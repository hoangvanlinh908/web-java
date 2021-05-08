<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main" style="margin-top:100px ">
    <div class="content">
        <div class="col-md-12 bor">
            <h3>Existing Customers</h3>
            <p>Sign in with the form below.</p>
            <form:form cssStyle="min-width: 300px;" action="/register-user" method="post" modelAttribute="registerFormuser" class=" col-md-6 col-md-offset-3 ">
                <div class="form-group">
                    HỌ và tên
                    <form:input path="name" cssClass="form-control" placeholder="name"/>
                    <form:errors path="name"/>
                </div>
                <div class="form-group">
                    Email
                    <form:input path="email" cssClass="form-control" placeholder="email"/>
                    <form:errors path="email"/>
                </div>

                <div class="form-group">
                    Password
                    <form:password path="password" cssClass="form-control" placeholder="Password"/>
                    <form:errors path="password"/>
                </div>
                <div class="form-group">
                    Địa chỉ
                    <form:input path="address" cssClass="form-control" placeholder="address"/>
                    <form:errors path="address"/>
                </div>

                <div class="form-group">
                    Số điện thoại
                    <form:password path="phone" cssClass="form-control" placeholder="phone"/>
                    <form:errors path="phone"/>
                </div>

                <div class="form-group" class="buttons">
                    <button type="submit" class="btn btn-block btn-primary">
                        <i class="fa fa-save"></i> Create account
                    </button>
                </div>
            </form:form>
        </div>

        <div class="clear"></div>
    </div>

</div>
