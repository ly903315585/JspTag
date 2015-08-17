package com.ly.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * when标签
 * 
 * @author liuyong
 *
 */
public class WhenTag extends SimpleTagSupport {

    private boolean test;// test属性，该属性值为true时，输出标签体中的内容

    @Override
    public void doTag() throws JspException, IOException {
        ChooseTag parentTag = (ChooseTag) this.getParent();// 获取标签的父标签
        if (test == true && parentTag.isExecute() == false) {
            this.getJspBody().invoke(null);// 输出标签体中的内容
            // 将父标签的isExecute属性设置为true，告诉父标签，我(when标签)已经执行过
            parentTag.setExecute(true);
        }
    }

    public void setTest(boolean test) {
        this.test = test;
    }

}
