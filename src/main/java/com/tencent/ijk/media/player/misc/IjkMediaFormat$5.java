/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;

public class IjkMediaFormat$5
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$5(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat ijkMediaFormat) {
        return ijkMediaFormat.getString("codec_pixel_format");
    }
}

