/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 */
package com.zhiyun.cama.appeal.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;
import com.zhiyun.common.util.Windows;
import com.zhiyun.image.Images;
import d.v.c.p0.p.g;
import d.v.c.p0.p.g$a;
import d.v.e.l.h2;

public class AppealDetailActivity$b
extends g {
    public final /* synthetic */ AppealDetailActivity b;

    public AppealDetailActivity$b(AppealDetailActivity appealDetailActivity) {
        this.b = appealDetailActivity;
    }

    public int g(int n10) {
        return 0;
    }

    public View h(int n10, Context context) {
        int n11;
        int n12;
        ImageView imageView = new ImageView(context);
        int n13 = Windows.l(context).getWidth();
        int n14 = h2.b(96.0f);
        n13 = (int)((float)(n13 - n14) * 1.0f / 3.0f);
        RecyclerView$LayoutParams recyclerView$LayoutParams = new RecyclerView$LayoutParams(-1, -2);
        float f10 = 8.0f;
        recyclerView$LayoutParams.rightMargin = n12 = h2.b(f10);
        recyclerView$LayoutParams.topMargin = n12 = h2.b(f10);
        recyclerView$LayoutParams.bottomMargin = n12 = h2.b(f10);
        recyclerView$LayoutParams.leftMargin = n11 = h2.b(f10);
        recyclerView$LayoutParams.height = n13;
        imageView.setLayoutParams((ViewGroup.LayoutParams)recyclerView$LayoutParams);
        return imageView;
    }

    public void n(g$a g$a, int n10) {
        g$a = (ImageView)g$a.itemView;
        Object object = this.getItem(n10);
        int n11 = h2.b(8.0f);
        Images.H((ImageView)g$a, object, n11, 2131232156);
    }
}

