/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import d.c.a.c;
import d.c.a.i;
import d.c.a.p.a;
import d.c.a.p.k;
import d.c.a.p.l;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RequestManagerFragment
extends Fragment {
    private static final String g = "RMFragment";
    private final a a;
    private final l b;
    private final Set c;
    private i d;
    private RequestManagerFragment e;
    private Fragment f;

    public RequestManagerFragment() {
        a a10 = new a();
        this(a10);
    }

    public RequestManagerFragment(a a10) {
        HashSet hashSet = new HashSet(this);
        this.b = hashSet;
        this.c = hashSet = new HashSet();
        this.a = a10;
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.c.add(requestManagerFragment);
    }

    private Fragment d() {
        Fragment fragment;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            fragment = this.getParentFragment();
        } else {
            n10 = 0;
            fragment = null;
        }
        if (fragment == null) {
            fragment = this.f;
        }
        return fragment;
    }

    private boolean g(Fragment fragment) {
        Fragment fragment2;
        Fragment fragment3 = this.getParentFragment();
        while ((fragment2 = fragment.getParentFragment()) != null) {
            boolean bl2 = fragment2.equals((Object)fragment3);
            if (bl2) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void h(Activity object) {
        this.l();
        k k10 = d.c.a.c.d((Context)object).n();
        object = k10.p((Activity)object);
        this.e = object;
        boolean bl2 = this.equals(object);
        if (!bl2) {
            object = this.e;
            super.a(this);
        }
    }

    private void i(RequestManagerFragment requestManagerFragment) {
        this.c.remove((Object)requestManagerFragment);
    }

    private void l() {
        RequestManagerFragment requestManagerFragment = this.e;
        if (requestManagerFragment != null) {
            requestManagerFragment.i(this);
            requestManagerFragment = null;
            this.e = null;
        }
    }

    public Set b() {
        int n10;
        Object object = this.e;
        int n11 = this.equals(object);
        if (n11 != 0) {
            return Collections.unmodifiableSet(this.c);
        }
        object = this.e;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 17)) {
            boolean bl2;
            object = new HashSet();
            Iterator iterator2 = this.e.b().iterator();
            while (bl2 = iterator2.hasNext()) {
                RequestManagerFragment requestManagerFragment = (RequestManagerFragment)((Object)iterator2.next());
                Fragment fragment = requestManagerFragment.getParentFragment();
                boolean bl3 = this.g(fragment);
                if (!bl3) continue;
                object.add(requestManagerFragment);
            }
            return Collections.unmodifiableSet(object);
        }
        return Collections.emptySet();
    }

    public a c() {
        return this.a;
    }

    public i e() {
        return this.d;
    }

    public l f() {
        return this.b;
    }

    public void j(Fragment fragment) {
        Activity activity;
        this.f = fragment;
        if (fragment != null && (activity = fragment.getActivity()) != null) {
            fragment = fragment.getActivity();
            this.h((Activity)fragment);
        }
    }

    public void k(i i10) {
        this.d = i10;
    }

    public void onAttach(Activity activity) {
        block2: {
            super.onAttach(activity);
            try {
                this.h(activity);
            }
            catch (IllegalStateException illegalStateException) {
                String string2 = g;
                boolean bl2 = Log.isLoggable((String)string2, (int)5);
                if (!bl2) break block2;
                String string3 = "Unable to register fragment with root";
                Log.w((String)string2, (String)string3, (Throwable)illegalStateException);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        this.l();
    }

    public void onDetach() {
        super.onDetach();
        this.l();
    }

    public void onStart() {
        super.onStart();
        this.a.d();
    }

    public void onStop() {
        super.onStop();
        this.a.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append("{parent=");
        string2 = this.d();
        stringBuilder.append((Object)string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

