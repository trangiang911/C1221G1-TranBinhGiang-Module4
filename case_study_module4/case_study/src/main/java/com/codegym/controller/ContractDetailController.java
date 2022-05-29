package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.IAttachService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
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
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    IContractDetailService iContractDetailService;
    @Autowired
    IContractService iContractService;

    @Autowired
    IAttachService iAttachService;
//    @GetMapping("")
//    public String list(Model model,
//                       @RequestParam Optional<String> sort,
//                       @PageableDefault(value = 5,sort = {})Pageable pageable){
//        String sortBy=sort.orElse("");
//        model.addAttribute("sort",sortBy);
//        model.addAttribute("contractDetail",this.iContractDetailService.findAll(pageable));
//        model.addAttribute("contracts",this.iContractService.findAll());
//        model.addAttribute("attach",this.iAttachService.findAll());
//        return "/contractDetail/list-contract-detail";
//    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("contracts",this.iContractService.findAll());
            model.addAttribute("attachs",this.iAttachService.findAll());
            return "contract/contract-create";
        }else {
            ContractDetail contractDetail=new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            this.iContractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("mess","OK!");
            return "redirect:/contract/";
        }
    }
}
