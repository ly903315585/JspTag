package com.ly.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * when标签和otherwise标签的父标签
 * 
 * @author liuyong
 *
 */
public class ChooseTag extends SimpleTagSupport {

    /**
     * 定义一个boolean类型的属性，该属性用于标识该标签下的某一个子标签是否已经执行过了，
     * 如果该标签下的某一个子标签已经执行过了，就将该属性设置为true
     */
    private boolean isExecute;

    @Override
    public void doTag() throws JspException, IOException {
        this.getJspBody().invoke(null); // 输出标签体中的内容
    }

    public boolean isExecute() {
        return isExecute;
    }

    public void setExecute(boolean isExecute) {
        this.isExecute = isExecute;
    }

}
