/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.database.model.transition;

import android.text.TextUtils;
import com.zhiyun.cama.data.database.model.ResourceData;
import d.v.v.c$a;

public class TransitionData
extends ResourceData {
    private String hash;
    private String licenseName;
    private String licensePath;
    private String littleThumb;
    private String path;
    private int requiredPrime;
    private long size;
    private String thumb;
    private int transitionType;

    public TransitionData(long l10, String string2, String string3, String string4, int n10, long l11, String string5, String string6, String string7, String string8, int n11) {
        super(l10, string2, string3, string4, n10);
        int n12;
        this.size = l11;
        this.path = string5;
        this.hash = string6;
        this.thumb = string7;
        this.littleThumb = string8;
        this.transitionType = n12 = this.getTransitionTypeByName(string5);
        this.requiredPrime = n11;
    }

    private int getTransitionTypeByName(String string2) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        int n12 = -1;
        if (n11 != 0) {
            return n12;
        }
        Object object = string2.split("\\.");
        int n13 = ((String[])object).length;
        if (n13 == (n10 = 1)) {
            Object object2;
            int n14;
            n11 = 0;
            object = null;
            for (n13 = 0; n13 < (n14 = ((String[])(object2 = c$a.b)).length); ++n13) {
                boolean bl2 = ((String)(object2 = object2[n13])).equals(string2);
                if (!bl2) continue;
                n11 = n10;
                break;
            }
            if (n11 != 0) {
                n12 = n10;
            }
            return n12;
        }
        int n15 = ((String[])object).length - n10;
        string2 = object[n15];
        if ((n15 = (int)(string2.equals(object = "videotransition") ? 1 : 0)) != 0) {
            return 2;
        }
        return n12;
    }

    public String getHash() {
        return this.hash;
    }

    public String getLicenseName() {
        return this.licenseName;
    }

    public String getLicensePath() {
        return this.licensePath;
    }

    public String getLittleThumb() {
        return this.littleThumb;
    }

    public String getPath() {
        return this.path;
    }

    public int getRequiredPrime() {
        return this.requiredPrime;
    }

    public long getSize() {
        return this.size;
    }

    public String getThumb() {
        return this.thumb;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public void setHash(String string2) {
        this.hash = string2;
    }

    public void setLicenseName(String string2) {
        this.licenseName = string2;
    }

    public void setLicensePath(String string2) {
        this.licensePath = string2;
    }

    public TransitionData setLittleThumb(String string2) {
        this.littleThumb = string2;
        return this;
    }

    public void setPath(String string2) {
        int n10;
        this.path = string2;
        this.transitionType = n10 = this.getTransitionTypeByName(string2);
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public void setSize(long l10) {
        this.size = l10;
    }

    public TransitionData setThumb(String string2) {
        this.thumb = string2;
        return this;
    }

    public void setTransitionType(int n10) {
        this.transitionType = n10;
    }
}

