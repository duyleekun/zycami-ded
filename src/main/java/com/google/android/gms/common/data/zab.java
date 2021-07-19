/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 */
package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder$Builder;
import java.util.HashMap;

public final class zab
extends DataHolder$Builder {
    public zab(String[] stringArray, String string2) {
        super(stringArray, null, null);
    }

    public final DataHolder$Builder withRow(ContentValues object) {
        object = new UnsupportedOperationException("Cannot add data to empty builder");
        throw object;
    }

    public final DataHolder$Builder zaa(HashMap serializable) {
        serializable = new UnsupportedOperationException("Cannot add data to empty builder");
        throw serializable;
    }
}

