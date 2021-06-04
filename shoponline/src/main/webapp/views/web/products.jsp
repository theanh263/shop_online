<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang chủ</title>
</head>
<body>

	<!-- BODY -->
	<div class="main-content">
		<div class='container'>
<%-- 		    <div class="main__ads">
                <img src="<c:url value='/template/image/banner.png'/>"/>
            </div> --%>
			<div class="product-container main__product">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item">${category.name}</li>
					</ol>
				</nav>
				<div class='category-container' style='margin-bottom: 32px'>
					<div class="main__product-container row">
						<!-- DUPLICATE THIS COMPONENT -->
						<c:forEach var="item" items="${products}">
							<div
								class="product-item col-12 col-sm-12 col-md-6 col-lg-4 col-xl-3">
								<div class="product-border">
									<a href="/detail?id=${item.id }"><img src="<c:url value= '${item.thumbnail }' />" alt=""
										class="product-img"></a>
									<h3 class="product-name">
										${item.title}
										</h5>
										<a href="">
<!-- 											<p class="product-verson">
												Có <strong style="color: red;">5</strong> phiên bản cấu hình
											</p> -->
										</a>
										<p class="product-price">${item.price } WON</p>
										<p class="product-describe">${item.shortDescription }</p>
								</div>
							</div>
						</c:forEach>
						<!-- ********  -->
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>