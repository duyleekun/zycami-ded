/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model.filter;

import com.zhiyun.cama.data.database.model.ResourceData;
import java.util.Objects;

public class FilterData
extends ResourceData {
    private String hash;
    private String licenseName;
    private String licensePath;
    private int main_sort;
    private String path;
    private int requiredPrime;
    private long size;
    private String thumb;
    private long typeId;

    public FilterData(long l10, String string2, String string3, String string4, int n10, long l11, long l12, String string5, String string6, String string7, int n11, int n12) {
        super(l10, string2, string3, string4, n10);
        this.typeId = l11;
        this.size = l12;
        this.path = string5;
        this.thumb = string6;
        this.hash = string7;
        this.main_sort = n11;
        this.requiredPrime = n12;
    }

    public FilterData clone() {
        long l10 = this.getResId();
        String string2 = this.getLabel();
        String string3 = this.getLabel_tw();
        String string4 = this.getLabel_en();
        int n10 = this.getSort();
        long l11 = this.typeId;
        long l12 = this.size;
        String string5 = this.path;
        String string6 = this.thumb;
        String string7 = this.hash;
        int n11 = this.main_sort;
        int n12 = this.requiredPrime;
        FilterData filterData = new FilterData(l10, string2, string3, string4, n10, l11, l12, string5, string6, string7, n11, n12);
        return filterData;
    }

    public boolean equals(Object object) {
        boolean bl2;
        String string2;
        String string3;
        int n10;
        long l10;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        Object object2 = object instanceof FilterData;
        if (object2 == 0) {
            return false;
        }
        object2 = super.equals(object);
        if (object2 == 0) {
            return false;
        }
        object = (FilterData)object;
        long l11 = this.typeId;
        long l12 = ((FilterData)object).typeId;
        long l13 = l11 - l12;
        object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != 0 || (object2 = (l10 = (l11 = this.size) - (l12 = ((FilterData)object).size)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != 0 || (object2 = this.requiredPrime) != (n10 = ((FilterData)object).requiredPrime) || (object2 = (Object)Objects.equals(string3 = this.path, string2 = ((FilterData)object).path)) == 0 || (object2 = (Object)Objects.equals(string3 = this.thumb, string2 = ((FilterData)object).thumb)) == 0 || !(bl2 = Objects.equals(string3 = this.hash, object = ((FilterData)object).hash))) {
            bl3 = false;
        }
        return bl3;
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

    public int getMain_sort() {
        return this.main_sort;
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

    public long getTypeId() {
        return this.typeId;
    }

    public int hashCode() {
        Object object = super.hashCode();
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.typeId), object = Long.valueOf(this.size), object = this.path, object = this.thumb, object = this.hash};
        return Objects.hash(objectArray);
    }

    public FilterData setHash(String string2) {
        this.hash = string2;
        return this;
    }

    public void setLicenseName(String string2) {
        this.licenseName = string2;
    }

    public void setLicensePath(String string2) {
        this.licensePath = string2;
    }

    public void setMain_sort(int n10) {
        this.main_sort = n10;
    }

    public FilterData setPath(String string2) {
        this.path = string2;
        return this;
    }

    public void setRequiredPrime(int n10) {
        this.requiredPrime = n10;
    }

    public FilterData setSize(long l10) {
        this.size = l10;
        return this;
    }

    public FilterData setThumb(String string2) {
        this.thumb = string2;
        return this;
    }

    public void setTypeId(long l10) {
        this.typeId = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FilterData{typeId=");
        long l10 = this.typeId;
        stringBuilder.append(l10);
        stringBuilder.append(", size=");
        l10 = this.size;
        stringBuilder.append(l10);
        stringBuilder.append(", path='");
        String string2 = this.path;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", thumb='");
        String string3 = this.thumb;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", hash='");
        string3 = this.hash;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", main_sort=");
        int n11 = this.main_sort;
        stringBuilder.append(n11);
        stringBuilder.append((char)n10);
        stringBuilder.append(", requiredPrime=");
        n10 = this.requiredPrime;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

