/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl;
import com.zhiyun.editortemplate.data.database.model.TypeListConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import java.util.List;
import java.util.concurrent.Callable;

public class G_SortResultDao_Impl$9
implements Callable {
    public final /* synthetic */ G_SortResultDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_SortResultDao_Impl$9(G_SortResultDao_Impl g_SortResultDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_SortResultDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public SortResult call() {
        Object object;
        RoomDatabase roomDatabase;
        block15: {
            Object object2;
            int n10;
            int n11;
            Object object3;
            block18: {
                boolean bl2;
                int n12;
                block17: {
                    int n13;
                    block16: {
                        roomDatabase = G_SortResultDao_Impl.access$000(this.this$0);
                        object3 = this.val$_statement;
                        n11 = 0;
                        String string2 = null;
                        object = null;
                        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object3, false, null);
                        object3 = "page_type";
                        try {
                            n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object3);
                            string2 = "next_page";
                        }
                        catch (Throwable throwable) {
                            roomDatabase.close();
                            throw throwable;
                        }
                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
                        String string3 = "count";
                        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
                        object2 = "id_list";
                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
                        bl2 = roomDatabase.moveToFirst();
                        if (!bl2) break block15;
                        bl2 = roomDatabase.isNull(n13);
                        if (!bl2) break block16;
                        n13 = 0;
                        object3 = null;
                        break block17;
                    }
                    object3 = roomDatabase.getString(n13);
                }
                n11 = roomDatabase.getInt(n11);
                n10 = roomDatabase.getInt(n10);
                bl2 = roomDatabase.isNull(n12);
                if (bl2) break block18;
                object = roomDatabase.getString(n12);
            }
            object = TypeListConverters.stringToLongList(object);
            object = object2 = new SortResult((String)object3, n11, n10, (List)object);
        }
        roomDatabase.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

