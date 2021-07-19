/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.Size
 */
package d.v.c.b2.w.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Size;
import com.bumptech.glide.Priority;
import com.zhiyun.image.Images;
import d.c.a.s.d;
import d.c.a.s.j.e;
import d.c.a.s.k.f;
import d.v.c.b2.w.j;
import d.v.c.b2.w.l.b;
import d.v.c.x1.q.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class a
extends e
implements b {
    private WeakReference d;
    private Object e;
    private Size f;
    private Priority g;
    private d.v.c.b2.x.d h;

    public a(Object object) {
        this(object, null, null);
    }

    public a(Object object, Size size) {
        this(object, size, null);
    }

    public a(Object object, Size size, Priority priority) {
        this.e = object;
        this.f = size;
        if (priority == null) {
            object = Priority.NORMAL;
            this.g = object;
        } else {
            this.g = priority;
        }
    }

    public a(Object object, Priority priority) {
        this(object, null, priority);
    }

    private void o() {
        d d10 = this.h();
        if (d10 != null) {
            d10.clear();
        }
    }

    private void q() {
        Object object = this.d;
        if (object != null) {
            ((Reference)object).clear();
            this.d = null;
        }
        if ((object = this.h) != null) {
            this.h = null;
        }
    }

    private Bitmap r() {
        WeakReference weakReference = this.d;
        weakReference = weakReference != null ? (Bitmap)weakReference.get() : null;
        return weakReference;
    }

    private void v(Context context) {
        Object object;
        Object object2;
        Object object3 = this.e;
        boolean bl2 = object3 instanceof c;
        if (bl2) {
            boolean bl3;
            object2 = ((c)object3).e();
            object3 = context.getContentResolver();
            object = Uri.parse((String)object2);
            if ((object3 = object3.getType(object)) != null && (bl3 = ((String)(object3 = ((String)object3).toLowerCase())).startsWith((String)(object = "image/"))) || (bl3 = ((String)(object3 = ((String)object2).toLowerCase())).endsWith((String)(object = ".gif"))) || (bl3 = ((String)(object3 = ((String)object2).toLowerCase())).endsWith((String)(object = ".png"))) || (bl3 = ((String)(object3 = ((String)object2).toLowerCase())).endsWith((String)(object = ".jpg"))) || (bl3 = ((String)(object3 = ((String)object2).toLowerCase())).endsWith((String)(object = ".jpeg")))) {
                int n10 = j.t;
                Priority priority = this.g;
                object = context;
                int n11 = n10;
                Images.p(context, object2, n10, n10, priority, this);
                return;
            }
        }
        if ((object3 = this.f) != null) {
            object2 = this.e;
            int n12 = object3.getWidth();
            object3 = this.f;
            int n13 = object3.getHeight();
            Priority priority = this.g;
            object = context;
            Images.p(context, object2, n12, n13, priority, this);
        } else {
            object3 = this.e;
            object = this.g;
            Images.u(context, object3, (Priority)((Object)object), this);
        }
    }

    public void b() {
        this.o();
        this.q();
        this.h = null;
    }

    public boolean f() {
        boolean bl2;
        Bitmap bitmap = this.r();
        if (bitmap != null && !(bl2 = (bitmap = (Bitmap)this.d.get()).isRecycled())) {
            bl2 = true;
        } else {
            bl2 = false;
            bitmap = null;
        }
        return bl2;
    }

    public void i(Drawable drawable2) {
        this.q();
    }

    public void n() {
        this.b();
    }

    public Bitmap s(Context context) {
        boolean bl2 = this.f();
        if (!bl2) {
            if (context != null) {
                this.v(context);
            }
            return null;
        }
        return this.r();
    }

    public Bitmap t(Context context, d.v.c.b2.x.d d10) {
        this.x(d10);
        return this.s(context);
    }

    public Object u() {
        return this.e;
    }

    public void w(Bitmap bitmap, f object) {
        object = new WeakReference(bitmap);
        this.d = object;
        object = this.h;
        if (object != null) {
            Object object2 = this.e;
            object.a(object2, bitmap);
        }
    }

    public void x(d.v.c.b2.x.d d10) {
        this.h = d10;
    }
}

