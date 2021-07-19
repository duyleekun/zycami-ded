/*
 * Decompiled with CFR 0.151.
 */
package androidx.media;

import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;

public class MediaBrowserServiceCompat$ConnectionRecord$1
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$ConnectionRecord this$1;

    public MediaBrowserServiceCompat$ConnectionRecord$1(MediaBrowserServiceCompat$ConnectionRecord connectionRecord) {
        this.this$1 = connectionRecord;
    }

    public void run() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord = this.this$1;
        ArrayMap arrayMap = mediaBrowserServiceCompat$ConnectionRecord.this$0.mConnections;
        mediaBrowserServiceCompat$ConnectionRecord = mediaBrowserServiceCompat$ConnectionRecord.callbacks.asBinder();
        arrayMap.remove(mediaBrowserServiceCompat$ConnectionRecord);
    }
}

