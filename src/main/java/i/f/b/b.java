/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.util.Log
 */
package i.f.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import i.f.b.b$a;
import i.f.b.b$b;
import i.f.b.b$c;
import i.f.b.b$d;
import i.f.b.b$e;
import i.f.b.b$f;
import i.f.b.b$g;
import i.f.b.j;
import i.f.b.m;

public abstract class b
implements m {
    private static final String g = "OCV/BaseLoaderCallback";
    public Context f;

    public b(Context context) {
        this.f = context;
    }

    public void a(int n10, j object) {
        int n11 = -2;
        int n12 = -1;
        Object object2 = null;
        if (n10 != 0) {
            int n13 = 1;
            if (n10 == n13) {
                Object object3 = this.f;
                AlertDialog.Builder builder = new AlertDialog.Builder(object3);
                builder = builder.create();
                builder.setTitle((CharSequence)"OpenCV is not ready");
                builder.setMessage((CharSequence)"Installation is in progress. Wait or exit?");
                builder.setCancelable(false);
                object2 = new b$f(this, (j)object);
                object3 = "Wait";
                builder.setButton(n12, (CharSequence)object3, (DialogInterface.OnClickListener)object2);
                b$g b$g = new b$g(this, (j)object);
                object = "Exit";
                builder.setButton(n11, (CharSequence)object, (DialogInterface.OnClickListener)b$g);
                builder.show();
            }
        } else {
            Object object4 = this.f;
            AlertDialog.Builder builder = new AlertDialog.Builder((Context)object4);
            builder = builder.create();
            builder.setTitle((CharSequence)"Package not found");
            object4 = new StringBuilder();
            String string2 = object.getPackageName();
            ((StringBuilder)object4).append(string2);
            string2 = " package was not found! Try to install it?";
            ((StringBuilder)object4).append(string2);
            object4 = ((StringBuilder)object4).toString();
            builder.setMessage((CharSequence)object4);
            builder.setCancelable(false);
            object2 = new b$d(this, (j)object);
            object4 = "Yes";
            builder.setButton(n12, (CharSequence)object4, (DialogInterface.OnClickListener)object2);
            b$e b$e = new b$e(this, (j)object);
            object = "No";
            builder.setButton(n11, (CharSequence)object, (DialogInterface.OnClickListener)b$e);
            builder.show();
        }
    }

    public void b(int n10) {
        if (n10 != 0) {
            int n11 = 2;
            String string2 = "OpenCV Manager";
            String string3 = "OK";
            int n12 = -1;
            String string4 = g;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        Log.e((String)string4, (String)"OpenCV loading failed!");
                        Object object = this.f;
                        AlertDialog.Builder builder = new AlertDialog.Builder(object);
                        builder = builder.create();
                        builder.setTitle((CharSequence)"OpenCV error");
                        builder.setMessage((CharSequence)"OpenCV was not initialised correctly. Application will be shut down");
                        builder.setCancelable(false);
                        object = new b$c(this);
                        builder.setButton(n12, (CharSequence)string3, (DialogInterface.OnClickListener)object);
                        builder.show();
                    } else {
                        Log.d((String)string4, (String)"OpenCV Manager Service is uncompatible with this app!");
                        Object object = this.f;
                        AlertDialog.Builder builder = new AlertDialog.Builder(object);
                        builder = builder.create();
                        builder.setTitle((CharSequence)string2);
                        builder.setMessage((CharSequence)"OpenCV Manager service is incompatible with this app. Try to update it via Google Play.");
                        builder.setCancelable(false);
                        object = new b$b(this);
                        builder.setButton(n12, (CharSequence)string3, (DialogInterface.OnClickListener)object);
                        builder.show();
                    }
                } else {
                    String string5 = "OpenCV library installation was canceled by user";
                    Log.d((String)string4, (String)string5);
                    this.c();
                }
            } else {
                Object object = "Package installation failed!";
                Log.e((String)string4, (String)object);
                string4 = this.f;
                AlertDialog.Builder builder = new AlertDialog.Builder((Context)string4);
                builder = builder.create();
                builder.setTitle((CharSequence)string2);
                builder.setMessage((CharSequence)object);
                builder.setCancelable(false);
                object = new b$a(this);
                builder.setButton(n12, (CharSequence)string3, (DialogInterface.OnClickListener)object);
                builder.show();
            }
        }
    }

    public void c() {
        ((Activity)this.f).finish();
    }
}

