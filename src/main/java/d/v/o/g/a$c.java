/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 */
package d.v.o.g;

import android.os.Bundle;
import android.util.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import d.v.o.f.d;
import d.v.o.g.a;

public class a$c
implements ITXLivePushListener {
    public final /* synthetic */ a a;

    public a$c(a a10) {
        this.a = a10;
    }

    public void onNetStatus(Bundle bundle) {
        Object object;
        if (bundle != null && (object = d.v.o.g.a.H(this.a)) != null) {
            object = this.a;
            int n10 = bundle.getInt("VIDEO_FPS");
            d.v.o.g.a.K((a)object, n10);
            object = this.a;
            n10 = bundle.getInt("NET_SPEED");
            d.v.o.g.a.M((a)object, n10);
            object = this.a;
            String string2 = "VIDEO_BITRATE";
            int n11 = bundle.getInt(string2);
            d.v.o.g.a.w((a)object, n11);
        }
    }

    public void onPushEvent(int n10, Bundle object) {
        d d10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Tx onPushEvent(raw platform) event:");
        charSequence.append(n10);
        charSequence.append("  param:");
        Object object2 = object.toString();
        charSequence.append((String)object2);
        charSequence = charSequence.toString();
        object2 = "TencentLivePusher";
        Log.i((String)object2, (String)charSequence);
        charSequence = object.getString("EVT_MSG");
        int n11 = 1001;
        if (n10 == n11) {
            object = d.v.o.g.a.R(this.a);
            if (object != null) {
                object = d.v.o.g.a.v(this.a);
                boolean bl2 = true;
                object.b(bl2);
            }
        } else {
            n11 = 1002;
            if (n10 == n11) {
                object = d.v.o.g.a.x(this.a);
                if (object != null) {
                    object = d.v.o.g.a.y(this.a);
                    object.c();
                }
            } else {
                n11 = -1307;
                String string2 = null;
                if (n10 != n11 && n10 != (n11 = -1313) && n10 != (n11 = -1301) && n10 != (n11 = -1302) && n10 != (n11 = -1303) && n10 != (n11 = -1304) && n10 != (n11 = -1305) && n10 != (n11 = -1306)) {
                    n11 = 1103;
                    if (n10 == n11) {
                        d.v.o.g.a.B(0);
                        d.v.o.g.a.C(this.a).setHardwareAcceleration(0);
                        object = d.v.o.g.a.D(this.a);
                        object2 = d.v.o.g.a.C(this.a);
                        ((TXLivePusher)object).setConfig((TXLivePushConfig)object2);
                    } else {
                        n11 = 1005;
                        string2 = "EVT_PARAM1";
                        if (n10 == n11) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Tx change resolution to ");
                            int n12 = object.getInt("EVT_PARAM2");
                            stringBuilder.append(n12);
                            String string3 = ", bitrate to";
                            stringBuilder.append(string3);
                            int n13 = object.getInt(string2);
                            stringBuilder.append(n13);
                            object = stringBuilder.toString();
                            Log.i((String)object2, (String)object);
                        } else {
                            n11 = 1006;
                            if (n10 == n11) {
                                StringBuilder stringBuilder = new StringBuilder();
                                String string4 = "Tx change bitrate to";
                                stringBuilder.append(string4);
                                int n14 = object.getInt(string2);
                                stringBuilder.append(n14);
                                object = stringBuilder.toString();
                                Log.i((String)object2, (String)object);
                            } else {
                                n11 = 1003;
                                if (n10 != n11 && n10 == (n11 = 1101)) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    String string5 = "Tx network busy. ";
                                    stringBuilder.append(string5);
                                    int n15 = object.getInt(string2);
                                    stringBuilder.append(n15);
                                    object = stringBuilder.toString();
                                    Log.i((String)object2, (String)object);
                                }
                            }
                        }
                    }
                } else {
                    object = d.v.o.g.a.z(this.a);
                    if (object != null) {
                        object = d.v.o.g.a.A(this.a);
                        object.b(false);
                    }
                    object = this.a;
                    ((a)object).a();
                }
            }
        }
        if (n10 < 0 && (d10 = d.v.o.g.a.E(this.a)) != null) {
            d10 = d.v.o.g.a.F(this.a);
            d10.e((String)charSequence);
        }
    }
}

