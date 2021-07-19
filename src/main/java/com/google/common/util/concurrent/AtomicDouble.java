/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDouble
extends Number
implements Serializable {
    private static final long serialVersionUID;
    private transient AtomicLong value;

    public AtomicDouble() {
        this(0.0);
    }

    public AtomicDouble(double d10) {
        AtomicLong atomicLong;
        long l10 = Double.doubleToRawLongBits(d10);
        this.value = atomicLong = new AtomicLong(l10);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        AtomicLong atomicLong;
        objectInputStream.defaultReadObject();
        this.value = atomicLong = new AtomicLong();
        double d10 = objectInputStream.readDouble();
        this.set(d10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        double d10 = this.get();
        objectOutputStream.writeDouble(d10);
    }

    public final double addAndGet(double d10) {
        double d11;
        long l10;
        AtomicLong atomicLong;
        long l11;
        AtomicLong atomicLong2;
        boolean bl2;
        while (!(bl2 = (atomicLong2 = this.value).compareAndSet(l11 = (atomicLong = this.value).get(), l10 = Double.doubleToRawLongBits(d11 = Double.longBitsToDouble(l11) + d10)))) {
        }
        return d11;
    }

    public final boolean compareAndSet(double d10, double d11) {
        AtomicLong atomicLong = this.value;
        long l10 = Double.doubleToRawLongBits(d10);
        long l11 = Double.doubleToRawLongBits(d11);
        return atomicLong.compareAndSet(l10, l11);
    }

    public double doubleValue() {
        return this.get();
    }

    public float floatValue() {
        return (float)this.get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    public final double getAndAdd(double d10) {
        double d11;
        double d12;
        long l10;
        AtomicLong atomicLong;
        long l11;
        AtomicLong atomicLong2;
        boolean bl2;
        while (!(bl2 = (atomicLong2 = this.value).compareAndSet(l11 = (atomicLong = this.value).get(), l10 = Double.doubleToRawLongBits(d12 = (d11 = Double.longBitsToDouble(l11)) + d10)))) {
        }
        return d11;
    }

    public final double getAndSet(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        return Double.longBitsToDouble(this.value.getAndSet(l10));
    }

    public int intValue() {
        return (int)this.get();
    }

    public final void lazySet(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.value.lazySet(l10);
    }

    public long longValue() {
        return (long)this.get();
    }

    public final void set(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        this.value.set(l10);
    }

    public String toString() {
        return Double.toString(this.get());
    }

    public final boolean weakCompareAndSet(double d10, double d11) {
        AtomicLong atomicLong = this.value;
        long l10 = Double.doubleToRawLongBits(d10);
        long l11 = Double.doubleToRawLongBits(d11);
        return atomicLong.weakCompareAndSet(l10, l11);
    }
}

