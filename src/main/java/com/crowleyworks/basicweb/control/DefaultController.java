package com.crowleyworks.basicweb.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crowleyworks.basicweb.service.BasicService;

@Controller
public class DefaultController {

	@Autowired
	BasicService basicService;

	@RequestMapping(value="/index.htm", method = RequestMethod.GET)
	public String basicIndex(Model model) {
		try {
			List<String> values = basicService.getMany();
			for(String curValue : values) {
				System.out.println(curValue);
			}
			model.addAttribute("values", values);
		} catch(Exception e) {
			
		}
		Map<String,String> allEnv = System.getenv();
		model.addAttribute("environment", allEnv);
		return "index";
	}

}
