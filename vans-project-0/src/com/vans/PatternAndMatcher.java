package com.vans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher {
    public static List<String> getImoocPage(String quesSource, String regex){
//        根据正则表达式来筛选出符合要求的东西
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(quesSource);
        List<String> quesUrl = new ArrayList<String>();
        while(matcher.find()){
            String url = matcher.group(1);
            quesUrl.add(url);
        }
        return quesUrl;
    }
}
