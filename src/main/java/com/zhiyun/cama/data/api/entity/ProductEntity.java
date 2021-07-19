/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import java.util.Objects;

public class ProductEntity {
    public String code;
    public int id;
    public String seriCode;
    public String seriCode16;
    public String title;
    public String title_alias;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ProductEntity)object;
            int n10 = this.id;
            int n11 = ((ProductEntity)object).id;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.title, object2 = ((ProductEntity)object).title) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.title_alias, object2 = ((ProductEntity)object).title_alias) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.code, object2 = ((ProductEntity)object).code) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.seriCode, object2 = ((ProductEntity)object).seriCode) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.seriCode16, object = ((ProductEntity)object).seriCode16))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.title, object = this.title_alias, object = this.code, object = this.seriCode, object = this.seriCode16};
        return Objects.hash(objectArray);
    }
}

