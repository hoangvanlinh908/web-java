<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page-wrapper">
    <a href="/add-product" class="btn btn-info">thêm mới</a>
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <div class="col-sm-12">


                    <table class="table table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Slug</th>
                            <th>thunbar</th>
                            <th>Created</th>
                            <th>Action</th>

                        </tr>
                        </thead>

                        <tbody>


                            <c:forEach items="${productlist}" var="product">
                        <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.category_id}</td>

                                <td>${product.slug}</td>
                                <td><img src="/images/shop/${product.thunbar}" width="80px" height="80px"></td>



                                <td>
                                    <ul>
                                        <li>Gia: ${product.price}</li>
                                        <li>So luong: ${product.number}</li>
                                    </ul>
                                </td>
                                <td>
                                    <a class="btn btn-xs btn-info" href="/edit-product?id=${product.id}"> sửa</a>
                                    <a class="btn btn-xs btn-danger" href="/product-delete?id=${product.id}">xóa</a>
                                </td>
                        </tr>
                            </c:forEach>



                        </tbody>
                    </table>
                    <div class="pull-right">
                        <nav aria-label="Page navigation" class="clearfix">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${totalPage}" varStatus="st">
                                    <c:choose>
                                        <c:when test="${currentPage == st.index}">
                                            <li class="active"><a href="/product/?page=${st.index}">${st.index}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class=""><a href="/product/?page=${st.index}">${st.index}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>


                            </ul>
                        </nav>

                    </div>


                </div>
            </div>
        </div>
    </div>
</div>