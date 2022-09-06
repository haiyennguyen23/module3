<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/6/2022
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Student</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
          integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="col-lg-9 col-md-8">
    <h3 class="display-4">Update Student</h3>
    <div class="card">

        <div class="card-body row">
            <form action="/Student?action=editPost&id=${studentEdit.getId_student()}" method="post">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" size="100"
                                   value="${studentEdit.getName()}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td>
                            <input type="text" name="price" size="100"
                                   value="${studentEdit.getPrice()}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>
                            <input type="number" name="quantity" size="100"
                                   value="${studentEdit.getQuantity()}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td>
                            <input type="text" name="color" size="100"
                                   value="${studentEdit.getColor()}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Class:</th>
                        <td>
                            <input type="text" name="description" size="100"
                                   value="${studentEdit.getDescription()}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="category" id="category">
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.getId_category()}">${category.getName_category()}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${studentEdit != null}">
                                <script>
                                    function myFunction() {
                                        document.getElementById("category").value = "${id_category}";
                                    }
                                    <c:if test="${studentEdit != null}">myFunction()</c:if>
                                </script>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit" class="btn btn-success">Update</button>
                            <button type="button" class="btn btn-outline-success"><a href="/product">Back</a></button>
                        </td>
                    </tr>
                    <tr>
                        <c:if test="${requestScope['check'] == true}">
                            <h5 style="color: blue">Update Student</h5>
                        </c:if>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
