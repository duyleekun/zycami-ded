/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.cloud_engine;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment;

public class CECompositeFinishFragment$a
extends OnBackPressedCallback {
    public final /* synthetic */ CECompositeFinishFragment a;

    public CECompositeFinishFragment$a(CECompositeFinishFragment cECompositeFinishFragment, boolean bl2) {
        this.a = cECompositeFinishFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        CECompositeFinishFragment.j(this.a).a();
    }
}

