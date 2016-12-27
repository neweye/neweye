<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<style>
article.product_list_new{
	color: #555555;
}


li.product_list_new_li{
list-style:none;
}
</style>

<article class="product_list_new">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="wow bounceInUp" data-wow-delay="0.4s">
				<h2 class="wow bounceInUp" data-wow-delay="0.3s">NEW PRODUCT</h2>
					<div id="owl-works" class="owl-carousel">
						<c:forEach items="${newProductList}" begin="0" end="11" step="1" var="productVO">
							<div class="item">
								<span class="div_areasize">
									<div class="div_all">
										<div id="product_list">
											<a href="productDetail.ne?pseq=${productVO.pseq}">
											<ul class="plist">
												<li class="product_list_new_li">
													<img src="<%=request.getContextPath() %>/productimg/${productVO.img_list}" onerror="this.src='<%=request.getContextPath() %>/productimg/default.png'"/>
												</li>
											</ul>
											<ul>
												<li class="product_list_new_li" id="product_list_name">${productVO.name}</li>
												<li class="product_list_new_li" id="product_list_price">${productVO.price}</li>
											</ul>
											</a>
										</div>
									</div>
								</span>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</article>