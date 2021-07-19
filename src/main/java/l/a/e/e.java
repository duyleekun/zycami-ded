/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 */
package l.a.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import l.a.c;
import l.a.e.f;
import l.a.e.h;
import l.a.q.z;

public class e
implements LayoutInflater.Factory2 {
    private final Context a;
    private f b;
    private List c;

    private e(Context context) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.c = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.a = context;
    }

    public static e b(Context context) {
        e e10 = new e(context);
        return e10;
    }

    public void a() {
        boolean bl2;
        Object object = this.c;
        if (object != null && !(bl2 = object.isEmpty())) {
            boolean bl3;
            object = this.c.iterator();
            while (bl3 = object.hasNext()) {
                Object t10;
                Object object2 = (WeakReference)object.next();
                if (object2 == null || (t10 = ((Reference)object2).get()) == null) continue;
                object2 = (z)((Reference)object2).get();
                object2.e();
            }
        }
    }

    public View c(View view, String string2, Context object, AttributeSet attributeSet) {
        boolean bl2;
        Object object2 = this.b;
        if (object2 == null) {
            this.b = object2 = new f();
        }
        object2 = l.a.c.r().v().iterator();
        while (bl2 = object2.hasNext()) {
            h h10 = (h)object2.next();
            Context context = this.a;
            if ((h10 = h10.a(context, view, attributeSet)) == null) continue;
            object = h10;
        }
        return this.b.c(view, string2, (Context)object, attributeSet);
    }

    public View onCreateView(View view, String object, Context object2, AttributeSet object3) {
        if ((view = this.c(view, (String)object, (Context)object2, (AttributeSet)object3)) == null) {
            return null;
        }
        boolean bl2 = view instanceof z;
        if (bl2) {
            object = this.c;
            object3 = view;
            object3 = (z)view;
            object2 = new WeakReference(object3);
            object.add(object2);
        }
        return view;
    }

    public View onCreateView(String string2, Context object, AttributeSet object2) {
        Object object3 = null;
        if ((string2 = this.c(null, string2, (Context)object, (AttributeSet)object2)) == null) {
            return null;
        }
        boolean bl2 = string2 instanceof z;
        if (bl2) {
            object = this.c;
            object3 = string2;
            object3 = (z)((Object)string2);
            object2 = new WeakReference(object3);
            object.add(object2);
        }
        return (View)string2;
    }
}

