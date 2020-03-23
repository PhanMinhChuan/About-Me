<%@page import="model.Category"%>
<%@page import="model.Contact"%>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<body class="dark-edition">
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="black" data-image="<%=request.getContextPath()%>/templates/admin/assets/img/sidebar-2.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo"><a href="<%=request.getContextPath()%>/admin" class="simple-text logo-normal">
          WELLCOME MY ADMIN
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item ">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin">
              <i class="material-icons">dashboard</i>
              <p>Trang Chủ</p>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/cat/index">
              <i class="material-icons">bubble_chart</i>
              <p>Danh Mục</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/new/index">
              <i class="material-icons">content_paste</i>
              <p>Tin Tức</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/user/index">
              <i class="material-icons">person</i>
              <p>User</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/contact/index">
              <i class="material-icons">notifications</i>
              <p>Liên Hệ</p>
            </a>
          </li>
          <li class="nav-item dropdown">
				<a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="material-icons ">library_books</i>
                	<p>Thông Tin<span class="dropdown-toggle" style="margin-left: 20px;"></span></p>
                </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<%=request.getContextPath()%>/admin/project/index" style="color: black;">Dự Án</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="<%=request.getContextPath()%>/admin/profile/index" style="color: black;">Thông tin Nhân Thân</a>
				</div>
			</li>
        </ul>
      </div>
      
    </div>
    <div class="main-panel">
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top " id="navigation-example">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:void(0)">Your Categories</a>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
              <div class="card">
                <div class="card-body">
                	<div class="row">
                        <div class="col-md-12">
                                <%
                            		String name = "";
                            		int id = 0;
                            		if(request.getAttribute("cat") != null) {
                            			Category cat = (Category) request.getAttribute("cat");
                            			name = cat.getName();
                            			id = cat.getId();
                            	%>
                                <form action="<%=request.getContextPath()%>/admin/cat/edit?id=<%=id%>" role="form" method="post" id="c">
                                    <div class="form-group">
                                        <label for="name">Tên danh mục</label><br /><br />
                                        <input type="text" id="name" value="<%=name%>" name="name" class="form-control" style="width: 40%;"/>
                                    </div>
                                    <div class="form-group">
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                    </div>
                                </form>
                                <%
                                	}                                
                            	%>
                            </div>
                    </div>
                </div>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>

	<script>
    document.getElementById("category").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>
	
	
