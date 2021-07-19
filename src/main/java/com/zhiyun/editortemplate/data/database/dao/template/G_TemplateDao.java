/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDao;
import e.a.i0;
import e.a.z;

public interface G_TemplateDao
extends TemplateDao {
    public LiveData getEditorTemplateFromReferenceId_LiveData(long var1, int var3);

    public z getEditorTemplateFromReferenceId_Observable(long var1, int var3);

    public i0 getEditorTemplateFromReferenceId_Single(long var1, int var3);

    public LiveData getEditorTemplate_LiveData(long var1);

    public z getEditorTemplate_Observable(long var1);

    public i0 getEditorTemplate_Single(long var1);

    public LiveData getSortTemplateDataIds_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public z getSortTemplateDataIds_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public i0 getSortTemplateDataIds_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public LiveData getTemplateCountFromType_LiveData(long var1);

    public z getTemplateCountFromType_Observable(long var1);

    public i0 getTemplateCountFromType_Single(long var1);

    public LiveData getTemplatePOJOFromTemplateTypeNonNullParam_LiveData(int[] var1, int[] var2, int[] var3, Boolean var4, String var5, long var6, boolean var8);

    public z getTemplatePOJOFromTemplateTypeNonNullParam_Observable(int[] var1, int[] var2, int[] var3, Boolean var4, String var5, long var6, boolean var8);

    public i0 getTemplatePOJOFromTemplateTypeNonNullParam_Single(int[] var1, int[] var2, int[] var3, Boolean var4, String var5, long var6, boolean var8);

    public LiveData getTemplatePOJOFromTemplateType_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public z getTemplatePOJOFromTemplateType_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);

    public i0 getTemplatePOJOFromTemplateType_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, long var6, boolean var8);
}

