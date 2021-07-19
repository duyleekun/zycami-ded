/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsTimeline;

public interface NvsStreamingContext$CompileCallback {
    public void onCompileFailed(NvsTimeline var1);

    public void onCompileFinished(NvsTimeline var1);

    public void onCompileProgress(NvsTimeline var1, int var2);
}

