<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<article class="product_list_jsp">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="wow bounceInUp" data-wow-delay="0.4s">
				<h2 class="wow bounceInUp" data-wow-delay="0.3s">BEST PRODUCT</h2>
					<div id="owl-works" class="owl-carousel">
						<c:forEach items="${bestProductList}" begin="0" end="11" step="1" var="productVO">
							<div class="item">
								<span class="div_areasize">
									<div class="div_all">
										<div id="product_list">
											<ul class="plist">
												<li><a href="productDetail.ne?pseq=${productVO.pseq}">
														<img
														src="<%=request.getContextPath() %>/productimg/${productVO.img_list}" />
												</a></li>
											</ul>
											<ul>
												<li id="product_list_name">${productVO.name}</li>
												<li id="product_list_price">${productVO.price}</li>
												<li id="product_list_price">${productVO.read_count}</li>
											</ul>
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