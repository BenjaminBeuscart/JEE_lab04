package yncrea.lab04.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
