/**
 * @Auther: 李耀辉
 * @Date: 2018/8/23 18:32
 * @Description:直接插入排序
 * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
 */
public class directInsertionSort {

    public static void main(String args[]){
        //初始化数组
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        // int[] b = {13, 27, 38 , 49 , 65 , 76, 78, 97 ,34,12,64,1};

        System.out.println("排序之前：");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }

        for (int i=1;i<a.length;i++){
            //将待插入元素保存在temp中
            int temp = a[i];
            int j;
            for (j= i-1;j>=0;j--){
                if(a[j]>temp){
                   a[j+1] = a[j];
                }
            else break;
            }
            a[j+1] = temp;
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
    }

}
