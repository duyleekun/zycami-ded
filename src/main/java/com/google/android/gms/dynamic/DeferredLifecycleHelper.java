/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.dynamic.DeferredLifecycleHelper$zaa;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.dynamic.zaa;
import com.google.android.gms.dynamic.zab;
import com.google.android.gms.dynamic.zac;
import com.google.android.gms.dynamic.zad;
import com.google.android.gms.dynamic.zae;
import com.google.android.gms.dynamic.zaf;
import com.google.android.gms.dynamic.zag;
import java.util.AbstractCollection;
import java.util.LinkedList;

public abstract class DeferredLifecycleHelper {
    private LifecycleDelegate zarf;
    private Bundle zarg;
    private LinkedList zarh;
    private final OnDelegateCreatedListener zari;

    public DeferredLifecycleHelper() {
        zaa zaa2 = new zaa(this);
        this.zari = zaa2;
    }

    public static void showGooglePlayUnavailableMessage(FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int n10 = googleApiAvailability.isGooglePlayServicesAvailable(context);
        String string2 = ConnectionErrorMessages.getErrorMessage(context, n10);
        String string3 = ConnectionErrorMessages.getErrorDialogButtonMessage(context, n10);
        Context context2 = frameLayout.getContext();
        LinearLayout linearLayout = new LinearLayout(context2);
        int n11 = 1;
        linearLayout.setOrientation(n11);
        int n12 = -2;
        context2 = new FrameLayout.LayoutParams(n12, n12);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)context2);
        frameLayout.addView((View)linearLayout);
        frameLayout = frameLayout.getContext();
        context2 = new TextView((Context)frameLayout);
        frameLayout = new FrameLayout.LayoutParams(n12, n12);
        context2.setLayoutParams((ViewGroup.LayoutParams)frameLayout);
        context2.setText((CharSequence)string2);
        linearLayout.addView((View)context2);
        frameLayout = googleApiAvailability.getErrorResolutionIntent(context, n10, null);
        if (frameLayout != null) {
            googleApiAvailability = new Button(context);
            n10 = 16908313;
            googleApiAvailability.setId(n10);
            Object object = new FrameLayout.LayoutParams(n12, n12);
            googleApiAvailability.setLayoutParams((ViewGroup.LayoutParams)object);
            googleApiAvailability.setText(string3);
            linearLayout.addView((View)googleApiAvailability);
            object = new zae(context, (Intent)frameLayout);
            googleApiAvailability.setOnClickListener((View.OnClickListener)object);
        }
    }

    public static /* synthetic */ Bundle zaa(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        deferredLifecycleHelper.zarg = null;
        return null;
    }

    public static /* synthetic */ LifecycleDelegate zaa(DeferredLifecycleHelper deferredLifecycleHelper, LifecycleDelegate lifecycleDelegate) {
        deferredLifecycleHelper.zarf = lifecycleDelegate;
        return lifecycleDelegate;
    }

    public static /* synthetic */ LinkedList zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        return deferredLifecycleHelper.zarh;
    }

    private final void zaa(Bundle object, DeferredLifecycleHelper$zaa deferredLifecycleHelper$zaa) {
        Object object2 = this.zarf;
        if (object2 != null) {
            deferredLifecycleHelper$zaa.zaa((LifecycleDelegate)object2);
            return;
        }
        object2 = this.zarh;
        if (object2 == null) {
            this.zarh = object2 = new Object();
        }
        object2 = this.zarh;
        ((LinkedList)object2).add(deferredLifecycleHelper$zaa);
        if (object != null) {
            deferredLifecycleHelper$zaa = this.zarg;
            if (deferredLifecycleHelper$zaa == null) {
                this.zarg = object = (Bundle)object.clone();
            } else {
                deferredLifecycleHelper$zaa.putAll((Bundle)object);
            }
        }
        object = this.zari;
        this.createDelegate((OnDelegateCreatedListener)object);
    }

    public static /* synthetic */ LifecycleDelegate zab(DeferredLifecycleHelper deferredLifecycleHelper) {
        return deferredLifecycleHelper.zarf;
    }

    private final void zal(int n10) {
        Object object;
        int n11;
        while ((n11 = ((AbstractCollection)(object = this.zarh)).isEmpty()) == 0 && (n11 = (object = (DeferredLifecycleHelper$zaa)this.zarh.getLast()).getState()) >= n10) {
            object = this.zarh;
            ((LinkedList)object).removeLast();
        }
    }

    public abstract void createDelegate(OnDelegateCreatedListener var1);

    public LifecycleDelegate getDelegate() {
        return this.zarf;
    }

    public void handleGooglePlayUnavailable(FrameLayout frameLayout) {
        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(frameLayout);
    }

    public void onCreate(Bundle bundle) {
        zac zac2 = new zac(this, bundle);
        this.zaa(bundle, zac2);
    }

    public View onCreateView(LayoutInflater object, ViewGroup viewGroup, Bundle bundle) {
        zad zad2;
        Object object2 = object.getContext();
        FrameLayout frameLayout = new FrameLayout(object2);
        object2 = zad2;
        zad2 = new zad(this, frameLayout, (LayoutInflater)object, viewGroup, bundle);
        this.zaa(bundle, zad2);
        object = this.zarf;
        if (object == null) {
            this.handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        LifecycleDelegate lifecycleDelegate = this.zarf;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
            return;
        }
        this.zal(1);
    }

    public void onDestroyView() {
        LifecycleDelegate lifecycleDelegate = this.zarf;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroyView();
            return;
        }
        this.zal(2);
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        zab zab2 = new zab(this, activity, bundle, bundle2);
        this.zaa(bundle2, zab2);
    }

    public void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.zarf;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
    }

    public void onPause() {
        LifecycleDelegate lifecycleDelegate = this.zarf;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
            return;
        }
        this.zal(5);
    }

    public void onResume() {
        zag zag2 = new zag(this);
        this.zaa(null, zag2);
    }

    public void onSaveInstanceState(Bundle bundle) {
        LifecycleDelegate lifecycleDelegate = this.zarf;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onSaveInstanceState(bundle);
            return;
        }
        lifecycleDelegate = this.zarg;
        if (lifecycleDelegate != null) {
            bundle.putAll((Bundle)lifecycleDelegate);
        }
    }

    public void onStart() {
        zaf zaf2 = new zaf(this);
        this.zaa(null, zaf2);
    }

    public void onStop() {
        LifecycleDelegate lifecycleDelegate = this.zarf;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onStop();
            return;
        }
        this.zal(4);
    }
}

