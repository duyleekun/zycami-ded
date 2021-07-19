/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Name;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class NavigatorProvider {
    private static final HashMap sAnnotationNames;
    private final HashMap mNavigators;

    static {
        HashMap hashMap;
        sAnnotationNames = hashMap = new HashMap();
    }

    public NavigatorProvider() {
        HashMap hashMap;
        this.mNavigators = hashMap = new HashMap();
    }

    public static String getNameForNavigator(Class object) {
        Serializable serializable = sAnnotationNames;
        Object object2 = (String)serializable.get(object);
        if (object2 == null) {
            object2 = ((Class)object).getAnnotation(Navigator$Name.class);
            object2 = object2 != null ? object2.value() : null;
            boolean bl2 = NavigatorProvider.validateName((String)object2);
            if (bl2) {
                serializable.put(object, object2);
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("No @Navigator.Name annotation found for ");
                object = ((Class)object).getSimpleName();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                serializable = new IllegalArgumentException((String)object);
                throw serializable;
            }
        }
        return object2;
    }

    private static boolean validateName(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public final Navigator addNavigator(Navigator navigator) {
        String string2 = NavigatorProvider.getNameForNavigator(navigator.getClass());
        return this.addNavigator(string2, navigator);
    }

    public Navigator addNavigator(String object, Navigator navigator) {
        boolean bl2 = NavigatorProvider.validateName((String)object);
        if (bl2) {
            return this.mNavigators.put(object, navigator);
        }
        object = new IllegalArgumentException("navigator name cannot be an empty string");
        throw object;
    }

    public final Navigator getNavigator(Class object) {
        object = NavigatorProvider.getNameForNavigator((Class)object);
        return this.getNavigator((String)object);
    }

    public Navigator getNavigator(String object) {
        boolean bl2 = NavigatorProvider.validateName((String)object);
        if (bl2) {
            Object object2 = (Navigator)this.mNavigators.get(object);
            if (object2 != null) {
                return object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find Navigator with name \"");
            stringBuilder.append((String)object);
            stringBuilder.append("\". You must call NavController.addNavigator() for each navigation type.");
            object = stringBuilder.toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("navigator name cannot be an empty string");
        throw object;
    }

    public Map getNavigators() {
        return this.mNavigators;
    }
}

