/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDrm
 *  android.media.MediaDrm$OnEventListener
 */
package d.h.a.a.g0;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

public final class n
implements MediaDrm.OnEventListener {
    public final /* synthetic */ FrameworkMediaDrm a;
    public final /* synthetic */ ExoMediaDrm$OnEventListener b;

    public /* synthetic */ n(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm$OnEventListener exoMediaDrm$OnEventListener) {
        this.a = frameworkMediaDrm;
        this.b = exoMediaDrm$OnEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] byArray, int n10, int n11, byte[] byArray2) {
        FrameworkMediaDrm frameworkMediaDrm = this.a;
        ExoMediaDrm$OnEventListener exoMediaDrm$OnEventListener = this.b;
        frameworkMediaDrm.b(exoMediaDrm$OnEventListener, mediaDrm, byArray, n10, n11, byArray2);
    }
}

