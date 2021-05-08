<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">

<div id="page-inner">
<div class="row">
<div class="col-md-12">
<form:form cssStyle="min-width: 300px;" action="/register" method="post" modelAttribute="registerForm">
    <div class="form-group">
        Họ Và tên
        <form:input path="name" cssClass="form-control" placeholder="Username"/>
        <form:errors path="name"/>
    </div>
    <div class="form-group">
        Address
        <form:input path="address" cssClass="form-control" placeholder="Name"/>
        <form:errors path="address"/>
    </div>
    <div class="form-group">
        Email
        <form:input path="email" cssClass="form-control" placeholder="Name"/>
        <form:errors path="email"/>
    </div>

    <div class="form-group">
        Password
        <form:password path="password" cssClass="form-control" placeholder="Password"/>
        <form:errors path="password"/>
    </div>

    <div class="form-group">
        Phone
        <form:input path="phone" cssClass="form-control" placeholder="Name"/>
        <form:errors path="phone"/>
    </div>



    <div class="form-group">
        <button type="submit" class="btn btn-block btn-primary">
            <i class="fa fa-save"></i> Create account
        </button>
    </div>
</form:form>
    ${mess}
</div>
</div>
</div>
</div>