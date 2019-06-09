package com.dgolov.bisearch;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BiSearch {
    private int count;

    public void alg(int n, int size){
        int[] array = new int[size];
        int num = n;

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int point;
        count=0;
        while(true){
            point = array[array.length/2];
            if(num==point){
                System.out.println("index = " + array.length/2);
                break;
            }else if((num<point)){
                array = changeArray(array,false);
            }else if(num>point){
                array = changeArray(array,true);
            }
        }
        System.out.println("count of steps: "+count);
        System.out.println(Arrays.toString(array));
    }

    private int[] changeArray(int[] oldArr,boolean way){
        List<Integer> newArr = Arrays.stream(oldArr).boxed().collect(Collectors.toList());
        if(way){//true = right
            newArr.subList(0, oldArr.length/2).clear();
        }else{ //false = left
            newArr.subList(oldArr.length/2, oldArr.length-1).clear();
        }
        count++;
        return newArr.stream().mapToInt(i->i).toArray();
    }
}
