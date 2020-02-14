package net.codejava.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.models.entity.Product;
import net.codejava.models.service.ProductService;


@RestController
public class AppController {
	@Autowired
	private ProductService service;
	
	/*Este metodo funciona sólo si se le coloca "Controller"*/
	@RequestMapping(value="/", method=RequestMethod.GET)	
	public ModelAndView viewHomePage(Map<String, Object> model) {
		List<Product> listProducts = service.listAll();
		model.put("listProducts", listProducts);
		return new ModelAndView("/index");
	}
	
	@RequestMapping(value = "/new", method=RequestMethod.GET)
	public ModelAndView showNewProduct(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		return new ModelAndView("/newProduct");
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		Map<String, Object> model;
		service.save(product);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProduct(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("edit_product");
		
		Product product = service.get(id);
		model.addObject("product", product);
		
		return model;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable(name = "id") Long id) {
	    service.delete(id);
	    return new ModelAndView("redirect:/");       
	}
	
	/*@RequestMapping("/")
	public String findProduct(Model model) {
		List<Product> listProducts = service.listAll();

	    model.addAttribute("listProducts", listProducts);

	    return "index";
	}*/
	
	/*@RequestMapping(value="/index", method=RequestMethod.GET)
	public List<Product> listProducts(Model model){
		List<Product> listProducts = service.listAll();
	    model.addAttribute("listProducts", listProducts);
		return listProducts;
	}*/
	
	/*@GetMapping(value = "/products")
	public List<Product> getProducts(Model model){
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return listProducts;
	}*/
	
	
	/*@RequestMapping(value = "/index", method = RequestMethod.GET)
	public List<Product> getAllProducts(Model model){
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return service.listAll();
	}*/
}
