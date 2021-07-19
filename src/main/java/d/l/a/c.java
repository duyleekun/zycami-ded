/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.l.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.kwai.auth.common.InternalResponse;
import d.l.a.b;
import d.l.a.f.b.a;
import java.util.ArrayList;
import java.util.Objects;

public final class c {
    private static final String c = "KwaiApi";
    private static Application d;
    private static c e;
    private static String f;
    private static String g;
    private static String h = "kwai_app";
    private b a;
    private boolean b;

    private c() {
    }

    private boolean a(Activity activity) {
        String string2;
        CharSequence charSequence = d.getPackageName();
        boolean bl2 = ((String)charSequence).equals(string2 = activity.getCallingPackage());
        if (!bl2) {
            charSequence = d.l.a.g.c.a(h);
            boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence);
            String string3 = c;
            if (!bl3 && !(bl2 = ((String)charSequence).equals(string2 = activity.getCallingPackage()))) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Package name is ");
                string2 = activity.getCallingPackage();
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.e((String)string3, (String)charSequence);
            }
            if (!(bl2 = d.l.a.g.c.d((Context)(charSequence = d), string2 = h))) {
                Log.e((String)string3, (String)"Signature wrong.");
                activity.finish();
                return false;
            }
        }
        return true;
    }

    private void b() {
        Object object = d;
        if (object != null) {
            return;
        }
        object = new IllegalStateException("Kwai API must be initialized first when launching the app.");
        throw object;
    }

    private String d(Context object, String string2) {
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        int n10 = 128;
        object = packageManager.getApplicationInfo((String)object, n10);
        object = object.metaData;
        try {
            object = object.getString(string2);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            object = null;
        }
        return object;
    }

    public static c f() {
        Object object = e;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("KwaiAuthAPI not init.");
        throw object;
    }

    public static void i(Application object) {
        d = object;
        object = new c();
        e = object;
    }

    private boolean k(a a10) {
        int n10;
        int n11 = a10.h();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public String c() {
        String string2 = f;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = d;
            String string3 = "KWAI_APP_ID";
            string2 = this.d((Context)string2, string3);
            int n10 = 7;
            string2 = string2.substring(n10);
            try {
                f = string2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            string2 = f;
            string3 = "KWAI_APP_ID meta-data cannot be null or empty";
            Objects.requireNonNull(string2, string3);
        }
        return f;
    }

    public String e() {
        String string2 = g;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = d;
            String string3 = "KWAI_SCOPE";
            string2 = this.d((Context)string2, string3);
            try {
                g = string2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            string2 = g;
            string3 = "KWAI_SCOPE meta-data cannot be null or empty";
            Objects.requireNonNull(string2, string3);
        }
        return g;
    }

    public b g() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean h(InternalResponse object, Activity object2) {
        Object object3 = c;
        Object object4 = this.a;
        int n10 = 0;
        if (object4 == null) {
            try {
                try {
                    object2.finish();
                    object = "handleResponse mLoginListener == null";
                    Log.e((String)object3, (String)object);
                    return false;
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    object4 = "handleResponse exception = ";
                    ((StringBuilder)object2).append((String)object4);
                    String string2 = exception.getMessage();
                    ((StringBuilder)object2).append(string2);
                    string2 = ((StringBuilder)object2).toString();
                    Log.e((String)object3, (String)string2);
                }
            }
            finally {
                return false;
            }
        }
        if (object == null) {
            object4.onFailed("handleResponse fail", 0, "handleResponse fail, response == null");
            return false;
        }
        int n11 = this.a((Activity)object2);
        if (n11 == 0) {
            object2 = this.a;
            object3 = ((InternalResponse)object).getState();
            int n12 = ((InternalResponse)object).getErrorCode();
            object = ((InternalResponse)object).getErrorMsg();
            object2.onFailed((String)object3, n12, (String)object);
            return false;
        }
        n11 = ((InternalResponse)object).isSuccess();
        if (n11 != 0) {
            object3 = this.a;
            object3.onSuccess((InternalResponse)object);
        } else {
            int n13;
            n11 = ((InternalResponse)object).getErrorCode();
            if (n11 == (n13 = -1)) {
                object = this.a;
                object.onCancel();
            } else {
                object3 = this.a;
                object4 = ((InternalResponse)object).getState();
                n10 = ((InternalResponse)object).getErrorCode();
                object = ((InternalResponse)object).getErrorMsg();
                object3.onFailed((String)object4, n10, (String)object);
            }
        }
        object2.finish();
        return true;
    }

    public boolean j() {
        return this.b;
    }

    public boolean l(Activity object, a object2, b object3) {
        boolean bl2;
        if (object2 == null) {
            return false;
        }
        this.a = object3;
        object3 = c;
        if (object != null && !(bl2 = object.isFinishing())) {
            boolean bl3;
            bl2 = this.k((a)object2);
            if (bl2) {
                Object object4 = d;
                String[] stringArray = ((a)object2).i();
                boolean bl4 = ((ArrayList)(object4 = d.l.a.g.c.f((Context)object4, stringArray))).isEmpty();
                if (bl4) {
                    Log.e((String)object3, (String)"Please install latest kwai app");
                    object = this.a;
                    object2 = ((a)object2).j();
                    object.onFailed((String)object2, -1005, "CODE_CANCEL_NO_APP");
                    return false;
                }
                stringArray = d;
                bl4 = ((ArrayList)(object4 = d.l.a.g.c.e((Context)stringArray, (ArrayList)object4))).isEmpty();
                if (bl4) {
                    Log.e((String)object3, (String)"Please install latest kwai app that support kwai api");
                    object = this.a;
                    object2 = ((a)object2).j();
                    object.onFailed((String)object2, -1006, "CODE_CANCEL_APP_UNSUPPORT");
                    return false;
                }
                h = object3 = (String)((ArrayList)object4).get(0);
            }
            if (bl3 = ((a)object2).g(this, (Activity)object, (String)(object3 = h))) {
                return true;
            }
            object = this.a;
            object2 = ((a)object2).j();
            object.onFailed((String)object2, -1008, "REQUEST_EXECUTE_FAIL");
            return false;
        }
        Log.e((String)object3, (String)"Please don't finish activity");
        object = this.a;
        object2 = ((a)object2).j();
        object.onFailed((String)object2, -1009, "CODE_FAIL_GHOST_ACTIVITY");
        return false;
    }

    public void m(boolean bl2) {
        this.b = bl2;
    }

    public boolean n() {
        this.b();
        return d.l.a.g.c.d((Context)d, "kwai_app");
    }
}

