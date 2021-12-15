package dataStructure.linkedList;

/**
 * @Description 实现单向链表(带头结点)。
 *              链表与数组的区别：1.数组在内存中各个元素的内存地址是连续的，而链表可以不连续；
 *                              2.链表每个节点包含data域和指向下个节点的引用，因而空间消耗比数组多
 *                              3.数组初始化时会指定长度，之后长度不可变，链表长度不确定，没有限制。
 * @Author myf
 * @CreateDate 2021/11/30 10:04
 * @Version 1.0
 **/
public class SingleLinkedList<T> {
    /**
     * 头节点
     */
    private Node<T> head;

    public SingleLinkedList() {
        this.head=new Node<>(null,null);
    }

    public SingleLinkedList(Node<T> head) {
        this.head = head;
    }
    /**
    * @Author myf
    * @Description //TODO 尾插法添加
    * @Date 2021/11/30 13:13
    * @Param
    * @return
    */
    public void addLastEle(Node<T> node){
        if (node==null) {
            throw new RuntimeException("要添加的节点不存在");
        }
        //找到尾节点
        Node temp = this.head;
        while(temp!=null) {
            if (temp.next==null) {
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
        node.next=null;
    }
    /**
    * @Author myf
    * @Description //TODO 头插法添加
    * @Date 2021/11/30 13:48
    * @Param 
    * @return 
    */
    public void addHeadEle(Node<T> node){
        if (node==null) {
            throw new RuntimeException("要添加的元素不存在");
        }
        node.next=head.next;
        this.head.next=node;
    }
    /**
    * @Author myf
    * @Description //TODO 展示链表所有节点数据
    * @Date 2021/11/30 13:29
    * @Param 
    * @return 
    */
    public void list(){
        if (this.head.next==null) {
            System.out.println("");
            return;
        }
        //遍历输出
        Node temp= this.head.next;
        while(temp!=null){
            System.out.println(temp+"\n");
            temp=temp.next;
        }
    }


    public static void main(String[] args) {
        SingleLinkedList<String> stringSingleLinkedList = new SingleLinkedList<>();

        stringSingleLinkedList.list();
        Node<String> node1 = new Node<>("my");
        Node<String> node2 = new Node<>("name");
        Node<String> node3 = new Node<>("is");
        Node<String> node4 = new Node<>("myf");

//        stringSingleLinkedList.addLastEle(node1);
//        stringSingleLinkedList.addLastEle(node2);
//        stringSingleLinkedList.addLastEle(node3);
//        stringSingleLinkedList.addLastEle(node4);

        stringSingleLinkedList.addHeadEle(node1);
        stringSingleLinkedList.addHeadEle(node2);
        stringSingleLinkedList.addHeadEle(node3);
        stringSingleLinkedList.addHeadEle(node4);

        stringSingleLinkedList.list();

    }
}

/**
 *
 * 节点封装类
 */
class Node<T>{
    public T data;
    public Node<T> next;

    public Node(){

    }
    public Node(T data){
        this.data=data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
