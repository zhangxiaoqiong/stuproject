package com.zxq.structalg;

/**
 * 顺序查找和二分查找
 */
public class T02_LinearSearch {

    public static Integer linearSearch(int[] dataset,int value){
        for(int v: dataset){
            if(v==value){
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int s = 3;
        int[] ds = new int[]{1,2,3};
        System.out.printf("result:"+linearSearch(ds, s));
    }
}
