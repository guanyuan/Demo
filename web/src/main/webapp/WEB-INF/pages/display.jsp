<html>
<body>

<form action="hello" method="post">
  <p>Adder1: <input type="text" name="adder1"/></p>
  <p>Adder2: <input type="text" name="adder2"/></p>
  <input type="submit" value="Submit" />
</form>


<%
String result = (String)request.getAttribute("addResult");
if(result != null)
    out.println(result);
%>


</body>
</html>