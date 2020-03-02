package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupDemo {
    public static void main(String[] args) {
        {
            String str = "public static   void main";
            String regex = "[a-z]+";

            Pattern pattern = Pattern.compile(regex);
            //  RegExp regExp = new RegExp(regExpString);

            Matcher matcher = pattern.matcher(str);
            //  Results results = regExp.searchIn(str);

            matcher.find();
            //  results.next();

            String match = matcher.group();
            //  String match = results.getMatch();

            System.out.println(match);

            matcher.find();
            System.out.println(matcher.group());

            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }
        {
            String str = "这个真的是有点 [捂脸]！！！[哭]呵呵[哈哈][恐怖]";
            String regex = "\\[([^\\[\\]]+)\\]"; // \[([^\[\]]+)\]

            Pattern pattern = Pattern.compile(regex);
            //  RegExp regExp = new RegExp(regExpString);

            Matcher matcher = pattern.matcher(str);
            //  Results results = regExp.searchIn(str);

            matcher.find();
            //  results.next();

            String match = matcher.group();
            //  String match = results.getMatch();
            System.out.println(match);

            String group = matcher.group(1);
            //  String groupStr = results.getGroupFromCurrentMatch(1)
            System.out.println(group);
        }
        {
            String str = "这个真的是有点 [捂脸]！！！[哭]呵呵[哈哈][恐怖]";
            String regex = "\\[([^\\[\\]]+)\\]"; // \[([^\[\]]+)\]

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                String match = matcher.group();
                String group = matcher.group(1);
                System.out.println(String.format("%s -> %s", match, group));
            }
        }
    }
}
