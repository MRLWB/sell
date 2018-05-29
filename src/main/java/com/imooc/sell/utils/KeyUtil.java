package com.imooc.sell.utils;
/*生产随机订单码*/
import java.util.Random;

public class KeyUtil {

    public static synchronized String genUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(9000000) + 1000000;

        return System.currentTimeMillis() + String.valueOf(number);

    }
}
