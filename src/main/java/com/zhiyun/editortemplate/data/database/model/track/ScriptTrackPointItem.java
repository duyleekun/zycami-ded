/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import java.lang.constant.Constable;
import java.util.Objects;

public class ScriptTrackPointItem {
    private float end;
    private Float start;
    private String type;

    public ScriptTrackPointItem(Float f10, float f11, String string2) {
        this.start = f10;
        this.end = f11;
        this.type = string2;
    }

    public ScriptTrackPointItem clone() {
        Float f10 = this.start;
        float f11 = this.end;
        String string2 = this.type;
        ScriptTrackPointItem scriptTrackPointItem = new ScriptTrackPointItem(f10, f11, string2);
        return scriptTrackPointItem;
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
            float f10;
            object = (ScriptTrackPointItem)object;
            object2 = ((ScriptTrackPointItem)object).start;
            float f11 = ((Float)object2).floatValue();
            int n10 = Float.compare(f11, f10 = ((Float)(constable = this.start)).floatValue());
            if (n10 != 0 || (n10 = Float.compare(f11 = ((ScriptTrackPointItem)object).end, f10 = this.end)) != 0 || !(bl3 = Objects.equals(object2 = this.type, object = ((ScriptTrackPointItem)object).type))) {
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
        stringBuilder.append("ScriptTrackPointItem{start=");
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

