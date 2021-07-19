/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.i0;

import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

public final class k
implements MediaCodecSelector {
    public static final /* synthetic */ k a;

    static {
        k k10;
        a = k10 = new k();
    }

    public final List getDecoderInfos(String string2, boolean bl2, boolean bl3) {
        return MediaCodecUtil.getDecoderInfos(string2, bl2, bl3);
    }
}

