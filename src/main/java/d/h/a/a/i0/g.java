/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider;

public final class g
implements MediaCodecUtil$ScoreProvider {
    public final /* synthetic */ Format a;

    public /* synthetic */ g(Format format) {
        this.a = format;
    }

    public final int getScore(Object object) {
        Format format = this.a;
        object = (MediaCodecInfo)object;
        return MediaCodecUtil.c(format, (MediaCodecInfo)object);
    }
}

