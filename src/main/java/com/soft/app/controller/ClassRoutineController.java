package com.soft.app.controller;

import java.util.Optional;

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

	@Autowired private ClassRoutineReopsitory classRoutineRepository;
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
	
	
	@RequestMapping(value="**/manager/add-addRoutine", method=RequestMethod.POST)
	public String addRoutine(@ModelAttribute("classRoutine")ClassRoutine classRoutine) {
		classRoutineRepository.save(classRoutine);
		return "redirect:manager/viewRoutine";
	}
	
	@RequestMapping(value="**/manager/viewRoutine", method=RequestMethod.GET)
	public String viewRoutine(Model model) {
		model.addAttribute("routineList", classRoutineRepository.findAll());
		return "manager_viewRoutine";	
	}
	
	@RequestMapping(value="**/manager/updateClassRoutine", method=RequestMethod.GET)
	public String loadUpdatePage(@RequestParam("id")Long id, Model model, Model model1, Model model2) {
		Optional<ClassRoutine>classroutine=classRoutineRepository.findById(id);
		ClassRoutine classRoutine =classroutine.get();
		model.addAttribute("classRoutine", classRoutine);
		model1.addAttribute("classList", classRepository.findAll()); 
		model2.addAttribute("batchList", batchRepository.findAll()); 
		return "manager_updateRoutine";
	}
	
	@RequestMapping(value="**/manager/update-updateClassRoutine", method=RequestMethod.POST)
	public String updateRoutine(@ModelAttribute("classRoutine")ClassRoutine classRoutine) {
		classRoutineRepository.save(classRoutine);
		return "redirect:/manager/viewRoutine";
		
	}
	
	@RequestMapping(value="**/manager/deleteClassRoutine", method=RequestMethod.GET)
	public String deleteRoutine(@RequestParam("id")Long id) {
		classRoutineRepository.deleteById(id);
		return "redirect:/manager/viewRoutine";
	}
}
