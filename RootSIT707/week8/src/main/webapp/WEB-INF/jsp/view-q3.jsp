<html>
<head><title>q3</title></head>
<body>
    <h2>q3</h2>

    <c:if test="${not empty message}">
        <p style="color:red">${message}</p>
    </c:if>

    <form action="/q3" method="post">
        <label>Number 1:</label>
        <input type="text" name="number1"/><br/>
        <label>Number 2:</label>
        <input type="text" name="number2"/><br/>
        <label>Multiplication:</label>
        <input type="text" name="result"/><br/>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
