/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.Record;

import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a
implements Runnable {
    private WeakReference a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private Thread f;
    private byte[] g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(byte[] object, int n10, long l10) {
        // MONITORENTER : this
        Object object2 = this.a;
        if (object2 != null) {
            object2 = ((Reference)object2).get();
            object2 = (c)object2;
        } else {
            object2 = null;
        }
        // MONITOREXIT : this
        if (object2 != null) {
            object2.onAudioRecordPCM((byte[])object, n10, l10);
            return;
        }
        object = "AudioCenter:TXCAudioBGMRecord";
        String string2 = "onRecordPcmData:no callback";
        TXCLog.e((String)object, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void b() {
        // MONITORENTER : this
        Object object = this.a;
        if (object != null) {
            object = ((Reference)object).get();
            object = (c)object;
        } else {
            object = null;
        }
        // MONITOREXIT : this
        if (object != null) {
            object.onAudioRecordStart();
            return;
        }
        object = "AudioCenter:TXCAudioBGMRecord";
        String string2 = "onRecordStart:no callback";
        TXCLog.e((String)object, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void c() {
        // MONITORENTER : this
        Object object = this.a;
        if (object != null) {
            object = ((Reference)object).get();
            object = (c)object;
        } else {
            object = null;
        }
        // MONITOREXIT : this
        if (object != null) {
            object.onAudioRecordStop();
            return;
        }
        object = "AudioCenter:TXCAudioBGMRecord";
        String string2 = "onRecordStop:no callback";
        TXCLog.e((String)object, string2);
    }

    public void a() {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        String string2 = null;
        this.e = false;
        long l13 = System.currentTimeMillis();
        Object object = this.f;
        String string3 = "AudioCenter:TXCAudioBGMRecord";
        if (object != null && (bl2 = ((Thread)object).isAlive()) && (bl2 = (l12 = (l11 = Thread.currentThread().getId()) - (l10 = ((Thread)(object = this.f)).getId())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            object = this.f;
            try {
                ((Thread)object).join();
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "record stop Exception: ";
                stringBuilder.append(string4);
                object = exception.getMessage();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                TXCLog.e(string3, (String)object);
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("stop record cost time(MS): ");
        l11 = System.currentTimeMillis() - l13;
        ((StringBuilder)object).append(l11);
        string2 = ((StringBuilder)object).toString();
        TXCLog.i(string3, string2);
        this.f = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        int n10 = this.e;
        if (n10 == 0) {
            TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
            return;
        }
        this.b();
        n10 = this.b;
        int n11 = this.c;
        int n12 = this.d;
        int n13 = n11 * 1024 * n12 / 8;
        byte[] byArray = new byte[n13];
        this.g = byArray;
        Arrays.fill(byArray, (byte)0);
        long l10 = 0L;
        long l11 = System.currentTimeMillis();
        while ((object = this.e) != 0 && (object = Thread.interrupted()) == 0) {
            long l12 = System.currentTimeMillis() - l11;
            long l13 = n10;
            l12 *= l13;
            l13 = n11;
            l12 *= l13;
            l13 = n12;
            long l14 = (l12 = l12 * l13 / (long)8 / 1000L - l10) - (l13 = (long)n13);
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object < 0) {
                l12 = 10;
                try {
                    Thread.sleep(l12);
                }
                catch (InterruptedException interruptedException) {}
                continue;
            }
            byte[] byArray2 = this.g;
            long l15 = byArray2.length;
            l10 += l15;
            int n14 = byArray2.length;
            l13 = TXCTimeUtil.getTimeTick();
            this.a(byArray2, n14, l13);
        }
        this.c();
    }
}

