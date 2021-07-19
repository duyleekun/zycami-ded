/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.view.View
 *  android.widget.SeekBar
 */
package com.zhiyun.cama.template.edit;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.SeekBar;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import d.v.c.e1.u;
import d.v.c.q0.c$b;
import d.v.c.q0.e;
import d.v.e.i.h;
import d.v.h.f.a;

public class EditorTemplateFilterFragment$a
extends c$b {
    public final /* synthetic */ EditorTemplateFilterFragment b;

    public EditorTemplateFilterFragment$a(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        this.b = editorTemplateFilterFragment;
        super(editorTemplateFilterFragment);
    }

    public void b(View view) {
        int n10;
        int n11 = view.getId();
        if (n11 == (n10 = 2131362630)) {
            n11 = 0;
            view = null;
            this.h(0);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void c() {
        Object object;
        super.c();
        TemplateEditViewModel templateEditViewModel = EditorTemplateFilterFragment.z(this.b);
        boolean bl2 = templateEditViewModel.W();
        Object object2 = EditorTemplateFilterFragment.u(this.b).S();
        boolean n10 = ((e)object2).c();
        if (n10) {
            object = EditorTemplateFilterFragment.z(this.b);
            a a10 = (a)((e)object2).a();
            ((TemplateEditViewModel)object).K0(a10);
        } else {
            Object object3;
            int n11;
            void var4_6;
            boolean bl3 = false;
            object = null;
            while (++var4_6 < (n11 = (object3 = ((e)object2).b()).size())) {
                object3 = EditorTemplateFilterFragment.z(this.b);
                SparseArray sparseArray = ((e)object2).b();
                int n12 = sparseArray.keyAt((int)var4_6);
                a a11 = (a)((e)object2).b().valueAt((int)var4_6);
                ((TemplateEditViewModel)object3).I0(n12, a11);
            }
        }
        EditorTemplateFilterFragment.A(this.b, false);
        object = EditorTemplateFilterFragment.z(this.b).U();
        boolean bl4 = ((e)object2).c();
        object2 = bl4;
        h.g((MutableLiveData)object, object2);
        if (bl2) {
            templateEditViewModel = EditorTemplateFilterFragment.z(this.b);
            templateEditViewModel.z0();
        }
    }

    public void g(SeekBar object, int n10, boolean bl2) {
        object = EditorTemplateFilterFragment.u(this.b).x();
        Integer n11 = n10;
        h.g((MutableLiveData)object, n11);
    }

    public void h(int n10) {
        EditorTemplateFilterFragment editorTemplateFilterFragment = this.b;
        EditorTemplateFilterFragment.v(editorTemplateFilterFragment, n10);
        EditorTemplateFilterFragment editorTemplateFilterFragment2 = this.b;
        n10 = (int)(EditorTemplateFilterFragment.w(editorTemplateFilterFragment2) ? 1 : 0);
        if (n10 != 0) {
            editorTemplateFilterFragment2 = this.b;
            EditorTemplateFilterFragment.x(editorTemplateFilterFragment2);
        } else {
            editorTemplateFilterFragment2 = this.b;
            EditorTemplateFilterFragment.y(editorTemplateFilterFragment2);
        }
    }

    public void i() {
        EditorTemplateFilterFragment.B((EditorTemplateFilterFragment)this.b).d.e();
        u u10 = EditorTemplateFilterFragment.u(this.b);
        Context context = this.b.requireContext();
        u10.u(context);
    }
}

