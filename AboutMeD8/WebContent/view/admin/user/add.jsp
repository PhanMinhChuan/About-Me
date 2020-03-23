<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ include file="/templates/admin/inc/leftbar.jsp" %>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
               <div class="col-md-12">	
                   <form action="<%=request.getContextPath()%>/admin/user/add" role="form" method="post" id="form">
                         <label for="username">Username</label>
                         <input type="text" id="name" value="" name="username" class="form-control" /><br />
                         <label for="password">Password</label>
                         <input type="text" id="name" value="" name="password" class="form-control" /><br />
                         <label for="fullname">Fullname</label>
                         <input type="text" id="name" value="" name="fullname" class="form-control" /><br /><br />
                         
                        <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
                  </form>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>

	<script>
    document.getElementById("user").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>