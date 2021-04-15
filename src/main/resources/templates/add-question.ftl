<!DOCTYPE HTML>
<html>
<head>
  <title>Add Question</title>
</head>
<style>
input[type=text], select {
  width: 100%;
  padding: 8px 20px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>
<body>
<form id="add-question" method="post">
<script src="/js/script.js"></script>
<script src="/js/quiz.js"></script>
<h2><center>Add Question</center></h2>
 
  <table>
   <tr>
<td>Questions</td>
<td><textarea name="Address" rows="5"  id ="question" cols="38"></textarea></td>
</tr>
<tr>
<td>
Options 1:
</td>
<td>
<input type="text" id="opt1">
</td>
<td>
Options 2:
</td>
<td>
<input type="text" id="opt2">
</td>
<td>
Options 3:
</td>
<td>
<input type="text" id="opt3">
</td>
<td>
Options 4:
</td>
<td>
<input type="text" id="opt4">
</td>
</tr>

<td>
Answer :
</td>
<td>
<select name="answers" id="answer">
    <option value="opt1">Options 1</option>
    <option value="opt2">Options 2</option>
    <option value="opt3">Options 3</option>
    <option value="opt4">Options 4</option></td>
</select>
<tr>
<td>
<input type="submit" value="Submit">
</td>
</tr>
 </table>
 </form>
</body>
</html>