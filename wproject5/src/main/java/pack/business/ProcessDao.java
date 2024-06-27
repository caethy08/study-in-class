package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.business.DataDto;
import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDataAll() throws SQLException{
		SqlSession sqlSesion = factory.openSession(); //세션 열기
		List list = sqlSesion.selectList("selectDataAll");
		sqlSesion.close();
		return list; //처리한 결과값을 리턴	
	}
	
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSesion = factory.openSession(); //세션 열기
		DataDto dto = sqlSesion.selectOne("selectDataById", para);
		sqlSesion.close();
		return dto;
	}
	
	public void insData(DataForm form) throws SQLException {
		SqlSession sqlSession = factory.openSession();  //transaction 수동 처리
		sqlSession.insert("insertData", form);
		sqlSession.commit(); //커밋하기
		sqlSession.close();
	}
	
	public void upData(DataForm form) throws SQLException {
		SqlSession sqlSession = factory.openSession(true);  //transaction 자동 처리
		sqlSession.update("updateData", form);
		sqlSession.close();
	}
	
	public boolean delData(int para) {
		boolean result = false;
		SqlSession sqlSession = factory.openSession();
		try {
			int cou = sqlSession.delete("deleteData", para);
			if(cou > 0)result = true;
			
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("delData err: " + e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return result;
	}
}
