/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.music;

import com.zhiyun.cama.data.database.model.ResourceData;
import java.util.Objects;

public class AlbumData
extends ResourceData
implements Cloneable {
    private String coverUrl;
    private int songCount;

    public AlbumData() {
    }

    public AlbumData(long l10, String string2, String string3, String string4, int n10, String string5, int n11) {
        super(l10, string2, string3, string4, n10);
        this.coverUrl = string5;
        this.songCount = n11;
    }

    public AlbumData clone() {
        ResourceData resourceData = super.clone();
        long l10 = resourceData.getResId();
        String string2 = resourceData.getLabel();
        String string3 = resourceData.getLabel_tw();
        String string4 = resourceData.getLabel_en();
        int n10 = resourceData.getSort();
        String string5 = this.coverUrl;
        int n11 = this.songCount;
        AlbumData albumData = new AlbumData(l10, string2, string3, string4, n10, string5, n11);
        return albumData;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            boolean bl3;
            int n10 = super.equals(object);
            if (n10 == 0) {
                return false;
            }
            object = (AlbumData)object;
            n10 = this.songCount;
            int n11 = ((AlbumData)object).songCount;
            if (n10 != n11 || !(bl3 = Objects.equals(object2 = this.coverUrl, object = ((AlbumData)object).coverUrl))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getSongCount() {
        return this.songCount;
    }

    public int hashCode() {
        Object object = super.hashCode();
        Object[] objectArray = new Object[]{object, object = this.coverUrl, object = Integer.valueOf(this.songCount)};
        return Objects.hash(objectArray);
    }

    public void setCoverUrl(String string2) {
        this.coverUrl = string2;
    }

    public void setSongCount(int n10) {
        this.songCount = n10;
    }
}

