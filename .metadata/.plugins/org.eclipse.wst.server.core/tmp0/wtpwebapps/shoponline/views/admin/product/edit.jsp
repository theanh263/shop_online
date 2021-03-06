<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/admin-myproducts" />
<c:url var="NewURL" value="/admin-myproducts" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Chỉnh sửa sản phẩm</title>
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
					<li class="active">상품 수정</li>
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
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">종류
									</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryCode"
										name="categoryCode">
										<c:if test="${empty model.categoryCode}">
											<option value="">상품 종류 선택</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.categoryCode}">
											<option value="">상품 종류 선택</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.code}"
													<c:if
															test="${item.code == model.categoryCode}">
															selected="selected"
												</c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">상품 이름
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${model.title}" />
								</div>
							</div>
<%-- 							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Hình
									đại diện</label>
								<div class="col-sm-9">
									<input type="file" class="form-control" id="thumbnail"
										name="thumbnail" value="${model.thumbnail}" />
								</div>
							</div> --%>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">설명
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${model.shortDescription}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">상줌 정보
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="description"
										name="description" value="${model.description}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">가격
									</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" id="price" name="price"
										style="width: 820px; height: 175px">${model.price}</textarea>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">수량
									</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" id="stock" name="stock"
										style="width: 820px; height: 175px">${model.stock}</textarea>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">산업체
									</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" id="producer" name="producer"
										style="width: 820px; height: 175px">${model.producer}</textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="업데이트" id="btnAddOrUpdateProduct" />
									</c:if>
									<c:if test="${empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="상품 주가" id="btnAddOrUpdateProduct" />
									</c:if>
								</div>
							</div>
							<input type="hidden" value="${model.id}" id="id" name="id" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('description');
		});

		$('#btnAddOrUpdateProduct').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["description"] = editor.getData();
			var id = $('#id').val();
			if (id == "") {
				addProduct(data);
			} else {
				updateProduct(data);
			}
		});
		function addProduct(data) {
			$.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
/* 						window.location.href = "${NewURL}?type=edit&id="
								+ result.id + "&message=insert_success"; */
						window.location.href = "/admin-myproducts?type=list&page=1&maxPageItem=2&sortName=title&sortBy=desc";
					},
					error : function(error) {
						window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
					}
				});
		}
		function updateProduct(data) {		
			$.ajax({
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