<!DOCTYPE html>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
    <h1>Create Task</h1>
    <form action="CreateTaskServlet" method="post">
        <label for="title">Task Title:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="description">Task Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" required><br><br>

        <label for="priority">Priority:</label>
        <select id="priority" name="priority" required>
            <option value="High">High</option>
            <option value="Medium">Medium</option>
            <option value="Low">Low</option>
        </select><br><br>

        <input type="submit" value="Create Task" id="createTask">
    </form>
</body>
</html>
