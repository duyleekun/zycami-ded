/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.draft;

import java.lang.constant.Constable;
import java.util.Objects;

public class Draft {
    private String contentDesc;
    private long createTime;
    private long draftId;
    private long id;

    public Draft() {
    }

    public Draft(long l10, long l11) {
        this.draftId = l10;
        this.createTime = l11;
    }

    public Draft clone() {
        Draft draft = new Draft();
        long l10 = System.currentTimeMillis();
        draft.setCreateTime(l10);
        String string2 = this.contentDesc;
        draft.setContentDesc(string2);
        return draft;
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
            long l10;
            long l11;
            object = (Draft)object;
            long l12 = this.id;
            long l13 = ((Draft)object).id;
            long l14 = l12 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false || (object3 = (l11 = (l12 = this.draftId) - (l13 = ((Draft)object).draftId)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object3 = (Object)Objects.equals(object2 = Long.valueOf(l12 = this.createTime), constable = Long.valueOf(l10 = ((Draft)object).createTime))) == false || !(bl3 = Objects.equals(object2 = this.contentDesc, object = ((Draft)object).contentDesc))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getContentDesc() {
        return this.contentDesc;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getDraftId() {
        return this.draftId;
    }

    public long getId() {
        return this.id;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.draftId), object = Long.valueOf(this.createTime), object = this.contentDesc};
        return Objects.hash(objectArray);
    }

    public void setContentDesc(String string2) {
        this.contentDesc = string2;
    }

    public void setCreateTime(long l10) {
        this.createTime = l10;
    }

    public void setDraftId(long l10) {
        this.draftId = l10;
    }

    public void setId(long l10) {
        this.id = l10;
    }
}

