package yncrea.lab04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yncrea.lab04.core.entity.Company;
import yncrea.lab04.core.service.CompanyService;

@Controller
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping("/list")
    public String getListOfCompanies(ModelMap modelMap) {
        modelMap.put("companies", companyService.findAllWithProjects());
        return "companiesList";
    }
}
    @RequestMapping(value = "/form")
    public String getForm(ModelMap modelMap) {
        modelMap.addAttribute("company", new Company());
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:list";
    }
