/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;
import java.util.Locale;

public class IjkMediaFormat$6
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$6(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat object) {
        Object object2 = "width";
        int n10 = ((IjkMediaFormat)object).getInteger((String)object2);
        String string2 = "height";
        int n11 = ((IjkMediaFormat)object).getInteger(string2);
        Object[] objectArray = "sar_num";
        int n12 = ((IjkMediaFormat)object).getInteger((String)objectArray);
        String string3 = "sar_den";
        int n13 = ((IjkMediaFormat)object).getInteger(string3);
        if (n10 > 0 && n11 > 0) {
            int n14 = 1;
            int n15 = 2;
            if (n12 > 0 && n13 > 0) {
                Locale locale = Locale.US;
                Object[] objectArray2 = new Object[4];
                objectArray2[0] = object2 = Integer.valueOf(n10);
                objectArray2[n14] = object2 = Integer.valueOf(n11);
                objectArray2[n15] = object2 = Integer.valueOf(n12);
                objectArray2[3] = object = Integer.valueOf(n13);
                return String.format(locale, "%d x %d [SAR %d:%d]", objectArray2);
            }
            object = Locale.US;
            objectArray = new Object[n15];
            objectArray[0] = object2 = Integer.valueOf(n10);
            objectArray[n14] = object2 = Integer.valueOf(n11);
            return String.format((Locale)object, "%d x %d", objectArray);
        }
        return null;
    }
}

