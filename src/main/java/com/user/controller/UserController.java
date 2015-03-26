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
 * �û����������
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
	 * �û�����ҳ��.
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
	 * ������Ա��Ϣ.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException 
	 */
	public void saveUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//�����json����
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
				jsonObj.put("message", "�޸ĳɹ�!");
			} catch (Exception e) {
				jsonObj.put("message", "�޸�ʧ��!");
				e.printStackTrace();
			}
		}else{
			String uuid = UUID.randomUUID().toString();
			userBean.setUser_id(uuid);
			try {
				this.userHandler.saveUser(userBean);
				jsonObj.put("message", "����ɹ�!");
			} catch (Exception e) {
				jsonObj.put("message", "����ʧ��!");
				e.printStackTrace();
			}
		}
		
		
		out.println(jsonObj);
	}
	
	/**
	 * ��ѯ��Ա�б�.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void loadUserList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//�����json����
		String cxmc = request.getParameter("cxmc");
		List<UserBean> userList = this.userHandler.loadUserList(cxmc);
		JSONArray jsArray =  new JSONArray();
		jsArray = jsArray.fromObject(userList);//listת��Ϊjsonarray
		jsonObj.put("userList", jsArray);
		out.println(jsonObj);
	}
	
	/**
	 * ɾ����Ա��Ϣ.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//�����json����
		String userId = request.getParameter("userId");
		int deleteCode = this.userHandler.deleteUser(userId);
		if(deleteCode == 1){
			jsonObj.put("message", "ɾ���ɹ�!");
		}else{
			jsonObj.put("message", "ɾ��ʧ��!");
		}
		out.println(jsonObj);
	}
	
	/**
	 * ��ȡ��Ա��Ϣ.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the user
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void getUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		jsonObj.clear();//�����json����
		String userId = request.getParameter("userId");
		UserBean userBean = this.userHandler.getUser(userId);
		jsonObj.put("userBean", userBean);
		out.println(jsonObj);
	}
}
