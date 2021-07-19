/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.AutoValue_Config_Option;

public abstract class Config$Option {
    public static Config$Option create(String string2, Class clazz) {
        return Config$Option.create(string2, clazz, null);
    }

    public static Config$Option create(String string2, Class clazz, Object object) {
        AutoValue_Config_Option autoValue_Config_Option = new AutoValue_Config_Option(string2, clazz, object);
        return autoValue_Config_Option;
    }

    public abstract String getId();

    public abstract Object getToken();

    public abstract Class getValueClass();
}

