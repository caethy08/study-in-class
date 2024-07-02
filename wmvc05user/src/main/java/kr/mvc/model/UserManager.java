package kr.mvc.model;

import java.util.ArrayList;

import kr.mvc.controller.UserForm;

//여러 개의 DAO 클래스 관리가 목적
public class UserManager { //싱글톤 패턴
	private static UserManager manager = new UserManager();
	
	public static UserManager instance() {
		return manager;
	}
	
	private UserDaoModel getuserDaoModel() {
		return new UserDaoModel(); //userdaomodel객체 리턴
	}
	
	public boolean login(String user_id, String user_password) {//로그인 확인
		UserDto dto = getuserDaoModel().findUser(user_id);
		if (dto == null) return false;
		
		if(dto.getPassword().equals(user_password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<UserDto> getUserAll() {
		return getuserDaoModel().getUserDataAll();
	}
	
	public int insert(UserForm userForm) {
		return getuserDaoModel().insertData(userForm);
	}
	
	public UserDto findUser(String userid) {
		return getuserDaoModel().findUser(userid);
	}
}
