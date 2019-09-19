package whiteList.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import whiteList.Controllers.Repositories.CaseLiveRepository;

@RestController
public class CaseController {

	private static final Logger logger = LoggerFactory.getLogger(CaseController.class);

	@Autowired
	private CaseLiveRepository caseLiveRepository;

	@PostMapping("/search")
	public boolean search(@RequestBody int id,@RequestBody String name) {
		try {
			return caseLiveRepository.search(id, name);
		} catch (Exception e) {
			logger.error("search exception ", e);
			return false;
		}
	}

}
