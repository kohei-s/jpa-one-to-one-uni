package com.koheis.jpaonetoone.dao;

import com.koheis.jpaonetoone.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
}
