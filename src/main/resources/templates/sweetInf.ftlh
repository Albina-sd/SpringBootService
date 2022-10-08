<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Sweet Card</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <style>
        body {
            background-color: #FFF0F5;
        }
    </style>
</head>
<body>
<h1>View Sweet</h1>
<a href="/sweets">Back to Sweets List</a>
<br/><br/>
<#if sweet??>
    <table border="0">
        <tr>
            <td>ID</td>
            <td>:</td>
            <td>${sweet.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td>${sweet.name}</td>
        </tr>
        <tr>
            <td>Sweet type</td>
            <td>:</td>
            <td>${sweet.sweets_types_id}</td>
        </tr>
        <tr>
            <td>Cost</td>
            <td>:</td>
            <td>${sweet.cost}</td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>:</td>
            <td>${sweet.weight}</td>
        </tr>
        <tr>
            <td>Manufacturer id</td>
            <td>:</td>
            <td>${sweet.manufacturer_id}</td>
        </tr>
        <tr>
            <td>With sugar</td>
            <td>:</td>
            <td>${sweet.with_sugar?then('Y', 'N')}</td>
        </tr>
        <tr>
            <td>Require freezing</td>
            <td>:</td>
            <td>${sweet.requires_freezing?then('Y', 'N')}</td>
        </tr>
        <tr>
            <td>Production date</td>
            <td>:</td>
            <td>${sweet.production_date}</td>
        </tr>
        <tr>
            <td>Expiration date</td>
            <td>:</td>
            <td>${sweet.expiration_date}</td>
        </tr>
    </table>
    <br/><br/>
    <#if allowDelete>
        <form action="${'/sweets/' + sweet.id + '/delete'}" method="POST">
            Delete this note? <input type="submit" value="Yes" />
        </form>
    <#else>
        <div>
            <a href="${'/sweets/' + sweet.id + '/edit'}">Edit</a> |
            <a href="${'/sweets/' + sweet.id + '/delete'}">Delete</a>
        </div>
    </#if>
</#if>
<#if errorMessage?has_content>
    <div class="error">${errorMessage}</div>
</#if>
</body>
</html>