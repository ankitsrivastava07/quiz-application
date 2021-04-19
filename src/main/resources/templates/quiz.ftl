<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Java Quiz</title>
<script src="/js/script.js"></script>
<script src="/js/jquery.validate.js"></script>

<link rel="stylesheet" href="/js/bootstrap.min.css" >
<script src="/js/bootstrap.min.js"></script>
<script src="/js/popper.min.js"></script>
  <style>

#submit{

    margin-right: auto;
    margin-left: auto;
}

#submit:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

input.options {
    height: 15px;
    width: 15px;
    cursor: pointer;
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


table.center {
  margin-left: auto; 
  margin-right: auto;
}

 .loader,
        .loader:after {
            border-radius: 50%;
            width: 10em;
            height: 10em;
        }
        .loader {            
            margin: 60px auto;
            font-size: 10px;
            position: relative;
            text-indent: -9999em;
            border-top: 1.1em solid rgba(255, 255, 255, 0.2);
            border-right: 1.1em solid rgba(255, 255, 255, 0.2);
            border-bottom: 1.1em solid rgba(255, 255, 255, 0.2);
            border-left: 1.1em solid #ffffff;
            -webkit-transform: translateZ(0);
            -ms-transform: translateZ(0);
            transform: translateZ(0);
            -webkit-animation: load8 1.1s infinite linear;
            animation: load8 1.1s infinite linear;
        }
        @-webkit-keyframes load8 {
            0% {
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
        @keyframes load8 {
            0% {
                -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg);
            }
        }
        #loadingDiv {
            position:absolute;;
            top:0;
            left:0;
            width:100%;
            height:100%;
            background-color:#C0C0C0;
            
            
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: 9999999;
            
        }
        
</style>
</head>

<body  id="gif" style="margin:0;">
 <form id="quizForm" method="post">
 
  <table class='center' cellpadding="0" cellspacing="0" border="0" width="100%">

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
        <span id="marks" style="color:green; text-align: center;"></span>
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
 
<div id="loader">

</div>

   <center>  <span id=res style="color:green;"></span></center>

      <tr>
   <#assign cnt=0>
   <#assign opt1=0>
   <#assign str = "ABCDEF">
   <#assign asci=0>
   
     <#list questions as question>
        <#assign cnt++>
   <td><b><span> ${cnt}. ${question.question}</span> </b><br/></td>
    </tr>
  
   <#list question.options as opt>
    <table border="0" cellpadding="0" cellspacing="0">
      <tbody><tr> 
   
    <td><b>${str[asci]}.)</b><label><input type="radio" class="options" name="option${opt.qid.id}" data-id="${opt.id}" value="checkbox${opt.id}" > ${opt.opt}</label></td>
      <#assign asci++>
   </tr>
   </tbody></table>
    </#list>
     <#assign asci=0>
    </#list>
     <input type="hidden" id="page" value=${cnt} />   
     <tr>
   <td><input type="submit" id="submit" class="btn btn-secondary" value="Submit"></td></t>
   </tr>
  </table>
 </form>
 <script src="/js/quiz.js"></script>
</body>
</html>