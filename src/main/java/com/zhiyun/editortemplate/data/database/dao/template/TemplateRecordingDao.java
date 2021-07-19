/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import java.util.List;

public interface TemplateRecordingDao
extends BaseDao {
    public List getTemplateRecording(long var1);

    default public void insertMusic(List list, long l10) {
        List list2 = this.getTemplateRecording(l10);
        this.delete(list2);
        this.replace(list);
    }
}

