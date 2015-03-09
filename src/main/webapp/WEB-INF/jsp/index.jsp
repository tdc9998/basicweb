<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!</h2>

<p>
<%
	Map<String, String> environment = (Map<String,String>)pageContext.findAttribute("environment");
	for(String key : environment.keySet()) {
		String val = environment.get(key);
		out.print("Key: " + key + " val: " + val + "<br/>");
	}
	out.print("</p><p>Values from the db:<br/>");
	List<String> values = (List<String>)pageContext.findAttribute("values");
	if (values != null) {
		for(String curVal : values) {
			out.print(curVal + "<br/>");
		}
	} else {
		out.print("BAD!");
	}
%>
</p>

</body>
</html>
