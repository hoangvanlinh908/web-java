<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="page-wrapper">

    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <form:form cssStyle="min-width: 300px;" action="/edit-category" method="post" modelAttribute="editcategory">
                    <div class="form-group">
                        <form:hidden path="id"/>
                        Họ Và tên
                        <form:input path="name" cssClass="form-control" placeholder="Username"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-block btn-primary">
                            <i class="fa fa-save"></i> edit
                        </button>
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>