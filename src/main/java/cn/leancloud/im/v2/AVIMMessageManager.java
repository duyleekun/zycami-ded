/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.im.AVIMEventHandler;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageIOType;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageHandler;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.im.v2.MessageHandler;
import cn.leancloud.im.v2.annotation.AVIMMessageType;
import cn.leancloud.im.v2.messages.AVIMAudioMessage;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import cn.leancloud.im.v2.messages.AVIMImageMessage;
import cn.leancloud.im.v2.messages.AVIMLocationMessage;
import cn.leancloud.im.v2.messages.AVIMRecalledMessage;
import cn.leancloud.im.v2.messages.AVIMTextMessage;
import cn.leancloud.im.v2.messages.AVIMVideoMessage;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class AVIMMessageManager {
    public static final AVLogger LOGGER;
    public static AVIMConversationEventHandler conversationEventHandler;
    public static AVIMMessageHandler defaultMessageHandler;
    public static ConcurrentMap messageHandlerRepository;
    public static Map messageTypesRepository;

    static {
        AbstractMap abstractMap;
        LOGGER = LogUtil.getLogger(AVIMMessageManager.class);
        messageTypesRepository = abstractMap = new AbstractMap();
        abstractMap = new AbstractMap();
        messageHandlerRepository = abstractMap;
        AVIMMessageManager.registerAVIMMessageType(AVIMTextMessage.class);
        AVIMMessageManager.registerAVIMMessageType(AVIMFileMessage.class);
        AVIMMessageManager.registerAVIMMessageType(AVIMImageMessage.class);
        AVIMMessageManager.registerAVIMMessageType(AVIMAudioMessage.class);
        AVIMMessageManager.registerAVIMMessageType(AVIMVideoMessage.class);
        AVIMMessageManager.registerAVIMMessageType(AVIMLocationMessage.class);
        AVIMMessageManager.registerAVIMMessageType(AVIMRecalledMessage.class);
    }

    public static AVIMConversationEventHandler getConversationEventHandler() {
        return conversationEventHandler;
    }

    private static int getMessageType(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            String string2;
            try {
                object = JSON.parseObject((String)object);
                string2 = "_lctype";
            }
            catch (Exception exception) {}
            object = ((JSONObject)object).getInteger(string2);
            return (Integer)object;
        }
        return 0;
    }

    public static AVIMMessage parseTypedMessage(AVIMMessage object) {
        Object object2 = ((AVIMMessage)object).getContent();
        int n10 = AVIMMessageManager.getMessageType((String)object2);
        if (n10 != 0) {
            Object object3 = null;
            Object object4 = messageTypesRepository;
            Object object5 = n10;
            if ((object4 = (Class)object4.get(object5)) != null) {
                object2 = ((Class)object4).newInstance();
                try {
                    object3 = object2 = (AVIMTypedMessage)object2;
                }
                catch (Exception exception) {
                    object5 = LOGGER;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = "failed to create instance for TypedMessage: ";
                    stringBuilder.append(string2);
                    object4 = ((Class)object4).getCanonicalName();
                    stringBuilder.append((String)object4);
                    object4 = ", cause: ";
                    stringBuilder.append((String)object4);
                    object2 = exception.getMessage();
                    stringBuilder.append((String)object2);
                    object2 = stringBuilder.toString();
                    ((AVLogger)object5).e((String)object2);
                }
            } else {
                object3 = LOGGER;
                object4 = new StringBuilder();
                object5 = "unknown message type: ";
                ((StringBuilder)object4).append((String)object5);
                ((StringBuilder)object4).append(n10);
                object4 = ((StringBuilder)object4).toString();
                ((AVLogger)object3).d((String)object4);
                object3 = new AVIMTypedMessage(n10);
            }
            if (object3 != null) {
                object2 = ((AVIMMessage)object).getConversationId();
                ((AVIMMessage)object3).setConversationId((String)object2);
                object2 = ((AVIMMessage)object).getFrom();
                ((AVIMMessage)object3).setFrom((String)object2);
                long l10 = ((AVIMMessage)object).getDeliveredAt();
                ((AVIMMessage)object3).setDeliveredAt(l10);
                l10 = ((AVIMMessage)object).getTimestamp();
                ((AVIMMessage)object3).setTimestamp(l10);
                object2 = ((AVIMMessage)object).getContent();
                ((AVIMTypedMessage)object3).setContent((String)object2);
                object2 = ((AVIMMessage)object).getMessageId();
                ((AVIMMessage)object3).setMessageId((String)object2);
                object2 = ((AVIMMessage)object).getMessageStatus();
                ((AVIMMessage)object3).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object2));
                object2 = ((AVIMMessage)object).getMessageIOType();
                ((AVIMMessage)object3).setMessageIOType((AVIMMessage$AVIMMessageIOType)((Object)object2));
                object2 = ((AVIMMessage)object).uniqueToken;
                ((AVIMMessage)object3).uniqueToken = object2;
                object2 = ((AVIMMessage)object).currentClient;
                ((AVIMMessage)object3).currentClient = object2;
                n10 = (int)(((AVIMMessage)object).mentionAll ? 1 : 0);
                ((AVIMMessage)object3).mentionAll = n10;
                ((AVIMMessage)object3).mentionList = object = ((AVIMMessage)object).mentionList;
                object = object3;
            }
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public static void processMessage(AVIMMessage aVIMMessage, int n10, AVIMClient simpleEntry, boolean bl2, boolean bl3) {
        int n11;
        void var4_6;
        Object object = ((AVIMClient)((Object)simpleEntry)).getStorage();
        boolean bl4 = ((AVIMMessageStorage)object).containMessage(aVIMMessage);
        if (bl4) {
            return;
        }
        if (var4_6 == false && (bl4 = ((AVIMOptions)(object = AVIMOptions.getGlobalOptions())).isMessageQueryCacheEnabled())) {
            object = ((AVIMClient)((Object)simpleEntry)).getStorage();
            ((AVIMMessageStorage)object).insertMessage(aVIMMessage, bl2);
        }
        aVIMMessage = AVIMMessageManager.parseTypedMessage(aVIMMessage);
        aVIMMessage.setTransient((boolean)var4_6);
        Object object2 = aVIMMessage.getConversationId();
        AVIMConversation aVIMConversation = ((AVIMClient)((Object)simpleEntry)).getConversation((String)object2, n10);
        aVIMConversation.setLastMessage(aVIMMessage);
        if (var4_6 == false) {
            n11 = 1;
            boolean bl5 = aVIMMessage.mentioned();
            aVIMConversation.increaseUnreadCount(n11, bl5);
        }
        long l10 = aVIMMessage.getTimestamp();
        simpleEntry = new AbstractMap.SimpleEntry<Object, Boolean>(l10);
        aVIMConversation.setLastMessageAt((Date)((Object)simpleEntry));
        if (var4_6 == false && (simpleEntry = conversationEventHandler) != null && (n11 = (int)(((AVIMOptions)((Object)(simpleEntry = AVIMOptions.getGlobalOptions()))).isOnlyPushCount() ? 1 : 0)) != 0) {
            int n12 = aVIMConversation.getUnreadMessagesCount();
            object2 = n12;
            Boolean bl6 = aVIMMessage.mentioned();
            simpleEntry = new AbstractMap.SimpleEntry<Object, Boolean>(object2, bl6);
            object2 = conversationEventHandler;
            int n13 = 50012;
            ((AVIMEventHandler)object2).processEvent(n13, aVIMMessage, simpleEntry, aVIMConversation);
        }
        AVIMMessageManager.retrieveAllMessageHandlers(aVIMMessage, aVIMConversation, false, null);
    }

    public static void processMessageReceipt(AVIMMessage aVIMMessage, AVIMClient object, String string2) {
        Object object2 = ((AVIMClient)object).getStorage();
        String string3 = aVIMMessage.getMessageId();
        ((AVIMMessageStorage)object2).updateMessage(aVIMMessage, string3);
        aVIMMessage = AVIMMessageManager.parseTypedMessage(aVIMMessage);
        object2 = aVIMMessage.getConversationId();
        object = ((AVIMClient)object).getConversation((String)object2);
        AVIMMessageManager.retrieveAllMessageHandlers(aVIMMessage, (AVIMConversation)object, true, string2);
    }

    public static void registerAVIMMessageType(Class object) {
        Object object2 = ((Class)object).getAnnotation(AVIMMessageType.class);
        if (object2 != null) {
            int n10 = object2.type();
            Object[] objectArray = messageTypesRepository;
            object2 = n10;
            objectArray.put(object2, object);
            object2 = "computeFieldAttribute";
            int n11 = 1;
            Class[] classArray = new Class[n11];
            Class<Class> clazz = Class.class;
            classArray[0] = clazz;
            object2 = ((Class)object).getDeclaredMethod((String)object2, classArray);
            ((Method)object2).setAccessible(n11 != 0);
            classArray = null;
            objectArray = new Object[n11];
            objectArray[0] = object;
            try {
                ((Method)object2).invoke(null, objectArray);
            }
            catch (Exception exception) {
                object = LOGGER;
                object2 = "failed to initialize message Fields";
                ((AVLogger)object).d((String)object2);
            }
            return;
        }
        object = new IncompleteAnnotationException(AVIMMessageType.class, "type");
        throw object;
    }

    public static void registerDefaultMessageHandler(AVIMMessageHandler aVIMMessageHandler) {
        defaultMessageHandler = aVIMMessageHandler;
    }

    public static void registerMessageHandler(Class object, MessageHandler messageHandler) {
        ConcurrentMap concurrentMap = messageHandlerRepository;
        Object object2 = new CopyOnWriteArraySet();
        if ((object = (Set)concurrentMap.putIfAbsent(object, object2)) != null) {
            object2 = object;
        }
        object2.add(messageHandler);
    }

    /*
     * Unable to fully structure code
     */
    private static void retrieveAllMessageHandlers(AVIMMessage var0, AVIMConversation var1_1, boolean var2_2, String var3_3) {
        var4_4 = AVIMMessageManager.messageHandlerRepository.entrySet().iterator();
        var5_5 = false;
        block0: while (true) {
            var6_6 = var4_4.hasNext();
            var7_7 = 50001;
            var8_8 = 50000;
            if (!var6_6) break;
            var9_9 = var4_4.next();
            var10_10 = (Class)var9_9.getKey();
            var12_12 = var10_10.isAssignableFrom(var11_11 = var0.getClass());
            if (var12_12 == 0) continue;
            var12_12 = (var9_9 = (Set)var9_9.getValue()).size();
            if (var12_12 > 0) {
                var5_5 = true;
            }
            var9_9 = var9_9.iterator();
            while (true) {
                if ((var12_12 = (int)var9_9.hasNext()) != 0) ** break;
                continue block0;
                var10_10 = (MessageHandler)var9_9.next();
                if (var2_2) {
                    var10_10.processEvent(var7_7, var3_3, var0, var1_1);
                    continue;
                }
                var10_10.processEvent(var8_8, var3_3, var0, var1_1);
            }
            break;
        }
        if (!var5_5 && (var4_4 = AVIMMessageManager.defaultMessageHandler) != null) {
            if (var2_2) {
                var4_4.processEvent(var7_7, var3_3, var0, var1_1);
            } else {
                var4_4.processEvent(var8_8, var3_3, var0, var1_1);
            }
        }
    }

    public static void setConversationEventHandler(AVIMConversationEventHandler aVIMConversationEventHandler) {
        conversationEventHandler = aVIMConversationEventHandler;
    }

    public static void unregisterMessageHandler(Class object, MessageHandler messageHandler) {
        ConcurrentMap concurrentMap = messageHandlerRepository;
        if ((object = (Set)concurrentMap.get(object)) != null) {
            object.remove(messageHandler);
        }
    }
}

