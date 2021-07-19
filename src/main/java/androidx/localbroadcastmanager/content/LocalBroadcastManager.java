/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 */
package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord;
import androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final HashMap mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList mPendingBroadcasts;
    private final HashMap mReceivers;

    static {
        Object object;
        mLock = object = new Object();
    }

    private LocalBroadcastManager(Context context) {
        Object object;
        this.mReceivers = object = new Object();
        this.mActions = object = new Object();
        this.mPendingBroadcasts = object;
        this.mAppContext = context;
        context = context.getMainLooper();
        super(this, (Looper)context);
        this.mHandler = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static LocalBroadcastManager getInstance(Context object) {
        Object object2 = mLock;
        synchronized (object2) {
            LocalBroadcastManager localBroadcastManager = mInstance;
            if (localBroadcastManager != null) return mInstance;
            object = object.getApplicationContext();
            mInstance = localBroadcastManager = new LocalBroadcastManager((Context)object);
            return mInstance;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executePendingBroadcasts() {
        block3: while (true) {
            ArrayList arrayList;
            LocalBroadcastManager$BroadcastRecord[] localBroadcastManager$BroadcastRecordArray;
            int n10;
            HashMap hashMap = this.mReceivers;
            synchronized (hashMap) {
                ArrayList arrayList2 = this.mPendingBroadcasts;
                n10 = arrayList2.size();
                if (n10 <= 0) {
                    return;
                }
                localBroadcastManager$BroadcastRecordArray = new LocalBroadcastManager$BroadcastRecord[n10];
                arrayList = this.mPendingBroadcasts;
                arrayList.toArray(localBroadcastManager$BroadcastRecordArray);
                arrayList = this.mPendingBroadcasts;
                arrayList.clear();
            }
            hashMap = null;
            int n11 = 0;
            arrayList = null;
            while (true) {
                if (n11 >= n10) continue block3;
                LocalBroadcastManager$BroadcastRecord localBroadcastManager$BroadcastRecord = localBroadcastManager$BroadcastRecordArray[n11];
                ArrayList arrayList3 = localBroadcastManager$BroadcastRecord.receivers;
                int n12 = arrayList3.size();
                for (int i10 = 0; i10 < n12; ++i10) {
                    LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = (LocalBroadcastManager$ReceiverRecord)localBroadcastManager$BroadcastRecord.receivers.get(i10);
                    boolean bl2 = localBroadcastManager$ReceiverRecord.dead;
                    if (bl2) continue;
                    localBroadcastManager$ReceiverRecord = localBroadcastManager$ReceiverRecord.receiver;
                    Context context = this.mAppContext;
                    Intent intent = localBroadcastManager$BroadcastRecord.intent;
                    localBroadcastManager$ReceiverRecord.onReceive(context, intent);
                }
                ++n11;
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        HashMap hashMap = this.mReceivers;
        synchronized (hashMap) {
            Cloneable cloneable;
            LocalBroadcastManager$ReceiverRecord localBroadcastManager$ReceiverRecord = new LocalBroadcastManager$ReceiverRecord(intentFilter, broadcastReceiver);
            Object object = this.mReceivers;
            object = ((HashMap)object).get(broadcastReceiver);
            object = (ArrayList)object;
            int n10 = 1;
            if (object == null) {
                object = new ArrayList(n10);
                cloneable = this.mReceivers;
                cloneable.put(broadcastReceiver, object);
            }
            ((ArrayList)object).add(localBroadcastManager$ReceiverRecord);
            int n11 = 0;
            broadcastReceiver = null;
            int n12;
            while (n11 < (n12 = intentFilter.countActions())) {
                object = intentFilter.getAction(n11);
                cloneable = this.mActions;
                cloneable = cloneable.get(object);
                if ((cloneable = (ArrayList)cloneable) == null) {
                    cloneable = new ArrayList(n10);
                    HashMap hashMap2 = this.mActions;
                    hashMap2.put(object, cloneable);
                }
                ((ArrayList)cloneable).add(localBroadcastManager$ReceiverRecord);
                ++n11;
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean sendBroadcast(Intent var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        var4_4 = this.mReceivers;
        synchronized (var4_4) {
            block14: {
                var5_5 = var1_1.getAction();
                var6_6 = this.mAppContext;
                var6_6 = var6_6.getContentResolver();
                var7_7 = var1_1.resolveTypeIfNeeded((ContentResolver)var6_6);
                var8_8 = var1_1.getData();
                var9_9 = var1_1.getScheme();
                var10_10 = var1_1.getCategories();
                var11_11 = var1_1.getFlags() & 8;
                var12_12 = var11_11 != 0;
                if (var12_12) {
                    var6_6 = "LocalBroadcastManager";
                    var13_13 = new StringBuilder();
                    var14_14 = "Resolving type ";
                    var13_13.append((String)var14_14);
                    var13_13.append(var7_7);
                    var14_14 = " scheme ";
                    var13_13.append((String)var14_14);
                    var13_13.append(var9_9);
                    var14_14 = " of intent ";
                    var13_13.append((String)var14_14);
                    var13_13.append(var3_3);
                    var13_13 = var13_13.toString();
                    Log.v((String)var6_6, (String)var13_13);
                }
                var6_6 = var2_2.mActions;
                var13_13 = var1_1.getAction();
                var15_15 = var6_6 = var6_6.get(var13_13);
                var15_15 = (ArrayList)var6_6;
                if (var15_15 == null) break block14;
                if (var12_12) {
                    var6_6 = "LocalBroadcastManager";
                    var13_13 = new StringBuilder();
                    var14_14 = "Action list: ";
                    var13_13.append((String)var14_14);
                    var13_13.append(var15_15);
                    var13_13 = var13_13.toString();
                    Log.v((String)var6_6, (String)var13_13);
                }
                var11_11 = 0;
                var6_6 = null;
                var16_16 = null;
                var17_17 = 0;
                var18_18 = null;
                while (var17_17 < (var11_11 = var15_15.size())) {
                    block15: {
                        var14_14 = var6_6 = var15_15.get(var17_17);
                        var14_14 = (LocalBroadcastManager$ReceiverRecord)var6_6;
                        if (var12_12) {
                            var6_6 = "LocalBroadcastManager";
                            var13_13 = new StringBuilder();
                            var19_19 = "Matching against filter ";
                            var13_13.append(var19_19);
                            var19_19 = var14_14.filter;
                            var13_13.append((Object)var19_19);
                            var13_13 = var13_13.toString();
                            Log.v((String)var6_6, (String)var13_13);
                        }
                        if ((var11_11 = (int)var14_14.broadcasting) == 0) break block15;
                        if (var12_12) {
                            var6_6 = "LocalBroadcastManager";
                            var13_13 = "  Filter's target already added";
                            Log.v((String)var6_6, (String)var13_13);
                        }
                        var20_20 = var17_17;
                        var21_21 = var15_15;
                        var22_22 = var5_5;
                        var23_23 = var7_7;
                        var24_24 = 1;
                        var5_5 = var16_16;
                        ** GOTO lbl131
                    }
                    var6_6 = var14_14.filter;
                    var19_19 = "LocalBroadcastManager";
                    var13_13 = var5_5;
                    var25_25 = var14_14;
                    var14_14 = var7_7;
                    var20_20 = var17_17;
                    var18_18 = var9_9;
                    var22_22 = var5_5;
                    var5_5 = var16_16;
                    var16_16 = var8_8;
                    var21_21 = var15_15;
                    var15_15 = var10_10;
                    var23_23 = var7_7;
                    var24_24 = 1;
                    var11_11 = var6_6.match((String)var13_13, var7_7, var9_9, var8_8, var10_10, var19_19);
                    if (var11_11 >= 0) {
                        if (var12_12) {
                            var13_13 = "LocalBroadcastManager";
                            var14_14 = new StringBuilder();
                            var18_18 = "  Filter matched!  match=0x";
                            var14_14.append(var18_18);
                            var6_6 = Integer.toHexString(var11_11);
                            var14_14.append((String)var6_6);
                            var6_6 = var14_14.toString();
                            Log.v((String)var13_13, (String)var6_6);
                        }
                        var16_16 = var5_5 == null ? new Object() : var5_5;
                        var16_16.add(var25_25);
                        var25_25.broadcasting = var24_24;
                    } else {
                        if (var12_12) {
                            var26_26 = -4;
                            var6_6 = var11_11 != var26_26 ? (var11_11 != (var26_26 = -3) ? (var11_11 != (var26_26 = -2) ? (var11_11 != (var26_26 = -1) ? "unknown reason" : "type") : "data") : "action") : "category";
                            var13_13 = "LocalBroadcastManager";
                            var14_14 = new StringBuilder();
                            var18_18 = "  Filter did not match: ";
                            var14_14.append(var18_18);
                            var14_14.append((String)var6_6);
                            var6_6 = var14_14.toString();
                            Log.v((String)var13_13, (String)var6_6);
                        }
lbl131:
                        // 4 sources

                        var16_16 = var5_5;
                    }
                    var17_17 = var20_20 + 1;
                    var5_5 = var22_22;
                    var15_15 = var21_21;
                    var7_7 = var23_23;
                }
                var5_5 = var16_16;
                var24_24 = 1;
                if (var16_16 != null) {
                    var6_6 = null;
                    for (var11_11 = 0; var11_11 < (var26_26 = var5_5.size()); ++var11_11) {
                        var13_13 = var5_5.get(var11_11);
                        var13_13 = (LocalBroadcastManager$ReceiverRecord)var13_13;
                        var14_14 = null;
                        var13_13.broadcasting = false;
                    }
                    var6_6 = var2_2.mPendingBroadcasts;
                    var13_13 = new LocalBroadcastManager$BroadcastRecord(var3_3, (ArrayList)var5_5);
                    var6_6.add(var13_13);
                    var3_3 = var2_2.mHandler;
                    var27_27 = var3_3.hasMessages(var24_24);
                    if (!var27_27) {
                        var3_3 = var2_2.mHandler;
                        var3_3.sendEmptyMessage(var24_24);
                    }
                    return (boolean)var24_24;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        boolean bl2 = this.sendBroadcast(intent);
        if (bl2) {
            this.executePendingBroadcasts();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        HashMap hashMap = this.mReceivers;
        synchronized (hashMap) {
            Cloneable cloneable = this.mReceivers;
            cloneable = ((HashMap)cloneable).remove(broadcastReceiver);
            cloneable = (ArrayList)cloneable;
            if (cloneable == null) {
                return;
            }
            int n10 = ((ArrayList)cloneable).size();
            int n11 = 1;
            n10 -= n11;
            while (n10 >= 0) {
                Object object;
                int n12;
                Object object2 = ((ArrayList)cloneable).get(n10);
                object2 = (LocalBroadcastManager$ReceiverRecord)object2;
                ((LocalBroadcastManager$ReceiverRecord)object2).dead = n11;
                for (int i10 = 0; i10 < (n12 = (object = ((LocalBroadcastManager$ReceiverRecord)object2).filter).countActions()); ++i10) {
                    object = ((LocalBroadcastManager$ReceiverRecord)object2).filter;
                    object = object.getAction(i10);
                    Cloneable cloneable2 = this.mActions;
                    cloneable2 = ((HashMap)cloneable2).get(object);
                    if ((cloneable2 = (ArrayList)cloneable2) == null) continue;
                    for (int i11 = ((ArrayList)cloneable2).size() - n11; i11 >= 0; i11 += -1) {
                        Object object3 = ((ArrayList)cloneable2).get(i11);
                        object3 = (LocalBroadcastManager$ReceiverRecord)object3;
                        BroadcastReceiver broadcastReceiver2 = ((LocalBroadcastManager$ReceiverRecord)object3).receiver;
                        if (broadcastReceiver2 != broadcastReceiver) continue;
                        ((LocalBroadcastManager$ReceiverRecord)object3).dead = n11;
                        ((ArrayList)cloneable2).remove(i11);
                    }
                    int n13 = ((ArrayList)cloneable2).size();
                    if (n13 > 0) continue;
                    cloneable2 = this.mActions;
                    ((HashMap)cloneable2).remove(object);
                }
                n10 += -1;
            }
            return;
        }
    }
}

