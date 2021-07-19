/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath$ResourceInfo;
import com.google.common.reflect.ClassPath$Scanner;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;

public final class ClassPath$DefaultScanner
extends ClassPath$Scanner {
    private final SetMultimap resources;

    public ClassPath$DefaultScanner() {
        Multimap multimap = MultimapBuilder.hashKeys().linkedHashSetValues().build();
        this.resources = multimap;
    }

    private void scanDirectory(File object, ClassLoader object2, String charSequence, Set set) {
        File[] fileArray = ((File)object).listFiles();
        if (fileArray == null) {
            object2 = ClassPath.access$100();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Cannot read directory ");
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            ((Logger)object2).warning((String)object);
            return;
        }
        for (File file : fileArray) {
            Object object3 = file.getName();
            boolean bl2 = file.isDirectory();
            if (bl2) {
                File file2 = file.getCanonicalFile();
                bl2 = set.add(file2);
                if (!bl2) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append((String)object3);
                stringBuilder.append("/");
                object3 = stringBuilder.toString();
                this.scanDirectory(file2, (ClassLoader)object2, (String)object3, set);
                set.remove(file2);
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append((String)object3);
            String string2 = stringBuilder.toString();
            object3 = "META-INF/MANIFEST.MF";
            boolean bl3 = string2.equals(object3);
            if (bl3) continue;
            object3 = this.resources.get(object2);
            object3.add(string2);
        }
    }

    public ImmutableSet getResources() {
        boolean bl2;
        ImmutableSet$Builder immutableSet$Builder = ImmutableSet.builder();
        Iterator iterator2 = this.resources.entries().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Map.Entry)iterator2.next();
            String string2 = (String)object.getValue();
            object = (ClassLoader)object.getKey();
            object = ClassPath$ResourceInfo.of(string2, (ClassLoader)object);
            immutableSet$Builder.add(object);
        }
        return immutableSet$Builder.build();
    }

    public void scanDirectory(ClassLoader classLoader, File file) {
        HashSet<File> hashSet = new HashSet<File>();
        File file2 = file.getCanonicalFile();
        hashSet.add(file2);
        this.scanDirectory(file, classLoader, "", hashSet);
    }

    public void scanJarFile(ClassLoader classLoader, JarFile object) {
        boolean bl2;
        object = ((JarFile)object).entries();
        while (bl2 = object.hasMoreElements()) {
            String string2;
            Object object2;
            Object object3 = (JarEntry)object.nextElement();
            boolean bl3 = ((ZipEntry)object3).isDirectory();
            if (bl3 || (bl3 = ((String)(object2 = ((ZipEntry)object3).getName())).equals(string2 = "META-INF/MANIFEST.MF"))) continue;
            object2 = this.resources.get(classLoader);
            object3 = ((ZipEntry)object3).getName();
            object2.add(object3);
        }
    }
}

