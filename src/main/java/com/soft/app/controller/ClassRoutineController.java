package com.soft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.ClassRoutine;
import com.soft.app.repository.BatchRepository;
import com.soft.app.repository.ClassRoutineReopsitory;
import com.soft.app.repository.ClassesRepository;
import com.soft.app.repository.DayRepository;

@Controller
public class ClassRoutineController {

	//@Autowired private ClassRoutineReopsitory classRoutineRepository;
	@Autowired private DayRepository dayRepository;
	@Autowired private ClassesRepository classRepository;
	@Autowired private BatchRepository batchRepository;
	
	
	@ModelAttribute("classRoutine")
	public ClassRoutine getRoutine() {
		return new ClassRoutine();
	}
	
	
	@RequestMapping(value="**/manager/createRoutine", method=RequestMethod.GET)
	public String loadCreateRoutinePage(Model model, Model model1, Model model2) {
	model.addAttribute("dayList", dayRepository.findAll());
	model1.addAttribute("batchList", batchRepository.findAll());
	model2.addAttribute("classList", classRepository.findAll());
	return "manager_createRoutine";
	}
}
