package com.ly.web.simpletag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 防盗链标签RefererTag
 * 
 * @author liuyong
 *
 */
public class RefererTag extends TagSupport {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8616493503032262244L;

    private String site;// 网站域名

    private String page;// 要跳转的页面

    public void setSite(String site) {
        this.site = site;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public int doEndTag() throws JspException {
        PageContext pageContext = this.pageContext;// 获取jsp页面的PageContext对象
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();// 通过PageContext对象来获取HttpServletRequest对象
        String referer = request.getHeader("referer");// 获取请求的来路(Referer)
        // 如果来路是null或者来路不是来自我们自己的site，那么就将请求重定向到page页面
        if (referer == null || !referer.startsWith(site)) {
            // 获取HttpServletResponse对象
            HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();// 获取HttpServletResponse对象
            String webRoot = request.getContextPath();
            if (page.startsWith(webRoot)) {
                try {
                    response.sendRedirect(page);// 重定向到page页面
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    response.sendRedirect(webRoot + page);// 重定向到page页面
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 重定向后，控制保护的页面不要执行
            throw new SkipPageException();
        }
        return super.doEndTag();
    }

}
