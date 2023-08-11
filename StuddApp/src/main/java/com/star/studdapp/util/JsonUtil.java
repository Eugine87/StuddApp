/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.star.studdapp.util;


import com.google.gson.GsonBuilder;

import java.util.List;
/**
 *
 * @author Star
 */
public class JsonUtil {

    private JsonUtil() {
    }

    public static String writeListToJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
}
