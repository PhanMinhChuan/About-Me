<%@page import="model.User"%>
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
                  <h4 class="card-title">Profile Index</h4>
                  <p class="card-category">Show Your Profile</p>
                </div><br />
                <div class="card-body"><br />
					<table class="table table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Tuổi</th>
                                        <th>Ngày Sinh</th>
                                        <th>Địa Chỉ</th>
                                        <th>Picture</th>
                                        <th>Email</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
									<% 
								  		if (request.getAttribute("profile") != null) {
								  			@SuppressWarnings("unchecked")
								  			Profile profile =  (Profile) request.getAttribute("profile");
									%>
                                    <tr>
                                        <td class="center"><%=profile.getName()%></td>
                                        <td class="center"><%=profile.getTuoi() %></td>
                                        <td class="center"><%=profile.getNgaySinh()%> </td>
                                        <td class="center"><%=profile.getDiaChi()%> </td>
                                        <td class="center">
                                        	<%
                                        		if(!"".equals(profile.getPicture())) {
                                        	%>
											<img width="200px" height="200px" src="<%=request.getContextPath()%>/files/<%=profile.getPicture()%>" alt=""/>
                                        	<%
                                        		} else {
                                        	%>
	                                        	<p>Chưa có hình hiển thị</p>
	                                        <%
	                                        	}
	                                        %>
                                        </td>
                                        <td class="center"><%=profile.getEmail()%> </td>
                                        <td class="center">
                                        <%
                                    	if (session.getAttribute("userInfo") != null) {
                                    		
                                    		User userInfo = (User) session.getAttribute("userInfo");
	                                    		if ("admin".equals(userInfo.getUsername())) {
	                                    %>
	                                           		<a href="<%=request.getContextPath()%>/admin/profile/edit" title="" class="btn btn-primary"onclick="return confirm('Bạn có chắc chắn muốn Sửa không?')"><i class="fa fa-edit "></i> Sửa</a>
	                                    <%
	                                    			}
	                                            	
	                                    		}
	                                    %>	
                                        </td>
                                    </tr>
									<%
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
    document.getElementById("profile").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>