package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.*;
import ru.kpfu.itis.form.*;
import ru.kpfu.itis.models.*;
import ru.kpfu.itis.services.ResumeService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/resumes")
public class ResumesController {

    private ObjectMapper objectMapper = new ObjectMapper();

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
        if (resume.getId() == null) return new ModelAndView("redirect:/resumes");
        modelAndView.addObject("resume", resume);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createResume(String resumeTitle, Authentication authentication) {
        if (resumeTitle == null) return new ModelAndView("redirect:/profile");
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) authentication.getPrincipal();
        ResumeForm resumeForm = ResumeForm.builder()
                .title(resumeTitle)
                .user(user)
                .build();
        Resume resume = resumeService.createResume(resumeForm);
        modelAndView.setViewName("redirect:/resumes/" + resume.getId() + "/edit");
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditResumesPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editResume");
        Resume resume = resumeService.getById(id);
        modelAndView.addObject("resume", resume);
        return modelAndView;
    }

    @PostMapping("/update_title")
    public void updateResumeTitle(Long id, String title) {
        resumeService.updateResumeTitle(id, title);
    }

    @PostMapping("/about_me")
    public void updateResumeAboutMe(Long id, String aboutMe) {
        resumeService.updateResumeAboutMe(id, aboutMe);
    }

    @PostMapping("/add_contact")
    public void addContact(ContactDto contactDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(contactDto.getResumeId());
        ContactForm contactForm = ContactForm.builder()
                .title(contactDto.getTitle())
                .contact(contactDto.getContact())
                .resume(resume)
                .build();
        Contact contact = resumeService.addContact(contactForm);
        String json = objectMapper.writeValueAsString(contact);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/add_experience")
    public void addExperience(ExperienceDto experienceDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(experienceDto.getResumeId());
        ExperienceForm contactForm = ExperienceForm.builder()
                .title(experienceDto.getTitle())
                .description(experienceDto.getDescription())
                .place(experienceDto.getPlace())
                .workTimeInterval(experienceDto.getTime())
                .resume(resume)
                .build();
        Experience experience = resumeService.addExperience(contactForm);
        String json = objectMapper.writeValueAsString(experience);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/add_education")
    public void addEducation(EducationDto educationDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(educationDto.getResumeId());
        EducationForm educationForm = EducationForm.builder()
                .title(educationDto.getTitle())
                .place(educationDto.getPlace())
                .workTimeInterval(educationDto.getTime())
                .resume(resume)
                .build();
        Education education = resumeService.addEducation(educationForm);
        String json = objectMapper.writeValueAsString(education);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/add_interest")
    public void addInterest(InterestDto interestDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(interestDto.getResumeId());
        InterestForm interestForm = InterestForm.builder()
                .title(interestDto.getTitle())
                .resume(resume)
                .build();
        Interest interest = resumeService.addInterest(interestForm);
        String json = objectMapper.writeValueAsString(interest);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/add_language")
    public void addLanguage(LanguageDto languageDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(languageDto.getResumeId());
        LanguageForm languageForm = LanguageForm.builder()
                .language(languageDto.getLanguage())
                .level(languageDto.getLevel())
                .resume(resume)
                .build();
        Language language = resumeService.addLanguage(languageForm);
        String json = objectMapper.writeValueAsString(language);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/add_project")
    public void addProject(ProjectDto projectDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(projectDto.getResumeId());
        ProjectForm projectForm = ProjectForm.builder()
                .title(projectDto.getTitle())
                .description(projectDto.getDescription())
                .resume(resume)
                .build();
        Project project = resumeService.addProject(projectForm);
        String json = objectMapper.writeValueAsString(project);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }

    @PostMapping("/add_skill")
    public void addSkill(SkillDto skillDto, HttpServletResponse response) throws IOException {
        Resume resume = resumeService.getById(skillDto.getResumeId());
        SkillForm skillForm = SkillForm.builder()
                .title(skillDto.getTitle())
                .resume(resume)
                .build();
        Skill skill = resumeService.addSkill(skillForm);
        String json = objectMapper.writeValueAsString(skill);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }
}
