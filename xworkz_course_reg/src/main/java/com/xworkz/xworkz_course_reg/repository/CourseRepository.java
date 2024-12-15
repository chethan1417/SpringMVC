package com.xworkz.xworkz_course_reg.repository;

import com.xworkz.xworkz_course_reg.entity.CourseEntity;

public interface CourseRepository {
    CourseEntity findByEmail(String email);

    boolean save(CourseEntity courseEntity);
}
