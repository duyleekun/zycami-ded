/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package cn.sharesdk.facebook;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.d;
import cn.sharesdk.framework.authorize.e;
import com.mob.tools.FakeActivity;

public class f
extends e {
    private String d;
    private String[] e;

    public f(d d10) {
        super(d10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean b() {
        boolean bl2;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        Object object = this.d;
        String string2 = "client_id";
        intent.putExtra(string2, (String)object);
        object = this.e;
        if (object != null && (bl2 = ((String[])object).length) > false) {
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
        }
        catch (Throwable throwable) {
            return bl2;
        }
        int n10 = this.b;
        ((FakeActivity)object).startActivityForResult(intent, n10);
        return true;
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
                string2 = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2";
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
        object2 = "error_message";
        CharSequence charSequence = object.getStringExtra((String)object2);
        String string2 = "error_code";
        if (charSequence == null) {
            charSequence = object.getStringExtra(string2);
        }
        if (charSequence == null) {
            object2 = this.c;
            object = object.getExtras();
            object2.onComplete((Bundle)object);
            return;
        }
        String string3 = "access_denied";
        boolean bl2 = ((String)charSequence).equals(string3);
        if (!bl2 && !(bl2 = ((String)charSequence).equals(string3 = "OAuthAccessDeniedException"))) {
            if ((object2 = object.getStringExtra((String)object2)) != null) {
                charSequence = new StringBuilder();
                object = object.getStringExtra(string2);
                ((StringBuilder)charSequence).append((String)object);
                object = ": ";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append((String)object2);
                charSequence = ((StringBuilder)charSequence).toString();
            }
            object = this.c;
            object2 = new Throwable((String)charSequence);
            object.onFailed((Throwable)object2);
        } else {
            object = this.c;
            object.onCancel();
        }
    }

    private void d(Intent object) {
        Object object2 = this.c;
        if (object2 == null) {
            return;
        }
        if (object != null) {
            object2 = object.getStringExtra("error");
            object = object.getStringExtra("error_code");
            Object object3 = "access_denied";
            boolean bl2 = ((String)object2).equals(object3);
            if (bl2 && (bl2 = ((String)object).equals(object3 = "200"))) {
                object = this.c;
                object.onCancel();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                object2 = " (";
                stringBuilder.append((String)object2);
                stringBuilder.append((String)object);
                stringBuilder.append(")");
                object = stringBuilder.toString();
                object3 = new Throwable((String)object);
                object = this.c;
                object.onFailed((Throwable)object3);
            }
        } else {
            object2.onCancel();
        }
    }

    public void a() {
        boolean bl2 = this.b();
        if (!bl2) {
            this.a.finish();
            SSOListener sSOListener = this.c;
            if (sSOListener != null) {
                Throwable throwable = new Throwable();
                sSOListener.onFailed(throwable);
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

    public void a(String string2, String[] stringArray) {
        this.d = string2;
        this.e = stringArray;
    }
}

