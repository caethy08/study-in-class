package pack.business;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SqlMapperInter {
	//@Select();로 막아버리면 안됨
	@Select("select * from memeberteb")
	public List<DataDto> selectDataAll();
	
	@Select("select id,name,passwd, reg_date from memberteb where id=#{id}")
	public DataDto selectPart(String id);
	
	@Insert("insert into memberteb values(#{id}, #{name}, #{passwd},now()))")
	public int insertData(DataFormbean form);
	
	@Update("update memberteb set name=#{name} where id=#{id}")
	public int updateData(DataFormbean form);
	
	@Delete("delete from memberteb where id=#{id}")
	public int deleteData(String id);
}
