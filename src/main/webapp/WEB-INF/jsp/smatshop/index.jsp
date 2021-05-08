<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="main">
        <div class="content">
            <div class="content_top">
                <div class="heading">
                    <h3>Sản Phảm mới</h3>
                </div>
                <div class="sort">
                    <p>Sort by:
                        <select>
                            <option>Lowest Price</option>
                            <option>Highest Price</option>
                            <option>Lowest Price</option>
                            <option>Lowest Price</option>
                            <option>Lowest Price</option>
                            <option>In Stock</option>
                        </select>
                    </p>
                </div>
                <div class="show">
                    <p>Show:
                        <select>
                            <option>4</option>
                            <option>8</option>
                            <option>12</option>
                            <option>16</option>
                            <option>20</option>
                            <option>In Stock</option>
                        </select>
                    </p>
                </div>
                <div class="page-no">
                    <p>Result Pages:<ul>
                    <li><a href="#">1</a></li>
                    <li class="active"><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li>[<a href="#"> Next>>></a >]</li>
                </ul></p>
                </div>
                <div class="clear"></div>
            </div>
            <div class="section group">
                <c:forEach items="${shop2}" var="shop">
                    <div class="grid_1_of_4 images_1_of_4" style="width: 23%">
                        <a href="/deltail-id?id=${shop.id}"><img src="images/shop/${shop.thunbar}" alt="" /></a>
                        <h2>${shop.name} </h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
                        <p><span class="strike">${shop.sale}</span><span class="price"> <tag:price price="${shop.price}"></tag:price></span></p>
                        <div class="button"><span><img src="images/cart.jpg" alt="" /><a href="/addToCart?id=${shop.id}" class="cart-button">Add to Cart</a></span> </div>
                        <div class="button"><span><a href="/deltail-id?id=${shop.id}" class="details">Details</a></span></div>
                    </div>

                </c:forEach>


            </div>
            <div class="content_bottom">
                <div class="heading">
                    <h3>Sản phẩm nổi bật</h3>
                </div>
                <div class="sort">
                    <p>Sort by:
                        <select>
                            <option>Lowest Price</option>
                            <option>Highest Price</option>
                            <option>Lowest Price</option>
                            <option>Lowest Price</option>
                            <option>Lowest Price</option>
                            <option>In Stock</option>
                        </select>
                    </p>
                </div>
                <div class="show">
                    <p>Show:
                        <select>
                            <option>4</option>
                            <option>8</option>
                            <option>12</option>
                            <option>16</option>
                            <option>20</option>
                            <option>In Stock</option>
                        </select>
                    </p>
                </div>
                <div class="page-no">
                    <p>Result Pages:<ul>
                    <li><a href="#">1</a></li>
                    <li class="active"><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li>[<a href="#"> Next>>></a >]</li>
                </ul></p>
                </div>
                <div class="clear"></div>
            </div>
            <div class="section group">
                <c:forEach items="${shop3}" var="shop">
                    <div class="grid_1_of_4 images_1_of_4" style="width: 23%">
                        <a href="/deltail-id?id=${shop.id}"><img src="images/shop/${shop.thunbar}" alt="" /></a>
                        <h2>${shop.name} </h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
                        <p><span class="strike">${shop.sale}</span><span class="price"><tag:price price="${shop.price}"></tag:price></span></p>
                        <div class="button"><span><img src="images/cart.jpg" alt="" /><a href="/addToCart?id=${shop.id}" class="cart-button">Add to Cart</a></span> </div>
                        <div class="button"><span><a href="/deltail-id?id=${shop.id}" class="details">Details</a></span></div>
                    </div>

                </c:forEach>
            </div>
        </div>
    </div>
</div>
