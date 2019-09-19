package whiteList.Controllers.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ICaseLiveRepository{
	
	public boolean createWhiteList(List<String> inputs);	
	
	public boolean insertIntoWL(Long case_rk);
	
	@Query("SELECT [party_identification_id],[party_name] "
			+ "FROM [fcf71].[FCFCORE].[FSC_PARTY_DIM] "
			+ "WHERE [party_identification_id] = ?1")
	public boolean search(int id ,String name);
	
}
