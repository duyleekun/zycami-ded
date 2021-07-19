/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 */
package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.material.animation.MotionTiming;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap timings;

    public MotionSpec() {
        SimpleArrayMap simpleArrayMap;
        this.timings = simpleArrayMap = new SimpleArrayMap();
    }

    private static void addTimingFromAnimator(MotionSpec object, Animator object2) {
        boolean bl2 = object2 instanceof ObjectAnimator;
        if (bl2) {
            object2 = (ObjectAnimator)object2;
            String string2 = object2.getPropertyName();
            object2 = MotionTiming.createFromAnimator((ValueAnimator)object2);
            ((MotionSpec)object).setTiming(string2, (MotionTiming)object2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animator must be an ObjectAnimator: ");
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static MotionSpec createFromAttribute(Context context, TypedArray typedArray, int n10) {
        boolean bl2 = typedArray.hasValue(n10);
        if (bl2) {
            bl2 = false;
            int n11 = typedArray.getResourceId(n10, 0);
            if (n11 != 0) {
                return MotionSpec.createFromResource(context, n11);
            }
        }
        return null;
    }

    public static MotionSpec createFromResource(Context object, int n10) {
        Serializable serializable;
        try {
            object = AnimatorInflater.loadAnimator((Context)object, (int)n10);
        }
        catch (Exception exception) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Can't load animation resource ID #0x");
            String string2 = Integer.toHexString(n10);
            ((StringBuilder)serializable).append(string2);
            string2 = ((StringBuilder)serializable).toString();
            Log.w((String)TAG, (String)string2, (Throwable)exception);
            return null;
        }
        boolean bl2 = object instanceof AnimatorSet;
        if (bl2) {
            object = (AnimatorSet)object;
            object = object.getChildAnimations();
            return MotionSpec.createSpecFromAnimators((List)object);
        }
        if (object != null) {
            serializable = new ArrayList();
            serializable.add(object);
            return MotionSpec.createSpecFromAnimators((List)((Object)serializable));
        }
        return null;
    }

    private static MotionSpec createSpecFromAnimators(List list) {
        MotionSpec motionSpec = new MotionSpec();
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Animator animator2 = (Animator)list.get(i10);
            MotionSpec.addTimingFromAnimator(motionSpec, animator2);
        }
        return motionSpec;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (MotionSpec)object;
            object2 = this.timings;
            object = ((MotionSpec)object).timings;
            return ((SimpleArrayMap)object2).equals(object);
        }
        return false;
    }

    public MotionTiming getTiming(String object) {
        boolean bl2 = this.hasTiming((String)object);
        if (bl2) {
            return (MotionTiming)this.timings.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public long getTotalDuration() {
        SimpleArrayMap simpleArrayMap = this.timings;
        int n10 = simpleArrayMap.size();
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            MotionTiming motionTiming = (MotionTiming)this.timings.valueAt(i10);
            long l11 = motionTiming.getDelay();
            long l12 = motionTiming.getDuration();
            l10 = Math.max(l10, l11 += l12);
        }
        return l10;
    }

    public boolean hasTiming(String object) {
        boolean bl2;
        SimpleArrayMap simpleArrayMap = this.timings;
        if ((object = simpleArrayMap.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setTiming(String string2, MotionTiming motionTiming) {
        this.timings.put(string2, motionTiming);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        Object object = this.getClass().getName();
        stringBuilder.append((String)object);
        stringBuilder.append('{');
        object = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append((String)object);
        stringBuilder.append(" timings: ");
        object = this.timings;
        stringBuilder.append(object);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

