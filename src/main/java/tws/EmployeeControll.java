package tws;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/employees")
public class EmployeeControll {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED)
	 public void addEmployee(@RequestBody Employee employee) {
		 employeeMapper.insertEmpployee(employee);
	 }
	 
	 @GetMapping
	 @ResponseStatus(HttpStatus.OK)
	 public List<Employee> getEmployee() {
		 List<Employee> employee = employeeMapper.getEmployees();
		 return employee;
	 }	 	 
	 
	 @PutMapping("/{id}")
	 @ResponseStatus(HttpStatus.OK)
	 public int updateEmployee(@RequestBody Employee employee,@PathVariable int id) {	
		 return employeeMapper.updateEmpployees(employee,id);
			 
		
	 }
 
	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.OK)
	 public void deleteEmployee(@PathVariable int id) {	
		 employeeMapper.deleteEmpployees(id);
	 }	
	 
}
