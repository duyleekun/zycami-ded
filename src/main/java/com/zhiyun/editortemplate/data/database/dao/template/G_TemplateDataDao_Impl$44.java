/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateDataDao_Impl$44
implements Callable {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDataDao_Impl$44(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TemplatePOJO call() {
        RoomSQLiteQuery roomSQLiteQuery;
        Object object;
        Object object2;
        block89: {
            Object object3;
            Object object4;
            block88: {
                int n10;
                block87: {
                    void var56_78;
                    boolean bl2;
                    long l10;
                    int n11;
                    int n12;
                    object2 = this;
                    object = G_TemplateDataDao_Impl.access$000(this.this$0);
                    ((RoomDatabase)object).beginTransaction();
                    object = this.this$0;
                    object = G_TemplateDataDao_Impl.access$000((G_TemplateDataDao_Impl)object);
                    roomSQLiteQuery = this.val$_statement;
                    int n13 = 1;
                    n10 = 0;
                    object4 = null;
                    roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, n13 != 0, null);
                    object = "id";
                    int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
                    Object object5 = "title_zh";
                    int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object5);
                    Object object6 = "title_tw";
                    int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object6);
                    Object object7 = "title_en";
                    int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object7);
                    ArrayList arrayList = "cover_url";
                    int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList));
                    ArrayList arrayList2 = "video_url";
                    int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList2));
                    ArrayList arrayList3 = "video_time";
                    int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList3));
                    ArrayList arrayList4 = "video_count";
                    int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList4));
                    Object object8 = "video_ratio";
                    int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object8);
                    ArrayList arrayList5 = "res_size";
                    int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)((Object)arrayList5));
                    Object object9 = "is_prime_usable";
                    int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object9);
                    Object object10 = "temp_type";
                    int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object10);
                    object3 = "download_finished";
                    n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object3);
                    object4 = "download_timestamp";
                    int n26 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "editor_template";
                    int n27 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "track_editor_config_data";
                    int n28 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "template_use_type";
                    int n29 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "template_proto_type";
                    int n30 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "first_loaded";
                    int n31 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "template_description_zh";
                    int n32 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "template_description_en";
                    int n33 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "template_description_zh_tw";
                    int n34 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "script_ext_status";
                    int n35 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "script_ext_protocol";
                    int n36 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = "script_ext_version";
                    int n37 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object4);
                    object4 = new LongSparseArray();
                    int n38 = n13;
                    object3 = new LongSparseArray();
                    int n39 = n25;
                    object10 = new LongSparseArray();
                    int n40 = n24;
                    object9 = new LongSparseArray();
                    int n41 = n23;
                    arrayList5 = new ArrayList();
                    int n42 = n22;
                    object8 = new LongSparseArray();
                    int n43 = n21;
                    arrayList4 = new ArrayList();
                    int n44 = n20;
                    arrayList3 = new ArrayList();
                    int n45 = n19;
                    arrayList2 = new ArrayList();
                    int n46 = n18;
                    arrayList = new ArrayList();
                    while ((n12 = roomSQLiteQuery.moveToNext()) != 0) {
                        long l11;
                        n12 = roomSQLiteQuery.isNull(n14);
                        if (n12 == 0) {
                            n12 = n16;
                            n11 = n17;
                            l10 = roomSQLiteQuery.getLong(n14);
                            var56_78 = bl2;
                            bl2 = false;
                            object5 = null;
                            ((LongSparseArray)object4).put(l10, null);
                        } else {
                            var56_78 = bl2;
                            n12 = n16;
                            n11 = n17;
                        }
                        bl2 = roomSQLiteQuery.isNull(n14);
                        if (!bl2) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            n17 = 0;
                            object7 = null;
                            ((LongSparseArray)object3).put(l11, null);
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            n17 = 0;
                            object7 = null;
                            ((LongSparseArray)object10).put(l11, null);
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            n17 = 0;
                            object7 = null;
                            ((LongSparseArray)object9).put(l11, null);
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            n17 = 0;
                            object7 = null;
                            ((LongSparseArray)((Object)arrayList5)).put(l11, null);
                        } else {
                            n17 = 0;
                            object7 = null;
                        }
                        bl2 = roomSQLiteQuery.isNull(n14);
                        if (!bl2) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            Object object11 = ((LongSparseArray)object8).get(l11);
                            if ((object11 = (ArrayList)object11) == null) {
                                object7 = new ArrayList();
                                ((LongSparseArray)object8).put(l11, object7);
                            }
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            object7 = ((LongSparseArray)((Object)arrayList4)).get(l11);
                            if ((object7 = (ArrayList)object7) == null) {
                                object7 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList4)).put(l11, object7);
                            }
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            object7 = ((LongSparseArray)((Object)arrayList3)).get(l11);
                            if ((object7 = (ArrayList)object7) == null) {
                                object7 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList3)).put(l11, object7);
                            }
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            object7 = ((LongSparseArray)((Object)arrayList2)).get(l11);
                            if ((object7 = (ArrayList)object7) == null) {
                                object7 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList2)).put(l11, object7);
                            }
                        }
                        if (!(bl2 = roomSQLiteQuery.isNull(n14))) {
                            l11 = roomSQLiteQuery.getLong(n14);
                            object7 = ((LongSparseArray)((Object)arrayList)).get(l11);
                            if ((object7 = (ArrayList)object7) == null) {
                                object7 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList)).put(l11, object7);
                            }
                        }
                        n16 = n12;
                        n17 = n11;
                        bl2 = var56_78;
                    }
                    var56_78 = bl2;
                    n12 = n16;
                    n11 = n17;
                    int n47 = -1;
                    roomSQLiteQuery.moveToPosition(n47);
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$400((G_TemplateDataDao_Impl)object5, (LongSparseArray)object4);
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$500((G_TemplateDataDao_Impl)object5, (LongSparseArray)object3);
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$600((G_TemplateDataDao_Impl)object5, (LongSparseArray)object10);
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$700((G_TemplateDataDao_Impl)object5, (LongSparseArray)object9);
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$800((G_TemplateDataDao_Impl)object5, (LongSparseArray)((Object)arrayList5));
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$900((G_TemplateDataDao_Impl)object5, (LongSparseArray)object8);
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$1000((G_TemplateDataDao_Impl)object5, (LongSparseArray)((Object)arrayList4));
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$1100((G_TemplateDataDao_Impl)object5, (LongSparseArray)((Object)arrayList3));
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$1200((G_TemplateDataDao_Impl)object5, (LongSparseArray)((Object)arrayList2));
                    object5 = ((G_TemplateDataDao_Impl$44)object2).this$0;
                    G_TemplateDataDao_Impl.access$1300((G_TemplateDataDao_Impl)object5, (LongSparseArray)((Object)arrayList));
                    boolean bl3 = roomSQLiteQuery.moveToFirst();
                    if (!bl3) break block87;
                    try {
                        long l12;
                        long l13;
                        Object object12;
                        Object object13;
                        Object object14;
                        Object object15;
                        ArrayList arrayList6;
                        Object object16;
                        ArrayList arrayList7;
                        ArrayList arrayList8;
                        ArrayList arrayList9;
                        ArrayList arrayList10;
                        int n48;
                        block115: {
                            boolean bl4;
                            void var9_20;
                            block114: {
                                block98: {
                                    block97: {
                                        block96: {
                                            block95: {
                                                block94: {
                                                    block90: {
                                                        block117: {
                                                            block91: {
                                                                block92: {
                                                                    block93: {
                                                                        block99: {
                                                                            block100: {
                                                                                block101: {
                                                                                    block102: {
                                                                                        block113: {
                                                                                            block112: {
                                                                                                block111: {
                                                                                                    block110: {
                                                                                                        block109: {
                                                                                                            block116: {
                                                                                                                block103: {
                                                                                                                    block104: {
                                                                                                                        block105: {
                                                                                                                            block106: {
                                                                                                                                block107: {
                                                                                                                                    block108: {
                                                                                                                                        boolean bl5 = roomSQLiteQuery.isNull(n14);
                                                                                                                                        if (!bl5) break block90;
                                                                                                                                        void var9_17 = var56_78;
                                                                                                                                        n16 = (int)(roomSQLiteQuery.isNull((int)var56_78) ? 1 : 0);
                                                                                                                                        if (n16 == 0) break block91;
                                                                                                                                        n16 = n12;
                                                                                                                                        n17 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                                                                                                                                        if (n17 == 0) break block92;
                                                                                                                                        n17 = n11;
                                                                                                                                        n12 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                                                                                                                                        if (n12 == 0) break block93;
                                                                                                                                        n48 = n46;
                                                                                                                                        if ((n46 = (int)(roomSQLiteQuery.isNull(n46) ? 1 : 0)) == 0) break block94;
                                                                                                                                        arrayList10 = arrayList;
                                                                                                                                        n18 = n45;
                                                                                                                                        if ((n45 = (int)(roomSQLiteQuery.isNull(n45) ? 1 : 0)) == 0) break block95;
                                                                                                                                        arrayList9 = arrayList2;
                                                                                                                                        n19 = n44;
                                                                                                                                        if ((n44 = (int)(roomSQLiteQuery.isNull(n44) ? 1 : 0)) == 0) break block96;
                                                                                                                                        arrayList8 = arrayList3;
                                                                                                                                        n20 = n43;
                                                                                                                                        if ((n43 = (int)(roomSQLiteQuery.isNull(n43) ? 1 : 0)) == 0) break block97;
                                                                                                                                        arrayList7 = arrayList4;
                                                                                                                                        n21 = n42;
                                                                                                                                        if ((n42 = (int)(roomSQLiteQuery.isNull(n42) ? 1 : 0)) == 0) break block98;
                                                                                                                                        object16 = object8;
                                                                                                                                        n22 = n41;
                                                                                                                                        if ((n41 = (int)(roomSQLiteQuery.isNull(n41) ? 1 : 0)) == 0) break block99;
                                                                                                                                        arrayList6 = arrayList5;
                                                                                                                                        n23 = n40;
                                                                                                                                        if ((n40 = (int)(roomSQLiteQuery.isNull(n40) ? 1 : 0)) == 0) break block100;
                                                                                                                                        object15 = object9;
                                                                                                                                        n24 = n39;
                                                                                                                                        if ((n39 = (int)(roomSQLiteQuery.isNull(n39) ? 1 : 0)) == 0) break block101;
                                                                                                                                        object14 = object10;
                                                                                                                                        n25 = n38;
                                                                                                                                        if ((n38 = (int)(roomSQLiteQuery.isNull(n38) ? 1 : 0)) == 0) break block102;
                                                                                                                                        object13 = object3;
                                                                                                                                        n13 = n26;
                                                                                                                                        if ((n26 = (int)(roomSQLiteQuery.isNull(n26) ? 1 : 0)) == 0) break block103;
                                                                                                                                        object12 = object4;
                                                                                                                                        n10 = n27;
                                                                                                                                        if ((n27 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0)) == 0) break block104;
                                                                                                                                        n27 = n10;
                                                                                                                                        n10 = n28;
                                                                                                                                        if ((n28 = (int)(roomSQLiteQuery.isNull(n28) ? 1 : 0)) == 0) break block105;
                                                                                                                                        n28 = n10;
                                                                                                                                        n10 = n29;
                                                                                                                                        if ((n29 = (int)(roomSQLiteQuery.isNull(n29) ? 1 : 0)) == 0) break block106;
                                                                                                                                        n29 = n10;
                                                                                                                                        n10 = n30;
                                                                                                                                        if ((n30 = (int)(roomSQLiteQuery.isNull(n30) ? 1 : 0)) == 0) break block107;
                                                                                                                                        n30 = n10;
                                                                                                                                        n10 = n31;
                                                                                                                                        if ((n31 = (int)(roomSQLiteQuery.isNull(n31) ? 1 : 0)) == 0) break block108;
                                                                                                                                        n31 = n10;
                                                                                                                                        n10 = n32;
                                                                                                                                        if ((n32 = (int)(roomSQLiteQuery.isNull(n32) ? 1 : 0)) == 0) break block109;
                                                                                                                                        n32 = n13;
                                                                                                                                        n13 = n33;
                                                                                                                                        if ((n33 = (int)(roomSQLiteQuery.isNull(n33) ? 1 : 0)) == 0) break block110;
                                                                                                                                        n33 = n25;
                                                                                                                                        n25 = n34;
                                                                                                                                        if ((n34 = (int)(roomSQLiteQuery.isNull(n34) ? 1 : 0)) == 0) break block111;
                                                                                                                                        n34 = n24;
                                                                                                                                        n24 = n35;
                                                                                                                                        if ((n35 = (int)(roomSQLiteQuery.isNull(n35) ? 1 : 0)) == 0) break block112;
                                                                                                                                        n35 = n23;
                                                                                                                                        n23 = n36;
                                                                                                                                        if ((n36 = (int)(roomSQLiteQuery.isNull(n36) ? 1 : 0)) == 0) break block113;
                                                                                                                                        n36 = n22;
                                                                                                                                        n22 = n37;
                                                                                                                                        if ((n37 = (int)(roomSQLiteQuery.isNull(n37) ? 1 : 0)) == 0) break block114;
                                                                                                                                        boolean bl6 = false;
                                                                                                                                        object5 = null;
                                                                                                                                        break block115;
                                                                                                                                    }
                                                                                                                                    n31 = n10;
                                                                                                                                    break block116;
                                                                                                                                }
                                                                                                                                n30 = n10;
                                                                                                                                break block116;
                                                                                                                            }
                                                                                                                            n29 = n10;
                                                                                                                            break block116;
                                                                                                                        }
                                                                                                                        n28 = n10;
                                                                                                                        break block116;
                                                                                                                    }
                                                                                                                    n27 = n10;
                                                                                                                    break block116;
                                                                                                                }
                                                                                                                object12 = object4;
                                                                                                            }
                                                                                                            n10 = n32;
                                                                                                        }
                                                                                                        n32 = n13;
                                                                                                        n13 = n33;
                                                                                                    }
                                                                                                    n33 = n25;
                                                                                                    n25 = n34;
                                                                                                }
                                                                                                n34 = n24;
                                                                                                n24 = n35;
                                                                                            }
                                                                                            n35 = n23;
                                                                                            n23 = n36;
                                                                                        }
                                                                                        n36 = n22;
                                                                                        n22 = n37;
                                                                                        break block114;
                                                                                    }
                                                                                    object13 = object3;
                                                                                    n13 = n33;
                                                                                    n33 = n25;
                                                                                    n25 = n34;
                                                                                    n34 = n24;
                                                                                    n24 = n35;
                                                                                    n35 = n23;
                                                                                    n23 = n36;
                                                                                    n36 = n22;
                                                                                    n22 = n37;
                                                                                    object12 = object4;
                                                                                    n10 = n32;
                                                                                    n32 = n26;
                                                                                    break block114;
                                                                                }
                                                                                object14 = object10;
                                                                                n25 = n34;
                                                                                n34 = n24;
                                                                                n24 = n35;
                                                                                n35 = n23;
                                                                                n23 = n36;
                                                                                n36 = n22;
                                                                                n22 = n37;
                                                                                object13 = object3;
                                                                                n13 = n33;
                                                                                n33 = n38;
                                                                                object12 = object4;
                                                                                n10 = n32;
                                                                                n32 = n26;
                                                                                break block114;
                                                                            }
                                                                            object15 = object9;
                                                                            n24 = n35;
                                                                            n35 = n23;
                                                                            n23 = n36;
                                                                            n36 = n22;
                                                                            n22 = n37;
                                                                            object13 = object3;
                                                                            n13 = n33;
                                                                            n33 = n38;
                                                                            object12 = object4;
                                                                            n10 = n32;
                                                                            n32 = n26;
                                                                            object14 = object10;
                                                                            n25 = n34;
                                                                            n34 = n39;
                                                                            break block114;
                                                                        }
                                                                        arrayList6 = arrayList5;
                                                                        n23 = n36;
                                                                        n36 = n22;
                                                                        n22 = n37;
                                                                        object13 = object3;
                                                                        n13 = n33;
                                                                        n33 = n38;
                                                                        object12 = object4;
                                                                        n10 = n32;
                                                                        n32 = n26;
                                                                        object15 = object9;
                                                                        n24 = n35;
                                                                        n35 = n40;
                                                                        object14 = object10;
                                                                        n25 = n34;
                                                                        n34 = n39;
                                                                        break block114;
                                                                    }
                                                                    n48 = n46;
                                                                    break block94;
                                                                }
                                                                n48 = n46;
                                                                break block117;
                                                            }
                                                            n48 = n46;
                                                            n16 = n12;
                                                        }
                                                        n17 = n11;
                                                        break block94;
                                                    }
                                                    n48 = n46;
                                                    void var9_19 = var56_78;
                                                }
                                                arrayList10 = arrayList;
                                                n18 = n45;
                                            }
                                            arrayList9 = arrayList2;
                                            n19 = n44;
                                        }
                                        arrayList8 = arrayList3;
                                        n20 = n43;
                                    }
                                    arrayList7 = arrayList4;
                                    n21 = n42;
                                }
                                object16 = object8;
                                n22 = n37;
                                object13 = object3;
                                n13 = n33;
                                n33 = n38;
                                object12 = object4;
                                n10 = n32;
                                n32 = n26;
                                arrayList6 = arrayList5;
                                n23 = n36;
                                n36 = n41;
                                object15 = object9;
                                n24 = n35;
                                n35 = n40;
                                object14 = object10;
                                n25 = n34;
                                n34 = n39;
                            }
                            n37 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                            if (n37 != 0 && (n37 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0)) != 0 && (n37 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0)) != 0) {
                                n37 = n21;
                                n21 = 0;
                                arrayList4 = null;
                            } else {
                                n37 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                                if (n37 != 0) {
                                    n10 = 0;
                                    object4 = null;
                                } else {
                                    object4 = roomSQLiteQuery.getString(n10);
                                }
                                n37 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                                if (n37 != 0) {
                                    n13 = 0;
                                    object3 = null;
                                } else {
                                    object3 = roomSQLiteQuery.getString(n13);
                                }
                                n37 = (int)(roomSQLiteQuery.isNull(n25) ? 1 : 0);
                                if (n37 != 0) {
                                    n37 = n21;
                                    n25 = 0;
                                    object10 = null;
                                } else {
                                    object10 = roomSQLiteQuery.getString(n25);
                                    n37 = n21;
                                }
                                arrayList4 = new ArrayList((String)object4, (String)object3, (String)object10);
                            }
                            n13 = (int)(roomSQLiteQuery.isNull(n24) ? 1 : 0);
                            if (n13 != 0 && (n13 = (int)(roomSQLiteQuery.isNull(n23) ? 1 : 0)) != 0 && (n13 = (int)(roomSQLiteQuery.isNull(n22) ? 1 : 0)) != 0) {
                                n13 = 0;
                                object3 = null;
                            } else {
                                n13 = roomSQLiteQuery.getInt(n24);
                                n10 = roomSQLiteQuery.getInt(n23);
                                n22 = roomSQLiteQuery.getInt(n22);
                                object3 = ScriptDataExt.create(n13, n10, n22);
                            }
                            object4 = new TemplateData();
                            l13 = roomSQLiteQuery.getLong(n14);
                            ((TemplateData)object4).setId(l13);
                            n22 = (int)(roomSQLiteQuery.isNull((int)var9_20) ? 1 : 0);
                            if (n22 != 0) {
                                boolean bl7 = false;
                                object5 = null;
                            } else {
                                object5 = roomSQLiteQuery.getString((int)var9_20);
                            }
                            ((TemplateData)object4).setTextZh((String)object5);
                            boolean bl8 = roomSQLiteQuery.isNull(n16);
                            if (bl8) {
                                boolean bl9 = false;
                                object5 = null;
                            } else {
                                object5 = roomSQLiteQuery.getString(n16);
                            }
                            ((TemplateData)object4).setTextZhTw((String)object5);
                            boolean bl10 = roomSQLiteQuery.isNull(n17);
                            if (bl10) {
                                boolean bl11 = false;
                                object5 = null;
                            } else {
                                object5 = roomSQLiteQuery.getString(n17);
                            }
                            ((TemplateData)object4).setTextEn((String)object5);
                            boolean bl12 = roomSQLiteQuery.isNull(n48);
                            if (bl12) {
                                boolean bl13 = false;
                                object5 = null;
                            } else {
                                object5 = roomSQLiteQuery.getString(n48);
                            }
                            ((TemplateData)object4).setCoverUrl((String)object5);
                            n48 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                            if (n48 != 0) {
                                boolean bl14 = false;
                                object5 = null;
                            } else {
                                object5 = roomSQLiteQuery.getString(n18);
                            }
                            ((TemplateData)object4).setVideoUrl((String)object5);
                            double d10 = roomSQLiteQuery.getDouble(n19);
                            ((TemplateData)object4).setVideoTime(d10);
                            n48 = roomSQLiteQuery.getInt(n20);
                            ((TemplateData)object4).setVideoCount(n48);
                            n48 = n37;
                            boolean bl15 = roomSQLiteQuery.isNull(n37);
                            if (bl15) {
                                boolean bl16 = false;
                                object5 = null;
                            } else {
                                object5 = roomSQLiteQuery.getString(n37);
                            }
                            ((TemplateData)object4).setVideoRatio((String)object5);
                            n48 = n36;
                            n48 = roomSQLiteQuery.getInt(n36);
                            ((TemplateData)object4).setResSize(n48);
                            n48 = n35;
                            n48 = roomSQLiteQuery.getInt(n35);
                            boolean bl17 = false;
                            object5 = null;
                            if (n48 != 0) {
                                n48 = 1;
                            } else {
                                n48 = 0;
                                object2 = null;
                            }
                            ((TemplateData)object4).setPrimeUsable(n48 != 0);
                            n48 = n34;
                            n48 = roomSQLiteQuery.getInt(n34);
                            ((TemplateData)object4).setTempType(n48);
                            n48 = n33;
                            n48 = roomSQLiteQuery.getInt(n33);
                            if (n48 != 0) {
                                n48 = 1;
                            } else {
                                n48 = 0;
                                object2 = null;
                            }
                            ((TemplateData)object4).setDownloadFinished(n48 != 0);
                            n48 = n32;
                            n16 = (int)(roomSQLiteQuery.isNull(n32) ? 1 : 0);
                            if (n16 != 0) {
                                n48 = 0;
                                object2 = null;
                            } else {
                                l10 = roomSQLiteQuery.getLong(n32);
                                object2 = l10;
                            }
                            ((TemplateData)object4).setDownloadTimestamp((Long)object2);
                            n48 = n27;
                            n16 = (int)(roomSQLiteQuery.isNull(n27) ? 1 : 0);
                            if (n16 != 0) {
                                n48 = 0;
                                object2 = null;
                            } else {
                                object2 = roomSQLiteQuery.getString(n27);
                            }
                            ((TemplateData)object4).setEditorTemplate((String)object2);
                            n48 = n28;
                            n16 = (int)(roomSQLiteQuery.isNull(n28) ? 1 : 0);
                            if (n16 != 0) {
                                n48 = 0;
                                object2 = null;
                            } else {
                                object2 = roomSQLiteQuery.getString(n28);
                            }
                            ((TemplateData)object4).setTrackEditorConfigData((String)object2);
                            n48 = n29;
                            n48 = roomSQLiteQuery.getInt(n29);
                            ((TemplateData)object4).setTemplateUseType(n48);
                            n48 = n30;
                            n48 = roomSQLiteQuery.getInt(n30);
                            ((TemplateData)object4).setTemplateProtocolType(n48);
                            n48 = n31;
                            n48 = roomSQLiteQuery.getInt(n31);
                            if (n48 != 0) {
                                bl4 = true;
                            }
                            ((TemplateData)object4).setFirstLoaded(bl4);
                            ((TemplateData)object4).setTemplateDescription((TemplateDescription)((Object)arrayList4));
                            ((TemplateData)object4).setScriptDataExt((ScriptDataExt)object3);
                            object5 = object4;
                        }
                        n48 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n48 == 0) {
                            l12 = roomSQLiteQuery.getLong(n14);
                            object2 = object12;
                            object2 = ((LongSparseArray)object12).get(l12);
                            object2 = (Template)object2;
                        } else {
                            n48 = 0;
                            object2 = null;
                        }
                        n13 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n13 == 0) {
                            l12 = roomSQLiteQuery.getLong(n14);
                            object6 = object13;
                            object3 = ((LongSparseArray)object13).get(l12);
                            object3 = (Script)object3;
                        } else {
                            n13 = 0;
                            object3 = null;
                        }
                        n10 = roomSQLiteQuery.isNull(n14);
                        if (n10 == 0) {
                            l10 = roomSQLiteQuery.getLong(n14);
                            object4 = object14;
                            object4 = ((LongSparseArray)object14).get(l10);
                            object4 = (Draft)object4;
                        } else {
                            n10 = 0;
                            object4 = null;
                        }
                        n16 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n16 == 0) {
                            l10 = roomSQLiteQuery.getLong(n14);
                            arrayList = object15;
                            object6 = ((LongSparseArray)object15).get(l10);
                            object6 = (Withdraw)object6;
                        } else {
                            n16 = 0;
                            object6 = null;
                        }
                        n17 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n17 == 0) {
                            long l14 = roomSQLiteQuery.getLong(n14);
                            arrayList2 = arrayList6;
                            object7 = ((LongSparseArray)((Object)arrayList6)).get(l14);
                            object7 = (TemplateGlobal)object7;
                        } else {
                            n17 = 0;
                            object7 = null;
                        }
                        n18 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                        if (n18 == 0) {
                            long l15 = roomSQLiteQuery.getLong(n14);
                            arrayList3 = object16;
                            arrayList = ((LongSparseArray)object16).get(l15);
                        } else {
                            n18 = 0;
                            arrayList = null;
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        if ((n19 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0)) == 0) {
                            long l16 = roomSQLiteQuery.getLong(n14);
                            arrayList4 = arrayList7;
                            arrayList2 = ((LongSparseArray)((Object)arrayList7)).get(l16);
                        } else {
                            n19 = 0;
                            arrayList2 = null;
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        if ((n20 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0)) == 0) {
                            long l17 = roomSQLiteQuery.getLong(n14);
                            object8 = arrayList8;
                            arrayList3 = ((LongSparseArray)((Object)arrayList8)).get(l17);
                        } else {
                            n20 = 0;
                            arrayList3 = null;
                        }
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        if ((n21 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0)) == 0) {
                            long l18 = roomSQLiteQuery.getLong(n14);
                            arrayList5 = arrayList9;
                            arrayList4 = ((LongSparseArray)((Object)arrayList9)).get(l18);
                        } else {
                            n21 = 0;
                            arrayList4 = null;
                        }
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        if ((n22 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0)) == 0) {
                            l13 = roomSQLiteQuery.getLong(n14);
                            object = arrayList10;
                            object = ((LongSparseArray)((Object)arrayList10)).get(l13);
                            object = (ArrayList)object;
                        } else {
                            n14 = 0;
                            object = null;
                        }
                        if (object == null) {
                            object = new ArrayList();
                        }
                        object8 = new TemplatePOJO();
                        ((TemplatePOJO)object8).setTemplateData((TemplateData)object5);
                        ((TemplatePOJO)object8).setTemplate((Template)object2);
                        ((TemplatePOJO)object8).setScript((Script)object3);
                        ((TemplatePOJO)object8).setDraft((Draft)object4);
                        ((TemplatePOJO)object8).setWithdraw((Withdraw)object6);
                        ((TemplatePOJO)object8).setTemplateGlobal((TemplateGlobal)object7);
                        ((TemplatePOJO)object8).setTemplateVideoList(arrayList);
                        ((TemplatePOJO)object8).setTemplateStickerList(arrayList2);
                        ((TemplatePOJO)object8).setTemplateMusicList(arrayList3);
                        ((TemplatePOJO)object8).setTemplateRecordingList(arrayList4);
                        ((TemplatePOJO)object8).setScriptTrackPOJOList((List)object);
                        object4 = object8;
                        break block88;
                    }
                    catch (Throwable throwable) {
                        object2 = this;
                        break block89;
                    }
                }
                n10 = 0;
                object4 = null;
            }
            if (object4 != null) {
                object2 = this;
                object = this.this$0;
                object = G_TemplateDataDao_Impl.access$000((G_TemplateDataDao_Impl)object);
                ((RoomDatabase)object).setTransactionSuccessful();
                roomSQLiteQuery.close();
                G_TemplateDataDao_Impl.access$000(this.this$0).endTransaction();
                return object4;
            }
            object2 = this;
            try {
                object3 = new StringBuilder();
                object4 = "Query returned empty result set: ";
                ((StringBuilder)object3).append((String)object4);
                object4 = this.val$_statement;
                object4 = ((RoomSQLiteQuery)object4).getSql();
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                object = new EmptyResultSetException((String)object3);
                throw object;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            roomSQLiteQuery.close();
            throw object;
        }
        catch (Throwable throwable) {
            G_TemplateDataDao_Impl.access$000(((G_TemplateDataDao_Impl$44)object2).this$0).endTransaction();
            throw throwable;
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

