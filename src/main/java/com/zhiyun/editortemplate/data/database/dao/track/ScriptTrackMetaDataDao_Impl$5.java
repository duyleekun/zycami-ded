/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

public class ScriptTrackMetaDataDao_Impl$5
implements Callable {
    public final /* synthetic */ ScriptTrackMetaDataDao_Impl this$0;
    public final /* synthetic */ List val$list;

    public ScriptTrackMetaDataDao_Impl$5(ScriptTrackMetaDataDao_Impl scriptTrackMetaDataDao_Impl, List list) {
        this.this$0 = scriptTrackMetaDataDao_Impl;
        this.val$list = list;
    }

    public List call() {
        Object object = ScriptTrackMetaDataDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.this$0;
            object = ScriptTrackMetaDataDao_Impl.access$100((ScriptTrackMetaDataDao_Impl)object);
            Object object2 = this.val$list;
            object = ((EntityInsertionAdapter)object).insertAndReturnIdsList((Collection)object2);
            object2 = this.this$0;
            object2 = ScriptTrackMetaDataDao_Impl.access$000((ScriptTrackMetaDataDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            ScriptTrackMetaDataDao_Impl.access$000(this.this$0).endTransaction();
        }
    }
}

