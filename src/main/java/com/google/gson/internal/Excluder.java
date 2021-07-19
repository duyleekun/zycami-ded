/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.Excluder$1;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder
implements TypeAdapterFactory,
Cloneable {
    public static final Excluder DEFAULT;
    private static final double IGNORE_VERSIONS = -1.0;
    private List deserializationStrategies;
    private int modifiers = 136;
    private boolean requireExpose;
    private List serializationStrategies;
    private boolean serializeInnerClasses = true;
    private double version = -1.0;

    static {
        Excluder excluder;
        DEFAULT = excluder = new Excluder();
    }

    public Excluder() {
        List list;
        this.serializationStrategies = list = Collections.emptyList();
        this.deserializationStrategies = list = Collections.emptyList();
    }

    private boolean excludeClassChecks(Class clazz) {
        Until until;
        Since since;
        double d10 = this.version;
        double d11 = -1.0;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        boolean bl2 = true;
        if (d12 != false && (d12 = (double)this.isValidVersion(since = clazz.getAnnotation(Since.class), until = clazz.getAnnotation(Until.class))) == false) {
            return bl2;
        }
        d12 = (double)this.serializeInnerClasses;
        if (d12 == false && (d12 = (double)this.isInnerClass(clazz)) != false) {
            return bl2;
        }
        boolean bl3 = this.isAnonymousOrLocal(clazz);
        if (bl3) {
            return bl2;
        }
        return false;
    }

    private boolean excludeClassInStrategy(Class clazz, boolean bl2) {
        boolean bl3;
        Object object = bl2 ? this.serializationStrategies : this.deserializationStrategies;
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            ExclusionStrategy exclusionStrategy = (ExclusionStrategy)object.next();
            bl3 = exclusionStrategy.shouldSkipClass(clazz);
            if (!bl3) continue;
            return true;
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class clazz) {
        boolean bl2;
        Class<Enum> clazz2 = Enum.class;
        boolean bl3 = clazz2.isAssignableFrom(clazz);
        if (!bl3 && ((bl3 = clazz.isAnonymousClass()) || (bl2 = clazz.isLocalClass()))) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    private boolean isInnerClass(Class clazz) {
        boolean bl2;
        boolean bl3 = clazz.isMemberClass();
        if (bl3 && !(bl2 = this.isStatic(clazz))) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    private boolean isStatic(Class clazz) {
        int n10 = clazz.getModifiers() & 8;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            clazz = null;
        }
        return n10 != 0;
    }

    private boolean isValidSince(Since since) {
        double d10;
        double d11;
        double d12;
        double d13;
        return since == null || (d13 = (d12 = (d11 = since.value()) - (d10 = this.version)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) <= 0;
    }

    private boolean isValidUntil(Until until) {
        double d10;
        double d11;
        double d12;
        double d13;
        return until == null || (d13 = (d12 = (d11 = until.value()) - (d10 = this.version)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) > 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        boolean bl2 = this.isValidSince(since);
        if (bl2 && (bl2 = this.isValidUntil(until))) {
            bl2 = true;
        } else {
            bl2 = false;
            since = null;
        }
        return bl2;
    }

    public Excluder clone() {
        Object object;
        try {
            object = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        return (Excluder)object;
    }

    public TypeAdapter create(Gson gson, TypeToken typeToken) {
        boolean bl2;
        boolean bl3;
        Object object = typeToken.getRawType();
        boolean bl4 = this.excludeClassChecks((Class)object);
        boolean bl5 = true;
        boolean bl6 = !bl4 && !(bl3 = this.excludeClassInStrategy((Class)object, bl5)) ? false : bl5;
        boolean bl7 = !bl4 && !(bl2 = this.excludeClassInStrategy((Class)object, false)) ? false : bl5;
        if (!bl6 && !bl7) {
            return null;
        }
        object = new Excluder$1(this, bl7, bl6, gson, typeToken);
        return object;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluder = this.clone();
        excluder.serializeInnerClasses = false;
        return excluder;
    }

    public boolean excludeClass(Class clazz, boolean bl2) {
        boolean bl3;
        boolean bl4 = this.excludeClassChecks(clazz);
        if (!bl4 && !(bl3 = this.excludeClassInStrategy(clazz, bl2))) {
            bl3 = false;
            clazz = null;
        } else {
            bl3 = true;
        }
        return bl3;
    }

    public boolean excludeField(Field object, boolean bl2) {
        Until until;
        Class clazz;
        int n10 = this.modifiers;
        int n11 = ((Field)object).getModifiers();
        n10 &= n11;
        n11 = 1;
        if (n10 != 0) {
            return n11 != 0;
        }
        double d10 = this.version;
        double d11 = -1.0;
        double d12 = d10 - d11;
        n10 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
        if (n10 != 0 && (n10 = (int)(this.isValidVersion((Since)((Object)(clazz = ((Field)object).getAnnotation(Since.class))), until = ((Field)object).getAnnotation(Until.class)) ? 1 : 0)) == 0) {
            return n11 != 0;
        }
        n10 = (int)(((Field)object).isSynthetic() ? 1 : 0);
        if (n10 != 0) {
            return n11 != 0;
        }
        n10 = (int)(this.requireExpose ? 1 : 0);
        if (n10 != 0 && ((clazz = ((Field)object).getAnnotation(Expose.class)) == null || (bl2 ? (n10 = (int)(clazz.serialize() ? 1 : 0)) == 0 : (n10 = (int)(clazz.deserialize() ? 1 : 0)) == 0))) {
            return n11 != 0;
        }
        n10 = (int)(this.serializeInnerClasses ? 1 : 0);
        if (n10 == 0 && (n10 = (int)(this.isInnerClass(clazz = ((Field)object).getType()) ? 1 : 0)) != 0) {
            return n11 != 0;
        }
        clazz = ((Field)object).getType();
        n10 = (int)(this.isAnonymousOrLocal(clazz) ? 1 : 0);
        if (n10 != 0) {
            return n11 != 0;
        }
        Object object2 = bl2 ? this.serializationStrategies : this.deserializationStrategies;
        n10 = (int)(object2.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            clazz = new FieldAttributes((Field)object);
            object = object2.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (ExclusionStrategy)object.next();
                bl2 = object2.shouldSkipField((FieldAttributes)((Object)clazz));
                if (!bl2) continue;
                return n11 != 0;
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluder = this.clone();
        excluder.requireExpose = true;
        return excluder;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean bl2, boolean bl3) {
        ArrayList<ExclusionStrategy> arrayList;
        Excluder excluder = this.clone();
        if (bl2) {
            List list = this.serializationStrategies;
            excluder.serializationStrategies = arrayList = new ArrayList<ExclusionStrategy>(list);
            arrayList.add(exclusionStrategy);
        }
        if (bl3) {
            List list = this.deserializationStrategies;
            excluder.deserializationStrategies = arrayList = new ArrayList<ExclusionStrategy>(list);
            arrayList.add(exclusionStrategy);
        }
        return excluder;
    }

    public Excluder withModifiers(int ... nArray) {
        Excluder excluder = this.clone();
        excluder.modifiers = 0;
        for (int n10 : nArray) {
            int n11 = excluder.modifiers;
            excluder.modifiers = n10 |= n11;
        }
        return excluder;
    }

    public Excluder withVersion(double d10) {
        Excluder excluder = this.clone();
        excluder.version = d10;
        return excluder;
    }
}

