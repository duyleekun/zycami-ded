/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.live.LiveLoginActivity;

public class LiveLoginActivity$a
extends OnBackPressedCallback {
    public final /* synthetic */ LiveLoginActivity a;

    public LiveLoginActivity$a(LiveLoginActivity liveLoginActivity, boolean bl2) {
        this.a = liveLoginActivity;
        super(bl2);
    }

    public void handleOnBackPressed() {
        int n10;
        Object object = LiveLoginActivity.d(this.a);
        boolean bl2 = object.canGoBackOrForward(n10 = -1);
        if (bl2) {
            object = LiveLoginActivity.d(this.a);
            object.goBackOrForward(n10);
        } else {
            object = this.a;
            n10 = 0;
            object.setResult(0);
            object = this.a;
            object.finish();
        }
    }
}

