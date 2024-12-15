package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.frontend.controller;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Address;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Candidate;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.services.CandidateService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidate/list-no-paging";
    }

    @GetMapping("/candidates")
    public String showCandidateListPage(Model model,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage= candidateService.findAll(
                currentPage - 1,pageSize,"id","asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidate/candidateList";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Candidate> opt = candidateRepository.findById(id);
        if (opt.isPresent()) {
            Candidate candidate = opt.get();
            modelAndView.addObject("candidate", candidate);
            modelAndView.addObject("address", candidate.getAddress());
            modelAndView.addObject("countries", CountryCode.values());
            modelAndView.setViewName("candidate/updateCandidate");
        } else {
            modelAndView.setViewName("error"); // Trang lỗi nếu không tìm thấy Candidate
        }
        return modelAndView;
    }

    @Transactional
    @PostMapping("candidates/updateCandidate")
    public String updateCandidate(
            @ModelAttribute("candidate") Candidate candidate,
            @ModelAttribute("address") Address address,
            BindingResult result, Model model
    ){
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        try{
            candidateRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Error deleting candidate: " + e.getMessage(), e);
        }
        return "redirect:/candidates";
    }
    @GetMapping("/show-add-form")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        Candidate candidate = new Candidate();
        candidate.setAddress(new Address());
        modelAndView.addObject("candidate", candidate);
        modelAndView.addObject("address", candidate.getAddress());
        modelAndView.addObject("countries", CountryCode.values());
        modelAndView.setViewName("candidate/addCandidate");
        return modelAndView;
    }
    @PostMapping("candidates/addCandidate")
    public String addCandidate(
            @ModelAttribute("candidate") Candidate candidate,
            @ModelAttribute("address") Address address,
            BindingResult result, Model model
    ){
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

}
