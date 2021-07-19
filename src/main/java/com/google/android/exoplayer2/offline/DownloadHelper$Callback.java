/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadHelper;
import java.io.IOException;

public interface DownloadHelper$Callback {
    public void onPrepareError(DownloadHelper var1, IOException var2);

    public void onPrepared(DownloadHelper var1);
}

