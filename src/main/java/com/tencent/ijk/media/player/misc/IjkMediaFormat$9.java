/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;
import java.util.Locale;

public class IjkMediaFormat$9
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$9(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat object) {
        Object object2 = "channel_layout";
        int n10 = ((IjkMediaFormat)object).getInteger((String)object2);
        if (n10 <= 0) {
            return null;
        }
        long l10 = n10;
        long l11 = 4;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false) {
            return "mono";
        }
        l11 = 3;
        long l13 = l10 - l11;
        Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object4 == false) {
            return "stereo";
        }
        object2 = Locale.US;
        object = n10;
        Object[] objectArray = new Object[]{object};
        return String.format((Locale)object2, "%x", objectArray);
    }
}

