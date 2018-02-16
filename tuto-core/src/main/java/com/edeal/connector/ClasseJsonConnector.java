package com.edeal.connector;

import com.edeal.server.bean.ClasseBean;
import com.edeal.service.ClasseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  ClasseJsonConnector extends JsonConnector{
	
	@Override
	@RequestMapping(value = "/classe", method= RequestMethod.GET)
	public @ResponseBody String toJson() throws Exception {
		ClasseService service = new ClasseService();
		ClasseBean bean = service.findByName("test");
		return toJson(bean);
	}
}
