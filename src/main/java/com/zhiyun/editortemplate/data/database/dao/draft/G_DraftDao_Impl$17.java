/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_DraftDao_Impl$17
implements Callable {
    public final /* synthetic */ G_DraftDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_DraftDao_Impl$17(G_DraftDao_Impl g_DraftDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_DraftDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List call() {
        block383: {
            var1_1 = this;
            var2_2 = "id";
            var3_6 = G_DraftDao_Impl.access$000(this.this$0);
            var3_6.beginTransaction();
            var3_6 = this.this$0;
            var3_6 = G_DraftDao_Impl.access$000((G_DraftDao_Impl)var3_6);
            var4_7 = this.val$_statement;
            var5_8 = true;
            var6_9 = false;
            var7_10 = null;
            var3_6 = DBUtil.query((RoomDatabase)var3_6, (SupportSQLiteQuery)var4_7, var5_8, null);
            var8_11 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var2_2);
            var9_12 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var2_2);
            var10_13 = "title_zh";
            var11_14 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var10_13);
            var12_15 = "title_tw";
            var13_16 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var12_15);
            var14_17 = "title_en";
            var15_18 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var14_17);
            var16_19 = "cover_url";
            var17_20 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var16_19);
            var18_21 = "video_url";
            var19_22 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var18_21);
            var20_23 = "video_time";
            var21_24 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var20_23);
            var22_25 = "video_count";
            var23_26 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var22_25);
            var24_27 = "video_ratio";
            var25_28 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var24_27);
            var26_29 = "res_size";
            var27_30 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var26_29);
            var28_31 = "is_prime_usable";
            var29_32 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var28_31);
            var30_33 = "temp_type";
            var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var30_33);
            var7_10 = "download_finished";
            var31_34 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "download_timestamp";
            var32_35 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "editor_template";
            var33_36 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "track_editor_config_data";
            var34_37 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "template_use_type";
            var35_38 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "template_proto_type";
            var36_39 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "first_loaded";
            var37_40 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "template_description_zh";
            var38_41 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "template_description_en";
            var39_42 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "template_description_zh_tw";
            var40_43 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "script_ext_status";
            var41_44 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "script_ext_protocol";
            var42_45 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = "script_ext_version";
            var43_46 = var6_9 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var7_10);
            var7_10 = new ArrayList<E>();
            var44_47 = var5_8;
            var30_33 = new LongSparseArray();
            var45_48 = var29_32;
            var28_31 = new ArrayList<E>();
            var46_49 = var27_30;
            var26_29 = new ArrayList<E>();
            var47_50 = var25_28;
            var24_27 = new ArrayList<E>();
            var48_51 = var23_26;
            var22_25 = new ArrayList<E>();
            var49_52 = var21_24;
            var20_23 = new ArrayList<E>();
            var50_53 = var19_22;
            var18_21 = new ArrayList<E>();
            var51_54 = var17_20;
            var16_19 = new LongSparseArray();
            var52_55 = var15_18;
            var14_17 = new LongSparseArray();
            ** while (var53_56 = var3_6.moveToNext())
lbl-1000:
            // 1 sources

            {
                block304: {
                    block303: {
                        block302: {
                            block301: {
                                block300: {
                                    block299: {
                                        block298: {
                                            block297: {
                                                block296: {
                                                    block295: {
                                                        block294: {
                                                            block293: {
                                                                var53_56 = var3_6.isNull(var8_11);
                                                                if (var53_56) break block293;
                                                                var53_56 = var11_14;
                                                                var54_57 = var13_16;
                                                                var55_58 = var3_6.getLong(var8_11);
                                                                var57_59 = var9_12;
                                                                var9_12 = false;
                                                                var2_2 = null;
                                                                var7_10.put(var55_58, null);
                                                                break block294;
                                                            }
                                                            var57_59 = var9_12;
                                                            var53_56 = var11_14;
                                                            var54_57 = var13_16;
                                                        }
                                                        var9_12 = var3_6.isNull(var8_11);
                                                        if (var9_12) break block295;
                                                        var55_58 = var3_6.getLong(var8_11);
                                                        var9_12 = false;
                                                        var2_2 = null;
                                                        var30_33.put(var55_58, null);
                                                    }
                                                    var9_12 = var3_6.isNull(var8_11);
                                                    if (var9_12) break block296;
                                                    var55_58 = var3_6.getLong(var8_11);
                                                    var9_12 = false;
                                                    var2_2 = null;
                                                    var28_31.put(var55_58, null);
                                                }
                                                var9_12 = var3_6.isNull(var8_11);
                                                if (var9_12) break block297;
                                                var55_58 = var3_6.getLong(var8_11);
                                                var9_12 = false;
                                                var2_2 = null;
                                                var26_29.put(var55_58, null);
                                            }
                                            var9_12 = var3_6.isNull(var8_11);
                                            if (var9_12) break block298;
                                            var55_58 = var3_6.getLong(var8_11);
                                            var9_12 = false;
                                            var2_2 = null;
                                            var24_27.put(var55_58, null);
                                            break block299;
                                        }
                                        var9_12 = false;
                                        var2_2 = null;
                                    }
                                    var11_14 = var3_6.isNull(var8_11);
                                    if (var11_14) break block300;
                                    var55_58 = var3_6.getLong(var8_11);
                                    var58_60 = var22_25.get(var55_58);
                                    var58_60 = (ArrayList)var58_60;
                                    if (var58_60 != null) break block300;
                                    var2_2 = new ArrayList<ArrayList<E>>();
                                    var22_25.put(var55_58, var2_2);
                                }
                                var9_12 = var3_6.isNull(var8_11);
                                if (var9_12) break block301;
                                var55_58 = var3_6.getLong(var8_11);
                                var2_2 = var20_23.get(var55_58);
                                var2_2 = var2_2;
                                if (var2_2 != null) break block301;
                                var2_2 = new ArrayList<ArrayList<E>>();
                                var20_23.put(var55_58, var2_2);
                            }
                            var9_12 = var3_6.isNull(var8_11);
                            if (var9_12) break block302;
                            var55_58 = var3_6.getLong(var8_11);
                            var2_2 = var18_21.get(var55_58);
                            var2_2 = var2_2;
                            if (var2_2 != null) break block302;
                            var2_2 = new ArrayList<ArrayList<E>>();
                            var18_21.put(var55_58, var2_2);
                        }
                        var9_12 = var3_6.isNull(var8_11);
                        if (var9_12) break block303;
                        var55_58 = var3_6.getLong(var8_11);
                        var2_2 = var16_19.get(var55_58);
                        var2_2 = var2_2;
                        if (var2_2 != null) break block303;
                        var2_2 = new ArrayList<ArrayList<E>>();
                        var16_19.put(var55_58, var2_2);
                    }
                    var9_12 = var3_6.isNull(var8_11);
                    if (var9_12) break block304;
                    var55_58 = var3_6.getLong(var8_11);
                    var2_2 = var14_17.get(var55_58);
                    var2_2 = var2_2;
                    if (var2_2 != null) break block304;
                    var2_2 = new ArrayList<ArrayList<E>>();
                    var14_17.put(var55_58, var2_2);
                }
                var11_14 = var53_56;
                var13_16 = var54_57;
                var9_12 = var57_59;
                continue;
            }
