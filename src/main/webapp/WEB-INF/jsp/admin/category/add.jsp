<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <div class="col-sm-12">
                <form:form cssStyle="min-width: 300px;" action="/add-category" method="post" modelAttribute="categoryAdd">
                    <div class="form-group">
                        Họ Và tên
                        <form:input path="name" cssClass="form-control" placeholder="Username"/>
                        <form:errors path="name"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-block btn-primary">
                            <i class="fa fa-save"></i> Create
                        </button>
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>
</div>