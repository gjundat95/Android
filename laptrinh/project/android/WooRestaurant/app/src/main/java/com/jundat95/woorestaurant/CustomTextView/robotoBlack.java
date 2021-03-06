package com.jundat95.woorestaurant.CustomTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by jundat95 on 23/03/2016.
 */
public class robotoBlack extends TextView {
    public robotoBlack(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public robotoBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public robotoBlack(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context){
        Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/robotos/Black.ttf");
        setTypeface(tf);
    }
}
