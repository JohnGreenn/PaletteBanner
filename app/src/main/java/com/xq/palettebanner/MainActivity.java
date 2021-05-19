package com.xq.palettebanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.LogUtils;

public class MainActivity extends BaseActivity {

    private  Banner banner;
    private RelativeLayout rl;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image7);


//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            //发生主线程    Palette调色板   总共六种颜色
//            @Override
//            public void onGenerated(Palette palette) {
//                //柔和而暗的颜色
//                int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);
//                //鲜艳和暗的颜色
//                int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
//                //亮和鲜艳的颜色
//                int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
//                //亮和柔和的颜色
//                int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
//                //柔和颜色
//                int mutedColor = palette.getMutedColor(Color.BLUE);
//                int vibrantColor = palette.getVibrantColor(Color.BLUE);
//
//                //主色调
//                Palette.Swatch vibrant = palette.getDominantSwatch();
//
//                //充满活力的颜色
//                //Palette.Swatch vibrant = palette.getVibrantSwatch();
//
//                t1.setBackgroundColor(vibrant.getRgb());
//                //t1.setBackgroundColor(darkMutedColor);
//                t2.setBackgroundColor(darkVibrantColor);
//                t3.setBackgroundColor(lightVibrantColor);
//                t4.setBackgroundColor(lightMutedColor);
//                t5.setBackgroundColor(mutedColor);
//                t6.setBackgroundColor(vibrantColor);
//            }
//        });

        /**
         * banner
         */

        banner = findViewById(R.id.banner);
        rl = findViewById(R.id.rl);

        //自定义的图片适配器，也可以使用默认的BannerImageAdapter
        ImageAdapter adapter = new ImageAdapter(DataBean.getTestData2());

        banner.setAdapter(adapter)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))//设置指示器
                .setOnBannerListener((data, position) -> {
                    Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
                    LogUtils.d("cccc-position：" + position);
                });

        banner.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,float positionOffset,int positionOffsetPixels) {
                changeColor(BitmapFactory.decodeResource(getResources(), DataBean.getTestData2().get(position).imageRes));
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    void changeColor(Bitmap bitmap){

        // Palette的部分
        Palette.Builder builder = Palette.from(bitmap);
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {

                //获取到充满活力的这种色调
                //Palette.Swatch vibrant = palette.getVibrantSwatch();
//                Palette.Swatch vibrantDark = palette.getDarkVibrantSwatch();//有活力的暗色
//                Palette.Swatch vibrantLight = palette.getLightVibrantSwatch();//有活力的亮色
//
//                Palette.Swatch muted = palette.getMutedSwatch();//柔和的
//                Palette.Swatch mutedDark = palette.getDarkMutedSwatch();//柔和的暗色
//                Palette.Swatch mutedLight = palette.getLightMutedSwatch();//柔和的亮色

                //返回调色板中的主要色板
                Palette.Swatch vibrant = palette.getDominantSwatch();
                //int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);
                //Palette.Swatch vibrant = palette.getLightVibrantColor(Color.BLUE);
                rl.setBackgroundColor(vibrant.getRgb());
            }
        });
    }
}
