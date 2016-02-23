<html>
<head>
<title></title>
<style>
body{
background-color:lightgreen;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
}
table#t01 {
    width: 100%;    
    background-color: #f1f1c1;
    }
    tr {
    background-color: #f2f2c2;
    }
    th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>


      <table align="center">
      <thead>
      <tr>
      <th>Id</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
      <th>Email</th>
      </tr>
      </thead>
      <g:findAll in="${person}" expr="true" >
     <tbody>
      <tr>
      <td>${it.id}</td>
      <td>${it.lastName}</td>
      <td>${it.firstName}</td>
      <td>${it.age}</td>
      <td>${it.email}</td>
      </tr>
      </tbody>
         
      </g:findAll>
      </table>
       
</body>
</html>

