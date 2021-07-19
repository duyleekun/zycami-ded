/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.TXCStreamUploader$a;
import com.tencent.liteav.network.l;
import com.tencent.liteav.network.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class TXCStreamUploader$2
extends Thread {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ TXCStreamUploader c;

    public TXCStreamUploader$2(TXCStreamUploader tXCStreamUploader, String string2, boolean bl2, String string3) {
        this.c = tXCStreamUploader;
        this.a = bl2;
        this.b = string3;
        super(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        long l10;
        long l11;
        long l12;
        int n10;
        Object object;
        long l13;
        long l14;
        Object object2;
        boolean bl2;
        long l15;
        long l16;
        long l17;
        Object object3;
        TXCStreamUploader$2 tXCStreamUploader$2 = this;
        while (true) {
            object3 = tXCStreamUploader$2.c;
            l17 = TXCStreamUploader.access$400((TXCStreamUploader)object3);
            l16 = 0L;
            l15 = l17 == l16 ? 0 : (l17 < l16 ? -1 : 1);
            bl2 = false;
            object2 = null;
            if (l15 == false) break;
            l14 = 100;
            try {
                Thread.sleep(l14, 0);
            }
            catch (InterruptedException interruptedException) {}
        }
        TXCStreamUploader.access$500(tXCStreamUploader$2.c).b();
        object3 = TXCStreamUploader.access$500(tXCStreamUploader$2.c);
        boolean bl3 = TXCStreamUploader.access$600((TXCStreamUploader)tXCStreamUploader$2.c).m;
        ((n)object3).a(bl3);
        object3 = TXCStreamUploader.access$500(tXCStreamUploader$2.c);
        Object object4 = TXCStreamUploader.access$700(tXCStreamUploader$2.c);
        ((n)object3).a((String)object4);
        object3 = TXCStreamUploader.access$500(tXCStreamUploader$2.c);
        bl3 = tXCStreamUploader$2.a;
        Object object5 = tXCStreamUploader$2.c;
        Object object6 = tXCStreamUploader$2.b;
        object5 = TXCStreamUploader.access$800((TXCStreamUploader)object5, (String)object6);
        ((n)object3).a(bl3, (String)object5);
        object3 = tXCStreamUploader$2.c;
        object4 = TXCStreamUploader.access$900((TXCStreamUploader)object3);
        synchronized (object4) {
            int n11;
            block28: {
                int n12;
                block26: {
                    block27: {
                        object3 = tXCStreamUploader$2.c;
                        n11 = tXCStreamUploader$2.a;
                        TXCStreamUploader.access$1002((TXCStreamUploader)object3, n11 != 0);
                        object3 = tXCStreamUploader$2.c;
                        object3 = TXCStreamUploader.access$600((TXCStreamUploader)object3);
                        l15 = (long)((l)object3).m;
                        l15 = l15 != false ? ((l15 = (long)TXCStreamUploader.access$1000((TXCStreamUploader)(object3 = tXCStreamUploader$2.c))) != false ? (long)3 : (long)2) : (long)1;
                        object6 = tXCStreamUploader$2.c;
                        n12 = TXCStreamUploader.access$1100((TXCStreamUploader)object6);
                        if (n12 != 0) break block26;
                        object6 = tXCStreamUploader$2.c;
                        if ((object6 = TXCStreamUploader.access$1200((TXCStreamUploader)object6)) == null) break block27;
                        object6 = tXCStreamUploader$2.c;
                        n12 = ((ArrayList)(object6 = TXCStreamUploader.access$1200((TXCStreamUploader)object6))).size();
                        if (n12 != 0) break block28;
                    }
                    l15 = 1;
                    break block28;
                }
                object6 = tXCStreamUploader$2.c;
                n12 = TXCStreamUploader.access$1300((TXCStreamUploader)object6);
                if (n12 != 0) {
                    object6 = tXCStreamUploader$2.c;
                    object6 = TXCStreamUploader.access$600((TXCStreamUploader)object6);
                    ((l)object6).n = false;
                }
            }
            object6 = tXCStreamUploader$2.c;
            int n13 = 7020;
            l13 = l15;
            Object object7 = l13;
            ((a)object6).setStatusValue(n13, object7);
            object6 = tXCStreamUploader$2.c;
            object7 = TXCStreamUploader.access$700((TXCStreamUploader)object6);
            String string2 = tXCStreamUploader$2.b;
            boolean bl4 = tXCStreamUploader$2.a;
            object = tXCStreamUploader$2.c;
            object = TXCStreamUploader.access$600((TXCStreamUploader)object);
            int n14 = ((l)object).e;
            object = tXCStreamUploader$2.c;
            object = TXCStreamUploader.access$600((TXCStreamUploader)object);
            int n15 = ((l)object).d;
            object = tXCStreamUploader$2.c;
            object = TXCStreamUploader.access$600((TXCStreamUploader)object);
            int n16 = ((l)object).a;
            object = tXCStreamUploader$2.c;
            object = TXCStreamUploader.access$600((TXCStreamUploader)object);
            int n17 = ((l)object).c;
            object = tXCStreamUploader$2.c;
            object = TXCStreamUploader.access$600((TXCStreamUploader)object);
            n13 = ((l)object).h;
            n10 = 16;
            object2 = tXCStreamUploader$2.c;
            object2 = TXCStreamUploader.access$600((TXCStreamUploader)object2);
            bl2 = ((l)object2).n;
            object5 = tXCStreamUploader$2.c;
            object5 = TXCStreamUploader.access$600((TXCStreamUploader)object5);
            n11 = ((l)object5).o;
            Object object8 = tXCStreamUploader$2.c;
            object8 = ((TXCStreamUploader)object8).mMetaData;
            int n18 = n13;
            object = object6;
            l16 = TXCStreamUploader.access$1400((TXCStreamUploader)object6, (String)object7, string2, bl4, n14, n15, n16, n17, n13, n10, (int)l15, bl2, n11, (HashMap)object8);
            TXCStreamUploader.access$402((TXCStreamUploader)object6, l16);
            object3 = tXCStreamUploader$2.c;
            l16 = TXCStreamUploader.access$400((TXCStreamUploader)object3);
            l12 = 0L;
            l15 = l16 == l12 ? 0 : (l16 < l12 ? -1 : 1);
            if (l15 != false) {
                boolean bl5;
                object = tXCStreamUploader$2.c;
                l13 = TXCStreamUploader.access$400((TXCStreamUploader)object);
                object3 = tXCStreamUploader$2.c;
                object3 = TXCStreamUploader.access$600((TXCStreamUploader)object3);
                bl4 = ((l)object3).j;
                object3 = tXCStreamUploader$2.c;
                object3 = TXCStreamUploader.access$600((TXCStreamUploader)object3);
                n14 = ((l)object3).h;
                object3 = tXCStreamUploader$2.c;
                object3 = TXCStreamUploader.access$600((TXCStreamUploader)object3);
                n15 = ((l)object3).i;
                TXCStreamUploader.access$1500((TXCStreamUploader)object, l13, bl4, n14, n15);
                object3 = tXCStreamUploader$2.c;
                object3 = TXCStreamUploader.access$1600((TXCStreamUploader)object3);
                object3 = ((Vector)object3).iterator();
                bl2 = false;
                object2 = null;
                while (bl5 = object3.hasNext()) {
                    object8 = object3.next();
                    object8 = (TXSNALPacket)object8;
                    if (!bl2 && (n18 = ((TXSNALPacket)object8).nalType) == 0) {
                        bl2 = true;
                    }
                    if (!bl2) continue;
                    TXCStreamUploader tXCStreamUploader = tXCStreamUploader$2.c;
                    l12 = TXCStreamUploader.access$400(tXCStreamUploader);
                    object = ((TXSNALPacket)object8).nalData;
                    int n19 = ((TXSNALPacket)object8).nalType;
                    long l18 = ((TXSNALPacket)object8).frameIndex;
                    l11 = ((TXSNALPacket)object8).pts;
                    l10 = ((TXSNALPacket)object8).dts;
                    TXCStreamUploader.access$1700(tXCStreamUploader, l12, (byte[])object, n19, l18, l11, l10);
                }
                object3 = tXCStreamUploader$2.c;
                object3 = TXCStreamUploader.access$1600((TXCStreamUploader)object3);
                ((Vector)object3).removeAllElements();
            }
        }
        object3 = tXCStreamUploader$2.c;
        l15 = (long)TXCStreamUploader.access$1100((TXCStreamUploader)object3);
        if (l15 != false) {
            object3 = tXCStreamUploader$2.c;
            object2 = TXCStreamUploader.access$1800((TXCStreamUploader)object3);
            synchronized (object2) {
                object3 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object3);
                l16 = ((TXCStreamUploader$a)object4).a;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                l12 = ((TXCStreamUploader$a)object4).b;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                object = ((TXCStreamUploader$a)object4).c;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                l13 = ((TXCStreamUploader$a)object4).d;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                String string3 = ((TXCStreamUploader$a)object4).e;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                l11 = ((TXCStreamUploader$a)object4).f;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                l10 = ((TXCStreamUploader$a)object4).g;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                Object object9 = object4 = ((TXCStreamUploader$a)object4).h;
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                bl3 = ((TXCStreamUploader$a)object4).i;
                n10 = (int)(bl3 ? 1 : 0);
                object4 = tXCStreamUploader$2.c;
                object4 = TXCStreamUploader.access$2000((TXCStreamUploader)object4);
                String string4 = ((TXCStreamUploader$a)object4).j;
                object4 = object3;
                l14 = TXCStreamUploader.access$2100((TXCStreamUploader)object3, l16, l12, (String)object, l13, string3, l11, l10, (String)object9, bl3, string4);
                TXCStreamUploader.access$1902((TXCStreamUploader)object3, l14);
            }
            object3 = tXCStreamUploader$2.c;
            object4 = TXCStreamUploader.access$2200((TXCStreamUploader)object3);
            synchronized (object4) {
                object3 = tXCStreamUploader$2.c;
                l16 = TXCStreamUploader.access$1900((TXCStreamUploader)object3);
                object2 = tXCStreamUploader$2.c;
                l12 = TXCStreamUploader.access$400((TXCStreamUploader)object2);
                l16 = TXCStreamUploader.access$2400((TXCStreamUploader)object3, l16, l12);
                TXCStreamUploader.access$2302((TXCStreamUploader)object3, l16);
            }
        }
        object3 = tXCStreamUploader$2.c;
        l17 = TXCStreamUploader.access$400((TXCStreamUploader)object3);
        TXCStreamUploader.access$2500((TXCStreamUploader)object3, l17);
        object3 = tXCStreamUploader$2.c;
        l15 = (long)TXCStreamUploader.access$1100((TXCStreamUploader)object3);
        if (l15 != false) {
            object3 = tXCStreamUploader$2.c;
            object2 = TXCStreamUploader.access$2200((TXCStreamUploader)object3);
            synchronized (object2) {
                object3 = tXCStreamUploader$2.c;
                l14 = TXCStreamUploader.access$2300((TXCStreamUploader)object3);
                TXCStreamUploader.access$2600((TXCStreamUploader)object3, l14);
                object3 = tXCStreamUploader$2.c;
                l14 = TXCStreamUploader.access$2300(object3);
                TXCStreamUploader.access$2700(object3, l14);
                object3 = tXCStreamUploader$2.c;
                l14 = 0L;
                TXCStreamUploader.access$2302((TXCStreamUploader)object3, l14);
            }
            object3 = tXCStreamUploader$2.c;
            object4 = TXCStreamUploader.access$1800((TXCStreamUploader)object3);
            synchronized (object4) {
                object3 = tXCStreamUploader$2.c;
                l16 = TXCStreamUploader.access$1900((TXCStreamUploader)object3);
                TXCStreamUploader.access$2800((TXCStreamUploader)object3, l16);
                object3 = tXCStreamUploader$2.c;
                l16 = 0L;
                TXCStreamUploader.access$1902((TXCStreamUploader)object3, l16);
            }
        }
        object3 = tXCStreamUploader$2.c;
        object2 = TXCStreamUploader.access$900((TXCStreamUploader)object3);
        synchronized (object2) {
            object3 = tXCStreamUploader$2.c;
            l14 = TXCStreamUploader.access$400((TXCStreamUploader)object3);
            TXCStreamUploader.access$2900((TXCStreamUploader)object3, l14);
            object3 = tXCStreamUploader$2.c;
            l14 = 0L;
            TXCStreamUploader.access$402(object3, l14);
            return;
        }
    }
}

