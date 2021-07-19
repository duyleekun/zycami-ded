/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVFriendshipRequest$RequestStatus
extends Enum {
    private static final /* synthetic */ AVFriendshipRequest$RequestStatus[] $VALUES;
    public static final /* enum */ AVFriendshipRequest$RequestStatus Accepted;
    public static final /* enum */ AVFriendshipRequest$RequestStatus Declined;
    public static final /* enum */ AVFriendshipRequest$RequestStatus Pending;

    static {
        AVFriendshipRequest$RequestStatus aVFriendshipRequest$RequestStatus;
        AVFriendshipRequest$RequestStatus aVFriendshipRequest$RequestStatus2;
        AVFriendshipRequest$RequestStatus aVFriendshipRequest$RequestStatus3;
        Pending = aVFriendshipRequest$RequestStatus3 = new AVFriendshipRequest$RequestStatus("Pending", 0);
        int n10 = 1;
        Accepted = aVFriendshipRequest$RequestStatus2 = new AVFriendshipRequest$RequestStatus("Accepted", n10);
        int n11 = 2;
        Declined = aVFriendshipRequest$RequestStatus = new AVFriendshipRequest$RequestStatus("Declined", n11);
        AVFriendshipRequest$RequestStatus[] aVFriendshipRequest$RequestStatusArray = new AVFriendshipRequest$RequestStatus[3];
        aVFriendshipRequest$RequestStatusArray[0] = aVFriendshipRequest$RequestStatus3;
        aVFriendshipRequest$RequestStatusArray[n10] = aVFriendshipRequest$RequestStatus2;
        aVFriendshipRequest$RequestStatusArray[n11] = aVFriendshipRequest$RequestStatus;
        $VALUES = aVFriendshipRequest$RequestStatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVFriendshipRequest$RequestStatus() {
        void var2_-1;
        void var1_-1;
    }

    public static AVFriendshipRequest$RequestStatus valueOf(String string2) {
        return Enum.valueOf(AVFriendshipRequest$RequestStatus.class, string2);
    }

    public static AVFriendshipRequest$RequestStatus[] values() {
        return (AVFriendshipRequest$RequestStatus[])$VALUES.clone();
    }
}

