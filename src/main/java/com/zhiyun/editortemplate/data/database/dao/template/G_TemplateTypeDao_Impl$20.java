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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import java.util.concurrent.Callable;

public class G_TemplateTypeDao_Impl$20
implements Callable {
    public final /* synthetic */ G_TemplateTypeDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateTypeDao_Impl$20(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateTypeDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public TemplateType call() {
        Object object;
        CharSequence charSequence;
        RoomSQLiteQuery roomSQLiteQuery;
        Object object2;
        G_TemplateTypeDao_Impl$20 g_TemplateTypeDao_Impl$20;
        block26: {
            Object object3;
            Object object4;
            long l10;
            int n10;
            int n11;
            block31: {
                int n12;
                int n13;
                block30: {
                    int n14;
                    block29: {
                        block28: {
                            int n15;
                            block27: {
                                g_TemplateTypeDao_Impl$20 = this;
                                object2 = G_TemplateTypeDao_Impl.access$000(this.this$0);
                                roomSQLiteQuery = this.val$_statement;
                                n15 = 0;
                                charSequence = null;
                                object = null;
                                roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
                                object2 = "id";
                                try {
                                    n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                    charSequence = "label";
                                }
                                catch (Throwable throwable) {
                                    roomSQLiteQuery.close();
                                    throw throwable;
                                }
                                n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)charSequence);
                                String string2 = "label_tw";
                                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                String string3 = "label_en";
                                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                                String string4 = "resource_type";
                                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                                String string5 = "template_proto_type";
                                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                                boolean bl2 = roomSQLiteQuery.moveToFirst();
                                if (!bl2) break block26;
                                l10 = roomSQLiteQuery.getLong(n13);
                                n13 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                if (n13 == 0) break block27;
                                object4 = null;
                                break block28;
                            }
                            object4 = object2 = roomSQLiteQuery.getString(n15);
                        }
                        n13 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n13 == 0) break block29;
                        object3 = null;
                        break block30;
                    }
                    object3 = object2 = roomSQLiteQuery.getString(n14);
                }
                n13 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                if (n13 != 0) break block31;
                object = roomSQLiteQuery.getString(n12);
            }
            int n16 = roomSQLiteQuery.getInt(n11);
            int n17 = roomSQLiteQuery.getInt(n10);
            object = TemplateType.create(l10, (String)object4, (String)object3, (String)object, n16, n17);
        }
        if (object != null) {
            roomSQLiteQuery.close();
            return object;
        }
        charSequence = new StringBuilder();
        object = "Query returned empty result set: ";
        ((StringBuilder)charSequence).append((String)object);
        object = g_TemplateTypeDao_Impl$20.val$_statement;
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

