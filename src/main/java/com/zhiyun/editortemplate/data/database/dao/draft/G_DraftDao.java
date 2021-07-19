/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.draft.DraftDao;
import e.a.i0;
import e.a.z;

public interface G_DraftDao
extends DraftDao {
    public LiveData getAllDraft_LiveData();

    public z getAllDraft_Observable();

    public i0 getAllDraft_Single();

    public LiveData getLatestDraftPOJO_LiveData();

    public z getLatestDraftPOJO_Observable();

    public i0 getLatestDraftPOJO_Single();

    public LiveData getLatestDraft_LiveData();

    public z getLatestDraft_Observable();

    public i0 getLatestDraft_Single();
}

