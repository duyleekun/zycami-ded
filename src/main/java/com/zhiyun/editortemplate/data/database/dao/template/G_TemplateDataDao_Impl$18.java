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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import java.util.concurrent.Callable;

public class G_TemplateDataDao_Impl$18
implements Callable {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDataDao_Impl$18(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * WARNING - void declaration
     */
    public TemplateData call() {
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block131: {
            block99: {
                boolean bl2;
                Object object2;
                Object object3;
                Object object4;
                block130: {
                    int n10;
                    int n11;
                    int n12;
                    Object object5;
                    block129: {
                        int n13;
                        block128: {
                            int n14;
                            block127: {
                                int n15;
                                block126: {
                                    block125: {
                                        int n16;
                                        block124: {
                                            void var8_44;
                                            block123: {
                                                void var8_37;
                                                boolean bl3;
                                                int n17;
                                                int n18;
                                                block122: {
                                                    int n19;
                                                    int n20;
                                                    block121: {
                                                        int n21;
                                                        block120: {
                                                            int n22;
                                                            int n23;
                                                            block119: {
                                                                int n24;
                                                                block118: {
                                                                    block117: {
                                                                        int n25;
                                                                        block116: {
                                                                            block115: {
                                                                                int n26;
                                                                                block114: {
                                                                                    block113: {
                                                                                        int n27;
                                                                                        block112: {
                                                                                            block111: {
                                                                                                block110: {
                                                                                                    int n28;
                                                                                                    block109: {
                                                                                                        int n29;
                                                                                                        int n30;
                                                                                                        int n31;
                                                                                                        int n32;
                                                                                                        int n322;
                                                                                                        block108: {
                                                                                                            block101: {
                                                                                                                block107: {
                                                                                                                    int n33;
                                                                                                                    block106: {
                                                                                                                        block105: {
                                                                                                                            int n34;
                                                                                                                            block104: {
                                                                                                                                block103: {
                                                                                                                                    block102: {
                                                                                                                                        block100: {
                                                                                                                                            String string2;
                                                                                                                                            object4 = this;
                                                                                                                                            object5 = G_TemplateDataDao_Impl.access$000(this.this$0);
                                                                                                                                            roomSQLiteQuery = this.val$_statement;
                                                                                                                                            n322 = 0;
                                                                                                                                            object3 = null;
                                                                                                                                            boolean bl22 = false;
                                                                                                                                            object = null;
                                                                                                                                            roomSQLiteQuery = DBUtil.query((RoomDatabase)object5, roomSQLiteQuery, false, null);
                                                                                                                                            object5 = "id";
                                                                                                                                            try {
                                                                                                                                                n28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
                                                                                                                                                string2 = "title_zh";
                                                                                                                                            }
                                                                                                                                            catch (Throwable throwable) {
                                                                                                                                                roomSQLiteQuery.close();
                                                                                                                                                throw throwable;
                                                                                                                                            }
                                                                                                                                            n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
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
                                                                                                                                            object2 = "video_ratio";
                                                                                                                                            n33 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                                                            String string9 = "res_size";
                                                                                                                                            n32 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                            String string10 = "is_prime_usable";
                                                                                                                                            n31 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                            String string11 = "temp_type";
                                                                                                                                            n30 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                            object3 = "download_finished";
                                                                                                                                            n322 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                            object = "download_timestamp";
                                                                                                                                            int n35 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                                            object4 = "editor_template";
                                                                                                                                            n15 = n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                            object4 = "track_editor_config_data";
                                                                                                                                            n13 = n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                            object4 = "template_use_type";
                                                                                                                                            n12 = n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                            object4 = "template_proto_type";
                                                                                                                                            n11 = n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                            object4 = "first_loaded";
                                                                                                                                            n10 = n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                            object4 = "template_description_zh";
                                                                                                                                            n29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                            n16 = n35;
                                                                                                                                            object = "template_description_en";
                                                                                                                                            n34 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                                            n18 = n322;
                                                                                                                                            object3 = "template_description_zh_tw";
                                                                                                                                            n322 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                            n17 = n30;
                                                                                                                                            string11 = "script_ext_status";
                                                                                                                                            n30 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                            n20 = n31;
                                                                                                                                            string10 = "script_ext_protocol";
                                                                                                                                            n31 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                            n19 = n32;
                                                                                                                                            string9 = "script_ext_version";
                                                                                                                                            n32 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                            n21 = roomSQLiteQuery.moveToFirst();
                                                                                                                                            if (n21 == 0) break block99;
                                                                                                                                            n21 = roomSQLiteQuery.isNull(n29);
                                                                                                                                            if (n21 == 0) break block100;
                                                                                                                                            n21 = roomSQLiteQuery.isNull(n34);
                                                                                                                                            if (n21 == 0) break block100;
                                                                                                                                            n21 = roomSQLiteQuery.isNull(n322);
                                                                                                                                            if (n21 == 0) break block100;
                                                                                                                                            n21 = n33;
                                                                                                                                            n33 = 0;
                                                                                                                                            object2 = null;
                                                                                                                                            break block101;
                                                                                                                                        }
                                                                                                                                        n21 = roomSQLiteQuery.isNull(n29);
                                                                                                                                        if (n21 == 0) break block102;
                                                                                                                                        n29 = 0;
                                                                                                                                        object4 = null;
                                                                                                                                        break block103;
                                                                                                                                    }
                                                                                                                                    object4 = roomSQLiteQuery.getString(n29);
                                                                                                                                }
                                                                                                                                n21 = (int)(roomSQLiteQuery.isNull(n34) ? 1 : 0);
                                                                                                                                if (n21 == 0) break block104;
                                                                                                                                boolean bl4 = false;
                                                                                                                                object = null;
                                                                                                                                break block105;
                                                                                                                            }
                                                                                                                            object = roomSQLiteQuery.getString(n34);
                                                                                                                        }
                                                                                                                        n21 = (int)(roomSQLiteQuery.isNull(n322) ? 1 : 0);
                                                                                                                        if (n21 == 0) break block106;
                                                                                                                        n21 = n33;
                                                                                                                        n322 = 0;
                                                                                                                        object3 = null;
                                                                                                                        break block107;
                                                                                                                    }
                                                                                                                    object3 = roomSQLiteQuery.getString(n322);
                                                                                                                    n21 = n33;
                                                                                                                }
                                                                                                                object2 = new TemplateDescription((String)object4, (String)object, (String)object3);
                                                                                                            }
                                                                                                            n29 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0);
                                                                                                            if (n29 == 0) break block108;
                                                                                                            n29 = (int)(roomSQLiteQuery.isNull(n31) ? 1 : 0);
                                                                                                            if (n29 == 0) break block108;
                                                                                                            n29 = (int)(roomSQLiteQuery.isNull(n32) ? 1 : 0);
                                                                                                            if (n29 == 0) break block108;
                                                                                                            n29 = 0;
                                                                                                            object4 = null;
                                                                                                            break block109;
                                                                                                        }
                                                                                                        n29 = roomSQLiteQuery.getInt(n30);
                                                                                                        n322 = roomSQLiteQuery.getInt(n31);
                                                                                                        int n36 = roomSQLiteQuery.getInt(n32);
                                                                                                        object4 = ScriptDataExt.create(n29, n322, n36);
                                                                                                    }
                                                                                                    object3 = new TemplateData();
                                                                                                    long l10 = roomSQLiteQuery.getLong(n28);
                                                                                                    ((TemplateData)object3).setId(l10);
                                                                                                    boolean bl5 = roomSQLiteQuery.isNull(n14);
                                                                                                    if (!bl5) break block110;
                                                                                                    boolean bl6 = false;
                                                                                                    object5 = null;
                                                                                                    break block111;
                                                                                                }
                                                                                                object5 = roomSQLiteQuery.getString(n14);
                                                                                            }
                                                                                            ((TemplateData)object3).setTextZh((String)object5);
                                                                                            boolean bl7 = roomSQLiteQuery.isNull(n27);
                                                                                            if (!bl7) break block112;
                                                                                            boolean bl8 = false;
                                                                                            object5 = null;
                                                                                            break block113;
                                                                                        }
                                                                                        object5 = roomSQLiteQuery.getString(n27);
                                                                                    }
                                                                                    ((TemplateData)object3).setTextZhTw((String)object5);
                                                                                    boolean bl9 = roomSQLiteQuery.isNull(n26);
                                                                                    if (!bl9) break block114;
                                                                                    boolean bl10 = false;
                                                                                    object5 = null;
                                                                                    break block115;
                                                                                }
                                                                                object5 = roomSQLiteQuery.getString(n26);
                                                                            }
                                                                            ((TemplateData)object3).setTextEn((String)object5);
                                                                            boolean bl11 = roomSQLiteQuery.isNull(n25);
                                                                            if (!bl11) break block116;
                                                                            boolean bl12 = false;
                                                                            object5 = null;
                                                                            break block117;
                                                                        }
                                                                        object5 = roomSQLiteQuery.getString(n25);
                                                                    }
                                                                    ((TemplateData)object3).setCoverUrl((String)object5);
                                                                    boolean bl13 = roomSQLiteQuery.isNull(n24);
                                                                    if (!bl13) break block118;
                                                                    boolean bl14 = false;
                                                                    object5 = null;
                                                                    break block119;
                                                                }
                                                                object5 = roomSQLiteQuery.getString(n24);
                                                            }
                                                            ((TemplateData)object3).setVideoUrl((String)object5);
                                                            double d10 = roomSQLiteQuery.getDouble(n23);
                                                            ((TemplateData)object3).setVideoTime(d10);
                                                            int n37 = roomSQLiteQuery.getInt(n22);
                                                            ((TemplateData)object3).setVideoCount(n37);
                                                            int n38 = n21;
                                                            boolean bl15 = roomSQLiteQuery.isNull(n21);
                                                            if (!bl15) break block120;
                                                            boolean bl16 = false;
                                                            object5 = null;
                                                            break block121;
                                                        }
                                                        object5 = roomSQLiteQuery.getString(n21);
                                                    }
                                                    ((TemplateData)object3).setVideoRatio((String)object5);
                                                    int n40 = n19;
                                                    n40 = roomSQLiteQuery.getInt(n19);
                                                    ((TemplateData)object3).setResSize(n40);
                                                    int n42 = n20;
                                                    n42 = roomSQLiteQuery.getInt(n20);
                                                    bl3 = true;
                                                    if (n42 != 0) {
                                                        boolean bl17 = bl3;
                                                        break block122;
                                                    }
                                                    boolean bl18 = false;
                                                    object5 = null;
                                                }
                                                ((TemplateData)object3).setPrimeUsable((boolean)var8_37);
                                                int n44 = n17;
                                                n44 = roomSQLiteQuery.getInt(n17);
                                                ((TemplateData)object3).setTempType(n44);
                                                int n46 = n18;
                                                n46 = roomSQLiteQuery.getInt(n18);
                                                if (n46 != 0) {
                                                    boolean bl19 = bl3;
                                                    break block123;
                                                }
                                                boolean bl20 = false;
                                                object5 = null;
                                            }
                                            ((TemplateData)object3).setDownloadFinished((boolean)var8_44);
                                            int n47 = n16;
                                            n14 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                                            if (n14 == 0) break block124;
                                            boolean bl21 = false;
                                            object5 = null;
                                            break block125;
                                        }
                                        long l11 = roomSQLiteQuery.getLong(n16);
                                        object5 = l11;
                                    }
                                    ((TemplateData)object3).setDownloadTimestamp((Long)object5);
                                    int n48 = n15;
                                    n14 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                    if (n14 == 0) break block126;
                                    boolean bl22 = false;
                                    object5 = null;
                                    break block127;
                                }
                                object5 = roomSQLiteQuery.getString(n15);
                            }
                            ((TemplateData)object3).setEditorTemplate((String)object5);
                            int n49 = n13;
                            n14 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                            if (n14 == 0) break block128;
                            boolean bl23 = false;
                            object5 = null;
                            break block129;
                        }
                        object5 = roomSQLiteQuery.getString(n13);
                    }
                    ((TemplateData)object3).setTrackEditorConfigData((String)object5);
                    int n51 = n12;
                    n51 = roomSQLiteQuery.getInt(n12);
                    ((TemplateData)object3).setTemplateUseType(n51);
                    int n53 = n11;
                    n53 = roomSQLiteQuery.getInt(n11);
                    ((TemplateData)object3).setTemplateProtocolType(n53);
                    int n55 = n10;
                    n55 = roomSQLiteQuery.getInt(n10);
                    if (n55 != 0) break block130;
                    bl2 = false;
                    object = null;
                }
                ((TemplateData)object3).setFirstLoaded(bl2);
                ((TemplateData)object3).setTemplateDescription((TemplateDescription)object2);
                ((TemplateData)object3).setScriptDataExt((ScriptDataExt)object4);
                object = object3;
                break block131;
            }
            boolean bl24 = false;
            object = null;
        }
        roomSQLiteQuery.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

