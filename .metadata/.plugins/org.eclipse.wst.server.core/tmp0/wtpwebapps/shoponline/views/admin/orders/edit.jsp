<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/admin-myproducts" />
<c:url var="NewURL" value="/admin-myproducts" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>주문 정보</title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="/admin-myproducts">Home Page</a></li>
					<li class="active">주문 정보</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">${messageResponse}</div>
						</c:if>
						<form id="formSubmit">
							<c:forEach var="item" items="${model.listResult}">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">상품 이름
										</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="title"
											name="title" value="${item.productName}" />
									</div>
								</div>
								<br />
								<br />
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right">수량
										</label>
									<div class="col-sm-9">
										<textarea rows="" cols="" id="stock" name="stock"
											style="width: 820px; height: 175px">${item.quantity}</textarea>
									</div>
								</div>
							</c:forEach>
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty item.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="업데이트" id="btnAddOrUpdateProduct" />
									</c:if>
									<c:if test="${empty item.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="상품 주가" id="btnAddOrUpdateProduct" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${item.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>

		$('#btnAddOrUpdateProduct').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#id').val();
			if (id == "") {
				addProduct(data);
			} else {
				updateProduct(data);
			}
		});
		function addProduct(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${NewURL}?type=edit&id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
						}
					});
		}
		function updateProduct(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${NewURL}?type=edit&id="
									+ result.id + "&message=update_success";
						},
						error : function(error) {
							window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
						}
					});
		}
	</script>
</body>

</html>