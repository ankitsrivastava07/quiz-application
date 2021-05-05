function submit(e) {
	$.ajax({
		type: "POST",
		url: "/quiz/submit",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(e),
		success: function(e) {
			$(e).each(function(e, t) {
				$("#res").html(), $("#answered").html("Number of correct answers " + t.answered), $("#marks").html(t.marks), $("#unanswered").html("Un answered of given questions " + t.unAnswered), $("#result").html(t.result);
			});
			$(".answer").html(""),
				$(document).ready(function() {
					$.each(e.correctOptionIds, function(e, t) {
						$("#correctOpt" + e).html(t);
					});
				});

			$(document).ready(function() {
				$(e.questionIds).each(function(e, t) {
					var n = $("#questionId" + t).val();
					null == n ? $("#notAns" + t).html("Option(Not Answered)") : "" == n && $("#notAns" + t).html("");
				});
			});
		},
		complete: function(data) {
			$("#staticBackdrop").modal("hide");
			$("#modal-fade").modal("show");
		},
		error: function(e) {
			alert("Something went wrong please try again later");
		},
	});
}

$("#quizForm").submit(function() {
	var e = [];
	$("input[type=radio]:checked").each(function(t) {
		(selectedOptions = {
			optionId: $(this).attr("data-id"),
			questionId: $(this).val()
		}), e.push(selectedOptions);
	});

	var totalOptions = $(".question").length;
	var selectedOptions = 0;

	$("input[type=radio]:checked").each(function(t) {
		selectedOptions = selectedOptions + 1;
	});

	var option = parseInt(totalOptions - selectedOptions);

	if (option > 0) {
		$("#alert-msg1").html("Total number of unanswered questions = " + (totalOptions - selectedOptions) + "</br></br>");
	}
	
	$("#alert-msg2").html("Are you sure you want to submit the Test now?");
	$("#staticBackdrop").modal("show");

	$("#close").click(function() {
		$("#staticBackdrop").modal("hide");
		return false;
	});

	$("#OK").click(function() {
		$("#staticBackdrop").modal("hide");
		submit(e);
	});
	return false;
});