import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Auther: 李耀辉
 * @Date: 2018/9/13 21:13
 * @Description:
 */
//定义节点
class Node{
    Node next = null;
    int value=0;
    int data;
    Node(int value){
        this.value = value;
    }
    Node(int value,int data){
        this.value = value;
        this.data = data;
    }
}
public class ArrayForJava {
    //初始化头节点
    Node firstNode = null;

    //添加节点
    public void addNote(int value,int data){
        //初始化待插入的节点
        Node newNode = new Node(value,data);
        if(firstNode ==null){
            //如果为首节点
            firstNode=newNode;
        }else{
            Node tempNode=firstNode;
            //一直遍历到结尾
            while(tempNode.next!=null){
                tempNode = tempNode.next;
            }
            //插入要添加节点
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
        // 保存第一个节点
        Node preNode = firstNode;
        //保存第二个节点
        Node curNode = preNode.next;
        //如果第二个节点为空证明已经到了结尾，结束循环
        while (curNode !=null){
            //i = index 则说明找到要删除的节点
            if(i ==index){
                //删除节点
                preNode.next = curNode.next;
                return true;
            }
            //否则指针向后移动
            preNode = preNode.next;
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
            showNode = showNode.next;
        }
        return l;
    }
    //显示链表
    public Node showList(){
        Node showNode = firstNode;
        while(showNode!=null){
            System.out.print(showNode.value+"="+showNode.data+" ");
            showNode = showNode.next;
        }

        System.out.println("");
        return firstNode;
    }
    //删除链表中重复元素使用hash去重
    public void deleteDuplecate(Node head){
        HashMap<Integer,Integer> table = new HashMap<>();
        Node temp = head;
        Node pre =null;
        while(temp!=null){

            if(table.containsKey(temp.data)){
                pre.next = temp.next;
            }else{
                pre=temp;
                table.put(temp.data,1);
            }
            temp =temp.next;
        }
    }
    //删除链表中重复元素使用循环比较
    public void deleteDuplecateForLoop(Node head){
        Node p = head;
        while(p!=null){
            Node q=p.next;
            while(q!=null){
                if(q.data == p.data){
                    p.next=q.next;
                }
                q=q.next;
            }
            p=p.next;
        }
    }

    //找寻倒数第k个元素
    public Node findElem(Node head,int k ){
        Node p1 =head;
        Node p2 =head;
        for(int i=0;i<k-1;i++){
            if(p1==null){
                System.out.println("k值过大");
                return null;
            }
            p1=p1.next;
        }
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
    //链表反转
    public void reverseIteratively(Node head){
        //保存倒转之后的尾指针，尾指针开始为null
        Node prev = null;
        //保存原头结点
        Node now = head;
        while (now!=null){
            //将需要倒转的下一个节点保存
            Node node = now.next;
            //倒转的节点指向prev
            now.next = prev;
            //倒转节点变成待指向的节点
            prev = now;
            //倒转节点变为下一个节点
            now = node;
        }
        firstNode = prev;
    }

    //反向输出链表
    public void priintListReverse(Node head){
        if(head !=null){
            priintListReverse(head.next);
            System.out.print(head.value+" ");
        }
    }

    //求中间节点
    public Node searchMid(Node head){
        Node p = head;
        Node q = head;
        while (p!=null && p.next !=null && p.next.next !=null){
            p=p.next.next;
            q =q.next;
        }
        return q;
    }



    public static void main(String[] args) {
        ArrayForJava array = new ArrayForJava();
        array.addNote(1,50);
        array.addNote(2,60);
        array.addNote(3,70);
        array.addNote(4,50);
        array.addNote(5,55);
        array.addNote(6,46);
        array.addNote(7,45);
        array.addNote(8,45);
        Node head =array.showList();

        Node node =array.findElem(head,3);
        System.out.println("倒数第3个元素为"+node.value+" "+node.data);
        node =array.searchMid(head);
        System.out.println("中间节点为"+node.value+" "+node.data);
        System.out.println("链表倒转");
        array.reverseIteratively(head);
        head = array.showList();
        System.out.println("链表倒转完成");

        System.out.println("链表倒转输出");
        array.priintListReverse(head);
        System.out.println("");
        System.out.println("链表倒转输出完成");

        System.out.println("链表删除第三节点");
        boolean aa= array.deleteNote(3);
        head =array.showList();
        System.out.println("链表删除第三节点完成");

        System.out.println("链表删除重复元素");
        //array.deleteDuplecate(head);
        array.deleteDuplecateForLoop(head);
        array.showList();
        System.out.println("链表删除重复元素完成");

    }
}
