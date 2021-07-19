/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.datatransport.TransportRegistrar$$Lambda$1;
import java.util.Collections;
import java.util.List;

public class TransportRegistrar
implements ComponentRegistrar {
    public static /* synthetic */ TransportFactory lambda$getComponents$0(ComponentContainer object) {
        TransportRuntime.initialize((Context)object.get(Context.class));
        object = TransportRuntime.getInstance();
        CCTDestination cCTDestination = CCTDestination.LEGACY_INSTANCE;
        return ((TransportRuntime)object).newFactory(cCTDestination);
    }

    public List getComponents() {
        Component$Builder component$Builder = Component.builder(TransportFactory.class);
        Object object = Dependency.required(Context.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = TransportRegistrar$$Lambda$1.lambdaFactory$();
        return Collections.singletonList(component$Builder.factory((ComponentFactory)object).build());
    }
}

