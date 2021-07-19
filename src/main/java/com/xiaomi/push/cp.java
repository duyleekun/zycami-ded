/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 */
package com.xiaomi.push;

import android.os.AsyncTask;
import com.xiaomi.push.cm;
import com.xiaomi.push.cq;
import com.xiaomi.push.ct;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cp
extends AsyncTask {
    public cm a;
    public ct a;
    public String a;
    public String b;

    public cp(ct ct2, String string2, String string3, cm cm2) {
        this.a = string2;
        this.b = string3;
        this.a = ct2;
        this.a = cm2;
    }

    public Integer a(String ... object) {
        object = this.a;
        String string2 = this.b;
        cm cm2 = this.a;
        return cq.a((String)object, string2, cm2);
    }

    public void a(Integer n10) {
        super.onPostExecute((Object)n10);
        ct ct2 = this.a;
        if (ct2 != null) {
            cm cm2 = this.a;
            ct2.a(n10, cm2);
        }
    }

    public /* synthetic */ Object doInBackground(Object[] objectArray) {
        objectArray = (String[])objectArray;
        return this.a((String[])objectArray);
    }

    public void onCancelled() {
        super.onCancelled();
        ct ct2 = this.a;
        if (ct2 != null) {
            int n10 = 1;
            Integer n11 = n10;
            cm cm2 = this.a;
            ct2.a(n11, cm2);
        }
    }

    public /* synthetic */ void onPostExecute(Object object) {
        object = (Integer)object;
        this.a((Integer)object);
    }
}

