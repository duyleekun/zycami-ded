/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import java.io.IOException;

public interface SntpClient$InitializationCallback {
    public void onInitializationFailed(IOException var1);

    public void onInitialized();
}

