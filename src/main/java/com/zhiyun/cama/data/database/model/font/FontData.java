/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.font;

import com.zhiyun.cama.data.database.model.ResourceData;

public class FontData
extends ResourceData
implements Cloneable {
    private String hash;
    private String path;
    private int requiredPrime;
    private long size;
    private String thumb;

    public FontData(long l10, String string2, String string3, String string4, int n10, long l11, String string5, String string6, String string7, int n11) {
        super(l10, string2, string3, string4, n10);
        this.size = l11;
        this.path = string5;
        this.hash = string6;
        this.thumb = string7;
        this.requiredPrime = n11;
    }

    public String getHash() {
        return this.hash;
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

    public FontData setHash(String string2) {
        this.hash = string2;
        return this;
    }

    public FontData setPath(String string2) {
        this.path = string2;
        return this;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public FontData setSize(long l10) {
        this.size = l10;
        return this;
    }

    public FontData setThumb(String string2) {
        this.thumb = string2;
        return this;
    }
}

