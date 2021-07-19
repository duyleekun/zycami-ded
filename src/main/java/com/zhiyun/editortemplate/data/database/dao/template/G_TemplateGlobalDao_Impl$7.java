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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import java.util.concurrent.Callable;

public class G_TemplateGlobalDao_Impl$7
implements Callable {
    public final /* synthetic */ G_TemplateGlobalDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateGlobalDao_Impl$7(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateGlobalDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Could not resolve type clashes
     */
    public TemplateGlobal call() {
        void var2_6;
        RoomSQLiteQuery roomSQLiteQuery;
        block158: {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            block154: {
                boolean bl2;
                block125: {
                    boolean bl3;
                    Object object5;
                    block157: {
                        float f10;
                        String string2;
                        block153: {
                            float f11;
                            boolean bl4;
                            boolean bl5;
                            block156: {
                                block152: {
                                    boolean bl6;
                                    int n10;
                                    int n11;
                                    block151: {
                                        boolean bl7;
                                        block150: {
                                            boolean bl8;
                                            boolean bl9;
                                            boolean bl10;
                                            boolean bl11;
                                            boolean bl12;
                                            block145: {
                                                Object object6;
                                                Object object7;
                                                float f12;
                                                float f13;
                                                float f14;
                                                float f15;
                                                boolean bl13;
                                                int n12;
                                                int n13;
                                                boolean bl14;
                                                block149: {
                                                    boolean bl15;
                                                    block148: {
                                                        float f16;
                                                        boolean bl16;
                                                        block147: {
                                                            block146: {
                                                                float f17;
                                                                block144: {
                                                                    boolean bl17;
                                                                    block143: {
                                                                        boolean bl18;
                                                                        block142: {
                                                                            boolean bl19;
                                                                            block141: {
                                                                                boolean bl20;
                                                                                block140: {
                                                                                    boolean bl21;
                                                                                    block139: {
                                                                                        boolean bl22;
                                                                                        block138: {
                                                                                            boolean bl23;
                                                                                            block137: {
                                                                                                boolean bl24;
                                                                                                float f18;
                                                                                                block135: {
                                                                                                    boolean bl25;
                                                                                                    boolean bl26;
                                                                                                    block155: {
                                                                                                        block136: {
                                                                                                            block134: {
                                                                                                                block133: {
                                                                                                                    int n14;
                                                                                                                    block132: {
                                                                                                                        block127: {
                                                                                                                            boolean bl27;
                                                                                                                            String string3;
                                                                                                                            boolean bl28;
                                                                                                                            boolean bl29;
                                                                                                                            block131: {
                                                                                                                                String string4;
                                                                                                                                block130: {
                                                                                                                                    int n15;
                                                                                                                                    block129: {
                                                                                                                                        block128: {
                                                                                                                                            String string5;
                                                                                                                                            block126: {
                                                                                                                                                object4 = this;
                                                                                                                                                object3 = G_TemplateGlobalDao_Impl.access$000(this.this$0);
                                                                                                                                                roomSQLiteQuery = this.val$_statement;
                                                                                                                                                bl16 = false;
                                                                                                                                                f18 = 0.0f;
                                                                                                                                                object2 = null;
                                                                                                                                                bl2 = false;
                                                                                                                                                object = null;
                                                                                                                                                roomSQLiteQuery = DBUtil.query((RoomDatabase)object3, roomSQLiteQuery, false, null);
                                                                                                                                                object3 = "id";
                                                                                                                                                bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object5 = "temp_id";
                                                                                                                                                bl26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
                                                                                                                                                string2 = "temp_duration";
                                                                                                                                                bl3 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                                                                String string6 = "temp_timebase";
                                                                                                                                                bl12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                                                                                                                                                String string7 = "temp_render";
                                                                                                                                                bl15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                                                                                                                                                String string8 = "temp_display_type";
                                                                                                                                                bl14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                                                                                                                                                String string9 = "temp_volume";
                                                                                                                                                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                                String string10 = "temp_mute";
                                                                                                                                                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                                String string11 = "voice_enable";
                                                                                                                                                bl24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                                string5 = "filter_enable";
                                                                                                                                                bl28 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
                                                                                                                                                string3 = "filter_name";
                                                                                                                                                n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
                                                                                                                                                string4 = "filter_local_source";
                                                                                                                                                bl27 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
                                                                                                                                                object2 = "filter_strength";
                                                                                                                                                bl16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
                                                                                                                                                object = "effect_enable";
                                                                                                                                                bl2 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                                                                                                                                                object4 = "effect_saturation";
                                                                                                                                                n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                                                                                                                                                bl5 = bl24;
                                                                                                                                                string11 = "effect_contrast";
                                                                                                                                                bl24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
                                                                                                                                                n11 = n12;
                                                                                                                                                string10 = "effect_temperature";
                                                                                                                                                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
                                                                                                                                                n10 = n13;
                                                                                                                                                string9 = "effect_hue";
                                                                                                                                                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
                                                                                                                                                bl6 = bl14;
                                                                                                                                                string8 = "effect_exposure";
                                                                                                                                                bl14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
                                                                                                                                                bl7 = bl15;
                                                                                                                                                string7 = "effect_vignette";
                                                                                                                                                bl15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
                                                                                                                                                bl11 = bl12;
                                                                                                                                                string6 = "effect_sharpen";
                                                                                                                                                bl12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
                                                                                                                                                bl10 = bl3;
                                                                                                                                                string2 = "rotate_enable";
                                                                                                                                                bl3 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
                                                                                                                                                bl9 = bl26;
                                                                                                                                                object5 = "rotate_rotate";
                                                                                                                                                bl26 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
                                                                                                                                                bl8 = bl29;
                                                                                                                                                object3 = "roi_enable";
                                                                                                                                                bl25 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_start_center";
                                                                                                                                                bl23 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_start_width";
                                                                                                                                                bl22 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_start_height";
                                                                                                                                                bl21 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_end_center";
                                                                                                                                                bl20 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_end_width";
                                                                                                                                                bl19 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_end_height";
                                                                                                                                                bl18 = bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                object3 = "roi_duration";
                                                                                                                                                bl29 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                                                                                                                                                bl17 = roomSQLiteQuery.moveToFirst();
                                                                                                                                                if (!bl17) break block125;
                                                                                                                                                bl17 = roomSQLiteQuery.isNull((int)(bl28 ? 1 : 0));
                                                                                                                                                bl4 = true;
                                                                                                                                                f11 = Float.MIN_VALUE;
                                                                                                                                                if (!bl17) break block126;
                                                                                                                                                bl17 = roomSQLiteQuery.isNull(n15);
                                                                                                                                                if (!bl17) break block126;
                                                                                                                                                bl17 = roomSQLiteQuery.isNull((int)(bl27 ? 1 : 0));
                                                                                                                                                if (!bl17) break block126;
                                                                                                                                                bl17 = roomSQLiteQuery.isNull((int)(bl16 ? 1 : 0));
                                                                                                                                                if (!bl17) break block126;
                                                                                                                                                bl17 = bl29;
                                                                                                                                                bl29 = false;
                                                                                                                                                object3 = null;
                                                                                                                                                break block127;
                                                                                                                                            }
                                                                                                                                            bl28 = roomSQLiteQuery.getInt((int)(bl28 ? 1 : 0));
                                                                                                                                            if (bl28) {
                                                                                                                                                bl28 = bl4;
                                                                                                                                                break block128;
                                                                                                                                            }
                                                                                                                                            bl28 = false;
                                                                                                                                            string5 = null;
                                                                                                                                        }
                                                                                                                                        bl17 = roomSQLiteQuery.isNull(n15);
                                                                                                                                        if (!bl17) break block129;
                                                                                                                                        n15 = 0;
                                                                                                                                        string3 = null;
                                                                                                                                        break block130;
                                                                                                                                    }
                                                                                                                                    string3 = roomSQLiteQuery.getString(n15);
                                                                                                                                }
                                                                                                                                bl27 = roomSQLiteQuery.getInt((int)(bl27 ? 1 : 0));
                                                                                                                                if (bl27) {
                                                                                                                                    bl27 = bl4;
                                                                                                                                    break block131;
                                                                                                                                }
                                                                                                                                bl27 = false;
                                                                                                                                string4 = null;
                                                                                                                            }
                                                                                                                            f18 = roomSQLiteQuery.getFloat((int)(bl16 ? 1 : 0));
                                                                                                                            bl17 = bl29;
                                                                                                                            object3 = new TemplateFilter(bl28, string3, bl27, f18);
                                                                                                                        }
                                                                                                                        bl16 = roomSQLiteQuery.isNull((int)(bl2 ? 1 : 0));
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull(n14);
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull((int)(bl24 ? 1 : 0));
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull(n12);
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull(n13);
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull((int)(bl14 ? 1 : 0));
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull((int)(bl15 ? 1 : 0));
                                                                                                                        if (!bl16) break block132;
                                                                                                                        bl16 = roomSQLiteQuery.isNull((int)(bl12 ? 1 : 0));
                                                                                                                        if (!bl16) break block132;
                                                                                                                        n14 = 0;
                                                                                                                        object4 = null;
                                                                                                                        break block133;
                                                                                                                    }
                                                                                                                    bl16 = roomSQLiteQuery.getInt((int)(bl2 ? 1 : 0));
                                                                                                                    bl13 = bl16 ? bl4 : false;
                                                                                                                    f17 = roomSQLiteQuery.getFloat(n14);
                                                                                                                    f15 = roomSQLiteQuery.getFloat((int)(bl24 ? 1 : 0));
                                                                                                                    f14 = roomSQLiteQuery.getFloat(n12);
                                                                                                                    f16 = roomSQLiteQuery.getFloat(n13);
                                                                                                                    f13 = roomSQLiteQuery.getFloat((int)(bl14 ? 1 : 0));
                                                                                                                    f12 = roomSQLiteQuery.getFloat((int)(bl15 ? 1 : 0));
                                                                                                                    float f19 = roomSQLiteQuery.getFloat((int)(bl12 ? 1 : 0));
                                                                                                                    object4 = new TemplateEffect(bl13, f17, f15, f14, f16, f13, f12, f19);
                                                                                                                }
                                                                                                                bl16 = roomSQLiteQuery.isNull((int)(bl3 ? 1 : 0));
                                                                                                                if (!bl16) break block134;
                                                                                                                bl16 = roomSQLiteQuery.isNull((int)(bl26 ? 1 : 0));
                                                                                                                if (!bl16) break block134;
                                                                                                                bl16 = bl25;
                                                                                                                bl26 = false;
                                                                                                                object5 = null;
                                                                                                                break block135;
                                                                                                            }
                                                                                                            bl16 = roomSQLiteQuery.getInt((int)(bl3 ? 1 : 0));
                                                                                                            if (!bl16) break block136;
                                                                                                            bl16 = bl4;
                                                                                                            f18 = f11;
                                                                                                            break block155;
                                                                                                        }
                                                                                                        bl16 = false;
                                                                                                        f18 = 0.0f;
                                                                                                        object2 = null;
                                                                                                    }
                                                                                                    bl2 = roomSQLiteQuery.getInt((int)(bl26 ? 1 : 0));
                                                                                                    object5 = new TemplateRotate(bl16, (int)(bl2 ? 1 : 0));
                                                                                                    bl16 = bl25;
                                                                                                }
                                                                                                bl2 = roomSQLiteQuery.isNull((int)(bl16 ? 1 : 0));
                                                                                                if (!bl2) break block137;
                                                                                                bl2 = bl23;
                                                                                                bl3 = roomSQLiteQuery.isNull((int)(bl23 ? 1 : 0));
                                                                                                if (!bl3) break block138;
                                                                                                bl3 = bl22;
                                                                                                bl12 = roomSQLiteQuery.isNull((int)(bl22 ? 1 : 0));
                                                                                                if (!bl12) break block139;
                                                                                                bl12 = bl21;
                                                                                                bl15 = roomSQLiteQuery.isNull((int)(bl21 ? 1 : 0));
                                                                                                if (!bl15) break block140;
                                                                                                bl15 = bl20;
                                                                                                bl14 = roomSQLiteQuery.isNull((int)(bl20 ? 1 : 0));
                                                                                                if (!bl14) break block141;
                                                                                                bl14 = bl19;
                                                                                                n13 = (int)(roomSQLiteQuery.isNull((int)(bl19 ? 1 : 0)) ? 1 : 0);
                                                                                                if (n13 == 0) break block142;
                                                                                                n13 = bl18;
                                                                                                n12 = (int)(roomSQLiteQuery.isNull((int)(bl18 ? 1 : 0)) ? 1 : 0);
                                                                                                if (n12 == 0) break block143;
                                                                                                n12 = bl17;
                                                                                                bl24 = roomSQLiteQuery.isNull((int)(bl17 ? 1 : 0));
                                                                                                if (!bl24) break block144;
                                                                                                bl16 = false;
                                                                                                f18 = 0.0f;
                                                                                                object2 = null;
                                                                                                break block145;
                                                                                            }
                                                                                            bl2 = bl23;
                                                                                        }
                                                                                        bl3 = bl22;
                                                                                    }
                                                                                    bl12 = bl21;
                                                                                }
                                                                                bl15 = bl20;
                                                                            }
                                                                            bl14 = bl19;
                                                                        }
                                                                        n13 = bl18;
                                                                    }
                                                                    n12 = bl17;
                                                                }
                                                                bl16 = roomSQLiteQuery.getInt((int)(bl16 ? 1 : 0));
                                                                bl13 = bl16 ? bl4 : false;
                                                                bl16 = roomSQLiteQuery.isNull((int)(bl2 ? 1 : 0));
                                                                if (!bl16) break block146;
                                                                f17 = 0.0f;
                                                                object7 = null;
                                                                break block147;
                                                            }
                                                            object7 = object2 = roomSQLiteQuery.getString((int)(bl2 ? 1 : 0));
                                                        }
                                                        f15 = roomSQLiteQuery.getFloat((int)(bl3 ? 1 : 0));
                                                        f14 = roomSQLiteQuery.getFloat((int)(bl12 ? 1 : 0));
                                                        bl16 = roomSQLiteQuery.isNull((int)(bl15 ? 1 : 0));
                                                        if (!bl16) break block148;
                                                        f16 = 0.0f;
                                                        object6 = null;
                                                        break block149;
                                                    }
                                                    object6 = object2 = roomSQLiteQuery.getString((int)(bl15 ? 1 : 0));
                                                }
                                                f13 = roomSQLiteQuery.getFloat((int)(bl14 ? 1 : 0));
                                                f12 = roomSQLiteQuery.getFloat(n13);
                                                long l10 = roomSQLiteQuery.getLong(n12);
                                                object2 = new TemplateRoi(bl13, (String)object7, f15, f14, (String)object6, f13, f12, l10);
                                            }
                                            object = new TemplateGlobal();
                                            bl3 = bl8;
                                            long l11 = roomSQLiteQuery.getLong((int)(bl8 ? 1 : 0));
                                            ((TemplateGlobal)object).setId(l11);
                                            bl3 = bl9;
                                            l11 = roomSQLiteQuery.getLong((int)(bl9 ? 1 : 0));
                                            ((TemplateGlobal)object).setTempId(l11);
                                            bl3 = bl10;
                                            l11 = roomSQLiteQuery.getLong((int)(bl10 ? 1 : 0));
                                            ((TemplateGlobal)object).setDuration(l11);
                                            bl3 = bl11;
                                            l11 = roomSQLiteQuery.getLong((int)(bl11 ? 1 : 0));
                                            ((TemplateGlobal)object).setTimebase(l11);
                                            bl3 = bl7;
                                            bl12 = roomSQLiteQuery.isNull((int)(bl7 ? 1 : 0));
                                            if (!bl12) break block150;
                                            bl3 = false;
                                            f10 = 0.0f;
                                            string2 = null;
                                            break block151;
                                        }
                                        string2 = roomSQLiteQuery.getString((int)(bl7 ? 1 : 0));
                                    }
                                    ((TemplateGlobal)object).setRender(string2);
                                    bl3 = bl6;
                                    bl3 = roomSQLiteQuery.getInt((int)(bl6 ? 1 : 0));
                                    ((TemplateGlobal)object).setDisplayType((int)(bl3 ? 1 : 0));
                                    bl3 = n10;
                                    f10 = roomSQLiteQuery.getFloat(n10);
                                    ((TemplateGlobal)object).setVolume(f10);
                                    bl3 = n11;
                                    bl3 = roomSQLiteQuery.getInt(n11);
                                    if (!bl3) break block152;
                                    bl3 = bl4;
                                    f10 = f11;
                                    break block156;
                                }
                                bl3 = false;
                                f10 = 0.0f;
                                string2 = null;
                            }
                            ((TemplateGlobal)object).setMute(bl3);
                            bl3 = bl5;
                            bl3 = roomSQLiteQuery.getInt((int)(bl5 ? 1 : 0));
                            if (!bl3) break block153;
                            bl3 = bl4;
                            f10 = f11;
                            break block157;
                        }
                        bl3 = false;
                        f10 = 0.0f;
                        string2 = null;
                    }
                    ((TemplateGlobal)object).setVoiceEnable(bl3);
                    ((TemplateGlobal)object).setFilter((TemplateFilter)object3);
                    ((TemplateGlobal)object).setEffect((TemplateEffect)object4);
                    ((TemplateGlobal)object).setRotate((TemplateRotate)object5);
                    ((TemplateGlobal)object).setRoi((TemplateRoi)object2);
                    break block154;
                }
                bl2 = false;
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
            break block158;
            catch (Throwable throwable) {
                object2 = this;
            }
            break block158;
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

