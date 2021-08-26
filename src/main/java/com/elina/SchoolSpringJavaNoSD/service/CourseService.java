package com.elina.SchoolSpringJavaNoSD.service;
import com.elina.SchoolSpringJavaNoSD.entity.Course;

import java.util.List;

public interface CourseService {
    public List <Course> getCourses();

    public void saveCourse(Course theCourse);

    public Course getCourse(Long theId);

    public void deleteCourse(Long theId);
}
