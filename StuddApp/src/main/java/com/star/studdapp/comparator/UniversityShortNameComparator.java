/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp.comparator;


import com.star.studdapp.model.University;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author Star
 */
public class UniversityShortNameComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
