package com.elina.SchoolSpringJavaNoSD.service;
import java.util.List;

import com.elina.SchoolSpringJavaNoSD.entity.Course;
import com.elina.SchoolSpringJavaNoSD.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public List <Course> getCourses() {
        return courseRepository.getCourses();
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        courseRepository.saveCourse(theCourse);
    }

    @Override
    @Transactional
    public Course getCourse(int theId) {
        return courseRepository.getCourse(theId);
    }

    @Override
    @Transactional
    public void deleteCourse(int theId) {
        courseRepository.deleteCourse(theId);
    }
}
