package whiteList.Controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import whiteList.Controllers.Repositories.CaseLiveRepository;


@RestController
@RequestMapping("/white-list")
public class WhiteListController {
	
	private static final Logger logger = LoggerFactory.getLogger(WhiteListController.class);
	
	@Autowired
	private CaseLiveRepository caseLiveRepository;
	
	@PostMapping("/create-white-list")
	public boolean createWhiteListCase(@RequestParam("Inputs") List<String> inputs) {
		try {
			return caseLiveRepository.createWhiteList(inputs);	
		} catch (Exception e) {
			logger.error("create white list exception ",e);
			return false;
		}
	}
	
	@PostMapping("/insert-white-list")
	public boolean insertWhiteList(@RequestBody Long case_rk) {
		try {
			return caseLiveRepository.insertIntoWL(case_rk);
		} catch (Exception e) {
			logger.error("insert to white list exception ",e);
			return false;
		}
	}

}
