/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import java.util.Objects;

public class Script {
    private long id;
    private long referenceId;
    private long scriptId;

    public Script() {
    }

    public Script(long l10) {
        this.scriptId = l10;
    }

    public Script clone() {
        Script script = new Script();
        return script;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            long l10;
            long l11;
            object = (Script)object;
            long l12 = this.id;
            long l13 = ((Script)object).id;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false || (l11 = (l10 = (l12 = this.scriptId) - (l13 = ((Script)object).scriptId)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getId() {
        return this.id;
    }

    public long getReferenceId() {
        return this.referenceId;
    }

    public long getScriptId() {
        return this.scriptId;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Long l10 = this.id;
        objectArray[0] = l10;
        l10 = this.scriptId;
        objectArray[1] = l10;
        return Objects.hash(objectArray);
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setReferenceId(long l10) {
        this.referenceId = l10;
    }

    public void setScriptId(long l10) {
        this.scriptId = l10;
    }
}

