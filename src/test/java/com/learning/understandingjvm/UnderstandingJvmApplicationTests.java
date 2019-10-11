package com.learning.understandingjvm;

import org.junit.Test;

import java.util.*;

public class UnderstandingJvmApplicationTests {

    @Test
    public void contextLoads() {
        String productKey = "hsdfjsd";
        String deviceId = "2346573";
        String clientId = "hsdfjsd" + "&" + "2346573";
        String client2 = "hsdfjsd&2346573";
        System.out.println(clientId == client2);
        System.out.println(client2 == clientId.intern());
        System.out.println("====================");
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);
        System.out.println("====================");
        String s3 = new String("3") + new String("3");
        s3.intern();
        String s4 = "33";
        System.out.println(s3 == s4);
        System.out.println("====================");
        String s5 = new String("5") + new String("5");
        String s6 = "55";
        s3.intern();
        System.out.println(s5 == s6);
    }

    @Test
    public void urlTest() {
        String image = "http://oasisfs.h3c.com//group1/M00/50/97/rBAEYV1WFuOAZr2QAO40NXrCdZU065.zip";
        String url2 = "lvzhou-portal.h3c.com:10080/group1/M00/2F/8C/BQAAr11WEJiAcWxYAO40NXrCdZU783.zip";
        int groupIndex = image.indexOf("group");
        int groupIndex2 = url2.indexOf("group");
        System.out.println(groupIndex);
        System.out.println(groupIndex2);
        System.out.println("image:" + image.substring(groupIndex));
        System.out.println("image:" + url2.substring(groupIndex2));

    }

    @Test
    public void listTest() {
        List<String> asList = new ArrayList<>();
        asList.add("1");
//        asList.add("2");
//        asList.add("3");
//        asList.add("12");
        Iterator<String> iterator = asList.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("2")){
                System.out.println("=====");
                iterator.remove();
            };
        }
        Collections.sort(asList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(asList);
    }

}
