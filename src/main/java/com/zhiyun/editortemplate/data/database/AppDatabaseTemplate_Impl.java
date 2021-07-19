/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.zhiyun.editortemplate.data.database;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper$Delegate;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate_Impl$1;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateRecordingDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateRecordingDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao_Impl;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppDatabaseTemplate_Impl
extends AppDatabaseTemplate {
    private volatile G_DraftDao _gDraftDao;
    private volatile G_ScriptDao _gScriptDao;
    private volatile G_SortResultDao _gSortResultDao;
    private volatile G_TemplateDao _gTemplateDao;
    private volatile G_TemplateDataDao _gTemplateDataDao;
    private volatile G_TemplateFileDao _gTemplateFileDao;
    private volatile G_TemplateFileRelationDao _gTemplateFileRelationDao;
    private volatile G_TemplateGlobalDao _gTemplateGlobalDao;
    private volatile G_TemplateMusicDao _gTemplateMusicDao;
    private volatile G_TemplateRecordingDao _gTemplateRecordingDao;
    private volatile G_TemplateStickerDao _gTemplateStickerDao;
    private volatile G_TemplateTypeDao _gTemplateTypeDao;
    private volatile G_TemplateVideoDao _gTemplateVideoDao;
    private volatile G_WithdrawDao _gWithdrawDao;
    private volatile ScriptTrackDao _scriptTrackDao;
    private volatile ScriptTrackMetaDataDao _scriptTrackMetaDataDao;
    private volatile ScriptTrackPOJODao _scriptTrackPOJODao;
    private volatile ScriptTrackPointDao _scriptTrackPointDao;

    public static /* synthetic */ List access$000(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$100(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$1000(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$200(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$300(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$400(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$500(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        appDatabaseTemplate_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    public static /* synthetic */ void access$700(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        appDatabaseTemplate_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    public static /* synthetic */ List access$800(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$900(AppDatabaseTemplate_Impl appDatabaseTemplate_Impl) {
        return appDatabaseTemplate_Impl.mCallbacks;
    }

    /*
     * Unable to fully structure code
     */
    public void clearAllTables() {
        super.assertNotMainThread();
        var1_1 = super.getOpenHelper().getWritableDatabase();
        var2_2 = Build.VERSION.SDK_INT;
        var3_3 = 21;
        if (var2_2 >= var3_3) {
            var2_2 = 1;
        } else {
            var2_2 = 0;
            var4_4 = null;
        }
        var5_5 = "VACUUM";
        var6_6 = "PRAGMA foreign_keys = TRUE";
        var7_7 = "PRAGMA wal_checkpoint(FULL)";
        if (var2_2 != 0) ** GOTO lbl17
        var8_8 = "PRAGMA foreign_keys = FALSE";
        var1_1.execSQL(var8_8);
lbl17:
        // 2 sources

        super.beginTransaction();
        if (var2_2 == 0) ** GOTO lbl24
        var8_8 = "PRAGMA defer_foreign_keys = TRUE";
        try {
            var1_1.execSQL(var8_8);
lbl24:
            // 2 sources

            var8_8 = "DELETE FROM `TemplateData`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `Template`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `draft`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `withdraw`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `TemplateGlobal`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `TemplateSticker`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `TemplateVideo`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `SortResult`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `FileData`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `TemplateFileRelation`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `TemplateMusic`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `script_track`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `script_track_point`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `TemplateType`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `script`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `template_recording`";
            var1_1.execSQL(var8_8);
            var8_8 = "DELETE FROM `script_metadata`";
            var1_1.execSQL(var8_8);
            super.setTransactionSuccessful();
            return;
        }
        finally {
            super.endTransaction();
            if (var2_2 == 0) {
                var1_1.execSQL(var6_6);
            }
            var4_4 = var1_1.query(var7_7);
            var4_4.close();
            var2_2 = (int)var1_1.inTransaction();
            if (var2_2 == 0) {
                var1_1.execSQL(var5_5);
            }
        }
    }

    public InvalidationTracker createInvalidationTracker() {
        HashMap hashMap = new HashMap(0);
        HashMap hashMap2 = new HashMap(0);
        String[] stringArray = new String[]{"TemplateData", "Template", "draft", "withdraw", "TemplateGlobal", "TemplateSticker", "TemplateVideo", "SortResult", "FileData", "TemplateFileRelation", "TemplateMusic", "script_track", "script_track_point", "TemplateType", "script", "template_recording", "script_metadata"};
        InvalidationTracker invalidationTracker = new InvalidationTracker((RoomDatabase)this, hashMap, hashMap2, stringArray);
        return invalidationTracker;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new AppDatabaseTemplate_Impl$1(this, 6);
        Object object2 = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper$Delegate)object, "3f0461c1d8522dc229d2eac584f68681", "47dcbd17738800ba47a50698106f1919");
        object = SupportSQLiteOpenHelper$Configuration.builder(databaseConfiguration.context);
        String string2 = databaseConfiguration.name;
        object2 = ((SupportSQLiteOpenHelper$Configuration$Builder)object).name(string2).callback((SupportSQLiteOpenHelper$Callback)object2).build();
        return databaseConfiguration.sqliteOpenHelperFactory.create((SupportSQLiteOpenHelper$Configuration)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_DraftDao draftDao() {
        G_DraftDao g_DraftDao = this._gDraftDao;
        if (g_DraftDao != null) {
            return this._gDraftDao;
        }
        synchronized (this) {
            g_DraftDao = this._gDraftDao;
            if (g_DraftDao != null) return this._gDraftDao;
            this._gDraftDao = g_DraftDao = new G_DraftDao_Impl(this);
            return this._gDraftDao;
        }
    }

    public Map getRequiredTypeConverters() {
        HashMap<Class, List> hashMap = new HashMap<Class, List>();
        List list = G_TemplateDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateDao.class, list);
        list = G_DraftDao_Impl.getRequiredConverters();
        hashMap.put(G_DraftDao.class, list);
        list = G_WithdrawDao_Impl.getRequiredConverters();
        hashMap.put(G_WithdrawDao.class, list);
        list = G_TemplateTypeDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateTypeDao.class, list);
        list = G_TemplateDataDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateDataDao.class, list);
        list = G_SortResultDao_Impl.getRequiredConverters();
        hashMap.put(G_SortResultDao.class, list);
        list = G_TemplateFileDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateFileDao.class, list);
        list = G_TemplateFileRelationDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateFileRelationDao.class, list);
        list = G_TemplateGlobalDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateGlobalDao.class, list);
        list = G_TemplateStickerDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateStickerDao.class, list);
        list = G_TemplateMusicDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateMusicDao.class, list);
        list = G_TemplateRecordingDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateRecordingDao.class, list);
        list = G_TemplateVideoDao_Impl.getRequiredConverters();
        hashMap.put(G_TemplateVideoDao.class, list);
        list = ScriptTrackPOJODao_Impl.getRequiredConverters();
        hashMap.put(ScriptTrackPOJODao.class, list);
        list = G_ScriptDao_Impl.getRequiredConverters();
        hashMap.put(G_ScriptDao.class, list);
        list = ScriptTrackDao_Impl.getRequiredConverters();
        hashMap.put(ScriptTrackDao.class, list);
        list = ScriptTrackPointDao_Impl.getRequiredConverters();
        hashMap.put(ScriptTrackPointDao.class, list);
        list = ScriptTrackMetaDataDao_Impl.getRequiredConverters();
        hashMap.put(ScriptTrackMetaDataDao.class, list);
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_ScriptDao scriptDao() {
        G_ScriptDao g_ScriptDao = this._gScriptDao;
        if (g_ScriptDao != null) {
            return this._gScriptDao;
        }
        synchronized (this) {
            g_ScriptDao = this._gScriptDao;
            if (g_ScriptDao != null) return this._gScriptDao;
            this._gScriptDao = g_ScriptDao = new G_ScriptDao_Impl(this);
            return this._gScriptDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ScriptTrackDao scriptTrackDao() {
        ScriptTrackDao scriptTrackDao = this._scriptTrackDao;
        if (scriptTrackDao != null) {
            return this._scriptTrackDao;
        }
        synchronized (this) {
            scriptTrackDao = this._scriptTrackDao;
            if (scriptTrackDao != null) return this._scriptTrackDao;
            this._scriptTrackDao = scriptTrackDao = new ScriptTrackDao_Impl(this);
            return this._scriptTrackDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ScriptTrackMetaDataDao scriptTrackMetaDataDao() {
        ScriptTrackMetaDataDao scriptTrackMetaDataDao = this._scriptTrackMetaDataDao;
        if (scriptTrackMetaDataDao != null) {
            return this._scriptTrackMetaDataDao;
        }
        synchronized (this) {
            scriptTrackMetaDataDao = this._scriptTrackMetaDataDao;
            if (scriptTrackMetaDataDao != null) return this._scriptTrackMetaDataDao;
            this._scriptTrackMetaDataDao = scriptTrackMetaDataDao = new ScriptTrackMetaDataDao_Impl(this);
            return this._scriptTrackMetaDataDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ScriptTrackPOJODao scriptTrackPOJODao() {
        ScriptTrackPOJODao scriptTrackPOJODao = this._scriptTrackPOJODao;
        if (scriptTrackPOJODao != null) {
            return this._scriptTrackPOJODao;
        }
        synchronized (this) {
            scriptTrackPOJODao = this._scriptTrackPOJODao;
            if (scriptTrackPOJODao != null) return this._scriptTrackPOJODao;
            this._scriptTrackPOJODao = scriptTrackPOJODao = new ScriptTrackPOJODao_Impl(this);
            return this._scriptTrackPOJODao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ScriptTrackPointDao scriptTrackPointDao() {
        ScriptTrackPointDao scriptTrackPointDao = this._scriptTrackPointDao;
        if (scriptTrackPointDao != null) {
            return this._scriptTrackPointDao;
        }
        synchronized (this) {
            scriptTrackPointDao = this._scriptTrackPointDao;
            if (scriptTrackPointDao != null) return this._scriptTrackPointDao;
            this._scriptTrackPointDao = scriptTrackPointDao = new ScriptTrackPointDao_Impl(this);
            return this._scriptTrackPointDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateDao templateDao() {
        G_TemplateDao g_TemplateDao = this._gTemplateDao;
        if (g_TemplateDao != null) {
            return this._gTemplateDao;
        }
        synchronized (this) {
            g_TemplateDao = this._gTemplateDao;
            if (g_TemplateDao != null) return this._gTemplateDao;
            this._gTemplateDao = g_TemplateDao = new G_TemplateDao_Impl(this);
            return this._gTemplateDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_SortResultDao templateDatResultDao() {
        G_SortResultDao g_SortResultDao = this._gSortResultDao;
        if (g_SortResultDao != null) {
            return this._gSortResultDao;
        }
        synchronized (this) {
            g_SortResultDao = this._gSortResultDao;
            if (g_SortResultDao != null) return this._gSortResultDao;
            this._gSortResultDao = g_SortResultDao = new G_SortResultDao_Impl(this);
            return this._gSortResultDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateDataDao templateDataDao() {
        G_TemplateDataDao g_TemplateDataDao = this._gTemplateDataDao;
        if (g_TemplateDataDao != null) {
            return this._gTemplateDataDao;
        }
        synchronized (this) {
            g_TemplateDataDao = this._gTemplateDataDao;
            if (g_TemplateDataDao != null) return this._gTemplateDataDao;
            this._gTemplateDataDao = g_TemplateDataDao = new G_TemplateDataDao_Impl(this);
            return this._gTemplateDataDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateFileRelationDao templateFilRelationDao() {
        G_TemplateFileRelationDao g_TemplateFileRelationDao = this._gTemplateFileRelationDao;
        if (g_TemplateFileRelationDao != null) {
            return this._gTemplateFileRelationDao;
        }
        synchronized (this) {
            g_TemplateFileRelationDao = this._gTemplateFileRelationDao;
            if (g_TemplateFileRelationDao != null) return this._gTemplateFileRelationDao;
            this._gTemplateFileRelationDao = g_TemplateFileRelationDao = new G_TemplateFileRelationDao_Impl(this);
            return this._gTemplateFileRelationDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateFileDao templateFileDao() {
        G_TemplateFileDao g_TemplateFileDao = this._gTemplateFileDao;
        if (g_TemplateFileDao != null) {
            return this._gTemplateFileDao;
        }
        synchronized (this) {
            g_TemplateFileDao = this._gTemplateFileDao;
            if (g_TemplateFileDao != null) return this._gTemplateFileDao;
            this._gTemplateFileDao = g_TemplateFileDao = new G_TemplateFileDao_Impl(this);
            return this._gTemplateFileDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateGlobalDao templateGlobalDao() {
        G_TemplateGlobalDao g_TemplateGlobalDao = this._gTemplateGlobalDao;
        if (g_TemplateGlobalDao != null) {
            return this._gTemplateGlobalDao;
        }
        synchronized (this) {
            g_TemplateGlobalDao = this._gTemplateGlobalDao;
            if (g_TemplateGlobalDao != null) return this._gTemplateGlobalDao;
            this._gTemplateGlobalDao = g_TemplateGlobalDao = new G_TemplateGlobalDao_Impl(this);
            return this._gTemplateGlobalDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateMusicDao templateMusicDao() {
        G_TemplateMusicDao g_TemplateMusicDao = this._gTemplateMusicDao;
        if (g_TemplateMusicDao != null) {
            return this._gTemplateMusicDao;
        }
        synchronized (this) {
            g_TemplateMusicDao = this._gTemplateMusicDao;
            if (g_TemplateMusicDao != null) return this._gTemplateMusicDao;
            this._gTemplateMusicDao = g_TemplateMusicDao = new G_TemplateMusicDao_Impl(this);
            return this._gTemplateMusicDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateRecordingDao templateRecordingDao() {
        G_TemplateRecordingDao g_TemplateRecordingDao = this._gTemplateRecordingDao;
        if (g_TemplateRecordingDao != null) {
            return this._gTemplateRecordingDao;
        }
        synchronized (this) {
            g_TemplateRecordingDao = this._gTemplateRecordingDao;
            if (g_TemplateRecordingDao != null) return this._gTemplateRecordingDao;
            this._gTemplateRecordingDao = g_TemplateRecordingDao = new G_TemplateRecordingDao_Impl(this);
            return this._gTemplateRecordingDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateStickerDao templateStickerDao() {
        G_TemplateStickerDao g_TemplateStickerDao = this._gTemplateStickerDao;
        if (g_TemplateStickerDao != null) {
            return this._gTemplateStickerDao;
        }
        synchronized (this) {
            g_TemplateStickerDao = this._gTemplateStickerDao;
            if (g_TemplateStickerDao != null) return this._gTemplateStickerDao;
            this._gTemplateStickerDao = g_TemplateStickerDao = new G_TemplateStickerDao_Impl(this);
            return this._gTemplateStickerDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateTypeDao templateTypeDao() {
        G_TemplateTypeDao g_TemplateTypeDao = this._gTemplateTypeDao;
        if (g_TemplateTypeDao != null) {
            return this._gTemplateTypeDao;
        }
        synchronized (this) {
            g_TemplateTypeDao = this._gTemplateTypeDao;
            if (g_TemplateTypeDao != null) return this._gTemplateTypeDao;
            this._gTemplateTypeDao = g_TemplateTypeDao = new G_TemplateTypeDao_Impl(this);
            return this._gTemplateTypeDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_TemplateVideoDao templateVideoDao() {
        G_TemplateVideoDao g_TemplateVideoDao = this._gTemplateVideoDao;
        if (g_TemplateVideoDao != null) {
            return this._gTemplateVideoDao;
        }
        synchronized (this) {
            g_TemplateVideoDao = this._gTemplateVideoDao;
            if (g_TemplateVideoDao != null) return this._gTemplateVideoDao;
            this._gTemplateVideoDao = g_TemplateVideoDao = new G_TemplateVideoDao_Impl(this);
            return this._gTemplateVideoDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public G_WithdrawDao withdrawDao() {
        G_WithdrawDao g_WithdrawDao = this._gWithdrawDao;
        if (g_WithdrawDao != null) {
            return this._gWithdrawDao;
        }
        synchronized (this) {
            g_WithdrawDao = this._gWithdrawDao;
            if (g_WithdrawDao != null) return this._gWithdrawDao;
            this._gWithdrawDao = g_WithdrawDao = new G_WithdrawDao_Impl(this);
            return this._gWithdrawDao;
        }
    }
}

