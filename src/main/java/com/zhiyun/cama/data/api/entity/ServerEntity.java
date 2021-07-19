/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.ServerEntity$Config;
import com.zhiyun.net.BaseEntity;
import java.util.Objects;

public class ServerEntity
extends BaseEntity {
    public static final String HOST_PURCHASE = "purchase";
    public static final String HOST_SERVICE = "service";
    public ServerEntity$Config config;
    public String env;
    public String server_name;
    public String server_title;

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (ServerEntity)object;
            object3 = this.server_name;
            object2 = ((ServerEntity)object).server_name;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.server_title, object2 = ((ServerEntity)object).server_title)) && (bl4 = Objects.equals(object3 = this.env, object2 = ((ServerEntity)object).env)) && (bl3 = Objects.equals(object3 = this.config, object = ((ServerEntity)object).config)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.server_name;
        object = this.server_title;
        object = this.env;
        object = this.config;
        Object[] objectArray = new Object[]{object, object, object, object};
        return Objects.hash(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{server_name: '");
        Object object = this.server_name;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(",\n server_title: '");
        String string2 = this.server_title;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(",\n env: '");
        string2 = this.env;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(",\n config: ");
        object = this.config;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

