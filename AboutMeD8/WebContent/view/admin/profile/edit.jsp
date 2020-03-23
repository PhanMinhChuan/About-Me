<%@page import="model.Profile"%>
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
									String name = "";
									int tuoi = 0;
									String ngaySinh = "";
									String diaChi = "";
									String picture = "";
									String email ="";
									if (request.getAttribute("profile") != null) {
										Profile profile = (Profile) request.getAttribute("profile");
										tuoi = profile.getTuoi();
										name = profile.getName();
										ngaySinh = profile.getNgaySinh();
										diaChi = profile.getDiaChi();
										picture = profile.getPicture();
										email = profile.getEmail();
							%>
								<form action="<%=request.getContextPath()%>/admin/profile/edit?&oldFileName=<%=picture%>" role="form" method="post" id="form" enctype="multipart/form-data">
									<label for="name" style="margin-top: 30px;">Tênt</label>
									<input type="text" id="name" value="<%=name%>" name="name" class="form-control" style="margin-top: 10px" />
									<label for="category">Tuổi</label> 
									<input type="text" id="tuoi" value="<%=tuoi%>" name="tuoi" class="form-control" style="margin-top: 10px" />
									<label for="category">Ngày Sinh</label> 
									<input type="text" id="ngaysinh" value="<%=ngaySinh%>" name="ngaysinh" class="form-control" style="margin-top: 10px" />
									<label for="category">Địa Chỉ</label> 
									<input type="text" id="diachi" value="<%=tuoi%>" name="diachi" class="form-control" style="margin-top: 10px" />
								    <br /><br />
								    <label for="picture">Hình ảnh</label> 
								    <input type="file" name="picture" style="margin-bottom: 40px"/>
									<%
										if (!"".equals(picture)) {
									%>
									<img style="margin-top: 10px" width="160px" height="90px"
										src="<%=request.getContextPath()%>\files\<%=picture%>" />
									<%
										} else {
									%>
									<p>Chưa có hình hiển thị</p>
									<%
										}
									%>
									<label for="category">Email</label> 
									<input type="text" id="email" value="<%=email%>" name="email" class="form-control" style="margin-top: 10px" />
									
									
									
									<button type="submit" name="submit"
									
									class="btn btn-success btn-md">Sửa</button>
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
    document.getElementById("profile").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>