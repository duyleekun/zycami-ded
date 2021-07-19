/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.t.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import d.t.a.b$a;
import d.t.a.c;
import d.t.a.d;

public class b {
    public static final int c = 69;
    public static final int d = 96;
    public static final int e = 10;
    private static final String f = "com.yalantis.ucrop";
    public static final String g = "com.yalantis.ucrop.InputUri";
    public static final String h = "com.yalantis.ucrop.OutputUri";
    public static final String i = "com.yalantis.ucrop.CropAspectRatio";
    public static final String j = "com.yalantis.ucrop.ImageWidth";
    public static final String k = "com.yalantis.ucrop.ImageHeight";
    public static final String l = "com.yalantis.ucrop.OffsetX";
    public static final String m = "com.yalantis.ucrop.OffsetY";
    public static final String n = "com.yalantis.ucrop.Error";
    public static final String o = "com.yalantis.ucrop.AspectRatioX";
    public static final String p = "com.yalantis.ucrop.AspectRatioY";
    public static final String q = "com.yalantis.ucrop.MaxSizeX";
    public static final String r = "com.yalantis.ucrop.MaxSizeY";
    private Intent a;
    private Bundle b;

    private b(Uri uri, Uri uri2) {
        Intent intent;
        this.a = intent = new Intent();
        this.b = intent;
        intent.putParcelable(g, (Parcelable)uri);
        this.b.putParcelable(h, (Parcelable)uri2);
    }

    public static Throwable a(Intent intent) {
        return (Throwable)intent.getSerializableExtra(n);
    }

    public static Uri e(Intent intent) {
        return (Uri)intent.getParcelableExtra(h);
    }

    public static float f(Intent intent) {
        return intent.getFloatExtra(i, 0.0f);
    }

    public static int g(Intent intent) {
        return intent.getIntExtra(k, -1);
    }

    public static int h(Intent intent) {
        return intent.getIntExtra(j, -1);
    }

    public static b i(Uri uri, Uri uri2) {
        b b10 = new b(uri, uri2);
        return b10;
    }

    public d b() {
        return d.t.a.d.x(this.b);
    }

    public d c(Bundle bundle) {
        this.b = bundle;
        return this.b();
    }

    public Intent d(Context context) {
        this.a.setClass(context, c.class);
        context = this.a;
        Bundle bundle = this.b;
        context.putExtras(bundle);
        return this.a;
    }

    public void j(Activity activity) {
        this.k(activity, 69);
    }

    public void k(Activity activity, int n10) {
        Intent intent = this.d((Context)activity);
        activity.startActivityForResult(intent, n10);
    }

    public void l(Context context, Fragment fragment) {
        this.m(context, fragment, 69);
    }

    public void m(Context context, Fragment fragment, int n10) {
        context = this.d(context);
        fragment.startActivityForResult((Intent)context, n10);
    }

    public b n() {
        this.b.putFloat(o, 0.0f);
        this.b.putFloat(p, 0.0f);
        return this;
    }

    public b o(float f10, float f11) {
        this.b.putFloat(o, f10);
        this.b.putFloat(p, f11);
        return this;
    }

    public b p(int n10, int n11) {
        int n12 = 10;
        if (n10 < n12) {
            n10 = n12;
        }
        if (n11 < n12) {
            n11 = n12;
        }
        this.b.putInt(q, n10);
        this.b.putInt(r, n11);
        return this;
    }

    public b q(b$a b$a) {
        Bundle bundle = this.b;
        b$a = b$a.a();
        bundle.putAll((Bundle)b$a);
        return this;
    }
}

