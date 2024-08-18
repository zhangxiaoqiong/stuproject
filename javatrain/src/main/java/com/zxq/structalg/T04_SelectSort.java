package com.zxq.structalg;

import java.util.Arrays;

public class T04_SelectSort {

    public static int[] selectSort(int[] dataset){

        for (int i=0; i< dataset.length-1; i++ ){
            for (int j=i+1; j<dataset.length; j++){
                if(dataset[j]<dataset[i]){
                    int tmp = dataset[i];
                    dataset[i] = dataset[j];
                    dataset[j] = tmp;
                }
                System.out.println(Arrays.toString(dataset));
            }
            System.out.println("-----");
            System.out.println(Arrays.toString(dataset));
        }
        return  dataset;
    }

    public static void main(String[] args) {
        int[] ds = new int[]{3,2,4,1,6,5,8,9,7};

        selectSort(ds);
    }
}
