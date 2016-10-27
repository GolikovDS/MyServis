<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>


<html>

<head>

    <link rel="stylesheet" href="resources/css/loginStyle.css" type="text/css">

    <title>АИСТ</title>

</head>

<body>

<div class="login_array">
    <form method="post" action="login.do">
        <table>
            <tr>
                <td>
                    <label>Логин</label>
                </td>
                <td>
                    <input type="text" name="loginInput" tabindex="1" placeholder="Логин" required>
                </td>
            </tr>

            <tr>
                <td>
                    <label>Пароль</label>
                </td>
                <td>
                    <input type="password" name="passwordInput" placeholder="Пароль" tabindex="2" required>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="saveMi" class="checkBoxInput" id="cb">
                </td>
                <td>
                    <label for="cb">Запомнить</label>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="submit" name="btnEnter" class="btn btn-primary btn-block btn-large" value="Login" tabindex="3">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
