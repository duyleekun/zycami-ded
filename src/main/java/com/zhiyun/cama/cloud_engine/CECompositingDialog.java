/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.ProgressBar
 */
package com.zhiyun.cama.cloud_engine;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import com.quvideo.mobile.external.component.cloudcomposite.model.CompositeFinishResponse;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.zhiyun.cama.cloud_engine.CECompositingDialog$a;
import com.zhiyun.cama.cloud_engine.CECompositingDialog$b;
import com.zhiyun.common.util.Windows;
import d.v.c.t0.i;
import d.v.c.t0.i0;
import d.v.c.t0.j;
import d.v.c.t0.v;
import d.v.c.w0.l3;
import d.v.c.x1.l;
import d.v.e.i.e;
import d.v.f.g.a;
import d.v.i0.b;
import java.util.List;

public class CECompositingDialog
extends a {
    public static final /* synthetic */ boolean h;
    private l3 f;
    private v g;

    private void A() {
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
        dialog.setDimAmount(0.0f);
        dialog.setBackgroundDrawable(null);
    }

    public static /* synthetic */ void u(CECompositingDialog cECompositingDialog) {
        cECompositingDialog.y();
    }

    public static /* synthetic */ void v(CECompositingDialog cECompositingDialog, e e10) {
        cECompositingDialog.z(e10);
    }

    private /* synthetic */ void w(Integer n10) {
        ProgressBar progressBar = this.f.d;
        int n11 = n10;
        progressBar.setProgress(n11, true);
    }

    private void y() {
        NavHostFragment.findNavController(this).popBackStack(2131361793, false);
    }

    private void z(e object) {
        if (object == null) {
            return;
        }
        if ((object = (CompositeFinishResponse)((e)object).b()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        String string2 = ((CompositeFinishResponse)object).getFileUrl();
        bundle.putString("ARGUMENTS_FILEURL", string2);
        string2 = ((CompositeFinishResponse)object).getDuration();
        bundle.putString("ARGUMENTS_DURATION", string2);
        object = ((CompositeFinishResponse)object).getCoverImageUrl();
        bundle.putString("ARGUMENTS_COVERIMAGEURL", (String)object);
        l.e(this, 2131361799, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onStart() {
        super.onStart();
        this.A();
        this.f.getRoot().setKeepScreenOn(true);
    }

    public void onStop() {
        this.f.getRoot().setKeepScreenOn(false);
        super.onStop();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        Windows.a((View)this.f.a);
        object = (v)b.a(this).get(v.class);
        this.g = object;
        this.f.B((v)object);
        object = this.g.b;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.g.a;
        object2 = this.getViewLifecycleOwner();
        observer = new i(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.getArguments();
        if (object != null) {
            long l10 = object.getLong("CE_TEMPLATEID");
            object2 = object.getParcelableArrayList("CE_ALBUMSECTION");
            object = (CompositeConfig$Resolution)((Object)object.getSerializable("resolution"));
            v v10 = this.g;
            v10.l(l10, (CompositeConfig$Resolution)((Object)object), (List)object2);
        }
        object = this.requireActivity().getOnBackPressedDispatcher();
        object2 = new CECompositingDialog$a(this, true);
        ((OnBackPressedDispatcher)object).addCallback(this, (OnBackPressedCallback)object2);
        object = i0.e();
        object2 = this.getActivity();
        ((i0)object).f((Context)object2);
    }

    public int s() {
        return 2131558516;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (l3)viewDataBinding;
        this.f = viewDataBinding;
        CECompositingDialog$b cECompositingDialog$b = new CECompositingDialog$b(this);
        ((l3)viewDataBinding).A(cECompositingDialog$b);
    }

    public /* synthetic */ void x(Integer n10) {
        this.w(n10);
    }
}

