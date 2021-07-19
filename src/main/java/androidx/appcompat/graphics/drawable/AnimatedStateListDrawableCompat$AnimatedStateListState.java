/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.StateSet
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.graphics.drawable.StateListDrawable$StateListState;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;

public class AnimatedStateListDrawableCompat$AnimatedStateListState
extends StateListDrawable$StateListState {
    private static final long REVERSED_BIT = 0x100000000L;
    private static final long REVERSIBLE_FLAG_BIT = 0x200000000L;
    public SparseArrayCompat mStateIds;
    public LongSparseArray mTransitions;

    public AnimatedStateListDrawableCompat$AnimatedStateListState(AnimatedStateListDrawableCompat$AnimatedStateListState object, AnimatedStateListDrawableCompat object2, Resources resources) {
        super((StateListDrawable$StateListState)((Object)object), (StateListDrawable)((Object)object2), resources);
        if (object != null) {
            this.mTransitions = object2 = object.mTransitions;
            object = object.mStateIds;
            this.mStateIds = object;
        } else {
            super();
            this.mTransitions = object;
            super();
            this.mStateIds = object;
        }
    }

    private static long generateTransitionKey(int n10, int n11) {
        long l10 = (long)n10 << 32;
        return (long)n11 | l10;
    }

    public int addStateSet(int[] nArray, Drawable object, int n10) {
        int n11 = super.addStateSet(nArray, (Drawable)object);
        object = this.mStateIds;
        Integer n12 = n10;
        ((SparseArrayCompat)object).put(n11, n12);
        return n11;
    }

    public int addTransition(int n10, int n11, Drawable drawable2, boolean bl2) {
        int n12 = super.addChild(drawable2);
        long l10 = AnimatedStateListDrawableCompat$AnimatedStateListState.generateTransitionKey(n10, n11);
        long l11 = bl2 ? 0x200000000L : 0L;
        LongSparseArray longSparseArray = this.mTransitions;
        long l12 = n12;
        long l13 = l12 | l11;
        Long l14 = l13;
        longSparseArray.append(l10, l14);
        if (bl2) {
            long l15 = AnimatedStateListDrawableCompat$AnimatedStateListState.generateTransitionKey(n11, n10);
            LongSparseArray longSparseArray2 = this.mTransitions;
            l10 = 0x100000000L | l12 | l11;
            Long l16 = l10;
            longSparseArray2.append(l15, l16);
        }
        return n12;
    }

    public int getKeyframeIdAt(int n10) {
        int n11 = 0;
        Integer n12 = null;
        if (n10 >= 0) {
            SparseArrayCompat sparseArrayCompat = this.mStateIds;
            n12 = 0;
            Integer n13 = (Integer)sparseArrayCompat.get(n10, n12);
            n11 = n13;
        }
        return n11;
    }

    public int indexOfKeyframe(int[] nArray) {
        int n10 = super.indexOfStateSet(nArray);
        if (n10 >= 0) {
            return n10;
        }
        nArray = StateSet.WILD_CARD;
        return super.indexOfStateSet(nArray);
    }

    public int indexOfTransition(int n10, int n11) {
        long l10 = AnimatedStateListDrawableCompat$AnimatedStateListState.generateTransitionKey(n10, n11);
        LongSparseArray longSparseArray = this.mTransitions;
        Long l11 = -1;
        return (int)((Long)longSparseArray.get(l10, l11)).longValue();
    }

    public boolean isTransitionReversed(int n10, int n11) {
        long l10;
        long l11 = AnimatedStateListDrawableCompat$AnimatedStateListState.generateTransitionKey(n10, n11);
        LongSparseArray longSparseArray = this.mTransitions;
        long l12 = -1;
        Long l13 = l12;
        Long l14 = (Long)longSparseArray.get(l11, l13);
        long l15 = (l11 = l14 & 0x100000000L) - (l10 = 0L);
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            l14 = null;
        }
        return n10 != 0;
    }

    public void mutate() {
        Cloneable cloneable;
        this.mTransitions = cloneable = this.mTransitions.clone();
        cloneable = this.mStateIds.clone();
        this.mStateIds = cloneable;
    }

    public Drawable newDrawable() {
        AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat(this, null);
        return animatedStateListDrawableCompat;
    }

    public Drawable newDrawable(Resources resources) {
        AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat(this, resources);
        return animatedStateListDrawableCompat;
    }

    public boolean transitionHasReversibleFlag(int n10, int n11) {
        long l10;
        long l11 = AnimatedStateListDrawableCompat$AnimatedStateListState.generateTransitionKey(n10, n11);
        LongSparseArray longSparseArray = this.mTransitions;
        long l12 = -1;
        Long l13 = l12;
        Long l14 = (Long)longSparseArray.get(l11, l13);
        long l15 = (l11 = l14 & 0x200000000L) - (l10 = 0L);
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            l14 = null;
        }
        return n10 != 0;
    }
}

