package com.ly.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 开发输出标签
 * 
 * @author liuyong
 *
 */
public class OutTag extends SimpleTagSupport {

    private String content;// 要输出的内容

    private boolean escapeHtml;// 是否将内容中的html进行转义后输出

    public void setContent(String content) {
        this.content = content;
    }

    public void setEscapeHtml(boolean escapeHtml) {
        this.escapeHtml = escapeHtml;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (escapeHtml == true) {
            content = filter(content);// 转义内容中的html代码
            this.getJspContext().getOut().write(content);// 输出转义后的content
        } else {
            this.getJspContext().getOut().write(content);
        }
    }

    /**
     * 
     * @param message
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
