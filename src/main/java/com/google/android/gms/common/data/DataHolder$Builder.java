/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.os.Bundle
 */
package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zab;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataHolder$Builder {
    private final String[] zalq;
    private final ArrayList zalz;
    private final String zama;
    private final HashMap zamb;
    private boolean zamc;
    private String zamd;

    private DataHolder$Builder(String[] object, String string2) {
        object = (String[])Preconditions.checkNotNull(object);
        this.zalq = object;
        this.zalz = object;
        this.zama = string2;
        super();
        this.zamb = object;
        this.zamc = false;
        this.zamd = null;
    }

    public /* synthetic */ DataHolder$Builder(String[] stringArray, String string2, zab zab2) {
        this(stringArray, null);
    }

    public static /* synthetic */ String[] zaa(DataHolder$Builder dataHolder$Builder) {
        return dataHolder$Builder.zalq;
    }

    public static /* synthetic */ ArrayList zab(DataHolder$Builder dataHolder$Builder) {
        return dataHolder$Builder.zalz;
    }

    public DataHolder build(int n10) {
        DataHolder dataHolder = new DataHolder(this, n10, null, null);
        return dataHolder;
    }

    public DataHolder build(int n10, Bundle bundle) {
        DataHolder dataHolder = new DataHolder(this, n10, bundle, -1, null);
        return dataHolder;
    }

    public DataHolder$Builder withRow(ContentValues object) {
        Asserts.checkNotNull(object);
        int n10 = object.size();
        HashMap<String, Map.Entry> hashMap = new HashMap<String, Map.Entry>(n10);
        object = object.valueSet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            String string2 = (String)entry.getKey();
            entry = entry.getValue();
            hashMap.put(string2, entry);
        }
        return this.zaa(hashMap);
    }

    /*
     * Unable to fully structure code
     */
    public DataHolder$Builder zaa(HashMap var1_1) {
        block5: {
            Asserts.checkNotNull(var1_1);
            var2_2 = this.zama;
            var3_3 = -1;
            if (var2_2 == null) lbl-1000:
            // 3 sources

            {
                while (true) {
                    var4_4 = var3_3;
                    break block5;
                    break;
                }
            }
            if ((var2_2 = var1_1.get(var2_2)) == null) ** GOTO lbl-1000
            var5_5 = (Integer)this.zamb.get(var2_2);
            if (var5_5 == null) {
                var5_5 = this.zamb;
                var6_6 = this.zalz.size();
                var7_7 = var6_6;
                var5_5.put(var2_2, var7_7);
                ** continue;
            }
            var4_4 = var5_5.intValue();
        }
        if (var4_4 == var3_3) {
            var2_2 = this.zalz;
            var2_2.add(var1_1);
        } else {
            this.zalz.remove(var4_4);
            var8_8 = this.zalz;
            var8_8.add(var4_4, var1_1);
        }
        this.zamc = false;
        return this;
    }
}

