/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp.comparator;

import com.star.studdapp.model.Student;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author Star
 */
public class StudentUniversityIdComparator implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
