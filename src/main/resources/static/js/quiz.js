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
			}),
				$(".answer").html(""),

				$(document).ready(function() {
					$.each(e.correctOptionIds, function(key, value) {
						$("#correctOpt" + key).html(value);
					});
				}),

				$(document).ready(function() {

					$(e.questionIds).each(function(e, t) {

						var img_icon = $("#questionId"+t).val();

						if (img_icon == undefined) {
							$("#notAns" + t).html("Option(Not Answered)");
						}
						else if (img_icon == "") {
							$("#notAns" + t).html("");
						}

					});
				})

			$("#modal-fade").modal("show")
			window.scrollTo(0, 0);
		},
		error: function(e) {
			alert("Something went wrong please try again later");
		},
	});
}

function removeLoader() {
	Spinner.hide();
}

function showGIF() {
}

function showPage() {

	document.getElementById("loader").style.display = "none";
}
$("#quizForm").submit(function() {
	var e = [];
	return (
		$("input[type=radio]:checked").each(function(t) {
			(selectedOptions = { optionId: $(this).attr("data-id"), questionId: $(this).val() }), e.push(selectedOptions);
		}),
		submit(e),
		!1
	);
}),
	$(document).ready(function() {
		$("#add-question").validate({
			ignoreTitle: !0,
			rules: { question: { required: !0, minlength: 7 }, opt1: { required: !0 }, opt2: { required: !0 }, opt3: { required: !0 }, opt4: { required: !0 }, answer: { required: !0 } },
			messages: {
				question: { required: "Please Enter question here" },
				opt1: { required: "Please Enter Option1" },
				opt2: { required: "Please Enter Option2" },
				opt3: { required: "Please Enter Option 3", minlength: "Option at least 15 characters long" },
				opt4: { required: "Please Enter Option 4" },
				answer: { required: "Please select answer" },
			},
			submitHandler: function(e) {
				var t = [];
				$("#add-question input[type=text]").each(function() {
					t.push(this.value);
				});
				var n = $("#answer").val(),
					o = { question: $("#question").val(), option1: $("#opt1").val(), option2: $("#opt2").val(), option3: $("#opt3").val(), option4: $("#opt4").val(), correctOption: n };
				let i = new Map();
				return i.has(o.option1)
					? (alert("Duplicate Option 1: containing value " + o.option1), !1)
					: (i.set(o.option1, 1),
						i.has(o.option2)
							? (alert("Duplicate Option 2: containing value " + o.option2), !1)
							: (i.set(o.option2, 1),
								i.has(o.option3)
									? (alert("Duplicate Option 3: containing value " + o.option3), !1)
									: (i.set(o.option3, 1),
										i.has(o.option4)
											? (alert("Duplicate Option 4: containing value " + o.option4), !1)
											: (i.set(o.option4, 1),
												$.ajax({
													type: "POST",
													url: "/add-question",
													contentType: "application/json",
													data: JSON.stringify(o),
													success: function(e) {
														alert("Successfully added");
													},
													error: function(e) {
														alert("Something went wrong  please try again later");
													},
												}),
												void $("#add-question")[0].reset()))));
			},
		});
	});
