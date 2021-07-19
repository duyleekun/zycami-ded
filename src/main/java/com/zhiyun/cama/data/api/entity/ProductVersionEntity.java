/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import java.util.Objects;

public class ProductVersionEntity {
    public String channel;
    public int id;
    public String version;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ProductVersionEntity)object;
            int n10 = this.id;
            int n11 = ((ProductVersionEntity)object).id;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.version, object2 = ((ProductVersionEntity)object).version) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.channel, object = ((ProductVersionEntity)object).channel))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.version, object = this.channel};
        return Objects.hash(objectArray);
    }
}

