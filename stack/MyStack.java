package dataStructure.stack;

/**
 * @Description 使用数组实现栈。线程安全,不可自动扩容
 * @Author myf
 * @CreateDate 2021/12/1 16:05
 * @Version 1.0
 **/
public class MyStack<T> {
    //栈的大小
    private int maxSize;
    //存储数据
    private Object[] data;
    //索引，用于指向当前栈顶位置，没有数据时top=-1,栈满时top=maxSize-1
    private volatile int top=-1;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.data=new Object[maxSize];
    }

    /**
    * @Author myf
    * @Description //TODO 数据入栈
    * @Date 2021/12/1 16:08
    * @Param
    * @return
    */
    public synchronized void push(T ele){
        //判断是否栈满
        if (this.top==(maxSize-1)) {
            throw new RuntimeException("栈已满，无法再添加数据");
        }
        data[++top]=ele;
    }
    /**
    * @Author myf
    * @Description //TODO 数据出栈
    * @Date 2021/12/1 16:12
    * @Param
    * @return
    */
    public synchronized T pop(){
        //判断栈是否为空
        if (this.top==-1) {
            throw new RuntimeException("栈空");
        }
        T value= (T) data[this.top];
        System.out.println(value);
        this.top--;
        return value;
    }
    /**
    * @Author myf
    * @Description //TODO 遍历栈
    * @Date 2021/12/1 16:17
    * @Param
    * @return
    */
    public void list(){
        for (int i = top; i >=0 ; i--) {
            System.out.println("stack["+i+"]="+data[i]);
        }
        System.out.println("----------------------------");
    }
    /**
    * @Author myf
    * @Description //TODO 数据大小
    * @Date 2021/12/1 16:24
    * @Param
    * @return
    */
    public int getSize(){
        return this.top+1;
    }


    public static void main(String[] args) {
        final MyStack<String> myStack = new MyStack<>(4);
        myStack.push("myf");
        myStack.push("is");
        myStack.push("name");
        myStack.push("my");
        myStack.list();

        System.out.println(myStack.top);
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    myStack.pop();
                }
            });
            thread.start();
        }
    }
}
