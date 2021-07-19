/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;

public interface TransferListener {
    public void onBytesTransferred(DataSource var1, DataSpec var2, boolean var3, int var4);

    public void onTransferEnd(DataSource var1, DataSpec var2, boolean var3);

    public void onTransferInitializing(DataSource var1, DataSpec var2, boolean var3);

    public void onTransferStart(DataSource var1, DataSpec var2, boolean var3);
}

