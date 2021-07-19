/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ProviderInfo
 *  android.content.pm.ResolveInfo
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 */
package d.r.a.s;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import d.r.a.q;
import d.r.a.s.e$a;
import d.r.a.u.c;
import d.r.a.u.s;
import d.r.a.u.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class e
extends q {
    private static e f;
    private static final List g;
    private Handler d;
    public String e;

    static {
        Integer n10 = 3;
        Integer[] integerArray = new Integer[]{n10};
        g = Arrays.asList(integerArray);
    }

    private e() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.d = handler = new Handler(looper);
    }

    public static e d() {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            e e10 = f;
            if (e10 == null) {
                f = e10 = new e();
            }
            e10 = f;
            return e10;
        }
    }

    private static String e(Context object, String charSequence, String string2) {
        Object object2;
        block10: {
            boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
            object2 = null;
            if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
                Intent intent = new Intent(string2);
                intent.setPackage((String)charSequence);
                object = object.getPackageManager();
                if (object == null) {
                    return null;
                }
                int n10 = 64;
                object = object.queryBroadcastReceivers(intent, n10);
                if (object == null) break block10;
                n10 = object.size();
                if (n10 <= 0) break block10;
                n10 = 0;
                charSequence = null;
                object = object.get(0);
                object = (ResolveInfo)object;
                object = object.activityInfo;
                try {
                    object2 = object = object.name;
                }
                catch (Exception exception) {
                    string2 = "error  ";
                    charSequence = new StringBuilder(string2);
                    String string3 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string3);
                    string3 = ((StringBuilder)charSequence).toString();
                    charSequence = "CommandWorker";
                    s.a((String)charSequence, string3);
                }
            }
        }
        return object2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void c(Message object) {
        CharSequence charSequence;
        Intent intent = (Intent)object.obj;
        String string2 = "CommandWorker";
        if (intent != null && (charSequence = this.b) != null) {
            Object[] objectArray;
            int n10;
            Object object2;
            int n11;
            Object object3;
            block65: {
                block61: {
                    void var7_22;
                    block63: {
                        void var8_25;
                        block64: {
                            block62: {
                                int n12;
                                block60: {
                                    charSequence = charSequence.getPackageName();
                                    object3 = "command_type";
                                    object3 = intent.getStringExtra((String)object3);
                                    n11 = TextUtils.isEmpty((CharSequence)object3);
                                    if (n11 != 0) return;
                                    object2 = "reflect_receiver";
                                    boolean bl2 = ((String)object3).equals(object2);
                                    if (!bl2) return;
                                    object3 = "command";
                                    n11 = -1;
                                    int n13 = intent.getIntExtra((String)object3, n11);
                                    if (n13 >= 0) break block60;
                                    object3 = "method";
                                    n12 = intent.getIntExtra((String)object3, n11);
                                }
                                object2 = g;
                                object3 = n12;
                                boolean bl3 = object2.contains(object3);
                                if (!bl3) break block61;
                                object3 = this.b;
                                object2 = "com.vivo.pushclient.action.RECEIVE";
                                boolean bl4 = w.d((Context)object3, (String)charSequence, (String)object2);
                                if (!bl4) break block61;
                                object3 = this.b;
                                object2 = w.a;
                                if (object2 == null) break block62;
                                boolean bl5 = (Boolean)object2;
                                break block63;
                            }
                            object2 = "com.vivo.push.sdk.service.SystemPushConfig";
                            Object var8_23 = null;
                            if (object3 != null) {
                                n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                                if (n10 != 0) break block64;
                                objectArray = object3.getPackageManager();
                                int n14 = 128;
                                object2 = objectArray.resolveContentProvider((String)object2, n14);
                                if (object2 == null) break block64;
                                String string3 = ((ProviderInfo)object2).packageName;
                            }
                        }
                        object2 = "BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02";
                        object3 = w.f((Context)object3, (String)var8_25);
                        boolean bl6 = ((String)object2).equals(object3);
                        object3 = bl6;
                        w.a = object3;
                        boolean bl7 = (Boolean)object3;
                    }
                    if (var7_22 == false) {
                        return;
                    }
                }
                object3 = intent.getAction();
                object2 = this.e;
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n11 == 0) break block65;
                object2 = this.b;
                object2 = d.r.a.s.e.e((Context)object2, (String)charSequence, (String)object3);
                this.e = object2;
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n11 == 0) break block65;
                String string4 = " reflectReceiver error: receiver for: ";
                object2 = new StringBuilder(string4);
                ((StringBuilder)object2).append((String)object3);
                object3 = " not found, package: ";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append((String)charSequence);
                object3 = ((StringBuilder)object2).toString();
                s.m(string2, (String)object3);
                intent.setPackage((String)charSequence);
                object3 = this.b;
                try {
                    object3.sendBroadcast(intent);
                    return;
                }
                catch (Exception exception) {
                    s.c(string2, exception);
                }
            }
            try {
                object3 = this.e;
            }
            catch (Exception exception) {
                s.i(string2, "reflect e: ", exception);
                return;
            }
            object3 = Class.forName((String)object3);
            n11 = 0;
            object2 = null;
            Class[] classArray = new Class[]{};
            Constructor constructor = ((Class)object3).getConstructor(classArray);
            objectArray = new Object[]{};
            Object t10 = constructor.newInstance(objectArray);
            n10 = 2;
            Class[] classArray2 = new Class[n10];
            Object object4 = Context.class;
            classArray2[0] = object4;
            object4 = Intent.class;
            int n15 = 1;
            classArray2[n15] = object4;
            object4 = "onReceive";
            object3 = ((Class)object3).getMethod((String)object4, classArray2);
            String string5 = this.e;
            intent.setClassName((String)charSequence, string5);
            charSequence = new Object[n10];
            objectArray = this.b;
            objectArray = d.r.a.u.c.c((Context)objectArray);
            objectArray = objectArray.getApplicationContext();
            charSequence[0] = objectArray;
            charSequence[n15] = intent;
            Handler handler = this.d;
            object2 = new e$a(this, (Method)object3, t10, (Object[])charSequence);
            handler.post((Runnable)object2);
            return;
        }
        charSequence = new StringBuilder(" handleMessage error: intent : ");
        ((StringBuilder)charSequence).append(intent);
        ((StringBuilder)charSequence).append(", mContext: ");
        Context context = this.b;
        ((StringBuilder)charSequence).append(context);
        String string6 = ((StringBuilder)charSequence).toString();
        s.m(string2, string6);
    }

    public final void f(Intent object) {
        StringBuilder stringBuilder;
        if (object != null && (stringBuilder = this.b) != null) {
            stringBuilder = Message.obtain();
            ((Message)stringBuilder).obj = object;
            this.b((Message)stringBuilder);
            return;
        }
        stringBuilder = new StringBuilder(" sendMessage error: intent : ");
        stringBuilder.append(object);
        stringBuilder.append(", mContext: ");
        object = this.b;
        stringBuilder.append(object);
        object = stringBuilder.toString();
        s.m("CommandWorker", (String)object);
    }
}

