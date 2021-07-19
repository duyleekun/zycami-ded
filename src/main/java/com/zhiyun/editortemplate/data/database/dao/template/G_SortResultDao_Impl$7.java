/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
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

public class G_SortResultDao_Impl$7
implements Callable {
    public final /* synthetic */ G_SortResultDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_SortResultDao_Impl$7(G_SortResultDao_Impl g_SortResultDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_SortResultDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public SortResult call() {
        Object object;
        CharSequence charSequence;
        Object object2;
        RoomDatabase roomDatabase;
        block23: {
            Object object3;
            int n10;
            int n11;
            block26: {
                boolean bl2;
                int n12;
                block25: {
                    int n13;
                    block24: {
                        roomDatabase = G_SortResultDao_Impl.access$000(this.this$0);
                        object2 = this.val$_statement;
                        n11 = 0;
                        charSequence = null;
                        object = null;
                        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
                        object2 = "page_type";
                        try {
                            n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
                            charSequence = "next_page";
                        }
                        catch (Throwable throwable) {
                            roomDatabase.close();
                            throw throwable;
                        }
                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)charSequence);
                        String string2 = "count";
                        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
                        object3 = "id_list";
                        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object3);
                        bl2 = roomDatabase.moveToFirst();
                        if (!bl2) break block23;
                        bl2 = roomDatabase.isNull(n13);
                        if (!bl2) break block24;
                        n13 = 0;
                        object2 = null;
                        break block25;
                    }
                    object2 = roomDatabase.getString(n13);
                }
                n11 = roomDatabase.getInt(n11);
                n10 = roomDatabase.getInt(n10);
                bl2 = roomDatabase.isNull(n12);
                if (bl2) break block26;
                object = roomDatabase.getString(n12);
            }
            object = TypeListConverters.stringToLongList((String)object);
            object = object3 = new SortResult((String)object2, n11, n10, (List)object);
        }
        if (object != null) {
            roomDatabase.close();
            return object;
        }
        charSequence = new StringBuilder();
        object = "Query returned empty result set: ";
        ((StringBuilder)charSequence).append((String)object);
        object = this.val$_statement;
        object = ((RoomSQLiteQuery)object).getSql();
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        object2 = new EmptyResultSetException((String)charSequence);
        throw object2;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

