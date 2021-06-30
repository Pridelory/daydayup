package design_mode.model10;


public class TestClone {

    /**
     * 浅克隆
     */
    public void simpleChange() {
        Monkey monkey = new Monkey();
        monkey.setHeight(30);
        monkey.setWeight(20);

        try {
            Monkey newMonkey = (Monkey) monkey.clone();
            System.out.println(newMonkey.getHeight());
            System.out.println(newMonkey.getWeight());
            // 返回true 表示引用类型只复制了引用
            System.out.println(newMonkey.getStaff() == monkey.getStaff());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 深克隆
     */
    public void deepChange() {
        Monkey monkey = new Monkey();
        monkey.setHeight(30);
        monkey.setWeight(20);

        try {
            Monkey newMonkey = (Monkey) monkey.deepClone();
            System.out.println(newMonkey.getHeight());
            System.out.println(newMonkey.getWeight());
            // 返回true 表示引用类型只复制了引用
            System.out.println(newMonkey.getStaff() == monkey.getStaff());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//       new TestClone().change1();
        new TestClone().deepChange();
    }
}
