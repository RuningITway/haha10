package com.shunlian.utils;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/6/25 21:50
 */
public class CalUtil {


    public static void main(String[] args) throws Exception {
        System.out.println(binaryAdd(-1, 2));//加法，减法

    }

    public static int binaryAdd(int a, int b) {// 正负数都包含在里面，不用分开处理
        int s = a ^ b;// 不考虑进位的和
        int jw = a & b;// 进位

        // 下面是 s + (jw<<1) 的计算
        while (jw != 0) {
            int jw_temp = s & (jw << 1);// 保存s + (jw<<1)的进位
            s = s ^ (jw << 1);// 保存s + (jw<<1)的和，不包含进位
            jw = jw_temp;// 赋值之后，还是计算s+(jw<<1)，依旧是计算：进位以及不进位的和，当进位为0时，不进位的和就是最终的计算结果
        }
        return s;
    }


}
