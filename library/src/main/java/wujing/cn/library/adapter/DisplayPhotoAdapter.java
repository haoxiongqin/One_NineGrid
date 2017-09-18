package wujing.cn.library.adapter;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import wujing.cn.library.DisplayImgActivity;
import wujing.cn.library.R;
import wujing.cn.library.XLoad;


public class DisplayPhotoAdapter extends BaseAdapter {
    public List<String> photoList = new ArrayList<>();
    Context context;
    int columnNum = 3;
    int resImg;
    boolean isclick = true;
    int statusColour;
    int mainBackgroud;
    int backIcon;
    int titleColour;
    int backColour;
    String title;
    String backTitle;
    String submitTitle;
    /**
     * @param backColour 左侧标题栏的字体颜色
     */
    public void setBackColour(int backColour) {
        this.backColour = backColour;
    }

    /**
     * @param titleColour 标题栏的颜色
     */
    public void setTitleColour(int titleColour) {
        this.titleColour = titleColour;
    }

    /**
     * @param backIcon 左侧图标
     */
    public void setBackIcon(int backIcon) {
        this.backIcon = backIcon;
    }

    /**
     * @param mainBackgroud 标题栏的背景色
     */
    public void setMainBackgroud(int mainBackgroud) {
        this.mainBackgroud = mainBackgroud;
    }

    /**
     * @param statusColour 状态栏的颜色
     */
    public void setStatusColour(int statusColour) {
        this.statusColour = statusColour;
    }

    /**
     * @param title 标题内容
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param backTitle 左侧标题，默认是图片
     */
    public void setBackTitle(String backTitle) {
        this.backTitle = backTitle;
    }

    /**
     * @param submitTitle 右侧标题，默认不显示
     */
    public void setSubmitTitle(String submitTitle) {
        this.submitTitle = submitTitle;
    }

    /**
     * @param isclick 是否点击监听
     */
    public void setIsClick(boolean isclick) {
        this.isclick = isclick;
    }

    /**
     * @param res 图片资源
     */
    public void setPlaceHolder(int res) {
        this.resImg = res;
    }

    /**
     * @param columnNum 自定义设置列数，默认是3列
     */
    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    /**
     * @param photoList 图片地址的集合
     */
    public void setPhotoList(List<String> photoList, GridView view) {
        this.photoList = photoList;
        if (photoList.size() == 0) {
            view.setVisibility(View.GONE);
        } else if (photoList.size() <= 3) {
            view.setNumColumns(photoList.size());
        }else{
            view.setNumColumns(3);
        }
    }

    public DisplayPhotoAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int position) {
        return photoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.photo_item_adapter, null);
        }
        ImageView addImage = (ImageView) convertView.findViewById(R.id.addImage);
        int spacing_12 = 12;
        int imgWidth = 0;
        int imgH = 0;
        if (columnNum == 1) {
            imgWidth = XLoad.screenW - 2 * spacing_12;
            imgH = (XLoad.screenW - 4 * spacing_12) / 2;
        } else if (columnNum == 2) {
            imgWidth = (XLoad.screenW - 3 * spacing_12) / 2;
            imgH = (XLoad.screenW - 4 * spacing_12) / 3;
        } else if (columnNum >= 3) {
            imgWidth = (XLoad.screenW - 4 * spacing_12) / 3;
            imgH = (XLoad.screenW - 4 * spacing_12) / 3;
        }
        addImage.setLayoutParams(new LinearLayout.LayoutParams(
                imgWidth, imgH));
        if (!TextUtils.isEmpty(photoList.get(position))) {
            XLoad.loadImage(context, photoList.get(position), addImage);
        } else {
            addImage.setImageResource(resImg);
        }
        if (isclick) {
            addImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("position", position);
                    intent.putExtra("statusColour",statusColour);
                    intent.putExtra("mainBackgroud",mainBackgroud);
                    intent.putExtra("backIcon",backIcon);
                    intent.putExtra("title",title);
                    intent.putExtra("backTitle",backTitle);
                    intent.putExtra("submitTitle",submitTitle);
                    intent.putExtra("titleColour",titleColour);
                    intent.putExtra("backColour",backColour);
                    intent.putStringArrayListExtra("serviceImg", (ArrayList<String>) photoList);
                    intent.setClass(context, DisplayImgActivity.class);
                    context.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}
