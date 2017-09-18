# Android朋友圈九宫格图片
[![Apache 2.0 License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0.html)  

<br>  
现在有很多列表都会展示图片，有的像社交软件似的九宫格，然而我这个是当图片是一张时，就会
显示一张，2张时会平铺，大于3张就会像九宫格那样。当然这里你也可以设置一排显示多少张。其中也
有点击放大图片。  

##效果图  

|列数|图片
|---|---|
|一列|![效果示例](https://github.com/haoxiongqin/One_NineGrid/raw/master/screenshot/sipmleOne.png)|
|二列|![效果示例](https://github.com/haoxiongqin/One_NineGrid/raw/master/screenshot/sipmleTwo.png)|
|三列|![效果示例](https://github.com/haoxiongqin/One_NineGrid/raw/master/screenshot/sipmleThree.png)|
|其它|![效果示例](https://github.com/haoxiongqin/One_NineGrid/raw/master/screenshot/sipmleFour.png)|  

### 联系方式  <a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=BjM0MTA-MTA2PkZ3dyhlaWs" style="text-decoration:none;"><img src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_11.png"/></a>  

## 方法  

|方法名|描述|
|---|---|
|setIsClick(boolean isclick)|是否点击监听跳转，默认是|
|setPlaceHolder(int res)|没数据时的占位符|
|setColumnNum(int columnNum)|自定义设置列数|
|setPhotoList(List<String> photoList, GridView view)|设置数据是图片url地址集合|
|setMainBackgroud(int mainBackgroud)|标题栏的背景色|
|setStatusColour(int statusColour)|状态栏的背景色|
|setTitle(String title)|标题栏内容,默认是图片浏览|
|setBackTitle(String backTitle)|标题栏左侧内容,默认是图片|
|setSubmitTitle(String submitTitle)|标题栏右侧内容，默认没显示|
|setBackIcon(int backIcon)|标题栏左侧图标|
|setTitleColour(int titleColour)|标题栏内容的颜色|
|setBackColour(int backColour)|左侧标题栏的字体颜色|

##使用步骤  

####  Step 1.依赖  
Gradle 
```groovy
dependencies{
    compile 'wujing.cn.library:library:1.0'
}
```
或者引用本地lib
```groovy
    compile project(':library')
```

#### Step 2.添加权限到你的 AndroidManifest.xml
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

#### Step 3.在列表中加载图片的adapter
 ```java
   DisplayPhotoAdapter adapter=new DisplayPhotoAdapter(context);
          //设置自定义列数，默认是3列
          adapter.setColumnNum(map.get(position).size());
          //设置url集合
          adapter.setPhotoList(map.get(position),viewHolder.grideview);
          //设置是否点击监听
          adapter.setIsClick(true);
          //设置展示图片界面左侧文字，默认是返回箭头
          adapter.setBackTitle("取消");
          //设置展示图片界面左侧图标
          adapter.setBackIcon(R.drawable.back_black);
          //设置展示图片界面标题栏背景色
          adapter.setMainBackgroud(ContextCompat.getColor(context,R.color.colorPrimary));
          //设置图片的占位符
          adapter.setPlaceHolder(R.drawable.user_logo);
          //设置展示图片界面的状态栏颜色
          adapter.setStatusColour(ContextCompat.getColor(context,R.color.colorPrimary));
          //设置展示图片界面的标题栏
          adapter.setTitle("图片展示");
          //设置展示图片界面右侧文字，默认不显示
          adapter.setSubmitTitle("没显示");
          //设置展示图片界面左侧文字颜色
          adapter.setBackColour(ContextCompat.getColor(context,R.color.colorPrimary));
          //设置标题栏的颜色
          adapter.setTitleColour(ContextCompat.getColor(context,R.color.colorPrimary));
 ```
 
## 注意
1. 项目中加载了图片选择器，可以直接使用。[jeasonlzy](https://github.com/jeasonlzy/ImagePicker) 
2. 在设置展示放大图片界面时，以上的方法并不是全部都使用，选择你需要的界面样式去设置方法，不然会造成一定的影响。







## License
```  
Copyright 2017 haoxiongqin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```