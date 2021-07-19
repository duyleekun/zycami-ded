/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$InstantiationException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory {
    private static final SimpleArrayMap sClassCacheMap;

    static {
        SimpleArrayMap simpleArrayMap;
        sClassCacheMap = simpleArrayMap = new SimpleArrayMap();
    }

    public static boolean isFragmentClass(ClassLoader object, String object2) {
        try {
            object = FragmentFactory.loadClass((ClassLoader)object, (String)object2);
            object2 = Fragment.class;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
        return ((Class)object2).isAssignableFrom((Class<?>)object);
    }

    private static Class loadClass(ClassLoader classLoader, String string2) {
        Object object = sClassCacheMap;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap)((SimpleArrayMap)object).get(classLoader);
        if (simpleArrayMap == null) {
            simpleArrayMap = new SimpleArrayMap();
            ((SimpleArrayMap)object).put(classLoader, simpleArrayMap);
        }
        if ((object = (Class)simpleArrayMap.get(string2)) == null) {
            object = Class.forName(string2, false, classLoader);
            simpleArrayMap.put(string2, object);
        }
        return object;
    }

    public static Class loadFragmentClass(ClassLoader classLoader, String string2) {
        String string3 = "Unable to instantiate fragment ";
        try {
            return FragmentFactory.loadClass(classLoader, string2);
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.append(": make sure class is a valid subclass of Fragment");
            string2 = stringBuilder.toString();
            Fragment$InstantiationException fragment$InstantiationException = new Fragment$InstantiationException(string2, classCastException);
            throw fragment$InstantiationException;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.append(": make sure class name exists");
            string2 = stringBuilder.toString();
            Fragment$InstantiationException fragment$InstantiationException = new Fragment$InstantiationException(string2, classNotFoundException);
            throw fragment$InstantiationException;
        }
    }

    public Fragment instantiate(ClassLoader constructor, String string2) {
        Object object = ": make sure class name exists, is public, and has an empty constructor that is public";
        String string3 = "Unable to instantiate fragment ";
        constructor = FragmentFactory.loadFragmentClass((ClassLoader)((Object)constructor), string2);
        Serializable serializable = null;
        Class[] classArray = new Class[]{};
        constructor = ((Class)((Object)constructor)).getConstructor(classArray);
        serializable = new Object[]{};
        constructor = constructor.newInstance((Object[])serializable);
        try {
            return (Fragment)((Object)constructor);
        }
        catch (InvocationTargetException invocationTargetException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append(": calling Fragment constructor caused an exception");
            string2 = ((StringBuilder)serializable).toString();
            object = new Fragment$InstantiationException(string2, invocationTargetException);
            throw object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append(": could not find Fragment constructor");
            string2 = ((StringBuilder)serializable).toString();
            object = new Fragment$InstantiationException(string2, noSuchMethodException);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            classArray = new StringBuilder();
            classArray.append(string3);
            classArray.append(string2);
            classArray.append((String)object);
            string2 = classArray.toString();
            serializable = new Fragment$InstantiationException(string2, illegalAccessException);
            throw serializable;
        }
        catch (InstantiationException instantiationException) {
            classArray = new StringBuilder();
            classArray.append(string3);
            classArray.append(string2);
            classArray.append((String)object);
            string2 = classArray.toString();
            serializable = new Fragment$InstantiationException(string2, instantiationException);
            throw serializable;
        }
    }
}

