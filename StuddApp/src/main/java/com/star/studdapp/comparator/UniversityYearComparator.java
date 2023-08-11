/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp.comparator;


import com.star.studdapp.model.University;
/**
 *
 * @author Star
 */
public class UniversityYearComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}