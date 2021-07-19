/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.tencent.ijk.media.player.misc;

import android.text.TextUtils;
import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$1;

public abstract class IjkMediaFormat$Formatter {
    private IjkMediaFormat$Formatter() {
    }

    public /* synthetic */ IjkMediaFormat$Formatter(IjkMediaFormat.1 var1_1) {
        this();
    }

    public abstract String doFormat(IjkMediaFormat var1);

    public String format(IjkMediaFormat object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = this.doFormat((IjkMediaFormat)object)));
        if (bl2) {
            object = this.getDefaultString();
        }
        return object;
    }

    public String getDefaultString() {
        return "N/A";
    }
}

