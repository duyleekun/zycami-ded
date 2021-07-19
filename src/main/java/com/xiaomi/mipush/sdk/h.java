/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.ResolveInfo
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.ah;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.i;
import com.xiaomi.mipush.sdk.j;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.mipush.sdk.m;
import com.xiaomi.push.ai;
import com.xiaomi.push.az;
import com.xiaomi.push.hr;
import com.xiaomi.push.r;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.t;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class h {
    private static HashMap a;

    static {
        HashMap hashMap;
        a = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MiPushMessage a(String string2) {
        String string3 = "extra";
        Object object = "isNotified";
        HashMap<String, String> hashMap = "category";
        String string4 = "notifyId";
        String string5 = "user_account";
        String string6 = "topic";
        String string7 = "alias";
        String string8 = "messageType";
        String string9 = "notifyType";
        String string10 = "passThrough";
        String string11 = "content";
        String string12 = "title";
        String string13 = "description";
        String string14 = "messageId";
        MiPushMessage miPushMessage = new MiPushMessage();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) return miPushMessage;
        try {
            boolean bl3;
            String string15 = string3;
            string3 = string2;
            JSONObject jSONObject = new JSONObject(string2);
            int n10 = jSONObject.has(string14);
            if (n10 != 0) {
                string3 = jSONObject.getString(string14);
                miPushMessage.setMessageId(string3);
            }
            if ((n10 = jSONObject.has(string13)) != 0) {
                string3 = jSONObject.getString(string13);
                miPushMessage.setDescription(string3);
            }
            if ((n10 = jSONObject.has(string12)) != 0) {
                string3 = jSONObject.getString(string12);
                miPushMessage.setTitle(string3);
            }
            if ((n10 = jSONObject.has(string11)) != 0) {
                string3 = jSONObject.getString(string11);
                miPushMessage.setContent(string3);
            }
            if ((n10 = jSONObject.has(string10)) != 0) {
                n10 = jSONObject.getInt(string10);
                miPushMessage.setPassThrough(n10);
            }
            if ((n10 = (int)(jSONObject.has(string9) ? 1 : 0)) != 0) {
                n10 = jSONObject.getInt(string9);
                miPushMessage.setNotifyType(n10);
            }
            if ((n10 = (int)(jSONObject.has(string8) ? 1 : 0)) != 0) {
                n10 = jSONObject.getInt(string8);
                miPushMessage.setMessageType(n10);
            }
            if ((n10 = (int)(jSONObject.has(string7) ? 1 : 0)) != 0) {
                string3 = jSONObject.getString(string7);
                miPushMessage.setAlias(string3);
            }
            if ((n10 = (int)(jSONObject.has(string6) ? 1 : 0)) != 0) {
                string3 = jSONObject.getString(string6);
                miPushMessage.setTopic(string3);
            }
            if ((n10 = (int)(jSONObject.has(string5) ? 1 : 0)) != 0) {
                string3 = jSONObject.getString(string5);
                miPushMessage.setUserAccount(string3);
            }
            if ((n10 = (int)(jSONObject.has(string4) ? 1 : 0)) != 0) {
                n10 = jSONObject.getInt(string4);
                miPushMessage.setNotifyId(n10);
            }
            if ((n10 = (int)(jSONObject.has((String)((Object)hashMap)) ? 1 : 0)) != 0) {
                string3 = jSONObject.getString((String)((Object)hashMap));
                miPushMessage.setCategory(string3);
            }
            if ((n10 = (int)(jSONObject.has((String)object) ? 1 : 0)) != 0) {
                n10 = (int)(jSONObject.getBoolean((String)object) ? 1 : 0);
                miPushMessage.setNotified(n10 != 0);
            }
            string3 = string15;
            boolean bl4 = jSONObject.has(string15);
            if (!bl4) return miPushMessage;
            string3 = jSONObject.getJSONObject(string15);
            object = string3.keys();
            hashMap = new HashMap<String, String>();
            while (object != null && (bl3 = object.hasNext())) {
                string4 = object.next();
                string5 = string3.getString(string4);
                hashMap.put(string4, string5);
            }
            n10 = hashMap.size();
            if (n10 <= 0) return miPushMessage;
            miPushMessage.setExtra(hashMap);
            return miPushMessage;
        }
        catch (Exception exception) {
            string3 = exception.toString();
            b.d(string3);
        }
        return miPushMessage;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static PushMessageReceiver a(Context object) {
        Object object2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        String string2 = object.getPackageName();
        object2.setPackage(string2);
        string2 = object.getPackageManager();
        int n10 = 32;
        object2 = string2.queryBroadcastReceivers((Intent)object2, n10);
        if (object2 == null) return null;
        object2 = object2.iterator();
        while (true) {
            boolean bl2 = object2.hasNext();
            if (!bl2) return null;
            string2 = object2.next();
            string2 = (ResolveInfo)string2;
            Object object3 = ((ResolveInfo)string2).activityInfo;
            if (object3 == null) continue;
            object3 = ((ActivityInfo)object3).packageName;
            String string3 = object.getPackageName();
            n10 = (int)(((String)object3).equals(string3) ? 1 : 0);
            if (n10 != 0) break;
            continue;
            break;
        }
        if (string2 == null) return null;
        try {
            object2 = ((ResolveInfo)string2).activityInfo;
        }
        catch (Exception exception) {
            b.d(exception.toString());
            return null;
        }
        object2 = ((ActivityInfo)object2).name;
        object = t.a(object, (String)object2);
        object = object.newInstance();
        return (PushMessageReceiver)((Object)object);
    }

    /*
     * WARNING - void declaration
     */
    public static String a(Context object, String string2) {
        Class<h> clazz = h.class;
        synchronized (clazz) {
            void var1_6;
            block6: {
                void var1_2;
                HashMap hashMap = a;
                Object v10 = hashMap.get(var1_2);
                String string3 = (String)v10;
                boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (!bl2) break block6;
                String string4 = "";
            }
            return var1_6;
        }
    }

    public static String a(d object) {
        int[] nArray = j.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n10 = 0;
                        object = null;
                    } else {
                        object = "ftos_push_token";
                    }
                } else {
                    object = "cos_push_token";
                }
            } else {
                object = "fcm_push_token";
            }
        } else {
            object = "hms_push_token";
        }
        return object;
    }

    public static HashMap a(Context object, d object2) {
        Object object3;
        HashMap<String, ApplicationInfo> hashMap;
        block9: {
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            int n10;
            Object object4;
            String string7;
            block6: {
                block10: {
                    block7: {
                        block8: {
                            hashMap = new HashMap<String, ApplicationInfo>();
                            string7 = h.a((d)((Object)object2));
                            int n11 = TextUtils.isEmpty((CharSequence)string7);
                            if (n11 != 0) {
                                return hashMap;
                            }
                            object4 = j.a;
                            n10 = ((Enum)object2).ordinal();
                            n10 = object4[n10];
                            n11 = 1;
                            object3 = null;
                            string6 = "package_name";
                            string5 = "token";
                            string4 = "brand:";
                            string3 = ":";
                            string2 = "~";
                            if (n10 == n11) break block6;
                            n11 = 2;
                            if (n10 == n11) break block7;
                            n11 = 3;
                            if (n10 == n11) break block8;
                            n11 = 4;
                            if (n10 != n11) break block9;
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append(string4);
                            object4 = (Object)ah.e;
                            break block10;
                        }
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string4);
                        object4 = ah.d;
                        break block10;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string4);
                    object4 = (Object)ah.c;
                }
                object4 = ((Enum)object4).name();
                ((StringBuilder)object2).append((String)object4);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(string5);
                ((StringBuilder)object2).append(string3);
                string7 = h.a(object, string7);
                ((StringBuilder)object2).append(string7);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(string6);
                ((StringBuilder)object2).append(string3);
                object = object.getPackageName();
                ((StringBuilder)object2).append((String)object);
                object3 = ((StringBuilder)object2).toString();
                break block9;
            }
            object2 = object.getPackageManager();
            object4 = object.getPackageName();
            int n12 = 128;
            try {
                object3 = object2.getApplicationInfo((String)object4, n12);
            }
            catch (Exception exception) {
                object2 = exception.toString();
                b.d((String)object2);
            }
            n10 = -1;
            if (object3 != null) {
                object2 = object3.metaData;
                object4 = "com.huawei.hms.client.appid";
                n10 = object2.getInt((String)object4);
            }
            object4 = new StringBuilder;
            ((StringBuilder)object4)();
            ((StringBuilder)object4).append(string4);
            object3 = m.a(object).name();
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append(string5);
            ((StringBuilder)object4).append(string3);
            string7 = h.a(object, string7);
            ((StringBuilder)object4).append(string7);
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append(string6);
            ((StringBuilder)object4).append(string3);
            object = object.getPackageName();
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append(string2);
            object = "app_id";
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append(string3);
            ((StringBuilder)object4).append(n10);
            object3 = ((StringBuilder)object4).toString();
        }
        hashMap.put("RegInfo", (ApplicationInfo)object3);
        return hashMap;
    }

    public static void a(Context object) {
        int n10;
        boolean bl2 = false;
        Object object2 = object.getSharedPreferences("mipush_extra", 0);
        String string2 = h.a(d.a);
        String string3 = h.a(d.b);
        String string4 = "";
        String string5 = object2.getString(string2, string4);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string5);
        if (!bl3 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object2 = object2.getString(string3, string4))) ? 1 : 0)) != 0) {
            bl2 = true;
        }
        if (bl2) {
            object = aq.a((Context)object);
            n10 = 2;
            ((aq)object).a(n10, string2);
        }
    }

    public static void a(Context context, d object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = h.a(object)));
        if (bl2) {
            return;
        }
        r.a(context.getSharedPreferences("mipush_extra", 0).edit().putString((String)object, ""));
    }

    public static void a(Context object, d d10, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            bl2 = false;
            Object object3 = object.getSharedPreferences("mipush_extra", 0);
            String string2 = h.a(d10);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) {
                b.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            String string3 = "";
            boolean bl4 = TextUtils.isEmpty((CharSequence)(object3 = object3.getString(string2, string3)));
            if (!bl4 && (bl2 = object2.equals(object3))) {
                object = "ASSEMBLE_PUSH : do not need to send token";
                b.a((String)object);
            } else {
                object3 = "ASSEMBLE_PUSH : send token upload";
                b.a((String)object3);
                h.a(d10, object2);
                object2 = k.a(d10);
                if (object2 == null) {
                    return;
                }
                object = aq.a((Context)object);
                bl2 = false;
                object3 = null;
                ((aq)object).a(null, (av)((Object)object2), d10);
            }
        }
    }

    public static void a(Intent intent) {
        String string2;
        boolean bl2;
        Object object;
        if (intent != null && (object = intent.getExtras()) != null && (bl2 = object.containsKey(string2 = "pushMsg"))) {
            object = h.a(object.getString(string2));
            string2 = "key_message";
            intent.putExtra(string2, (Serializable)object);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(d object, String string2) {
        Class<h> clazz = h.class;
        synchronized (clazz) {
            void var1_4;
            String string3 = h.a(object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (bl2) {
                String string4 = "ASSEMBLE_PUSH : can not find the key of token used in sp file";
                b.a(string4);
                return;
            }
            bl2 = TextUtils.isEmpty((CharSequence)var1_4);
            if (bl2) {
                String string5 = "ASSEMBLE_PUSH : token is null";
                b.a(string5);
                return;
            }
            HashMap hashMap = a;
            hashMap.put(string3, var1_4);
            return;
        }
    }

    public static void a(String string2, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("error code = ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        MiTinyDataClient.upload("hms_push_error", string2, 1L, string3);
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return az.b(context);
    }

    public static boolean a(Context object, d d10) {
        hr hr2 = k.a(d10);
        if (hr2 != null) {
            object = ak.a((Context)object);
            int n10 = k.a(d10).a();
            return ((ak)object).a(n10, true);
        }
        return false;
    }

    public static String b(d object) {
        int[] nArray = j.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n10 = 0;
                        object = null;
                    } else {
                        object = "ftos_push_error";
                    }
                } else {
                    object = "cos_push_error";
                }
            } else {
                object = "fcm_push_error";
            }
        } else {
            object = "hms_push_error";
        }
        return object;
    }

    public static void b(Context context) {
        e.a(context).register();
    }

    public static void b(Context context, d d10, String string2) {
        ai ai2 = ai.a(context);
        i i10 = new i(string2, context, d10);
        ai2.a(i10);
    }

    public static void c(Context context) {
        e.a(context).unregister();
    }

    public static /* synthetic */ void c(Context context, d d10, String string2) {
        h.d(context, d10, string2);
    }

    private static void d(Context object, d object2, String string2) {
        Class<h> clazz = h.class;
        synchronized (clazz) {
            block13: {
                object2 = h.a(object2);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl2) break block13;
                object = "ASSEMBLE_PUSH : can not find the key of token used in sp file";
                b.a((String)object);
                return;
            }
            String string3 = "mipush_extra";
            object = object.getSharedPreferences(string3, 0);
            object = object.edit();
            object = object.putString((String)object2, string2);
            r.a((SharedPreferences.Editor)object);
            object = new StringBuilder();
            object2 = "ASSEMBLE_PUSH : update sp file success!  ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            b.a((String)object);
            return;
        }
    }
}

