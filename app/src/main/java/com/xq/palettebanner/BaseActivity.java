package com.xq.palettebanner;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/18 19:20
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
