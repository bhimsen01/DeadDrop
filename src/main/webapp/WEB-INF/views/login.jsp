<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DeadDrop - Log In</title>
    <link rel="icon" href="assets/images/Crop1_DeadDrop2.jpg" type="image/jpg">

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/signup.css?v=1.1">
</head>
<body>
<form method="post" action="login">
    <div class="form-avatar">
        <img class="avatar-img" src="assets/images/Crop1_DeadDrop2.jpg">
    </div>
    <p class="form-heading">Log in with DeadDrop Account</p>

    <hr class="form-hr">

    <div class="input-container">
        <div class="usernamepassword">
            <label class="label">Username</label>
            <input type="text" name="username" required>

            <label class="label">Password</label>
            <input type="password" name="password" required>
        </div>

        <hr class="form-hr">

        <div class="checkbox-option">
            <label><input type="checkbox" name="remember">&nbsp;&nbsp;Keep me logged in</label>
        </div>
        <br>

        <c:if test="${not empty error}">
            <p style="color: var(--red); text-align: center; margin-bottom: 12px; font-weight: bold;">
                    ${error}
            </p>
        </c:if>

        <div class="form-action-btn">
            <button type="button" class="form-secondary-btn" onclick="window.location.href='index'">Cancel</button>
            <button type="submit" class="form-primary-btn">Log in</button>
        </div>

        <hr class="form-hr">

        <div class="form-tertiary-options">
            <button class="form-tertiary-btn">Forgot password?</button>
            <button class="form-tertiary-btn" type="button" onclick="window.location.href='signup'">Create DeadDrop Account ↗</button>

        </div>
    </div>
</form>
</body>
</html>