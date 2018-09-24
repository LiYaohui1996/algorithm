/**
 * @Auther: 李耀辉
 * @Date: 2018/9/15 18:58
 * @Description:归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 *                即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 *                归并排序是稳定的排序方法。
　　             归并排序的时间复杂度为O(nlogn)。
　　             速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        MergeSort(a,0,a.length-1);

        System.out.println();
        System.out.println("排序之后：");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }

    public static void MergeSort(int array[],int p,int r){
           if(p< r){
               int q = (p+r)/2;
               MergeSort(array,p,q);
               MergeSort(array,q+1,r);
               Merge(array,p,q,r);

           }
    }

    public static void Merge(int array[],int p,int q,int r){

        int[] tmpArr  =new int[array.length];
        int middle =q+1;
        int left = p;
        //int right = r;
        int third = p;
        while(left<=q && middle<=r){
            if(array[left] <=array[middle]){
                tmpArr[third++] = array[left++];
            }else{
                tmpArr[third++] = array[middle++];
            }
        }
        while(left<=q){
            tmpArr[third++] = array[left++];
        }
        while (middle<=r){
            tmpArr[third++] = array[middle++];
        }
        while (p<=r){

            array[p] = tmpArr[p++];
        }
    }

}
