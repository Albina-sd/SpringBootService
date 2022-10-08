<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if add>Add sweet<#else>Edit sweet</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <style>
        body {
            background-color: #FFF0F5;
        }
    </style>
</head>
<body>
<h1><#if add>Create a new sweet's note:<#else>Edit a sweet:</#if></h1>
<a href="/sweets">Back to Sweets List</a>
<br/><br/>
<#if add>
<#assign urlAction>/sweets/add</#assign>
<#assign submitTitle>Create</#assign>
<#else>
<#assign urlAction>${'/sweets/' + sweet.id + '/edit'}</#assign>
<#assign submitTitle>Update</#assign>
</#if>
<form action="${urlAction}" name="note" method="POST">
    <table border="0">
        <#if sweet.id??>
        <tr>
            <td>ID</td>
            <td>:</td>
            <td>${sweet.id}</td>
        </tr>
    </#if>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td><input type="text" name="name" value="${(sweet.name)!''}" /></td>
        </tr>
        <tr>
            <td>Sweet types</td>
            <td>:</td>
            <td><input type="text" name="sweets_types_id" value="${(sweet.sweets_types_id)!''}" /></td>
        </tr>
        <tr>
            <td>Cost</td>
            <td>:</td>
            <td><input type="text" name="cost" value="${(sweet.cost)!''}" /></td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>:</td>
            <td><input type="text" name="weight" value="${(sweet.weight)!''}" /></td>
        </tr>
        <tr>
            <td>Manufacturer id</td>
            <td>:</td>
            <td><input type="text" name="manufacturer_id" value="${(sweet.manufacturer_id)!''}" /></td>
        </tr>
        <tr>
            <td>Requires freezing</td>
            <td>:</td>
            <td>
                <input type="hidden" id="${(sweet.requires_freezing)!''}" name="requires_freezing" value="true" />
                <input type="radio" id="${(sweet.requires_freezing)!''}" name="requires_freezing" value="true" />Yes
                <input type="radio" id="${(sweet.requires_freezing)!''}" name="requires_freezing" value="false" />No
            </td>
        </tr>
        <tr>
            <td>With sugar</td>
            <td>:</td>
            <td>
                <input type="hidden" id="${(sweet.with_sugar)!''}" name="with_sugar" value="true" />
                <input type="radio" id="${(sweet.with_sugar)!''}" name="with_sugar" value="true" />Yes
                <input type="radio" id="${(sweet.with_sugar)!''}" name="with_sugar" value="false" />No
            </td>
        </tr>
        <tr>
            <td>Production date</td>
            <td>:</td>
            <td><input type="date" name="production_date" value="${(sweet.production_date)!''}" /></td>
        </tr>
        <tr>
            <td>Expiration date</td>
            <td>:</td>
            <td><input type="date" name="expiration_date" value="${(sweet.expiration_date)!''}" /></td>
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