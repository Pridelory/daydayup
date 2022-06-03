package design_mode.model13.filter;

import design_mode.model13.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilterChain
 * @Description 过滤链
 * @Author wangmeng
 * @Date 2021/6/30
 */
public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg m) {
        for (Filter filter : filters) {
            if (!filter.doFilter(m)) return false;
        }
        return true;
    }
}
