/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import java.util.concurrent.Callable;

public class G_TemplateDataDao_Impl$10
implements Callable {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;
    public final /* synthetic */ Boolean val$download;
    public final /* synthetic */ Integer val$editorProtoType;
    public final /* synthetic */ Integer val$tempType;
    public final /* synthetic */ Integer val$templateUseType;
    public final /* synthetic */ String val$videoRatio;

    public G_TemplateDataDao_Impl$10(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        this.this$0 = g_TemplateDataDao_Impl;
        this.val$tempType = n10;
        this.val$templateUseType = n11;
        this.val$editorProtoType = n12;
        this.val$download = bl2;
        this.val$videoRatio = string2;
    }

    public Integer call() {
        long l10;
        int n10;
        SupportSQLiteStatement supportSQLiteStatement = G_TemplateDataDao_Impl.access$300(this.this$0).acquire();
        Object object = this.val$tempType;
        int n11 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            n10 = (Integer)object;
            long l11 = n10;
            supportSQLiteStatement.bindLong(n11, l11);
        }
        n10 = 2;
        Object object2 = this.val$tempType;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = (Integer)object2;
            l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        n10 = 3;
        object2 = this.val$templateUseType;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = (Integer)object2;
            l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        n10 = 4;
        object2 = this.val$templateUseType;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = (Integer)object2;
            l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        n10 = 5;
        object2 = this.val$editorProtoType;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = (Integer)object2;
            l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        n10 = 6;
        object2 = this.val$editorProtoType;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = (Integer)object2;
            l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        n10 = 7;
        object2 = this.val$download;
        Integer n12 = null;
        if (object2 == null) {
            n11 = 0;
            object2 = null;
        } else {
            n11 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            object2 = n11;
        }
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = (Integer)object2;
            long l12 = n11;
            supportSQLiteStatement.bindLong(n10, l12);
        }
        n10 = 8;
        object2 = this.val$download;
        if (object2 != null) {
            n11 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            n12 = n11;
        }
        if (n12 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            n11 = n12;
            l10 = n11;
            supportSQLiteStatement.bindLong(n10, l10);
        }
        n10 = 9;
        object2 = this.val$videoRatio;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        n10 = 10;
        object2 = this.val$videoRatio;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object = G_TemplateDataDao_Impl.access$000(this.this$0);
        ((RoomDatabase)object).beginTransaction();
        try {
            n10 = supportSQLiteStatement.executeUpdateDelete();
            object = n10;
            object2 = this.this$0;
            object2 = G_TemplateDataDao_Impl.access$000((G_TemplateDataDao_Impl)object2);
            ((RoomDatabase)object2).setTransactionSuccessful();
            return object;
        }
        finally {
            G_TemplateDataDao_Impl.access$000(this.this$0).endTransaction();
            G_TemplateDataDao_Impl.access$300(this.this$0).release(supportSQLiteStatement);
        }
    }
}

