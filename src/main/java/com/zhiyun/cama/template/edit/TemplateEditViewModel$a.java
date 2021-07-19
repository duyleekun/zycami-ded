/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.editorsdk.MainUseCase;
import d.v.c.u1.m.a1;
import d.v.e.h.c;
import d.v.e.h.d;
import d.v.e.i.h;
import d.v.h.e.b;
import m.a.a;

public class TemplateEditViewModel$a
implements b {
    public final /* synthetic */ TemplateEditViewModel a;

    public TemplateEditViewModel$a(TemplateEditViewModel templateEditViewModel) {
        this.a = templateEditViewModel;
    }

    public void d(int n10) {
        float f10 = Float.MIN_VALUE;
        Object object = n10;
        Object object2 = new Object[]{object};
        object = "onMediaEnd:%d";
        m.a.a.b((String)object, (Object[])object2);
        object2 = this.a;
        Object object3 = ((TemplateEditViewModel)object2).r0();
        if (!object3) {
            object2 = (Float)TemplateEditViewModel.p(this.a).getValue();
            f10 = c.c((Float)object2);
            float f11 = 0.0f;
            object = null;
            float f12 = f10 - 0.0f;
            object3 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object3) {
                object2 = TemplateEditViewModel.p(this.a);
                f11 = 1.0f;
                object = Float.valueOf(f11);
                h.e((MutableLiveData)object2, object);
            }
            this.a.U0();
            object2 = TemplateEditViewModel.d(this.a);
            Integer n11 = n10;
            h.e((MutableLiveData)object2, n11);
        }
    }

    public void f() {
        this.a.W0();
    }

    public void h() {
        Integer n10 = null;
        Object object = new Object[]{};
        m.a.a.b("onMediaAllEnd:", (Object[])object);
        object = TemplateEditViewModel.p(this.a);
        int n11 = 1065353216;
        float f10 = 1.0f;
        Float f11 = Float.valueOf(f10);
        h.e((MutableLiveData)object, f11);
        this.a.U0();
        object = this.a;
        boolean n12 = ((TemplateEditViewModel)object).r0();
        if (n12) {
            object = this.a;
            int n13 = TemplateEditViewModel.e((TemplateEditViewModel)object);
            n11 = 1;
            f10 = Float.MIN_VALUE;
            if (n13 == n11) {
                object = TemplateEditViewModel.d(this.a);
                n10 = 0;
                h.e((MutableLiveData)object, n10);
            }
        }
    }

    public void l(int n10, int n11) {
        Object object = n10;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(n11)};
        m.a.a.b("onMediaIndexChange:lastIndex =  %s currentIndex = %s", objectArray);
        object = TemplateEditViewModel.d(this.a);
        Integer n12 = n11;
        h.g((MutableLiveData)object, n12);
    }

    public void m(boolean bl2) {
        boolean bl3;
        Boolean bl4 = Boolean.TRUE;
        if (!bl2) {
            h.e(TemplateEditViewModel.b(this.a), bl4);
            return;
        }
        Object object = (Integer)TemplateEditViewModel.c(this.a).getValue();
        int n10 = d.d((Integer)object, (int)((bl3 = -1 != 0) ? 1 : 0));
        if (n10 == 0) {
            object = this.a;
            bl3 = true;
            ((TemplateEditViewModel)object).O0(bl3);
        }
        object = TemplateEditViewModel.j(this.a);
        Object object2 = TemplateEditViewModel.i(this.a);
        ((a1)object).h((MainUseCase)object2);
        object = TemplateEditViewModel.k(this.a);
        object2 = TemplateEditViewModel.j(this.a).B();
        h.g((MutableLiveData)object, object2);
        this.a.X0();
        object = TemplateEditViewModel.i(this.a);
        bl3 = TemplateEditViewModel.l(this.a);
        String string2 = TemplateEditViewModel.m(this.a);
        ((MainUseCase)object).l0(bl3, string2);
        TemplateEditViewModel.n(this.a);
        h.e(TemplateEditViewModel.o(this.a), bl4);
    }

    public void p(int n10) {
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        m.a.a.b("onMediaStart:%d", objectArray);
    }

    public void q(boolean bl2) {
        if (bl2) {
            a1 a12 = TemplateEditViewModel.j(this.a);
            a12.r0();
        }
    }

    public void t(int n10) {
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        m.a.a.b("onMediaPause: %s", objectArray);
        this.a.U0();
    }

    public void u() {
        Object[] objectArray = new Object[]{};
        m.a.a.b("onPlayStart", objectArray);
    }
}

