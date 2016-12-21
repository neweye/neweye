<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<title></title>
</head>
<body>

	<!-- 상품 상세 상단 영역 시작 -->
	<article>
		<table border="1">
			<tr>
				<td rowspan="3">
				<img src="product_images/${productVO.img_List}" />
				이미지와야함</td>
				<td colspan="2">${productVO.name}상품명올거임</td>
			</tr>
			<tr>
				<td>가격 :</td>
				<td>${productVO.price}가격와야함</td>
			</tr>
			<tr>
				<td>수랑 :</td>
				<td>${productVO.quantity}수량와야함</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="button" value="TO CART"/>&nbsp;&nbsp;
					<input type="button" value="BUY NOW"/>&nbsp;&nbsp;
					<input type="button" value="LIST"/>
				</td>
				
			</tr>
		</table>
	</article>
	<!-- 상품 상세 상단 영역 끝 -->

<br/><br/><br/>
	<!-- 상품상세 테이블 시작 -->
	<article>
	
		<table border="1" solid="black">
			<th>상품 상세 정보</th>
			<tr>
				<td>상품번호</td>
				<td>| ${productVO.pseq}</td>
			</tr>
			<tr>
				<td>대분류</td>
				<td>| ${productVO.first_level}</td>
			</tr>
			<tr>
				<td>중분류</td>
				<td>| ${productVO.second_level}</td>
			</tr>
			<tr>
				<td>상품분류번호</td>
				<td>${productVO.kind}</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>${productVO.name}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${productVO.price}</td>
			</tr>
			<tr>
				<td>출시일</td>
				<td>${productVO.indate}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${productVO.read_count}</td>
			</tr>
			<tr>
				<td>수량</td>
				<td>${productVO.quantity}</td>
			</tr>
			<tr>
				<td>상품삭제여부</td>
				<td>${productVO.useyn}</td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td>${productVO.content}</td>
			</tr>
			<tr>
				<td>이미지명</td>
				<td>${productVO.img_List}</td>
			</tr>
			<tr>
				<td>상세이미지명</td>
				<td>${productVO.img_detail}</td>
			</tr>
			<tr>
				<td>크기</td>
				<td>${productVO.sizee}</td>
			</tr>
			<tr>
				<td>무게</td>
				<td>${productVO.weight}</td>
			</tr>
			<tr>
				<td>센서크기</td>
				<td>${productVO.ratio}</td>
			</tr>
			<tr>
				<td>화소</td>
				<td>${productVO.pixel}</td>
			</tr>
			<tr>
				<td>최소셔터스피드</td>
				<td>${productVO.speed}</td>
			</tr>
			<tr>
				<td>최대연속촬영속도</td>
				<td>${productVO.seqpictures}</td>
			</tr>
			<tr>
				<td>화면크기</td>
				<td>${productVO.screen}</td>
			</tr>
			<tr>
				<td>최대ISO감도</td>
				<td>${productVO.iso}</td>
			</tr>
			<tr>
				<td>동영상프레임</td>
				<td>${productVO.movframe}</td>
			</tr>
			<tr>
				<td>렌즈호환</td>
				<td>${productVO.format}</td>
			</tr>
			<tr>
				<td>필터구경</td>
				<td>${productVO.filter}</td>
			</tr>
			<tr>
				<td>렌즈기능</td>
				<td>${productVO.functions}</td>
			</tr>
			<tr>
				<td>줌여부</td>
				<td>${productVO. zoomyn}</td>
			</tr>
			<tr>
				<td>최소초점거리</td>
				<td>${productVO.minfocus}</td>
			</tr>
			<tr>
				<td>최대초첨거리</td>
				<td>${productVO.maxfocus}</td>
			</tr>
			<tr>
				<td>최소조리개</td>
				<td>${productVO.minaperture}</td>
			</tr>
			<tr>
				<td>최대조리개</td>
				<td>${productVO.maxaperture}</td>
			</tr>
			<tr>
				<td>최소촬영거리</td>
				<td>${productVO.distance}</td>
			</tr>
			<tr>
				<td>액세서리 분류</td>
				<td>${productVO.types}</td>
			</tr>



		</table>
	</article>
	<!-- 상품상세 테이블 끝 -->
	
	<!-- 상품 구매 주의사항 시작 -->
	
	<!-- 상품 구매 주의사항 끝 -->

</body>
</html>