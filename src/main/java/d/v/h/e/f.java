/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package d.v.h.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public abstract class f
extends FrameLayout {
    private static final String b = "VideoPlayerView";
    public View a;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.setBackgroundColor(-16777216);
        context = LayoutInflater.from((Context)context);
        int n11 = this.a();
        context = context.inflate(n11, (ViewGroup)this, false);
        this.a = context;
        this.addView((View)context);
    }

    public abstract int a();

    public abstract SurfaceView getDisplayView();
}

