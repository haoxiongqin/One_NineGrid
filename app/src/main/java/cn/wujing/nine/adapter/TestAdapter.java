package cn.wujing.nine.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Map;

import cn.wujing.nine.R;
import cn.wujing.nine.view.ExpandGridView;
import wujing.cn.library.adapter.DisplayPhotoAdapter;


public class TestAdapter extends BaseAdapter {
    Context context;
    Map<Integer,ArrayList> map;
    public TestAdapter(Context context,Map<Integer,ArrayList> map) {
        this.map = map;
        this.context = context;
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.audience_tip_adapter, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
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
//        adapter.setBackIcon(R.drawable.back_black);
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
        adapter.setBackColour(ContextCompat.getColor(context,R.color.colorAccent));
        //设置标题栏的颜色
        adapter.setTitleColour(ContextCompat.getColor(context,R.color.colorAccent));
        viewHolder.grideview.setAdapter(adapter);
        return view;
    }

    public class ViewHolder {
        public final ExpandGridView grideview;
        public final View root;

        public ViewHolder(View root) {
            grideview=(ExpandGridView)root.findViewById(R.id.gride_view);
            this.root = root;
        }
    }
}
