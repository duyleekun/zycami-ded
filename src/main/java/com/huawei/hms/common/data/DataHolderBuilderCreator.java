/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 */
package com.huawei.hms.common.data;

import android.content.ContentValues;
import com.huawei.hms.common.data.DataHolder$Builder;
import java.util.HashMap;

public final class DataHolderBuilderCreator
extends DataHolder$Builder {
    public DataHolderBuilderCreator(String[] stringArray, String string2) {
        super(stringArray, (String)null, (DataHolderBuilderCreator)null);
    }

    public final DataHolder$Builder setDataForContentValuesHashMap(HashMap serializable) {
        serializable = new UnsupportedOperationException("DataHolderBuilderCreator unsupported setDataForContentValuesHashMap");
        throw serializable;
    }

    public final DataHolder$Builder withRow(ContentValues object) {
        object = new UnsupportedOperationException("DataHolderBuilderCreator unsupported withRow");
        throw object;
    }
}

