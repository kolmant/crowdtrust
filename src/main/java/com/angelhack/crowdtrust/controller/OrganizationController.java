package com.angelhack.crowdtrust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationController {

    @GetMapping("/")
    public String getOrganizations(Model model) {
        String[] organizations = {"Cruz Roja", "EPM", "Transparencia Colombia"};
        model.addAttribute("organizations", organizations);

        return "index.html";
    }
}
