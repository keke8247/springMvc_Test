<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/inputJs.jspf"%>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#efefef">
  	<tr id="_middle">
	<!-- 主操作区 -->
    <td valign="top" >
	  <div class="tabkk" id="_maintab">
             <div class="yongyaoguize">
                       <div class="clearfloat pdt5">
                       		<div class="fleft" style="line-height: 28px; vertical-align: middle;">
								<label class="fleft"> 
								<span>&nbsp</span>
								姓名：
								<span>&nbsp</span> 
								<input type="text" id="cxmc" name="cxmc"  class="inpbg width200" /> 
								<span>&nbsp</span>
								</label> 
							</div>
                       		<p class="btns">
                       			<a onclick="addUser()">
                       			<span><img src="images/add.png" />新 增</span>
                       			</a>
                       			<a onclick="searchUser()">
                       			<span><img src="images/search.png" />查询</span>
                       			</a>
                       		</p>
                       </div>
               </div><!--clearfloat end-->
               <div>
              	<table id="ryTable"  width="100%" border="0" cellpadding="0" cellspacing="0" class="yao">
               	</table>
               		<div style="margin-top: 5px" align="center">
						<div id="barcon" name="barcon"></div>
					</div>
              </div> 
      </div><!--tabkk-->
    </td>
  </tr>
  
  <!-- 首页区 -->
  <tr id="_bottom" style="display:none;">
    <td valign="top" class="indexbody" colspan="3">
      <div class="defbody" id="_index"></div>
    </td>
  </tr>
</table>

<div class="diog  width500" id="etyygzwh">
     <p id="etyygzwhP">人员信息维护<a onclick="cancel_adduser()" class="close-reveal-modal">关闭</a></p>
	 <form id="ryxxwhform" name="ryxxwhform" method="post"	action="${pageContext.request.contextPath}/specialCrowdRule.do?action=saveRule">
	 	<input type="hidden" id="userId" name="userId">
	     <div class="diog_box">
	     	<ul class="zidian2 mt10 clearfloat">
	         <li>姓名：<span class="red">*</span><input id="xm" name="xm" type="text"  class="inpbg width200" /></li>
	         <li>性别：&nbsp;
	         	<select name="xb" id="xb" style="width: 110px; height: 22px">
						<option value="">-请选择-</option>
						<option value="1">男</option>
						<option value="0">女</option>
					</select>
	         </li>
	     	</ul>
	     	<ul class="zidian2 mt10 clearfloat">
	         <li>电话：<span class="red">*</span><input id="dh" name="dh" type="text"  class="inpbg width200" /></li>
	         <li>年龄：&nbsp;<input id="nl" name="nl" type="text" style="margin-left: 5px" class="inpbg width105" /></li>
	     	</ul>
	     	<ul class="zidian2 mt10 clearfloat">
	         <li>地址：<span class="red">*</span><input id="dz" name="dz" type="text"  class="inpbg width375" /></li>
	     	</ul>
	      <ul class="detail">
		            <li><span class="head1">备注：</span><textarea id="bz" name="bz" class="trea2"></textarea></li>
          </ul>
		     <div class="Btn">
		     	<a onclick="cancel_adduser()"><span>取 消</span></a>
		     	<a onclick="confirm_adduser()"><span>确 认</span></a>
		     </div>
	   	 </div>
   </form>
</div>

</body>
</html>
<script>
	//页面加载执行该函数
	$(document).ready(function(){
		searchUser();
	});
	//弹出新增窗口
	function addUser(){
		$("#ryxxwhform").resetForm();
		$('#userId').val("");
		document.getElementById('etyygzwh').style.display='block';
	}
	//取消新增
	function cancel_adduser(){
		document.getElementById('etyygzwh').style.display='none';
	}
	//确认添加
	function confirm_adduser(){
		if(trim($('#xm').val()) == ""||trim($('#dh').val()) == ""||$('#dz').val()==""){
			alert("带*号为必填项,请输入!");
			return  false;
		}
		$("#ryxxwhform").ajaxSubmit({
			async: false, //同步请求,该ajax请求执行完成后才能执行其他的操作.实用.
			type:"post",  //提交方式
			url : "${pageContext.request.contextPath}/user.do?action=saveUser",
			dataType:"json", //数据类型 ,设置后后台返回该类型的数据 
			success:function(data){ //提交成功的回调函数  
				alert(data.message);
				document.getElementById('etyygzwh').style.display='none';
				searchUser();
			},
		});
		return false;
	}

	//查询人员信息
	function searchUser(){
		if(trim($('#cxmc').val()) == "" ){
			$("#cxmc").val("");
		}
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/user.do?action=loadUserList',
			data : {
				cxmc : $("#cxmc").val(),
			},
			dataType:"json", //数据类型 ,设置后后台返回该类型的数据 
			success : function(data) {
				showUser(data);
				flag = true;
			}
		});
	}
	
	//加载页面人员列表
	function showUser(data){
		var userList = data.userList;
		strBuild();
		var title = "<tr><th width='5%'>序号</th><th width='10%'>姓名</th><th width='5%'>性别</th><th width='10%'>电话</th><th width='20%'>地址</th><th width='40%'>备注</th><th width='10%'>操作</th></tr>"
		var stringBuilder = new stringBuild();
		stringBuilder.append(title);
		var tr ="";
		for(var i=0;i<userList.length;i++){
			if((i+1)%2==1){
				tr += "<tr><td align='center'>"+(i+1)+"</td><td >"+userList[i].user_name+"</td><td >"+userList[i].user_sex+"</td><td>"+userList[i].user_tel+"</td><td>"+userList[i].user_add+"</td><td>"+userList[i].user_bz+"</td>";
			}else{
				tr += "<tr class='odd'><td align='center'>"+(i+1)+"</td><td >"+userList[i].user_name+"</td><td >"+userList[i].user_sex+"</td><td>"+userList[i].user_tel+"</td><td>"+userList[i].user_add+"</td><td>"+userList[i].user_bz+"</td>";
			}
			tr += "<td><p><a onclick=editUser('"+userList[i].user_id+"')  class='edit'>编辑</a><a onclick=deleteUser('"+userList[i].user_id+"')  class='del'>删除</a></p></td></tr>"
		}
		stringBuilder.append(tr);
		$("#ryTable").empty();
		$("#ryTable").append(stringBuilder.toString());
	}
	
	//删除人员信息
	function deleteUser(userId){
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/user.do?action=deleteUser',
			data : {
				userId : userId,
			},
			dataType:"json", //数据类型 ,设置后后台返回该类型的数据 
			success : function(data) {
				alert(data.message);
				searchUser();
			}
		});
	}
	
	//获取人员信息
	function editUser(userId){
		$.ajax({
			type : "post",
			url : '${pageContext.request.contextPath}/user.do?action=getUser',
			data : {
				userId : userId,
			},
			dataType:"json", //数据类型 ,设置后后台返回该类型的数据 
			success : function(data) {
				editView(data.userBean);
			}
		});
	}
	
	function editView(userBean){
		$('#userId').val(userBean.user_id);
		$('#xm').val(userBean.user_name);
		$('#xb').val(userBean.user_sex);
		$('#dh').val(userBean.user_tel);
		$('#dz').val(userBean.user_add);
		$('#nl').val(userBean.user_age);
		$('#bz').val(userBean.user_bz);
		document.getElementById('etyygzwh').style.display='block';
	}
	
</script>