lbl263:
            // 1 sources

            var57_59 = var9_12;
            var53_56 = var11_14;
            var54_57 = var13_16;
            var9_12 = -1 != 0;
            var3_6.moveToPosition((int)var9_12);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$400((G_DraftDao_Impl)var2_2, (LongSparseArray)var7_10);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$500((G_DraftDao_Impl)var2_2, (LongSparseArray)var30_33);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$600((G_DraftDao_Impl)var2_2, (LongSparseArray)var28_31);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$700((G_DraftDao_Impl)var2_2, (LongSparseArray)var26_29);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$800((G_DraftDao_Impl)var2_2, (LongSparseArray)var24_27);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$900((G_DraftDao_Impl)var2_2, (LongSparseArray)var22_25);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$1000((G_DraftDao_Impl)var2_2, (LongSparseArray)var20_23);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$1100((G_DraftDao_Impl)var2_2, (LongSparseArray)var18_21);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$1200(var2_2, (LongSparseArray)var16_19);
            var2_2 = var1_1.this$0;
            G_DraftDao_Impl.access$1300(var2_2, (LongSparseArray)var14_17);
            var11_14 = var3_6.getCount();
            var2_2 = new ArrayList<ArrayList<E>>((int)var11_14);
            ** while (var11_14 = (boolean)var3_6.moveToNext())
