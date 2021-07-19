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
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zaw;
import com.google.android.gms.common.api.internal.zax;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

public final class zaaa
implements OnCompleteListener {
    private final /* synthetic */ zax zafi;
    private SignInConnectionListener zafj;

    public zaaa(zax zax2, SignInConnectionListener signInConnectionListener) {
        this.zafi = zax2;
        this.zafj = signInConnectionListener;
    }

    public final void cancel() {
        this.zafj.onComplete();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onComplete(Task var1_1) {
        block16: {
            block15: {
                var2_3 = zax.zaa(this.zafi);
                var2_3.lock();
                var2_3 = this.zafi;
                var3_4 = zax.zab((zax)var2_3);
                if (!var3_4) {
                    var1_1 = this.zafj;
                    var1_1.onComplete();
                    zax.zaa(this.zafi).unlock();
                    return;
                }
                {
                    var3_4 = var1_1.isSuccessful();
                    if (!var3_4) break block15;
                    var1_1 = this.zafi;
                    var4_5 = zax.zam((zax)var1_1);
                    var5_8 = var4_5.size();
                    var2_3 = new ArrayMap(var5_8);
                    zax.zab((zax)var1_1, (Map)var2_3);
                    var1_1 = this.zafi;
                    var1_1 = zax.zam((zax)var1_1);
                    var1_1 = var1_1.values();
                    var1_1 = var1_1.iterator();
                    while (var3_4 = var1_1.hasNext()) {
                        var2_3 = var1_1.next();
                        var2_3 = (zaw)var2_3;
                        var4_5 = this.zafi;
                        var4_5 = zax.zag((zax)var4_5);
                        var2_3 = var2_3.zak();
                        var6_10 = ConnectionResult.RESULT_SUCCESS;
                        var4_5.put(var2_3, var6_10);
                    }
                    break block16;
                }
            }
            var2_3 = var1_1.getException();
            var3_4 = var2_3 instanceof AvailabilityException;
            if (var3_4) {
                ** try [egrp 2[TRYBLOCK] [24 : 195->575)] { 
lbl42:
                // 1 sources

                var1_1 = var1_1.getException();
                var1_1 = (AvailabilityException)var1_1;
                var2_3 = this.zafi;
                var3_4 = zax.zae((zax)var2_3);
                if (var3_4) {
                    var2_3 = this.zafi;
                    var6_11 = zax.zam((zax)var2_3);
                    var7_12 = var6_11.size();
                    var4_6 = new ArrayMap(var7_12);
                    zax.zab((zax)var2_3, (Map)var4_6);
                    var2_3 = this.zafi;
                    var2_3 = zax.zam((zax)var2_3);
                    var2_3 = var2_3.values();
                    var2_3 = var2_3.iterator();
                    while (var5_9 = var2_3.hasNext()) {
                        var4_6 = var2_3.next();
                        var4_6 = (zaw)var4_6;
                        var6_11 = var4_6.zak();
                        var9_14 = this.zafi;
                        var8_13 = var1_1.getConnectionResult((GoogleApi)var4_6);
                        var5_9 = zax.zaa(var9_14, (zaw)var4_6, var8_13);
                        if (var5_9) {
                            var4_6 = this.zafi;
                            var4_6 = zax.zag((zax)var4_6);
                            var10_15 = 16;
                            var8_13 = new ConnectionResult(var10_15);
                            var4_6.put(var6_11, var8_13);
                            continue;
                        }
                        var4_6 = this.zafi;
                        var4_6 = zax.zag((zax)var4_6);
                        var4_6.put(var6_11, var8_13);
                    }
                } else {
                    var2_3 = this.zafi;
                    var1_1 = var1_1.zaj();
                    zax.zab((zax)var2_3, var1_1);
                }
            } else {
                var2_3 = "ConnectionlessGAC";
                var4_7 = "Unexpected availability exception";
                var1_1 = var1_1.getException();
                Log.e((String)var2_3, (String)var4_7, (Throwable)var1_1);
                var1_1 = this.zafi;
                var2_3 = Collections.emptyMap();
                zax.zab(var1_1, (Map)var2_3);
            }
        }
        if (var11_16 = (var1_1 = this.zafi).isConnected()) {
            var1_1 = this.zafi;
            var1_1 = zax.zad((zax)var1_1);
            var2_3 = this.zafi;
            var2_3 = zax.zag((zax)var2_3);
            var1_1.putAll(var2_3);
            var1_1 = this.zafi;
            var1_1 = zax.zaf((zax)var1_1);
            if (var1_1 == null) {
                var1_1 = this.zafi;
                zax.zai((zax)var1_1);
                var1_1 = this.zafi;
                zax.zaj((zax)var1_1);
                var1_1 = this.zafi;
                var1_1 = zax.zal((zax)var1_1);
                var1_1.signalAll();
            }
        }
        var1_1 = this.zafj;
        var1_1.onComplete();
        return;
lbl112:
        // 1 sources

        finally {
            zax.zaa(this.zafi).unlock();
        }
    }
}

