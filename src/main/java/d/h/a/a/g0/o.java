/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDrm
 *  android.media.MediaDrm$OnExpirationUpdateListener
 */
package d.h.a.a.g0;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnExpirationUpdateListener;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

public final class o
implements MediaDrm.OnExpirationUpdateListener {
    public final /* synthetic */ FrameworkMediaDrm a;
    public final /* synthetic */ ExoMediaDrm$OnExpirationUpdateListener b;

    public /* synthetic */ o(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm$OnExpirationUpdateListener exoMediaDrm$OnExpirationUpdateListener) {
        this.a = frameworkMediaDrm;
        this.b = exoMediaDrm$OnExpirationUpdateListener;
    }

    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] byArray, long l10) {
        FrameworkMediaDrm frameworkMediaDrm = this.a;
        ExoMediaDrm$OnExpirationUpdateListener exoMediaDrm$OnExpirationUpdateListener = this.b;
        frameworkMediaDrm.d(exoMediaDrm$OnExpirationUpdateListener, mediaDrm, byArray, l10);
    }
}

