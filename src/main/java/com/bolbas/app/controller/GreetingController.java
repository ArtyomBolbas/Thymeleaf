package com.bolbas.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolbas.app.dao.MessageRepo;
import com.bolbas.app.model.Message;
import com.bolbas.app.thymeleaf.model.MessageForm;

@Controller
public class GreetingController {

	@Autowired
	private MessageRepo messageRepo;
	
	// Вводится (inject) из application.properties.
	@Value("${error.message}")
	private String errorMessage;
	
	/*@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Map<String, Object> model) {
		model.put("name", name);
		return "greeting";
	}
	
	@RequestMapping(value={"/main"}, method=RequestMethod.GET)
	public String main(Model model) {
		Iterable<Message> messages = messageRepo.findAll();
		model.addAttribute("messages", messages);
		
	  	MessageForm messageForm = new MessageForm();
        model.addAttribute("messageForm", messageForm);
		return "main";
	}
	
	@RequestMapping(value={"/main"}, method=RequestMethod.POST)
	public String add(Model model, @ModelAttribute("messageForm") MessageForm messageForm) {
		/*Message message = new Message(text, tag);*/
		/*System.out.println("text = " + messageForm.getText() + "; tag = " + messageForm.getTag());
		String text = messageForm.getText();
		String tag = messageForm.getTag();
		
		if(text != null && !text.isEmpty() && tag != null && !tag.isEmpty()) {
			Message message = new Message(text, tag);
			messageRepo.save(message);
		} else {
			model.addAttribute("errorMessage", errorMessage);
		}

		Iterable<Message> messages = messageRepo.findAll();
		model.addAttribute("messages", messages);
		return "main";
	}*/
	
	@GetMapping
	public String main(Map<String, Object> model) {
		Iterable<Message> messages = messageRepo.findAll();
		model.put("messages", messages);
		return "main";
	}
	
	@PostMapping
	public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
		Message message = new Message(text, tag);
		messageRepo.save(message);
		
		Iterable<Message> messages = messageRepo.findAll();
		model.put("messages", messages);
		return "main";
	}

}