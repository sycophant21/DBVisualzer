<html>
<head>
    <title>
        Hello World
    </title>
</head>
<style>
    .center {
        padding: 20%;
        text-align: center;
    }
</style>
<body>
<div class="center" >
    <form action="${pageContext.request.contextPath}/signup" method="put">
        <label for="emailId">Email:</label><br>
        <input type="email" id="emailId" name="emailId" value=""><br>
        <label for="pass">Password:</label><br>
        <input type="password" id="pass" name="pass" value=""><br><br>
        <input type="submit" value="Create Account">
    </form>
</div>
</body>
</html>