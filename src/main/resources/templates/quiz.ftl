<!DOCTYPE HTML>
<html>
<head>
  <title>Java Quiz </title>
</head>
<body>
 <form id="quizForm" method="post">
        <script src="/js/script.js"></script>
        <center>  <span id=res></span></center>
  <table>
   <tr>
   <#assign cnt=0>
     <#list questions as question>
        <#assign cnt++>
   <td><b> ${cnt}. ${question.question} </b></td>
    </tr>
    <tr>
   <#list question.options as opt>
    <td><input type="radio" name="opt${opt.qid.id}" data-id="${opt.qid.id}" value="${opt.opt}">${opt.opt}</td>
   </tr>
    </#list>
    </#list>
   <tr>
    <td><input type="submit" value="Submit"></td>
   </tr>
  </table>
  
 </form>
 <script src="/js/quiz.js"></script>
</body>
</html>