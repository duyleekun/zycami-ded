/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.core.util.Pair;
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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$10;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$11;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$12;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$13;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$14;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$15;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$16;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$17;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$18;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$19;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$20;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$21;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$22;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$23;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$24;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$25;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$26;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$27;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$28;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$29;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$30;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$31;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$32;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$33;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$34;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$35;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$36;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$37;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$38;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$39;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$40;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$41;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$42;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$43;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$44;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$45;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$46;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$8;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl$9;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
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
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
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
import java.util.concurrent.Callable;

public final class G_TemplateDataDao_Impl
implements G_TemplateDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTemplateData;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateData;
    private final EntityInsertionAdapter __insertionAdapterOfTemplateData_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteTemplateData_Single;
    private final SharedSQLiteStatement __preparedStmtOfRenameTemplate;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFirstLoaded;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfTemplateData;

    public G_TemplateDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        SharedSQLiteStatement sharedSQLiteStatement = new G_TemplateDataDao_Impl$1(this, roomDatabase);
        this.__insertionAdapterOfTemplateData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__insertionAdapterOfTemplateData_1 = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__deletionAdapterOfTemplateData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__updateAdapterOfTemplateData = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfDeleteTemplateData_Single = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfRenameTemplate = sharedSQLiteStatement;
        super(this, roomDatabase);
        this.__preparedStmtOfUpdateFirstLoaded = sharedSQLiteStatement;
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
                    ((G_TemplateDataDao_Impl)object6).__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal((LongSparseArray)object5);
                    longSparseArray2.putAll((LongSparseArray)object5);
                    object5 = new LongSparseArray(n15);
                    n17 = 0;
                    var15_20 = null;
                }
                if (n17 > 0) {
                    ((G_TemplateDataDao_Impl)object6).__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal((LongSparseArray)object5);
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
            roomDatabase = ((G_TemplateDataDao_Impl)object6).__db;
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
                    ((G_TemplateDataDao_Impl)object5).__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic((LongSparseArray)object3);
                    object3 = new LongSparseArray(n14);
                    n16 = 0;
                    var12_16 = null;
                }
                if (n16 > 0) {
                    ((G_TemplateDataDao_Impl)object5).__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic((LongSparseArray)object3);
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
            roomDatabase = ((G_TemplateDataDao_Impl)object5).__db;
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
                    ((G_TemplateDataDao_Impl)object4).__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker((LongSparseArray)object2);
                    object2 = new LongSparseArray(n14);
                    n16 = 0;
                    var12_16 = null;
                }
                if (n16 > 0) {
                    ((G_TemplateDataDao_Impl)object4).__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker((LongSparseArray)object2);
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
            roomDatabase = ((G_TemplateDataDao_Impl)object4).__db;
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
                    ((G_TemplateDataDao_Impl)object7).__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo((LongSparseArray)object5);
                    object5 = new LongSparseArray(n15);
                    n17 = 0;
                    var14_18 = null;
                    f13 = 0.0f;
                }
                if (n17 > 0) {
                    ((G_TemplateDataDao_Impl)object7).__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo((LongSparseArray)object5);
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
            object = ((G_TemplateDataDao_Impl)object7).__db;
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
                    ((G_TemplateDataDao_Impl)object6).__fetchRelationshipscriptTrackPointAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPoint((LongSparseArray)object4);
                    object4 = new LongSparseArray(n14);
                    n16 = 0;
                    var13_17 = null;
                }
                if (n16 > 0) {
                    ((G_TemplateDataDao_Impl)object6).__fetchRelationshipscriptTrackPointAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPoint((LongSparseArray)object4);
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
            object2 = ((G_TemplateDataDao_Impl)object6).__db;
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
                    ((G_TemplateDataDao_Impl)object5).__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording((LongSparseArray)object3);
                    object3 = new LongSparseArray(n14);
                    n16 = 0;
                    var12_16 = null;
                }
                if (n16 > 0) {
                    ((G_TemplateDataDao_Impl)object5).__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording((LongSparseArray)object3);
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
            roomDatabase = ((G_TemplateDataDao_Impl)object5).__db;
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

    public static /* synthetic */ RoomDatabase access$000(G_TemplateDataDao_Impl g_TemplateDataDao_Impl) {
        return g_TemplateDataDao_Impl.__db;
    }

    public static /* synthetic */ EntityInsertionAdapter access$100(G_TemplateDataDao_Impl g_TemplateDataDao_Impl) {
        return g_TemplateDataDao_Impl.__insertionAdapterOfTemplateData;
    }

    public static /* synthetic */ void access$1000(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker(longSparseArray);
    }

    public static /* synthetic */ void access$1100(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic(longSparseArray);
    }

    public static /* synthetic */ void access$1200(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording(longSparseArray);
    }

    public static /* synthetic */ void access$1300(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO(longSparseArray);
    }

    public static /* synthetic */ EntityInsertionAdapter access$200(G_TemplateDataDao_Impl g_TemplateDataDao_Impl) {
        return g_TemplateDataDao_Impl.__insertionAdapterOfTemplateData_1;
    }

    public static /* synthetic */ SharedSQLiteStatement access$300(G_TemplateDataDao_Impl g_TemplateDataDao_Impl) {
        return g_TemplateDataDao_Impl.__preparedStmtOfDeleteTemplateData_Single;
    }

    public static /* synthetic */ void access$400(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate(longSparseArray);
    }

    public static /* synthetic */ void access$500(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript(longSparseArray);
    }

    public static /* synthetic */ void access$600(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft(longSparseArray);
    }

    public static /* synthetic */ void access$700(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw(longSparseArray);
    }

    public static /* synthetic */ void access$800(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal(longSparseArray);
    }

    public static /* synthetic */ void access$900(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, LongSparseArray longSparseArray) {
        g_TemplateDataDao_Impl.__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo(longSparseArray);
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    public void delete(TemplateData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__deletionAdapterOfTemplateData;
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
            object2 = this.__deletionAdapterOfTemplateData;
            ((EntityDeletionOrUpdateAdapter)object2).handleMultiple((Iterable)object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public int deleteTemplateData(Integer object, Integer object2, Integer n10, Boolean bl2, String string2) {
        int n11;
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfDeleteTemplateData_Single.acquire();
        int n14 = 1;
        if (object == null) {
            supportSQLiteStatement.bindNull(n14);
        } else {
            int n15 = (Integer)object;
            l12 = n15;
            supportSQLiteStatement.bindLong(n14, l12);
        }
        n14 = 2;
        if (object == null) {
            supportSQLiteStatement.bindNull(n14);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            supportSQLiteStatement.bindLong(n14, l12);
        }
        n13 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            n14 = (Integer)object2;
            l11 = n14;
            supportSQLiteStatement.bindLong(n13, l11);
        }
        n13 = 4;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            n12 = (Integer)object2;
            l11 = n12;
            supportSQLiteStatement.bindLong(n13, l11);
        }
        n13 = 5;
        if (n10 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            supportSQLiteStatement.bindLong(n13, l11);
        }
        n13 = 6;
        if (n10 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            supportSQLiteStatement.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        object2 = null;
        if (bl2 == null) {
            n11 = 0;
            n10 = null;
        } else {
            n11 = bl2.booleanValue();
            n10 = n11;
        }
        if (n10 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            n11 = n10;
            l11 = n11;
            supportSQLiteStatement.bindLong(n13, l11);
        }
        n13 = 8;
        if (bl2 != null) {
            n12 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n12;
        }
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            n12 = (Integer)object2;
            l10 = n12;
            supportSQLiteStatement.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            supportSQLiteStatement.bindString(n13, string2);
        }
        n13 = 10;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n13);
        } else {
            supportSQLiteStatement.bindString(n13, string2);
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            n13 = supportSQLiteStatement.executeUpdateDelete();
            object2 = this.__db;
            ((RoomDatabase)object2).setTransactionSuccessful();
            return n13;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteTemplateData_Single.release(supportSQLiteStatement);
        }
    }

    public i0 deleteTemplateData_Single(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        G_TemplateDataDao_Impl$10 g_TemplateDataDao_Impl$10 = new G_TemplateDataDao_Impl$10(this, n10, n11, n12, bl2, string2);
        return i0.o0(g_TemplateDataDao_Impl$10);
    }

    public int deletedTemplateFromTemplateDataIds(long ... object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("DELETE FROM TemplateData WHERE id IN (");
        int n10 = ((long[])object).length;
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        RoomDatabase roomDatabase = this.__db;
        object2 = roomDatabase.compileStatement((String)object2);
        n10 = ((long[])object).length;
        int n11 = 1;
        int n12 = n11;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = object[i10];
            object2.bindLong(n12, l10);
            n12 += n11;
        }
        object = this.__db;
        ((RoomDatabase)object).beginTransaction();
        try {
            int n13 = object2.executeUpdateDelete();
            object2 = this.__db;
            ((RoomDatabase)object2).setTransactionSuccessful();
            return n13;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public List getSortTemplateData(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, boolean n13, Integer n14) {
        Object object;
        long l10;
        Object object2;
        int n15;
        long l11;
        int n16;
        int n17;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        ArrayList<Object> arrayList = string2;
        int n18 = n13;
        int n19 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n19);
        int n20 = 1;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n20);
        } else {
            n17 = n10;
            long l12 = n17;
            roomSQLiteQuery.bindLong(n20, l12);
        }
        n17 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n17, l11);
        }
        n17 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n11;
            l11 = n16;
            roomSQLiteQuery.bindLong(n17, l11);
        }
        n17 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n11;
            l11 = n16;
            roomSQLiteQuery.bindLong(n17, l11);
        }
        n17 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n12;
            l11 = n16;
            roomSQLiteQuery.bindLong(n17, l11);
        }
        n17 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n12;
            l11 = n16;
            roomSQLiteQuery.bindLong(n17, l11);
        }
        n17 = 7;
        n16 = 0;
        Object object3 = null;
        if (bl2 == null) {
            n15 = 0;
            object2 = null;
        } else {
            n15 = bl2.booleanValue();
            object2 = n15;
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = (Integer)object2;
            l10 = n15;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 8;
        if (bl2 == null) {
            n15 = 0;
            object2 = null;
        } else {
            n15 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n15;
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = (Integer)object2;
            l10 = n15;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 9;
        if (arrayList == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)((Object)arrayList));
        }
        n17 = 10;
        if (arrayList == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)((Object)arrayList));
        }
        int n21 = 11;
        if (n14 == null) {
            roomSQLiteQuery.bindNull(n21);
        } else {
            n17 = n14;
            l10 = n17;
            roomSQLiteQuery.bindLong(n21, l10);
        }
        n21 = 12;
        if (n14 == null) {
            roomSQLiteQuery.bindNull(n21);
        } else {
            n17 = n14;
            l10 = n17;
            roomSQLiteQuery.bindLong(n21, l10);
        }
        n21 = 13;
        l10 = n18;
        roomSQLiteQuery.bindLong(n21, l10);
        l10 = n18;
        roomSQLiteQuery.bindLong(n19, l10);
        g_TemplateDataDao_Impl.__db.assertNotSuspendingTransaction();
        arrayList = g_TemplateDataDao_Impl.__db;
        ((RoomDatabase)((Object)arrayList)).beginTransaction();
        try {
            arrayList = g_TemplateDataDao_Impl.__db;
            n18 = 0;
            object = null;
        }
        catch (Throwable throwable) {
            g_TemplateDataDao_Impl.__db.endTransaction();
            throw throwable;
        }
        Cursor cursor = DBUtil.query((RoomDatabase)((Object)arrayList), roomSQLiteQuery, false, null);
        arrayList = "id";
        try {
            n21 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string3 = "title_zh";
            n17 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            object2 = "title_tw";
            n15 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string4 = "title_en";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "cover_url";
            int n23 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "video_url";
            int n24 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "video_time";
            int n25 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "video_count";
            int n26 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            ArrayList<Object> arrayList2 = "video_ratio";
            int n27 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList2));
            String string9 = "res_size";
            int n28 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            object = "is_prime_usable";
            n18 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string10 = "temp_type";
            n20 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            object3 = "download_finished";
            n16 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            return n16;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public List getSortTemplateDataFromNonNullParam(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        int n14;
        Object object = this;
        Object object2 = nArray;
        Object object3 = nArray2;
        Object object4 = nArray3;
        String string3 = string2;
        Object object5 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object5).append(string4);
        int n15 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object5, n15);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object5).append(string5);
        int n16 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object5, n16);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object5).append(string6);
        int n17 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object5, n17);
        ((StringBuilder)object5).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object5).append(string7);
        ((StringBuilder)object5).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object5).append(string7);
        ((StringBuilder)object5).append(")  AND  (");
        ((StringBuilder)object5).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object5).append(string8);
        ((StringBuilder)object5).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object5).append(string7);
        object5 = ((StringBuilder)object5).toString();
        int n18 = n15 + 4 + n16 + n17;
        object5 = RoomSQLiteQuery.acquire((String)object5, n18);
        int n19 = nArray.length;
        int n20 = n14 = 1;
        String string9 = null;
        for (n13 = 0; n13 < n19; n13 += 1) {
            n12 = object2[n13];
            l10 = n12;
            ((RoomSQLiteQuery)object5).bindLong(n20, l10);
            n20 += n14;
        }
        int n21 = n15 + 1;
        n19 = ((int[])object3).length;
        n13 = n21;
        String string10 = null;
        for (n11 = 0; n11 < n19; n11 += 1) {
            n20 = object3[n11];
            long l11 = n20;
            ((RoomSQLiteQuery)object5).bindLong(n13, l11);
            n13 += n14;
        }
        int n22 = ((int[])object4).length;
        n11 = n21 += n16;
        string8 = null;
        for (n19 = 0; n19 < n22; n19 += 1) {
            n13 = object4[n19];
            long l12 = n13;
            ((RoomSQLiteQuery)object5).bindLong(n11, l12);
            n11 += n14;
        }
        n21 += n17;
        n22 = 0;
        object3 = null;
        if (bl2 == null) {
            n10 = 0;
            object4 = null;
        } else {
            n10 = bl2.booleanValue();
            object4 = n10;
        }
        if (object4 == null) {
            ((RoomSQLiteQuery)object5).bindNull(n21);
        } else {
            n10 = (Integer)object4;
            l10 = n10;
            ((RoomSQLiteQuery)object5).bindLong(n21, l10);
        }
        n21 = n15 + 2 + n16 + n17;
        if (bl2 == null) {
            n10 = 0;
            object4 = null;
        } else {
            n10 = (int)(bl2.booleanValue() ? 1 : 0);
            object4 = n10;
        }
        if (object4 == null) {
            ((RoomSQLiteQuery)object5).bindNull(n21);
        } else {
            n10 = (Integer)object4;
            l10 = n10;
            ((RoomSQLiteQuery)object5).bindLong(n21, l10);
        }
        n15 = n15 + 3 + n16 + n17;
        if (string3 == null) {
            ((RoomSQLiteQuery)object5).bindNull(n15);
        } else {
            ((RoomSQLiteQuery)object5).bindString(n15, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object5).bindNull(n18);
        } else {
            ((RoomSQLiteQuery)object5).bindString(n18, string3);
        }
        ((G_TemplateDataDao_Impl)object).__db.assertNotSuspendingTransaction();
        object2 = ((G_TemplateDataDao_Impl)object).__db;
        n10 = 0;
        object4 = null;
        string3 = DBUtil.query((RoomDatabase)object2, (SupportSQLiteQuery)object5, false, null);
        object2 = "id";
        try {
            n21 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, (String)object2);
            string4 = "title_zh";
        }
        catch (Throwable throwable) {}
        n15 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string4);
        string5 = "title_tw";
        n16 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string5);
        string6 = "title_en";
        n17 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string6);
        string7 = "cover_url";
        n18 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string7);
        string8 = "video_url";
        n19 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string8);
        string10 = "video_time";
        n11 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string10);
        string9 = "video_count";
        n13 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string9);
        ArrayList<Object> arrayList = "video_ratio";
        n20 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, (String)((Object)arrayList));
        String string11 = "res_size";
        n12 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string11);
        object3 = "is_prime_usable";
        try {
            n22 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, (String)object3);
            object4 = "temp_type";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, (String)object4);
            String string12 = "download_finished";
            n14 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, string12);
            object = "download_timestamp";
            int n23 = CursorUtil.getColumnIndexOrThrow((Cursor)string3, (String)object);
            return n23;
        }
        finally {
            Object object6 = object5;
        }
    }

    public LiveData getSortTemplateDataFromNonNullParam_LiveData(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n14 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n15 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n16 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n16);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n17 = n14 + 4 + n15 + n16;
        object4 = RoomSQLiteQuery.acquire((String)object4, n17);
        int n18 = nArray.length;
        int n19 = n13 = 1;
        for (n12 = 0; n12 < n18; ++n12) {
            int n20 = object[n12];
            l10 = n20;
            ((RoomSQLiteQuery)object4).bindLong(n19, l10);
            n19 += n13;
        }
        int n21 = n14 + 1;
        n18 = ((int[])object2).length;
        n12 = n21;
        for (n11 = 0; n11 < n18; ++n11) {
            n19 = object2[n11];
            long l11 = n19;
            ((RoomSQLiteQuery)object4).bindLong(n12, l11);
            n12 += n13;
        }
        int n22 = ((int[])object3).length;
        n11 = n21 += n15;
        string8 = null;
        for (n18 = 0; n18 < n22; ++n18) {
            n12 = object3[n18];
            long l12 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n11, l12);
            n11 += n13;
        }
        n21 += n16;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            l10 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l10);
        }
        n21 = n14 + 2 + n15 + n16;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n14 = n14 + 3 + n15 + n16;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n14);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n14, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n17);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n17, string3);
        }
        object = g_TemplateDataDao_Impl.__db.getInvalidationTracker();
        object2 = new String[]{"TemplateData"};
        object3 = new G_TemplateDataDao_Impl$36(g_TemplateDataDao_Impl, (RoomSQLiteQuery)object4);
        return ((InvalidationTracker)object).createLiveData((String[])object2, false, (Callable)object3);
    }

    public z getSortTemplateDataFromNonNullParam_Observable(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n14 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n15 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n16 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n16);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n17 = n14 + 4 + n15 + n16;
        object4 = RoomSQLiteQuery.acquire((String)object4, n17);
        int n18 = nArray.length;
        int n19 = n13 = 1;
        for (n12 = 0; n12 < n18; ++n12) {
            int n20 = object[n12];
            l10 = n20;
            ((RoomSQLiteQuery)object4).bindLong(n19, l10);
            n19 += n13;
        }
        int n21 = n14 + 1;
        n18 = ((int[])object2).length;
        n12 = n21;
        for (n11 = 0; n11 < n18; ++n11) {
            n19 = object2[n11];
            long l11 = n19;
            ((RoomSQLiteQuery)object4).bindLong(n12, l11);
            n12 += n13;
        }
        int n22 = ((int[])object3).length;
        n11 = n21 += n15;
        string8 = null;
        for (n18 = 0; n18 < n22; ++n18) {
            n12 = object3[n18];
            long l12 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n11, l12);
            n11 += n13;
        }
        n21 += n16;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            l10 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l10);
        }
        n21 = n14 + 2 + n15 + n16;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n14 = n14 + 3 + n15 + n16;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n14);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n14, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n17);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n17, string3);
        }
        object = g_TemplateDataDao_Impl.__db;
        object2 = new String[]{"TemplateData"};
        object3 = new G_TemplateDataDao_Impl$37(g_TemplateDataDao_Impl, (RoomSQLiteQuery)object4);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])object2, (Callable)object3);
    }

    public i0 getSortTemplateDataFromNonNullParam_Single(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        long l10;
        int n11;
        int n12;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n13 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n13);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n14 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n15 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n16 = n13 + 4 + n14 + n15;
        object4 = RoomSQLiteQuery.acquire((String)object4, n16);
        int n17 = nArray.length;
        int n18 = 0;
        int n19 = 1;
        int n20 = n19;
        for (n12 = 0; n12 < n17; ++n12) {
            n11 = object[n12];
            l10 = n11;
            ((RoomSQLiteQuery)object4).bindLong(n20, l10);
            n20 += n19;
        }
        int n21 = n13 + 1;
        n17 = ((int[])object2).length;
        n20 = n21;
        for (n12 = 0; n12 < n17; ++n12) {
            n11 = object2[n12];
            l10 = n11;
            ((RoomSQLiteQuery)object4).bindLong(n20, l10);
            n20 += n19;
        }
        int n22 = ((int[])object3).length;
        n17 = n21 += n14;
        while (n18 < n22) {
            n12 = object3[n18];
            long l11 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n17, l11);
            n17 += n19;
            ++n18;
        }
        n21 += n15;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            long l12 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l12);
        }
        n21 = n13 + 2 + n14 + n15;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n13 = n13 + 3 + n14 + n15;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n13);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n13, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n16);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n16, string3);
        }
        object = new G_TemplateDataDao_Impl$35;
        object2 = this;
        object(this, (RoomSQLiteQuery)object4);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getSortTemplateData_LiveData(Integer object, Integer stringArray, Integer object2, Boolean bl2, String string2, boolean bl3, Integer n10) {
        int n11;
        long l10;
        int n12;
        int n13;
        long l11;
        int n14;
        int n15 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n15);
        boolean bl4 = true;
        if (object == null) {
            roomSQLiteQuery.bindNull((int)(bl4 ? 1 : 0));
        } else {
            n14 = (Integer)object;
            l11 = n14;
            roomSQLiteQuery.bindLong((int)(bl4 ? 1 : 0), l11);
        }
        n14 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = (Integer)object;
            long l12 = n13;
            roomSQLiteQuery.bindLong(n14, l12);
        }
        n13 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n14 = stringArray.intValue();
            l11 = n14;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)object2;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)object2;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        stringArray = null;
        if (bl2 == null) {
            n11 = 0;
            object2 = null;
        } else {
            n11 = bl2.booleanValue();
            object2 = n11;
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = (Integer)object2;
            l11 = n11;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (bl2 != null) {
            n12 = (int)(bl2.booleanValue() ? 1 : 0);
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        n13 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        n13 = 11;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 12;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        l10 = (long)bl3;
        roomSQLiteQuery.bindLong(13, l10);
        long l13 = (long)bl3;
        roomSQLiteQuery.bindLong(n15, l13);
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateData", "TemplateVideo"};
        object2 = new G_TemplateDataDao_Impl$21(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, bl4, (Callable)object2);
    }

    public z getSortTemplateData_Observable(Integer object, Integer stringArray, Integer object2, Boolean bl2, String string2, boolean bl3, Integer n10) {
        int n11;
        long l10;
        int n12;
        int n13;
        long l11;
        int n14;
        int n15 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n15);
        boolean bl4 = true;
        if (object == null) {
            roomSQLiteQuery.bindNull((int)(bl4 ? 1 : 0));
        } else {
            n14 = (Integer)object;
            l11 = n14;
            roomSQLiteQuery.bindLong((int)(bl4 ? 1 : 0), l11);
        }
        n14 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = (Integer)object;
            long l12 = n13;
            roomSQLiteQuery.bindLong(n14, l12);
        }
        n13 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n14 = stringArray.intValue();
            l11 = n14;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)object2;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)object2;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        stringArray = null;
        if (bl2 == null) {
            n11 = 0;
            object2 = null;
        } else {
            n11 = bl2.booleanValue();
            object2 = n11;
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n11 = (Integer)object2;
            l11 = n11;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (bl2 != null) {
            n12 = (int)(bl2.booleanValue() ? 1 : 0);
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        n13 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        n13 = 11;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 12;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        l10 = (long)bl3;
        roomSQLiteQuery.bindLong(13, l10);
        long l13 = (long)bl3;
        roomSQLiteQuery.bindLong(n15, l13);
        object = this.__db;
        stringArray = new String[]{"TemplateData", "TemplateVideo"};
        object2 = new G_TemplateDataDao_Impl$22(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, bl4, stringArray, (Callable)object2);
    }

    public i0 getSortTemplateData_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2, boolean bl3, Integer n12) {
        int n13;
        long l10;
        int n14;
        long l11;
        int n15;
        long l12;
        int n16 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n16);
        int n17 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            int n18 = (Integer)object;
            l12 = n18;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n17 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = (Integer)object;
            l12 = n15;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n15 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n17 = n10;
            l11 = n17;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n10;
            l11 = n14;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            l11 = n14;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 7;
        n14 = 0;
        n10 = null;
        if (bl2 == null) {
            n13 = 0;
            n11 = null;
        } else {
            n13 = bl2.booleanValue();
            n11 = n13;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 8;
        if (bl2 != null) {
            n14 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n14;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n10;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        n15 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        n15 = 11;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n12;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 12;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n12;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        l10 = (long)bl3;
        roomSQLiteQuery.bindLong(13, l10);
        long l13 = (long)bl3;
        roomSQLiteQuery.bindLong(n16, l13);
        object = new G_TemplateDataDao_Impl$20(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public List getSortTemplatePOJO(Integer n10, Integer object, Integer n11, Boolean bl2, String string2, boolean bl3, Integer n12) {
        long l10;
        Object object2;
        long l11;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        ArrayList arrayList = string2;
        int n13 = bl3;
        int bl7 = 14;
        ArrayList arrayList2 = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", bl7);
        boolean bl4 = true;
        if (n10 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull((int)(bl4 ? 1 : 0));
        } else {
            int n14 = n10;
            long l12 = n14;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong((int)(bl4 ? 1 : 0), l12);
        }
        int n15 = 2;
        if (n10 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n15);
        } else {
            int n16 = n10;
            l11 = n16;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n15, l11);
        }
        int n17 = 3;
        if (object == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n17);
        } else {
            int n18 = (Integer)object;
            l11 = n18;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n17, l11);
        }
        int n19 = 4;
        if (object == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n19);
        } else {
            int n20 = (Integer)object;
            l11 = n20;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n19, l11);
        }
        int n21 = 5;
        if (n11 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n21);
        } else {
            int n22 = n11;
            l11 = n22;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n21, l11);
        }
        int n23 = 6;
        if (n11 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n23);
        } else {
            int n24 = n11;
            l11 = n24;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n23, l11);
        }
        int n25 = 7;
        boolean bl5 = false;
        ArrayList arrayList3 = null;
        if (bl2 == null) {
            boolean bl6 = false;
            object2 = null;
        } else {
            int n26 = bl2.booleanValue();
            object2 = n26;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n25);
        } else {
            int n27 = (Integer)object2;
            l10 = n27;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n25, l10);
        }
        int n28 = 8;
        if (bl2 == null) {
            boolean bl8 = false;
            object2 = null;
        } else {
            int n29 = bl2.booleanValue();
            object2 = n29;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n28);
        } else {
            int n30 = (Integer)object2;
            l10 = n30;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n28, l10);
        }
        int n31 = 9;
        if (arrayList == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n31);
        } else {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindString(n31, (String)((Object)arrayList));
        }
        int n32 = 10;
        if (arrayList == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n32);
        } else {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindString(n32, (String)((Object)arrayList));
        }
        int n33 = 11;
        if (n12 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n33);
        } else {
            int n34 = n12;
            l10 = n34;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n33, l10);
        }
        n33 = 12;
        if (n12 == null) {
            ((RoomSQLiteQuery)((Object)arrayList2)).bindNull(n33);
        } else {
            int n35 = n12;
            l10 = n35;
            ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n33, l10);
        }
        n33 = 13;
        l10 = n13;
        ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(n33, l10);
        l10 = n13;
        ((RoomSQLiteQuery)((Object)arrayList2)).bindLong(bl7, l10);
        g_TemplateDataDao_Impl.__db.assertNotSuspendingTransaction();
        arrayList = g_TemplateDataDao_Impl.__db;
        ((RoomDatabase)((Object)arrayList)).beginTransaction();
        try {
            arrayList = g_TemplateDataDao_Impl.__db;
        }
        catch (Throwable throwable) {}
        {
            throw throwable;
        }
        Cursor cursor = DBUtil.query((RoomDatabase)((Object)arrayList), (SupportSQLiteQuery)((Object)arrayList2), bl4, null);
        arrayList = "id";
        try {
            n33 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            ArrayList arrayList4 = "title_zh";
            int n36 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList4));
            ArrayList arrayList5 = "title_tw";
            int n37 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList5));
            object2 = "title_en";
            int n38 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "cover_url";
            boolean bl9 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            ArrayList arrayList6 = "video_url";
            boolean bl10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList6));
            ArrayList arrayList7 = "video_time";
            boolean bl11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList7));
            ArrayList arrayList8 = "video_count";
            boolean bl12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList8));
            ArrayList arrayList9 = "video_ratio";
            boolean bl13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList9));
            ArrayList arrayList10 = "res_size";
            boolean bl14 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList10));
            ArrayList arrayList11 = "is_prime_usable";
            boolean bl15 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList11));
            ArrayList arrayList12 = "temp_type";
            bl4 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList12));
            arrayList3 = "download_finished";
            boolean bl16 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList3));
            return bl16;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery = arrayList2;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getSortTemplatePOJOFromNonNullParam(int[] nArray, int[] object, int[] nArray2, Boolean bl2, String string2) {
        void var7_14;
        Object object2;
        block108: {
            Object object3;
            Object object4;
            Object object5;
            block107: {
                int n10;
                long l10;
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                int n16;
                int n17;
                int n18;
                int n19;
                int n20;
                int n21;
                int n22;
                int n23;
                int n24;
                int n25;
                int n26;
                int n27;
                int n28;
                int n29;
                int n30;
                int n31;
                int n32;
                int n33;
                int n34;
                Object object6;
                Object object7;
                Object object8;
                int n35;
                long l11;
                int n36;
                long l12;
                int n37;
                Object object9;
                int n38;
                long l13;
                int n39;
                int n40;
                Object object10;
                int n41;
                int n42;
                int n43;
                int n44;
                Object object11;
                Object object12;
                int n45;
                Object object13;
                int n46;
                Object object14;
                int n47;
                Object object15;
                Object object16;
                ArrayList<Object> arrayList;
                Object object17;
                block106: {
                    int n48;
                    object17 = this;
                    object5 = nArray;
                    object2 = object;
                    object4 = nArray2;
                    arrayList = string2;
                    object16 = StringUtil.newStringBuilder();
                    object15 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
                    ((StringBuilder)object16).append((String)object15);
                    n47 = nArray.length;
                    StringUtil.appendPlaceholders((StringBuilder)object16, n47);
                    object14 = ") AND TemplateData.template_use_type IN (";
                    ((StringBuilder)object16).append((String)object14);
                    n46 = ((Object)object).length;
                    StringUtil.appendPlaceholders((StringBuilder)object16, n46);
                    object13 = ") AND TemplateData.template_proto_type IN (";
                    ((StringBuilder)object16).append((String)object13);
                    n45 = nArray2.length;
                    StringUtil.appendPlaceholders((StringBuilder)object16, n45);
                    ((StringBuilder)object16).append(") AND  (");
                    object12 = "?";
                    ((StringBuilder)object16).append((String)object12);
                    ((StringBuilder)object16).append(" IS NULL OR TemplateData.download_finished == ");
                    ((StringBuilder)object16).append((String)object12);
                    ((StringBuilder)object16).append(")  AND  (");
                    ((StringBuilder)object16).append((String)object12);
                    object11 = " IS NULL OR TemplateData.video_ratio == ";
                    ((StringBuilder)object16).append((String)object11);
                    ((StringBuilder)object16).append((String)object12);
                    object12 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
                    ((StringBuilder)object16).append((String)object12);
                    object16 = ((StringBuilder)object16).toString();
                    n44 = n47 + 4 + n46 + n45;
                    object16 = RoomSQLiteQuery.acquire((String)object16, n44);
                    n43 = nArray.length;
                    n41 = n42 = 1;
                    object10 = null;
                    for (n40 = 0; n40 < n43; n41 += n42, ++n40) {
                        n39 = object5[n40];
                        l13 = n39;
                        ((RoomSQLiteQuery)object16).bindLong(n41, l13);
                    }
                    n38 = n47 + 1;
                    n43 = ((Object)object2).length;
                    n40 = n38;
                    object9 = null;
                    for (n37 = 0; n37 < n43; n40 += n42, ++n37) {
                        n41 = (int)object2[n37];
                        l12 = n41;
                        ((RoomSQLiteQuery)object16).bindLong(n40, l12);
                    }
                    n36 = ((int[])object4).length;
                    n37 = n38 += n46;
                    object11 = null;
                    for (n43 = 0; n43 < n36; n37 += n42, ++n43) {
                        n40 = object4[n43];
                        l11 = n40;
                        ((RoomSQLiteQuery)object16).bindLong(n37, l11);
                    }
                    n38 += n45;
                    n36 = 0;
                    object2 = null;
                    if (bl2 == null) {
                        n48 = 0;
                        object4 = null;
                    } else {
                        n48 = bl2.booleanValue();
                        object4 = n48;
                    }
                    if (object4 == null) {
                        ((RoomSQLiteQuery)object16).bindNull(n38);
                    } else {
                        n48 = (Integer)object4;
                        l13 = n48;
                        ((RoomSQLiteQuery)object16).bindLong(n38, l13);
                    }
                    n38 = n47 + 2 + n46 + n45;
                    if (bl2 == null) {
                        n48 = 0;
                        object4 = null;
                    } else {
                        n48 = (int)(bl2.booleanValue() ? 1 : 0);
                        object4 = n48;
                    }
                    if (object4 == null) {
                        ((RoomSQLiteQuery)object16).bindNull(n38);
                    } else {
                        n48 = (Integer)object4;
                        l13 = n48;
                        ((RoomSQLiteQuery)object16).bindLong(n38, l13);
                    }
                    n47 = n47 + 3 + n46 + n45;
                    if (arrayList == null) {
                        ((RoomSQLiteQuery)object16).bindNull(n47);
                    } else {
                        ((RoomSQLiteQuery)object16).bindString(n47, (String)((Object)arrayList));
                    }
                    if (arrayList == null) {
                        ((RoomSQLiteQuery)object16).bindNull(n44);
                    } else {
                        ((RoomSQLiteQuery)object16).bindString(n44, (String)((Object)arrayList));
                    }
                    ((G_TemplateDataDao_Impl)object17).__db.assertNotSuspendingTransaction();
                    object5 = ((G_TemplateDataDao_Impl)object17).__db;
                    ((RoomDatabase)object5).beginTransaction();
                    object5 = ((G_TemplateDataDao_Impl)object17).__db;
                    object4 = DBUtil.query((RoomDatabase)object5, (SupportSQLiteQuery)object16, n42 != 0, null);
                    object5 = "id";
                    n38 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object5);
                    arrayList = "title_zh";
                    n35 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)((Object)arrayList));
                    object15 = "title_tw";
                    n47 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object15);
                    object14 = "title_en";
                    n46 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object14);
                    object13 = "cover_url";
                    n45 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object13);
                    object12 = "video_url";
                    n44 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object12);
                    object11 = "video_time";
                    n43 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object11);
                    object9 = "video_count";
                    n37 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object9);
                    object10 = "video_ratio";
                    n40 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object10);
                    object8 = "res_size";
                    n41 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object8);
                    object7 = "is_prime_usable";
                    n39 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object7);
                    object6 = "temp_type";
                    n42 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object6);
                    object2 = "download_finished";
                    n36 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object2);
                    object3 = object16;
                    object16 = "download_timestamp";
                    try {
                        n33 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "editor_template";
                        n32 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "track_editor_config_data";
                        n31 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "template_use_type";
                        n30 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "template_proto_type";
                        n29 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "first_loaded";
                        n28 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "template_description_zh";
                        n27 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "template_description_en";
                        n26 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "template_description_zh_tw";
                        n25 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "script_ext_status";
                        n24 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "script_ext_protocol";
                        n23 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = "script_ext_version";
                        n22 = n34 = CursorUtil.getColumnIndexOrThrow((Cursor)object4, (String)object16);
                        object16 = new LongSparseArray();
                        n21 = n36;
                        object2 = new LongSparseArray();
                        n20 = n42;
                        object6 = new LongSparseArray();
                        n19 = n39;
                        object7 = new LongSparseArray();
                        n18 = n41;
                        object8 = new LongSparseArray();
                        n17 = n40;
                        object10 = new LongSparseArray();
                        n16 = n37;
                        object9 = new LongSparseArray();
                        n15 = n43;
                        object11 = new LongSparseArray();
                        n14 = n44;
                        object12 = new LongSparseArray();
                        n13 = n45;
                        object13 = new LongSparseArray();
                        while ((n12 = object4.moveToNext()) != 0) {
                            n12 = object4.isNull(n38);
                            if (n12 == 0) {
                                n12 = n47;
                                n11 = n46;
                                l10 = object4.getLong(n38);
                                n10 = n35;
                                n35 = 0;
                                arrayList = null;
                                ((LongSparseArray)object16).put(l10, null);
                            } else {
                                n10 = n35;
                                n12 = n47;
                                n11 = n46;
                            }
                            n35 = (int)(object4.isNull(n38) ? 1 : 0);
                            if (n35 == 0) {
                                l10 = object4.getLong(n38);
                                n35 = 0;
                                arrayList = null;
                                ((LongSparseArray)object2).put(l10, null);
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                n35 = 0;
                                arrayList = null;
                                ((LongSparseArray)object6).put(l10, null);
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                n35 = 0;
                                arrayList = null;
                                ((LongSparseArray)object7).put(l10, null);
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                n35 = 0;
                                arrayList = null;
                                ((LongSparseArray)object8).put(l10, null);
                            } else {
                                n35 = 0;
                                arrayList = null;
                            }
                            n47 = (int)(object4.isNull(n38) ? 1 : 0);
                            if (n47 == 0) {
                                l10 = object4.getLong(n38);
                                Object object18 = ((LongSparseArray)object10).get(l10);
                                if ((object18 = (ArrayList)object18) == null) {
                                    arrayList = new ArrayList<Object>();
                                    ((LongSparseArray)object10).put(l10, arrayList);
                                }
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                arrayList = ((LongSparseArray)object9).get(l10);
                                if ((arrayList = (ArrayList)arrayList) == null) {
                                    arrayList = new ArrayList<Object>();
                                    ((LongSparseArray)object9).put(l10, arrayList);
                                }
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                arrayList = ((LongSparseArray)object11).get(l10);
                                if ((arrayList = (ArrayList)arrayList) == null) {
                                    arrayList = new ArrayList<Object>();
                                    ((LongSparseArray)object11).put(l10, arrayList);
                                }
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                arrayList = ((LongSparseArray)object12).get(l10);
                                if ((arrayList = (ArrayList)arrayList) == null) {
                                    arrayList = new ArrayList<Object>();
                                    ((LongSparseArray)object12).put(l10, arrayList);
                                }
                            }
                            if ((n35 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                                l10 = object4.getLong(n38);
                                arrayList = ((LongSparseArray)object13).get(l10);
                                if ((arrayList = (ArrayList<Object>)arrayList) == null) {
                                    arrayList = new ArrayList<Object>();
                                    ((LongSparseArray)object13).put(l10, arrayList);
                                }
                            }
                            n47 = n12;
                            n46 = n11;
                            n35 = n10;
                        }
                        n10 = n35;
                        n12 = n47;
                        n11 = n46;
                        n35 = -1;
                        object4.moveToPosition(n35);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate((LongSparseArray)object16);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript((LongSparseArray)object2);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft((LongSparseArray)object6);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw((LongSparseArray)object7);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal((LongSparseArray)object8);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo((LongSparseArray)object10);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker((LongSparseArray)object9);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic((LongSparseArray)object11);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording((LongSparseArray)object12);
                        ((G_TemplateDataDao_Impl)object17).__fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO((LongSparseArray)object13);
                        n47 = object4.getCount();
                        arrayList = new ArrayList<Object>(n47);
                        break block106;
                    }
                    catch (Throwable throwable) {
                        object2 = object17;
                        break block107;
                    }
                    catch (Throwable throwable) {
                        object2 = object17;
                        object3 = object16;
                    }
                    break block107;
                    catch (Throwable throwable) {
                        object2 = object17;
                    }
                    break block108;
                }
                while ((n47 = (int)(object4.moveToNext() ? 1 : 0)) != 0) {
                    try {
                        int n49;
                        Object object19;
                        Object object20;
                        Object object21;
                        Object object22;
                        Object object23;
                        Object object24;
                        Object object25;
                        long l14;
                        int n50;
                        int n51;
                        Object object26;
                        ArrayList arrayList2;
                        Object object27;
                        ArrayList arrayList3;
                        ArrayList arrayList4;
                        ArrayList arrayList5;
                        ArrayList arrayList6;
                        Object object28;
                        Object object29;
                        ArrayList<Object> arrayList7;
                        int n52;
                        block132: {
                            Object object30;
                            block131: {
                                int n53;
                                block117: {
                                    block116: {
                                        block115: {
                                            block114: {
                                                block113: {
                                                    block112: {
                                                        block109: {
                                                            block110: {
                                                                block111: {
                                                                    block118: {
                                                                        block119: {
                                                                            block120: {
                                                                                block121: {
                                                                                    block130: {
                                                                                        block129: {
                                                                                            block128: {
                                                                                                block127: {
                                                                                                    block126: {
                                                                                                        block123: {
                                                                                                            block122: {
                                                                                                                block124: {
                                                                                                                    block125: {
                                                                                                                        n47 = (int)(object4.isNull(n38) ? 1 : 0);
                                                                                                                        if (n47 == 0) break block109;
                                                                                                                        n47 = n10;
                                                                                                                        n46 = (int)(object4.isNull(n10) ? 1 : 0);
                                                                                                                        if (n46 == 0) break block110;
                                                                                                                        n46 = n12;
                                                                                                                        if ((n12 = (int)(object4.isNull(n12) ? 1 : 0)) == 0) break block111;
                                                                                                                        n52 = n11;
                                                                                                                        n12 = (int)(object4.isNull(n11) ? 1 : 0);
                                                                                                                        if (n12 == 0) break block112;
                                                                                                                        arrayList7 = arrayList;
                                                                                                                        n35 = n13;
                                                                                                                        if ((n13 = (int)(object4.isNull(n13) ? 1 : 0)) == 0) break block113;
                                                                                                                        object29 = object13;
                                                                                                                        n45 = n14;
                                                                                                                        if ((n14 = (int)(object4.isNull(n14) ? 1 : 0)) == 0) break block114;
                                                                                                                        object28 = object12;
                                                                                                                        n44 = n15;
                                                                                                                        if ((n15 = (int)(object4.isNull(n15) ? 1 : 0)) == 0) break block115;
                                                                                                                        arrayList6 = object11;
                                                                                                                        n43 = n16;
                                                                                                                        if ((n16 = (int)(object4.isNull(n16) ? 1 : 0)) == 0) break block116;
                                                                                                                        arrayList5 = object9;
                                                                                                                        n37 = n17;
                                                                                                                        if ((n17 = (int)(object4.isNull(n17) ? 1 : 0)) == 0) break block117;
                                                                                                                        arrayList4 = object10;
                                                                                                                        n40 = n18;
                                                                                                                        if ((n18 = (int)(object4.isNull(n18) ? 1 : 0)) == 0) break block118;
                                                                                                                        arrayList3 = object8;
                                                                                                                        n41 = n19;
                                                                                                                        if ((n19 = (int)(object4.isNull(n19) ? 1 : 0)) == 0) break block119;
                                                                                                                        object27 = object7;
                                                                                                                        n39 = n20;
                                                                                                                        if ((n20 = (int)(object4.isNull(n20) ? 1 : 0)) == 0) break block120;
                                                                                                                        arrayList2 = object6;
                                                                                                                        n42 = n21;
                                                                                                                        if ((n21 = (int)(object4.isNull(n21) ? 1 : 0)) == 0) break block121;
                                                                                                                        object26 = object2;
                                                                                                                        n36 = n33;
                                                                                                                        n11 = (int)(object4.isNull(n33) ? 1 : 0);
                                                                                                                        if (n11 == 0) break block122;
                                                                                                                        object = object16;
                                                                                                                        n34 = n32;
                                                                                                                        n11 = (int)(object4.isNull(n32) ? 1 : 0);
                                                                                                                        if (n11 == 0) break block123;
                                                                                                                        n34 = n31;
                                                                                                                        n11 = (int)(object4.isNull(n31) ? 1 : 0);
                                                                                                                        if (n11 == 0) break block123;
                                                                                                                        n34 = n30;
                                                                                                                        n11 = (int)(object4.isNull(n30) ? 1 : 0);
                                                                                                                        if (n11 == 0) break block123;
                                                                                                                        n34 = n29;
                                                                                                                        if ((n29 = (int)(object4.isNull(n29) ? 1 : 0)) == 0) break block124;
                                                                                                                        n29 = n34;
                                                                                                                        n34 = n28;
                                                                                                                        if ((n28 = (int)(object4.isNull(n28) ? 1 : 0)) == 0) break block125;
                                                                                                                        n28 = n34;
                                                                                                                        n34 = n27;
                                                                                                                        if ((n27 = (int)(object4.isNull(n27) ? 1 : 0)) == 0) break block126;
                                                                                                                        n27 = n33;
                                                                                                                        n36 = n26;
                                                                                                                        if ((n26 = (int)(object4.isNull(n26) ? 1 : 0)) == 0) break block127;
                                                                                                                        n26 = n42;
                                                                                                                        n42 = n25;
                                                                                                                        if ((n25 = (int)(object4.isNull(n25) ? 1 : 0)) == 0) break block128;
                                                                                                                        n25 = n39;
                                                                                                                        n39 = n24;
                                                                                                                        if ((n24 = (int)(object4.isNull(n24) ? 1 : 0)) == 0) break block129;
                                                                                                                        n24 = n41;
                                                                                                                        n41 = n23;
                                                                                                                        if ((n23 = (int)(object4.isNull(n23) ? 1 : 0)) == 0) break block130;
                                                                                                                        n23 = n40;
                                                                                                                        n40 = n22;
                                                                                                                        if ((n22 = (int)(object4.isNull(n22) ? 1 : 0)) == 0) break block131;
                                                                                                                        n10 = n36;
                                                                                                                        n11 = n34;
                                                                                                                        n51 = n42;
                                                                                                                        n50 = n40;
                                                                                                                        n22 = n33;
                                                                                                                        n27 = n26;
                                                                                                                        n26 = n25;
                                                                                                                        n40 = n23;
                                                                                                                        n34 = 0;
                                                                                                                        object16 = null;
                                                                                                                        n23 = n52;
                                                                                                                        n25 = n35;
                                                                                                                        n42 = n37;
                                                                                                                        n35 = n29;
                                                                                                                        break block132;
                                                                                                                    }
                                                                                                                    n28 = n34;
                                                                                                                    break block123;
                                                                                                                }
                                                                                                                n29 = n34;
                                                                                                                break block123;
                                                                                                            }
                                                                                                            object = object16;
                                                                                                        }
                                                                                                        n34 = n27;
                                                                                                    }
                                                                                                    n27 = n36;
                                                                                                    n36 = n26;
                                                                                                }
                                                                                                n26 = n42;
                                                                                                n42 = n25;
                                                                                            }
                                                                                            n25 = n39;
                                                                                            n39 = n24;
                                                                                        }
                                                                                        n24 = n41;
                                                                                        n41 = n23;
                                                                                    }
                                                                                    n23 = n40;
                                                                                    n40 = n22;
                                                                                    break block131;
                                                                                }
                                                                                object26 = object2;
                                                                                n36 = n26;
                                                                                n26 = n42;
                                                                                n42 = n25;
                                                                                n25 = n39;
                                                                                n39 = n24;
                                                                                n24 = n41;
                                                                                n41 = n23;
                                                                                n23 = n40;
                                                                                n40 = n22;
                                                                                n53 = n27;
                                                                                n27 = n33;
                                                                                object = object16;
                                                                                n34 = n53;
                                                                                break block131;
                                                                            }
                                                                            arrayList2 = object6;
                                                                            n42 = n25;
                                                                            n25 = n39;
                                                                            n39 = n24;
                                                                            n24 = n41;
                                                                            n41 = n23;
                                                                            n23 = n40;
                                                                            n40 = n22;
                                                                            n53 = n27;
                                                                            n27 = n33;
                                                                            object = object16;
                                                                            n34 = n53;
                                                                            object26 = object2;
                                                                            n36 = n26;
                                                                            n26 = n21;
                                                                            break block131;
                                                                        }
                                                                        object27 = object7;
                                                                        n39 = n24;
                                                                        n24 = n41;
                                                                        n41 = n23;
                                                                        n23 = n40;
                                                                        n40 = n22;
                                                                        n53 = n27;
                                                                        n27 = n33;
                                                                        object = object16;
                                                                        n34 = n53;
                                                                        object26 = object2;
                                                                        n36 = n26;
                                                                        n26 = n21;
                                                                        arrayList2 = object6;
                                                                        n42 = n25;
                                                                        n25 = n20;
                                                                        break block131;
                                                                    }
                                                                    arrayList3 = object8;
                                                                    n41 = n23;
                                                                    n23 = n40;
                                                                    n40 = n22;
                                                                    n53 = n27;
                                                                    n27 = n33;
                                                                    object = object16;
                                                                    n34 = n53;
                                                                    object26 = object2;
                                                                    n36 = n26;
                                                                    n26 = n21;
                                                                    arrayList2 = object6;
                                                                    n42 = n25;
                                                                    n25 = n20;
                                                                    object27 = object7;
                                                                    n39 = n24;
                                                                    n24 = n19;
                                                                    break block131;
                                                                }
                                                                arrayList7 = arrayList;
                                                                n35 = n13;
                                                                n52 = n11;
                                                                break block113;
                                                            }
                                                            n46 = n12;
                                                            n52 = n11;
                                                            break block112;
                                                        }
                                                        n46 = n12;
                                                        n52 = n11;
                                                        n47 = n10;
                                                    }
                                                    arrayList7 = arrayList;
                                                    n35 = n13;
                                                }
                                                object29 = object13;
                                                n45 = n14;
                                            }
                                            object28 = object12;
                                            n44 = n15;
                                        }
                                        arrayList6 = object11;
                                        n43 = n16;
                                    }
                                    arrayList5 = object9;
                                    n37 = n17;
                                }
                                arrayList4 = object10;
                                n40 = n22;
                                n53 = n27;
                                n27 = n33;
                                object = object16;
                                n34 = n53;
                                object26 = object2;
                                n36 = n26;
                                n26 = n21;
                                arrayList2 = object6;
                                n42 = n25;
                                n25 = n20;
                                arrayList3 = object8;
                                n41 = n23;
                                n23 = n18;
                                object27 = object7;
                                n39 = n24;
                                n24 = n19;
                            }
                            n22 = (int)(object4.isNull(n34) ? 1 : 0);
                            if (n22 != 0 && (n22 = (int)(object4.isNull(n36) ? 1 : 0)) != 0 && (n22 = (int)(object4.isNull(n42) ? 1 : 0)) != 0) {
                                n10 = n36;
                                n11 = n34;
                                n22 = n37;
                                n51 = n42;
                                n37 = 0;
                                object9 = null;
                            } else {
                                String string3;
                                n22 = (int)(object4.isNull(n34) ? 1 : 0);
                                if (n22 != 0) {
                                    n11 = n34;
                                    n34 = 0;
                                    object16 = null;
                                } else {
                                    string3 = object4.getString(n34);
                                    n11 = n34;
                                    object16 = string3;
                                }
                                n22 = (int)(object4.isNull(n36) ? 1 : 0);
                                if (n22 != 0) {
                                    n10 = n36;
                                    n36 = 0;
                                    object2 = null;
                                } else {
                                    string3 = object4.getString(n36);
                                    n10 = n36;
                                    object2 = string3;
                                }
                                n22 = (int)(object4.isNull(n42) ? 1 : 0);
                                if (n22 != 0) {
                                    n22 = n37;
                                    n51 = n42;
                                    n42 = 0;
                                    object6 = null;
                                } else {
                                    string3 = object4.getString(n42);
                                    n51 = n42;
                                    object6 = string3;
                                    n22 = n37;
                                }
                                object9 = new TemplateDescription((String)object16, (String)object2, (String)object6);
                            }
                            n36 = (int)(object4.isNull(n39) ? 1 : 0);
                            if (n36 != 0 && (n36 = (int)(object4.isNull(n41) ? 1 : 0)) != 0 && (n36 = (int)(object4.isNull(n40) ? 1 : 0)) != 0) {
                                n36 = 0;
                                object2 = null;
                            } else {
                                n36 = object4.getInt(n39);
                                n34 = object4.getInt(n41);
                                n42 = object4.getInt(n40);
                                object2 = ScriptDataExt.create(n36, n34, n42);
                            }
                            object16 = new TemplateData();
                            n50 = n40;
                            l14 = object4.getLong(n38);
                            ((TemplateData)object16).setId(l14);
                            n42 = (int)(object4.isNull(n47) ? 1 : 0);
                            if (n42 != 0) {
                                n42 = 0;
                                object6 = null;
                            } else {
                                object6 = object4.getString(n47);
                            }
                            ((TemplateData)object16).setTextZh((String)object6);
                            n42 = (int)(object4.isNull(n46) ? 1 : 0);
                            if (n42 != 0) {
                                n42 = 0;
                                object6 = null;
                            } else {
                                object6 = object4.getString(n46);
                            }
                            ((TemplateData)object16).setTextZhTw((String)object6);
                            n42 = (int)(object4.isNull(n52) ? 1 : 0);
                            if (n42 != 0) {
                                n42 = 0;
                                object6 = null;
                            } else {
                                object6 = object4.getString(n52);
                            }
                            ((TemplateData)object16).setTextEn((String)object6);
                            n42 = (int)(object4.isNull(n35) ? 1 : 0);
                            if (n42 != 0) {
                                n42 = 0;
                                object6 = null;
                            } else {
                                object6 = object4.getString(n35);
                            }
                            ((TemplateData)object16).setCoverUrl((String)object6);
                            n42 = (int)(object4.isNull(n45) ? 1 : 0);
                            if (n42 != 0) {
                                n42 = 0;
                                object6 = null;
                            } else {
                                object6 = object4.getString(n45);
                            }
                            ((TemplateData)object16).setVideoUrl((String)object6);
                            double d10 = object4.getDouble(n44);
                            ((TemplateData)object16).setVideoTime(d10);
                            n42 = object4.getInt(n43);
                            ((TemplateData)object16).setVideoCount(n42);
                            n42 = n22;
                            n40 = (int)(object4.isNull(n22) ? 1 : 0);
                            if (n40 != 0) {
                                n40 = 0;
                                object10 = null;
                            } else {
                                object10 = object4.getString(n22);
                            }
                            ((TemplateData)object16).setVideoRatio((String)object10);
                            n40 = n23;
                            n23 = n52;
                            n52 = object4.getInt(n40);
                            ((TemplateData)object16).setResSize(n52);
                            n52 = n24;
                            n24 = object4.getInt(n24);
                            if (n24 != 0) {
                                n24 = n52;
                                n52 = 1;
                            } else {
                                n24 = n52;
                                n52 = 0;
                                object17 = null;
                            }
                            ((TemplateData)object16).setPrimeUsable(n52 != 0);
                            n52 = n25;
                            n25 = n35;
                            n35 = object4.getInt(n52);
                            ((TemplateData)object16).setTempType(n35);
                            n35 = n26;
                            n26 = object4.getInt(n26);
                            if (n26 != 0) {
                                n26 = n52;
                                n52 = 1;
                            } else {
                                n26 = n52;
                                n52 = 0;
                                object17 = null;
                            }
                            ((TemplateData)object16).setDownloadFinished(n52 != 0);
                            n52 = n27;
                            n27 = (int)(object4.isNull(n27) ? 1 : 0);
                            if (n27 != 0) {
                                n22 = n52;
                                n52 = 0;
                                object17 = null;
                            } else {
                                long l15 = object4.getLong(n52);
                                object30 = l15;
                                n22 = n52;
                                object17 = object30;
                            }
                            ((TemplateData)object16).setDownloadTimestamp((Long)object17);
                            n52 = n32;
                            n27 = (int)(object4.isNull(n32) ? 1 : 0);
                            if (n27 != 0) {
                                n52 = 0;
                                object17 = null;
                            } else {
                                object17 = object30 = object4.getString(n32);
                            }
                            ((TemplateData)object16).setEditorTemplate((String)object17);
                            n52 = n31;
                            n27 = (int)(object4.isNull(n31) ? 1 : 0);
                            if (n27 != 0) {
                                n52 = 0;
                                object17 = null;
                            } else {
                                object17 = object30 = object4.getString(n31);
                            }
                            ((TemplateData)object16).setTrackEditorConfigData((String)object17);
                            n52 = n30;
                            n27 = n35;
                            n35 = object4.getInt(n30);
                            ((TemplateData)object16).setTemplateUseType(n35);
                            n35 = n29;
                            n52 = object4.getInt(n29);
                            ((TemplateData)object16).setTemplateProtocolType(n52);
                            n52 = n28;
                            n29 = object4.getInt(n28);
                            if (n29 != 0) {
                                n52 = 1;
                            } else {
                                n52 = 0;
                                object17 = null;
                            }
                            ((TemplateData)object16).setFirstLoaded(n52 != 0);
                            ((TemplateData)object16).setTemplateDescription((TemplateDescription)object9);
                            ((TemplateData)object16).setScriptDataExt((ScriptDataExt)object2);
                        }
                        n52 = (int)(object4.isNull(n38) ? 1 : 0);
                        if (n52 == 0) {
                            long l16 = object4.getLong(n38);
                            object9 = object;
                            object17 = ((LongSparseArray)object).get(l16);
                            object17 = (Template)object17;
                        } else {
                            object9 = object;
                            n52 = 0;
                            object17 = null;
                        }
                        n36 = (int)(object4.isNull(n38) ? 1 : 0);
                        if (n36 == 0) {
                            n36 = n47;
                            n29 = n46;
                            l10 = object4.getLong(n38);
                            n33 = n47;
                            object2 = object26;
                            object15 = ((LongSparseArray)object26).get(l10);
                            object15 = (Script)object15;
                        } else {
                            n33 = n47;
                            n29 = n46;
                            object2 = object26;
                            n47 = 0;
                            object15 = null;
                        }
                        n46 = (int)(object4.isNull(n38) ? 1 : 0);
                        if (n46 == 0) {
                            n21 = n45;
                            long l17 = object4.getLong(n38);
                            object25 = object2;
                            object2 = arrayList2;
                            object14 = ((LongSparseArray)((Object)arrayList2)).get(l17);
                            object14 = (Draft)object14;
                        } else {
                            object25 = object2;
                            n21 = n45;
                            object2 = arrayList2;
                            n46 = 0;
                            object14 = null;
                        }
                        n45 = (int)(object4.isNull(n38) ? 1 : 0);
                        if (n45 == 0) {
                            n20 = n44;
                            long l18 = object4.getLong(n38);
                            object24 = object2;
                            object2 = object27;
                            object13 = ((LongSparseArray)object27).get(l18);
                            object13 = (Withdraw)object13;
                        } else {
                            object24 = object2;
                            n20 = n44;
                            object2 = object27;
                            n45 = 0;
                            object13 = null;
                        }
                        n44 = (int)(object4.isNull(n38) ? 1 : 0);
                        if (n44 == 0) {
                            n19 = n43;
                            long l19 = object4.getLong(n38);
                            object23 = object2;
                            object2 = arrayList3;
                            object12 = ((LongSparseArray)((Object)arrayList3)).get(l19);
                            object12 = (TemplateGlobal)object12;
                        } else {
                            object23 = object2;
                            n19 = n43;
                            object2 = arrayList3;
                            n44 = 0;
                            object12 = null;
                        }
                        n43 = (int)(object4.isNull(n38) ? 1 : 0);
                        if (n43 == 0) {
                            arrayList3 = object9;
                            l13 = object4.getLong(n38);
                            object22 = object2;
                            object2 = arrayList4;
                            object11 = ((LongSparseArray)((Object)arrayList4)).get(l13);
                            object11 = (ArrayList)object11;
                        } else {
                            object22 = object2;
                            arrayList3 = object9;
                            object2 = arrayList4;
                            n43 = 0;
                            object11 = null;
                        }
                        if (object11 == null) {
                            object11 = new ArrayList();
                        }
                        if ((n37 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                            n17 = n42;
                            long l20 = object4.getLong(n38);
                            object21 = object2;
                            object2 = arrayList5;
                            object9 = ((LongSparseArray)((Object)arrayList5)).get(l20);
                            object9 = (ArrayList)object9;
                        } else {
                            object21 = object2;
                            n17 = n42;
                            object2 = arrayList5;
                            n37 = 0;
                            object9 = null;
                        }
                        if (object9 == null) {
                            object9 = new ArrayList();
                        }
                        if ((n42 = object4.isNull(n38)) == 0) {
                            n16 = n40;
                            l14 = object4.getLong(n38);
                            object20 = object2;
                            object2 = arrayList6;
                            object6 = ((LongSparseArray)((Object)arrayList6)).get(l14);
                            object6 = (ArrayList)object6;
                        } else {
                            object20 = object2;
                            n16 = n40;
                            object2 = arrayList6;
                            n42 = 0;
                            object6 = null;
                        }
                        if (object6 == null) {
                            object6 = new ArrayList();
                        }
                        if ((n40 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                            n15 = n41;
                            l11 = object4.getLong(n38);
                            object19 = object2;
                            object2 = object28;
                            object10 = ((LongSparseArray)object28).get(l11);
                            object10 = (ArrayList)object10;
                        } else {
                            object19 = object2;
                            n15 = n41;
                            object2 = object28;
                            n40 = 0;
                            object10 = null;
                        }
                        if (object10 == null) {
                            object10 = new ArrayList();
                        }
                        if ((n41 = (int)(object4.isNull(n38) ? 1 : 0)) == 0) {
                            n14 = n39;
                            l12 = object4.getLong(n38);
                            n49 = n38;
                            object5 = object29;
                            object8 = ((LongSparseArray)object29).get(l12);
                            object8 = (ArrayList)object8;
                        } else {
                            n49 = n38;
                            n14 = n39;
                            object5 = object29;
                            n41 = 0;
                            object8 = null;
                        }
                        if (object8 == null) {
                            object8 = new ArrayList();
                        }
                        object7 = new TemplatePOJO();
                        ((TemplatePOJO)object7).setTemplateData((TemplateData)object16);
                        ((TemplatePOJO)object7).setTemplate((Template)object17);
                        ((TemplatePOJO)object7).setScript((Script)object15);
                        ((TemplatePOJO)object7).setDraft((Draft)object14);
                        ((TemplatePOJO)object7).setWithdraw((Withdraw)object13);
                        ((TemplatePOJO)object7).setTemplateGlobal((TemplateGlobal)object12);
                        ((TemplatePOJO)object7).setTemplateVideoList((List)object11);
                        ((TemplatePOJO)object7).setTemplateStickerList((List)object9);
                        ((TemplatePOJO)object7).setTemplateMusicList((List)object6);
                        ((TemplatePOJO)object7).setTemplateRecordingList((List)object10);
                        ((TemplatePOJO)object7).setScriptTrackPOJOList((List)object8);
                        object17 = arrayList7;
                        arrayList7.add(object7);
                        object13 = object5;
                        object12 = object2;
                        n12 = n29;
                        n13 = n25;
                        object16 = arrayList3;
                        n18 = n16;
                        n25 = n51;
                        object2 = object25;
                        object6 = object24;
                        object7 = object23;
                        object8 = object22;
                        object10 = object21;
                        object9 = object20;
                        object11 = object19;
                        n38 = n49;
                        n29 = n35;
                        n16 = n19;
                        arrayList = arrayList7;
                        n19 = n24;
                        n24 = n14;
                        object17 = this;
                        n14 = n21;
                        n21 = n27;
                        n27 = n11;
                        n11 = n23;
                        n23 = n15;
                        n15 = n20;
                        n20 = n26;
                        n26 = n10;
                        n10 = n33;
                        n33 = n22;
                        n22 = n50;
                    }
                    catch (Throwable throwable) {
                        object2 = this;
                        break block107;
                    }
                }
                object2 = object17;
                object17 = arrayList;
                object5 = ((G_TemplateDataDao_Impl)object2).__db;
                ((RoomDatabase)object5).setTransactionSuccessful();
                try {
                    object4.close();
                    ((RoomSQLiteQuery)object3).release();
                    ((G_TemplateDataDao_Impl)object2).__db.endTransaction();
                    return arrayList;
                }
                catch (Throwable throwable) {}
                catch (Throwable throwable) {}
            }
            object4.close();
            ((RoomSQLiteQuery)object3).release();
            throw object5;
        }
        ((G_TemplateDataDao_Impl)object2).__db.endTransaction();
        throw var7_14;
    }

    public LiveData getSortTemplatePOJOFromNonNullParam_LiveData(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n14 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n15 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n16 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n16);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n17 = n14 + 4 + n15 + n16;
        object4 = RoomSQLiteQuery.acquire((String)object4, n17);
        int n18 = nArray.length;
        int n19 = n13 = 1;
        for (n12 = 0; n12 < n18; ++n12) {
            int n20 = object[n12];
            l10 = n20;
            ((RoomSQLiteQuery)object4).bindLong(n19, l10);
            n19 += n13;
        }
        int n21 = n14 + 1;
        n18 = ((int[])object2).length;
        n12 = n21;
        for (n11 = 0; n11 < n18; ++n11) {
            n19 = object2[n11];
            long l11 = n19;
            ((RoomSQLiteQuery)object4).bindLong(n12, l11);
            n12 += n13;
        }
        int n22 = ((int[])object3).length;
        n18 = n21 += n15;
        for (n11 = 0; n11 < n22; ++n11) {
            n12 = object3[n11];
            long l12 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n18, l12);
            n18 += n13;
        }
        n21 += n16;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            l10 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l10);
        }
        n21 = n14 + 2 + n15 + n16;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n14 = n14 + 3 + n15 + n16;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n14);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n14, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n17);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n17, string3);
        }
        object = g_TemplateDataDao_Impl.__db.getInvalidationTracker();
        object2 = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        object3 = new G_TemplateDataDao_Impl$27(g_TemplateDataDao_Impl, (RoomSQLiteQuery)object4);
        return ((InvalidationTracker)object).createLiveData((String[])object2, n13 != 0, (Callable)object3);
    }

    public z getSortTemplatePOJOFromNonNullParam_Observable(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        int n11;
        long l10;
        int n12;
        int n13;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n14 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n15 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n16 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n16);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n17 = n14 + 4 + n15 + n16;
        object4 = RoomSQLiteQuery.acquire((String)object4, n17);
        int n18 = nArray.length;
        int n19 = n13 = 1;
        for (n12 = 0; n12 < n18; ++n12) {
            int n20 = object[n12];
            l10 = n20;
            ((RoomSQLiteQuery)object4).bindLong(n19, l10);
            n19 += n13;
        }
        int n21 = n14 + 1;
        n18 = ((int[])object2).length;
        n12 = n21;
        for (n11 = 0; n11 < n18; ++n11) {
            n19 = object2[n11];
            long l11 = n19;
            ((RoomSQLiteQuery)object4).bindLong(n12, l11);
            n12 += n13;
        }
        int n22 = ((int[])object3).length;
        n18 = n21 += n15;
        for (n11 = 0; n11 < n22; ++n11) {
            n12 = object3[n11];
            long l12 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n18, l12);
            n18 += n13;
        }
        n21 += n16;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            l10 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l10);
        }
        n21 = n14 + 2 + n15 + n16;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n14 = n14 + 3 + n15 + n16;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n14);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n14, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n17);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n17, string3);
        }
        object = g_TemplateDataDao_Impl.__db;
        object2 = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        object3 = new G_TemplateDataDao_Impl$28(g_TemplateDataDao_Impl, (RoomSQLiteQuery)object4);
        return RxRoom.createObservable((RoomDatabase)object, n13 != 0, (String[])object2, (Callable)object3);
    }

    public i0 getSortTemplatePOJOFromNonNullParam_Single(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        int n10;
        long l10;
        int n11;
        int n12;
        Object object = nArray;
        Object object2 = nArray2;
        Object object3 = nArray3;
        String string3 = string2;
        Object object4 = StringUtil.newStringBuilder();
        String string4 = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (";
        ((StringBuilder)object4).append(string4);
        int n13 = nArray.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n13);
        String string5 = ") AND TemplateData.template_use_type IN (";
        ((StringBuilder)object4).append(string5);
        int n14 = nArray2.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n14);
        String string6 = ") AND TemplateData.template_proto_type IN (";
        ((StringBuilder)object4).append(string6);
        int n15 = nArray3.length;
        StringUtil.appendPlaceholders((StringBuilder)object4, n15);
        ((StringBuilder)object4).append(") AND  (");
        String string7 = "?";
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(" IS NULL OR TemplateData.download_finished == ");
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(")  AND  (");
        ((StringBuilder)object4).append(string7);
        String string8 = " IS NULL OR TemplateData.video_ratio == ";
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string7);
        string7 = ")  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
        ((StringBuilder)object4).append(string7);
        object4 = ((StringBuilder)object4).toString();
        int n16 = n13 + 4 + n14 + n15;
        object4 = RoomSQLiteQuery.acquire((String)object4, n16);
        int n17 = nArray.length;
        int n18 = 0;
        int n19 = 1;
        int n20 = n19;
        for (n12 = 0; n12 < n17; ++n12) {
            n11 = object[n12];
            l10 = n11;
            ((RoomSQLiteQuery)object4).bindLong(n20, l10);
            n20 += n19;
        }
        int n21 = n13 + 1;
        n17 = ((int[])object2).length;
        n20 = n21;
        for (n12 = 0; n12 < n17; ++n12) {
            n11 = object2[n12];
            l10 = n11;
            ((RoomSQLiteQuery)object4).bindLong(n20, l10);
            n20 += n19;
        }
        int n22 = ((int[])object3).length;
        n17 = n21 += n14;
        while (n18 < n22) {
            n12 = object3[n18];
            long l11 = n12;
            ((RoomSQLiteQuery)object4).bindLong(n17, l11);
            n17 += n19;
            ++n18;
        }
        n21 += n15;
        n22 = 0;
        object2 = null;
        if (bl2 == null) {
            n10 = 0;
            object3 = null;
        } else {
            n10 = bl2.booleanValue();
            object3 = n10;
        }
        if (object3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n10 = (Integer)object3;
            long l12 = n10;
            ((RoomSQLiteQuery)object4).bindLong(n21, l12);
        }
        n21 = n13 + 2 + n14 + n15;
        if (bl2 != null) {
            n22 = (int)(bl2.booleanValue() ? 1 : 0);
            object2 = n22;
        }
        if (object2 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n21);
        } else {
            n22 = object2.intValue();
            long l13 = n22;
            ((RoomSQLiteQuery)object4).bindLong(n21, l13);
        }
        n13 = n13 + 3 + n14 + n15;
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n13);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n13, string3);
        }
        if (string3 == null) {
            ((RoomSQLiteQuery)object4).bindNull(n16);
        } else {
            ((RoomSQLiteQuery)object4).bindString(n16, string3);
        }
        object = new G_TemplateDataDao_Impl$26;
        object2 = this;
        object(this, (RoomSQLiteQuery)object4);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getSortTemplatePOJO_LiveData(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, boolean bl3, Integer n13) {
        Integer n14;
        int n15;
        long l10;
        int n16;
        long l11;
        int n17;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = string2;
        int n18 = bl3;
        int n19 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n19);
        boolean bl4 = true;
        if (n10 == null) {
            roomSQLiteQuery.bindNull((int)(bl4 ? 1 : 0));
        } else {
            n17 = n10;
            l11 = n17;
            roomSQLiteQuery.bindLong((int)(bl4 ? 1 : 0), l11);
        }
        n17 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n10;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n11;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n11;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n12;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n12;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 7;
        n16 = 0;
        Integer n20 = null;
        if (bl2 == null) {
            n15 = 0;
            n14 = null;
        } else {
            n15 = bl2.booleanValue();
            n14 = n15;
        }
        if (n14 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = n14;
            long l12 = n15;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n17 = 8;
        if (bl2 != null) {
            n16 = (int)(bl2.booleanValue() ? 1 : 0);
            n20 = n16;
        }
        if (n20 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n20;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 9;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)object);
        }
        n17 = 10;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)object);
        }
        int n21 = 11;
        if (n13 == null) {
            roomSQLiteQuery.bindNull(n21);
        } else {
            n17 = n13;
            l11 = n17;
            roomSQLiteQuery.bindLong(n21, l11);
        }
        n21 = 12;
        if (n13 == null) {
            roomSQLiteQuery.bindNull(n21);
        } else {
            n17 = n13;
            l11 = n17;
            roomSQLiteQuery.bindLong(n21, l11);
        }
        l11 = n18;
        roomSQLiteQuery.bindLong(13, l11);
        long l13 = n18;
        roomSQLiteQuery.bindLong(n19, l13);
        object = g_TemplateDataDao_Impl.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$39 g_TemplateDataDao_Impl$39 = new G_TemplateDataDao_Impl$39(g_TemplateDataDao_Impl, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, bl4, g_TemplateDataDao_Impl$39);
    }

    public z getSortTemplatePOJO_Observable(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, boolean bl3, Integer n13) {
        Integer n14;
        int n15;
        long l10;
        int n16;
        long l11;
        int n17;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = string2;
        int n18 = bl3;
        int n19 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n19);
        boolean bl4 = true;
        if (n10 == null) {
            roomSQLiteQuery.bindNull((int)(bl4 ? 1 : 0));
        } else {
            n17 = n10;
            l11 = n17;
            roomSQLiteQuery.bindLong((int)(bl4 ? 1 : 0), l11);
        }
        n17 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n10;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n11;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n11;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n12;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n12;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 7;
        n16 = 0;
        Integer n20 = null;
        if (bl2 == null) {
            n15 = 0;
            n14 = null;
        } else {
            n15 = bl2.booleanValue();
            n14 = n15;
        }
        if (n14 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = n14;
            long l12 = n15;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n17 = 8;
        if (bl2 != null) {
            n16 = (int)(bl2.booleanValue() ? 1 : 0);
            n20 = n16;
        }
        if (n20 == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n16 = n20;
            l10 = n16;
            roomSQLiteQuery.bindLong(n17, l10);
        }
        n17 = 9;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)object);
        }
        n17 = 10;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)object);
        }
        int n21 = 11;
        if (n13 == null) {
            roomSQLiteQuery.bindNull(n21);
        } else {
            n17 = n13;
            l11 = n17;
            roomSQLiteQuery.bindLong(n21, l11);
        }
        n21 = 12;
        if (n13 == null) {
            roomSQLiteQuery.bindNull(n21);
        } else {
            n17 = n13;
            l11 = n17;
            roomSQLiteQuery.bindLong(n21, l11);
        }
        l11 = n18;
        roomSQLiteQuery.bindLong(13, l11);
        long l13 = n18;
        roomSQLiteQuery.bindLong(n19, l13);
        object = g_TemplateDataDao_Impl.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$40 g_TemplateDataDao_Impl$40 = new G_TemplateDataDao_Impl$40(g_TemplateDataDao_Impl, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, bl4, stringArray, g_TemplateDataDao_Impl$40);
    }

    public i0 getSortTemplatePOJO_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2, boolean bl3, Integer n12) {
        int n13;
        long l10;
        int n14;
        long l11;
        int n15;
        long l12;
        int n16 = 14;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN ? THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN ? THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ", n16);
        int n17 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            int n18 = (Integer)object;
            l12 = n18;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n17 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = (Integer)object;
            l12 = n15;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n15 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n17 = n10;
            l11 = n17;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n10;
            l11 = n14;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            l11 = n14;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 7;
        n14 = 0;
        n10 = null;
        if (bl2 == null) {
            n13 = 0;
            n11 = null;
        } else {
            n13 = bl2.booleanValue();
            n11 = n13;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 8;
        if (bl2 != null) {
            n14 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n14;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n10;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        n15 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        n15 = 11;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n12;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 12;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n12;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        l10 = (long)bl3;
        roomSQLiteQuery.bindLong(13, l10);
        long l13 = (long)bl3;
        roomSQLiteQuery.bindLong(n16, l13);
        object = new G_TemplateDataDao_Impl$38(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public TemplatePOJO getTemplate(long l10) {
        Object object;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        int bl3 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", bl3);
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

    public Long getTemplateCount(Integer object, Integer number, Integer n10, Boolean bl2, String string2, Integer n11) {
        RoomSQLiteQuery roomSQLiteQuery;
        block34: {
            long l10;
            block35: {
                long l11;
                int n12;
                int n13;
                long l12;
                int n14;
                long l13;
                int n15 = 12;
                roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM TemplateData  WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ", n15);
                int n16 = 1;
                if (object == null) {
                    roomSQLiteQuery.bindNull(n16);
                } else {
                    int n17 = (Integer)object;
                    l13 = n17;
                    roomSQLiteQuery.bindLong(n16, l13);
                }
                n16 = 2;
                if (object == null) {
                    roomSQLiteQuery.bindNull(n16);
                } else {
                    n14 = (Integer)object;
                    l13 = n14;
                    roomSQLiteQuery.bindLong(n16, l13);
                }
                n14 = 3;
                if (number == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n16 = number;
                    l12 = n16;
                    roomSQLiteQuery.bindLong(n14, l12);
                }
                n14 = 4;
                if (number == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n13 = number;
                    l12 = n13;
                    roomSQLiteQuery.bindLong(n14, l12);
                }
                n14 = 5;
                if (n10 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n13 = n10;
                    l12 = n13;
                    roomSQLiteQuery.bindLong(n14, l12);
                }
                n14 = 6;
                if (n10 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n13 = n10;
                    l10 = n13;
                    roomSQLiteQuery.bindLong(n14, l10);
                }
                n14 = 7;
                n13 = 0;
                number = null;
                if (bl2 == null) {
                    n12 = 0;
                    n10 = null;
                } else {
                    n12 = bl2.booleanValue();
                    n10 = n12;
                }
                if (n10 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n12 = n10;
                    l12 = n12;
                    roomSQLiteQuery.bindLong(n14, l12);
                }
                n14 = 8;
                if (bl2 == null) {
                    n12 = 0;
                    n10 = null;
                } else {
                    n12 = (int)(bl2.booleanValue() ? 1 : 0);
                    n10 = n12;
                }
                if (n10 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n12 = n10;
                    l11 = n12;
                    roomSQLiteQuery.bindLong(n14, l11);
                }
                n14 = 9;
                if (string2 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    roomSQLiteQuery.bindString(n14, string2);
                }
                n14 = 10;
                if (string2 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    roomSQLiteQuery.bindString(n14, string2);
                }
                n14 = 11;
                if (n11 == null) {
                    roomSQLiteQuery.bindNull(n14);
                } else {
                    n12 = n11;
                    l11 = n12;
                    roomSQLiteQuery.bindLong(n14, l11);
                }
                if (n11 == null) {
                    roomSQLiteQuery.bindNull(n15);
                } else {
                    n14 = n11;
                    l11 = n14;
                    roomSQLiteQuery.bindLong(n15, l11);
                }
                this.__db.assertNotSuspendingTransaction();
                object = this.__db;
                n12 = 0;
                n10 = null;
                object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
                boolean bl3 = object.moveToFirst();
                if (!bl3) break block34;
                bl3 = object.isNull(0);
                if (!bl3) break block35;
            }
            l10 = object.getLong(0);
            number = l10;
        }
        return number;
        finally {
            object.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getTemplateCount_LiveData(Integer object, Integer stringArray, Integer n10, Boolean object2, String string2, Integer n11) {
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 12;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM TemplateData  WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = stringArray.intValue();
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = stringArray.intValue();
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        stringArray = null;
        if (object2 == null) {
            boolean n12 = false;
            n10 = null;
        } else {
            int n12 = ((Boolean)object2).booleanValue();
            n10 = n12;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            int n17 = n10;
            l11 = n17;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (object2 != null) {
            n13 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            stringArray = n13;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = stringArray.intValue();
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        n14 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        n14 = 11;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            long l13 = n14;
            roomSQLiteQuery.bindLong(n15, l13);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateData", "TemplateVideo"};
        object2 = new G_TemplateDataDao_Impl$24(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getTemplateCount_Observable(Integer object, Integer n10, Integer stringArray, Boolean object2, String string2, Integer n11) {
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 12;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM TemplateData  WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = (Integer)stringArray;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = (Integer)stringArray;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (object2 == null) {
            boolean n12 = false;
            stringArray = null;
        } else {
            int n12 = ((Boolean)object2).booleanValue();
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            int n17 = (Integer)stringArray;
            l11 = n17;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (object2 != null) {
            n13 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            n10 = n13;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        n14 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        n14 = 11;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            long l13 = n14;
            roomSQLiteQuery.bindLong(n15, l13);
        }
        object = this.__db;
        stringArray = new String[]{"TemplateData", "TemplateVideo"};
        object2 = new G_TemplateDataDao_Impl$25(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])stringArray, (Callable)object2);
    }

    public i0 getTemplateCount_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2, Integer n12) {
        int n13;
        long l10;
        int n14;
        long l11;
        int n15;
        long l12;
        int n16 = 12;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM TemplateData  WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  AND  (? IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= ?)) ", n16);
        int n17 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            int n18 = (Integer)object;
            l12 = n18;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n17 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            n15 = (Integer)object;
            l12 = n15;
            roomSQLiteQuery.bindLong(n17, l12);
        }
        n15 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n17 = n10;
            l11 = n17;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n10;
            l11 = n14;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            l11 = n14;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n11;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 7;
        n14 = 0;
        n10 = null;
        if (bl2 == null) {
            n13 = 0;
            n11 = null;
        } else {
            n13 = bl2.booleanValue();
            n11 = n13;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n15, l11);
        }
        n15 = 8;
        if (bl2 != null) {
            n14 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n14;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n10;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        n15 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        n15 = 10;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        n15 = 11;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n14 = n12;
            l10 = n14;
            roomSQLiteQuery.bindLong(n15, l10);
        }
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n12;
            long l13 = n15;
            roomSQLiteQuery.bindLong(n16, l13);
        }
        object = new G_TemplateDataDao_Impl$23(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public List getTemplateData(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        long l10;
        Object object;
        int n13;
        long l11;
        boolean bl3;
        int n14;
        Object object2 = this;
        Object object3 = string2;
        int bl4 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", bl4);
        boolean bl5 = true;
        if (n10 == null) {
            roomSQLiteQuery.bindNull((int)(bl5 ? 1 : 0));
        } else {
            n14 = n10;
            long l12 = n14;
            roomSQLiteQuery.bindLong((int)(bl5 ? 1 : 0), l12);
        }
        n14 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            bl3 = n10.intValue();
            l11 = (long)bl3;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            bl3 = n11.intValue();
            l11 = (long)bl3;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            bl3 = n11.intValue();
            l11 = (long)bl3;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            bl3 = n12.intValue();
            l11 = (long)bl3;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            bl3 = n12.intValue();
            l11 = (long)bl3;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 7;
        bl3 = false;
        Object object4 = null;
        if (bl2 == null) {
            n13 = 0;
            object = null;
        } else {
            n13 = bl2.booleanValue();
            object = n13;
        }
        if (object == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = (Integer)object;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 8;
        if (bl2 == null) {
            n13 = 0;
            object = null;
        } else {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            object = n13;
        }
        if (object == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = (Integer)object;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (object3 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, (String)object3);
        }
        if (object3 == null) {
            roomSQLiteQuery.bindNull(bl4);
        } else {
            roomSQLiteQuery.bindString(bl4, (String)object3);
        }
        ((G_TemplateDataDao_Impl)object2).__db.assertNotSuspendingTransaction();
        object3 = ((G_TemplateDataDao_Impl)object2).__db;
        boolean bl6 = false;
        String string3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object3, roomSQLiteQuery, false, null);
        object3 = "id";
        try {
            boolean bl7 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "title_zh";
            n13 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            String string4 = "title_tw";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "title_en";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "cover_url";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "video_url";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "video_time";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "video_count";
            boolean bl8 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            ArrayList<Object> arrayList = "video_ratio";
            boolean bl9 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
            String string10 = "res_size";
            boolean bl10 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            string3 = "is_prime_usable";
            boolean bl11 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string11 = "temp_type";
            bl5 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            object4 = "download_finished";
            bl3 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object4);
            object2 = "download_timestamp";
            boolean bl12 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            return bl12;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplateDataIds(Integer object, Integer n10, Integer n11, Boolean serializable, String object2) {
        int n12;
        int n13;
        long l10;
        int n14;
        long l11;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT TemplateData.id FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l11 = n17;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l11 = n14;
            roomSQLiteQuery.bindLong(n16, l11);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l10 = n16;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            long l12 = n13;
            roomSQLiteQuery.bindLong(n14, l12);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (serializable == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = ((Boolean)serializable).booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l10 = n12;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 8;
        if (serializable == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = (int)(((Boolean)serializable).booleanValue() ? 1 : 0);
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            long l13 = n12;
            roomSQLiteQuery.bindLong(n14, l13);
        }
        n14 = 9;
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, (String)object2);
        }
        if (object2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, (String)object2);
        }
        this.__db.assertNotSuspendingTransaction();
        object = this.__db;
        n12 = 0;
        n11 = null;
        object = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        try {
            int n18 = object.getCount();
            serializable = new ArrayList(n18);
            while ((n18 = (int)(object.moveToNext() ? 1 : 0)) != 0) {
                n18 = (int)(object.isNull(0) ? 1 : 0);
                if (n18 != 0) {
                    n18 = 0;
                    object2 = null;
                } else {
                    long l14 = object.getLong(0);
                    object2 = l14;
                }
                serializable.add(object2);
            }
            return serializable;
        }
        finally {
            object.close();
            roomSQLiteQuery.release();
        }
    }

    public LiveData getTemplateDataIds_LiveData(Integer object, Integer stringArray, Integer n10, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT TemplateData.id FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = stringArray.intValue();
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        stringArray = null;
        if (object2 == null) {
            boolean n11 = false;
            n10 = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            n10 = n11;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateData"};
        object2 = new G_TemplateDataDao_Impl$33(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getTemplateDataIds_Observable(Integer object, Integer n10, Integer stringArray, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT TemplateData.id FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = n10;
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        n10 = null;
        if (object2 == null) {
            boolean n11 = false;
            stringArray = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            stringArray = n11;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = (Integer)stringArray;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            n10 = n12;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db;
        stringArray = new String[]{"TemplateData"};
        object2 = new G_TemplateDataDao_Impl$34(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])stringArray, (Callable)object2);
    }

    public i0 getTemplateDataIds_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2) {
        int n12;
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT TemplateData.id FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (bl2 == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = bl2.booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l11 = n12;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (bl2 != null) {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n13;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        object = new G_TemplateDataDao_Impl$32(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getTemplateData_LiveData(Integer object, Integer stringArray, Integer n10, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = stringArray.intValue();
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        stringArray = null;
        if (object2 == null) {
            boolean n11 = false;
            n10 = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            n10 = n11;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            stringArray = n12;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = stringArray.intValue();
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db.getInvalidationTracker();
        stringArray = new String[]{"TemplateData"};
        object2 = new G_TemplateDataDao_Impl$12(this, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, false, (Callable)object2);
    }

    public z getTemplateData_Observable(Integer object, Integer n10, Integer stringArray, Boolean object2, String string2) {
        long l10;
        int n12;
        long l11;
        int n13;
        long l12;
        int n14 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n14);
        int n15 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            int n16 = (Integer)object;
            l12 = n16;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n15 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            n13 = (Integer)object;
            l12 = n13;
            roomSQLiteQuery.bindLong(n15, l12);
        }
        n13 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n15 = n10;
            l11 = n15;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 5;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l11 = n12;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 6;
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = (Integer)stringArray;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 7;
        n12 = 0;
        n10 = null;
        if (object2 == null) {
            boolean n11 = false;
            stringArray = null;
        } else {
            int n11 = ((Boolean)object2).booleanValue();
            stringArray = n11;
        }
        if (stringArray == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            int n16 = (Integer)stringArray;
            l11 = n16;
            roomSQLiteQuery.bindLong(n13, l11);
        }
        n13 = 8;
        if (object2 != null) {
            n12 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            n10 = n12;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            n12 = n10;
            l10 = n12;
            roomSQLiteQuery.bindLong(n13, l10);
        }
        n13 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n13);
        } else {
            roomSQLiteQuery.bindString(n13, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        object = this.__db;
        stringArray = new String[]{"TemplateData"};
        object2 = new G_TemplateDataDao_Impl$13(this, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, false, (String[])stringArray, (Callable)object2);
    }

    public i0 getTemplateData_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2) {
        int n12;
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (bl2 == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = bl2.booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l11 = n12;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (bl2 != null) {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n13;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        object = new G_TemplateDataDao_Impl$11(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplatePOJO(Integer n10, Integer object, Integer n11, Boolean bl2, String string2) {
        void var7_14;
        Object arrayList2;
        block38: {
            Cursor cursor;
            long l10;
            Object object2;
            long l11;
            G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
            Object arrayList = string2;
            int n12 = 10;
            arrayList2 = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n12);
            boolean bl6 = true;
            if (n10 == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull((int)(bl6 ? 1 : 0));
            } else {
                int bl5 = n10;
                long l12 = bl5;
                ((RoomSQLiteQuery)arrayList2).bindLong((int)(bl6 ? 1 : 0), l12);
            }
            int n13 = 2;
            if (n10 == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n13);
            } else {
                int n14 = n10;
                l11 = n14;
                ((RoomSQLiteQuery)arrayList2).bindLong(n13, l11);
            }
            int n15 = 3;
            if (object == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n15);
            } else {
                int n16 = (Integer)object;
                l11 = n16;
                ((RoomSQLiteQuery)arrayList2).bindLong(n15, l11);
            }
            int n17 = 4;
            if (object == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n17);
            } else {
                int n18 = (Integer)object;
                l11 = n18;
                ((RoomSQLiteQuery)arrayList2).bindLong(n17, l11);
            }
            int n19 = 5;
            if (n11 == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n19);
            } else {
                int n20 = n11;
                l11 = n20;
                ((RoomSQLiteQuery)arrayList2).bindLong(n19, l11);
            }
            int n21 = 6;
            if (n11 == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n21);
            } else {
                int n22 = n11;
                l11 = n22;
                ((RoomSQLiteQuery)arrayList2).bindLong(n21, l11);
            }
            int n23 = 7;
            boolean bl3 = false;
            Object object3 = null;
            if (bl2 == null) {
                boolean bl4 = false;
                object2 = null;
            } else {
                int n24 = bl2.booleanValue();
                object2 = n24;
            }
            if (object2 == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n23);
            } else {
                int n25 = (Integer)object2;
                l10 = n25;
                ((RoomSQLiteQuery)arrayList2).bindLong(n23, l10);
            }
            int n26 = 8;
            if (bl2 == null) {
                boolean bl5 = false;
                object2 = null;
            } else {
                int n27 = bl2.booleanValue();
                object2 = n27;
            }
            if (object2 == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n26);
            } else {
                int n28 = (Integer)object2;
                l10 = n28;
                ((RoomSQLiteQuery)arrayList2).bindLong(n26, l10);
            }
            int n29 = 9;
            if (arrayList == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n29);
            } else {
                ((RoomSQLiteQuery)arrayList2).bindString(n29, (String)arrayList);
            }
            if (arrayList == null) {
                ((RoomSQLiteQuery)arrayList2).bindNull(n12);
            } else {
                ((RoomSQLiteQuery)arrayList2).bindString(n12, (String)arrayList);
            }
            g_TemplateDataDao_Impl.__db.assertNotSuspendingTransaction();
            arrayList = g_TemplateDataDao_Impl.__db;
            ((RoomDatabase)arrayList).beginTransaction();
            try {
                arrayList = g_TemplateDataDao_Impl.__db;
                cursor = DBUtil.query((RoomDatabase)arrayList, (SupportSQLiteQuery)arrayList2, bl6, null);
                arrayList = "id";
            }
            catch (Throwable throwable) {
                arrayList2 = g_TemplateDataDao_Impl;
                break block38;
            }
            try {
                int n30 = CursorUtil.getColumnIndexOrThrow(cursor, (String)arrayList);
                ArrayList<Object> arrayList3 = "title_zh";
                int n31 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList3));
                object2 = "title_tw";
                int n32 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
                String string3 = "title_en";
                boolean bl7 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
                String arrayList4 = "cover_url";
                boolean bl8 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList4);
                String arrayList5 = "video_url";
                boolean bl9 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList5);
                String arrayList6 = "video_time";
                boolean bl10 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList6);
                String arrayList7 = "video_count";
                boolean bl11 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList7);
                String arrayList8 = "video_ratio";
                boolean bl12 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList8);
                String arrayList9 = "res_size";
                boolean bl13 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList9);
                String arrayList10 = "is_prime_usable";
                boolean bl14 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList10);
                String arrayList11 = "temp_type";
                bl6 = CursorUtil.getColumnIndexOrThrow(cursor, arrayList11);
                object3 = "download_finished";
                boolean bl15 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
                return bl15;
            }
            finally {
                Object arrayList12 = arrayList2;
            }
        }
        ((G_TemplateDataDao_Impl)arrayList2).__db.endTransaction();
        throw var7_14;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getTemplatePOJO(List list) {
        void var3_10;
        Object arrayList3;
        block17: {
            Object object;
            Long l10;
            boolean bl2;
            boolean n10;
            G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
            Object arrayList = StringUtil.newStringBuilder();
            ((StringBuilder)arrayList).append("SELECT * FROM TemplateData WHERE id IN (");
            boolean n11 = list.size();
            StringUtil.appendPlaceholders((StringBuilder)arrayList, (int)(n11 ? 1 : 0));
            ((StringBuilder)arrayList).append(")");
            arrayList = ((StringBuilder)arrayList).toString();
            boolean n12 = false;
            Object arrayList2 = null;
            arrayList3 = RoomSQLiteQuery.acquire((String)arrayList, (int)((n11 += 0) ? 1 : 0));
            arrayList = list.iterator();
            boolean n13 = n10 = true;
            while (bl2 = arrayList.hasNext()) {
                l10 = (Long)arrayList.next();
                if (l10 == null) {
                    ((RoomSQLiteQuery)arrayList3).bindNull((int)(n13 ? 1 : 0));
                } else {
                    long l11 = l10;
                    ((RoomSQLiteQuery)arrayList3).bindLong((int)(n13 ? 1 : 0), l11);
                }
                n13 += 1;
            }
            g_TemplateDataDao_Impl.__db.assertNotSuspendingTransaction();
            arrayList = g_TemplateDataDao_Impl.__db;
            ((RoomDatabase)arrayList).beginTransaction();
            try {
                arrayList = g_TemplateDataDao_Impl.__db;
                n13 = false;
                object = null;
                l10 = DBUtil.query((RoomDatabase)arrayList, (SupportSQLiteQuery)arrayList3, n10, null);
                arrayList = "id";
            }
            catch (Throwable throwable) {
                arrayList3 = g_TemplateDataDao_Impl;
                break block17;
            }
            try {
                int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, (String)arrayList);
                ArrayList<Object> arrayList4 = "title_zh";
                boolean n15 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, (String)((Object)arrayList4));
                String string2 = "title_tw";
                boolean n16 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, string2);
                String string3 = "title_en";
                boolean n17 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, string3);
                String arrayList5 = "cover_url";
                boolean n18 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList5);
                String arrayList6 = "video_url";
                boolean n19 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList6);
                String arrayList7 = "video_time";
                boolean n20 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList7);
                String arrayList8 = "video_count";
                boolean n21 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList8);
                String arrayList9 = "video_ratio";
                boolean n22 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList9);
                String arrayList10 = "res_size";
                boolean n23 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList10);
                arrayList2 = "is_prime_usable";
                n12 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, (String)arrayList2);
                String arrayList11 = "temp_type";
                n10 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, arrayList11);
                object = "download_finished";
                n13 = CursorUtil.getColumnIndexOrThrow((Cursor)l10, (String)object);
                return n13;
            }
            finally {
                Object arrayList12 = arrayList3;
            }
        }
        ((G_TemplateDataDao_Impl)arrayList3).__db.endTransaction();
        throw var3_10;
    }

    public LiveData getTemplatePOJO_LiveData(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        Integer n13;
        int n14;
        long l10;
        int n15;
        int n16;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = string2;
        int n17 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n17);
        boolean bl3 = true;
        if (n10 == null) {
            roomSQLiteQuery.bindNull((int)(bl3 ? 1 : 0));
        } else {
            n16 = n10;
            long l11 = n16;
            roomSQLiteQuery.bindLong((int)(bl3 ? 1 : 0), l11);
        }
        n16 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n10;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n11;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n11;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n12;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n12;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 7;
        n15 = 0;
        Integer n18 = null;
        if (bl2 == null) {
            n14 = 0;
            n13 = null;
        } else {
            n14 = bl2.booleanValue();
            n13 = n14;
        }
        if (n13 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n13;
            long l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 8;
        if (bl2 != null) {
            n15 = (int)(bl2.booleanValue() ? 1 : 0);
            n18 = n15;
        }
        if (n18 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n18;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 9;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            roomSQLiteQuery.bindString(n16, (String)object);
        }
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)object);
        }
        object = g_TemplateDataDao_Impl.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$30 g_TemplateDataDao_Impl$30 = new G_TemplateDataDao_Impl$30(g_TemplateDataDao_Impl, roomSQLiteQuery);
        return ((InvalidationTracker)object).createLiveData(stringArray, bl3, g_TemplateDataDao_Impl$30);
    }

    public LiveData getTemplatePOJO_LiveData(List list) {
        Object object;
        boolean bl2;
        boolean bl3;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("SELECT * FROM TemplateData WHERE id IN (");
        int n10 = list.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        String string2 = ")";
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object2 = RoomSQLiteQuery.acquire((String)object2, n10 += 0);
        Object object3 = list.iterator();
        boolean bl4 = bl3 = true;
        while (bl2 = object3.hasNext()) {
            object = (Long)object3.next();
            if (object == null) {
                ((RoomSQLiteQuery)object2).bindNull((int)(bl4 ? 1 : 0));
            } else {
                long l10 = (Long)object;
                ((RoomSQLiteQuery)object2).bindLong((int)(bl4 ? 1 : 0), l10);
            }
            bl4 += 1;
        }
        object3 = g_TemplateDataDao_Impl.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        object = new G_TemplateDataDao_Impl$42(g_TemplateDataDao_Impl, (RoomSQLiteQuery)object2);
        return ((InvalidationTracker)object3).createLiveData(stringArray, bl3, (Callable)object);
    }

    public z getTemplatePOJO_Observable(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        Integer n13;
        int n14;
        long l10;
        int n15;
        int n16;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object = string2;
        int n17 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n17);
        boolean bl3 = true;
        if (n10 == null) {
            roomSQLiteQuery.bindNull((int)(bl3 ? 1 : 0));
        } else {
            n16 = n10;
            long l11 = n16;
            roomSQLiteQuery.bindLong((int)(bl3 ? 1 : 0), l11);
        }
        n16 = 2;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n10;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 3;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n11;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 4;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n11;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 5;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n12;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 6;
        if (n12 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n12;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 7;
        n15 = 0;
        Integer n18 = null;
        if (bl2 == null) {
            n14 = 0;
            n13 = null;
        } else {
            n14 = bl2.booleanValue();
            n13 = n14;
        }
        if (n13 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = n13;
            long l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 8;
        if (bl2 != null) {
            n15 = (int)(bl2.booleanValue() ? 1 : 0);
            n18 = n15;
        }
        if (n18 == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n15 = n18;
            l10 = n15;
            roomSQLiteQuery.bindLong(n16, l10);
        }
        n16 = 9;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            roomSQLiteQuery.bindString(n16, (String)object);
        }
        if (object == null) {
            roomSQLiteQuery.bindNull(n17);
        } else {
            roomSQLiteQuery.bindString(n17, (String)object);
        }
        object = g_TemplateDataDao_Impl.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$31 g_TemplateDataDao_Impl$31 = new G_TemplateDataDao_Impl$31(g_TemplateDataDao_Impl, roomSQLiteQuery);
        return RxRoom.createObservable((RoomDatabase)object, bl3, stringArray, g_TemplateDataDao_Impl$31);
    }

    public z getTemplatePOJO_Observable(List list) {
        Object object;
        boolean bl2;
        boolean bl3;
        G_TemplateDataDao_Impl g_TemplateDataDao_Impl = this;
        Object object2 = StringUtil.newStringBuilder();
        ((StringBuilder)object2).append("SELECT * FROM TemplateData WHERE id IN (");
        int n10 = list.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        String string2 = ")";
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object2 = RoomSQLiteQuery.acquire((String)object2, n10 += 0);
        Object object3 = list.iterator();
        boolean bl4 = bl3 = true;
        while (bl2 = object3.hasNext()) {
            object = (Long)object3.next();
            if (object == null) {
                ((RoomSQLiteQuery)object2).bindNull((int)(bl4 ? 1 : 0));
            } else {
                long l10 = (Long)object;
                ((RoomSQLiteQuery)object2).bindLong((int)(bl4 ? 1 : 0), l10);
            }
            bl4 += 1;
        }
        object3 = g_TemplateDataDao_Impl.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        object = new G_TemplateDataDao_Impl$43(g_TemplateDataDao_Impl, (RoomSQLiteQuery)object2);
        return RxRoom.createObservable((RoomDatabase)object3, bl3, stringArray, (Callable)object);
    }

    public i0 getTemplatePOJO_Single(Integer object, Integer n10, Integer n11, Boolean bl2, String string2) {
        int n12;
        long l10;
        int n13;
        long l11;
        int n14;
        long l12;
        int n15 = 10;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?)  ORDER BY id DESC", n15);
        int n16 = 1;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            int n17 = (Integer)object;
            l12 = n17;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n16 = 2;
        if (object == null) {
            roomSQLiteQuery.bindNull(n16);
        } else {
            n14 = (Integer)object;
            l12 = n14;
            roomSQLiteQuery.bindLong(n16, l12);
        }
        n14 = 3;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n16 = n10;
            l11 = n16;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 4;
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 5;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l11 = n13;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 6;
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n11;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 7;
        n13 = 0;
        n10 = null;
        if (bl2 == null) {
            n12 = 0;
            n11 = null;
        } else {
            n12 = bl2.booleanValue();
            n11 = n12;
        }
        if (n11 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n12 = n11;
            l11 = n12;
            roomSQLiteQuery.bindLong(n14, l11);
        }
        n14 = 8;
        if (bl2 != null) {
            n13 = (int)(bl2.booleanValue() ? 1 : 0);
            n10 = n13;
        }
        if (n10 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            n13 = n10;
            l10 = n13;
            roomSQLiteQuery.bindLong(n14, l10);
        }
        n14 = 9;
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n14);
        } else {
            roomSQLiteQuery.bindString(n14, string2);
        }
        if (string2 == null) {
            roomSQLiteQuery.bindNull(n15);
        } else {
            roomSQLiteQuery.bindString(n15, string2);
        }
        object = new G_TemplateDataDao_Impl$29(this, roomSQLiteQuery);
        return RxRoom.createSingle((Callable)object);
    }

    public i0 getTemplatePOJO_Single(List object) {
        boolean bl2;
        Object object2 = StringUtil.newStringBuilder();
        String string2 = "SELECT * FROM TemplateData WHERE id IN (";
        ((StringBuilder)object2).append(string2);
        int n10 = object.size();
        StringUtil.appendPlaceholders((StringBuilder)object2, n10);
        Object object3 = ")";
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object2 = RoomSQLiteQuery.acquire((String)object2, n10 += 0);
        object = object.iterator();
        n10 = 1;
        while (bl2 = object.hasNext()) {
            object3 = (Long)object.next();
            if (object3 == null) {
                ((RoomSQLiteQuery)object2).bindNull(n10);
            } else {
                long l10 = (Long)object3;
                ((RoomSQLiteQuery)object2).bindLong(n10, l10);
            }
            ++n10;
        }
        object = new G_TemplateDataDao_Impl$41(this, (RoomSQLiteQuery)object2);
        return RxRoom.createSingle((Callable)object);
    }

    public LiveData getTemplate_LiveData(long l10) {
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", (int)(bl2 ? 1 : 0));
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$45 g_TemplateDataDao_Impl$45 = new G_TemplateDataDao_Impl$45(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, bl2, g_TemplateDataDao_Impl$45);
    }

    public z getTemplate_Observable(long l10) {
        boolean bl2 = true;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", (int)(bl2 ? 1 : 0));
        roomSQLiteQuery.bindLong((int)(bl2 ? 1 : 0), l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$46 g_TemplateDataDao_Impl$46 = new G_TemplateDataDao_Impl$46(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, bl2, stringArray, g_TemplateDataDao_Impl$46);
    }

    public i0 getTemplate_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateDataDao_Impl$44 g_TemplateDataDao_Impl$44 = new G_TemplateDataDao_Impl$44(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateDataDao_Impl$44);
    }

    public long insert(TemplateData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateData_1;
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
            object = this.__insertionAdapterOfTemplateData_1;
            list = ((EntityInsertionAdapter)object).insertAndReturnIdsList(list);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return list;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long insertOrReplaceTemplateConfig(TemplatePOJO templatePOJO, boolean bl2, boolean bl3) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            long l10 = TemplateDataDao.super.insertOrReplaceTemplateConfig(templatePOJO, bl2, bl3);
            RoomDatabase roomDatabase2 = this.__db;
            roomDatabase2.setTransactionSuccessful();
            return l10;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public Pair insertOrUpdateAll(TemplatePOJO object, boolean bl2, boolean bl3) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            object = TemplateDataDao.super.insertOrUpdateAll((TemplatePOJO)object, bl2, bl3);
            RoomDatabase roomDatabase2 = this.__db;
            roomDatabase2.setTransactionSuccessful();
            return object;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public long insertOrUpdateTemplateIndex(TemplatePOJO templatePOJO, boolean bl2, boolean bl3, long l10) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            long l11 = TemplateDataDao.super.insertOrUpdateTemplateIndex(templatePOJO, bl2, bl3, l10);
            RoomDatabase roomDatabase2 = this.__db;
            roomDatabase2.setTransactionSuccessful();
            return l11;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public i0 insertSingle(List list) {
        G_TemplateDataDao_Impl$9 g_TemplateDataDao_Impl$9 = new G_TemplateDataDao_Impl$9(this, list);
        return i0.o0(g_TemplateDataDao_Impl$9);
    }

    public TemplateData loadTemplate(long l10) {
        Object object = this;
        int bl2 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", bl2);
        roomSQLiteQuery.bindLong(bl2, l10);
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        boolean bl3 = false;
        String string2 = null;
        int n10 = 0;
        Object object3 = null;
        Cursor cursor = DBUtil.query((RoomDatabase)object2, roomSQLiteQuery, false, null);
        object2 = "id";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
            String string3 = "title_zh";
            int n12 = CursorUtil.getColumnIndexOrThrow(cursor, string3);
            String string4 = "title_tw";
            int n13 = CursorUtil.getColumnIndexOrThrow(cursor, string4);
            String string5 = "title_en";
            int n14 = CursorUtil.getColumnIndexOrThrow(cursor, string5);
            String string6 = "cover_url";
            int n15 = CursorUtil.getColumnIndexOrThrow(cursor, string6);
            String string7 = "video_url";
            int n16 = CursorUtil.getColumnIndexOrThrow(cursor, string7);
            String string8 = "video_time";
            int n17 = CursorUtil.getColumnIndexOrThrow(cursor, string8);
            String string9 = "video_count";
            int n18 = CursorUtil.getColumnIndexOrThrow(cursor, string9);
            String string10 = "video_ratio";
            int n19 = CursorUtil.getColumnIndexOrThrow(cursor, string10);
            String string11 = "res_size";
            int n20 = CursorUtil.getColumnIndexOrThrow(cursor, string11);
            String string12 = "is_prime_usable";
            bl2 = CursorUtil.getColumnIndexOrThrow(cursor, string12);
            string2 = "temp_type";
            int n21 = CursorUtil.getColumnIndexOrThrow(cursor, string2);
            object3 = "download_finished";
            n10 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
            object = "download_timestamp";
            int n22 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
            return n22;
        }
        finally {
            RoomSQLiteQuery roomSQLiteQuery2 = roomSQLiteQuery;
        }
    }

    public LiveData loadTemplate_LiveData(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"TemplateData"};
        G_TemplateDataDao_Impl$18 g_TemplateDataDao_Impl$18 = new G_TemplateDataDao_Impl$18(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, false, g_TemplateDataDao_Impl$18);
    }

    public z loadTemplate_Observable(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"TemplateData"};
        G_TemplateDataDao_Impl$19 g_TemplateDataDao_Impl$19 = new G_TemplateDataDao_Impl$19(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, false, stringArray, g_TemplateDataDao_Impl$19);
    }

    public i0 loadTemplate_Single(long l10) {
        int n10 = 1;
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData WHERE id = ?", n10);
        roomSQLiteQuery.bindLong(n10, l10);
        G_TemplateDataDao_Impl$17 g_TemplateDataDao_Impl$17 = new G_TemplateDataDao_Impl$17(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateDataDao_Impl$17);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List queryAll() {
        void var5_12;
        Object object;
        block93: {
            RoomSQLiteQuery roomSQLiteQuery;
            Cursor cursor;
            Object object2;
            block92: {
                long l10;
                int n10;
                long l11;
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                int n16;
                int n17;
                int n18;
                int n19;
                int n20;
                int n21;
                int n22;
                int n23;
                int n24;
                int n25;
                int n26;
                int n27;
                int n28;
                int n29;
                int n30;
                int n31;
                int n32;
                int n33;
                int n34;
                Object object3;
                int n35;
                Object object4;
                int n36;
                Object object5;
                int n37;
                Object object6;
                int n38;
                Object object7;
                int n39;
                Object object8;
                int n40;
                Object object9;
                int n41;
                Object object10;
                int n42;
                Object object11;
                int n43;
                ArrayList<Object> arrayList;
                int n44;
                Object object12;
                int n45;
                int n46;
                Object object13;
                int n47;
                Object object14;
                block91: {
                    object14 = this;
                    n47 = 0;
                    object = null;
                    object13 = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData", 0);
                    this.__db.assertNotSuspendingTransaction();
                    object2 = this.__db;
                    ((RoomDatabase)object2).beginTransaction();
                    object2 = this.__db;
                    n46 = 1;
                    n45 = 0;
                    object12 = null;
                    cursor = DBUtil.query((RoomDatabase)object2, (SupportSQLiteQuery)object13, n46 != 0, null);
                    object2 = "id";
                    n44 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object2);
                    arrayList = "title_zh";
                    n43 = CursorUtil.getColumnIndexOrThrow(cursor, (String)((Object)arrayList));
                    object11 = "title_tw";
                    n42 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object11);
                    object10 = "title_en";
                    n41 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object10);
                    object9 = "cover_url";
                    n40 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object9);
                    object8 = "video_url";
                    n39 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object8);
                    object7 = "video_time";
                    n38 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object7);
                    object6 = "video_count";
                    n37 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object6);
                    object5 = "video_ratio";
                    n36 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object5);
                    object4 = "res_size";
                    n35 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object4);
                    object = "is_prime_usable";
                    n47 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object);
                    object3 = "temp_type";
                    n46 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object3);
                    object12 = "download_finished";
                    n45 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object12);
                    roomSQLiteQuery = object13;
                    object13 = "download_timestamp";
                    try {
                        n33 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "editor_template";
                        n32 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "track_editor_config_data";
                        n31 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "template_use_type";
                        n30 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "template_proto_type";
                        n29 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "first_loaded";
                        n28 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "template_description_zh";
                        n27 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "template_description_en";
                        n26 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "template_description_zh_tw";
                        n25 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "script_ext_status";
                        n24 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "script_ext_protocol";
                        n23 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = "script_ext_version";
                        n22 = n34 = CursorUtil.getColumnIndexOrThrow(cursor, (String)object13);
                        object13 = new LongSparseArray();
                        n21 = n45;
                        object12 = new LongSparseArray();
                        n20 = n46;
                        object3 = new LongSparseArray();
                        n19 = n47;
                        object = new LongSparseArray();
                        n18 = n35;
                        object4 = new LongSparseArray();
                        n17 = n36;
                        object5 = new LongSparseArray();
                        n16 = n37;
                        object6 = new LongSparseArray();
                        n15 = n38;
                        object7 = new LongSparseArray();
                        n14 = n39;
                        object8 = new LongSparseArray();
                        n13 = n40;
                        object9 = new LongSparseArray();
                        while ((n12 = cursor.moveToNext()) != 0) {
                            n12 = cursor.isNull(n44);
                            if (n12 == 0) {
                                n12 = n42;
                                n11 = n41;
                                l11 = cursor.getLong(n44);
                                n10 = n43;
                                n43 = 0;
                                arrayList = null;
                                ((LongSparseArray)object13).put(l11, null);
                            } else {
                                n10 = n43;
                                n12 = n42;
                                n11 = n41;
                            }
                            n43 = (int)(cursor.isNull(n44) ? 1 : 0);
                            if (n43 == 0) {
                                l10 = cursor.getLong(n44);
                                n41 = 0;
                                object10 = null;
                                ((LongSparseArray)object12).put(l10, null);
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                n41 = 0;
                                object10 = null;
                                ((LongSparseArray)object3).put(l10, null);
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                n41 = 0;
                                object10 = null;
                                ((LongSparseArray)object).put(l10, null);
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                n41 = 0;
                                object10 = null;
                                ((LongSparseArray)object4).put(l10, null);
                            } else {
                                n41 = 0;
                                object10 = null;
                            }
                            n43 = (int)(cursor.isNull(n44) ? 1 : 0);
                            if (n43 == 0) {
                                l10 = cursor.getLong(n44);
                                Object object15 = ((LongSparseArray)object5).get(l10);
                                if ((object15 = (ArrayList)object15) == null) {
                                    object10 = new ArrayList();
                                    ((LongSparseArray)object5).put(l10, object10);
                                }
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                object10 = ((LongSparseArray)object6).get(l10);
                                if ((object10 = (ArrayList)object10) == null) {
                                    object10 = new ArrayList();
                                    ((LongSparseArray)object6).put(l10, object10);
                                }
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                object10 = ((LongSparseArray)object7).get(l10);
                                if ((object10 = (ArrayList)object10) == null) {
                                    object10 = new ArrayList();
                                    ((LongSparseArray)object7).put(l10, object10);
                                }
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                object10 = ((LongSparseArray)object8).get(l10);
                                if ((object10 = (ArrayList)object10) == null) {
                                    object10 = new ArrayList();
                                    ((LongSparseArray)object8).put(l10, object10);
                                }
                            }
                            if ((n43 = (int)(cursor.isNull(n44) ? 1 : 0)) == 0) {
                                l10 = cursor.getLong(n44);
                                object10 = ((LongSparseArray)object9).get(l10);
                                if ((object10 = (ArrayList)object10) == null) {
                                    object10 = new ArrayList();
                                    ((LongSparseArray)object9).put(l10, object10);
                                }
                            }
                            n42 = n12;
                            n41 = n11;
                            n43 = n10;
                        }
                        n10 = n43;
                        n12 = n42;
                        n11 = n41;
                        n43 = -1;
                        cursor.moveToPosition(n43);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipTemplateAscomZhiyunEditortemplateDataDatabaseModelTemplateTemplate((LongSparseArray)object13);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipscriptAscomZhiyunEditortemplateDataDatabaseModelTrackScript((LongSparseArray)object12);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipdraftAscomZhiyunEditortemplateDataDatabaseModelDraftDraft((LongSparseArray)object3);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipwithdrawAscomZhiyunEditortemplateDataDatabaseModelDraftWithdraw((LongSparseArray)object);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipTemplateGlobalAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateGlobal((LongSparseArray)object4);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipTemplateVideoAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateVideo((LongSparseArray)object5);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipTemplateStickerAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateSticker((LongSparseArray)object6);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipTemplateMusicAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateMusic((LongSparseArray)object7);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshiptemplateRecordingAscomZhiyunEditortemplateDataDatabaseModelTemplateConfigTemplateRecording((LongSparseArray)object8);
                        ((G_TemplateDataDao_Impl)object14).__fetchRelationshipscriptTrackAscomZhiyunEditortemplateDataDatabaseModelTrackScriptTrackPOJO((LongSparseArray)object9);
                        n42 = cursor.getCount();
                        arrayList = new ArrayList<Object>(n42);
                        break block91;
                    }
                    catch (Throwable throwable) {
                        object = object14;
                        break block92;
                    }
                    catch (Throwable throwable) {
                        object = object14;
                        roomSQLiteQuery = object13;
                    }
                    break block92;
                    catch (Throwable throwable) {
                        object = object14;
                    }
                    break block93;
                }
                while ((n42 = (int)(cursor.moveToNext() ? 1 : 0)) != 0) {
                    try {
                        int n48;
                        Object object16;
                        Object object17;
                        Object object18;
                        Object object19;
                        Object object20;
                        Object object21;
                        int n49;
                        long l12;
                        int n50;
                        int n51;
                        Object object22;
                        Object object23;
                        Object object24;
                        Object object25;
                        Object object26;
                        ArrayList arrayList2;
                        ArrayList arrayList3;
                        ArrayList arrayList4;
                        ArrayList arrayList5;
                        ArrayList arrayList6;
                        ArrayList<Object> arrayList7;
                        int n52;
                        block119: {
                            String string2;
                            block118: {
                                block102: {
                                    block101: {
                                        block100: {
                                            block99: {
                                                block98: {
                                                    block97: {
                                                        block94: {
                                                            block95: {
                                                                block96: {
                                                                    block103: {
                                                                        block104: {
                                                                            block105: {
                                                                                block106: {
                                                                                    block117: {
                                                                                        block116: {
                                                                                            block115: {
                                                                                                block114: {
                                                                                                    block113: {
                                                                                                        block120: {
                                                                                                            block107: {
                                                                                                                block108: {
                                                                                                                    block109: {
                                                                                                                        block110: {
                                                                                                                            block111: {
                                                                                                                                block112: {
                                                                                                                                    n42 = (int)(cursor.isNull(n44) ? 1 : 0);
                                                                                                                                    if (n42 == 0) break block94;
                                                                                                                                    n42 = n10;
                                                                                                                                    n41 = (int)(cursor.isNull(n10) ? 1 : 0);
                                                                                                                                    if (n41 == 0) break block95;
                                                                                                                                    n41 = n12;
                                                                                                                                    if ((n12 = (int)(cursor.isNull(n12) ? 1 : 0)) == 0) break block96;
                                                                                                                                    n52 = n11;
                                                                                                                                    n12 = (int)(cursor.isNull(n11) ? 1 : 0);
                                                                                                                                    if (n12 == 0) break block97;
                                                                                                                                    arrayList7 = arrayList;
                                                                                                                                    n43 = n13;
                                                                                                                                    if ((n13 = (int)(cursor.isNull(n13) ? 1 : 0)) == 0) break block98;
                                                                                                                                    arrayList6 = object9;
                                                                                                                                    n40 = n14;
                                                                                                                                    if ((n14 = (int)(cursor.isNull(n14) ? 1 : 0)) == 0) break block99;
                                                                                                                                    arrayList5 = object8;
                                                                                                                                    n39 = n15;
                                                                                                                                    if ((n15 = (int)(cursor.isNull(n15) ? 1 : 0)) == 0) break block100;
                                                                                                                                    arrayList4 = object7;
                                                                                                                                    n38 = n16;
                                                                                                                                    if ((n16 = (int)(cursor.isNull(n16) ? 1 : 0)) == 0) break block101;
                                                                                                                                    arrayList3 = object6;
                                                                                                                                    n37 = n17;
                                                                                                                                    if ((n17 = (int)(cursor.isNull(n17) ? 1 : 0)) == 0) break block102;
                                                                                                                                    arrayList2 = object5;
                                                                                                                                    n36 = n18;
                                                                                                                                    if ((n18 = (int)(cursor.isNull(n18) ? 1 : 0)) == 0) break block103;
                                                                                                                                    object26 = object4;
                                                                                                                                    n35 = n19;
                                                                                                                                    if ((n19 = (int)(cursor.isNull(n19) ? 1 : 0)) == 0) break block104;
                                                                                                                                    object25 = object;
                                                                                                                                    n47 = n20;
                                                                                                                                    if ((n20 = (int)(cursor.isNull(n20) ? 1 : 0)) == 0) break block105;
                                                                                                                                    object24 = object3;
                                                                                                                                    n46 = n21;
                                                                                                                                    if ((n21 = (int)(cursor.isNull(n21) ? 1 : 0)) == 0) break block106;
                                                                                                                                    object23 = object12;
                                                                                                                                    n45 = n33;
                                                                                                                                    if ((n33 = (int)(cursor.isNull(n33) ? 1 : 0)) == 0) break block107;
                                                                                                                                    object22 = object13;
                                                                                                                                    n34 = n32;
                                                                                                                                    if ((n32 = (int)(cursor.isNull(n32) ? 1 : 0)) == 0) break block108;
                                                                                                                                    n32 = n34;
                                                                                                                                    n34 = n31;
                                                                                                                                    if ((n31 = (int)(cursor.isNull(n31) ? 1 : 0)) == 0) break block109;
                                                                                                                                    n31 = n34;
                                                                                                                                    n34 = n30;
                                                                                                                                    if ((n30 = (int)(cursor.isNull(n30) ? 1 : 0)) == 0) break block110;
                                                                                                                                    n30 = n34;
                                                                                                                                    n34 = n29;
                                                                                                                                    if ((n29 = (int)(cursor.isNull(n29) ? 1 : 0)) == 0) break block111;
                                                                                                                                    n29 = n34;
                                                                                                                                    n34 = n28;
                                                                                                                                    if ((n28 = (int)(cursor.isNull(n28) ? 1 : 0)) == 0) break block112;
                                                                                                                                    n28 = n34;
                                                                                                                                    n34 = n27;
                                                                                                                                    if ((n27 = (int)(cursor.isNull(n27) ? 1 : 0)) == 0) break block113;
                                                                                                                                    n27 = n45;
                                                                                                                                    n45 = n26;
                                                                                                                                    if ((n26 = (int)(cursor.isNull(n26) ? 1 : 0)) == 0) break block114;
                                                                                                                                    n26 = n46;
                                                                                                                                    n46 = n25;
                                                                                                                                    if ((n25 = (int)(cursor.isNull(n25) ? 1 : 0)) == 0) break block115;
                                                                                                                                    n25 = n47;
                                                                                                                                    n47 = n24;
                                                                                                                                    if ((n24 = (int)(cursor.isNull(n24) ? 1 : 0)) == 0) break block116;
                                                                                                                                    n24 = n35;
                                                                                                                                    n35 = n23;
                                                                                                                                    if ((n23 = (int)(cursor.isNull(n23) ? 1 : 0)) == 0) break block117;
                                                                                                                                    n23 = n36;
                                                                                                                                    n36 = n22;
                                                                                                                                    if ((n22 = (int)(cursor.isNull(n22) ? 1 : 0)) == 0) break block118;
                                                                                                                                    n11 = n34;
                                                                                                                                    n51 = n46;
                                                                                                                                    n10 = n45;
                                                                                                                                    n50 = n36;
                                                                                                                                    n45 = n35;
                                                                                                                                    n22 = n27;
                                                                                                                                    n35 = n23;
                                                                                                                                    n46 = 0;
                                                                                                                                    object3 = null;
                                                                                                                                    n23 = n52;
                                                                                                                                    n36 = n37;
                                                                                                                                    n27 = n32;
                                                                                                                                    n32 = n26;
                                                                                                                                    n26 = n25;
                                                                                                                                    n25 = n47;
                                                                                                                                    n47 = n29;
                                                                                                                                    break block119;
                                                                                                                                }
                                                                                                                                n28 = n34;
                                                                                                                                break block120;
                                                                                                                            }
                                                                                                                            n29 = n34;
                                                                                                                            break block120;
                                                                                                                        }
                                                                                                                        n30 = n34;
                                                                                                                        break block120;
                                                                                                                    }
                                                                                                                    n31 = n34;
                                                                                                                    break block120;
                                                                                                                }
                                                                                                                n32 = n34;
                                                                                                                break block120;
                                                                                                            }
                                                                                                            object22 = object13;
                                                                                                        }
                                                                                                        n34 = n27;
                                                                                                    }
                                                                                                    n27 = n45;
                                                                                                    n45 = n26;
                                                                                                }
                                                                                                n26 = n46;
                                                                                                n46 = n25;
                                                                                            }
                                                                                            n25 = n47;
                                                                                            n47 = n24;
                                                                                        }
                                                                                        n24 = n35;
                                                                                        n35 = n23;
                                                                                    }
                                                                                    n23 = n36;
                                                                                    n36 = n22;
                                                                                    break block118;
                                                                                }
                                                                                object23 = object12;
                                                                                n45 = n26;
                                                                                n26 = n46;
                                                                                n46 = n25;
                                                                                n25 = n47;
                                                                                n47 = n24;
                                                                                n24 = n35;
                                                                                n35 = n23;
                                                                                n23 = n36;
                                                                                n36 = n22;
                                                                                object22 = object13;
                                                                                n34 = n27;
                                                                                n27 = n33;
                                                                                break block118;
                                                                            }
                                                                            object24 = object3;
                                                                            n46 = n25;
                                                                            n25 = n47;
                                                                            n47 = n24;
                                                                            n24 = n35;
                                                                            n35 = n23;
                                                                            n23 = n36;
                                                                            n36 = n22;
                                                                            object22 = object13;
                                                                            n34 = n27;
                                                                            n27 = n33;
                                                                            object23 = object12;
                                                                            n45 = n26;
                                                                            n26 = n21;
                                                                            break block118;
                                                                        }
                                                                        object25 = object;
                                                                        n47 = n24;
                                                                        n24 = n35;
                                                                        n35 = n23;
                                                                        n23 = n36;
                                                                        n36 = n22;
                                                                        object22 = object13;
                                                                        n34 = n27;
                                                                        n27 = n33;
                                                                        object24 = object3;
                                                                        n46 = n25;
                                                                        n25 = n20;
                                                                        object23 = object12;
                                                                        n45 = n26;
                                                                        n26 = n21;
                                                                        break block118;
                                                                    }
                                                                    object26 = object4;
                                                                    n35 = n23;
                                                                    n23 = n36;
                                                                    n36 = n22;
                                                                    object25 = object;
                                                                    n47 = n24;
                                                                    n24 = n19;
                                                                    object22 = object13;
                                                                    n34 = n27;
                                                                    n27 = n33;
                                                                    object24 = object3;
                                                                    n46 = n25;
                                                                    n25 = n20;
                                                                    object23 = object12;
                                                                    n45 = n26;
                                                                    n26 = n21;
                                                                    break block118;
                                                                }
                                                                arrayList7 = arrayList;
                                                                n43 = n13;
                                                                n52 = n11;
                                                                break block98;
                                                            }
                                                            n41 = n12;
                                                            n52 = n11;
                                                            break block97;
                                                        }
                                                        n41 = n12;
                                                        n52 = n11;
                                                        n42 = n10;
                                                    }
                                                    arrayList7 = arrayList;
                                                    n43 = n13;
                                                }
                                                arrayList6 = object9;
                                                n40 = n14;
                                            }
                                            arrayList5 = object8;
                                            n39 = n15;
                                        }
                                        arrayList4 = object7;
                                        n38 = n16;
                                    }
                                    arrayList3 = object6;
                                    n37 = n17;
                                }
                                arrayList2 = object5;
                                n36 = n22;
                                object25 = object;
                                n47 = n24;
                                n24 = n19;
                                object22 = object13;
                                n34 = n27;
                                n27 = n33;
                                object24 = object3;
                                n46 = n25;
                                n25 = n20;
                                object23 = object12;
                                n45 = n26;
                                n26 = n21;
                                object26 = object4;
                                n35 = n23;
                                n23 = n18;
                            }
                            n22 = (int)(cursor.isNull(n34) ? 1 : 0);
                            if (n22 != 0 && (n22 = (int)(cursor.isNull(n45) ? 1 : 0)) != 0 && (n22 = (int)(cursor.isNull(n46) ? 1 : 0)) != 0) {
                                n11 = n34;
                                n51 = n46;
                                n10 = n45;
                                n22 = n37;
                                n37 = 0;
                                object6 = null;
                            } else {
                                String string3;
                                n22 = (int)(cursor.isNull(n34) ? 1 : 0);
                                if (n22 != 0) {
                                    n11 = n34;
                                    n34 = 0;
                                    object13 = null;
                                } else {
                                    string3 = cursor.getString(n34);
                                    n11 = n34;
                                    object13 = string3;
                                }
                                n22 = (int)(cursor.isNull(n45) ? 1 : 0);
                                if (n22 != 0) {
                                    n10 = n45;
                                    n45 = 0;
                                    object12 = null;
                                } else {
                                    string3 = cursor.getString(n45);
                                    n10 = n45;
                                    object12 = string3;
                                }
                                n22 = (int)(cursor.isNull(n46) ? 1 : 0);
                                if (n22 != 0) {
                                    n51 = n46;
                                    n22 = n37;
                                    n46 = 0;
                                    object3 = null;
                                } else {
                                    string3 = cursor.getString(n46);
                                    n51 = n46;
                                    object3 = string3;
                                    n22 = n37;
                                }
                                object6 = new TemplateDescription((String)object13, (String)object12, (String)object3);
                            }
                            n34 = (int)(cursor.isNull(n47) ? 1 : 0);
                            if (n34 != 0 && (n34 = (int)(cursor.isNull(n35) ? 1 : 0)) != 0 && (n34 = (int)(cursor.isNull(n36) ? 1 : 0)) != 0) {
                                n34 = 0;
                                object13 = null;
                            } else {
                                n34 = cursor.getInt(n47);
                                n46 = cursor.getInt(n35);
                                n45 = cursor.getInt(n36);
                                object13 = ScriptDataExt.create(n34, n46, n45);
                            }
                            object3 = new TemplateData();
                            n50 = n36;
                            n45 = n35;
                            l12 = cursor.getLong(n44);
                            ((TemplateData)object3).setId(l12);
                            n36 = (int)(cursor.isNull(n42) ? 1 : 0);
                            if (n36 != 0) {
                                n36 = 0;
                                object5 = null;
                            } else {
                                object5 = cursor.getString(n42);
                            }
                            ((TemplateData)object3).setTextZh((String)object5);
                            n36 = (int)(cursor.isNull(n41) ? 1 : 0);
                            if (n36 != 0) {
                                n36 = 0;
                                object5 = null;
                            } else {
                                object5 = cursor.getString(n41);
                            }
                            ((TemplateData)object3).setTextZhTw((String)object5);
                            n36 = (int)(cursor.isNull(n52) ? 1 : 0);
                            if (n36 != 0) {
                                n36 = 0;
                                object5 = null;
                            } else {
                                object5 = cursor.getString(n52);
                            }
                            ((TemplateData)object3).setTextEn((String)object5);
                            n36 = (int)(cursor.isNull(n43) ? 1 : 0);
                            if (n36 != 0) {
                                n36 = 0;
                                object5 = null;
                            } else {
                                object5 = cursor.getString(n43);
                            }
                            ((TemplateData)object3).setCoverUrl((String)object5);
                            n36 = (int)(cursor.isNull(n40) ? 1 : 0);
                            if (n36 != 0) {
                                n36 = 0;
                                object5 = null;
                            } else {
                                object5 = cursor.getString(n40);
                            }
                            ((TemplateData)object3).setVideoUrl((String)object5);
                            double d10 = cursor.getDouble(n39);
                            ((TemplateData)object3).setVideoTime(d10);
                            n36 = cursor.getInt(n38);
                            ((TemplateData)object3).setVideoCount(n36);
                            n36 = n22;
                            n35 = (int)(cursor.isNull(n22) ? 1 : 0);
                            if (n35 != 0) {
                                n35 = 0;
                                object4 = null;
                            } else {
                                object4 = cursor.getString(n22);
                            }
                            ((TemplateData)object3).setVideoRatio((String)object4);
                            n35 = n23;
                            n23 = n52;
                            n52 = cursor.getInt(n35);
                            ((TemplateData)object3).setResSize(n52);
                            n52 = n24;
                            n24 = cursor.getInt(n24);
                            if (n24 != 0) {
                                n24 = n52;
                                n52 = 1;
                            } else {
                                n24 = n52;
                                n52 = 0;
                                object14 = null;
                            }
                            ((TemplateData)object3).setPrimeUsable(n52 != 0);
                            n52 = n25;
                            n25 = n47;
                            n47 = cursor.getInt(n52);
                            ((TemplateData)object3).setTempType(n47);
                            n47 = n26;
                            n26 = cursor.getInt(n26);
                            if (n26 != 0) {
                                n26 = n52;
                                n52 = 1;
                            } else {
                                n26 = n52;
                                n52 = 0;
                                object14 = null;
                            }
                            ((TemplateData)object3).setDownloadFinished(n52 != 0);
                            n52 = n27;
                            n27 = (int)(cursor.isNull(n27) ? 1 : 0);
                            if (n27 != 0) {
                                n22 = n52;
                                n52 = 0;
                                object14 = null;
                            } else {
                                long l13 = cursor.getLong(n52);
                                Long l14 = l13;
                                n22 = n52;
                                object14 = l14;
                            }
                            ((TemplateData)object3).setDownloadTimestamp((Long)object14);
                            n52 = n32;
                            n32 = (int)(cursor.isNull(n32) ? 1 : 0);
                            if (n32 != 0) {
                                n27 = n52;
                                n52 = 0;
                                object14 = null;
                            } else {
                                string2 = cursor.getString(n52);
                                n27 = n52;
                                object14 = string2;
                            }
                            ((TemplateData)object3).setEditorTemplate((String)object14);
                            n52 = n31;
                            n32 = (int)(cursor.isNull(n31) ? 1 : 0);
                            if (n32 != 0) {
                                n52 = 0;
                                object14 = null;
                            } else {
                                string2 = cursor.getString(n31);
                                object14 = string2;
                            }
                            ((TemplateData)object3).setTrackEditorConfigData((String)object14);
                            n32 = n47;
                            n52 = n30;
                            n47 = cursor.getInt(n30);
                            ((TemplateData)object3).setTemplateUseType(n47);
                            n47 = n29;
                            n52 = cursor.getInt(n29);
                            ((TemplateData)object3).setTemplateProtocolType(n52);
                            n52 = n28;
                            n29 = cursor.getInt(n28);
                            if (n29 != 0) {
                                n52 = 1;
                            } else {
                                n52 = 0;
                                object14 = null;
                            }
                            ((TemplateData)object3).setFirstLoaded(n52 != 0);
                            ((TemplateData)object3).setTemplateDescription((TemplateDescription)object6);
                            ((TemplateData)object3).setScriptDataExt((ScriptDataExt)object13);
                        }
                        n52 = (int)(cursor.isNull(n44) ? 1 : 0);
                        if (n52 == 0) {
                            n29 = n47;
                            long l15 = cursor.getLong(n44);
                            object13 = object22;
                            object14 = ((LongSparseArray)object22).get(l15);
                            object14 = (Template)object14;
                        } else {
                            n29 = n47;
                            object13 = object22;
                            n52 = 0;
                            object14 = null;
                        }
                        n47 = cursor.isNull(n44);
                        if (n47 == 0) {
                            object22 = object13;
                            long l16 = cursor.getLong(n44);
                            object6 = object23;
                            object = ((LongSparseArray)object23).get(l16);
                            object = (Script)object;
                        } else {
                            object22 = object13;
                            object6 = object23;
                            n47 = 0;
                            object = null;
                        }
                        n34 = (int)(cursor.isNull(n44) ? 1 : 0);
                        if (n34 == 0) {
                            n21 = n43;
                            n34 = n42;
                            l10 = cursor.getLong(n44);
                            n49 = n42;
                            object13 = object24;
                            arrayList = ((LongSparseArray)object24).get(l10);
                            arrayList = (Draft)((Object)arrayList);
                        } else {
                            n21 = n43;
                            n49 = n42;
                            object13 = object24;
                            n43 = 0;
                            arrayList = null;
                        }
                        n42 = (int)(cursor.isNull(n44) ? 1 : 0);
                        if (n42 == 0) {
                            n20 = n41;
                            l11 = cursor.getLong(n44);
                            object21 = object13;
                            object13 = object25;
                            object11 = ((LongSparseArray)object25).get(l11);
                            object11 = (Withdraw)object11;
                        } else {
                            object21 = object13;
                            n20 = n41;
                            object13 = object25;
                            n42 = 0;
                            object11 = null;
                        }
                        n41 = (int)(cursor.isNull(n44) ? 1 : 0);
                        if (n41 == 0) {
                            n19 = n40;
                            long l17 = cursor.getLong(n44);
                            object20 = object13;
                            object13 = object26;
                            object10 = ((LongSparseArray)object26).get(l17);
                            object10 = (TemplateGlobal)object10;
                        } else {
                            object20 = object13;
                            n19 = n40;
                            object13 = object26;
                            n41 = 0;
                            object10 = null;
                        }
                        n40 = (int)(cursor.isNull(n44) ? 1 : 0);
                        if (n40 == 0) {
                            n18 = n39;
                            long l18 = cursor.getLong(n44);
                            object19 = object13;
                            object13 = arrayList2;
                            object9 = ((LongSparseArray)((Object)arrayList2)).get(l18);
                            object9 = (ArrayList)object9;
                        } else {
                            object19 = object13;
                            n18 = n39;
                            object13 = arrayList2;
                            n40 = 0;
                            object9 = null;
                        }
                        if (object9 == null) {
                            object9 = new ArrayList();
                        }
                        if ((n39 = cursor.isNull(n44)) == 0) {
                            n17 = n38;
                            long l19 = cursor.getLong(n44);
                            object18 = object13;
                            object13 = arrayList3;
                            object8 = ((LongSparseArray)((Object)arrayList3)).get(l19);
                            object8 = (ArrayList)object8;
                        } else {
                            object18 = object13;
                            n17 = n38;
                            object13 = arrayList3;
                            n39 = 0;
                            object8 = null;
                        }
                        if (object8 == null) {
                            object8 = new ArrayList();
                        }
                        if ((n38 = cursor.isNull(n44)) == 0) {
                            arrayList3 = object6;
                            long l20 = cursor.getLong(n44);
                            object17 = object13;
                            object13 = arrayList4;
                            object7 = ((LongSparseArray)((Object)arrayList4)).get(l20);
                            object7 = (ArrayList)object7;
                        } else {
                            object17 = object13;
                            arrayList3 = object6;
                            object13 = arrayList4;
                            n38 = 0;
                            object7 = null;
                        }
                        if (object7 == null) {
                            object7 = new ArrayList();
                        }
                        if ((n37 = cursor.isNull(n44)) == 0) {
                            n15 = n36;
                            long l21 = cursor.getLong(n44);
                            object16 = object13;
                            object13 = arrayList5;
                            object6 = ((LongSparseArray)((Object)arrayList5)).get(l21);
                            object6 = (ArrayList)object6;
                        } else {
                            object16 = object13;
                            n15 = n36;
                            object13 = arrayList5;
                            n37 = 0;
                            object6 = null;
                        }
                        if (object6 == null) {
                            object6 = new ArrayList();
                        }
                        if ((n36 = cursor.isNull(n44)) == 0) {
                            n14 = n35;
                            l12 = cursor.getLong(n44);
                            n48 = n44;
                            object2 = arrayList6;
                            object5 = ((LongSparseArray)((Object)arrayList6)).get(l12);
                            object5 = (ArrayList)object5;
                        } else {
                            n48 = n44;
                            n14 = n35;
                            object2 = arrayList6;
                            n36 = 0;
                            object5 = null;
                        }
                        if (object5 == null) {
                            object5 = new ArrayList();
                        }
                        object4 = new TemplatePOJO();
                        ((TemplatePOJO)object4).setTemplateData((TemplateData)object3);
                        ((TemplatePOJO)object4).setTemplate((Template)object14);
                        ((TemplatePOJO)object4).setScript((Script)object);
                        ((TemplatePOJO)object4).setDraft((Draft)((Object)arrayList));
                        ((TemplatePOJO)object4).setWithdraw((Withdraw)object11);
                        ((TemplatePOJO)object4).setTemplateGlobal((TemplateGlobal)object10);
                        ((TemplatePOJO)object4).setTemplateVideoList((List)object9);
                        ((TemplatePOJO)object4).setTemplateStickerList((List)object8);
                        ((TemplatePOJO)object4).setTemplateMusicList((List)object7);
                        ((TemplatePOJO)object4).setTemplateRecordingList((List)object6);
                        ((TemplatePOJO)object4).setScriptTrackPOJOList((List)object5);
                        object14 = arrayList7;
                        arrayList7.add(object4);
                        object9 = object2;
                        arrayList = arrayList7;
                        object8 = object13;
                        object13 = object22;
                        n33 = n22;
                        n13 = n21;
                        n12 = n20;
                        n22 = n50;
                        object3 = object21;
                        object = object20;
                        object4 = object19;
                        object5 = object18;
                        object6 = object17;
                        object7 = object16;
                        n44 = n48;
                        object14 = this;
                        n21 = n32;
                        n32 = n27;
                        n20 = n26;
                        n27 = n11;
                        n26 = n10;
                        n10 = n49;
                        n11 = n23;
                        n23 = n45;
                        object12 = arrayList3;
                        n16 = n17;
                        n17 = n15;
                        n15 = n18;
                        n18 = n14;
                        n14 = n19;
                        n19 = n24;
                        n24 = n25;
                        n25 = n51;
                    }
                    catch (Throwable throwable) {
                        object = this;
                        break block92;
                    }
                }
                object = object14;
                object14 = arrayList;
                object2 = ((G_TemplateDataDao_Impl)object).__db;
                ((RoomDatabase)object2).setTransactionSuccessful();
                try {
                    cursor.close();
                    roomSQLiteQuery.release();
                    ((G_TemplateDataDao_Impl)object).__db.endTransaction();
                    return arrayList;
                }
                catch (Throwable throwable) {}
                catch (Throwable throwable) {}
            }
            cursor.close();
            roomSQLiteQuery.release();
            throw object2;
        }
        ((G_TemplateDataDao_Impl)object).__db.endTransaction();
        throw var5_12;
    }

    public LiveData queryAll_LiveData() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData", 0);
        InvalidationTracker invalidationTracker = this.__db.getInvalidationTracker();
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$15 g_TemplateDataDao_Impl$15 = new G_TemplateDataDao_Impl$15(this, roomSQLiteQuery);
        return invalidationTracker.createLiveData(stringArray, true, g_TemplateDataDao_Impl$15);
    }

    public z queryAll_Observable() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData", 0);
        RoomDatabase roomDatabase = this.__db;
        String[] stringArray = new String[]{"Template", "script", "draft", "withdraw", "TemplateGlobal", "TemplateVideo", "TemplateSticker", "TemplateMusic", "template_recording", "script_track_point", "script_metadata", "script_track", "TemplateData"};
        G_TemplateDataDao_Impl$16 g_TemplateDataDao_Impl$16 = new G_TemplateDataDao_Impl$16(this, roomSQLiteQuery);
        return RxRoom.createObservable(roomDatabase, true, stringArray, g_TemplateDataDao_Impl$16);
    }

    public i0 queryAll_Single() {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire("SELECT * FROM TemplateData", 0);
        G_TemplateDataDao_Impl$14 g_TemplateDataDao_Impl$14 = new G_TemplateDataDao_Impl$14(this, roomSQLiteQuery);
        return RxRoom.createSingle(g_TemplateDataDao_Impl$14);
    }

    public void renameTemplate(long l10, String string2, String string3, String string4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfRenameTemplate.acquire();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
        int n11 = 2;
        if (string3 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, string3);
        }
        n11 = 3;
        if (string4 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, string4);
        }
        n11 = 4;
        supportSQLiteStatement.bindLong(n11, l10);
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            roomDatabase = this.__db;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRenameTemplate.release(supportSQLiteStatement);
        }
    }

    public long replace(TemplateData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__insertionAdapterOfTemplateData;
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
            object = this.__insertionAdapterOfTemplateData;
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
        G_TemplateDataDao_Impl$8 g_TemplateDataDao_Impl$8 = new G_TemplateDataDao_Impl$8(this, list);
        return i0.o0(g_TemplateDataDao_Impl$8);
    }

    public void update(TemplateData object) {
        this.__db.assertNotSuspendingTransaction();
        Object object2 = this.__db;
        ((RoomDatabase)object2).beginTransaction();
        try {
            object2 = this.__updateAdapterOfTemplateData;
            ((EntityDeletionOrUpdateAdapter)object2).handle(object);
            object = this.__db;
            ((RoomDatabase)object).setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
        }
    }

    public void updateFirstLoaded(long l10, boolean bl2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement = this.__preparedStmtOfUpdateFirstLoaded.acquire();
        long l11 = (long)bl2;
        supportSQLiteStatement.bindLong(1, l11);
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l10);
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatement.executeUpdateDelete();
            roomDatabase = this.__db;
            roomDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateFirstLoaded.release(supportSQLiteStatement);
        }
    }
}

