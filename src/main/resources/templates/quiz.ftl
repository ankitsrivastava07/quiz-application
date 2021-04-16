<!DOCTYPE HTML>
<html>
<head>
  <title>Java Quiz </title>
  <style>

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
 <form id="quizForm" method="post">
        <script src="/js/script.js"></script>
        <center>  <span id=res style="color:green;"></span></center>
 <table class='center'>
   <tr>
   <#assign cnt=0>
   <#assign str = "ABCDEF">
   <#assign asci=0>
     <#list questions as question>
        <#assign cnt++>
   <td><b><span id="question_id${question.id}"> ${cnt}. ${question.question}</span> </b><br/></td>
    </tr>
    <tr>
   <#list question.options as opt>
    <td><b>${str[asci]}.)</b><input type="radio" name="option${opt.qid.id}" data-id="${opt.qid.id}" value="${opt.opt}"> ${opt.opt}</td>
      <#assign asci++>
   </tr>
    </#list>
    <tr><td><input type="submit" value="Save"></td></tr>
     <#assign asci=0>
    </#list>
   <tr>
    <td><input type="submit" value="Submit"></td>
   </tr>
  </table>
 </form>
 <script src="/js/quiz.js"></script>
</body>
</html>