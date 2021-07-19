/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource$Factory;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.database.model.Works;
import java.util.List;

public interface WorksDao {
    public void deleteLikes(List var1);

    public void deletePublishWorks(PublishWorks var1);

    public void deleteWorks(Works var1);

    public void deletedAllPublish();

    public void deletedUserLikes(int var1);

    public void deletedUserWorks(int var1);

    public void insertLikes(List var1);

    public void insertPublishWorks(PublishWorks var1);

    public void insertWorks(List var1);

    public void insertWorks(Works ... var1);

    public List loadLikesData(int var1);

    public List loadLikesData(int var1, int var2);

    public DataSource$Factory loadLikesWithUserId(int var1);

    public LiveData loadPublishWorks();

    public PublishWorks loadPublishWorksData();

    public Works loadWorksData(int var1);

    public Works loadWorksDataWithApprovalId(int var1);

    public DataSource$Factory loadWorksWithUserId(int var1);
}

