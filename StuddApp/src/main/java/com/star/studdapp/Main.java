/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp;

import com.star.studdapp.enums.*;
import com.star.studdapp.io.XlsReader;
import com.star.studdapp.model.Student;
import com.star.studdapp.model.University;
import com.star.studdapp.util.*;
import com.star.studdapp.comparator.*;
import com.star.studdapp.io.JsonWriter;
import com.star.studdapp.io.XlsWriter;
import com.star.studdapp.io.XmlWriter;
import com.star.studdapp.model.FullInfo;
import com.star.studdapp.model.Statistics;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 *
 * @author Star
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
}