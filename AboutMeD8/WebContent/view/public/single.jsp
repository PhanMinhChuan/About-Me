<!DOCTYPE html>
<%@page import="util.StringUtil"%>
<%@page import="model.Category"%>
<%@page import="model.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Profile"%>
<%@page import="model.New"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<html lang="en">
  <head>
    <title>About Me - Books</title>
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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/style.css">
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
	  
	  
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light site-navbar-target" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="#">WELCOME</a>
	      <button class="navbar-toggler js-fh5co-nav-toggle fh5co-nav-toggle" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav nav ml-auto">
	          <li class="nav-item"><a href="<%=request.getContextPath() %>/index" class="nav-link"><span>Home</span></a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath() %>/auth/login" class="nav-link"><span>Login</span></a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>

	  <section class="hero-wrap hero-wrap-2" style="background-image: url('<%=request.getContextPath() %>/templates/public/images/bg_4.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate padding-me text-center">
            <h1 class="mb-3 bread">Books</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="#">Home <i class="ion-ios-arrow-forward"></i></a></span> <span class="mr-2"><a href="#">Books <i class="ion-ios-arrow-forward"></i></a></span> <span>Book Single <i class="ion-ios-arrow-forward"></i></span></p>
          </div>
        </div>
      </div>
    </section>
		

    <section class="ftco-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 ftco-animate">
          <%
				if (request.getAttribute("newSearchList") != null) {
		  			@SuppressWarnings("unchecked")
		  				ArrayList<New> newSearchList =  (ArrayList<New>)request.getAttribute("newSearchList");
		  					if(newSearchList.size() > 0) {	
		  						for (New item : newSearchList) {
		  							String urlSlug =request.getContextPath()+"/blog/"+StringUtil.makeSlug(item.getName())+"-"+item.getId()+"-"+item.getCat_id()+".html";
			%>
					<div class="about-author d-flex p-4 bg-light">
						<div class="bio mr-5">
							<a href="<%=urlSlug%>" class="block-20" style="background-image: url('<%=request.getContextPath()%>/files/<%=item.getPicture()%>'); width:200px; height: 206px;"></a>	
						</div>
						<div class="desc">
							<h5 class="heading" style="margin-top: 20px;"><a href="<%=urlSlug%>" style="color: chocolate;"><%=item.getName()%></a></h5>
						</div>
					</div>
			<%
							}
						} else {
			%>
						<p>Không tìm thấy cuốn sách nào cả!</p>
			<%				
						}
				} else if (request.getAttribute("newListCat") != null) {
		  			@SuppressWarnings("unchecked")
		  				ArrayList<New> newListCat =  (ArrayList<New>)request.getAttribute("newListCat");
		  					if(newListCat.size() > 0) {	
		  						for (New item : newListCat) {
		  							String urlSlug =request.getContextPath()+"/blog/"+StringUtil.makeSlug(item.getName())+"-"+item.getId()+"-"+item.getCat_id()+".html";
			%>
					<div class="about-author d-flex p-4 bg-light">
						<div class="bio mr-5">
							<a href="<%=urlSlug%>" class="block-20" style="background-image: url('<%=request.getContextPath()%>/files/<%=item.getPicture()%>'); width:200px; height: 206px;"></a>	
						</div>
						<div class="desc">
							<h5 class="heading" style="margin-top: 20px;"><a href="<%=urlSlug%>" style="color: chocolate;"><%=item.getName()%></a></h5>
						</div>
					</div>
			<%
							}
						}
					} else {
			          	if (request.getAttribute("new") != null ) {
						  	  			New news =  (New)request.getAttribute("new");
					%>
		            <h2 class="mb-3"><%=news.getName() %></h2>
		            <p><%=news.getPreview_text() %></p>
		            <p>
		              <img src="<%=request.getContextPath()%>/files/<%=news.getPicture()%>" alt="" class="img-fluid">
		            </p>
		            <p><%=news.getDetail_text() %></p>
		            <%} %>
		            <div class="tag-widget post-tag-container mb-5-me mt-5-me">
		              <div class="tagcloud">
		                <a href="#" class="tag-cloud-link">Tác Giả</a>
		              </div>
		            </div>
		            <%
			          	if (request.getAttribute("profile") != null ) {
							Profile profile =  (Profile)	request.getAttribute("profile");	 
			         %>
		            <div class="about-author d-flex p-4 bg-light">
		              <div class="bio mr-5">
		                <img src="<%=request.getContextPath()%>/files/<%=profile.getPicture()%> " style="width: 100px;" alt="Image placeholder" class="img-fluid mb-4">
		              </div>
		              <div class="desc">
		                <h3><%=profile.getName() %></h3>
		                <p><%=profile.getEmail() %></p>
		              </div>
		            </div>
		            <%} %>
		            <div class="pt-5 mt-5">
		            <%
				          	if (request.getAttribute("new") != null ) {
							  	  			New news =  (New)request.getAttribute("new");
		            %>
		          	<h3 class="mb-5-me">Tham Gia comment</h3>
		              <form action="javascript:void(0)" class="p-5 bg-light" >
		                <div class="form-group">
		                  <label for="name">Name *</label>
		                  <input type="text" class="form-control-me workwork " id="username" required  >
		                </div>
		                <div class="form-group">
		                  <label for="message">Message *</label>
		                  <textarea name="" id="message" cols="30" rows="10" class="form-control-me"  required></textarea>
		                </div>
		                <div class="form-group">
		                  <input type="submit" value="Gửi Comment" class="btn py-3 px-4 btn-primary workwork1" onclick="comment(<%=news.getId()%>)">
		                </div>

		              </form> 
		              	 <script type="text/javascript">
							function comment(idNew) {
								var username =  $("#username").val();
								var email =  $("#email").val();
								var message = $("#message").val();
								$.ajax({
									
									url: '<%=request.getContextPath()%>/blog', 
									type: 'POST',	// GET	,required: bắt buộc có 		duong_dan_file_servlet_xu_ly
									cache: false,	//Truyền biến đi không lưu (optional : không bắt buộc có, mặc định là true)
									data: { 		//những biến được gửi đi vào file servlet và cũng là optional
										username: username,		//KEY:VALUE 
										email: email,
										message: message,
										idNew: idNew
									},
									success: function(data){	//optional
										$("#comment-list").html(data);
									},
									error: function (){			//optional
										alert('Có lỗi xảy ra');
									}
								});
								return false;
							}
						</script>
						<%} %>
		              <h3 class="mb-5 workwork2" >6 Comments</h3>
		              <ul id="comment-list" class="comment-list"></ul>
		               <%
				              		if (session.getAttribute("commentList") != null) {
						  			@SuppressWarnings("unchecked")
						  				ArrayList<Comment> commentList =  (ArrayList<Comment>)session.getAttribute("commentList");
						  					if(commentList.size() > 0) {	
						  						for (Comment item : commentList) {
				         %>
		              <ul class="comment-list">
		                <li class="comment">
		                  <div class="vcard bio">
		                    <img src="<%=request.getContextPath() %>/templates/public/images/person_1.jpg"  alt="Image placeholder">
		                  </div>
		                  <div class="comment-body">
		                    <h3><%=item.getName()%></h3>
		                    <div class="meta"><%=item.getDateCreate() %></div>
		                    <p><%=item.getMessage()%></p>	
		                    <p><a href="#" class="reply">Reply</a></p>
		                  </div>
		                 </li>
		              </ul>
					   <%
						  		}}}
		               %>
		            </div>
		            <% } %>

		          </div> <!-- .col-md-8 -->
		          <div class="col-lg-4 sidebar ftco-animate">
		            <div class="sidebar-box">
