/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.lifecycle.LiveData;
import com.zhiyun.editortemplate.data.database.dao.template.TemplateDataDao;
import e.a.i0;
import e.a.z;
import java.util.List;

public interface G_TemplateDataDao
extends TemplateDataDao {
    public i0 deleteTemplateData_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public LiveData getSortTemplateDataFromNonNullParam_LiveData(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public z getSortTemplateDataFromNonNullParam_Observable(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public i0 getSortTemplateDataFromNonNullParam_Single(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public LiveData getSortTemplateData_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public z getSortTemplateData_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public i0 getSortTemplateData_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public LiveData getSortTemplatePOJOFromNonNullParam_LiveData(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public z getSortTemplatePOJOFromNonNullParam_Observable(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public i0 getSortTemplatePOJOFromNonNullParam_Single(int[] var1, int[] var2, int[] var3, Boolean var4, String var5);

    public LiveData getSortTemplatePOJO_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public z getSortTemplatePOJO_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public i0 getSortTemplatePOJO_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, boolean var6, Integer var7);

    public LiveData getTemplateCount_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, Integer var6);

    public z getTemplateCount_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, Integer var6);

    public i0 getTemplateCount_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5, Integer var6);

    public LiveData getTemplateDataIds_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public z getTemplateDataIds_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public i0 getTemplateDataIds_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public LiveData getTemplateData_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public z getTemplateData_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public i0 getTemplateData_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public LiveData getTemplatePOJO_LiveData(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public LiveData getTemplatePOJO_LiveData(List var1);

    public z getTemplatePOJO_Observable(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public z getTemplatePOJO_Observable(List var1);

    public i0 getTemplatePOJO_Single(Integer var1, Integer var2, Integer var3, Boolean var4, String var5);

    public i0 getTemplatePOJO_Single(List var1);

    public LiveData getTemplate_LiveData(long var1);

    public z getTemplate_Observable(long var1);

    public i0 getTemplate_Single(long var1);

    public LiveData loadTemplate_LiveData(long var1);

    public z loadTemplate_Observable(long var1);

    public i0 loadTemplate_Single(long var1);

    public LiveData queryAll_LiveData();

    public z queryAll_Observable();

    public i0 queryAll_Single();
}

