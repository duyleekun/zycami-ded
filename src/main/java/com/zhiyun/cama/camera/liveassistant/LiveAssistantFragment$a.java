/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.liveassistant;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment;

public class LiveAssistantFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ LiveAssistantFragment a;

    public LiveAssistantFragment$a(LiveAssistantFragment liveAssistantFragment, boolean bl2) {
        this.a = liveAssistantFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        LiveAssistantFragment.h(this.a);
    }
}

