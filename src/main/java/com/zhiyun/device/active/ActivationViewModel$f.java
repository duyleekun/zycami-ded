/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.active;

import com.zhiyun.device.active.ActivationViewModel;
import com.zhiyun.device.data.local.entity.ActivationData;
import com.zhiyun.net.BaseEntity;
import d.v.g.d.a;

public class ActivationViewModel$f
extends a {
    public final /* synthetic */ a c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ String n;
    public final /* synthetic */ String o;
    public final /* synthetic */ ActivationViewModel p;

    public ActivationViewModel$f(ActivationViewModel activationViewModel, a a10, Integer n10, String string2, String string3, int n11, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
        this.p = activationViewModel;
        this.c = a10;
        this.d = n10;
        this.e = string2;
        this.f = string3;
        this.g = n11;
        this.h = string4;
        this.i = string5;
        this.j = string6;
        this.k = string7;
        this.l = string8;
        this.m = string9;
        this.n = string10;
        this.o = string11;
    }

    public void a(BaseEntity baseEntity) {
        a a10 = this.c;
        if (a10 != null) {
            a10.onSuccess(baseEntity);
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
        String string3;
        int n11;
        ActivationViewModel$f activationViewModel$f = this;
        Object object = this.c;
        if (object != null) {
            n11 = n10;
            string3 = string2;
            object.onError(throwable, n10, string2);
        }
        n11 = activationViewModel$f.d;
        string3 = activationViewModel$f.e;
        String string4 = activationViewModel$f.f;
        int n12 = activationViewModel$f.g;
        String string5 = activationViewModel$f.h;
        String string6 = activationViewModel$f.i;
        String string7 = activationViewModel$f.j;
        String string8 = activationViewModel$f.k;
        String string9 = activationViewModel$f.l;
        String string10 = activationViewModel$f.m;
        String string11 = activationViewModel$f.n;
        boolean bl2 = activationViewModel$f.p.G();
        String string12 = activationViewModel$f.o;
        object = new ActivationData(n11, string3, string4, n12, string5, string6, string7, string8, string9, string10, string11, bl2, string12);
        ActivationViewModel.i(activationViewModel$f.p, (ActivationData)object);
    }
}

