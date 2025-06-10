package top.fish.mydb.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: wwwsea
 * @Content: <p> </p>
 * @CreateTime: 2025/5/27 14:53
 */

public class shareMemoryTest {
    public class SubArray {
        public byte[] raw;
        public int start;
        public int end;

        public SubArray(byte[] raw, int start, int end) {
            this.raw = raw;
            this.start = start;
            this.end = end;
        }
    }
    @Test
    public void testSubArray(){
        //创建一个1~10的数组
        byte[] subArray = new byte[10];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = (byte) (i+1);
        }
        //创建两个SubArray
        SubArray sub1 = new SubArray(subArray,3,7);
        SubArray sub2 = new SubArray(subArray,6,9);

        //修改共享数组数据
        sub1.raw[4] = (byte)44;

        //打印原始数组
        System.out.println("Original Array: ");
        printArray(subArray);

        //打印共享数组
        System.out.println("SubArray1: ");
        printSubArray(sub1);
        System.out.println("SubArray2: ");
        printSubArray(sub2);
    }

    private void printArray(byte[] array){
        System.out.println(Arrays.toString(array));
    }

    private void printSubArray(SubArray subArray){
        for (int i = subArray.start; i <= subArray.end; i++) {
            System.out.print(subArray.raw[i] + "\t");
        }
        System.out.println();
    }

}
