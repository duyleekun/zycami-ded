/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.h;
import java.util.HashMap;

public class ar
extends Handler {
    public final /* synthetic */ aq a;

    public ar(aq aq2, Looper looper) {
        this.a = aq2;
        super(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispatchMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 19;
        if (n10 != n11) {
            return;
        }
        String string2 = (String)((Message)object).obj;
        int n12 = ((Message)object).arg1;
        Class<ag> clazz = ag.class;
        synchronized (clazz) {
            block15: {
                block6: {
                    block10: {
                        Object object2;
                        Object object3;
                        block12: {
                            Object object4;
                            int n13;
                            block14: {
                                block13: {
                                    block11: {
                                        block9: {
                                            boolean bl2;
                                            block8: {
                                                Object object5;
                                                block7: {
                                                    object3 = this.a;
                                                    object3 = aq.a((aq)object3);
                                                    object3 = ag.a((Context)object3);
                                                    int n14 = ((ag)object3).a(string2);
                                                    if (n14 == 0) return;
                                                    object3 = this.a;
                                                    object3 = aq.a((aq)object3);
                                                    n14 = ((ag)(object3 = ag.a((Context)object3))).a(string2);
                                                    if (n14 >= (n13 = 10)) break block6;
                                                    object3 = av.a;
                                                    n13 = ((Enum)object3).ordinal();
                                                    bl2 = true;
                                                    if (n13 != n12) break block7;
                                                    object2 = "syncing";
                                                    object5 = this.a;
                                                    object5 = aq.a((aq)object5);
                                                    object5 = ag.a((Context)object5);
                                                    n13 = (int)(((String)object2).equals(object5 = ((ag)object5).a((av)((Object)object3))) ? 1 : 0);
                                                    if (n13 == 0) break block7;
                                                    object = this.a;
                                                    break block8;
                                                }
                                                if ((n13 = ((Enum)(object3 = av.b)).ordinal()) != n12) break block9;
                                                object2 = "syncing";
                                                object5 = this.a;
                                                object5 = aq.a((aq)object5);
                                                object5 = ag.a((Context)object5);
                                                n13 = (int)(((String)object2).equals(object5 = ((ag)object5).a((av)((Object)object3))) ? 1 : 0);
                                                if (n13 == 0) break block9;
                                                object = this.a;
                                            }
                                            aq.a((aq)object, string2, (av)((Object)object3), bl2, null);
                                            break block10;
                                        }
                                        if ((n13 = ((Enum)(object3 = av.c)).ordinal()) != n12) break block11;
                                        object2 = "syncing";
                                        object4 = this.a;
                                        object4 = aq.a((aq)object4);
                                        object4 = ag.a((Context)object4);
                                        n13 = (int)(((String)object2).equals(object4 = ((ag)object4).a((av)((Object)object3))) ? 1 : 0);
                                        if (n13 == 0) break block11;
                                        object = this.a;
                                        object2 = aq.a((aq)object);
                                        object4 = d.a;
                                        object2 = h.a((Context)object2, (d)((Object)object4));
                                        break block12;
                                    }
                                    if ((n13 = ((Enum)(object3 = av.d)).ordinal()) != n12) break block13;
                                    object2 = "syncing";
                                    object4 = this.a;
                                    object4 = aq.a((aq)object4);
                                    object4 = ag.a((Context)object4);
                                    n13 = (int)(((String)object2).equals(object4 = ((ag)object4).a((av)((Object)object3))) ? 1 : 0);
                                    if (n13 == 0) break block13;
                                    object = this.a;
                                    object2 = aq.a((aq)object);
                                    object4 = d.b;
                                    object2 = h.a((Context)object2, (d)((Object)object4));
                                    break block12;
                                }
                                if ((n13 = ((Enum)(object3 = av.e)).ordinal()) != n12) break block14;
                                object2 = "syncing";
                                object4 = this.a;
                                object4 = aq.a((aq)object4);
                                object4 = ag.a((Context)object4);
                                n13 = (int)(((String)object2).equals(object4 = ((ag)object4).a((av)((Object)object3))) ? 1 : 0);
                                if (n13 == 0) break block14;
                                object = this.a;
                                object2 = aq.a((aq)object);
                                object4 = d.c;
                                object2 = h.a((Context)object2, (d)((Object)object4));
                                break block12;
                            }
                            if ((n13 = ((Enum)(object3 = av.f)).ordinal()) != n12) break block10;
                            object = "syncing";
                            object2 = this.a;
                            object2 = aq.a((aq)object2);
                            object2 = ag.a((Context)object2);
                            n12 = (int)(((String)object).equals(object2 = ((ag)object2).a((av)((Object)object3))) ? 1 : 0);
                            if (n12 == 0) break block10;
                            object = this.a;
                            object2 = aq.a((aq)object);
                            object4 = d.d;
                            object2 = h.a((Context)object2, (d)((Object)object4));
                        }
                        aq.a((aq)object, string2, (av)((Object)object3), false, (HashMap)object2);
                    }
                    object = this.a;
                    object = aq.a((aq)object);
                    object = ag.a((Context)object);
                    ((ag)object).b(string2);
                    break block15;
                }
                object = this.a;
                object = aq.a((aq)object);
                object = ag.a((Context)object);
                ((ag)object).c(string2);
            }
            return;
        }
    }
}

