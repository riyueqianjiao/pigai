<%
request.setAttribute("CURRENTUSER", request.getSession().getAttribute("user"));
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/init.jsp"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程管理</title>
<%@include file="../common/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/course.js"></script>
</head>
<body>
	
<div class="w1000">

    <jsp:include page="../common/navigation.jsp" /> 
	  
   
     <div class="cont">
    	<div class="current-position" >
            <span class="font14" > 当前位置：<a  href="${pageContext.request.contextPath }/">首页</a> &gt;&gt; 课程</span>   
        </div>
     
    	<div class="repair_con mt10">
    	<div class="repair_title">
        	<ul>
            	<li class="current cur">课程列表</li>
            </ul>
           </div>
        
          <form id="form" action="${pageContext.request.contextPath}/course" method="post">
          <div class="repair_main">
              <div class="repair_search">         
                    课程名称：<input type="text" name="courseName" value="${courseCriteria.courseName }" class="repair_text"/>
                    创建老师：<input type="text" name="teacherName" value="${courseCriteria.teacherName }" class="repair_text"/>
                 <input type="button" value="搜索" onclick="$('#form').submit();"class="att_button" style="margin: 0"/>
                </div>
                
                    <div class="att_table">
            	 <table width="100%" align="center" class="tb_list" border="0" cellspacing="0" cellpadding="0">
                 	<tbody>
                    	<tr>
                    	<td class="f_1" width="15%">课程id</td>
                        	<td class="f_1" width="25%">课程名称</td>
                           <td class="f_1" width="15%">教师</td>
                           <td class="f_1" width="15%">创建时间</td>
                           <td class="f_1" colspan="3" width="15%">操作</td>
                        </tr>
                        
                      <c:if test="${empty pageModel.pageData }">
              	 <tr class="select" >
              	 	<td colspan="8"><li style="color: gray;text-align: center;">没有相关信息</li></td>
              	 </tr>
              </c:if>
              <c:forEach items="${pageModel.pageData }" var="course" varStatus="status">
               <tr<c:if test="${status.index % 2 == 1}"> class="row"</c:if>> 
               <td class="f_2">${course.courseId }</td>
               <td class="f_2">${course.courseName }</td>
               <td class="f_2">${course.teacherName }</td>
               <td class="f_2"><fmt:formatDate value="${course.time }"
											pattern="yyyy-MM-dd HH:mm" /></td>
                                  	                                                   	                    								                  
                    	<td class="f_2">                                                        	                                                       
                            	<a href="javascript:void(0);"onclick="goWithUrl('${pageContext.request.contextPath }/course/add?id=${course.courseId}');"  title="编辑"><img src="${pageContext.request.contextPath }/images/edit.png" width="16" height="16" style="margin-right: 10px;" alt=""/></a>
                            	<a href="javascript:void(0);" onclick="delCourse('${course.courseId}');" title="删除"><img src="${pageContext.request.contextPath }/images/del.png" width="16" height="16" alt=""/></a>                            
                            	<a href="javascript:void(0);" onclick="goWithUrl('${pageContext.request.contextPath }/course/detail/${course.courseId}');">查看</a>                            	                            	
                            </td>                            
                        </tr>   
             </c:forEach>
                                             
                    </tbody>
                 </table>
            </div>
                </div></form>
          
            <div class="pager-area" >
        	<pg:pager url="${pageContext.request.contextPath}/course" items="${pageModel.totalRecord}"
					maxIndexPages="10" export="currentPageNumber=pageNumber" maxPageItems="${pageModel.pageSize}">
					<pg:param name="courseName" value="${CourseCriteria.courseName }"/>
					<pg:param name="teacherName" value="${CourseCriteria.teacherName}"/>					
				
					<pg:index>
						<pg:first><a class="next-page" href="${pageUrl}&amp;currentIndex=${pageNumber}">首页</a></pg:first> 
						<pg:prev><a  class="prev-page" href="${pageUrl }&amp;currentIndex=${pageNumber}">前页</a></pg:prev> 
						<pg:pages>
						<c:choose>
						<c:when test="${pageNumber eq currentPageNumber }">
						<span class="page-num current-page">${pageNumber }</span>						   							
							</c:when>
							<c:otherwise> 
							<a class="page-num" href="${pageUrl }&amp;currentIndex=${pageNumber }">${pageNumber}</a> 
						</c:otherwise> 
					</c:choose> 
					</pg:pages> 
							<pg:next><a class="next-page" href="${pageUrl }&amp;currentIndex=${pageNumber }">下页</a></pg:next> 
							<pg:last><a class="next-page" href="${pageUrl }&amp;currentIndex=${pageNumber }">尾页</a>
		<%-- 					<span class="page-skip" style="margin-right: 0px;">共${pageNumber }页，去第<input style="width:25px; height:20px;border: 1px solid #ababab; border-radius:4px; text-align:center" id="pageNum" type="text" />页</span> 
						<span><input class="ui-button" type="button" value="跳转" onclick="goPage('${pageNumber }');" /></span> --%>
							</pg:last>
					</pg:index>
			</pg:pager>
         </div>
              <!-- <div class="pager-area" >
                    <a class="next-page" href="">首页</a> 
                    <a class="prev-page" href="">前页</a> 
                    <a class="page-num " href="">1</a> 
                    <span class="page-num current-page">2</span>
                    <a class="next-page" href="">尾页</a>
             </div>  -->
             <div class="repair_info">
             	<ul>
             	
                	<li><a href="javascript:void(0);" onclick="goWithUrl('${pageContext.request.contextPath}/course/add')">课程添加</a></li>                               	                	                
                </ul>
             </div> 
                   
     </div>
    </div>
           
        <jsp:include page="../common/footer.jsp" ></jsp:include>
    </div>
 
</body>
</html>
