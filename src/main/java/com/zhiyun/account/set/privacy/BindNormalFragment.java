/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.view.View;
import com.zhiyun.account.R$id;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;
import d.v.a.j.c.z.j;
import d.v.a.k.a;

public class BindNormalFragment
extends j {
    public PrivateGetCodeStatus a() {
        return PrivateGetCodeStatus.BIND;
    }

    public void b(View view) {
        int n10 = R$id.action_bindNormalFragment_to_bindSuccessFragment;
        a.a(view, n10);
    }
}

