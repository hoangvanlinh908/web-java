<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">
    <a href="/add-category" class="btn btn-info">thêm mới</a>
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <div class="col-sm-12">

                    <table class="table table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                        <thead>

                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Slug</th>

                            <th>Created</th>
                            <th>Action</th>

                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${category}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>${category.slug}</td>

                            <td>${category.created_at}</td>
                            <td>
                                <a class="btn btn-xs btn-info" href="/edit-category?id=${category.id}"> sửa</a>
                                <a class="btn btn-xs btn-danger" href="/category-delete?id=${category.id}">xóa</a>
                            </td>
                        </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">«</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">»</span>
                                </a>
                            </li>
                        </ul>
                    </nav>

                </div>

            </div>
        </div>
        <!-- /. ROW  -->


    </div>
    <!-- /. PAGE INNER  -->
</div>
<!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

