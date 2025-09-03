package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String resu = createMultipleTableByTwoNumbers(2, 5);
        System.out.println("resu=\n" + resu);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }


    private static Boolean handlerLargestEvenNumber(List<Integer> list){
        return false;
    }

    private static Boolean handlerLargestEvenNumber(Set<Integer> set){
        return false;
    }


    private static String createMultipleTableByTwoNumbers(int numberA, int numberB){
        if (!verifyNumbers(numberA, numberB)){
            return null;
        }
        //constructMultiplicationResultList函数，构造乘法结果列表
        List<String> multiplicationResultList = constructMultiplicationResultList(numberA, numberB);
        //getMultipleTableWithFormat函数，获取格式化后的乘法表
        return getMultipleTableWithFormat(multiplicationResultList);
    }

    private static String getMultipleTableWithFormat(List<String> multiplicationResultList) {
        // 将 [2*2=4, 2*3=6, 2*4=8, 2*5=10, 3*3=9, 3*4=12, 3*5=15, 4*4=16, 4*5=20, 5*5=25] 转换为
        /*
         2*2=4
         2*3=6  3*3=9
         2*4=8	3*4=12  4*4=16
         2*5=10 3*5=15  4*5=20  5*5=25
        */
        // 用于拼接最终格式化的乘法表字符串
        StringBuilder sb = new StringBuilder();
        int index = 0; // 当前处理到的乘法结果索引
        int row = 1;   // 当前行需要输出的元素个数，第一行1个，第二行2个，依��递增

        // 循环直到所有乘法结果都被处理
        while (index < multiplicationResultList.size()) {
            // 每行输出row个元素
            for (int i = 0; i < row && index < multiplicationResultList.size(); i++, index++) {
                sb.append(multiplicationResultList.get(index)); // 添加乘法结果
                if (i < row - 1) {
                    sb.append("\t"); // 行内元素之间用制表符分隔
                }
            }
            sb.append("\n"); // 每行结束换行
            row++; // 下一行元素个数加1
        }
        return sb.toString(); // 返回格式化后的字符串
    }

    private static List<String> constructMultiplicationResultList(int numberA, int numberB) {
        //生成numberA到numberB的乘法结果列表，例如
        // [2*2=4, 2*3=6, 3*3=9, 2*4=8, 3*4=12, 4*4=16, 2*5=10, 3*5=15, 4*5=20, 5*5=25]
        /*
         2*2=4
         2*3=6  3*3=9
         2*4=8	3*4=12  4*4=16
         2*5=10 3*5=15  4*5=20  5*5=25
        */
        List<String> resultList = new ArrayList<>();
        for (int row=0; row<(numberB-numberA+1); row++){
            for (int col=0; col<(numberB-numberA+1); col++){
                if (col>row){
                    continue;
                }
                resultList.add(numberA+col+"*"+(numberA+row)+"="+(numberA+col)*(numberA+row));
            }
        }
        System.out.println(resultList);
        return resultList;
    }


    private static Boolean verifyNumbers(int numberA, int numberB){
        // 验证numberA是否大于numberB，创建isStartGreaterEnd函数
        if (isStartGreaterEnd(numberA, numberB)){
            return false;
        }
        //verifyNumberRange函数,验证是否在1-1000范围内整数
        return verifyNumberRange(numberA) && verifyNumberRange(numberB);
    }

    private static Boolean verifyNumberRange(int number) {
        return number >= 1 && number <= 1000;
    }

    private static Boolean isStartGreaterEnd(int numberA, int numberB) {
        return numberA > numberB;
    }
}