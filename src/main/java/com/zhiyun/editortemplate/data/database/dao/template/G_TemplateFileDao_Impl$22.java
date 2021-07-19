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
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import java.util.concurrent.Callable;

public class G_TemplateFileDao_Impl$22
implements Callable {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateFileDao_Impl$22(G_TemplateFileDao_Impl g_TemplateFileDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateFileDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public FileData call() {
        Object object;
        RoomDatabase roomDatabase;
        block52: {
            FileExt fileExt;
            Object object2;
            int n10;
            block71: {
                int n11;
                int n12;
                Object object3;
                block70: {
                    int n13;
                    block69: {
                        int n14;
                        block68: {
                            int n15;
                            block67: {
                                block66: {
                                    int n16;
                                    block65: {
                                        block64: {
                                            int n17;
                                            block63: {
                                                block62: {
                                                    block61: {
                                                        int n18;
                                                        block54: {
                                                            block60: {
                                                                int n19;
                                                                block59: {
                                                                    int n20;
                                                                    block58: {
                                                                        block57: {
                                                                            block56: {
                                                                                block55: {
                                                                                    block53: {
                                                                                        roomDatabase = G_TemplateFileDao_Impl.access$000(this.this$0);
                                                                                        object3 = this.val$_statement;
                                                                                        n17 = 0;
                                                                                        String string2 = null;
                                                                                        object = null;
                                                                                        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object3, false, null);
                                                                                        object3 = "hash";
                                                                                        try {
                                                                                            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object3);
                                                                                            string2 = "name";
                                                                                        }
                                                                                        catch (Throwable throwable) {
                                                                                            roomDatabase.close();
                                                                                            throw throwable;
                                                                                        }
                                                                                        n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
                                                                                        String string3 = "category";
                                                                                        n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
                                                                                        String string4 = "mime";
                                                                                        n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
                                                                                        String string5 = "size";
                                                                                        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string5);
                                                                                        String string6 = "url";
                                                                                        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string6);
                                                                                        String string7 = "path";
                                                                                        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string7);
                                                                                        String string8 = "download_timestamp";
                                                                                        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string8);
                                                                                        object2 = "ext_lic_url";
                                                                                        n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
                                                                                        String string9 = "ext_lic_name";
                                                                                        n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string9);
                                                                                        String string10 = "ext_lic_path";
                                                                                        n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string10);
                                                                                        boolean bl2 = roomDatabase.moveToFirst();
                                                                                        if (!bl2) break block52;
                                                                                        bl2 = roomDatabase.isNull(n20);
                                                                                        if (!bl2) break block53;
                                                                                        bl2 = roomDatabase.isNull(n18);
                                                                                        if (!bl2) break block53;
                                                                                        bl2 = roomDatabase.isNull(n19);
                                                                                        if (!bl2) break block53;
                                                                                        bl2 = false;
                                                                                        fileExt = null;
                                                                                        break block54;
                                                                                    }
                                                                                    fileExt = new FileExt();
                                                                                    boolean bl3 = roomDatabase.isNull(n20);
                                                                                    if (!bl3) break block55;
                                                                                    n20 = 0;
                                                                                    object2 = null;
                                                                                    break block56;
                                                                                }
                                                                                object2 = roomDatabase.getString(n20);
                                                                            }
                                                                            fileExt.setLicenseUrl((String)object2);
                                                                            n20 = (int)(roomDatabase.isNull(n18) ? 1 : 0);
                                                                            if (n20 == 0) break block57;
                                                                            n20 = 0;
                                                                            object2 = null;
                                                                            break block58;
                                                                        }
                                                                        object2 = roomDatabase.getString(n18);
                                                                    }
                                                                    fileExt.setLicenseName((String)object2);
                                                                    n20 = (int)(roomDatabase.isNull(n19) ? 1 : 0);
                                                                    if (n20 == 0) break block59;
                                                                    n20 = 0;
                                                                    object2 = null;
                                                                    break block60;
                                                                }
                                                                object2 = roomDatabase.getString(n19);
                                                            }
                                                            fileExt.setLicensePath((String)object2);
                                                        }
                                                        object2 = new FileData();
                                                        n18 = (int)(roomDatabase.isNull(n12) ? 1 : 0);
                                                        if (n18 == 0) break block61;
                                                        n12 = 0;
                                                        object3 = null;
                                                        break block62;
                                                    }
                                                    object3 = roomDatabase.getString(n12);
                                                }
                                                ((FileData)object2).setHash((String)object3);
                                                n12 = (int)(roomDatabase.isNull(n17) ? 1 : 0);
                                                if (n12 == 0) break block63;
                                                n12 = 0;
                                                object3 = null;
                                                break block64;
                                            }
                                            object3 = roomDatabase.getString(n17);
                                        }
                                        ((FileData)object2).setName((String)object3);
                                        n12 = (int)(roomDatabase.isNull(n16) ? 1 : 0);
                                        if (n12 == 0) break block65;
                                        n12 = 0;
                                        object3 = null;
                                        break block66;
                                    }
                                    object3 = roomDatabase.getString(n16);
                                }
                                object3 = EditorResourceTypeConverters.stringToType((String)object3);
                                ((FileData)object2).setCategory((EditConfig$ResourceType)object3);
                                n12 = (int)(roomDatabase.isNull(n15) ? 1 : 0);
                                if (n12 == 0) break block67;
                                n12 = 0;
                                object3 = null;
                                break block68;
                            }
                            object3 = roomDatabase.getString(n15);
                        }
                        ((FileData)object2).setType((String)object3);
                        n12 = roomDatabase.getInt(n14);
                        ((FileData)object2).setSize(n12);
                        n12 = (int)(roomDatabase.isNull(n13) ? 1 : 0);
                        if (n12 == 0) break block69;
                        n12 = 0;
                        object3 = null;
                        break block70;
                    }
                    object3 = roomDatabase.getString(n13);
                }
                ((FileData)object2).setUrl((String)object3);
                n12 = (int)(roomDatabase.isNull(n11) ? 1 : 0);
                if (n12 != 0) break block71;
                object = roomDatabase.getString(n11);
            }
            ((FileData)object2).setPath((String)object);
            long l10 = roomDatabase.getLong(n10);
            ((FileData)object2).setDownloadTimestamp(l10);
            ((FileData)object2).setExt(fileExt);
            object = object2;
        }
        roomDatabase.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

