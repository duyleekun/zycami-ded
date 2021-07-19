/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.config;

import java.util.Objects;

public class TemplateTransition {
    private long duration;
    private boolean localSource;
    private String name;
    private String thumb;
    private long timebase;

    public TemplateTransition(String string2, long l10, long l11, boolean bl2) {
        this.name = string2;
        this.duration = l10;
        this.timebase = l11;
        this.localSource = bl2;
    }

    public TemplateTransition(String string2, long l10, long l11, boolean bl2, String string3) {
        this(string2, l10, l11, bl2);
        this.thumb = string3;
    }

    public TemplateTransition clone() {
        String string2 = this.name;
        long l10 = this.duration;
        long l11 = this.timebase;
        boolean bl2 = this.localSource;
        String string3 = this.thumb;
        TemplateTransition templateTransition = new TemplateTransition(string2, l10, l11, bl2, string3);
        return templateTransition;
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
            boolean bl4;
            long l10;
            object = (TemplateTransition)object;
            long l11 = this.duration;
            long l12 = ((TemplateTransition)object).duration;
            long l13 = l11 - l12;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 != false || (object3 = (l10 = (l11 = this.timebase) - (l12 = ((TemplateTransition)object).timebase)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object3 = (Object)this.localSource) != (bl4 = ((TemplateTransition)object).localSource) || !(bl3 = Objects.equals(object2 = this.name, object = ((TemplateTransition)object).name))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    public String getThumb() {
        return this.thumb;
    }

    public long getTimebase() {
        return this.timebase;
    }

    public int hashCode() {
        Object object = this.name;
        object = this.duration;
        Object[] objectArray = new Object[]{object, object, object = Long.valueOf(this.timebase), object = Boolean.valueOf(this.localSource)};
        return Objects.hash(objectArray);
    }

    public boolean isLocalSource() {
        return this.localSource;
    }

    public void setDuration(long l10) {
        this.duration = l10;
    }

    public void setLocalSource(boolean bl2) {
        this.localSource = bl2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setThumb(String string2) {
        this.thumb = string2;
    }

    public void setTimebase(long l10) {
        this.timebase = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateTransition{name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", duration=");
        long l10 = this.duration;
        stringBuilder.append(l10);
        stringBuilder.append(", timebase=");
        l10 = this.timebase;
        stringBuilder.append(l10);
        stringBuilder.append(", localSource=");
        boolean bl2 = this.localSource;
        stringBuilder.append(bl2);
        stringBuilder.append(", thumb='");
        String string3 = this.thumb;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

