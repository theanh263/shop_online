<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div id='sign'>
		<div class='form-container'>
			<div class="form-header">
				<button class='login active'>Login</button>
				<button class='register'>Register</button>
			</div>
			<div class='login-form active'>
				<form method="POST" action="<c:url value='/dang-nhap'/>" id="formLogin">
					<label for='userName'>Username</label>
					 <input required type="text"name='userName' id='userName' placeholder="Enter your username">
					<label for='password'>Password</label> 
					<input required type="password" name='password' id='password' placeholder="******">
						<input type="hidden" value="login" name="action"/>
					<button type='submit'>Login</button>
				</form>
			</div>
			<div class='register-form'>
				<form method="POST" action="<c:url value='/dang-ky'/>">
					<label for='fullName'>Fullname</label>  
					<input required type="text" name='fullName' id='fullName' placeholder="Enter your fullname">
					<label for='userName'>Email</label> 
					<input required type="text" name='userName' id='userName' placeholder="Enter your email"> <label
						for='password'>Password</label>
						 <input required type="password" name='password' id='password' placeholder="******"> <label
						for='confirmpassword'>Confirm password</label> 
						<input required type="confirmpassword" name='confirmpassword' id='confirmpassword' placeholder="******">
						<input type="hidden" value="register" name="action"/>
					<button type='submit'>Register</button>
				</form>
			</div>
			<hr />
			<div class='third-auth'>
				<button style='color: blue'>Facebook</button>
				<button style='color: orange'>Google</button>
			</div>
		</div>
	</div>

	<script>
    const changeLoginBtn = document.querySelector('#sign .form-container .form-header button.login')
    const changeRegisterBtn = document.querySelector('#sign .form-container .form-header button.register')
    const loginForm = document.querySelector('#sign .form-container .login-form')
    const registerForm = document.querySelector('#sign .form-container .register-form')

    changeLoginBtn.addEventListener('click', () => {
      changeLoginBtn.classList.add('active')
      loginForm.classList.add('active')

      registerForm.classList.remove('active')
      changeRegisterBtn.classList.remove('active')
    })

    changeRegisterBtn.addEventListener('click', () => {
      changeRegisterBtn.classList.add('active')
      registerForm.classList.add('active')

      loginForm.classList.remove('active')
      changeLoginBtn.classList.remove('active')
    })
  </script>
</body>
</html>