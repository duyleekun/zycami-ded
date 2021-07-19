/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerfRegistrar$$Lambda$1;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Arrays;
import java.util.List;

public class FirebasePerfRegistrar
implements ComponentRegistrar {
    public static /* synthetic */ FirebasePerformance lambda$getComponents$0(ComponentContainer object) {
        FirebaseApp firebaseApp = (FirebaseApp)object.get(FirebaseApp.class);
        Provider provider = object.getProvider(RemoteConfigComponent.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi)object.get(FirebaseInstallationsApi.class);
        object = object.getProvider(TransportFactory.class);
        FirebasePerformance firebasePerformance = new FirebasePerformance(firebaseApp, provider, firebaseInstallationsApi, (Provider)object);
        return firebasePerformance;
    }

    public List getComponents() {
        Component[] componentArray = new Component[2];
        Object object = Component.builder(FirebasePerformance.class);
        Object object2 = Dependency.required(FirebaseApp.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.requiredProvider(RemoteConfigComponent.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.required(FirebaseInstallationsApi.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.requiredProvider(TransportFactory.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = FirebasePerfRegistrar$$Lambda$1.lambdaFactory$();
        componentArray[0] = object = ((Component$Builder)object).factory((ComponentFactory)object2).eagerInDefaultApp().build();
        componentArray[1] = object = LibraryVersionComponent.create("fire-perf", "19.1.1");
        return Arrays.asList(componentArray);
    }
}

