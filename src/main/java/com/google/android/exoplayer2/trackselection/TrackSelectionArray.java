/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.util.Arrays;

public final class TrackSelectionArray {
    private int hashCode;
    public final int length;
    private final TrackSelection[] trackSelections;

    public TrackSelectionArray(TrackSelection ... trackSelectionArray) {
        int n10;
        this.trackSelections = trackSelectionArray;
        this.length = n10 = trackSelectionArray.length;
    }

    public boolean equals(Object objectArray) {
        Class<?> clazz;
        Object[] objectArray2;
        if (this == objectArray) {
            return true;
        }
        if (objectArray != null && (objectArray2 = TrackSelectionArray.class) == (clazz = objectArray.getClass())) {
            objectArray = (TrackSelectionArray)objectArray;
            objectArray2 = this.trackSelections;
            objectArray = objectArray.trackSelections;
            return Arrays.equals(objectArray2, objectArray);
        }
        return false;
    }

    public TrackSelection get(int n10) {
        return this.trackSelections[n10];
    }

    public TrackSelection[] getAll() {
        return (TrackSelection[])this.trackSelections.clone();
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            Object[] objectArray = this.trackSelections;
            int n11 = Arrays.hashCode(objectArray);
            this.hashCode = n10 = 527 + n11;
        }
        return this.hashCode;
    }
}

