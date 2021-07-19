/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.firebase.platforminfo.LibraryVersionComponent$$Lambda$1;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public class LibraryVersionComponent {
    private LibraryVersionComponent() {
    }

    public static Component create(String string2, String string3) {
        return Component.intoSet(LibraryVersion.create(string2, string3), LibraryVersion.class);
    }

    public static Component fromContext(String object, LibraryVersionComponent$VersionExtractor libraryVersionComponent$VersionExtractor) {
        Component$Builder component$Builder = Component.intoSetBuilder(LibraryVersion.class);
        Dependency dependency = Dependency.required(Context.class);
        component$Builder = component$Builder.add(dependency);
        object = LibraryVersionComponent$$Lambda$1.lambdaFactory$((String)object, libraryVersionComponent$VersionExtractor);
        return component$Builder.factory((ComponentFactory)object).build();
    }

    public static /* synthetic */ LibraryVersion lambda$fromContext$0(String string2, LibraryVersionComponent$VersionExtractor object, ComponentContainer componentContainer) {
        componentContainer = (Context)componentContainer.get(Context.class);
        object = object.extract(componentContainer);
        return LibraryVersion.create(string2, (String)object);
    }
}

