package com.example.unitconversion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.unitconversion.entity.Answer;
import com.example.unitconversion.logic.Control;
import com.example.unitconversion.repository.AnswerRepository;

@Controller
@RequestMapping("/answers/")
public class AnswerController {

	private final AnswerRepository answerRepo;
	
	@SuppressWarnings("serial")
	public class AnswerNotFoundException extends IllegalArgumentException {
		public AnswerNotFoundException(String msg) {
			super(msg);
			System.out.println(msg);
		} 
	}

	@Autowired
	public AnswerController(AnswerRepository answerRepository) {
		this.answerRepo = answerRepository;
	}
		
	@GetMapping("add")
	public String showSignUpForm(Answer answer) {
		return "add-answer";
	}
	@GetMapping("list")
	public String showList(Model model) {
		Iterable<Answer> list = answerRepo.findAll();
		if(list.iterator().hasNext()) {
		    model.addAttribute("answers", list);
		}
		return "index";
	}

	@PostMapping("add")
	public String addStudent(@Valid Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-answer";
		}

		Control.updateDB(answerRepo, answer);
		return "redirect:list";
	}


	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Answer answer = answerRepo.findById(id)
				.orElseThrow(() -> new AnswerNotFoundException("Invalid answer Id:" + id));
		model.addAttribute("answer", answer);
		return "update-answer";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Answer answer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			answer.setId(id);
			return "update-answer";
		}

		Control.updateDB(answerRepo, answer);
		return "redirect:../list";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		Answer answer = answerRepo.findById(id)
				.orElseThrow(() -> new AnswerNotFoundException("Invalid answer Id:" + id));
		answerRepo.delete(answer);
		
		return "redirect:../list";
	}
	
	

	
    @ExceptionHandler(AnswerNotFoundException.class)
    // @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Answer")
    public ModelAndView handleAnswerNotFoundExceptionn(
    		HttpServletRequest req, 
    		AnswerNotFoundException ex,
    		Model model) {
    	System.out.println("AnswerNotFoundException");
    	System.out.println(ex.getMessage());
        ModelAndView mav = new ModelAndView();
        model.addAttribute("exception", ex);
        model.addAttribute("errmsg", ex.getMessage());
        model.addAttribute("url", req.getRequestURL());
        mav.setViewName("notfound-answer");
        return mav;
        
    }
}

