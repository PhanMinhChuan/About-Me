<%@page import="model.User"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
      <!-- End Navbar -->
      <br /> <br /> 
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-xl-4 col-lg-12">
              <div class="card card-chart">
                <div class="card-body">
                  <a class="card-title" href="<%=request.getContextPath()%>/admin/user/index">Quản lý Người dùng</a>
                  <p class="card-category">
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">access_time</i> updated 4 minutes ago
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-4 col-lg-12">
              <div class="card card-chart">
                <div class="card-body">
                  <a class="card-title" href="<%=request.getContextPath()%>/admin/new/index">Quản lý tin tức</a>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">access_time</i> campaign sent 2 days ago
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-4 col-lg-12">
              <div class="card card-chart">
                <div class="card-body">
                  <a class="card-title" href="<%=request.getContextPath()%>/admin/contact/index">Quản lý liên hệ</a>
                </div>
                <div class="card-footer">
                  <div class="stats">
                    <i class="material-icons">access_time</i> campaign sent 2 days ago
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
    document.getElementById("index").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>
