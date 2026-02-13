<%--
  Created by IntelliJ IDEA.
  User: bhims
  Date: 2/1/2026
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Credits - DeadDrop</title>
    <link rel="icon" href="assets/images/Crop1_DeadDrop2.jpg" type="image/jpg">

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/global.css?v=10.8">
    <link rel="stylesheet" href="assets/css/creditPage.css?v=1.8">
    <link rel="stylesheet" href="assets/css/addTaskModal.css?v=1.8">
</head>
<body>
<!-- navgation bar -->
<nav>
    <navbar>
        <div class="logo-and-name">
            <div class="logo"><img id="logo-img" src="assets/images/Crop1_DeadDrop2.jpg"></div>
            <div class="name"><p class="logo-name">DeadDrop</p></div>
        </div>

        <div class="navigation">
            <button class="nav-btn" onclick="window.location.href='homepage'">Home</button>
            <button class="nav-btn" id="add-task-btn">Add Task</button>
            <button class="nav-btn" onclick="window.location.href='inProgress'">In Progress</button>
            <button class="nav-btn" onclick="window.location.href='credits'">Credits</button>
            <button class="nav-btn" onclick="window.location.href='profile'">Profile</button>
        </div>
    </navbar>
</nav>

<!-- main content -->
<div class="main">

    <!-- credits -->
    <div class="credit">
        <h3 class="section-heading">Your Credits</h3>
        <h2>${credit}</h2>
    </div>

    <div class="credit-store">
        <h1 class="section-heading">Credit Store</h1>
        <div class="credit-store-grid">
            <form method="post" action="buyCredit" class="credit-store-card">
                <input type="hidden" name="packageID" value="101" />
                    <div class="credit-store-card-body">
                        <h2>250 Credits</h2>
                    </div>
                    <div class="action-btn">
                        <button type="submit" class="purchase-primary-btn">Purchase</button>
                    </div>
            </form>

            <form method="post" action="buyCredit" class="credit-store-card">
                <input type="hidden" name="packageID" value="102" />
                <div class="credit-store-card-body">
                    <h2>500 Credits</h2>
                </div>
                <div class="action-btn">
                    <button type="submit" class="purchase-primary-btn">Purchase</button>
                </div>
            </form>

            <form method="post" action="buyCredit" class="credit-store-card">
                <input type="hidden" name="packageID" value="103" />
                <div class="credit-store-card-body">
                    <h2>1000 Credits</h2>
                </div>
                <div class="action-btn">
                    <button type="submit" class="purchase-primary-btn">Purchase</button>
                </div>
            </form>

            <form method="post" action="buyCredit" class="credit-store-card">
                <input type="hidden" name="packageID" value="104" />
                <div class="credit-store-card-body">
                    <h2>2000 Credits</h2>
                </div>
                <div class="action-btn">
                    <button type="submit" class="purchase-primary-btn">Purchase</button>
                </div>
            </form>

            <form method="post" action="buyCredit" class="credit-store-card">
                <input type="hidden" name="packageID" value="105" />
                <div class="credit-store-card-body">
                    <h2>5000 Credits</h2>
                </div>
                <div class="action-btn">
                    <button type="submit" class="purchase-primary-btn">Purchase</button>
                </div>
            </form>

            <form method="post" action="buyCredit" class="credit-store-card">
                <input type="hidden" name="packageID" value="106" />
                <div class="credit-store-card-body">
                    <h2>10000 Credits</h2>
                </div>
                <div class="action-btn">
                    <button type="submit" class="purchase-primary-btn">Purchase</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Add Task Modal -->
<div class="add-task-modal" id="add-task-modal">
    <div class="add-task-modal-content">
        <h2>Task</h2>

        <form id="add-task-form" class="add-task-form" action="addTask" method="post" enctype="multipart/form-data">

            <label>Task Title</label>
            <input type="text" name="title" required>

            <label>Description</label>
            <textarea name="description" required></textarea>

            <label>Credits</label>
            <input type="number" name="credits" required>

            <label>Deadline</label>
            <input type="date" name="deadline">

            <label>Image</label>
            <input type="file" name="image" accept="image/*">

            <div class="action-btn">
                <button type="button" class="secondary-btn">Cancel</button>
                <button type="submit" class="primary-btn">Create Task</button>
            </div>
        </form>
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
                <p><a class="footer-link" href="privacyPolicy" target="_blank" rel="noopener noreferrer">Privacy Policy</a></p>
                <p><a class="footer-link" href="termsOfUse" target="_blank" rel="noopener noreferrer">Terms of Use</a></p>
            </div>

            <div class="footer-menu">
                <p class="footer-heading-small">Preferences</p>
                <button class="theme-toggle"><img class="theme" src="assets/images/lightmode.png"></button>
            </div>
        </div>
    </div>
</div>

<script>
    const modal = document.getElementById("add-task-modal");
    const addTaskBtn = document.getElementById("add-task-btn");
    const cancelBtn = modal.querySelector(".secondary-btn");

    // open modal
    addTaskBtn.addEventListener("click", () => {
        modal.style.display = "flex";
    });

    // close modal (Cancel button)
    cancelBtn.addEventListener("click", () => {
        modal.style.display = "none";
    });

    // close when clicking outside modal content
    modal.addEventListener("click", (e) => {
        if (e.target === modal) {
            modal.style.display = "none";
        }
    });

    // close on ESC key
    window.addEventListener("keydown", (e) => {
        if (e.key === "Escape") {
            modal.style.display = "none";
        }
    });
</script>
</body>
</html>
