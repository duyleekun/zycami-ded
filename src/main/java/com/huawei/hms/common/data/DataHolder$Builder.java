/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.os.Bundle
 */
package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.huawei.hms.common.data.DataHolder;
import com.huawei.hms.common.data.DataHolder$1;
import com.huawei.hms.common.data.DataHolderBuilderCreator;
import com.huawei.hms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataHolder$Builder {
    private String[] builderColumns;
    private final ArrayList dataCollectionList;
    private final String type;
    private final HashMap typeAndDataCollectionCountMapping;

    private DataHolder$Builder(String[] object, String string2) {
        Preconditions.checkNotNull(object, "builderColumnsP cannot be null");
        this.builderColumns = object;
        this.dataCollectionList = object;
        this.type = string2;
        super();
        this.typeAndDataCollectionCountMapping = object;
    }

    public /* synthetic */ DataHolder$Builder(String[] stringArray, String string2, DataHolder$1 dataHolder$1) {
        this(stringArray, string2);
    }

    public DataHolder$Builder(String[] stringArray, String string2, DataHolderBuilderCreator dataHolderBuilderCreator) {
        this(stringArray, null);
    }

    public static /* synthetic */ String[] access$200(DataHolder$Builder dataHolder$Builder) {
        return dataHolder$Builder.builderColumns;
    }

    public static /* synthetic */ ArrayList access$300(DataHolder$Builder dataHolder$Builder) {
        return dataHolder$Builder.dataCollectionList;
    }

    public DataHolder build(int n10) {
        DataHolder dataHolder = new DataHolder(this, n10, null, null);
        return dataHolder;
    }

    public DataHolder build(int n10, Bundle bundle) {
        DataHolder dataHolder = new DataHolder(this, n10, bundle, -1, null);
        return dataHolder;
    }

    /*
     * Unable to fully structure code
     */
    public DataHolder$Builder setDataForContentValuesHashMap(HashMap var1_1) {
        Preconditions.checkNotNull(var1_1, "contentValuesHashMap cannot be null");
        var2_2 = this.type;
        var3_3 = 0;
        var4_4 = null;
        if (var2_2 == null || (var2_2 = var1_1.get(var2_2)) == null) ** GOTO lbl18
        var5_5 = (Integer)this.typeAndDataCollectionCountMapping.get(var2_2);
        if (var5_5 != null) {
            var6_6 = var3_3 = var5_5.intValue();
            var3_3 = 1;
            var7_7 = var6_6;
        } else {
            var5_5 = this.typeAndDataCollectionCountMapping;
            var8_8 = this.dataCollectionList.size();
            var9_9 = var8_8;
            var5_5.put(var2_2, var9_9);
lbl18:
            // 2 sources

            var7_7 = 0;
            var2_2 = null;
        }
        if (var3_3 != 0) {
            this.dataCollectionList.remove(var7_7);
            var4_4 = this.dataCollectionList;
            var4_4.add(var7_7, var1_1);
        } else {
            var2_2 = this.dataCollectionList;
            var2_2.add(var1_1);
        }
        return this;
    }

    public DataHolder$Builder withRow(ContentValues object) {
        Preconditions.checkNotNull(object, "contentValues cannot be null");
        int n10 = object.size();
        HashMap hashMap = new HashMap(n10);
        object = object.valueSet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            hashMap.put(k10, entry);
        }
        return this.setDataForContentValuesHashMap(hashMap);
    }
}

