/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 */
package d.j.f.a.a.j.o;

import android.content.Context;
import android.os.AsyncTask;
import d.j.f.a.a.j.o.a;
import d.j.f.a.a.j.o.h;
import d.j.f.a.a.j.o.i;
import java.io.InputStream;

public class f
extends AsyncTask {
    private static final String a = f.class.getSimpleName();

    public Boolean a(Context ... object) {
        String string2;
        StringBuilder stringBuilder;
        long l10 = System.currentTimeMillis();
        String string3 = null;
        object = object[0];
        try {
            object = d.j.f.a.a.j.o.a.n(object);
        }
        catch (Exception exception) {
            string3 = a;
            stringBuilder = new StringBuilder();
            string2 = "doInBackground: exception : ";
            stringBuilder.append(string2);
            object = exception.getMessage();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            i.d(string3, (String)object);
            object = null;
        }
        string3 = a;
        stringBuilder = new StringBuilder();
        string2 = "doInBackground: get bks from hms tss cost : ";
        stringBuilder.append(string2);
        long l11 = System.currentTimeMillis() - l10;
        stringBuilder.append(l11);
        stringBuilder.append(" ms");
        String string4 = stringBuilder.toString();
        i.b(string3, string4);
        if (object != null) {
            h.g((InputStream)object);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void b(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = a;
            String string2 = "onPostExecute: upate done";
            i.e((String)object, string2);
        } else {
            object = a;
            String string3 = "onPostExecute: upate failed";
            i.d((String)object, string3);
        }
    }

    public void c(Integer ... integerArray) {
        i.e(a, "onProgressUpdate");
    }

    public void onPreExecute() {
        i.b(a, "onPreExecute");
    }
}

