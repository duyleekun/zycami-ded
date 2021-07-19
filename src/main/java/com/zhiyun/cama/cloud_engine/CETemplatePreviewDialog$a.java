/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.cloud_engine;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data$DataType;
import com.zhiyun.cama.cloud_engine.CETemplateModel;
import com.zhiyun.cama.cloud_engine.CETemplatePreviewDialog;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.t0.a;
import d.v.c.t0.g0;
import d.v.c.t0.q;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class CETemplatePreviewDialog$a {
    private int a;
    public final /* synthetic */ CETemplatePreviewDialog b;

    public CETemplatePreviewDialog$a(CETemplatePreviewDialog cETemplatePreviewDialog) {
        this.b = cETemplatePreviewDialog;
    }

    private /* synthetic */ void c(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        CETemplatePreviewDialog.w(this.b, 1);
        this.f();
    }

    private void f() {
        ExoVideoView exoVideoView = CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).g;
        int n10 = this.a;
        exoVideoView.c(n10);
        CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).g.start();
        CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).d.setVisibility(8);
    }

    public void a() {
        NavHostFragment.findNavController(this.b).popBackStack();
    }

    public void b() {
        CETemplatePreviewDialog.x(this.b).set(false);
        CETemplatePreviewDialog.y(this.b);
    }

    public /* synthetic */ void d(DialogFragment dialogFragment) {
        this.c(dialogFragment);
    }

    public void e() {
        ExoVideoView exoVideoView = CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).g;
        int n10 = exoVideoView.isPlaying();
        if (n10 == 0) {
            return;
        }
        this.a = n10 = CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).g.getCurrentPosition();
        CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).g.E();
        CETemplatePreviewDialog.u((CETemplatePreviewDialog)this.b).d.setVisibility(0);
    }

    public void g() {
        Object object = this.b;
        int n10 = CETemplatePreviewDialog.v((CETemplatePreviewDialog)object);
        if (n10 == 0) {
            Object object2 = this.b.getContext();
            object = new k$b((Context)object2);
            object = (k$b)((k$a)object).A(2131952796);
            d.v.f.f.a a10 = d.v.c.t0.a.a;
            object = (k$b)((k$a)object).o(2131951833, a10);
            a10 = new q(this);
            object = (k$b)((k$a)object).v(2131952767, a10);
            object2 = this.b.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
            return;
        }
        this.f();
    }

    public void h(CETemplateModel object) {
        Object object2;
        TemplateResponse$Data$DataType templateResponse$Data$DataType = ((CETemplateModel)object).getDateType();
        int n10 = templateResponse$Data$DataType == (object2 = TemplateResponse$Data$DataType.image) ? 4 : (templateResponse$Data$DataType == (object2 = TemplateResponse$Data$DataType.video) ? 2 : 6);
        object2 = NavHostFragment.findNavController(this.b);
        int n11 = ((CETemplateModel)object).getMaxMediaCount();
        long l10 = ((CETemplateModel)object).getTemplateId();
        object = g0.a(n11, l10, n10);
        ((NavController)object2).navigate((NavDirections)object);
    }
}

