/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.cloud_engine;

import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.cloud_engine.CETemplateFragment;

public class CETemplateFragment$b {
    public final /* synthetic */ CETemplateFragment a;

    public CETemplateFragment$b(CETemplateFragment cETemplateFragment) {
        this.a = cETemplateFragment;
    }

    public void a() {
        NavHostFragment.findNavController(this.a).popBackStack();
    }

    public void b() {
        CETemplateFragment.o(this.a);
    }
}

