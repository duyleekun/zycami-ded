/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher$$Lambda$1;
import com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Set;

public class DefaultUserAgentPublisher
implements UserAgentPublisher {
    private final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
    private final String javaSDKVersionUserAgent;

    public DefaultUserAgentPublisher(Set object, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.javaSDKVersionUserAgent = object = DefaultUserAgentPublisher.toUserAgent((Set)object);
        this.gamesSDKRegistrar = globalLibraryVersionRegistrar;
    }

    public static Component component() {
        Component$Builder component$Builder = Component.builder(UserAgentPublisher.class);
        Object object = Dependency.setOf(LibraryVersion.class);
        component$Builder = component$Builder.add((Dependency)object);
        object = DefaultUserAgentPublisher$$Lambda$1.lambdaFactory$();
        return component$Builder.factory((ComponentFactory)object).build();
    }

    public static /* synthetic */ UserAgentPublisher lambda$component$0(ComponentContainer object) {
        object = object.setOf(LibraryVersion.class);
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.getInstance();
        DefaultUserAgentPublisher defaultUserAgentPublisher = new DefaultUserAgentPublisher((Set)object, globalLibraryVersionRegistrar);
        return defaultUserAgentPublisher;
    }

    private static String toUserAgent(Set object) {
        char c10;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while ((c10 = object.hasNext()) != '\u0000') {
            Object object2 = (LibraryVersion)object.next();
            String string2 = ((LibraryVersion)object2).getLibraryName();
            stringBuilder.append(string2);
            char c11 = '/';
            stringBuilder.append(c11);
            object2 = ((LibraryVersion)object2).getVersion();
            stringBuilder.append((String)object2);
            c10 = object.hasNext();
            if (c10 == '\u0000') continue;
            c10 = ' ';
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public String getUserAgent() {
        Object object = this.gamesSDKRegistrar.getRegisteredVersions();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return this.javaSDKVersionUserAgent;
        }
        object = new StringBuilder();
        String string2 = this.javaSDKVersionUserAgent;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(' ');
        string2 = DefaultUserAgentPublisher.toUserAgent(this.gamesSDKRegistrar.getRegisteredVersions());
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }
}

