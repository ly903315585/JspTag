package com.ly.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 开发if标签
 * @author liuyong
 *
 */
public class IFTag extends SimpleTagSupport{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3647599211504941506L;
    private boolean test;
    
    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException,IOException {
        if(test){
            this.getJspBody().invoke(null);
        }
    }
    
}
