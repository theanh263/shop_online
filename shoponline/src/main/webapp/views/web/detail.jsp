<%@include file="/common/taglib.jsp" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Chi tiết sản phẩm</title>
		</head>

		<body>
			<!-- BODY -->
			<div id='detail-page'>
				<div class='container'>
					<div class="detail-container">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<!-- 						<li class="breadcrumb-item"><a href="#">Library</a></li> -->
								<li class="breadcrumb-item active" aria-current="page">${product.title }</li>
							</ol>
						</nav>
						<div class='detail-body'>
							<div class="main-info">
								<div class="image-container">
									<img src="<c:url value= '${product.thumbnail }' />" alt='' />
								</div>
								<div class="main-info-detail">
									<h1 class='detail-title'>${product.title }</h1>
									<!-- 							<h5 class='detail-code'>
								Item code: <i>MH370MALAYSIAAIRLINE</i>
							</h5> -->
									<h5 class='detail-producer'>
										Producer: <span>${product.producer }</span>
									</h5>
									<h5 class='detail-producer'>
										Stock: <span>${product.stock }</span>
									</h5>
									<h3>${product.price } WON</h3>
									<button title='Add to cart'>
										<i class="fas fa-shopping-cart"></i>
									</button>
									<form id="formSubmit">
										<input type="hidden" name="productId" value="${product.id  }">
										<input type="hidden" name="quantity" value="1">
										<input type="hidden" name="userId" value="${USERMODEL.id }">
										<input type="hidden" name="userName" value="${USERMODEL.userName }">
										<input type="hidden" name="productName" value="${product.title   }">
										<button type="submit" id="btnBuy">
											Quick buy</i>
										</button>
									</form>


								</div>
							</div>

							<div class="description">
								<hr />
								<div class='desc-container'>
									${product.description}
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script>
				$('#btnBuy').click(function (e) {
					e.preventDefault();
					var data = {};
					var formData = $('#formSubmit').serializeArray();
					$.each(formData, function (i, v) {
						data["" + v.name + ""] = v.value;
					});
					addProduct(data);
				});
				function addProduct(data) {
					$.ajax({
						url: "/myproducts",
						type: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(data),
						dataType: 'json',
						success: function (result) {
							window.location.href = "/myproducts?userCart=${USERMODEL.id}";
						},
						error: function (error) {
							window.location.href = "/trang-chu";
						}
					});
				}
			</script>
		</body>

		</html>