/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.api.entity.template.Description;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import java.util.List;

public interface TemplateDao
extends BaseDao {
    public static final String AND_TYPE = "AND TemplateData.id IN (SELECT Template.temp_id FROM Template WHERE Template.type_id == :templateTypeId)";
    public static final String EDITOR_QUERY_TEMPLATE = "SELECT * FROM TemplateData WHERE TemplateData.id = (SELECT Template.temp_id FROM Template WHERE Template.id = :templateId)";
    public static final String EDITOR_QUERY_TEMPLATE_FROM_REFERENCE_ID = "SELECT * FROM TemplateData WHERE TemplateData.id = (SELECT Template.temp_id FROM Template WHERE Template.reference_id = :referenceId AND TemplateData.template_proto_type == :templateProtocolType )";
    public static final String SELECT_COUNT_FROM_TEMPLATE_WHERE_TYPE_ID_TYPE_ID = "SELECT COUNT(*) FROM Template WHERE type_id == :typeId";
    public static final String SELECT_FROM_TEMPLATE_DATA = "SELECT * FROM TemplateData WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) AND TemplateData.id IN (SELECT Template.temp_id FROM Template WHERE Template.type_id == :templateTypeId)ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN :ascDownloadTime THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN :ascDownloadTime THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ";
    public static final String SELECT_FROM_TEMPLATE_DATA_ARRAY = "SELECT * FROM TemplateData WHERE TemplateData.temp_type IN (:tempType) AND TemplateData.template_use_type IN (:templateUseType) AND TemplateData.template_proto_type IN (:editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) AND TemplateData.id IN (SELECT Template.temp_id FROM Template WHERE Template.type_id == :templateTypeId)ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN :ascDownloadTime THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN :ascDownloadTime THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ";
    public static final String SELECT_TEMPLATE_DATA_IDS = "SELECT TemplateData.id FROM TemplateData WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio) AND TemplateData.id IN (SELECT Template.temp_id FROM Template WHERE Template.type_id == :templateTypeId)ORDER BY TemplateData.download_finished DESC, CASE WHEN TemplateData.temp_type == -1 THEN 0 ELSE 1 END, CASE WHEN :ascDownloadTime THEN TemplateData.download_timestamp ELSE 0 END, CASE WHEN :ascDownloadTime THEN 0 ELSE TemplateData.download_timestamp END DESC, TemplateData.id DESC ";

    public TemplatePOJO getEditorTemplate(long var1);

    public TemplatePOJO getEditorTemplateFromReferenceId(long var1, int var3);

    public List getSortTemplateDataIds(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public long getTemplateCountFromType(long var1);

    public List getTemplatePOJOFromTemplateType(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public List getTemplatePOJOFromTemplateTypeNonNullParam(int[] var1, int[] var2, int[] var3, Boolean var4, String var5, long var6, boolean var8);

    default public void insertDIYTemplate(TemplatePOJO templatePOJO, Description object) {
        if (templatePOJO == null) {
            return;
        }
        Template template = new Template();
        templatePOJO.setTemplate(template);
        AppDatabaseTemplate appDatabaseTemplate = DatabaseHelperTemplate.getInstance().getDataBase();
        long l10 = -999L;
        if (object == null) {
            String string2 = "\u6211\u7684";
            String string3 = "Mine";
            object = new Description(string2, string3, string2);
        }
        String string4 = ((Description)object).getZh();
        String string5 = ((Description)object).getZh_tw();
        String string6 = ((Description)object).getEn();
        object = TemplateType.create(-999L, string4, string5, string6, -2, 0);
        appDatabaseTemplate.templateTypeDao().insert(object);
        template.setTypeId(l10);
        DatabaseHelperTemplate.getInstance().getDataBase().templateDataDao().insertOrUpdateAll(templatePOJO, false, false);
    }

    default public long insertNetworkTemplateData(TemplatePOJO templatePOJO, long l10) {
        Template template = templatePOJO.getTemplate();
        template.setTypeId(l10);
        Object object = templatePOJO.getTemplateData();
        long l11 = template.getReferenceId();
        int n10 = ((TemplateData)object).getTemplateProtocolType();
        TemplatePOJO templatePOJO2 = this.getEditorTemplateFromReferenceId(l11, n10);
        if (templatePOJO2 != null) {
            Object object2 = templatePOJO2.getTemplateData();
            long l12 = ((TemplateData)object2).getId();
            ((TemplateData)object).setId(l12);
            boolean bl2 = ((TemplateData)object2).isDownloadFinished();
            ((TemplateData)object).setDownloadFinished(bl2);
            object2 = ((TemplateData)object2).getDownloadTimestamp();
            ((TemplateData)object).setDownloadTimestamp((Long)object2);
            object = templatePOJO2.getTemplate();
            l11 = ((Template)object).getId();
            template.setId(l11);
            l11 = ((Template)object).getTypeId();
            template.setTypeId(l11);
            l10 = ((Template)object).getTempId();
            template.setTempId(l10);
        }
        return (Long)DatabaseHelperTemplate.getInstance().getDataBase().templateDataDao().insertOrUpdateAll((TemplatePOJO)templatePOJO, (boolean)false, (boolean)true).first;
    }
}

