package design_mode.model13.filter;

import design_mode.model13.Msg;

/**
 * @ClassName EmojiFilter
 * @Description emoji过滤器
 * @Author wangmeng
 * @Date 2021/6/30
 */
public class EmojiFilter implements Filter{

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace(":)", "^^");
        m.setMsg(msg);
        return true;
    }
}
