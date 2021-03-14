package com.example.xunhuan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class XunhuanApplicationTests {


    public static ArrayList<ArrayList<String>>ininData(List<String> args){
        HashMap <String, ArrayList <String>> data= new HashMap <>();
        ArrayList<String> info1 = new ArrayList<>();
        info1.add("1");
        data.put("1",info1);
        ArrayList<String> info12 = new ArrayList<>();
        info12.add("A");
        info12.add("B");
        info12.add("C");
        data.put("2",info12);
        ArrayList<String> info123 = new ArrayList<>();
        info123.add("D");
        info123.add("E");
        info123.add("F");
        data.put("3",info123);
        ArrayList<String> info1234 = new ArrayList<>();
        info1234.add("G");
        info1234.add("H");
        info1234.add("I");
        data.put("4",info1234);
        ArrayList<String> info12345 = new ArrayList<>();
        info12345.add("J");
        info12345.add("K");
        info12345.add("L");
        data.put("5",info12345);
        ArrayList<String> info123456 = new ArrayList<>();
        info123456.add("M");
        info123456.add("N");
        info123456.add("O");
        data.put("6",info123456);
        ArrayList<String> info1234567 = new ArrayList<>();
        info1234567.add("P");
        info1234567.add("Q");
        info1234567.add("R");
        info1234567.add("S");
        data.put("7",info1234567);
        ArrayList<String> info1234578 = new ArrayList<>();
        info1234578.add("T");
        info1234578.add("U");
        info1234578.add("V");
        data.put("8",info1234578);
        ArrayList<String> info12345789 = new ArrayList<>();
        info12345789.add("W");
        info12345789.add("X");
        info12345789.add("Y");
        info12345789.add("Z");
        data.put("9",info12345789);
        ArrayList<String> group = new ArrayList<>();
        group.add("*");
        data.put("*",group);

        ArrayList<String> group1 = new ArrayList<>();
        group1.add("0");
        data.put("0",group1);

        ArrayList<String> group2 = new ArrayList<>();
        group2.add("#");
        data.put("#",group2);

        ArrayList<ArrayList<String>>target =new ArrayList <>();

        for (String parm:args) {
               target.add(data.get(parm));
        }

        return target;
    }

    public static void main(String[] args) {
       System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        List<String>parm = Arrays.asList(str1.split(","));
        List arrList = new ArrayList(parm);
        if(parm.contains("0")){
            System.out.println("0");
            ArrayList<String> info1 = new ArrayList<>();
            info1.add("0");
            arrList.removeAll(info1);

        }else if(parm.contains("1")){
            System.out.println("1");
            ArrayList<String> info1 = new ArrayList<>();
            info1.add("1");

            arrList.removeAll(info1);

        }
        ArrayList<ArrayList<String>> totalFiles = ininData(arrList);


      
        ArrayList <ArrayList <String>> allzuhe = new ArrayList <>();

        int all = totalFiles.size();
        int nCurDeep = 0;
        IntPair cTotalAndCurIndex = new IntPair();
        cTotalAndCurIndex.a = all;
        cTotalAndCurIndex.b = nCurDeep;

        ArrayList <Integer> vecInt = new ArrayList <>();
        ArrayList <Integer> vecInt2 = new ArrayList <>();
        LoopForCombination(totalFiles, cTotalAndCurIndex, vecInt, vecInt2, allzuhe);

    }
    @Test
    void contextLoads() {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String [] str =str1.split(",");
        String [] newArray;
        if(Arrays.asList(str1.split(",")).contains("0")||Arrays.asList(str1.split(",")).contains("1")){
            System.out.println("0");
            newArray = new String[str.length-1];
            for (int i = 0; i < str.length; i++) {
                if(str[i]!="0"||str[i]!="1"){
                    newArray[i]=str[i];
                }
            }

        }
        ArrayList<ArrayList<String>> totalFiles = ininData(Arrays.asList(str1.split(",")));


        //可以
       /* totalFiles.add(aaa);
        totalFiles.add(bbb);
        totalFiles.add(ccc);*/
        //totalFiles.add(ddd);
            ArrayList <ArrayList <String>> allzuhe = new ArrayList <>();

            int all = totalFiles.size();
            int nCurDeep = 0;
            IntPair cTotalAndCurIndex = new IntPair();
            cTotalAndCurIndex.a = all;
            cTotalAndCurIndex.b = nCurDeep;

            ArrayList <Integer> vecInt = new ArrayList <>();
            ArrayList <Integer> vecInt2 = new ArrayList <>();
            LoopForCombination(totalFiles, cTotalAndCurIndex, vecInt, vecInt2, allzuhe);

    }

    public static int deleteVecBehindSepVal(ArrayList <Integer> vecInt, int nDeletePos)
    {
        if(nDeletePos== 0)
        {
            vecInt.clear();
        }
        else
        {
            if(nDeletePos >= 1)
            {
                vecInt.remove(nDeletePos);
            }
        }
        return 0;
    }

    public static void LoopForCombination(ArrayList <ArrayList <String>> totalFiles, IntPair cTotalAndCurIndex, ArrayList <Integer> vecInt, ArrayList <Integer> vecInt2, ArrayList <ArrayList <String>> allZuhes)
    {

        vecInt.add(cTotalAndCurIndex.b);
        for(int i = 0; i < totalFiles.get(cTotalAndCurIndex.b).size(); i++)
        {
            if(cTotalAndCurIndex.a > 1)
            {
                cTotalAndCurIndex.a--;
                cTotalAndCurIndex.b++;
                vecInt2.add(i);
                LoopForCombination(totalFiles,cTotalAndCurIndex,vecInt,vecInt2,allZuhes);
            }
            else
            {
                ArrayList<String> strTempArr = new ArrayList<>();
                for(int j = 0; j < vecInt2.size(); j++)
                {
                    strTempArr.add(totalFiles.get(vecInt.get(j)).get(vecInt2.get(j)));
                    System.out.print(totalFiles.get(vecInt.get(j)).get(vecInt2.get(j)) + " ");
                }
                strTempArr.add(totalFiles.get(cTotalAndCurIndex.b).get(i));
                System.out.println(totalFiles.get(cTotalAndCurIndex.b).get(i));
                allZuhes.add(strTempArr);
            }
        }

        deleteVecBehindSepVal( vecInt, cTotalAndCurIndex.b);
        cTotalAndCurIndex.a++;
        cTotalAndCurIndex.b--;
        deleteVecBehindSepVal( vecInt2,cTotalAndCurIndex.b);
        return;
    }

    public static class IntPair {
        public int a = 0;
        public int b = 0;
    }

}
