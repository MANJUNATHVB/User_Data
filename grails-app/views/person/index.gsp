<html>
	<head>
		<style>
		body
		{
		background-color: brown;
		}
	ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
.active {
    background-color: #4CAF50;
}
.active {
    background-color: red;
}
	</style>
		<title>Persons</title>
	</head>

	<body>
	<ul>
       <li><g:link controller="person" action="form" class="active">Create</g:link></li>
       <li><g:link controller="person" action="updatePerson">Update</g:link></li>
       <li><g:link controller="person" action="deletePerson" class="active">Delete</g:link></li>
    </ul>
       
	</body>
</html>