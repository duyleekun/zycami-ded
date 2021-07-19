/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.be;
import com.xiaomi.push.bz;
import com.xiaomi.push.cb;
import com.xiaomi.push.cd;
import com.xiaomi.push.v;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Random;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class cb$a
implements Runnable {
    private int a;
    public bz a;
    private cb$a a;
    private String a;
    private WeakReference a;
    private Random a = null;
    public String b;

    public cb$a(String string2) {
        Random random;
        this.a = random = new Random();
        this.a = 0;
        this.a = string2;
    }

    public SQLiteDatabase a() {
        return this.a.getWritableDatabase();
    }

    public Object a() {
        return null;
    }

    public String a() {
        return this.a;
    }

    public void a(Context context) {
        cb$a cb$a = this.a;
        if (cb$a != null) {
            Object object = this.a();
            cb$a.a(context, object);
        }
        this.b(context);
    }

    public abstract void a(Context var1, SQLiteDatabase var2);

    public void a(Context context, Object object) {
        cb.a(context).a(this);
    }

    public void a(bz object, Context context) {
        this.a = object;
        object = object.a();
        this.b = object;
        object = new WeakReference(context);
        this.a = object;
    }

    public void a(cb$a cb$a) {
        this.a = cb$a;
    }

    public boolean a() {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b))) && (object = this.a) != null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void b(Context context) {
    }

    public final void run() {
        boolean bl2;
        Object object;
        WeakReference weakReference = this.a;
        if (weakReference == null) {
            return;
        }
        if ((weakReference = (Context)weakReference.get()) != null && (object = weakReference.getFilesDir()) != null && (object = this.a) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.a)))) {
            Object object2 = this.a;
            object = new File((String)object2);
            File file = ((File)object).getParentFile();
            object = be.b(((File)object).getAbsolutePath());
            object2 = new File(file, (String)object);
            object = new cd(this, (Context)weakReference);
            v.a((Context)weakReference, (File)object2, (Runnable)object);
        }
    }
}

