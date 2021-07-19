/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package d.c.a.p;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import d.c.a.c;
import d.c.a.i;
import d.c.a.p.a;
import d.c.a.p.k;
import d.c.a.p.l;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class n
extends Fragment {
    private static final String g = "SupportRMFragment";
    private final a a;
    private final l b;
    private final Set c;
    private n d;
    private i e;
    private Fragment f;

    public n() {
        a a10 = new a();
        this(a10);
    }

    public n(a a10) {
        HashSet hashSet = new HashSet(this);
        this.b = hashSet;
        this.c = hashSet = new HashSet();
        this.a = a10;
    }

    private void h(n n10) {
        this.c.add(n10);
    }

    private Fragment k() {
        Fragment fragment = this.getParentFragment();
        if (fragment == null) {
            fragment = this.f;
        }
        return fragment;
    }

    private static FragmentManager n(Fragment fragment) {
        Fragment fragment2;
        while ((fragment2 = fragment.getParentFragment()) != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean o(Fragment fragment) {
        Fragment fragment2;
        Fragment fragment3 = this.k();
        while ((fragment2 = fragment.getParentFragment()) != null) {
            boolean bl2 = fragment2.equals(fragment3);
            if (bl2) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void p(Context object, FragmentManager fragmentManager) {
        this.t();
        k k10 = d.c.a.c.d((Context)object).n();
        object = k10.r((Context)object, fragmentManager);
        this.d = object;
        boolean bl2 = this.equals(object);
        if (!bl2) {
            object = this.d;
            super.h(this);
        }
    }

    private void q(n n10) {
        this.c.remove(n10);
    }

    private void t() {
        n n10 = this.d;
        if (n10 != null) {
            n10.q(this);
            n10 = null;
            this.d = null;
        }
    }

    public Set i() {
        boolean bl2;
        Object object = this.d;
        if (object == null) {
            return Collections.emptySet();
        }
        boolean bl3 = this.equals(object);
        if (bl3) {
            return Collections.unmodifiableSet(this.c);
        }
        object = new Object();
        Iterator iterator2 = this.d.i().iterator();
        while (bl2 = iterator2.hasNext()) {
            n n10 = (n)iterator2.next();
            Fragment fragment = n10.k();
            boolean bl4 = this.o(fragment);
            if (!bl4) continue;
            object.add(n10);
        }
        return Collections.unmodifiableSet(object);
    }

    public a j() {
        return this.a;
    }

    public i l() {
        return this.e;
    }

    public l m() {
        return this.b;
    }

    public void onAttach(Context object) {
        block5: {
            super.onAttach((Context)object);
            object = n.n(this);
            int n10 = 5;
            String string2 = g;
            if (object == null) {
                boolean bl2 = Log.isLoggable((String)string2, (int)n10);
                if (bl2) {
                    object = "Unable to register fragment with root, ancestor detached";
                    Log.w((String)string2, (String)object);
                }
                return;
            }
            Context context = this.getContext();
            try {
                this.p(context, (FragmentManager)object);
            }
            catch (IllegalStateException illegalStateException) {
                n10 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0);
                if (n10 == 0) break block5;
                String string3 = "Unable to register fragment with root";
                Log.w((String)string2, (String)string3, (Throwable)illegalStateException);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        this.t();
    }

    public void onDetach() {
        super.onDetach();
        this.f = null;
        this.t();
    }

    public void onStart() {
        super.onStart();
        this.a.d();
    }

    public void onStop() {
        super.onStop();
        this.a.e();
    }

    public void r(Fragment fragment) {
        Object object;
        this.f = fragment;
        if (fragment != null && (object = fragment.getContext()) != null) {
            object = n.n(fragment);
            if (object == null) {
                return;
            }
            fragment = fragment.getContext();
            this.p((Context)fragment, (FragmentManager)object);
        }
    }

    public void s(i i10) {
        this.e = i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("{parent=");
        object = this.k();
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

