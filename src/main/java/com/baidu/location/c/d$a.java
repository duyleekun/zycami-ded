/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.baidu.location.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.location.c.d;

public class d$a
extends BroadcastReceiver {
    public final /* synthetic */ d a;

    public d$a(d d10) {
        this.a = d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceive(Context object, Intent object2) {
        object = object2.getAction();
        String string2 = "android.intent.action.BATTERY_CHANGED";
        try {
            int n10;
            int n11;
            int n12;
            block10: {
                String string3;
                block11: {
                    block8: {
                        block9: {
                            n12 = ((String)object).equals(string2);
                            if (n12 == 0) return;
                            object = this.a;
                            n11 = 0;
                            string2 = null;
                            d.a((d)object, false);
                            object = "status";
                            n12 = object2.getIntExtra((String)object, 0);
                            string3 = "plugged";
                            n11 = object2.getIntExtra(string3, 0);
                            string3 = "level";
                            int n13 = -1;
                            int n14 = object2.getIntExtra(string3, n13);
                            String string4 = "scale";
                            n10 = object2.getIntExtra(string4, n13);
                            if (n14 > 0 && n10 > 0) {
                                d d10 = this.a;
                                n14 *= 100;
                                d.a(d10, n14 /= n10);
                            } else {
                                object2 = this.a;
                                d.a((d)object2, n13);
                            }
                            n10 = 2;
                            if (n12 == n10) break block8;
                            n14 = 3;
                            if (n12 == n14 || n12 == (n14 = 4)) break block9;
                            object = this.a;
                            d.a((d)object, null);
                            break block10;
                        }
                        object = this.a;
                        string3 = "3";
                        break block11;
                    }
                    object = this.a;
                    string3 = "4";
                }
                d.a((d)object, string3);
            }
            n12 = 1;
            if (n11 != n12) {
                if (n11 != n10) {
                    return;
                }
                object2 = this.a;
                string2 = "5";
                d.a((d)object2, string2);
            } else {
                object2 = this.a;
                string2 = "6";
                d.a((d)object2, string2);
            }
            object2 = this.a;
            d.a((d)object2, n12 != 0);
            return;
        }
        catch (Exception exception) {
            object = this.a;
            d.a((d)object, null);
        }
    }
}

