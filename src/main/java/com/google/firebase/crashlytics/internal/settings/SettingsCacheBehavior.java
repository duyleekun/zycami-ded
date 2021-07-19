/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings;

public final class SettingsCacheBehavior
extends Enum {
    private static final /* synthetic */ SettingsCacheBehavior[] $VALUES;
    public static final /* enum */ SettingsCacheBehavior IGNORE_CACHE_EXPIRATION;
    public static final /* enum */ SettingsCacheBehavior SKIP_CACHE_LOOKUP;
    public static final /* enum */ SettingsCacheBehavior USE_CACHE;

    static {
        SettingsCacheBehavior settingsCacheBehavior;
        SettingsCacheBehavior settingsCacheBehavior2;
        SettingsCacheBehavior settingsCacheBehavior3;
        USE_CACHE = settingsCacheBehavior3 = new SettingsCacheBehavior("USE_CACHE", 0);
        int n10 = 1;
        SKIP_CACHE_LOOKUP = settingsCacheBehavior2 = new SettingsCacheBehavior("SKIP_CACHE_LOOKUP", n10);
        int n11 = 2;
        IGNORE_CACHE_EXPIRATION = settingsCacheBehavior = new SettingsCacheBehavior("IGNORE_CACHE_EXPIRATION", n11);
        SettingsCacheBehavior[] settingsCacheBehaviorArray = new SettingsCacheBehavior[3];
        settingsCacheBehaviorArray[0] = settingsCacheBehavior3;
        settingsCacheBehaviorArray[n10] = settingsCacheBehavior2;
        settingsCacheBehaviorArray[n11] = settingsCacheBehavior;
        $VALUES = settingsCacheBehaviorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SettingsCacheBehavior() {
        void var2_-1;
        void var1_-1;
    }

    public static SettingsCacheBehavior valueOf(String string2) {
        return Enum.valueOf(SettingsCacheBehavior.class, string2);
    }

    public static SettingsCacheBehavior[] values() {
        return (SettingsCacheBehavior[])$VALUES.clone();
    }
}

