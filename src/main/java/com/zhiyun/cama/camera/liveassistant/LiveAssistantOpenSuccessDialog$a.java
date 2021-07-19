/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.liveassistant;

import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantOpenSuccessDialog;

public class LiveAssistantOpenSuccessDialog$a {
    public final /* synthetic */ LiveAssistantOpenSuccessDialog a;

    public LiveAssistantOpenSuccessDialog$a(LiveAssistantOpenSuccessDialog liveAssistantOpenSuccessDialog) {
        this.a = liveAssistantOpenSuccessDialog;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }
}

