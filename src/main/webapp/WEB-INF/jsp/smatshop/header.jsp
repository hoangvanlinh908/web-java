<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html>
<head>

    <title>Linhshop</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css1/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css1/menu.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="js1/jquery.min.js"></script>
    <script src="js1/script.js" type="text/javascript"></script>
    <script type="text/javascript" src="js1/move-top.js"></script>
    <script type="text/javascript" src="js1/easing.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.1/content/tables/">
    <link href='//fonts.googleapis.com/css?family=Monda' rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Doppio+One' rel='stylesheet' type='text/css'>

    <!-- BOOTSTRAP STYLES-->
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div class="wrap">
    <div class="header">

        <div class="header_top">
            <div class="logo">
                <a href="/"><img src="images/logo.png" alt="" /></a>
            </div>
            <div class="header_top_right">
                
                <div class="search_box">
                    <form:form cssStyle="min-width: 300px;" action="/search" method="post" modelAttribute="search">
                            <form:input id="w-input-search" path="name" cssClass="form-control" placeholder="Search for Products"/>
                        <input type="submit" value="SEARCH">
                    </form:form>
                </div>
                <div class="search_box">
                    <form>
                    </form>
                </div>
                <div class="shopping_cart">
                    <div class="cart">
                        <a href="/cart" title="View my shopping cart" rel="nofollow">
                            <strong class="opencart"> </strong>
                            <c:if test="${cart == null}">
                                <span class="no_product">(empty)</span>
                            </c:if>
                            <span class="cart_title">Cart</span>

                        </a>
                    </div>
                </div>
                <div class="languages" title="language">
                    <div class="login" style="width: 90px">
                        <a href="/register-user"> Đăng ký</a>
                    </div>
                </div>


                    <c:if test="${userModelcart != null}">
                        <div class="login" style="width: 90px">
                            <a href="/logoutUser"> Đẳng Xuất</a>
                        </div>
                    </c:if>

                <c:if test="${userModelcart != null}">
                <div class="login" style="width: 90px">
                    <p> chào ${userModelcart.name}</p>
                </div>
                </c:if>
                <c:if test="${userModelcart == null}">
                <div class="login">
                        <span><a href="/loginUser"><img src="images/login.png" alt="" title="login"/></a></span>


                </div>
                </c:if>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="h_menu">
            <a id="touch-menu" class="mobile-menu" href="#">Menu</a>
            <nav>
                <ul class="menu list-unstyled">
                    <li><a href="/">HOME</a></li>
                    <li class="activate"><a href="products.html">Category</a>
                        <ul class="sub-menu list-unstyled sub-menu2">
                            <div class="navg-drop-main">

                                    <c:forEach items="${categories}" var="category">
                                        <div class="nav-drop nav-top-brand">
                                        <li><a href="/productCategory?id=${category.id}">${category.name}</a></li>
                                        </div>
                                    </c:forEach>



                            </div>
                        </ul>
                    </li>
                    <li><a href="products.html">Top Brand</a>
                        <ul class="sub-menu list-unstyled sub-menu2">

                        </ul>
                    </li>
                    <li><a href="faq.html">Services</a>

                    </li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="#">Delivery</a></li>
                    <li><a href="faq.html">Faqs</a></li>
                    <li><a href="contact.html">CONTACT</a></li>
                    <div class="clear"> </div>
                </ul>
            </nav>
            <script src="js/menu.js" type="text/javascript"></script>
        </div>

        <div class="header_bottom">
            <div class="header_bottom_left">
                <div class="section group">
                    <c:forEach items="${shop}" var="shop">
                        <div class="listview_1_of_2 images_1_of_2">
                            <div class="listimg listimg_2_of_1">
                                <a href="/deltail-id?id=${shop.id}"> <img src="images/shop/${shop.thunbar}" alt="" /></a>
                            </div>
                            <div class="text list_2_of_1">
                                <h2>${shop.name}</h2>
                                <tag:price price="${shop.price}"></tag:price>
                                <p>Lorem ipsum dolor sit amet sed do eiusmod.</p>
                                <div class="button"><span><a href="/addToCart?id=${shop.id}">Add to cart</a></span></div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <div class="section group">
                    <c:forEach items="${shop1}" var="shop">
                        <div class="listview_1_of_2 images_1_of_2">
                            <div class="listimg listimg_2_of_1">
                                <a href="/deltail-id?id=${shop.id}"> <img src="images/shop/${shop.thunbar}" alt="" /></a>
                            </div>
                            <div class="text list_2_of_1">
                                <h2>${shop.name}</h2>
                                <tag:price price="${shop.price}"></tag:price>
                                <p>Lorem ipsum dolor sit amet sed do eiusmod.</p>
                                <div class="button"><span><a href="/addToCart?id=${shop.id}">Add to cart</a></span></div>
                            </div>
                        </div>

                    </c:forEach>
                </div>
                <div class="clear"></div>
            </div>
            <div class="header_bottom_right_images" style="margin-top: 30px">
                <!-- FlexSlider -->
                <section class="slider" >
                    <div class="flexslider">
                        <ul class="slides">
                            <li><img src="images/13.PNG" alt=""/></li>
                            <li><img src="images/11.PNG" alt=""/></li>
                            <li><img src="images/12.PNG" alt=""/></li>
                        </ul>
                    </div>
                </section>
                <!-- FlexSlider -->
            </div>
            <div class="clear"></div>
        </div>
    </div>

