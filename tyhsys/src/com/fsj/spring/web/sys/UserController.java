package com.fsj.spring.web.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsj.spring.model.sys.SysUser;
import com.fsj.spring.service.sys.UserService;
import com.fsj.spring.util.Constants;
import com.fsj.spring.util.DataGridModel;
import com.fsj.spring.web.TUserAwareImpl;
/**
 * Title:用户管理控制层
 * 继承TUserAwareImpl，提供会话用户信息
 *
 * @author 唐有欢
 * @version 1.0 , 2013-1-21 创建
 */
@Controller
@RequestMapping("/user")
public class UserController extends TUserAwareImpl {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		return "sys/sysuserlist";
	}

	@RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, SysUser user) throws Exception {
		// spring可以自动装配两个对象 会自动的装返回的Map转换成JSON对象
		
		//设置会话用户信息 ， 用于数据过滤
		userService.setLoginUser(sessionUser);
		
		//return userService.getPageList(dgm, user);
		return userService.getPageListBySQL(dgm, user);
	}

	@RequestMapping(value = "/sysuser-edit", method = RequestMethod.GET)
	public String popWindow() throws Exception {
		return "sys/sysuser-edit";
	}

	@RequestMapping(value = "/addOrUpdateUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addOrUpdate(SysUser user, HttpSession session) throws Exception {
		// spring会利用jackson自动将返回值封装成JSON对象
		Map<String, String> map = new HashMap<String, String>();
		try {
			userService.setLoginUser(sessionUser);
			userService.saveOrUpdate(user);
			map.put("mes", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			throw e;
		}
		return map;
	}

	@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("uid") List<Long> uid) throws Exception {
		// spring 将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			userService.deleteAllObjects(SysUser.class, uid);
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			throw e;
		}
		return map;
	}

	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		if (session != null && session.getAttribute(Constants.USER_INFO_SESSION) != null) {
			session.removeAttribute(Constants.USER_INFO_SESSION);
		}
		return "relogin";
	}

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
