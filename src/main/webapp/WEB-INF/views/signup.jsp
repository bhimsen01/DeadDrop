<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DeadDrop - Sign Up</title>
    <link rel="icon" href="assets/images/Crop1_DeadDrop2.jpg" type="image/jpg">

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/signup.css?v=1.1">
</head>
<body>
<form action="signup" method="post">
    <div class="form-avatar">
        <img class="avatar-img" src="assets/images/Crop1_DeadDrop2.jpg">
    </div>
    <p class="form-heading">Create Your DeadDrop Account</p>

    <p class="form-sub-heading">Already have an account?
        <button type="button" class="form-tertiary-btn" onclick="window.location.href='login'">Log in ↗</button>
    </p>

    <hr class="form-hr">

    <div class="input-container">
        <div class="input-name">
            <div class="fname">
                <label class="label">First Name</label>
                <input type="text" name="fname" required>
            </div>

            <div class="lname">
                <label class="label">Last Name</label>
                <input type="text" name="lname" required>
            </div>
        </div>

        <hr class="form-hr">

        <div class="usernamepassword">
            <label class="label">Username</label>
            <input type="text" name="username" required>

            <label class="label">Password</label>
            <input type="password" name="password" required>
        </div>

        <hr class="form-hr">

        <c:if test="${not empty error}">
            <p style="color: var(--red); text-align: center; margin-bottom: 12px; font-weight: bold;">
                    ${error}
            </p>
        </c:if>


        <div class="form-action-btn">
            <button type="button" class="form-secondary-btn" onclick="window.location.href='index'">Cancel</button>
            <button type="submit" class="form-primary-btn">Sign up</button>
        </div>

    </div>
</form>
</body>
</html>