package com.zohocrmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/viewLeadPage")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	@PostMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead") Lead lead, Model model) {
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
}
	@PostMapping("convertLead")
	public String convertLead(@RequestParam("id") long id) {
		Lead lead = leadService.findeadById(id);
		
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContact(contact);
		
		leadService.deleteLeadById(id);
		
		return"";
	}
	@RequestMapping("listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return"list_leads";
	}
}
