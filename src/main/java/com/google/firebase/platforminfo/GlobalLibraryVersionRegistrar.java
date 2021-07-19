/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import com.google.firebase.platforminfo.LibraryVersion;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar {
    private static volatile GlobalLibraryVersionRegistrar INSTANCE;
    private final Set infos;

    public GlobalLibraryVersionRegistrar() {
        HashSet hashSet;
        this.infos = hashSet = new HashSet();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static GlobalLibraryVersionRegistrar getInstance() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = INSTANCE;
        if (globalLibraryVersionRegistrar != null) return globalLibraryVersionRegistrar;
        Class<GlobalLibraryVersionRegistrar> clazz = GlobalLibraryVersionRegistrar.class;
        synchronized (clazz) {
            globalLibraryVersionRegistrar = INSTANCE;
            if (globalLibraryVersionRegistrar != null) return globalLibraryVersionRegistrar;
            INSTANCE = globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
            return globalLibraryVersionRegistrar;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set getRegisteredVersions() {
        Set set = this.infos;
        synchronized (set) {
            Set set2 = this.infos;
            return Collections.unmodifiableSet(set2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerVersion(String object, String string2) {
        Set set = this.infos;
        synchronized (set) {
            Set set2 = this.infos;
            object = LibraryVersion.create((String)object, string2);
            set2.add(object);
            return;
        }
    }
}

