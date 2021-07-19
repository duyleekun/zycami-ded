/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor;

public final class LibraryVersionComponent$$Lambda$1
implements ComponentFactory {
    private final String arg$1;
    private final LibraryVersionComponent$VersionExtractor arg$2;

    private LibraryVersionComponent$$Lambda$1(String string2, LibraryVersionComponent$VersionExtractor libraryVersionComponent$VersionExtractor) {
        this.arg$1 = string2;
        this.arg$2 = libraryVersionComponent$VersionExtractor;
    }

    public static ComponentFactory lambdaFactory$(String string2, LibraryVersionComponent$VersionExtractor libraryVersionComponent$VersionExtractor) {
        LibraryVersionComponent$$Lambda$1 libraryVersionComponent$$Lambda$1 = new LibraryVersionComponent$$Lambda$1(string2, libraryVersionComponent$VersionExtractor);
        return libraryVersionComponent$$Lambda$1;
    }

    public Object create(ComponentContainer componentContainer) {
        String string2 = this.arg$1;
        LibraryVersionComponent$VersionExtractor libraryVersionComponent$VersionExtractor = this.arg$2;
        return LibraryVersionComponent.lambda$fromContext$0(string2, libraryVersionComponent$VersionExtractor, componentContainer);
    }
}

