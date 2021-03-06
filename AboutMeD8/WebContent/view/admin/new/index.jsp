<%@page import="model.New"%>
<%@page import="model.Category"%>
<%@page import="model.Contact"%>
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
                  <h4 class="card-title">Books Index</h4>
                  <p class="card-category">Show Your Books</p>
                </div>
                <br />
                <div class="card-body">
                	<div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath()%>/admin/new/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">	
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder=" Nhập tên tin tức " style="float:right; width: 300px;  background-color:#1A2035; " />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                    </div>
                    <br />
					<table class="table table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th width="270px">Tên tin tức</th>
                                        <th>Danh mục</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <th width="250px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
									<%
										if (request.getAttribute("NewList") != null) {
							  			@SuppressWarnings("unchecked")
							  			ArrayList<New> NewList =  (ArrayList<New>)request.getAttribute("NewList");
							  			if(NewList.size() > 0) {
							  				for (New item : NewList) {
							  					String  urlDel = request.getContextPath() + "/admin/new/del?id=" + item.getId();
							  					String  urlEdit = request.getContextPath() + "/admin/new/edit?id=" + item.getId();
									%>
                                    <tr>
                                        <td><%=item.getId()%></td>
                                        <td class="center"><%=item.getName()%></td>
                                        <td class="center"><%=item.getCatName()%></td>
                                        <td class="center"><%=item.getCounter()%></td>
                                        <td class="center">
                                        	<%
                                        		if(!"".equals(item.getPicture())) {
                                        	%>
											<img width="200px" height="200px" src="<%=request.getContextPath()%>/files/<%=item.getPicture()%>" alt=""/>
                                        	<%
                                        		} else {
                                        	%>
	                                        	<p>Chưa có hình hiển thị</p>
	                                        <%
	                                        	}
	                                        %>
                                        </td>
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
	                                    %>
	                                    			<a href="<%=urlEdit%>" title="" class="btn btn-primary" onclick="return confirm('Bạn có chắc chắn muốn sửa không?')"><i class="fa fa-edit "></i> Sửa</a>
	                                    <%
	                                    		}
	                                    	}
	                                    %>
                                        </td>
                                    </tr>
									<%
										}
															  			}
															  		} else if (session.getAttribute("NewListSearch") != null) {
															  			@SuppressWarnings("unchecked")
															  			ArrayList<New> NewListSearch =  (ArrayList<New>)session.getAttribute("NewListSearch");
															  			if(NewListSearch.size() > 0) {
															  				for (New item : NewListSearch) {
															  					String  urlDel = request.getContextPath() + "/admin/new/del?id=" + item.getId();
															  					String  urlEdit = request.getContextPath() + "/admin/new/edit?id=" + item.getId();
									%>		
								  			<tr>
	                                        <td><%=item.getId()%></td>
	                                        <td class="center"><%=item.getName() %></td>
	                                        <td class="center"><%=item.getCatName() %></td>
	                                        <td class="center"><%=item.getCounter() %></td>
	                                        <td class="center">
	                                        	<% 
	                                        		if(!"".equals(item.getPicture())) {
												 %>
												<img width="200px" height="200px" src="<%=request.getContextPath()%>/files/<%=item.getPicture()%>" alt=""/>
	                                        	<% 
	                                        		} else {
		                                        %>
		                                        	<p>Chưa có hình hiển thị</p>
		                                        <%
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
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ 1 đến 4 của 8 truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <%
                                            	if (request.getAttribute("numberOfPages") != null && request.getAttribute("currentPage") != null) {
                                            		int numberOfPages = (int) request.getAttribute("numberOfPages");
                                            		int currentPage = (int) request.getAttribute("currentPage");
                                            		String active = "";
                                            		String disabled1 = "";
                                            		if (currentPage <= 1) {
                                            			disabled1 = "disabled";
                                            		} else {
                                            			disabled1 = "";
                                            		}
                                           	%>
                                           		<li class="paginate_button previous <%=disabled1 %>" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/new/index?page=<%=currentPage-1%>">Trang trước</a></li>
                                           	<%
                                            		for (int i = 1; i <= numberOfPages; i++) {
                                            		
                                            			if (currentPage == i) {
                                            				active = "active";
                                            			} else {
                                            				active = "";
                                            			}
                                            %>
                                            	<li class="paginate_button <%=active %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/new/index?page=<%=i%>"><%=i %></a></li>
											<%
                                            		}
		                                           	String disabled2 = "";
		                                       		if (currentPage >= numberOfPages) {
		                                       			disabled2 = "disabled";
		                                       		} else {
		                                       			disabled2 = "";
		                                       		}
                                           	%>
                                           		<li class="paginate_button next <%=disabled2 %>" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/new/index?page=<%=currentPage + 1%>">Trang tiếp</a></li>
                                       		<%
                                            	}
                                            %>
                                        </ul>
                                    </div>
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