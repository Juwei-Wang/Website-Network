package com;

public class Demo {
    public static void main(String[] args) {
        String str = "public static   void main";
        //                  ^      ^^^    ^
        //            ------ ------   ---- ----
        // String part = "";
//        String[] parts = str.split(" ");
        String[] parts = str.split("\\s+");    // \s+


        for (String part : parts) {
            System.out.println(part);
        }

        System.out.println(str.matches("[a-z]+"));

        String colorCode = "FFKJ01";
        if (!colorCode.matches("[A-Fa-f0-9]{6}")) {
            System.out.println("格式有问题");
        }

        String s = str.replaceAll("\\s+", ",");
        System.out.println(s);
    }
}
