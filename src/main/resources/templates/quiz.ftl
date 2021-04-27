<!DOCTYPE HTML>
<html>
<head>
 <meta name="viewport" content="width=device-width,initial-scale=1">
 <meta name="theme-color" content="#2299c5">

  <title>Java Quiz</title>

<script src="/js/script.js"></script>
<link rel="stylesheet" href="/js/bootstrap.min.css" >
<script src="/js/bootstrap.min.js"></script>
<script src="/js/popper.min.js"></script>

    <style>
    
.td-option{
padding-top: 0px;
    padding-right: 7px;
    padding-bottom: 7px;
    padding-left: 97px;
}

.question{
padding-left: 80px;
}

.whole-page{

    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 10px;

border:0;

padding:10px 0;

}


#submit{
    margin-left: 97px;
}
.input,span{
font-family:arial
}

#submit:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

input.options {
    height: 15px;
    width: 15px;
    cursor: pointer;
}
.test-marks{
line-height: 1.6;
}

#modal-fade{

    margin-right: auto;
    margin-left: auto;

}
.modal-title{
  margin-right: auto;
    margin-left: auto;
}
.btn{

    margin-right: auto;
    margin-left: auto;

}

.test-resutl{

    margin-right: auto;
    margin-left: auto;

}

.mar{

text-align: center;
}

@media (max-width: 992px) {
 
 .whole-page{
   
font-size: 15px;
width: auto;
  height: auto;
  display:block;
    }
}
@media (max-width: 992px) {
 
 .question{
 top: 0;
padding-left:10px;
  width: auto;
  height: auto;

   font-stretch: normal;
 }
}

@media screen and (max-width: 992px) {
 
 .td-option{
 top: 0;
 left: 0;
   padding-left: 25px;
  width: 100%;
  height: auto;
   font-stretch: normal;
 }
}

@media (max-width: 992px) {
 
 .test-marks{
   margin-left:20px;
padding:10px;
  width: auto;
  height: auto;
 
line-height: 1.6;

font-size: 20px;
   font-stretch: normal;
 }
}

@media (max-width: 992px) {
 #submit{
   margin-left: 15px;
 }
}

</style>
</head>

<body  id="gif" style="margin:0;">
 <form id="quizForm" method="post">
 
 <div class="modal fade" id="modal-fade" tabindex="-3" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">
        <div class="test-resutl">Test Result </div>
        </h5>
      </div>
      <div class="modal-body">
        
        <div class="test-marks">
        <div>
        <label><span id="marks-msg" style="color:green;"></span><label>
        <span id="answered" style="color:green; text-align: center;"></span>
        </div>
        </div>

          <div>
        <div>
        <span id="unanswered" style="color:green;"></span>
        </div>
        </div>
        
          <div>
        <div>
        <span id="result" style="color:green;"></span>
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
<div class="whole-page">
<table>
     
   <#assign cnt=0>
   <#assign opt1=0>
   
     <#list questions as question>
        <#assign cnt++>
         <tr>
   <td class="question">
   <span><p> ${cnt}. ${question.question} </p></span>
   </td>
    </tr>
  
    <tr> 
   <#list question.options as opt>
   
    <td class="td-option">
    <label><p>${opt.option}.)<input type="radio" class="options" id="qid${opt.qid.id}" name="option${opt.qid.id}" data-id="${opt.id}" value="${opt.qid.id}"> ${opt.opt}</p></label>
      <span class="option" id="optionId${opt.id}"></span>
      <span class="option" id="wrong_answer${opt.id}"></span>
      </td>
   </tr>
    </#list>
    </#list>
     <tr>
   <td><input type="submit" id="submit" class="btn btn-secondary" value="Submit"></td></t>
   </tr>
   </div>
  </table>
 </form>
 <script src="/js/quiz.js"></script>
</body>
</html>