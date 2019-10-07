import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import com.revature.beans.Employees;
import com.revature.beans.Reimbursements;
import com.revature.dao.EmployeesDAO;
import com.revature.dao.ReimbursementsDAOImpl;

class Testing {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		// tests to see if all 4 employees are returned by the ReimbursementsDAO
		List<Reimbursements> empList = ReimbursementsDAOImpl.getReimbursements();
		assertEquals(empList.size(), 4);
	}
	
	@Test
	void test2() {
		// testing the first employee
		Employees emp = ReimbursementsDAOImpl.getEmployeesById(1);
		assertEquals(emp.getEmployeeId(), 1);
		assertEquals(emp.getEmployeeUsername(), "Bankole");
		assertEquals(emp.getEmployeePassword(), "Shadow26");

		assertEquals(emp.getEmployeeManagerId(), 2);
	}
	
	@Test
	void test3() {
		boolean isUpdated = ReimbursementsDAOImpl.getReimbursementsByName(Bankole);
		assertEquals(isUpdated, true);
	}
	
	@Test
	void test4() {
		List<Reimbursements> reimList = ReimbursementsDAOImpl.AllApproved();
		assertNotEquals(reimList.size(), 0);
	}
	
	@Test
	void test5() {
		List<Reimbursements> reimList = ReimbursementsDAOImpl.AllPending();
		assertNotEquals(reimList.size(), 0);
	}
	
	

}