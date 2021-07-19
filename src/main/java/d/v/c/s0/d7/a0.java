/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package d.v.c.s0.d7;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import d.v.e.f;

public class a0 {
    private static final String b = "SP_SAVE_LIVE";
    public static final String c = "SP_LIVE_LOGIN_WEB";
    private static volatile a0 d;
    private SharedPreferences a;

    private a0(Context context, String string2) {
        context = context.getSharedPreferences(string2, 0);
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a0 e() {
        Object object = d;
        if (object != null) return d;
        object = a0.class;
        synchronized (object) {
            a0 a02 = d;
            if (a02 != null) return d;
            f f10 = f.a();
            f10 = f10.b();
            String string2 = b;
            d = a02 = new a0((Context)f10, string2);
            return d;
        }
    }

    public void a() {
        SharedPreferences.Editor editor = this.a.edit();
        editor.clear();
        editor.apply();
    }

    public void b(String string2) {
        SharedPreferences.Editor editor = this.a.edit();
        editor.remove(string2);
        editor.apply();
    }

    public boolean c(String string2, Boolean bl2) {
        SharedPreferences sharedPreferences = this.a;
        boolean bl3 = bl2;
        return sharedPreferences.getBoolean(string2, bl3);
    }

    public AccountManager$AuthData d(String object, AccountManager$AuthData object2) {
        block9: {
            Object object3 = "";
            Gson gson = new Gson();
            SharedPreferences sharedPreferences = this.a;
            object = sharedPreferences.getString((String)object, (String)object3);
            boolean n10 = ((String)object).equals(object3);
            if (n10) break block9;
            int n11 = ((String)object).length();
            if (n11 <= 0) break block9;
            object3 = object2.getClass();
            object = gson.fromJson((String)object, (Class)object3);
            try {
                object2 = object = (AccountManager$AuthData)object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return object2;
    }

    public void f(String string2, Boolean bl2) {
        SharedPreferences.Editor editor = this.a.edit();
        boolean bl3 = bl2;
        editor.putBoolean(string2, bl3);
        editor.apply();
    }

    public void g(String string2, AccountManager$AuthData object) {
        SharedPreferences.Editor editor = this.a.edit();
        Gson gson = new Gson();
        object = gson.toJson(object);
        try {
            editor.putString(string2, (String)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        editor.apply();
    }
}

