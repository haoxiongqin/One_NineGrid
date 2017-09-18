package cn.wujing.nine;


import android.app.Application;

import wujing.cn.library.XLoad;


public class App extends Application{
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        XLoad.init(this);
    }
    public static App getInstance() {
        return instance;
    }
}
