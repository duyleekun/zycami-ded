/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.cloud_engine;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import com.zhiyun.cama.cloud_engine.CETemplatePreviewDialog$a;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.t0.f0;
import d.v.c.t0.o;
import d.v.c.t0.p;
import d.v.c.w0.r2;
import d.v.e.f;
import d.v.e.l.b2;
import d.v.f.g.a;
import d.v.j0.d;

public class CETemplatePreviewDialog
extends a {
    private r2 f;
    private CETemplatePreviewDialog$a g;
    private int h = -1;
    private ObservableBoolean i;
    private String j;

    public CETemplatePreviewDialog() {
        ObservableBoolean observableBoolean;
        this.i = observableBoolean = new ObservableBoolean();
    }

    private /* synthetic */ void A(Context object, d object2) {
        boolean bl2;
        int n10 = this.h;
        int n11 = -1;
        if (n10 == n11 && (bl2 = b2.l(object))) {
            object = this.f.g;
            object2 = new o(this);
            long l10 = 50;
            object.postDelayed((Runnable)object2, l10);
        }
    }

    private /* synthetic */ void C() {
        this.h = 0;
        this.g.e();
        this.f.g.c(1);
    }

    private void E() {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        dialog = this.getDialog().getWindow();
        if (dialog == null) {
            return;
        }
        int n10 = -1;
        dialog.setLayout(n10, n10);
        dialog.setDimAmount(0.8f);
        dialog.setBackgroundDrawableResource(2131099742);
    }

    public static /* synthetic */ r2 u(CETemplatePreviewDialog cETemplatePreviewDialog) {
        return cETemplatePreviewDialog.f;
    }

    public static /* synthetic */ int v(CETemplatePreviewDialog cETemplatePreviewDialog) {
        return cETemplatePreviewDialog.h;
    }

    public static /* synthetic */ int w(CETemplatePreviewDialog cETemplatePreviewDialog, int n10) {
        cETemplatePreviewDialog.h = n10;
        return n10;
    }

    public static /* synthetic */ ObservableBoolean x(CETemplatePreviewDialog cETemplatePreviewDialog) {
        return cETemplatePreviewDialog.i;
    }

    public static /* synthetic */ void y(CETemplatePreviewDialog cETemplatePreviewDialog) {
        cETemplatePreviewDialog.z();
    }

    private void z() {
        Object object = d.v.e.f.a().c();
        boolean bl2 = b2.m((Context)object);
        int n10 = 1;
        if (!bl2) {
            this.i.set(n10 != 0);
            return;
        }
        Uri[] uriArray = this.f.g;
        p p10 = new p(this, (Context)object);
        uriArray.setOnPreparedListener(p10);
        object = this.f.g;
        uriArray = new Uri[n10];
        p10 = Uri.parse((String)this.j);
        uriArray[0] = p10;
        ((ExoVideoView)object).setVideoURI(uriArray);
    }

    public /* synthetic */ void B(Context context, d d10) {
        this.A(context, d10);
    }

    public /* synthetic */ void D() {
        this.C();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onDestroy() {
        this.f.g.F(true);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.g.e();
    }

    public void onStart() {
        super.onStart();
        this.E();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = f0.b(this.getArguments()).c();
        object2 = ((CETemplateModel)object).getPreviewurl();
        this.j = object2;
        this.f.C((CETemplateModel)object);
        object = this.f;
        object2 = this.i;
        ((r2)object).D((ObservableBoolean)object2);
        object = this.f;
        object2 = new CETemplatePreviewDialog$a(this);
        this.g = object2;
        ((r2)object).B((CETemplatePreviewDialog$a)object2);
        this.f.g.L(false);
        this.f.g.setMediaControllerDefault(false);
        this.f.g.setLoopPlay(true);
        this.z();
    }

    public int s() {
        return 2131558489;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (r2)viewDataBinding;
        this.f = viewDataBinding;
    }
}

