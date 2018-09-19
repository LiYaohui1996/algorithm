/**
 * @Auther: 李耀辉
 * @Date: 2018/9/13 21:13
 * @Description:
 */
//定义节点
class Node{
    Node next = null;
    int value=0;
    Node(int value){
        this.value = value;
    }
}
public class ArrayForJava {
    //初始化头节点
    Node firstNode = null;

    //添加节点
    public void addNote(int value){
        //初始化待插入的节点
        Node newNode = new Node(value);
        if(firstNode ==null){
            //如果为首节点
            firstNode=newNode;
        }else{
            Node tempNode=firstNode;
            while(tempNode.next!=null){
                tempNode = tempNode.next;
            }
            tempNode.next =newNode;
        }
    }

    //删除第index节点
    public boolean deleteNote(int index){
        if(index<1 ||getLength()<index ){
             return false;
        }
        if(index==1){
            firstNode = firstNode.next;
            return true;
        }
        int i=2;
        Node preNode = firstNode;
        Node curNode = preNode.next;
        while (curNode !=null){
            if(i ==index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }

        return true;
    }

    //得到链表长度
    public int getLength(){
        int l=0;
        Node showNode = firstNode;
        while(showNode!=null){
            l++;
        }
        return l;
    }
    //显示链表
    public void showList(){
        Node showNode = firstNode;
        while(showNode!=null){
            System.out.println(showNode.value);
            showNode = showNode.next;
        }
    }
    public static void main(String[] args) {
        ArrayForJava array = new ArrayForJava();
        array.addNote(1);
        array.addNote(2);
        array.addNote(3);
        array.addNote(4);
        array.addNote(5);
        array.addNote(6);
        array.addNote(7);
        array.addNote(8);
        array.showList();

        boolean aa= array.deleteNote(3);
        System.out.println("444"+aa);
        array.showList();
    }
}
