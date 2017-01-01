<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <title>TechFab</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all"/>

<link href="resources/css/slider.css" rel="stylesheet" type="text/css" media="all"/>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
 
<script type="text/javascript" src="resources/js/move-top.js"></script>

<script type="text/javascript" src="resources/js/easing.js"></script>

<script type="text/javascript" src="resources/js/startstop-slider.js"></script>

<script src="resources/js/angular.min.js"></script>
        


</head>

<body>
 <div class="wrap">

	<div class="header">
	
	<div class="headertop_desc">
	
		<div class="call">
<p><span>Need help?</span> call us <span class="number">1-22-3456789</span></span></p>

<sec:authorize access="isAuthenticated()">
 <sec:authentication property="principal.Username"/>
 Dear <strong>${userName}</strong>, Welcome to Admin Page.
    <a href="<c:url value="/logout" />">Logout</a>
 </sec:authorize>
 
 
                  
 
			</div>
			
			<div class="account_desc">
				<ul>
					<li><a href="#">Register</a></li>
					<li><a href="#">Login</a></li>
					<li><a href="#">Delivery</a></li>
					<li><a href="#">Checkout</a></li>
					<li><a href="#">My Account</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="header_top">
			<div style="color:red;font-size:40px;font-weight:bold;">
		 TechFab
			</div>
			
			  <div class="cart">
			  	   <p>Welcome to our Online Store! <span>Cart:</span><div id="dd" class="wrapper-dropdown-2"> 0 item(s) - $0.00
			  	   	<ul class="dropdown">
							<li>you have no items in your Shopping cart</li>
					</ul></div></p>
			  </div>
			  <script type="text/javascript">
			function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#dd') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-2').removeClass('active');
				});

			});

		</script>
	 <div class="clear"></div>
  </div>
	<div class="header_bottom">
	     	<div class="menu">
	     		<ul>
			    	<li class="active"><a href="index.html">Home</a></li>
			    	<li><a href="about.html">About</a></li>
			    	<li><a href="delivery.html">Delivery</a></li>
			    	<li><a href="news.html">News</a></li>
			    	<li><a href="contact.html">Contact</a></li>
			    	<div class="clear"></div>
     			</ul>
	     	</div>
	     	<div class="search_box">
	     		<form>
	     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
	     		</form>
	     	</div>
	     	<div class="clear"></div>
	     </div>	     
	