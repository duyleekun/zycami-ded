/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao_Impl;
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

public class G_WithdrawDao_Impl$16
implements Callable {
    public final /* synthetic */ G_WithdrawDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_WithdrawDao_Impl$16(G_WithdrawDao_Impl g_WithdrawDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_WithdrawDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TemplatePOJO call() {
        Object object;
        Object object2;
        Object object3;
        block89: {
            Object object4;
            Object object5;
            Object object6;
            block88: {
                int n10;
                block87: {
                    Object object7;
                    int n11;
                    long l10;
                    int n12;
                    int n13;
                    object3 = this;
                    object2 = "id";
                    object = G_WithdrawDao_Impl.access$000(this.this$0);
                    ((RoomDatabase)object).beginTransaction();
                    object = this.this$0;
                    object = G_WithdrawDao_Impl.access$000((G_WithdrawDao_Impl)object);
                    object6 = this.val$_statement;
                    int n14 = 1;
                    n10 = 0;
                    object5 = null;
                    object = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object6, n14 != 0, null);
                    int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
                    int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
                    Object object8 = "title_zh";
                    int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object8);
                    Object object9 = "title_tw";
                    int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object9);
                    ArrayList arrayList = "title_en";
                    boolean bl2 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)((Object)arrayList));
                    ArrayList arrayList2 = "cover_url";
                    int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)((Object)arrayList2));
                    ArrayList arrayList3 = "video_url";
                    int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)((Object)arrayList3));
                    ArrayList arrayList4 = "video_time";
                    int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)((Object)arrayList4));
                    Object object10 = "video_count";
                    int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object10);
                    ArrayList arrayList5 = "video_ratio";
                    int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)((Object)arrayList5));
                    Object object11 = "res_size";
                    int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object11);
                    Object object12 = "is_prime_usable";
                    int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object12);
                    object4 = "temp_type";
                    n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object4);
                    object5 = "download_finished";
                    int n26 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "download_timestamp";
                    int n27 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "editor_template";
                    int n28 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "track_editor_config_data";
                    int n29 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "template_use_type";
                    int n30 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "template_proto_type";
                    int n31 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "first_loaded";
                    int n32 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "template_description_zh";
                    int n33 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "template_description_en";
                    int n34 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "template_description_zh_tw";
                    int n35 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "script_ext_status";
                    int n36 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "script_ext_protocol";
                    int n37 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = "script_ext_version";
                    int n38 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object5);
                    object5 = new LongSparseArray();
                    int n39 = n14;
                    object4 = new LongSparseArray();
                    int n40 = n25;
                    object12 = new LongSparseArray();
                    int n41 = n24;
                    object11 = new LongSparseArray();
                    int n42 = n23;
                    arrayList5 = new ArrayList();
                    int n43 = n22;
                    object10 = new LongSparseArray();
                    int n44 = n21;
                    arrayList4 = new ArrayList();
                    int n45 = n20;
                    arrayList3 = new ArrayList();
                    int n46 = n19;
                    arrayList2 = new ArrayList();
                    boolean bl3 = bl2;
                    arrayList = new ArrayList();
                    while ((n13 = object.moveToNext()) != 0) {
                        n13 = object.isNull(n15);
                        if (n13 == 0) {
                            n13 = n17;
                            n12 = n18;
                            l10 = object.getLong(n15);
                            n11 = n16;
                            n16 = 0;
                            object2 = null;
                            ((LongSparseArray)object5).put(l10, null);
                        } else {
                            n11 = n16;
                            n13 = n17;
                            n12 = n18;
                        }
                        n16 = (int)(object.isNull(n15) ? 1 : 0);
                        if (n16 == 0) {
                            l10 = object.getLong(n15);
                            n16 = 0;
                            object2 = null;
                            ((LongSparseArray)object4).put(l10, null);
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            n16 = 0;
                            object2 = null;
                            ((LongSparseArray)object12).put(l10, null);
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            n16 = 0;
                            object2 = null;
                            ((LongSparseArray)object11).put(l10, null);
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            n16 = 0;
                            object2 = null;
                            ((LongSparseArray)((Object)arrayList5)).put(l10, null);
                        } else {
                            n16 = 0;
                            object2 = null;
                        }
                        n17 = (int)(object.isNull(n15) ? 1 : 0);
                        if (n17 == 0) {
                            l10 = object.getLong(n15);
                            object7 = ((LongSparseArray)object10).get(l10);
                            if ((object7 = (ArrayList)object7) == null) {
                                object2 = new ArrayList();
                                ((LongSparseArray)object10).put(l10, object2);
                            }
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            object2 = ((LongSparseArray)((Object)arrayList4)).get(l10);
                            if ((object2 = (ArrayList)object2) == null) {
                                object2 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList4)).put(l10, object2);
                            }
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            object2 = ((LongSparseArray)((Object)arrayList3)).get(l10);
                            if ((object2 = (ArrayList)object2) == null) {
                                object2 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList3)).put(l10, object2);
                            }
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            object2 = ((LongSparseArray)((Object)arrayList2)).get(l10);
                            if ((object2 = (ArrayList)object2) == null) {
                                object2 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList2)).put(l10, object2);
                            }
                        }
                        if ((n16 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            l10 = object.getLong(n15);
                            object2 = ((LongSparseArray)((Object)arrayList)).get(l10);
                            if ((object2 = (ArrayList)object2) == null) {
                                object2 = new ArrayList();
                                ((LongSparseArray)((Object)arrayList)).put(l10, object2);
                            }
                        }
                        n17 = n13;
                        n18 = n12;
                        n16 = n11;
                    }
                    n11 = n16;
                    n13 = n17;
                    n12 = n18;
                    n16 = -1;
                    object.moveToPosition(n16);
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$400((G_WithdrawDao_Impl)object2, (LongSparseArray)object5);
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$500((G_WithdrawDao_Impl)object2, (LongSparseArray)object4);
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$600((G_WithdrawDao_Impl)object2, (LongSparseArray)object12);
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$700((G_WithdrawDao_Impl)object2, (LongSparseArray)object11);
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$800((G_WithdrawDao_Impl)object2, (LongSparseArray)((Object)arrayList5));
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$900((G_WithdrawDao_Impl)object2, (LongSparseArray)object10);
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$1000((G_WithdrawDao_Impl)object2, (LongSparseArray)((Object)arrayList4));
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$1100((G_WithdrawDao_Impl)object2, (LongSparseArray)((Object)arrayList3));
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$1200((G_WithdrawDao_Impl)object2, (LongSparseArray)((Object)arrayList2));
                    object2 = ((G_WithdrawDao_Impl$16)object3).this$0;
                    G_WithdrawDao_Impl.access$1300((G_WithdrawDao_Impl)object2, (LongSparseArray)((Object)arrayList));
                    n16 = (int)(object.moveToFirst() ? 1 : 0);
                    if (n16 == 0) break block87;
                    try {
                        boolean bl4;
                        long l11;
                        long l12;
                        Object object13;
                        Object object14;
                        Object object15;
                        Object object16;
                        ArrayList arrayList6;
                        Object object17;
                        ArrayList arrayList7;
                        ArrayList arrayList8;
                        ArrayList arrayList9;
                        ArrayList arrayList10;
                        boolean bl5;
                        block116: {
                            void var42_70;
                            void var43_83;
                            void var15_21;
                            void var23_40;
                            boolean bl6;
                            boolean bl7;
                            block115: {
                                block98: {
                                    block97: {
                                        block96: {
                                            block95: {
                                                block94: {
                                                    block90: {
                                                        block118: {
                                                            block91: {
                                                                block92: {
                                                                    block93: {
                                                                        int n47;
                                                                        block99: {
                                                                            block100: {
                                                                                block101: {
                                                                                    block102: {
                                                                                        block114: {
                                                                                            block113: {
                                                                                                block112: {
                                                                                                    block111: {
                                                                                                        block110: {
                                                                                                            block117: {
                                                                                                                block103: {
                                                                                                                    block104: {
                                                                                                                        block105: {
                                                                                                                            block106: {
                                                                                                                                block107: {
                                                                                                                                    block108: {
                                                                                                                                        block109: {
                                                                                                                                            n16 = (int)(object.isNull(n15) ? 1 : 0);
                                                                                                                                            if (n16 == 0) break block90;
                                                                                                                                            n16 = n11;
                                                                                                                                            n17 = (int)(object.isNull(n11) ? 1 : 0);
                                                                                                                                            if (n17 == 0) break block91;
                                                                                                                                            n17 = n13;
                                                                                                                                            n18 = (int)(object.isNull(n13) ? 1 : 0);
                                                                                                                                            if (n18 == 0) break block92;
                                                                                                                                            n18 = n12;
                                                                                                                                            n13 = (int)(object.isNull(n12) ? 1 : 0);
                                                                                                                                            if (n13 == 0) break block93;
                                                                                                                                            bl5 = bl3;
                                                                                                                                            if (!(bl3 = (boolean)object.isNull((int)(bl3 ? 1 : 0)))) break block94;
                                                                                                                                            arrayList10 = arrayList;
                                                                                                                                            int n48 = n46;
                                                                                                                                            if ((n46 = (int)(object.isNull(n46) ? 1 : 0)) == 0) break block95;
                                                                                                                                            arrayList9 = arrayList2;
                                                                                                                                            n19 = n45;
                                                                                                                                            if ((n45 = (int)(object.isNull(n45) ? 1 : 0)) == 0) break block96;
                                                                                                                                            arrayList8 = arrayList3;
                                                                                                                                            n20 = n44;
                                                                                                                                            if ((n44 = (int)(object.isNull(n44) ? 1 : 0)) == 0) break block97;
                                                                                                                                            arrayList7 = arrayList4;
                                                                                                                                            n21 = n43;
                                                                                                                                            if ((n43 = (int)(object.isNull(n43) ? 1 : 0)) == 0) break block98;
                                                                                                                                            object17 = object10;
                                                                                                                                            n47 = n42;
                                                                                                                                            if ((n42 = (int)(object.isNull(n42) ? 1 : 0)) == 0) break block99;
                                                                                                                                            arrayList6 = arrayList5;
                                                                                                                                            n23 = n41;
                                                                                                                                            if ((n41 = (int)(object.isNull(n41) ? 1 : 0)) == 0) break block100;
                                                                                                                                            object16 = object11;
                                                                                                                                            n24 = n40;
                                                                                                                                            if ((n40 = (int)(object.isNull(n40) ? 1 : 0)) == 0) break block101;
                                                                                                                                            object15 = object12;
                                                                                                                                            n25 = n39;
                                                                                                                                            if ((n39 = (int)(object.isNull(n39) ? 1 : 0)) == 0) break block102;
                                                                                                                                            object14 = object4;
                                                                                                                                            n14 = n26;
                                                                                                                                            if ((n26 = (int)(object.isNull(n26) ? 1 : 0)) == 0) break block103;
                                                                                                                                            object13 = object5;
                                                                                                                                            n10 = n27;
                                                                                                                                            if ((n27 = (int)(object.isNull(n27) ? 1 : 0)) == 0) break block104;
                                                                                                                                            n27 = n10;
                                                                                                                                            n10 = n28;
                                                                                                                                            if ((n28 = (int)(object.isNull(n28) ? 1 : 0)) == 0) break block105;
                                                                                                                                            n28 = n10;
                                                                                                                                            n10 = n29;
                                                                                                                                            if ((n29 = (int)(object.isNull(n29) ? 1 : 0)) == 0) break block106;
                                                                                                                                            n29 = n10;
                                                                                                                                            n10 = n30;
                                                                                                                                            if ((n30 = (int)(object.isNull(n30) ? 1 : 0)) == 0) break block107;
                                                                                                                                            n30 = n10;
                                                                                                                                            n10 = n31;
                                                                                                                                            if ((n31 = (int)(object.isNull(n31) ? 1 : 0)) == 0) break block108;
                                                                                                                                            n31 = n10;
                                                                                                                                            n10 = n32;
                                                                                                                                            if ((n32 = (int)(object.isNull(n32) ? 1 : 0)) == 0) break block109;
                                                                                                                                            n32 = n10;
                                                                                                                                            n10 = n33;
                                                                                                                                            if ((n33 = (int)(object.isNull(n33) ? 1 : 0)) == 0) break block110;
                                                                                                                                            n33 = n14;
                                                                                                                                            n14 = n34;
                                                                                                                                            if ((n34 = (int)(object.isNull(n34) ? 1 : 0)) == 0) break block111;
                                                                                                                                            n34 = n25;
                                                                                                                                            n25 = n35;
                                                                                                                                            if ((n35 = (int)(object.isNull(n35) ? 1 : 0)) == 0) break block112;
                                                                                                                                            n35 = n24;
                                                                                                                                            n24 = n36;
                                                                                                                                            if ((n36 = (int)(object.isNull(n36) ? 1 : 0)) == 0) break block113;
                                                                                                                                            n36 = n23;
                                                                                                                                            n23 = n37;
                                                                                                                                            boolean bl8 = object.isNull(n37);
                                                                                                                                            if (!bl8) break block114;
                                                                                                                                            int n49 = n47;
                                                                                                                                            int n50 = n38;
                                                                                                                                            boolean bl9 = object.isNull(n38);
                                                                                                                                            if (!bl9) break block115;
                                                                                                                                            n16 = 0;
                                                                                                                                            object2 = null;
                                                                                                                                            break block116;
                                                                                                                                        }
                                                                                                                                        n32 = n10;
                                                                                                                                        break block117;
                                                                                                                                    }
                                                                                                                                    n31 = n10;
                                                                                                                                    break block117;
                                                                                                                                }
                                                                                                                                n30 = n10;
                                                                                                                                break block117;
                                                                                                                            }
                                                                                                                            n29 = n10;
                                                                                                                            break block117;
                                                                                                                        }
                                                                                                                        n28 = n10;
                                                                                                                        break block117;
                                                                                                                    }
                                                                                                                    n27 = n10;
                                                                                                                    break block117;
                                                                                                                }
                                                                                                                object13 = object5;
                                                                                                            }
                                                                                                            n10 = n33;
                                                                                                        }
                                                                                                        n33 = n14;
                                                                                                        n14 = n34;
                                                                                                    }
                                                                                                    n34 = n25;
                                                                                                    n25 = n35;
                                                                                                }
                                                                                                n35 = n24;
                                                                                                n24 = n36;
                                                                                            }
                                                                                            n36 = n23;
                                                                                            n23 = n37;
                                                                                        }
                                                                                        int n51 = n47;
                                                                                        int n52 = n38;
                                                                                        break block115;
                                                                                    }
                                                                                    object14 = object4;
                                                                                    n14 = n34;
                                                                                    n34 = n25;
                                                                                    n25 = n35;
                                                                                    n35 = n24;
                                                                                    n24 = n36;
                                                                                    n36 = n23;
                                                                                    n23 = n37;
                                                                                    int n53 = n47;
                                                                                    int n54 = n38;
                                                                                    object13 = object5;
                                                                                    n10 = n33;
                                                                                    n33 = n26;
                                                                                    break block115;
                                                                                }
                                                                                object15 = object12;
                                                                                n25 = n35;
                                                                                n35 = n24;
                                                                                n24 = n36;
                                                                                n36 = n23;
                                                                                n23 = n37;
                                                                                int n55 = n47;
                                                                                int n56 = n38;
                                                                                object14 = object4;
                                                                                n14 = n34;
                                                                                n34 = n39;
                                                                                object13 = object5;
                                                                                n10 = n33;
                                                                                n33 = n26;
                                                                                break block115;
                                                                            }
                                                                            object16 = object11;
                                                                            n24 = n36;
                                                                            n36 = n23;
                                                                            n23 = n37;
                                                                            int n57 = n47;
                                                                            int n58 = n38;
                                                                            object14 = object4;
                                                                            n14 = n34;
                                                                            n34 = n39;
                                                                            object13 = object5;
                                                                            n10 = n33;
                                                                            n33 = n26;
                                                                            object15 = object12;
                                                                            n25 = n35;
                                                                            n35 = n40;
                                                                            break block115;
                                                                        }
                                                                        arrayList6 = arrayList5;
                                                                        n23 = n37;
                                                                        int n59 = n47;
                                                                        int n60 = n38;
                                                                        object14 = object4;
                                                                        n14 = n34;
                                                                        n34 = n39;
                                                                        object13 = object5;
                                                                        n10 = n33;
                                                                        n33 = n26;
                                                                        object16 = object11;
                                                                        n24 = n36;
                                                                        n36 = n41;
                                                                        object15 = object12;
                                                                        n25 = n35;
                                                                        n35 = n40;
                                                                        break block115;
                                                                    }
                                                                    bl5 = bl3;
                                                                    break block94;
                                                                }
                                                                bl5 = bl3;
                                                                break block118;
                                                            }
                                                            bl5 = bl3;
                                                            n17 = n13;
                                                        }
                                                        n18 = n12;
                                                        break block94;
                                                    }
                                                    bl5 = bl3;
                                                    n16 = n11;
                                                }
                                                arrayList10 = arrayList;
                                                int n61 = n46;
                                            }
                                            arrayList9 = arrayList2;
                                            n19 = n45;
                                        }
                                        arrayList8 = arrayList3;
                                        n20 = n44;
                                    }
                                    arrayList7 = arrayList4;
                                    n21 = n43;
                                }
                                object17 = object10;
                                int n62 = n38;
                                object14 = object4;
                                n14 = n34;
                                n34 = n39;
                                object13 = object5;
                                n10 = n33;
                                n33 = n26;
                                arrayList6 = arrayList5;
                                n23 = n37;
                                int n63 = n42;
                                object16 = object11;
                                n24 = n36;
                                n36 = n41;
                                object15 = object12;
                                n25 = n35;
                                n35 = n40;
                            }
                            boolean bl10 = object.isNull(n10);
                            if (bl10 && (bl7 = object.isNull(n14)) && (bl6 = object.isNull(n25))) {
                                int n64 = n21;
                                n21 = 0;
                                arrayList4 = null;
                            } else {
                                boolean bl11 = object.isNull(n10);
                                if (bl11) {
                                    n10 = 0;
                                    object5 = null;
                                } else {
                                    object5 = object.getString(n10);
                                }
                                boolean bl12 = object.isNull(n14);
                                if (bl12) {
                                    n14 = 0;
                                    object4 = null;
                                } else {
                                    object4 = object.getString(n14);
                                }
                                boolean bl13 = object.isNull(n25);
                                if (bl13) {
                                    int n65 = n21;
                                    n25 = 0;
                                    object12 = null;
                                } else {
                                    object12 = object.getString(n25);
                                    int n66 = n21;
                                }
                                arrayList4 = new ArrayList((String)object5, (String)object4, (String)object12);
                            }
                            n14 = (int)(object.isNull(n24) ? 1 : 0);
                            if (n14 != 0 && (n14 = (int)(object.isNull(n23) ? 1 : 0)) != 0 && (n14 = (int)(object.isNull((int)var23_40) ? 1 : 0)) != 0) {
                                n14 = 0;
                                object4 = null;
                            } else {
                                n14 = object.getInt(n24);
                                n10 = object.getInt(n23);
                                int n67 = object.getInt((int)var23_40);
                                object4 = ScriptDataExt.create(n14, n10, n67);
                            }
                            object5 = new TemplateData();
                            l12 = object.getLong(n15);
                            ((TemplateData)object5).setId(l12);
                            l12 = object.getLong(n16);
                            ((TemplateData)object5).setId(l12);
                            n16 = (int)(object.isNull(n17) ? 1 : 0);
                            if (n16 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString(n17);
                            }
                            ((TemplateData)object5).setTextZh((String)object2);
                            n16 = (int)(object.isNull(n18) ? 1 : 0);
                            if (n16 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString(n18);
                            }
                            ((TemplateData)object5).setTextZhTw((String)object2);
                            n16 = (int)(object.isNull((int)(bl5 ? 1 : 0)) ? 1 : 0);
                            if (n16 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString((int)(bl5 ? 1 : 0));
                            }
                            ((TemplateData)object5).setTextEn((String)object2);
                            n16 = (int)(object.isNull((int)var15_21) ? 1 : 0);
                            if (n16 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString((int)var15_21);
                            }
                            ((TemplateData)object5).setCoverUrl((String)object2);
                            n16 = (int)(object.isNull(n19) ? 1 : 0);
                            if (n16 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString(n19);
                            }
                            ((TemplateData)object5).setVideoUrl((String)object2);
                            double d10 = object.getDouble(n20);
                            ((TemplateData)object5).setVideoTime(d10);
                            n16 = var43_83;
                            n16 = object.getInt((int)var43_83);
                            ((TemplateData)object5).setVideoCount(n16);
                            n16 = var42_70;
                            bl5 = object.isNull((int)var42_70);
                            if (bl5) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString((int)var42_70);
                            }
                            ((TemplateData)object5).setVideoRatio((String)object2);
                            n16 = n36;
                            n16 = object.getInt(n36);
                            ((TemplateData)object5).setResSize(n16);
                            n16 = n35;
                            n16 = object.getInt(n35);
                            bl5 = false;
                            object3 = null;
                            if (n16 != 0) {
                                n16 = 1;
                            } else {
                                n16 = 0;
                                object2 = null;
                            }
                            ((TemplateData)object5).setPrimeUsable(n16 != 0);
                            n16 = n34;
                            n16 = object.getInt(n34);
                            ((TemplateData)object5).setTempType(n16);
                            n16 = n33;
                            n16 = object.getInt(n33);
                            if (n16 != 0) {
                                n16 = 1;
                            } else {
                                n16 = 0;
                                object2 = null;
                            }
                            ((TemplateData)object5).setDownloadFinished(n16 != 0);
                            n16 = n27;
                            n17 = (int)(object.isNull(n27) ? 1 : 0);
                            if (n17 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                l10 = object.getLong(n27);
                                object2 = l10;
                            }
                            ((TemplateData)object5).setDownloadTimestamp((Long)object2);
                            n16 = n28;
                            n17 = (int)(object.isNull(n28) ? 1 : 0);
                            if (n17 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString(n28);
                            }
                            ((TemplateData)object5).setEditorTemplate((String)object2);
                            n16 = n29;
                            n17 = (int)(object.isNull(n29) ? 1 : 0);
                            if (n17 != 0) {
                                n16 = 0;
                                object2 = null;
                            } else {
                                object2 = object.getString(n29);
                            }
                            ((TemplateData)object5).setTrackEditorConfigData((String)object2);
                            n16 = n30;
                            n16 = object.getInt(n30);
                            ((TemplateData)object5).setTemplateUseType(n16);
                            n16 = n31;
                            n16 = object.getInt(n31);
                            ((TemplateData)object5).setTemplateProtocolType(n16);
                            n16 = n32;
                            n16 = object.getInt(n32);
                            if (n16 != 0) {
                                bl5 = true;
                            }
                            ((TemplateData)object5).setFirstLoaded(bl5);
                            ((TemplateData)object5).setTemplateDescription((TemplateDescription)((Object)arrayList4));
                            ((TemplateData)object5).setScriptDataExt((ScriptDataExt)object4);
                            object2 = object5;
                        }
                        bl5 = object.isNull(n15);
                        if (!bl5) {
                            l11 = object.getLong(n15);
                            object3 = object13;
                            object3 = ((LongSparseArray)object13).get(l11);
                            object3 = (Template)object3;
                        } else {
                            bl5 = false;
                            object3 = null;
                        }
                        n14 = (int)(object.isNull(n15) ? 1 : 0);
                        if (n14 == 0) {
                            l11 = object.getLong(n15);
                            object8 = object14;
                            object4 = ((LongSparseArray)object14).get(l11);
                            object4 = (Script)object4;
                        } else {
                            n14 = 0;
                            object4 = null;
                        }
                        n10 = object.isNull(n15);
                        if (n10 == 0) {
                            long l13 = object.getLong(n15);
                            object9 = object15;
                            object5 = ((LongSparseArray)object15).get(l13);
                            object5 = (Draft)object5;
                        } else {
                            n10 = 0;
                            object5 = null;
                        }
                        n17 = (int)(object.isNull(n15) ? 1 : 0);
                        if (n17 == 0) {
                            l10 = object.getLong(n15);
                            arrayList = object16;
                            object8 = ((LongSparseArray)object16).get(l10);
                            object8 = (Withdraw)object8;
                        } else {
                            n17 = 0;
                            object8 = null;
                        }
                        n18 = (int)(object.isNull(n15) ? 1 : 0);
                        if (n18 == 0) {
                            long l14 = object.getLong(n15);
                            arrayList2 = arrayList6;
                            object9 = ((LongSparseArray)((Object)arrayList6)).get(l14);
                            object9 = (TemplateGlobal)object9;
                        } else {
                            n18 = 0;
                            object9 = null;
                        }
                        boolean bl14 = object.isNull(n15);
                        if (!bl14) {
                            long l15 = object.getLong(n15);
                            arrayList3 = object17;
                            arrayList = ((LongSparseArray)object17).get(l15);
                        } else {
                            boolean bl15 = false;
                            arrayList = null;
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        if ((n19 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            long l16 = object.getLong(n15);
                            arrayList4 = arrayList7;
                            arrayList2 = ((LongSparseArray)((Object)arrayList7)).get(l16);
                        } else {
                            n19 = 0;
                            arrayList2 = null;
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        if ((n20 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            long l17 = object.getLong(n15);
                            object10 = arrayList8;
                            arrayList3 = ((LongSparseArray)((Object)arrayList8)).get(l17);
                        } else {
                            n20 = 0;
                            arrayList3 = null;
                        }
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        if ((n21 = (int)(object.isNull(n15) ? 1 : 0)) == 0) {
                            long l18 = object.getLong(n15);
                            arrayList5 = arrayList9;
                            arrayList4 = ((LongSparseArray)((Object)arrayList9)).get(l18);
                        } else {
                            n21 = 0;
                            arrayList4 = null;
                        }
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        if (!(bl4 = object.isNull(n15))) {
                            l12 = object.getLong(n15);
                            object6 = arrayList10;
                            object6 = ((LongSparseArray)((Object)arrayList10)).get(l12);
                            object7 = object6 = (ArrayList)object6;
                        } else {
                            object7 = null;
                        }
                        if (object7 == null) {
                            object7 = new ArrayList();
                        }
                        object6 = object7;
                        object10 = new TemplatePOJO();
                        ((TemplatePOJO)object10).setTemplateData((TemplateData)object2);
                        ((TemplatePOJO)object10).setTemplate((Template)object3);
                        ((TemplatePOJO)object10).setScript((Script)object4);
                        ((TemplatePOJO)object10).setDraft((Draft)object5);
                        ((TemplatePOJO)object10).setWithdraw((Withdraw)object8);
                        ((TemplatePOJO)object10).setTemplateGlobal((TemplateGlobal)object9);
                        ((TemplatePOJO)object10).setTemplateVideoList(arrayList);
                        ((TemplatePOJO)object10).setTemplateStickerList(arrayList2);
                        ((TemplatePOJO)object10).setTemplateMusicList(arrayList3);
                        ((TemplatePOJO)object10).setTemplateRecordingList(arrayList4);
                        ((TemplatePOJO)object10).setScriptTrackPOJOList((List)object7);
                        object5 = object10;
                        break block88;
                    }
                    catch (Throwable throwable) {
                        object3 = this;
                        break block89;
                    }
                }
                n10 = 0;
                object5 = null;
            }
            if (object5 != null) {
                object3 = this;
                object2 = this.this$0;
                object2 = G_WithdrawDao_Impl.access$000((G_WithdrawDao_Impl)object2);
                ((RoomDatabase)object2).setTransactionSuccessful();
                object.close();
                G_WithdrawDao_Impl.access$000(this.this$0).endTransaction();
                return object5;
            }
            object3 = this;
            try {
                object6 = new StringBuilder();
                object4 = "Query returned empty result set: ";
                ((StringBuilder)object6).append((String)object4);
                object4 = this.val$_statement;
                object4 = ((RoomSQLiteQuery)object4).getSql();
                ((StringBuilder)object6).append((String)object4);
                object6 = ((StringBuilder)object6).toString();
                object2 = new EmptyResultSetException((String)object6);
                throw object2;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            object.close();
            throw object2;
        }
        catch (Throwable throwable) {
            G_WithdrawDao_Impl.access$000(((G_WithdrawDao_Impl$16)object3).this$0).endTransaction();
            throw throwable;
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

