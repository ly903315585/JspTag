package com.ly.web.simpletag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * ForEach迭代标签
 * 
 * @author liuyong
 *
 */
public class ForEachTag extends SimpleTagSupport {

    private Object items;// 存储集合

    private String var;// 迭代集合时使用的变量

    private Collection collection;// 集合，用于存储items中的数据

    public void setItems(Object items) {
        if (items instanceof Collection) {
            collection = (Collection) items;// list
        } else if (items instanceof Map) {
            Map map = (Map) items;
            collection = map.entrySet();// map
        } else if (items.getClass().isArray()) {
            collection = new ArrayList();
            int len = Array.getLength(items);
            for (int i = 0; i < len; i++) {
                Object object = Array.get(items, i);//获取数组元素
                collection.add(object);
            }
        }
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) this.getJspContext();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object object = (Object) it.next();// 得到一个迭代出来的对象
            pageContext.setAttribute(var, object);// 将迭代出来的对象存放到pageContext对象中
            this.getJspBody().invoke(null);// 输出标签体中的内容
        }
    }

}
