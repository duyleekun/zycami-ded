/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
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

public class G_TemplateDao_Impl$18
implements Callable {
    public final /* synthetic */ G_TemplateDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDao_Impl$18(G_TemplateDao_Impl g_TemplateDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List call() {
        block378: {
            var1_1 = this;
            var2_2 = G_TemplateDao_Impl.access$000(this.this$0);
            var2_2.beginTransaction();
            var2_2 = this.this$0;
            var2_2 = G_TemplateDao_Impl.access$000((G_TemplateDao_Impl)var2_2);
            var3_6 = this.val$_statement;
            var4_7 = true;
            var5_8 = false;
            var6_9 = null;
            var3_6 = DBUtil.query((RoomDatabase)var2_2, var3_6, var4_7, null);
            var2_2 = "id";
            var7_10 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var2_2);
            var8_11 = "title_zh";
            var9_12 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var8_11);
            var10_13 = "title_tw";
            var11_14 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var10_13);
            var12_15 = "title_en";
            var13_16 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var12_15);
            var14_17 = "cover_url";
            var15_18 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var14_17);
            var16_19 = "video_url";
            var17_20 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var16_19);
            var18_21 = "video_time";
            var19_22 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var18_21);
            var20_23 = "video_count";
            var21_24 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var20_23);
            var22_25 = "video_ratio";
            var23_26 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var22_25);
            var24_27 = "res_size";
            var25_28 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var24_27);
            var26_29 = "is_prime_usable";
            var27_30 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var26_29);
            var28_31 = "temp_type";
            var29_32 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var28_31);
            var30_33 = "download_finished";
            var4_7 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var30_33);
            var6_9 = "download_timestamp";
            var31_34 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "editor_template";
            var32_35 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "track_editor_config_data";
            var33_36 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "template_use_type";
            var34_37 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "template_proto_type";
            var35_38 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "first_loaded";
            var36_39 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "template_description_zh";
            var37_40 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "template_description_en";
            var38_41 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "template_description_zh_tw";
            var39_42 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "script_ext_status";
            var40_43 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "script_ext_protocol";
            var41_44 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = "script_ext_version";
            var42_45 = var5_8 = CursorUtil.getColumnIndexOrThrow((Cursor)var3_6, (String)var6_9);
            var6_9 = new LongSparseArray();
            var43_46 = var4_7;
            var30_33 = new LongSparseArray();
            var44_47 = var29_32;
            var28_31 = new ArrayList<E>();
            var45_48 = var27_30;
            var26_29 = new ArrayList<E>();
            var46_49 = var25_28;
            var24_27 = new ArrayList<E>();
            var47_50 = var23_26;
            var22_25 = new ArrayList<E>();
            var48_51 = var21_24;
            var20_23 = new ArrayList<E>();
            var49_52 = var19_22;
            var18_21 = new LongSparseArray();
            var50_53 = var17_20;
            var16_19 = new LongSparseArray();
            var51_54 = var15_18;
            var14_17 = new LongSparseArray();
            ** while (var52_55 = var3_6.moveToNext())
lbl-1000:
            // 1 sources

            {
                block300: {
                    block299: {
                        block298: {
                            block297: {
                                block296: {
                                    block295: {
                                        block294: {
                                            block293: {
                                                block292: {
                                                    block291: {
                                                        block290: {
                                                            block289: {
                                                                var52_55 = var3_6.isNull(var7_10);
                                                                if (var52_55) break block289;
                                                                var52_55 = var11_14;
                                                                var53_56 = var13_16;
                                                                var54_57 = var3_6.getLong(var7_10);
                                                                var56_58 = var9_12;
                                                                var9_12 = false;
                                                                var8_11 = null;
                                                                var6_9.put(var54_57, null);
                                                                break block290;
                                                            }
                                                            var56_58 = var9_12;
                                                            var52_55 = var11_14;
                                                            var53_56 = var13_16;
                                                        }
                                                        var9_12 = var3_6.isNull(var7_10);
                                                        if (var9_12) break block291;
                                                        var57_59 = var3_6.getLong(var7_10);
                                                        var13_16 = false;
                                                        var12_15 = null;
                                                        var30_33.put(var57_59, null);
                                                    }
                                                    var9_12 = var3_6.isNull(var7_10);
                                                    if (var9_12) break block292;
                                                    var57_59 = var3_6.getLong(var7_10);
                                                    var13_16 = false;
                                                    var12_15 = null;
                                                    var28_31.put(var57_59, null);
                                                }
                                                var9_12 = var3_6.isNull(var7_10);
                                                if (var9_12) break block293;
                                                var57_59 = var3_6.getLong(var7_10);
                                                var13_16 = false;
                                                var12_15 = null;
                                                var26_29.put(var57_59, null);
                                            }
                                            var9_12 = var3_6.isNull(var7_10);
                                            if (var9_12) break block294;
                                            var57_59 = var3_6.getLong(var7_10);
                                            var13_16 = false;
                                            var12_15 = null;
                                            var24_27.put(var57_59, null);
                                            break block295;
                                        }
                                        var13_16 = false;
                                        var12_15 = null;
                                    }
                                    var9_12 = var3_6.isNull(var7_10);
                                    if (var9_12) break block296;
                                    var57_59 = var3_6.getLong(var7_10);
                                    var59_60 = var22_25.get(var57_59);
                                    var59_60 = (ArrayList)var59_60;
                                    if (var59_60 != null) break block296;
                                    var12_15 = new ArrayList();
                                    var22_25.put(var57_59, var12_15);
                                }
                                var9_12 = var3_6.isNull(var7_10);
                                if (var9_12) break block297;
                                var57_59 = var3_6.getLong(var7_10);
                                var12_15 = var20_23.get(var57_59);
                                var12_15 = (ArrayList)var12_15;
                                if (var12_15 != null) break block297;
                                var12_15 = new ArrayList();
                                var20_23.put(var57_59, var12_15);
                            }
                            var9_12 = var3_6.isNull(var7_10);
                            if (var9_12) break block298;
                            var57_59 = var3_6.getLong(var7_10);
                            var12_15 = var18_21.get(var57_59);
                            var12_15 = (ArrayList)var12_15;
                            if (var12_15 != null) break block298;
                            var12_15 = new ArrayList();
                            var18_21.put(var57_59, var12_15);
                        }
                        var9_12 = var3_6.isNull(var7_10);
                        if (var9_12) break block299;
                        var57_59 = var3_6.getLong(var7_10);
                        var12_15 = var16_19.get(var57_59);
                        var12_15 = (ArrayList)var12_15;
                        if (var12_15 != null) break block299;
                        var12_15 = new ArrayList();
                        var16_19.put(var57_59, var12_15);
                    }
                    var9_12 = var3_6.isNull(var7_10);
                    if (var9_12) break block300;
                    var57_59 = var3_6.getLong(var7_10);
                    var12_15 = var14_17.get(var57_59);
                    var12_15 = (ArrayList)var12_15;
                    if (var12_15 != null) break block300;
                    var12_15 = new ArrayList();
                    var14_17.put(var57_59, var12_15);
                }
                var11_14 = var52_55;
                var13_16 = var53_56;
                var9_12 = var56_58;
                continue;
            }
