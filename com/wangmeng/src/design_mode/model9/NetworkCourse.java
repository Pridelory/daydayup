package design_mode.model9;

/**
 * 模板会有一个或者多个未实现的方法，而且这几个未实现的方法有固定的执行顺序
 */
public abstract class NetworkCourse {

    // 这里用protected修饰符，表明只有其子类可以用此方法，起到了保护方法的作用
    protected final void createCourse() {
        // 发放预习资料
        this.postPreSource();

        // 制作课件PPT
        this.createPPT();

        // 在线直播
        this.liveVedio();

        // 提交课堂笔记
        this.postNote();

        // 提交源码
        this.postSource();

        if (needHomework()) {
            this.checkHomework();
        }
    }

    abstract void checkHomework();

    // 钩子方法，实现流程微调
    // 子类可覆盖也可不覆盖 根据实际情况而定
    protected boolean needHomework() {
        return false;
    }

    // final 修饰 说明子类不可以改此模板
    final void postSource() {
        System.out.println("提交源码");
    }

    final void postNote() {
        System.out.println("提交课件和笔记");
    }

    final void liveVedio() {
        System.out.println("直播授课");
    }

    final void createPPT() {
        System.out.println("创建备课PPT");
    }

    final void postPreSource() {
        System.out.println("分发预习资料");
    }

}
