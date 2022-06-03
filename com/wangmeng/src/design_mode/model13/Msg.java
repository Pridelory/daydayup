package design_mode.model13;

/**
 * @ClassName Msg
 * @Description 消息对象
 * @Author wangmeng
 * @Date 2021/6/30
 */
public class Msg {

    private String name;

    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
