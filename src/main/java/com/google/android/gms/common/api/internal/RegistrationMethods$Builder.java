/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zaby;
import com.google.android.gms.common.api.internal.zabz;
import com.google.android.gms.common.api.internal.zaca;
import com.google.android.gms.common.api.internal.zacb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public class RegistrationMethods$Builder {
    private boolean zajw = true;
    private RemoteCall zakb;
    private RemoteCall zakc;
    private ListenerHolder zakd;
    private Feature[] zake;

    private RegistrationMethods$Builder() {
    }

    public /* synthetic */ RegistrationMethods$Builder(zabx zabx2) {
        this();
    }

    public static /* synthetic */ RemoteCall zaa(RegistrationMethods$Builder registrationMethods$Builder) {
        return registrationMethods$Builder.zakb;
    }

    public static /* synthetic */ RemoteCall zab(RegistrationMethods$Builder registrationMethods$Builder) {
        return registrationMethods$Builder.zakc;
    }

    public RegistrationMethods build() {
        zaca zaca2;
        boolean bl2;
        Object object = this.zakb;
        boolean bl3 = true;
        Object object2 = null;
        if (object != null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        Object object3 = "Must set register function";
        Preconditions.checkArgument(bl2, object3);
        object = this.zakc;
        if (object != null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        object3 = "Must set unregister function";
        Preconditions.checkArgument(bl2, object3);
        object = this.zakd;
        if (object == null) {
            bl3 = false;
            zaca2 = null;
        }
        Preconditions.checkArgument(bl3, "Must set holder");
        object2 = this.zakd;
        object3 = this.zake;
        boolean bl4 = this.zajw;
        zaca2 = new zaca(this, (ListenerHolder)object2, (Feature[])object3, bl4);
        object3 = this.zakd.getListenerKey();
        object2 = new zacb(this, (ListenerHolder$ListenerKey)object3);
        object = new RegistrationMethods(zaca2, (UnregisterListenerMethod)object2, null);
        return object;
    }

    public RegistrationMethods$Builder register(RemoteCall remoteCall) {
        this.zakb = remoteCall;
        return this;
    }

    public RegistrationMethods$Builder register(BiConsumer biConsumer) {
        zaby zaby2 = new zaby(biConsumer);
        this.zakb = zaby2;
        return this;
    }

    public RegistrationMethods$Builder setAutoResolveMissingFeatures(boolean bl2) {
        this.zajw = bl2;
        return this;
    }

    public RegistrationMethods$Builder setFeatures(Feature[] featureArray) {
        this.zake = featureArray;
        return this;
    }

    public RegistrationMethods$Builder unregister(RemoteCall remoteCall) {
        this.zakc = remoteCall;
        return this;
    }

    public RegistrationMethods$Builder unregister(BiConsumer object) {
        this.zakb = object = new zabz(this);
        return this;
    }

    public RegistrationMethods$Builder withHolder(ListenerHolder listenerHolder) {
        this.zakd = listenerHolder;
        return this;
    }

    public final /* synthetic */ void zaa(Api$AnyClient api$AnyClient, TaskCompletionSource taskCompletionSource) {
        this.zakb.accept(api$AnyClient, taskCompletionSource);
    }
}

