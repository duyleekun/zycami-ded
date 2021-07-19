/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package com.tencent.liteav.txcvodplayer;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.SurfaceRenderView$b;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$a;
import com.tencent.liteav.txcvodplayer.c;

public class SurfaceRenderView
extends SurfaceView
implements a {
    private c a;
    private SurfaceRenderView$b b;

    public SurfaceRenderView(Context context) {
        super(context);
        this.a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context);
    }

    private void a(Context object) {
        object = new c((View)this);
        this.a = object;
        object = new SurfaceRenderView$b(this);
        this.b = object;
        object = this.getHolder();
        SurfaceRenderView$b surfaceRenderView$b = this.b;
        object.addCallback((SurfaceHolder.Callback)surfaceRenderView$b);
        this.getHolder().setType(0);
    }

    public void addRenderCallback(a$a a$a) {
        this.b.a(a$a);
    }

    public View getView() {
        return this;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        String string2 = SurfaceRenderView.class.getName();
        accessibilityEvent.setClassName((CharSequence)string2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 >= n11) {
            String string2 = SurfaceRenderView.class.getName();
            accessibilityNodeInfo.setClassName((CharSequence)string2);
        }
    }

    public void onMeasure(int n10, int n11) {
        this.a.c(n10, n11);
        n10 = this.a.a();
        n11 = this.a.b();
        this.setMeasuredDimension(n10, n11);
    }

    public void removeRenderCallback(a$a a$a) {
        this.b.b(a$a);
    }

    public void setAspectRatio(int n10) {
        this.a.b(n10);
        this.requestLayout();
    }

    public void setVideoRotation(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceView doesn't support rotation (");
        stringBuilder.append(n10);
        stringBuilder.append(")!\n");
        String string2 = stringBuilder.toString();
        TXCLog.e("", string2);
    }

    public void setVideoSampleAspectRatio(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            c c10 = this.a;
            c10.b(n10, n11);
            this.requestLayout();
        }
    }

    public void setVideoSize(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            this.a.a(n10, n11);
            SurfaceHolder surfaceHolder = this.getHolder();
            surfaceHolder.setFixedSize(n10, n11);
            this.requestLayout();
        }
    }

    public boolean shouldWaitForResize() {
        return true;
    }
}

