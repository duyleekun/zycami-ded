/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource$Factory;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import com.zhiyun.cama.data.database.model.MessageViolation;
import java.util.ArrayList;
import java.util.List;

public interface MessageDao {
    public void deleteMessageLike();

    public void deleteMessageLike(int var1);

    public void deleteMessageSystem();

    public void deleteMessageSystem(int var1);

    public void deleteMessageViolation();

    public void deleteMessageViolation(int var1);

    public void insertMessageLike(List var1);

    public void insertMessageSystem(ArrayList var1);

    public void insertMessageUnreadCount(MessageUnReadCount var1);

    public void insertMessageViolation(List var1);

    public void insertMessageViolation(MessageViolation ... var1);

    public DataSource$Factory loadMessageLike();

    public DataSource$Factory loadMessageSystem();

    public LiveData loadMessageUnreadCount(int var1);

    public MessageUnReadCount loadMessageUnreadCountData(int var1);

    public DataSource$Factory loadMessageViolation();

    public MessageViolation loadMessageViolation(String var1, int var2);
}

