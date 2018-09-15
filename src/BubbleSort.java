/**
 * @Auther: 李耀辉
 * @Date: 2018/9/15 11:01
 * @Description:冒泡排序
 *                在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
 *               让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 *               若文件初状为正序，则一趟起泡就可完成排序，排序码的比较次数为n-1，且没有记录移动，时间复杂度是O(n)
 *               若文件初态为逆序，则需要n-1趟起泡，每趟进行n-i次排序码的比较，且每次比较都移动三次，比较和移动次数均达到最大值∶O(n2)
 *              起泡排序平均时间复杂度为O(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
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
