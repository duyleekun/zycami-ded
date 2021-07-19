/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider;

public final class e
implements MediaCodecUtil$ScoreProvider {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final int getScore(Object object) {
        return MediaCodecUtil.a((MediaCodecInfo)object);
    }
}

