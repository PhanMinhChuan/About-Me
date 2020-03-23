<%@page import="model.New"%>
<%@page import="java.util.List"%>
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
                <div class="card-body">
                	<div class="row">
                        <div class="col-md-12">
                        	<%
									int id = 0;
									String name = "";
									String catName = "";
									String fileName = "";
									String decription = "";
									String detail = "";
									if (request.getAttribute("news") != null) {
										New news = (New) request.getAttribute("news");
										id = news.getId();
										name = news.getName();
										catName = news.getCatName();
										fileName = news.getPicture();
										decription = news.getPreview_text();
										detail = news.getDetail_text();
							%>
								<form action="<%=request.getContextPath()%>/admin/new/edit?id=<%=id%>&oldFileName=<%=fileName%>" role="form" method="post" id="form" enctype="multipart/form-data">
									<label for="name" style="margin-top: 30px;">Tên bài hát</label>
									<input type="text" id="name" value="<%=name%>" name="name" class="form-control" style="margin-top: 10px" required/>
									<label for="category">Danh mục bài hát</label> 
									<select id="category" name="category" class="form-control" style="margin-top: 1px">
										<%
											if (request.getAttribute("catList") != null) {
													@SuppressWarnings("unchecked")
													List<Category> catList = (List<Category>) request.getAttribute("catList");
													if (catList.size() > 0) {
														for (Category item : catList) {
															if (catName.equals(item.getName())) {
										%>
										<option value="<%=item.getId()%>" selected><%=item.getName()%></option>
										<%
											} else {
										%>
										<option value="<%=item.getId()%>"><%=item.getName()%></option>
										<%
											}
														}
													}
												}
										%>
								    </select>
								    <div class="form-group">
								    <label for="picture">Hình ảnh</label> 
								    </div>
								    <input type="file" name="picture" style="margin-bottom: 40px" required/>
									<%
										if (!"".equals(fileName)) {
									%>
									<img style="margin-top: 10px" width="130px" height="130px"
										src="<%=request.getContextPath()%>\files\<%=fileName%>" />
									<%
										} else {
									%>
									<p>Chưa có hình hiển thị</p>
									<%
										}
									%>
									<div class="form-group" style="padding-top: 35px; margin-top: 40px;">
									<label for="preview">Mô tả</label>
									<textarea id="preview" class="form-control" rows="3" name="preview" required><%=decription%></textarea>
									</div>
									<label for="detail">Chi tiết</label>
									<textarea id="detail" class="form-control" rows="35" cols="60"name="detail" required><%=detail%></textarea>
									<button type="submit" name="submit"
									
									class="btn btn-success btn-md">Sửa</button>
								</form>
								<%
									}
								%>
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