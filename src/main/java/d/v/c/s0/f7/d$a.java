/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package d.v.c.s0.f7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.f7.d;
import d.v.e.i.h;
import m.a.a;

public class d$a
extends BroadcastReceiver {
    public final /* synthetic */ d a;

    public d$a(d d10) {
        this.a = d10;
    }

    public void onReceive(Context object, Intent object2) {
        Object object3;
        object = Boolean.FALSE;
        Object object4 = object2.getAction();
        object4.hashCode();
        int n10 = object4.hashCode();
        int n11 = 2;
        int n12 = 1;
        int n13 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 545516589: {
                object3 = "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED";
                boolean bl2 = object4.equals(object3);
                if (!bl2) break;
                n13 = n11;
                break;
            }
            case -549244379: {
                object3 = "android.media.AUDIO_BECOMING_NOISY";
                boolean bl3 = object4.equals(object3);
                if (!bl3) break;
                n13 = n12;
                break;
            }
            case -1676458352: {
                object3 = "android.intent.action.HEADSET_PLUG";
                boolean bl4 = object4.equals(object3);
                if (!bl4) break;
                n13 = 0;
            }
        }
        switch (n13) {
            default: {
                break;
            }
            case 2: {
                int n14 = object2.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                object4 = new Object[n12];
                object4[0] = object3 = Integer.valueOf(n14);
                object3 = "Action \u84dd\u7259\u8033\u673a %s";
                m.a.a.b((String)object3, object4);
                if (n11 == n14) {
                    object = this.a.c;
                    object2 = Boolean.TRUE;
                    h.d((MutableLiveData)object, object2);
                    break;
                }
                if (n14 != 0) break;
                object2 = this.a.c;
                h.d((MutableLiveData)object2, object);
                break;
            }
            case 1: {
                object4 = new Object[]{};
                object3 = "Action \u65ad\u5f00\u901a\u77e5";
                m.a.a.b((String)object3, object4);
                object2 = object2.getExtras();
                if (object2 != null) break;
                object2 = this.a.b;
                h.d((MutableLiveData)object2, object);
                break;
            }
            case 0: {
                object = "state";
                int n15 = object2.getIntExtra((String)object, 0);
                int n16 = object2.getIntExtra("microphone", 0);
                object4 = new Object[n12];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(n15);
                String string2 = " ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(n16);
                object4[0] = object3 = ((StringBuilder)object3).toString();
                object3 = "Action \u6709\u7ebf\u8033\u673a\u6709\u5ef6\u8fdf %s";
                m.a.a.b((String)object3, object4);
                object4 = this.a.b;
                if (n12 != n15 || n12 != n16) {
                    n12 = 0;
                }
                object = n12 != 0;
                h.d((MutableLiveData)object4, object);
            }
        }
    }
}

