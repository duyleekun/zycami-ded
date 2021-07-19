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
import androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState;
import androidx.appcompat.graphics.drawable.StateListDrawable;

public class StateListDrawable$StateListState
extends DrawableContainer$DrawableContainerState {
    public int[][] mStateSets;

    public StateListDrawable$StateListState(StateListDrawable$StateListState object, StateListDrawable stateListDrawable, Resources resources) {
        super((DrawableContainer$DrawableContainerState)((Object)object), stateListDrawable, resources);
        if (object != null) {
            object = object.mStateSets;
            this.mStateSets = (int[][])object;
        } else {
            int n10 = this.getCapacity();
            object = new int[n10][];
            this.mStateSets = (int[][])object;
        }
    }

    public int addStateSet(int[] nArray, Drawable drawable2) {
        int n10 = this.addChild(drawable2);
        this.mStateSets[n10] = nArray;
        return n10;
    }

    public void growArray(int n10, int n11) {
        super.growArray(n10, n11);
        int[][] nArrayArray = new int[n11][];
        System.arraycopy(this.mStateSets, 0, nArrayArray, 0, n10);
        this.mStateSets = nArrayArray;
    }

    public int indexOfStateSet(int[] nArray) {
        int[][] nArray2 = this.mStateSets;
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray3 = nArray2[i10];
            boolean bl2 = StateSet.stateSetMatches((int[])nArray3, (int[])nArray);
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public void mutate() {
        int[][] nArray = this.mStateSets;
        int n10 = nArray.length;
        int[][] nArrayArray = new int[n10][];
        for (int i10 = nArray.length + -1; i10 >= 0; i10 += -1) {
            Object object = this.mStateSets;
            int[] nArray2 = object[i10];
            object = nArray2 != null ? (Object)((int[])object[i10].clone()) : null;
            nArrayArray[i10] = (int[])object;
        }
        this.mStateSets = nArrayArray;
    }

    public Drawable newDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable(this, null);
        return stateListDrawable;
    }

    public Drawable newDrawable(Resources resources) {
        StateListDrawable stateListDrawable = new StateListDrawable(this, resources);
        return stateListDrawable;
    }
}

