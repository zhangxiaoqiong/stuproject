package com.zxq.structalg;

/**
 * @author zhangxiaoqiong
 * @desc xxx
 * @date 2021/7/12 10:55
 */
public class T01_HanoiTower {

    public static void main(String[] args) {
        int n = 5;
        doTower(n, 'A','B','C');

    }

    public static void doTower(int topN, char from, char inter, char to){

        if (topN == 1){
            System.out.println("Disk 1 from "
                    + from + " to " + to);
        }else {
            doTower(topN - 1, from, to, inter);
            System.out.println("Disk "
                    + topN + " from " + from + " to " + to);
            doTower(topN - 1, inter, from, to);
        }

    }
}
