package com.my.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
	
	//上传文件
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file){
		System.out.println("desc: " + desc + " file: " + file.getOriginalFilename());
		return "success";
	}
	
	//下载文件
	@RequestMapping("/testFileDown")
	public ResponseEntity<byte[]> testFileDown(HttpSession session) throws IOException {
		byte[] body = null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("file/abc.txt");
		body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	
}
