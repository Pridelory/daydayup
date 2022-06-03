package design_mode.model13.filter;

import design_mode.model13.Msg;

/**
 * @ClassName SensitiveFilter
 * @Description 敏感词过滤器
 * @Author wangmeng
 * @Date 2021/6/30
 */
public class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace("996", "995");
        m.setMsg(msg);
        return false;
    }
}
