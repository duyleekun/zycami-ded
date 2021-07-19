/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;
import java.util.Locale;

public class IjkMediaFormat$8
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$8(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat object) {
        Object object2 = "sample_rate";
        int n10 = ((IjkMediaFormat)object).getInteger((String)object2);
        if (n10 <= 0) {
            return null;
        }
        object2 = Locale.US;
        object = n10;
        Object[] objectArray = new Object[]{object};
        return String.format((Locale)object2, "%d Hz", objectArray);
    }
}

