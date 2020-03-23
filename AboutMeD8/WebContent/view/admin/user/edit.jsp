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
                   <%
                            		String username = "";
                            		String password = "";
                            		String fullname = "";
                            		int id = 0;
                            		if(request.getAttribute("user") != null) {
                            			User user = (User) request.getAttribute("user");
                            			username = user.getUsername();
                            			password = user.getPassword();
                            			fullname = user.getFullname();
                            			id = user.getId();
                            	%>
                                <form action="<%=request.getContextPath()%>/admin/user/edit?id=<%=id%>" role="form" method="post" id="form">
                                        <label for="username">Username</label>
                                        <input type="text" id="name" value="<%=username%>" name="username" class="form-control" />
                                        <label for="password">Password</label>
                                        <input type="text" id="password" value="<%=password%>" name="password" class="form-control" />
                                        <label for="fullname">Fullname</label>
                                        <input type="text" id="fullname" value="<%=fullname%>" name="fullname" class="form-control" />
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
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

	<script>
    document.getElementById("user").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>
</html>