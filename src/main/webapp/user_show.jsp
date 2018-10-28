<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="data">
    <table>
        <tr class="title">
            <td></td>
            <td>序号</td>
            <td>账号</td>
            <td>密码</td>
            <td></td>
        </tr>
        <c:choose>
            <c:when test="${requestScope.rows!=null }">
                <c:forEach items="${requestScope.rows }" var="ins" varStatus="vs">
                    <tr>
                        <td>${vs.count }</td>
                        <td>${ins.aac104 }</td>
                        <td>${ins.aac103 }</td>
                        <td>${ins.aac202 }</td>
                        <td>${ins.aac302 }</td>
                        <td>${ins.aac402 }</td>
                        <td align="center">
                            <a href="#" onclick="onDelete('${ins.aac101}')">[删除]</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach begin="1" step="1" end="10">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</div>
</body>
</html>
