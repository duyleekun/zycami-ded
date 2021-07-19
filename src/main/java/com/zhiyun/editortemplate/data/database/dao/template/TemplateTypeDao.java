/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import java.util.List;

public interface TemplateTypeDao
extends BaseDao {
    public static final String ORDER = " ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_FROM_TEMPLATE_DATA = " JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_FROM_TEMPLATE_DATA_ARRAY = " JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE TemplateData.temp_type IN (:tempType) AND TemplateData.template_use_type IN (:templateUseType) AND TemplateData.template_proto_type IN (:editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_TEMPLATE_TYPE = "SELECT * FROM TemplateType WHERE (:tempType IS NULL OR TemplateType.resource_type == :tempType) AND (:editorProtoType IS NULL OR TemplateType.template_proto_type == :editorProtoType) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_TEMPLATE_TYPE_FROM_TEMPLATE_DATA = "SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_TEMPLATE_TYPE_FROM_TEMPLATE_DATA_ARRAY = "SELECT DISTINCT TemplateType.* FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE TemplateData.temp_type IN (:tempType) AND TemplateData.template_use_type IN (:templateUseType) AND TemplateData.template_proto_type IN (:editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_TEMPLATE_TYPE_IDS = "SELECT DISTINCT TemplateType.id FROM TemplateType WHERE (:tempType IS NULL OR TemplateType.resource_type == :tempType) AND (:editorProtoType IS NULL OR TemplateType.template_proto_type == :editorProtoType) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String QUERY_TEMPLATE_TYPE_IDS_FROM_TEMPLATE_DATA = "SELECT DISTINCT TemplateType.id FROM TemplateType JOIN Template ON TemplateType.id == Template.type_id JOIN TemplateData ON Template.temp_id == TemplateData.id WHERE (:tempType IS NULL OR TemplateData.temp_type == :tempType) AND (:templateUseType IS NULL OR TemplateData.template_use_type == :templateUseType) AND (:editorProtoType IS NULL OR TemplateData.template_proto_type == :editorProtoType) AND  (:download IS NULL OR TemplateData.download_finished == :download)  AND  (:videoRatio IS NULL OR TemplateData.video_ratio == :videoRatio)  ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";
    public static final String WHERE_TEMPLATE_TYPE = " WHERE (:tempType IS NULL OR TemplateType.resource_type == :tempType) AND (:editorProtoType IS NULL OR TemplateType.template_proto_type == :editorProtoType) ORDER BY CASE WHEN TemplateType.resource_type == -1 THEN 0 ELSE 1 END,TemplateType.id DESC";

    public void delete(long var1);

    public List getAllTemplateType(List var1);

    public TemplateType getTemplateType(long var1);

    public List getTemplateType(Integer var1, Integer var2);

    public List getTemplateTypeFromTemplateData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public List getTemplateTypeFromTemplateDataNonNullParam(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public List getTemplateTypeIds(Integer var1, Integer var2);

    public List getTemplateTypeIdsFromTemplateData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    default public void updateOrInsert(TemplateType templateType) {
        long l10 = templateType.getId();
        TemplateType templateType2 = this.getTemplateType(l10);
        if (templateType2 == null) {
            this.insert(templateType);
        } else {
            this.update(templateType);
        }
    }
}

