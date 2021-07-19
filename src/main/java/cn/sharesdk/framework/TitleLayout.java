/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout$1;
import com.mob.tools.utils.ResHelper;

public class TitleLayout
extends LinearLayout {
    private ImageView btnBack;
    private TextView btnRight;
    private TextView tvTitle;

    public TitleLayout(Context context) {
        super(context);
        this.init(context);
    }

    public TitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    private void init(Context context) {
        float f10;
        Object object;
        Object object2;
        this.btnBack = object2 = new ImageView(context);
        object2.setBackgroundDrawable(null);
        object2 = "ssdk_back_arr";
        int n10 = ResHelper.getBitmapRes(context, (String)object2);
        if (n10 > 0) {
            object = this.btnBack;
            object.setImageResource(n10);
        }
        object2 = this.btnBack;
        object = ImageView.ScaleType.CENTER_INSIDE;
        object2.setScaleType((ImageView.ScaleType)object);
        n10 = ResHelper.dipToPx(context, 48);
        object = this.btnBack;
        int n11 = -1;
        Object object3 = new LinearLayout.LayoutParams(n10, n11);
        object.setLayoutParams((ViewGroup.LayoutParams)object3);
        object2 = this.btnBack;
        this.addView((View)object2);
        object2 = new ImageView(context);
        int n12 = ResHelper.dipToPx(context, 2);
        object3 = "ssdk_title_div";
        int n13 = ResHelper.getBitmapRes(context, (String)object3);
        if (n13 > 0) {
            object2.setImageResource(n13);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(n12, n11);
        object2.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.addView((View)object2);
        object2 = new TextView(context);
        this.tvTitle = object2;
        n10 = ResHelper.dipToPx(context, 23);
        this.tvTitle.setPadding(n10, 0, n10, 0);
        this.tvTitle.setSingleLine();
        this.tvTitle.setTextColor(n11);
        object2 = this.tvTitle;
        int n14 = 1;
        object2.setTextSize(n14, 18.0f);
        object2 = this.tvTitle;
        layoutParams = Typeface.DEFAULT_BOLD;
        object2.setTypeface((Typeface)layoutParams);
        this.tvTitle.setGravity(16);
        n13 = -2;
        object2 = new LinearLayout.LayoutParams(n13, n11);
        object2.weight = f10 = 1.0f;
        TextView textView = this.tvTitle;
        textView.setLayoutParams((ViewGroup.LayoutParams)object2);
        object2 = this.tvTitle;
        this.addView((View)object2);
        object2 = new ImageView(context);
        int n15 = ResHelper.getBitmapRes(context, (String)object3);
        if (n15 > 0) {
            object2.setImageResource(n15);
        }
        object3 = new LinearLayout.LayoutParams(n12, n11);
        object2.setLayoutParams((ViewGroup.LayoutParams)object3);
        this.addView((View)object2);
        object = new TitleLayout$1(this, context, (ImageView)object2);
        this.btnRight = object;
        object.setVisibility(4);
        this.btnRight.setBackgroundDrawable(null);
        int n16 = ResHelper.dipToPx(context, 50);
        this.btnRight.setMinWidth(n16);
        this.btnRight.setTextColor(n11);
        this.btnRight.setTextSize(n14, 12.0f);
        this.btnRight.setGravity(17);
        context = this.btnRight;
        object2 = new LinearLayout.LayoutParams(n13, n11);
        context.setLayoutParams((ViewGroup.LayoutParams)object2);
        context = this.btnRight;
        this.addView((View)context);
    }

    public ImageView getBtnBack() {
        return this.btnBack;
    }

    public TextView getBtnRight() {
        return this.btnRight;
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }
}

