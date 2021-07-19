/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.conversation;

public final class ConversationMemberRole
extends Enum {
    private static final /* synthetic */ ConversationMemberRole[] $VALUES;
    public static final /* enum */ ConversationMemberRole MANAGER;
    public static final /* enum */ ConversationMemberRole MEMBER;
    private String role;

    static {
        ConversationMemberRole conversationMemberRole;
        ConversationMemberRole conversationMemberRole2;
        MANAGER = conversationMemberRole2 = new ConversationMemberRole("MANAGER", 0, "Manager");
        int n10 = 1;
        MEMBER = conversationMemberRole = new ConversationMemberRole("MEMBER", n10, "Member");
        ConversationMemberRole[] conversationMemberRoleArray = new ConversationMemberRole[2];
        conversationMemberRoleArray[0] = conversationMemberRole2;
        conversationMemberRoleArray[n10] = conversationMemberRole;
        $VALUES = conversationMemberRoleArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ConversationMemberRole() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.role = var3_1;
    }

    public static ConversationMemberRole fromString(String string2) {
        for (ConversationMemberRole conversationMemberRole : ConversationMemberRole.values()) {
            String string3 = conversationMemberRole.role;
            boolean bl2 = string3.equalsIgnoreCase(string2);
            if (!bl2) continue;
            return conversationMemberRole;
        }
        return null;
    }

    public static ConversationMemberRole valueOf(String string2) {
        return Enum.valueOf(ConversationMemberRole.class, string2);
    }

    public static ConversationMemberRole[] values() {
        return (ConversationMemberRole[])$VALUES.clone();
    }

    public String getName() {
        return this.role;
    }
}

