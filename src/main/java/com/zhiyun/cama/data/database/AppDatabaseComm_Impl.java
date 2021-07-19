/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

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
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.AppDatabaseComm_Impl$1;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao_Impl;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao_Impl;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao_Impl;
import com.zhiyun.cama.data.database.dao.font.FontDao;
import com.zhiyun.cama.data.database.dao.font.FontDao_Impl;
import com.zhiyun.cama.data.database.dao.font.FontFileDao;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl;
import com.zhiyun.cama.data.database.dao.music.AlbumDao;
import com.zhiyun.cama.data.database.dao.music.AlbumDao_Impl;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao_Impl;
import com.zhiyun.cama.data.database.dao.music.MusicDao;
import com.zhiyun.cama.data.database.dao.music.MusicDao_Impl;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao_Impl;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao_Impl;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao_Impl;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppDatabaseComm_Impl
extends AppDatabaseComm {
    private volatile AlbumDao _albumDao;
    private volatile CaptionStyleDao _captionStyleDao;
    private volatile CaptionStyleFileDao _captionStyleFileDao;
    private volatile FilterDataDao _filterDataDao;
    private volatile FilterFileDao _filterFileDao;
    private volatile FilterTypeDao _filterTypeDao;
    private volatile FontDao _fontDao;
    private volatile FontFileDao _fontFileDao;
    private volatile MusicBeatDao _musicBeatDao;
    private volatile MusicDao _musicDao;
    private volatile MusicFileDao _musicFileDao;
    private volatile MusicInfoDataDao _musicInfoDataDao;
    private volatile StickerDataDao _stickerDataDao;
    private volatile StickerFileDao _stickerFileDao;
    private volatile StickerTypeDao _stickerTypeDao;
    private volatile TransitionDataDao _transitionDataDao;
    private volatile TransitionFileDao _transitionFileDao;

    public static /* synthetic */ List access$000(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$100(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$1000(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$200(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$300(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$400(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$500(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ SupportSQLiteDatabase access$602(AppDatabaseComm_Impl appDatabaseComm_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        appDatabaseComm_Impl.mDatabase = supportSQLiteDatabase;
        return supportSQLiteDatabase;
    }

    public static /* synthetic */ void access$700(AppDatabaseComm_Impl appDatabaseComm_Impl, SupportSQLiteDatabase supportSQLiteDatabase) {
        appDatabaseComm_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
    }

    public static /* synthetic */ List access$800(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    public static /* synthetic */ List access$900(AppDatabaseComm_Impl appDatabaseComm_Impl) {
        return appDatabaseComm_Impl.mCallbacks;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AlbumDao albumDao() {
        AlbumDao albumDao = this._albumDao;
        if (albumDao != null) {
            return this._albumDao;
        }
        synchronized (this) {
            albumDao = this._albumDao;
            if (albumDao != null) return this._albumDao;
            this._albumDao = albumDao = new AlbumDao_Impl(this);
            return this._albumDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CaptionStyleDao captionStyleDao() {
        CaptionStyleDao captionStyleDao = this._captionStyleDao;
        if (captionStyleDao != null) {
            return this._captionStyleDao;
        }
        synchronized (this) {
            captionStyleDao = this._captionStyleDao;
            if (captionStyleDao != null) return this._captionStyleDao;
            this._captionStyleDao = captionStyleDao = new CaptionStyleDao_Impl(this);
            return this._captionStyleDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CaptionStyleFileDao captionStyleFileDao() {
        CaptionStyleFileDao captionStyleFileDao = this._captionStyleFileDao;
        if (captionStyleFileDao != null) {
            return this._captionStyleFileDao;
        }
        synchronized (this) {
            captionStyleFileDao = this._captionStyleFileDao;
            if (captionStyleFileDao != null) return this._captionStyleFileDao;
            this._captionStyleFileDao = captionStyleFileDao = new CaptionStyleFileDao_Impl(this);
            return this._captionStyleFileDao;
        }
    }

    public void clearAllTables() {
        String string2 = "VACUUM";
        String string3 = "PRAGMA wal_checkpoint(FULL)";
        super.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            String string4 = "DELETE FROM `music_info_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `filter_type`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `filter_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `filter_file`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `album_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `music_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `music_file`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `font_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `font_file`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `caption_style_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `caption_style_file`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `sticker_type`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `sticker_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `sticker_file`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `transition_data`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `transition_file`";
            supportSQLiteDatabase.execSQL(string4);
            string4 = "DELETE FROM `music_beat_data`";
            supportSQLiteDatabase.execSQL(string4);
            super.setTransactionSuccessful();
            return;
        }
        finally {
            super.endTransaction();
            string3 = supportSQLiteDatabase.query(string3);
            string3.close();
            boolean bl2 = supportSQLiteDatabase.inTransaction();
            if (!bl2) {
                supportSQLiteDatabase.execSQL(string2);
            }
        }
    }

    public InvalidationTracker createInvalidationTracker() {
        HashMap hashMap = new HashMap(0);
        HashMap hashMap2 = new HashMap(0);
        String[] stringArray = new String[]{"music_info_data", "filter_type", "filter_data", "filter_file", "album_data", "music_data", "music_file", "font_data", "font_file", "caption_style_data", "caption_style_file", "sticker_type", "sticker_data", "sticker_file", "transition_data", "transition_file", "music_beat_data"};
        InvalidationTracker invalidationTracker = new InvalidationTracker((RoomDatabase)this, hashMap, hashMap2, stringArray);
        return invalidationTracker;
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        Object object = new AppDatabaseComm_Impl$1(this, 7);
        Object object2 = new RoomOpenHelper(databaseConfiguration, (RoomOpenHelper$Delegate)object, "ba989ba01ec08ab8a7432a22c1eb6709", "025639fa82b77c22aeeb58889e5577fe");
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
    public FilterDataDao filterDataDao() {
        FilterDataDao filterDataDao = this._filterDataDao;
        if (filterDataDao != null) {
            return this._filterDataDao;
        }
        synchronized (this) {
            filterDataDao = this._filterDataDao;
            if (filterDataDao != null) return this._filterDataDao;
            this._filterDataDao = filterDataDao = new FilterDataDao_Impl(this);
            return this._filterDataDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FilterFileDao filterFileDao() {
        FilterFileDao filterFileDao = this._filterFileDao;
        if (filterFileDao != null) {
            return this._filterFileDao;
        }
        synchronized (this) {
            filterFileDao = this._filterFileDao;
            if (filterFileDao != null) return this._filterFileDao;
            this._filterFileDao = filterFileDao = new FilterFileDao_Impl(this);
            return this._filterFileDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FilterTypeDao filterTypeDao() {
        FilterTypeDao filterTypeDao = this._filterTypeDao;
        if (filterTypeDao != null) {
            return this._filterTypeDao;
        }
        synchronized (this) {
            filterTypeDao = this._filterTypeDao;
            if (filterTypeDao != null) return this._filterTypeDao;
            this._filterTypeDao = filterTypeDao = new FilterTypeDao_Impl(this);
            return this._filterTypeDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FontDao fontDao() {
        FontDao fontDao = this._fontDao;
        if (fontDao != null) {
            return this._fontDao;
        }
        synchronized (this) {
            fontDao = this._fontDao;
            if (fontDao != null) return this._fontDao;
            this._fontDao = fontDao = new FontDao_Impl(this);
            return this._fontDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FontFileDao fontFileDao() {
        FontFileDao fontFileDao = this._fontFileDao;
        if (fontFileDao != null) {
            return this._fontFileDao;
        }
        synchronized (this) {
            fontFileDao = this._fontFileDao;
            if (fontFileDao != null) return this._fontFileDao;
            this._fontFileDao = fontFileDao = new FontFileDao_Impl(this);
            return this._fontFileDao;
        }
    }

    public Map getRequiredTypeConverters() {
        HashMap<Class<MusicBeatDao>, List> hashMap = new HashMap<Class<MusicBeatDao>, List>();
        List list = MusicInfoDataDao_Impl.getRequiredConverters();
        hashMap.put(MusicInfoDataDao.class, list);
        list = FilterTypeDao_Impl.getRequiredConverters();
        hashMap.put(FilterTypeDao.class, list);
        list = FilterDataDao_Impl.getRequiredConverters();
        hashMap.put(FilterDataDao.class, list);
        list = FilterFileDao_Impl.getRequiredConverters();
        hashMap.put(FilterFileDao.class, list);
        list = AlbumDao_Impl.getRequiredConverters();
        hashMap.put(AlbumDao.class, list);
        list = MusicDao_Impl.getRequiredConverters();
        hashMap.put(MusicDao.class, list);
        list = MusicFileDao_Impl.getRequiredConverters();
        hashMap.put(MusicFileDao.class, list);
        list = FontDao_Impl.getRequiredConverters();
        hashMap.put(FontDao.class, list);
        list = CaptionStyleDao_Impl.getRequiredConverters();
        hashMap.put(CaptionStyleDao.class, list);
        list = FontFileDao_Impl.getRequiredConverters();
        hashMap.put(FontFileDao.class, list);
        list = CaptionStyleFileDao_Impl.getRequiredConverters();
        hashMap.put(CaptionStyleFileDao.class, list);
        list = StickerDataDao_Impl.getRequiredConverters();
        hashMap.put(StickerDataDao.class, list);
        list = StickerTypeDao_Impl.getRequiredConverters();
        hashMap.put(StickerTypeDao.class, list);
        list = StickerFileDao_Impl.getRequiredConverters();
        hashMap.put(StickerFileDao.class, list);
        list = TransitionDataDao_Impl.getRequiredConverters();
        hashMap.put(TransitionDataDao.class, list);
        list = TransitionFileDao_Impl.getRequiredConverters();
        hashMap.put(TransitionFileDao.class, list);
        list = MusicBeatDao_Impl.getRequiredConverters();
        hashMap.put(MusicBeatDao.class, list);
        return hashMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MusicBeatDao musicBeatDao() {
        MusicBeatDao musicBeatDao = this._musicBeatDao;
        if (musicBeatDao != null) {
            return this._musicBeatDao;
        }
        synchronized (this) {
            musicBeatDao = this._musicBeatDao;
            if (musicBeatDao != null) return this._musicBeatDao;
            this._musicBeatDao = musicBeatDao = new MusicBeatDao_Impl(this);
            return this._musicBeatDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MusicDao musicDao() {
        MusicDao musicDao = this._musicDao;
        if (musicDao != null) {
            return this._musicDao;
        }
        synchronized (this) {
            musicDao = this._musicDao;
            if (musicDao != null) return this._musicDao;
            this._musicDao = musicDao = new MusicDao_Impl(this);
            return this._musicDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MusicFileDao musicFileDao() {
        MusicFileDao musicFileDao = this._musicFileDao;
        if (musicFileDao != null) {
            return this._musicFileDao;
        }
        synchronized (this) {
            musicFileDao = this._musicFileDao;
            if (musicFileDao != null) return this._musicFileDao;
            this._musicFileDao = musicFileDao = new MusicFileDao_Impl(this);
            return this._musicFileDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MusicInfoDataDao musicInfoDataDao() {
        MusicInfoDataDao musicInfoDataDao = this._musicInfoDataDao;
        if (musicInfoDataDao != null) {
            return this._musicInfoDataDao;
        }
        synchronized (this) {
            musicInfoDataDao = this._musicInfoDataDao;
            if (musicInfoDataDao != null) return this._musicInfoDataDao;
            this._musicInfoDataDao = musicInfoDataDao = new MusicInfoDataDao_Impl(this);
            return this._musicInfoDataDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public StickerDataDao stickerDataDao() {
        StickerDataDao stickerDataDao = this._stickerDataDao;
        if (stickerDataDao != null) {
            return this._stickerDataDao;
        }
        synchronized (this) {
            stickerDataDao = this._stickerDataDao;
            if (stickerDataDao != null) return this._stickerDataDao;
            this._stickerDataDao = stickerDataDao = new StickerDataDao_Impl(this);
            return this._stickerDataDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public StickerFileDao stickerFileDao() {
        StickerFileDao stickerFileDao = this._stickerFileDao;
        if (stickerFileDao != null) {
            return this._stickerFileDao;
        }
        synchronized (this) {
            stickerFileDao = this._stickerFileDao;
            if (stickerFileDao != null) return this._stickerFileDao;
            this._stickerFileDao = stickerFileDao = new StickerFileDao_Impl(this);
            return this._stickerFileDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public StickerTypeDao stickerTypeDao() {
        StickerTypeDao stickerTypeDao = this._stickerTypeDao;
        if (stickerTypeDao != null) {
            return this._stickerTypeDao;
        }
        synchronized (this) {
            stickerTypeDao = this._stickerTypeDao;
            if (stickerTypeDao != null) return this._stickerTypeDao;
            this._stickerTypeDao = stickerTypeDao = new StickerTypeDao_Impl(this);
            return this._stickerTypeDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TransitionDataDao transitionDataDao() {
        TransitionDataDao transitionDataDao = this._transitionDataDao;
        if (transitionDataDao != null) {
            return this._transitionDataDao;
        }
        synchronized (this) {
            transitionDataDao = this._transitionDataDao;
            if (transitionDataDao != null) return this._transitionDataDao;
            this._transitionDataDao = transitionDataDao = new TransitionDataDao_Impl(this);
            return this._transitionDataDao;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TransitionFileDao transitionFileDao() {
        TransitionFileDao transitionFileDao = this._transitionFileDao;
        if (transitionFileDao != null) {
            return this._transitionFileDao;
        }
        synchronized (this) {
            transitionFileDao = this._transitionFileDao;
            if (transitionFileDao != null) return this._transitionFileDao;
            this._transitionFileDao = transitionFileDao = new TransitionFileDao_Impl(this);
            return this._transitionFileDao;
        }
    }
}