lbl-1000:
            // 1 sources

            {
                block382: {
                    block381: {
                        block380: {
                            block379: {
                                block378: {
                                    block377: {
                                        block376: {
                                            block375: {
                                                block374: {
                                                    block373: {
                                                        block372: {
                                                            block371: {
                                                                block370: {
                                                                    block369: {
                                                                        block368: {
                                                                            block367: {
                                                                                block366: {
                                                                                    block365: {
                                                                                        block364: {
                                                                                            block363: {
                                                                                                block331: {
                                                                                                    block362: {
                                                                                                        block361: {
                                                                                                            block360: {
                                                                                                                block359: {
                                                                                                                    block358: {
                                                                                                                        block357: {
                                                                                                                            block356: {
                                                                                                                                block355: {
                                                                                                                                    block354: {
                                                                                                                                        block353: {
                                                                                                                                            block352: {
                                                                                                                                                block351: {
                                                                                                                                                    block350: {
                                                                                                                                                        block349: {
                                                                                                                                                            block348: {
                                                                                                                                                                block347: {
                                                                                                                                                                    block346: {
                                                                                                                                                                        block345: {
                                                                                                                                                                            block344: {
                                                                                                                                                                                block343: {
                                                                                                                                                                                    block342: {
                                                                                                                                                                                        block341: {
                                                                                                                                                                                            block340: {
                                                                                                                                                                                                block333: {
                                                                                                                                                                                                    block339: {
                                                                                                                                                                                                        block338: {
                                                                                                                                                                                                            block337: {
                                                                                                                                                                                                                block336: {
                                                                                                                                                                                                                    block335: {
                                                                                                                                                                                                                        block334: {
                                                                                                                                                                                                                            block332: {
                                                                                                                                                                                                                                block330: {
                                                                                                                                                                                                                                    block313: {
                                                                                                                                                                                                                                        block312: {
                                                                                                                                                                                                                                            block311: {
                                                                                                                                                                                                                                                block310: {
                                                                                                                                                                                                                                                    block309: {
                                                                                                                                                                                                                                                        block308: {
                                                                                                                                                                                                                                                            block305: {
                                                                                                                                                                                                                                                                block306: {
                                                                                                                                                                                                                                                                    block307: {
                                                                                                                                                                                                                                                                        block314: {
                                                                                                                                                                                                                                                                            block315: {
                                                                                                                                                                                                                                                                                block316: {
                                                                                                                                                                                                                                                                                    block317: {
                                                                                                                                                                                                                                                                                        block329: {
                                                                                                                                                                                                                                                                                            block328: {
                                                                                                                                                                                                                                                                                                block327: {
                                                                                                                                                                                                                                                                                                    block326: {
                                                                                                                                                                                                                                                                                                        block325: {
                                                                                                                                                                                                                                                                                                            block384: {
                                                                                                                                                                                                                                                                                                                block318: {
                                                                                                                                                                                                                                                                                                                    block319: {
                                                                                                                                                                                                                                                                                                                        block320: {
                                                                                                                                                                                                                                                                                                                            block321: {
                                                                                                                                                                                                                                                                                                                                block322: {
                                                                                                                                                                                                                                                                                                                                    block323: {
                                                                                                                                                                                                                                                                                                                                        block324: {
                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                var11_14 = var3_6.isNull(var8_11);
                                                                                                                                                                                                                                                                                                                                                if (!var11_14) break block305;
                                                                                                                                                                                                                                                                                                                                                var11_14 = var57_59;
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            catch (Throwable var2_3) {
                                                                                                                                                                                                                                                                                                                                                var1_1 = this;
                                                                                                                                                                                                                                                                                                                                                break block383;
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            var13_16 = var3_6.isNull((int)var57_59);
                                                                                                                                                                                                                                                                                                                                            if (!var13_16) break block306;
                                                                                                                                                                                                                                                                                                                                            var13_16 = var53_56;
                                                                                                                                                                                                                                                                                                                                            var53_56 = var3_6.isNull((int)var53_56);
                                                                                                                                                                                                                                                                                                                                            if (!var53_56) break block307;
                                                                                                                                                                                                                                                                                                                                            var59_61 = var54_57;
                                                                                                                                                                                                                                                                                                                                            var53_56 = var3_6.isNull((int)var54_57);
                                                                                                                                                                                                                                                                                                                                            if (!var53_56) break block308;
                                                                                                                                                                                                                                                                                                                                            var60_62 = var2_2;
                                                                                                                                                                                                                                                                                                                                            var9_12 = var52_55;
                                                                                                                                                                                                                                                                                                                                            var52_55 = var3_6.isNull((int)var52_55);
                                                                                                                                                                                                                                                                                                                                            if (!var52_55) break block309;
                                                                                                                                                                                                                                                                                                                                            var61_63 = var14_17;
                                                                                                                                                                                                                                                                                                                                            var15_18 = var51_54;
                                                                                                                                                                                                                                                                                                                                            var51_54 = var3_6.isNull((int)var51_54);
                                                                                                                                                                                                                                                                                                                                            if (!var51_54) break block310;
                                                                                                                                                                                                                                                                                                                                            var62_64 = var16_19;
                                                                                                                                                                                                                                                                                                                                            var17_20 = var50_53;
                                                                                                                                                                                                                                                                                                                                            var50_53 = var3_6.isNull((int)var50_53);
                                                                                                                                                                                                                                                                                                                                            if (!var50_53) break block311;
                                                                                                                                                                                                                                                                                                                                            var63_65 = var18_21;
                                                                                                                                                                                                                                                                                                                                            var19_22 = var49_52;
                                                                                                                                                                                                                                                                                                                                            var49_52 = var3_6.isNull((int)var49_52);
                                                                                                                                                                                                                                                                                                                                            if (!var49_52) break block312;
                                                                                                                                                                                                                                                                                                                                            var64_66 = var20_23;
                                                                                                                                                                                                                                                                                                                                            var21_24 = var48_51;
                                                                                                                                                                                                                                                                                                                                            var48_51 = var3_6.isNull((int)var48_51);
                                                                                                                                                                                                                                                                                                                                            if (!var48_51) break block313;
                                                                                                                                                                                                                                                                                                                                            var65_67 = var22_25;
                                                                                                                                                                                                                                                                                                                                            var23_26 = var47_50;
                                                                                                                                                                                                                                                                                                                                            var47_50 = var3_6.isNull((int)var47_50);
                                                                                                                                                                                                                                                                                                                                            if (!var47_50) break block314;
                                                                                                                                                                                                                                                                                                                                            var66_68 = var24_27;
                                                                                                                                                                                                                                                                                                                                            var25_28 = var46_49;
                                                                                                                                                                                                                                                                                                                                            var46_49 = var3_6.isNull((int)var46_49);
                                                                                                                                                                                                                                                                                                                                            if (!var46_49) break block315;
                                                                                                                                                                                                                                                                                                                                            var67_69 = var26_29;
                                                                                                                                                                                                                                                                                                                                            var27_30 = var45_48;
                                                                                                                                                                                                                                                                                                                                            var45_48 = var3_6.isNull((int)var45_48);
                                                                                                                                                                                                                                                                                                                                            if (!var45_48) break block316;
                                                                                                                                                                                                                                                                                                                                            var68_70 = var28_31;
                                                                                                                                                                                                                                                                                                                                            var29_32 = var44_47;
                                                                                                                                                                                                                                                                                                                                            var44_47 = var3_6.isNull((int)var44_47);
                                                                                                                                                                                                                                                                                                                                            if (!var44_47) break block317;
                                                                                                                                                                                                                                                                                                                                            var69_71 = var30_33;
                                                                                                                                                                                                                                                                                                                                            var5_8 = var31_34;
                                                                                                                                                                                                                                                                                                                                            var31_34 = var3_6.isNull((int)var31_34);
                                                                                                                                                                                                                                                                                                                                            if (!var31_34) break block318;
                                                                                                                                                                                                                                                                                                                                            var70_72 = var7_10;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var32_35;
                                                                                                                                                                                                                                                                                                                                            var32_35 = var3_6.isNull((int)var32_35);
                                                                                                                                                                                                                                                                                                                                            if (!var32_35) break block319;
                                                                                                                                                                                                                                                                                                                                            var32_35 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var33_36;
                                                                                                                                                                                                                                                                                                                                            var33_36 = var3_6.isNull((int)var33_36);
                                                                                                                                                                                                                                                                                                                                            if (!var33_36) break block320;
                                                                                                                                                                                                                                                                                                                                            var33_36 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var34_37;
                                                                                                                                                                                                                                                                                                                                            var34_37 = var3_6.isNull((int)var34_37);
                                                                                                                                                                                                                                                                                                                                            if (!var34_37) break block321;
                                                                                                                                                                                                                                                                                                                                            var34_37 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var35_38;
                                                                                                                                                                                                                                                                                                                                            var35_38 = var3_6.isNull((int)var35_38);
                                                                                                                                                                                                                                                                                                                                            if (!var35_38) break block322;
                                                                                                                                                                                                                                                                                                                                            var35_38 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var36_39;
                                                                                                                                                                                                                                                                                                                                            var36_39 = var3_6.isNull((int)var36_39);
                                                                                                                                                                                                                                                                                                                                            if (!var36_39) break block323;
                                                                                                                                                                                                                                                                                                                                            var36_39 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var37_40;
                                                                                                                                                                                                                                                                                                                                            var37_40 = var3_6.isNull((int)var37_40);
                                                                                                                                                                                                                                                                                                                                            if (!var37_40) break block324;
                                                                                                                                                                                                                                                                                                                                            var37_40 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var6_9 = var38_41;
                                                                                                                                                                                                                                                                                                                                            var38_41 = var3_6.isNull((int)var38_41);
                                                                                                                                                                                                                                                                                                                                            if (!var38_41) break block325;
                                                                                                                                                                                                                                                                                                                                            var38_41 = var5_8;
                                                                                                                                                                                                                                                                                                                                            var5_8 = var39_42;
                                                                                                                                                                                                                                                                                                                                            var39_42 = var3_6.isNull((int)var39_42);
                                                                                                                                                                                                                                                                                                                                            if (!var39_42) break block326;
                                                                                                                                                                                                                                                                                                                                            var39_42 = var29_32;
                                                                                                                                                                                                                                                                                                                                            var29_32 = var40_43;
                                                                                                                                                                                                                                                                                                                                            var40_43 = var3_6.isNull((int)var40_43);
                                                                                                                                                                                                                                                                                                                                            if (!var40_43) break block327;
                                                                                                                                                                                                                                                                                                                                            var40_43 = var27_30;
                                                                                                                                                                                                                                                                                                                                            var27_30 = var41_44;
                                                                                                                                                                                                                                                                                                                                            var41_44 = var3_6.isNull((int)var41_44);
                                                                                                                                                                                                                                                                                                                                            if (!var41_44) break block328;
                                                                                                                                                                                                                                                                                                                                            var41_44 = var25_28;
                                                                                                                                                                                                                                                                                                                                            var25_28 = var42_45;
                                                                                                                                                                                                                                                                                                                                            var42_45 = var3_6.isNull((int)var42_45);
                                                                                                                                                                                                                                                                                                                                            if (!var42_45) break block329;
                                                                                                                                                                                                                                                                                                                                            var42_45 = var23_26;
                                                                                                                                                                                                                                                                                                                                            var23_26 = var43_46;
                                                                                                                                                                                                                                                                                                                                            var43_46 = var3_6.isNull((int)var43_46);
                                                                                                                                                                                                                                                                                                                                            if (!var43_46) break block330;
                                                                                                                                                                                                                                                                                                                                            var43_46 = var9_12;
                                                                                                                                                                                                                                                                                                                                            var57_59 = var5_8;
                                                                                                                                                                                                                                                                                                                                            var54_57 = var6_9;
                                                                                                                                                                                                                                                                                                                                            var71_73 = var23_26;
                                                                                                                                                                                                                                                                                                                                            var72_74 = var29_32;
                                                                                                                                                                                                                                                                                                                                            var73_75 = var32_35;
                                                                                                                                                                                                                                                                                                                                            var32_35 = var38_41;
                                                                                                                                                                                                                                                                                                                                            var38_41 = var39_42;
                                                                                                                                                                                                                                                                                                                                            var39_42 = var40_43;
                                                                                                                                                                                                                                                                                                                                            var40_43 = var41_44;
                                                                                                                                                                                                                                                                                                                                            var9_12 = false;
                                                                                                                                                                                                                                                                                                                                            var2_2 = null;
                                                                                                                                                                                                                                                                                                                                            var41_44 = var59_61;
                                                                                                                                                                                                                                                                                                                                            var23_26 = var21_24;
                                                                                                                                                                                                                                                                                                                                            var29_32 = var25_28;
                                                                                                                                                                                                                                                                                                                                            var59_61 = var36_39;
                                                                                                                                                                                                                                                                                                                                            var25_28 = var42_45;
                                                                                                                                                                                                                                                                                                                                            break block331;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        var37_40 = var6_9;
                                                                                                                                                                                                                                                                                                                                        break block384;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    var36_39 = var6_9;
                                                                                                                                                                                                                                                                                                                                    break block384;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                var35_38 = var6_9;
                                                                                                                                                                                                                                                                                                                                break block384;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            var34_37 = var6_9;
                                                                                                                                                                                                                                                                                                                            break block384;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        var33_36 = var6_9;
                                                                                                                                                                                                                                                                                                                        break block384;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    var32_35 = var6_9;
                                                                                                                                                                                                                                                                                                                    break block384;
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                var70_72 = var7_10;
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            var6_9 = var38_41;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        var38_41 = var5_8;
                                                                                                                                                                                                                                                                                                        var5_8 = var39_42;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    var39_42 = var29_32;
                                                                                                                                                                                                                                                                                                    var29_32 = var40_43;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                var40_43 = var27_30;
                                                                                                                                                                                                                                                                                                var27_30 = var41_44;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            var41_44 = var25_28;
                                                                                                                                                                                                                                                                                            var25_28 = var42_45;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        var42_45 = var23_26;
                                                                                                                                                                                                                                                                                        var23_26 = var43_46;
                                                                                                                                                                                                                                                                                        break block330;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    var69_71 = var30_33;
                                                                                                                                                                                                                                                                                    var5_8 = var39_42;
                                                                                                                                                                                                                                                                                    var39_42 = var29_32;
                                                                                                                                                                                                                                                                                    var29_32 = var40_43;
                                                                                                                                                                                                                                                                                    var40_43 = var27_30;
                                                                                                                                                                                                                                                                                    var27_30 = var41_44;
                                                                                                                                                                                                                                                                                    var41_44 = var25_28;
                                                                                                                                                                                                                                                                                    var25_28 = var42_45;
                                                                                                                                                                                                                                                                                    var42_45 = var23_26;
                                                                                                                                                                                                                                                                                    var23_26 = var43_46;
                                                                                                                                                                                                                                                                                    var70_72 = var7_10;
                                                                                                                                                                                                                                                                                    var6_9 = var38_41;
                                                                                                                                                                                                                                                                                    var38_41 = var31_34;
                                                                                                                                                                                                                                                                                    break block330;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                var68_70 = var28_31;
                                                                                                                                                                                                                                                                                var29_32 = var40_43;
                                                                                                                                                                                                                                                                                var40_43 = var27_30;
                                                                                                                                                                                                                                                                                var27_30 = var41_44;
                                                                                                                                                                                                                                                                                var41_44 = var25_28;
                                                                                                                                                                                                                                                                                var25_28 = var42_45;
                                                                                                                                                                                                                                                                                var42_45 = var23_26;
                                                                                                                                                                                                                                                                                var23_26 = var43_46;
                                                                                                                                                                                                                                                                                var69_71 = var30_33;
                                                                                                                                                                                                                                                                                var5_8 = var39_42;
                                                                                                                                                                                                                                                                                var39_42 = var44_47;
                                                                                                                                                                                                                                                                                var70_72 = var7_10;
                                                                                                                                                                                                                                                                                var6_9 = var38_41;
                                                                                                                                                                                                                                                                                var38_41 = var31_34;
                                                                                                                                                                                                                                                                                break block330;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            var67_69 = var26_29;
                                                                                                                                                                                                                                                                            var27_30 = var41_44;
                                                                                                                                                                                                                                                                            var41_44 = var25_28;
                                                                                                                                                                                                                                                                            var25_28 = var42_45;
                                                                                                                                                                                                                                                                            var42_45 = var23_26;
                                                                                                                                                                                                                                                                            var23_26 = var43_46;
                                                                                                                                                                                                                                                                            var69_71 = var30_33;
                                                                                                                                                                                                                                                                            var5_8 = var39_42;
                                                                                                                                                                                                                                                                            var39_42 = var44_47;
                                                                                                                                                                                                                                                                            var70_72 = var7_10;
                                                                                                                                                                                                                                                                            var6_9 = var38_41;
                                                                                                                                                                                                                                                                            var38_41 = var31_34;
                                                                                                                                                                                                                                                                            var68_70 = var28_31;
                                                                                                                                                                                                                                                                            var29_32 = var40_43;
                                                                                                                                                                                                                                                                            var40_43 = var45_48;
                                                                                                                                                                                                                                                                            break block330;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        var66_68 = var24_27;
                                                                                                                                                                                                                                                                        var25_28 = var42_45;
                                                                                                                                                                                                                                                                        var42_45 = var23_26;
                                                                                                                                                                                                                                                                        var23_26 = var43_46;
                                                                                                                                                                                                                                                                        var69_71 = var30_33;
                                                                                                                                                                                                                                                                        var5_8 = var39_42;
                                                                                                                                                                                                                                                                        var39_42 = var44_47;
                                                                                                                                                                                                                                                                        var70_72 = var7_10;
                                                                                                                                                                                                                                                                        var6_9 = var38_41;
                                                                                                                                                                                                                                                                        var38_41 = var31_34;
                                                                                                                                                                                                                                                                        var67_69 = var26_29;
                                                                                                                                                                                                                                                                        var27_30 = var41_44;
                                                                                                                                                                                                                                                                        var41_44 = var46_49;
                                                                                                                                                                                                                                                                        var68_70 = var28_31;
                                                                                                                                                                                                                                                                        var29_32 = var40_43;
                                                                                                                                                                                                                                                                        var40_43 = var45_48;
                                                                                                                                                                                                                                                                        break block330;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    var60_62 = var2_2;
                                                                                                                                                                                                                                                                    var9_12 = var52_55;
                                                                                                                                                                                                                                                                    var59_61 = var54_57;
                                                                                                                                                                                                                                                                    break block309;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                var13_16 = var53_56;
                                                                                                                                                                                                                                                                var59_61 = var54_57;
                                                                                                                                                                                                                                                                break block308;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            var13_16 = var53_56;
                                                                                                                                                                                                                                                            var59_61 = var54_57;
                                                                                                                                                                                                                                                            var11_14 = var57_59;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        var60_62 = var2_2;
                                                                                                                                                                                                                                                        var9_12 = var52_55;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    var61_63 = var14_17;
                                                                                                                                                                                                                                                    var15_18 = var51_54;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                var62_64 = var16_19;
                                                                                                                                                                                                                                                var17_20 = var50_53;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            var63_65 = var18_21;
                                                                                                                                                                                                                                            var19_22 = var49_52;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        var64_66 = var20_23;
                                                                                                                                                                                                                                        var21_24 = var48_51;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    var65_67 = var22_25;
                                                                                                                                                                                                                                    var23_26 = var43_46;
                                                                                                                                                                                                                                    var69_71 = var30_33;
                                                                                                                                                                                                                                    var5_8 = var39_42;
                                                                                                                                                                                                                                    var39_42 = var44_47;
                                                                                                                                                                                                                                    var70_72 = var7_10;
                                                                                                                                                                                                                                    var6_9 = var38_41;
                                                                                                                                                                                                                                    var38_41 = var31_34;
                                                                                                                                                                                                                                    var66_68 = var24_27;
                                                                                                                                                                                                                                    var25_28 = var42_45;
                                                                                                                                                                                                                                    var42_45 = var47_50;
                                                                                                                                                                                                                                    var67_69 = var26_29;
                                                                                                                                                                                                                                    var27_30 = var41_44;
                                                                                                                                                                                                                                    var41_44 = var46_49;
                                                                                                                                                                                                                                    var68_70 = var28_31;
                                                                                                                                                                                                                                    var29_32 = var40_43;
                                                                                                                                                                                                                                    var40_43 = var45_48;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                var43_46 = var3_6.isNull((int)var6_9);
                                                                                                                                                                                                                                if (!var43_46) break block332;
                                                                                                                                                                                                                                var43_46 = var3_6.isNull((int)var5_8);
                                                                                                                                                                                                                                if (!var43_46) break block332;
                                                                                                                                                                                                                                var43_46 = var3_6.isNull((int)var29_32);
                                                                                                                                                                                                                                if (!var43_46) break block332;
                                                                                                                                                                                                                                var57_59 = var5_8;
                                                                                                                                                                                                                                var54_57 = var6_9;
                                                                                                                                                                                                                                var43_46 = var21_24;
                                                                                                                                                                                                                                var72_74 = var29_32;
                                                                                                                                                                                                                                var21_24 = false;
                                                                                                                                                                                                                                var20_23 = null;
                                                                                                                                                                                                                                break block333;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            var43_46 = var3_6.isNull((int)var6_9);
                                                                                                                                                                                                                            if (!var43_46) break block334;
                                                                                                                                                                                                                            var54_57 = var6_9;
                                                                                                                                                                                                                            var6_9 = false;
                                                                                                                                                                                                                            var7_10 = null;
                                                                                                                                                                                                                            break block335;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        var74_76 = var3_6.getString((int)var6_9);
                                                                                                                                                                                                                        var54_57 = var6_9;
                                                                                                                                                                                                                        var7_10 = var74_76;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    var43_46 = var3_6.isNull((int)var5_8);
                                                                                                                                                                                                                    if (!var43_46) break block336;
                                                                                                                                                                                                                    var57_59 = var5_8;
                                                                                                                                                                                                                    var5_8 = false;
                                                                                                                                                                                                                    var30_33 = null;
                                                                                                                                                                                                                    break block337;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                var74_76 = var3_6.getString((int)var5_8);
                                                                                                                                                                                                                var57_59 = var5_8;
                                                                                                                                                                                                                var30_33 = var74_76;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            var43_46 = var3_6.isNull((int)var29_32);
                                                                                                                                                                                                            if (!var43_46) break block338;
                                                                                                                                                                                                            var43_46 = var21_24;
                                                                                                                                                                                                            var72_74 = var29_32;
                                                                                                                                                                                                            var29_32 = false;
                                                                                                                                                                                                            var28_31 = null;
                                                                                                                                                                                                            break block339;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        var74_76 = var3_6.getString((int)var29_32);
                                                                                                                                                                                                        var72_74 = var29_32;
                                                                                                                                                                                                        var28_31 = var74_76;
                                                                                                                                                                                                        var43_46 = var21_24;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    var20_23 = new ArrayList<E>((String)var7_10, (String)var30_33, (String)var28_31);
                                                                                                                                                                                                }
                                                                                                                                                                                                var5_8 = var3_6.isNull((int)var27_30);
                                                                                                                                                                                                if (!var5_8) break block340;
                                                                                                                                                                                                var5_8 = var3_6.isNull((int)var25_28);
                                                                                                                                                                                                if (!var5_8) break block340;
                                                                                                                                                                                                var5_8 = var3_6.isNull((int)var23_26);
                                                                                                                                                                                                if (!var5_8) break block340;
                                                                                                                                                                                                var5_8 = false;
                                                                                                                                                                                                var30_33 = null;
                                                                                                                                                                                                break block341;
                                                                                                                                                                                            }
                                                                                                                                                                                            var5_8 = var3_6.getInt((int)var27_30);
                                                                                                                                                                                            var6_9 = var3_6.getInt((int)var25_28);
                                                                                                                                                                                            var29_32 = var3_6.getInt((int)var23_26);
                                                                                                                                                                                            var30_33 = ScriptDataExt.create((int)var5_8, (int)var6_9, (int)var29_32);
                                                                                                                                                                                        }
                                                                                                                                                                                        var7_10 = new ArrayList<E>();
                                                                                                                                                                                        var71_73 = var23_26;
                                                                                                                                                                                        var29_32 = var25_28;
                                                                                                                                                                                        var75_77 = var3_6.getLong(var8_11);
                                                                                                                                                                                        var7_10.setId(var75_77);
                                                                                                                                                                                        var75_77 = var3_6.getLong((int)var11_14);
                                                                                                                                                                                        var7_10.setId(var75_77);
                                                                                                                                                                                        var23_26 = var3_6.isNull((int)var13_16);
                                                                                                                                                                                        if (!var23_26) break block342;
                                                                                                                                                                                        var23_26 = false;
                                                                                                                                                                                        var22_25 = null;
                                                                                                                                                                                        break block343;
                                                                                                                                                                                    }
                                                                                                                                                                                    var22_25 = var3_6.getString((int)var13_16);
                                                                                                                                                                                }
                                                                                                                                                                                var7_10.setTextZh((String)var22_25);
                                                                                                                                                                                var23_26 = var3_6.isNull((int)var59_61);
                                                                                                                                                                                if (!var23_26) break block344;
                                                                                                                                                                                var23_26 = false;
                                                                                                                                                                                var22_25 = null;
                                                                                                                                                                                break block345;
                                                                                                                                                                            }
                                                                                                                                                                            var22_25 = var3_6.getString((int)var59_61);
                                                                                                                                                                        }
                                                                                                                                                                        var7_10.setTextZhTw((String)var22_25);
                                                                                                                                                                        var23_26 = var3_6.isNull((int)var9_12);
                                                                                                                                                                        if (!var23_26) break block346;
                                                                                                                                                                        var23_26 = false;
                                                                                                                                                                        var22_25 = null;
                                                                                                                                                                        break block347;
                                                                                                                                                                    }
                                                                                                                                                                    var22_25 = var3_6.getString((int)var9_12);
                                                                                                                                                                }
                                                                                                                                                                var7_10.setTextEn((String)var22_25);
                                                                                                                                                                var23_26 = var3_6.isNull((int)var15_18);
                                                                                                                                                                if (!var23_26) break block348;
                                                                                                                                                                var23_26 = false;
                                                                                                                                                                var22_25 = null;
                                                                                                                                                                break block349;
                                                                                                                                                            }
                                                                                                                                                            var22_25 = var3_6.getString((int)var15_18);
                                                                                                                                                        }
                                                                                                                                                        var7_10.setCoverUrl((String)var22_25);
                                                                                                                                                        var23_26 = var3_6.isNull((int)var17_20);
                                                                                                                                                        if (!var23_26) break block350;
                                                                                                                                                        var23_26 = false;
                                                                                                                                                        var22_25 = null;
                                                                                                                                                        break block351;
                                                                                                                                                    }
                                                                                                                                                    var22_25 = var3_6.getString((int)var17_20);
                                                                                                                                                }
                                                                                                                                                var7_10.setVideoUrl((String)var22_25);
                                                                                                                                                var77_78 = var3_6.getDouble((int)var19_22);
                                                                                                                                                var7_10.setVideoTime(var77_78);
                                                                                                                                                var23_26 = var43_46;
                                                                                                                                                var25_28 = var3_6.getInt((int)var43_46);
                                                                                                                                                var7_10.setVideoCount((int)var25_28);
                                                                                                                                                var25_28 = var42_45;
                                                                                                                                                var42_45 = var3_6.isNull((int)var42_45);
                                                                                                                                                if (!var42_45) break block352;
                                                                                                                                                var43_46 = var9_12;
                                                                                                                                                var9_12 = false;
                                                                                                                                                var2_2 = null;
                                                                                                                                                break block353;
                                                                                                                                            }
                                                                                                                                            var79_79 = var3_6.getString((int)var25_28);
                                                                                                                                            var43_46 = var9_12;
                                                                                                                                            var2_2 = var79_79;
                                                                                                                                        }
                                                                                                                                        var7_10.setVideoRatio((String)var2_2);
                                                                                                                                        var9_12 = var41_44;
                                                                                                                                        var41_44 = var59_61;
                                                                                                                                        var59_61 = var3_6.getInt((int)var9_12);
                                                                                                                                        var7_10.setResSize((int)var59_61);
                                                                                                                                        var59_61 = var40_43;
                                                                                                                                        var40_43 = var3_6.getInt((int)var40_43);
                                                                                                                                        var42_45 = false;
                                                                                                                                        var79_79 = null;
                                                                                                                                        if (var40_43) {
                                                                                                                                            var40_43 = var9_12;
                                                                                                                                            var9_12 = true;
                                                                                                                                            break block354;
                                                                                                                                        }
                                                                                                                                        var40_43 = var9_12;
                                                                                                                                        var9_12 = false;
                                                                                                                                        var2_2 = null;
                                                                                                                                    }
                                                                                                                                    var7_10.setPrimeUsable(var9_12);
                                                                                                                                    var9_12 = var39_42;
                                                                                                                                    var39_42 = var59_61;
                                                                                                                                    var59_61 = var3_6.getInt((int)var9_12);
                                                                                                                                    var7_10.setTempType((int)var59_61);
                                                                                                                                    var59_61 = var38_41;
                                                                                                                                    var38_41 = var3_6.getInt((int)var38_41);
                                                                                                                                    if (var38_41) {
                                                                                                                                        var38_41 = var9_12;
                                                                                                                                        var9_12 = true;
                                                                                                                                        break block355;
                                                                                                                                    }
                                                                                                                                    var38_41 = var9_12;
                                                                                                                                    var9_12 = false;
                                                                                                                                    var2_2 = null;
                                                                                                                                }
                                                                                                                                var7_10.setDownloadFinished(var9_12);
                                                                                                                                var9_12 = var32_35;
                                                                                                                                var32_35 = var3_6.isNull((int)var32_35);
                                                                                                                                if (!var32_35) break block356;
                                                                                                                                var73_75 = var9_12;
                                                                                                                                var9_12 = false;
                                                                                                                                var2_2 = null;
                                                                                                                                break block357;
                                                                                                                            }
                                                                                                                            var80_80 = var3_6.getLong((int)var9_12);
                                                                                                                            var82_81 = var80_80;
                                                                                                                            var73_75 = var9_12;
                                                                                                                            var2_2 = var82_81;
                                                                                                                        }
                                                                                                                        var7_10.setDownloadTimestamp((Long)var2_2);
                                                                                                                        var9_12 = var33_36;
                                                                                                                        var32_35 = var3_6.isNull((int)var33_36);
                                                                                                                        if (!var32_35) break block358;
                                                                                                                        var9_12 = false;
                                                                                                                        var2_2 = null;
                                                                                                                        break block359;
                                                                                                                    }
                                                                                                                    var82_81 = var3_6.getString((int)var33_36);
                                                                                                                    var2_2 = var82_81;
                                                                                                                }
                                                                                                                var7_10.setEditorTemplate((String)var2_2);
                                                                                                                var9_12 = var34_37;
                                                                                                                var32_35 = var3_6.isNull((int)var34_37);
                                                                                                                if (!var32_35) break block360;
                                                                                                                var9_12 = false;
                                                                                                                var2_2 = null;
                                                                                                                break block361;
                                                                                                            }
                                                                                                            var82_81 = var3_6.getString((int)var34_37);
                                                                                                            var2_2 = var82_81;
                                                                                                        }
                                                                                                        var7_10.setTrackEditorConfigData((String)var2_2);
                                                                                                        var32_35 = var59_61;
                                                                                                        var9_12 = var35_38;
                                                                                                        var59_61 = var3_6.getInt((int)var35_38);
                                                                                                        var7_10.setTemplateUseType((int)var59_61);
                                                                                                        var59_61 = var36_39;
                                                                                                        var9_12 = var3_6.getInt((int)var36_39);
                                                                                                        var7_10.setTemplateProtocolType((int)var9_12);
                                                                                                        var9_12 = var37_40;
                                                                                                        var36_39 = var3_6.getInt((int)var37_40);
                                                                                                        if (var36_39) {
                                                                                                            var9_12 = true;
                                                                                                            break block362;
                                                                                                        }
                                                                                                        var9_12 = false;
                                                                                                        var2_2 = null;
                                                                                                    }
                                                                                                    var7_10.setFirstLoaded(var9_12);
                                                                                                    var7_10.setTemplateDescription((TemplateDescription)var20_23);
                                                                                                    var7_10.setScriptDataExt((ScriptDataExt)var30_33);
                                                                                                    var2_2 = var7_10;
                                                                                                }
                                                                                                var5_8 = var3_6.isNull(var8_11);
                                                                                                if (var5_8) break block363;
                                                                                                var83_82 = var3_6.getLong(var8_11);
                                                                                                var20_23 = var70_72;
                                                                                                var30_33 = var70_72.get(var83_82);
                                                                                                var30_33 = (Template)var30_33;
                                                                                                break block364;
                                                                                            }
                                                                                            var20_23 = var70_72;
                                                                                            var5_8 = false;
                                                                                            var30_33 = null;
                                                                                        }
                                                                                        var6_9 = var3_6.isNull(var8_11);
                                                                                        if (var6_9) break block365;
                                                                                        var31_34 = var11_14;
                                                                                        var85_83 = var3_6.getLong(var8_11);
                                                                                        var36_39 = var59_61;
                                                                                        var1_1 = var69_71;
                                                                                        var7_10 = var69_71.get(var85_83);
                                                                                        var7_10 = (Script)var7_10;
                                                                                        break block366;
                                                                                    }
                                                                                    var36_39 = var59_61;
                                                                                    var31_34 = var11_14;
                                                                                    var1_1 = var69_71;
                                                                                    var6_9 = false;
                                                                                    var7_10 = null;
                                                                                }
                                                                                var11_14 = var3_6.isNull(var8_11);
                                                                                if (var11_14) break block367;
                                                                                var42_45 = var13_16;
                                                                                var55_58 = var3_6.getLong(var8_11);
                                                                                var69_71 = var1_1;
                                                                                var1_1 = var68_70;
                                                                                var10_13 = var68_70.get(var55_58);
                                                                                var10_13 = (Draft)var10_13;
                                                                                break block368;
                                                                            }
                                                                            var69_71 = var1_1;
                                                                            var42_45 = var13_16;
                                                                            var1_1 = var68_70;
                                                                            var11_14 = false;
                                                                            var10_13 = null;
                                                                        }
                                                                        var13_16 = var3_6.isNull(var8_11);
                                                                        if (var13_16) break block369;
                                                                        var45_48 = var15_18;
                                                                        var87_84 = var3_6.getLong(var8_11);
                                                                        var89_85 = var1_1;
                                                                        var1_1 = var67_69;
                                                                        var12_15 = var67_69.get(var87_84);
                                                                        var12_15 = (Withdraw)var12_15;
                                                                        break block370;
                                                                    }
                                                                    var89_85 = var1_1;
                                                                    var45_48 = var15_18;
                                                                    var1_1 = var67_69;
                                                                    var13_16 = false;
                                                                    var12_15 = null;
                                                                }
                                                                var15_18 = var3_6.isNull(var8_11);
                                                                if (var15_18) break block371;
                                                                var46_49 = var17_20;
                                                                var90_86 = var3_6.getLong(var8_11);
                                                                var92_87 = var1_1;
                                                                var1_1 = var66_68;
                                                                var14_17 = var66_68.get(var90_86);
                                                                var14_17 = (TemplateGlobal)var14_17;
                                                                break block372;
                                                            }
                                                            var92_87 = var1_1;
                                                            var46_49 = var17_20;
                                                            var1_1 = var66_68;
                                                            var15_18 = false;
                                                            var14_17 = null;
                                                        }
                                                        var17_20 = var3_6.isNull(var8_11);
                                                        if (var17_20) break block373;
                                                        var47_50 = var19_22;
                                                        var93_88 = var3_6.getLong(var8_11);
                                                        var95_89 = var1_1;
                                                        var1_1 = var65_67;
                                                        var16_19 = var65_67.get(var93_88);
                                                        break block374;
                                                    }
                                                    var95_89 = var1_1;
                                                    var47_50 = var19_22;
                                                    var1_1 = var65_67;
                                                    var17_20 = false;
                                                    var16_19 = null;
                                                }
                                                if (var16_19 == null) {
                                                    var16_19 = new ArrayList();
                                                }
                                                var19_22 = var3_6.isNull(var8_11);
                                                if (var19_22) break block375;
                                                var65_67 = var20_23;
                                                var96_90 = var3_6.getLong(var8_11);
                                                var98_91 = var1_1;
                                                var1_1 = var64_66;
                                                var18_21 = var64_66.get(var96_90);
                                                break block376;
                                            }
                                            var98_91 = var1_1;
                                            var65_67 = var20_23;
                                            var1_1 = var64_66;
                                            var19_22 = false;
                                            var18_21 = null;
                                        }
                                        if (var18_21 == null) {
                                            var18_21 = new ArrayList<E>();
                                        }
                                        var21_24 = var3_6.isNull(var8_11);
                                        if (var21_24) break block377;
                                        var49_52 = var23_26;
                                        var99_92 = var3_6.getLong(var8_11);
                                        var101_93 = var1_1;
                                        var1_1 = var63_65;
                                        var20_23 = var63_65.get(var99_92);
                                        break block378;
                                    }
                                    var101_93 = var1_1;
                                    var49_52 = var23_26;
                                    var1_1 = var63_65;
                                    var21_24 = false;
                                    var20_23 = null;
                                }
                                if (var20_23 == null) {
                                    var20_23 = new ArrayList<E>();
                                }
                                var23_26 = var3_6.isNull(var8_11);
                                if (var23_26) break block379;
                                var50_53 = var25_28;
                                var75_77 = var3_6.getLong(var8_11);
                                var102_94 = var1_1;
                                var1_1 = var62_64;
                                var22_25 = var62_64.get(var75_77);
                                break block380;
                            }
                            var102_94 = var1_1;
                            var50_53 = var25_28;
                            var1_1 = var62_64;
                            var23_26 = false;
                            var22_25 = null;
                        }
                        if (var22_25 == null) {
                            var22_25 = new ArrayList<E>();
                        }
                        var25_28 = var3_6.isNull(var8_11);
                        if (var25_28) break block381;
                        var51_54 = var27_30;
                        var103_95 = var3_6.getLong(var8_11);
                        var105_96 = var1_1;
                        var1_1 = var61_63;
                        var24_27 = var61_63.get(var103_95);
                        break block382;
                    }
                    var105_96 = var1_1;
                    var51_54 = var27_30;
                    var1_1 = var61_63;
                    var25_28 = false;
                    var24_27 = null;
                }
                if (var24_27 == null) {
                    var24_27 = new ArrayList<E>();
                }
                var26_29 = new ArrayList<E>();
                var26_29.setTemplateData((TemplateData)var2_2);
                var26_29.setTemplate((Template)var30_33);
                var26_29.setScript((Script)var7_10);
                var26_29.setDraft((Draft)var10_13);
                var26_29.setWithdraw((Withdraw)var12_15);
                var26_29.setTemplateGlobal((TemplateGlobal)var14_17);
                var26_29.setTemplateVideoList((List)var16_19);
                var26_29.setTemplateStickerList(var18_21);
                var26_29.setTemplateMusicList(var20_23);
                var26_29.setTemplateRecordingList(var22_25);
                var26_29.setScriptTrackPOJOList(var24_27);
                var2_2 = var60_62;
                var60_62.add(var26_29);
                var14_17 = var1_1;
                var53_56 = var42_45;
                var52_55 = var43_46;
                var30_33 = var69_71;
                var7_10 = var65_67;
                var48_51 = var49_52;
                var43_46 = var71_73;
                var26_29 = var92_87;
                var24_27 = var95_89;
                var22_25 = var98_91;
                var20_23 = var101_93;
                var18_21 = var102_94;
                var16_19 = var105_96;
                var1_1 = this;
                var42_45 = var29_32;
                var44_47 = var38_41;
                var49_52 = var47_50;
                var47_50 = var50_53;
                var38_41 = var54_57;
                var28_31 = var89_85;
                var54_57 = var41_44;
                var50_53 = var46_49;
                var41_44 = var51_54;
                var46_49 = var40_43;
                var51_54 = var45_48;
                var40_43 = var72_74;
                var45_48 = var39_42;
                var39_42 = var57_59;
                var57_59 = var31_34;
                var31_34 = var32_35;
                var32_35 = var73_75;
                continue;
            }
lbl1163:
            // 2 sources

            var4_7 = var1_1.this$0;
            var4_7 = G_DraftDao_Impl.access$000((G_DraftDao_Impl)var4_7);
            var4_7.setTransactionSuccessful();
            var3_6.close();
            return var2_2;
            catch (Throwable var2_4) {
                // empty catch block
            }
        }
        try {
            var3_6.close();
            throw var2_2;
        }
        catch (Throwable var2_5) {
            throw var2_5;
        }
        finally {
            G_DraftDao_Impl.access$000(var1_1.this$0).endTransaction();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

