$("#quizForm").submit(function() {

	var list = []

	$("input[type=radio]:checked").each(function(index) {
		index = index + 1

		selectedOptions = {

			"questionId": $(this).attr('data-id'),
			"selectedOption": $(this).val()

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