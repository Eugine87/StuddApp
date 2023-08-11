/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp.util;

import com.star.studdapp.model.Statistics;
import com.star.studdapp.enums.*;
import com.star.studdapp.model.*;
import org.apache.commons.lang3.StringUtils;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Star
 */
public class StatisticsUtil {

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students,
                                                    List<University> universities) {

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumberOfUniversities(profileUniversityIds.size());
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticsList;
    }
}