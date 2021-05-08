<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="main" style="margin-top:100px ">
    <div class="content">
        <div class=" col-md-12 bor" >

            <form:form cssStyle="min-width: 300px;" action="" method="post" modelAttribute="userModelcart" class=" col-md-6 col-md-offset-3 ">
                <h3>Thánh toán</h3>


                <div class="form-group">
                    Họ và tên
                    <form:input readonly="true"  path="name" cssClass="form-control" placeholder="name"/>
                </div>
                <div class="form-group">
                    Email
                    <form:input readonly="true" path="email" cssClass="form-control" placeholder="email"/>
                </div>
                <div class="form-group">
                    Địa chỉ
                    <form:input  readonly="true" path="address" cssClass="form-control" placeholder="address"/>
                </div>
                    Phone
                <div class="form-group">
                    <form:input readonly="true" path="phone" cssClass="form-control" placeholder="phone"/>
                </div>
                <div class="form-group">
                    Tổng tiền
                    <input Class="form-control" readonly="true" type="text" value="<tag:price price="${sum}"></tag:price>">
                </div>
            </form:form>
            <form:form action="/thanhtoan" method="post" modelAttribute="transaction" class=" col-md-6 col-md-offset-3 ">
                <form:hidden path="id"/>
                Ghi chú
                <form:input   path="note" cssClass="form-control" placeholder="giao hang tan noi"/>
                <div class="form-group" class="buttons" STYLE="width: 140px; margin: 0 auto; margin-top: 20px;margin-bottom: 100px">
                    <button onclick="removeCartItem()" type="submit" class="btn btn-block btn-primary">
                        <i class="fa fa-save"></i> Create account
                    </button>
                </div>
            </form:form>
        </div>


        <div class="clear"></div>
    </div>
</div>
<script type="text/javascript">
    function removeCartItem() {

        jQuery.ajax({

            success : function(data){
                alert("Thanh toán thành công"); // alerts the response from jsp
                // $('#Tablea').remove();
                // // location.reload();
            },
            error:function (e) {
                console.log("ERROR",e);
            }
        });
    }
</script>

