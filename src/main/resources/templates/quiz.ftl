<!DOCTYPE HTML>
<html>
<head>
<script src="/js/script.js"></script>
<script src="/js/jquery.validate.js"></script>

<link rel="stylesheet" href="/js/bootstrap.min.css" >
<script src="/js/bootstrap.min.js"></script>

<script src="/js/popper.min.js"></script>
  <style>

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
 <form id="quizForm" method="post">
 
 <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">
        <div class="center">Test Result </div>
        </h5>
      </div>
      <div class="modal-body">
        
        <div class="test-marks">
        <div>
        <label><span id="marks-msg" style="color:green;"></span><label>
        <label><span id="marks" style="color:green;"></span><label>
        </div>
        </div>

         <div>
        <div>
        <span id=answered style="color:green;"></span>
        </div>
        </div>
        
          <div>
        <div>
        <span id=unanswered style="color:green;"></span>
        </div>
        </div>
        
          <div>
        <div>
        <span id=result style="color:green;"></span>
        </div>
        </div>
                                        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
 
        <center>  <span id=res style="color:green;"></span></center>
 <table class='center'>

      <tr>
   <#assign cnt=0>
   <#assign opt1=0>
   <#assign str = "ABCDEF">
   <#assign asci=0>
   
     <#list questions as question>
        <#assign cnt++>
   <td><b><span id="question_id${question.id}"> ${cnt}. ${question.question}</span> </b><br/></td>
    </tr>
    <tr>
   <#list question.options as opt>
    <td><b>${str[asci]}.)</b><input type="radio" name="option${opt.qid.id}" data-id="${opt.id}" value="${opt.opt}"> ${opt.opt}</td>
      <#assign asci++>
   </tr>
    </#list>
     <#assign asci=0>
    </#list>
     <input type="hidden" id="page" value=${cnt} />   
     <tr>
   <td><input type="submit" class="btn btn-secondary" value="Submit"></td></t>
   </tr>
  </table>
 </form>
 <script src="/js/quiz.js"></script>
</body>
</html>