/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp.enums;

/**
 *
 * @author Star
 */
public enum StudyProfile {
    PHYSICS("������"),
    COMPUTER_SCIENCE("�����������"),
    MATHEMATICS("����������"),
    JURISPRUDENCE("�������������"),
    MEDICINE("��������"),
    LINGUISTICS("�����������");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}