<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <div id="page-wrapper">
        <a href="/register" class="btn btn-info">thêm mới</a>
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-sm-12">

                        <table class="table table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Phone</th>
                                <th>level</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${admin}" var="admin">
                                <tr>
                                    <td>${admin.id}</td>
                                    <td>${admin.name}</td>
                                    <td>${admin.address}</td>
                                    <td>${admin.email}</td>
                                    <td>${admin.password}</td>
                                    <td>${admin.phone}</td>
                                    <td>${admin.level}</td>

                                    <td>
                                        <a class="btn btn-xs btn-info"  href="/edit?id=${admin.id}">sửa</a>
                                        <a class="btn btn-xs btn-danger" href="/delete?id=${admin.id}">xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="pull-right">
                            <nav aria-label="Page navigation" class="clearfix">
                                <ul class="pagination">
                                    <li>
                                        <a class="page-link" href="" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </li>
                                    <li class="active">
                                        <a class="page-link" href="?page=1">1</a>

                                    </li>
                                    <li class="">
                                        <a class="page-link" href="?page=2">2</a>

                                    </li>
                                    <li class="">
                                        <a class="page-link" href="?page=3">3</a>

                                    </li>
                                    <li>
                                        <a class="page-link" href="" aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>

                        </div>


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

