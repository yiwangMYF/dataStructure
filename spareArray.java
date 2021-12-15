package dataStructure;

import java.util.*;

/**
 * @Description 稀疏数组与二维数组的互转。稀疏数组用于当一个数组中的大部分数据都是相同的情况（一般为无效数据）下，减少数据存储。
 *              稀疏数组的第一行存储二维数组的行数、列数和有效数据的个数，其他行存储的有效数据所属的行、列和值。
 * @Author myf
 * @CreateDate 2021/11/29 11:25
 * @Version 1.0
 **/
public class spareArray {
    public static void main(String[] args) {
        int[][] testArr= new int[10][10];
        testArr[0][1]=1;
        testArr[1][4]=1;
        testArr[2][3]=1;
        testArr[3][2]=1;
        System.out.println("before:"+Arrays.deepToString(testArr));
        int[][] ints = ddArrayToSpareArray(testArr);
        System.out.println("after:"+Arrays.deepToString(ints));
        System.out.println("return:"+Arrays.deepToString(spareArrayToDdArray(ints)));
    }

    /**
     *  二维数组转稀疏数组
     * @param ddArray
     * @return
     */
    public static int[][] ddArrayToSpareArray(int[][] ddArray){
        int sum=0;
        List<Map> temp= new ArrayList<>();
        for (int i = 0; i < ddArray.length; i++) {
            for (int j = 0; j < ddArray[i].length; j++) {
                if (ddArray[i][j]!=0) {
                    //有效数据
                    sum++;
                    HashMap<Object, Object> map = new HashMap<>(3);
                    map.put("row",i);
                    map.put("col",j);
                    map.put("value",ddArray[i][j]);
                    temp.add(map);
                }
            }
        }
        int[][] spareArr;
        if (sum!=0) {
            spareArr=new int[sum+1][3];
            //首行数据为二维数组的信息
            spareArr[0][0]=ddArray.length;
            spareArr[0][1]=ddArray[0].length;
            spareArr[0][2]=sum;
            int index=1;
            for (Map map:temp) {
                //填充有效数据
                spareArr[index][0]= (int) map.get("row");
                spareArr[index][1]= (int) map.get("col");
                spareArr[index][2]= (int) map.get("value");
                index++;
            }
        }else {
            spareArr=new int[1][3];
            spareArr[0][0]=ddArray.length;
            spareArr[0][1]=ddArray[0].length;
            spareArr[0][2]=0;
        }
        return spareArr;
    }
    
    /**
    * @Author myf
    * @Description //TODO 稀疏数组转二维数组
    * @Date 2021/11/29 13:46
    * @Param 
    * @return 
    */
    public static int[][] spareArrayToDdArray(int[][] spareArray){
        int rows=spareArray[0][0];
        int cols=spareArray[0][1];
        int sum=spareArray[0][2];

        int[][] ddArray = new int[rows][cols];
        for (int i = 1; i <= sum; i++) {
            int row=spareArray[i][0];
            int col=spareArray[i][1];
            int value=spareArray[i][2];
            ddArray[row][col]=value;
        }
        return ddArray;
    }
}
