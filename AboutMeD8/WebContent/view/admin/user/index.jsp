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
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">User Index</h4>
                  <p class="card-category">Show Your User (Blog)</p>
                </div>
                <br />
                <div class="card-body">
                	<div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath()%>/admin/user/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">	
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right;" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập Tên User" style="float:right; width: 300px; background-color:#1A2035; " />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                    </div>
                    <br />
					<table class="table table-bordered table-hover" id="dataTables-example">
		                         <thead>
		                             <tr>
		                                 <th>ID</th>
		                                 <th>Tên Người Dùng</th>
		                                 <th>Fullname</th>
		                                 <th width="260px">Chức năng</th>
		                             </tr>
		                         </thead>
		                         <tbody>
				<% 
			  		if (request.getAttribute("userList") != null) {
			  			@SuppressWarnings("unchecked")
			  			ArrayList<User> userList =  (ArrayList<User>) request.getAttribute("userList");
			  			if(userList.size() > 0) {
			  				for (User item : userList) {
			  					String  urlDel = request.getContextPath() + "/admin/user/del?id=" + item.getId();
			  					String  urlEdit = request.getContextPath() + "/admin/user/edit?id=" + item.getId();
				%>
		                             <tr>
		                                 <td><%=item.getId() %></td>
		                                 <td class="center"><%=item.getUsername() %></td>
		                                 <td class="center"><%=item.getFullname()%></td>
		                                 <td class="center">
		                             <%
                                    	if (session.getAttribute("userInfo") != null) {
                                    		
                                    		User userInfo = (User) session.getAttribute("userInfo");
                                    		if ("admin".equals(userInfo.getUsername())) {
                                    %>
                                           		<a href="<%=urlEdit%>" title="" class="btn btn-primary" onclick="return confirm('Bạn có chắc chắn muốn sửa không?')"><i class="fa fa-edit "></i> Sửa</a>
                                    			<a href="<%=urlDel%>" title="" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')"><i class="fa fa-pencil"></i> Xóa</a>
                                    <%
                                    		} else {
                                    			if (item.getId() == userInfo.getId()) {
                                    %>
                                    			<a href="<%=urlEdit%>" title="" class="btn btn-primary" onclick="return confirm('Bạn có chắc chắn muốn sửa không?')"><i class="fa fa-edit "></i> Sửa</a>
                                    <%
                                    			}
                                    		}
                                    	}
                                    %>
		                                 </td>
		                             </tr>
				<%
			  				}
			  			}
			  		}
			  	%>                                    
		                         </tbody>
		                     </table>
                </div>
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