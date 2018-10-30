package mx.com.bwl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String mostrarPrincipal(Model model){
		return "home";
	}

	@GetMapping(value="/about")
	public String goHome(){
		return "home";
	}
	
	@GetMapping(value="/formLogin")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/formLogin";
	}
	
	
	
}
