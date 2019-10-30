<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

   <div class="row">
       <div class="col-lg-12">
           <h1 class="page-header">Board Read</h1>
       </div>
       <!-- /.col-lg-12 -->
   </div>
   <!-- /.row -->
   
   <div class="row">
       <div class="col-lg-12">
           <div class="panel panel-default">
           
               <div class="panel-heading">Board Read Page</div>
               <!-- /.panel-heading -->
               <div class="panel-body">
               		
           			<div class="form-group">
           				<label>Bno</label>
           				<input class="form-control" name='bno' value='<c:out value="${board.bno}"/>' readonly="readonly">
           			</div>
           			
           			<div class="form-group">
           				<label>Title</label>
           				<input class="form-control" name='title' value='<c:out value="${board.title}"/>' readonly="readonly">
           			</div>
           			
           			<div class="form-group">
           				<label>Text area</label>
           				<textarea class="form-control" rows="3" name='content' readonly="readonly"><c:out value="${board.content}"/></textarea>
           			</div>
           			
           			<div class="form-group">
           				<label>Writer</label>
           				<input class="form-control" name='writer' value='<c:out value="${board.writer}"/>' readonly="readonly">
           			</div>
           			
           			<button data-oper='modify' class="btn btn-default">수정</button>
           			<button data-oper='list' class="btn btn-info">목록</button>
           			
           			<form id='operForm' action="/board/modify" method="get">
           				<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
           				<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
           				<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
           				<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
           				<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
           			</form>
           			
               </div>
               <!-- /.end panel-body -->
           </div>
           <!-- /.end panel -->
       </div>
       <!-- /.col-lg-12 -->
   </div>
   <!-- /.row -->
   
    <div class="row">
       <div class="col-lg-12">
           <div class="panel panel-default">
           
               <div class="panel-heading">
               		<i class="fa fa-comments fa-fw"></i> Reply
               </div>
               <!-- /.panel-heading -->
               
               <div class="panel-body">
               		
               		<ul class="chat">
               			<!-- start reply -->
               			<li class="left clearfix" data-rno='12'>
               				<div>
               					<div class="header">
               						<strong class="primary-font">user12</strong>
               						<small class="pull-right text-muted">2019-10-30 17:38</small>
               					</div>
               					<p>이야 대단하다!</p>
               				</div>
               			</li>
               			<!-- end reply -->
               		</ul>
           			<!-- end ul -->
               </div>
               <!-- end panel-body -->
           </div>
           <!-- end panel -->
       </div>
       <!-- end col-lg-12 -->
   </div>
   <!-- end row -->
   
	<script type="text/javascript" src="/resources/js/reply.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			var bnoValue = '<c:out value="${board.bno}"/>';
			var replyUL = $(".chat");
			
			showList(1);
			
			function showList(page){
				
				replyService.getList({bno:bnoValue, page:page||1},
				function(list) {
					var str="";
					if(list == null || list.length == 0) {
						replyUL.html("");
						
						return;
					}
					
					for (var i = 0, len = list.length || 0; i < len; i++) {
						str +="<li class='left clearfix' data-rno='" + list[i].rno + "'>";
						str +="		<div><div class='header'><strong class='primary-font'>" + list[i].replyer + "</strong>";
						str +="			<small class='pull-right text-muted'>" + list[i].replyDate + "</small></div>";
						str +="			<p>" + list[i].reply + "</p></div></li>";
					}
					
					replyUL.html(str); 
					
				}); // end function
			} // end showList
		});
		
	</script>
   
	<script type="text/javascript">
   		$(document).ready(function() {
   			
   			var operForm = $("#operForm");
   			
			$("button[data-oper='modify']").on("click", function(e) {
  				
				operForm.attr("action", "/board/modify").submit();
				
			});
   			
			$("button[data-oper='list']").on("click", function(e) {
  				
				operForm.find("#bno").remove();
				operForm.attr("action", "/board/list")
				operForm.submit();
				
			});
   			
   		});
   </script>
            
<%@ include file="../includes/footer.jsp" %>