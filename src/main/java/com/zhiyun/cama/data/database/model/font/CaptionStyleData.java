/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.font;

import com.zhiyun.cama.data.database.model.ResourceData;
import java.util.Objects;

public class CaptionStyleData
extends ResourceData
implements Cloneable {
    private String hash;
    private String licenseName;
    private String licensePath;
    private String path;
    private int requiredPrime;
    private long size;
    private String thumb;

    public CaptionStyleData(long l10, String string2, String string3, String string4, int n10, long l11, String string5, String string6, String string7, int n11) {
        super(l10, string2, string3, string4, n10);
        this.size = l11;
        this.path = string5;
        this.hash = string6;
        this.thumb = string7;
        this.requiredPrime = n11;
    }

    public boolean equals(Object object) {
        String string2 = null;
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Object object2 = object instanceof CaptionStyleData;
        if (object2 == 0) {
            return false;
        }
        object2 = super.equals(object);
        if (object2 == 0) {
            return false;
        }
        object = (CaptionStyleData)object;
        long l10 = this.size;
        long l11 = ((CaptionStyleData)object).size;
        long l12 = l10 - l11;
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != 0) {
            return false;
        }
        String string3 = this.path;
        String string4 = ((CaptionStyleData)object).path;
        object2 = Objects.equals(string3, string4);
        if (object2 == 0) {
            return false;
        }
        string3 = this.hash;
        string4 = ((CaptionStyleData)object).hash;
        object2 = Objects.equals(string3, string4);
        if (object2 == 0) {
            return false;
        }
        string3 = this.thumb;
        string4 = ((CaptionStyleData)object).thumb;
        object2 = Objects.equals(string3, string4);
        if (object2 == 0) {
            return false;
        }
        string3 = this.licensePath;
        string4 = ((CaptionStyleData)object).licensePath;
        object2 = Objects.equals(string3, string4);
        if (object2 == 0) {
            return false;
        }
        object2 = this.requiredPrime;
        int n10 = ((CaptionStyleData)object).requiredPrime;
        if (object2 != n10) {
            return false;
        }
        string2 = this.licenseName;
        object = ((CaptionStyleData)object).licenseName;
        return Objects.equals(string2, object);
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

    public int hashCode() {
        int n10 = super.hashCode() * 31;
        long l10 = this.size;
        int n11 = 32;
        long l11 = l10 >>> n11;
        int n12 = (int)(l10 ^= l11);
        n10 = (n10 + n12) * 31;
        String string2 = this.path;
        int n13 = 0;
        if (string2 != null) {
            n12 = string2.hashCode();
        } else {
            n12 = 0;
            string2 = null;
        }
        n10 = (n10 + n12) * 31;
        string2 = this.hash;
        if (string2 != null) {
            n12 = string2.hashCode();
        } else {
            n12 = 0;
            string2 = null;
        }
        n10 = (n10 + n12) * 31;
        string2 = this.thumb;
        if (string2 != null) {
            n12 = string2.hashCode();
        } else {
            n12 = 0;
            string2 = null;
        }
        n10 = (n10 + n12) * 31;
        string2 = this.licensePath;
        if (string2 != null) {
            n12 = string2.hashCode();
        } else {
            n12 = 0;
            string2 = null;
        }
        n10 = (n10 + n12) * 31;
        string2 = this.licenseName;
        if (string2 != null) {
            n13 = string2.hashCode();
        }
        return n10 + n13;
    }

    public CaptionStyleData setHash(String string2) {
        this.hash = string2;
        return this;
    }

    public void setLicenseName(String string2) {
        this.licenseName = string2;
    }

    public void setLicensePath(String string2) {
        this.licensePath = string2;
    }

    public CaptionStyleData setPath(String string2) {
        this.path = string2;
        return this;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public CaptionStyleData setSize(long l10) {
        this.size = l10;
        return this;
    }

    public CaptionStyleData setThumb(String string2) {
        this.thumb = string2;
        return this;
    }
}

