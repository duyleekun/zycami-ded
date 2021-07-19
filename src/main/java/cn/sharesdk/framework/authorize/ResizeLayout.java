/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.LinearLayout
 */
package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import cn.sharesdk.framework.authorize.ResizeLayout$OnResizeListener;

public class ResizeLayout
extends LinearLayout {
    private ResizeLayout$OnResizeListener a;

    public ResizeLayout(Context context) {
        super(context);
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(ResizeLayout$OnResizeListener resizeLayout$OnResizeListener) {
        this.a = resizeLayout$OnResizeListener;
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        ResizeLayout$OnResizeListener resizeLayout$OnResizeListener = this.a;
        if (resizeLayout$OnResizeListener != null) {
            resizeLayout$OnResizeListener.OnResize(n10, n11, n12, n13);
        }
    }
}

