/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class ScriptTrackDao_Impl$6
implements Callable {
    public final /* synthetic */ ScriptTrackDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public ScriptTrackDao_Impl$6(ScriptTrackDao_Impl scriptTrackDao_Impl, List list) {
        this.this$0 = scriptTrackDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = ScriptTrackDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = ScriptTrackDao_Impl.access$200((ScriptTrackDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = ScriptTrackDao_Impl.access$000((ScriptTrackDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            ScriptTrackDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

