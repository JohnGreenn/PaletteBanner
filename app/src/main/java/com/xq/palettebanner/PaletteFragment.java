package com.xq.palettebanner;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/18 18:26
 */
public class PaletteFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;
    private static final int[] drawables = {R.mipmap.image7, R.mipmap.two2, R.mipmap.four, R.mipmap
            .three3, R.mipmap.five};

    public static PaletteFragment newInstance(int position) {
        PaletteFragment f = new PaletteFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams
                .MATCH_PARENT);

        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);
        fl.setBackgroundResource(drawables[position]);
        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8,
                getResources().getDisplayMetrics());

        TextView v = new TextView(getActivity());
        params.setMargins(margin, margin, margin, margin);
        v.setLayoutParams(params);
        v.setLayoutParams(params);
        v.setGravity(Gravity.BOTTOM);
        v.setText("CARD " + (position + 1));

        fl.addView(v);
        return fl;
    }

    /**
     * 提供当前Fragment的主色调的Bitmap对象,供Palette解析颜色
     *
     * @return
     */
    public static int getBackgroundBitmapPosition(int selectViewPagerItem) {
        return drawables[selectViewPagerItem];
    }

}
