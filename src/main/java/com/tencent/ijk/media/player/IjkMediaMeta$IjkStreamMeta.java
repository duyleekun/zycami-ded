/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.tencent.ijk.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Locale;

public class IjkMediaMeta$IjkStreamMeta {
    public long mBitrate;
    public long mChannelLayout;
    public String mCodecLongName;
    public String mCodecName;
    public String mCodecProfile;
    public int mFpsDen;
    public int mFpsNum;
    public int mHeight;
    public final int mIndex;
    public String mLanguage;
    public Bundle mMeta;
    public int mSampleRate;
    public int mSarDen;
    public int mSarNum;
    public int mTbrDen;
    public int mTbrNum;
    public String mType;
    public int mWidth;

    public IjkMediaMeta$IjkStreamMeta(int n10) {
        this.mIndex = n10;
    }

    public String getBitrateInline() {
        long l10 = this.mBitrate;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return "N/A";
        }
        l11 = 1000L;
        long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l13 < 0) {
            Locale locale = Locale.US;
            Object[] objectArray = new Object[n10];
            Long l14 = l10;
            objectArray[0] = l14;
            return String.format(locale, "%d bit/s", objectArray);
        }
        Locale locale = Locale.US;
        Object[] objectArray = new Object[n10];
        Long l15 = l10 / l11;
        objectArray[0] = l15;
        return String.format(locale, "%d kb/s", objectArray);
    }

    public String getChannelLayoutInline() {
        long l10 = this.mChannelLayout;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return "N/A";
        }
        l11 = 4;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return "mono";
        }
        l11 = 3;
        long l14 = l10 - l11;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return "stereo";
        }
        Locale locale = Locale.US;
        Object[] objectArray = new Object[1];
        Long l15 = l10;
        objectArray[0] = l15;
        return String.format(locale, "%x", objectArray);
    }

    public String getCodecLongNameInline() {
        String string2 = this.mCodecLongName;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.mCodecLongName;
        }
        string2 = this.mCodecName;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.mCodecName;
        }
        return "N/A";
    }

    public String getCodecShortNameInline() {
        String string2 = this.mCodecName;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return this.mCodecName;
        }
        return "N/A";
    }

    public String getFpsInline() {
        int n10;
        int n11 = this.mFpsNum;
        if (n11 > 0 && (n10 = this.mFpsDen) > 0) {
            float f10 = n11;
            float f11 = n10;
            return String.valueOf(f10 / f11);
        }
        return "N/A";
    }

    public int getInt(String string2) {
        return this.getInt(string2, 0);
    }

    public int getInt(String string2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.getString(string2)));
        if (bl2) {
            return n10;
        }
        try {
            return Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
    }

    public long getLong(String string2) {
        return this.getLong(string2, 0L);
    }

    public long getLong(String string2, long l10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.getString(string2)));
        if (bl2) {
            return l10;
        }
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return l10;
        }
    }

    public String getResolutionInline() {
        int n10;
        int n11 = this.mWidth;
        if (n11 > 0 && (n10 = this.mHeight) > 0) {
            n10 = this.mSarNum;
            int n12 = 1;
            int n13 = 2;
            if (n10 > 0 && (n10 = this.mSarDen) > 0) {
                Locale locale = Locale.US;
                Object[] objectArray = new Object[4];
                Integer n14 = n11;
                objectArray[0] = n14;
                n14 = this.mHeight;
                objectArray[n12] = n14;
                n14 = this.mSarNum;
                objectArray[n13] = n14;
                Integer n15 = this.mSarDen;
                objectArray[3] = n15;
                return String.format(locale, "%d x %d [SAR %d:%d]", objectArray);
            }
            Locale locale = Locale.US;
            Object[] objectArray = new Object[n13];
            Integer n16 = n11;
            objectArray[0] = n16;
            n16 = this.mHeight;
            objectArray[n12] = n16;
            return String.format(locale, "%d x %d", objectArray);
        }
        return "N/A";
    }

    public String getSampleRateInline() {
        int n10 = this.mSampleRate;
        if (n10 <= 0) {
            return "N/A";
        }
        Locale locale = Locale.US;
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        return String.format(locale, "%d Hz", objectArray);
    }

    public String getString(String string2) {
        return this.mMeta.getString(string2);
    }
}

