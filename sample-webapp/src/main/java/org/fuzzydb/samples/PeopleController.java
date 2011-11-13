package org.fuzzydb.samples;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.validation.Valid;

import org.fuzzydb.samples.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.thoughtworks.xstream.XStream;
import com.wwm.db.query.Result;
import com.wwm.db.spring.repository.AttributeMatchQuery;
import com.wwm.db.spring.repository.SubjectMatchQuery;

/**
 * Example controller for creating fuzzy items and querying them
 */
@Controller
@RequestMapping("/people")
public class PeopleController extends AbstractDataController {


	@Autowired
	private PersonRepository personRepo;


	
	@Transactional
	@RequestMapping(value="/createPeople", method=RequestMethod.GET) 
	public ModelAndView createPeople(@RequestParam(defaultValue="5") int numPeople) {
		
		for (int i = 0; i < numPeople; i++) {
			personRepo.save(dataGenerator.createRandomPerson());
		}
		return new ModelAndView(new RedirectView("search", false, true, false)); //"redirect:/search";
	}

	@Transactional(readOnly=true)
	@RequestMapping(value="/search", method=RequestMethod.POST) 
	public String search(
			@RequestParam(defaultValue="similarPeople") String style,
			@RequestParam(defaultValue="0") int start,
			@RequestParam(defaultValue="10") int pageSize,
			Model model, 
			@ModelAttribute("command") @Valid Person form, 
			Errors result) {
		
		Pageable pageable = new PageRequest(start, pageSize);
		doSearch(model, style, null, pageable, form);
		
		return "results";
	}

	/**
	 * 
	 * @param style The name of the matching configuration or 'style'
	 * @param ref A database reference - something we probably don't want in a real app
	 * @param maxResults This lets the database know the maximum number of results you're going to iterate over
     *	 		you could potentially feed results out as you get them, so long as you've got the 
	 *			transaction held open... hmmm. I feel some Ajax coming on ;)
	 */
	@Transactional(readOnly=true)
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String findMatches(
			Model model, 
			@RequestParam(defaultValue="similarPeople") String style,
			@RequestParam(required=false) String ref,
			@RequestParam(defaultValue="0") int start,
			@RequestParam(defaultValue="10") int pageSize) {
	
		// We need some attributes to search against.  This doesn't have to be something already in the 
		// database.  For the default, we'll just grab a named sample from our dataGenerator.
		// If we have a key (ref), then we'll use that to grab an item.
		Person idealMatch = StringUtils.hasText(ref) ? personRepo.findOne(ref) : dataGenerator.createPerson("Matt");

		Pageable pageable = new PageRequest(start/pageSize, pageSize);
		doSearch(model, style, ref, pageable, idealMatch);
		model.addAttribute("command", new Person("Entered search"));
		return "results";
	}

	@ModelAttribute("newspapers")
	public ArrayList<String> getNewspaperOptions() {
		return getOptionsForField("newspapers");
	}
	
	@ModelAttribute("smokeOptions")
	public ArrayList<String> getSmokeOptions() {
		return getOptionsForField("smoke");
	}

	protected void doSearch(Model model, String style, String ref,
			Pageable pageable, Person idealMatch) {
		// requested match style
		int maxResults = pageable.getOffset() + pageable.getPageSize(); 
		AttributeMatchQuery<Person> query = new SubjectMatchQuery<Person>(idealMatch, style, maxResults);
		
		// Do the actual query
		Page<Result<Person>> results = personRepo.findMatchesFor(query, pageable);
				
		// Stick 'em in our model for our view to render
		model.addAttribute("subject", idealMatch);
		model.addAttribute("ref", ref);
		model.addAttribute("results", results.getContent());
		model.addAttribute("style", style);
		model.addAttribute("startNextPage", results.hasNextPage() ? maxResults : -1);
		model.addAttribute("pageSize", results.getSize());
	}


	@Transactional(readOnly=true)
	@RequestMapping(value="/dump", method=RequestMethod.GET)
	public void dump(OutputStream response) throws IOException {

		Iterable<Person> people = personRepo.findAll();
		
		XStream xs = new XStream();
		
		for (Person item : people) {
			xs.toXML(item, response);
		}
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/dumpMatches", method=RequestMethod.GET)
	public void dumpMatches(
			Model model, 
			@RequestParam(defaultValue="Matt") String name,
			@RequestParam(defaultValue="similarPeople") String style,
			OutputStream response) {
	
		Person subject = dataGenerator.createPerson(name);
		int maxResults = 10; 
		AttributeMatchQuery<Person> query = new SubjectMatchQuery<Person>(subject, style, maxResults + 1); // + 1 so we can check if there are more results
		Iterator<Result<Person>> resultIterator = personRepo.findMatchesFor(query);
		
		XStream xs = new XStream();
		
		for (Iterator<Result<Person>> iterator = resultIterator; iterator.hasNext();) {
			Result<Person> item = iterator.next();
			
			xs.toXML(item.getItem(), response);
		}
	}
}
