/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.widget.CheckBox
 */
package com.zhiyun.cama.ratio;

import android.util.SparseIntArray;
import android.widget.CheckBox;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.ratio.EditorRatioFragment$a;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.w0.j7;
import d.v.c.x1.p.c;

public class EditorRatioFragment
extends d {
    private j7 j;
    private c k;
    private final SparseIntArray l;

    public EditorRatioFragment() {
        SparseIntArray sparseIntArray;
        this.l = sparseIntArray = new SparseIntArray();
        int n10 = 3;
        sparseIntArray.put(0, n10);
        int n11 = 1;
        sparseIntArray.put(n11, 0);
        int n12 = 2;
        sparseIntArray.put(n12, n12);
        sparseIntArray.put(n10, n11);
        n12 = 4;
        sparseIntArray.put(n12, n12);
        n12 = 5;
        sparseIntArray.put(n12, n12);
        n12 = 6;
        sparseIntArray.put(n12, n12);
    }

    public static /* synthetic */ void A(EditorRatioFragment editorRatioFragment, int n10, boolean bl2) {
        editorRatioFragment.C(n10, bl2);
    }

    private void B() {
        c c10;
        int n10 = this.g.C0();
        this.k = c10 = new c();
        Integer n11 = n10;
        c10.b(n11);
        this.C(n10, true);
    }

    private void C(int n10, boolean n11) {
        Object object;
        if (n11 == 0) {
            g g10;
            int n12;
            object = this.l;
            n11 = object.get(n10);
            if (n11 == (n12 = (g10 = this.g).C0())) {
                return;
            }
            object = this.g;
            g10 = this.l;
            n10 = g10.get(n10);
            ((i2)object).X(n10);
        }
        j7 j72 = this.j;
        object = j72.d;
        j72 = j72.e;
        this.D((CheckBox)object, (CheckBox)j72);
        j72 = this.j;
        object = j72.j;
        j72 = j72.k;
        this.D((CheckBox)object, (CheckBox)j72);
        j72 = this.j;
        object = j72.h;
        j72 = j72.i;
        this.D((CheckBox)object, (CheckBox)j72);
        j72 = this.j;
        object = j72.b;
        j72 = j72.c;
        this.D((CheckBox)object, (CheckBox)j72);
        j72 = this.j;
        object = j72.n;
        j72 = j72.o;
        this.D((CheckBox)object, (CheckBox)j72);
        j72 = this.j;
        object = j72.f;
        j72 = j72.g;
        this.D((CheckBox)object, (CheckBox)j72);
        j72 = this.j;
        object = j72.l;
        j72 = j72.m;
        this.D((CheckBox)object, (CheckBox)j72);
    }

    private void D(CheckBox checkBox, CheckBox checkBox2) {
        String string2;
        SparseIntArray sparseIntArray = this.l;
        int n10 = this.g.C0();
        int n11 = sparseIntArray.indexOfValue(n10);
        if (n11 == (n10 = Integer.parseInt(string2 = (String)checkBox.getTag()))) {
            n11 = 1;
        } else {
            n11 = 0;
            sparseIntArray = null;
        }
        checkBox.setChecked(n11 != 0);
        checkBox2.setChecked(n11 != 0);
    }

    public static /* synthetic */ c x(EditorRatioFragment editorRatioFragment) {
        return editorRatioFragment.k;
    }

    public static /* synthetic */ g y(EditorRatioFragment editorRatioFragment) {
        return editorRatioFragment.g;
    }

    public static /* synthetic */ void z(EditorRatioFragment editorRatioFragment, long l10) {
        editorRatioFragment.w(l10);
    }

    public int h() {
        return 2131558579;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (j7)viewDataBinding;
        this.j = viewDataBinding;
        EditorRatioFragment$a editorRatioFragment$a = new EditorRatioFragment$a(this);
        ((j7)viewDataBinding).z(editorRatioFragment$a);
        this.B();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }
}

