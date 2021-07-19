/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.search;

import cn.leancloud.types.AVGeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AVSearchSortBuilder {
    private final List sortFields;

    public AVSearchSortBuilder() {
        ArrayList arrayList;
        this.sortFields = arrayList = new ArrayList();
    }

    private AVSearchSortBuilder addField(String string2, String charSequence, String string3, String string4) {
        HashMap hashMap = new HashMap();
        HashMap<String, CharSequence> hashMap2 = new HashMap<String, CharSequence>();
        hashMap2.put("order", charSequence);
        hashMap2.put("mode", string3);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("_");
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        hashMap2.put("missing", charSequence);
        hashMap.put(string2, hashMap2);
        this.sortFields.add(hashMap);
        return this;
    }

    public static AVSearchSortBuilder newBuilder() {
        AVSearchSortBuilder aVSearchSortBuilder = new AVSearchSortBuilder();
        return aVSearchSortBuilder;
    }

    public List getSortFields() {
        return this.sortFields;
    }

    public AVSearchSortBuilder orderByAscending(String string2) {
        return this.orderByAscending(string2, "avg");
    }

    public AVSearchSortBuilder orderByAscending(String string2, String string3) {
        return this.orderByAscending(string2, string3, "last");
    }

    public AVSearchSortBuilder orderByAscending(String string2, String string3, String string4) {
        return this.addField(string2, "asc", string3, string4);
    }

    public AVSearchSortBuilder orderByDescending(String string2) {
        return this.orderByDescending(string2, "avg");
    }

    public AVSearchSortBuilder orderByDescending(String string2, String string3) {
        return this.orderByDescending(string2, string3, "last");
    }

    public AVSearchSortBuilder orderByDescending(String string2, String string3, String string4) {
        return this.addField(string2, "desc", string3, string4);
    }

    public AVSearchSortBuilder whereNear(String string2, AVGeoPoint aVGeoPoint) {
        return this.whereNear(string2, aVGeoPoint, "asc");
    }

    public AVSearchSortBuilder whereNear(String string2, AVGeoPoint aVGeoPoint, String string3) {
        return this.whereNear(string2, aVGeoPoint, string3, "avg", "km");
    }

    public AVSearchSortBuilder whereNear(String string2, AVGeoPoint object, String string3, String string4, String string5) {
        HashMap hashMap = new HashMap();
        HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
        HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
        Double d10 = ((AVGeoPoint)object).getLatitude();
        hashMap3.put("lat", d10);
        object = ((AVGeoPoint)object).getLongitude();
        hashMap3.put("lon", object);
        hashMap2.put(string2, hashMap3);
        hashMap2.put("unit", string5);
        hashMap2.put("mode", string4);
        hashMap2.put("order", string3);
        hashMap.put("_geo_distance", hashMap2);
        this.sortFields.add(hashMap);
        return this;
    }
}

