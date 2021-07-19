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
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import java.util.concurrent.Callable;

public class G_TemplateFileDao_Impl$21
implements Callable {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateFileDao_Impl$21(G_TemplateFileDao_Impl g_TemplateFileDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateFileDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public FileData call() {
        Object object;
        CharSequence charSequence;
        Object object2;
        RoomDatabase roomDatabase;
        block60: {
            FileExt fileExt;
            Object object3;
            int n10;
            block79: {
                int n11;
                int n12;
                block78: {
                    int n13;
                    block77: {
                        int n14;
                        block76: {
                            int n15;
                            block75: {
                                block74: {
                                    int n16;
                                    block73: {
                                        block72: {
                                            int n17;
                                            block71: {
                                                block70: {
                                                    block69: {
                                                        int n18;
                                                        block62: {
                                                            block68: {
                                                                int n19;
                                                                block67: {
                                                                    int n20;
                                                                    block66: {
                                                                        block65: {
                                                                            block64: {
                                                                                block63: {
                                                                                    block61: {
                                                                                        roomDatabase = G_TemplateFileDao_Impl.access$000(this.this$0);
                                                                                        object2 = this.val$_statement;
                                                                                        n17 = 0;
                                                                                        charSequence = null;
                                                                                        object = null;
                                                                                        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
                                                                                        object2 = "hash";
                                                                                        try {
                                                                                            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
                                                                                            charSequence = "name";
                                                                                        }
                                                                                        catch (Throwable throwable) {
                                                                                            roomDatabase.close();
                                                                                            throw throwable;
                                                                                        }
                                                                                        n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)charSequence);
                                                                                        String string2 = "category";
                                                                                        n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
                                                                                        String string3 = "mime";
                                                                                        n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
                                                                                        String string4 = "size";
                                                                                        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
                                                                                        String string5 = "url";
                                                                                        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
                                                                                        String string6 = "path";
                                                                                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string6);
                                                                                        String string7 = "download_timestamp";
                                                                                        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string7);
                                                                                        object3 = "ext_lic_url";
                                                                                        n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object3);
                                                                                        String string8 = "ext_lic_name";
                                                                                        n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string8);
                                                                                        String string9 = "ext_lic_path";
                                                                                        n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string9);
                                                                                        boolean bl2 = roomDatabase.moveToFirst();
                                                                                        if (!bl2) break block60;
                                                                                        bl2 = roomDatabase.isNull(n20);
                                                                                        if (!bl2) break block61;
                                                                                        bl2 = roomDatabase.isNull(n18);
                                                                                        if (!bl2) break block61;
                                                                                        bl2 = roomDatabase.isNull(n19);
                                                                                        if (!bl2) break block61;
                                                                                        bl2 = false;
                                                                                        fileExt = null;
                                                                                        break block62;
                                                                                    }
                                                                                    fileExt = new FileExt();
                                                                                    boolean bl3 = roomDatabase.isNull(n20);
                                                                                    if (!bl3) break block63;
                                                                                    n20 = 0;
                                                                                    object3 = null;
                                                                                    break block64;
                                                                                }
                                                                                object3 = roomDatabase.getString(n20);
                                                                            }
                                                                            fileExt.setLicenseUrl((String)object3);
                                                                            n20 = (int)(roomDatabase.isNull(n18) ? 1 : 0);
                                                                            if (n20 == 0) break block65;
                                                                            n20 = 0;
                                                                            object3 = null;
                                                                            break block66;
                                                                        }
                                                                        object3 = roomDatabase.getString(n18);
                                                                    }
                                                                    fileExt.setLicenseName((String)object3);
                                                                    n20 = (int)(roomDatabase.isNull(n19) ? 1 : 0);
                                                                    if (n20 == 0) break block67;
                                                                    n20 = 0;
                                                                    object3 = null;
                                                                    break block68;
                                                                }
                                                                object3 = roomDatabase.getString(n19);
                                                            }
                                                            fileExt.setLicensePath((String)object3);
                                                        }
                                                        object3 = new FileData();
                                                        n18 = (int)(roomDatabase.isNull(n12) ? 1 : 0);
                                                        if (n18 == 0) break block69;
                                                        n12 = 0;
                                                        object2 = null;
                                                        break block70;
                                                    }
                                                    object2 = roomDatabase.getString(n12);
                                                }
                                                ((FileData)object3).setHash((String)object2);
                                                n12 = (int)(roomDatabase.isNull(n17) ? 1 : 0);
                                                if (n12 == 0) break block71;
                                                n12 = 0;
                                                object2 = null;
                                                break block72;
                                            }
                                            object2 = roomDatabase.getString(n17);
                                        }
                                        ((FileData)object3).setName((String)object2);
                                        n12 = (int)(roomDatabase.isNull(n16) ? 1 : 0);
                                        if (n12 == 0) break block73;
                                        n12 = 0;
                                        object2 = null;
                                        break block74;
                                    }
                                    object2 = roomDatabase.getString(n16);
                                }
                                object2 = EditorResourceTypeConverters.stringToType((String)object2);
                                ((FileData)object3).setCategory((EditConfig$ResourceType)object2);
                                n12 = (int)(roomDatabase.isNull(n15) ? 1 : 0);
                                if (n12 == 0) break block75;
                                n12 = 0;
                                object2 = null;
                                break block76;
                            }
                            object2 = roomDatabase.getString(n15);
                        }
                        ((FileData)object3).setType((String)object2);
                        n12 = roomDatabase.getInt(n14);
                        ((FileData)object3).setSize(n12);
                        n12 = (int)(roomDatabase.isNull(n13) ? 1 : 0);
                        if (n12 == 0) break block77;
                        n12 = 0;
                        object2 = null;
                        break block78;
                    }
                    object2 = roomDatabase.getString(n13);
                }
                ((FileData)object3).setUrl((String)object2);
                n12 = (int)(roomDatabase.isNull(n11) ? 1 : 0);
                if (n12 != 0) break block79;
                object = roomDatabase.getString(n11);
            }
            ((FileData)object3).setPath((String)object);
            long l10 = roomDatabase.getLong(n10);
            ((FileData)object3).setDownloadTimestamp(l10);
            ((FileData)object3).setExt(fileExt);
            object = object3;
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

