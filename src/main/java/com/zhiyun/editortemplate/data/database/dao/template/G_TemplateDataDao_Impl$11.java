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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateDataDao_Impl$11
implements Callable {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDataDao_Impl$11(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        Object object2 = G_TemplateDataDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        boolean bl2 = false;
        Object object3 = null;
        boolean bl3 = false;
        Object object4 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            boolean bl4;
            boolean bl5 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            String string2 = "title_zh";
            boolean bl6 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "title_tw";
            int n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "title_en";
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "cover_url";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "video_url";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "video_time";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "video_count";
            boolean bl7 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            ArrayList<Object> arrayList = "video_ratio";
            boolean bl8 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            String string9 = "res_size";
            boolean bl9 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "is_prime_usable";
            boolean bl10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "temp_type";
            boolean bl11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            object3 = "download_finished";
            bl2 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
            object4 = "download_timestamp";
            boolean bl12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
            object = "editor_template";
            boolean bl13 = bl4 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "track_editor_config_data";
            boolean bl14 = bl4 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "template_use_type";
            boolean bl15 = bl4 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "template_proto_type";
            boolean bl16 = bl4 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "first_loaded";
            boolean bl17 = bl4 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "template_description_zh";
            bl4 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            boolean bl18 = bl12;
            object4 = "template_description_en";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
            boolean bl19 = bl2;
            object3 = "template_description_zh_tw";
            bl2 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
            boolean bl20 = bl11;
            string11 = "script_ext_status";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            boolean bl21 = bl10;
            string10 = "script_ext_protocol";
            bl10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            boolean bl22 = bl9;
            string9 = "script_ext_version";
            bl9 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            boolean bl23 = bl8;
            boolean bl24 = bl7;
            bl7 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>((int)(bl7 ? 1 : 0));
            while (bl7 = (boolean)roomSQLiteQuery.moveToNext()) {
                String string12;
                boolean bl25;
                boolean bl26;
                boolean bl27;
                boolean bl28;
                boolean bl29;
                bl7 = roomSQLiteQuery.isNull((int)(bl4 ? 1 : 0));
                if (bl7 && (bl7 = (boolean)roomSQLiteQuery.isNull((int)(bl29 ? 1 : 0))) && (bl7 = (boolean)roomSQLiteQuery.isNull((int)(bl2 ? 1 : 0)))) {
                    bl28 = bl4;
                    bl27 = bl2;
                    bl26 = bl29;
                    bl29 = false;
                    object4 = null;
                } else {
                    String string13;
                    bl7 = roomSQLiteQuery.isNull((int)(bl4 ? 1 : 0));
                    if (bl7) {
                        bl7 = false;
                        string8 = null;
                    } else {
                        string8 = roomSQLiteQuery.getString((int)(bl4 ? 1 : 0));
                    }
                    bl26 = roomSQLiteQuery.isNull((int)(bl29 ? 1 : 0));
                    if (bl26) {
                        bl28 = bl4;
                        bl4 = false;
                        object = null;
                    } else {
                        string13 = roomSQLiteQuery.getString((int)(bl29 ? 1 : 0));
                        bl28 = bl4;
                        object = string13;
                    }
                    bl26 = roomSQLiteQuery.isNull((int)(bl2 ? 1 : 0));
                    if (bl26) {
                        bl27 = bl2;
                        bl26 = bl29;
                        bl2 = false;
                        object3 = null;
                    } else {
                        string13 = roomSQLiteQuery.getString((int)(bl2 ? 1 : 0));
                        bl27 = bl2;
                        object3 = string13;
                        bl26 = bl29;
                    }
                    object4 = new TemplateDescription(string8, (String)object, (String)object3);
                }
                bl4 = roomSQLiteQuery.isNull(n16);
                if (bl4 && (bl4 = (boolean)roomSQLiteQuery.isNull((int)(bl10 ? 1 : 0))) && (bl4 = (boolean)roomSQLiteQuery.isNull((int)(bl9 ? 1 : 0)))) {
                    bl4 = false;
                    object = null;
                } else {
                    bl4 = roomSQLiteQuery.getInt(n16);
                    bl2 = roomSQLiteQuery.getInt((int)(bl10 ? 1 : 0));
                    bl7 = roomSQLiteQuery.getInt((int)(bl9 ? 1 : 0));
                    object = ScriptDataExt.create((int)(bl4 ? 1 : 0), (int)(bl2 ? 1 : 0), (int)(bl7 ? 1 : 0));
                }
                object3 = new TemplateData();
                boolean bl30 = bl9;
                bl7 = bl10;
                long l10 = roomSQLiteQuery.getLong((int)(bl5 ? 1 : 0));
                ((TemplateData)object3).setId(l10);
                bl9 = roomSQLiteQuery.isNull((int)(bl6 ? 1 : 0));
                if (bl9) {
                    bl9 = false;
                    string9 = null;
                } else {
                    string9 = roomSQLiteQuery.getString((int)(bl6 ? 1 : 0));
                }
                ((TemplateData)object3).setTextZh(string9);
                bl9 = roomSQLiteQuery.isNull(n10);
                if (bl9) {
                    bl9 = false;
                    string9 = null;
                } else {
                    string9 = roomSQLiteQuery.getString(n10);
                }
                ((TemplateData)object3).setTextZhTw(string9);
                bl9 = roomSQLiteQuery.isNull(n11);
                if (bl9) {
                    bl9 = false;
                    string9 = null;
                } else {
                    string9 = roomSQLiteQuery.getString(n11);
                }
                ((TemplateData)object3).setTextEn(string9);
                bl9 = roomSQLiteQuery.isNull(n12);
                if (bl9) {
                    bl9 = false;
                    string9 = null;
                } else {
                    string9 = roomSQLiteQuery.getString(n12);
                }
                ((TemplateData)object3).setCoverUrl(string9);
                bl9 = roomSQLiteQuery.isNull(n13);
                if (bl9) {
                    bl9 = false;
                    string9 = null;
                } else {
                    string9 = roomSQLiteQuery.getString(n13);
                }
                ((TemplateData)object3).setVideoUrl(string9);
                double d10 = roomSQLiteQuery.getDouble(n14);
                ((TemplateData)object3).setVideoTime(d10);
                bl9 = bl24;
                bl10 = roomSQLiteQuery.getInt((int)(bl24 ? 1 : 0));
                ((TemplateData)object3).setVideoCount((int)(bl10 ? 1 : 0));
                bl10 = bl23;
                bl23 = roomSQLiteQuery.isNull((int)(bl23 ? 1 : 0));
                if (bl23) {
                    bl24 = bl5;
                    bl5 = false;
                    object2 = null;
                } else {
                    String string14 = roomSQLiteQuery.getString((int)(bl10 ? 1 : 0));
                    bl24 = bl5;
                    object2 = string14;
                }
                ((TemplateData)object3).setVideoRatio((String)object2);
                bl5 = bl22;
                bl22 = bl6;
                bl6 = roomSQLiteQuery.getInt((int)(bl5 ? 1 : 0));
                ((TemplateData)object3).setResSize((int)(bl6 ? 1 : 0));
                bl6 = bl21;
                bl21 = roomSQLiteQuery.getInt((int)(bl21 ? 1 : 0));
                bl23 = true;
                if (bl21) {
                    bl21 = bl5;
                    bl5 = bl23;
                } else {
                    bl21 = bl5;
                    bl5 = false;
                    object2 = null;
                }
                ((TemplateData)object3).setPrimeUsable(bl5);
                bl5 = bl20;
                bl20 = bl6;
                bl6 = roomSQLiteQuery.getInt((int)(bl5 ? 1 : 0));
                ((TemplateData)object3).setTempType((int)(bl6 ? 1 : 0));
                bl6 = bl19;
                bl19 = roomSQLiteQuery.getInt((int)(bl19 ? 1 : 0));
                if (bl19) {
                    bl19 = bl5;
                    bl5 = bl23;
                } else {
                    bl19 = bl5;
                    bl5 = false;
                    object2 = null;
                }
                ((TemplateData)object3).setDownloadFinished(bl5);
                bl5 = bl18;
                bl18 = roomSQLiteQuery.isNull((int)(bl18 ? 1 : 0));
                if (bl18) {
                    bl25 = bl5;
                    bl5 = false;
                    object2 = null;
                } else {
                    long l11 = roomSQLiteQuery.getLong((int)(bl5 ? 1 : 0));
                    Long l12 = l11;
                    bl25 = bl5;
                    object2 = l12;
                }
                ((TemplateData)object3).setDownloadTimestamp((Long)object2);
                bl5 = bl13;
                bl13 = roomSQLiteQuery.isNull((int)(bl13 ? 1 : 0));
                if (bl13) {
                    bl18 = bl5;
                    bl5 = false;
                    object2 = null;
                } else {
                    string12 = roomSQLiteQuery.getString((int)(bl5 ? 1 : 0));
                    bl18 = bl5;
                    object2 = string12;
                }
                ((TemplateData)object3).setEditorTemplate((String)object2);
                bl5 = bl14;
                bl13 = roomSQLiteQuery.isNull((int)(bl14 ? 1 : 0));
                if (bl13) {
                    bl5 = false;
                    object2 = null;
                } else {
                    string12 = roomSQLiteQuery.getString((int)(bl14 ? 1 : 0));
                    object2 = string12;
                }
                ((TemplateData)object3).setTrackEditorConfigData((String)object2);
                bl13 = bl6;
                bl5 = bl15;
                bl6 = roomSQLiteQuery.getInt((int)(bl15 ? 1 : 0));
                ((TemplateData)object3).setTemplateUseType((int)(bl6 ? 1 : 0));
                bl6 = bl16;
                bl5 = roomSQLiteQuery.getInt((int)(bl16 ? 1 : 0));
                ((TemplateData)object3).setTemplateProtocolType((int)(bl5 ? 1 : 0));
                bl5 = bl17;
                bl16 = roomSQLiteQuery.getInt((int)(bl17 ? 1 : 0));
                if (bl16) {
                    bl5 = bl23;
                } else {
                    bl5 = false;
                    object2 = null;
                }
                ((TemplateData)object3).setFirstLoaded(bl5);
                ((TemplateData)object3).setTemplateDescription((TemplateDescription)object4);
                ((TemplateData)object3).setScriptDataExt((ScriptDataExt)object);
                arrayList.add(object3);
                bl16 = bl6;
                bl23 = bl10;
                bl6 = bl22;
                bl5 = bl24;
                bl29 = bl26;
                bl4 = bl28;
                bl2 = bl27;
                bl10 = bl7;
                bl24 = bl9;
                bl22 = bl21;
                bl9 = bl30;
                bl21 = bl20;
                bl20 = bl19;
                bl19 = bl13;
                bl13 = bl18;
                bl18 = bl25;
            }
            return arrayList;
        }
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

