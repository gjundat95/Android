package com.jundat95.woorestaurant.CustomTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by jundat95 on 23/03/2016.
 */
public class robotoLight extends TextView {
    public robotoLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public robotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public robotoLight(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/robotos/Regular.ttf");
        setTypeface(tf);
    }
}
