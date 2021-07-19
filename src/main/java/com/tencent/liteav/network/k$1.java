/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.e;
import com.tencent.liteav.network.k;
import com.tencent.liteav.network.k$a;
import java.util.Vector;

public class k$1
implements k$a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ k$a e;
    public final /* synthetic */ k f;

    public k$1(k k10, String string2, String string3, String string4, String string5, k$a k$a) {
        this.f = k10;
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = k$a;
    }

    public void a(int n10, String string2, Vector object) {
        boolean bl2;
        Vector<Object> vector = this.f;
        Object object2 = this.a;
        k.a((k)((Object)vector), (String)object2);
        vector = this.f;
        object2 = this.b;
        k.b((k)((Object)vector), (String)object2);
        k.a(this.f, n10);
        vector = this.f;
        k.c((k)((Object)vector), string2);
        if (object != null && !(bl2 = ((Vector)object).isEmpty())) {
            Object object3;
            CharSequence charSequence;
            boolean bl3;
            vector = new Vector<Object>();
            object = ((Vector)object).iterator();
            while (bl3 = object.hasNext()) {
                int n11;
                object2 = (e)object.next();
                charSequence = ((e)object2).a;
                object3 = "?";
                int n12 = ((String)charSequence).indexOf((String)object3);
                if (n12 != (n11 = -1)) {
                    n12 = 0;
                    int n13 = ((String)charSequence).indexOf((String)object3);
                    charSequence = ((String)charSequence).substring(0, n13);
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)charSequence);
                ((StringBuilder)object3).append("?txSecret=");
                charSequence = this.c;
                ((StringBuilder)object3).append((String)charSequence);
                ((StringBuilder)object3).append("&txTime=");
                charSequence = this.d;
                ((StringBuilder)object3).append((String)charSequence);
                ((StringBuilder)object3).append("&bizid=");
                charSequence = this.b;
                ((StringBuilder)object3).append((String)charSequence);
                charSequence = ((StringBuilder)object3).toString();
                bl3 = ((e)object2).b;
                object3 = new e((String)charSequence, bl3);
                vector.add(object3);
            }
            object = this.e;
            if (object != null) {
                object = vector.iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (e)object.next();
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("accurl = ");
                    object3 = ((e)object2).a;
                    ((StringBuilder)charSequence).append((String)object3);
                    object3 = " quic = ";
                    ((StringBuilder)charSequence).append((String)object3);
                    bl3 = ((e)object2).b;
                    ((StringBuilder)charSequence).append(bl3);
                    object2 = ((StringBuilder)charSequence).toString();
                    charSequence = "TXRTMPAccUrlFetcher";
                    TXCLog.e((String)charSequence, (String)object2);
                }
                object = this.e;
                object.a(n10, string2, vector);
            }
        } else {
            object = this.e;
            if (object != null) {
                bl2 = false;
                vector = null;
                object.a(n10, string2, null);
            }
        }
    }
}

