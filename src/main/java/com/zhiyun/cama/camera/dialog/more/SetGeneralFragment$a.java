/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment;
import d.v.f.f.e;

public class SetGeneralFragment$a
extends e {
    public final /* synthetic */ SetGeneralFragment b;

    public SetGeneralFragment$a(SetGeneralFragment setGeneralFragment, Context context) {
        this.b = setGeneralFragment;
        super(context);
    }

    public void f(int n10) {
        SetGeneralFragment setGeneralFragment = this.b;
        int n11 = SetGeneralFragment.j(setGeneralFragment);
        if (n11 != n10) {
            setGeneralFragment = this.b;
            SetGeneralFragment.k(setGeneralFragment, n10);
        }
    }
}

