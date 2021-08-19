package com.elina.SchoolSpringJavaNoSD.controller;

import java.util.List;

import com.elina.SchoolSpringJavaNoSD.entity.Course;
import com.elina.SchoolSpringJavaNoSD.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listCourses(Model theModel) {
        List < Course > theCourses = courseService.getCourses();
        theModel.addAttribute("courses", theCourses);
        return "list-courses";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Course theCourse = new Course();
        theModel.addAttribute("course", theCourse);
        return "course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {
        courseService.saveCourse(theCourse);
        return "redirect:/course/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("courseId") int theId,
                                    Model theModel) {
        Course theCourse = courseService.getCourse(theId);
        theModel.addAttribute("course", theCourse);
        return "course-form";
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam("courseId") int theId) {
        courseService.deleteCourse(theId);
        return "redirect:/course/list";
    }
}
