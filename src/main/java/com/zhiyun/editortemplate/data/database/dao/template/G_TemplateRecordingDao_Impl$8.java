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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateRecordingDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateRecordingDao_Impl$8
implements Callable {
    public final /* synthetic */ G_TemplateRecordingDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateRecordingDao_Impl$8(G_TemplateRecordingDao_Impl g_TemplateRecordingDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateRecordingDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        Object object2 = G_TemplateRecordingDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        int n11 = 0;
        String string3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            String string4 = "temp_id";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "name";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "title";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "attach_time";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "start_time";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "end_time";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "timebase";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "volume";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            String string12 = "mute";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
            String string13 = "local_source";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
            ArrayList<Object> arrayList = "customer_uuid";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            string2 = "fade_in_start_time";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            string3 = "fade_in_end_time";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            object = "fade_in_start_volume";
            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            int n25 = n23;
            arrayList = "fade_in_end_volume";
            int n26 = n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "fade_out_start_time";
            int n27 = n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "fade_out_end_time";
            int n28 = n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "fade_out_start_volume";
            int n29 = n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "fade_out_end_volume";
            int n30 = n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            int n31 = n24;
            n24 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n24);
            while ((n24 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                int n32;
                TemplateAudioTransition templateAudioTransition;
                TemplateAudioTransition templateAudioTransition2;
                int n33;
                int n34;
                int n35;
                float f10;
                long l10;
                long l11;
                long l12;
                long l13;
                Object object3;
                Object object4;
                long l14;
                long l15;
                block14: {
                    TemplateAudioTransition templateAudioTransition3;
                    float f11;
                    block13: {
                        block12: {
                            block11: {
                                block10: {
                                    block9: {
                                        TemplateAudioTransition templateAudioTransition4;
                                        block8: {
                                            block7: {
                                                block6: {
                                                    l15 = roomSQLiteQuery.getLong(n12);
                                                    l14 = roomSQLiteQuery.getLong(n13);
                                                    n24 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                                                    object4 = n24 != 0 ? null : (object = roomSQLiteQuery.getString(n14));
                                                    n24 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                                    object3 = n24 != 0 ? null : (object = roomSQLiteQuery.getString(n15));
                                                    l13 = roomSQLiteQuery.getLong(n16);
                                                    l12 = roomSQLiteQuery.getLong(n17);
                                                    l11 = roomSQLiteQuery.getLong(n18);
                                                    l10 = roomSQLiteQuery.getLong(n19);
                                                    f10 = roomSQLiteQuery.getFloat(n20);
                                                    n24 = roomSQLiteQuery.getInt(n21);
                                                    n35 = 1;
                                                    n34 = n24 != 0 ? n35 : 0;
                                                    n24 = roomSQLiteQuery.getInt(n22);
                                                    n33 = n24 != 0 ? n35 : 0;
                                                    n24 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                                                    if (n24 == 0 || (n24 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0)) == 0) break block6;
                                                    n24 = n31;
                                                    if ((n31 = (int)(roomSQLiteQuery.isNull(n31) ? 1 : 0)) == 0) break block7;
                                                    n31 = n12;
                                                    n12 = n26;
                                                    if ((n26 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0)) == 0) break block8;
                                                    n26 = n12;
                                                    n12 = n27;
                                                    templateAudioTransition2 = null;
                                                    break block9;
                                                }
                                                n24 = n31;
                                            }
                                            n31 = n12;
                                            n12 = n26;
                                        }
                                        long l16 = roomSQLiteQuery.getLong(n10);
                                        long l17 = roomSQLiteQuery.getLong(n11);
                                        float f12 = roomSQLiteQuery.getFloat(n24);
                                        f11 = roomSQLiteQuery.getFloat(n12);
                                        templateAudioTransition2 = templateAudioTransition4;
                                        templateAudioTransition4 = new TemplateAudioTransition(l16, l17, f12, f11);
                                        n26 = n12;
                                        n12 = n27;
                                    }
                                    n27 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                                    if (n27 == 0) break block10;
                                    n27 = n24;
                                    n24 = n28;
                                    if ((n28 = (int)(roomSQLiteQuery.isNull(n28) ? 1 : 0)) == 0) break block11;
                                    n28 = n10;
                                    n10 = n29;
                                    if ((n29 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0)) == 0) break block12;
                                    n29 = n11;
                                    n11 = n30;
                                    if ((n30 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0)) == 0) break block13;
                                    n30 = n12;
                                    templateAudioTransition = null;
                                    break block14;
                                }
                                n27 = n24;
                                n24 = n28;
                            }
                            n28 = n10;
                            n10 = n29;
                        }
                        n29 = n11;
                        n11 = n30;
                    }
                    long l18 = roomSQLiteQuery.getLong(n12);
                    long l19 = roomSQLiteQuery.getLong(n24);
                    f11 = roomSQLiteQuery.getFloat(n10);
                    float f13 = roomSQLiteQuery.getFloat(n11);
                    templateAudioTransition = templateAudioTransition3;
                    templateAudioTransition3 = new TemplateAudioTransition(l18, l19, f11, f13);
                    n30 = n12;
                }
                object2 = new TemplateRecording(l15, l14, (String)object4, (String)object3, l13, l12, l11, l10, f10, n34 != 0, n33 != 0, templateAudioTransition2, templateAudioTransition);
                n35 = n24;
                n24 = n25;
                n25 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0);
                if (n25 != 0) {
                    n32 = n24;
                    n24 = 0;
                    object = null;
                } else {
                    String string14 = roomSQLiteQuery.getString(n24);
                    n32 = n24;
                    object = string14;
                }
                ((TemplateBaseData)object2).setCustomerUUID((String)object);
                arrayList.add(object2);
                n12 = n31;
                n25 = n32;
                n31 = n27;
                n27 = n30;
                n30 = n11;
                n11 = n29;
                n29 = n10;
                n10 = n28;
                n28 = n35;
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

