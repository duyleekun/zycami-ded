/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateVideoDao;
import e.a.i0;
import e.a.z;
import java.util.List;

public interface G_TemplateVideoDao
extends TemplateVideoDao {
    public LiveData getTemplateVideos_LiveData(long var1);

    public z getTemplateVideos_Observable(long var1);

    public i0 getTemplateVideos_Single(long var1);

    public z loadTemplateVideoData_Observable(long var1);

    public List loadTemplateVideoData_Primitive(long var1);

    public i0 loadTemplateVideoData_Single(long var1);
}

