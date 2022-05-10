package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.services.ResumeService;

import java.util.List;

@Controller
@RequestMapping("/resumes")
public class ResumesController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public ModelAndView getResumesPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resumes");
        List<Resume> resumes = resumeService.findAll();
        modelAndView.addObject("resumes", resumes);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView openResume(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("resumePage");
        Resume resume = resumeService.getById(id);
        modelAndView.addObject("resume", resume);
        return modelAndView;
    }
}
