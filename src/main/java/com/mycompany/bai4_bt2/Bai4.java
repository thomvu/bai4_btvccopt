/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai4_bt2;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.TimeUnit;
import static sun.security.x509.CertificateVersion.V1;

/**
 *
 * @author Thom
 */
public class Bai4 {

    private static LoadingCache<Integer, String> cache;

    static {
        cache = CacheBuilder.newBuilder()
                .maximumSize(100) //set size
                .expireAfterWrite(20, TimeUnit.SECONDS) //set time expire
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer k) throws Exception {
                        return getPrime(k);
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });
        /* Chinh sua tren server github */
    }

    public static LoadingCache<Integer, String> getLoadingCache() {
        return cache;
    }

    private static boolean checkPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int m = (int) Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static String getPrime(Integer n) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (checkPrimeNumber(i) == true) {
                result.append(i).append(",  ");
            }
        }
        String result1 = result.substring(0, result.length() - 3);
        return result1.toString();
    }
}
