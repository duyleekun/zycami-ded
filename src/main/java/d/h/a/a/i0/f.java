/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider;

public final class f
implements MediaCodecUtil$ScoreProvider {
    public static final /* synthetic */ f a;

    static {
        f f10;
        a = f10 = new f();
    }

    public final int getScore(Object object) {
        return MediaCodecUtil.b((MediaCodecInfo)object);
    }
}

