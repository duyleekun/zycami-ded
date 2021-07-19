/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.baidu.location.b;

import android.os.Message;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.b.n;
import com.baidu.location.b.n$a;

public class n$e
extends BDAbstractLocationListener {
    public final /* synthetic */ n a;

    public n$e(n n10) {
        this.a = n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void onReceiveLocation(BDLocation object) {
        block2: {
            void var1_16;
            block4: {
                Object object2;
                Object object3;
                block5: {
                    void var1_7;
                    String string2;
                    block8: {
                        int n10;
                        block7: {
                            block6: {
                                block3: {
                                    object3 = this.a;
                                    int n11 = n.a((n)object3);
                                    if (n11 == 0 || object == null) break block2;
                                    object3 = new BDLocation((BDLocation)object);
                                    n10 = ((BDLocation)object3).getLocType();
                                    object2 = ((BDLocation)object3).getCoorType();
                                    int n12 = 61;
                                    if (n10 == n12 || n10 == (n12 = 161) || n10 == (n12 = 66)) break block3;
                                    n$a n$a = n.b(this.a);
                                    n11 = 5;
                                    Message message = n$a.obtainMessage(n11);
                                    break block4;
                                }
                                if (object2 == null) break block5;
                                String string3 = "gcj02";
                                n10 = (int)(((String)object2).equals(string3) ? 1 : 0);
                                string2 = "gcj2wgs";
                                if (n10 == 0) break block6;
                                object3 = LocationClient.getBDLocationInCoorType((BDLocation)object3, string2);
                                break block5;
                            }
                            String string4 = "bd09";
                            n10 = (int)(((String)object2).equals(string4) ? 1 : 0);
                            if (n10 == 0) break block7;
                            String string5 = "bd092gcj";
                            break block8;
                        }
                        String string6 = "bd09ll";
                        n10 = (int)(((String)object2).equals(string6) ? 1 : 0);
                        if (n10 == 0) break block5;
                        String string7 = "bd09ll2gcj";
                    }
                    BDLocation bDLocation = LocationClient.getBDLocationInCoorType((BDLocation)object3, (String)var1_7);
                    object3 = LocationClient.getBDLocationInCoorType(bDLocation, string2);
                }
                n n13 = this.a;
                long l10 = System.currentTimeMillis();
                n.a(n13, l10);
                n n14 = this.a;
                object2 = new BDLocation((BDLocation)object3);
                n.a(n14, (BDLocation)object2);
                n$a n$a = n.b(this.a);
                int n15 = 2;
                Message message = n$a.obtainMessage(n15);
                message.obj = object3;
            }
            var1_16.sendToTarget();
        }
    }
}

