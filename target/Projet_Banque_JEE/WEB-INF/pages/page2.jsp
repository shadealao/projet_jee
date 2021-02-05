<html> 
<body>
<h2>Page 2!</h2>
<p><% 
		String attr = (String) request.getAttribute("test");
		out.println(attr);
		%></p>
		
		<p>Salut ${individu.nom }
		</p>
</body>
</html>
