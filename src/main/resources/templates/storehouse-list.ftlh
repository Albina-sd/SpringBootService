<!DOCTYPE html>
<html>
<head>
    <title>Storehouses list</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            background-color: #F5FFFA;
        }
    </style>
</head>
<body>
<h2>List of storehouses </h2>

<div>
    <a href="/index">Back to Home page</a> |
    <a href="/storehouses/add">Add Storehouse</a>

</div>

<br/><br/>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>city</th>
        <th>country</th>
        <th>edit</th>
    </tr>

    <#list storehouses as storehouse>
        <tr>
            <td><a href="${'storehouses/' + storehouse.id}">${storehouse.id}</a></td>
            <td>${storehouse.name}</td>
            <td>${storehouse.address}</td>
            <td>${storehouse.city}</td>
            <td>${storehouse.country}</td>
            <td><a href="${'storehouses/' + storehouse.id + '/edit'}">Edit</a></td>
        </tr>
    </#list>
</table>

</body>
</html>