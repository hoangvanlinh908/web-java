<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main" style="margin-top:100px ">
    <div class="content">
        <div class="col-md-12 bor">
            <h3>Existing Customers</h3>
            <p>Sign in with the form below.</p>
            <form:form cssStyle="min-width: 300px;" action="/loginUser" method="post" modelAttribute="loginFormUser" class=" col-md-6 col-md-offset-3 ">
                <div class="form-group">
                    <form:input path="email" cssClass="form-control" placeholder="email"/>
                </div>

                <div class="form-group">
                    <form:password path="password" cssClass="form-control" placeholder="Password"/>
                </div>



                <div class="form-group" class="buttons">
                    <button type="submit" class="btn btn-block btn-primary">
                        <i class="fa fa-save"></i> Create account
                    </button>
                </div>
                <div class="button"><span>  <a href="/register-user">đăng ký</a></span></div>

            </form:form>

        </div>

        <div class="clear"></div>
    </div>

</div>
