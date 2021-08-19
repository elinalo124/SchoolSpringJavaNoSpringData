package com.elina.SchoolSpringJavaNoSD.repository;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.elina.SchoolSpringJavaNoSD.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class CourseRepositoryImpl implements CourseRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Course> getCourses() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Course > cq = cb.createQuery(Course.class);
        Root < Course > root = cq.from(Course.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        Course book = session.byId(Course.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveCourse(Course theCourse) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCourse);
    }

    @Override
    public Course getCourse(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Course theCourse = currentSession.get(Course.class, theId);
        return theCourse;
    }
}
