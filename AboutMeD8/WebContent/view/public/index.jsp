<!DOCTYPE html>
<%@page import="util.StringUtil"%>
<style>@import url(https://fonts.googleapis.com/css?family=Dancing+Script);</style>
<%@page import="model.Profile"%>
<%@page import="model.New"%>
<%@page import="model.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Skill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<html lang="en">
  <head>
    <title>About Me - Minh Chuẩn</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">
	
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/animate.css">
    
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/magnific-popup.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/aos.css">

    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/icomoon.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/slick-theme.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/slick.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/style.css">
    
    
    
	  <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.1.3.min.js"></script>
	  <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
	  
	  
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light site-navbar-target" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="<%=request.getContextPath() %>/trang-chu.html">Welcome</a>
	      <button class="navbar-toggler js-fh5co-nav-toggle fh5co-nav-toggle" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
		<% int idCat = 3; %>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav nav ml-auto menu-me">
	          <li class="nav-item"><a href="#home-section" class="nav-link"><span>Home</span></a></li>
	          <li class="nav-item"><a href="#about-section" class="nav-link"><span>About</span></a></li>
	          <li class="nav-item"><a href="#skills-section" class="nav-link"><span>Education</span></a></li>
	          <li class="nav-item"><a href="#projects-section" class="nav-link"><span>Projects</span></a></li>
	          <%
						//String urlSlug2 =request.getContextPath()+"/blog/msg" + "-"+ 1 + ".html";
						//String urlSlug3 =request.getContextPath()+"/blog/msg" + "-"+ 3 + ".html";
						//String urlSlug4 =request.getContextPath()+"/blog/msg" + "-"+ 4 + ".html";
			%>
			  <li class="nav-item"><a href="#blog-section" class="nav-link"><span>Books</span></a>
					<ul class="dropdown-menu" >
						<li><a class="dropdown-item" href="<%=request.getContextPath()%>/blog?msg=1">IT</a></li>
						<li><div class="dropdown-divider "></div></li>
						<li><a href="#" class="dropdown-item dropdown-toggle">Xã Hội</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Trinh Thám</a></li>
								<li><div class="dropdown-divider"></div></li>
								<li><a class="dropdown-item" href="#">Tình Cảm</a></li>
							</ul>
						</li>	
					</ul>
			  </li>
			  <li class="nav-item"><a href="#contact-section" class="nav-link"><span>Contact</span></a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath() %>/login.html" class="nav-link"><span>Login</span></a></li>
	        </ul>
	       	        <script>
						$(document).ready(function()  {
			  				$(".menu-me li").hover(function() {
			   					$(this).find("ul:first").slideDown(50);
			  				}, function() {
			  					$(this).find("ul:first").hide(0);
			  				});
			  			});
					</script>
	      </div>
	    </div>
	  </nav>
	  <section id="home-section" class="hero">
		  <div class="home-slider  owl-carousel">
	      <div class="slider-item ">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row d-md-flex no-gutters slider-text align-items-end justify-content-end" data-scrollax-parent="true">
<!-- 	          images/bg_1.jpg   <%=request.getContextPath()%>/slide.jpg-->
	          	<div class="one-third order-md-last img" style="background-image:url(<%=request.getContextPath() %>/templates/public/images/slide.jpg);">
	          		<div class="overlay"></div>
	          	</div>
		          <div class="one-forth d-flex  align-items-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
		          	<a href="https://www.youtube.com/watch?v=qUIJ5HFz5Jc" class="icon-video popup-vimeo d-flex justify-content-center align-items-center">
	    						<span class="ion-ios-play play"></span>
	    					</a>
		          	<div class="text">
		          		<span class="subheading">Hello</span>
			            <h1 class="mb-4 mt-3">I'm <span>Minh Chuan</span></h1>
			            <h2 class="mb-4">A Web Developer</h2>
			            <p><a href="<%=request.getContextPath() %>/templates/public/cv/CV.pdf" class="btn-custom" download>Doawload CV</a></p>
		            </div>
		          </div>
	        	</div>
	        </div>
	      </div>

	      <div class="slider-item">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row d-flex no-gutters slider-text align-items-end justify-content-end" data-scrollax-parent="true">
	          	<div class="one-third order-md-last img" style="background-image:url(<%=request.getContextPath() %>/templates/public/images/slide3.jpg);">
	          		<div class="overlay"></div>
	          	</div>
		          <div class="one-forth d-flex align-items-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
		          	<a href="https://www.youtube.com/watch?v=qUIJ5HFz5Jc" class="icon-video popup-vimeo d-flex justify-content-center align-items-center">
	    						<span class="ion-ios-play play"></span>
	    					</a>
		          	<div class="text">
			            <h1 class="mb-4 mt-3">Welcome my <span>Project</span></h1>
 			            <p><a href="#" class="btn-custom">Hire me</a></p> 
			            <!-- Button trigger modal -->
					</div>
		          </div>
	        	</div>
	        </div>
	      </div>
	    </div>
    </section>
	
    <section class="ftco-about ftco-counter img ftco-section" id="about-section">
    	<div class="container">
<!-- 			  <div class="col-md-12 heading-section text-center ftco-animate"> -->
<!-- 	            <h3 class="mb-4Me" style="margin-top: 50px;margin-bottom: 40px;">Personal Information</h3> -->
<!-- 	          </div>	 -->
			<br />
    		<div class="row d-flex">
    			<div class="col-md-6 col-lg-5 d-flex">
    				<div class="img-about img d-flex align-items-stretch">
    					<div class="overlay"></div>
	    				<div class="img d-flex align-self-stretch align-items-center" style="background-image:url(<%=request.getContextPath() %>/templates/public/images/anhdaidien.jpg); height: 550px;margin-right: 22px;">
	    				</div>
    				</div>
    			</div>
    			<%
						  		if (request.getAttribute("profile") != null ) {
						  	  			Profile profile =  (Profile)request.getAttribute("profile");
				%>
    			<div class="col-md-6 col-lg-7 pl-lg-5 py-5">
    				<div class="row justify-content-start pb-3">
		          <div class="col-md-12 heading-section ftco-animate">
		            <h2 class="mb-4" style="font-size: 26px;margin-top: 55px;">Mục tiêu nghề nghiệp</h2>
		            <p>Mong muốn trở thành một Web Developer, Hãy cùng tìm hiểu con đường sự nghiệp của mình nhé!</p>
		          </div>
		        </div>
		        <!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="background-color: #77B7FF;margin-top: 20px;margin-bottom: 100px;">
				  Xem Chi tiết!
				</button>
				
				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style=>
				  <div class="modal-dialog modal-lg">
				    <div class="modal-content">
<!-- 				      <div class="modal-header"> -->
<!-- 				        <h5 class="modal-title" id="exampleModalLabel">Thông Tin</h5> -->
<!-- 				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!-- 				          <span aria-hidden="true">&times;</span> -->
<!-- 				        </button> -->
<!-- 				      </div> -->
						  <div class="container-fluid">
						    <div style="padding-top : 50px;padding-bottom:60px; border: 2px dashed;">
						    		<div class="row">
							          <div class="col-8 col-sm-4">
							            <img alt="" src="<%=request.getContextPath()%>/files/<%=profile.getPicture()%>" style="width: 200px;height: 250px;"/>
							          </div>
							          <hr>
							          <div class="col-4 col-sm-8" > 
						          		<h2>
											<%=profile.getName() %>
										</h2>
										<h4 style="font-size: 1.2em; margin-top: 1em; ">Web Developer</h4>
										<hr><br/>
										<p><strong>Facebook</strong>:  facebook.com/chuan.minh.167</p>
										<p><strong>Github</strong>:  github.com/PhanMinhChuan</p>
										<p><strong>Linked</strong>:  linkedin.com/chuan-minh-739969198</p>
										<p><strong>GPA</strong>:  3.0</p>
								  	</div>
								  </div>
						    </div>
						</div>
				    </div>
				  </div>
				</div>
				<div class="row">
		        	<div class="col-md-6">
		        		<div class="media block-6 services d-block ftco-animate">
		              <div class="icon"><span class="flaticon-analysis"></span></div>
		              <div class="media-body">
		                <a class="heading mb-3" style="color: black;font-size: 18px;font-weight: 500;" href="#projects-section">My Project</a>
		              </div>
		            </div> 
		        	</div>
		        	<div class="col-md-6">
		        		<div class="media block-6 services d-block ftco-animate">
		              <div class="icon"><span class="flaticon-analysis"></span></div>
		              <div class="media-body">
		                <a class="heading mb-3" style="color: black;font-size: 18px;font-weight: 500;" href="#contact-section">Contact</a>
		              </div>
		            </div> 
		        	</div>
		        </div>
				</div>
				<%
			  		}
				%>
        </div>
    	</div>
    </section>
		
	<section class="ftco-section bg-light" id="skills-section">
		<div class="container">
			<div class="row justify-content-center pb-5">
         <div class="col-md-12 heading-section text-center ftco-animate">
           <p style="margin-bottom: 35px">Học tập là hạt giống của kiến thức, kiến thức là hạt giống của hạnh phúc.</p>
         </div>
       </div>
			<div class="row1 w3l-heading">
					<h3>Education</h3>
			</div>
			<div class="row">
					<div class="col-sm-6">
						<div class="khoi1">
							<div class="row">
								<div class="col-sm-5 work1">
									<h4>Viết CV và Tham gia phỏng vấn</h4>
									<p>Intern Java Web-BackEnd</p>
								</div>
								<div class="col-sm-5-me work2">
										<h5>03-2020</h5>
								</div>
								<div class="col-sm-2-me">
									<hr width="100%" style="margin-top: 100px;"/>
								</div>
							</div>
							<div class="row2">
								<div class="col-sm-5 work1">
									<h4>Thi JLPT</h4>
									<p>N4</p>
								</div>
								<div class="col-sm-5-me work7">
										<h5>07-2019</h5>
								</div>
								<div class="col-sm-2-me">
									<hr width="100%" style="margin-top: 120px;"/>
								</div>
							</div>
							
						</div>
					</div>
					<div class="col-sm-6">
						<div class="khoi2">
							<div class="row">
								<div class="col-sm-2-me work6">
								</div>
								<div class="col-sm-5-me work4">
									<h5>08-2019</h5>
								</div>
								<div class="col-sm-5 work5">
									<h4>Trung tâm đào tạo lập trình viên VinaENTER</h4>
									<p>Học lập trình java với spring FrameWork tại trung tâm đạo tạo lập trình viên VinaENTER</p>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-2-me work6">
								</div>
								<div class="col-sm-5-me work4">
									<h5>08-2017</h5>
								</div>
								<div class="col-sm-5 work55">
									<h4>Đại học Bách khoa Đà Nẵng</h4>
									<p>Khoa: Công nghệ thông tin</p>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
	</section>
	
	<section class="ftco-section ftco-project" id="projects-section">
    	<div class="container">
    		<div class="row justify-content-center pb-5">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<span class="subheading">project </span>
            <h2 class="mb-4">My Projects</h2>
            <p>Học tập là hạt giống của kiến thức, kiến thức là hạt giống của hạnh phúc.</p>
          </div>
        </div>
    		<div class="row">
    			<%
			  		if (request.getAttribute("projectList") != null ) {
			  	  			@SuppressWarnings("unchecked")
			  	  			ArrayList<Project> projectList =  (ArrayList<Project>)request.getAttribute("projectList");
			  	  			if(projectList.size() > 0) {
			  	  				int i = 0;
			  	%>
    			<div class="col-md-8">
    				<div class="project img ftco-animate img-2 d-flex justify-content-center align-items-center" style="background-image: url(<%=request.getContextPath() %>/templates/public/images/bsong.jpeg);">
    					<div class="overlay"></div>
	    				<div class="text text-center p-4">
	    					<h3><a href="<%=request.getContextPath() %>/index"><%=projectList.get(0).getName() %></a></h3>
	    					<span>Web Design</span>
	    				</div>
    				</div>
    			</div>
    			<div class="col-md-4">
    				<div class="row">
    					<div class="col-md-12">
		    				<div class="project img ftco-animate d-flex justify-content-center align-items-center" style="background-image: url(<%=request.getContextPath() %>/templates/public/images/CV.jpg); ">
		    					<div class="overlay"></div>
			    				<div class="text text-center p-4">
			    					<h3><a href="<%=request.getContextPath() %>/index"><%=projectList.get(1).getName() %></a></h3>
			    					<span>Web Design</span>
			    				</div>
		    				</div>
	    				</div>
	    				<div class="col-md-12">
		    				<div class="project img ftco-animate d-flex justify-content-center align-items-center" style="background-image: url(<%=request.getContextPath() %>/templates/public/images/QHTT.jpg);">
		    					<div class="overlay"></div>
			    				<div class="text text-center p-4">
			    					<h3><a href="<%=request.getContextPath()%>/templates/public/cv/SimpleMethod.cpp" download><%=projectList.get(2).getName() %></a></h3>
			    					<span>Application</span>
			    				</div>
		    				</div>
	    				</div>
    				</div>
    			</div>
<!--     			<div class="col-md-12"> -->
<%--     				<div class="project img ftco-animate d-flex justify-content-center align-items-center" style="background-image: url(<%=request.getContextPath() %>/templates/public/images/CV.jpg);"> --%>
<!--     					<div class="overlay"></div> -->
<!-- 	    				<div class="text text-center p-4"> -->
<%-- 	    					<h3><a href="#"><%=projectList.get(3).getName() %></a></h3> --%>
<!-- 	    					<span>Web Design</span> -->
<!-- 	    				</div> -->
<!--     				</div> -->
<!--   				</div> -->
    		</div>
    		<%						
					  			}
					  		}
				%>
    	</div>
    </section>
    
	<section class="ftco-section bg-light" id="blog-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <span class="subheading">Books</span>
            <h2 class="mb-4">My Books</h2>
            <p>Học tập là hạt giống của kiến thức, kiến thức là hạt giống của hạnh phúc.</p>
          </div>
        </div>
		<section class="regular slider">
			<%
			
				if (request.getAttribute("newList") != null) {
					@SuppressWarnings("unchecked")
					ArrayList<New> newList = (ArrayList<New>) request.getAttribute("newList");
					if (newList.size() > 0) {
						for (New item : newList) {
							String urlSlug =request.getContextPath()+"/blog/"+StringUtil.makeSlug(item.getName())+"-"+item.getId()+"-"+item.getCat_id()+".html";
			%>
			<div>
<%-- 				 <a href="<%=request.getContextPath() %>/blog?id=<%=item.getId()%>&idCat=<%=item.getCat_id()%>" class="block-20" style="background-image: url('<%=request.getContextPath()%>/files/<%=item.getPicture()%>');"></a> --%>
				 	
				 	<a href="<%=urlSlug%>" class="block-20" style="background-image: url('<%=request.getContextPath()%>/files/<%=item.getPicture()%>');"></a>
				 <div class="text mt-3 d-block">
	                <p><span style="color: black"><%=item.getCatName() %></span></p>
	             </div>
			</div>
			<%
				}
					}
				}
			%>
		</section>
		</div>

    </section>

    <section class="ftco-section contact-section ftco-no-pb" id="contact-section">
      <div class="container">
      	<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <span class="subheading">Contact</span>
            <h2 class="mb-4">Contact Me</h2>
            <p>Học tập là hạt giống của kiến thức, kiến thức là hạt giống của hạnh phúc.</p>
          </div>
        </div>

        <div class="row no-gutters block-9">
          <div class="col-md-6 order-md-last d-flex">
			<script>
					$(document).ready(function()  {
						$("#register-form").validate({
							rules: {
								name: {
									required: true
								},
								email: {
									required: true,
									email:true
								},
								message: {
									required: true
								},
							},
							messages: {
								name: {
									required:"<p style='color:red'> Vui lòng nhập Tên!</p>",
								},
								email: {
									required:"<p style='color:red'> Vui lòng nhập Email!</p>",
									email:"<p style='color:red'> Xin nhập đúng định dạng Email!</p>"
								},
								message: {
									required:"<p style='color:red'> Vui lòng nhập tin nhắn của bạn!</p>",
								}
								}
							});
					});
			</script>
			<form action="<%=request.getContextPath() %>/contact" id="register-form" class="bg-light p-4 p-md-5 contact-form" role="form" method="post" >
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Your Name (*)" name="name" id= "name" >
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Your Email (*)" name="email"  id= "email">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Subject" name="subject"   id= "subject" >
              </div>
              <div class="form-group">
                <textarea cols="30" rows="7" class="form-control" placeholder="Message (*)" name="message"  id= "message" ></textarea>
              </div>
              <div class="form-group">
                <input type="submit" value="Send Message" class="btn btn-primary py-3 px-5" onclick="myFunction()">
              </div>
            </form>
            <%
			  		if (request.getParameter("msg") != null ) {
			%>
					<script>
				  		alert("Lời nhắn của bạn đã đến với tôi!");
					</script>
			<% 
			  		}
			%>
          </div>
		  <%
			  		if (request.getAttribute("profile") != null ) {
			  	  			Profile profile =  (Profile)request.getAttribute("profile");
		  %>	
          <div class="col-md-6 d-flex">
          	<div class="img" style="background-image: url(<%=request.getContextPath()%>/files/<%=profile.getPicture()%>);width: 380px; margin-left: 110px;"></div>
          </div>
          <%
					}
		  %>
        </div>
      </div>
    </section>

    <footer class="ftco-footer ftco-section">
      <div class="container">
        <div class="row mb-5">
<!--           <div class="col-md"> -->
<!--             <div class="ftco-footer-widget mb-4 ml-md-4"> -->
<!--               <h2 class="ftco-heading-2">Links</h2> -->
<!--               <ul class="list-unstyled"> -->
<!--                 <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Home</a></li> -->
<!--                 <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>About</a></li> -->
<!--                 <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Services</a></li> -->
<!--                 <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Projects</a></li> -->
<!--                 <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Contact</a></li> -->
<!--               </ul> -->
<!--               <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5"> -->
<!--                 <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li> -->
<!--                 <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li> -->
<!--                 <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li> -->
<!--               </ul> -->
<!--             </div> -->
<!--           </div> -->
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><a href="#"><span class="icon icon-map-marker"></span><span class="text">235 Tran Quy Khoach, Lieu Chieu, Da Nang</span></a></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+84 859 743 442</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">minhchuan.me@gmail.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
              	<li class="ftco-animate"><a href="https://www.facebook.com/chuan.minh.167"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href=""><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </footer>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/popper.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.easing.1.3.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.waypoints.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.stellar.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/owl.carousel.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.magnific-popup.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/aos.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.animateNumber.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/scrollax.min.js"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/main.js"></script>
  <script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/slick.js" type="text/javascript" charset="utf-8"></script>
  <script src="https://code.jquery.com/jquery-2.2.0.min.js" ></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/slick.js" ></script>
  <script src="<%=request.getContextPath() %>/templates/public/js/jquery.validate.min.js"></script>
  <script type="text/javascript">
    $(document).on('ready', function() {
      $(".regular").slick({
        dots: true,
        infinite: true,
        centerMode: true,
        slidesToShow: 3,
        slidesToScroll: 3
      });
    });
</script>
  </body>
</html>