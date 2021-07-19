/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.StreamVolumeManager$VolumeChangeReceiver;

public final class c0
implements Runnable {
    public final /* synthetic */ StreamVolumeManager a;

    public /* synthetic */ c0(StreamVolumeManager streamVolumeManager) {
        this.a = streamVolumeManager;
    }

    public final void run() {
        StreamVolumeManager$VolumeChangeReceiver.a(this.a);
    }
}

