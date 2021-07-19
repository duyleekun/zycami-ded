/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 */
package com.zhiyun.cama.album;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.album.AlbumDeleteConfirmDialog$a;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.common.util.Windows;
import d.v.c.o0.u0;
import d.v.c.w0.b3;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.f.i.g;
import d.v.i0.b;
import java.util.Arrays;
import java.util.List;

public class AlbumDeleteConfirmDialog
extends a {
    private b3 f;
    private u0 g;
    private List h;

    public static /* synthetic */ List u(AlbumDeleteConfirmDialog albumDeleteConfirmDialog) {
        return albumDeleteConfirmDialog.h;
    }

    public static /* synthetic */ u0 v(AlbumDeleteConfirmDialog albumDeleteConfirmDialog) {
        return albumDeleteConfirmDialog.g;
    }

    private /* synthetic */ void w(Integer n10) {
        int n11 = n10;
        if (n11 == 0) {
            this.dismiss();
        }
    }

    private void y() {
        float f10;
        float f11;
        int n10;
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        dialog = this.getDialog().getWindow();
        if (dialog == null) {
            return;
        }
        Context context = this.requireContext();
        int n11 = h2.c(context);
        if (n11 != 0) {
            n10 = 1133903872;
            f11 = 300.0f;
        } else {
            n10 = 1134559232;
            f11 = 320.0f;
        }
        n10 = h2.b(f11);
        if (n11 != 0) {
            n11 = 1125122048;
            f10 = 144.0f;
        } else {
            n11 = 1126563840;
            f10 = 166.0f;
        }
        n11 = h2.b(f10);
        dialog.setLayout(n10, n11);
        dialog.setBackgroundDrawableResource(2131231975);
        Windows.p((Window)dialog);
    }

    public void onActivityCreated(Bundle object) {
        super.onActivityCreated((Bundle)object);
        object = (u0)b.c(this.requireActivity()).get(u0.class);
        this.g = object;
        this.f.B((u0)object);
        object = this.g.d;
        Object object2 = this.getViewLifecycleOwner();
        Object[] objectArray = new d.v.c.o0.b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)objectArray);
        object = this.getArguments();
        if (object != null && (object = object.getParcelableArray((String)(object2 = "album_delete"))) != null) {
            int n10 = ((Object)object).length;
            this.h = object = Arrays.asList((AlbumSection[])Arrays.copyOf(object, n10, AlbumSection[].class));
            object = this.getResources();
            n10 = 2131951888;
            int n11 = 1;
            objectArray = new Object[n11];
            int n12 = this.h.size();
            Integer n13 = n12;
            objectArray[0] = n13;
            object = d.v.f.i.g.p((Resources)object, n10, objectArray);
            object2 = this.f.g;
            object2.setText((CharSequence)object);
        }
    }

    public void onStart() {
        super.onStart();
        this.y();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.f;
        object2 = new AlbumDeleteConfirmDialog$a(this);
        ((b3)object).A((AlbumDeleteConfirmDialog$a)object2);
    }

    public int s() {
        return 2131558511;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (b3)viewDataBinding;
        this.f = viewDataBinding;
    }

    public /* synthetic */ void x(Integer n10) {
        this.w(n10);
    }
}

