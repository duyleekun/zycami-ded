/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import java.util.List;

public interface TemplateVideoDao
extends BaseDao {
    public List getTemplateVideos(long var1);

    default public void insertTemplateVideo(List list, long l10) {
        List list2 = this.getTemplateVideos(l10);
        this.delete(list2);
        this.replace(list);
    }

    public LiveData loadTemplateVideoData(long var1);
}

