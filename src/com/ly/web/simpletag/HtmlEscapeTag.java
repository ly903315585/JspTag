package com.ly.web.simpletag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * html转义标签
 * 
 * @author liuyong
 *
 */
public class HtmlEscapeTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        this.getJspBody().invoke(sw);// 将标签体中的内容先输出到StringWriter流
        String content = sw.getBuffer().toString();// 得到标签体中的内容
        content = filter(content);// 转义标签体中的html代码
        this.getJspContext().getOut().write(content);// 输出转义后的content
    }

    /**
     * 
     * @param content
     * @return 转义html标签
     */
    private String filter(String message) {
        if (message == null) {
            return null;
        }
        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuilder result = new StringBuilder(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return result.toString();
    }
}
