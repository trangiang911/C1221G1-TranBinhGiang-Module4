package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    IRentService iRentService;
    @Autowired
    IFacilityTypeService iFacilityTypeService;
    @GetMapping("")
    public String list(Model model,
                       @RequestParam Optional<String> sort,
                       @RequestParam Optional<String> name,
                       @RequestParam Optional<String> rent,
                       @RequestParam Optional<String> type,
                       @PageableDefault(value = 5, sort = {}) Pageable pageable) {
        String nameVal = name.orElse("");
        String rentBy = rent.orElse("%");
        String typeBy = type.orElse("%");
        String sortBy= sort.orElse("");
        model.addAttribute("name",nameVal);
        model.addAttribute("rent",rentBy);
        model.addAttribute("type",typeBy);
        model.addAttribute("sort",sortBy);
        model.addAttribute("facilitys", this.iFacilityService.findAndSearch(nameVal, rentBy, typeBy, pageable));
        model.addAttribute("rents",this.iRentService.findAll());
        model.addAttribute("types",this.iFacilityTypeService.findAll());
        return "facility/list-facility";
    }
    @GetMapping(value = "/create")
    public String goCreate(Model model){
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("rents",this.iRentService.findAll());
        model.addAttribute("types",this.iFacilityTypeService.findAll());
        return "facility/facility-create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute @Validated FacilityDto facilityDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("rents",this.iRentService.findAll());
            model.addAttribute("types",this.iFacilityTypeService.findAll());
            return "facility/facility-create";
        }else {
            Facility facility=new Facility();
            BeanUtils.copyProperties(facilityDto,facility);
            this.iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("mess","OK!");
            return "redirect:/facility/";
        }
    }
    @GetMapping(value = "/edit")
    public String goEdit(@RequestParam Integer id,
                         RedirectAttributes redirectAttributes,
                         Model model){
        Facility facility= this.iFacilityService.findById(id);
        FacilityDto facilityDto=new FacilityDto();
        BeanUtils.copyProperties(facility,facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("rents",this.iRentService.findAll());
        model.addAttribute("types",this.iFacilityTypeService.findAll());
        return "/facility/edit-facility";
    }
}
