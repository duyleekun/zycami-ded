/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.util.AttributeSet
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package com.tencent.liteav.txcvodplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.liteav.txcvodplayer.TextureRenderView$a;
import com.tencent.liteav.txcvodplayer.TextureRenderView$b;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$a;
import com.tencent.liteav.txcvodplayer.a$b;
import com.tencent.liteav.txcvodplayer.c;

public class TextureRenderView
extends TextureView
implements a {
    private static final String TAG = "TextureRenderView";
    private c mMeasureHelper;
    private TextureRenderView$b mSurfaceCallback;

    public TextureRenderView(Context context) {
        super(context);
        this.initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        this.initView(context);
    }

    public static /* synthetic */ TextureRenderView$b access$100(TextureRenderView textureRenderView) {
        return textureRenderView.mSurfaceCallback;
    }

    private void initView(Context object) {
        object = new c((View)this);
        this.mMeasureHelper = object;
        object = new TextureRenderView$b(this);
        this.mSurfaceCallback = object;
        this.setSurfaceTextureListener((TextureView.SurfaceTextureListener)object);
    }

    public void addRenderCallback(a$a a$a) {
        this.mSurfaceCallback.a(a$a);
    }

    public a$b getSurfaceHolder() {
        SurfaceTexture surfaceTexture = TextureRenderView$b.a(this.mSurfaceCallback);
        TextureRenderView$b textureRenderView$b = this.mSurfaceCallback;
        TextureRenderView$a textureRenderView$a = new TextureRenderView$a(this, surfaceTexture, textureRenderView$b);
        return textureRenderView$a;
    }

    public View getView() {
        return this;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mSurfaceCallback.c();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onDetachedFromWindow() {
        TextureRenderView$b textureRenderView$b;
        try {
            textureRenderView$b = this.mSurfaceCallback;
        }
        catch (Exception exception) {
            return;
        }
        textureRenderView$b.a();
        super.onDetachedFromWindow();
        textureRenderView$b = this.mSurfaceCallback;
        textureRenderView$b.b();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        String string2 = TextureRenderView.class.getName();
        accessibilityEvent.setClassName((CharSequence)string2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String string2 = TextureRenderView.class.getName();
        accessibilityNodeInfo.setClassName((CharSequence)string2);
    }

    public void onMeasure(int n10, int n11) {
        this.mMeasureHelper.c(n10, n11);
        n10 = this.mMeasureHelper.a();
        n11 = this.mMeasureHelper.b();
        this.setMeasuredDimension(n10, n11);
    }

    public void removeRenderCallback(a$a a$a) {
        this.mSurfaceCallback.b(a$a);
    }

    public void setAspectRatio(int n10) {
        this.mMeasureHelper.b(n10);
        this.requestLayout();
    }

    public void setVideoRotation(int n10) {
        this.mMeasureHelper.a(n10);
        float f10 = n10;
        this.setRotation(f10);
    }

    public void setVideoSampleAspectRatio(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            c c10 = this.mMeasureHelper;
            c10.b(n10, n11);
            this.requestLayout();
        }
    }

    public void setVideoSize(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            c c10 = this.mMeasureHelper;
            c10.a(n10, n11);
            this.requestLayout();
        }
    }

    public boolean shouldWaitForResize() {
        return false;
    }
}

