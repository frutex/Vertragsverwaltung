<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Form</title>
</head>
<body>
	<h1>Search Form</h1>
	<h2>eine Arbeit von Paysan, Obst und Köhler</h2>
	<form action="Search" method="get">
		<table cellpadding="3pt">
			<tr>
				<td>Mitarbeiter-ID :</td>
				<td><input type="text" name="ID" size="30" /></td>
			</tr>

			<tr>
				<td>Mitarbeiter-Name :</td>
				<td><input type="text" name="name" size="30" /></td>
			</tr>
		</table>
		<p />
		<input type="submit" value="Search" />
	</form>
</body>
</html>