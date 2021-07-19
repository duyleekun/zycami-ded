/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$10;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$11;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$12;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$13;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$14;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$15;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$5;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$6;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$7;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl$9;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptDao;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;
import e.a.i0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class G_ScriptDao_Impl
implements G_ScriptDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfScript;
    private final EntityInsertionAdapter __insertionAdapterOfScript;
    private final EntityInsertionAdapter __insertionAdapterOfScript_1;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfScript;

    public G_ScriptDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_ScriptDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfScript = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfScript_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfScript = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfScript = sharedSQLiteStatement;
    }

    private void __fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate(LongSparseArray longSparseArray) {
        int n10;
        String string2;
        int n11;
        Object object;
        Object object2;
        String string3;
        int n12;
        int n13;
        int n14;
        Object object3;
        block27: {
            int n15;
            object3 = "temp_id";
            int n16 = longSparseArray.isEmpty();
            if (n16 != 0) {
                return;
            }
            n16 = longSparseArray.size();
            n14 = 0;
            n13 = 999;
            n12 = 0;
            string3 = null;
            if (n16 > n13) {
                object3 = new LongSparseArray(n13);
                n16 = longSparseArray.size();
                Object var9_11 = null;
                int n17 = 0;
                for (int i10 = 0; i10 < n16; ++i10) {
                    long l10 = longSparseArray.keyAt(i10);
                    ((LongSparseArray)object3).put(l10, null);
                    if (++n17 != n13) continue;
                    this.__fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate((LongSparseArray)object3);
                    longSparseArray.putAll((LongSparseArray)object3);
                    object3 = new LongSparseArray(n13);
                    n17 = 0;
                }
                if (n17 > 0) {
                    this.__fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate((LongSparseArray)object3);
                    longSparseArray.putAll((LongSparseArray)object3);
                }
                return;
            }
            object2 = StringUtil.newStringBuilder();
            object = "SELECT `id`,`temp_id`,`type_id`,`reference_id` FROM `Template` WHERE `temp_id` IN (";
            ((StringBuilder)object2).append((String)object);
            n13 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object2, n13);
            ((StringBuilder)object2).append(")");
            object2 = ((StringBuilder)object2).toString();
            object2 = RoomSQLiteQuery.acquire((String)object2, n13 += 0);
            n11 = n13 = 1;
            string2 = null;
            for (n10 = 0; n10 < (n15 = longSparseArray.size()); ++n10) {
                long l11 = longSparseArray.keyAt(n10);
                ((RoomSQLiteQuery)object2).bindLong(n11, l11);
                n11 += n13;
            }
            object = this.__db;
            object2 = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object2, false, null);
            n14 = CursorUtil.getColumnIndex((Cursor)object2, (String)object3);
            n13 = -1;
            if (n14 != n13) break block27;
            object2.close();
            return;
        }
        object = "id";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object);
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object3);
        string3 = "type_id";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string3);
        string2 = "reference_id";
        try {
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        }
        catch (Throwable throwable) {
            object2.close();
            throw throwable;
        }
        while (true) {
            n11 = (int)(object2.moveToNext() ? 1 : 0);
            if (n11 == 0) break;
            n11 = (int)(object2.isNull(n14) ? 1 : 0);
            if (n11 != 0) continue;
            long l12 = object2.getLong(n14);
            boolean bl2 = longSparseArray.containsKey(l12);
            if (!bl2) continue;
            Template template = new Template();
            long l13 = object2.getLong(n13);
            template.setId(l13);
            l13 = object2.getLong(n18);
            template.setTempId(l13);
            l13 = object2.getLong(n12);
            template.setTypeId(l13);
            l13 = object2.getLong(n10);
            template.setReferenceId(l13);
            longSparseArray.put(l12, template);
            continue;
            break;
        }
        object2.close();
        return;
    }

    private void __fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal(LongSparseArray longSparseArray) {
        int n10;
        int n11;
        float f10;
        RoomDatabase roomDatabase;
        int n12;
        Object object;
        Object object2;
        Object object3;
        int n13;
        Object object4;
        int n14;
        int n15;
        Object object5;
        LongSparseArray longSparseArray2;
        Object object6;
        block129: {
            object6 = this;
            longSparseArray2 = longSparseArray;
            object5 = "temp_id";
            int n16 = longSparseArray.isEmpty();
            if (n16) {
                return;
            }
            n16 = longSparseArray.size();
            n15 = 999;
            n14 = 0;
            object4 = null;
            n13 = 0;
            object3 = null;
            if (n16 > n15) {
                object5 = new LongSparseArray(n15);
                n16 = longSparseArray.size();
                Object var12_14 = null;
                float f11 = 0.0f;
                int n17 = 0;
                Object var15_20 = null;
                for (int i10 = 0; i10 < n16; i10 += 1) {
                    long l10 = longSparseArray2.keyAt(i10);
                    ((LongSparseArray)object5).put(l10, null);
                    if ((n17 += 1) != n15) continue;
                    ((G_ScriptDao_Impl)object6).__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal((LongSparseArray)object5);
                    longSparseArray2.putAll((LongSparseArray)object5);
                    object5 = new LongSparseArray(n15);
                    n17 = 0;
                    var15_20 = null;
                }
                if (n17 > 0) {
                    ((G_ScriptDao_Impl)object6).__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal((LongSparseArray)object5);
                    longSparseArray2.putAll((LongSparseArray)object5);
                }
                return;
            }
            object2 = StringUtil.newStringBuilder();
            object = "SELECT `id`,`temp_id`,`temp_duration`,`temp_timebase`,`temp_render`,`temp_display_type`,`temp_volume`,`temp_mute`,`voice_enable`,`filter_enable`,`filter_name`,`filter_local_source`,`filter_strength`,`effect_enable`,`effect_saturation`,`effect_contrast`,`effect_temperature`,`effect_hue`,`effect_exposure`,`effect_vignette`,`effect_sharpen`,`rotate_enable`,`rotate_rotate`,`roi_enable`,`roi_start_center`,`roi_start_width`,`roi_start_height`,`roi_end_center`,`roi_end_width`,`roi_end_height`,`roi_duration` FROM `TemplateGlobal` WHERE `temp_id` IN (";
            ((StringBuilder)object2).append((String)object);
            n15 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object2, n15);
            ((StringBuilder)object2).append(")");
            object2 = ((StringBuilder)object2).toString();
            object2 = RoomSQLiteQuery.acquire((String)object2, n15 += 0);
            n12 = n15 = 1;
            roomDatabase = null;
            f10 = 0.0f;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); n11 += 1) {
                long l11 = longSparseArray2.keyAt(n11);
                ((RoomSQLiteQuery)object2).bindLong(n12, l11);
                n12 += n15;
            }
            roomDatabase = ((G_ScriptDao_Impl)object6).__db;
            object2 = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
            n11 = CursorUtil.getColumnIndex((Cursor)object2, (String)object5);
            n12 = -1;
            if (n11 != n12) break block129;
            object2.close();
            return;
        }
        String string2 = "id";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object5);
        String string3 = "temp_duration";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string3);
        String string4 = "temp_timebase";
        int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string4);
        String string5 = "temp_render";
        int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string5);
        String string6 = "temp_display_type";
        int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string6);
        String string7 = "temp_volume";
        int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string7);
        String string8 = "temp_mute";
        int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string8);
        String string9 = "voice_enable";
        int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string9);
        object = "filter_enable";
        n15 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object);
        object4 = "filter_name";
        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object4);
        object3 = "filter_local_source";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object3);
        object6 = "filter_strength";
        int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object6);
        int n26 = n24;
        string9 = "effect_enable";
        n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string9);
        int n27 = n23;
        string8 = "effect_saturation";
        n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string8);
        int n28 = n22;
        string7 = "effect_contrast";
        n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string7);
        int n29 = n21;
        string6 = "effect_temperature";
        n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string6);
        int n30 = n20;
        string5 = "effect_hue";
        n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string5);
        int n31 = n19;
        string4 = "effect_exposure";
        n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string4);
        int n32 = n10;
        string3 = "effect_vignette";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string3);
        int n33 = n18;
        object5 = "effect_sharpen";
        n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object5);
        int n34 = n12;
        string2 = "rotate_enable";
        int n35 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "rotate_rotate";
        int n36 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_enable";
        int n37 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_start_center";
        int n38 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_start_width";
        int n39 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_start_height";
        int n40 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_end_center";
        int n41 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_end_width";
        int n42 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_end_height";
        int n43 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "roi_duration";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        }
        catch (Throwable throwable) {
            object2.close();
            throw throwable;
        }
        while (true) {
            int n44;
            block164: {
                int n45;
                int n46;
                block130: {
                    int n47;
                    int n48;
                    int n49;
                    int n50;
                    int n51;
                    int n52;
                    block162: {
                        block131: {
                            long l12;
                            block161: {
                                block160: {
                                    block159: {
                                        block158: {
                                            block153: {
                                                String string10;
                                                Object object7;
                                                String string11;
                                                float f12;
                                                float f13;
                                                float f14;
                                                float f15;
                                                block157: {
                                                    block156: {
                                                        float f16;
                                                        block155: {
                                                            block154: {
                                                                float f17;
                                                                block152: {
                                                                    block163: {
                                                                        block151: {
                                                                            block149: {
                                                                                block147: {
                                                                                    block145: {
                                                                                        block150: {
                                                                                            block148: {
                                                                                                block146: {
                                                                                                    block143: {
                                                                                                        block144: {
                                                                                                            block142: {
                                                                                                                block141: {
                                                                                                                    block140: {
                                                                                                                        block139: {
                                                                                                                            block138: {
                                                                                                                                block133: {
                                                                                                                                    block137: {
                                                                                                                                        block136: {
                                                                                                                                            block135: {
                                                                                                                                                block134: {
                                                                                                                                                    block132: {
                                                                                                                                                        n52 = object2.moveToNext();
                                                                                                                                                        if (!n52) break;
                                                                                                                                                        n52 = object2.isNull(n11);
                                                                                                                                                        if (n52) break block130;
                                                                                                                                                        n46 = n12;
                                                                                                                                                        n52 = n10;
                                                                                                                                                        l12 = object2.getLong(n11);
                                                                                                                                                        n51 = longSparseArray2.containsKey(l12);
                                                                                                                                                        if (!n51) break block131;
                                                                                                                                                        n51 = (int)(object2.isNull(n15) ? 1 : 0);
                                                                                                                                                        if (!n51) break block132;
                                                                                                                                                        n51 = (int)(object2.isNull(n14) ? 1 : 0);
                                                                                                                                                        if (!n51) break block132;
                                                                                                                                                        n51 = (int)(object2.isNull(n13) ? 1 : 0);
                                                                                                                                                        if (!n51) break block132;
                                                                                                                                                        n51 = (int)(object2.isNull(n25) ? 1 : 0);
                                                                                                                                                        if (!n51) break block132;
                                                                                                                                                        n50 = n25;
                                                                                                                                                        n51 = n15;
                                                                                                                                                        n49 = n14;
                                                                                                                                                        n48 = n13;
                                                                                                                                                        n47 = n11;
                                                                                                                                                        n25 = 0;
                                                                                                                                                        object6 = null;
                                                                                                                                                        break block133;
                                                                                                                                                    }
                                                                                                                                                    n51 = object2.getInt(n15);
                                                                                                                                                    if (n51) {
                                                                                                                                                        n51 = n15;
                                                                                                                                                        n15 = 1;
                                                                                                                                                        break block134;
                                                                                                                                                    }
                                                                                                                                                    n51 = n15;
                                                                                                                                                    n15 = 0;
                                                                                                                                                    object = null;
                                                                                                                                                }
                                                                                                                                                n48 = (int)(object2.isNull(n14) ? 1 : 0);
                                                                                                                                                if (!n48) break block135;
                                                                                                                                                n49 = n14;
                                                                                                                                                n14 = 0;
                                                                                                                                                object4 = null;
                                                                                                                                                break block136;
                                                                                                                                            }
                                                                                                                                            String string12 = object2.getString(n14);
                                                                                                                                            n49 = n14;
                                                                                                                                            object4 = string12;
                                                                                                                                        }
                                                                                                                                        n48 = object2.getInt(n13);
                                                                                                                                        if (n48) {
                                                                                                                                            n48 = n13;
                                                                                                                                            n47 = n11;
                                                                                                                                            n13 = 1;
                                                                                                                                            break block137;
                                                                                                                                        }
                                                                                                                                        n48 = n13;
                                                                                                                                        n47 = n11;
                                                                                                                                        n13 = 0;
                                                                                                                                        object3 = null;
                                                                                                                                    }
                                                                                                                                    f10 = object2.getFloat(n25);
                                                                                                                                    n50 = n25;
                                                                                                                                    object6 = new TemplateFilter(n15 != 0, (String)object4, n13 != 0, f10);
                                                                                                                                }
                                                                                                                                n15 = (int)(object2.isNull(n24) ? 1 : 0);
                                                                                                                                if (!n15) break block138;
                                                                                                                                n15 = (int)(object2.isNull(n23) ? 1 : 0);
                                                                                                                                if (!n15) break block138;
                                                                                                                                n15 = (int)(object2.isNull(n22) ? 1 : 0);
                                                                                                                                if (!n15) break block138;
                                                                                                                                n15 = (int)(object2.isNull(n21) ? 1 : 0);
                                                                                                                                if (!n15) break block138;
                                                                                                                                n15 = (int)(object2.isNull(n20) ? 1 : 0);
                                                                                                                                if (!n15) break block138;
                                                                                                                                n15 = (int)(object2.isNull(n19) ? 1 : 0);
                                                                                                                                if (!n15) break block138;
                                                                                                                                n15 = n52;
                                                                                                                                n14 = (int)(object2.isNull(n52) ? 1 : 0);
                                                                                                                                if (n14 == 0) break block139;
                                                                                                                                n14 = (int)(object2.isNull(n18) ? 1 : 0);
                                                                                                                                if (n14 == 0) break block139;
                                                                                                                                n13 = n35;
                                                                                                                                n14 = 0;
                                                                                                                                object4 = null;
                                                                                                                                break block140;
                                                                                                                            }
                                                                                                                            n15 = n52;
                                                                                                                        }
                                                                                                                        n14 = object2.getInt(n24);
                                                                                                                        n45 = n14 != 0 ? 1 : 0;
                                                                                                                        f17 = object2.getFloat(n23);
                                                                                                                        f15 = object2.getFloat(n22);
                                                                                                                        f14 = object2.getFloat(n21);
                                                                                                                        f16 = object2.getFloat(n20);
                                                                                                                        f13 = object2.getFloat(n19);
                                                                                                                        f12 = object2.getFloat(n15);
                                                                                                                        float f18 = object2.getFloat(n18);
                                                                                                                        object4 = new TemplateEffect(n45 != 0, f17, f15, f14, f16, f13, f12, f18);
                                                                                                                        n13 = n35;
                                                                                                                    }
                                                                                                                    n11 = (int)(object2.isNull(n13) ? 1 : 0);
                                                                                                                    if (!n11) break block141;
                                                                                                                    n11 = n36;
                                                                                                                    n35 = (int)(object2.isNull(n36) ? 1 : 0);
                                                                                                                    if (!n35) break block142;
                                                                                                                    n35 = n18;
                                                                                                                    n52 = n15;
                                                                                                                    n36 = n13;
                                                                                                                    n18 = n37;
                                                                                                                    n13 = 0;
                                                                                                                    object3 = null;
                                                                                                                    break block143;
                                                                                                                }
                                                                                                                n11 = n36;
                                                                                                            }
                                                                                                            n35 = object2.getInt(n13);
                                                                                                            if (n35) {
                                                                                                                n35 = n18;
                                                                                                                n52 = n15;
                                                                                                                n18 = 1;
                                                                                                                break block144;
                                                                                                            }
                                                                                                            n35 = n18;
                                                                                                            n52 = n15;
                                                                                                            n18 = 0;
                                                                                                            object5 = null;
                                                                                                        }
                                                                                                        n15 = object2.getInt(n11);
                                                                                                        n36 = n13;
                                                                                                        object3 = new TemplateRotate(n18 != 0, n15);
                                                                                                        n18 = n37;
                                                                                                    }
                                                                                                    n15 = (int)(object2.isNull(n18) ? 1 : 0);
                                                                                                    if (!n15) break block145;
                                                                                                    n15 = n38;
                                                                                                    n37 = (int)(object2.isNull(n38) ? 1 : 0);
                                                                                                    if (!n37) break block146;
                                                                                                    n37 = n11;
                                                                                                    n11 = n39;
                                                                                                    n38 = (int)(object2.isNull(n39) ? 1 : 0);
                                                                                                    if (!n38) break block147;
                                                                                                    n38 = n19;
                                                                                                    n19 = n40;
                                                                                                    n39 = (int)(object2.isNull(n40) ? 1 : 0);
                                                                                                    if (!n39) break block148;
                                                                                                    n39 = n20;
                                                                                                    n20 = n41;
                                                                                                    n40 = (int)(object2.isNull(n41) ? 1 : 0);
                                                                                                    if (!n40) break block149;
                                                                                                    n40 = n21;
                                                                                                    n21 = n42;
                                                                                                    n41 = (int)(object2.isNull(n42) ? 1 : 0);
                                                                                                    if (!n41) break block150;
                                                                                                    n41 = n22;
                                                                                                    n22 = n43;
                                                                                                    n42 = (int)(object2.isNull(n43) ? 1 : 0);
                                                                                                    if (!n42) break block151;
                                                                                                    n42 = n23;
                                                                                                    n23 = n46;
                                                                                                    n43 = (int)(object2.isNull(n46) ? 1 : 0);
                                                                                                    if (!n43) break block152;
                                                                                                    n46 = n18;
                                                                                                    n43 = n15;
                                                                                                    n18 = 0;
                                                                                                    object5 = null;
                                                                                                    break block153;
                                                                                                }
                                                                                                n37 = n11;
                                                                                                n38 = n19;
                                                                                                n11 = n39;
                                                                                                n19 = n40;
                                                                                            }
                                                                                            n39 = n20;
                                                                                            n40 = n21;
                                                                                            n20 = n41;
                                                                                            n21 = n42;
                                                                                        }
                                                                                        n41 = n22;
                                                                                        n42 = n23;
                                                                                        n22 = n43;
                                                                                        break block163;
                                                                                    }
                                                                                    n37 = n11;
                                                                                    n15 = n38;
                                                                                    n11 = n39;
                                                                                }
                                                                                n38 = n19;
                                                                                n39 = n20;
                                                                                n19 = n40;
                                                                                n20 = n41;
                                                                            }
                                                                            n40 = n21;
                                                                            n41 = n22;
                                                                            n21 = n42;
                                                                            n22 = n43;
                                                                        }
                                                                        n42 = n23;
                                                                    }
                                                                    n23 = n46;
                                                                }
                                                                n43 = object2.getInt(n18);
                                                                n45 = n43 != 0 ? 1 : 0;
                                                                n43 = (int)(object2.isNull(n15) ? 1 : 0);
                                                                if (!n43) break block154;
                                                                f17 = 0.0f;
                                                                string11 = null;
                                                                break block155;
                                                            }
                                                            object7 = object2.getString(n15);
                                                            string11 = object7;
                                                        }
                                                        f15 = object2.getFloat(n11);
                                                        f14 = object2.getFloat(n19);
                                                        n43 = (int)(object2.isNull(n20) ? 1 : 0);
                                                        if (!n43) break block156;
                                                        f16 = 0.0f;
                                                        string10 = null;
                                                        break block157;
                                                    }
                                                    object7 = object2.getString(n20);
                                                    string10 = object7;
                                                }
                                                f13 = object2.getFloat(n21);
                                                f12 = object2.getFloat(n22);
                                                long l13 = object2.getLong(n23);
                                                object7 = new TemplateRoi(n45 != 0, string11, f15, f14, string10, f13, f12, l13);
                                                n46 = n18;
                                                object5 = object7;
                                                n43 = n15;
                                            }
                                            object = new TemplateGlobal();
                                            n44 = n11;
                                            n45 = n20;
                                            n11 = n34;
                                            n34 = n19;
                                            long l14 = object2.getLong(n11);
                                            ((TemplateGlobal)object).setId(l14);
                                            n19 = n33;
                                            n33 = n21;
                                            long l15 = object2.getLong(n19);
                                            ((TemplateGlobal)object).setTempId(l15);
                                            n20 = n32;
                                            n32 = n22;
                                            long l16 = object2.getLong(n20);
                                            ((TemplateGlobal)object).setDuration(l16);
                                            n22 = n19;
                                            n21 = n31;
                                            n31 = n20;
                                            l14 = object2.getLong(n21);
                                            ((TemplateGlobal)object).setTimebase(l14);
                                            n19 = n30;
                                            n20 = (int)(object2.isNull(n30) ? 1 : 0);
                                            if (!n20) break block158;
                                            n20 = 0;
                                            string5 = null;
                                            break block159;
                                        }
                                        string5 = object2.getString(n30);
                                    }
                                    ((TemplateGlobal)object).setRender(string5);
                                    n20 = n29;
                                    n29 = n11;
                                    n11 = object2.getInt(n20);
                                    ((TemplateGlobal)object).setDisplayType(n11);
                                    n30 = n19;
                                    n11 = n28;
                                    float f19 = object2.getFloat(n28);
                                    ((TemplateGlobal)object).setVolume(f19);
                                    n19 = n27;
                                    n27 = object2.getInt(n27);
                                    if (n27) {
                                        n11 = 1;
                                        f10 = Float.MIN_VALUE;
                                        break block160;
                                    }
                                    n11 = 0;
                                    f10 = 0.0f;
                                    roomDatabase = null;
                                }
                                ((TemplateGlobal)object).setMute(n11 != 0);
                                n11 = n26;
                                n26 = object2.getInt(n26);
                                if (n26) {
                                    n26 = n11;
                                    n11 = 1;
                                    f10 = Float.MIN_VALUE;
                                    break block161;
                                }
                                n26 = n11;
                                n11 = 0;
                                f10 = 0.0f;
                                roomDatabase = null;
                            }
                            ((TemplateGlobal)object).setVoiceEnable(n11 != 0);
                            ((TemplateGlobal)object).setFilter((TemplateFilter)object6);
                            ((TemplateGlobal)object).setEffect((TemplateEffect)object4);
                            ((TemplateGlobal)object).setRotate((TemplateRotate)object3);
                            ((TemplateGlobal)object).setRoi((TemplateRoi)object5);
                            longSparseArray2.put(l12, object);
                            break block162;
                        }
                        n50 = n25;
                        n51 = n15;
                        n49 = n14;
                        n48 = n13;
                        n47 = n11;
                        n44 = n39;
                        n45 = n41;
                        n39 = n20;
                        n41 = n22;
                        n20 = n29;
                        n22 = n33;
                        n29 = n34;
                        n34 = n40;
                        n33 = n42;
                        n40 = n21;
                        n42 = n23;
                        n21 = n31;
                        n31 = n32;
                        n32 = n43;
                        n23 = n12;
                        n46 = n37;
                        n43 = n38;
                        n38 = n19;
                        n19 = n27;
                        n37 = n36;
                        n36 = n35;
                        n35 = n18;
                    }
                    n27 = n19;
                    n12 = n23;
                    n18 = n35;
                    n35 = n36;
                    n36 = n37;
                    n19 = n38;
                    n23 = n42;
                    n38 = n43;
                    n10 = n52;
                    n37 = n46;
                    n15 = n51;
                    n13 = n48;
                    n14 = n49;
                    n11 = n47;
                    n25 = n50;
                    n43 = n32;
                    n42 = n33;
                    n33 = n22;
                    n32 = n31;
                    n22 = n41;
                    n41 = n45;
                    break block164;
                }
                n46 = n37;
                n44 = n39;
                n45 = n41;
                n39 = n20;
                n41 = n22;
                n20 = n29;
                n22 = n33;
                n29 = n34;
                n37 = n36;
                n34 = n40;
                n33 = n42;
                n40 = n21;
                n21 = n31;
                n31 = n32;
                n36 = n35;
                n32 = n43;
                n43 = n38;
                n36 = n37;
                n37 = n46;
                n33 = n22;
                n43 = n32;
                n22 = n41;
                n41 = n45;
                n32 = n31;
            }
            n31 = n21;
            n21 = n40;
            n40 = n34;
            n34 = n29;
            n29 = n20;
            n20 = n39;
            n39 = n44;
        }
        object2.close();
        return;
    }

    private void __fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic(LongSparseArray longSparseArray) {
        String string2;
        int n10;
        int n11;
        int n12;
        Object object;
        Object object2;
        String string3;
        int n13;
        int n14;
        Object object3;
        Object object4;
        Object object5;
        block72: {
            object5 = this;
            object4 = longSparseArray;
            object3 = "temp_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 999;
            n13 = 0;
            string3 = null;
            if (n15 > n14) {
                object3 = new LongSparseArray(n14);
                n15 = longSparseArray.size();
                Object var10_12 = null;
                int n16 = 0;
                Object var12_16 = null;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l10 = ((LongSparseArray)object4).keyAt(i10);
                    Object object6 = ((LongSparseArray)object4).valueAt(i10);
                    ((LongSparseArray)object3).put(l10, object6);
                    if (++n16 != n14) continue;
                    ((G_ScriptDao_Impl)object5).__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic((LongSparseArray)object3);
                    object3 = new LongSparseArray(n14);
                    n16 = 0;
                    var12_16 = null;
                }
                if (n16 > 0) {
                    ((G_ScriptDao_Impl)object5).__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic((LongSparseArray)object3);
                }
                return;
            }
            object2 = StringUtil.newStringBuilder();
            object = "SELECT `id`,`temp_id`,`name`,`title`,`attach_time`,`start_time`,`end_time`,`timebase`,`volume`,`mute`,`local_source`,`customer_uuid`,`fade_in_start_time`,`fade_in_end_time`,`fade_in_start_volume`,`fade_in_end_volume`,`fade_out_start_time`,`fade_out_end_time`,`fade_out_start_volume`,`fade_out_end_volume` FROM `TemplateMusic` WHERE `temp_id` IN (";
            ((StringBuilder)object2).append((String)object);
            n14 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object2, n14);
            ((StringBuilder)object2).append(")");
            object2 = ((StringBuilder)object2).toString();
            object2 = RoomSQLiteQuery.acquire((String)object2, n14 += 0);
            n12 = n14 = 1;
            RoomDatabase roomDatabase = null;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                long l11 = ((LongSparseArray)object4).keyAt(n11);
                ((RoomSQLiteQuery)object2).bindLong(n12, l11);
                n12 += n14;
            }
            roomDatabase = ((G_ScriptDao_Impl)object5).__db;
            n12 = 0;
            string2 = null;
            object2 = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
            n11 = CursorUtil.getColumnIndex((Cursor)object2, (String)object3);
            n10 = -1;
            if (n11 != n10) break block72;
            object2.close();
            return;
        }
        String string4 = "id";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string4);
        int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object3);
        String string5 = "name";
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string5);
        String string6 = "title";
        int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string6);
        String string7 = "attach_time";
        int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string7);
        String string8 = "start_time";
        int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string8);
        String string9 = "end_time";
        int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string9);
        String string10 = "timebase";
        int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string10);
        String string11 = "volume";
        int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string11);
        object = "mute";
        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object);
        string3 = "local_source";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string3);
        string2 = "customer_uuid";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        object5 = "fade_in_start_time";
        int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object5);
        int n26 = n12;
        string2 = "fade_in_end_time";
        int n27 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_in_start_volume";
        int n28 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_in_end_volume";
        int n29 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_start_time";
        int n30 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_end_time";
        int n31 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_start_volume";
        int n32 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_end_volume";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        }
        catch (Throwable throwable) {
            object2.close();
            throw throwable;
        }
        while (true) {
            int n33;
            int n34;
            block93: {
                block73: {
                    int n35;
                    int n36;
                    block90: {
                        block74: {
                            block89: {
                                block88: {
                                    TemplateAudioTransition templateAudioTransition;
                                    TemplateAudioTransition templateAudioTransition2;
                                    boolean bl2;
                                    boolean bl3;
                                    float f10;
                                    long l12;
                                    long l13;
                                    long l14;
                                    long l15;
                                    String string12;
                                    String string13;
                                    long l16;
                                    long l17;
                                    block87: {
                                        TemplateAudioTransition templateAudioTransition3;
                                        float f11;
                                        int n37;
                                        block86: {
                                            block92: {
                                                block84: {
                                                    block85: {
                                                        block83: {
                                                            TemplateAudioTransition templateAudioTransition4;
                                                            block82: {
                                                                block79: {
                                                                    block91: {
                                                                        block80: {
                                                                            block81: {
                                                                                block78: {
                                                                                    block77: {
                                                                                        block76: {
                                                                                            block75: {
                                                                                                n36 = object2.moveToNext();
                                                                                                if (n36 == 0) break;
                                                                                                n36 = object2.isNull(n11);
                                                                                                if (n36 != 0) break block73;
                                                                                                n36 = n14;
                                                                                                n34 = n13;
                                                                                                long l18 = object2.getLong(n11);
                                                                                                object = ((LongSparseArray)object4).get(l18);
                                                                                                object = (ArrayList)object;
                                                                                                if (object == null) break block74;
                                                                                                l17 = object2.getLong(n10);
                                                                                                l16 = object2.getLong(n17);
                                                                                                n13 = (int)(object2.isNull(n18) ? 1 : 0);
                                                                                                if (n13 == 0) break block75;
                                                                                                string13 = null;
                                                                                                break block76;
                                                                                            }
                                                                                            string13 = string3 = object2.getString(n18);
                                                                                        }
                                                                                        n13 = (int)(object2.isNull(n19) ? 1 : 0);
                                                                                        if (n13 == 0) break block77;
                                                                                        string12 = null;
                                                                                        break block78;
                                                                                    }
                                                                                    string12 = string3 = object2.getString(n19);
                                                                                }
                                                                                l15 = object2.getLong(n20);
                                                                                l14 = object2.getLong(n21);
                                                                                l13 = object2.getLong(n22);
                                                                                l12 = object2.getLong(n23);
                                                                                f10 = object2.getFloat(n24);
                                                                                n13 = n36;
                                                                                n36 = object2.getInt(n36);
                                                                                n37 = n34;
                                                                                bl3 = n36 != 0;
                                                                                n36 = object2.getInt(n37);
                                                                                bl2 = n36 != 0;
                                                                                n36 = (int)(object2.isNull(n25) ? 1 : 0);
                                                                                if (n36 == 0) break block79;
                                                                                n34 = n37;
                                                                                n37 = n27;
                                                                                n27 = (int)(object2.isNull(n27) ? 1 : 0);
                                                                                if (n27 == 0) break block80;
                                                                                n27 = n17;
                                                                                n17 = n28;
                                                                                n28 = (int)(object2.isNull(n28) ? 1 : 0);
                                                                                if (n28 == 0) break block81;
                                                                                n36 = n13;
                                                                                n13 = n29;
                                                                                n28 = (int)(object2.isNull(n29) ? 1 : 0);
                                                                                if (n28 == 0) break block82;
                                                                                n28 = n37;
                                                                                n37 = n30;
                                                                                templateAudioTransition2 = null;
                                                                                break block83;
                                                                            }
                                                                            n36 = n13;
                                                                            break block91;
                                                                        }
                                                                        n27 = n17;
                                                                        n36 = n13;
                                                                        n17 = n28;
                                                                    }
                                                                    n13 = n29;
                                                                    break block82;
                                                                }
                                                                n34 = n37;
                                                                n36 = n13;
                                                                n37 = n27;
                                                                n13 = n29;
                                                                n27 = n17;
                                                                n17 = n28;
                                                            }
                                                            long l19 = object2.getLong(n25);
                                                            long l20 = object2.getLong(n37);
                                                            float f12 = object2.getFloat(n17);
                                                            f11 = object2.getFloat(n13);
                                                            templateAudioTransition2 = templateAudioTransition4;
                                                            templateAudioTransition4 = new TemplateAudioTransition(l19, l20, f12, f11);
                                                            n28 = n37;
                                                            n37 = n30;
                                                        }
                                                        n29 = (int)(object2.isNull(n37) ? 1 : 0);
                                                        if (n29 == 0) break block84;
                                                        n29 = n25;
                                                        n25 = n31;
                                                        n30 = (int)(object2.isNull(n31) ? 1 : 0);
                                                        if (n30 == 0) break block85;
                                                        n30 = n17;
                                                        n17 = n32;
                                                        n31 = (int)(object2.isNull(n32) ? 1 : 0);
                                                        if (n31 == 0) break block86;
                                                        n31 = (int)(object2.isNull(n12) ? 1 : 0);
                                                        if (n31 == 0) break block86;
                                                        n31 = n37;
                                                        templateAudioTransition = null;
                                                        break block87;
                                                    }
                                                    n30 = n17;
                                                    break block92;
                                                }
                                                n29 = n25;
                                                n30 = n17;
                                                n25 = n31;
                                            }
                                            n17 = n32;
                                        }
                                        long l21 = object2.getLong(n37);
                                        long l22 = object2.getLong(n25);
                                        f11 = object2.getFloat(n17);
                                        float f13 = object2.getFloat(n12);
                                        templateAudioTransition = templateAudioTransition3;
                                        templateAudioTransition3 = new TemplateAudioTransition(l21, l22, f11, f13);
                                        n31 = n37;
                                    }
                                    object4 = new TemplateMusic(l17, l16, string13, string12, l15, l14, l13, l12, f10, bl3, bl2, templateAudioTransition2, templateAudioTransition);
                                    n32 = n25;
                                    n25 = n26;
                                    n26 = (int)(object2.isNull(n26) ? 1 : 0);
                                    if (n26 == 0) break block88;
                                    n35 = n25;
                                    n25 = 0;
                                    object5 = null;
                                    break block89;
                                }
                                String string14 = object2.getString(n25);
                                n35 = n25;
                                object5 = string14;
                            }
                            ((TemplateBaseData)object4).setCustomerUUID((String)object5);
                            ((ArrayList)object).add(object4);
                            break block90;
                        }
                        n35 = n26;
                        n13 = n29;
                        n29 = n25;
                        n33 = n27;
                        n27 = n17;
                        n17 = n32;
                        n32 = n31;
                        n31 = n30;
                        n30 = n28;
                        n28 = n33;
                    }
                    object4 = longSparseArray;
                    n25 = n29;
                    n14 = n36;
                    n26 = n35;
                    n29 = n13;
                    break block93;
                }
                n34 = n13;
                n13 = n29;
                n33 = n27;
                n27 = n17;
                n17 = n32;
                n32 = n31;
                n31 = n30;
                n30 = n28;
                n28 = n33;
                object4 = longSparseArray;
            }
            n13 = n34;
            n33 = n32;
            n32 = n17;
            n17 = n27;
            n27 = n28;
            n28 = n30;
            n30 = n31;
            n31 = n33;
        }
        object2.close();
        return;
    }

    private void __fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker(LongSparseArray longSparseArray) {
        String string2;
        int n10;
        int n11;
        int n12;
        String string3;
        Object object;
        String string4;
        int n13;
        int n14;
        Object object2;
        Object object3;
        Object object4;
        block70: {
            object4 = this;
            object3 = longSparseArray;
            object2 = "temp_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 999;
            n13 = 0;
            string4 = null;
            if (n15 > n14) {
                object2 = new LongSparseArray(n14);
                n15 = longSparseArray.size();
                Object var10_12 = null;
                int n16 = 0;
                Object var12_16 = null;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l10 = ((LongSparseArray)object3).keyAt(i10);
                    Object object5 = ((LongSparseArray)object3).valueAt(i10);
                    ((LongSparseArray)object2).put(l10, object5);
                    if (++n16 != n14) continue;
                    ((G_ScriptDao_Impl)object4).__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker((LongSparseArray)object2);
                    object2 = new LongSparseArray(n14);
                    n16 = 0;
                    var12_16 = null;
                }
                if (n16 > 0) {
                    ((G_ScriptDao_Impl)object4).__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker((LongSparseArray)object2);
                }
                return;
            }
            object = StringUtil.newStringBuilder();
            string3 = "SELECT `id`,`temp_id`,`start_time`,`end_time`,`angle`,`center`,`type`,`sticker_type_id`,`scale`,`text_font_size`,`text_color`,`text_content`,`text_caption_name`,`caption_local_source`,`text_font_name`,`image_name`,`gif_name`,`thumb_url`,`local_source`,`customer_uuid` FROM `TemplateSticker` WHERE `temp_id` IN (";
            ((StringBuilder)object).append(string3);
            n14 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object, n14);
            ((StringBuilder)object).append(")");
            object = ((StringBuilder)object).toString();
            object = RoomSQLiteQuery.acquire((String)object, n14 += 0);
            n12 = n14 = 1;
            RoomDatabase roomDatabase = null;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                long l11 = ((LongSparseArray)object3).keyAt(n11);
                ((RoomSQLiteQuery)object).bindLong(n12, l11);
                n12 += n14;
            }
            roomDatabase = ((G_ScriptDao_Impl)object4).__db;
            n12 = 0;
            string2 = null;
            object = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object, false, null);
            n11 = CursorUtil.getColumnIndex((Cursor)object, (String)object2);
            n10 = -1;
            if (n11 != n10) break block70;
            object.close();
            return;
        }
        String string5 = "id";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
        String string6 = "start_time";
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string6);
        String string7 = "end_time";
        int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string7);
        String string8 = "angle";
        int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string8);
        String string9 = "center";
        int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string9);
        String string10 = "type";
        int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string10);
        String string11 = "sticker_type_id";
        int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string11);
        String string12 = "scale";
        int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string12);
        string3 = "text_font_size";
        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
        string4 = "text_color";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
        string2 = "text_content";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
        object4 = "text_caption_name";
        int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object4);
        int n26 = n17;
        object2 = "caption_local_source";
        n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
        int n27 = n10;
        string5 = "text_font_name";
        int n28 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        string5 = "image_name";
        int n29 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        string5 = "gif_name";
        int n30 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        string5 = "thumb_url";
        int n31 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        string5 = "local_source";
        int n32 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        string5 = "customer_uuid";
        try {
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        }
        catch (Throwable throwable) {
            object.close();
            throw throwable;
        }
        while (true) {
            int n33;
            block95: {
                block71: {
                    int n34;
                    int n35;
                    block94: {
                        block72: {
                            block93: {
                                block92: {
                                    boolean bl2;
                                    String string13;
                                    String string14;
                                    String string15;
                                    String string16;
                                    boolean bl3;
                                    String string17;
                                    Object object6;
                                    Object object7;
                                    float f10;
                                    float f11;
                                    long l12;
                                    Object object8;
                                    Object object9;
                                    float f12;
                                    long l13;
                                    long l14;
                                    block91: {
                                        int n36;
                                        block90: {
                                            String string18;
                                            block89: {
                                                block88: {
                                                    String string19;
                                                    block87: {
                                                        block86: {
                                                            String string20;
                                                            block85: {
                                                                block84: {
                                                                    String string21;
                                                                    block83: {
                                                                        block82: {
                                                                            String string22;
                                                                            block81: {
                                                                                block80: {
                                                                                    block79: {
                                                                                        block78: {
                                                                                            block77: {
                                                                                                block76: {
                                                                                                    block75: {
                                                                                                        block74: {
                                                                                                            block73: {
                                                                                                                n35 = object.moveToNext();
                                                                                                                if (n35 == 0) break;
                                                                                                                n35 = object.isNull(n11);
                                                                                                                if (n35 != 0) break block71;
                                                                                                                n35 = n25;
                                                                                                                n33 = n17;
                                                                                                                long l15 = object.getLong(n11);
                                                                                                                object4 = ((LongSparseArray)object3).get(l15);
                                                                                                                object4 = (ArrayList)object4;
                                                                                                                if (object4 == null) break block72;
                                                                                                                l14 = object.getLong(n18);
                                                                                                                l13 = object.getLong(n19);
                                                                                                                f12 = object.getFloat(n20);
                                                                                                                n17 = (int)(object.isNull(n21) ? 1 : 0);
                                                                                                                if (n17 == 0) break block73;
                                                                                                                object9 = null;
                                                                                                                break block74;
                                                                                                            }
                                                                                                            object9 = object2 = object.getString(n21);
                                                                                                        }
                                                                                                        n17 = (int)(object.isNull(n22) ? 1 : 0);
                                                                                                        if (n17 == 0) break block75;
                                                                                                        object8 = null;
                                                                                                        break block76;
                                                                                                    }
                                                                                                    object8 = object2 = object.getString(n22);
                                                                                                }
                                                                                                l12 = object.getLong(n23);
                                                                                                f11 = object.getFloat(n24);
                                                                                                f10 = object.getFloat(n14);
                                                                                                n17 = (int)(object.isNull(n13) ? 1 : 0);
                                                                                                if (n17 == 0) break block77;
                                                                                                object7 = null;
                                                                                                break block78;
                                                                                            }
                                                                                            object7 = object2 = object.getString(n13);
                                                                                        }
                                                                                        n17 = (int)(object.isNull(n12) ? 1 : 0);
                                                                                        if (n17 == 0) break block79;
                                                                                        n17 = n35;
                                                                                        object6 = null;
                                                                                        break block80;
                                                                                    }
                                                                                    object6 = object2 = object.getString(n12);
                                                                                    n17 = n35;
                                                                                }
                                                                                n35 = (int)(object.isNull(n17) ? 1 : 0);
                                                                                if (n35 == 0) break block81;
                                                                                n36 = n33;
                                                                                string17 = null;
                                                                                break block82;
                                                                            }
                                                                            string17 = string22 = object.getString(n17);
                                                                            n36 = n33;
                                                                        }
                                                                        n35 = object.getInt(n36);
                                                                        n33 = n36;
                                                                        n36 = n28;
                                                                        bl3 = n35 != 0;
                                                                        n28 = (int)(object.isNull(n36) ? 1 : 0);
                                                                        if (n28 == 0) break block83;
                                                                        n28 = n36;
                                                                        n36 = n29;
                                                                        string16 = null;
                                                                        break block84;
                                                                    }
                                                                    string16 = string21 = object.getString(n36);
                                                                    n28 = n36;
                                                                    n36 = n29;
                                                                }
                                                                n29 = (int)(object.isNull(n36) ? 1 : 0);
                                                                if (n29 == 0) break block85;
                                                                n29 = n36;
                                                                n36 = n30;
                                                                string15 = null;
                                                                break block86;
                                                            }
                                                            string15 = string20 = object.getString(n36);
                                                            n29 = n36;
                                                            n36 = n30;
                                                        }
                                                        n30 = (int)(object.isNull(n36) ? 1 : 0);
                                                        if (n30 == 0) break block87;
                                                        n30 = n36;
                                                        n36 = n31;
                                                        string14 = null;
                                                        break block88;
                                                    }
                                                    string14 = string19 = object.getString(n36);
                                                    n30 = n36;
                                                    n36 = n31;
                                                }
                                                n31 = (int)(object.isNull(n36) ? 1 : 0);
                                                if (n31 == 0) break block89;
                                                n31 = n36;
                                                n36 = n32;
                                                string13 = null;
                                                break block90;
                                            }
                                            string13 = string18 = object.getString(n36);
                                            n31 = n36;
                                            n36 = n32;
                                        }
                                        n32 = object.getInt(n36);
                                        if (n32 != 0) {
                                            n32 = n36;
                                            bl2 = true;
                                            break block91;
                                        }
                                        n32 = n36;
                                        bl2 = false;
                                    }
                                    object3 = new TemplateSticker(l14, l13, f12, (String)object9, (String)object8, l12, f11, f10, string16, (String)object7, (String)object6, string17, bl3, string15, string14, string13, bl2);
                                    n35 = n17;
                                    n34 = n13;
                                    n17 = n27;
                                    n27 = n14;
                                    long l16 = object.getLong(n17);
                                    ((TemplateSticker)object3).setId(l16);
                                    n14 = n26;
                                    n26 = n11;
                                    long l17 = object.getLong(n14);
                                    ((TemplateSticker)object3).setTempId(l17);
                                    n13 = (int)(object.isNull(n10) ? 1 : 0);
                                    if (n13 == 0) break block92;
                                    n13 = 0;
                                    string4 = null;
                                    break block93;
                                }
                                string4 = object.getString(n10);
                            }
                            ((TemplateBaseData)object3).setCustomerUUID(string4);
                            ((ArrayList)object4).add(object3);
                            break block94;
                        }
                        n34 = n13;
                        n17 = n27;
                        n27 = n14;
                        n14 = n26;
                        n26 = n11;
                    }
                    object3 = longSparseArray;
                    n11 = n26;
                    n25 = n35;
                    n13 = n34;
                    n26 = n14;
                    break block95;
                }
                n33 = n17;
                n17 = n27;
                n27 = n14;
                n14 = n26;
                object3 = longSparseArray;
            }
            n14 = n27;
            n27 = n17;
            n17 = n33;
        }
        object.close();
        return;
    }

    private void __fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo(LongSparseArray longSparseArray) {
        int n10;
        String string2;
        long l10;
        int n11;
        int n12;
        Object object;
        float f10;
        int n13;
        Object object2;
        Object object3;
        Object object4;
        float f11;
        int n14;
        float f12;
        int n15;
        Object object5;
        Object object6;
        Object object7;
        block196: {
            object7 = this;
            object6 = longSparseArray;
            object5 = "temp_id";
            int n16 = longSparseArray.isEmpty();
            if (n16 != 0) {
                return;
            }
            n16 = longSparseArray.size();
            n15 = 999;
            f12 = 1.4E-42f;
            n14 = 0;
            f11 = 0.0f;
            object4 = null;
            if (n16 > n15) {
                object5 = new LongSparseArray(n15);
                n16 = longSparseArray.size();
                Object var12_14 = null;
                int n17 = 0;
                Object var14_18 = null;
                float f13 = 0.0f;
                for (int i10 = 0; i10 < n16; ++i10) {
                    long l11 = ((LongSparseArray)object6).keyAt(i10);
                    Object object8 = ((LongSparseArray)object6).valueAt(i10);
                    ((LongSparseArray)object5).put(l11, object8);
                    if (++n17 != n15) continue;
                    ((G_ScriptDao_Impl)object7).__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo((LongSparseArray)object5);
                    object5 = new LongSparseArray(n15);
                    n17 = 0;
                    var14_18 = null;
                    f13 = 0.0f;
                }
                if (n17 > 0) {
                    ((G_ScriptDao_Impl)object7).__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo((LongSparseArray)object5);
                }
                return;
            }
            object3 = StringUtil.newStringBuilder();
            object2 = "SELECT `id`,`temp_id`,`timebase`,`start_time`,`end_time`,`duration`,`mute`,`volume`,`voice_enable`,`rate`,`rate_type`,`bezier_rate`,`videoPath`,`is_local_source`,`is_reverse`,`reverse_path`,`customer_uuid`,`filter_enable`,`filter_name`,`filter_local_source`,`filter_strength`,`effect_enable`,`effect_saturation`,`effect_contrast`,`effect_temperature`,`effect_hue`,`effect_exposure`,`effect_vignette`,`effect_sharpen`,`rotate_enable`,`rotate_rotate`,`transition_name`,`transition_duration`,`transition_timebase`,`transition_local_source`,`transition_thumb`,`roi_enable`,`roi_start_center`,`roi_start_width`,`roi_start_height`,`roi_end_center`,`roi_end_width`,`roi_end_height`,`roi_duration`,`rotate_frame_center`,`rotate_frame_scale`,`rotate_frame_rotate` FROM `TemplateVideo` WHERE `temp_id` IN (";
            ((StringBuilder)object3).append((String)object2);
            n15 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object3, n15);
            ((StringBuilder)object3).append(")");
            object3 = ((StringBuilder)object3).toString();
            object3 = RoomSQLiteQuery.acquire((String)object3, n15 += 0);
            n15 = 1;
            f12 = Float.MIN_VALUE;
            n13 = n15;
            f10 = f12;
            object = null;
            for (n12 = 0; n12 < (n11 = longSparseArray.size()); ++n12) {
                l10 = ((LongSparseArray)object6).keyAt(n12);
                ((RoomSQLiteQuery)object3).bindLong(n13, l10);
                n13 += n15;
            }
            object = ((G_ScriptDao_Impl)object7).__db;
            n13 = 0;
            f10 = 0.0f;
            string2 = null;
            object3 = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object3, false, null);
            n12 = CursorUtil.getColumnIndex((Cursor)object3, (String)object5);
            n11 = -1;
            if (n12 != n11) break block196;
            object3.close();
            return;
        }
        Object object9 = "id";
        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object5);
        Object object10 = "timebase";
        int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object10);
        String string3 = "start_time";
        int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string3);
        String string4 = "end_time";
        int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string4);
        String string5 = "duration";
        int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string5);
        String string6 = "mute";
        int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string6);
        String string7 = "volume";
        int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string7);
        String string8 = "voice_enable";
        int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string8);
        object2 = "rate";
        n15 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object2);
        object4 = "rate_type";
        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object4);
        string2 = "bezier_rate";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string2);
        object7 = "videoPath";
        int n26 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object7);
        object7 = "is_local_source";
        int n27 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object7);
        object7 = "is_reverse";
        int n28 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object7);
        object7 = "reverse_path";
        int n29 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object7);
        object7 = "customer_uuid";
        int n30 = n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object7);
        object7 = "filter_enable";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object7);
        int n31 = n13;
        string2 = "filter_name";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string2);
        int n32 = n14;
        object4 = "filter_local_source";
        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object4);
        int n33 = n15;
        object2 = "filter_strength";
        n15 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object2);
        int n34 = n25;
        string8 = "effect_enable";
        n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string8);
        int n35 = n24;
        string7 = "effect_saturation";
        n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string7);
        int n36 = n23;
        string6 = "effect_contrast";
        n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string6);
        int n37 = n22;
        string5 = "effect_temperature";
        n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string5);
        int n38 = n21;
        string4 = "effect_hue";
        n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string4);
        int n39 = n20;
        string3 = "effect_exposure";
        n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string3);
        int n40 = n19;
        object10 = "effect_vignette";
        n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object10);
        int n41 = n18;
        object5 = "effect_sharpen";
        n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object5);
        int n42 = n11;
        object9 = "rotate_enable";
        int n43 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "rotate_rotate";
        int n44 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "transition_name";
        int n45 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "transition_duration";
        int n46 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "transition_timebase";
        int n47 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "transition_local_source";
        int n48 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "transition_thumb";
        int n49 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_enable";
        int n50 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_start_center";
        int n51 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_start_width";
        int n52 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_start_height";
        int n53 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_end_center";
        int n54 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_end_width";
        int n55 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_end_height";
        int n56 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "roi_duration";
        int n57 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "rotate_frame_center";
        int n58 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "rotate_frame_scale";
        int n59 = n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        object9 = "rotate_frame_rotate";
        try {
            n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        }
        catch (Throwable throwable) {
            object3.close();
            throw throwable;
        }
        while (true) {
            int n60;
            int n61;
            int n62;
            block261: {
                int n63;
                int n64;
                block197: {
                    int n65;
                    int n66;
                    int n67;
                    int n68;
                    int n69;
                    block258: {
                        block198: {
                            block257: {
                                String string9;
                                block256: {
                                    block255: {
                                        block254: {
                                            block253: {
                                                block252: {
                                                    block251: {
                                                        block250: {
                                                            block249: {
                                                                block248: {
                                                                    block247: {
                                                                        block246: {
                                                                            block241: {
                                                                                block245: {
                                                                                    String string10;
                                                                                    block244: {
                                                                                        block243: {
                                                                                            block242: {
                                                                                                block240: {
                                                                                                    block239: {
                                                                                                        block238: {
                                                                                                            block232: {
                                                                                                                Object object11;
                                                                                                                String string11;
                                                                                                                String string12;
                                                                                                                float f14;
                                                                                                                float f15;
                                                                                                                float f16;
                                                                                                                float f17;
                                                                                                                Object object12;
                                                                                                                block237: {
                                                                                                                    block236: {
                                                                                                                        boolean bl2;
                                                                                                                        float f18;
                                                                                                                        block235: {
                                                                                                                            block234: {
                                                                                                                                float f19;
                                                                                                                                block233: {
                                                                                                                                    float f20;
                                                                                                                                    block231: {
                                                                                                                                        block260: {
                                                                                                                                            block230: {
                                                                                                                                                block228: {
                                                                                                                                                    block226: {
                                                                                                                                                        block224: {
                                                                                                                                                            block229: {
                                                                                                                                                                block227: {
                                                                                                                                                                    block225: {
                                                                                                                                                                        block218: {
                                                                                                                                                                            block223: {
                                                                                                                                                                                block222: {
                                                                                                                                                                                    long l12;
                                                                                                                                                                                    long l13;
                                                                                                                                                                                    block221: {
                                                                                                                                                                                        int n70;
                                                                                                                                                                                        block220: {
                                                                                                                                                                                            block219: {
                                                                                                                                                                                                block217: {
                                                                                                                                                                                                    block259: {
                                                                                                                                                                                                        block215: {
                                                                                                                                                                                                            block213: {
                                                                                                                                                                                                                block216: {
                                                                                                                                                                                                                    block214: {
                                                                                                                                                                                                                        block211: {
                                                                                                                                                                                                                            block212: {
                                                                                                                                                                                                                                block210: {
                                                                                                                                                                                                                                    block209: {
                                                                                                                                                                                                                                        block207: {
                                                                                                                                                                                                                                            block208: {
                                                                                                                                                                                                                                                block206: {
                                                                                                                                                                                                                                                    block205: {
                                                                                                                                                                                                                                                        block200: {
                                                                                                                                                                                                                                                            block204: {
                                                                                                                                                                                                                                                                block203: {
                                                                                                                                                                                                                                                                    block202: {
                                                                                                                                                                                                                                                                        block201: {
                                                                                                                                                                                                                                                                            block199: {
                                                                                                                                                                                                                                                                                n69 = object3.moveToNext();
                                                                                                                                                                                                                                                                                if (n69 == 0) break;
                                                                                                                                                                                                                                                                                n69 = object3.isNull(n12);
                                                                                                                                                                                                                                                                                if (n69 != 0) break block197;
                                                                                                                                                                                                                                                                                n64 = n11;
                                                                                                                                                                                                                                                                                n69 = n19;
                                                                                                                                                                                                                                                                                l10 = object3.getLong(n12);
                                                                                                                                                                                                                                                                                object9 = ((LongSparseArray)object6).get(l10);
                                                                                                                                                                                                                                                                                object9 = (ArrayList)object9;
                                                                                                                                                                                                                                                                                if (object9 == null) break block198;
                                                                                                                                                                                                                                                                                n19 = (int)(object3.isNull(n10) ? 1 : 0);
                                                                                                                                                                                                                                                                                if (n19 == 0) break block199;
                                                                                                                                                                                                                                                                                n19 = (int)(object3.isNull(n13) ? 1 : 0);
                                                                                                                                                                                                                                                                                if (n19 == 0) break block199;
                                                                                                                                                                                                                                                                                n19 = (int)(object3.isNull(n14) ? 1 : 0);
                                                                                                                                                                                                                                                                                if (n19 == 0) break block199;
                                                                                                                                                                                                                                                                                n19 = (int)(object3.isNull(n15) ? 1 : 0);
                                                                                                                                                                                                                                                                                if (n19 == 0) break block199;
                                                                                                                                                                                                                                                                                n68 = n10;
                                                                                                                                                                                                                                                                                n67 = n15;
                                                                                                                                                                                                                                                                                n66 = n14;
                                                                                                                                                                                                                                                                                n15 = 0;
                                                                                                                                                                                                                                                                                f12 = 0.0f;
                                                                                                                                                                                                                                                                                object2 = null;
                                                                                                                                                                                                                                                                                break block200;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            n19 = object3.getInt(n10);
                                                                                                                                                                                                                                                                            if (n19 != 0) {
                                                                                                                                                                                                                                                                                n19 = 1;
                                                                                                                                                                                                                                                                                break block201;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            n19 = 0;
                                                                                                                                                                                                                                                                            object10 = null;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        n68 = (int)(object3.isNull(n13) ? 1 : 0);
                                                                                                                                                                                                                                                                        if (n68 == 0) break block202;
                                                                                                                                                                                                                                                                        n70 = 0;
                                                                                                                                                                                                                                                                        object6 = null;
                                                                                                                                                                                                                                                                        break block203;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    String string13 = object3.getString(n13);
                                                                                                                                                                                                                                                                    object6 = string13;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                n68 = object3.getInt(n14);
                                                                                                                                                                                                                                                                if (n68 != 0) {
                                                                                                                                                                                                                                                                    n68 = n10;
                                                                                                                                                                                                                                                                    n66 = n14;
                                                                                                                                                                                                                                                                    n10 = 1;
                                                                                                                                                                                                                                                                    break block204;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                n68 = n10;
                                                                                                                                                                                                                                                                n66 = n14;
                                                                                                                                                                                                                                                                n10 = 0;
                                                                                                                                                                                                                                                                object7 = null;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            f11 = object3.getFloat(n15);
                                                                                                                                                                                                                                                            n67 = n15;
                                                                                                                                                                                                                                                            object2 = new TemplateFilter(n19 != 0, (String)object6, n10 != 0, f11);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        n70 = object3.isNull(n25);
                                                                                                                                                                                                                                                        if (n70 == 0) break block205;
                                                                                                                                                                                                                                                        n70 = (int)(object3.isNull(n24) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n70 == 0) break block205;
                                                                                                                                                                                                                                                        n70 = (int)(object3.isNull(n23) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n70 == 0) break block205;
                                                                                                                                                                                                                                                        n70 = (int)(object3.isNull(n22) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n70 == 0) break block205;
                                                                                                                                                                                                                                                        n70 = (int)(object3.isNull(n21) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n70 == 0) break block205;
                                                                                                                                                                                                                                                        n70 = (int)(object3.isNull(n20) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n70 == 0) break block205;
                                                                                                                                                                                                                                                        n70 = n69;
                                                                                                                                                                                                                                                        n10 = (int)(object3.isNull(n69) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n10 == 0) break block206;
                                                                                                                                                                                                                                                        n10 = (int)(object3.isNull(n18) ? 1 : 0);
                                                                                                                                                                                                                                                        if (n10 == 0) break block206;
                                                                                                                                                                                                                                                        n14 = n43;
                                                                                                                                                                                                                                                        n10 = 0;
                                                                                                                                                                                                                                                        object7 = null;
                                                                                                                                                                                                                                                        break block207;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    n70 = n69;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                n10 = object3.getInt(n25);
                                                                                                                                                                                                                                                if (n10 != 0) {
                                                                                                                                                                                                                                                    n62 = 1;
                                                                                                                                                                                                                                                    break block208;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                n62 = 0;
                                                                                                                                                                                                                                                object12 = null;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            f20 = object3.getFloat(n24);
                                                                                                                                                                                                                                            f19 = object3.getFloat(n23);
                                                                                                                                                                                                                                            f17 = object3.getFloat(n22);
                                                                                                                                                                                                                                            f16 = object3.getFloat(n21);
                                                                                                                                                                                                                                            f18 = object3.getFloat(n20);
                                                                                                                                                                                                                                            f15 = object3.getFloat(n70);
                                                                                                                                                                                                                                            f14 = object3.getFloat(n18);
                                                                                                                                                                                                                                            object7 = new TemplateEffect(n62 != 0, f20, f19, f17, f16, f18, f15, f14);
                                                                                                                                                                                                                                            n14 = n43;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        n19 = object3.isNull(n14);
                                                                                                                                                                                                                                        if (n19 == 0) break block209;
                                                                                                                                                                                                                                        n19 = n44;
                                                                                                                                                                                                                                        n43 = (int)(object3.isNull(n44) ? 1 : 0);
                                                                                                                                                                                                                                        if (n43 == 0) break block210;
                                                                                                                                                                                                                                        n69 = n70;
                                                                                                                                                                                                                                        n43 = n18;
                                                                                                                                                                                                                                        n44 = n14;
                                                                                                                                                                                                                                        n70 = n45;
                                                                                                                                                                                                                                        n14 = 0;
                                                                                                                                                                                                                                        f11 = 0.0f;
                                                                                                                                                                                                                                        object4 = null;
                                                                                                                                                                                                                                        break block211;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    n19 = n44;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                n43 = object3.getInt(n14);
                                                                                                                                                                                                                                n69 = n70;
                                                                                                                                                                                                                                if (n43 != 0) {
                                                                                                                                                                                                                                    n43 = n18;
                                                                                                                                                                                                                                    n70 = 1;
                                                                                                                                                                                                                                    break block212;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                n43 = n18;
                                                                                                                                                                                                                                n70 = 0;
                                                                                                                                                                                                                                object6 = null;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            n18 = object3.getInt(n19);
                                                                                                                                                                                                                            n44 = n14;
                                                                                                                                                                                                                            object4 = new TemplateRotate(n70 != 0, n18);
                                                                                                                                                                                                                            n70 = n45;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        n18 = (int)(object3.isNull(n70) ? 1 : 0);
                                                                                                                                                                                                                        if (n18 == 0) break block213;
                                                                                                                                                                                                                        n18 = n46;
                                                                                                                                                                                                                        n45 = (int)(object3.isNull(n46) ? 1 : 0);
                                                                                                                                                                                                                        if (n45 == 0) break block214;
                                                                                                                                                                                                                        n45 = n12;
                                                                                                                                                                                                                        n12 = n47;
                                                                                                                                                                                                                        n46 = (int)(object3.isNull(n47) ? 1 : 0);
                                                                                                                                                                                                                        if (n46 == 0) break block215;
                                                                                                                                                                                                                        n46 = n13;
                                                                                                                                                                                                                        n13 = n48;
                                                                                                                                                                                                                        n47 = (int)(object3.isNull(n48) ? 1 : 0);
                                                                                                                                                                                                                        if (n47 == 0) break block216;
                                                                                                                                                                                                                        n47 = n19;
                                                                                                                                                                                                                        n19 = n49;
                                                                                                                                                                                                                        n48 = (int)(object3.isNull(n49) ? 1 : 0);
                                                                                                                                                                                                                        if (n48 == 0) break block217;
                                                                                                                                                                                                                        n48 = n70;
                                                                                                                                                                                                                        n63 = n18;
                                                                                                                                                                                                                        n18 = n50;
                                                                                                                                                                                                                        n70 = 0;
                                                                                                                                                                                                                        object6 = null;
                                                                                                                                                                                                                        break block218;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    n45 = n12;
                                                                                                                                                                                                                    n46 = n13;
                                                                                                                                                                                                                    n12 = n47;
                                                                                                                                                                                                                    n13 = n48;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                n47 = n19;
                                                                                                                                                                                                                break block259;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            n45 = n12;
                                                                                                                                                                                                            n18 = n46;
                                                                                                                                                                                                            n12 = n47;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        n46 = n13;
                                                                                                                                                                                                        n47 = n19;
                                                                                                                                                                                                        n13 = n48;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    n19 = n49;
                                                                                                                                                                                                }
                                                                                                                                                                                                n48 = (int)(object3.isNull(n70) ? 1 : 0);
                                                                                                                                                                                                if (n48 == 0) break block219;
                                                                                                                                                                                                n62 = 0;
                                                                                                                                                                                                object12 = null;
                                                                                                                                                                                                break block220;
                                                                                                                                                                                            }
                                                                                                                                                                                            String string14 = object3.getString(n70);
                                                                                                                                                                                            object12 = string14;
                                                                                                                                                                                        }
                                                                                                                                                                                        l13 = object3.getLong(n18);
                                                                                                                                                                                        l12 = object3.getLong(n12);
                                                                                                                                                                                        n48 = object3.getInt(n13);
                                                                                                                                                                                        if (n48 != 0) {
                                                                                                                                                                                            n48 = n70;
                                                                                                                                                                                            bl2 = true;
                                                                                                                                                                                            f18 = Float.MIN_VALUE;
                                                                                                                                                                                            break block221;
                                                                                                                                                                                        }
                                                                                                                                                                                        n48 = n70;
                                                                                                                                                                                        bl2 = false;
                                                                                                                                                                                        f18 = 0.0f;
                                                                                                                                                                                        string12 = null;
                                                                                                                                                                                    }
                                                                                                                                                                                    object6 = new TemplateTransition((String)object12, l13, l12, bl2);
                                                                                                                                                                                    n49 = (int)(object3.isNull(n19) ? 1 : 0);
                                                                                                                                                                                    if (n49 == 0) break block222;
                                                                                                                                                                                    n63 = n18;
                                                                                                                                                                                    n18 = 0;
                                                                                                                                                                                    object5 = null;
                                                                                                                                                                                    break block223;
                                                                                                                                                                                }
                                                                                                                                                                                String string15 = object3.getString(n19);
                                                                                                                                                                                n63 = n18;
                                                                                                                                                                                object5 = string15;
                                                                                                                                                                            }
                                                                                                                                                                            ((TemplateTransition)object6).setThumb((String)object5);
                                                                                                                                                                            n18 = n50;
                                                                                                                                                                        }
                                                                                                                                                                        n49 = (int)(object3.isNull(n18) ? 1 : 0);
                                                                                                                                                                        if (n49 == 0) break block224;
                                                                                                                                                                        n49 = n12;
                                                                                                                                                                        n12 = n51;
                                                                                                                                                                        n50 = (int)(object3.isNull(n51) ? 1 : 0);
                                                                                                                                                                        if (n50 == 0) break block225;
                                                                                                                                                                        n50 = n13;
                                                                                                                                                                        n13 = n52;
                                                                                                                                                                        n51 = (int)(object3.isNull(n52) ? 1 : 0);
                                                                                                                                                                        if (n51 == 0) break block226;
                                                                                                                                                                        n51 = n19;
                                                                                                                                                                        n19 = n53;
                                                                                                                                                                        n52 = (int)(object3.isNull(n53) ? 1 : 0);
                                                                                                                                                                        if (n52 == 0) break block227;
                                                                                                                                                                        n52 = n20;
                                                                                                                                                                        n20 = n54;
                                                                                                                                                                        n53 = (int)(object3.isNull(n54) ? 1 : 0);
                                                                                                                                                                        if (n53 == 0) break block228;
                                                                                                                                                                        n53 = n21;
                                                                                                                                                                        n21 = n55;
                                                                                                                                                                        n54 = (int)(object3.isNull(n55) ? 1 : 0);
                                                                                                                                                                        if (n54 == 0) break block229;
                                                                                                                                                                        n54 = n22;
                                                                                                                                                                        n22 = n56;
                                                                                                                                                                        n55 = (int)(object3.isNull(n56) ? 1 : 0);
                                                                                                                                                                        if (n55 == 0) break block230;
                                                                                                                                                                        n55 = n23;
                                                                                                                                                                        n23 = n57;
                                                                                                                                                                        n56 = (int)(object3.isNull(n57) ? 1 : 0);
                                                                                                                                                                        if (n56 == 0) break block231;
                                                                                                                                                                        n57 = n18;
                                                                                                                                                                        n56 = n12;
                                                                                                                                                                        n12 = n58;
                                                                                                                                                                        n18 = 0;
                                                                                                                                                                        object5 = null;
                                                                                                                                                                        break block232;
                                                                                                                                                                    }
                                                                                                                                                                    n50 = n13;
                                                                                                                                                                    n51 = n19;
                                                                                                                                                                    n13 = n52;
                                                                                                                                                                    n19 = n53;
                                                                                                                                                                }
                                                                                                                                                                n52 = n20;
                                                                                                                                                                n53 = n21;
                                                                                                                                                                n20 = n54;
                                                                                                                                                                n21 = n55;
                                                                                                                                                            }
                                                                                                                                                            n54 = n22;
                                                                                                                                                            n55 = n23;
                                                                                                                                                            n22 = n56;
                                                                                                                                                            break block260;
                                                                                                                                                        }
                                                                                                                                                        n49 = n12;
                                                                                                                                                        n50 = n13;
                                                                                                                                                        n12 = n51;
                                                                                                                                                        n13 = n52;
                                                                                                                                                    }
                                                                                                                                                    n51 = n19;
                                                                                                                                                    n52 = n20;
                                                                                                                                                    n19 = n53;
                                                                                                                                                    n20 = n54;
                                                                                                                                                }
                                                                                                                                                n53 = n21;
                                                                                                                                                n54 = n22;
                                                                                                                                                n21 = n55;
                                                                                                                                                n22 = n56;
                                                                                                                                            }
                                                                                                                                            n55 = n23;
                                                                                                                                        }
                                                                                                                                        n23 = n57;
                                                                                                                                    }
                                                                                                                                    n56 = object3.getInt(n18);
                                                                                                                                    if (n56 != 0) {
                                                                                                                                        n61 = 1;
                                                                                                                                        f20 = Float.MIN_VALUE;
                                                                                                                                        break block233;
                                                                                                                                    }
                                                                                                                                    n61 = 0;
                                                                                                                                    f20 = 0.0f;
                                                                                                                                }
                                                                                                                                n56 = (int)(object3.isNull(n12) ? 1 : 0);
                                                                                                                                if (n56 == 0) break block234;
                                                                                                                                n65 = 0;
                                                                                                                                f19 = 0.0f;
                                                                                                                                string11 = null;
                                                                                                                                break block235;
                                                                                                                            }
                                                                                                                            object11 = object3.getString(n12);
                                                                                                                            string11 = object11;
                                                                                                                        }
                                                                                                                        f17 = object3.getFloat(n13);
                                                                                                                        f16 = object3.getFloat(n19);
                                                                                                                        n56 = (int)(object3.isNull(n20) ? 1 : 0);
                                                                                                                        if (n56 == 0) break block236;
                                                                                                                        bl2 = false;
                                                                                                                        f18 = 0.0f;
                                                                                                                        string12 = null;
                                                                                                                        break block237;
                                                                                                                    }
                                                                                                                    object11 = object3.getString(n20);
                                                                                                                    string12 = object11;
                                                                                                                }
                                                                                                                f15 = object3.getFloat(n21);
                                                                                                                f14 = object3.getFloat(n22);
                                                                                                                long l14 = object3.getLong(n23);
                                                                                                                object12 = object11;
                                                                                                                object11 = new TemplateRoi(n61 != 0, string11, f17, f16, string12, f15, f14, l14);
                                                                                                                n57 = n18;
                                                                                                                object5 = object11;
                                                                                                                n56 = n12;
                                                                                                                n12 = n58;
                                                                                                            }
                                                                                                            n58 = (int)(object3.isNull(n12) ? 1 : 0);
                                                                                                            if (n58 == 0) break block238;
                                                                                                            n58 = n13;
                                                                                                            n13 = n59;
                                                                                                            n59 = (int)(object3.isNull(n59) ? 1 : 0);
                                                                                                            if (n59 == 0) break block239;
                                                                                                            n59 = n19;
                                                                                                            n19 = n64;
                                                                                                            n64 = (int)(object3.isNull(n64) ? 1 : 0);
                                                                                                            if (n64 == 0) break block240;
                                                                                                            n62 = n12;
                                                                                                            n61 = n13;
                                                                                                            n65 = n19;
                                                                                                            n64 = n20;
                                                                                                            n19 = 0;
                                                                                                            object10 = null;
                                                                                                            break block241;
                                                                                                        }
                                                                                                        n58 = n13;
                                                                                                        n13 = n59;
                                                                                                    }
                                                                                                    n59 = n19;
                                                                                                    n19 = n64;
                                                                                                }
                                                                                                n64 = (int)(object3.isNull(n12) ? 1 : 0);
                                                                                                if (n64 == 0) break block242;
                                                                                                n62 = n12;
                                                                                                n12 = 0;
                                                                                                object = null;
                                                                                                break block243;
                                                                                            }
                                                                                            string10 = object3.getString(n12);
                                                                                            n62 = n12;
                                                                                            object = string10;
                                                                                        }
                                                                                        n64 = (int)(object3.isNull(n13) ? 1 : 0);
                                                                                        if (n64 == 0) break block244;
                                                                                        n61 = n13;
                                                                                        n64 = n20;
                                                                                        n13 = 0;
                                                                                        f10 = 0.0f;
                                                                                        string2 = null;
                                                                                        break block245;
                                                                                    }
                                                                                    string10 = object3.getString(n13);
                                                                                    n61 = n13;
                                                                                    string2 = string10;
                                                                                    n64 = n20;
                                                                                }
                                                                                n20 = object3.getInt(n19);
                                                                                n65 = n19;
                                                                                object10 = new TemplateRotateFrame((String)object, string2, n20);
                                                                            }
                                                                            object = new TemplateVideo();
                                                                            n13 = n42;
                                                                            n42 = n21;
                                                                            long l15 = object3.getLong(n13);
                                                                            ((TemplateVideo)object).setId(l15);
                                                                            n20 = n41;
                                                                            n41 = n22;
                                                                            long l16 = object3.getLong(n20);
                                                                            ((TemplateVideo)object).setTempId(l16);
                                                                            n21 = n40;
                                                                            n40 = n23;
                                                                            long l17 = object3.getLong(n21);
                                                                            ((TemplateVideo)object).setTimebase(l17);
                                                                            n23 = n20;
                                                                            n22 = n39;
                                                                            n39 = n21;
                                                                            l15 = object3.getLong(n22);
                                                                            ((TemplateVideo)object).setStartTime(l15);
                                                                            n20 = n38;
                                                                            n38 = n22;
                                                                            l16 = object3.getLong(n20);
                                                                            ((TemplateVideo)object).setEndTime(l16);
                                                                            n21 = n37;
                                                                            n37 = n23;
                                                                            l17 = object3.getLong(n21);
                                                                            ((TemplateVideo)object).setDuration(l17);
                                                                            n22 = n36;
                                                                            n23 = object3.getInt(n36);
                                                                            if (n23 != 0) {
                                                                                n23 = 1;
                                                                                break block246;
                                                                            }
                                                                            n23 = 0;
                                                                            string6 = null;
                                                                        }
                                                                        ((TemplateVideo)object).setMute(n23 != 0);
                                                                        n23 = n35;
                                                                        n35 = n13;
                                                                        f10 = object3.getFloat(n23);
                                                                        ((TemplateVideo)object).setVolume(f10);
                                                                        n13 = n34;
                                                                        n34 = object3.getInt(n34);
                                                                        if (n34 != 0) {
                                                                            n34 = n13;
                                                                            n13 = 1;
                                                                            f10 = Float.MIN_VALUE;
                                                                            break block247;
                                                                        }
                                                                        n34 = n13;
                                                                        n13 = 0;
                                                                        f10 = 0.0f;
                                                                        string2 = null;
                                                                    }
                                                                    ((TemplateVideo)object).setVoiceEnable(n13 != 0);
                                                                    n13 = n33;
                                                                    n33 = n20;
                                                                    float f21 = object3.getFloat(n13);
                                                                    ((TemplateVideo)object).setRate(f21);
                                                                    n20 = n32;
                                                                    n32 = n13;
                                                                    n13 = object3.getInt(n20);
                                                                    ((TemplateVideo)object).setRateType(n13);
                                                                    n13 = n31;
                                                                    n31 = (int)(object3.isNull(n31) ? 1 : 0);
                                                                    if (n31 == 0) break block248;
                                                                    n36 = n13;
                                                                    n13 = 0;
                                                                    f10 = 0.0f;
                                                                    string2 = null;
                                                                    break block249;
                                                                }
                                                                String string16 = object3.getString(n13);
                                                                n36 = n13;
                                                                string2 = string16;
                                                            }
                                                            ((TemplateVideo)object).setBezierRate(string2);
                                                            n13 = n26;
                                                            n26 = (int)(object3.isNull(n26) ? 1 : 0);
                                                            if (n26 == 0) break block250;
                                                            n31 = n13;
                                                            n13 = 0;
                                                            f10 = 0.0f;
                                                            string2 = null;
                                                            break block251;
                                                        }
                                                        string9 = object3.getString(n13);
                                                        n31 = n13;
                                                        string2 = string9;
                                                    }
                                                    ((TemplateVideo)object).setVideoPath(string2);
                                                    n13 = n27;
                                                    n26 = object3.getInt(n27);
                                                    if (n26 != 0) {
                                                        n13 = 1;
                                                        f10 = Float.MIN_VALUE;
                                                        break block252;
                                                    }
                                                    n13 = 0;
                                                    f10 = 0.0f;
                                                    string2 = null;
                                                }
                                                ((TemplateVideo)object).setLocalSource(n13 != 0);
                                                n13 = n28;
                                                n26 = object3.getInt(n28);
                                                if (n26 != 0) {
                                                    n13 = 1;
                                                    f10 = Float.MIN_VALUE;
                                                    break block253;
                                                }
                                                n13 = 0;
                                                f10 = 0.0f;
                                                string2 = null;
                                            }
                                            ((TemplateVideo)object).setReverse(n13 != 0);
                                            n13 = n29;
                                            n26 = (int)(object3.isNull(n29) ? 1 : 0);
                                            if (n26 == 0) break block254;
                                            n13 = 0;
                                            f10 = 0.0f;
                                            string2 = null;
                                            break block255;
                                        }
                                        string2 = string9 = object3.getString(n29);
                                    }
                                    ((TemplateVideo)object).setReversePath(string2);
                                    n13 = n30;
                                    n26 = (int)(object3.isNull(n30) ? 1 : 0);
                                    if (n26 == 0) break block256;
                                    n13 = 0;
                                    f10 = 0.0f;
                                    string2 = null;
                                    break block257;
                                }
                                string2 = string9 = object3.getString(n30);
                            }
                            ((TemplateBaseData)object).setCustomerUUID(string2);
                            ((TemplateVideo)object).setFilter((TemplateFilter)object2);
                            ((TemplateVideo)object).setEffect((TemplateEffect)object7);
                            ((TemplateVideo)object).setRotate((TemplateRotate)object4);
                            ((TemplateVideo)object).setTransition((TemplateTransition)object6);
                            ((TemplateVideo)object).setRoi((TemplateRoi)object5);
                            ((TemplateVideo)object).setRotateFrame((TemplateRotateFrame)object10);
                            ((ArrayList)object9).add(object);
                            break block258;
                        }
                        n68 = n10;
                        n67 = n15;
                        n66 = n14;
                        n63 = n46;
                        n62 = n58;
                        n61 = n59;
                        n65 = n11;
                        n46 = n13;
                        n58 = n52;
                        n59 = n53;
                        n64 = n54;
                        n52 = n20;
                        n53 = n21;
                        n54 = n22;
                        n20 = n32;
                        n32 = n33;
                        n22 = n36;
                        n21 = n37;
                        n33 = n38;
                        n38 = n39;
                        n39 = n40;
                        n37 = n41;
                        n41 = n56;
                        n40 = n57;
                        n36 = n31;
                        n57 = n50;
                        n56 = n51;
                        n31 = n26;
                        n50 = n48;
                        n51 = n49;
                        n48 = n45;
                        n49 = n47;
                        n45 = n12;
                        n47 = n44;
                        n44 = n43;
                        n43 = n18;
                        n60 = n55;
                        n55 = n23;
                        n23 = n35;
                        n35 = n42;
                        n42 = n60;
                    }
                    object6 = longSparseArray;
                    n26 = n31;
                    n31 = n36;
                    n18 = n43;
                    n43 = n44;
                    n12 = n45;
                    n13 = n46;
                    n44 = n47;
                    n45 = n48;
                    n47 = n49;
                    n48 = n50;
                    n49 = n51;
                    n51 = n56;
                    n50 = n57;
                    n19 = n69;
                    n10 = n68;
                    n14 = n66;
                    n15 = n67;
                    n46 = n63;
                    n11 = n65;
                    n36 = n22;
                    n57 = n40;
                    n56 = n41;
                    n22 = n54;
                    n54 = n64;
                    break block261;
                }
                n63 = n46;
                n64 = n54;
                n62 = n58;
                n61 = n59;
                n58 = n52;
                n59 = n53;
                n52 = n20;
                n53 = n21;
                n20 = n32;
                n32 = n33;
                n21 = n37;
                n33 = n38;
                n38 = n39;
                n39 = n40;
                n37 = n41;
                n41 = n56;
                n40 = n57;
                n57 = n50;
                n56 = n51;
                n50 = n48;
                n51 = n49;
                n48 = n45;
                n49 = n47;
                n47 = n44;
                n44 = n43;
                n60 = n55;
                n55 = n23;
                n23 = n35;
                n35 = n42;
                n42 = n60;
                object6 = longSparseArray;
                n44 = n47;
                n47 = n49;
                n48 = n50;
                n49 = n51;
                n51 = n56;
                n50 = n57;
                n57 = n40;
                n56 = n41;
            }
            n41 = n37;
            n40 = n39;
            n37 = n21;
            n39 = n38;
            n21 = n53;
            n53 = n59;
            n59 = n61;
            n38 = n33;
            n33 = n32;
            n32 = n20;
            n20 = n52;
            n52 = n58;
            n58 = n62;
            n60 = n35;
            n35 = n23;
            n23 = n55;
            n55 = n42;
            n42 = n60;
        }
        object3.close();
        return;
    }

    private void __fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft(LongSparseArray longSparseArray) {
        long l10;
        int n10;
        int n11;
        String string2;
        int n12;
        Object object;
        String string3;
        int n13;
        int n14;
        Object object2;
        block28: {
            object2 = "draft_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 999;
            n13 = 0;
            string3 = null;
            if (n15 > n14) {
                object2 = new LongSparseArray(n14);
                n15 = longSparseArray.size();
                Object var8_10 = null;
                int n16 = 0;
                Object var10_14 = null;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l11 = longSparseArray.keyAt(i10);
                    ((LongSparseArray)object2).put(l11, null);
                    if (++n16 != n14) continue;
                    this.__fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft((LongSparseArray)object2);
                    longSparseArray.putAll((LongSparseArray)object2);
                    object2 = new LongSparseArray(n14);
                    n16 = 0;
                    var10_14 = null;
                }
                if (n16 > 0) {
                    this.__fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft((LongSparseArray)object2);
                    longSparseArray.putAll((LongSparseArray)object2);
                }
                return;
            }
            object = StringUtil.newStringBuilder();
            Object object3 = "SELECT `id`,`draft_id`,`create_time`,`content_desc` FROM `draft` WHERE `draft_id` IN (";
            ((StringBuilder)object).append((String)object3);
            n14 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object, n14);
            ((StringBuilder)object).append(")");
            object = ((StringBuilder)object).toString();
            object = RoomSQLiteQuery.acquire((String)object, n14 += 0);
            n12 = n14 = 1;
            string2 = null;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                l10 = longSparseArray.keyAt(n11);
                ((RoomSQLiteQuery)object).bindLong(n12, l10);
                n12 += n14;
            }
            object3 = this.__db;
            object = DBUtil.query((RoomDatabase)object3, (SupportSQLiteQuery)object, false, null);
            n14 = CursorUtil.getColumnIndex((Cursor)object, (String)object2);
            n13 = -1;
            if (n14 != n13) break block28;
            object.close();
            return;
        }
        string3 = "id";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
        int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
        string2 = "create_time";
        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
        String string4 = "content_desc";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
        }
        catch (Throwable throwable) {
            object.close();
            throw throwable;
        }
        while (true) {
            String string5;
            Draft draft;
            block30: {
                block29: {
                    n10 = (int)(object.moveToNext() ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = (int)(object.isNull(n14) ? 1 : 0);
                    if (n10 != 0) continue;
                    l10 = object.getLong(n14);
                    boolean bl2 = longSparseArray.containsKey(l10);
                    if (!bl2) continue;
                    draft = new Draft();
                    long l12 = object.getLong(n13);
                    draft.setId(l12);
                    l12 = object.getLong(n17);
                    draft.setDraftId(l12);
                    l12 = object.getLong(n11);
                    draft.setCreateTime(l12);
                    boolean bl3 = object.isNull(n12);
                    if (!bl3) break block29;
                    bl3 = false;
                    string5 = null;
                    break block30;
                }
                string5 = object.getString(n12);
            }
            draft.setContentDesc(string5);
            longSparseArray.put(l10, draft);
            continue;
            break;
        }
        object.close();
        return;
    }

    private void __fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript(LongSparseArray longSparseArray) {
        int n10;
        int n11;
        Object object;
        Object object2;
        String string2;
        int n12;
        int n13;
        int n14;
        Object object3;
        block24: {
            object3 = "script_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 0;
            n13 = 999;
            n12 = 0;
            string2 = null;
            if (n15 > n13) {
                object3 = new LongSparseArray(n13);
                n15 = longSparseArray.size();
                int n16 = 0;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l10 = longSparseArray.keyAt(i10);
                    ((LongSparseArray)object3).put(l10, null);
                    if (++n16 != n13) continue;
                    this.__fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript((LongSparseArray)object3);
                    longSparseArray.putAll((LongSparseArray)object3);
                    object3 = new LongSparseArray(n13);
                    n16 = 0;
                }
                if (n16 > 0) {
                    this.__fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript((LongSparseArray)object3);
                    longSparseArray.putAll((LongSparseArray)object3);
                }
                return;
            }
            object2 = StringUtil.newStringBuilder();
            object = "SELECT `id`,`script_id`,`reference_id` FROM `script` WHERE `script_id` IN (";
            ((StringBuilder)object2).append((String)object);
            n13 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object2, n13);
            ((StringBuilder)object2).append(")");
            object2 = ((StringBuilder)object2).toString();
            object2 = RoomSQLiteQuery.acquire((String)object2, n13 += 0);
            int n17 = n13 = 1;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                long l11 = longSparseArray.keyAt(n11);
                ((RoomSQLiteQuery)object2).bindLong(n17, l11);
                n17 += n13;
            }
            object = this.__db;
            object2 = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object2, false, null);
            n14 = CursorUtil.getColumnIndex((Cursor)object2, (String)object3);
            n13 = -1;
            if (n14 != n13) break block24;
            object2.close();
            return;
        }
        object = "id";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object);
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object3);
        string2 = "reference_id";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        }
        catch (Throwable throwable) {
            object2.close();
            throw throwable;
        }
        while (true) {
            n11 = (int)(object2.moveToNext() ? 1 : 0);
            if (n11 == 0) break;
            n11 = (int)(object2.isNull(n14) ? 1 : 0);
            if (n11 != 0) continue;
            long l12 = object2.getLong(n14);
            n10 = (int)(longSparseArray.containsKey(l12) ? 1 : 0);
            if (n10 == 0) continue;
            Script script = new Script();
            long l13 = object2.getLong(n13);
            script.setId(l13);
            l13 = object2.getLong(n18);
            script.setScriptId(l13);
            l13 = object2.getLong(n12);
            script.setReferenceId(l13);
            longSparseArray.put(l12, script);
            continue;
            break;
        }
        object2.close();
        return;
    }

    private void __fetchRelationshipscriptMetadataAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackMetaData(LongSparseArray longSparseArray) {
        int n10;
        int n11;
        int n12;
        Object object;
        String string2;
        int n13;
        int n14;
        Object object2;
        block33: {
            int n15;
            object2 = "track_metadata_id";
            int n16 = longSparseArray.isEmpty();
            if (n16 != 0) {
                return;
            }
            n16 = longSparseArray.size();
            n14 = 999;
            n13 = 0;
            string2 = null;
            if (n16 > n14) {
                object2 = new LongSparseArray(n14);
                n16 = longSparseArray.size();
                int n17 = 0;
                Object var9_12 = null;
                for (int i10 = 0; i10 < n16; ++i10) {
                    long l10 = longSparseArray.keyAt(i10);
                    Object object3 = longSparseArray.valueAt(i10);
                    ((LongSparseArray)object2).put(l10, object3);
                    if (++n17 != n14) continue;
                    this.__fetchRelationshipscriptMetadataAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackMetaData((LongSparseArray)object2);
                    object2 = new LongSparseArray(n14);
                    n17 = 0;
                    var9_12 = null;
                }
                if (n17 > 0) {
                    this.__fetchRelationshipscriptMetadataAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackMetaData((LongSparseArray)object2);
                }
                return;
            }
            object = StringUtil.newStringBuilder();
            Object object4 = "SELECT `id`,`track_metadata_id`,`product`,`name`,`version` FROM `script_metadata` WHERE `track_metadata_id` IN (";
            ((StringBuilder)object).append((String)object4);
            n14 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object, n14);
            ((StringBuilder)object).append(")");
            object = ((StringBuilder)object).toString();
            object = RoomSQLiteQuery.acquire((String)object, n14 += 0);
            n12 = n14 = 1;
            for (n15 = 0; n15 < (n11 = longSparseArray.size()); ++n15) {
                long l11 = longSparseArray.keyAt(n15);
                ((RoomSQLiteQuery)object).bindLong(n12, l11);
                n12 += n14;
            }
            object4 = this.__db;
            n15 = 0;
            object = DBUtil.query((RoomDatabase)object4, (SupportSQLiteQuery)object, false, null);
            n14 = CursorUtil.getColumnIndex((Cursor)object, (String)object2);
            n13 = -1;
            if (n14 != n13) break block33;
            object.close();
            return;
        }
        string2 = "id";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string2);
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object2);
        String string3 = "product";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string3);
        String string4 = "name";
        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
        String string5 = "version";
        try {
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
        }
        catch (Throwable throwable) {
            object.close();
            throw throwable;
        }
        while (true) {
            String string6;
            int n19;
            ScriptTrackMetaData scriptTrackMetaData;
            Object object5;
            block37: {
                block36: {
                    block35: {
                        block34: {
                            boolean bl2 = object.moveToNext();
                            if (!bl2) break;
                            bl2 = object.isNull(n14);
                            if (bl2) continue;
                            long l12 = object.getLong(n14);
                            object5 = longSparseArray.get(l12);
                            if ((object5 = (ArrayList)object5) == null) continue;
                            scriptTrackMetaData = new ScriptTrackMetaData();
                            long l13 = object.getLong(n13);
                            scriptTrackMetaData.setId(l13);
                            l13 = object.getLong(n18);
                            scriptTrackMetaData.setTrackMetadataId(l13);
                            n19 = object.isNull(n12);
                            if (n19 == 0) break block34;
                            n19 = 0;
                            string6 = null;
                            break block35;
                        }
                        string6 = object.getString(n12);
                    }
                    scriptTrackMetaData.setProduct(string6);
                    n19 = object.isNull(n11);
                    if (n19 == 0) break block36;
                    n19 = 0;
                    string6 = null;
                    break block37;
                }
                string6 = object.getString(n11);
            }
            scriptTrackMetaData.setName(string6);
            n19 = object.getInt(n10);
            scriptTrackMetaData.setVersion(n19);
            ((ArrayList)object5).add(scriptTrackMetaData);
            continue;
            break;
        }
        object.close();
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void __fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO(LongSparseArray longSparseArray) {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12;
        Object object3;
        block23: {
            object3 = "script_track_id";
            int n13 = longSparseArray.isEmpty();
            if (n13 != 0) {
                return;
            }
            n13 = longSparseArray.size();
            n12 = 999;
            object2 = null;
            if (n13 > n12) {
                object3 = new LongSparseArray(n12);
                n13 = longSparseArray.size();
                int n14 = 0;
                Object var8_10 = null;
                int n15 = 0;
                Object var10_14 = null;
                while (true) {
                    if (n14 >= n13) {
                        if (n15 <= 0) return;
                        this.__fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO((LongSparseArray)object3);
                        return;
                    }
                    long l10 = longSparseArray.keyAt(n14);
                    Object object4 = longSparseArray.valueAt(n14);
                    ((LongSparseArray)object3).put(l10, object4);
                    ++n14;
                    if (++n15 != n12) continue;
                    this.__fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO((LongSparseArray)object3);
                    object3 = new LongSparseArray(n12);
                    n15 = 0;
                    var10_14 = null;
                }
            }
            object = StringUtil.newStringBuilder();
            String string2 = "SELECT `id`,`script_track_id`,`track_id`,`duration_type` FROM `script_track` WHERE `script_track_id` IN (";
            ((StringBuilder)object).append(string2);
            n12 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object, n12);
            String string3 = ")";
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            object = RoomSQLiteQuery.acquire((String)object, n12 += 0);
            int n16 = n12 = 1;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); n16 += n12, ++n11) {
                long l11 = longSparseArray.keyAt(n11);
                ((RoomSQLiteQuery)object).bindLong(n16, l11);
            }
            object2 = this.__db;
            n16 = 0;
            string3 = null;
            object = DBUtil.query((RoomDatabase)object2, (SupportSQLiteQuery)object, n12 != 0, null);
            n12 = CursorUtil.getColumnIndex((Cursor)object, (String)object3);
            n11 = -1;
            if (n12 != n11) break block23;
            object.close();
            return;
        }
        String string4 = "id";
        try {
            ArrayList arrayList;
            long l12;
            boolean bl2;
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string4);
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object, (String)object3);
            String string5 = "track_id";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string5);
            String string6 = "duration_type";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object, string6);
            LongSparseArray longSparseArray2 = new LongSparseArray();
            LongSparseArray longSparseArray3 = new LongSparseArray();
            while (bl2 = object.moveToNext()) {
                bl2 = object.isNull(n10);
                if (!bl2) {
                    l12 = object.getLong(n10);
                    arrayList = longSparseArray2.get(l12);
                    if ((arrayList = (ArrayList)arrayList) == null) {
                        arrayList = new ArrayList();
                        longSparseArray2.put(l12, arrayList);
                    }
                }
                if (bl2 = object.isNull(n10)) continue;
                l12 = object.getLong(n10);
                arrayList = longSparseArray3.get(l12);
                if ((arrayList = (ArrayList)arrayList) != null) continue;
                arrayList = new ArrayList();
                longSparseArray3.put(l12, arrayList);
            }
            object.moveToPosition(n11);
            this.__fetchRelationshipscriptTrackPointAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPoint(longSparseArray2);
            this.__fetchRelationshipscriptMetadataAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackMetaData(longSparseArray3);
            while ((n11 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                boolean bl3;
                ArrayList arrayList2;
                boolean bl4;
                long l13;
                ScriptTrack scriptTrack;
                n11 = (int)(object.isNull(n12) ? 1 : 0);
                if (n11 != 0) continue;
                l12 = object.getLong(n12);
                object2 = longSparseArray.get(l12);
                if ((object2 = (ArrayList)object2) == null) continue;
                bl2 = object.isNull(n10);
                if (bl2 && (bl2 = object.isNull(n17)) && (bl2 = object.isNull(n18)) && (bl2 = object.isNull(n19))) {
                    bl2 = false;
                    scriptTrack = null;
                } else {
                    scriptTrack = new ScriptTrack();
                    l13 = object.getLong(n10);
                    scriptTrack.setId(l13);
                    l13 = object.getLong(n17);
                    scriptTrack.setScriptTrackId(l13);
                    l13 = object.getLong(n18);
                    scriptTrack.setTrackId(l13);
                    bl4 = object.isNull(n19);
                    if (bl4) {
                        bl4 = false;
                        arrayList2 = null;
                    } else {
                        arrayList2 = object.getString(n19);
                    }
                    scriptTrack.setDurationType((String)((Object)arrayList2));
                }
                bl4 = object.isNull(n10);
                if (!bl4) {
                    l13 = object.getLong(n10);
                    arrayList2 = longSparseArray2.get(l13);
                    arrayList2 = arrayList2;
                } else {
                    bl4 = false;
                    arrayList2 = null;
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                if (!(bl3 = object.isNull(n10))) {
                    long l14 = object.getLong(n10);
                    arrayList = longSparseArray3.get(l14);
                    arrayList = arrayList;
                } else {
                    bl3 = false;
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                ScriptTrackPOJO scriptTrackPOJO = new ScriptTrackPOJO();
                scriptTrackPOJO.setScriptTrack(scriptTrack);
                scriptTrackPOJO.setScriptTrackPointList(arrayList2);
                scriptTrackPOJO.setScriptTrackMetaDataList(arrayList);
                ((ArrayList)object2).add(scriptTrackPOJO);
            }
            return;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            object.close();
        }
    }

    private void __fetchRelationshipscriptTrackPointAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPoint(LongSparseArray longSparseArray) {
        int n10;
        int n11;
        Object object;
        int n12;
        Object object2;
        Object object3;
        String string2;
        int n13;
        float f10;
        int n14;
        Object object4;
        Object object5;
        Object object6;
        block81: {
            object6 = this;
            object5 = longSparseArray;
            object4 = "track_point_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 999;
            f10 = 1.4E-42f;
            n13 = 0;
            string2 = null;
            if (n15 > n14) {
                object4 = new LongSparseArray(n14);
                n15 = longSparseArray.size();
                Object var11_13 = null;
                int n16 = 0;
                Object var13_17 = null;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l10 = ((LongSparseArray)object5).keyAt(i10);
                    Object object7 = ((LongSparseArray)object5).valueAt(i10);
                    ((LongSparseArray)object4).put(l10, object7);
                    if (++n16 != n14) continue;
                    ((G_ScriptDao_Impl)object6).__fetchRelationshipscriptTrackPointAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPoint((LongSparseArray)object4);
                    object4 = new LongSparseArray(n14);
                    n16 = 0;
                    var13_17 = null;
                }
                if (n16 > 0) {
                    ((G_ScriptDao_Impl)object6).__fetchRelationshipscriptTrackPointAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPoint((LongSparseArray)object4);
                }
                return;
            }
            object3 = StringUtil.newStringBuilder();
            object2 = "SELECT `id`,`track_point_id`,`type`,`duration`,`yaw`,`pitch`,`roll`,`orientation`,`func`,`zoom_start`,`zoom_end`,`zoom_type`,`focus_start`,`focus_end`,`focus_type` FROM `script_track_point` WHERE `track_point_id` IN (";
            ((StringBuilder)object3).append((String)object2);
            n14 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object3, n14);
            ((StringBuilder)object3).append(")");
            object3 = ((StringBuilder)object3).toString();
            object3 = RoomSQLiteQuery.acquire((String)object3, n14 += 0);
            n14 = 1;
            f10 = Float.MIN_VALUE;
            n12 = n14;
            object = null;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                long l11 = ((LongSparseArray)object5).keyAt(n11);
                ((RoomSQLiteQuery)object3).bindLong(n12, l11);
                n12 += n14;
            }
            object2 = ((G_ScriptDao_Impl)object6).__db;
            n11 = 0;
            object = null;
            object3 = DBUtil.query((RoomDatabase)object2, (SupportSQLiteQuery)object3, false, null);
            n14 = CursorUtil.getColumnIndex((Cursor)object3, (String)object4);
            n13 = -1;
            if (n14 != n13) break block81;
            object3.close();
            return;
        }
        string2 = "id";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string2);
        int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object4);
        String string3 = "type";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string3);
        String string4 = "duration";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string4);
        String string5 = "yaw";
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string5);
        Object object8 = "pitch";
        int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object8);
        Object object9 = "roll";
        int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object9);
        Object object10 = "orientation";
        int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object10);
        String string6 = "func";
        int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string6);
        String string7 = "zoom_start";
        int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string7);
        String string8 = "zoom_end";
        int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string8);
        object = "zoom_type";
        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object);
        object6 = "focus_start";
        int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object6);
        int n26 = n22;
        string6 = "focus_end";
        n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, string6);
        int n27 = n21;
        object10 = "focus_type";
        try {
            n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object3, (String)object10);
        }
        catch (Throwable throwable) {
            object3.close();
            throw throwable;
        }
        while (true) {
            int n28;
            block109: {
                block82: {
                    int n29;
                    int n30;
                    int n31;
                    int n32;
                    block108: {
                        block83: {
                            block107: {
                                block106: {
                                    block105: {
                                        block104: {
                                            block103: {
                                                block102: {
                                                    block101: {
                                                        float f11;
                                                        block100: {
                                                            block99: {
                                                                float f12;
                                                                block98: {
                                                                    long l12;
                                                                    block97: {
                                                                        block96: {
                                                                            block91: {
                                                                                block95: {
                                                                                    block94: {
                                                                                        block93: {
                                                                                            float f13;
                                                                                            block92: {
                                                                                                boolean bl2;
                                                                                                block90: {
                                                                                                    block85: {
                                                                                                        block89: {
                                                                                                            block88: {
                                                                                                                block87: {
                                                                                                                    block86: {
                                                                                                                        block84: {
                                                                                                                            n32 = object3.moveToNext();
                                                                                                                            if (n32 == 0) break;
                                                                                                                            n32 = object3.isNull(n14);
                                                                                                                            if (n32 != 0) break block82;
                                                                                                                            n32 = n19;
                                                                                                                            n31 = n20;
                                                                                                                            long l13 = object3.getLong(n14);
                                                                                                                            object8 = ((LongSparseArray)object5).get(l13);
                                                                                                                            object8 = (ArrayList)object8;
                                                                                                                            if (object8 == null) break block83;
                                                                                                                            n20 = (int)(object3.isNull(n23) ? 1 : 0);
                                                                                                                            if (n20 == 0) break block84;
                                                                                                                            n20 = (int)(object3.isNull(n24) ? 1 : 0);
                                                                                                                            if (n20 == 0) break block84;
                                                                                                                            n20 = (int)(object3.isNull(n11) ? 1 : 0);
                                                                                                                            if (n20 == 0) break block84;
                                                                                                                            n28 = n14;
                                                                                                                            n30 = n11;
                                                                                                                            n11 = 0;
                                                                                                                            object = null;
                                                                                                                            break block85;
                                                                                                                        }
                                                                                                                        n20 = (int)(object3.isNull(n23) ? 1 : 0);
                                                                                                                        if (n20 == 0) break block86;
                                                                                                                        n20 = 0;
                                                                                                                        f12 = 0.0f;
                                                                                                                        object9 = null;
                                                                                                                        break block87;
                                                                                                                    }
                                                                                                                    f12 = object3.getFloat(n23);
                                                                                                                    object9 = Float.valueOf(f12);
                                                                                                                }
                                                                                                                f13 = object3.getFloat(n24);
                                                                                                                n30 = (int)(object3.isNull(n11) ? 1 : 0);
                                                                                                                if (n30 == 0) break block88;
                                                                                                                n28 = n14;
                                                                                                                n30 = n11;
                                                                                                                n14 = 0;
                                                                                                                f10 = 0.0f;
                                                                                                                object2 = null;
                                                                                                                break block89;
                                                                                                            }
                                                                                                            String string9 = object3.getString(n11);
                                                                                                            n28 = n14;
                                                                                                            object2 = string9;
                                                                                                            n30 = n11;
                                                                                                        }
                                                                                                        object = new ScriptTrackPointItem((Float)object9, f13, (String)object2);
                                                                                                    }
                                                                                                    bl2 = object3.isNull(n25);
                                                                                                    if (!bl2) break block90;
                                                                                                    bl2 = object3.isNull(n22);
                                                                                                    if (!bl2) break block90;
                                                                                                    bl2 = object3.isNull(n21);
                                                                                                    if (!bl2) break block90;
                                                                                                    n29 = n25;
                                                                                                    n25 = 0;
                                                                                                    object6 = null;
                                                                                                    break block91;
                                                                                                }
                                                                                                bl2 = object3.isNull(n25);
                                                                                                if (!bl2) break block92;
                                                                                                bl2 = false;
                                                                                                f13 = 0.0f;
                                                                                                object5 = null;
                                                                                                break block93;
                                                                                            }
                                                                                            f13 = object3.getFloat(n25);
                                                                                            object5 = Float.valueOf(f13);
                                                                                        }
                                                                                        f10 = object3.getFloat(n22);
                                                                                        n20 = (int)(object3.isNull(n21) ? 1 : 0);
                                                                                        if (n20 == 0) break block94;
                                                                                        n29 = n25;
                                                                                        n20 = 0;
                                                                                        f12 = 0.0f;
                                                                                        object9 = null;
                                                                                        break block95;
                                                                                    }
                                                                                    object9 = object3.getString(n21);
                                                                                    n29 = n25;
                                                                                }
                                                                                object6 = new ScriptTrackPointItem((Float)object5, f10, (String)object9);
                                                                            }
                                                                            object5 = new ScriptTrackPoint();
                                                                            n14 = n21;
                                                                            l12 = object3.getLong(n13);
                                                                            ((ScriptTrackPoint)object5).setId(l12);
                                                                            l12 = object3.getLong(n17);
                                                                            ((ScriptTrackPoint)object5).setTrackPointId(l12);
                                                                            n20 = (int)(object3.isNull(n12) ? 1 : 0);
                                                                            if (n20 == 0) break block96;
                                                                            n20 = 0;
                                                                            f12 = 0.0f;
                                                                            object9 = null;
                                                                            break block97;
                                                                        }
                                                                        object9 = object3.getString(n12);
                                                                    }
                                                                    ((ScriptTrackPoint)object5).setType((String)object9);
                                                                    l12 = object3.getLong(n10);
                                                                    ((ScriptTrackPoint)object5).setDuration(l12);
                                                                    n20 = (int)(object3.isNull(n18) ? 1 : 0);
                                                                    if (n20 == 0) break block98;
                                                                    n20 = 0;
                                                                    f12 = 0.0f;
                                                                    object9 = null;
                                                                    break block99;
                                                                }
                                                                f12 = object3.getFloat(n18);
                                                                object9 = Float.valueOf(f12);
                                                            }
                                                            ((ScriptTrackPoint)object5).setYaw((Float)object9);
                                                            n20 = n32;
                                                            n21 = (int)(object3.isNull(n32) ? 1 : 0);
                                                            if (n21 == 0) break block100;
                                                            n21 = 0;
                                                            f11 = 0.0f;
                                                            object10 = null;
                                                            break block101;
                                                        }
                                                        f11 = object3.getFloat(n32);
                                                        object10 = Float.valueOf(f11);
                                                    }
                                                    ((ScriptTrackPoint)object5).setPitch((Float)object10);
                                                    n21 = n31;
                                                    n32 = (int)(object3.isNull(n31) ? 1 : 0);
                                                    if (n32 == 0) break block102;
                                                    n31 = n17;
                                                    n17 = 0;
                                                    object4 = null;
                                                    break block103;
                                                }
                                                float f14 = object3.getFloat(n31);
                                                Float f15 = Float.valueOf(f14);
                                                n31 = n17;
                                                object4 = f15;
                                            }
                                            ((ScriptTrackPoint)object5).setRoll((Float)object4);
                                            n17 = n27;
                                            n27 = (int)(object3.isNull(n27) ? 1 : 0);
                                            if (n27 == 0) break block104;
                                            n32 = n17;
                                            n17 = 0;
                                            object4 = null;
                                            break block105;
                                        }
                                        String string10 = object3.getString(n17);
                                        n32 = n17;
                                        object4 = string10;
                                    }
                                    ((ScriptTrackPoint)object5).setOrientation((String)object4);
                                    n17 = n26;
                                    n26 = (int)(object3.isNull(n26) ? 1 : 0);
                                    if (n26 == 0) break block106;
                                    n27 = n17;
                                    n17 = 0;
                                    object4 = null;
                                    break block107;
                                }
                                String string11 = object3.getString(n17);
                                n27 = n17;
                                object4 = string11;
                            }
                            ((ScriptTrackPoint)object5).setFunc((String)object4);
                            ((ScriptTrackPoint)object5).setZoom((ScriptTrackPointItem)object);
                            ((ScriptTrackPoint)object5).setFocus((ScriptTrackPointItem)object6);
                            ((ArrayList)object8).add(object5);
                            break block108;
                        }
                        n29 = n25;
                        n28 = n14;
                        n30 = n11;
                        n14 = n21;
                        n20 = n19;
                        n21 = n31;
                        n31 = n17;
                        n32 = n27;
                        n27 = n26;
                    }
                    object5 = longSparseArray;
                    n19 = n20;
                    n20 = n21;
                    n26 = n27;
                    n27 = n32;
                    n17 = n31;
                    n11 = n30;
                    n25 = n29;
                    break block109;
                }
                n28 = n14;
                n14 = n21;
                n21 = n20;
                object5 = longSparseArray;
            }
            n21 = n14;
            n14 = n28;
        }
        object3.close();
        return;
    }

    private void __fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording(LongSparseArray longSparseArray) {
        String string2;
        int n10;
        int n11;
        int n12;
        Object object;
        Object object2;
        String string3;
        int n13;
        int n14;
        Object object3;
        Object object4;
        Object object5;
        block72: {
            object5 = this;
            object4 = longSparseArray;
            object3 = "temp_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 999;
            n13 = 0;
            string3 = null;
            if (n15 > n14) {
                object3 = new LongSparseArray(n14);
                n15 = longSparseArray.size();
                Object var10_12 = null;
                int n16 = 0;
                Object var12_16 = null;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l10 = ((LongSparseArray)object4).keyAt(i10);
                    Object object6 = ((LongSparseArray)object4).valueAt(i10);
                    ((LongSparseArray)object3).put(l10, object6);
                    if (++n16 != n14) continue;
                    ((G_ScriptDao_Impl)object5).__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording((LongSparseArray)object3);
                    object3 = new LongSparseArray(n14);
                    n16 = 0;
                    var12_16 = null;
                }
                if (n16 > 0) {
                    ((G_ScriptDao_Impl)object5).__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording((LongSparseArray)object3);
                }
                return;
            }
            object2 = StringUtil.newStringBuilder();
            object = "SELECT `id`,`temp_id`,`name`,`title`,`attach_time`,`start_time`,`end_time`,`timebase`,`volume`,`mute`,`local_source`,`customer_uuid`,`fade_in_start_time`,`fade_in_end_time`,`fade_in_start_volume`,`fade_in_end_volume`,`fade_out_start_time`,`fade_out_end_time`,`fade_out_start_volume`,`fade_out_end_volume` FROM `template_recording` WHERE `temp_id` IN (";
            ((StringBuilder)object2).append((String)object);
            n14 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object2, n14);
            ((StringBuilder)object2).append(")");
            object2 = ((StringBuilder)object2).toString();
            object2 = RoomSQLiteQuery.acquire((String)object2, n14 += 0);
            n12 = n14 = 1;
            RoomDatabase roomDatabase = null;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                long l11 = ((LongSparseArray)object4).keyAt(n11);
                ((RoomSQLiteQuery)object2).bindLong(n12, l11);
                n12 += n14;
            }
            roomDatabase = ((G_ScriptDao_Impl)object5).__db;
            n12 = 0;
            string2 = null;
            object2 = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
            n11 = CursorUtil.getColumnIndex((Cursor)object2, (String)object3);
            n10 = -1;
            if (n11 != n10) break block72;
            object2.close();
            return;
        }
        String string4 = "id";
        n10 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string4);
        int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object3);
        String string5 = "name";
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string5);
        String string6 = "title";
        int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string6);
        String string7 = "attach_time";
        int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string7);
        String string8 = "start_time";
        int n21 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string8);
        String string9 = "end_time";
        int n22 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string9);
        String string10 = "timebase";
        int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string10);
        String string11 = "volume";
        int n24 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string11);
        object = "mute";
        n14 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object);
        string3 = "local_source";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string3);
        string2 = "customer_uuid";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        object5 = "fade_in_start_time";
        int n25 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object5);
        int n26 = n12;
        string2 = "fade_in_end_time";
        int n27 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_in_start_volume";
        int n28 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_in_end_volume";
        int n29 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_start_time";
        int n30 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_end_time";
        int n31 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_start_volume";
        int n32 = n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        string2 = "fade_out_end_volume";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        }
        catch (Throwable throwable) {
            object2.close();
            throw throwable;
        }
        while (true) {
            int n33;
            int n34;
            block93: {
                block73: {
                    int n35;
                    int n36;
                    block90: {
                        block74: {
                            block89: {
                                block88: {
                                    TemplateAudioTransition templateAudioTransition;
                                    TemplateAudioTransition templateAudioTransition2;
                                    boolean bl2;
                                    boolean bl3;
                                    float f10;
                                    long l12;
                                    long l13;
                                    long l14;
                                    long l15;
                                    String string12;
                                    String string13;
                                    long l16;
                                    long l17;
                                    block87: {
                                        TemplateAudioTransition templateAudioTransition3;
                                        float f11;
                                        int n37;
                                        block86: {
                                            block92: {
                                                block84: {
                                                    block85: {
                                                        block83: {
                                                            TemplateAudioTransition templateAudioTransition4;
                                                            block82: {
                                                                block79: {
                                                                    block91: {
                                                                        block80: {
                                                                            block81: {
                                                                                block78: {
                                                                                    block77: {
                                                                                        block76: {
                                                                                            block75: {
                                                                                                n36 = object2.moveToNext();
                                                                                                if (n36 == 0) break;
                                                                                                n36 = object2.isNull(n11);
                                                                                                if (n36 != 0) break block73;
                                                                                                n36 = n14;
                                                                                                n34 = n13;
                                                                                                long l18 = object2.getLong(n11);
                                                                                                object = ((LongSparseArray)object4).get(l18);
                                                                                                object = (ArrayList)object;
                                                                                                if (object == null) break block74;
                                                                                                l17 = object2.getLong(n10);
                                                                                                l16 = object2.getLong(n17);
                                                                                                n13 = (int)(object2.isNull(n18) ? 1 : 0);
                                                                                                if (n13 == 0) break block75;
                                                                                                string13 = null;
                                                                                                break block76;
                                                                                            }
                                                                                            string13 = string3 = object2.getString(n18);
                                                                                        }
                                                                                        n13 = (int)(object2.isNull(n19) ? 1 : 0);
                                                                                        if (n13 == 0) break block77;
                                                                                        string12 = null;
                                                                                        break block78;
                                                                                    }
                                                                                    string12 = string3 = object2.getString(n19);
                                                                                }
                                                                                l15 = object2.getLong(n20);
                                                                                l14 = object2.getLong(n21);
                                                                                l13 = object2.getLong(n22);
                                                                                l12 = object2.getLong(n23);
                                                                                f10 = object2.getFloat(n24);
                                                                                n13 = n36;
                                                                                n36 = object2.getInt(n36);
                                                                                n37 = n34;
                                                                                bl3 = n36 != 0;
                                                                                n36 = object2.getInt(n37);
                                                                                bl2 = n36 != 0;
                                                                                n36 = (int)(object2.isNull(n25) ? 1 : 0);
                                                                                if (n36 == 0) break block79;
                                                                                n34 = n37;
                                                                                n37 = n27;
                                                                                n27 = (int)(object2.isNull(n27) ? 1 : 0);
                                                                                if (n27 == 0) break block80;
                                                                                n27 = n17;
                                                                                n17 = n28;
                                                                                n28 = (int)(object2.isNull(n28) ? 1 : 0);
                                                                                if (n28 == 0) break block81;
                                                                                n36 = n13;
                                                                                n13 = n29;
                                                                                n28 = (int)(object2.isNull(n29) ? 1 : 0);
                                                                                if (n28 == 0) break block82;
                                                                                n28 = n37;
                                                                                n37 = n30;
                                                                                templateAudioTransition2 = null;
                                                                                break block83;
                                                                            }
                                                                            n36 = n13;
                                                                            break block91;
                                                                        }
                                                                        n27 = n17;
                                                                        n36 = n13;
                                                                        n17 = n28;
                                                                    }
                                                                    n13 = n29;
                                                                    break block82;
                                                                }
                                                                n34 = n37;
                                                                n36 = n13;
                                                                n37 = n27;
                                                                n13 = n29;
                                                                n27 = n17;
                                                                n17 = n28;
                                                            }
                                                            long l19 = object2.getLong(n25);
                                                            long l20 = object2.getLong(n37);
                                                            float f12 = object2.getFloat(n17);
                                                            f11 = object2.getFloat(n13);
                                                            templateAudioTransition2 = templateAudioTransition4;
                                                            templateAudioTransition4 = new TemplateAudioTransition(l19, l20, f12, f11);
                                                            n28 = n37;
                                                            n37 = n30;
                                                        }
                                                        n29 = (int)(object2.isNull(n37) ? 1 : 0);
                                                        if (n29 == 0) break block84;
                                                        n29 = n25;
                                                        n25 = n31;
                                                        n30 = (int)(object2.isNull(n31) ? 1 : 0);
                                                        if (n30 == 0) break block85;
                                                        n30 = n17;
                                                        n17 = n32;
                                                        n31 = (int)(object2.isNull(n32) ? 1 : 0);
                                                        if (n31 == 0) break block86;
                                                        n31 = (int)(object2.isNull(n12) ? 1 : 0);
                                                        if (n31 == 0) break block86;
                                                        n31 = n37;
                                                        templateAudioTransition = null;
                                                        break block87;
                                                    }
                                                    n30 = n17;
                                                    break block92;
                                                }
                                                n29 = n25;
                                                n30 = n17;
                                                n25 = n31;
                                            }
                                            n17 = n32;
                                        }
                                        long l21 = object2.getLong(n37);
                                        long l22 = object2.getLong(n25);
                                        f11 = object2.getFloat(n17);
                                        float f13 = object2.getFloat(n12);
                                        templateAudioTransition = templateAudioTransition3;
                                        templateAudioTransition3 = new TemplateAudioTransition(l21, l22, f11, f13);
                                        n31 = n37;
                                    }
                                    object4 = new TemplateRecording(l17, l16, string13, string12, l15, l14, l13, l12, f10, bl3, bl2, templateAudioTransition2, templateAudioTransition);
                                    n32 = n25;
                                    n25 = n26;
                                    n26 = (int)(object2.isNull(n26) ? 1 : 0);
                                    if (n26 == 0) break block88;
                                    n35 = n25;
                                    n25 = 0;
                                    object5 = null;
                                    break block89;
                                }
                                String string14 = object2.getString(n25);
                                n35 = n25;
                                object5 = string14;
                            }
                            ((TemplateBaseData)object4).setCustomerUUID((String)object5);
                            ((ArrayList)object).add(object4);
                            break block90;
                        }
                        n35 = n26;
                        n13 = n29;
                        n29 = n25;
                        n33 = n27;
                        n27 = n17;
                        n17 = n32;
                        n32 = n31;
                        n31 = n30;
                        n30 = n28;
                        n28 = n33;
                    }
                    object4 = longSparseArray;
                    n25 = n29;
                    n14 = n36;
                    n26 = n35;
                    n29 = n13;
                    break block93;
                }
                n34 = n13;
                n13 = n29;
                n33 = n27;
                n27 = n17;
                n17 = n32;
                n32 = n31;
                n31 = n30;
                n30 = n28;
                n28 = n33;
                object4 = longSparseArray;
            }
            n13 = n34;
            n33 = n32;
            n32 = n17;
            n17 = n27;
            n27 = n28;
            n28 = n30;
            n30 = n31;
            n31 = n33;
        }
        object2.close();
        return;
    }

    private void __fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw(LongSparseArray longSparseArray) {
        int n10;
        int n11;
        Object object;
        Object object2;
        String string2;
        int n12;
        int n13;
        int n14;
        Object object3;
        block24: {
            object3 = "back_id";
            int n15 = longSparseArray.isEmpty();
            if (n15 != 0) {
                return;
            }
            n15 = longSparseArray.size();
            n14 = 0;
            n13 = 999;
            n12 = 0;
            string2 = null;
            if (n15 > n13) {
                object3 = new LongSparseArray(n13);
                n15 = longSparseArray.size();
                int n16 = 0;
                for (int i10 = 0; i10 < n15; ++i10) {
                    long l10 = longSparseArray.keyAt(i10);
                    ((LongSparseArray)object3).put(l10, null);
                    if (++n16 != n13) continue;
                    this.__fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw((LongSparseArray)object3);
                    longSparseArray.putAll((LongSparseArray)object3);
                    object3 = new LongSparseArray(n13);
                    n16 = 0;
                }
                if (n16 > 0) {
                    this.__fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw((LongSparseArray)object3);
                    longSparseArray.putAll((LongSparseArray)object3);
                }
                return;
            }
            object2 = StringUtil.newStringBuilder();
            object = "SELECT `id`,`back_id`,`create_time` FROM `withdraw` WHERE `back_id` IN (";
            ((StringBuilder)object2).append((String)object);
            n13 = longSparseArray.size();
            StringUtil.appendPlaceholders((StringBuilder)object2, n13);
            ((StringBuilder)object2).append(")");
            object2 = ((StringBuilder)object2).toString();
            object2 = RoomSQLiteQuery.acquire((String)object2, n13 += 0);
            int n17 = n13 = 1;
            for (n11 = 0; n11 < (n10 = longSparseArray.size()); ++n11) {
                long l11 = longSparseArray.keyAt(n11);
                ((RoomSQLiteQuery)object2).bindLong(n17, l11);
                n17 += n13;
            }
            object = this.__db;
            object2 = DBUtil.query((RoomDatabase)object, (SupportSQLiteQuery)object2, false, null);
            n14 = CursorUtil.getColumnIndex((Cursor)object2, (String)object3);
            n13 = -1;
            if (n14 != n13) break block24;
            object2.close();
            return;
        }
        object = "id";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object);
        int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, (String)object3);
        string2 = "create_time";
        try {
            n12 = CursorUtil.getColumnIndexOrThrow((Cursor)object2, string2);
        }
        catch (Throwable throwable) {
            object2.close();
            throw throwable;
        }
        while (true) {
            n11 = (int)(object2.moveToNext() ? 1 : 0);
            if (n11 == 0) break;
            n11 = (int)(object2.isNull(n14) ? 1 : 0);
            if (n11 != 0) continue;
            long l12 = object2.getLong(n14);
            n10 = (int)(longSparseArray.containsKey(l12) ? 1 : 0);
            if (n10 == 0) continue;
            Withdraw withdraw = new Withdraw();
            long l13 = object2.getLong(n13);
            withdraw.setId(l13);
            l13 = object2.getLong(n18);
            withdraw.setBackId(l13);
            l13 = object2.getLong(n12);
            withdraw.createTime = l13;
            longSparseArray.put(l12, withdraw);
            continue;
            break;
        }
        object2.close();
        return;
    }

    public static /* synthetic */ RoomDatabase access$000(G_ScriptDao_Impl g_ScriptDao_Impl) {
        return g_ScriptDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_ScriptDao_Impl g_ScriptDao_Impl) {
        return g_ScriptDao_Impl.__insertionAdapterOfScript;
    }

    public static /* synthetic */ void access$1000(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic(longSparseArray);
    }

    public static /* synthetic */ void access$1100(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording(longSparseArray);
    }

    public static /* synthetic */ void access$1200(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO(longSparseArray);
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_ScriptDao_Impl g_ScriptDao_Impl) {
        return g_ScriptDao_Impl.__insertionAdapterOfScript_1;
    }

    public static /* synthetic */ void access$300(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate(longSparseArray);
    }

    public static /* synthetic */ void access$400(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript(longSparseArray);
    }

    public static /* synthetic */ void access$500(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft(longSparseArray);
    }

    public static /* synthetic */ void access$600(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw(longSparseArray);
    }

    public static /* synthetic */ void access$700(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal(longSparseArray);
    }

    public static /* synthetic */ void access$800(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo(longSparseArray);
    }

    public static /* synthetic */ void access$900(G_ScriptDao_Impl g_ScriptDao_Impl, LongSparseArray longSparseArray) {
        g_ScriptDao_Impl.__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker(longSparseArray);
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(Script object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfScript;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void delete(List object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfScript;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public Long getSmartMaxReferenceId() {
        Object object;
        RoomDatabase roomDatabase;
        RoomSQLiteQuery roomSQLiteQuery;
        Object object2;
        block13: {
            boolean bl2;
            object2 = null;
            roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT MAX(script.reference_id) FROM script", 0);
            this.__db.assertNotSuspendingTransaction();
            roomDatabase = this.__db;
            roomDatabase.beginTransaction();
            roomDatabase = this.__db;
            object = null;
            roomDatabase = DBUtil.query(roomDatabase, roomSQLiteQuery, false, null);
            try {
                bl2 = roomDatabase.moveToFirst();
                if (!bl2) break block13;
            }
            catch (Throwable throwable) {
                roomDatabase.close();
                roomSQLiteQuery.release();
                throw throwable;
            }
            bl2 = roomDatabase.isNull(0);
            if (bl2) break block13;
            long l10 = roomDatabase.getLong(0);
            object = object2 = Long.valueOf(l10);
        }
        object2 = this.__db;
        ((RoomDatabase)object2).setTransactionSuccessful();
        try {
            roomDatabase.close();
            roomSQLiteQuery.release();
            return object;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public LiveData getSmartMaxReferenceId_LiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT MAX(script.reference_id) FROM script", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"script"};
        G_ScriptDao_Impl$11 g_ScriptDao_Impl$11 = new G_ScriptDao_Impl$11(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, true, g_ScriptDao_Impl$11);
    }

    public z getSmartMaxReferenceId_Observable() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT MAX(script.reference_id) FROM script", 0);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"script"};
        G_ScriptDao_Impl$12 g_ScriptDao_Impl$12 = new G_ScriptDao_Impl$12(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, true, stringArray, g_ScriptDao_Impl$12);
    }

    public i0 getSmartMaxReferenceId_Single() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT MAX(script.reference_id) FROM script", 0);
        G_ScriptDao_Impl$10 g_ScriptDao_Impl$10 = new G_ScriptDao_Impl$10(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_ScriptDao_Impl$10);
    }

    public TemplatePOJO getTemplatePOJOFromScriptId(long l10) {
        Object object;
        G_ScriptDao_Impl g_ScriptDao_Impl = this;
        int bl3 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.id == ?)", bl3);
        roomSQLiteQuery.bindLong(bl3, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__db;
            boolean bl2 = false;
            object = null;
        }
        catch (Throwable throwable) {}
        {
            throw throwable;
        }
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, bl3 != 0, null);
        object2 = "id";
        try {
            int n10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string2 = "title_zh";
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "title_tw";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "title_en";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            ArrayList arrayList = "cover_url";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            ArrayList arrayList2 = "video_url";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList2));
            ArrayList arrayList3 = "video_time";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList3));
            String string5 = "video_count";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            ArrayList arrayList4 = "video_ratio";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList4));
            String string6 = "res_size";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "is_prime_usable";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "temp_type";
            bl3 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            object = "download_finished";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n21;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getTemplatePOJOFromScriptId_LiveData(long l10) {
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.id == ?)", (int)(bl2 ? 1 : 0));
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_ScriptDao_Impl$8 g_ScriptDao_Impl$8 = new G_ScriptDao_Impl$8(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, bl2, g_ScriptDao_Impl$8);
    }

    public z getTemplatePOJOFromScriptId_Observable(long l10) {
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.id == ?)", (int)(bl2 ? 1 : 0));
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_ScriptDao_Impl$9 g_ScriptDao_Impl$9 = new G_ScriptDao_Impl$9(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, bl2, stringArray, g_ScriptDao_Impl$9);
    }

    public i0 getTemplatePOJOFromScriptId_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.id == ?)", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_ScriptDao_Impl$7 g_ScriptDao_Impl$7 = new G_ScriptDao_Impl$7(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_ScriptDao_Impl$7);
    }

    public TemplatePOJO getTemplatePOJOFromSmartReferenceId(long l10) {
        Object object;
        G_ScriptDao_Impl g_ScriptDao_Impl = this;
        int bl3 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.reference_id = ?)", bl3);
        roomSQLiteQuery.bindLong(bl3, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__db;
            boolean bl2 = false;
            object = null;
        }
        catch (Throwable throwable) {}
        {
            throw throwable;
        }
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, bl3 != 0, null);
        object2 = "id";
        try {
            int n10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string2 = "title_zh";
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            String string3 = "title_tw";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "title_en";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            ArrayList arrayList = "cover_url";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            ArrayList arrayList2 = "video_url";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList2));
            ArrayList arrayList3 = "video_time";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList3));
            String string5 = "video_count";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            ArrayList arrayList4 = "video_ratio";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList4));
            String string6 = "res_size";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "is_prime_usable";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "temp_type";
            bl3 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            object = "download_finished";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n21;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData getTemplatePOJOFromSmartReferenceId_LiveData(long l10) {
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.reference_id = ?)", (int)(bl2 ? 1 : 0));
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_ScriptDao_Impl$14 g_ScriptDao_Impl$14 = new G_ScriptDao_Impl$14(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, bl2, g_ScriptDao_Impl$14);
    }

    public z getTemplatePOJOFromSmartReferenceId_Observable(long l10) {
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.reference_id = ?)", (int)(bl2 ? 1 : 0));
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_ScriptDao_Impl$15 g_ScriptDao_Impl$15 = new G_ScriptDao_Impl$15(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, bl2, stringArray, g_ScriptDao_Impl$15);
    }

    public i0 getTemplatePOJOFromSmartReferenceId_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE TemplateData.id == (SELECT script.script_id FROM script WHERE script.reference_id = ?)", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_ScriptDao_Impl$13 g_ScriptDao_Impl$13 = new G_ScriptDao_Impl$13(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_ScriptDao_Impl$13);
    }

    public long insert(Script object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScript_1;
            long l10 = ((EntityInsertionAdapter)object2).insertAndReturnId(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List insert(List list) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__insertionAdapterOfScript_1;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long insertNetworkScriptData(TemplatePOJO object) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            long l10 = ScriptDao.super.insertNetworkScriptData((TemplatePOJO)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 insertSingle(List list) {
        G_ScriptDao_Impl$6 g_ScriptDao_Impl$6 = new G_ScriptDao_Impl$6(this, list);
        return i0.o0(g_ScriptDao_Impl$6);
    }

    public long replace(Script object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfScript;
            long l10 = ((EntityInsertionAdapter)object2).insertAndReturnId(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List replace(List list) {
        this.__db.assertNotSuspendingTransaction();
        Object object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            object = this.__insertionAdapterOfScript;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 replaceSingle(List list) {
        G_ScriptDao_Impl$5 g_ScriptDao_Impl$5 = new G_ScriptDao_Impl$5(this, list);
        return i0.o0(g_ScriptDao_Impl$5);
    }

    public void update(Script object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfScript;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

