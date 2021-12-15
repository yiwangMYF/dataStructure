package dataStructure.linkedList;

/**
 * @Description 单向环形链表，解决约瑟夫问题。
 *              约瑟夫问题：  设编号为1~n的n个人围坐一圈，约定编号为1<=k<=n的人从1开始报数，数到m的那个人出列，
 *              他的下一位又从1开始报数，数到m的人处列，知道所有人都处列
 *              
 *
 * @Author myf
 * @CreateDate 2021/11/30 19:09
 * @Version 1.0
 **/
public class CircleSingleLinkedList {
    /**
     * 第一个节点
     */
    private CNode first;

    public CircleSingleLinkedList() {
        
    }

    /**
    * @Author myf
    * @Description //TODO 根据人数创建对应的环形链表
    * @Date 2021/11/30 19:27
    * @Param 
    * @return 
    */
    public void buildCircle(int nums){
        if (nums<1) {
            return;
        }
        first= new CNode(1);
        int count=2;
        //辅助节点
        CNode curNode=first;
        curNode.next=first;
        while(count<=nums) {
            CNode cNode = new CNode(count);
            curNode.next=cNode;
            cNode.next=first;
            curNode=curNode.next;
            count++;
        }
    }
    /**
    * @Author myf
    * @Description //TODO 输出约瑟夫问题答案
    * @Date 2021/11/30 20:22
    * @Param startNo-开始编号；m-第m个出列；nums-总人数
    * @return
    */
    public void st(int startNo,int m,int nums){
        /**
         * 创建2个辅助节点,curNode节点指向起始编号所对应的节点，最终会指向要删除的节点，
         * helper节点指向curNode的前一个节点，用于辅助删除操作。
         */
        CNode curNode=this.first;
        CNode helper = this.first;
        //由于是单向链表，需要找到当前链表的尾节点 （即first节点的前一个）
        while(helper.next!=this.first) {
            helper=helper.next;
        }
        //将curNode节点指向到开始编号所对应的节点
        for (int i = 1; i < startNo; i++) {
            curNode=curNode.next;
            helper=helper.next;
        }
        //开始出列
        while(true) {
            if (curNode==helper) {
                //只剩最后一个节点了
                System.out.println("last:"+curNode);
                break;
            }
            for (int j = 1; j < m; j++) {
                //指向要出列的节点
                curNode=curNode.next;
                helper=helper.next;
            }
            //出列
            System.out.println(curNode);
            helper.next=curNode.next;
            curNode=helper.next;
        }
    }
    
    /**
    * @Author myf
    * @Description //TODO 遍历单向环形链表
    * @Date 2021/11/30 19:43
    * @Param 
    * @return 
    */
    public void list(){
        if (this.first==null) {
            System.out.println("");
            return;
        }
        //使用辅助节点进行遍历
        CNode curNode= this.first;
        System.out.println(this.first);
        while (curNode.next!=this.first) {
            curNode=curNode.next;
            System.out.println(curNode.no);
            System.out.println(curNode);
        }
    }


    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.buildCircle(5);
        circleSingleLinkedList.list();

        System.out.println("------------------------------------");

        circleSingleLinkedList.st(1,2,5);
    }

    /**
     * 链表节点封装类
     */
    private static class CNode{
        private int no;
        private CNode next;

        public CNode(int no) {
            this.no = no;
        }
        @Override
        public String toString() {
            return "CNode{" +
                    "no=" + no +
                    '}';
        }
    }
}
