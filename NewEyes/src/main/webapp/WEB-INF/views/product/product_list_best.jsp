<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
article.product_list_best {
	color: #555555;
}

div.div_product_best {
	margin: auto;
	padding: 15px 0 0 0 ;
	width: 1000px;
	border: 1px dashed #999999;
}

li.product_list_best_li {
	list-style: none;
}

span.div_areasize {
	width: 650px;
	text-align: center;
	vertical-align: top;
}

div.index_div_all {
	folat: left;
	padding: 5px auto;
	width: 210px;
	height: 210px;
	text-align: center;
	vertical-align: top;
	display: table-cell;
}

div#index_product_list {
	margin: 10px;
	padding: 0 20px 10px;
	width: 200px;
	height: 200px;
	border: 1px dashed #999999;
	display: inline-block;
}
img.index_product_img {
	width: 180px;
}
</style>

<article class="product_list_best">
	<div class="div_product_best">
	<h2>BEST PRODUCT</h2>
			<c:forEach items="${bestProductList}" begin="0" end="3" step="1" var="productVO">
				<span class="div_areasize">
				<div class="index_div_all">
				<div id='#index_product_list'>
					<a href="productDetail?pseq=${productVO.pseq}">
						<ul class="plist">
							<li class="product_list_best_li"><img class="index_product_img"
								src="<%=request.getContextPath() %>/productimg/${productVO.img_list}"
								onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'" />
							</li>
						</ul>
						<ul>
							<li class="product_list_best_li">${productVO.name}</li>
							<li class="product_list_best_li">${productVO.price}</li>
						</ul>
					</a>
					</div>
					</div>
					
					</span>
			</c:forEach>
	</div>
</article>