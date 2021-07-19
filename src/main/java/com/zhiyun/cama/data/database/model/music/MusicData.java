/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.music;

import com.zhiyun.cama.data.database.model.ResourceData;
import java.util.Objects;

public class MusicData
extends ResourceData {
    private Long albumId;
    private long duration;
    private long fileDownloadTimestamp;
    private String hash;
    private String path;
    private int requiredPrime;
    private long size;
    private String thumb;

    public MusicData(long l10, Long l11, String string2, String string3, String string4, int n10, String string5, long l12, long l13, String string6, String string7, int n11) {
        this(l10, string2, string3, string4, n10, string5, l12, l13, string6, string7, n11);
        this.albumId = l11;
    }

    public MusicData(long l10, String string2, String string3, String string4, int n10, String string5, long l11, long l12, String string6, String string7, int n11) {
        super(l10, string2, string3, string4, n10);
        this.thumb = string7;
        this.hash = string5;
        this.duration = l11;
        this.size = l12;
        this.path = string6;
        this.requiredPrime = n11;
    }

    public MusicData clone() {
        Object object;
        Object object2 = super.clone();
        long l10 = ((ResourceData)object2).getResId();
        Long l11 = this.albumId;
        String string2 = ((ResourceData)object2).getLabel();
        String string3 = ((ResourceData)object2).getLabel_tw();
        String string4 = ((ResourceData)object2).getLabel_en();
        int n10 = ((ResourceData)object2).getSort();
        String string5 = this.hash;
        long l12 = this.duration;
        long l13 = this.size;
        object2 = this.path;
        Object object3 = this.thumb;
        int n11 = this.requiredPrime;
        String string6 = object3;
        object3 = object;
        object = object2;
        ((MusicData)object3)(l10, l11, string2, string3, string4, n10, string5, l12, l13, (String)object2, string6, n11);
        long l14 = System.currentTimeMillis();
        ((MusicData)object3).setFileDownloadTimestamp(l14);
        return object3;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            long l10;
            Object object4 = super.equals(object);
            if (!object4) {
                return false;
            }
            object = (MusicData)object;
            long l11 = this.duration;
            long l12 = ((MusicData)object).duration;
            long l13 = l11 - l12;
            object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object4 || (object4 = (l10 = (l11 = this.size) - (l12 = ((MusicData)object).size)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) || !(object4 = Objects.equals(object3 = this.albumId, object2 = ((MusicData)object).albumId)) || !(object4 = Objects.equals(object3 = this.thumb, object2 = ((MusicData)object).thumb)) || !(object4 = Objects.equals(object3 = this.hash, object2 = ((MusicData)object).hash)) || !(bl3 = Objects.equals(object3 = this.path, object = ((MusicData)object).path))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Long getAlbumId() {
        return this.albumId;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getFileDownloadTimestamp() {
        return this.fileDownloadTimestamp;
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

    public int hashCode() {
        Object object = super.hashCode();
        Object[] objectArray = new Object[]{object, object = this.albumId, object = this.thumb, object = this.hash, object = Long.valueOf(this.duration), object = Long.valueOf(this.size), object = this.path};
        return Objects.hash(objectArray);
    }

    public void setAlbumId(Long l10) {
        this.albumId = l10;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setFileDownloadTimestamp(long l10) {
        this.fileDownloadTimestamp = l10;
    }

    public void setHash(String string2) {
        this.hash = string2;
    }

    public void setPath(String string2) {
        this.path = string2;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public void setSize(long l10) {
        this.size = l10;
    }

    public void setThumb(String string2) {
        this.thumb = string2;
    }
}

