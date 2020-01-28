package yncrea.lab04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yncrea.lab04.core.entity.Company;
import yncrea.lab04.core.service.CompanyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CompanyController {

    private CompanyService companyService;

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/list")
    public String getListOfCompanies(ModelMap modelMap) {
        modelMap.put("companies", companyService.findAllWithProjects());
        logger.debug("List of companies displayed.");
        return "companiesList";
    }

    @RequestMapping(value = "/form")
    public String getForm(ModelMap modelMap) {
        modelMap.addAttribute("company", new Company());
        logger.debug("Company adding form.");
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("company") Company company) {
        companyService.save(company);
        logger.debug("Company added.");
        return "redirect:list";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable long id) {
        companyService.deleteById(id);
        logger.debug("Company deleted, ID : ", id, " .");
        return "redirect:/list";
    }
}