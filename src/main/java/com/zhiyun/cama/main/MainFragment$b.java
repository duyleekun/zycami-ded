/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main;

import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import com.zhiyun.cama.main.MainFragment;
import d.v.f.i.g;

public class MainFragment$b
implements SharePlatformManager$OnShareCallback {
    public final /* synthetic */ MainFragment a;

    public MainFragment$b(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public void onShareFailed(String string2) {
        MainFragment.j(this.a, string2);
    }

    public void onShareSuccess() {
        MainFragment mainFragment = this.a;
        String string2 = g.m(mainFragment.requireContext(), 2131952944);
        MainFragment.j(mainFragment, string2);
    }
}

