/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 */
package j.a.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;

public class g {
    private static final String g = "positiveButton";
    private static final String h = "negativeButton";
    private static final String i = "rationaleMsg";
    private static final String j = "theme";
    private static final String k = "requestCode";
    private static final String l = "permissions";
    public String a;
    public String b;
    public int c;
    public int d;
    public String e;
    public String[] f;

    public g(Bundle stringArray) {
        int n10;
        String string2;
        this.a = string2 = stringArray.getString(g);
        this.b = string2 = stringArray.getString(h);
        this.e = string2 = stringArray.getString(i);
        this.c = n10 = stringArray.getInt(j);
        this.d = n10 = stringArray.getInt(k);
        stringArray = stringArray.getStringArray(l);
        this.f = stringArray;
    }

    public g(String string2, String string3, String string4, int n10, int n11, String[] stringArray) {
        this.a = string2;
        this.b = string3;
        this.e = string4;
        this.c = n10;
        this.d = n11;
        this.f = stringArray;
    }

    public android.app.AlertDialog a(Context context, DialogInterface.OnClickListener object) {
        Object object2;
        int n10 = this.c;
        if (n10 > 0) {
            int n11 = this.c;
            object2 = new AlertDialog.Builder(context, n11);
        } else {
            object2 = new AlertDialog.Builder(context);
        }
        context = object2.setCancelable(false);
        object2 = this.a;
        context = context.setPositiveButton((CharSequence)object2, object);
        object2 = this.b;
        context = context.setNegativeButton((CharSequence)object2, object);
        object = this.e;
        return context.setMessage((CharSequence)object).create();
    }

    public AlertDialog b(Context object, DialogInterface.OnClickListener object2) {
        int n10 = this.c;
        AlertDialog$Builder alertDialog$Builder = n10 > 0 ? new AlertDialog$Builder((Context)object, n10) : new AlertDialog$Builder((Context)object);
        object = alertDialog$Builder.setCancelable(false);
        String string2 = this.a;
        object = ((AlertDialog$Builder)object).setPositiveButton(string2, (DialogInterface.OnClickListener)object2);
        string2 = this.b;
        object = ((AlertDialog$Builder)object).setNegativeButton(string2, (DialogInterface.OnClickListener)object2);
        object2 = this.e;
        return ((AlertDialog$Builder)object).setMessage((CharSequence)object2).create();
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        String[] stringArray = this.a;
        bundle.putString(g, (String)stringArray);
        stringArray = this.b;
        bundle.putString(h, (String)stringArray);
        stringArray = this.e;
        bundle.putString(i, (String)stringArray);
        int n10 = this.c;
        bundle.putInt(j, n10);
        n10 = this.d;
        bundle.putInt(k, n10);
        stringArray = this.f;
        bundle.putStringArray(l, stringArray);
        return bundle;
    }
}

