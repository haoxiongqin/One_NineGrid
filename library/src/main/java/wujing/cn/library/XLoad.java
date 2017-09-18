package wujing.cn.library;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.Target;

import wujing.cn.library.view.DensityUtils;

public class XLoad {
    public static Context context;
    public static int screenH;
    public static int screenW;
    public static DisplayImgActivity imgactivity;
    public static void init(Context context) {
        XLoad.context = context;
        imgactivity=new DisplayImgActivity();
        screenH = DensityUtils.getScreenH(context);
        screenW = DensityUtils.getScreenW(context);
    }

    public static Context getContext() {
        synchronized (XLoad.class) {
            if (XLoad.context == null)
                throw new NullPointerException("Call XFrame.init(context) within your Application onCreate() method." +
                        "Or extends XApplication");
            return XLoad.context.getApplicationContext();
        }
    }
    public static void loadImage(Context context, String url, ImageView view) {
        Glide.with(context.getApplicationContext())
                .load(url)
                .centerCrop()
                .into(view);
    }
    public static ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            view.setAlpha(0f);
            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
            fadeAnim.setDuration(2500);
            fadeAnim.start();
        }
    };

    public static void loadFileImage(final Context context, String url, ImageView view) {
        Glide.with(context.getApplicationContext())
                .load(url)
                .animate(animationObject)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Toast.makeText(context,"加载异常",Toast.LENGTH_SHORT);
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(view);
    }
}
