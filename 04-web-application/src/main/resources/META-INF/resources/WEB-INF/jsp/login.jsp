<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<%--    <h1>Login ${name}</h1>--%>
    <pre>${errorMessage}</pre>
    <form method="post">
        <fieldset>
            <legend>Login</legend>
            <label for="username">Name</label>
            <input type="text" id="username" name="username">
            <label for="password">Password</label>
            <input type="password" id="password" name="password">
            <button type="submit">Login</button>
        </fieldset>
    </form>
</body>
</html>