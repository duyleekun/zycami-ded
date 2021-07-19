/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.mob.tools.gui;

import android.graphics.Bitmap;
import com.mob.tools.gui.BitmapProcessor$BitmapCallback;
import com.mob.tools.gui.BitmapProcessor$BitmapDesiredOptions;
import com.mob.tools.gui.BitmapProcessor$WorkerThread;
import java.util.ArrayList;
import java.util.Iterator;

public class BitmapProcessor$ImageReq {
    private BitmapProcessor$BitmapDesiredOptions bitmapDesiredOptions;
    private ArrayList callbacks;
    private long diskCacheTime;
    private long reqTime;
    private String url;
    private boolean useDiskCache;
    private boolean useRamCache;
    private BitmapProcessor$WorkerThread worker;

    public BitmapProcessor$ImageReq() {
        ArrayList arrayList;
        long l10;
        boolean bl2;
        this.useRamCache = bl2 = true;
        this.useDiskCache = bl2;
        this.diskCacheTime = 0L;
        this.reqTime = l10 = System.currentTimeMillis();
        this.callbacks = arrayList = new ArrayList();
    }

    public static /* synthetic */ String access$000(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        return bitmapProcessor$ImageReq.url;
    }

    public static /* synthetic */ String access$002(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, String string2) {
        bitmapProcessor$ImageReq.url = string2;
        return string2;
    }

    public static /* synthetic */ BitmapProcessor$BitmapDesiredOptions access$100(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        return bitmapProcessor$ImageReq.bitmapDesiredOptions;
    }

    public static /* synthetic */ BitmapProcessor$BitmapDesiredOptions access$102(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, BitmapProcessor$BitmapDesiredOptions bitmapProcessor$BitmapDesiredOptions) {
        bitmapProcessor$ImageReq.bitmapDesiredOptions = bitmapProcessor$BitmapDesiredOptions;
        return bitmapProcessor$BitmapDesiredOptions;
    }

    public static /* synthetic */ BitmapProcessor$WorkerThread access$1402(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, BitmapProcessor$WorkerThread workerThread) {
        bitmapProcessor$ImageReq.worker = workerThread;
        return workerThread;
    }

    public static /* synthetic */ void access$1500(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, Bitmap bitmap) {
        bitmapProcessor$ImageReq.throwComplete(bitmap);
    }

    public static /* synthetic */ void access$1800(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        bitmapProcessor$ImageReq.throwError();
    }

    public static /* synthetic */ ArrayList access$200(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        return bitmapProcessor$ImageReq.callbacks;
    }

    public static /* synthetic */ boolean access$300(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        return bitmapProcessor$ImageReq.useRamCache;
    }

    public static /* synthetic */ boolean access$302(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, boolean bl2) {
        bitmapProcessor$ImageReq.useRamCache = bl2;
        return bl2;
    }

    public static /* synthetic */ long access$400(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        return bitmapProcessor$ImageReq.diskCacheTime;
    }

    public static /* synthetic */ long access$402(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, long l10) {
        bitmapProcessor$ImageReq.diskCacheTime = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$500(BitmapProcessor$ImageReq bitmapProcessor$ImageReq) {
        return bitmapProcessor$ImageReq.useDiskCache;
    }

    public static /* synthetic */ boolean access$502(BitmapProcessor$ImageReq bitmapProcessor$ImageReq, boolean bl2) {
        bitmapProcessor$ImageReq.useDiskCache = bl2;
        return bl2;
    }

    private void throwComplete(Bitmap bitmap) {
        boolean bl2;
        Iterator iterator2 = this.callbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback = (BitmapProcessor$BitmapCallback)iterator2.next();
            String string2 = this.url;
            bitmapProcessor$BitmapCallback.onImageGot(string2, bitmap);
        }
        this.callbacks.clear();
    }

    private void throwError() {
        boolean bl2;
        Iterator iterator2 = this.callbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            BitmapProcessor$BitmapCallback bitmapProcessor$BitmapCallback = (BitmapProcessor$BitmapCallback)iterator2.next();
            String string2 = this.url;
            bitmapProcessor$BitmapCallback.onImageGot(string2, null);
        }
        this.callbacks.clear();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url=");
        String string2 = this.url;
        stringBuilder.append(string2);
        stringBuilder.append("time=");
        long l10 = this.reqTime;
        stringBuilder.append(l10);
        stringBuilder.append("worker=");
        string2 = this.worker.getName();
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        l10 = this.worker.getId();
        stringBuilder.append(l10);
        stringBuilder.append("");
        return stringBuilder.toString();
    }
}