<%-- 		              <form action="<%=request.getContextPath()%>/blog?search=<%=s %>" class="search-form" method="GET"> --%>
<!-- 		                <div class="form-group"> -->
<!-- 		                  <span class="icon icon-search"></span> -->
<!-- 		                  <input type="text" class="form-control" placeholder="Nhập tên sách bạn muốn tìm!" id="searchname"> -->
<!-- 		                </div> -->
<!-- 		              </form> -->
 					  <form action="<%=request.getContextPath()%>/blog?search=1" class="search-form" method="GET">
 					  	 <div class="form-group">
						    <span class="icon icon-search"></span>
						    <input name="editbox_search" class="form-control" id="editbox_search" placeholder="Nhập tên sách bạn muốn tìm!" type="text" />
					    </div>
					  </form>
		            </div>
            <div class="sidebar-box ftco-animate">
            	<h3 class="heading-sidebar">Categories</h3>
              <ul class="categories">
              	<%
					if (session.getAttribute("catList") != null) {
						@SuppressWarnings("unchecked")
						ArrayList<Category> catList = (ArrayList<Category>) session.getAttribute("catList");
						if (catList.size() > 0) {
							for (Category item : catList) {
								String urlSlug2 =request.getContextPath()+"/blog/messeger" + "-"+ item.getId() + ".html";
				%>
                	<li id="<%=item.getId()%>"><a href="<%=urlSlug2%>" style="margin-left: 20px;"><%=item.getName()%></a></li>
                <%
					}}}
				%>
              </ul>
            </div>
			<%
					if (request.getParameter("idCat") != null || request.getParameter("msg") != null) {
						String idCat = request.getParameter("idCat");
						String msg = request.getParameter("msg");
						if (idCat != null ){
							if (Integer.parseInt(idCat) == 1){
			%>
							<script>
		    					document.getElementById("1").classList.add('active-menu');
							</script>
			<%				
							}
						if (Integer.parseInt(idCat) == 2){
							%>
											<script>
						    					document.getElementById("2").classList.add('active-menu');
											</script>
							<%				
											}
						if (Integer.parseInt(idCat) == 3){
							%>
											<script>
						    					document.getElementById("3").classList.add('active-menu');
											</script>
							<%				
											}
						if (Integer.parseInt(idCat) == 4){
							%>
											<script>
						    					document.getElementById("4").classList.add('active-menu');
											</script>
							<%				
											}
						} 
						if (msg != null ){
							if (Integer.parseInt(msg) == 1){
			%>
							<script>
		    					document.getElementById("1").classList.add('active-menu');
							</script>
			<%				
							}
						if (Integer.parseInt(msg) == 2){
							%>
											<script>
						    					document.getElementById("2").classList.add('active-menu');
											</script>
							<%				
											}
						if (Integer.parseInt(msg) == 3){
							%>
											<script>
						    					document.getElementById("3").classList.add('active-menu');
											</script>
							<%				
											}
						if (Integer.parseInt(msg) == 4){
							%>
											<script>
						    					document.getElementById("4").classList.add('active-menu');
											</script>
							<%				
											}
						} 
					}
			
			%>

            <div class="sidebar-box ftco-animate">
              <%
			  		if (request.getAttribute("newList") != null ) {
			  %>
			  	<h3 class="heading-sidebar">Những Cuốn Sách Liên Quan</h3>
			  <%
			  	  			@SuppressWarnings("unchecked")
			  	  			ArrayList<New> newList =  (ArrayList<New>)request.getAttribute("newList");
			  	  			if(newList.size() > 0) {
									for (New item : newList) {	
										String urlSlug =request.getContextPath()+"/blog/"+StringUtil.makeSlug(item.getName())+"-"+item.getId()+"-"+item.getCat_id()+".html";
			  %>
              <div class="block-21 mb-4 d-flex">
                <a href="<%=urlSlug %>" class="blog-img mr-4 block-20" style="background-image: url('<%=request.getContextPath()%>/files/<%=item.getPicture()%>');"></a>
                <div class="text">
                  <h3 class="heading"><a href="<%=urlSlug%>"><%=item.getName()%></a></h3>
                  <div class="meta">
                    <div><a href="#"><span class="icon-calendar"></span> March 12, 2019</a></div>
                    <div><a href="#"><span class="icon-person"></span> Admin</a></div>
                    <div><a href="#"><span class="icon-chat"></span> <%=item.getCounter() %></a></div>
                  </div>
                </div>
              </div>
              <%
					}}}
			  %>
            </div>
            <div class="sidebar-box ftco-animate">
              <h3 class="heading-sidebar">Gustavơ Lebon</h3>
              <p>Một cuốn sách hay cho ta một điều tốt, Một người bạn tốt cho ta một điều hay!</p>
            </div>
            <div class="sidebar-box ftco-animate">
              <h3 class="heading-sidebar">Mark Twain</h3>
              <p>A person who won’t read has no advantage over one who can’t read.</p>
            </div>
            <div class="sidebar-box ftco-animate">
              <h3 class="heading-sidebar">Louisa May Alcott</h3>
              <p>Sách hay, cũng như bạn tốt, ít và được chọn lựa; chọn lựa càng nhiều, thưởng thức càng nhiều.</p>
            </div>
          </div>

        </div>
      </div>
    </section> <!-- .section -->
		
         <footer class="ftco-footer ftco-section">
      <div class="container">
        <div class="row mb-5">
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
    
  </body>
</html>