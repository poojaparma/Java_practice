package com.programmingfree.springservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/token")
	public ModelAndView home() {
		System.out.println("controller.........................is called");
		RestTemplate restTemplate = new RestTemplate();

		final ResponseEntity<String> response = restTemplate.getForEntity("https://avrilemail-load-hawks.nctx3-load.ciscoccservice.com/metrics", String.class);

	//	App app = new App();
	String token = response.getBody();
		System.out.println("token : ..............." + response.getBody());
		ModelAndView model = new ModelAndView("token");
		model.addObject("token", token);
		return model;
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/?logout";
	}

}
