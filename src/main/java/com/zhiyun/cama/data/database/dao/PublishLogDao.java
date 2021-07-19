/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import com.zhiyun.cama.data.database.model.PublishLog;
import java.util.List;

public interface PublishLogDao {
    public void deletePublishLog(List var1);

    public void insert(PublishLog ... var1);

    public List loadPublishLog();
}

