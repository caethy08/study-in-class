package kr.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import kr.mvc.controller.UserForm;

//controller 클래스의 요청을 받아 DB 연동 처리 담당
public class UserDaoModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDaoModel() { //usermanager에서 넘어옴(프로젝트가 커지면 매니저가 관리)
		
	}
	
	public UserDto findUser(String userid) {
		UserDto dto = null;
		
		SqlSession session = factory.openSession();
		
		try {
			dto = session.selectOne("findUser", userid); //mybatis를 통해 userid에 해당하는 dto값을 가져감
		} catch (Exception e) {
			System.out.println("findUser err" + e);
		}finally {
			session.close();
		}
		return dto;
	}
	
	public ArrayList<UserDto> getUserDataAll() {
		List<UserDto> list = null;
		SqlSession session = factory.openSession();
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserDataAll err" + e);
		}finally {
			session.close();
		}
		return (ArrayList<UserDto>)list;
		
	}
	
	public int insertData(UserForm userForm) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.insert("insertData",userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertData err" + e);
			session.rollback();
		}finally {
			session.close();
		}
		return result;
		
	}
	
	//....
}
