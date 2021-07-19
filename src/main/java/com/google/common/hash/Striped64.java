/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Striped64$1;
import com.google.common.hash.Striped64$Cell;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

public abstract class Striped64
extends Number {
    public static final int NCPU;
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    public static final Random rng;
    public static final ThreadLocal threadHashCode;
    public volatile transient long base;
    public volatile transient int busy;
    public volatile transient Striped64$Cell[] cells;

    static {
        Object object;
        int n10;
        Object object2 = new ThreadLocal();
        threadHashCode = object2;
        rng = object2 = new Random();
        object2 = Runtime.getRuntime();
        NCPU = n10 = ((Runtime)object2).availableProcessors();
        try {
            object2 = Striped64.getUnsafe();
        }
        catch (Exception exception) {
            object = new Error(exception);
            throw object;
        }
        UNSAFE = object2;
        object = Striped64.class;
        Object object3 = "base";
        object3 = ((Class)object).getDeclaredField((String)object3);
        long l10 = ((Unsafe)object2).objectFieldOffset((Field)object3);
        baseOffset = l10;
        object3 = "busy";
        object = ((Class)object).getDeclaredField((String)object3);
        long l11 = ((Unsafe)object2).objectFieldOffset((Field)object);
        busyOffset = l11;
    }

    public static /* synthetic */ Unsafe access$000() {
        return Striped64.getUnsafe();
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException securityException) {
            Striped64$1 striped64$1;
            try {
                striped64$1 = new Striped64$1();
                striped64$1 = AccessController.doPrivileged(striped64$1);
            }
            catch (PrivilegedActionException privilegedActionException) {
                Throwable throwable = privilegedActionException.getCause();
                RuntimeException runtimeException = new RuntimeException("Could not initialize intrinsics", throwable);
                throw runtimeException;
            }
            return (Unsafe)((Object)striped64$1);
        }
    }

    public final boolean casBase(long l10, long l11) {
        Unsafe unsafe = UNSAFE;
        long l12 = baseOffset;
        return unsafe.compareAndSwapLong(this, l12, l10, l11);
    }

    public final boolean casBusy() {
        Unsafe unsafe = UNSAFE;
        long l10 = busyOffset;
        return unsafe.compareAndSwapInt(this, l10, 0, 1);
    }

    public abstract long fn(long var1, long var3);

    public final void internalReset(long l10) {
        Striped64$Cell[] striped64$CellArray = this.cells;
        this.base = l10;
        if (striped64$CellArray != null) {
            for (Striped64$Cell striped64$Cell : striped64$CellArray) {
                if (striped64$Cell == null) continue;
                striped64$Cell.value = l10;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void retryUpdate(long var1_1, int[] var3_2, boolean var4_3) {
        var5_4 = this;
        var6_5 = var1_1;
        var8_6 = 1;
        if (var3_2 == null) {
            var9_7 = Striped64.threadHashCode;
            var10_8 = new int[var8_6];
            var9_7.set(var10_8);
            var9_7 = Striped64.rng;
            var11_9 = var9_7.nextInt();
            if (var11_9 == 0) {
                var11_9 = var8_6;
            }
            var10_8[0] = var11_9;
        } else {
            var11_9 = var3_2[0];
            var10_8 = var3_2;
        }
        var12_10 = 0;
        var13_11 = null;
        var14_12 = var11_9;
        var11_9 = (int)var4_3;
        while (true) {
            if ((var15_13 /* !! */  = var5_4.cells) != null && (var16_14 = var15_13 /* !! */ .length) > 0) {
                block36: {
                    var17_15 = var16_14 + -1 & var14_12;
                    var18_16 = var15_13 /* !! */ [var17_15];
                    if (var18_16 == null) {
                        var19_17 = var5_4.busy;
                        if (var19_17 == 0) {
                            var15_13 /* !! */  = new Striped64$Cell(var6_5);
                            var16_14 = var5_4.busy;
                            if (var16_14 == 0 && (var16_14 = (int)this.casBusy()) != 0) {
                                block35: {
                                    try {
                                        var20_18 = var5_4.cells;
                                        if (var20_18 == null) break block35;
                                    }
                                    catch (Throwable var22_24) {
                                        var5_4.busy = 0;
                                        throw var22_24;
                                    }
                                    var17_15 = var20_18.length;
                                    if (var17_15 <= 0) break block35;
                                    var17_15 = var17_15 + -1 & var14_12;
                                    var21_19 = var20_18[var17_15];
                                    if (var21_19 != null) break block35;
                                    var20_18[var17_15] = var15_13 /* !! */ ;
                                    var19_17 = var8_6;
                                }
                                var19_17 = 0;
                                var15_13 /* !! */  = null;
                                var5_4.busy = 0;
                                if (var19_17 == 0) continue;
                                break;
                            }
                        }
                        while (true) {
                            var12_10 = 0;
                            var13_11 = null;
                            break block36;
                            break;
                        }
                    }
                    if (var11_9 == 0) {
                        var11_9 = var8_6;
                    } else {
                        var23_20 = var18_16.value;
                        var25_21 = var5_4.fn(var23_20, var6_5);
                        var17_15 = (int)var18_16.cas(var23_20, var25_21);
                        if (var17_15 != 0) break;
                        if (var16_14 >= (var17_15 = Striped64.NCPU) || (var18_16 = var5_4.cells) != var15_13 /* !! */ ) ** continue;
                        if (var12_10 == 0) {
                            var12_10 = var8_6;
                        } else {
                            var17_15 = var5_4.busy;
                            if (var17_15 == 0 && (var17_15 = (int)this.casBusy()) != 0) {
                                block37: {
                                    var13_11 = var5_4.cells;
                                    if (var13_11 != var15_13 /* !! */ ) break block37;
                                    var12_10 = var16_14 << 1;
                                    var13_11 = new Striped64$Cell[var12_10];
                                    var18_16 = null;
                                    for (var17_15 = 0; var17_15 < var16_14; ++var17_15) {
                                        var21_19 = var15_13 /* !! */ [var17_15];
                                        var13_11[var17_15] = var21_19;
                                        continue;
                                    }
                                    try {
                                        var5_4.cells = var13_11;
                                    }
                                    catch (Throwable var22_25) {
                                        throw var22_25;
                                    }
                                    finally {
                                        var5_4.busy = 0;
                                    }
                                }
                                var12_10 = 0;
                                var13_11 = null;
                                continue;
                            }
                        }
                    }
                }
                var19_17 = var14_12 << 13;
                var14_12 ^= var19_17;
                var19_17 = var14_12 >>> 17;
                var14_12 ^= var19_17;
                var19_17 = var14_12 << 5;
                var10_8[0] = var14_12 ^= var19_17;
                continue;
            }
            var16_14 = var5_4.busy;
            if (var16_14 == 0 && (var20_18 = var5_4.cells) == var15_13 /* !! */  && (var16_14 = (int)this.casBusy()) != 0) {
                block38: {
                    try {
                        var20_18 = var5_4.cells;
                        if (var20_18 != var15_13 /* !! */ ) break block38;
                        var19_17 = 2;
                    }
                    catch (Throwable var22_26) {
                        var5_4.busy = 0;
                        throw var22_26;
                    }
                    var15_13 /* !! */  = new Striped64$Cell[var19_17];
                    var16_14 = var14_12 & 1;
                    var18_16 = new Striped64$Cell(var6_5);
                    var15_13 /* !! */ [var16_14] = var18_16;
                    var5_4.cells = var15_13 /* !! */ ;
                    var19_17 = var8_6;
                }
                var19_17 = 0;
                var15_13 /* !! */  = null;
                var5_4.busy = 0;
                if (var19_17 == 0) continue;
                break;
            }
            var27_22 = var5_4.base;
            var29_23 = var5_4.fn(var27_22, var6_5);
            var19_17 = var5_4.casBase(var27_22, var29_23);
            if (var19_17 != 0) break;
        }
    }
}

