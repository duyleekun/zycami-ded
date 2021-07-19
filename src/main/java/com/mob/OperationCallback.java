/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;

public abstract class OperationCallback
implements PublicMemberKeeper {
    public abstract void onComplete(Object var1);

    public abstract void onFailure(Throwable var1);
}

