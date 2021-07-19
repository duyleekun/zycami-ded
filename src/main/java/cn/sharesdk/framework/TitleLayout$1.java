/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package cn.sharesdk.framework;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;

public class TitleLayout$1
extends TextView {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ TitleLayout b;

    public TitleLayout$1(TitleLayout titleLayout, Context context, ImageView imageView) {
        this.b = titleLayout;
        this.a = imageView;
        super(context);
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        this.a.setVisibility(n10);
    }
}

