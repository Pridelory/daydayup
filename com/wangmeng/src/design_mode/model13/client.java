package design_mode.model13;

import design_mode.model13.filter.*;

/**
 * @ClassName client
 * @Description 责任链模式客户端
 * @Author wangmeng
 * @Date 2021/6/30
 */
public class client {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script>,欢迎访问pridelory.com,大家都是996!");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new EmojiFilter())
                .addFilter(new SensitiveFilter());

        FilterChain filterChain2 = new FilterChain();
        filterChain2.addFilter(new HtmlFilter())
                .addFilter(new EmojiFilter());

        filterChain.addFilter(filterChain2);
        filterChain.doFilter(msg);

        System.out.println(msg.getMsg());
    }
}

