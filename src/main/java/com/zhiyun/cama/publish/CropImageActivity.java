/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.zhiyun.cama.publish.CropImageActivity$a;
import com.zhiyun.common.util.StatusBarUtil;
import d.t.a.b;
import d.t.a.b$a;
import d.t.a.c;
import d.v.c.n1.n;
import d.v.c.n1.o;
import d.v.c.n1.p;
import d.v.c.n1.q;
import d.v.c.n1.r;
import d.v.c.w0.x4;
import d.v.c.w0.z4;
import d.v.e.l.k2;
import d.v.e.l.o1;
import d.v.f.i.g;
import java.io.File;
import java.lang.reflect.Field;

public class CropImageActivity
extends c {
    private static final int S = 90;
    private static final int T = 1;
    private static final int U = 2000;
    private UCropView P;
    private CropImageActivity$a Q;
    private x4 R;

    public static /* synthetic */ void N(CropImageActivity cropImageActivity) {
        cropImageActivity.O();
    }

    private void O() {
        OverlayView overlayView = this.P.getOverlayView();
        overlayView.setShowCropGrid(false);
        overlayView.setShowCropFrame(false);
        overlayView.invalidate();
    }

    private /* synthetic */ void P(View view) {
        this.onBackPressed();
    }

    private /* synthetic */ void R(View view) {
        this.r();
    }

    private /* synthetic */ void T(View view) {
        this.Z();
    }

    private /* synthetic */ void V(View view) {
        this.onBackPressed();
    }

    private /* synthetic */ boolean X(View object, MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11) {
                this.Q.removeMessages(n11);
                object = this.Q;
                long l10 = 2000L;
                object.sendEmptyMessageDelayed(n11, l10);
            }
        } else {
            object = this.Q;
            object.removeMessages(n11);
            this.a0();
        }
        return false;
    }

    private void Z() {
        GestureCropImageView gestureCropImageView = this.P.getCropImageView();
        gestureCropImageView.y(90.0f);
        gestureCropImageView.A();
    }

    private void a0() {
        OverlayView overlayView = this.P.getOverlayView();
        boolean bl2 = true;
        Object object = ((Object)((Object)overlayView)).getClass();
        String string2 = "mShowCropGrid";
        object = ((Class)object).getDeclaredField(string2);
        ((Field)object).setAccessible(bl2);
        object = ((Field)object).get((Object)overlayView);
        object = (Boolean)object;
        try {
            boolean bl3 = (Boolean)object;
            if (bl3) {
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        overlayView.setShowCropGrid(bl2);
        overlayView.setShowCropFrame(bl2);
        overlayView.invalidate();
    }

    public static void b0(Fragment fragment, Uri object, float f10, float f11, boolean bl2) {
        File file = k2.h();
        CharSequence charSequence = new StringBuilder();
        long l10 = System.currentTimeMillis();
        charSequence.append(l10);
        charSequence.append(".png");
        charSequence = charSequence.toString();
        File file2 = new File(file, (String)charSequence);
        file2 = Uri.fromFile((File)file2);
        object = b.i((Uri)object, (Uri)file2);
        ((b)object).p(1440, 2960);
        ((b)object).o(f10, f11);
        b$a b$a = new b$a();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        b$a.f(compressFormat);
        b$a.g(100);
        int n10 = 1;
        b$a.p(n10 != 0);
        b$a.o(false);
        b$a.w(n10 != 0);
        b$a.e(bl2);
        n10 = g.e(fragment, 2131099747);
        b$a.u(n10);
        object = ((b)object).q(b$a);
        b$a = fragment.requireContext();
        object = ((b)object).d((Context)b$a);
        b$a = fragment.requireContext();
        object.setClass((Context)b$a, CropImageActivity.class);
        fragment.startActivityForResult((Intent)object, 69);
    }

    public /* synthetic */ void Q(View view) {
        this.P(view);
    }

    public /* synthetic */ void S(View view) {
        this.R(view);
    }

    public /* synthetic */ void U(View view) {
        this.T(view);
    }

    public /* synthetic */ void W(View view) {
        this.V(view);
    }

    public /* synthetic */ boolean Y(View view, MotionEvent motionEvent) {
        return this.X(view, motionEvent);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = (RelativeLayout)this.findViewById(2131363640);
        Object object2 = (UCropView)this.findViewById(2131363638);
        this.P = object2;
        this.findViewById(2131363327).setVisibility(8);
        object2 = (x4)DataBindingUtil.inflate(this.getLayoutInflater(), 2131558536, null, false);
        this.R = object2;
        int n10 = -1;
        int n11 = -2;
        object2 = new RelativeLayout.LayoutParams(n10, n11);
        object2.addRule(12);
        Object object3 = this.R.getRoot();
        object.addView(object3, (ViewGroup.LayoutParams)object2);
        object2 = this.R.b;
        object3 = new r(this);
        object2.setOnClickListener((View.OnClickListener)object3);
        object2 = this.R.c;
        object3 = new p(this);
        object2.setOnClickListener((View.OnClickListener)object3);
        object2 = this.R.a;
        object3 = new q(this);
        object2.setOnClickListener((View.OnClickListener)object3);
        object2 = (z4)DataBindingUtil.inflate(this.getLayoutInflater(), 2131558537, null, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n10, n11);
        layoutParams.addRule(10);
        View view = ((ViewDataBinding)object2).getRoot();
        object.addView(view, (ViewGroup.LayoutParams)layoutParams);
        object = ((z4)object2).a;
        object2 = new n(this);
        object.setOnClickListener((View.OnClickListener)object2);
        object = this.P.getCropImageView();
        object2 = new o(this);
        object.setOnTouchListener((View.OnTouchListener)object2);
    }

    public void onStart() {
        CropImageActivity$a cropImageActivity$a;
        super.onStart();
        this.Q = cropImageActivity$a = new CropImageActivity$a(this);
        cropImageActivity$a.sendEmptyMessageDelayed(1, 2000L);
        cropImageActivity$a = this.getWindow();
        int n10 = o1.a((Context)this, 2131099739);
        StatusBarUtil.h((Window)cropImageActivity$a, n10);
    }
}

