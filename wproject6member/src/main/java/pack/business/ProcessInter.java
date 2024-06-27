package pack.business;

import java.util.List;

public interface ProcessInter {
	List<DataDto> selectDataAll();
	DataDto selectPart(String para);
	boolean insertData(DataFormbean form);
	boolean updateData(DataFormbean form);
	boolean deleteData(String id);
}
