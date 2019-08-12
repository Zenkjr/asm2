package com.example.demo.controller;

import com.example.demo.dto.StreetDto;
import com.example.demo.entity.District;
import com.example.demo.entity.Street;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class StreetController {
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    StreetRepository streetRepository;

    @RequestMapping(value = "/hanoi/create", method = RequestMethod.GET)
    public String Create(Model model){
        model.addAttribute("street",new StreetDto());
        model.addAttribute("districts",districtRepository.findAll());
        return "hanoi";
    }

    @PostMapping(value = "/hanoi/create")
    public String CreateStreet(Model model, @ModelAttribute("street") @Valid StreetDto streetDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("districts",districtRepository.findAll());
            model.addAttribute("street", streetDto);
            return "hanoi";
        }
        Street street = new Street();
        street.setName(streetDto.getName());
        street.setDescription(streetDto.getDescription());

        District district = districtRepository.findById(streetDto.getDistrict());
        district.setStreet(street);
        street.setDistrict(district);
        districtRepository.save(district);
        streetRepository.save(street);
        redirectAttributes.addAttribute("districts",districtRepository.findAll());
        return "redirect:/index";
//        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String Index(Model model){
        model.addAttribute("districts",districtRepository.findAll());
        return "index";
    }
}
