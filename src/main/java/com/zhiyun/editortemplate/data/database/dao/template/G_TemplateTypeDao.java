/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateTypeDao;
import e.a.i0;
import e.a.z;
import java.util.List;

public interface G_TemplateTypeDao
extends TemplateTypeDao {
    public LiveData getAllTemplateType_LiveData(List var1);

    public z getAllTemplateType_Observable(List var1);

    public i0 getAllTemplateType_Single(List var1);

    public LiveData getTemplateTypeFromTemplateDataNonNullParam_LiveData(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public z getTemplateTypeFromTemplateDataNonNullParam_Observable(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public i0 getTemplateTypeFromTemplateDataNonNullParam_Single(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public LiveData getTemplateTypeFromTemplateData_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public z getTemplateTypeFromTemplateData_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public i0 getTemplateTypeFromTemplateData_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public LiveData getTemplateTypeIdsFromTemplateData_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public z getTemplateTypeIdsFromTemplateData_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public i0 getTemplateTypeIdsFromTemplateData_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public LiveData getTemplateTypeIds_LiveData(Integer var1, Integer var2);

    public z getTemplateTypeIds_Observable(Integer var1, Integer var2);

    public i0 getTemplateTypeIds_Single(Integer var1, Integer var2);

    public LiveData getTemplateType_LiveData(long var1);

    public LiveData getTemplateType_LiveData(Integer var1, Integer var2);

    public z getTemplateType_Observable(long var1);

    public z getTemplateType_Observable(Integer var1, Integer var2);

    public i0 getTemplateType_Single(long var1);

    public i0 getTemplateType_Single(Integer var1, Integer var2);
}

