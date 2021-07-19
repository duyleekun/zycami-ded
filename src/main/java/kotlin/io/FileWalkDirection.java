/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

public final class FileWalkDirection
extends Enum {
    public static final /* enum */ FileWalkDirection BOTTOM_UP;
    public static final /* enum */ FileWalkDirection TOP_DOWN;
    private static final /* synthetic */ FileWalkDirection[] a;

    static {
        FileWalkDirection fileWalkDirection;
        FileWalkDirection[] fileWalkDirectionArray = new FileWalkDirection[2];
        TOP_DOWN = fileWalkDirection = new FileWalkDirection("TOP_DOWN", 0);
        fileWalkDirectionArray[0] = fileWalkDirection;
        int n10 = 1;
        BOTTOM_UP = fileWalkDirection = new FileWalkDirection("BOTTOM_UP", n10);
        fileWalkDirectionArray[n10] = fileWalkDirection;
        a = fileWalkDirectionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FileWalkDirection() {
        void var2_-1;
        void var1_-1;
    }

    public static FileWalkDirection valueOf(String string2) {
        return Enum.valueOf(FileWalkDirection.class, string2);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[])a.clone();
    }
}

