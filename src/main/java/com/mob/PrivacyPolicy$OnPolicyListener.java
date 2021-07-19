/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.PrivacyPolicy;
import com.mob.tools.proguard.PublicMemberKeeper;

public interface PrivacyPolicy$OnPolicyListener
extends PublicMemberKeeper {
    public void onComplete(PrivacyPolicy var1);

    public void onFailure(Throwable var1);
}

