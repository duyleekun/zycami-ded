/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.trackselection.TrackSelector$InvalidationListener;

public final class e
implements TrackSelector$InvalidationListener {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final void onTrackSelectionsInvalidated() {
        DownloadHelper.c();
    }
}

