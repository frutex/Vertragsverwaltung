<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<h1>Registration Form</h1>
	<h2>eine Arbeit von Paysan, Obst und Köhler</h2>
	<form action="register" method="post">
		<table >
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" size="30" /></td>
			</tr>

			<tr>
				<td>Vorname :</td>
				<td><input type="text" name="vorname" size="30" /></td>
			</tr>
			<tr>
				<td>Telefonnummer :</td>
				<td><input type="text" name="telnr" size="30" /></td>
			</tr>
			<tr>
				<td>Adresse :</td>
				<td><input type="text" name="adresse" size="30" /></td>
			</tr>
		</table>
		<p />
		<input type="submit" value="Register" />
	</form>
</body>
</html>