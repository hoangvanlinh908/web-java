<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">

    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <div class="col-sm-12">

                    <table class="table table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                        <thead>
                        <tr>
                            <th>ID</th>

                            <th>amount</th>
                            <th>Status</th>
                            <th>note</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${tran}" var="transaction">
                            <tr>
                                <td>${transaction.id}</td>
                                <td>${transaction.amount}</td>
                                <td>${transaction.status}</td>
                                <td>${transaction.note}</td>


                                <td>

                                    <a class="btn btn-xs btn-danger" href="/user-delete?id=${user.id}">xóa</a>
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

