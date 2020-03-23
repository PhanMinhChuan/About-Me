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
                        	<form action="<%=request.getContextPath()%>/admin/project/add" role="form" method="post" id="form"  enctype="multipart/form-data">
                                    <label for="name">ID</label>
                                    <br />
                                    <input type="text" id="id" value="" name="id" class="form-control" /> <br /> <br />
                                    <label for="name">Tên Project</label>
                                    <br />
                                    <input type="text" id="name" value="" name="name" class="form-control" /> <br /> <br />
                                    <label for="picture">Hình ảnh</label>
                                    <input type="file" name="picture" style="margin-bottom: 40px"/><br />
                                <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
                            </form>
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
    document.getElementById("project").classList.add('active');
	</script>
	<%@ include file="/templates/admin/inc/footer.jsp" %>