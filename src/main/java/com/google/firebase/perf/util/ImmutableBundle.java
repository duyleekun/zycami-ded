/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;

public final class ImmutableBundle {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Bundle bundle;

    public ImmutableBundle() {
        Bundle bundle = new Bundle();
        this(bundle);
    }

    public ImmutableBundle(Bundle bundle) {
        this.bundle = bundle = (Bundle)bundle.clone();
    }

    private Optional getInt(String string2) {
        Object object;
        boolean bl2 = this.containsKey(string2);
        if (!bl2) {
            return Optional.absent();
        }
        try {
            object = this.bundle;
        }
        catch (ClassCastException classCastException) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            String string3 = classCastException.getMessage();
            objectArray[1] = string3;
            androidLogger.debug("Metadata key %s contains type other than int: %s", objectArray);
            return Optional.absent();
        }
        object = object.get(string2);
        object = (Integer)object;
        return Optional.fromNullable(object);
    }

    public boolean containsKey(String string2) {
        Bundle bundle;
        boolean bl2;
        if (string2 != null && (bl2 = (bundle = this.bundle).containsKey(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public Optional getBoolean(String string2) {
        Object object;
        boolean bl2 = this.containsKey(string2);
        if (!bl2) {
            return Optional.absent();
        }
        try {
            object = this.bundle;
        }
        catch (ClassCastException classCastException) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            String string3 = classCastException.getMessage();
            objectArray[1] = string3;
            androidLogger.debug("Metadata key %s contains type other than boolean: %s", objectArray);
            return Optional.absent();
        }
        object = object.get(string2);
        object = (Boolean)object;
        return Optional.fromNullable(object);
    }

    public Optional getFloat(String string2) {
        Object object;
        boolean bl2 = this.containsKey(string2);
        if (!bl2) {
            return Optional.absent();
        }
        try {
            object = this.bundle;
        }
        catch (ClassCastException classCastException) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            String string3 = classCastException.getMessage();
            objectArray[1] = string3;
            androidLogger.debug("Metadata key %s contains type other than float: %s", objectArray);
            return Optional.absent();
        }
        object = object.get(string2);
        object = (Float)object;
        return Optional.fromNullable(object);
    }

    public Optional getLong(String object) {
        boolean bl2 = ((Optional)(object = this.getInt((String)object))).isAvailable();
        if (bl2) {
            return Optional.of((Integer)((Optional)object).get());
        }
        return Optional.absent();
    }
}

