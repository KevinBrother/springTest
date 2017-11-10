package com.my.handlers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.my.domain.User;


/**
 * 请求参数实例
 * @author heheda
 *
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	@RequestMapping("/testPathVariable/{id}")
	//http://localhost:8091/springTest/springmvc/testPathVariable/12
	public String testPathVariable(@PathVariable(value="id") Integer id) {
		System.out.println("testPathVariable=" + id);
		return "/success";
	}
	
	@RequestMapping("/testRequestParam")
	//http://localhost:8091/springTest/springmvc/testPathVariable/12
	public String testRequestParam(@RequestParam(value="username") String username, @RequestParam(value="age", required=false, defaultValue="0") int age) {
		System.out.println("username=" + username + ",age=" + age);
		return "/success";
	}
	
	@RequestMapping("/testCookieValue")
	//http://localhost:8091/springTest/springmvc/testPathVariable/12
	public String testCookieValue(@CookieValue("JSESSIONID") String JSESSIONID) {
		System.out.println("JSESSIONID=" + JSESSIONID);
		return "/success";
	}
	
	@RequestMapping("/testRequestHeader")
	//http://localhost:8091/springTest/springmvc/testPathVariable/12
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String language) {
		System.out.println("testRequestHeader Accept-Languge:" + language);
		return "/success";
	}
	
	@RequestMapping("/testPojo")
	//http://localhost:8091/springTest/springmvc/testPathVariable/12
	public String testPojo(User user) {
		System.out.println("testPojo" + user);
		return "/success";
	}
	
	@RequestMapping("/testModelAndView")
	//http://localhost:8091/springTest/springmvc/testPathVariable/12
	public ModelAndView testModelAndView() {
		String viewname= "/success";
		ModelAndView modelAndView = new ModelAndView(viewname);
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}
}
