/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.FirebaseInstallationsRegistrar$$Lambda$1;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

public class FirebaseInstallationsRegistrar
implements ComponentRegistrar {
    public static /* synthetic */ FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer object) {
        FirebaseApp firebaseApp = (FirebaseApp)object.get(FirebaseApp.class);
        Provider provider = object.getProvider(UserAgentPublisher.class);
        object = object.getProvider(HeartBeatInfo.class);
        FirebaseInstallations firebaseInstallations = new FirebaseInstallations(firebaseApp, provider, (Provider)object);
        return firebaseInstallations;
    }

    public List getComponents() {
        Component[] componentArray = new Component[2];
        Object object = Component.builder(FirebaseInstallationsApi.class);
        Object object2 = Dependency.required(FirebaseApp.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.optionalProvider(HeartBeatInfo.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = Dependency.optionalProvider(UserAgentPublisher.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = FirebaseInstallationsRegistrar$$Lambda$1.lambdaFactory$();
        componentArray[0] = object = ((Component$Builder)object).factory((ComponentFactory)object2).build();
        componentArray[1] = object = LibraryVersionComponent.create("fire-installations", "16.3.5");
        return Arrays.asList(componentArray);
    }
}

