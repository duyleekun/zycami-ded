/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 */
package cn.sharesdk.twitter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.twitter.a;
import com.mob.tools.FakeActivity;

public class d
extends e {
    private String d;
    private String e;
    private cn.sharesdk.framework.authorize.d f;

    public d(cn.sharesdk.framework.authorize.d d10) {
        super(d10);
        this.f = d10;
    }

    public static String a(PackageManager packageManager) {
        String string2 = "com.twitter.android";
        String string3 = "3082025d308201c6a00302010202044bd76cce300d06092a864886f70d01010505003073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e6420526563686973301e170d3130303432373233303133345a170d3438303832353233303133345a3073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e642052656368697330819f300d06092a864886f70d010101050003818d003081890281810086233c2e51c62232d49cc932e470713d63a6a1106b38f9e442e01bc79ca4f95c72b2cb3f1369ef7dea6036bff7c4b2828cb3787e7657ad83986751ced5b131fcc6f413efb7334e32ed9787f9e9a249ae108fa66009ac7a7932c25d37e1e07d4f9f66aa494c270dbac87d261c9668d321c2fba4ef2800e46671a597ff2eac5d7f0203010001300d06092a864886f70d0101050500038181003e1f01cb6ea8be8d2cecef5cd2a64c97ba8728aa5f08f8275d00508d64d139b6a72c5716b40a040df0eeeda04de9361107e123ee8d3dc05e70c8a355f46dbadf1235443b0b214c57211afd4edd147451c443d49498d2a7ff27e45a99c39b9e47429a1dae843ba233bf8ca81296dbe1dc5c5434514d995b0279246809392a219b";
        boolean bl2 = cn.sharesdk.twitter.d.a(packageManager, string2, string3);
        if (bl2) {
            return string2;
        }
        string2 = "com.twitter.android.beta";
        string3 = "308203523082023aa00302010202044fd0006b300d06092a864886f70d0101050500306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c65301e170d3132303630373031313431395a170d3339313032343031313431395a306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c6530820122300d06092a864886f70d01010105000382010f003082010a028201010089e6cbdfed4288a9c0a215d33d4fa978a5bdd20be426ef4b497d358a9fd1c6efec9684f059f6955e60e5fda1b5910bb2d097e7421a78f9c81e95cd8ef3bf50add7f8d9f073c0478736a6c7fd38c5871559783a76420d37f3f874f2114ec02532e85587791d24037485b1b95ec8cbc75b52042867988b51c7c3589d5b5972fd20a2e8a7c9ced986873f5008a418b2921daa7cfb78afc174eecdb8a79dc0961bea9740d09c4656ac9b8c86263a788e35af1d4a3f86ce053a1aefb5369def91614a390219f896f378712376baa05934a341798950e229f4f735b86004952b259f23cc9fc3b8c1bc8171984884dc92940e91f2e9a78a84a78f0c2946b7e37bbf3b9b0203010001300d06092a864886f70d010105050003820101001cf15250365e66cc87bb5054de1661266cf87907841016b20dfa1f9f59842020cbc33f9b4d41717db0428d11696a0bade6a4950a48cc4fa8ae56c850647379a5c2d977436b644162c453dd36b7745ccb9ff0b5fc070125024de73dab6dcda5c69372e978a49865f569927199ed0f61d7cbee1839079a7da2e83f8c90f7421a8c81b3f17f1cc05d52aedac9acd6e092ffd9ad572960e779a5b91a78e1aeb2b3c7b24464bd223c745e40abd74fc586310809520d183443fcca3c6ade3be458afedbd3325df9c0e552636e35bb55b240eb8c0ba3973c4fb81213f22363be2d70e85014650c2f4fc679747a7ec31ea7b08da7dd9b9ba279a7fbbc1bd440fbe831bf4";
        boolean bl3 = cn.sharesdk.twitter.d.a(packageManager, string2, string3);
        if (bl3) {
            return string2;
        }
        return null;
    }

    private static boolean a(Context context) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3 = cn.sharesdk.twitter.d.a((PackageManager)(context = context.getPackageManager()), string3 = "com.twitter.android", string2 = "3082025d308201c6a00302010202044bd76cce300d06092a864886f70d01010505003073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e6420526563686973301e170d3130303432373233303133345a170d3438303832353233303133345a3073310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f31163014060355040a130d547769747465722c20496e632e310f300d060355040b13064d6f62696c65311630140603550403130d4c656c616e642052656368697330819f300d06092a864886f70d010101050003818d003081890281810086233c2e51c62232d49cc932e470713d63a6a1106b38f9e442e01bc79ca4f95c72b2cb3f1369ef7dea6036bff7c4b2828cb3787e7657ad83986751ced5b131fcc6f413efb7334e32ed9787f9e9a249ae108fa66009ac7a7932c25d37e1e07d4f9f66aa494c270dbac87d261c9668d321c2fba4ef2800e46671a597ff2eac5d7f0203010001300d06092a864886f70d0101050500038181003e1f01cb6ea8be8d2cecef5cd2a64c97ba8728aa5f08f8275d00508d64d139b6a72c5716b40a040df0eeeda04de9361107e123ee8d3dc05e70c8a355f46dbadf1235443b0b214c57211afd4edd147451c443d49498d2a7ff27e45a99c39b9e47429a1dae843ba233bf8ca81296dbe1dc5c5434514d995b0279246809392a219b");
        if (!bl3 && !(bl2 = cn.sharesdk.twitter.d.a((PackageManager)context, string3 = "com.twitter.android.beta", string2 = "308203523082023aa00302010202044fd0006b300d06092a864886f70d0101050500306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c65301e170d3132303630373031313431395a170d3339313032343031313431395a306b310b3009060355040613025553310b3009060355040813024341311630140603550407130d53616e204672616e636973636f3110300e060355040a130754776974746572310f300d060355040b13064d6f62696c65311430120603550403130b4a6f6e617468616e204c6530820122300d06092a864886f70d01010105000382010f003082010a028201010089e6cbdfed4288a9c0a215d33d4fa978a5bdd20be426ef4b497d358a9fd1c6efec9684f059f6955e60e5fda1b5910bb2d097e7421a78f9c81e95cd8ef3bf50add7f8d9f073c0478736a6c7fd38c5871559783a76420d37f3f874f2114ec02532e85587791d24037485b1b95ec8cbc75b52042867988b51c7c3589d5b5972fd20a2e8a7c9ced986873f5008a418b2921daa7cfb78afc174eecdb8a79dc0961bea9740d09c4656ac9b8c86263a788e35af1d4a3f86ce053a1aefb5369def91614a390219f896f378712376baa05934a341798950e229f4f735b86004952b259f23cc9fc3b8c1bc8171984884dc92940e91f2e9a78a84a78f0c2946b7e37bbf3b9b0203010001300d06092a864886f70d010105050003820101001cf15250365e66cc87bb5054de1661266cf87907841016b20dfa1f9f59842020cbc33f9b4d41717db0428d11696a0bade6a4950a48cc4fa8ae56c850647379a5c2d977436b644162c453dd36b7745ccb9ff0b5fc070125024de73dab6dcda5c69372e978a49865f569927199ed0f61d7cbee1839079a7da2e83f8c90f7421a8c81b3f17f1cc05d52aedac9acd6e092ffd9ad572960e779a5b91a78e1aeb2b3c7b24464bd223c745e40abd74fc586310809520d183443fcca3c6ade3be458afedbd3325df9c0e552636e35bb55b240eb8c0ba3973c4fb81213f22363be2d70e85014650c2f4fc679747a7ec31ea7b08da7dd9b9ba279a7fbbc1bd440fbe831bf4"))) {
            bl2 = false;
            context = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean a(PackageManager signatureArray, String string2, String string3) {
        int n10 = 64;
        try {
            signatureArray = signatureArray.getPackageInfo((String)string2, (int)n10).signatures;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
        int n11 = signatureArray.length;
        for (n10 = 0; n10 < n11; ++n10) {
            String string4 = signatureArray[n10].toCharsString();
            boolean bl2 = string3.equals(string4);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    private void b() {
        Object object = this.f;
        object = ((FakeActivity)object).getContext();
        object = object.getPackageManager();
        object = cn.sharesdk.twitter.d.a((PackageManager)object);
        String string2 = "com.twitter.android.SingleSignOnActivity";
        Object object2 = new ComponentName((String)object, string2);
        object = new Intent();
        object = object.setComponent((ComponentName)object2);
        object2 = this.f;
        object2 = ((FakeActivity)object2).getContext();
        cn.sharesdk.twitter.a.a((Context)object2, (Intent)object);
        object2 = "ck";
        string2 = this.d;
        object2 = object.putExtra((String)object2, string2);
        string2 = "cs";
        String string3 = this.e;
        object2.putExtra(string2, string3);
        object2 = this.f;
        int n10 = 140;
        try {
            ((FakeActivity)object2).startActivityForResult((Intent)object, n10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b(Intent object) {
        Object object2 = this.c;
        if (object2 == null) {
            return;
        }
        object2 = object.getStringExtra("error");
        if (object2 == null) {
            object2 = this.c;
            object = object.getExtras();
            object2.onComplete((Bundle)object);
            return;
        }
        Object object3 = "access_denied";
        boolean bl2 = ((String)object2).equals(object3);
        if (bl2) {
            object = this.c;
            if (object != null) {
                object.onCancel();
            }
        } else {
            object3 = "error_description";
            if ((object = object.getStringExtra((String)object3)) != null) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(": ");
                ((StringBuilder)object3).append((String)object);
                object2 = ((StringBuilder)object3).toString();
            }
            if ((object = this.c) != null) {
                object3 = new Throwable((String)object2);
                object.onFailed((Throwable)object3);
            }
        }
    }

    private void c(Intent object) {
        Object object2 = this.c;
        if (object2 == null) {
            return;
        }
        if (object != null) {
            object2 = object.getStringExtra("error");
            int n10 = -1;
            int n11 = object.getIntExtra("error_code", n10);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            object2 = " (";
            stringBuilder.append((String)object2);
            stringBuilder.append(n11);
            stringBuilder.append(")");
            object = stringBuilder.toString();
            Throwable throwable = new Throwable((String)object);
            object = this.c;
            if (object != null) {
                object.onFailed(throwable);
            }
        } else {
            try {
                object2.onCancel();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        try {
            Object object = this.f;
            object = ((FakeActivity)object).getContext();
            boolean bl2 = cn.sharesdk.twitter.d.a((Context)object);
            if (bl2) {
                this.b();
                return;
            }
            object = this.f;
            ((FakeActivity)object).finish();
            object = this.c;
            if (object == null) return;
            String string2 = " You may not have installed Twitter client ";
            Throwable throwable = new Throwable(string2);
            object.onFailed(throwable);
            return;
        }
        catch (Throwable throwable) {
            this.f.finish();
            SSOListener sSOListener = this.c;
            if (sSOListener == null) return;
            sSOListener.onFailed(throwable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, int n11, Intent intent) {
        try {
            cn.sharesdk.framework.authorize.d d10 = this.f;
            d10.finish();
            int n12 = 140;
            if (n10 != n12) return;
            n10 = -1;
            if (n11 != n10) {
                if (n11 != 0) {
                    return;
                }
                cn.sharesdk.framework.authorize.d d11 = this.f;
                if (d11 != null) {
                    d11.finish();
                }
                this.c(intent);
                return;
            }
            cn.sharesdk.framework.authorize.d d12 = this.f;
            if (d12 != null) {
                d12.finish();
            }
            this.b(intent);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(String string2) {
        this.d = string2;
    }

    public void b(String string2) {
        this.e = string2;
    }
}

