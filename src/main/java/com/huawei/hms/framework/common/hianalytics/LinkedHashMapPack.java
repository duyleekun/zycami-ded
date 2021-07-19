/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

public class LinkedHashMapPack {
    private LinkedHashMap map;

    public LinkedHashMapPack() {
        LinkedHashMap linkedHashMap;
        this.map = linkedHashMap = new LinkedHashMap();
    }

    public LinkedHashMap getAll() {
        return this.map;
    }

    public LinkedHashMapPack put(String string2, long l10) {
        if (string2 != null) {
            LinkedHashMap linkedHashMap = this.map;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "";
            stringBuilder.append(string3);
            stringBuilder.append(l10);
            String string4 = stringBuilder.toString();
            linkedHashMap.put(string2, string4);
        }
        return this;
    }

    public LinkedHashMapPack put(String string2, String string3) {
        if (string2 != null && string3 != null) {
            LinkedHashMap linkedHashMap = this.map;
            linkedHashMap.put(string2, string3);
        }
        return this;
    }

    public LinkedHashMapPack put(String string2, boolean bl2) {
        if (string2 != null) {
            String string3;
            LinkedHashMap linkedHashMap;
            if (bl2) {
                linkedHashMap = this.map;
                string3 = "1";
            } else {
                linkedHashMap = this.map;
                string3 = "0";
            }
            linkedHashMap.put(string2, string3);
        }
        return this;
    }
}

