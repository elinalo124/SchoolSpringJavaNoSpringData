package com.elina.SchoolSpringJavaNoSD.controller;

import java.util.List;

import com.elina.SchoolSpringJavaNoSD.entity.Course;
import com.elina.SchoolSpringJavaNoSD.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


public class CourseController {
    @Autowired
    private CourseService courseService;


    //CREATE
    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course newCourse){
        System.out.println("Controller is saving:\n"+newCourse);
        courseService.saveCourse(newCourse);
    }

    //RETRIEVE
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Long id){
        Course course = courseService.getCourse(id);
        System.out.println("get Course\n"+ course);
        return course;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> courses = courseService.getCourses();
        System.out.println("All courses\n"+courses);
        return courses;
    }
    //UPDATE
    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course newCourse) {
        courseService.saveCourse(newCourse);
    }

    //DELETE
    @DeleteMapping("/courses/{id}")
    void deleteEmployee(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    /*
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

     */
}
