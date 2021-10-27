package com.kosta.model;

import java.util.List;

public class DeptService {

	
	DeptDAO dao;
	public DeptService(String path) {
		dao = new DeptDAO(path) ;
	}
	 
	public List<DeptDTO> selectAllService() {
		return dao.selectAll();
	}
	
	public DeptDTO selectByIdService(int deptid) {
		return dao.selectById(deptid);
	}
	
	public List<DeptDTO> selectByNameService(String dname) {
		return dao.selectByName(dname);
	}
	public List<DeptDTO> selectByLocService(int loc) {
		return dao.selectByLoc(loc);
	}

	public int updateService(DeptDTO dept) {
		// TODO Auto-generated method stub
		return dao.updateDept(dept);
	}
	public int insertService(DeptDTO dept) {
		// TODO Auto-generated method stub
		return dao.insertDept(dept);
	}
	public int deleteService(int deptid) {
		// TODO Auto-generated method stub
		return dao.deleteDept(deptid);
	}
}





