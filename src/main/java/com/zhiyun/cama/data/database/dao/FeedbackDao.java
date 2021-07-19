/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.paging.DataSource$Factory;
import com.zhiyun.cama.data.database.model.Feedback;
import java.util.List;

public interface FeedbackDao {
    public void deleteFeedback();

    public void insertFeedback(List var1);

    public void insertFeedback(Feedback ... var1);

    public Feedback loadFeedback(int var1);

    public DataSource$Factory loadFeedbackList();
}

