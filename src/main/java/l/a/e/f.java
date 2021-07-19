/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package l.a.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import l.a.c;
import l.a.e.f$a;
import l.a.e.g;
import l.a.h.a;

public class f {
    private static final Class[] b;
    private static final int[] c;
    private static final String[] d;
    private static final Map e;
    private final Object[] a;

    static {
        Object object = new Class[2];
        object[0] = Context.class;
        int n10 = 1;
        object[n10] = AttributeSet.class;
        b = object;
        object = new int[n10];
        object[0] = (Class)16843375;
        c = (int[])object;
        d = new String[]{"android.widget.", "android.view.", "android.webkit."};
        e = object = new a();
    }

    public f() {
        Object[] objectArray = new Object[2];
        this.a = objectArray;
    }

    private void a(View view, AttributeSet attributeSet) {
        int n10;
        Object object = view.getContext();
        int n11 = object instanceof ContextWrapper;
        if (n11 != 0 && ((n11 = Build.VERSION.SDK_INT) < (n10 = 15) || (n11 = (int)(l.a.p.c.a(view) ? 1 : 0)) != 0)) {
            Object object2 = c;
            if ((object = (attributeSet = object.obtainStyledAttributes(attributeSet, object2)).getString(0)) != null) {
                object2 = new f$a;
                object2(view, (String)object);
                view.setOnClickListener((View.OnClickListener)object2);
            }
            attributeSet.recycle();
        }
    }

    private View b(Context object, String string2, String object2) {
        Map map = e;
        Constructor constructor = (Constructor)map.get(string2);
        if (constructor == null) {
            block16: {
                block15: {
                    object = object.getClassLoader();
                    if (object2 == null) break block15;
                    constructor = new Constructor();
                    ((StringBuilder)((Object)constructor)).append((String)object2);
                    ((StringBuilder)((Object)constructor)).append(string2);
                    object2 = ((StringBuilder)((Object)constructor)).toString();
                    break block16;
                }
                object2 = string2;
            }
            object = ((ClassLoader)object).loadClass((String)object2);
            object2 = View.class;
            object = ((Class)object).asSubclass(object2);
            object2 = b;
            constructor = ((Class)object).getConstructor((Class<?>)object2);
            map.put(string2, constructor);
        }
        boolean bl2 = true;
        try {
            constructor.setAccessible(bl2);
            object = this.a;
        }
        catch (Exception exception) {
            return null;
        }
        object = constructor.newInstance((Object[])object);
        return (View)object;
    }

    private View d(Context context, String string2, AttributeSet attributeSet) {
        boolean bl2;
        Iterator iterator2 = l.a.c.r().p().iterator();
        View view = null;
        while ((bl2 = iterator2.hasNext()) && (view = ((g)iterator2.next()).b(context, string2, attributeSet)) == null) {
        }
        return view;
    }

    private View e(Context context, String string2, AttributeSet attributeSet) {
        boolean bl2;
        Iterator iterator2 = l.a.c.r().q().iterator();
        View view = null;
        while ((bl2 = iterator2.hasNext()) && (view = ((g)iterator2.next()).b(context, string2, attributeSet)) == null) {
        }
        return view;
    }

    public final View c(View view, String string2, Context context, AttributeSet attributeSet) {
        view = this.d(context, string2, attributeSet);
        if (view == null) {
            view = this.e(context, string2, attributeSet);
        }
        if (view == null) {
            view = this.f(context, string2, attributeSet);
        }
        if (view != null) {
            this.a(view, attributeSet);
        }
        return view;
    }

    public View f(Context objectArray, String objectArray2, AttributeSet attributeSet) {
        block14: {
            String string2 = "view";
            int n10 = (int)(string2.equals(objectArray2) ? 1 : 0);
            if (n10 != 0) {
                objectArray2 = attributeSet.getAttributeValue(null, "class");
            }
            n10 = 1;
            View view = this.a;
            view[0] = objectArray;
            view[n10] = attributeSet;
            int n11 = -1;
            int n12 = 46;
            n12 = objectArray2.indexOf(n12);
            if (n11 != n12) break block14;
            n11 = 0;
            attributeSet = null;
            while (true) {
                view = d;
                int n13 = ((Object[])view).length;
                if (n11 >= n13) break;
                view = view[n11];
                view = this.b((Context)objectArray, (String)objectArray2, (String)view);
                if (view != null) {
                    objectArray = this.a;
                    objectArray[0] = null;
                    objectArray[n10] = null;
                    return view;
                }
                ++n11;
                continue;
                break;
            }
            objectArray = this.a;
            objectArray[0] = null;
            objectArray[n10] = null;
            return null;
        }
        try {
            objectArray = this.b((Context)objectArray, (String)objectArray2, null);
            objectArray2 = this.a;
            objectArray2[0] = null;
            objectArray2[n10] = null;
            return objectArray;
        }
        catch (Throwable throwable) {
            objectArray2 = this.a;
            objectArray2[0] = null;
            objectArray2[n10] = null;
            throw throwable;
        }
        catch (Exception exception) {
            objectArray = this.a;
            objectArray[0] = null;
            objectArray[n10] = null;
            return null;
        }
    }
}

