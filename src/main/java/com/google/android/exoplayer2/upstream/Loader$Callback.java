/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import java.io.IOException;

public interface Loader$Callback {
    public void onLoadCanceled(Loader$Loadable var1, long var2, long var4, boolean var6);

    public void onLoadCompleted(Loader$Loadable var1, long var2, long var4);

    public Loader.LoadErrorAction onLoadError(Loader$Loadable var1, long var2, long var4, IOException var6, int var7);
}

