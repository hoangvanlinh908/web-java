<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="main">
    <div class="content">
        <div class="section group">
            <c:forEach items="${deltail}" var="deltail">
                <div class="cont-desc span_1_of_2">
                    <div class="grid images_3_of_2">
                        <img src="images/shop/${deltail.thunbar}" alt="">
                    </div>
                    <div class="desc span_3_of_2">
                        <h2>${deltail.name}</h2>
                        <p> ${deltail.slug}</p>
                        <div class="price">
                            <p>Price: <span>${deltail.price}</span></p>
                        </div>

                        <div class="share">
                            <p>Share Product :</p>
                            <ul>
                                <li><a href="#"><img src="images/youtube.png" alt=""></a></li>
                                <li><a href="#"><img src="images/facebook.png" alt=""></a></li>
                                <li><a href="#"><img src="images/twitter.png" alt=""></a></li>
                                <li><a href="#"><img src="images/linkedin.png" alt=""></a></li>
                            </ul>
                        </div>
                        <div class="add-cart">
                            <div class="rating">
                                <p>Rating:<img src="images/rating.png"><span>[3 of 5 Stars]</span></p>
                            </div>
                            <div class="button"><span><a href="/addToCart?id=${deltail.id}">Add to Cart</a></span></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="product-desc">
                        <h2>Product Details</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                    </div>
                    <div class="product-tags">
                        <h2>Product Tags</h2>
                        <h4>Add Your Tags:</h4>
                        <div class="input-box">
                            <input type="text" value="">
                        </div>
                        <div class="button"><span><a href="#">Add Tags</a></span></div>
                    </div>
                </div>
            </c:forEach>

            <div class="rightsidebar span_3_of_1">
                <h2>CATEGORIES</h2>
                <ul>
                    <li><a href="#">Mobile Phones</a></li>
                    <li><a href="#">Desktop</a></li>
                    <li><a href="#">Laptop</a></li>
                    <li><a href="#">Accessories</a></li>
                    <li><a href="#">Software</a></li>
                    <li><a href="#">Sports &amp; Fitness</a></li>
                    <li><a href="#">Footwear</a></li>
                    <li><a href="#">Jewellery</a></li>
                    <li><a href="#">Clothing</a></li>
                    <li><a href="#">Home Decor &amp; Kitchen</a></li>
                    <li><a href="#">Beauty &amp; Healthcare</a></li>
                    <li><a href="#">Toys, Kids &amp; Babies</a></li>
                </ul>

            </div>
        </div>
    </div>
</div>
</div>
