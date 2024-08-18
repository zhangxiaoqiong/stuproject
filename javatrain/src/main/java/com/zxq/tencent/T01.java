package com.zxq.tencent;

import java.util.*;

public class T01 {

    public static void main(String[] args) {

        String[] t = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(t);
        for(List<String> tt : lists) {
            System.out.printf("\n--\n");
            for (String s: tt) {
                System.out.printf(s);
            }
        }

    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<List<String>>();
            HashMap<String, ArrayList<String>> mp = new HashMap<String, ArrayList<String>>();
            for(String str: strs){
                char[] ch = str.toCharArray();
                for(int i=0;i<ch.length;i++){
                    for(int j=i;j<ch.length;j++){
                        if(ch[j]>ch[i]){
                            char tm = ch[i];
                            ch[i]=ch[j];
                            ch[j]=tm;
                        }
                    }

                }

                String tmp = new String(ch);
                System.out.printf("-"+tmp);
                if(mp.get(tmp)!=null){
                    ArrayList<String> al = mp.get(tmp);
                    al.add(str);
                    mp.put(tmp, al);
                }else{
                    ArrayList<String> tt0 = new ArrayList<String>();
                    tt0.add(tmp);
                    mp.put(tmp, tt0);
                }
            }
            Collection<ArrayList<String>> values = mp.values();
            res = new ArrayList<List<String>>(values);
            return  res;
        }
    }
}
