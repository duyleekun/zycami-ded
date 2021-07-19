/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.model;

import d.v.e.l.w1;
import java.util.Objects;

public class ResourceData
implements Cloneable {
    private long id;
    private String label;
    private String label_en;
    private String label_tw;
    private long resId;
    private int sort;

    public ResourceData() {
    }

    public ResourceData(long l10, String string2, String string3, String string4, int n10) {
        this.resId = l10;
        this.label = string2;
        this.label_tw = string3;
        this.label_en = string4;
        this.sort = n10;
    }

    public ResourceData clone() {
        long l10 = this.resId;
        String string2 = this.label;
        String string3 = this.label_tw;
        String string4 = this.label_en;
        int n10 = this.sort;
        ResourceData resourceData = new ResourceData(l10, string2, string3, string4, n10);
        return resourceData;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            int n10;
            long l10;
            object = (ResourceData)object;
            long l11 = this.id;
            long l12 = ((ResourceData)object).id;
            long l13 = l11 - l12;
            Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object4 != false || (object4 = (l10 = (l11 = this.resId) - (l12 = ((ResourceData)object).resId)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object4 = (Object)this.sort) != (n10 = ((ResourceData)object).sort) || (object4 = (Object)Objects.equals(object3 = this.label, object2 = ((ResourceData)object).label)) == false || (object4 = (Object)Objects.equals(object3 = this.label_tw, object2 = ((ResourceData)object).label_tw)) == false || !(bl3 = Objects.equals(object3 = this.label_en, object = ((ResourceData)object).label_en))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLabel_en() {
        return this.label_en;
    }

    public String getLabel_tw() {
        return this.label_tw;
    }

    public long getResId() {
        return this.resId;
    }

    public int getSort() {
        return this.sort;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.resId), object = this.label, object = this.label_tw, object = this.label_en, object = Integer.valueOf(this.sort)};
        return Objects.hash(objectArray);
    }

    public void setId(long l10) {
        this.id = l10;
    }

    public void setLabel(String string2) {
        this.label = string2;
    }

    public void setLabel_en(String string2) {
        this.label_en = string2;
    }

    public void setLabel_tw(String string2) {
        this.label_tw = string2;
    }

    public void setResId(long l10) {
        this.resId = l10;
    }

    public void setSort(int n10) {
        this.sort = n10;
    }

    public String showLabel() {
        boolean bl2;
        String string2;
        String string3 = w1.a();
        boolean bl3 = string3.equals(string2 = "zh".toLowerCase());
        string3 = !bl3 && !(bl3 = string3.equals(string2 = "zh_CN".toLowerCase())) ? ((bl2 = string3.equals(string2 = "zh_TW".toLowerCase())) ? this.label_tw : this.label_en) : this.label;
        if (string3 == null) {
            string3 = "";
        }
        return string3;
    }
}

