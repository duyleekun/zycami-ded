/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.reflect.ClassPath;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ClassPath$Scanner {
    private final Set scannedUris;

    public ClassPath$Scanner() {
        HashSet hashSet = Sets.newHashSet();
        this.scannedUris = hashSet;
    }

    private static ImmutableList getClassLoaderUrls(ClassLoader classLoader) {
        boolean bl2 = classLoader instanceof URLClassLoader;
        if (bl2) {
            return ImmutableList.copyOf(((URLClassLoader)classLoader).getURLs());
        }
        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader();
        boolean bl3 = classLoader.equals(classLoader2);
        if (bl3) {
            return ClassPath$Scanner.parseJavaClassPath();
        }
        return ImmutableList.of();
    }

    public static ImmutableMap getClassPathEntries(ClassLoader classLoader) {
        boolean bl2;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        Object object = classLoader.getParent();
        if (object != null) {
            object = ClassPath$Scanner.getClassPathEntries((ClassLoader)object);
            linkedHashMap.putAll(object);
        }
        object = ClassPath$Scanner.getClassLoaderUrls(classLoader).iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            Serializable serializable = (URL)object.next();
            String string3 = serializable.getProtocol();
            boolean bl3 = string3.equals(string2 = "file");
            if (!bl3 || (bl3 = linkedHashMap.containsKey(serializable = ClassPath.toFile(serializable)))) continue;
            linkedHashMap.put(serializable, classLoader);
        }
        return ImmutableMap.copyOf((Map)linkedHashMap);
    }

    public static URL getClassPathEntry(File serializable, String string2) {
        serializable = serializable.toURI().toURL();
        URL uRL = new URL((URL)serializable, string2);
        return uRL;
    }

    public static ImmutableSet getClassPathFromManifest(File file, Manifest iterator2) {
        if (iterator2 == null) {
            return ImmutableSet.of();
        }
        ImmutableSet$Builder immutableSet$Builder = ImmutableSet.builder();
        iterator2 = ((Manifest)((Object)iterator2)).getMainAttributes();
        Object object = Attributes.Name.CLASS_PATH.toString();
        if ((iterator2 = ((Attributes)((Object)iterator2)).getValue((String)object)) != null) {
            boolean bl2;
            object = ClassPath.access$200();
            iterator2 = ((Splitter)object).split((CharSequence)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                CharSequence charSequence;
                Object object2;
                object = (String)iterator2.next();
                try {
                    object2 = ((URL)(object = ClassPath$Scanner.getClassPathEntry(file, (String)object))).getProtocol();
                    boolean bl3 = ((String)object2).equals(charSequence = "file");
                    if (!bl3) continue;
                }
                catch (MalformedURLException malformedURLException) {
                    object2 = ClassPath.access$100();
                    charSequence = new StringBuilder();
                    String string2 = "Invalid Class-Path entry: ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append((String)object);
                    object = ((StringBuilder)charSequence).toString();
                    ((Logger)object2).warning((String)object);
                    continue;
                }
                object = ClassPath.toFile((URL)object);
                immutableSet$Builder.add(object);
            }
        }
        return immutableSet$Builder.build();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ImmutableList parseJavaClassPath() {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        Object object = Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value());
        String string2 = StandardSystemProperty.JAVA_CLASS_PATH.value();
        object = ((Splitter)object).split(string2).iterator();
        boolean bl2;
        while (bl2 = object.hasNext()) {
            Object object2;
            Level level;
            Object object3;
            MalformedURLException malformedURLException2222222;
            string2 = (String)object.next();
            Serializable serializable = new File(string2);
            serializable = ((File)serializable).toURI();
            serializable = ((URI)serializable).toURL();
            immutableList$Builder.add(serializable);
            continue;
            {
                catch (MalformedURLException malformedURLException2222222) {
                }
                catch (SecurityException securityException) {}
                {
                    object3 = "file";
                    level = null;
                    object2 = new File(string2);
                    object2 = ((File)object2).getAbsolutePath();
                    serializable = new URL((String)object3, null, (String)object2);
                    immutableList$Builder.add(serializable);
                    continue;
                }
            }
            object3 = ClassPath.access$100();
            level = Level.WARNING;
            object2 = new StringBuilder();
            String string3 = "malformed classpath entry: ";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            ((Logger)object3).log(level, string2, malformedURLException2222222);
        }
        return immutableList$Builder.build();
    }

    private void scanFrom(File object, ClassLoader classLoader) {
        boolean bl2;
        block4: {
            try {
                bl2 = ((File)object).exists();
                if (bl2) break block4;
                return;
            }
            catch (SecurityException securityException) {
                Logger logger = ClassPath.access$100();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot access ");
                stringBuilder.append(object);
                stringBuilder.append(": ");
                stringBuilder.append(securityException);
                object = stringBuilder.toString();
                logger.warning((String)object);
                return;
            }
        }
        bl2 = ((File)object).isDirectory();
        if (bl2) {
            this.scanDirectory(classLoader, (File)object);
        } else {
            this.scanJar((File)object, classLoader);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void scanJar(File object, ClassLoader classLoader) {
        JarFile jarFile;
        try {
            jarFile = new JarFile((File)object);
        }
        catch (IOException iOException) {
            return;
        }
        try {
            boolean bl2;
            Object object2 = jarFile.getManifest();
            object = ClassPath$Scanner.getClassPathFromManifest((File)object, (Manifest)object2);
            object = ((ImmutableSet)object).iterator();
            while (bl2 = object.hasNext()) {
                object2 = object.next();
                object2 = (File)object2;
                this.scan((File)object2, classLoader);
            }
            this.scanJarFile(classLoader, jarFile);
            return;
        }
        finally {
            jarFile.close();
        }
    }

    public final void scan(File file, ClassLoader classLoader) {
        Set set = this.scannedUris;
        File file2 = file.getCanonicalFile();
        boolean bl2 = set.add(file2);
        if (bl2) {
            this.scanFrom(file, classLoader);
        }
    }

    public final void scan(ClassLoader object) {
        boolean bl2;
        object = ClassPath$Scanner.getClassPathEntries((ClassLoader)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            File file = (File)object2.getKey();
            object2 = (ClassLoader)object2.getValue();
            this.scan(file, (ClassLoader)object2);
        }
    }

    public abstract void scanDirectory(ClassLoader var1, File var2);

    public abstract void scanJarFile(ClassLoader var1, JarFile var2);
}

