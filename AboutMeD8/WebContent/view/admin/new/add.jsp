<%@page import="java.util.List"%>
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
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/admin/cat/index">
              <i class="material-icons">bubble_chart</i>
              <p>Danh Mục</p>
            </a>
          </li>
          <li class="nav-item active">
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
					<a class="dropdown-item" href="<%=request.getContextPath()%>/admin/project/index">Dự Án</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="<%=request.getContextPath()%>/admin/profile/index">Thông tin Nhân Thân</a>
				</div>
				
			</li>
        </ul>
      </div>
      
    </div>
    <div class="main-panel">
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top " id="navigation-example">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:void(0)">Your News</a>
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
                        	<form action="<%=request.getContextPath()%>/admin/new/add" role="form" method="post" enctype="multipart/form-data" id="form">
                                        <label for="name" style="margin-top: 30px;">Tên bài hát</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" style="margin-top: 10px" required /><br /> 
                                        <label for="category">Danh mục bài hát</label>
                                        <select id="category" name="category" class="form-control" style="margin-top: 1px" >
                                        	<% 
                                        		if (request.getAttribute("catList") != null) {
        								  			@SuppressWarnings("unchecked")
                                        			List<Category> catList = (List<Category>) request.getAttribute("catList");
                                        			if (catList.size()> 0) {
                                        				for(Category item : catList) {
                                        	%>
                                        					<option value="<%=item.getId() %>"><%=item.getName() %></option>
                							<%
                                        				}
                                        				
                                        			}
                                        		}
                                        	%>
                                        </select>
                                    <br /><br />
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" style="margin-bottom: 40px"/><br />
                                        <label for="preview">Mô tả</label>
                                        <textarea id="preview" class="form-control" rows="3" name="preview"></textarea>
                                        <label for="detail">Chi tiết</label>
                                        <textarea id="detail" class="form-control" id="detail" rows="5" name="detail" required></textarea>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
                                </form>
                                <script type="text/javascript">
									var editor = '';
									$(document).ready(function() {
										editor = CKEDITOR.replace('detail');
									});
								</script>
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
    document.getElementById("book").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>