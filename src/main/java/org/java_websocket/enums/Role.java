/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.enums;

public final class Role
extends Enum {
    public static final /* enum */ Role CLIENT;
    public static final /* enum */ Role SERVER;
    private static final /* synthetic */ Role[] a;

    static {
        Role role;
        Role role2;
        CLIENT = role2 = new Role("CLIENT", 0);
        int n10 = 1;
        SERVER = role = new Role("SERVER", n10);
        Role[] roleArray = new Role[2];
        roleArray[0] = role2;
        roleArray[n10] = role;
        a = roleArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Role() {
        void var2_-1;
        void var1_-1;
    }

    public static Role valueOf(String string2) {
        return Enum.valueOf(Role.class, string2);
    }

    public static Role[] values() {
        return (Role[])a.clone();
    }
}

