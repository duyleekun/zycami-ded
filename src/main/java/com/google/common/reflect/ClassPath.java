/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.ClassPath$1;
import com.google.common.reflect.ClassPath$ClassInfo;
import com.google.common.reflect.ClassPath$DefaultScanner;
import com.google.common.reflect.ClassPath$Scanner;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Logger;

public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    private static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR;
    private static final Predicate IS_TOP_LEVEL;
    private static final Logger logger;
    private final ImmutableSet resources;

    static {
        logger = Logger.getLogger(ClassPath.class.getName());
        ClassPath$1 classPath$1 = new ClassPath$1();
        IS_TOP_LEVEL = classPath$1;
        CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    }

    private ClassPath(ImmutableSet immutableSet) {
        this.resources = immutableSet;
    }

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ Splitter access$200() {
        return CLASS_PATH_ATTRIBUTE_SEPARATOR;
    }

    public static ClassPath from(ClassLoader object) {
        Object object2 = new ClassPath$DefaultScanner();
        ((ClassPath$Scanner)object2).scan((ClassLoader)object);
        object2 = ((ClassPath$DefaultScanner)object2).getResources();
        object = new ClassPath((ImmutableSet)object2);
        return object;
    }

    public static String getClassName(String string2) {
        int n10 = string2.length() + -6;
        return string2.substring(0, n10).replace('/', '.');
    }

    public static File toFile(URL object) {
        Object object2 = ((URL)object).getProtocol();
        Object object3 = "file";
        boolean bl2 = ((String)object2).equals(object3);
        Preconditions.checkArgument(bl2);
        try {
            object3 = ((URL)object).toURI();
        }
        catch (URISyntaxException uRISyntaxException) {
            object = ((URL)object).getPath();
            object2 = new File((String)object);
            return object2;
        }
        object2 = new File((URI)object3);
        return object2;
    }

    public ImmutableSet getAllClasses() {
        return FluentIterable.from(this.resources).filter(ClassPath$ClassInfo.class).toSet();
    }

    public ImmutableSet getResources() {
        return this.resources;
    }

    public ImmutableSet getTopLevelClasses() {
        FluentIterable fluentIterable = FluentIterable.from(this.resources).filter(ClassPath$ClassInfo.class);
        Predicate predicate = IS_TOP_LEVEL;
        return fluentIterable.filter(predicate).toSet();
    }

    public ImmutableSet getTopLevelClasses(String string2) {
        boolean bl2;
        Preconditions.checkNotNull(string2);
        ImmutableSet$Builder immutableSet$Builder = ImmutableSet.builder();
        UnmodifiableIterator unmodifiableIterator = this.getTopLevelClasses().iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            ClassPath$ClassInfo classPath$ClassInfo = (ClassPath$ClassInfo)unmodifiableIterator.next();
            String string3 = classPath$ClassInfo.getPackageName();
            boolean bl3 = string3.equals(string2);
            if (!bl3) continue;
            immutableSet$Builder.add(classPath$ClassInfo);
        }
        return immutableSet$Builder.build();
    }

    public ImmutableSet getTopLevelClassesRecursive(String string2) {
        boolean bl2;
        Preconditions.checkNotNull(string2);
        Object object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        char c10 = '.';
        ((StringBuilder)object).append(c10);
        string2 = ((StringBuilder)object).toString();
        object = ImmutableSet.builder();
        UnmodifiableIterator unmodifiableIterator = this.getTopLevelClasses().iterator();
        while (bl2 = unmodifiableIterator.hasNext()) {
            ClassPath$ClassInfo classPath$ClassInfo = (ClassPath$ClassInfo)unmodifiableIterator.next();
            String string3 = classPath$ClassInfo.getName();
            boolean bl3 = string3.startsWith(string2);
            if (!bl3) continue;
            ((ImmutableSet$Builder)object).add(classPath$ClassInfo);
        }
        return ((ImmutableSet$Builder)object).build();
    }
}

