/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Strings;

public final class Platform {
    private static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";

    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
        String string2 = GWT_RPC_PROPERTY_NAME;
        Object object = System.getProperty(string2, "true");
        boolean bl2 = Boolean.parseBoolean((String)object);
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{string2, "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"};
        string2 = Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", objectArray);
        object = new UnsupportedOperationException(string2);
        throw object;
    }
}

