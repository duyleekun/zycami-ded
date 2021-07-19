/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.fragment.NavHostFragment;
import com.quvideo.mobile.external.component.cloudengine.QVCloudEngine;
import com.quvideo.mobile.external.component.cloudengine.model.CloudEngineConfig;
import com.zhiyun.cama.publish.CreationFragment$a;
import d.v.a.f.c.b;
import d.v.c.m1.c;
import d.v.c.w0.x2;
import d.v.e.l.w1;
import d.v.f.h.a;

public class CreationFragment
extends a {
    private static final String e = "A10001ByJLJBano7lPHvCp";
    private static final String f = "56d6eec848bc7bc3ad7e233f1af31e8dcab3b404";
    private x2 b;
    private c c;
    private boolean d;

    public static /* synthetic */ boolean j(CreationFragment creationFragment, boolean bl2) {
        creationFragment.d = bl2;
        return bl2;
    }

    public static /* synthetic */ void k(CreationFragment creationFragment, int n10) {
        creationFragment.l(n10);
    }

    private void l(int n10) {
        Object object;
        boolean bl2;
        String string2 = "en";
        Object object2 = w1.a();
        boolean bl3 = string2.equalsIgnoreCase((String)object2);
        if (!bl3 && !(bl2 = ((String)(object = "zh_TW")).equalsIgnoreCase((String)object2))) {
            object2 = "CN";
            string2 = "ZH";
        } else {
            object2 = "US";
        }
        String string3 = object2;
        String string4 = String.valueOf(n10);
        object = object2;
        object2 = new CloudEngineConfig(e, f, string4, string3, string2, false);
        QVCloudEngine.initialize(this.getContext(), (CloudEngineConfig)object2);
    }

    private void m() {
        NavHostFragment.findNavController(this).navigate(2131361897);
    }

    public int h() {
        return 2131558493;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (x2)viewDataBinding;
        this.b = viewDataBinding;
        CreationFragment$a creationFragment$a = new CreationFragment$a(this);
        ((x2)viewDataBinding).z(creationFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (c)d.v.i0.b.c(this.requireActivity()).get(c.class);
        this.c = object;
    }

    public void onResume() {
        super.onResume();
        boolean bl2 = this.d;
        if (bl2) {
            this.d = false;
            Object object = d.v.a.f.c.b.N();
            bl2 = ((b)object).s();
            if (bl2) {
                object = d.v.a.f.c.b.N().i().getToken();
                c c10 = this.c;
                c10.w((String)object);
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}

