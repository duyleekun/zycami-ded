/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zaw;
import com.google.android.gms.common.api.internal.zax;
import com.google.android.gms.common.api.internal.zay;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

public final class zaz
implements OnCompleteListener {
    private final /* synthetic */ zax zafi;

    private zaz(zax zax2) {
        this.zafi = zax2;
    }

    public /* synthetic */ zaz(zax zax2, zay zay2) {
        this(zax2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onComplete(Task var1_1) {
        block17: {
            block16: {
                var2_3 = zax.zaa(this.zafi);
                var2_3.lock();
                var2_3 = this.zafi;
                var3_4 = zax.zab((zax)var2_3);
                if (!var3_4) {
                    zax.zaa(this.zafi).unlock();
                    return;
                }
                {
                    var3_4 = var1_1.isSuccessful();
                    if (!var3_4) break block16;
                    var1_1 = this.zafi;
                    var4_5 = zax.zac((zax)var1_1);
                    var5_8 = var4_5.size();
                    var2_3 = new ArrayMap(var5_8);
                    zax.zaa((zax)var1_1, (Map)var2_3);
                    var1_1 = this.zafi;
                    var1_1 = zax.zac((zax)var1_1);
                    var1_1 = var1_1.values();
                    var1_1 = var1_1.iterator();
                    while (var3_4 = var1_1.hasNext()) {
                        var2_3 = var1_1.next();
                        var2_3 = (zaw)var2_3;
                        var4_5 = this.zafi;
                        var4_5 = zax.zad((zax)var4_5);
                        var2_3 = var2_3.zak();
                        var6_11 = ConnectionResult.RESULT_SUCCESS;
                        var4_5.put(var2_3, var6_11);
                    }
                    break block17;
                }
            }
            var2_3 = var1_1.getException();
            var3_4 = var2_3 instanceof AvailabilityException;
            if (var3_4) {
                ** try [egrp 2[TRYBLOCK] [22 : 184->651)] { 
lbl40:
                // 1 sources

                var1_1 = var1_1.getException();
                var1_1 = (AvailabilityException)var1_1;
                var2_3 = this.zafi;
                var3_4 = zax.zae((zax)var2_3);
                if (var3_4) {
                    var2_3 = this.zafi;
                    var6_12 = zax.zac((zax)var2_3);
                    var7_13 = var6_12.size();
                    var4_6 = new ArrayMap(var7_13);
                    zax.zaa((zax)var2_3, (Map)var4_6);
                    var2_3 = this.zafi;
                    var2_3 = zax.zac((zax)var2_3);
                    var2_3 = var2_3.values();
                    var2_3 = var2_3.iterator();
                    while (var5_9 = var2_3.hasNext()) {
                        var4_6 = var2_3.next();
                        var4_6 = (zaw)var4_6;
                        var6_12 = var4_6.zak();
                        var9_15 = this.zafi;
                        var8_14 = var1_1.getConnectionResult((GoogleApi)var4_6);
                        var5_9 = zax.zaa(var9_15, (zaw)var4_6, var8_14);
                        if (var5_9) {
                            var4_6 = this.zafi;
                            var4_6 = zax.zad((zax)var4_6);
                            var10_16 = 16;
                            var8_14 = new ConnectionResult(var10_16);
                            var4_6.put(var6_12, var8_14);
                            continue;
                        }
                        var4_6 = this.zafi;
                        var4_6 = zax.zad((zax)var4_6);
                        var4_6.put(var6_12, var8_14);
                    }
                } else {
                    var2_3 = this.zafi;
                    var1_1 = var1_1.zaj();
                    zax.zaa((zax)var2_3, var1_1);
                }
                var1_1 = this.zafi;
                var2_3 = zax.zaf((zax)var1_1);
                zax.zaa((zax)var1_1, (ConnectionResult)var2_3);
            } else {
                var2_3 = "ConnectionlessGAC";
                var4_7 = "Unexpected availability exception";
                var1_1 = var1_1.getException();
                Log.e((String)var2_3, (String)var4_7, (Throwable)var1_1);
                var1_1 = this.zafi;
                var2_3 = Collections.emptyMap();
                zax.zaa(var1_1, (Map)var2_3);
                var1_1 = this.zafi;
                var5_10 = 8;
                var2_3 = new ConnectionResult(var5_10);
                zax.zaa((zax)var1_1, (ConnectionResult)var2_3);
            }
        }
        var1_1 = this.zafi;
        if ((var1_1 = zax.zag((zax)var1_1)) != null) {
            var1_1 = this.zafi;
            var1_1 = zax.zad((zax)var1_1);
            var2_3 = this.zafi;
            var2_3 = zax.zag(var2_3);
            var1_1.putAll(var2_3);
            var1_1 = this.zafi;
            var2_3 = zax.zaf((zax)var1_1);
            zax.zaa((zax)var1_1, (ConnectionResult)var2_3);
        }
        var1_1 = this.zafi;
        if ((var1_1 = zax.zah((zax)var1_1)) == null) {
            var1_1 = this.zafi;
            zax.zai((zax)var1_1);
            var1_1 = this.zafi;
            zax.zaj((zax)var1_1);
        } else {
            var1_1 = this.zafi;
            var3_4 = false;
            var2_3 = null;
            zax.zaa((zax)var1_1, false);
            var1_1 = this.zafi;
            var1_1 = zax.zak((zax)var1_1);
            var2_3 = this.zafi;
            var2_3 = zax.zah((zax)var2_3);
            var1_1.zac((ConnectionResult)var2_3);
        }
        var1_1 = this.zafi;
        var1_1 = zax.zal((zax)var1_1);
        var1_1.signalAll();
        return;
lbl132:
        // 1 sources

        finally {
            zax.zaa(this.zafi).unlock();
        }
    }
}

