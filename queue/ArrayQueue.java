package dataStructure.queue;

/**
 * @Description 数组实现普通队列，队列先进先出，这里使用头尾指针分别用来取值和添加值的控制.
 * 注：该队列只能使用一次
 * @Author myf
 * @CreateDate 2021/11/29 14:48
 * @Version 1.0
 **/
public class ArrayQueue<T> {
    //队列的大小
    private int maxSize;
    //前指针（下标），开始时值为-1,每次取值时++front
    private int front;
    //后指针（下标），开始值为-1，每次添加值时++rear
    private int rear;
    //存储数据的数组
    private Object[] data;


    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        front=-1;
        rear=-1;
        data=new Object[maxSize];
    }
    /**
    * @Author myf
    * @Description //TODO 添加元素
    * @Date 2021/11/29 15:02
    * @Param
    * @return
    */
    public void addEle(T ele) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加数据");
        }
        data[++rear]=ele;
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
        return (T) data[++front];
    }
    /**
    * @Author myf
    * @Description //TODO 判断队列是否满了
    * @Date 2021/11/29 15:04
    * @Param
    * @return
    */
    public boolean isFull() {
        if (this.rear==maxSize-1) {
            return true;
        }else {
            return false;
        }
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
}
