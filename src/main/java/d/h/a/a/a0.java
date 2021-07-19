/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;

public final class a0
implements MediaSource$MediaSourceCaller {
    public final /* synthetic */ MediaSourceList a;

    public /* synthetic */ a0(MediaSourceList mediaSourceList) {
        this.a = mediaSourceList;
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        this.a.b(mediaSource, timeline);
    }
}

