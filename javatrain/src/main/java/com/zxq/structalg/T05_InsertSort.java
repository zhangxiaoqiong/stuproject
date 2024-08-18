package com.zxq.structalg;

import java.util.Arrays;

public class T05_InsertSort {

    public static int[] insertSort(int[] dataset) {
        for(int i=1;i<dataset.length; i++){
            for(int j=i; j>0; j--){
                if(dataset[j]<dataset[j-1]){
                    int tmp = dataset[j-1];
                    dataset[j-1] = dataset[j];
                    dataset[j] = tmp;
                }
                System.out.println(Arrays.toString(dataset));
            }
            System.out.println("-----");
            System.out.println(Arrays.toString(dataset));
        }

        return dataset;
    }

    public static void main(String[] args) {
        int[] ds = new int[]{3,2,4,1,6,5,8,9,7};

        insertSort(ds);
    }
}
