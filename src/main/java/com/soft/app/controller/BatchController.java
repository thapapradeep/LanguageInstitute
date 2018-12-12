package com.soft.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.app.model.Batch;
import com.soft.app.repository.BatchRepository;

@Controller
public class BatchController {
	@Autowired private BatchRepository batchRepository;
	
	@ModelAttribute("batch")
	public Batch getBatch() {
		return new Batch();
	}
	
	
	@RequestMapping(value="**/manager/addBatch", method=RequestMethod.GET)
	public String loadAddBatchPage() {
		return "manager_addBatch";
		
	}
	
	@RequestMapping(value="**/manager/add-addBatch", method=RequestMethod.POST)
	public String addBatcch(@ModelAttribute("batch")Batch batch) {
		batchRepository.save(batch);
		return "redirect:/manager/viewBatch";
	}
	
	@RequestMapping(value="**/manager/viewBatch", method=RequestMethod.GET)
	public String loadViewBatchPage(Model model) {
		model.addAttribute("batchList", batchRepository.findAll());
		return"manager_viewBatch";
	}
	
	
	@RequestMapping(value="**/manager/updateBatch", method=RequestMethod.GET)
	public String loadBatchUpdatePage(@RequestParam("id")Long id, Model model) {
		Optional<Batch>batch=batchRepository.findById(id);
		
		Batch ba=batch.get();
		model.addAttribute("batch", ba);
		return "manager_updateBatch";
	}
	
	@RequestMapping(value="**/manager/update-updateBatch", method=RequestMethod.POST)
	public String updateBatch(@ModelAttribute("batch")Batch batch){
		batchRepository.save(batch);
		return "redirect:/manager/viewBatch";
		
		
	}
	
	@RequestMapping(value="**/manager/deleteBatch", method=RequestMethod.GET)
	public String deleteBatch(@RequestParam("id")Long id) {
		batchRepository.deleteById(id);
		return "redirect:/manager/viewBatch";
	}

}
