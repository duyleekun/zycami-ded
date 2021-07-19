/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.tencent.ijk.media.player.misc;

import android.text.TextUtils;
import com.tencent.ijk.media.player.IjkMediaMeta$IjkStreamMeta;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import com.tencent.ijk.media.player.misc.ITrackInfo;
import com.tencent.ijk.media.player.misc.IjkMediaFormat;

public class IjkTrackInfo
implements ITrackInfo {
    private IjkMediaMeta$IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(IjkMediaMeta$IjkStreamMeta ijkMediaMeta$IjkStreamMeta) {
        this.mStreamMeta = ijkMediaMeta$IjkStreamMeta;
    }

    public IMediaFormat getFormat() {
        IjkMediaMeta$IjkStreamMeta ijkMediaMeta$IjkStreamMeta = this.mStreamMeta;
        IjkMediaFormat ijkMediaFormat = new IjkMediaFormat(ijkMediaMeta$IjkStreamMeta);
        return ijkMediaFormat;
    }

    public String getInfoInline() {
        StringBuilder stringBuilder = new StringBuilder(128);
        int n10 = this.mTrackType;
        int n11 = 1;
        String string2 = ", ";
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        String string3 = "UNKNOWN";
                        stringBuilder.append(string3);
                    } else {
                        String string4 = "SUBTITLE";
                        stringBuilder.append(string4);
                    }
                } else {
                    stringBuilder.append("TIMEDTEXT");
                    stringBuilder.append(string2);
                    String string5 = this.mStreamMeta.mLanguage;
                    stringBuilder.append(string5);
                }
            } else {
                stringBuilder.append("AUDIO");
                stringBuilder.append(string2);
                String string6 = this.mStreamMeta.getCodecShortNameInline();
                stringBuilder.append(string6);
                stringBuilder.append(string2);
                string6 = this.mStreamMeta.getBitrateInline();
                stringBuilder.append(string6);
                stringBuilder.append(string2);
                string6 = this.mStreamMeta.getSampleRateInline();
                stringBuilder.append(string6);
            }
        } else {
            stringBuilder.append("VIDEO");
            stringBuilder.append(string2);
            String string7 = this.mStreamMeta.getCodecShortNameInline();
            stringBuilder.append(string7);
            stringBuilder.append(string2);
            string7 = this.mStreamMeta.getBitrateInline();
            stringBuilder.append(string7);
            stringBuilder.append(string2);
            string7 = this.mStreamMeta.getResolutionInline();
            stringBuilder.append(string7);
        }
        return stringBuilder.toString();
    }

    public String getLanguage() {
        boolean bl2;
        Object object = this.mStreamMeta;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((IjkMediaMeta$IjkStreamMeta)object).mLanguage)))) {
            return this.mStreamMeta.mLanguage;
        }
        return "und";
    }

    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(IjkMediaMeta$IjkStreamMeta ijkMediaMeta$IjkStreamMeta) {
        this.mStreamMeta = ijkMediaMeta$IjkStreamMeta;
    }

    public void setTrackType(int n10) {
        this.mTrackType = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getSimpleName();
        stringBuilder.append(string2);
        stringBuilder.append('{');
        string2 = this.getInfoInline();
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

