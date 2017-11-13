package com.my.handlers;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.dao.EmployeeDao;
import com.my.domain.Employee;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/list")
	public String list(Map<String, Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/list";
	}
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	public static void main(String[] args) {
		EmployeeDao abc = new EmployeeDao();
		System.out.println(abc.getAll());
	}
	
}
