/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.RoomDatabase;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateRecordingDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPOJODao;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao;
import d.v.e.l.c1;
import d.v.j.e.f.a;
import java.util.concurrent.Executor;

public abstract class AppDatabaseTemplate
extends RoomDatabase {
    private /* synthetic */ void e(Runnable runnable) {
        this.runInTransaction(runnable);
    }

    public abstract G_DraftDao draftDao();

    public /* synthetic */ void f(Runnable runnable) {
        this.e(runnable);
    }

    public void runOnTransition(Runnable runnable) {
        Executor executor = c1.b().a();
        a a10 = new a(this, runnable);
        executor.execute(a10);
    }

    public abstract G_ScriptDao scriptDao();

    public abstract ScriptTrackDao scriptTrackDao();

    public abstract ScriptTrackMetaDataDao scriptTrackMetaDataDao();

    public abstract ScriptTrackPOJODao scriptTrackPOJODao();

    public abstract ScriptTrackPointDao scriptTrackPointDao();

    public abstract G_TemplateDao templateDao();

    public abstract G_SortResultDao templateDatResultDao();

    public abstract G_TemplateDataDao templateDataDao();

    public abstract G_TemplateFileRelationDao templateFilRelationDao();

    public abstract G_TemplateFileDao templateFileDao();

    public abstract G_TemplateGlobalDao templateGlobalDao();

    public abstract G_TemplateMusicDao templateMusicDao();

    public abstract G_TemplateRecordingDao templateRecordingDao();

    public abstract G_TemplateStickerDao templateStickerDao();

    public abstract G_TemplateTypeDao templateTypeDao();

    public abstract G_TemplateVideoDao templateVideoDao();

    public abstract G_WithdrawDao withdrawDao();
}

