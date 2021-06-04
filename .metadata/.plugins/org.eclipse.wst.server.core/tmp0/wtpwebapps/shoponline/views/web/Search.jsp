<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class='category-container' style='margin-bottom: 32px'>
		<div class="main__product-container row">
			<!-- DUPLICATE THIS COMPONENT -->
			<c:forEach var="item" items="${products}">
				<div
					class="product-item col-12 col-sm-12 col-md-6 col-lg-4 col-xl-3">
					<div class="product-border">
						<a href="/detail?id=${item.id }"><img
							src="<c:url value= '${item.thumbnail }' />" alt=""
							class="product-img"></a>
						<h3 class="product-name">
							${item.title}
							</h5>
							<p class="product-price">${item.price }</p>
							<p class="product-describe">${item.shortDescription }</p>
					</div>
				</div>
			</c:forEach>
			<!-- ********  -->
		</div>
	</div>
</body>
</html>