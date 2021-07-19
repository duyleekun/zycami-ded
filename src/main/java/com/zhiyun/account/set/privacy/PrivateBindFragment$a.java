/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.app.Activity;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.zhiyun.account.R$id;
import com.zhiyun.account.set.privacy.PrivateBindFragment;
import d.v.a.k.a;

public class PrivateBindFragment$a {
    public final /* synthetic */ PrivateBindFragment a;

    public PrivateBindFragment$a(PrivateBindFragment privateBindFragment) {
        this.a = privateBindFragment;
    }

    public void a(View object) {
        boolean bl2 = d.v.a.k.a.g(object);
        if (!bl2) {
            object = this.a.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    public void b(View view) {
        int n10 = R$id.bindSuccessFragment;
        d.v.a.k.a.a(view, n10);
    }

    public void c(View view) {
        int n10 = R$id.bindThirdFragment;
        d.v.a.k.a.a(view, n10);
    }
}

