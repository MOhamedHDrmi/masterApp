package whiteList.Controllers.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CaseLiveRepository implements ICaseLiveRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public boolean createWhiteList(List<String> inputs) {
		StoredProcedureQuery q = entityManager.createStoredProcedureQuery("casemgmt.CREATEWHITELIST");
		for (int i = 1; i <= inputs.size(); i++) {
			q.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
		}
		q.registerStoredProcedureParameter(inputs.size() + 1, Long.class, ParameterMode.OUT);

		for (int i = 0; i < inputs.size(); i++) {
			q.setParameter(i + 1, inputs.get(i));
		}
		q.execute();
		
		return (Long) q.getOutputParameterValue(inputs.size() + 1) == 1;
		
	}

	@Override
	public boolean insertIntoWL(Long case_rk) {
		StoredProcedureQuery q = entityManager.createStoredProcedureQuery("casemgmt.INSERTINTOWL");
		q.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
		q.registerStoredProcedureParameter(2, Long.class, ParameterMode.OUT);
		q.setParameter(1, case_rk);
		q.execute();
		return (Long) q.getOutputParameterValue(2) == 1;
	}

	@Override
	public boolean search(int id, String name) {
		
		return false;
	}

}
