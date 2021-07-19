/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import d.v.j.e.f.b.f.a;
import d.v.j.e.f.b.f.b;
import d.v.j.e.f.b.f.c;
import d.v.j.e.f.b.f.d;
import d.v.j.e.f.b.f.e;
import d.v.j.e.f.b.f.f;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface ScriptTrackPOJODao {
    public static /* synthetic */ void a(long l10, AppDatabaseTemplate appDatabaseTemplate, List object) {
        object = object.stream();
        d d10 = new d(l10, appDatabaseTemplate);
        object.peek(d10).count();
    }

    public static /* synthetic */ void b(long l10, AppDatabaseTemplate appDatabaseTemplate, ScriptTrackPoint scriptTrackPoint) {
        scriptTrackPoint.setTrackPointId(l10);
        appDatabaseTemplate.scriptTrackPointDao().insert(scriptTrackPoint);
    }

    public static /* synthetic */ void c(ScriptTrack scriptTrack, long l10, AppDatabaseTemplate appDatabaseTemplate, ScriptTrackPOJO object, ScriptTrack object2) {
        scriptTrack.setScriptTrackId(l10);
        long l11 = appDatabaseTemplate.scriptTrackDao().insert(scriptTrack);
        Optional<List> optional = Optional.ofNullable(((ScriptTrackPOJO)object).getScriptTrackPointList());
        object2 = new b(l11, appDatabaseTemplate);
        optional.ifPresent((Consumer<List>)object2);
        optional = Optional.ofNullable(((ScriptTrackPOJO)object).getScriptTrackMetaDataList());
        object = new c(l11, appDatabaseTemplate);
        optional.ifPresent((Consumer<List>)object);
    }

    public static /* synthetic */ void d(long l10, AppDatabaseTemplate appDatabaseTemplate, List object) {
        object = object.stream();
        e e10 = new e(l10, appDatabaseTemplate);
        object.peek(e10).count();
    }

    public static /* synthetic */ void e(long l10, AppDatabaseTemplate appDatabaseTemplate, ScriptTrackMetaData scriptTrackMetaData) {
        scriptTrackMetaData.setTrackMetadataId(l10);
        appDatabaseTemplate.scriptTrackMetaDataDao().insert(scriptTrackMetaData);
    }

    public static /* synthetic */ void f(ScriptTrackPOJODao scriptTrackPOJODao, long l10, ScriptTrackPOJO scriptTrackPOJO) {
        scriptTrackPOJODao.insertScriptTrack(scriptTrackPOJO, l10);
    }

    default public void insertScriptTrack(ScriptTrackPOJO scriptTrackPOJO, long l10) {
        if (scriptTrackPOJO == null) {
            return;
        }
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        AppDatabaseTemplate appDatabaseTemplate = DatabaseHelperTemplate.getInstance().getDataBase();
        ScriptTrack scriptTrack = scriptTrackPOJO.getScriptTrack();
        Optional<ScriptTrack> optional = Optional.ofNullable(scriptTrack);
        a a10 = new a(scriptTrack, l10, appDatabaseTemplate, scriptTrackPOJO);
        optional.ifPresent(a10);
    }

    default public void insertScriptTrack(List object, long l10) {
        long l11;
        long l12;
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty()) && (bl2 = (l12 = l10 - (l11 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            object = object.stream();
            f f10 = new f(this, l10);
            object.forEach(f10);
        }
    }
}

