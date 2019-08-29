package tws;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {
	@Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
	void insertEmpployee(@Param(value = "employee") Employee employee);
	
	@Select("select * from employee")
	List<Employee> getEmployees();
	
	@Update("update employee set name =#{employee.name},  age=#{employee.age} WHERE id = #{id}")
	int updateEmpployees(@Param(value = "employee") Employee employee ,
			@Param(value = "id") int id);
	
	@Delete("delete  from employee where id=#{employee.id}")
	void deleteEmpployees(@Param(value = "employee") int id);

}
