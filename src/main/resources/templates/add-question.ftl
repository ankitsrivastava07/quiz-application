<!DOCTYPE HTML>
<html>
<head>
  <title>Add Question</title>
  <script src="/js/script.js"></script>
  <script src="/js/jquery.validate.js"></script>

</head>
<style>
  #question {
  width:100%;
  padding: 20px 15px;
  margin: 5px 0;
  display: inline-block;
  border-radius: 4px;
  box-sizing: border-box;
  font-size: 15px;
}
  input[type=text],select {
  width:200px;
  padding: 8px 20px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
.error{
color:red;
font-size: 14px;
}

</style>
<body>
<form id="add-question" method="post">
<script src="/js/quiz.js"></script>
<h2><center>Add Question</center></h2>
  <table align="center">
   <tr>
<td>Question</td>
<td><textarea name="question" id ="question" autocomplete=off rows="5" cols="33" title="Question"></textarea></td>
</tr>
<tr>
<td>
Option 1:
</td>
<td>
<input type="text" id="opt1" name="opt1" autocomplete=off title="Option1">
</td>
</tr>
<tr>
<td>
Option 2:
</td>
<td>
<input type="text" id="opt2" name="opt2" autocomplete=off title="Option2">
</td>
</tr>
<tr>
<td>
Option 3:
</td>
<td>
<input type="text" id="opt3" name="opt3" autocomplete=off title="Option3">
</td>
</tr>
<tr>
<td>
Option 4:
</td>
<td>
<input type="text" id="opt4" name="opt4" autocomplete=off title="Option4">
</td>
</tr>
</tr>
<tr>
<td>
Answer :
</td>
<td>
<select name="answer" id="answer" title="Answer">
    <option value="">Select Answer</option>
    <option value="opt1">Options 1</option>
    <option value="opt2">Options 2</option>
    <option value="opt3">Options 3</option>
    <option value="opt4">Options 4</option></td>
</select>
</tr>
<tr>
<td></td>
<td>
<input type="submit" value="Submit" style="width:58%; height:35px">
</td>
</tr>
 </table>
 </form>
</body>
</html>