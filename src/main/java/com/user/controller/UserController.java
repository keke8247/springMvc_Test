package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.user.entity.UserBean;
import com.user.logic.UserHandler;

// TODO: Auto-generated Javadoc
/**
 * 用户管理控制类
 * @author wdk
 * 2015-03-24.
 */
public class UserController extends MultiActionController{
	private JSONObject jsonObj = new JSONObject();
	private UserHandler userHandler;
	
	public UserHandler getUserHandler() {
		return userHandler;
	}

	public void setUserHandler(UserHandler userHandler) {
		this.userHandler = userHandler;
	}

	/**
	 * 用户管理页面.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	public ModelAndView userView(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> data = new HashMap<String, Object>();
		
		return new ModelAndView("/user/user.jsp", data);
	}
	
	/**
	 * 保存人员信息.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException 
	 */
	public void saveUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//先清空json对象
		UserBean userBean = new UserBean();
		String userID = request.getParameter("userId");
		userBean.setUser_name(request.getParameter("xm"));
		userBean.setUser_age(Integer.parseInt(request.getParameter("nl")));
		userBean.setUser_sex(Integer.parseInt(request.getParameter("xb")));
		userBean.setUser_tel(request.getParameter("dh"));
		userBean.setUser_add(request.getParameter("dz"));
		userBean.setUser_bz(request.getParameter("bz"));
		
		if(userID!=null && !"".equals(userID)){
			userBean.setUser_id(userID);
			try {
				this.userHandler.updateUser(userBean);
				jsonObj.put("message", "修改成功!");
			} catch (Exception e) {
				jsonObj.put("message", "修改失败!");
				e.printStackTrace();
			}
		}else{
			String uuid = UUID.randomUUID().toString();
			userBean.setUser_id(uuid);
			try {
				this.userHandler.saveUser(userBean);
				jsonObj.put("message", "保存成功!");
			} catch (Exception e) {
				jsonObj.put("message", "保存失败!");
				e.printStackTrace();
			}
		}
		
		
		out.println(jsonObj);
	}
	
	/**
	 * 查询人员列表.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void loadUserList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//先清空json对象
		String cxmc = request.getParameter("cxmc");
		List<UserBean> userList = this.userHandler.loadUserList(cxmc);
		JSONArray jsArray =  new JSONArray();
		jsArray = jsArray.fromObject(userList);//list转换为jsonarray
		jsonObj.put("userList", jsArray);
		out.println(jsonObj);
	}
	
	/**
	 * 删除人员信息.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//先清空json对象
		String userId = request.getParameter("userId");
		int deleteCode = this.userHandler.deleteUser(userId);
		if(deleteCode == 1){
			jsonObj.put("message", "删除成功!");
		}else{
			jsonObj.put("message", "删除失败!");
		}
		out.println(jsonObj);
	}
	
	/**
	 * 获取人员信息.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the user
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void getUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//先清空json对象
		String userId = request.getParameter("userId");
		UserBean userBean = this.userHandler.getUser(userId);
		jsonObj.put("userBean", userBean);
		out.println(jsonObj);
	}
}
