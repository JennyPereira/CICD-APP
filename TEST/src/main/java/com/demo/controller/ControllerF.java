package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.CircuitoRepository;
import com.demo.dao.DistritoRepository;
import com.demo.dao.SubcircuitoRepository;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = {"","demo"})
public class ControllerF {
	
	 @Autowired
	 private DistritoRepository dr;
	 
	 @Autowired
	 private CircuitoRepository cr;
	 
	 @Autowired
	 private SubcircuitoRepository sr;
	 
	 @RequestMapping(method = RequestMethod.GET)
		public String index(ModelMap modelMap) {
			modelMap.put("distritos", dr.findAll());
			return "demo/index";
		}

		@ResponseBody
		@RequestMapping(value = "loadCircuitosByDistrito/{id}", method = RequestMethod.GET)
		public String loadCircuitosByDistrito(@PathVariable("id") Long id) {
			Gson gson = new Gson();
			return gson.toJson(cr.findByDistrito(id));
		}

		@ResponseBody
		@RequestMapping(value = "loadSubcircuitosByCircuito/{id}", method = RequestMethod.GET)
		public String loadCitiesByState(@PathVariable("id") Long id) {
			Gson gson = new Gson();
			return gson.toJson(sr.findByCircuito(id));
		}
	 
}
