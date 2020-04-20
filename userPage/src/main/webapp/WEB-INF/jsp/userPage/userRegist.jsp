<%@page import="userPage.type.GrantType"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <c:set var="registerFlag" value="${empty userVO.userId ? 'create' : 'modify'}"/>
    <title><c:if test="${registerFlag == 'create'}">사용자 등록</c:if>
           <c:if test="${registerFlag == 'modify'}">사용자 수정</c:if>
    </title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    
    <!--For Commons Validator Client Side-->
    <script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script>
    <%-- <validator:javascript formName="userVO" staticJavascript="false" xhtml="true" cdata="false"/> --%>
    
    <script type="text/javaScript" language="javascript" defer="defer">
        <!--
        /* 첫화면 */
        function fn_egov_selectList() {
           	document.detailForm.action = "<c:url value='/userPage.userList.do'/>";
           	document.detailForm.submit();
        }
        
        /* 사용자 등록 */
        function fn_egov_save() {
        	frm = document.detailForm;
        	//if(!validateUserVO(frm)){
            //    return;
            //}else{
            	frm.action = "<c:url value="${registerFlag == 'create' ? '/userPage.addUser.do' : '/userPage.updateUser.do'}"/>";
                frm.submit();
           // }
        }
        
        function fn_egov_delete(){
        	document.detailForm.action = "<c:url value='/userPage.deleteUser.do'/>";
           	document.detailForm.submit();
        }
        
        -->
    </script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">

<form:form commandName="userVO" id="detailForm" name="detailForm">
	<input type="hidden" name="obid" value="<c:out value='${userVO.obid}'/>"/>
	<input type="hidden" name="1231332" value="<c:out value='${userVO.userType}'/>"/>
    <div id="content_pop">
    	<!-- 타이틀 -->
    	<div id="title">
    		<ul>
    			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>
                    <c:if test="${registerFlag == 'create'}">사용자 등록</c:if>
                    <c:if test="${registerFlag == 'modify'}">사용자 수정</c:if>
                </li>
    		</ul>
    	</div>
    	<!-- // 타이틀 -->
    	<div id="table">
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" style="bordercolor:#D3E2EC; bordercolordark:#FFFFFF; BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
    		<colgroup>
    			<col width="150"/>
    			<col width="?"/>
    		</colgroup>
        	<tr>
        		<td class="tbtd_caption"><label for="userId">사용자 ID</label></td>
        		<td class="tbtd_content">
        			<c:if test="${registerFlag == 'create'}">
        				<form:input path="userId"  maxlength="10"  />
        			</c:if>
        			<c:if test="${registerFlag == 'modify'}">
        				<form:input path="userId"  maxlength="10" cssClass="essentiality" readonly="true" />
        			</c:if>
        		</td>
        	</tr>
        	<tr>
    			<td class="tbtd_caption"><label for="pwd">비밀번호</label></td>
    			<td class="tbtd_content">
    				<form:password path="pwd" rows="5" cols="58" />
                </td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="name">사용자명</label></td>
    			<td class="tbtd_content">
    				<form:input path="name" maxlength="30" cssClass="txt"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="userType">사용권한</label></td>
    			<td class="tbtd_content">
    				<form:select path="userType" cssClass="use">
	    				<form:option value="2" label="<%=GrantType.NUSER.getName() %>" />
    					<form:option value="1" label="<%=GrantType.ADMIN.getName() %>" />
    				</form:select>
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="email">이메일 주소</label></td>
    			<td class="tbtd_content">
    				<form:input path="email" maxlength="30" cssClass="txt"/>
    			</td>
    		</tr>
    		<c:if test="${registerFlag == 'modify'}">
        		<tr>
        			<td class="tbtd_caption"><label for="createdOn">최초 등록일</label></td>
        			<td class="tbtd_content">
        				<%-- <form:input path="createdOn" cssClass="essentiality" maxlength="10" readonly="true" /> --%>
        				<fmt:formatDate value="${userVO.createdOn}" pattern="yyyy-MM-dd hh:mm:ss"/>
        			</td>
        		</tr>
        		<tr>
        			<td class="tbtd_caption"><label for="modifiedOn">최종 수정일</label></td>
        			<td class="tbtd_content">
        				<%-- <form:input path="modifiedOn" cssClass="essentiality" maxlength="10" readonly="true"  /> --%>
        				<fmt:formatDate value="${userVO.modifiedOn}" pattern="yyyy-MM-dd hh:mm:ss"/>
        			</td>
        		</tr>
    		</c:if>
    	</table>
      </div>
    	<div id="sysbtn">
    		<ul>
    			<li>
                    <span class="btn_blue_l">
                        <a href="javascript:fn_egov_selectList();"><spring:message code="button.list" /></a>
                        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
    			<li>
                    <span class="btn_blue_l">
                        <a href="javascript:fn_egov_save();">
                            <c:if test="${registerFlag == 'create'}"><spring:message code="button.create" /></c:if>
                            <c:if test="${registerFlag == 'modify'}"><spring:message code="button.modify" /></c:if>
                        </a>
                        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
    			<c:if test="${registerFlag == 'modify'}">
                    <li>
                        <span class="btn_blue_l">
                            <a href="javascript:fn_egov_delete();"><spring:message code="button.delete" /></a>
                            <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                        </span>
                    </li>
    			</c:if>
    			<li>
                    <span class="btn_blue_l">
                        <a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><!-- 재설정 -->
                        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                    </span>
                </li>
            </ul>
    	</div>
    </div>
</form:form>
</body>
</html>