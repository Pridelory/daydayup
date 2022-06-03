package design_mode.model13.filter;

import design_mode.model13.Msg;

/**
 * @ClassName Filter
 * @Description 过滤器接口
 * @Author wangmeng
 * @Date 2021/6/30
 */
public interface Filter {

    public boolean doFilter(Msg m);
}
