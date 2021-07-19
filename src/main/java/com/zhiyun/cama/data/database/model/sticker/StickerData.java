/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.sticker;

import com.zhiyun.cama.data.database.model.ResourceData;

public class StickerData
extends ResourceData
implements Cloneable {
    private String hash;
    private String licenseName;
    private String licensePath;
    private String littleThumb;
    private String name;
    private String path;
    private int requiredPrime;
    private float scale;
    private long size;
    private String thumb;
    private long typeId;

    public StickerData(long l10, String string2, String string3, String string4, int n10, long l11, long l12, String string5, float f10, String string6, String string7, String string8, String string9, int n11) {
        super(l10, string2, string3, string4, n10);
        this.typeId = l11;
        this.size = l12;
        this.name = string5;
        this.scale = f10;
        this.littleThumb = string7;
        this.thumb = string6;
        this.path = string8;
        this.hash = string9;
        this.requiredPrime = n11;
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

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public int getRequiredPrime() {
        return this.requiredPrime;
    }

    public float getScale() {
        return this.scale;
    }

    public long getSize() {
        return this.size;
    }

    public String getThumb() {
        return this.thumb;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public StickerData setHash(String string2) {
        this.hash = string2;
        return this;
    }

    public void setLicenseName(String string2) {
        this.licenseName = string2;
    }

    public void setLicensePath(String string2) {
        this.licensePath = string2;
    }

    public StickerData setLittleThumb(String string2) {
        this.littleThumb = string2;
        return this;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public StickerData setPath(String string2) {
        this.path = string2;
        return this;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public StickerData setScale(float f10) {
        this.scale = f10;
        return this;
    }

    public StickerData setSize(long l10) {
        this.size = l10;
        return this;
    }

    public StickerData setThumb(String string2) {
        this.thumb = string2;
        return this;
    }

    public StickerData setTypeId(long l10) {
        this.typeId = l10;
        return this;
    }
}

