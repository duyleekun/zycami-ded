/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Fragment
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 */
package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.dynamic.IFragmentWrapper$Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class FragmentWrapper
extends IFragmentWrapper$Stub {
    private Fragment zza;

    private FragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
            return fragmentWrapper;
        }
        return null;
    }

    public final IObjectWrapper zza() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    public final void zza(Intent intent) {
        this.zza.startActivity(intent);
    }

    public final void zza(Intent intent, int n10) {
        this.zza.startActivityForResult(intent, n10);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        iObjectWrapper = (View)ObjectWrapper.unwrap(iObjectWrapper);
        this.zza.registerForContextMenu((View)iObjectWrapper);
    }

    public final void zza(boolean bl2) {
        this.zza.setHasOptionsMenu(bl2);
    }

    public final Bundle zzb() {
        return this.zza.getArguments();
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        iObjectWrapper = (View)ObjectWrapper.unwrap(iObjectWrapper);
        this.zza.unregisterForContextMenu((View)iObjectWrapper);
    }

    public final void zzb(boolean bl2) {
        this.zza.setMenuVisibility(bl2);
    }

    public final int zzc() {
        return this.zza.getId();
    }

    public final void zzc(boolean bl2) {
        this.zza.setRetainInstance(bl2);
    }

    public final IFragmentWrapper zzd() {
        return FragmentWrapper.wrap(this.zza.getParentFragment());
    }

    public final void zzd(boolean bl2) {
        this.zza.setUserVisibleHint(bl2);
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    public final boolean zzf() {
        return this.zza.getRetainInstance();
    }

    public final String zzg() {
        return this.zza.getTag();
    }

    public final IFragmentWrapper zzh() {
        return FragmentWrapper.wrap(this.zza.getTargetFragment());
    }

    public final int zzi() {
        return this.zza.getTargetRequestCode();
    }

    public final boolean zzj() {
        return this.zza.getUserVisibleHint();
    }

    public final IObjectWrapper zzk() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    public final boolean zzl() {
        return this.zza.isAdded();
    }

    public final boolean zzm() {
        return this.zza.isDetached();
    }

    public final boolean zzn() {
        return this.zza.isHidden();
    }

    public final boolean zzo() {
        return this.zza.isInLayout();
    }

    public final boolean zzp() {
        return this.zza.isRemoving();
    }

    public final boolean zzq() {
        return this.zza.isResumed();
    }

    public final boolean zzr() {
        return this.zza.isVisible();
    }
}

