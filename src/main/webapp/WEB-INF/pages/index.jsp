<html> 
<body>
<h2>Hello World!</h2>
<p><% 
		String attr = (String) request.getAttribute("test");
		out.println(attr);
		%></p>
		
		
</body>
</html>
