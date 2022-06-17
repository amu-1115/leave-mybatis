package com.gxuwz.leave.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author amu_1115@126.com
 * @version 1.0
 */
public class PathMatcherUtil {
    private final static String ROOT_URL_PATTERN="^/[a-z]*/[a-z]*/[a-z]*$";
    private final static String WEBAPP_URL_PATTERN="^/[a-z]*/[a-z]*/[a-z]*/[a-z]*$";
    /**
     *
     * @param uri
     * @param isRoot
     * @return
     */
    public static String doMatcher(String uri,boolean isRoot){
        String  regex =isRoot?ROOT_URL_PATTERN:WEBAPP_URL_PATTERN;
        Pattern pattern=Pattern.compile(regex);
        Matcher m = pattern.matcher(uri);
        boolean flag =m.find();
        String  s="-1";
        try{
            s=m.group();
            int lastIndex=uri.lastIndexOf("/");
            s=uri.substring(lastIndex+1);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        return s;
    }

    public static void main(String[]args){
        String uri1="/leave/api/menu/add";
        String uri2="/api/user/add";
        String str = PathMatcherUtil.doMatcher(uri1,false);
        System.out.println(str);
    }
}
