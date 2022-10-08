<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if add>Add storehouse<#else>Edit storehouse</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <style>
        body {
            background-color: #F5FFFA;
        }
    </style>
</head>
<body>
<h2><#if add>Create a new storehouse note:<#else>Edit a storehouse:</#if></h2>
<a href="/storehouses">Back to Storehouse List</a>
<br/><br/>
<#if add>
    <#assign urlAction>/storehouses/add</#assign>
    <#assign submitTitle>Create</#assign>
<#else>
    <#assign urlAction>${'/storehouses/' + storehouse.id + '/edit'}</#assign>
    <#assign submitTitle>Update</#assign>
</#if>
<form action="${urlAction}" name="note" method="POST">
    <table border="0">
        <#if storehouse.id??>
            <tr>
                <td>ID</td>
                <td>:</td>
                <td>${storehouse.id}</td>
            </tr>
        </#if>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td><input type="text" name="name" value="${(storehouse.name)!''}" /></td>
        </tr>
        <tr>
            <td>Address</td>
            <td>:</td>
            <td><textarea name="address" rows="4" cols="50">${(storehouse.address)!''} </textarea></td>
        </tr>
        <tr>
            <td>City</td>
            <td>:</td>
            <td><input type="text" name="city" value="${(storehouse.city)!''}" /></td>
        </tr>
        <tr>
            <td>Country</td>
            <td>:</td>
            <td><input type="text" name="country" value="${(storehouse.country)!''}" /></td>
        </tr>
    </table>
    <input type="submit" value="${submitTitle}" />
</form>

<br/>
<!-- Check if errorMessage is not null and not empty -->
<#if errorMessage?has_content>
    <div class="error">${errorMessage}</div>
</#if>
</body>
</html>