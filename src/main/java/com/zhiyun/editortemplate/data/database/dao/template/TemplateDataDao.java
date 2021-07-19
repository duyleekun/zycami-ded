/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.core.util.Pair;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import d.v.j.e.f.b.e.a;
import d.v.j.e.f.b.e.b;
import d.v.j.e.f.b.e.c;
import d.v.j.e.f.b.e.d;
import d.v.j.e.f.b.e.e;
import d.v.j.e.f.b.e.f;
import d.v.j.e.f.b.e.g;
import d.v.j.e.f.b.e.h;
import d.v.j.e.f.b.e.i;
import d.v.j.e.f.b.e.j;
import d.v.j.e.f.b.e.k;
import d.v.j.e.f.b.e.l;
import d.v.j.e.f.b.e.m;
import d.v.j.e.f.b.e.n;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface TemplateDataDao
extends BaseDao {
    public static final String DELETE_TEMPLATE_DATA = "DELETE FROM TemplateData WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) ";
    public static final String ORDER = " ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
    public static final String ORDER_BY_PARAM = "ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN :ascDownloadTime THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN :ascDownloadTime THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ";
    public static final String RESTRICT_DOWNLOAD_FINISHED = " (:download IS NULL OR TemplateData.download_finished == :download) ";
    public static final String RESTRICT_TEMPLATE_VIDEO_SIZE = " (:videoSize IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= :videoSize)) ";
    public static final String RESTRICT_VIDEO_RATIO = " (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) ";
    public static final String SELECT_TEMPLATE_DATA = "SELECT * FROM TemplateData WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY id DESC";
    public static final String SELECT_TEMPLATE_DATA_FROM_ID = "SELECT * FROM TemplateData WHERE id = :templateDataId";
    public static final String SELECT_TEMPLATE_DATA_FROM_IDS = "SELECT * FROM TemplateData WHERE id IN (:templateDataIds)";
    public static final String SELECT_TEMPLATE_DATA_IDS = "SELECT TemplateData.id FROM TemplateData WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY id DESC";
    public static final String SELECT_TEMPLATE_DATA_SORT = "SELECT * FROM TemplateData WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  AND  (:videoSize IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= :videoSize)) ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN :ascDownloadTime THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN :ascDownloadTime THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ";
    public static final String SELECT_TEMPLATE_DATA_SORT_FROM_ARRAY = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (:tempType) AND TemplateData.template_use_type IN (:templateUseType) AND TemplateData.template_proto_type IN (:editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END,TemplateData.download_timestamp,TemplateData.id DESC ";
    public static final String UPDATE_TEMPLATE_DATA_SET_FIRST_LOADED = "UPDATE TemplateData SET first_loaded = :firstLoaded WHERE id == :templateDataId";
    public static final String UPDATE_TEMPLATE_DATA_SET_NAME = "UPDATE TemplateData SET title_zh = :textZh , title_tw = :textZhTw, title_en = :textEn WHERE id == :templateDataId";
    public static final String WHERE_TEMPLATE_DATA_FROM_TYPE = " WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) ";
    public static final String WHERE_TEMPLATE_DATA_FROM_TYPE_ARRAY = " WHERE TemplateData.temp_type IN (:tempType) AND TemplateData.template_use_type IN (:templateUseType) AND TemplateData.template_proto_type IN (:editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) ";
    public static final String WHERE_TEMPLATE_DATA_FROM_TYPE_RESTRICT_TEMPLATE_VIDEO_SIZE = " WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  AND  (:videoSize IS NULL OR TemplateData.id IN (SELECT temp_id FROM TemplateVideo GROUP BY temp_id HAVING COUNT(*) <= :videoSize)) ";

    public static /* synthetic */ void c(TemplateDataDao baseDao, long l10, boolean bl2, AppDatabaseTemplate appDatabaseTemplate, boolean bl3, AtomicLong atomicLong, Template template) {
        template.setTempId(l10);
        if (bl2) {
            baseDao = appDatabaseTemplate.templateDao();
            baseDao.replace(template);
        } else {
            boolean bl4;
            G_TemplateDao g_TemplateDao = appDatabaseTemplate.templateDao();
            l10 = g_TemplateDao.insert(template);
            if (bl3 && !(bl4 = baseDao.checkInsertSuccessful(l10))) {
                baseDao = appDatabaseTemplate.templateDao();
                baseDao.update(template);
                long l11 = template.getId();
                atomicLong.set(l11);
            } else {
                atomicLong.set(l10);
            }
        }
    }

    public static /* synthetic */ void d(TemplateDataDao templateDataDao, boolean bl2, AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, boolean bl3, TemplateData templateData) {
        boolean bl4;
        long l10;
        if (bl2) {
            G_TemplateDataDao g_TemplateDataDao = appDatabaseTemplate.templateDataDao();
            l10 = g_TemplateDataDao.replace(templateData);
            atomicLong.set(l10);
        } else {
            G_TemplateDataDao g_TemplateDataDao = appDatabaseTemplate.templateDataDao();
            l10 = g_TemplateDataDao.insert(templateData);
            atomicLong.set(l10);
        }
        if (bl3 && !(bl4 = templateDataDao.checkInsertSuccessful(l10 = atomicLong.get()))) {
            templateDataDao = appDatabaseTemplate.templateDataDao();
            templateDataDao.update(templateData);
            long l11 = templateData.getId();
            atomicLong.set(l11);
        }
    }

    public static /* synthetic */ void e(AtomicLong atomicLong, TemplateSticker templateSticker) {
        long l10 = atomicLong.get();
        templateSticker.setTempId(l10);
    }

    public static /* synthetic */ void f(AtomicLong atomicLong, TemplateVideo templateVideo) {
        long l10 = atomicLong.get();
        templateVideo.setTempId(l10);
    }

    public static /* synthetic */ void g(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, TemplateGlobal templateGlobal) {
        long l10 = atomicLong.get();
        templateGlobal.setTempId(l10);
        appDatabaseTemplate.templateGlobalDao().insert(templateGlobal);
    }

    public static /* synthetic */ void i(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, List list) {
        Stream stream = list.stream();
        m m10 = new m(atomicLong);
        stream.forEach(m10);
        appDatabaseTemplate.templateStickerDao().insert(list);
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ void j(TemplateDataDao object, boolean bl2, boolean n10, TemplatePOJO object2, TemplateData templateData) {
        IllegalArgumentException illegalArgumentException;
        int n11;
        int n12;
        block8: {
            int n13;
            float f10;
            float f11;
            block9: {
                block10: {
                    Object object3;
                    block5: {
                        block6: {
                            block7: {
                                void var4_6;
                                long l10;
                                if (!bl2 && n12 != 0 && (n11 = (int)(object.checkInsertSuccessful(l10 = var4_6.getId()) ? 1 : 0)) != 0) {
                                    return;
                                }
                                n11 = var4_6.getTemplateUseType();
                                boolean bl3 = false;
                                f11 = 0.0f;
                                illegalArgumentException = null;
                                n12 = 1;
                                f10 = Float.MIN_VALUE;
                                if (n11 == 0) break block5;
                                if (n11 == n12) break block6;
                                int n14 = 2;
                                if (n11 == n14) break block7;
                                n14 = 3;
                                if (n11 != n14) break block8;
                                if ((object3 = ((TemplatePOJO)object3).getDraft()) != null) break block9;
                                break block10;
                            }
                            if ((object3 = ((TemplatePOJO)object3).getWithdraw()) != null) break block9;
                            break block10;
                        }
                        if ((object3 = ((TemplatePOJO)object3).getScript()) != null) break block9;
                        break block10;
                    }
                    if ((object3 = ((TemplatePOJO)object3).getTemplate()) != null) break block9;
                }
                n13 = n12;
                f11 = f10;
            }
            n12 = n13;
            f10 = f11;
        }
        if (n12 == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u4e0d\u5b58\u5728\u5bf9\u5e94\u7684\u7d22\u5f15\u8868, TemplateData.getTemplateUseType() = ");
        stringBuilder.append(n11);
        object = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static /* synthetic */ void k(AppDatabaseTemplate object, List list, AtomicLong atomicLong, List list2) {
        object = ((AppDatabaseTemplate)object).scriptTrackPOJODao();
        long l10 = atomicLong.get();
        object.insertScriptTrack(list, l10);
    }

    public static /* synthetic */ void l(TemplateDataDao baseDao, Script object, long l10, boolean bl2, AppDatabaseTemplate appDatabaseTemplate, boolean bl3, AtomicLong atomicLong, Script script) {
        ((Script)object).setScriptId(l10);
        if (bl2) {
            baseDao = appDatabaseTemplate.scriptDao();
            baseDao.replace(script);
        } else {
            boolean bl4;
            object = appDatabaseTemplate.scriptDao();
            long l11 = object.insert(script);
            if (bl3 && !(bl4 = baseDao.checkInsertSuccessful(l11))) {
                baseDao = appDatabaseTemplate.scriptDao();
                baseDao.update(script);
                long l12 = script.getId();
                atomicLong.set(l12);
            } else {
                atomicLong.set(l11);
            }
        }
    }

    public static /* synthetic */ void m(AtomicLong atomicLong, TemplateMusic templateMusic) {
        long l10 = atomicLong.get();
        templateMusic.setTempId(l10);
    }

    public static /* synthetic */ void n(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, List list) {
        Stream stream = list.stream();
        k k10 = new k(atomicLong);
        stream.forEach(k10);
        appDatabaseTemplate.templateRecordingDao().insert(list);
    }

    public static /* synthetic */ void o(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, List list) {
        Stream stream = list.stream();
        j j10 = new j(atomicLong);
        stream.forEach(j10);
        appDatabaseTemplate.templateVideoDao().insert(list);
    }

    public static /* synthetic */ void p(AtomicLong atomicLong, TemplateRecording templateRecording) {
        long l10 = atomicLong.get();
        templateRecording.setTempId(l10);
    }

    public static /* synthetic */ void q(AtomicLong atomicLong, AppDatabaseTemplate appDatabaseTemplate, List list) {
        Stream stream = list.stream();
        f f10 = new f(atomicLong);
        stream.forEach(f10);
        appDatabaseTemplate.templateMusicDao().insert(list);
    }

    default public void checkAutoGenerateId(boolean bl2, boolean bl3, Long l10, Class object) {
        long l11;
        long l12;
        long l13;
        if (l10 == null) {
            return;
        }
        if (!bl2 && !bl3 && (bl2 = (l13 = (l12 = l10.longValue()) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("\u5982\u679c\u4e0d\u8fdb\u884c\u51b2\u7a81\u66ff\u6362\u4e5f\u4e0d\u8fdb\u884c\u66f4\u65b0\u7684\u8bdd,");
            object = ((Class)object).getName();
            charSequence.append((String)object);
            charSequence.append(" \u4e0d\u80fd\u5b58\u5728\u4e3b\u952e\u503c,\u4f46\u662f id = ");
            charSequence.append(l10);
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
    }

    default public boolean checkInsertSuccessful(long l10) {
        long l11 = this.getInitId();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    default public void checkTemplateData(boolean bl2, boolean bl3, TemplateData object) {
        if (object != null) {
            object = ((TemplateData)object).getId();
            this.checkAutoGenerateId(bl2, bl3, (Long)object, TemplateData.class);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\u53c2\u6570\u5f02\u5e38, \u56e0\u4e3a TemplateData = null");
        throw illegalArgumentException;
    }

    default public void checkTemplateIndex(boolean bl2, boolean bl3, TemplatePOJO object) {
        if (object != null) {
            int n10;
            int n11;
            Object object2 = Optional.ofNullable(((TemplatePOJO)object).getTemplateData());
            Object object3 = new c(this, bl2, bl3, (TemplatePOJO)object);
            ((Optional)object2).ifPresent((Consumer<TemplateData>)object3);
            object2 = ((TemplatePOJO)object).getDraft();
            int n12 = 1;
            int n13 = 0;
            Class clazz = null;
            if (object2 == null) {
                n11 = 0;
                object2 = null;
            } else {
                n11 = n12;
            }
            n11 += 0;
            Object object4 = ((TemplatePOJO)object).getTemplate();
            if (object4 == null) {
                n10 = 0;
                object4 = null;
            } else {
                n10 = n12;
            }
            n11 += n10;
            object4 = ((TemplatePOJO)object).getScript();
            if (object4 == null) {
                n10 = 0;
                object4 = null;
            } else {
                n10 = n12;
            }
            n11 += n10;
            object4 = ((TemplatePOJO)object).getWithdraw();
            if (object4 != null) {
                n13 = n12;
            }
            if ((n11 += n13) == n12) {
                long l10;
                object2 = ((TemplatePOJO)object).getDraft();
                n12 = 0;
                object3 = null;
                if (object2 == null) {
                    n11 = 0;
                    object2 = null;
                } else {
                    l10 = ((TemplatePOJO)object).getDraft().getId();
                    object2 = l10;
                }
                clazz = Draft.class;
                this.checkAutoGenerateId(bl2, bl3, (Long)object2, clazz);
                object2 = ((TemplatePOJO)object).getTemplate();
                if (object2 == null) {
                    n11 = 0;
                    object2 = null;
                } else {
                    l10 = ((TemplatePOJO)object).getTemplate().getId();
                    object2 = l10;
                }
                clazz = Template.class;
                this.checkAutoGenerateId(bl2, bl3, (Long)object2, clazz);
                object2 = ((TemplatePOJO)object).getScript();
                if (object2 == null) {
                    n11 = 0;
                    object2 = null;
                } else {
                    l10 = ((TemplatePOJO)object).getScript().getId();
                    object2 = l10;
                }
                clazz = Script.class;
                this.checkAutoGenerateId(bl2, bl3, (Long)object2, clazz);
                object2 = ((TemplatePOJO)object).getWithdraw();
                if (object2 != null) {
                    object = ((TemplatePOJO)object).getWithdraw();
                    long l11 = ((Withdraw)object).getId();
                    object3 = l11;
                }
                this.checkAutoGenerateId(bl2, bl3, (Long)object3, Withdraw.class);
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("\u7d22\u5f15\u6570\u91cf\u4e0d\u4e3a1, \u7d22\u5f15\u4e2a\u6570\u4e3a:");
            charSequence.append(n11);
            charSequence.append(" , Draft:");
            object2 = ((TemplatePOJO)object).getDraft();
            charSequence.append(object2);
            charSequence.append(" , Template:");
            object2 = ((TemplatePOJO)object).getTemplate();
            charSequence.append(object2);
            charSequence.append(" , Script:");
            object2 = ((TemplatePOJO)object).getScript();
            charSequence.append(object2);
            charSequence.append(" , Withdraw:");
            object = ((TemplatePOJO)object).getWithdraw();
            charSequence.append(object);
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\u53c2\u6570\u5f02\u5e38, \u56e0\u4e3a templatePOJO = null");
        throw illegalArgumentException;
    }

    public int deleteTemplateData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public int deletedTemplateFromTemplateDataIds(long ... var1);

    default public long getInitId() {
        return -1;
    }

    public List getSortTemplateData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public List getSortTemplateDataFromNonNullParam(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public List getSortTemplatePOJO(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public List getSortTemplatePOJOFromNonNullParam(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public TemplatePOJO getTemplate(long var1);

    public Long getTemplateCount(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, Integer var6);

    public List getTemplateData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public List getTemplateDataIds(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public List getTemplatePOJO(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public List getTemplatePOJO(List var1);

    default public long insertOrReplaceTemplateConfig(TemplatePOJO object, boolean bl2, boolean bl3) {
        Object object2 = ((TemplatePOJO)object).getTemplateData();
        Object object3 = object == null ? null : object2;
        this.checkTemplateData(bl2, bl3, (TemplateData)object3);
        long l10 = this.getInitId();
        object3 = new AtomicLong(l10);
        AppDatabaseTemplate appDatabaseTemplate = DatabaseHelperTemplate.getInstance().getDataBase();
        object2 = Optional.ofNullable(object2);
        g g10 = new g(this, bl2, (AtomicLong)object3, appDatabaseTemplate, bl3);
        ((Optional)object2).ifPresent(g10);
        Optional<Object> optional = Optional.ofNullable(((TemplatePOJO)object).getTemplateGlobal());
        Consumer consumer = new n((AtomicLong)object3, appDatabaseTemplate);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(((TemplatePOJO)object).getTemplateVideoList());
        consumer = new e((AtomicLong)object3, appDatabaseTemplate);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(((TemplatePOJO)object).getTemplateStickerList());
        consumer = new d((AtomicLong)object3, appDatabaseTemplate);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(((TemplatePOJO)object).getTemplateMusicList());
        consumer = new a((AtomicLong)object3, appDatabaseTemplate);
        optional.ifPresent(consumer);
        optional = Optional.ofNullable(((TemplatePOJO)object).getTemplateRecordingList());
        consumer = new i((AtomicLong)object3, appDatabaseTemplate);
        optional.ifPresent(consumer);
        object = ((TemplatePOJO)object).getScriptTrackPOJOList();
        optional = Optional.ofNullable(object);
        consumer = new h(appDatabaseTemplate, (List)object, (AtomicLong)object3);
        optional.ifPresent(consumer);
        return ((AtomicLong)object3).get();
    }

    default public Pair insertOrUpdateAll(TemplatePOJO object, boolean bl2, boolean bl3) {
        this.checkTemplateIndex(bl2, bl3, (TemplatePOJO)object);
        Object object2 = ((TemplatePOJO)object).getTemplateData();
        this.checkTemplateData(bl2, bl3, (TemplateData)object2);
        long l10 = this.insertOrReplaceTemplateConfig((TemplatePOJO)object, bl2, bl3);
        long l11 = this.insertOrUpdateTemplateIndex((TemplatePOJO)object, bl2, bl3, l10);
        object2 = l10;
        object = l11;
        Pair pair = new Pair(object2, object);
        return pair;
    }

    default public long insertOrUpdateTemplateIndex(TemplatePOJO templatePOJO, boolean bl2, boolean bl3, long l10) {
        Object object;
        Optional<Script> optional = this;
        boolean bl4 = this.checkInsertSuccessful(l10);
        if (!bl4) {
            return this.getInitId();
        }
        this.checkTemplateIndex(bl2, bl3, templatePOJO);
        long l11 = this.getInitId();
        AtomicLong atomicLong = new AtomicLong(l11);
        AppDatabaseTemplate appDatabaseTemplate = DatabaseHelperTemplate.getInstance().getDataBase();
        Object object2 = Optional.ofNullable(templatePOJO.getTemplate());
        Consumer consumer = object;
        optional = object2;
        object2 = atomicLong;
        object = new l(this, l10, bl2, appDatabaseTemplate, bl3, atomicLong);
        optional.ifPresent((Consumer<Script>)object);
        Script script = templatePOJO.getScript();
        optional = Optional.ofNullable(script);
        object = appDatabaseTemplate;
        consumer = new b(this, script, l10, bl2, appDatabaseTemplate, bl3, atomicLong);
        optional.ifPresent(consumer);
        return atomicLong.get();
    }

    public TemplateData loadTemplate(long var1);

    public List queryAll();

    public void renameTemplate(long var1, String var3, String var4, String var5);

    public void updateFirstLoaded(long var1, boolean var3);
}

