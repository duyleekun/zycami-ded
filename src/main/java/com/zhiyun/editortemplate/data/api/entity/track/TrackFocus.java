/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.track;

import java.lang.constant.Constable;
import java.util.Objects;

public class TrackFocus {
    private float end;
    private Float start;
    private String type;

    public TrackFocus(Float f10, float f11, String string2) {
        this.start = f10;
        this.end = f11;
        this.type = string2;
    }

    public boolean equals(Object object) {
        Constable constable;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (constable = object.getClass())) {
            boolean bl3;
            object = (TrackFocus)object;
            float f10 = ((TrackFocus)object).end;
            float f11 = this.end;
            int n10 = Float.compare(f10, f11);
            if (n10 != 0 || (n10 = (int)(Objects.equals(object2 = this.start, constable = ((TrackFocus)object).start) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object2 = this.type, object = ((TrackFocus)object).type))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public float getEnd() {
        return this.end;
    }

    public Float getStart() {
        return this.start;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        Object object = this.start;
        object = Float.valueOf(this.end);
        Object[] objectArray = new Object[]{object, object, object = this.type};
        return Objects.hash(objectArray);
    }

    public void setEnd(float f10) {
        this.end = f10;
    }

    public void setStart(Float f10) {
        this.start = f10;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackItem{start=");
        Object object = this.start;
        stringBuilder.append(object);
        stringBuilder.append(", end=");
        float f10 = this.end;
        stringBuilder.append(f10);
        stringBuilder.append(", type='");
        object = this.type;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

