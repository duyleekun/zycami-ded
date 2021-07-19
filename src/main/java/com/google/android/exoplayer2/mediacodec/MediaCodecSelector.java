/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.mediacodec;

import d.h.a.a.i0.k;
import java.util.List;

public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = k.a;

    public List getDecoderInfos(String var1, boolean var2, boolean var3);
}

