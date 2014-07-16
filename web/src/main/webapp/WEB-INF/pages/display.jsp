<html>
<body>

<form action="add" method="post">
  <p>Adder1: <input type="text" name="adder1"/></p>
  <p>Adder2: <input type="text" name="adder2"/></p>
  <input type="submit" value="Submit" />
</form>


<%
String result = (String)request.getAttribute("addResult");
if(result != null){%>
<h2>The result is:
    <%out.println(result);}%>
<h2>


</body>
</html>