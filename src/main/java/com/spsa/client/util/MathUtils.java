package com.spsa.client.util;

public class MathUtils {

    public static double deviation(double[] v, double m){
        double sum=0;
        for(int i=0; i<v.length; i++){
            sum+=Math.pow(v[i],2.0);
        }
        return Math.sqrt(sum/v.length-Math.pow(m,2.0));
    }
}
