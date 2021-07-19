/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.draft.WithdrawDao;
import e.a.i0;
import e.a.z;

public interface G_WithdrawDao
extends WithdrawDao {
    public LiveData geLimitData_LiveData(int var1);

    public z geLimitData_Observable(int var1);

    public i0 geLimitData_Single(int var1);

    public LiveData getAllWithdraw_LiveData();

    public z getAllWithdraw_Observable();

    public i0 getAllWithdraw_Single();

    public LiveData getLastWithdraw_LiveData();

    public z getLastWithdraw_Observable();

    public i0 getLastWithdraw_Single();
}

