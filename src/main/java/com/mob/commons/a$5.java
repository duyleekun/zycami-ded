/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public final class a$5
implements Runnable {
    public void run() {
        block112: {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            Object[] objectArray;
            block108: {
                block109: {
                    block110: {
                        block111: {
                            block113: {
                                boolean bl2;
                                block114: {
                                    int n10;
                                    Object[] objectArray2;
                                    block107: {
                                        objectArray = null;
                                        object4 = MobSDK.getContext();
                                        object4 = DeviceHelper.getInstance((Context)object4);
                                        object3 = new ArrayList();
                                        object2 = "appkey";
                                        objectArray2 = MobSDK.getAppkey();
                                        object = new KVPair((String)object2, objectArray2);
                                        ((ArrayList)object3).add(object);
                                        object2 = "apppkg";
                                        objectArray2 = ((DeviceHelper)object4).getPackageName();
                                        object = new KVPair((String)object2, objectArray2);
                                        ((ArrayList)object3).add(object);
                                        object2 = "appver";
                                        objectArray2 = ((DeviceHelper)object4).getAppVersionName();
                                        object = new KVPair((String)object2, objectArray2);
                                        ((ArrayList)object3).add(object);
                                        object2 = "plat";
                                        n10 = ((DeviceHelper)object4).getPlatformCode();
                                        objectArray2 = String.valueOf(n10);
                                        object = new KVPair((String)object2, objectArray2);
                                        ((ArrayList)object3).add(object);
                                        object2 = "networktype";
                                        object4 = ((DeviceHelper)object4).getDetailNetworkTypeForStatic();
                                        object = new KVPair((String)object2, object4);
                                        ((ArrayList)object3).add(object);
                                        object4 = DeviceAuthorizer.authorizeForOnce();
                                        boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
                                        if (bl3) break block107;
                                        object2 = "duid";
                                        object = new KVPair((String)object2, object4);
                                        ((ArrayList)object3).add(object);
                                    }
                                    object4 = new NetworkHelper$NetworkTimeOut();
                                    int n11 = 10000;
                                    ((NetworkHelper$NetworkTimeOut)object4).readTimout = n11;
                                    int n12 = 5000;
                                    ((NetworkHelper$NetworkTimeOut)object4).connectionTimeout = n12;
                                    object = new ArrayList();
                                    objectArray2 = "User-Identity";
                                    Object object5 = MobProductCollector.getUserIdentity();
                                    object2 = new KVPair((String)objectArray2, object5);
                                    ((ArrayList)object).add(object2);
                                    object2 = MobLog.getInstance();
                                    objectArray2 = new StringBuilder();
                                    object5 = "Request: ";
                                    objectArray2.append((String)object5);
                                    object5 = a.q();
                                    objectArray2.append((String)object5);
                                    object5 = "\nHeaders: ";
                                    objectArray2.append((String)object5);
                                    objectArray2.append(object);
                                    object5 = "\nValues: ";
                                    objectArray2.append((String)object5);
                                    objectArray2.append(object3);
                                    objectArray2 = objectArray2.toString();
                                    object5 = new Object[]{};
                                    ((NLog)object2).d(objectArray2, (Object[])object5);
                                    object2 = new NetworkHelper();
                                    objectArray2 = a.q();
                                    object4 = ((NetworkHelper)object2).httpGet((String)objectArray2, (ArrayList)object3, (ArrayList)object, (NetworkHelper$NetworkTimeOut)object4);
                                    object3 = MobLog.getInstance();
                                    object = new StringBuilder();
                                    object2 = "Response: ";
                                    ((StringBuilder)object).append((String)object2);
                                    ((StringBuilder)object).append((String)object4);
                                    object = ((StringBuilder)object).toString();
                                    object2 = new Object[]{};
                                    ((NLog)object3).d(object, (Object[])object2);
                                    object3 = new Hashon();
                                    object = ((Hashon)object3).fromJson((String)object4);
                                    object2 = "Response is illegal: ";
                                    if (object == null) break block108;
                                    objectArray2 = "code";
                                    objectArray2 = ((HashMap)object).get(objectArray2);
                                    objectArray2 = String.valueOf(objectArray2);
                                    object5 = "200";
                                    n10 = (int)(((String)object5).equals(objectArray2) ? 1 : 0);
                                    if (n10 == 0) break block109;
                                    objectArray2 = "data";
                                    object = ((HashMap)object).get(objectArray2);
                                    if (object == null) break block110;
                                    object = (HashMap)object;
                                    if (object == null) break block111;
                                    object4 = "content";
                                    object4 = ((HashMap)object).get(object4);
                                    object4 = (String)object4;
                                    object2 = "timestamp";
                                    object = ((HashMap)object).get(object2);
                                    object = (Long)object;
                                    boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
                                    if (bl3) break block112;
                                    long l10 = (Long)object;
                                    object4 = a.a(l10, (String)object4);
                                    object = MobLog.getInstance();
                                    object2 = new StringBuilder();
                                    objectArray2 = "contentDe: ";
                                    ((StringBuilder)object2).append((String)objectArray2);
                                    ((StringBuilder)object2).append((String)object4);
                                    objectArray2 = " (ppms->ppNece)";
                                    ((StringBuilder)object2).append((String)objectArray2);
                                    object2 = ((StringBuilder)object2).toString();
                                    objectArray2 = new Object[]{};
                                    ((NLog)object).d(object2, objectArray2);
                                    object4 = ((Hashon)object3).fromJson((String)object4);
                                    if (object4 == null) break block112;
                                    boolean bl4 = ((HashMap)object4).isEmpty();
                                    if (bl4) break block112;
                                    object3 = "ppms";
                                    object3 = ((HashMap)object4).get(object3);
                                    object3 = (Integer)object3;
                                    if (object3 == null) break block113;
                                    int n13 = (Integer)object3;
                                    int n14 = 1;
                                    if (n13 == n14) break block114;
                                    bl2 = false;
                                    object = null;
                                }
                                object3 = bl2;
                                a.c((Boolean)object3);
                                object3 = a.r();
                                boolean bl5 = (Boolean)object3;
                                i.a(bl5);
                            }
                            object3 = "ppVersion";
                            object4 = ((HashMap)object4).get(object3);
                            object4 = (Integer)object4;
                            if (object4 == null) break block112;
                            int n15 = (Integer)object4;
                            a.c(n15);
                            n15 = a.s();
                            a.d(n15);
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append((String)object4);
                        object4 = ((StringBuilder)object).toString();
                        object3 = new Throwable((String)object4);
                        throw object3;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append((String)object4);
                    object4 = ((StringBuilder)object).toString();
                    object3 = new Throwable((String)object4);
                    throw object3;
                }
                object = new StringBuilder();
                object2 = "Response code is not 200: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)object4);
                object4 = ((StringBuilder)object).toString();
                object3 = new Throwable((String)object4);
                throw object3;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append((String)object4);
            object4 = ((StringBuilder)object).toString();
            try {
                object3 = new Throwable((String)object4);
                throw object3;
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                objectArray = new Object[]{};
                object = "Request total switch error";
                ((NLog)object3).e(throwable, object, objectArray);
            }
        }
    }
}

