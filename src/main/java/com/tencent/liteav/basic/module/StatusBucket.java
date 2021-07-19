/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.log.TXCLog;

public class StatusBucket {
    private static final String TAG = "com.tencent.liteav.basic.module.StatusBucket";
    private long mBucketObj = 0L;

    public StatusBucket() {
        long l10;
        this.mBucketObj = l10 = StatusBucket.nativeCreateStatusBucket();
    }

    public StatusBucket(long l10) {
        this.mBucketObj = l10;
    }

    private static native long nativeCreateStatusBucket();

    private static native void nativeDestroyStatusBucket(long var0);

    private static native boolean nativeGetBooleanStatus(long var0, String var2, int var3);

    private static native int nativeGetIntStatus(long var0, String var2, int var3);

    private static native long nativeGetLongStatus(long var0, String var2, int var3);

    private static native void nativeMerge(long var0, long var2);

    private static native void nativeSetBooleanStatus(long var0, String var2, int var3, boolean var4);

    private static native void nativeSetIntStatus(long var0, String var2, int var3, int var4);

    private static native void nativeSetLongStatus(long var0, String var2, int var3, long var4);

    public static void testStatusBucket() {
        Object object = new StatusBucket();
        Object object2 = new StatusBucket();
        CharSequence charSequence = "1";
        int bl2 = 1;
        ((StatusBucket)object).setBooleanStatus((String)charSequence, bl2, bl2 != 0);
        String string2 = "2";
        int n10 = 2;
        ((StatusBucket)object).setIntStatus(string2, n10, n10);
        String string3 = "3";
        int n11 = 3;
        ((StatusBucket)object).setLongStatus(string3, n11, 3);
        int n12 = 4;
        ((StatusBucket)object2).setIntStatus((String)charSequence, n12, n12);
        String string4 = "5";
        int n13 = 5;
        ((StatusBucket)object2).setBooleanStatus(string4, n13, bl2 != 0);
        String string5 = "6";
        int n14 = 6;
        ((StatusBucket)object2).setLongStatus(string5, n14, 6);
        ((StatusBucket)object).merge((StatusBucket)object2);
        object2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("test_status_bucket: id:1, key:1, value:");
        boolean bl3 = ((StatusBucket)object).getBooleanStatus((String)charSequence, bl2);
        stringBuilder.append(bl3);
        CharSequence charSequence2 = stringBuilder.toString();
        TXCLog.e((String)object2, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("test_status_bucket: id:1, key:4, value:");
        int n15 = ((StatusBucket)object).getIntStatus((String)charSequence, n12);
        ((StringBuilder)charSequence2).append(n15);
        charSequence = ((StringBuilder)charSequence2).toString();
        TXCLog.e((String)object2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("test_status_bucket: id:2, key:2, value:");
        int n16 = ((StatusBucket)object).getIntStatus(string2, n10);
        ((StringBuilder)charSequence).append(n16);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.e((String)object2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("test_status_bucket: id:3, key:3, value:");
        long l10 = ((StatusBucket)object).getLongStatus(string3, n11);
        ((StringBuilder)charSequence).append(l10);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.e((String)object2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("test_status_bucket: id:5, key:5, value:");
        boolean bl4 = ((StatusBucket)object).getBooleanStatus(string4, n13);
        ((StringBuilder)charSequence).append(bl4);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.e((String)object2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("test_status_bucket: id:6, key:6, value:");
        l10 = ((StatusBucket)object).getLongStatus(string5, n14);
        ((StringBuilder)charSequence).append(l10);
        object = ((StringBuilder)charSequence).toString();
        TXCLog.e((String)object2, (String)object);
    }

    public void finalize() {
        super.finalize();
        long l10 = this.mBucketObj;
        this.mBucketObj = 0L;
        StatusBucket.nativeDestroyStatusBucket(l10);
    }

    public boolean getBooleanStatus(String string2, int n10) {
        return StatusBucket.nativeGetBooleanStatus(this.mBucketObj, string2, n10);
    }

    public int getIntStatus(String string2, int n10) {
        return StatusBucket.nativeGetIntStatus(this.mBucketObj, string2, n10);
    }

    public long getLongStatus(String string2, int n10) {
        return StatusBucket.nativeGetLongStatus(this.mBucketObj, string2, n10);
    }

    public void merge(StatusBucket statusBucket) {
        long l10 = this.mBucketObj;
        long l11 = statusBucket.mBucketObj;
        StatusBucket.nativeMerge(l10, l11);
    }

    public void setBooleanStatus(String string2, int n10, boolean bl2) {
        StatusBucket.nativeSetBooleanStatus(this.mBucketObj, string2, n10, bl2);
    }

    public void setIntStatus(String string2, int n10, int n11) {
        StatusBucket.nativeSetIntStatus(this.mBucketObj, string2, n10, n11);
    }

    public void setLongStatus(String string2, int n10, long l10) {
        StatusBucket.nativeSetLongStatus(this.mBucketObj, string2, n10, l10);
    }
}

