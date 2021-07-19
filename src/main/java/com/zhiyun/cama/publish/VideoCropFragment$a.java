/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.publish;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.publish.VideoCropFragment;

public class VideoCropFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ VideoCropFragment a;

    public VideoCropFragment$a(VideoCropFragment videoCropFragment, boolean bl2) {
        this.a = videoCropFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        VideoCropFragment.j(this.a).a();
    }
}

