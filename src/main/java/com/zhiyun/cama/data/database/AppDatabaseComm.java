/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao;
import com.zhiyun.cama.data.database.dao.font.FontDao;
import com.zhiyun.cama.data.database.dao.font.FontFileDao;
import com.zhiyun.cama.data.database.dao.music.AlbumDao;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao;
import com.zhiyun.cama.data.database.dao.music.MusicDao;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerTypeDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao;
import d.v.c.v0.o.a;
import d.v.e.l.c1;
import java.util.concurrent.Executor;

public abstract class AppDatabaseComm
extends RoomDatabase {
    private /* synthetic */ void e(Runnable runnable) {
        this.runInTransaction(runnable);
    }

    public abstract AlbumDao albumDao();

    public abstract CaptionStyleDao captionStyleDao();

    public abstract CaptionStyleFileDao captionStyleFileDao();

    public /* synthetic */ void f(Runnable runnable) {
        this.e(runnable);
    }

    public abstract FilterDataDao filterDataDao();

    public abstract FilterFileDao filterFileDao();

    public abstract FilterTypeDao filterTypeDao();

    public abstract FontDao fontDao();

    public abstract FontFileDao fontFileDao();

    public abstract MusicBeatDao musicBeatDao();

    public abstract MusicDao musicDao();

    public abstract MusicFileDao musicFileDao();

    public abstract MusicInfoDataDao musicInfoDataDao();

    public void runOnTransition(Runnable runnable) {
        Executor executor = c1.b().a();
        a a10 = new a(this, runnable);
        executor.execute(a10);
    }

    public abstract StickerDataDao stickerDataDao();

    public abstract StickerFileDao stickerFileDao();

    public abstract StickerTypeDao stickerTypeDao();

    public abstract TransitionDataDao transitionDataDao();

    public abstract TransitionFileDao transitionFileDao();
}

