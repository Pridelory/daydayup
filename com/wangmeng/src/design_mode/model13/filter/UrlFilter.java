package design_mode.model13.filter;

import design_mode.model13.Msg;

/**
 * @ClassName UrlFilter
 * @Description url过滤器
 * @Author wangmeng
 * @Date 2021/6/30
 */
public class UrlFilter implements Filter {

    @Override
    public boolean doFilter(Msg m) {
        String msg = m.getMsg();
        msg = msg.replace("pridelory.com", "https://www.pridelory.com");
        m.setMsg(msg);
        return true;
    }
}
