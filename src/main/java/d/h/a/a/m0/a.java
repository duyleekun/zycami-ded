/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;

public final class a
implements MediaSource$MediaSourceCaller {
    public final /* synthetic */ CompositeMediaSource a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(CompositeMediaSource compositeMediaSource, Object object) {
        this.a = compositeMediaSource;
        this.b = object;
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        CompositeMediaSource compositeMediaSource = this.a;
        Object object = this.b;
        compositeMediaSource.b(object, mediaSource, timeline);
    }
}

