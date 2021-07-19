/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config$Option;
import java.util.Objects;

public final class AutoValue_Config_Option
extends Config$Option {
    private final String id;
    private final Object token;
    private final Class valueClass;

    public AutoValue_Config_Option(String string2, Class clazz, Object object) {
        Objects.requireNonNull(string2, "Null id");
        this.id = string2;
        Objects.requireNonNull(clazz, "Null valueClass");
        this.valueClass = clazz;
        this.token = object;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof Config$Option;
        if (bl3) {
            boolean bl4;
            Object object2 = this.id;
            Object object3 = ((Config$Option)(object = (Config$Option)object)).getId();
            bl3 = ((String)object2).equals(object3);
            if (!(bl3 && (bl3 = (object2 = this.valueClass).equals(object3 = ((Config$Option)object).getValueClass())) && ((object2 = this.token) == null ? (object = ((Config$Option)object).getToken()) == null : (bl4 = object2.equals(object = ((Config$Option)object).getToken()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getId() {
        return this.id;
    }

    public Object getToken() {
        return this.token;
    }

    public Class getValueClass() {
        return this.valueClass;
    }

    public int hashCode() {
        String string2 = this.id;
        int n10 = string2.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        Class clazz = this.valueClass;
        int n12 = clazz.hashCode();
        n10 = (n10 ^ n12) * n11;
        Object object = this.token;
        if (object == null) {
            n11 = 0;
            object = null;
        } else {
            n11 = object.hashCode();
        }
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option{id=");
        Object object = this.id;
        stringBuilder.append((String)object);
        stringBuilder.append(", valueClass=");
        object = this.valueClass;
        stringBuilder.append(object);
        stringBuilder.append(", token=");
        object = this.token;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

