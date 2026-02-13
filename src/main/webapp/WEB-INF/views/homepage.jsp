<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - DeadDrop</title>
    <link rel="icon" href="assets/images/Crop1_DeadDrop2.jpg" type="image/jpg">

    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/global.css?v=10.9">
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

    <!-- tasks -->
    <div class="task">
        <h1 class="section-heading">Tasks</h1>
        <div class="task-grid">
            <c:if test="${empty tasks}">
                <h3 style="color: var(--grey-light)">No tasks to execute.</h3>
            </c:if>

            <c:forEach var="task" items="${tasks}">
                <form method="post" action="taskAction" class="task-card">
                    <input type="hidden" name="taskId" value="${task.taskId}" />
                    <div class="task-body">
                        <div class="task-img-card">
                            <c:choose>
                                <c:when test="${empty task.imagePath}">
                                    <img class="task-img" src="${pageContext.request.contextPath}/assets/images/oracle-red-bull-racing-2026-livery.avif" />
                                </c:when>
                                <c:otherwise>
                                    <img class="task-img" src="${pageContext.request.contextPath}/${task.imagePath}" />
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="task-details">
                            <p class="task-title">${task.title}</p>
                            <p class="task-credits">Credits: ${task.credits}</p>
                            <p class="task-deadline">Deadline: ${task.deadline}</p>
                            <p class="task-director">Director: ${task.director}</p>
                            <p class="task-creation">Published: ${task.createdAt}</p>
                            <p class="task-description">Description:<br>${task.description}</p>
                        </div>
                    </div>
                    <div class="action-btn">
                        <button class="secondary-btn">Add Credit</button>
                        <button type="submit" class="primary-btn">Execute</button>
                    </div>
                </form>
            </c:forEach>
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