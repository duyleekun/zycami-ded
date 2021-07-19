/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;

public class IjkMediaFormat$7
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$7(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat ijkMediaFormat) {
        String string2 = "fps_num";
        int n10 = ijkMediaFormat.getInteger(string2);
        String string3 = "fps_den";
        int n11 = ijkMediaFormat.getInteger(string3);
        if (n10 > 0 && n11 > 0) {
            float f10 = n10;
            float f11 = n11;
            return String.valueOf(f10 / f11);
        }
        return null;
    }
}

