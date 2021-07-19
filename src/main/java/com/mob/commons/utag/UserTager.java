/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons.utag;

import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.j;
import com.mob.commons.utag.UserTagError;
import com.mob.commons.utag.UserTager$1;
import com.mob.commons.utag.UserTager$CustomTag;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.SQLiteHelper$SingleTableDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class UserTager
implements PublicMemberKeeper {
    private static Handler a;
    private static SQLiteHelper$SingleTableDB b;
    private static Hashon c;
    private static DeviceHelper d;
    private HashMap e;
    private UserTagError f;

    static {
        Object object = SQLiteHelper.getDatabase(MobSDK.getContext(), "UserTag_1");
        b = object;
        String string2 = "text";
        boolean bl2 = true;
        ((SQLiteHelper$SingleTableDB)object).addField("time", string2, bl2);
        b.addField("data", string2, bl2);
        c = object = new Hashon();
        d = DeviceHelper.getInstance(MobSDK.getContext());
        object = new UserTager$1();
        a = MobHandlerThread.newHandler("t", (Handler.Callback)object);
        UserTager.c();
    }

    public UserTager() {
        HashMap hashMap;
        this.e = hashMap = new HashMap();
    }

    public static /* synthetic */ void a() {
        UserTager.c();
    }

    public static /* synthetic */ void a(UserTager userTager, String string2, Object object) {
        userTager.a(string2, object);
    }

    private void a(String string2, Object object) {
        this.e.put(string2, object);
    }

    public static /* synthetic */ void a(HashMap hashMap, UserTagError userTagError) {
        UserTager.b(hashMap, userTagError);
    }

    private static boolean a(ArrayList object) {
        boolean bl2;
        String string2;
        HashMap<String, Object> hashMap;
        try {
            hashMap = new HashMap<String, Object>();
            string2 = "plat";
            bl2 = true;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return false;
        }
        Object object2 = (int)(bl2 ? 1 : 0);
        hashMap.put(string2, object2);
        string2 = "mac";
        object2 = d;
        object2 = ((DeviceHelper)object2).getMacAddress();
        hashMap.put(string2, object2);
        string2 = "duid";
        object2 = null;
        object2 = DeviceAuthorizer.authorize(null);
        hashMap.put(string2, object2);
        string2 = "model";
        object2 = d;
        object2 = ((DeviceHelper)object2).getModel();
        hashMap.put(string2, object2);
        string2 = "imei";
        object2 = d;
        object2 = ((DeviceHelper)object2).getIMEI();
        hashMap.put(string2, object2);
        string2 = "serialno";
        object2 = d;
        object2 = ((DeviceHelper)object2).getSerialno();
        hashMap.put(string2, object2);
        string2 = "appkey";
        object2 = MobSDK.getAppkey();
        hashMap.put(string2, object2);
        string2 = "apppkg";
        object2 = d;
        object2 = ((DeviceHelper)object2).getPackageName();
        hashMap.put(string2, object2);
        string2 = "appver";
        object2 = d;
        object2 = ((DeviceHelper)object2).getAppVersionName();
        hashMap.put(string2, object2);
        string2 = "datas";
        hashMap.put(string2, object);
        object = "e3e28dce5fe8fc1bb56a25964219d5dc2976edb171b99b1103c2c4f89ad0b66fb58669fe69eb0b5d11e8be990b0715b4de2b4e5a5dcce121f47f18063d5d99f9";
        string2 = "256f461cc45979b52264ac022ff1353ea5f8140d35686ffdae2faee09db2006c3b43c2bb74ce6f4c51698db6384c1c0ceca958208d65c7ed345a04ea6349ca39601818c3d5500565ba49ed49c0f4014b06980d17fc069c95d30092d0cfdaddf783ea96c5f8bdc42b6765d71a5d12192ef74646b41d92f1caeba3123e71938d39";
        int n10 = 1024;
        object2 = new MobCommunicator(n10, (String)object, string2);
        object = "http://api.utag.mob.com/bdata";
        object = j.c((String)object);
        ((MobCommunicator)object2).requestSynchronized(hashMap, (String)object, false);
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(ArrayList object) {
        try {
            CharSequence charSequence = new StringBuilder();
            object = ((ArrayList)object).iterator();
            while (true) {
                String string2;
                Object object2;
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = b;
                    object2 = new StringBuilder();
                    string2 = "time in (";
                    ((StringBuilder)object2).append(string2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    ((StringBuilder)object2).append((String)charSequence);
                    charSequence = ")";
                    ((StringBuilder)object2).append((String)charSequence);
                    charSequence = ((StringBuilder)object2).toString();
                    bl2 = false;
                    object2 = null;
                    SQLiteHelper.delete((SQLiteHelper$SingleTableDB)object, (String)charSequence, null);
                    return;
                }
                object2 = object.next();
                object2 = (HashMap)object2;
                int n10 = ((StringBuilder)charSequence).length();
                if (n10 > 0) {
                    string2 = ", ";
                    ((StringBuilder)charSequence).append(string2);
                }
                n10 = 39;
                ((StringBuilder)charSequence).append((char)n10);
                String string3 = "___datetime";
                object2 = ((HashMap)object2).get(string3);
                ((StringBuilder)charSequence).append(object2);
                ((StringBuilder)charSequence).append((char)n10);
            }
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(HashMap object, UserTagError userTagError) {
        String string2;
        Map.Entry entry;
        Object object2;
        block8: {
            int n10;
            object2 = ((HashMap)object).entrySet().iterator();
            while ((n10 = object2.hasNext()) != 0) {
                entry = object2.next();
                string2 = (String)entry.getKey();
                if (string2 == null) {
                    entry = "found a key of null";
                    object2 = new IllegalArgumentException((String)((Object)entry));
                    break block8;
                } else {
                    int n11 = string2.length();
                    String string3 = " > ";
                    String string4 = "' is too long: ";
                    int n12 = 30;
                    if (n11 > n12) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("key '");
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(string4);
                        n10 = string2.length();
                        ((StringBuilder)object2).append(n10);
                        ((StringBuilder)object2).append(string3);
                        ((StringBuilder)object2).append(n12);
                        object2 = ((StringBuilder)object2).toString();
                        entry = new IllegalArgumentException((String)object2);
                    } else {
                        int n13;
                        if ((entry = entry.getValue()) == null || (n13 = entry instanceof String) == 0 || (n13 = ((String)((Object)(entry = (String)((Object)entry)))).length()) <= (n11 = 255)) continue;
                        object2 = new StringBuilder();
                        string2 = "value '";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append((String)((Object)entry));
                        ((StringBuilder)object2).append(string4);
                        n10 = ((String)((Object)entry)).length();
                        ((StringBuilder)object2).append(n10);
                        ((StringBuilder)object2).append(string3);
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        entry = new IllegalArgumentException((String)object2);
                    }
                    object2 = entry;
                }
                break block8;
            }
            object2 = null;
        }
        if (object2 != null) {
            if (userTagError == null) return;
            userTagError.onError((Throwable)object2);
            return;
        }
        try {
            long l10 = com.mob.commons.b.a();
            string2 = "___datetime";
            Object object3 = l10;
            ((HashMap)object).put(string2, object3);
            string2 = new ContentValues();
            object3 = "time";
            object2 = String.valueOf(l10);
            string2.put((String)object3, (String)object2);
            object2 = "data";
            entry = c;
            object = ((Hashon)((Object)entry)).fromHashMap((HashMap)object);
            string2.put((String)object2, (String)object);
            object = b;
            SQLiteHelper.insert((SQLiteHelper$SingleTableDB)object, (ContentValues)string2);
            return;
        }
        catch (Throwable throwable) {
            if (userTagError == null) return;
            userTagError.onError(throwable);
        }
    }

    public static /* synthetic */ boolean b() {
        return UserTager.d();
    }

    private static void c() {
        String string2;
        boolean bl2;
        Object object = a;
        int n10 = 1;
        object.removeMessages(n10);
        object = d.getNetworkType();
        long l10 = object != null && !(bl2 = (string2 = "none").equals(object)) ? 10000L : 600000L;
        a.sendEmptyMessageDelayed(n10, l10);
    }

    private static boolean d() {
        String string2;
        int n10;
        Object object = d.getNetworkType();
        int n11 = 0;
        if (object != null && (n10 = (string2 = "none").equals(object)) == 0) {
            int n12;
            n10 = com.mob.commons.b.I();
            if (n10 != 0) {
                return false;
            }
            object = UserTager.e();
            if (object != null && (n12 = ((ArrayList)object).size()) > 0) {
                n12 = (int)(UserTager.a((ArrayList)object) ? 1 : 0);
                if (n12 != 0) {
                    UserTager.b((ArrayList)object);
                    n10 = ((ArrayList)object).size();
                    n11 = 50;
                    if (n10 == n11) {
                        UserTager.d();
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static ArrayList e() {
        String string2;
        int n10;
        Object object;
        ArrayList<Object> arrayList;
        String[] stringArray;
        block15: {
            block14: {
                stringArray = "data";
                stringArray = new String[]{stringArray};
                arrayList = b;
                stringArray = SQLiteHelper.query((SQLiteHelper$SingleTableDB)((Object)arrayList), stringArray, null, null, null);
                if (stringArray != null) break block14;
                return null;
            }
            boolean bl2 = stringArray.moveToFirst();
            if (bl2) break block15;
            stringArray.close();
            return null;
        }
        try {
            arrayList = new ArrayList<Object>();
            while (true) {
                object = c;
                n10 = 0;
                string2 = null;
                break;
            }
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
        {
            string2 = stringArray.getString(0);
            object = ((Hashon)object).fromJson(string2);
            arrayList.add(object);
            int n11 = arrayList.size();
            n10 = 50;
            if (n11 > n10) break;
            if ((n11 = (int)(stringArray.moveToNext() ? 1 : 0)) != 0) continue;
        }
        stringArray.close();
        return arrayList;
    }

    public void commit() {
        int n10;
        Object object = new HashMap();
        HashMap hashMap = this.e;
        ((HashMap)object).putAll(hashMap);
        hashMap = new Message();
        ((Message)hashMap).what = n10 = 2;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[1] = object = this.f;
        ((Message)hashMap).obj = objectArray;
        a.sendMessage((Message)hashMap);
    }

    public UserTager$CustomTag set(String string2) {
        UserTager$CustomTag userTager$CustomTag = new UserTager$CustomTag(this, this, string2, null);
        return userTager$CustomTag;
    }

    public UserTager whenError(UserTagError userTagError) {
        this.f = userTagError;
        return this;
    }
}

