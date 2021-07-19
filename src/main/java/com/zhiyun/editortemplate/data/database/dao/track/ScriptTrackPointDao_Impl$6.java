/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class ScriptTrackPointDao_Impl$6
implements Callable {
    public final /* synthetic */ ScriptTrackPointDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public ScriptTrackPointDao_Impl$6(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl, List list) {
        this.this$0 = scriptTrackPointDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = ScriptTrackPointDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = ScriptTrackPointDao_Impl.access$200((ScriptTrackPointDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = ScriptTrackPointDao_Impl.access$000((ScriptTrackPointDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            ScriptTrackPointDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

