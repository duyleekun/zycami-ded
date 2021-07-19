/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.track;

import java.util.List;
import java.util.Objects;

public class TrackBean {
    private String durationType;
    private List products;
    private long trackId;
    private String trackName;
    private String trackNameJson;

    public TrackBean(long l10, String string2, String string3, String string4, List list) {
        this.trackId = l10;
        this.trackName = string2;
        this.trackNameJson = string3;
        this.durationType = string4;
        this.products = list;
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
            object = (TrackBean)object;
            long l10 = this.trackId;
            long l11 = ((TrackBean)object).trackId;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (Object)Objects.equals(object3 = this.trackName, object2 = ((TrackBean)object).trackName)) == false || (object4 = (Object)Objects.equals(object3 = this.trackNameJson, object2 = ((TrackBean)object).trackNameJson)) == false || (object4 = (Object)Objects.equals(object3 = this.durationType, object2 = ((TrackBean)object).durationType)) == false || !(bl3 = Objects.equals(object3 = this.products, object = ((TrackBean)object).products))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getDurationType() {
        return this.durationType;
    }

    public List getProducts() {
        return this.products;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public String getTrackName() {
        return this.trackName;
    }

    public String getTrackNameJson() {
        return this.trackNameJson;
    }

    public int hashCode() {
        Object object = this.trackId;
        Object[] objectArray = new Object[]{object, object = this.trackName, object = this.trackNameJson, object = this.durationType, object = this.products};
        return Objects.hash(objectArray);
    }

    public void setDurationType(String string2) {
        this.durationType = string2;
    }

    public void setProducts(List list) {
        this.products = list;
    }

    public void setTrackId(long l10) {
        this.trackId = l10;
    }

    public void setTrackName(String string2) {
        this.trackName = string2;
    }

    public void setTrackNameJson(String string2) {
        this.trackNameJson = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Track{trackId=");
        long l10 = this.trackId;
        stringBuilder.append(l10);
        stringBuilder.append(", trackName='");
        Object object = this.trackName;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", trackNameJson='");
        String string2 = this.trackNameJson;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", durationType='");
        string2 = this.durationType;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", products=");
        object = this.products;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

