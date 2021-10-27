package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosta.util.DBUtil;
import com.kosta.util.DBUtil2;
import com.kosta.util.DateUtil;

//DAO(Data Access Object)
//Repository���� 
public class EmpDAO {
	
	//DML(Data Manipulation Languaeg)--insert, update, delete 
	
	public int empDelete(int empid) {
		int result = 0;  //delete�Ǽ�
		String sql=" delete from employees where EMPLOYEE_ID = ?";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int empUpdate2(EmployeeVO emp) {
		int result = 0;  //update�Ǽ�
		String sql="update employees set EMPLOYEE_ID =" +emp.getEmployee_id();
		String whereSQL = " where EMPLOYEE_ID =" +emp.getEmployee_id(); 
		String fnameSQL=" ",lnameSQL=" ", emailSQL=" ", phoneSQL=" ", jobSQL=" ",salSQL=" ",commSQL=" ";
		if(emp.getFirst_name()!=null) fnameSQL = ",first_name='" + emp.getFirst_name()+"'";
		if(emp.getLast_name()!=null) lnameSQL = ",last_name='" + emp.getLast_name()+"'";
		if(emp.getEmail()!=null) emailSQL = ",email='" + emp.getEmail()+"'";
		if(emp.getPhone_number()!=null) phoneSQL = ",phone_number='" + emp.getPhone_number()+"'";
		if(emp.getJob_id()!=null) jobSQL = ",job_id='" + emp.getJob_id()+"'";
		if(emp.getSalary()>=0) salSQL = ",salary=" + emp.getSalary();
		if(emp.getCommission_pct()>=0) commSQL = ",Commission_pct=" + emp.getCommission_pct();

		sql += fnameSQL+lnameSQL+emailSQL+phoneSQL+jobSQL+salSQL+commSQL+whereSQL;
		System.out.println("SQL��:" + sql);		
		Connection conn = DBUtil2.dbConnect();
		Statement st = null;
		try {
			st = conn.createStatement();		 
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int empUpdate(EmployeeVO emp) {
		int result = 0;  //insert�Ǽ�
		String sql="update employees set " +
			" FIRST_NAME=?," +
			" LAST_NAME=?," +
			" EMAIL=?,"+
			" PHONE_NUMBER=?,"+
			" HIRE_DATE=?,"+
			" JOB_ID=?,"+
			" SALARY=?,"+
			" COMMISSION_PCT=?,"+
			" MANAGER_ID=?,"+
			" DEPARTMENT_ID=?"+ 
			" where EMPLOYEE_ID = ?";
					 
		 
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(11, emp.getEmployee_id());
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getPhone_number());
			st.setDate(5, emp.getHire_date());
			st.setString(6, emp.getJob_id());
			st.setInt(7, emp.getSalary());
			st.setDouble(8, emp.getCommission_pct());
			st.setInt(9, emp.getManager_id());
			st.setInt(10, emp.getDepartment_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}
	
	public int empInsert(EmployeeVO emp) {
		int result = 0;  //insert�Ǽ�
		String sql="insert into employees "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate(6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setInt(8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			st.setInt(10, emp.getManager_id());
			st.setInt(11, emp.getDepartment_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}
	
	
	
	
	
    //��ü�ϱ⼭��: (���¿��� ����ϱ� ���, ���¿��� �Ա��ϱ� ���)
	public void withdraw() {
		System.out.println("����Ѵ�.");
	}
	public void deposit() {
		System.out.println("�Ա��Ѵ�.");
	}
	// ���������ȸ
	public List<EmployeeVO> selectAll() {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees order by 1";
		Connection conn = DBUtil2.dbConnect();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	// Ư���μ��� ������ȸ
	public List<EmployeeVO> selectById(int deptid) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees where department_id=?" ;
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);//sql�� �غ��Ѵ�. 
			st.setInt(1, deptid); //ù��°?�� �μ���ȣ�� �־��~
			rs = st.executeQuery();//����
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	// salary�� Ư���ݾ� �̻��� ������ ��ȸ
	public List<EmployeeVO> selectBySalary(int sal) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees where salary >= ?" ;
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); //sql���� ?���־�
			st.setInt(1, sal);//ù��° ?�� sal�� �Ҵ�  
			rs = st.executeQuery(); //sql�� ���� 
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	//job_id�� Ư������ ������ ��ȸ 
	public List<EmployeeVO> selectByJob(String jobid) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees where job_id = ? ";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); //sql���� ?���ִ�. 
			st.setString(1, jobid); //ù��° ?�� jobid�� setting 
			rs = st.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}
	// �μ��ڵ�, ��å, �޿�, �Ի��� 
	public List<EmployeeVO> selectByCondition(int deptid, String jobid, int sal, String hdate) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees "
				+ " where department_id=? "
				+ " and job_id = ? "
				+ " and salary>=? "
				+ " and hire_date>=? ";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); //sql���� ?���ִ�. 
			st.setInt(1, deptid);  
			st.setString(2, jobid);
			st.setInt(3, sal);  
			st.setDate(4, DateUtil.convertToDate(hdate));
			rs = st.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//�������ο� ������� ������ ���� 
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}
	private EmployeeVO makeEmp(ResultSet rs) throws SQLException {
		// DB�� ����ϴ� ��ü�� JAVA�� ��밡 ����ϴ� ��ü�� �ٸ���. �ڵ����� setting�Ұ�
		// �����ڰ� ResultSet�� �о �ڹ��� ��ü�� setting�ؾ��Ѵ�.
		EmployeeVO emp = new EmployeeVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getInt("Salary"));
		return emp;
	}

	public EmployeeVO selectByEmpid(int empid) {
		EmployeeVO emp = null;
		String sql = "select * from Employees "
				+ " where employee_id=? ";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); //sql���� ?���ִ�. 
			st.setInt(1, empid);  
			rs = st.executeQuery();
			while (rs.next()) {
				emp = makeEmp(rs) ;
			}			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//�������ο� ������� ������ ���� 
			DBUtil2.dbClose(conn, st, rs);
		}
		return emp;
	}
	//���޴�����ȸ�ϱ� 
	public List<EmployeeVO> selectAllManager() {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = 
				" select distinct emp.manager_id , manager.first_name"+
				" from employees emp join employees manager "+
				" on (emp.manager_id = manager.employee_id) "+
				" where emp.manager_id is not null"+
				" order by 1";
					
		Connection conn = DBUtil2.dbConnect();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployee_id(rs.getInt(1));
				emp.setFirst_name(rs.getString(2));
				emplist.add( emp );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}
}
