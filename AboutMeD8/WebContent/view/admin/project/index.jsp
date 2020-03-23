<%@page import="model.User"%>
<%@page import="model.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Profile"%>
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
                  <h4 class="card-title">Project Project</h4>
                  <p class="card-category">Show Your Project</p>
                </div><br />
                <div class="card-body">
                	<div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath()%>/admin/project/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">	
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder=" Nhập tên dự án" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                    </div><br />
					<table class="table table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Picture</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
									<% 
								  		if (request.getAttribute("projectList") != null) {
								  			@SuppressWarnings("unchecked")
								  			ArrayList<Project> projectList =  (ArrayList<Project>) request.getAttribute("projectList");
								  			if(projectList.size() > 0) {
								  				for (Project item : projectList) {
								  					String  urlDel = request.getContextPath() + "/admin/project/del?id=" + item.getId();
									%>
                                    <tr>
                                        <td><%=item.getId() %></td>
                                        <td class="center"><%=item.getName() %></td>
                                        <td class="center"><%=item.getPicture() %></td>
                                        <td class="center" width="50px">
                                         <%
	                                    	if (session.getAttribute("userInfo") != null) {
	                                    		
	                                    		User userInfo = (User) session.getAttribute("userInfo");
		                                    		if ("admin".equals(userInfo.getUsername())) {
		                                    %>
		                                           		<a href="<%=urlDel%>" title="" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không?')"><i class="fa fa-pencil"></i> Xóa</a>
		                                    <%
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
    document.getElementById("project").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>