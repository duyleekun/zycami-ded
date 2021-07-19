/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import java.util.Objects;

public class ServerEntity$Config {
    public String api;
    public String purchase;
    public String purchaseOverseas;
    public String service;
    public String zycamiH5;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ServerEntity$Config)object;
            object3 = this.api;
            object2 = ((ServerEntity$Config)object).api;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.service, object2 = ((ServerEntity$Config)object).service)) && (bl4 = Objects.equals(object3 = this.zycamiH5, object2 = ((ServerEntity$Config)object).zycamiH5)) && (bl4 = Objects.equals(object3 = this.purchase, object2 = ((ServerEntity$Config)object).purchase)) && (bl3 = Objects.equals(object3 = this.purchaseOverseas, object = ((ServerEntity$Config)object).purchaseOverseas)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[5];
        String string2 = this.api;
        objectArray[0] = string2;
        string2 = this.service;
        objectArray[1] = string2;
        string2 = this.zycamiH5;
        objectArray[2] = string2;
        string2 = this.purchase;
        objectArray[3] = string2;
        string2 = this.purchaseOverseas;
        objectArray[4] = string2;
        return Objects.hash(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ \n api: '");
        String string2 = this.api;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(",\n service: '");
        String string3 = this.service;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(",\n zycamiH5: '");
        string3 = this.zycamiH5;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(",\n purchase: '");
        string3 = this.purchase;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(",\n purchaseOverseas: '");
        string3 = this.purchaseOverseas;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

