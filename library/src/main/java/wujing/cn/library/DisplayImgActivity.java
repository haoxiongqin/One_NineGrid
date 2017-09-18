package wujing.cn.library;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import wujing.cn.library.view.HackyViewPager;
import wujing.cn.library.view.StatusBar;

public class DisplayImgActivity extends AppCompatActivity {

    TextView headerBack;
    TextView headerText;
    TextView headerSubmit;
    RelativeLayout layoutheader;
    HackyViewPager viewpager;
    ArrayList<String> lists;
    int position;
    int stausBarColor=0;
    int mainBackgroud=0;
    int backIcon=0;
    int titleColour=0;
    int backColour=0;
    String title;
    String backTitle;
    String submitTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_img);
        initData();
        initView();
        headerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void initData() {
        position = getIntent().getIntExtra("position", -1);
        lists = getIntent().getStringArrayListExtra("serviceImg");
        stausBarColor=getIntent().getIntExtra("statusColour", 0);
        mainBackgroud=getIntent().getIntExtra("mainBackgroud", 0);
        backIcon=getIntent().getIntExtra("backIcon", 0);
        titleColour=getIntent().getIntExtra("titleColour", 0);
        backColour=getIntent().getIntExtra("backColour", 0);
        title=getIntent().getStringExtra("title");
        backTitle=getIntent().getStringExtra("backTitle");
        submitTitle=getIntent().getStringExtra("submitTitle");
    }
    private void initView() {
        headerBack = (TextView) findViewById(R.id.headerBack);
        headerText = (TextView) findViewById(R.id.headerText);
        headerSubmit = (TextView) findViewById(R.id.headerSubmit);
        layoutheader = (RelativeLayout) findViewById(R.id.layout_header);
        viewpager = (HackyViewPager) findViewById(R.id.view_pager);
        viewpager.setAdapter(new SamplePagerAdapter());
        viewpager.setCurrentItem(position);
        if(stausBarColor!=0){
            StatusBar.setColor(this,stausBarColor);
        }else{
            StatusBar.setColor(this, ContextCompat.getColor(this,R.color.colorPrimary));
        }
        if(mainBackgroud!=0){
            layoutheader.setBackgroundColor(mainBackgroud);
        }else{
            layoutheader.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        }
        if(backIcon!=0){
            setTitleBackIcon(backIcon);
        }
        if(titleColour!=0){
            headerText.setTextColor(titleColour);
        }
        if(backColour!=0){
            headerBack.setTextColor(backColour);
        }
        if(!TextUtils.isEmpty(title)){
            setTitleCenter(title);
        }
        if(!TextUtils.isEmpty(backTitle)){
            setTitleBack(backTitle);
        }
        if(!TextUtils.isEmpty(submitTitle)){
            setTitleSubmit(submitTitle);
        }
    }

    /**
     * 设置左侧内容
     *
     * @param content
     */
    public void setTitleBack(String content) {
        headerBack.setCompoundDrawables(null,null,null,null);
        headerBack.setText(content);
    }
    /**
     * 设置显示左侧图片
     */
    public void setTitleBackIcon(int res) {
        Drawable drawable = getResources().getDrawable(res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        headerBack.setCompoundDrawables(drawable, null, null, null);
    }
    /**
     * 设置显示头部右侧内容
     *
     * @param content
     */
    public void setTitleSubmit(String content) {
        headerSubmit.setText(content);
    }

    /**
     * 设置显示右侧图片
     */
    public void setTitleSubmitIcon(int res) {
        Drawable drawable = getResources().getDrawable(res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        headerSubmit.setCompoundDrawables(drawable, null, null, null);
    }
    /**
     * 设置中间内容
     *
     * @param content
     */
    public void setTitleCenter(String content) {
        headerText.setText(content);
    }

    class SamplePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return lists.size();
        }
        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            if (lists != null && lists.size() > 0) {
                XLoad.loadFileImage(DisplayImgActivity.this, lists.get(position), photoView);
            }
            photoView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(photoView, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
            return photoView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
