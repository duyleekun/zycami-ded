/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

public final class FtsOptions$MatchInfo
extends Enum {
    private static final /* synthetic */ FtsOptions$MatchInfo[] $VALUES;
    public static final /* enum */ FtsOptions$MatchInfo FTS3;
    public static final /* enum */ FtsOptions$MatchInfo FTS4;

    static {
        FtsOptions$MatchInfo ftsOptions$MatchInfo;
        FtsOptions$MatchInfo ftsOptions$MatchInfo2;
        FTS3 = ftsOptions$MatchInfo2 = new FtsOptions$MatchInfo("FTS3", 0);
        int n10 = 1;
        FTS4 = ftsOptions$MatchInfo = new FtsOptions$MatchInfo("FTS4", n10);
        FtsOptions$MatchInfo[] ftsOptions$MatchInfoArray = new FtsOptions$MatchInfo[2];
        ftsOptions$MatchInfoArray[0] = ftsOptions$MatchInfo2;
        ftsOptions$MatchInfoArray[n10] = ftsOptions$MatchInfo;
        $VALUES = ftsOptions$MatchInfoArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FtsOptions$MatchInfo() {
        void var2_-1;
        void var1_-1;
    }

    public static FtsOptions$MatchInfo valueOf(String string2) {
        return Enum.valueOf(FtsOptions$MatchInfo.class, string2);
    }

    public static FtsOptions$MatchInfo[] values() {
        return (FtsOptions$MatchInfo[])$VALUES.clone();
    }
}

