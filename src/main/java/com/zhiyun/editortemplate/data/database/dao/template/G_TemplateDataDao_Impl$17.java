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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import java.util.concurrent.Callable;

public class G_TemplateDataDao_Impl$17
implements Callable {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDataDao_Impl$17(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Could not resolve type clashes
     */
    public TemplateData call() {
        void var2_6;
        RoomSQLiteQuery roomSQLiteQuery;
        block143: {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            block142: {
                boolean bl22;
                block110: {
                    Object object5;
                    block141: {
                        int n10;
                        int n11;
                        int n12;
                        int n13;
                        block140: {
                            int n14;
                            block139: {
                                int n15;
                                block138: {
                                    int n16;
                                    block137: {
                                        block136: {
                                            boolean bl3;
                                            block135: {
                                                block134: {
                                                    int n17;
                                                    int n18;
                                                    block133: {
                                                        int n19;
                                                        int n20;
                                                        block132: {
                                                            int n21;
                                                            block131: {
                                                                int n22;
                                                                int n23;
                                                                block130: {
                                                                    int n24;
                                                                    block129: {
                                                                        block128: {
                                                                            int n25;
                                                                            block127: {
                                                                                block126: {
                                                                                    int n26;
                                                                                    block125: {
                                                                                        block124: {
                                                                                            int n27;
                                                                                            block123: {
                                                                                                block122: {
                                                                                                    block121: {
                                                                                                        block120: {
                                                                                                            int n28;
                                                                                                            int n29;
                                                                                                            int n30;
                                                                                                            int n31;
                                                                                                            int n322;
                                                                                                            block119: {
                                                                                                                block112: {
                                                                                                                    block118: {
                                                                                                                        int n33;
                                                                                                                        block117: {
                                                                                                                            block116: {
                                                                                                                                block115: {
                                                                                                                                    block114: {
                                                                                                                                        block113: {
                                                                                                                                            block111: {
                                                                                                                                                object4 = this;
                                                                                                                                                object3 = G_TemplateDataDao_Impl.access$000(this.this$0);
                                                                                                                                                roomSQLiteQuery = this.val$_statement;
                                                                                                                                                n322 = 0;
                                                                                                                                                object2 = null;
                                                                                                                                                bl22 = false;
                                                                                                                                                object = null;
                                                                                                                                                roomSQLiteQuery = DBUtil.query((RoomDatabase)object3, roomSQLiteQuery, false, null);
                                                                                                                                                object3 = "id";
                                                                                                                                                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                String string2 = "title_zh";
                                                                                                                                                n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                                                                String string3 = "title_tw";
                                                                                                                                                n27 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                                                                                                                                                String string4 = "title_en";
                                                                                                                                                n26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                                                                                                                                                String string5 = "cover_url";
                                                                                                                                                n25 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                                                                                                                                                String string6 = "video_url";
                                                                                                                                                n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                                                                                                                                                String string7 = "video_time";
                                                                                                                                                n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                                                                                                                                                String string8 = "video_count";
                                                                                                                                                n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                                                                                                                                                object5 = "video_ratio";
                                                                                                                                                n33 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
                                                                                                                                                String string9 = "res_size";
                                                                                                                                                n31 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                                String string10 = "is_prime_usable";
                                                                                                                                                n30 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                                String string11 = "temp_type";
                                                                                                                                                n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                                object2 = "download_finished";
                                                                                                                                                n322 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                                                                object = "download_timestamp";
                                                                                                                                                bl22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                                                object4 = "editor_template";
                                                                                                                                                n16 = n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                object4 = "track_editor_config_data";
                                                                                                                                                n14 = n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                object4 = "template_use_type";
                                                                                                                                                n12 = n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                object4 = "template_proto_type";
                                                                                                                                                n11 = n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                object4 = "first_loaded";
                                                                                                                                                n10 = n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                object4 = "template_description_zh";
                                                                                                                                                n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                bl3 = bl22;
                                                                                                                                                object = "template_description_en";
                                                                                                                                                bl22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                                                n18 = n322;
                                                                                                                                                object2 = "template_description_zh_tw";
                                                                                                                                                n322 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                                                                n17 = n29;
                                                                                                                                                string11 = "script_ext_status";
                                                                                                                                                n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                                n20 = n30;
                                                                                                                                                string10 = "script_ext_protocol";
                                                                                                                                                n30 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                                n19 = n31;
                                                                                                                                                string9 = "script_ext_version";
                                                                                                                                                n31 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                                n21 = roomSQLiteQuery.moveToFirst();
                                                                                                                                                if (n21 == 0) break block110;
                                                                                                                                                n21 = roomSQLiteQuery.isNull(n28);
                                                                                                                                                if (n21 == 0) break block111;
                                                                                                                                                n21 = roomSQLiteQuery.isNull((int)(bl22 ? 1 : 0));
                                                                                                                                                if (n21 == 0) break block111;
                                                                                                                                                n21 = roomSQLiteQuery.isNull(n322);
                                                                                                                                                if (n21 == 0) break block111;
                                                                                                                                                n21 = n33;
                                                                                                                                                n33 = 0;
                                                                                                                                                object5 = null;
                                                                                                                                                break block112;
                                                                                                                                            }
                                                                                                                                            n21 = roomSQLiteQuery.isNull(n28);
                                                                                                                                            if (n21 == 0) break block113;
                                                                                                                                            n28 = 0;
                                                                                                                                            object4 = null;
                                                                                                                                            break block114;
                                                                                                                                        }
                                                                                                                                        object4 = roomSQLiteQuery.getString(n28);
                                                                                                                                    }
                                                                                                                                    n21 = (int)(roomSQLiteQuery.isNull((int)(bl22 ? 1 : 0)) ? 1 : 0);
                                                                                                                                    if (n21 == 0) break block115;
                                                                                                                                    bl22 = false;
                                                                                                                                    object = null;
                                                                                                                                    break block116;
                                                                                                                                }
                                                                                                                                object = roomSQLiteQuery.getString((int)(bl22 ? 1 : 0));
                                                                                                                            }
                                                                                                                            n21 = (int)(roomSQLiteQuery.isNull(n322) ? 1 : 0);
                                                                                                                            if (n21 == 0) break block117;
                                                                                                                            n21 = n33;
                                                                                                                            n322 = 0;
                                                                                                                            object2 = null;
                                                                                                                            break block118;
                                                                                                                        }
                                                                                                                        object2 = roomSQLiteQuery.getString(n322);
                                                                                                                        n21 = n33;
                                                                                                                    }
                                                                                                                    object5 = new TemplateDescription((String)object4, (String)object, (String)object2);
                                                                                                                }
                                                                                                                n28 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0);
                                                                                                                if (n28 == 0) break block119;
                                                                                                                n28 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0);
                                                                                                                if (n28 == 0) break block119;
                                                                                                                n28 = (int)(roomSQLiteQuery.isNull(n31) ? 1 : 0);
                                                                                                                if (n28 == 0) break block119;
                                                                                                                n28 = 0;
                                                                                                                object4 = null;
                                                                                                                break block120;
                                                                                                            }
                                                                                                            n28 = roomSQLiteQuery.getInt(n29);
                                                                                                            n322 = roomSQLiteQuery.getInt(n30);
                                                                                                            bl22 = roomSQLiteQuery.getInt(n31);
                                                                                                            object4 = ScriptDataExt.create(n28, n322, (int)(bl22 ? 1 : 0));
                                                                                                        }
                                                                                                        object2 = new TemplateData();
                                                                                                        long l10 = roomSQLiteQuery.getLong(n13);
                                                                                                        ((TemplateData)object2).setId(l10);
                                                                                                        n13 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                                                                                        if (n13 == 0) break block121;
                                                                                                        n13 = 0;
                                                                                                        object3 = null;
                                                                                                        break block122;
                                                                                                    }
                                                                                                    object3 = roomSQLiteQuery.getString(n15);
                                                                                                }
                                                                                                ((TemplateData)object2).setTextZh((String)object3);
                                                                                                n13 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0);
                                                                                                if (n13 == 0) break block123;
                                                                                                n13 = 0;
                                                                                                object3 = null;
                                                                                                break block124;
                                                                                            }
                                                                                            object3 = roomSQLiteQuery.getString(n27);
                                                                                        }
                                                                                        ((TemplateData)object2).setTextZhTw((String)object3);
                                                                                        n13 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0);
                                                                                        if (n13 == 0) break block125;
                                                                                        n13 = 0;
                                                                                        object3 = null;
                                                                                        break block126;
                                                                                    }
                                                                                    object3 = roomSQLiteQuery.getString(n26);
                                                                                }
                                                                                ((TemplateData)object2).setTextEn((String)object3);
                                                                                n13 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0);
                                                                                if (n13 == 0) break block127;
                                                                                n13 = 0;
                                                                                object3 = null;
                                                                                break block128;
                                                                            }
                                                                            object3 = roomSQLiteQuery.getString(n25);
                                                                        }
                                                                        ((TemplateData)object2).setCoverUrl((String)object3);
                                                                        n13 = (int)(roomSQLiteQuery.isNull(n24) ? 1 : 0);
                                                                        if (n13 == 0) break block129;
                                                                        n13 = 0;
                                                                        object3 = null;
                                                                        break block130;
                                                                    }
                                                                    object3 = roomSQLiteQuery.getString(n24);
                                                                }
                                                                ((TemplateData)object2).setVideoUrl((String)object3);
                                                                double d10 = roomSQLiteQuery.getDouble(n23);
                                                                ((TemplateData)object2).setVideoTime(d10);
                                                                n13 = roomSQLiteQuery.getInt(n22);
                                                                ((TemplateData)object2).setVideoCount(n13);
                                                                n13 = n21;
                                                                bl22 = roomSQLiteQuery.isNull(n21);
                                                                if (!bl22) break block131;
                                                                n13 = 0;
                                                                object3 = null;
                                                                break block132;
                                                            }
                                                            object3 = roomSQLiteQuery.getString(n21);
                                                        }
                                                        ((TemplateData)object2).setVideoRatio((String)object3);
                                                        n13 = n19;
                                                        n13 = roomSQLiteQuery.getInt(n19);
                                                        ((TemplateData)object2).setResSize(n13);
                                                        n13 = n20;
                                                        n13 = roomSQLiteQuery.getInt(n20);
                                                        bl22 = true;
                                                        if (n13 != 0) {
                                                            n13 = bl22;
                                                            break block133;
                                                        }
                                                        n13 = 0;
                                                        object3 = null;
                                                    }
                                                    ((TemplateData)object2).setPrimeUsable(n13 != 0);
                                                    n13 = n17;
                                                    n13 = roomSQLiteQuery.getInt(n17);
                                                    ((TemplateData)object2).setTempType(n13);
                                                    n13 = n18;
                                                    n13 = roomSQLiteQuery.getInt(n18);
                                                    if (n13 != 0) {
                                                        n13 = bl22;
                                                        break block134;
                                                    }
                                                    n13 = 0;
                                                    object3 = null;
                                                }
                                                ((TemplateData)object2).setDownloadFinished(n13 != 0);
                                                n13 = bl3;
                                                n15 = (int)(roomSQLiteQuery.isNull((int)(bl3 ? 1 : 0)) ? 1 : 0);
                                                if (n15 == 0) break block135;
                                                n13 = 0;
                                                object3 = null;
                                                break block136;
                                            }
                                            long l11 = roomSQLiteQuery.getLong((int)(bl3 ? 1 : 0));
                                            object3 = l11;
                                        }
                                        ((TemplateData)object2).setDownloadTimestamp((Long)object3);
                                        n13 = n16;
                                        n15 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                                        if (n15 == 0) break block137;
                                        n13 = 0;
                                        object3 = null;
                                        break block138;
                                    }
                                    object3 = roomSQLiteQuery.getString(n16);
                                }
                                ((TemplateData)object2).setEditorTemplate((String)object3);
                                n13 = n14;
                                n15 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                                if (n15 == 0) break block139;
                                n13 = 0;
                                object3 = null;
                                break block140;
                            }
                            object3 = roomSQLiteQuery.getString(n14);
                        }
                        ((TemplateData)object2).setTrackEditorConfigData((String)object3);
                        n13 = n12;
                        n13 = roomSQLiteQuery.getInt(n12);
                        ((TemplateData)object2).setTemplateUseType(n13);
                        n13 = n11;
                        n13 = roomSQLiteQuery.getInt(n11);
                        ((TemplateData)object2).setTemplateProtocolType(n13);
                        n13 = n10;
                        n13 = roomSQLiteQuery.getInt(n10);
                        if (n13 != 0) break block141;
                        bl22 = false;
                        object = null;
                    }
                    ((TemplateData)object2).setFirstLoaded(bl22);
                    ((TemplateData)object2).setTemplateDescription((TemplateDescription)object5);
                    ((TemplateData)object2).setScriptDataExt((ScriptDataExt)object4);
                    object = object2;
                    break block142;
                }
                bl22 = false;
                object = null;
            }
            if (object != null) {
                roomSQLiteQuery.close();
                return object;
            }
            object4 = new StringBuilder();
            object2 = "Query returned empty result set: ";
            ((StringBuilder)object4).append((String)object2);
            object2 = this;
            try {
                object = this.val$_statement;
            }
            catch (Throwable throwable) {}
            object = ((RoomSQLiteQuery)object).getSql();
            ((StringBuilder)object4).append((String)object);
            object4 = ((StringBuilder)object4).toString();
            object3 = new EmptyResultSetException((String)object4);
            throw object3;
            break block143;
            catch (Throwable throwable) {
                object2 = this;
            }
            break block143;
            catch (Throwable throwable) {
                object2 = object4;
            }
        }
        roomSQLiteQuery.close();
        throw var2_6;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

