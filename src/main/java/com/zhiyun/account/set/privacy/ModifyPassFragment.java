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

public class ModifyPassFragment
extends j {
    public PrivateGetCodeStatus a() {
        return PrivateGetCodeStatus.MODIFY_PASS;
    }

    public void b(View view) {
        int n10 = R$id.action_modifyPassFragment_to_setNewPassFragment;
        a.a(view, n10);
    }
}

