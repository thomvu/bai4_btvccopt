/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai4_bt2;

import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import static spark.Spark.get;

/**
 *
 * @author Thom
 */
public class GuavaTest {
    
    public static void main(String[] args) {
        GuavaTest guavaTest = new GuavaTest();
        get("prime", "application/json", (request, response) -> {
            String id = request.queryParams("n");
            return guavaTest.getStudentUsingGuava(Integer.parseInt(id));
        });
        //vu thi thom
        //test confict
        //fđffdfffdnfjdnfjdnf
        //bai tap lan 1
        //english
//        try {
//            // Access student first time with id 1, getStudentUsingGuava() will
//            // be called.
//            System.out.println(guavaTest.getStudentUsingGuava(100));
//            System.out.println("------------------------");
//
//            // The second time we get student, data will cache
//            System.out.println(guavaTest.getStudentUsingGuava(100));
//        } catch (ExecutionException e) {
//        }
    }

    private String getStudentUsingGuava(int id) throws ExecutionException {
        LoadingCache<Integer, String> cache = Bai4.getLoadingCache();
        System.out.println("Cache Size:" + cache.size());
        return cache.get(id);
    }

}
