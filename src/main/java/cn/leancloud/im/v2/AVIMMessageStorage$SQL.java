/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

public class AVIMMessageStorage$SQL {
    public static final String DELETE_LOCAL_MESSAGE = "conversation_id = ? and message_id = ? and status = ? and dtoken = ? ";
    public static final String ORDER_BY_TIMESTAMP_ASC_THEN_MESSAGE_ID_ASC = "timestamp , message_id";
    public static final String ORDER_BY_TIMESTAMP_DESC_THEN_MESSAGE_ID_DESC = "timestamp desc, message_id desc";
    public static final String SELECT_VALID_CONVS = "(temp < 1 and expireAt > ?) or (temp> 0 and temp_ttl > ?)";
    public static final String TIMESTAMP_LESS_AND_CONVERSATION_ID = "timestamp < ? and conversation_id = ? ";
    public static final String TIMESTAMP_LESS_OR_TIMESTAMP_EQUAL_BUT_MESSAGE_ID_LESS_AND_CONVERSATION_ID = " ( timestamp < ? or (timestamp = ? and message_id < ? )) and conversation_id = ? ";
    public static final String TIMESTAMP_MORE_OR_TIMESTAMP_EQUAL_BUT_MESSAGE_ID_MORE_AND_CONVERSATION_ID = " ( timestamp > ? or (timestamp = ? and message_id > ? )) and conversation_id = ? ";
}