lbl261:
            // 1 sources

            var56_58 = var9_12;
            var52_55 = var11_14;
            var53_56 = var13_16;
            var9_12 = -1 != 0;
            var3_6.moveToPosition((int)var9_12);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$300((G_TemplateDao_Impl)var8_11, (LongSparseArray)var6_9);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$400((G_TemplateDao_Impl)var8_11, (LongSparseArray)var30_33);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$500((G_TemplateDao_Impl)var8_11, (LongSparseArray)var28_31);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$600((G_TemplateDao_Impl)var8_11, (LongSparseArray)var26_29);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$700((G_TemplateDao_Impl)var8_11, (LongSparseArray)var24_27);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$800((G_TemplateDao_Impl)var8_11, (LongSparseArray)var22_25);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$900((G_TemplateDao_Impl)var8_11, (LongSparseArray)var20_23);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$1000((G_TemplateDao_Impl)var8_11, (LongSparseArray)var18_21);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$1100((G_TemplateDao_Impl)var8_11, (LongSparseArray)var16_19);
            var8_11 = var1_1.this$0;
            G_TemplateDao_Impl.access$1200((G_TemplateDao_Impl)var8_11, (LongSparseArray)var14_17);
            var11_14 = var3_6.getCount();
            var8_11 = new ArrayList<ArrayList<E>>((int)var11_14);
            ** while (var11_14 = (boolean)var3_6.moveToNext())
