package com.elina.SchoolSpringJavaNoSD.repository;

import com.elina.SchoolSpringJavaNoSD.entity.Course;

import java.util.List;

public interface CourseRepository {
    public List< Course > getCourses();

    public void saveCourse(Course theCourse);

    public Course getCourse(int theId);

    public void deleteCourse(int theId);
}
