<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <style>
        #header {
            text-align:center;
            padding:5px;
            font-size:25px;
            color: #00CED1;
        }
        #nav {
            line-height:30px;
            height:300px;
            width:300px;
            float:left;
            padding:5px;
            color: #4682B4;
            font-size:18px;
        }
        #section {
            width: 900px;
            float:left;
            padding:10px;
            color: black;
            font-size:19px;
        }
        #footer {
            width: 100%;
            bottom: 0px;
            position: absolute;
            padding-top:10px;
            padding-bottom:0px;
            text-align:center;
            font-size:10px;
            font-weight:bold;
            color: black;
        }
        body {
            background-color: #F0FFF0;
        }

    </style>
</head>

<body>

<div id="header">
    <h2>Home page </h2>
</div>

<div id="nav">
    <p><strong>Menu:</strong></p>
    <ul>
        <li><a href="/storehouses">Show storehouses</a></li>
        <li><a href="/sweets">Show sweets</a></li>
        <li><a href="/profile">Profile</a></li>
    </ul>
</div>

<div id="section">
    <p><i>This application for work with sweets DB.</i></p>
    <p><i>This DB is from statement about preparing SQL interview. <a href="https://habr.com/ru/post/664550/">Statement link</a> </i></p>
    <p><i>Here you can see ER-diagram of DB:</i></p>
    <img src="https://habrastorage.org/r/w1560/getpro/habr/upload_files/2e6/53f/5e8/2e653f5e88476bfb030bc5608c23adee.jpg" alt="ER-diagram">
    <p><i>We have next main tables: sweets types, sweets, manufacturers, storehouses.</i></p>
</div>

<div id="footer">
    <p>Albina Safina, 2022</p>
    <p>https://github.com/Albina-sd</p>
</div>

</body>

</html>
