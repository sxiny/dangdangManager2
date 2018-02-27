package src.com.baizhi.manager.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import src.com.baizhi.manager.entity.User;
import src.com.baizhi.manager.service.UserService;
import src.com.baizhi.manager.util.util.FIleTrasfer;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@RequestMapping("/checkCount")
	public @ResponseBody boolean checkCount(String userCount){
		
		return service.checkCount(userCount);
	}
	@RequestMapping("/checkCode")
	public @ResponseBody boolean checkCode(HttpSession session,String num){
		
		String code = (String)session.getAttribute("code");
		
		return num.equals(code);
	}
	@RequestMapping("/login")
	public @ResponseBody Map login(User u,HttpSession session){
		Map map = service.login(u);
		session.setAttribute("user", map.get("user"));
		return map;
	}
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		
		session.removeAttribute("user");
		
		return "index";
	}
	@RequestMapping("/file")
	public void fileupload(HttpServletRequest req,MultipartFile filename){
		String fileTrtans = FIleTrasfer.fileTrtans(req, filename);
			
		System.out.println(fileTrtans);
	}
	
}
