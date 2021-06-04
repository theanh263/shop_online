<%@include file="/common/taglib.jsp" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<!-- Navigation -->
		<header class="app__header">
			<div class="container">
				<div class='header-container'>
					<div class="grid__header-search__form">
						<div class="logo">
							<a href="/trang-chu">
								<img src="<c:url value='/template/image/logo.png'/>" class="logo__img logo--normal"
									style="width: 100%; object-fit: cover">
								<img src="<c:url value='/template/image/logo.png'/>" class="logo__img logo--rps"
									style="width: 100%; object-fit: cover">
							</a>
						</div>
						<form style='flex-grow: 1' action="/search" method="get">
							<div class="input__form">
								<input type="text" class="input__form-input" name="title">
								<button class="search__button" type="submit">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</form>
					</div>
					<div class='mb-menu-btn'>
						<button>
							<i class="fas fa-bars"></i>
						</button>
					</div>
					<div class="grid__header-selection">
						<ul class="grid__header-selection-options">
							<li class="selection-options-items"><a href='<c:url value="/trang-chu?category=1"/>'> <i
										class="header-selection-icon fas fa-laptop"></i> <span>LAPTOP</span>
								</a></li>
							<li class="selection-options-items"><a href='<c:url value="/trang-chu?category=2"/>'> <i
										class="header-selection-icon fas fa-mobile-alt"></i> <span>MOBILE</span>
								</a></li>
							<li class="selection-options-items"><a href='<c:url value="/trang-chu?category=3"/>'> <i
										class="header-selection-icon fas fa-headphones"></i> <span>ACCESSORIES</span>
								</a></li>
						</ul>
					</div>
					<div class="grid__header-user__about">
						<button style='border: none; background: none'>
							<c:if test="${empty USERMODEL}">
								<a href="<c:url value='/dang-nhap?action=login'/>"> <i
										class="grid__header-user__about-icon fas fa-user"></i>
								</a>

							</c:if>

							<!-- đã đăng nhập -->
							<c:if test="${not empty USERMODEL}">
								<img style='width: 40px; aspect-ratio: 1; object-fit: cover; border-radius: 50%;'
									src="<c:url value='/template/image/icon_user.jpg'/>" />
								<span style="font-weight: bold; color: white;">${USERMODEL.fullName }</span>

								<ul>
									<li><a href='<c:url value="/thoat?action=logout"/>'><i class="fas fa-sign-out-alt"></i>LOGOUT</a>
									</li>
								</ul>
							</c:if>
						</button>
						<c:if test="${not empty USERMODEL}">
							<a href="/myproducts?userCart=${USERMODEL.id }"> <i
									class="grid__header-user__about-icon fas fa-shopping-cart">
									<!-- <div class="grid__header-user__about-icon-notify"></div> -->
								</i>
							</a>
						</c:if>
					</div>
				</div>
				<div class="rps__menu-list">
					<div class="mb-menu-close-btn">
						<button>
							<i class="fas fa-times"></i>
						</button>
					</div>
					<ul class="rps-selection-options">
						<li class="rps-selection-options-items"><a href=""> <i
									class="rps-header-selection-icon fas fa-laptop"></i> <span>LAPTOP</span>
							</a></li>
						<li class="rps-selection-options-items"><a href=""> <i
									class="rps-header-selection-icon fas fa-mobile-alt"></i> <span>MOBILE</span>
							</a></li>
						<li class="rps-selection-options-items"><a href=""> <i
									class="rps-header-selection-icon fas fa-headphones"></i> <span>ACCESSORIES</span>
							</a></li>
					</ul>
					<div class="rps-boundary"></div>
					<div class="rps-user__about" style="margin-top: 24px">
						<!-- chua dang nhap -->
						<c:if test="${empty USERMODEL}">
							<a href="<c:url value='/dang-nhap?action=login'/>">
								<i class="rps-user__about-icon fas fa-user"></i>
							</a>
						</c:if>
						<!-- da dang nhap -->
						<c:if test="${not empty USERMODEL}">
							<img style='width: 40px; aspect-ratio: 1; object-fit: cover; border-radius: 50%;'
								src="<c:url value='/template/image/icon_user.jpg'/>" />
							<span style="font-weight: bold; color: white; margin:12px">${USERMODEL.fullName }</span>

							<a href="/thoat?action=logout" style="color: white"><i class="fas fa-sign-out-alt"></i>LOGOUT</a>

						</c:if>


					</div>
				</div>

				<script>
					const menuBtn = document.querySelector('.mb-menu-btn button')
					const closeMenuBtn = document.querySelector('.mb-menu-close-btn button')
					const mbMenu = document.querySelector('.rps__menu-list')

					menuBtn.addEventListener('click', () => {
						mbMenu.classList.add('active')
					})

					closeMenuBtn.addEventListener('click', () => {
						mbMenu.classList.remove('active')
					})

				</script>
			</div>
		</header>