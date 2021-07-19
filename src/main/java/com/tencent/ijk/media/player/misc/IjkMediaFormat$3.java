/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;
import java.util.Locale;

public class IjkMediaFormat$3
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$3(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat object) {
        String string2 = "bitrate";
        int n10 = ((IjkMediaFormat)object).getInteger(string2);
        if (n10 <= 0) {
            return null;
        }
        string2 = null;
        int n11 = 1;
        int n12 = 1000;
        if (n10 < n12) {
            Locale locale = Locale.US;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Integer.valueOf(n10);
            return String.format(locale, "%d bit/s", objectArray);
        }
        Locale locale = Locale.US;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = Integer.valueOf(n10 / n12);
        return String.format(locale, "%d kb/s", objectArray);
    }
}

