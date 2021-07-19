/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.tencent.ijk.media.player.misc;

import android.text.TextUtils;
import com.tencent.ijk.media.player.misc.IjkMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;

public class IjkMediaFormat$4
extends IjkMediaFormat$Formatter {
    public final /* synthetic */ IjkMediaFormat this$0;

    public IjkMediaFormat$4(IjkMediaFormat ijkMediaFormat) {
        this.this$0 = ijkMediaFormat;
        super(null);
    }

    public String doFormat(IjkMediaFormat ijkMediaFormat) {
        String string2;
        String string3 = "codec_profile_id";
        int n10 = ijkMediaFormat.getInteger(string3);
        switch (n10) {
            default: {
                return null;
            }
            case 2292: {
                string3 = "High 4:4:4 Intra";
                break;
            }
            case 2170: {
                string3 = "High 4:2:2 Intra";
                break;
            }
            case 2158: {
                string3 = "High 10 Intra";
                break;
            }
            case 578: {
                string3 = "Constrained Baseline";
                break;
            }
            case 244: {
                string3 = "High 4:4:4 Predictive";
                break;
            }
            case 144: {
                string3 = "High 4:4:4";
                break;
            }
            case 122: {
                string3 = "High 4:2:2";
                break;
            }
            case 110: {
                string3 = "High 10";
                break;
            }
            case 100: {
                string3 = "High";
                break;
            }
            case 88: {
                string3 = "Extended";
                break;
            }
            case 77: {
                string3 = "Main";
                break;
            }
            case 66: {
                string3 = "Baseline";
                break;
            }
            case 44: {
                string3 = "CAVLC 4:4:4";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        string3 = ijkMediaFormat.getString("codec_name");
        int n11 = TextUtils.isEmpty((CharSequence)string3);
        if (n11 == 0 && (n10 = (int)(string3.equalsIgnoreCase(string2 = "h264") ? 1 : 0)) != 0) {
            string3 = "codec_level";
            int n12 = ijkMediaFormat.getInteger(string3);
            if (n12 < (n10 = 10)) {
                return stringBuilder.toString();
            }
            string2 = " Profile Level ";
            stringBuilder.append(string2);
            n11 = n12 / 10 % n10;
            stringBuilder.append(n11);
            if ((n12 %= n10) != 0) {
                string3 = ".";
                stringBuilder.append(string3);
                stringBuilder.append(n12);
            }
        }
        return stringBuilder.toString();
    }
}

