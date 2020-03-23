<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<body class="dark-edition">
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="black" data-image="<%=request.getContextPath()%>/templates/admin/assets/img/sidebar-2.jpg">
      <div class="logo"><a href="<%=request.getContextPath()%>/admin" class="simple-text logo-normal">
          WELCOME MY ADMIN
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li  id="index"  class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin">
              <i class="material-icons">dashboard</i>
              <p>Trang Chủ</p>
            </a>
          </li>
          <li  id="category"  class="nav-item ">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/cat/index">
              <i class="material-icons">bubble_chart</i>
              <p>Danh Mục</p>
            </a>
          </li>
          <li id="book"  class="nav-item ">
            <a  class="nav-link" href="<%=request.getContextPath()%>/admin/new/index">
              <i class="material-icons">content_paste</i>
              <p>Tin Tức</p>
            </a>
          </li>
          <li  id="user"class="nav-item ">
            <a  class="nav-link" href="<%=request.getContextPath()%>/admin/user/index">
              <i class="material-icons">person</i>
              <p>User</p>
            </a>
          </li>
          <li id="contact" class="nav-item ">
            <a  class="nav-link" href="<%=request.getContextPath()%>/admin/contact/index">
              <i class="material-icons">notifications</i>
              <p>Liên Hệ</p>
            </a>
          </li>
			<li id="thongtin" class="nav-item dropdown">
				<a   class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="material-icons ">library_books</i>
                	<p>Thông Tin<span class="dropdown-toggle" style="margin-left: 20px;"></span></p>
                </a>
				<div class="dropdown-menu">
					<a  id="project" class="dropdown-item" href="<%=request.getContextPath()%>/admin/project/index" style="color:black;">Dự Án</a>
					<div class="dropdown-divider"></div>
					<a  id="profile" class="dropdown-item" href="<%=request.getContextPath()%>/admin/profile/index" style="color:black;">Thông tin Nhân Thân</a>
				</div>
			</li>
		</ul>
      </div>
    </div>
    <div class="main-panel">
	  <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top" id="navigation-example"  role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="<%=request.getContextPath()%>/admin">Trang Chủ</a>
            </div>
            <% 
            	if (session.getAttribute("userInfo") != null) {
            		User userInfo = (User) session.getAttribute("userInfo");
            %>
            <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px; margin-left: auto;"> Xin chào, 
            <b><%=userInfo.getFullname()%></b> &nbsp; <a href="<%=request.getContextPath()%>/auth/logout?msgout=out" class="btn btn-danger square-btn-adjust">Đăng xuất</a> </div>
        	<%
            	} else {
            %>
            	<div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px; margin-left: auto;">
            	<b>Xin Chào Khách!</b> &nbsp; <a href="<%=request.getContextPath()%>/auth/login" class="btn btn-danger square-btn-adjust">Login</a>	
            	</div>
            <%		
            	}
        	%>
        </nav>