<!DOCTYPE html>
<html>
<head>
    <title>Sweets list</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            background-color: #FFF0F5;
        }
    </style>
</head>
<body>

<h1>List of sweets </h1>

<div>
    <a href="/index">Back to Home page</a> |
    <a href="/sweets/add">Add Sweet</a>

</div>

<br/><br/>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Sweets types</th>
        <th>Cost</th>
        <th>Weight</th>
        <th>Manufacturer id</th>
        <th>With sugar</th>
        <th>Requires freezing</th>
        <th>Production date</th>
        <th>Expiration date</th>
        <th>Edit</th>
    </tr>

    <#list sweets as sweet>
        <tr>
            <td><a href="${'sweets/' + sweet.id}">${sweet.id}</a></td>
            <td>${sweet.name}</td>
            <td>${sweet.sweets_types_id}</td>
            <td>${sweet.cost}</td>
            <td>${sweet.weight}</td>
            <td>${sweet.manufacturer_id}</td>
            <td>${sweet.with_sugar?then('Y', 'N')}</td>
            <td>${sweet.requires_freezing?then('Y', 'N')}</td>
            <td>${sweet.production_date}</td>
            <td>${sweet.expiration_date}</td>
            <td><a href="${'sweets/' + sweet.id + '/edit'}">Edit</a></td>
        </tr>
    </#list>
</table>

</body>
</html>