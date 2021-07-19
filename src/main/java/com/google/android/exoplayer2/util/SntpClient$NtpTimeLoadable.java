/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.SntpClient$1;

public final class SntpClient$NtpTimeLoadable
implements Loader$Loadable {
    private SntpClient$NtpTimeLoadable() {
    }

    public /* synthetic */ SntpClient$NtpTimeLoadable(SntpClient$1 sntpClient$1) {
        this();
    }

    public void cancelLoad() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void load() {
        Object object = SntpClient.access$100();
        synchronized (object) {
            Object object2 = SntpClient.access$200();
            synchronized (object2) {
                boolean bl2 = SntpClient.access$300();
                if (bl2) {
                    return;
                }
            }
            long l10 = SntpClient.access$400();
            Object object3 = SntpClient.access$200();
            synchronized (object3) {
                SntpClient.access$502(l10);
                boolean bl3 = true;
                SntpClient.access$302(bl3);
                return;
            }
        }
    }
}

