/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvCommand$Builder;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.StringUtil;
import java.util.Arrays;
import java.util.Map;

public class ConversationQueryPacket
extends PeerBasedCommandPacket {
    public Map queryParams;

    public ConversationQueryPacket() {
        this.setCmd("conv");
    }

    public static ConversationQueryPacket getConversationQueryPacket(String string2, Map map, int n10) {
        int n11;
        ConversationQueryPacket conversationQueryPacket = new ConversationQueryPacket();
        int n12 = AVIMClient.getClientsCount();
        if (n12 > (n11 = 1)) {
            conversationQueryPacket.setPeerId(string2);
        }
        conversationQueryPacket.queryParams = map;
        conversationQueryPacket.setRequestId(n10);
        return conversationQueryPacket;
    }

    public Messages$ConvCommand getConvCommand() {
        int n10;
        Messages$ConvCommand$Builder messages$ConvCommand$Builder = Messages$ConvCommand.newBuilder();
        Object object = this.queryParams;
        if (object != null && (n10 = object.isEmpty()) == 0) {
            boolean bl2;
            boolean bl3;
            object = this.queryParams;
            Object object2 = "temp_id";
            if ((object = object.get(object2)) != null && !(bl3 = StringUtil.isEmpty((String)(object2 = object.toString())))) {
                object = object.toString();
                object2 = ",";
                object = Arrays.asList(((String)object).split((String)object2));
                messages$ConvCommand$Builder.addAllTempConvIds((Iterable)object);
            }
            object = this.queryParams;
            object2 = "order";
            if ((object = object.get(object2)) != null && !(bl3 = StringUtil.isEmpty((String)(object2 = object.toString())))) {
                object = object.toString();
                messages$ConvCommand$Builder.setSort((String)object);
            }
            object = this.queryParams;
            object2 = "skip";
            if ((object = object.get(object2)) != null && !(bl3 = StringUtil.isEmpty((String)(object2 = object.toString())))) {
                object = object.toString();
                n10 = Integer.parseInt((String)object);
                messages$ConvCommand$Builder.setSkip(n10);
            }
            object = this.queryParams;
            object2 = "limit";
            if ((object = object.get(object2)) != null && !(bl3 = StringUtil.isEmpty((String)(object2 = object.toString())))) {
                object = object.toString();
                n10 = Integer.parseInt((String)object);
                messages$ConvCommand$Builder.setLimit(n10);
            }
            object = this.queryParams;
            object2 = "where";
            if ((object = object.get(object2)) != null && !(bl3 = StringUtil.isEmpty((String)(object2 = object.toString())))) {
                object2 = Messages$JsonObjectMessage.newBuilder();
                bl2 = object instanceof String;
                if (bl2) {
                    object = (String)object;
                    ((Messages$JsonObjectMessage$Builder)object2).setData((String)object);
                } else {
                    object = JSON.toJSONString(object);
                    ((Messages$JsonObjectMessage$Builder)object2).setData((String)object);
                }
                messages$ConvCommand$Builder.setWhere((Messages$JsonObjectMessage$Builder)object2);
            }
            n10 = 0;
            object = null;
            object2 = this.queryParams;
            String string2 = "last_message";
            if ((object2 = object2.get(string2)) != null && !(bl2 = StringUtil.isEmpty(string2 = object2.toString())) && (bl3 = Boolean.parseBoolean((String)(object2 = object2.toString())))) {
                n10 = 2;
            }
            object2 = this.queryParams;
            string2 = "compact";
            if ((object2 = object2.get(string2)) != null && !(bl2 = StringUtil.isEmpty(string2 = object2.toString())) && (bl3 = Boolean.parseBoolean((String)(object2 = object2.toString())))) {
                n10 |= 1;
            }
            if (n10 > 0) {
                messages$ConvCommand$Builder.setFlag(n10);
            }
        }
        return messages$ConvCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = this.getConvCommand();
        messages$GenericCommand$Builder.setConvMessage((Messages$ConvCommand)object);
        object = Messages$OpType.valueOf("query");
        messages$GenericCommand$Builder.setOp((Messages$OpType)object);
        return messages$GenericCommand$Builder;
    }
}

