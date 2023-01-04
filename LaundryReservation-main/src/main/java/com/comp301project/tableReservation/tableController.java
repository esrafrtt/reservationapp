package com.comp301project.tableReservation;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.comp301project.AboutTime.TimeHandler;
import com.comp301project.tableService.tableService;
import com.comp301project.database.WriteDefaultData;

@Controller
public class tableController {
	
	@GetMapping
	public ModelAndView get(Model model) {
		model.addAttribute("alltables",tableService.gettableServiceInstance().getAlltables());
		model.addAttribute("currentTime",TimeHandler.getTimeHandlerObject());
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	
	@PostMapping
	@ResponseBody
	public ModelAndView post(@RequestParam String value,Model model) throws IOException {
		if(value.equals("increaseHour") || value.equals("decreaseHour")) {
			TimeHandler.getTimeHandlerObject().handleTime(value);
		}
		else if(value.equals("reset")){
			WriteDefaultData.getInstance().returnToDefaults();
		}
		else {
			tableService.gettableServiceInstance().gettableById(value).makeReservation(TimeHandler.getTimeHandlerObject().getCurrentHour());
		}
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("redirect:/");
	    return modelAndView;
	}
		
}