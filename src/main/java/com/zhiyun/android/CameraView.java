/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.util.Size
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package com.zhiyun.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.zhiyun.android.CameraYun;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b.a0;
import d.v.b.b0.k.a;
import d.v.b.b0.k.b;
import d.v.b.b0.k.c;
import d.v.b.b0.k.d;
import d.v.b.b0.k.h;
import d.v.b.b0.k.i;
import d.v.b.c0.e$a;
import d.v.b.f0.l.e;
import d.v.b.f0.l.f;
import d.v.b.f0.l.g;
import d.v.b.u;
import d.v.b.w;
import d.v.b.x;
import d.v.b.y;
import d.v.b.z;
import d.v.d.i.f.j;
import d.v.d.i.f.l;
import d.v.d.i.f.m;
import d.v.d.i.f.n;
import d.v.d.i.f.r;
import d.v.d.i.f.t;
import d.v.d.i.g.k;

public class CameraView
extends FrameLayout
implements x,
w,
y,
a0,
z {
    private CameraYun a;

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.f(context, attributeSet);
    }

    private void f(Context object, AttributeSet object2) {
        CameraYun cameraYun;
        this.a = cameraYun = new CameraYun((Context)object, (ViewGroup)this, (AttributeSet)object2);
        object = this.getTextureSize();
        object2 = new d.v.b.a(this);
        ((d.v.b.c0.b)object).h((e$a)object2);
    }

    private /* synthetic */ void g(Size size, int n10) {
        this.i();
    }

    private void i() {
        Handler handler = this.getHandler();
        if (handler == null) {
            return;
        }
        handler = this.getHandler();
        u u10 = new u(this);
        handler.post((Runnable)u10);
    }

    public void a() {
        this.a.a();
    }

    public Bitmap b(int n10, int n11) {
        return this.a.b(n10, n11);
    }

    public void c() {
        this.a.c();
    }

    public void d(Lifecycle lifecycle) {
        this.a.d(lifecycle);
    }

    public Bitmap e(int n10, int n11) {
        return this.b(n10, n11);
    }

    public a getBeautyCheek() {
        return this.a.getBeautyCheek();
    }

    public b getBeautyEye() {
        return this.a.getBeautyEye();
    }

    public c getBeautyFilter() {
        return this.a.getBeautyFilter();
    }

    public d getBeautyLight() {
        return this.a.getBeautyLight();
    }

    public d.v.b.b0.k.f getBeautyRosy() {
        return this.a.getBeautyRosy();
    }

    public d.v.b.b0.k.g getBeautySkin() {
        return this.a.getBeautySkin();
    }

    public h getBeautySwitch() {
        return this.a.getBeautySwitch();
    }

    public i getBeautyWhite() {
        return this.a.getBeautyWhite();
    }

    public d.v.d.i.b.a getCameraApi() {
        return this.a.getCameraApi();
    }

    public d.v.d.i.b.b getCameraMode() {
        return this.a.getCameraMode();
    }

    public d.v.d.i.b.d getCameraStatus() {
        return this.a.getCameraStatus();
    }

    public d.v.d.i.b.e getCameraUpdate() {
        return this.a.getCameraUpdate();
    }

    public d.v.d.i.c.a getDeviceOrientation() {
        return this.a.getDeviceOrientation();
    }

    public d.v.d.i.c.c getDeviceStatus() {
        return this.a.getDeviceStatus();
    }

    public DisplayRender getDisplayRender() {
        return (DisplayRender)this.getTextureEncoder().get();
    }

    public d.v.d.i.d.c getLivePcm() {
        return this.a.getLivePcm();
    }

    public d.v.d.i.d.d getLiveRecord() {
        return this.a.getLiveRecord();
    }

    public d.v.b.d0.k.d getMaskAnimation() {
        return this.a.getMaskAnimation();
    }

    public d.v.b.d0.k.f getMaskColor() {
        return this.a.getMaskColor();
    }

    public d.v.b.d0.k.h getMaskGrid() {
        return this.a.getMaskGrid();
    }

    public d.v.b.d0.k.i getMaskMotion() {
        return this.a.getMaskMotion();
    }

    public d.v.b.d0.k.j getMaskScale() {
        return this.a.getMaskScale();
    }

    public d.v.b.d0.k.l getMaskValue() {
        return this.a.getMaskValue();
    }

    public d.v.d.i.e.a getPhotoControl() {
        return this.a.getPhotoControl();
    }

    public d.v.d.i.e.b getPhotoData() {
        return this.a.getPhotoData();
    }

    public d.v.d.i.e.c getPhotoMirror() {
        return this.a.getPhotoMirror();
    }

    public d.v.d.i.e.e getPhotoPath() {
        return this.a.getPhotoPath();
    }

    public d.v.d.i.e.f getPhotoSize() {
        return this.a.getPhotoSize();
    }

    public d.v.d.i.e.g getPhotoStatus() {
        return this.a.getPhotoStatus();
    }

    public d.v.d.i.e.h getPhotoTime() {
        return this.a.getPhotoTime();
    }

    public d.v.d.i.f.e getPreviewAe() {
        return this.a.getPreviewAe();
    }

    public d.v.d.i.f.f getPreviewAf() {
        return this.a.getPreviewAf();
    }

    public d.v.d.i.f.g getPreviewData() {
        return this.a.getPreviewData();
    }

    public d.v.d.i.f.h getPreviewFace() {
        return this.a.getPreviewFace();
    }

    public d.v.d.i.f.i getPreviewFlash() {
        return this.a.getPreviewFlash();
    }

    public j getPreviewFocus() {
        return this.a.getPreviewFocus();
    }

    public l getPreviewId() {
        return this.a.getPreviewId();
    }

    public m getPreviewIso() {
        return this.a.getPreviewIso();
    }

    public n getPreviewList() {
        return this.a.getPreviewList();
    }

    public r getPreviewSec() {
        return this.a.getPreviewSec();
    }

    public t getPreviewSize() {
        return this.a.getPreviewSize();
    }

    public d.v.d.i.f.u getPreviewStatus() {
        return this.a.getPreviewStatus();
    }

    public d.v.d.i.f.w getPreviewView() {
        return this.a.getPreviewView();
    }

    public d.v.d.i.f.x getPreviewWb() {
        return this.a.getPreviewWb();
    }

    public d.v.d.i.f.y getPreviewWbType() {
        return this.a.getPreviewWbType();
    }

    public d.v.d.i.f.z getPreviewWt() {
        return this.a.getPreviewWt();
    }

    public d.v.d.i.f.a0 getPreviewZoom() {
        return this.a.getPreviewZoom();
    }

    public d.v.d.i.g.c getRecordArm() {
        return this.a.getRecordArm();
    }

    public d.v.d.i.g.e getRecordCapture() {
        return this.a.getRecordCapture();
    }

    public d.v.d.i.g.f getRecordControl() {
        return this.a.getRecordControl();
    }

    public d.v.d.i.g.g getRecordMic() {
        return this.a.getRecordMic();
    }

    public d.v.d.i.g.h getRecordMute() {
        return this.a.getRecordMute();
    }

    public d.v.d.i.g.j getRecordPath() {
        return this.a.getRecordPath();
    }

    public k getRecordSize() {
        return this.a.getRecordSize();
    }

    public d.v.d.i.g.l getRecordStatus() {
        return this.a.getRecordStatus();
    }

    public d.v.d.i.g.m getRecordSurface() {
        return this.a.getRecordSurface();
    }

    public d.v.d.i.g.n getRecordVolume() {
        return this.a.getRecordVolume();
    }

    public d.v.b.f0.l.c getTextureEncoder() {
        return this.a.getTextureEncoder();
    }

    public d.v.b.f0.l.d getTextureOrientation() {
        return this.a.getTextureOrientation();
    }

    public e getTextureRatio() {
        return this.a.getTextureRatio();
    }

    public f getTextureSize() {
        return this.a.getTextureSize();
    }

    public g getTextureStatus() {
        return this.a.getTextureStatus();
    }

    public /* synthetic */ void h(Size size, int n10) {
        this.g(size, n10);
    }

    public void onMeasure(int n10, int n11) {
        f f10 = this.getTextureSize();
        int n12 = f10.p();
        f f11 = this.getTextureSize();
        int n13 = f11.o();
        if (n12 > 0 && n13 > 0) {
            n10 = 0x40000000;
            n11 = View.MeasureSpec.makeMeasureSpec((int)n12, (int)n10);
            n10 = View.MeasureSpec.makeMeasureSpec((int)n13, (int)n10);
            super.onMeasure(n11, n10);
            return;
        }
        super.onMeasure(n10, n11);
    }
}

