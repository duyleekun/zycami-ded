/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  org.json.JSONObject
 */
package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;

public class a
implements LBSAuthManagerListener {
    private static Object a;
    private static a b;
    private int c = 0;
    private Context d = null;
    private long e = 0L;
    private String f = null;

    static {
        Object object;
        a = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        Object object = a;
        synchronized (object) {
            a a10 = b;
            if (a10 != null) return b;
            b = a10 = new a();
            return b;
        }
    }

    public static String b(Context object) {
        LBSAuthManager lBSAuthManager = LBSAuthManager.getInstance(object);
        try {
            object = lBSAuthManager.getPublicKey((Context)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = null;
        }
        return object;
    }

    public static String c(Context object) {
        object = LBSAuthManager.getInstance((Context)object);
        try {
            object = ((LBSAuthManager)object).getMCode();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = null;
        }
        return object;
    }

    public void a(Context context) {
        long l10;
        this.d = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
        this.e = l10 = System.currentTimeMillis();
    }

    public boolean b() {
        int n10;
        int n11 = this.c;
        n11 = n11 != 0 && n11 != (n10 = 602) && n11 != (n10 = 601) && n11 != (n10 = -10) && n11 != (n10 = -11) ? 0 : 1;
        Object object = this.d;
        if (object != null) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            long l15;
            long l16 = System.currentTimeMillis();
            long l17 = this.e;
            l16 -= l17;
            String string2 = "lbs_locsdk";
            if (n11 != 0 ? (n10 = (int)((l15 = l16 - (l14 = 86400000L)) == 0L ? 0 : (l15 < 0L ? -1 : 1))) > 0 : (l13 = (l12 = l16 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0 || (n10 = (int)((l10 = l16 - (l11 = 10000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
                long l18;
                object = LBSAuthManager.getInstance(this.d);
                ((LBSAuthManager)object).authenticate(false, string2, null, this);
                this.e = l18 = System.currentTimeMillis();
            }
        }
        return n11 != 0;
    }

    public void onAuthResult(int n10, String string2) {
        block9: {
            String string3;
            String string4 = "token";
            this.c = n10;
            if (n10 == 0) {
                string3 = com.baidu.location.h.a.a;
                String string5 = "LocationAuthManager Authentication AUTHENTICATE_SUCC";
                Log.i((String)string3, (String)string5);
            } else {
                String string6 = com.baidu.location.h.a.a;
                StringBuilder stringBuilder = new StringBuilder();
                String string7 = "LocationAuthManager Authentication Error errorcode = ";
                stringBuilder.append(string7);
                stringBuilder.append(n10);
                stringBuilder.append(" , msg = ");
                stringBuilder.append(string2);
                string3 = stringBuilder.toString();
                Log.i((String)string6, (String)string3);
            }
            if (string2 != null) {
                string3 = new JSONObject(string2);
                string2 = string3.getString(string4);
                if (string2 == null) break block9;
                string3 = string3.getString(string4);
                try {
                    this.f = string3;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}

