function submit(e) {
	$(document).ready(function() {
		$.ajax({
			type: "POST",
			url: "/quiz/submit",
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify(e),
			success: function(e) {
				$(e).each(function(e, t) {
					$("#res").html(), $("#answered").html("Number of correct answers " + t.answered),
						$("#marks").html(t.marks), $("#unanswered").html("Un answered of given questions " + t.unAnswered),
						$("#result").html(t.result);
				});

				$(".answer").html("");
				$(document).ready(function() {
					$.each(e.correctOptionIds, function(e, t) {
						var qId = $("#qid" + t).val();
						$("#correctOpt" + t).html("&nbsp;&nbsp;<img src='/images/correct.png' id='correctId'" + qId + ">");
					});
				});

				$(document).ready(function() {
					$.each(e.worngOptionIds, function(e, t) {
						var qId = $("#qid" + t).val();
						$("#correctOpt" + t).html("&nbsp;&nbsp;<img src='/images/incorrect.png' id='incorrectId'" + qId + ">");
					});
				});

				$(document).ready(function() {
					$(".attempt").html("");
					$(".correct_icon").html("");

					var img = $("img").find();

					$(e.questionIds).each(function(e, t) {

						var correct_icon = $("#correctId" + t).val();
						var incorrectId = $("#incorrectId" + t).val();

						//	null == n ? $("#notAns" + t).html("Option(Not Answered)") : "" == n && $("#notAns" + t).html("");

						//td-option

						if (correct_icon == undefined && incorrectId == undefined)
							$("#notAns" + t).html("Option(Not Answered)");

						else
							$("#notAns" + questionId).html("");

					});

					/*$("input[type=radio]").each(function() {
						questionId = $(this).val()

						if (this.checked) {
							$("#notAns" + questionId).html("");
						}
						else
							$("#notAns" + questionId).html("Option(Not Answered)");
					});*/


				});
			},
			complete: function(data) {

				$("#alert").modal("hide");
				$("#modal-fade").modal("show");

				$("html, body").animate({
					scrollTop: 12e3
				}, "8000");
			},
			error: function(e) {
				alert("Something went wrong please try again later");
			}
		});
	});
}

var selectedOptions = [];
$("input[type=radio]:checked").each(function(t) {
	selectedOptions = {
		optionId: $(this).attr("data-id"),
		questionId: $(this).val()
	}, e.push(selectedOptions);
});

$("#quizForm").submit(function() {
	var e = [];
	$("input[type=radio]:checked").each(function(t) {
		selectedOptions = {
			optionId: $(this).attr("data-id"),
			questionId: $(this).val()
		}, e.push(selectedOptions);
	});
	selectedOptions = e;
	closeAlert();
	return false;
});

function closeAlert() {

	var totalOptions = $(".question").length;
	var selectedOptions = 0;

	$("input[type=radio]:checked").each(function(t) {
		selectedOptions = selectedOptions + 1;
	});

	$("#alert-msg1").html("");
	$("#alert-msg2").html("");

	var option = parseInt(totalOptions - selectedOptions);

	if (option > 0) {
		$("#alert-msg1").html("Total number of unanswered questions = " + (totalOptions - selectedOptions) + "</br></br>");
	}
	$("#alert-msg2").html("Are you sure you want to submit the Test now?");

	$("#alert").modal("show");
	return false;
}

function submitTest() {
	submit(selectedOptions);
	return false;
}