lbl-1000:
            // 1 sources

            {
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
                                                                            block362: {
                                                                                block361: {
                                                                                    block360: {
                                                                                        block359: {
                                                                                            block358: {
                                                                                                block326: {
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
                                                                                                                                                                            block339: {
                                                                                                                                                                                block338: {
                                                                                                                                                                                    block337: {
                                                                                                                                                                                        block336: {
                                                                                                                                                                                            block335: {
                                                                                                                                                                                                block328: {
                                                                                                                                                                                                    block334: {
                                                                                                                                                                                                        block333: {
                                                                                                                                                                                                            block332: {
                                                                                                                                                                                                                block331: {
                                                                                                                                                                                                                    block330: {
                                                                                                                                                                                                                        block329: {
                                                                                                                                                                                                                            block327: {
                                                                                                                                                                                                                                block325: {
                                                                                                                                                                                                                                    block309: {
                                                                                                                                                                                                                                        block308: {
                                                                                                                                                                                                                                            block307: {
                                                                                                                                                                                                                                                block306: {
                                                                                                                                                                                                                                                    block305: {
                                                                                                                                                                                                                                                        block304: {
                                                                                                                                                                                                                                                            block301: {
                                                                                                                                                                                                                                                                block302: {
                                                                                                                                                                                                                                                                    block303: {
                                                                                                                                                                                                                                                                        block310: {
                                                                                                                                                                                                                                                                            block311: {
                                                                                                                                                                                                                                                                                block312: {
                                                                                                                                                                                                                                                                                    block313: {
                                                                                                                                                                                                                                                                                        block324: {
                                                                                                                                                                                                                                                                                            block323: {
                                                                                                                                                                                                                                                                                                block322: {
                                                                                                                                                                                                                                                                                                    block321: {
                                                                                                                                                                                                                                                                                                        block320: {
                                                                                                                                                                                                                                                                                                            block379: {
                                                                                                                                                                                                                                                                                                                block314: {
                                                                                                                                                                                                                                                                                                                    block315: {
                                                                                                                                                                                                                                                                                                                        block316: {
                                                                                                                                                                                                                                                                                                                            block317: {
                                                                                                                                                                                                                                                                                                                                block318: {
                                                                                                                                                                                                                                                                                                                                    block319: {
                                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                                            var11_14 = var3_6.isNull(var7_10);
                                                                                                                                                                                                                                                                                                                                            if (!var11_14) break block301;
                                                                                                                                                                                                                                                                                                                                            var11_14 = var56_58;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        catch (Throwable var2_3) {
                                                                                                                                                                                                                                                                                                                                            var1_1 = this;
                                                                                                                                                                                                                                                                                                                                            break block378;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        var13_16 = var3_6.isNull((int)var56_58);
                                                                                                                                                                                                                                                                                                                                        if (!var13_16) break block302;
                                                                                                                                                                                                                                                                                                                                        var13_16 = var52_55;
                                                                                                                                                                                                                                                                                                                                        var52_55 = var3_6.isNull((int)var52_55);
                                                                                                                                                                                                                                                                                                                                        if (!var52_55) break block303;
                                                                                                                                                                                                                                                                                                                                        var60_61 = var53_56;
                                                                                                                                                                                                                                                                                                                                        var52_55 = var3_6.isNull((int)var53_56);
                                                                                                                                                                                                                                                                                                                                        if (!var52_55) break block304;
                                                                                                                                                                                                                                                                                                                                        var61_62 = var8_11;
                                                                                                                                                                                                                                                                                                                                        var9_12 = var51_54;
                                                                                                                                                                                                                                                                                                                                        var51_54 = var3_6.isNull((int)var51_54);
                                                                                                                                                                                                                                                                                                                                        if (!var51_54) break block305;
                                                                                                                                                                                                                                                                                                                                        var62_63 = var14_17;
                                                                                                                                                                                                                                                                                                                                        var15_18 = var50_53;
                                                                                                                                                                                                                                                                                                                                        var50_53 = var3_6.isNull((int)var50_53);
                                                                                                                                                                                                                                                                                                                                        if (!var50_53) break block306;
                                                                                                                                                                                                                                                                                                                                        var63_64 = var16_19;
                                                                                                                                                                                                                                                                                                                                        var17_20 = var49_52;
                                                                                                                                                                                                                                                                                                                                        var49_52 = var3_6.isNull((int)var49_52);
                                                                                                                                                                                                                                                                                                                                        if (!var49_52) break block307;
                                                                                                                                                                                                                                                                                                                                        var64_65 = var18_21;
                                                                                                                                                                                                                                                                                                                                        var19_22 = var48_51;
                                                                                                                                                                                                                                                                                                                                        var48_51 = var3_6.isNull((int)var48_51);
                                                                                                                                                                                                                                                                                                                                        if (!var48_51) break block308;
                                                                                                                                                                                                                                                                                                                                        var65_66 = var20_23;
                                                                                                                                                                                                                                                                                                                                        var21_24 = var47_50;
                                                                                                                                                                                                                                                                                                                                        var47_50 = var3_6.isNull((int)var47_50);
                                                                                                                                                                                                                                                                                                                                        if (!var47_50) break block309;
                                                                                                                                                                                                                                                                                                                                        var66_67 = var22_25;
                                                                                                                                                                                                                                                                                                                                        var23_26 = var46_49;
                                                                                                                                                                                                                                                                                                                                        var46_49 = var3_6.isNull((int)var46_49);
                                                                                                                                                                                                                                                                                                                                        if (!var46_49) break block310;
                                                                                                                                                                                                                                                                                                                                        var67_68 = var24_27;
                                                                                                                                                                                                                                                                                                                                        var25_28 = var45_48;
                                                                                                                                                                                                                                                                                                                                        var45_48 = var3_6.isNull((int)var45_48);
                                                                                                                                                                                                                                                                                                                                        if (!var45_48) break block311;
                                                                                                                                                                                                                                                                                                                                        var68_69 = var26_29;
                                                                                                                                                                                                                                                                                                                                        var27_30 = var44_47;
                                                                                                                                                                                                                                                                                                                                        var44_47 = var3_6.isNull((int)var44_47);
                                                                                                                                                                                                                                                                                                                                        if (!var44_47) break block312;
                                                                                                                                                                                                                                                                                                                                        var69_70 = var28_31;
                                                                                                                                                                                                                                                                                                                                        var29_32 = var43_46;
                                                                                                                                                                                                                                                                                                                                        var43_46 = var3_6.isNull((int)var43_46);
                                                                                                                                                                                                                                                                                                                                        if (!var43_46) break block313;
                                                                                                                                                                                                                                                                                                                                        var70_71 = var30_33;
                                                                                                                                                                                                                                                                                                                                        var4_7 = var31_34;
                                                                                                                                                                                                                                                                                                                                        var31_34 = var3_6.isNull((int)var31_34);
                                                                                                                                                                                                                                                                                                                                        if (!var31_34) break block314;
                                                                                                                                                                                                                                                                                                                                        var71_72 = var6_9;
                                                                                                                                                                                                                                                                                                                                        var5_8 = var32_35;
                                                                                                                                                                                                                                                                                                                                        var32_35 = var3_6.isNull((int)var32_35);
                                                                                                                                                                                                                                                                                                                                        if (!var32_35) break block315;
                                                                                                                                                                                                                                                                                                                                        var32_35 = var5_8;
                                                                                                                                                                                                                                                                                                                                        var5_8 = var33_36;
                                                                                                                                                                                                                                                                                                                                        var33_36 = var3_6.isNull((int)var33_36);
                                                                                                                                                                                                                                                                                                                                        if (!var33_36) break block316;
                                                                                                                                                                                                                                                                                                                                        var33_36 = var5_8;
                                                                                                                                                                                                                                                                                                                                        var5_8 = var34_37;
                                                                                                                                                                                                                                                                                                                                        var34_37 = var3_6.isNull((int)var34_37);
                                                                                                                                                                                                                                                                                                                                        if (!var34_37) break block317;
                                                                                                                                                                                                                                                                                                                                        var34_37 = var5_8;
                                                                                                                                                                                                                                                                                                                                        var5_8 = var35_38;
                                                                                                                                                                                                                                                                                                                                        var35_38 = var3_6.isNull((int)var35_38);
                                                                                                                                                                                                                                                                                                                                        if (!var35_38) break block318;
                                                                                                                                                                                                                                                                                                                                        var35_38 = var5_8;
                                                                                                                                                                                                                                                                                                                                        var5_8 = var36_39;
                                                                                                                                                                                                                                                                                                                                        var36_39 = var3_6.isNull((int)var36_39);
                                                                                                                                                                                                                                                                                                                                        if (!var36_39) break block319;
                                                                                                                                                                                                                                                                                                                                        var36_39 = var5_8;
                                                                                                                                                                                                                                                                                                                                        var5_8 = var37_40;
                                                                                                                                                                                                                                                                                                                                        var37_40 = var3_6.isNull((int)var37_40);
                                                                                                                                                                                                                                                                                                                                        if (!var37_40) break block320;
                                                                                                                                                                                                                                                                                                                                        var37_40 = var4_7;
                                                                                                                                                                                                                                                                                                                                        var4_7 = var38_41;
                                                                                                                                                                                                                                                                                                                                        var38_41 = var3_6.isNull((int)var38_41);
                                                                                                                                                                                                                                                                                                                                        if (!var38_41) break block321;
                                                                                                                                                                                                                                                                                                                                        var38_41 = var29_32;
                                                                                                                                                                                                                                                                                                                                        var29_32 = var39_42;
                                                                                                                                                                                                                                                                                                                                        var39_42 = var3_6.isNull((int)var39_42);
                                                                                                                                                                                                                                                                                                                                        if (!var39_42) break block322;
                                                                                                                                                                                                                                                                                                                                        var39_42 = var27_30;
                                                                                                                                                                                                                                                                                                                                        var27_30 = var40_43;
                                                                                                                                                                                                                                                                                                                                        var40_43 = var3_6.isNull((int)var40_43);
                                                                                                                                                                                                                                                                                                                                        if (!var40_43) break block323;
                                                                                                                                                                                                                                                                                                                                        var40_43 = var25_28;
                                                                                                                                                                                                                                                                                                                                        var25_28 = var41_44;
                                                                                                                                                                                                                                                                                                                                        var41_44 = var3_6.isNull((int)var41_44);
                                                                                                                                                                                                                                                                                                                                        if (!var41_44) break block324;
                                                                                                                                                                                                                                                                                                                                        var41_44 = var23_26;
                                                                                                                                                                                                                                                                                                                                        var23_26 = var42_45;
                                                                                                                                                                                                                                                                                                                                        var42_45 = var3_6.isNull((int)var42_45);
                                                                                                                                                                                                                                                                                                                                        if (!var42_45) break block325;
                                                                                                                                                                                                                                                                                                                                        var56_58 = var4_7;
                                                                                                                                                                                                                                                                                                                                        var53_56 = var5_8;
                                                                                                                                                                                                                                                                                                                                        var72_73 = var23_26;
                                                                                                                                                                                                                                                                                                                                        var73_74 = var29_32;
                                                                                                                                                                                                                                                                                                                                        var74_75 = var37_40;
                                                                                                                                                                                                                                                                                                                                        var5_8 = false;
                                                                                                                                                                                                                                                                                                                                        var6_9 = null;
                                                                                                                                                                                                                                                                                                                                        var23_26 = var21_24;
                                                                                                                                                                                                                                                                                                                                        var29_32 = var25_28;
                                                                                                                                                                                                                                                                                                                                        var37_40 = var32_35;
                                                                                                                                                                                                                                                                                                                                        var32_35 = var38_41;
                                                                                                                                                                                                                                                                                                                                        var38_41 = var39_42;
                                                                                                                                                                                                                                                                                                                                        var25_28 = var41_44;
                                                                                                                                                                                                                                                                                                                                        var41_44 = var60_61;
                                                                                                                                                                                                                                                                                                                                        var39_42 = var9_12;
                                                                                                                                                                                                                                                                                                                                        var9_12 = var35_38;
                                                                                                                                                                                                                                                                                                                                        break block326;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    var36_39 = var5_8;
                                                                                                                                                                                                                                                                                                                                    break block379;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                var35_38 = var5_8;
                                                                                                                                                                                                                                                                                                                                break block379;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            var34_37 = var5_8;
                                                                                                                                                                                                                                                                                                                            break block379;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        var33_36 = var5_8;
                                                                                                                                                                                                                                                                                                                        break block379;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    var32_35 = var5_8;
                                                                                                                                                                                                                                                                                                                    break block379;
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                var71_72 = var6_9;
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            var5_8 = var37_40;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        var37_40 = var4_7;
                                                                                                                                                                                                                                                                                                        var4_7 = var38_41;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    var38_41 = var29_32;
                                                                                                                                                                                                                                                                                                    var29_32 = var39_42;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                var39_42 = var27_30;
                                                                                                                                                                                                                                                                                                var27_30 = var40_43;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            var40_43 = var25_28;
                                                                                                                                                                                                                                                                                            var25_28 = var41_44;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        var41_44 = var23_26;
                                                                                                                                                                                                                                                                                        var23_26 = var42_45;
                                                                                                                                                                                                                                                                                        break block325;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    var70_71 = var30_33;
                                                                                                                                                                                                                                                                                    var4_7 = var38_41;
                                                                                                                                                                                                                                                                                    var38_41 = var29_32;
                                                                                                                                                                                                                                                                                    var29_32 = var39_42;
                                                                                                                                                                                                                                                                                    var39_42 = var27_30;
                                                                                                                                                                                                                                                                                    var27_30 = var40_43;
                                                                                                                                                                                                                                                                                    var40_43 = var25_28;
                                                                                                                                                                                                                                                                                    var25_28 = var41_44;
                                                                                                                                                                                                                                                                                    var41_44 = var23_26;
                                                                                                                                                                                                                                                                                    var23_26 = var42_45;
                                                                                                                                                                                                                                                                                    var71_72 = var6_9;
                                                                                                                                                                                                                                                                                    var5_8 = var37_40;
                                                                                                                                                                                                                                                                                    var37_40 = var31_34;
                                                                                                                                                                                                                                                                                    break block325;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                var69_70 = var28_31;
                                                                                                                                                                                                                                                                                var29_32 = var39_42;
                                                                                                                                                                                                                                                                                var39_42 = var27_30;
                                                                                                                                                                                                                                                                                var27_30 = var40_43;
                                                                                                                                                                                                                                                                                var40_43 = var25_28;
                                                                                                                                                                                                                                                                                var25_28 = var41_44;
                                                                                                                                                                                                                                                                                var41_44 = var23_26;
                                                                                                                                                                                                                                                                                var23_26 = var42_45;
                                                                                                                                                                                                                                                                                var70_71 = var30_33;
                                                                                                                                                                                                                                                                                var4_7 = var38_41;
                                                                                                                                                                                                                                                                                var38_41 = var43_46;
                                                                                                                                                                                                                                                                                var71_72 = var6_9;
                                                                                                                                                                                                                                                                                var5_8 = var37_40;
                                                                                                                                                                                                                                                                                var37_40 = var31_34;
                                                                                                                                                                                                                                                                                break block325;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            var68_69 = var26_29;
                                                                                                                                                                                                                                                                            var27_30 = var40_43;
                                                                                                                                                                                                                                                                            var40_43 = var25_28;
                                                                                                                                                                                                                                                                            var25_28 = var41_44;
                                                                                                                                                                                                                                                                            var41_44 = var23_26;
                                                                                                                                                                                                                                                                            var23_26 = var42_45;
                                                                                                                                                                                                                                                                            var70_71 = var30_33;
                                                                                                                                                                                                                                                                            var4_7 = var38_41;
                                                                                                                                                                                                                                                                            var38_41 = var43_46;
                                                                                                                                                                                                                                                                            var71_72 = var6_9;
                                                                                                                                                                                                                                                                            var5_8 = var37_40;
                                                                                                                                                                                                                                                                            var37_40 = var31_34;
                                                                                                                                                                                                                                                                            var69_70 = var28_31;
                                                                                                                                                                                                                                                                            var29_32 = var39_42;
                                                                                                                                                                                                                                                                            var39_42 = var44_47;
                                                                                                                                                                                                                                                                            break block325;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        var67_68 = var24_27;
                                                                                                                                                                                                                                                                        var25_28 = var41_44;
                                                                                                                                                                                                                                                                        var41_44 = var23_26;
                                                                                                                                                                                                                                                                        var23_26 = var42_45;
                                                                                                                                                                                                                                                                        var70_71 = var30_33;
                                                                                                                                                                                                                                                                        var4_7 = var38_41;
                                                                                                                                                                                                                                                                        var38_41 = var43_46;
                                                                                                                                                                                                                                                                        var71_72 = var6_9;
                                                                                                                                                                                                                                                                        var5_8 = var37_40;
                                                                                                                                                                                                                                                                        var37_40 = var31_34;
                                                                                                                                                                                                                                                                        var68_69 = var26_29;
                                                                                                                                                                                                                                                                        var27_30 = var40_43;
                                                                                                                                                                                                                                                                        var40_43 = var45_48;
                                                                                                                                                                                                                                                                        var69_70 = var28_31;
                                                                                                                                                                                                                                                                        var29_32 = var39_42;
                                                                                                                                                                                                                                                                        var39_42 = var44_47;
                                                                                                                                                                                                                                                                        break block325;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    var61_62 = var8_11;
                                                                                                                                                                                                                                                                    var9_12 = var51_54;
                                                                                                                                                                                                                                                                    var60_61 = var53_56;
                                                                                                                                                                                                                                                                    break block305;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                var13_16 = var52_55;
                                                                                                                                                                                                                                                                var60_61 = var53_56;
                                                                                                                                                                                                                                                                break block304;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            var13_16 = var52_55;
                                                                                                                                                                                                                                                            var60_61 = var53_56;
                                                                                                                                                                                                                                                            var11_14 = var56_58;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        var61_62 = var8_11;
                                                                                                                                                                                                                                                        var9_12 = var51_54;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    var62_63 = var14_17;
                                                                                                                                                                                                                                                    var15_18 = var50_53;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                var63_64 = var16_19;
                                                                                                                                                                                                                                                var17_20 = var49_52;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            var64_65 = var18_21;
                                                                                                                                                                                                                                            var19_22 = var48_51;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        var65_66 = var20_23;
                                                                                                                                                                                                                                        var21_24 = var47_50;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    var66_67 = var22_25;
                                                                                                                                                                                                                                    var23_26 = var42_45;
                                                                                                                                                                                                                                    var70_71 = var30_33;
                                                                                                                                                                                                                                    var4_7 = var38_41;
                                                                                                                                                                                                                                    var38_41 = var43_46;
                                                                                                                                                                                                                                    var71_72 = var6_9;
                                                                                                                                                                                                                                    var5_8 = var37_40;
                                                                                                                                                                                                                                    var37_40 = var31_34;
                                                                                                                                                                                                                                    var67_68 = var24_27;
                                                                                                                                                                                                                                    var25_28 = var41_44;
                                                                                                                                                                                                                                    var41_44 = var46_49;
                                                                                                                                                                                                                                    var68_69 = var26_29;
                                                                                                                                                                                                                                    var27_30 = var40_43;
                                                                                                                                                                                                                                    var40_43 = var45_48;
                                                                                                                                                                                                                                    var69_70 = var28_31;
                                                                                                                                                                                                                                    var29_32 = var39_42;
                                                                                                                                                                                                                                    var39_42 = var44_47;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                var42_45 = var3_6.isNull((int)var5_8);
                                                                                                                                                                                                                                if (!var42_45) break block327;
                                                                                                                                                                                                                                var42_45 = var3_6.isNull((int)var4_7);
                                                                                                                                                                                                                                if (!var42_45) break block327;
                                                                                                                                                                                                                                var42_45 = var3_6.isNull((int)var29_32);
                                                                                                                                                                                                                                if (!var42_45) break block327;
                                                                                                                                                                                                                                var56_58 = var4_7;
                                                                                                                                                                                                                                var53_56 = var5_8;
                                                                                                                                                                                                                                var42_45 = var21_24;
                                                                                                                                                                                                                                var73_74 = var29_32;
                                                                                                                                                                                                                                var21_24 = false;
                                                                                                                                                                                                                                var20_23 = null;
                                                                                                                                                                                                                                break block328;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            var42_45 = var3_6.isNull((int)var5_8);
                                                                                                                                                                                                                            if (!var42_45) break block329;
                                                                                                                                                                                                                            var53_56 = var5_8;
                                                                                                                                                                                                                            var5_8 = false;
                                                                                                                                                                                                                            var6_9 = null;
                                                                                                                                                                                                                            break block330;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        var75_76 = var3_6.getString((int)var5_8);
                                                                                                                                                                                                                        var53_56 = var5_8;
                                                                                                                                                                                                                        var6_9 = var75_76;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    var42_45 = var3_6.isNull((int)var4_7);
                                                                                                                                                                                                                    if (!var42_45) break block331;
                                                                                                                                                                                                                    var56_58 = var4_7;
                                                                                                                                                                                                                    var4_7 = false;
                                                                                                                                                                                                                    var30_33 = null;
                                                                                                                                                                                                                    break block332;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                var75_76 = var3_6.getString((int)var4_7);
                                                                                                                                                                                                                var56_58 = var4_7;
                                                                                                                                                                                                                var30_33 = var75_76;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            var42_45 = var3_6.isNull((int)var29_32);
                                                                                                                                                                                                            if (!var42_45) break block333;
                                                                                                                                                                                                            var42_45 = var21_24;
                                                                                                                                                                                                            var73_74 = var29_32;
                                                                                                                                                                                                            var29_32 = false;
                                                                                                                                                                                                            var28_31 = null;
                                                                                                                                                                                                            break block334;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        var75_76 = var3_6.getString((int)var29_32);
                                                                                                                                                                                                        var73_74 = var29_32;
                                                                                                                                                                                                        var28_31 = var75_76;
                                                                                                                                                                                                        var42_45 = var21_24;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    var20_23 = new ArrayList<E>((String)var6_9, (String)var30_33, (String)var28_31);
                                                                                                                                                                                                }
                                                                                                                                                                                                var4_7 = var3_6.isNull((int)var27_30);
                                                                                                                                                                                                if (!var4_7) break block335;
                                                                                                                                                                                                var4_7 = var3_6.isNull((int)var25_28);
                                                                                                                                                                                                if (!var4_7) break block335;
                                                                                                                                                                                                var4_7 = var3_6.isNull((int)var23_26);
                                                                                                                                                                                                if (!var4_7) break block335;
                                                                                                                                                                                                var4_7 = false;
                                                                                                                                                                                                var30_33 = null;
                                                                                                                                                                                                break block336;
                                                                                                                                                                                            }
                                                                                                                                                                                            var4_7 = var3_6.getInt((int)var27_30);
                                                                                                                                                                                            var5_8 = var3_6.getInt((int)var25_28);
                                                                                                                                                                                            var29_32 = var3_6.getInt((int)var23_26);
                                                                                                                                                                                            var30_33 = ScriptDataExt.create((int)var4_7, (int)var5_8, (int)var29_32);
                                                                                                                                                                                        }
                                                                                                                                                                                        var6_9 = new TemplateData();
                                                                                                                                                                                        var72_73 = var23_26;
                                                                                                                                                                                        var29_32 = var25_28;
                                                                                                                                                                                        var76_77 = var3_6.getLong(var7_10);
                                                                                                                                                                                        var6_9.setId(var76_77);
                                                                                                                                                                                        var23_26 = var3_6.isNull((int)var11_14);
                                                                                                                                                                                        if (!var23_26) break block337;
                                                                                                                                                                                        var23_26 = false;
                                                                                                                                                                                        var22_25 = null;
                                                                                                                                                                                        break block338;
                                                                                                                                                                                    }
                                                                                                                                                                                    var22_25 = var3_6.getString((int)var11_14);
                                                                                                                                                                                }
                                                                                                                                                                                var6_9.setTextZh((String)var22_25);
                                                                                                                                                                                var23_26 = var3_6.isNull((int)var13_16);
                                                                                                                                                                                if (!var23_26) break block339;
                                                                                                                                                                                var23_26 = false;
                                                                                                                                                                                var22_25 = null;
                                                                                                                                                                                break block340;
                                                                                                                                                                            }
                                                                                                                                                                            var22_25 = var3_6.getString((int)var13_16);
                                                                                                                                                                        }
                                                                                                                                                                        var6_9.setTextZhTw((String)var22_25);
                                                                                                                                                                        var23_26 = var3_6.isNull((int)var60_61);
                                                                                                                                                                        if (!var23_26) break block341;
                                                                                                                                                                        var23_26 = false;
                                                                                                                                                                        var22_25 = null;
                                                                                                                                                                        break block342;
                                                                                                                                                                    }
                                                                                                                                                                    var22_25 = var3_6.getString((int)var60_61);
                                                                                                                                                                }
                                                                                                                                                                var6_9.setTextEn((String)var22_25);
                                                                                                                                                                var23_26 = var3_6.isNull((int)var9_12);
                                                                                                                                                                if (!var23_26) break block343;
                                                                                                                                                                var23_26 = false;
                                                                                                                                                                var22_25 = null;
                                                                                                                                                                break block344;
                                                                                                                                                            }
                                                                                                                                                            var22_25 = var3_6.getString((int)var9_12);
                                                                                                                                                        }
                                                                                                                                                        var6_9.setCoverUrl((String)var22_25);
                                                                                                                                                        var23_26 = var3_6.isNull((int)var15_18);
                                                                                                                                                        if (!var23_26) break block345;
                                                                                                                                                        var23_26 = false;
                                                                                                                                                        var22_25 = null;
                                                                                                                                                        break block346;
                                                                                                                                                    }
                                                                                                                                                    var22_25 = var3_6.getString((int)var15_18);
                                                                                                                                                }
                                                                                                                                                var6_9.setVideoUrl((String)var22_25);
                                                                                                                                                var78_78 = var3_6.getDouble((int)var17_20);
                                                                                                                                                var6_9.setVideoTime(var78_78);
                                                                                                                                                var23_26 = var3_6.getInt((int)var19_22);
                                                                                                                                                var6_9.setVideoCount((int)var23_26);
                                                                                                                                                var23_26 = var42_45;
                                                                                                                                                var25_28 = var3_6.isNull((int)var42_45);
                                                                                                                                                if (!var25_28) break block347;
                                                                                                                                                var25_28 = false;
                                                                                                                                                var24_27 = null;
                                                                                                                                                break block348;
                                                                                                                                            }
                                                                                                                                            var24_27 = var3_6.getString((int)var42_45);
                                                                                                                                        }
                                                                                                                                        var6_9.setVideoRatio((String)var24_27);
                                                                                                                                        var25_28 = var41_44;
                                                                                                                                        var41_44 = var60_61;
                                                                                                                                        var60_61 = var3_6.getInt((int)var25_28);
                                                                                                                                        var6_9.setResSize((int)var60_61);
                                                                                                                                        var60_61 = var40_43;
                                                                                                                                        var40_43 = var3_6.getInt((int)var40_43);
                                                                                                                                        var42_45 = false;
                                                                                                                                        var75_76 = null;
                                                                                                                                        if (var40_43) {
                                                                                                                                            var40_43 = var60_61;
                                                                                                                                            var60_61 = true;
                                                                                                                                            break block349;
                                                                                                                                        }
                                                                                                                                        var40_43 = var60_61;
                                                                                                                                        var60_61 = false;
                                                                                                                                        var1_1 = null;
                                                                                                                                    }
                                                                                                                                    var6_9.setPrimeUsable(var60_61);
                                                                                                                                    var60_61 = var39_42;
                                                                                                                                    var39_42 = var9_12;
                                                                                                                                    var9_12 = var3_6.getInt((int)var60_61);
                                                                                                                                    var6_9.setTempType((int)var9_12);
                                                                                                                                    var9_12 = var38_41;
                                                                                                                                    var38_41 = var3_6.getInt((int)var38_41);
                                                                                                                                    if (var38_41) {
                                                                                                                                        var38_41 = var60_61;
                                                                                                                                        var60_61 = true;
                                                                                                                                        break block350;
                                                                                                                                    }
                                                                                                                                    var38_41 = var60_61;
                                                                                                                                    var60_61 = false;
                                                                                                                                    var1_1 = null;
                                                                                                                                }
                                                                                                                                var6_9.setDownloadFinished(var60_61);
                                                                                                                                var60_61 = var37_40;
                                                                                                                                var37_40 = var3_6.isNull((int)var37_40);
                                                                                                                                if (!var37_40) break block351;
                                                                                                                                var74_75 = var60_61;
                                                                                                                                var60_61 = false;
                                                                                                                                var1_1 = null;
                                                                                                                                break block352;
                                                                                                                            }
                                                                                                                            var80_79 = var3_6.getLong((int)var60_61);
                                                                                                                            var82_80 = var80_79;
                                                                                                                            var74_75 = var60_61;
                                                                                                                            var1_1 = var82_80;
                                                                                                                        }
                                                                                                                        var6_9.setDownloadTimestamp((Long)var1_1);
                                                                                                                        var60_61 = var32_35;
                                                                                                                        var32_35 = var3_6.isNull((int)var32_35);
                                                                                                                        if (!var32_35) break block353;
                                                                                                                        var37_40 = var60_61;
                                                                                                                        var60_61 = false;
                                                                                                                        var1_1 = null;
                                                                                                                        break block354;
                                                                                                                    }
                                                                                                                    var83_81 = var3_6.getString((int)var60_61);
                                                                                                                    var37_40 = var60_61;
                                                                                                                    var1_1 = var83_81;
                                                                                                                }
                                                                                                                var6_9.setEditorTemplate((String)var1_1);
                                                                                                                var60_61 = var33_36;
                                                                                                                var32_35 = var3_6.isNull((int)var33_36);
                                                                                                                if (!var32_35) break block355;
                                                                                                                var60_61 = false;
                                                                                                                var1_1 = null;
                                                                                                                break block356;
                                                                                                            }
                                                                                                            var83_81 = var3_6.getString((int)var33_36);
                                                                                                            var1_1 = var83_81;
                                                                                                        }
                                                                                                        var6_9.setTrackEditorConfigData((String)var1_1);
                                                                                                        var32_35 = var9_12;
                                                                                                        var60_61 = var34_37;
                                                                                                        var9_12 = var3_6.getInt((int)var34_37);
                                                                                                        var6_9.setTemplateUseType((int)var9_12);
                                                                                                        var9_12 = var35_38;
                                                                                                        var60_61 = var3_6.getInt((int)var35_38);
                                                                                                        var6_9.setTemplateProtocolType((int)var60_61);
                                                                                                        var60_61 = var36_39;
                                                                                                        var35_38 = var3_6.getInt((int)var36_39);
                                                                                                        if (var35_38) {
                                                                                                            var60_61 = true;
                                                                                                            break block357;
                                                                                                        }
                                                                                                        var60_61 = false;
                                                                                                        var1_1 = null;
                                                                                                    }
                                                                                                    var6_9.setFirstLoaded(var60_61);
                                                                                                    var6_9.setTemplateDescription((TemplateDescription)var20_23);
                                                                                                    var6_9.setScriptDataExt((ScriptDataExt)var30_33);
                                                                                                }
                                                                                                var60_61 = var3_6.isNull(var7_10);
                                                                                                if (var60_61) break block358;
                                                                                                var35_38 = var9_12;
                                                                                                var60_61 = var11_14;
                                                                                                var57_59 = var3_6.getLong(var7_10);
                                                                                                var30_33 = var71_72;
                                                                                                var8_11 = var71_72.get(var57_59);
                                                                                                var8_11 = (Template)var8_11;
                                                                                                break block359;
                                                                                            }
                                                                                            var35_38 = var9_12;
                                                                                            var60_61 = var11_14;
                                                                                            var30_33 = var71_72;
                                                                                            var9_12 = false;
                                                                                            var8_11 = null;
                                                                                        }
                                                                                        var11_14 = var3_6.isNull(var7_10);
                                                                                        if (var11_14) break block360;
                                                                                        var21_24 = var13_16;
                                                                                        var54_57 = var3_6.getLong(var7_10);
                                                                                        var31_34 = var60_61;
                                                                                        var1_1 = var70_71;
                                                                                        var10_13 = var70_71.get(var54_57);
                                                                                        var10_13 = (Script)var10_13;
                                                                                        break block361;
                                                                                    }
                                                                                    var31_34 = var60_61;
                                                                                    var21_24 = var13_16;
                                                                                    var1_1 = var70_71;
                                                                                    var11_14 = false;
                                                                                    var10_13 = null;
                                                                                }
                                                                                var13_16 = var3_6.isNull(var7_10);
                                                                                if (var13_16) break block362;
                                                                                var42_45 = var15_18;
                                                                                var84_82 = var3_6.getLong(var7_10);
                                                                                var70_71 = var1_1;
                                                                                var1_1 = var69_70;
                                                                                var12_15 = var69_70.get(var84_82);
                                                                                var12_15 = (Draft)var12_15;
                                                                                break block363;
                                                                            }
                                                                            var70_71 = var1_1;
                                                                            var42_45 = var15_18;
                                                                            var1_1 = var69_70;
                                                                            var13_16 = false;
                                                                            var12_15 = null;
                                                                        }
                                                                        var15_18 = var3_6.isNull(var7_10);
                                                                        if (var15_18) break block364;
                                                                        var44_47 = var17_20;
                                                                        var86_83 = var3_6.getLong(var7_10);
                                                                        var88_84 = var1_1;
                                                                        var1_1 = var68_69;
                                                                        var14_17 = var68_69.get(var86_83);
                                                                        var14_17 = (Withdraw)var14_17;
                                                                        break block365;
                                                                    }
                                                                    var88_84 = var1_1;
                                                                    var44_47 = var17_20;
                                                                    var1_1 = var68_69;
                                                                    var15_18 = false;
                                                                    var14_17 = null;
                                                                }
                                                                var17_20 = var3_6.isNull(var7_10);
                                                                if (var17_20) break block366;
                                                                var45_48 = var19_22;
                                                                var89_85 = var3_6.getLong(var7_10);
                                                                var91_86 = var1_1;
                                                                var1_1 = var67_68;
                                                                var16_19 = var67_68.get(var89_85);
                                                                var16_19 = (TemplateGlobal)var16_19;
                                                                break block367;
                                                            }
                                                            var91_86 = var1_1;
                                                            var45_48 = var19_22;
                                                            var1_1 = var67_68;
                                                            var17_20 = false;
                                                            var16_19 = null;
                                                        }
                                                        var19_22 = var3_6.isNull(var7_10);
                                                        if (var19_22) break block368;
                                                        var46_49 = var21_24;
                                                        var92_87 = var3_6.getLong(var7_10);
                                                        var94_88 = var1_1;
                                                        var1_1 = var66_67;
                                                        var18_21 = var66_67.get(var92_87);
                                                        break block369;
                                                    }
                                                    var94_88 = var1_1;
                                                    var46_49 = var21_24;
                                                    var1_1 = var66_67;
                                                    var19_22 = false;
                                                    var18_21 = null;
                                                }
                                                if (var18_21 == null) {
                                                    var18_21 = new ArrayList();
                                                }
                                                var21_24 = var3_6.isNull(var7_10);
                                                if (var21_24) break block370;
                                                var47_50 = var23_26;
                                                var95_89 = var3_6.getLong(var7_10);
                                                var97_90 = var1_1;
                                                var1_1 = var65_66;
                                                var20_23 = var65_66.get(var95_89);
                                                break block371;
                                            }
                                            var97_90 = var1_1;
                                            var47_50 = var23_26;
                                            var1_1 = var65_66;
                                            var21_24 = false;
                                            var20_23 = null;
                                        }
                                        if (var20_23 == null) {
                                            var20_23 = new ArrayList<E>();
                                        }
                                        var23_26 = var3_6.isNull(var7_10);
                                        if (var23_26) break block372;
                                        var48_51 = var25_28;
                                        var76_77 = var3_6.getLong(var7_10);
                                        var98_91 = var1_1;
                                        var1_1 = var64_65;
                                        var22_25 = var64_65.get(var76_77);
                                        break block373;
                                    }
                                    var98_91 = var1_1;
                                    var48_51 = var25_28;
                                    var1_1 = var64_65;
                                    var23_26 = false;
                                    var22_25 = null;
                                }
                                if (var22_25 == null) {
                                    var22_25 = new ArrayList<E>();
                                }
                                var25_28 = var3_6.isNull(var7_10);
                                if (var25_28) break block374;
                                var49_52 = var27_30;
                                var99_92 = var3_6.getLong(var7_10);
                                var101_93 = var1_1;
                                var1_1 = var63_64;
                                var24_27 = var63_64.get(var99_92);
                                break block375;
                            }
                            var101_93 = var1_1;
                            var49_52 = var27_30;
                            var1_1 = var63_64;
                            var25_28 = false;
                            var24_27 = null;
                        }
                        if (var24_27 == null) {
                            var24_27 = new ArrayList<E>();
                        }
                        var27_30 = var3_6.isNull(var7_10);
                        if (var27_30) break block376;
                        var50_53 = var29_32;
                        var102_94 = var3_6.getLong(var7_10);
                        var104_95 = var7_10;
                        var2_2 = var62_63;
                        var26_29 = var62_63.get(var102_94);
                        break block377;
                    }
                    var104_95 = var7_10;
                    var50_53 = var29_32;
                    var2_2 = var62_63;
                    var27_30 = false;
                    var26_29 = null;
                }
                if (var26_29 == null) {
                    var26_29 = new ArrayList<E>();
                }
                var28_31 = new ArrayList<E>();
                var28_31.setTemplateData((TemplateData)var6_9);
                var28_31.setTemplate((Template)var8_11);
                var28_31.setScript((Script)var10_13);
                var28_31.setDraft((Draft)var12_15);
                var28_31.setWithdraw((Withdraw)var14_17);
                var28_31.setTemplateGlobal((TemplateGlobal)var16_19);
                var28_31.setTemplateVideoList((List)var18_21);
                var28_31.setTemplateStickerList(var20_23);
                var28_31.setTemplateMusicList(var22_25);
                var28_31.setTemplateRecordingList(var24_27);
                var28_31.setScriptTrackPOJOList(var26_29);
                var6_9 = var61_62;
                var61_62.add(var28_31);
                var14_17 = var2_2;
                var16_19 = var1_1;
                var8_11 = var61_62;
                var51_54 = var39_42;
                var52_55 = var46_49;
                var46_49 = var48_51;
                var39_42 = var73_74;
                var28_31 = var88_84;
                var26_29 = var91_86;
                var24_27 = var94_88;
                var22_25 = var97_90;
                var20_23 = var98_91;
                var18_21 = var101_93;
                var7_10 = var104_95;
                var1_1 = this;
                var6_9 = var30_33;
                var30_33 = var70_71;
                var48_51 = var45_48;
                var43_46 = var32_35;
                var32_35 = var37_40;
                var45_48 = var40_43;
                var40_43 = var49_52;
                var37_40 = var53_56;
                var53_56 = var41_44;
                var49_52 = var44_47;
                var41_44 = var50_53;
                var44_47 = var38_41;
                var50_53 = var42_45;
                var38_41 = var56_58;
                var42_45 = var72_73;
                var56_58 = var31_34;
                var31_34 = var74_75;
                continue;
            }
lbl1149:
            // 1 sources

            var6_9 = var8_11;
            var2_2 = var1_1.this$0;
            var2_2 = G_TemplateDao_Impl.access$000((G_TemplateDao_Impl)var2_2);
            var2_2.setTransactionSuccessful();
            var3_6.close();
            return var8_11;
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
            G_TemplateDao_Impl.access$000(var1_1.this$0).endTransaction();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

