$("#quizForm").submit(function() {

	var list = []

	$("input[type=radio]:checked").each(function(index) {
		index = index + 1

		selectedOptions = {

			"optionId": $(this).attr('data-id'),
		}
		list.push(selectedOptions);

	});

	submit(list)
	$("#quizForm")[0].reset();
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
				$('#marks-msg').html("Number of correct answers ");
				$('#marks').html(item.marks);

				$('#answered').html("Given answers " + item.answered);
				$('#unAnswered').html(item.unAnswered);
				$('#result').html(item.result);

				$("#modal").modal("show");

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

			var correctOption = $("#answer").val()

			var formData = {

				"question": $("#question").val(),

				"option1": $("#opt1").val(),
				"option2": $("#opt2").val(),
				"option3": $("#opt3").val(),
				"option4": $("#opt4").val(),

				"correctOption": correctOption
			}

			let map = new Map()

			if (map.has(formData.option1)) {
				alert("Duplicate Option 1: containing value " + formData.option1)
				return false;
			}

			map.set(formData.option1, 1);

			if (map.has(formData.option2)) {
				alert("Duplicate Option 2: containing value " + formData.option2)
				return false;
			}

			map.set(formData.option2, 1);

			if (map.has(formData.option3)) {
				alert("Duplicate Option 3: containing value " + formData.option3)
				return false;
			}

			map.set(formData.option3, 1);

			if (map.has(formData.option4)) {
				alert("Duplicate Option 4: containing value " + formData.option4)
				return false;
			}

			map.set(formData.option4, 1);

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

function getNextPage(offset) {

	formdata = {
		"offSet": offset,
		"limit": 3
	}

	$.ajax({
		type: "GET",
		url: "/quiz",
		contentType: "application/json",
		data: formdata,

		success: function(response) {
			alert("Successfully added")
		},
		error: function(error) {
			alert("Something went wrong  please try again later")
		}
	})

}

