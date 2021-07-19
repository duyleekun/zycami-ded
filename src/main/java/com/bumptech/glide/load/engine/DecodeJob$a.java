/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DecodeJob$RunReason;
import com.bumptech.glide.load.engine.DecodeJob$Stage;

public class DecodeJob$a {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object2;
        int n13;
        Object object3;
        int n14 = EncodeStrategy.values().length;
        int[] nArray = new int[n14];
        c = nArray;
        int n15 = 1;
        try {
            object3 = EncodeStrategy.SOURCE;
            n13 = object3.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object3 = c;
            object2 = EncodeStrategy.TRANSFORMED;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (EncodeStrategy)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = DecodeJob$Stage.values().length;
        object3 = new int[n13];
        b = (int[])object3;
        try {
            object2 = DecodeJob$Stage.RESOURCE_CACHE;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (EncodeStrategy)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object3 = b;
            object2 = DecodeJob$Stage.DATA_CACHE;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (EncodeStrategy)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object2 = b;
            enum_ = DecodeJob$Stage.SOURCE;
            n11 = enum_.ordinal();
            object2[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = DecodeJob$Stage.FINISHED;
            n11 = enum_.ordinal();
            n10 = 4;
            object2[n11] = n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = DecodeJob$Stage.INITIALIZE;
            n11 = enum_.ordinal();
            n10 = 5;
            object2[n11] = n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = DecodeJob$RunReason.values().length;
        object2 = new int[n12];
        a = (int[])object2;
        try {
            enum_ = DecodeJob$RunReason.INITIALIZE;
            n11 = enum_.ordinal();
            object2[n11] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
            n12 = ((Enum)object2).ordinal();
            object[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)DecodeJob$RunReason.DECODE_DATA;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

