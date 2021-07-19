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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import java.util.concurrent.Callable;

public class G_TemplateGlobalDao_Impl$9
implements Callable {
    public final /* synthetic */ G_TemplateGlobalDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateGlobalDao_Impl$9(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateGlobalDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * WARNING - void declaration
     */
    public TemplateGlobal call() {
        Object object;
        RoomSQLiteQuery roomSQLiteQuery;
        block140: {
            int bl2;
            block119: {
                void var13_38;
                Object object2;
                Object object3;
                Object object4;
                Object object5;
                block139: {
                    void var13_33;
                    float f10;
                    float f11;
                    int n10;
                    int n11;
                    String string2;
                    block138: {
                        int n12;
                        int n13;
                        int n14;
                        int n15;
                        block137: {
                            void var23_58;
                            void var21_51;
                            String string3;
                            String string4;
                            float f12;
                            float f13;
                            float f14;
                            float f15;
                            int n16;
                            int n17;
                            int n18;
                            int n19;
                            int n20;
                            int n21;
                            int n22;
                            int n23;
                            block136: {
                                void var13_19;
                                float f16;
                                int bl16;
                                block135: {
                                    float f17;
                                    block134: {
                                        int n24;
                                        block133: {
                                            int n25;
                                            block132: {
                                                int n26;
                                                block131: {
                                                    int n27;
                                                    block130: {
                                                        int n28;
                                                        block129: {
                                                            int n29;
                                                            block128: {
                                                                int n30;
                                                                block127: {
                                                                    int n31;
                                                                    int bl26;
                                                                    float f18;
                                                                    block126: {
                                                                        int n32;
                                                                        block125: {
                                                                            int n33;
                                                                            int n34;
                                                                            int n35;
                                                                            int n36;
                                                                            block124: {
                                                                                void var31_72;
                                                                                String string5;
                                                                                int n37;
                                                                                int bl29;
                                                                                block123: {
                                                                                    int n38;
                                                                                    String string6;
                                                                                    int n39;
                                                                                    block122: {
                                                                                        block121: {
                                                                                            String string7;
                                                                                            block120: {
                                                                                                object5 = this;
                                                                                                object4 = G_TemplateGlobalDao_Impl.access$000(this.this$0);
                                                                                                roomSQLiteQuery = this.val$_statement;
                                                                                                bl16 = 0;
                                                                                                f18 = 0.0f;
                                                                                                object3 = null;
                                                                                                bl2 = 0;
                                                                                                object = null;
                                                                                                roomSQLiteQuery = DBUtil.query((RoomDatabase)object4, roomSQLiteQuery, false, null);
                                                                                                object4 = "id";
                                                                                                bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object2 = "temp_id";
                                                                                                bl26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                string2 = "temp_duration";
                                                                                                int bl3 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                String string8 = "temp_timebase";
                                                                                                n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                                                                                                String string9 = "temp_render";
                                                                                                n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                String string10 = "temp_display_type";
                                                                                                n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                String string11 = "temp_volume";
                                                                                                int n40 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                String string12 = "temp_mute";
                                                                                                int n41 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
                                                                                                String string13 = "voice_enable";
                                                                                                int n42 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
                                                                                                string7 = "filter_enable";
                                                                                                n37 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                                                                                                string5 = "filter_name";
                                                                                                n39 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                                                                                                string6 = "filter_local_source";
                                                                                                n38 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                                                                                                object3 = "filter_strength";
                                                                                                bl16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                object = "effect_enable";
                                                                                                bl2 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                object5 = "effect_saturation";
                                                                                                n36 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
                                                                                                n11 = n42;
                                                                                                string13 = "effect_contrast";
                                                                                                n35 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string13);
                                                                                                n15 = n41;
                                                                                                string12 = "effect_temperature";
                                                                                                n34 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string12);
                                                                                                n14 = n40;
                                                                                                string11 = "effect_hue";
                                                                                                n33 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                n13 = n21;
                                                                                                string10 = "effect_exposure";
                                                                                                n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                n12 = n22;
                                                                                                string9 = "effect_vignette";
                                                                                                n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                n20 = n23;
                                                                                                string8 = "effect_sharpen";
                                                                                                n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                                                                                                n19 = bl3;
                                                                                                string2 = "rotate_enable";
                                                                                                n32 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                n18 = bl26;
                                                                                                object2 = "rotate_rotate";
                                                                                                bl26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                n17 = bl29;
                                                                                                object4 = "roi_enable";
                                                                                                n31 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_start_center";
                                                                                                n30 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_start_width";
                                                                                                n29 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_start_height";
                                                                                                n28 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_end_center";
                                                                                                n27 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_end_width";
                                                                                                n26 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_end_height";
                                                                                                n25 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                object4 = "roi_duration";
                                                                                                bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                n24 = roomSQLiteQuery.moveToFirst();
                                                                                                if (n24 == 0) break block119;
                                                                                                n24 = roomSQLiteQuery.isNull(n37);
                                                                                                n10 = 1;
                                                                                                f11 = Float.MIN_VALUE;
                                                                                                if (n24 == 0) break block120;
                                                                                                n24 = roomSQLiteQuery.isNull(n39);
                                                                                                if (n24 == 0) break block120;
                                                                                                n24 = roomSQLiteQuery.isNull(n38);
                                                                                                if (n24 == 0) break block120;
                                                                                                n24 = roomSQLiteQuery.isNull(bl16);
                                                                                                if (n24 == 0) break block120;
                                                                                                n24 = bl29;
                                                                                                bl29 = 0;
                                                                                                object4 = null;
                                                                                            }
                                                                                            n37 = roomSQLiteQuery.getInt(n37);
                                                                                            if (n37 != 0) {
                                                                                                n37 = n10;
                                                                                                break block121;
                                                                                            }
                                                                                            n37 = 0;
                                                                                            string7 = null;
                                                                                        }
                                                                                        n24 = roomSQLiteQuery.isNull(n39);
                                                                                        if (n24 == 0) break block122;
                                                                                        n39 = 0;
                                                                                        string5 = null;
                                                                                    }
                                                                                    string5 = roomSQLiteQuery.getString(n39);
                                                                                    int n43 = roomSQLiteQuery.getInt(n38);
                                                                                    if (n43 != 0) {
                                                                                        int n44 = n10;
                                                                                        break block123;
                                                                                    }
                                                                                    boolean bl3 = false;
                                                                                    string6 = null;
                                                                                }
                                                                                f18 = roomSQLiteQuery.getFloat(bl16);
                                                                                n24 = bl29;
                                                                                object4 = new TemplateFilter(n37 != 0, string5, (boolean)var31_72, f18);
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(bl2) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n36) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n35) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n34) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n33) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n21) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                bl16 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0);
                                                                                if (bl16 == 0) break block124;
                                                                                n36 = 0;
                                                                                object5 = null;
                                                                            }
                                                                            bl16 = roomSQLiteQuery.getInt(bl2);
                                                                            n16 = bl16 != 0 ? n10 : 0;
                                                                            f17 = roomSQLiteQuery.getFloat(n36);
                                                                            f15 = roomSQLiteQuery.getFloat(n35);
                                                                            f14 = roomSQLiteQuery.getFloat(n34);
                                                                            f16 = roomSQLiteQuery.getFloat(n33);
                                                                            f13 = roomSQLiteQuery.getFloat(n21);
                                                                            f12 = roomSQLiteQuery.getFloat(n22);
                                                                            float f19 = roomSQLiteQuery.getFloat(n23);
                                                                            object5 = new TemplateEffect(n16 != 0, f17, f15, f14, f16, f13, f12, f19);
                                                                            bl16 = (int)(roomSQLiteQuery.isNull(n32) ? 1 : 0);
                                                                            if (bl16 == 0) break block125;
                                                                            bl16 = (int)(roomSQLiteQuery.isNull(bl26) ? 1 : 0);
                                                                            if (bl16 == 0) break block125;
                                                                            bl16 = n31;
                                                                            bl26 = 0;
                                                                            object2 = null;
                                                                        }
                                                                        bl16 = roomSQLiteQuery.getInt(n32);
                                                                        if (bl16 != 0) {
                                                                            bl16 = n10;
                                                                            f18 = f11;
                                                                            break block126;
                                                                        }
                                                                        bl16 = 0;
                                                                        f18 = 0.0f;
                                                                        object3 = null;
                                                                    }
                                                                    bl2 = roomSQLiteQuery.getInt(bl26);
                                                                    object2 = new TemplateRotate(bl16 != 0, bl2);
                                                                    bl16 = n31;
                                                                    bl2 = (int)(roomSQLiteQuery.isNull(bl16) ? 1 : 0);
                                                                    if (bl2 == 0) break block127;
                                                                    bl2 = n30;
                                                                    boolean bl4 = roomSQLiteQuery.isNull(n30);
                                                                    if (!bl4) break block128;
                                                                    int n45 = n29;
                                                                    n23 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0);
                                                                    if (n23 == 0) break block129;
                                                                    n23 = n28;
                                                                    n22 = (int)(roomSQLiteQuery.isNull(n28) ? 1 : 0);
                                                                    if (n22 == 0) break block130;
                                                                    n22 = n27;
                                                                    n21 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0);
                                                                    if (n21 == 0) break block131;
                                                                    n21 = n26;
                                                                    boolean bl5 = roomSQLiteQuery.isNull(n26);
                                                                    if (!bl5) break block132;
                                                                    int n46 = n25;
                                                                    boolean bl6 = roomSQLiteQuery.isNull(n25);
                                                                    if (!bl6) break block133;
                                                                    int n47 = n24;
                                                                    boolean bl7 = roomSQLiteQuery.isNull(n24);
                                                                    if (bl7) {
                                                                        bl16 = 0;
                                                                        f18 = 0.0f;
                                                                        object3 = null;
                                                                    }
                                                                    break block134;
                                                                }
                                                                bl2 = n30;
                                                            }
                                                            int n48 = n29;
                                                        }
                                                        n23 = n28;
                                                    }
                                                    n22 = n27;
                                                }
                                                n21 = n26;
                                            }
                                            int n49 = n25;
                                        }
                                        int n50 = n24;
                                    }
                                    bl16 = roomSQLiteQuery.getInt(bl16);
                                    n16 = bl16 != 0 ? n10 : 0;
                                    bl16 = (int)(roomSQLiteQuery.isNull(bl2) ? 1 : 0);
                                    if (bl16 == 0) break block135;
                                    f17 = 0.0f;
                                    string4 = null;
                                }
                                object3 = roomSQLiteQuery.getString(bl2);
                                string4 = object3;
                                f15 = roomSQLiteQuery.getFloat((int)var13_19);
                                f14 = roomSQLiteQuery.getFloat(n23);
                                bl16 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0);
                                if (bl16 == 0) break block136;
                                f16 = 0.0f;
                                string3 = null;
                            }
                            object3 = roomSQLiteQuery.getString(n22);
                            string3 = object3;
                            f13 = roomSQLiteQuery.getFloat(n21);
                            f12 = roomSQLiteQuery.getFloat((int)var21_51);
                            long l10 = roomSQLiteQuery.getLong((int)var23_58);
                            object3 = new TemplateRoi(n16 != 0, string4, f15, f14, string3, f13, f12, l10);
                            object = new TemplateGlobal();
                            int n51 = n17;
                            long l11 = roomSQLiteQuery.getLong(n17);
                            ((TemplateGlobal)object).setId(l11);
                            int n52 = n18;
                            l11 = roomSQLiteQuery.getLong(n18);
                            ((TemplateGlobal)object).setTempId(l11);
                            int n53 = n19;
                            l11 = roomSQLiteQuery.getLong(n19);
                            ((TemplateGlobal)object).setDuration(l11);
                            int n54 = n20;
                            l11 = roomSQLiteQuery.getLong(n20);
                            ((TemplateGlobal)object).setTimebase(l11);
                            int n55 = n12;
                            n23 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                            if (n23 == 0) break block137;
                            boolean bl8 = false;
                            f10 = 0.0f;
                            string2 = null;
                        }
                        string2 = roomSQLiteQuery.getString(n12);
                        ((TemplateGlobal)object).setRender(string2);
                        int n57 = n13;
                        n57 = roomSQLiteQuery.getInt(n13);
                        ((TemplateGlobal)object).setDisplayType(n57);
                        int n58 = n14;
                        f10 = roomSQLiteQuery.getFloat(n14);
                        ((TemplateGlobal)object).setVolume(f10);
                        int n60 = n15;
                        n60 = roomSQLiteQuery.getInt(n15);
                        if (n60 != 0) {
                            int n61 = n10;
                            f10 = f11;
                            break block138;
                        }
                        boolean bl9 = false;
                        f10 = 0.0f;
                        string2 = null;
                    }
                    ((TemplateGlobal)object).setMute((boolean)var13_33);
                    int n63 = n11;
                    n63 = roomSQLiteQuery.getInt(n11);
                    if (n63 != 0) {
                        int n64 = n10;
                        f10 = f11;
                        break block139;
                    }
                    boolean bl10 = false;
                    f10 = 0.0f;
                    string2 = null;
                }
                ((TemplateGlobal)object).setVoiceEnable((boolean)var13_38);
                ((TemplateGlobal)object).setFilter((TemplateFilter)object4);
                ((TemplateGlobal)object).setEffect((TemplateEffect)object5);
                ((TemplateGlobal)object).setRotate((TemplateRotate)object2);
                ((TemplateGlobal)object).setRoi((TemplateRoi)object3);
                break block140;
            }
            bl2 = 0;
            object = null;
        }
        return object;
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

