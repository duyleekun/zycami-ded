/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl;
import com.zhiyun.cama.data.database.model.transition.TransitionFile;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class TransitionFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ TransitionFileDao_Impl this$0;

    public TransitionFileDao_Impl$3(TransitionFileDao_Impl transitionFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = transitionFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TransitionFile object) {
        String string2 = ((FileData)object).getHash();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `transition_file` WHERE `hash` = ?";
    }
}

