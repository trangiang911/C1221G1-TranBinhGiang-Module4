package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    IContractDetailService iContractDetailService;
    @Autowired
    IAttachService iAttachService;
    @GetMapping("")
    public String list(Model model,
                       @RequestParam Optional<String> sort,
                       @RequestParam Optional<String> employee,
                       @RequestParam Optional<String> customer,
                       @RequestParam Optional<String> service,
                       @PageableDefault(value = 5,sort = {}) Pageable pageable){
        String sortBy=sort.orElse("");
        String employeeVal=employee.orElse("%");
        String customerVal=customer.orElse("%");
        String serviceVal=service.orElse("%");
        model.addAttribute("employee",employeeVal);
        model.addAttribute("customer",customerVal);
        model.addAttribute("service",serviceVal);
        model.addAttribute("sort",sortBy);
        model.addAttribute("contracts",this.iContractService.findAndSearch(employeeVal,customerVal,serviceVal,pageable));
        model.addAttribute("employees",this.iEmployeeService.findAll());
        model.addAttribute("customers",this.iCustomerService.findAll());
        model.addAttribute("services",this.iFacilityService.findAll());
       return "contract/list-contract";
    }
    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("employees",this.iEmployeeService.findAll());
        model.addAttribute("customers",this.iCustomerService.findAll());
        model.addAttribute("services",this.iFacilityService.findAll());
        return "contract/contract-create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDto contractDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("employees",this.iEmployeeService.findAll());
            model.addAttribute("customers",this.iCustomerService.findAll());
            model.addAttribute("services",this.iFacilityService.findAll());
            return "contract/contract-create";
        }else {
            Contract contract=new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            this.iContractService.save(contract);
            model.addAttribute("contractDetailDto",new ContractDetailDto());
            model.addAttribute("attachs",this.iAttachService.findAll());
            model.addAttribute("contracts",this.iContractService.findAll());
//            redirectAttributes.addFlashAttribute("mess","OK!");
            return "contract/contract-detail-create";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") List<Integer> integerList,RedirectAttributes redirectAttributes){
        this.iContractService.delete(integerList);
        redirectAttributes.addFlashAttribute("mess","ok");
        return "redirect:/contract/";
    }
}
