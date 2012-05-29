package org.fuzzydb.samples.mvc;

import org.fuzzydb.samples.GiveTakeItem;
import org.fuzzydb.samples.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/givetake", "/mobile/givetake"}) 
public class ProfileController extends AbstractDataController<GiveTakeItem> {


	@Autowired
	private ProfileRepository repo;

	
	@Override
	protected void createItem() {
		throw new UnsupportedOperationException();
//		repo.save(dataGenerator.createRandomCafe());
	}

	
	@Override
	protected String getDefaultSearchStyle() {
		return "GiveTake";
	}

	@Override
	protected ProfileRepository getRepo() {
		return repo;
	}

	@Override
	protected String getViewPathPrefix() {
		return "givetake";
	}

	@Override
	protected GiveTakeItem getSearchForm() {
		return new GiveTakeItem("Entered search");
	}

	
	@Override
	protected GiveTakeItem getInitialSearchEntity() {
		return new GiveTakeItem("Null item to search against");
	}
}

