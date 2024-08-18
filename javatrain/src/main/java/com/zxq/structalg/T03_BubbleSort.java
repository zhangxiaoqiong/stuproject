package com.zxq.structalg;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class T03_BubbleSort {

    public static int[] bubbleSort(int[] dataset){

        for (int i=0; i<dataset.length-1 ;i++ ){

            for (int j=0; j<dataset.length-i-1 ;j++){

                if (dataset[j+1]<dataset[j]){
                    int tmp = dataset[j];
                    dataset[j] = dataset[j+1];
                    dataset[j+1] = tmp;
                }
                System.out.println(Arrays.toString(dataset));
            }
            System.out.println("-----");
            System.out.println(Arrays.toString(dataset));
        }
        return dataset;
    }

    public static void main(String[] args) {
//        int[] ds = new int[]{3,2,4,1,6,5,8,9,7};
        int[] ds = new int[]{9,8,7,6,5,4,3,2,1};

        bubbleSort(ds);
    }
 }
