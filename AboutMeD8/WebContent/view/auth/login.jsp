<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Admin</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/css1/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="<%=request.getContextPath()%>/templates/public/css/css1/creativeLogin.css" rel="stylesheet">
</head>
<body>
	<section class="login-block">
		<div class="container">
			<div class="row">
				<div class="col-md-4 login-sec">
					<h2 class="text-center">Login Now</h2>
					<form class="login-form" action="<%=request.getContextPath()%>/auth/login" role="form" method="post" id="form">
						<div class="form-group">
							<label for="exampleInputEmail1" class="text-uppercase">Username</label>
							<input type="text" class="form-control" placeholder="" name="username">

						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="text-uppercase">Password</label>
							<input type="password" class="form-control" placeholder="" name="password">
						</div>


						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input"> <small>Remember Me</small>
							</label>
							<button type="submit" class="btn btn-login float-right">Submit</button>
						</div>

					</form>
				</div>
				<div class="col-md-8 banner-sec">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block img-fluid"
									src="https://static.pexels.com/photos/33972/pexels-photo.jpg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid"
									src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid"
									src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg"
									alt="First slide">
								<div class="carousel-caption d-none d-md-block">
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

