<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Storehouse Card</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <style>
        body {
            background-color: #F5FFFA;
        }
    </style>
</head>
<body>
<h2>View Storehouse</h2>
<a href="/storehouses">Back to Storehouses List</a>
<br/><br/>
<#if storehouse??>
    <table border="0">
        <tr>
            <td>ID</td>
            <td>:</td>
            <td>${storehouse.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td>${storehouse.name}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>:</td>
            <td>${storehouse.address}</td>
        </tr>
        <tr>
            <td>City</td>
            <td>:</td>
            <td>${storehouse.city}</td>
        </tr>
        <tr>
            <td>Country</td>
            <td>:</td>
            <td>${storehouse.country}</td>
        </tr>
    </table>
    <br/><br/>
    <#if allowDelete>
        <form action="${'/storehouses/' + storehouse.id + '/delete'}" method="POST">
            Delete this note? <input type="submit" value="Yes" />
        </form>
    <#else>
        <div>
            <a href="${'/storehouses/' + storehouse.id + '/edit'}">Edit</a> |
            <a href="${'/storehouses/' + storehouse.id + '/delete'}">Delete</a>
        </div>
    </#if>
</#if>
<#if errorMessage?has_content>
    <div class="error">${errorMessage}</div>
</#if>
</body>
</html>