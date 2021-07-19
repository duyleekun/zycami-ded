/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

public final class AVLiveQuery$EventType
extends Enum {
    private static final /* synthetic */ AVLiveQuery$EventType[] $VALUES;
    public static final /* enum */ AVLiveQuery$EventType CREATE;
    public static final /* enum */ AVLiveQuery$EventType DELETE;
    public static final /* enum */ AVLiveQuery$EventType ENTER;
    public static final /* enum */ AVLiveQuery$EventType LEAVE;
    public static final /* enum */ AVLiveQuery$EventType LOGIN;
    public static final /* enum */ AVLiveQuery$EventType UNKONWN;
    public static final /* enum */ AVLiveQuery$EventType UPDATE;
    private String event;

    static {
        AVLiveQuery$EventType aVLiveQuery$EventType;
        AVLiveQuery$EventType aVLiveQuery$EventType2;
        AVLiveQuery$EventType aVLiveQuery$EventType3;
        AVLiveQuery$EventType aVLiveQuery$EventType4;
        AVLiveQuery$EventType aVLiveQuery$EventType5;
        AVLiveQuery$EventType aVLiveQuery$EventType6;
        AVLiveQuery$EventType aVLiveQuery$EventType7;
        CREATE = aVLiveQuery$EventType7 = new AVLiveQuery$EventType("CREATE", 0, "create");
        int n10 = 1;
        UPDATE = aVLiveQuery$EventType6 = new AVLiveQuery$EventType("UPDATE", n10, "update");
        int n11 = 2;
        ENTER = aVLiveQuery$EventType5 = new AVLiveQuery$EventType("ENTER", n11, "enter");
        int n12 = 3;
        LEAVE = aVLiveQuery$EventType4 = new AVLiveQuery$EventType("LEAVE", n12, "leave");
        int n13 = 4;
        DELETE = aVLiveQuery$EventType3 = new AVLiveQuery$EventType("DELETE", n13, "delete");
        int n14 = 5;
        LOGIN = aVLiveQuery$EventType2 = new AVLiveQuery$EventType("LOGIN", n14, "login");
        int n15 = 6;
        UNKONWN = aVLiveQuery$EventType = new AVLiveQuery$EventType("UNKONWN", n15, "unknown");
        AVLiveQuery$EventType[] aVLiveQuery$EventTypeArray = new AVLiveQuery$EventType[7];
        aVLiveQuery$EventTypeArray[0] = aVLiveQuery$EventType7;
        aVLiveQuery$EventTypeArray[n10] = aVLiveQuery$EventType6;
        aVLiveQuery$EventTypeArray[n11] = aVLiveQuery$EventType5;
        aVLiveQuery$EventTypeArray[n12] = aVLiveQuery$EventType4;
        aVLiveQuery$EventTypeArray[n13] = aVLiveQuery$EventType3;
        aVLiveQuery$EventTypeArray[n14] = aVLiveQuery$EventType2;
        aVLiveQuery$EventTypeArray[n15] = aVLiveQuery$EventType;
        $VALUES = aVLiveQuery$EventTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVLiveQuery$EventType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.event = var3_1;
    }

    public static AVLiveQuery$EventType getType(String string2) {
        AVLiveQuery$EventType aVLiveQuery$EventType = CREATE;
        String string3 = aVLiveQuery$EventType.getContent();
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return aVLiveQuery$EventType;
        }
        aVLiveQuery$EventType = UPDATE;
        string3 = aVLiveQuery$EventType.getContent();
        bl2 = string3.equals(string2);
        if (bl2) {
            return aVLiveQuery$EventType;
        }
        aVLiveQuery$EventType = ENTER;
        string3 = aVLiveQuery$EventType.getContent();
        bl2 = string3.equals(string2);
        if (bl2) {
            return aVLiveQuery$EventType;
        }
        aVLiveQuery$EventType = LEAVE;
        string3 = aVLiveQuery$EventType.getContent();
        bl2 = string3.equals(string2);
        if (bl2) {
            return aVLiveQuery$EventType;
        }
        aVLiveQuery$EventType = DELETE;
        string3 = aVLiveQuery$EventType.getContent();
        bl2 = string3.equals(string2);
        if (bl2) {
            return aVLiveQuery$EventType;
        }
        aVLiveQuery$EventType = LOGIN;
        string3 = aVLiveQuery$EventType.getContent();
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return aVLiveQuery$EventType;
        }
        return UNKONWN;
    }

    public static AVLiveQuery$EventType valueOf(String string2) {
        return Enum.valueOf(AVLiveQuery$EventType.class, string2);
    }

    public static AVLiveQuery$EventType[] values() {
        return (AVLiveQuery$EventType[])$VALUES.clone();
    }

    public String getContent() {
        return this.event;
    }
}

