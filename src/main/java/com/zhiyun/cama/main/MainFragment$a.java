/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main;

import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiCallback;
import com.zhiyun.cama.main.MainFragment;

public class MainFragment$a
implements KWaiManager$OnKWaiCallback {
    public final /* synthetic */ MainFragment a;

    public MainFragment$a(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public void onFailed(String string2) {
        MainFragment.j(this.a, string2);
    }

    public void onSuccess() {
    }
}

