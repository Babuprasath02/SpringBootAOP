// package com.kgisl.springdataquerymethods;

// import static org.mockito.Mockito.when;

// import java.util.Arrays;
// import java.util.List;

// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.kgisl.springdataquerymethods.controller.EmployeeController;
// import com.kgisl.springdataquerymethods.model.Employee;
// import com.kgisl.springdataquerymethods.service.EmployeeServiceImpl;

// @ExtendWith(MockitoExtension.class)
// public class EmployeeControllerTest {
// 	@InjectMocks
// 	public EmployeeController empController;
// 	@Mock
// 	public EmployeeServiceImpl empService;

// 	public static List<Employee> expected;
// 	Employee emp1 = new Employee();
// 	Employee emp2 = new Employee();

// 	@Test
// 	public void allTest() {
// 		expected = Arrays.asList(emp1);
// 		when(empService.getAll()).thenReturn(expected);
// 		ResponseEntity<List<Employee>> actual = empController.getAll();
// 		 assertNotNull(actual);
// 		assertEquals(expected,actual.getBody());
// 		assertEquals(HttpStatus.OK, actual.getStatusCode());

// 	}
// 	@Test
// 	public void getByIdTest(){
// 	int id = 1;
// 	when(empController.getById(id)).thenReturn(emp1);
// 	Employee actual = empController.getById(id);
// 	System.out.println("Actual is "+actual);
// 	assertNotNull(actual);
// 	}
// 	@Test
// 	public void createEmploeeTest(){
// 	when(empController.create(emp1)).thenReturn(null);
// 	empController.create(emp1);
// 	}
// 	@Test
// 	public void updateEmployeeTest(){
// 	int id = 1;
// 	when(empController.getById(id)).thenReturn(emp1);
// 	Employee actual = empController.update(id, emp1);
// 	//assertNotNull(actual);
// 	// Employee emp = new Employee();
// 	// emp.setId(5);
// 	// emp.setName(";klsfjklfjldj");
// 	// emp.setAge(44);
// 	// emp.setSalary(444.4f);
// 	// emp.setAddress("Coimbatore");
// 	System.out.println("Actual is "+actual);
// 	System.out.println("expecter---> "+expected);
// 	}

// 	@Test
// 	public void deleteEmployeeTest(){
// 	int id =1;
// 	when(empController.getById(id)).thenReturn(null);
// 	ResponseEntity<Employee> actual =empController.deleteById(id);
// 	//verify(empController).deleteById(id);
// 	System.out.println("Actual is "+actual);
// 	}

// }
