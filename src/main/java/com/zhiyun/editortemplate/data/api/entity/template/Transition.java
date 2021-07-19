/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;

public class Transition
extends FileDataBaseBean {
    private long duration;
    private long timebase;

    public Transition() {
        this.isLocalSource = true;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getTimebase() {
        return this.timebase;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transition{timebase=");
        long l10 = this.timebase;
        stringBuilder.append(l10);
        stringBuilder.append(", name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", isLocalSource=");
        boolean bl2 = this.isLocalSource;
        stringBuilder.append(bl2);
        stringBuilder.append(", file=");
        object = this.file;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

