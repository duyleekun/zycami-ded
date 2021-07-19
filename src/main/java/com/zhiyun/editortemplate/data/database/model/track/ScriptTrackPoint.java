/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;
import java.util.Objects;

public class ScriptTrackPoint {
    private long duration;
    private ScriptTrackPointItem focus;
    private String func;
    private long id;
    private String orientation;
    private Float pitch;
    private Float roll;
    private long trackPointId;
    private String type;
    private Float yaw;
    private ScriptTrackPointItem zoom;

    public ScriptTrackPoint() {
    }

    public ScriptTrackPoint(String string2, long l10) {
        this.type = string2;
        this.duration = l10;
    }

    public ScriptTrackPoint(String string2, long l10, Float f10, Float f11, Float f12, ScriptTrackPointItem scriptTrackPointItem, ScriptTrackPointItem scriptTrackPointItem2, String string3, String string4) {
        this.type = string2;
        this.duration = l10;
        this.yaw = f10;
        this.pitch = f11;
        this.roll = f12;
        this.zoom = scriptTrackPointItem;
        this.focus = scriptTrackPointItem2;
        this.orientation = string3;
        this.func = string4;
    }

    public ScriptTrackPoint clone() {
        ScriptTrackPoint scriptTrackPoint;
        ScriptTrackPointItem scriptTrackPointItem;
        String string2 = this.type;
        long l10 = this.duration;
        Float f10 = this.yaw;
        Float f11 = this.pitch;
        Float f12 = this.roll;
        Object object = this.zoom;
        ScriptTrackPointItem scriptTrackPointItem2 = null;
        if (object == null) {
            scriptTrackPointItem = null;
        } else {
            object = ((ScriptTrackPointItem)object).clone();
            scriptTrackPointItem = object;
        }
        object = this.focus;
        Object object2 = object == null ? null : (object = ((ScriptTrackPointItem)object).clone());
        String string3 = this.orientation;
        String string4 = this.func;
        object = scriptTrackPoint;
        scriptTrackPointItem2 = scriptTrackPointItem;
        scriptTrackPointItem = object2;
        object2 = string3;
        string3 = string4;
        scriptTrackPoint = new ScriptTrackPoint(string2, l10, f10, f11, f12, scriptTrackPointItem2, scriptTrackPointItem, (String)object2, string4);
        return scriptTrackPoint;
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
            long l11;
            object = (ScriptTrackPoint)object;
            long l12 = this.id;
            long l13 = ((ScriptTrackPoint)object).id;
            long l14 = l12 - l13;
            Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (l11 = (l12 = this.trackPointId) - (l13 = ((ScriptTrackPoint)object).trackPointId)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object4 = (l10 = (l12 = this.duration) - (l13 = ((ScriptTrackPoint)object).duration)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)Objects.equals(object3 = this.type, object2 = ((ScriptTrackPoint)object).type)) == false || (object4 = (Object)Objects.equals(object3 = this.yaw, object2 = ((ScriptTrackPoint)object).yaw)) == false || (object4 = (Object)Objects.equals(object3 = this.pitch, object2 = ((ScriptTrackPoint)object).pitch)) == false || (object4 = (Object)Objects.equals(object3 = this.roll, object2 = ((ScriptTrackPoint)object).roll)) == false || (object4 = (Object)Objects.equals(object3 = this.zoom, object2 = ((ScriptTrackPoint)object).zoom)) == false || (object4 = (Object)Objects.equals(object3 = this.focus, object2 = ((ScriptTrackPoint)object).focus)) == false || (object4 = (Object)Objects.equals(object3 = this.orientation, object2 = ((ScriptTrackPoint)object).orientation)) == false || !(bl3 = Objects.equals(object3 = this.func, object = ((ScriptTrackPoint)object).func))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getDuration() {
        return this.duration;
    }

    public ScriptTrackPointItem getFocus() {
        return this.focus;
    }

    public String getFunc() {
        return this.func;
    }

    public long getId() {
        return this.id;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public Float getPitch() {
        return this.pitch;
    }

    public Float getRoll() {
        return this.roll;
    }

    public long getTrackPointId() {
        return this.trackPointId;
    }

    public String getType() {
        return this.type;
    }

    public Float getYaw() {
        return this.yaw;
    }

    public ScriptTrackPointItem getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.trackPointId), object = this.type, object = Long.valueOf(this.duration), object = this.yaw, object = this.pitch, object = this.roll, object = this.zoom, object = this.focus, object = this.orientation, object = this.func};
        return Objects.hash(objectArray);
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setFocus(ScriptTrackPointItem scriptTrackPointItem) {
        this.focus = scriptTrackPointItem;
    }

    public void setFunc(String string2) {
        this.func = string2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setOrientation(String string2) {
        this.orientation = string2;
    }

    public void setPitch(Float f10) {
        this.pitch = f10;
    }

    public void setRoll(Float f10) {
        this.roll = f10;
    }

    public void setTrackPointId(long l10) {
        this.trackPointId = l10;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public void setYaw(Float f10) {
        this.yaw = f10;
    }

    public void setZoom(ScriptTrackPointItem scriptTrackPointItem) {
        this.zoom = scriptTrackPointItem;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScriptTrackPoint{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", trackPointId=");
        l10 = this.trackPointId;
        stringBuilder.append(l10);
        stringBuilder.append(", type='");
        String string2 = this.type;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", duration=");
        long l11 = this.duration;
        stringBuilder.append(l11);
        stringBuilder.append(", yaw=");
        Object object = this.yaw;
        stringBuilder.append(object);
        stringBuilder.append(", pitch=");
        object = this.pitch;
        stringBuilder.append(object);
        stringBuilder.append(", roll=");
        object = this.roll;
        stringBuilder.append(object);
        stringBuilder.append(", zoom=");
        object = this.zoom;
        stringBuilder.append(object);
        stringBuilder.append(", focus=");
        object = this.focus;
        stringBuilder.append(object);
        stringBuilder.append(", orientation='");
        object = this.orientation;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append(", func='");
        object = this.func;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

