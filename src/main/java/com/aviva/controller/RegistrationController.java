package com.aviva.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aviva.dao.RegistrationRepo;
import com.aviva.model.Registration;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationRepo regRepo;

	@PostMapping("/registration")
	public Registration saveRegistrationDetail(@RequestBody Registration regs) {
		System.out.println("called saveRegistrationDetail() " + regs);
		Registration savedReg = regRepo.save(regs);
		System.out.println("saved RegistrationDetail " + savedReg);
		return savedReg;
	}

	@GetMapping("registration_by_id/{id}")
	public Registration registrationById(@PathVariable("id") Integer id) {
		System.out.println("called registrationById() " + id);
		Registration regs = regRepo.findById(id).orElse(null);
		System.out.println("called registrationById() " + regs);
		return regs;
	}

	@GetMapping("registrations")
	public List<Registration> registrations() {
		List<Registration> regs = regRepo.findAll();
		System.out.println("called registrations() " + regs);
		return regs;
	}

	@RequestMapping("registration_detail_page_by_id")
	public ModelAndView registrationDetailPageById(@RequestParam Integer id) {
		System.out.println("called registrationDetailPageById() " + id);
		Registration regs = regRepo.findById(id).orElse(null);
		System.out.println("called registrationDetailPageById() " + regs);

		ModelAndView mav = new ModelAndView();
		ModelMap modelMap = new ModelMap();
		mav.setViewName("registration_detail.jsp");
		modelMap.put("id", regs.getId());
		modelMap.put("first_name", regs.getFirstName());
		modelMap.put("last_name", regs.getLastName());
		modelMap.put("email", regs.getEmail());
		modelMap.addAttribute("email", regs.getEmail());
		System.out.println("called registrationDetailPageById() " + modelMap);
		mav.addAllObjects(modelMap);
		return mav;
	}

	@RequestMapping(value = "/registrationByUi")
	public ModelAndView saveRegistrationByUi(HttpServletRequest req) {
		Registration reg = new Registration();
		reg.setFirstName(req.getParameter("firstname"));
		reg.setLastName(req.getParameter("lastname"));
		reg.setEmail(req.getParameter("email"));
		reg.setPassword(req.getParameter("password"));
		reg.setConfirmPassword(req.getParameter("confirmpassword"));

		System.out.println("called saveRegistrationByUi() " + reg);
		Registration savedReg = regRepo.save(reg);
		System.out.println("saved saveRegistrationByUi " + savedReg);

		ModelAndView mav = new ModelAndView();
		ModelMap modelMap = new ModelMap();
		mav.setViewName("registration_detail.jsp");
		modelMap.put("id", savedReg.getId());
		modelMap.put("first_name", savedReg.getFirstName());
		modelMap.put("last_name", savedReg.getLastName());
		modelMap.put("email", savedReg.getEmail());
		modelMap.addAttribute("email", savedReg.getEmail());
		System.out.println("called registrationDetailPageById() " + modelMap);
		mav.addAllObjects(modelMap);
		return mav;
	}

	@RequestMapping("/registration_page")
	public ModelAndView showRegistrationPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registration.jsp");
		return mav;
	}

	@RequestMapping("/home")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home.jsp");
		return mav;
	}
}
