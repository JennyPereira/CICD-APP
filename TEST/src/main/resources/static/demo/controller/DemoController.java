package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.CircuitoService;
import com.demo.service.DistritoService;
import com.demo.service.SubcircuitoService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value= {"","demo"})
public class DemoController {

	@Autowired 
	private DistritoService distritoService;
	
	@Autowired 
	private CircuitoService circuitoService;
	
	@Autowired 
	private SubcircuitoService subcircuitoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("distritos", distritoService.findAll());
		return "templates/index";
	}

	@ResponseBody
	@RequestMapping(value = "loadCircuitosByDistrito/{id}", method = RequestMethod.GET)
	public String loadCircuitosByDistrito(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(circuitoService.findByDistrito(id));
	}

	@ResponseBody
	@RequestMapping(value = "loadSubcircuitosByCircuito/{id}", method = RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		return gson.toJson(subcircuitoService.findByCircuto(id));
	}

}
