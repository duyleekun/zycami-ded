/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.publish;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.publish.PublishFragment;

public class PublishFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ PublishFragment a;

    public PublishFragment$a(PublishFragment publishFragment, boolean bl2) {
        this.a = publishFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        PublishFragment publishFragment = this.a;
        boolean bl2 = PublishFragment.j(publishFragment);
        if (!bl2) {
            publishFragment = this.a;
            boolean bl3 = true;
            PublishFragment.k(publishFragment, bl3);
        }
    }
}

