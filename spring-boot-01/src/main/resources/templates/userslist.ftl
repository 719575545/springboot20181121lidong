<html>
	
	<head>
		<title>用户列表</title>
		<meta charset="utf-8" />
	</head>
	<body>
		<table border="1" align="center" width="50%">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
			</tr>
			<tr>
				<#list list as user>
					<tr>
						 <td>${user.userid}</td>
						 <td>${user.username}</td>
						 <td>${user.userage}</td>
					</tr>
				</#list>
			</tr>
		</table>
	</body>
</html>