/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateDao_Impl$23
implements Callable {
    public final /* synthetic */ G_TemplateDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDao_Impl$23(G_TemplateDao_Impl g_TemplateDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = G_TemplateDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        object = this.this$0;
        object = G_TemplateDao_Impl.access$000((G_TemplateDao_Impl)object);
        ArrayList<Long> arrayList = this.val$_statement;
        Object object2 = null;
        object = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)((Object)arrayList), false, null);
        try {
            int n10 = object.getCount();
            arrayList = new ArrayList<Long>(n10);
            while ((n10 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                Long l10;
                n10 = (int)(object.isNull(0) ? 1 : 0);
                if (n10 != 0) {
                    n10 = 0;
                    l10 = null;
                } else {
                    long l11 = object.getLong(0);
                    l10 = l11;
                }
                arrayList.add(l10);
            }
            object2 = this.this$0;
            object2 = G_TemplateDao_Impl.access$000((G_TemplateDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
        }
        catch (Throwable throwable) {
            object.close();
            throw throwable;
        }
        try {
            object.close();
            return arrayList;
        }
        finally {
            G_TemplateDao_Impl.access$000(this.this$0).endTransaction();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

