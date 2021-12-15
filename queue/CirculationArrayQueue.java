package dataStructure.queue;

/**
 * @Description 循环队列，解决普通队列只能使用一次的问题.注:rear>=front
 * @Author myf
 * @CreateDate 2021/11/29 16:05
 * @Version 1.0
 **/
public class CirculationArrayQueue<T> {
    //队列的大小
    private int maxSize;
    //前指针（下标），开始时值为-1,每次取值时++front
    private int front;
    //后指针（下标），开始值为-1，每次添加值时++rear
    private int rear;
    //存储数据的数组
    private Object[] data;


    public CirculationArrayQueue(int maxSize){
        this.maxSize=maxSize;
        front=-1;
        rear=-1;
        data=new Object[maxSize];
    }
    /**
    * @Author myf
    * @Description //TODO 添加元素
    * @Date 2021/11/29 16:08
    * @Param 
    * @return 
    */
    public void addEle(T ele) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加数据");
        }
        data[(++rear)%this.maxSize]=ele;
    }
    /**
    * @Author myf
    * @Description //TODO 校验队列是否满了
    * @Date 2021/11/29 16:08
    * @Param 
    * @return 
    */
    public boolean isFull() {
        if (this.rear!=this.front && (this.rear-this.front)%this.maxSize==0) {
            return true;
        }
        return false;
    }
    /**
     * @Author myf
     * @Description //TODO 从队列中取值
     * @Date 2021/11/29 15:08
     * @Param
     * @return
     */
    public T pop(){
        if (isEmpty()) {
            return null;
        }
        //取值
        return (T) data[(++front)%this.maxSize];
    }

    /**
     * @Author myf
     * @Description //TODO 判断队列是否为空
     * @Date 2021/11/29 15:10
     * @Param
     * @return
     */
    public boolean isEmpty() {
        if (this.front==this.rear) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        CirculationArrayQueue<String> circulationArrayQueue = new CirculationArrayQueue<String>(3);
        circulationArrayQueue.addEle("name");
        circulationArrayQueue.addEle("age");
        circulationArrayQueue.addEle("sex");

        System.out.println(circulationArrayQueue.front);
        System.out.println(circulationArrayQueue.rear);
        while (!circulationArrayQueue.isEmpty()) {
            System.out.println(circulationArrayQueue.pop());
        }


    }
}
