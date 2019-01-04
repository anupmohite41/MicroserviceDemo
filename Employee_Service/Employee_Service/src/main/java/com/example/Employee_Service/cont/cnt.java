package com.example.Employee_Service.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Employee_Service.configDAO.DemoObject;
import com.example.Employee_Service.configDAO.LogInDAO;
import com.example.Employee_Service.configDAO.RegDAO;
import com.example.Employee_Service.configDaoRepository.RegistrationRepository;

@Controller
@ResponseBody
@RequestMapping("")
public class cnt {
	static int i = 0;
	@Autowired(required=true)
	private RegistrationRepository RR;

	@GetMapping("/demo")
    public DemoObject getHelloWordObject() {
        DemoObject demo = new DemoObject();
        demo.setMessage("Welcome to microservices Demo " );
        return demo;
    }

	
	
	@PostMapping(value="/Register")
	public RedirectView registerUser(@ModelAttribute RegDAO rd){
			System.out.println("Gender :: " + rd.getGender());
			RR.save(rd);
			RedirectView redirectView = new RedirectView();
		    redirectView.setUrl("http://localhost:8089/login");
		    return redirectView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String LoginUser(){
		return "index.html";
	}
	@RequestMapping(value = "/LoginPage", method = RequestMethod.POST)
	public RedirectView getAll(@ModelAttribute LogInDAO LD){
		RedirectView redirectView1 = new RedirectView();
		String[] uname = RR.findUname();
		String[] pass = RR.findPassword();
		for(String name : uname){
			for(String password : pass){
				if(name.equals(LD.getEmail()) && password.equals(LD.getPass())){
				    redirectView1.setUrl("http://localhost:8089/Welcome");
				    return redirectView1;
				}}}
		redirectView1.setUrl("http://localhost:8089");
	    return redirectView1;
	}
	@RequestMapping(value="/Welcome", method = RequestMethod.GET)
	public String WelcomeUser(){
		return "Welcome.html";
	}
}
