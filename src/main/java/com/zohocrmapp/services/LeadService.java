package com.zohocrmapp.services;

import java.util.List;

import com.zohocrmapp.entities.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead);

	public Lead findeadById(long id);

	public void deleteLeadById(long id);

	public List<Lead> listAllLeads();

}
