/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnUnhandledKeyEventListener
 */
package androidx.core.view;

import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.R$id;
import androidx.core.view.ViewCompat$CompatImplApi28$1;
import androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat;

public class ViewCompat$CompatImplApi28 {
    private ViewCompat$CompatImplApi28() {
    }

    public static void addOnUnhandledKeyEventListener(View view, ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        int n10 = R$id.tag_unhandled_key_listeners;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap)view.getTag(n10);
        if (simpleArrayMap == null) {
            simpleArrayMap = new SimpleArrayMap();
            view.setTag(n10, (Object)simpleArrayMap);
        }
        ViewCompat$CompatImplApi28$1 viewCompat$CompatImplApi28$1 = new ViewCompat$CompatImplApi28$1(viewCompat$OnUnhandledKeyEventListenerCompat);
        simpleArrayMap.put(viewCompat$OnUnhandledKeyEventListenerCompat, viewCompat$CompatImplApi28$1);
        view.addOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)viewCompat$CompatImplApi28$1);
    }

    public static void removeOnUnhandledKeyEventListener(View view, ViewCompat$OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat) {
        int n10 = R$id.tag_unhandled_key_listeners;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap)view.getTag(n10);
        if (simpleArrayMap == null) {
            return;
        }
        if ((viewCompat$OnUnhandledKeyEventListenerCompat = (View.OnUnhandledKeyEventListener)simpleArrayMap.get(viewCompat$OnUnhandledKeyEventListenerCompat)) != null) {
            view.removeOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)viewCompat$OnUnhandledKeyEventListenerCompat);
        }
    }
}

