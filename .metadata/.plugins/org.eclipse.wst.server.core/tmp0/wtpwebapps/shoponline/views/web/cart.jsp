<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<!-- BODY -->
	<div id="cart">
		<div class='container'>
			<div class="cart-container">
				<div style='col-12'>
					<nav aria-label="breadcrumb" style='width: 100%'>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item">Cart</li>
						</ol>
					</nav>
				</div>
				<button style="margin: 12px 0px;" id="btnDelete" type="button"
					class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
					data-toggle="tooltip" title='Xóa bài viết'>
					<span> <i class="fa fa-trash-o bigger-110 pink"></i>
					</span>
				</button>
					<div class="col-xs-12">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><input style="opacity: 0" type="checkbox" id="checkAll"></th>
										<th>Tên Sản phẩm</th>
										<th>Số lượng sản phẩm</th>
										<!-- <th>Thao tác</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.listResult}">
										<tr>
											<td><input type="checkbox"
												id="checkbox_${item.productId}" value="${item.productId}"></td>
											<td>${item.productName}</td>
											<td>${item.quantity}</td>
											<%-- 											<td><c:url var="editURL" value="/admin-myproducts">
													<c:param name="type" value="edit" />
													<c:param name="id" value="${item.id}" />
												</c:url> <a class="btn btn-sm btn-primary btn-edit"
												data-toggle="tooltip" title="Cập nhật bài viết"
												href='${editURL}'><i class="fa fa-pencil-square-o"
													aria-hidden="true"></i> </a></td> --%>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page" /> <input
								type="hidden" value="" id="maxPageItem" name="maxPageItem" /> <input
								type="hidden" value="" id="sortName" name="sortName" /> <input
								type="hidden" value="" id="sortBy" name="sortBy" /> <input
								type="hidden" value="" id="type" name="type" /> -->
						</div>
					</div>
			</div>
		</div>

	</div>
	<script>

	$("#btnDelete").click(function() {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteNew(data);
		});

		function deleteNew(data) {
			$
					.ajax({
						url : '/myproducts',
						type : 'DELETE',
						contentType : 'application/json',
						data : JSON.stringify(data),
						success : function(result) {
							window.location.href = "/myproducts?userCart=${USERMODEL.id}";
						},
						error : function(error) {
							window.location.href = "/myproducts?userCart=${USERMODEL.id}";
						}
					});
		}
	</script>

</body>
</html>