package com;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class Driver {
    public static void main(String[] args) {
        try {
            String pinyin = PinyinHelper.convertToPinyinString("赵哲", "");
            System.out.println(pinyin);
        } catch (PinyinException e) {
            e.printStackTrace();
        }
    }
}
