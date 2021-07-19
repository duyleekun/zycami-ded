/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider;
import java.util.Comparator;

public final class h
implements Comparator {
    public final /* synthetic */ MediaCodecUtil$ScoreProvider a;

    public /* synthetic */ h(MediaCodecUtil$ScoreProvider mediaCodecUtil$ScoreProvider) {
        this.a = mediaCodecUtil$ScoreProvider;
    }

    public final int compare(Object object, Object object2) {
        return MediaCodecUtil.d(this.a, object, object2);
    }
}

