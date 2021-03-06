<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <title>Hello Spring MVC</title>

    <link th:href="@{/resources/css/bootstrap.min.css}" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <h2 th:text="'Hello ' + ${name} + '!'"></h2>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script th:src="@{/resources/js/bootstrap.min.js}"></script>
</body>
</html>

