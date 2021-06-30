package design_mode.model8;
import design_mode.model8.interfaces.Duck;
import design_mode.model8.interfaces.Impl.MallardDuck;
import design_mode.model8.interfaces.Impl.WildTurkey;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        //原先直接用Duck
        Duck duck1 = new MallardDuck();
        duck1.quark();
        duck1.fly();
        System.out.println("-----------------------");
        Duck duck2 = new MallardDuck();
        duck2.quark();
        duck2.fly();
        System.out.println("-----------------------");
        //现在Duck不够用了，得用Turkey冒充
        WildTurkey wildTurkey = new WildTurkey();
        Duck duck3 = new TurkeyAdapter(wildTurkey);
        duck3.quark();
        duck3.fly();
    }
}
