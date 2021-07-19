/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  android.view.View
 */
package d.c.a.p;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.manager.RequestManagerFragment;
import d.c.a.c;
import d.c.a.i;
import d.c.a.p.a;
import d.c.a.p.b;
import d.c.a.p.g;
import d.c.a.p.k$a;
import d.c.a.p.k$b;
import d.c.a.p.l;
import d.c.a.p.n;
import d.c.a.u.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class k
implements Handler.Callback {
    public static final String i = "com.bumptech.glide.manager";
    private static final String j = "RMRetriever";
    private static final int k = 1;
    private static final int l = 2;
    private static final String m = "key";
    private static final k$b n;
    private volatile i a;
    public final Map b;
    public final Map c;
    private final Handler d;
    private final k$b e;
    private final ArrayMap f;
    private final ArrayMap g;
    private final Bundle h;

    static {
        k$a k$a = new k$a();
        n = k$a;
    }

    public k(k$b k$b) {
        Bundle bundle = new HashMap();
        this.b = bundle;
        bundle = new HashMap();
        this.c = bundle;
        this.f = bundle;
        super();
        this.g = bundle;
        this.h = bundle = new Bundle();
        if (k$b == null) {
            k$b = n;
        }
        this.e = k$b;
        bundle = Looper.getMainLooper();
        super((Looper)bundle, (Handler.Callback)this);
        this.d = k$b;
    }

    private static void a(Activity object) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11 && (bl2 = object.isDestroyed())) {
            object = new IllegalArgumentException("You cannot start a load for a destroyed activity");
            throw object;
        }
    }

    private static Activity b(Context context) {
        boolean bl2 = context instanceof Activity;
        if (bl2) {
            return (Activity)context;
        }
        bl2 = context instanceof ContextWrapper;
        if (bl2) {
            return d.c.a.p.k.b(((ContextWrapper)context).getBaseContext());
        }
        return null;
    }

    private void c(android.app.FragmentManager object, ArrayMap arrayMap) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            object = object.getFragments().iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Fragment fragment = (Fragment)object.next();
                View view = fragment.getView();
                if (view == null) continue;
                view = fragment.getView();
                arrayMap.put(view, fragment);
                fragment = fragment.getChildFragmentManager();
                this.c((android.app.FragmentManager)fragment, arrayMap);
            }
        } else {
            this.d((android.app.FragmentManager)object, arrayMap);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(android.app.FragmentManager fragmentManager, ArrayMap arrayMap) {
        int n10 = 0;
        Fragment fragment = null;
        while (true) {
            Bundle bundle = this.h;
            int n11 = n10 + 1;
            String string2 = m;
            bundle.putInt(string2, n10);
            n10 = 0;
            fragment = null;
            try {
                bundle = this.h;
                fragment = fragmentManager.getFragment(bundle, string2);
            }
            catch (Exception exception) {}
            if (fragment == null) {
                return;
            }
            bundle = fragment.getView();
            if (bundle != null) {
                bundle = fragment.getView();
                arrayMap.put(bundle, fragment);
                int n12 = Build.VERSION.SDK_INT;
                int n13 = 17;
                if (n12 >= n13) {
                    fragment = fragment.getChildFragmentManager();
                    this.c((android.app.FragmentManager)fragment, arrayMap);
                }
            }
            n10 = n11;
        }
    }

    private static void e(Collection object, Map map) {
        boolean bl2;
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            View view;
            Object object2 = (androidx.fragment.app.Fragment)object.next();
            if (object2 == null || (view = ((androidx.fragment.app.Fragment)object2).getView()) == null) continue;
            view = ((androidx.fragment.app.Fragment)object2).getView();
            map.put(view, object2);
            object2 = ((androidx.fragment.app.Fragment)object2).getChildFragmentManager().getFragments();
            d.c.a.p.k.e((Collection)object2, map);
        }
    }

    private Fragment f(View view, Activity activity) {
        boolean bl2;
        this.g.clear();
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        ArrayMap arrayMap = this.g;
        this.c(fragmentManager, arrayMap);
        activity = activity.findViewById(0x1020002);
        fragmentManager = null;
        while (!(bl2 = view.equals(activity)) && (fragmentManager = (Fragment)this.g.get(view)) == null && (bl2 = (arrayMap = view.getParent()) instanceof View)) {
            view = (View)view.getParent();
        }
        this.g.clear();
        return fragmentManager;
    }

    private androidx.fragment.app.Fragment g(View view, FragmentActivity fragmentActivity) {
        boolean bl2;
        this.f.clear();
        Object object = fragmentActivity.getSupportFragmentManager().getFragments();
        ArrayMap arrayMap = this.f;
        d.c.a.p.k.e((Collection)object, arrayMap);
        fragmentActivity = fragmentActivity.findViewById(0x1020002);
        object = null;
        while (!(bl2 = view.equals(fragmentActivity)) && (object = (androidx.fragment.app.Fragment)this.f.get(view)) == null && (bl2 = (arrayMap = view.getParent()) instanceof View)) {
            view = (View)view.getParent();
        }
        this.f.clear();
        return object;
    }

    private i h(Context context, android.app.FragmentManager object, Fragment object2, boolean bl2) {
        if ((object2 = ((RequestManagerFragment)((Object)(object = this.q((android.app.FragmentManager)object, (Fragment)object2, bl2)))).e()) == null) {
            object2 = d.c.a.c.d(context);
            k$b k$b = this.e;
            a a10 = ((RequestManagerFragment)((Object)object)).c();
            l l10 = ((RequestManagerFragment)((Object)object)).f();
            object2 = k$b.a((c)object2, a10, l10, context);
            ((RequestManagerFragment)((Object)object)).k((i)object2);
        }
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private i o(Context object) {
        Object object2 = this.a;
        if (object2 != null) return this.a;
        synchronized (this) {
            object2 = this.a;
            if (object2 != null) return this.a;
            object2 = object.getApplicationContext();
            object2 = d.c.a.c.d((Context)object2);
            k$b k$b = this.e;
            b b10 = new b();
            g g10 = new g();
            object = object.getApplicationContext();
            object = k$b.a((c)object2, b10, g10, (Context)object);
            this.a = object;
            return this.a;
        }
    }

    private RequestManagerFragment q(android.app.FragmentManager fragmentManager, Fragment object, boolean bl2) {
        String string2 = i;
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment)fragmentManager.findFragmentByTag(string2);
        if (requestManagerFragment == null && (requestManagerFragment = (RequestManagerFragment)((Object)this.b.get(fragmentManager))) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.j((Fragment)object);
            if (bl2) {
                object = requestManagerFragment.c();
                ((a)object).d();
            }
            this.b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment)requestManagerFragment, string2).commitAllowingStateLoss();
            object = this.d;
            bl2 = true;
            fragmentManager = object.obtainMessage((int)(bl2 ? 1 : 0), (Object)fragmentManager);
            fragmentManager.sendToTarget();
        }
        return requestManagerFragment;
    }

    private n s(FragmentManager fragmentManager, androidx.fragment.app.Fragment object, boolean bl2) {
        String string2 = i;
        n n10 = (n)fragmentManager.findFragmentByTag(string2);
        if (n10 == null && (n10 = (n)this.c.get(fragmentManager)) == null) {
            n10 = new n();
            n10.r((androidx.fragment.app.Fragment)object);
            if (bl2) {
                object = n10.j();
                ((a)object).d();
            }
            this.c.put(fragmentManager, n10);
            fragmentManager.beginTransaction().add(n10, string2).commitAllowingStateLoss();
            object = this.d;
            int n11 = 2;
            fragmentManager = object.obtainMessage(n11, (Object)fragmentManager);
            fragmentManager.sendToTarget();
        }
        return n10;
    }

    private static boolean t(Context context) {
        boolean bl2;
        if ((context = d.c.a.p.k.b(context)) != null && (bl2 = context.isFinishing())) {
            bl2 = false;
            context = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private i u(Context context, FragmentManager object, androidx.fragment.app.Fragment object2, boolean bl2) {
        if ((object2 = ((n)(object = this.s((FragmentManager)object, (androidx.fragment.app.Fragment)object2, bl2))).l()) == null) {
            object2 = d.c.a.c.d(context);
            k$b k$b = this.e;
            a a10 = ((n)object).j();
            l l10 = ((n)object).m();
            object2 = k$b.a((c)object2, a10, l10, context);
            ((n)object).s((i)object2);
        }
        return object2;
    }

    public boolean handleMessage(Message object) {
        boolean bl2;
        boolean bl3;
        Object object2;
        block3: {
            block4: {
                block1: {
                    block2: {
                        boolean bl32 = object.what;
                        object2 = null;
                        bl3 = true;
                        if (bl32 == bl3) break block1;
                        boolean bl4 = 2 != 0;
                        if (bl32 == bl4) break block2;
                        bl3 = false;
                        object = null;
                        break block3;
                    }
                    object = object.obj;
                    object2 = object;
                    object2 = (FragmentManager)object;
                    object = this.c.remove(object2);
                    break block4;
                }
                object = object.obj;
                object2 = object;
                object2 = (android.app.FragmentManager)object;
                object = this.b.remove(object2);
            }
            Object object3 = object2;
            object2 = object;
            object = object3;
        }
        if (bl3 && object2 == null && (bl2 = Log.isLoggable((String)(object2 = j), (int)5))) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Failed to remove expected request manager fragment, manager: ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            Log.w((String)object2, (String)object);
        }
        return bl3;
    }

    public i i(Activity activity) {
        boolean bl2 = d.c.a.u.m.s();
        if (bl2) {
            activity = activity.getApplicationContext();
            return this.k((Context)activity);
        }
        d.c.a.p.k.a(activity);
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        boolean bl3 = d.c.a.p.k.t((Context)activity);
        return this.h((Context)activity, fragmentManager, null, bl3);
    }

    public i j(Fragment object) {
        Activity activity = object.getActivity();
        if (activity != null) {
            int n10;
            int n11 = d.c.a.u.m.s();
            if (n11 == 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 17)) {
                activity = object.getChildFragmentManager();
                Activity activity2 = object.getActivity();
                boolean bl2 = object.isVisible();
                return this.h((Context)activity2, (android.app.FragmentManager)activity, (Fragment)object, bl2);
            }
            object = object.getActivity().getApplicationContext();
            return this.k((Context)object);
        }
        object = new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        throw object;
    }

    public i k(Context object) {
        if (object != null) {
            boolean bl2 = d.c.a.u.m.t();
            if (bl2 && !(bl2 = object instanceof Application)) {
                bl2 = object instanceof FragmentActivity;
                if (bl2) {
                    object = (FragmentActivity)object;
                    return this.n((FragmentActivity)object);
                }
                bl2 = object instanceof Activity;
                if (bl2) {
                    object = (Activity)object;
                    return this.i((Activity)object);
                }
                bl2 = object instanceof ContextWrapper;
                if (bl2) {
                    Object object2 = object;
                    object2 = (ContextWrapper)object;
                    Context context = object2.getBaseContext().getApplicationContext();
                    if (context != null) {
                        object = object2.getBaseContext();
                        return this.k((Context)object);
                    }
                }
            }
            return this.o((Context)object);
        }
        object = new IllegalArgumentException("You cannot start a load on a null Context");
        throw object;
    }

    public i l(View object) {
        boolean bl2 = d.c.a.u.m.s();
        if (bl2) {
            object = object.getContext().getApplicationContext();
            return this.k((Context)object);
        }
        d.c.a.u.k.d(object);
        Object object2 = object.getContext();
        String string2 = "Unable to obtain a request manager for a view without a Context";
        d.c.a.u.k.e(object2, string2);
        object2 = d.c.a.p.k.b(object.getContext());
        if (object2 == null) {
            object = object.getContext().getApplicationContext();
            return this.k((Context)object);
        }
        boolean bl3 = object2 instanceof FragmentActivity;
        if (bl3) {
            object = (object = this.g((View)object, (FragmentActivity)(object2 = (FragmentActivity)object2))) != null ? this.m((androidx.fragment.app.Fragment)object) : this.n((FragmentActivity)object2);
            return object;
        }
        if ((object = this.f((View)object, (Activity)object2)) == null) {
            return this.i((Activity)object2);
        }
        return this.j((Fragment)object);
    }

    public i m(androidx.fragment.app.Fragment fragment) {
        Object object = fragment.getContext();
        String string2 = "You cannot start a load on a fragment before it is attached or after it is destroyed";
        d.c.a.u.k.e(object, string2);
        boolean bl2 = d.c.a.u.m.s();
        if (bl2) {
            fragment = fragment.getContext().getApplicationContext();
            return this.k((Context)fragment);
        }
        object = fragment.getChildFragmentManager();
        string2 = fragment.getContext();
        boolean bl3 = fragment.isVisible();
        return this.u((Context)string2, (FragmentManager)object, fragment, bl3);
    }

    public i n(FragmentActivity fragmentActivity) {
        boolean bl2 = d.c.a.u.m.s();
        if (bl2) {
            fragmentActivity = fragmentActivity.getApplicationContext();
            return this.k((Context)fragmentActivity);
        }
        d.c.a.p.k.a(fragmentActivity);
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        boolean bl3 = d.c.a.p.k.t((Context)fragmentActivity);
        return this.u((Context)fragmentActivity, fragmentManager, null, bl3);
    }

    public RequestManagerFragment p(Activity activity) {
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        boolean bl2 = d.c.a.p.k.t((Context)activity);
        return this.q(fragmentManager, null, bl2);
    }

    public n r(Context context, FragmentManager fragmentManager) {
        boolean bl2 = d.c.a.p.k.t(context);
        return this.s(fragmentManager, null, bl2);
    }
}

