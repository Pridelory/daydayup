package design_mode.model6;

public class ExectorThread implements Runnable {

    @Override
    public void run() {
        LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " : " + instance);
    }
}
