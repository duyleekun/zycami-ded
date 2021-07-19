/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.liteav.qos;

import android.os.Bundle;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.qos.TXCQoS;

public class TXCQoS$1
implements Runnable {
    public final /* synthetic */ TXCQoS a;

    public TXCQoS$1(TXCQoS tXCQoS) {
        this.a = tXCQoS;
    }

    public void run() {
        long l10;
        Object object = TXCQoS.access$000(this.a);
        if (object != null) {
            int n10 = TXCQoS.access$000(this.a).b();
            int n11 = TXCQoS.access$000(this.a).c();
            int n12 = TXCQoS.access$000(this.a).d();
            int n13 = TXCQoS.access$000(this.a).e();
            int n14 = TXCQoS.access$000(this.a).f();
            int n15 = TXCQoS.access$000(this.a).g();
            int n16 = TXCQoS.access$000(this.a).h();
            Object object2 = this.a;
            long l11 = TXCQoS.access$100((TXCQoS)object2);
            TXCQoS.access$200((TXCQoS)object2, l11, n10);
            TXCQoS tXCQoS = this.a;
            long l12 = TXCQoS.access$100(tXCQoS);
            TXCQoS.access$300(tXCQoS, l12, n13, n14, n15, n12, n11, n16);
            object = this.a;
            l10 = TXCQoS.access$100((TXCQoS)object);
            n10 = (int)(TXCQoS.access$400((TXCQoS)object, l10) ? 1 : 0);
            object2 = this.a;
            int n17 = TXCQoS.access$500((TXCQoS)object2);
            if (n17 != n10) {
                TXCQoS.access$502(this.a, n10 != 0);
                object2 = TXCQoS.access$000(this.a);
                object2.a(n10 != 0);
            }
            object = this.a;
            l10 = TXCQoS.access$100((TXCQoS)object);
            n10 = TXCQoS.access$600((TXCQoS)object, l10);
            object2 = this.a;
            l11 = TXCQoS.access$100((TXCQoS)object2);
            n17 = TXCQoS.access$700((TXCQoS)object2, l11);
            tXCQoS = this.a;
            l12 = TXCQoS.access$100(tXCQoS);
            int n18 = TXCQoS.access$800(tXCQoS, l12);
            Object object3 = this.a;
            int n19 = TXCQoS.access$900((TXCQoS)object3);
            Object object4 = "EVT_TIME";
            String string2 = "EVT_MSG";
            if (n17 == n19 && n18 == (n19 = TXCQoS.access$1000((TXCQoS)(object3 = this.a)))) {
                object3 = this.a;
                n19 = TXCQoS.access$1300((TXCQoS)object3);
                if (n10 != n19) {
                    object3 = TXCQoS.access$000(this.a);
                    n14 = 0;
                    CharSequence charSequence = null;
                    object3.a(n10, 0, 0);
                    object3 = TXCQoS.access$1200(this.a);
                    if (object3 != null) {
                        object3 = new Bundle();
                        charSequence = new StringBuilder();
                        String string3 = "Adjust encoding bitrate:new bitrate:";
                        charSequence.append(string3);
                        charSequence.append(n10);
                        charSequence = charSequence.toString();
                        object3.putCharSequence(string2, charSequence);
                        long l13 = TXCTimeUtil.getTimeTick();
                        object3.putLong((String)object4, l13);
                        object4 = TXCQoS.access$1400(this.a);
                        string2 = "EVT_USERID";
                        object3.putString(string2, (String)object4);
                        object4 = TXCQoS.access$1200(this.a);
                        n13 = 1006;
                        object4.onNotifyEvent(n13, (Bundle)object3);
                    }
                }
            } else {
                object3 = this.a;
                n19 = TXCQoS.access$1100((TXCQoS)object3);
                if (n19 == (n14 = 1) || (n19 = TXCQoS.access$1100((TXCQoS)(object3 = this.a))) == (n14 = 5)) {
                    TXCQoS.access$000(this.a).a(n10, n17, n18);
                    object3 = TXCQoS.access$1200(this.a);
                    if (object3 != null) {
                        object3 = new Bundle();
                        CharSequence charSequence = new StringBuilder();
                        charSequence.append("Adjust resolution:new bitrate:");
                        charSequence.append(n10);
                        charSequence.append(" new resolution:");
                        charSequence.append(n17);
                        String string4 = "*";
                        charSequence.append(string4);
                        charSequence.append(n18);
                        charSequence = charSequence.toString();
                        object3.putCharSequence(string2, charSequence);
                        long l14 = TXCTimeUtil.getTimeTick();
                        object3.putLong((String)object4, l14);
                        object4 = TXCQoS.access$1200(this.a);
                        n13 = 1005;
                        object4.onNotifyEvent(n13, (Bundle)object3);
                    }
                }
            }
            object3 = this.a;
            TXCQoS.access$1302((TXCQoS)object3, n10);
            TXCQoS.access$902(this.a, n17);
            object = this.a;
            TXCQoS.access$1002((TXCQoS)object, n18);
        }
        object = TXCQoS.access$1600(this.a);
        l10 = TXCQoS.access$1500(this.a);
        object.postDelayed((Runnable)this, l10);
    }
}

