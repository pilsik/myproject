<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <div class="row">
                Confirmation message : ${success}
                <br>
                Would you like to <a href="<c:url value='/newclient' />">Add More Users</a>
                <br/>
                Go to <a href="<c:url value='/home' />">Admin Page</a> OR <a href="<c:url value="/logout" />">Logout</a>
            </div>
            <div class="row">
                <a href="<c:url value='/addAddress' />">Add More Users</a>?
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>
