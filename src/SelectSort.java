/**
 * @Auther: 李耀辉
 * @Date: 2018/9/15 16:09
 * @Description:选择排序
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换，
 *  如此循环到倒数第二个数和最后一个数比较为止。简单选择排序是不稳定的排序。时间复杂度：T(n)=O(n2)。
 *
 */
public class SelectSort  {
    public static void main(String args[]) {
        //初始化数组
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        // int[] b = {13, 27, 38 , 49 , 65 , 76, 78, 97 ,34,12,64,1};

        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }

        for(int i=0;i<a.length;i++){
            int temp=a[i];
            for(int j=a.length-1;j>i;j--){
                if(a[i]>a[j]){
                    a[i]=a[j];
                    a[j]=temp;
                    temp=a[i];
                }
            }
        }



        System.out.println();
        System.out.println("排序之后：");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }
}
