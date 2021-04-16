$("#quizForm").submit(function() {

	var list = []

	$("input[type=radio]:checked").each(function(index) {
		index = index + 1

		selectedOptions = {

			"questionId": $(this).attr('data-id'),
			"answer": $(this).val()
		}
		list.push(selectedOptions);

	});

	submit(list)
	return false
});

function submit(list) {

	$.ajax({
		type: "POST",
		url: "/quiz/submit",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(list),

		success: function(response) {

			$(response).each(function(index, item) {

				var text = $("#res").html();

				if (text != "")
					$("#res").html("")

				$('#res').append(
					'<b></td><td>&nbsp<br><b>' + item.marks +
					'<b><tr><td>&nbsp<br><b>' + item.answered + ' <br> ' + item.unAnswered + '   ' +
					'</td><td><br>' + item.result +
					'</td></tr>'
				)

			});

			window.scrollTo(0, 0);

		},

		error: function(res) {
			alert(res)
		}

	});
}

$(document).ready(function() {

	$("#add-question").validate({
		ignoreTitle: true,

		rules: {
			question: {
				required: true,
				minlength: 7
			},
			opt1: {
				required: true,
			},

			opt2: {
				required: true,
			},

			opt3: {
				required: true,
			},

			opt4: {
				required: true,
			},

			answer: {
				required: true
			}

		},
		messages: {

			question: {
				required: "Please Enter question here",
			},

			opt1: {
				required: "Please Enter Option1",
			},

			opt2: {
				required: "Please Enter Option2",
			},

			opt3: {
				required: "Please Enter Option 3",
				minlength: "Option at least 15 characters long"
			},

			opt4: {
				required: "Please Enter Option 4",
			},

			answer: {
				required: "Please select answer"
			}
		},

		submitHandler: function(form) {

			var options = []

			$("#add-question input[type=text]").each(function() {

				options.push(this.value);
			});

			var optId = $("#answer").val()

			var formData = {

				"question": $("#question").val(),
				"opt1": $("#opt1").val(),
				"opt2": $("#opt2").val(),
				"opt3": $("#opt3").val(),
				"opt4": $("#opt4").val(),
				"answer": document.getElementById(optId).value
			}

			$.ajax({
				type: "POST",
				url: "/quiz/add-question",
				contentType: "application/json",
				data: JSON.stringify(formData),

				success: function(response) {
					alert("Successfully added")
				},
				error: function(error) {
					alert("Something went wrong  please try again later")
				}
			})
			$("#add-question")[0].reset();
		}

	});
});
