/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import java.util.Objects;

public class ScriptTrack {
    private String durationType;
    private long id;
    private long scriptTrackId;
    private long trackId;

    public ScriptTrack() {
    }

    public ScriptTrack(long l10, long l11, long l12, String string2) {
        this(l12, string2);
        this.id = l10;
        this.scriptTrackId = l11;
    }

    public ScriptTrack(long l10, String string2) {
        this.trackId = l10;
        this.durationType = string2;
    }

    public ScriptTrack clone() {
        long l10 = this.trackId;
        String string2 = this.durationType;
        ScriptTrack scriptTrack = new ScriptTrack(l10, string2);
        return scriptTrack;
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
            long l10;
            long l11;
            object = (ScriptTrack)object;
            long l12 = this.id;
            long l13 = ((ScriptTrack)object).id;
            long l14 = l12 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false || (object3 = (l11 = (l12 = this.scriptTrackId) - (l13 = ((ScriptTrack)object).scriptTrackId)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object3 = (l10 = (l12 = this.trackId) - (l13 = ((ScriptTrack)object).trackId)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || !(bl3 = Objects.equals(object2 = this.durationType, object = ((ScriptTrack)object).durationType))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getDurationType() {
        return this.durationType;
    }

    public long getId() {
        return this.id;
    }

    public long getScriptTrackId() {
        return this.scriptTrackId;
    }

    public long getTrackId() {
        return this.trackId;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.scriptTrackId), object = Long.valueOf(this.trackId), object = this.durationType};
        return Objects.hash(objectArray);
    }

    public void setDurationType(String string2) {
        this.durationType = string2;
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setScriptTrackId(long l10) {
        this.scriptTrackId = l10;
    }

    public void setTrackId(long l10) {
        this.trackId = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScriptTrack{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", scriptTrackId=");
        l10 = this.scriptTrackId;
        stringBuilder.append(l10);
        stringBuilder.append(", trackId=");
        l10 = this.trackId;
        stringBuilder.append(l10);
        stringBuilder.append(", durationType='");
        String string2 = this.durationType;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

