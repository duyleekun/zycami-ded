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
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateVideoDao_Impl$8
implements Callable {
    public final /* synthetic */ G_TemplateVideoDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateVideoDao_Impl$8(G_TemplateVideoDao_Impl g_TemplateVideoDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateVideoDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = this;
        ArrayList<Object> arrayList = G_TemplateVideoDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        Object object2 = null;
        int n11 = 0;
        float f10 = 0.0f;
        Object object3 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)((Object)arrayList), roomSQLiteQuery, false, null);
        arrayList = "id";
        try {
            int n12;
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            Object object4 = "temp_id";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
            Object object5 = "timebase";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
            String string2 = "start_time";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            Object object6 = "end_time";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object6);
            String string3 = "duration";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "mute";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "volume";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "voice_enable";
            int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "rate";
            int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "rate_type";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            Object object7 = "bezier_rate";
            int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
            object2 = "videoPath";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            object3 = "is_local_source";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
            object = "is_reverse";
            int n25 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "reverse_path";
            int n26 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "customer_uuid";
            int n27 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            object = "filter_enable";
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            int n28 = n11;
            object3 = "filter_name";
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
            int n29 = n10;
            object2 = "filter_local_source";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object2);
            int n30 = n24;
            object7 = "filter_strength";
            n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
            int n31 = n23;
            string8 = "effect_enable";
            n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            int n32 = n22;
            string7 = "effect_saturation";
            n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            int n33 = n21;
            string6 = "effect_contrast";
            n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            int n34 = n20;
            string5 = "effect_temperature";
            n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            int n35 = n19;
            string4 = "effect_hue";
            n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            int n36 = n18;
            string3 = "effect_exposure";
            n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            int n37 = n17;
            object6 = "effect_vignette";
            n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object6);
            int n38 = n16;
            string2 = "effect_sharpen";
            n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            int n39 = n15;
            object5 = "rotate_enable";
            n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
            int n40 = n14;
            object4 = "rotate_rotate";
            n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
            int n41 = n13;
            arrayList = "transition_name";
            int n42 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "transition_duration";
            int n43 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "transition_timebase";
            int n44 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "transition_local_source";
            int n45 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "transition_thumb";
            int n46 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_enable";
            int n47 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_start_center";
            int n48 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_start_width";
            int n49 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_start_height";
            int n50 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_end_center";
            int n51 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_end_width";
            int n52 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_end_height";
            int n53 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "roi_duration";
            int n54 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "rotate_frame_center";
            int n55 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "rotate_frame_scale";
            int n56 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            arrayList = "rotate_frame_rotate";
            int n57 = n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
            int n58 = n14;
            n14 = roomSQLiteQuery.getCount();
            arrayList = new ArrayList<Object>(n14);
            while ((n14 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                String string9;
                float f11;
                int n59;
                int n60;
                int n61;
                int n62;
                int n63;
                int n64;
                int n65;
                int n66;
                float f12;
                int n67;
                block73: {
                    String string10;
                    block72: {
                        block71: {
                            block70: {
                                block68: {
                                    Object object8;
                                    String string11;
                                    String string12;
                                    int n68;
                                    float f13;
                                    float f14;
                                    float f15;
                                    float f16;
                                    float f17;
                                    float f18;
                                    float f19;
                                    Object object9;
                                    block67: {
                                        block69: {
                                            block66: {
                                                block64: {
                                                    block62: {
                                                        block60: {
                                                            block65: {
                                                                block63: {
                                                                    block61: {
                                                                        block58: {
                                                                            block57: {
                                                                                block59: {
                                                                                    block55: {
                                                                                        block53: {
                                                                                            block56: {
                                                                                                block54: {
                                                                                                    block52: {
                                                                                                        block51: {
                                                                                                            block50: {
                                                                                                                n14 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                                                                                                                n67 = 1;
                                                                                                                f12 = Float.MIN_VALUE;
                                                                                                                if (n14 != 0 && (n14 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0)) != 0 && (n14 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0)) != 0 && (n14 = (int)(roomSQLiteQuery.isNull(n24) ? 1 : 0)) != 0) {
                                                                                                                    n66 = n12;
                                                                                                                    n65 = n10;
                                                                                                                    n64 = n11;
                                                                                                                    n63 = n24;
                                                                                                                    n24 = 0;
                                                                                                                    object7 = null;
                                                                                                                } else {
                                                                                                                    n14 = roomSQLiteQuery.getInt(n12);
                                                                                                                    if (n14 != 0) {
                                                                                                                        n14 = n67;
                                                                                                                    } else {
                                                                                                                        n14 = 0;
                                                                                                                        object4 = null;
                                                                                                                    }
                                                                                                                    n65 = roomSQLiteQuery.isNull(n11);
                                                                                                                    if (n65 != 0) {
                                                                                                                        n66 = n12;
                                                                                                                        n12 = 0;
                                                                                                                        object = null;
                                                                                                                    } else {
                                                                                                                        String string13 = roomSQLiteQuery.getString(n11);
                                                                                                                        n66 = n12;
                                                                                                                        object = string13;
                                                                                                                    }
                                                                                                                    n65 = roomSQLiteQuery.getInt(n10);
                                                                                                                    if (n65 != 0) {
                                                                                                                        n65 = n10;
                                                                                                                        n64 = n11;
                                                                                                                        n10 = n67;
                                                                                                                    } else {
                                                                                                                        n65 = n10;
                                                                                                                        n64 = n11;
                                                                                                                        n10 = 0;
                                                                                                                        object2 = null;
                                                                                                                    }
                                                                                                                    f10 = roomSQLiteQuery.getFloat(n24);
                                                                                                                    n63 = n24;
                                                                                                                    object7 = new TemplateFilter(n14 != 0, (String)object, n10 != 0, f10);
                                                                                                                }
                                                                                                                n12 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0);
                                                                                                                if (n12 != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0)) != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n21) ? 1 : 0)) != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n20) ? 1 : 0)) != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n19) ? 1 : 0)) != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0)) != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n17) ? 1 : 0)) != 0 && (n12 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0)) != 0) {
                                                                                                                    n12 = 0;
                                                                                                                    object = null;
                                                                                                                } else {
                                                                                                                    n12 = roomSQLiteQuery.getInt(n23);
                                                                                                                    if (n12 != 0) {
                                                                                                                        n62 = n67;
                                                                                                                    } else {
                                                                                                                        n62 = 0;
                                                                                                                        object9 = null;
                                                                                                                    }
                                                                                                                    f19 = roomSQLiteQuery.getFloat(n22);
                                                                                                                    f18 = roomSQLiteQuery.getFloat(n21);
                                                                                                                    f17 = roomSQLiteQuery.getFloat(n20);
                                                                                                                    f16 = roomSQLiteQuery.getFloat(n19);
                                                                                                                    f15 = roomSQLiteQuery.getFloat(n18);
                                                                                                                    f14 = roomSQLiteQuery.getFloat(n17);
                                                                                                                    f13 = roomSQLiteQuery.getFloat(n16);
                                                                                                                    object = new TemplateEffect(n62 != 0, f19, f18, f17, f16, f15, f14, f13);
                                                                                                                }
                                                                                                                n10 = roomSQLiteQuery.isNull(n15);
                                                                                                                if (n10 == 0) break block50;
                                                                                                                n10 = n58;
                                                                                                                n11 = (int)(roomSQLiteQuery.isNull(n58) ? 1 : 0);
                                                                                                                if (n11 == 0) break block51;
                                                                                                                n11 = n42;
                                                                                                                n10 = 0;
                                                                                                                object2 = null;
                                                                                                                break block52;
                                                                                                            }
                                                                                                            n10 = n58;
                                                                                                        }
                                                                                                        n11 = roomSQLiteQuery.getInt(n15);
                                                                                                        if (n11 != 0) {
                                                                                                            n11 = n67;
                                                                                                            f10 = f12;
                                                                                                        } else {
                                                                                                            n11 = 0;
                                                                                                            f10 = 0.0f;
                                                                                                            object3 = null;
                                                                                                        }
                                                                                                        n14 = roomSQLiteQuery.getInt(n10);
                                                                                                        n58 = n10;
                                                                                                        object2 = new TemplateRotate(n11 != 0, n14);
                                                                                                        n11 = n42;
                                                                                                    }
                                                                                                    n14 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                                                                                                    if (n14 == 0) break block53;
                                                                                                    n14 = n43;
                                                                                                    n42 = (int)(roomSQLiteQuery.isNull(n43) ? 1 : 0);
                                                                                                    if (n42 == 0) break block54;
                                                                                                    n42 = n15;
                                                                                                    n15 = n44;
                                                                                                    n43 = (int)(roomSQLiteQuery.isNull(n44) ? 1 : 0);
                                                                                                    if (n43 == 0) break block55;
                                                                                                    n43 = n16;
                                                                                                    n16 = n45;
                                                                                                    n44 = (int)(roomSQLiteQuery.isNull(n45) ? 1 : 0);
                                                                                                    if (n44 == 0) break block56;
                                                                                                    n44 = n17;
                                                                                                    n17 = n46;
                                                                                                    n45 = (int)(roomSQLiteQuery.isNull(n46) ? 1 : 0);
                                                                                                    if (n45 == 0) break block57;
                                                                                                    n45 = n11;
                                                                                                    n61 = n14;
                                                                                                    n14 = n47;
                                                                                                    n11 = 0;
                                                                                                    f10 = 0.0f;
                                                                                                    object3 = null;
                                                                                                    break block58;
                                                                                                }
                                                                                                n42 = n15;
                                                                                                n43 = n16;
                                                                                                n15 = n44;
                                                                                                n16 = n45;
                                                                                            }
                                                                                            n44 = n17;
                                                                                            break block59;
                                                                                        }
                                                                                        n42 = n15;
                                                                                        n14 = n43;
                                                                                        n15 = n44;
                                                                                    }
                                                                                    n43 = n16;
                                                                                    n44 = n17;
                                                                                    n16 = n45;
                                                                                }
                                                                                n17 = n46;
                                                                            }
                                                                            n45 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                                                                            if (n45 != 0) {
                                                                                n62 = 0;
                                                                                object9 = null;
                                                                            } else {
                                                                                String string14 = roomSQLiteQuery.getString(n11);
                                                                                object9 = string14;
                                                                            }
                                                                            long l10 = roomSQLiteQuery.getLong(n14);
                                                                            long l11 = roomSQLiteQuery.getLong(n15);
                                                                            n45 = roomSQLiteQuery.getInt(n16);
                                                                            if (n45 != 0) {
                                                                                n45 = n11;
                                                                                n68 = n67;
                                                                                f15 = f12;
                                                                            } else {
                                                                                n45 = n11;
                                                                                n68 = 0;
                                                                                f15 = 0.0f;
                                                                                string12 = null;
                                                                            }
                                                                            object3 = new TemplateTransition((String)object9, l10, l11, n68 != 0);
                                                                            n46 = roomSQLiteQuery.isNull(n17);
                                                                            if (n46 != 0) {
                                                                                n61 = n14;
                                                                                n14 = 0;
                                                                                object4 = null;
                                                                            } else {
                                                                                String string15 = roomSQLiteQuery.getString(n17);
                                                                                n61 = n14;
                                                                                object4 = string15;
                                                                            }
                                                                            ((TemplateTransition)object3).setThumb((String)object4);
                                                                            n14 = n47;
                                                                        }
                                                                        n46 = roomSQLiteQuery.isNull(n14);
                                                                        if (n46 == 0) break block60;
                                                                        n46 = n15;
                                                                        n15 = n48;
                                                                        n47 = (int)(roomSQLiteQuery.isNull(n48) ? 1 : 0);
                                                                        if (n47 == 0) break block61;
                                                                        n47 = n16;
                                                                        n16 = n49;
                                                                        n48 = (int)(roomSQLiteQuery.isNull(n49) ? 1 : 0);
                                                                        if (n48 == 0) break block62;
                                                                        n48 = n17;
                                                                        n17 = n50;
                                                                        n49 = (int)(roomSQLiteQuery.isNull(n50) ? 1 : 0);
                                                                        if (n49 == 0) break block63;
                                                                        n49 = n18;
                                                                        n18 = n51;
                                                                        n50 = (int)(roomSQLiteQuery.isNull(n51) ? 1 : 0);
                                                                        if (n50 == 0) break block64;
                                                                        n50 = n19;
                                                                        n19 = n52;
                                                                        n51 = (int)(roomSQLiteQuery.isNull(n52) ? 1 : 0);
                                                                        if (n51 == 0) break block65;
                                                                        n51 = n20;
                                                                        n20 = n53;
                                                                        n52 = (int)(roomSQLiteQuery.isNull(n53) ? 1 : 0);
                                                                        if (n52 == 0) break block66;
                                                                        n52 = n21;
                                                                        n21 = n54;
                                                                        n53 = (int)(roomSQLiteQuery.isNull(n54) ? 1 : 0);
                                                                        if (n53 == 0) break block67;
                                                                        n54 = n14;
                                                                        n53 = n15;
                                                                        n15 = n55;
                                                                        n14 = 0;
                                                                        object4 = null;
                                                                        break block68;
                                                                    }
                                                                    n47 = n16;
                                                                    n48 = n17;
                                                                    n16 = n49;
                                                                    n17 = n50;
                                                                }
                                                                n49 = n18;
                                                                n50 = n19;
                                                                n18 = n51;
                                                                n19 = n52;
                                                            }
                                                            n51 = n20;
                                                            n52 = n21;
                                                            n20 = n53;
                                                            break block69;
                                                        }
                                                        n46 = n15;
                                                        n47 = n16;
                                                        n15 = n48;
                                                        n16 = n49;
                                                    }
                                                    n48 = n17;
                                                    n49 = n18;
                                                    n17 = n50;
                                                    n18 = n51;
                                                }
                                                n50 = n19;
                                                n51 = n20;
                                                n19 = n52;
                                                n20 = n53;
                                            }
                                            n52 = n21;
                                        }
                                        n21 = n54;
                                    }
                                    n53 = roomSQLiteQuery.getInt(n14);
                                    if (n53 != 0) {
                                        n60 = n67;
                                        f19 = f12;
                                    } else {
                                        n60 = 0;
                                        f19 = 0.0f;
                                    }
                                    n53 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                    if (n53 != 0) {
                                        n59 = 0;
                                        f18 = 0.0f;
                                        string11 = null;
                                    } else {
                                        object8 = roomSQLiteQuery.getString(n15);
                                        string11 = object8;
                                    }
                                    f17 = roomSQLiteQuery.getFloat(n16);
                                    f16 = roomSQLiteQuery.getFloat(n17);
                                    n53 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                                    if (n53 != 0) {
                                        n68 = 0;
                                        f15 = 0.0f;
                                        string12 = null;
                                    } else {
                                        object8 = roomSQLiteQuery.getString(n18);
                                        string12 = object8;
                                    }
                                    f14 = roomSQLiteQuery.getFloat(n19);
                                    f13 = roomSQLiteQuery.getFloat(n20);
                                    long l12 = roomSQLiteQuery.getLong(n21);
                                    object9 = object8;
                                    object8 = new TemplateRoi(n60 != 0, string11, f17, f16, string12, f14, f13, l12);
                                    n54 = n14;
                                    object4 = object8;
                                    n53 = n15;
                                    n15 = n55;
                                }
                                n55 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                                if (n55 == 0) break block70;
                                n55 = n16;
                                n16 = n56;
                                if ((n56 = (int)(roomSQLiteQuery.isNull(n56) ? 1 : 0)) == 0) break block71;
                                n56 = n17;
                                n17 = n57;
                                if ((n57 = (int)(roomSQLiteQuery.isNull(n57) ? 1 : 0)) == 0) break block72;
                                n62 = n15;
                                n60 = n16;
                                n59 = n17;
                                n57 = n18;
                                n17 = 0;
                                object6 = null;
                                break block73;
                            }
                            n55 = n16;
                            n16 = n56;
                        }
                        n56 = n17;
                        n17 = n57;
                    }
                    n57 = roomSQLiteQuery.isNull(n15);
                    if (n57 != 0) {
                        n62 = n15;
                        n15 = 0;
                        object5 = null;
                    } else {
                        string10 = roomSQLiteQuery.getString(n15);
                        n62 = n15;
                        object5 = string10;
                    }
                    n57 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                    if (n57 != 0) {
                        n60 = n16;
                        n57 = n18;
                        n16 = 0;
                        f11 = 0.0f;
                        string2 = null;
                    } else {
                        string10 = roomSQLiteQuery.getString(n16);
                        n60 = n16;
                        string2 = string10;
                        n57 = n18;
                    }
                    n18 = roomSQLiteQuery.getInt(n17);
                    n59 = n17;
                    object6 = new TemplateRotateFrame((String)object5, string2, n18);
                }
                object5 = new TemplateVideo();
                n16 = n41;
                n41 = n19;
                long l13 = roomSQLiteQuery.getLong(n16);
                ((TemplateVideo)object5).setId(l13);
                n18 = n40;
                n40 = n20;
                long l14 = roomSQLiteQuery.getLong(n18);
                ((TemplateVideo)object5).setTempId(l14);
                n19 = n39;
                n39 = n21;
                long l15 = roomSQLiteQuery.getLong(n19);
                ((TemplateVideo)object5).setTimebase(l15);
                n21 = n18;
                n20 = n38;
                n38 = n19;
                l13 = roomSQLiteQuery.getLong(n20);
                ((TemplateVideo)object5).setStartTime(l13);
                n18 = n37;
                n37 = n20;
                l14 = roomSQLiteQuery.getLong(n18);
                ((TemplateVideo)object5).setEndTime(l14);
                n19 = n36;
                n36 = n21;
                l15 = roomSQLiteQuery.getLong(n19);
                ((TemplateVideo)object5).setDuration(l15);
                n20 = n35;
                n21 = roomSQLiteQuery.getInt(n35);
                if (n21 != 0) {
                    n21 = n67;
                } else {
                    n21 = 0;
                    string6 = null;
                }
                ((TemplateVideo)object5).setMute(n21 != 0);
                n21 = n34;
                n34 = n16;
                f11 = roomSQLiteQuery.getFloat(n21);
                ((TemplateVideo)object5).setVolume(f11);
                n16 = n33;
                n33 = roomSQLiteQuery.getInt(n33);
                if (n33 != 0) {
                    n33 = n16;
                    n16 = n67;
                    f11 = f12;
                } else {
                    n33 = n16;
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                }
                ((TemplateVideo)object5).setVoiceEnable(n16 != 0);
                n16 = n32;
                n32 = n18;
                float f20 = roomSQLiteQuery.getFloat(n16);
                ((TemplateVideo)object5).setRate(f20);
                n18 = n31;
                n31 = n16;
                n16 = roomSQLiteQuery.getInt(n18);
                ((TemplateVideo)object5).setRateType(n16);
                n16 = n30;
                n30 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0);
                if (n30 != 0) {
                    n35 = n16;
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                } else {
                    String string16 = roomSQLiteQuery.getString(n16);
                    n35 = n16;
                    string2 = string16;
                }
                ((TemplateVideo)object5).setBezierRate(string2);
                n16 = n29;
                n29 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0);
                if (n29 != 0) {
                    n30 = n16;
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                } else {
                    String string17 = roomSQLiteQuery.getString(n16);
                    n30 = n16;
                    string2 = string17;
                }
                ((TemplateVideo)object5).setVideoPath(string2);
                n16 = n28;
                n28 = roomSQLiteQuery.getInt(n28);
                if (n28 != 0) {
                    n28 = n16;
                    n16 = n67;
                    f11 = f12;
                } else {
                    n28 = n16;
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                }
                ((TemplateVideo)object5).setLocalSource(n16 != 0);
                n16 = n25;
                n25 = roomSQLiteQuery.getInt(n25);
                if (n25 != 0) {
                    n25 = n16;
                    n16 = n67;
                    f11 = f12;
                } else {
                    n25 = n16;
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                }
                ((TemplateVideo)object5).setReverse(n16 != 0);
                n16 = n26;
                n26 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0);
                if (n26 != 0) {
                    n29 = n16;
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                } else {
                    string9 = roomSQLiteQuery.getString(n16);
                    n29 = n16;
                    string2 = string9;
                }
                ((TemplateVideo)object5).setReversePath(string2);
                n16 = n27;
                n26 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0);
                if (n26 != 0) {
                    n16 = 0;
                    f11 = 0.0f;
                    string2 = null;
                } else {
                    string2 = string9 = roomSQLiteQuery.getString(n27);
                }
                ((TemplateBaseData)object5).setCustomerUUID(string2);
                ((TemplateVideo)object5).setFilter((TemplateFilter)object7);
                ((TemplateVideo)object5).setEffect((TemplateEffect)object);
                ((TemplateVideo)object5).setRotate((TemplateRotate)object2);
                ((TemplateVideo)object5).setTransition((TemplateTransition)object3);
                ((TemplateVideo)object5).setRoi((TemplateRoi)object4);
                ((TemplateVideo)object5).setRotateFrame((TemplateRotateFrame)object6);
                arrayList.add(object5);
                n26 = n29;
                n29 = n30;
                n30 = n35;
                n15 = n42;
                n16 = n43;
                n17 = n44;
                n42 = n45;
                n44 = n46;
                n45 = n47;
                n46 = n48;
                n48 = n53;
                n47 = n54;
                n10 = n65;
                n12 = n66;
                n11 = n64;
                n24 = n63;
                n43 = n61;
                n35 = n20;
                n54 = n39;
                n53 = n40;
                n20 = n51;
                n51 = n57;
                n57 = n59;
                n40 = n36;
                n39 = n38;
                n36 = n19;
                n38 = n37;
                n19 = n50;
                n50 = n56;
                n56 = n60;
                n37 = n32;
                n32 = n31;
                n31 = n18;
                n18 = n49;
                n49 = n55;
                n55 = n62;
                int n69 = n34;
                n34 = n21;
                n21 = n52;
                n52 = n41;
                n41 = n69;
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

