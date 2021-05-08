<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-wrapper">

    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <form:form cssStyle="min-width: 300px;" action="/edit-product" method="post" modelAttribute="editProduct" enctype="multipart/form-data">

                        <div class="form-group">
                            Danh mục sản phẩm
                            <div class="col-10">
                                <form:hidden path="id"/>
                                <form:select path="category_id">
                                    <form:options  items="${category}" itemLabel="name" itemValue="id"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            Danh mục sản phẩm
                            <form:input path="name" cssClass="form-control" placeholder="Username"/>

                        </div>
                             <form:errors path="name"/>
                        <div class="form-group">
                            Danh mục sản phẩm
                            <form:input path="price" cssClass="form-control" placeholder="Username"/>

                        </div>
                    <form:errors path="price"/>
                        <div class="form-group">
                            Danh mục sản phẩm
                            <form:input path="number" cssClass="form-control" placeholder="Username"/>

                        </div>
                    <form:errors path="number"/>
                        <div class="form-group">
                            Danh mục sản phẩm
                            <form:input path="sale" cssClass="form-control" placeholder="Username"/>

                        </div>
                    <form:errors path="sale"/>
                        <div class="form-group ">
                            <label class="col-2 col-form-label">Image</label>
                            <div class="col-10">
                                <input type="file" name="thunbar">
                            </div>
                            <img src="/images/shop/${editProduct.thunbar}" height="80px" width="80px">
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