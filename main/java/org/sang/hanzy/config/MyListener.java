package org.sang.hanzy.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
//监听器
public class MyListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("监听器----请求销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("监听器----请求创建");
    }
}
