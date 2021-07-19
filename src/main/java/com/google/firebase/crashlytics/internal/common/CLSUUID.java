/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class CLSUUID {
    private static String _clsId;
    private static final AtomicLong _sequenceNumber;

    static {
        AtomicLong atomicLong;
        _sequenceNumber = atomicLong = new AtomicLong(0L);
    }

    public CLSUUID(IdManager object) {
        Object object2 = new byte[10];
        this.populateTime((byte[])object2);
        this.populateSequenceNumber((byte[])object2);
        this.populatePID((byte[])object2);
        object = CommonUtils.sha1(((IdManager)object).getCrashlyticsInstallId());
        object2 = CommonUtils.hexify((byte[])object2);
        Locale locale = Locale.US;
        Object[] objectArray = new Object[4];
        int n10 = 12;
        String string2 = ((String)object2).substring(0, n10);
        objectArray[0] = string2;
        int n11 = 16;
        String string3 = ((String)object2).substring(n10, n11);
        objectArray[1] = string3;
        objectArray[2] = object2 = ((String)object2).subSequence(n11, 20);
        objectArray[3] = object = ((String)object).substring(0, n10);
        _clsId = String.format(locale, "%s%s%s%s", objectArray).toUpperCase(locale);
    }

    private static byte[] convertLongToFourByteBuffer(long l10) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        int n10 = (int)l10;
        byteBuffer.putInt(n10);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byteBuffer.order(byteOrder);
        byteBuffer.position(0);
        return byteBuffer.array();
    }

    private static byte[] convertLongToTwoByteBuffer(long l10) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        short s10 = (short)l10;
        byteBuffer.putShort(s10);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byteBuffer.order(byteOrder);
        byteBuffer.position(0);
        return byteBuffer.array();
    }

    private void populatePID(byte[] byArray) {
        byte by2;
        byte by3;
        byte[] byArray2 = CLSUUID.convertLongToTwoByteBuffer(Integer.valueOf(Process.myPid()).shortValue());
        byArray[8] = by3 = byArray2[0];
        byArray[9] = by2 = byArray2[1];
    }

    private void populateSequenceNumber(byte[] byArray) {
        byte by2;
        byte by3;
        byte[] byArray2 = CLSUUID.convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
        byArray[6] = by3 = byArray2[0];
        byArray[7] = by2 = byArray2[1];
    }

    private void populateTime(byte[] byArray) {
        byte by2;
        byte by3;
        int n10;
        byte by4;
        Object object = new Date();
        long l10 = ((Date)object).getTime();
        long l11 = 1000L;
        long l12 = l10 / l11;
        byte[] byArray2 = CLSUUID.convertLongToFourByteBuffer(l12);
        byArray[0] = by4 = byArray2[0];
        by4 = 1;
        byArray[by4] = n10 = byArray2[by4];
        n10 = 2;
        byArray[n10] = by3 = byArray2[n10];
        n10 = 3;
        byArray[n10] = by2 = byArray2[n10];
        object = CLSUUID.convertLongToTwoByteBuffer(l10 %= l11);
        Object object2 = object[0];
        byArray[4] = (byte)object2;
        Object object3 = object[by4];
        byArray[5] = (byte)object3;
    }

    public String toString() {
        return _clsId;
    }
}

