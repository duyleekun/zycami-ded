/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package d.v.c.i1.t2.p0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import d.v.c.i1.t2.p0.h$a;
import d.v.c.i1.t2.p0.h$b;
import d.v.e.f;
import d.v.e.l.k2;
import d.v.e.l.s1;
import java.io.File;

public class h {
    private static volatile h e;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private h$a a;
    private final Uri b;
    private final Uri c;
    private h$b d;

    private h() {
        Context context = d.v.e.f.a().c();
        String string2 = k2.s("Avatar").getAbsolutePath();
        File file = new File(string2, "avatar.jpg");
        string2 = Uri.fromFile((File)file);
        this.c = string2;
        string2 = file.getPath();
        context = s1.n0(context, string2);
        this.b = context;
    }

    private void a(Activity activity, Uri uri, Uri uri2) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        int n10 = this.a.a;
        intent.putExtra("aspectX", n10);
        n10 = this.a.b;
        intent.putExtra("aspectY", n10);
        n10 = this.a.c;
        intent.putExtra("outputX", n10);
        n10 = this.a.d;
        intent.putExtra("outputY", n10);
        intent.putExtra("outputFormat", "JPEG");
        int n11 = 1;
        intent.putExtra("noFaceDetection", n11 != 0);
        intent.addFlags(2);
        intent.addFlags(n11);
        intent.putExtra("output", (Parcelable)uri2);
        intent.putExtra("return-data", false);
        activity.startActivityForResult(intent, 3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h b() {
        Object object = e;
        if (object != null) return e;
        object = h.class;
        synchronized (object) {
            h h10 = e;
            if (h10 != null) return e;
            e = h10 = new h();
            return e;
        }
    }

    public static boolean c(int n10) {
        int n11;
        int n12 = 1;
        if (n12 != n10 && (n11 = 2) != n10 && (n11 = 3) != n10) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private void f(Activity activity) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        activity.startActivityForResult(intent, 2);
    }

    private void h(Activity activity) {
        Intent intent = new Intent();
        intent.addFlags(2);
        int n10 = 1;
        intent.addFlags(n10);
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        Uri uri = this.b;
        intent.putExtra("output", (Parcelable)uri);
        activity.startActivityForResult(intent, n10);
    }

    public void d(Activity object, int n10, int n11, Intent intent) {
        int n12;
        if (object != null && n11 == (n12 = -1)) {
            n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    int n13 = 3;
                    if (n10 == n13 && (object = this.d) != null) {
                        if (intent != null && (n13 = (int)(TextUtils.isEmpty((CharSequence)(object = intent.getAction())) ? 1 : 0)) == 0) {
                            object = this.d;
                            Uri uri = Uri.parse((String)intent.getAction());
                            object.a(uri);
                        } else {
                            object = this.d;
                            Uri uri = this.c;
                            object.a(uri);
                        }
                    }
                } else {
                    Object object2 = intent.getData();
                    n11 = (int)(TextUtils.isEmpty((CharSequence)(object2 = s1.F((Context)object, object2))) ? 1 : 0);
                    if (n11 != 0) {
                        object = this.d;
                        if (object != null) {
                            object2 = this.c;
                            object.a((Uri)object2);
                        }
                    } else {
                        object2 = s1.n0((Context)object, (String)object2);
                        Uri uri = this.c;
                        this.a((Activity)object, (Uri)object2, uri);
                    }
                }
            } else {
                Uri uri = this.b;
                Uri uri2 = this.c;
                this.a((Activity)object, uri, uri2);
            }
        }
    }

    public void e(h$b h$b) {
        this.d = h$b;
    }

    public void g(Activity activity, h$a h$a) {
        this.a = h$a;
        this.f(activity);
    }

    public void i(Activity activity, h$a h$a) {
        this.a = h$a;
        this.h(activity);
    }
}

