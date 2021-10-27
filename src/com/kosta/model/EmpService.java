package com.kosta.model;

import java.util.List;

//����ڿ�û-->Controller-->Service--->DAO-->DB
//Service:�ϳ��� �������� (��, ��ü�ϱ�(���,�Ա�), ��ǰ�԰��ϱ�(�԰�insert,���update)
public class EmpService {
    EmpDAO dao = new EmpDAO();  
    public int empDelete(int empid) {
		return dao.empDelete(empid);
	}
   
    public int empUpdate(EmployeeVO emp) {
		return dao.empUpdate2(emp);
	}   
    public int empInsert(EmployeeVO emp) {
    	return dao.empInsert(emp);
    }
 
    //dao�� �������������ִ�.
    public void test() {
    	System.out.println("db�� �����ʾƵ� �Ǵ� Business logic�ۼ�");
    }
    //dao�� �����۾��� ȣ���Ҽ��� �ִ�. 
	public void ��ü�ϱ�() {
		dao.withdraw();
		dao.deposit();
	}
	//dao�� ���� �����ϰ� ���� ���� Controller���� ������.  
	public List<EmployeeVO> selectAll() {
		return dao.selectAll();
	}
	public List<EmployeeVO> selectById(int deptid) {
		return dao.selectById(deptid);
	}
	public List<EmployeeVO> selectBySalary(int salary) {
		return dao.selectBySalary(salary);
	}
	public List<EmployeeVO> selectByJob(String job) {
		return dao.selectByJob(job);
	}
	public List<EmployeeVO> selectByCondition(int deptid, String job, int sal, String hdate) {
		return dao.selectByCondition(deptid, job, sal, hdate);
	}

	public EmployeeVO selectByEmpid(int empid) {
		// TODO Auto-generated method stub
		return dao.selectByEmpid(empid);
	}

	public List<EmployeeVO> selectAllManager() {
		return dao.selectAllManager();
	}
	
}




