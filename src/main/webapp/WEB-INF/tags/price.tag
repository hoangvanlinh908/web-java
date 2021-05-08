<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="price" required="true"  type="java.lang.Float" %>

    <fmt:formatNumber value="${price}"  currencySymbol="vnđ" currencyCode="vnđ"/> vnd

