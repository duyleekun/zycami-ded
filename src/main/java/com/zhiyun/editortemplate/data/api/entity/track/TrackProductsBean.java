/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.track;

import java.util.Objects;

public class TrackProductsBean {
    private String name;
    private String product;
    private int version;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (TrackProductsBean)object;
            int n10 = this.version;
            int n11 = ((TrackProductsBean)object).version;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.product, object2 = ((TrackProductsBean)object).product) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.name, object = ((TrackProductsBean)object).name))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getProduct() {
        return this.product;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        Object object = this.product;
        object = this.name;
        object = this.version;
        Object[] objectArray = new Object[]{object, object, object};
        return Objects.hash(objectArray);
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setProduct(String string2) {
        this.product = string2;
    }

    public void setVersion(int n10) {
        this.version = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackProductsBean{product='");
        String string2 = this.product;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", name='");
        String string3 = this.name;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", version=");
        n10 = this.version;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

