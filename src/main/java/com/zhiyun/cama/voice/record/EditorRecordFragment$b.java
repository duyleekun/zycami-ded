/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.voice.record;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.voice.record.EditorRecordFragment;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d$a;
import d.v.c.x0.a;
import d.v.e.i.h;
import java.util.List;

public class EditorRecordFragment$b
extends d$a {
    public final /* synthetic */ EditorRecordFragment c;

    public EditorRecordFragment$b(EditorRecordFragment editorRecordFragment) {
        this.c = editorRecordFragment;
        super(editorRecordFragment);
    }

    public void c() {
        int n10;
        Object object = EditorRecordFragment.D(this.c);
        boolean bl2 = ((i2)object).m2();
        if (bl2) {
            object = EditorRecordFragment.E(this.c);
            ((i2)object).G();
        }
        EditorRecordFragment.F(this.c).D2();
        object = EditorRecordFragment.x(this.c).m();
        if (object != null && (n10 = object.size()) != 0) {
            g g10 = EditorRecordFragment.G(this.c);
            g10.t((List)object);
        }
        NavHostFragment.findNavController(this.c).navigateUp();
        super.c();
    }

    public void d() {
        super.d();
        Object object = EditorRecordFragment.H(this.c);
        boolean bl2 = ((i2)object).m2();
        if (bl2) {
            object = EditorRecordFragment.R(this.c);
            FragmentManager fragmentManager = this.c.getChildFragmentManager();
            ((a)object).q(fragmentManager);
            EditorRecordFragment.I(this.c).C3();
            object = this.c;
            boolean bl3 = true;
            EditorRecordFragment.Q((EditorRecordFragment)object, bl3);
        } else {
            object = this.c;
            long l10 = 0x4000000L;
            EditorRecordFragment.J((EditorRecordFragment)object, l10);
            object = NavHostFragment.findNavController(this.c);
            ((NavController)object).navigateUp();
        }
    }

    public void h() {
        Object object = EditorRecordFragment.x(this.c).e();
        int n10 = (Integer)object;
        int n11 = 1;
        int n12 = 3;
        if (n10 != n11) {
            if (n10 == n12) {
                object = EditorRecordFragment.C(this.c);
                ((i2)object).C3();
            }
        } else {
            object = EditorRecordFragment.x(this.c).d();
            n11 = 2;
            Integer n13 = n11;
            h.g((MutableLiveData)object, n13);
            EditorRecordFragment.x(this.c).n(n12);
            object = EditorRecordFragment.B(this.c);
            ((i2)object).A2();
        }
    }
}

