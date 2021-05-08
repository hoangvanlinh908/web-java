<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="main" style="margin-top:100px ">
    <div class="content">
        <div class="panel-body">
            <div class="table-responsive">
<c:choose>
    <c:when test="${cart == null || empty cart.cartItems}">
        lol
    </c:when>
    <c:otherwise>
                <table class="table table-hover" >
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Hình Ảnh</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Tổng tiền</th>
                        <th>Thao tác</th>

                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${cart.cartItems}" var="cart" varStatus="i" begin="0" end="100">

                            <tr id="Tablea">

                                <td >${i.index+1}</td>
                                <td>${cart.product.name}</td>
                                <td><img width="128" height="128" src="/images/shop/${cart.product.thunbar}" alt=""></td>
                                <td>${cart.number1}</td>

                                <td> <tag:price price="${cart.product.price}"></tag:price></td>

                                <td><tag:price price="${cart.totalPrice}"></tag:price></td>
                                <td>
                                    <a class="btn btn-xs btn-info" href="/edit-category?id=${category.id}"> cập nhập</a>
                                 <a onclick="removeCartItem(${cart.product.id})" class="btn btn-xs btn-danger" >xóa</a>
                                </td>


                            </tr>



                        </c:forEach>


                    </tbody>
                </table>
            </div>

    </c:otherwise>
</c:choose>
            <a class="btn btn-xs btn-info" href="/thanhtoan">Thanh toán</a>


            </div>
        </div>


        <div class="clear"></div>
    </div>

</div>
<script type="text/javascript">
    index=0;

    function removeCartItem(id) {
        var id = id;
        jQuery.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/cartdelete",
            data: {
                id: id
            }
            ,
                success : function(data){
                    alert("xóa thành công");
                    $('#Tablea').remove();
                },

            error:function (e) {
                console.log("ERROR",e);

            }

        });

    }




</script>

