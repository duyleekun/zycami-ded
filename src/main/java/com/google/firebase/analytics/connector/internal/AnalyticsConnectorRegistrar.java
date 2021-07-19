/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzb;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class AnalyticsConnectorRegistrar
implements ComponentRegistrar {
    public static final /* synthetic */ int zza;

    public List getComponents() {
        Component[] componentArray = new Component[2];
        Object object = Component.builder(AnalyticsConnector.class);
        Object object2 = Dependency.required(FirebaseApp.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(Context.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(Subscriber.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = zzb.zza;
        componentArray[0] = object = ((Component$Builder)object).factory((ComponentFactory)object2).eagerInDefaultApp().build();
        componentArray[1] = object = LibraryVersionComponent.create("fire-analytics", "18.0.2");
        return Arrays.asList(componentArray);
    }
}

