<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DeadDrop</title>
    <link rel="icon" href="assets/images/Crop1_DeadDrop2.jpg" type="image/jpg">

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/index.css?v=1.1">
</head>
<body>

<!-- navigation bar -->
<nav>
    <div class="logo-and-name">
        <img id="logo-img" src="assets/images/Crop1_DeadDrop2.jpg">
        <p class="logo-name">DeadDrop</p>
    </div>

    <div class="navigation">
        <button type="button" class="nav-btn secondary-btn" onclick="window.location.href='login'">Log in</button>
        <button type="button" class="nav-btn primary-btn" onclick="window.location.href='signup'">Sign up</button>
    </div>
</nav>


<!-- main content -->
<div class="main">
    <div class="desc">
        <p class="slogan">Task and Reward Network.</p>
        <p class="slogan-sub">Where Directors create tasks.<br>Agents execute tasks and earn rewards.</p>
    </div>


    <!-- explore sectoin -->
    <div class="explore">
        <div class="explore-card">
            <img class ="explore-img" src="assets/images/oracle-red-bull-racing-2026-livery.avif">
        </div>
    </div>
</div>


<!-- footer section -->
<div class="footer">
    <div class="footer-section">
        <div class="footer-left">
            <p class="footer-heading-small">DeadDrop</p>
            <p>Copyright © DeadDrop 2026. All rights reserved.</p>
        </div>

        <div class="footer-right">
            <div class="footer-menu">
                <p class="footer-heading-small">Links</p>
                <p><a class="footer-link" href="${pageContext.request.contextPath}/privacyPolicy" target="_blank" rel="noopener noreferrer">Privacy Policy</a></p>
                <p><a class="footer-link" href="${pageContext.request.contextPath}/termsOfUse" target="_blank" rel="noopener noreferrer">Terms of Use</a></p>
            </div>

            <div class="footer-menu">
                <p class="footer-heading-small">Preferences</p>
                <button class="theme-toggle"><img class="theme" src="assets/images/lightmode.png"></button>
            </div>
        </div>
    </div>
</div>
</body>
</html>