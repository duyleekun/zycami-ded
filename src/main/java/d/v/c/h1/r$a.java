/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 */
package d.v.c.h1;

import android.os.AsyncTask;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import d.v.c.h1.r;
import d.v.c.h1.r$a$a;
import java.util.List;

public class r$a
extends AsyncTask {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;
    public final /* synthetic */ r d;

    public r$a(r r10, List list, List list2, int n10) {
        this.d = r10;
        this.a = list;
        this.b = list2;
        this.c = n10;
    }

    public DiffUtil$DiffResult a(Void ... object) {
        object = new r$a$a(this);
        return DiffUtil.calculateDiff((DiffUtil$Callback)object);
    }

    public void b(DiffUtil$DiffResult diffUtil$DiffResult) {
        int n10 = this.c;
        Object object = this.d;
        int n11 = r.a((r)object);
        if (n10 != n11) {
            return;
        }
        r r10 = this.d;
        r10.a = object = this.b;
        r10.e(diffUtil$DiffResult);
    }
}

