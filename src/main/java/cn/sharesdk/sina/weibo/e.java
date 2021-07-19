/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package cn.sharesdk.sina.weibo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.d;
import com.mob.tools.FakeActivity;
import java.lang.reflect.Method;

public class e
extends cn.sharesdk.framework.authorize.e
implements ServiceConnection {
    private String d;
    private String e;
    private String[] f;

    public e(d d10) {
        super(d10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(String object, String string2) {
        boolean bl2;
        Intent intent = new Intent();
        intent.setClassName((String)object, string2);
        object = this.d;
        intent.putExtra("appKey", (String)object);
        object = this.e;
        string2 = "redirectUri";
        intent.putExtra(string2, (String)object);
        object = this.f;
        if (object != null && (bl2 = ((Object)object).length) > false) {
            object = TextUtils.join((CharSequence)",", (Object[])object);
            string2 = "scope";
            intent.putExtra(string2, (String)object);
        }
        boolean bl3 = this.b(intent);
        bl2 = false;
        string2 = null;
        if (!bl3) {
            return false;
        }
        try {
            object = this.a;
            int n10 = this.b;
            ((FakeActivity)object).startActivityForResult(intent, n10);
            bl2 = true;
        }
        catch (Throwable throwable) {}
        this.a.getContext().getApplicationContext().unbindService((ServiceConnection)this);
        return bl2;
    }

    private boolean b(Intent resolveInfo) {
        Object object = this.a.getContext().getPackageManager();
        resolveInfo = object.resolveActivity((Intent)resolveInfo, 0);
        if (resolveInfo == null) {
            return false;
        }
        resolveInfo = resolveInfo.activityInfo.packageName;
        object = this.a;
        object = ((FakeActivity)object).getContext();
        object = object.getPackageManager();
        int n10 = 64;
        resolveInfo = object.getPackageInfo((String)resolveInfo, n10);
        resolveInfo = resolveInfo.signatures;
        int n11 = ((Signature[])resolveInfo).length;
        for (n10 = 0; n10 < n11; ++n10) {
            String string2;
            Object object2;
            try {
                object2 = resolveInfo[n10];
                string2 = "30820295308201fea00302010202044b4ef1bf300d06092a864886f70d010105050030818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c74643020170d3130303131343130323831355a180f32303630303130323130323831355a30818d310b300906035504061302434e3110300e060355040813074265694a696e673110300e060355040713074265694a696e67312c302a060355040a132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c7464312c302a060355040b132353696e612e436f6d20546563686e6f6c6f677920284368696e612920436f2e204c746430819f300d06092a864886f70d010101050003818d00308189028181009d367115bc206c86c237bb56c8e9033111889b5691f051b28d1aa8e42b66b7413657635b44786ea7e85d451a12a82a331fced99c48717922170b7fc9bc1040753c0d38b4cf2b22094b1df7c55705b0989441e75913a1a8bd2bc591aa729a1013c277c01c98cbec7da5ad7778b2fad62b85ac29ca28ced588638c98d6b7df5a130203010001300d06092a864886f70d0101050500038181000ad4b4c4dec800bd8fd2991adfd70676fce8ba9692ae50475f60ec468d1b758a665e961a3aedbece9fd4d7ce9295cd83f5f19dc441a065689d9820faedbb7c4a4c4635f5ba1293f6da4b72ed32fb8795f736a20c95cda776402099054fccefb4a1a558664ab8d637288feceba9508aa907fc1fe2b1ae5a0dec954ed831c0bea4";
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            object2 = object2.toCharsString();
            boolean bl2 = string2.equals(object2);
            if (!bl2) continue;
            return true;
            break;
        }
        return false;
    }

    private void c(Intent object) {
        Object object2 = this.c;
        if (object2 == null) {
            return;
        }
        object2 = object.getStringExtra("error");
        if (object2 == null) {
            object2 = object.getStringExtra("error_type");
        }
        if (object2 == null) {
            object2 = this.c;
            object = object.getExtras();
            object2.onComplete((Bundle)object);
            return;
        }
        Object object3 = "access_denied";
        boolean bl2 = ((String)object2).equals(object3);
        if (!bl2 && !(bl2 = ((String)object2).equals(object3 = "OAuthAccessDeniedException"))) {
            object3 = "error_description";
            if ((object = object.getStringExtra((String)object3)) != null) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(": ");
                ((StringBuilder)object3).append((String)object);
                object2 = ((StringBuilder)object3).toString();
            }
            object = this.c;
            object3 = new Throwable((String)object2);
            object.onFailed((Throwable)object3);
        } else {
            object = this.c;
            object.onCancel();
        }
    }

    private void d(Intent object) {
        if (object != null) {
            String string2 = object.getStringExtra("error");
            int n10 = -1;
            int n11 = object.getIntExtra("error_code", n10);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = " (";
            stringBuilder.append(string2);
            stringBuilder.append(n11);
            stringBuilder.append(")");
            object = stringBuilder.toString();
            Throwable throwable = new Throwable((String)object);
            object = this.c;
            if (object != null) {
                object.onFailed(throwable);
            }
        } else {
            object = this.c;
            if (object != null) {
                object.onCancel();
            }
        }
    }

    public void a() {
        boolean bl2;
        Object object = new Intent();
        Object object2 = "com.sina.weibo";
        String string2 = "com.sina.weibo.business.RemoteSSOService";
        object.setClassName((String)object2, string2);
        object2 = this.a;
        object2 = ((FakeActivity)object2).getContext();
        object2 = object2.getApplicationContext();
        int n10 = 1;
        try {
            bl2 = object2.bindService((Intent)object, (ServiceConnection)this, n10);
        }
        catch (Throwable throwable) {
            bl2 = false;
            object = null;
        }
        if (!bl2) {
            this.a.finish();
            object = this.c;
            if (object != null) {
                object2 = new Throwable();
                object.onFailed((Throwable)object2);
            }
        }
    }

    public void a(int n10, int n11, Intent intent) {
        d d10 = this.a;
        d10.finish();
        int n12 = this.b;
        if (n10 == n12) {
            n10 = -1;
            if (n11 != n10) {
                if (n11 == 0) {
                    this.d(intent);
                }
            } else {
                this.c(intent);
            }
        }
    }

    public void a(String string2, String string3, String[] stringArray) {
        this.d = string2;
        this.e = string3;
        this.f = stringArray;
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        block25: {
            object = "com.sina.sso.RemoteSSO$Stub";
            object = Class.forName((String)object);
            Object object3 = "asInterface";
            boolean bl2 = true;
            Object object4 = new Class[bl2];
            Object[] objectArray = IBinder.class;
            object4[0] = objectArray;
            object3 = ((Class)object).getMethod((String)object3, (Class<?>[])object4);
            ((Method)object3).setAccessible(bl2);
            object4 = null;
            objectArray = new Object[bl2];
            objectArray[0] = object2;
            object2 = ((Method)object3).invoke(null, objectArray);
            object3 = "getPackageName";
            object4 = new Class[]{};
            object3 = ((Class)object).getMethod((String)object3, (Class<?>[])object4);
            ((Method)object3).setAccessible(bl2);
            object4 = new Object[]{};
            object3 = ((Method)object3).invoke(object2, object4);
            object3 = String.valueOf(object3);
            object4 = "getActivityName";
            objectArray = new Class[]{};
            object = ((Class)object).getMethod((String)object4, (Class<?>[])objectArray);
            ((Method)object).setAccessible(bl2);
            Object[] objectArray2 = new Object[]{};
            object = ((Method)object).invoke(object2, objectArray2);
            object = String.valueOf(object);
            boolean bl3 = this.a((String)object3, (String)object);
            if (bl3) break block25;
            object = this.a;
            ((FakeActivity)object).finish();
            object = this.c;
            if (object == null) break block25;
            object2 = new Throwable();
            try {
                object.onFailed((Throwable)object2);
            }
            catch (Throwable throwable) {
                this.a.finish();
                object2 = this.c;
                if (object2 == null) break block25;
                object2.onFailed(throwable);
            }
        }
    }

    public void onServiceDisconnected(ComponentName object) {
        this.a.finish();
        object = this.c;
        if (object != null) {
            Throwable throwable = new Throwable();
            object.onFailed(throwable);
        }
    }
}

