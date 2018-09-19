/**
 * @Auther: 李耀辉
 * @Date: 2018/9/15 18:58
 * @Description:
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
