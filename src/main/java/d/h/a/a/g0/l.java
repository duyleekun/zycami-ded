/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaDrm
 *  android.media.MediaDrm$OnKeyStatusChangeListener
 */
package d.h.a.a.g0;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnKeyStatusChangeListener;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import java.util.List;

public final class l
implements MediaDrm.OnKeyStatusChangeListener {
    public final /* synthetic */ FrameworkMediaDrm a;
    public final /* synthetic */ ExoMediaDrm$OnKeyStatusChangeListener b;

    public /* synthetic */ l(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm$OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener) {
        this.a = frameworkMediaDrm;
        this.b = exoMediaDrm$OnKeyStatusChangeListener;
    }

    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] byArray, List list, boolean bl2) {
        FrameworkMediaDrm frameworkMediaDrm = this.a;
        ExoMediaDrm$OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener = this.b;
        frameworkMediaDrm.f(exoMediaDrm$OnKeyStatusChangeListener, mediaDrm, byArray, list, bl2);
    }
}

