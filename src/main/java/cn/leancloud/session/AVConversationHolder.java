/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvMemberInfo;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$LogItem;
import cn.leancloud.codec.Base64Decoder;
import cn.leancloud.command.BlacklistCommandPacket;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.ConversationControlPacket;
import cn.leancloud.command.ConversationDirectMessagePacket;
import cn.leancloud.command.ConversationMessageQueryPacket;
import cn.leancloud.command.MessagePatchModifyPacket;
import cn.leancloud.command.UnreadMessagesClearPacket;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.SignatureCallback;
import cn.leancloud.im.SignatureTask;
import cn.leancloud.im.v2.AVIMBinaryMessage;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationEventHandler;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageIOType;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageManagerHelper;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.AVIMMessageQueryDirection;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.im.v2.ConversationSynchronizer;
import cn.leancloud.im.v2.callback.AVIMOperationFailure;
import cn.leancloud.im.v2.conversation.AVIMConversationMemberInfo;
import cn.leancloud.im.v2.conversation.ConversationMemberRole;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVConversationHolder$1;
import cn.leancloud.session.AVConversationHolder$10;
import cn.leancloud.session.AVConversationHolder$11;
import cn.leancloud.session.AVConversationHolder$12;
import cn.leancloud.session.AVConversationHolder$13;
import cn.leancloud.session.AVConversationHolder$14;
import cn.leancloud.session.AVConversationHolder$15;
import cn.leancloud.session.AVConversationHolder$16;
import cn.leancloud.session.AVConversationHolder$17;
import cn.leancloud.session.AVConversationHolder$18;
import cn.leancloud.session.AVConversationHolder$19;
import cn.leancloud.session.AVConversationHolder$2;
import cn.leancloud.session.AVConversationHolder$20;
import cn.leancloud.session.AVConversationHolder$21;
import cn.leancloud.session.AVConversationHolder$22;
import cn.leancloud.session.AVConversationHolder$3;
import cn.leancloud.session.AVConversationHolder$4;
import cn.leancloud.session.AVConversationHolder$5;
import cn.leancloud.session.AVConversationHolder$6;
import cn.leancloud.session.AVConversationHolder$7;
import cn.leancloud.session.AVConversationHolder$8;
import cn.leancloud.session.AVConversationHolder$9;
import cn.leancloud.session.AVConversationHolder$SimpleCallback;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.PendingMessageCache$Message;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.google.protobuf.ProtocolStringList;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AVConversationHolder {
    private static final String BLOCK_MEMBER = "conversation-block-clients";
    private static final String GROUP_INVITE = "invite";
    private static final String GROUP_KICK = "kick";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVConversationHolder.class);
    private static final String UNBLOCK_MEMBER = "conversation-unblock-clients";
    public int convType;
    private String conversationGene = null;
    public String conversationId;
    public AVSession session;

    public AVConversationHolder(String string2, AVSession aVSession, int n10) {
        this.session = aVSession;
        this.conversationId = string2;
        this.conversationGene = string2 = this.getConversationGeneString();
        this.convType = n10;
    }

    private boolean checkSessionStatus(Conversation$AVIMOperation conversation$AVIMOperation, int n10) {
        AVSession$Status aVSession$Status;
        AVSession$Status aVSession$Status2 = this.session.getCurrentStatus();
        if (aVSession$Status2 == (aVSession$Status = AVSession$Status.Closed)) {
            RuntimeException runtimeException = new RuntimeException("Connection Lost");
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string2 = this.session.getSelfPeerId();
            String string3 = this.conversationId;
            operationTube.onOperationCompleted(string2, string3, n10, conversation$AVIMOperation, runtimeException);
            return false;
        }
        return true;
    }

    private HashMap genPartiallyResult(List arrayList, List iterator2) {
        String[] stringArray;
        int n10;
        int n11 = 0;
        Object object = null;
        if (arrayList == null) {
            n10 = 0;
            stringArray = null;
        } else {
            n10 = arrayList.size();
        }
        stringArray = new String[n10];
        if (arrayList != null) {
            arrayList.toArray(stringArray);
        }
        if (iterator2 != null) {
            n11 = iterator2.size();
        }
        arrayList = new ArrayList<AVIMOperationFailure>(n11);
        if (iterator2 != null) {
            iterator2 = iterator2.iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object = (Messages$ErrorCommand)iterator2.next();
                AVIMOperationFailure aVIMOperationFailure = new AVIMOperationFailure();
                int n12 = ((Messages$ErrorCommand)object).getCode();
                aVIMOperationFailure.setCode(n12);
                ProtocolStringList protocolStringList = ((Messages$ErrorCommand)object).getPidsList();
                aVIMOperationFailure.setMemberIds(protocolStringList);
                object = ((Messages$ErrorCommand)object).getReason();
                aVIMOperationFailure.setReason((String)object);
                arrayList.add(aVIMOperationFailure);
            }
        }
        iterator2 = new Iterator();
        ((HashMap)((Object)iterator2)).put("callbackConvMemberPartialSUCC", stringArray);
        ((HashMap)((Object)iterator2)).put("callbackConvMemberPartialFAIL", arrayList);
        return iterator2;
    }

    private String getConversationGeneString() {
        Object object = this.conversationGene;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            object = new HashMap();
            String string2 = this.session.getSelfPeerId();
            ((HashMap)object).put("conversation.client", string2);
            string2 = this.conversationId;
            String string3 = "convesration.id";
            ((HashMap)object).put(string3, string2);
            this.conversationGene = object = JSON.toJSONString(object);
        }
        return this.conversationGene;
    }

    private void mergeServerData(Messages$ConvCommand object) {
        String string2;
        boolean bl2;
        Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
        Object object3 = this.conversationId;
        object2 = ((AVIMClient)object2).getConversation((String)object3);
        object3 = ((Messages$ConvCommand)object).getAttrModified();
        Serializable serializable = ((Messages$ConvCommand)object).getAttr();
        JSONObject jSONObject = null;
        serializable = serializable != null && !(bl2 = StringUtil.isEmpty(string2 = serializable.getData())) ? JSON.parseObject(serializable.getData()) : null;
        if (object3 != null && !(bl2 = StringUtil.isEmpty(string2 = ((Messages$JsonObjectMessage)object3).getData()))) {
            object3 = ((Messages$JsonObjectMessage)object3).getData();
            jSONObject = JSON.parseObject((String)object3);
        }
        ConversationSynchronizer.mergeConversationFromJsonObject((AVIMConversation)object2, jSONObject, (JSONObject)serializable);
        object = ((Messages$ConvCommand)object).getUdate();
        ConversationSynchronizer.changeUpdatedTime((AVIMConversation)object2, (String)object);
    }

    private void onInfoUpdated(int n10, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("callbackUpdatedAt", string2);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string3 = this.session.getSelfPeerId();
        String string4 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UPDATE;
        operationTube.onOperationCompletedEx(string3, string4, n10, conversation$AVIMOperation, hashMap);
    }

    private void onMemberChanged(String string2, Messages$ConvMemberInfo object) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
            Object object3 = this.conversationId;
            AVIMConversation aVIMConversation = ((AVIMClient)object2).getConversation((String)object3);
            object2 = ((Messages$ConvMemberInfo)object).getInfoId();
            object3 = ((Messages$ConvMemberInfo)object).getRole();
            object = ((Messages$ConvMemberInfo)object).getPid();
            String string3 = this.conversationId;
            object3 = ConversationMemberRole.fromString(object3);
            AVIMConversationMemberInfo aVIMConversationMemberInfo = new AVIMConversationMemberInfo((String)object2, string3, (String)object, (ConversationMemberRole)((Object)object3));
            object2 = object;
            object3 = this;
            string3 = string2;
            object = new AVConversationHolder$6(this, aVIMConversationEventHandler, string2, aVIMConversationMemberInfo, aVIMConversation);
            this.refreshConversationThenNotify(aVIMConversation, (AVConversationHolder$SimpleCallback)object);
        }
    }

    private void onMemberUpdated(int n10) {
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_PROMOTE_MEMBER;
        operationTube.onOperationCompleted(string2, string3, n10, conversation$AVIMOperation, null);
    }

    private AVIMConversation parseConversation(AVIMClient object, Messages$ConvCommand object2) {
        if (object != null && object2 != null) {
            boolean bl2 = ((Messages$ConvCommand)object2).hasTempConv();
            boolean bl3 = true;
            int n10 = 0;
            bl2 = bl2 && (bl2 = ((Messages$ConvCommand)object2).getTempConv()) ? bl3 : false;
            boolean bl4 = ((Messages$ConvCommand)object2).hasTransient();
            if (!bl4 || !(bl4 = ((Messages$ConvCommand)object2).getTransient())) {
                bl3 = false;
            }
            bl4 = ((Messages$ConvCommand)object2).hasTempConvTTL();
            if (bl4) {
                n10 = ((Messages$ConvCommand)object2).getTempConvTTL();
            }
            object2 = this.conversationId;
            object = ((AVIMClient)object).getConversation((String)object2, bl3, bl2);
            long l10 = System.currentTimeMillis() / 1000L;
            long l11 = n10;
            ((AVIMConversation)object).setTemporaryExpiredat(l10 += l11);
            return object;
        }
        return null;
    }

    private void read(String object, long l10, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_READ;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        Object object3 = this.session.conversationOperationCache;
        int n11 = object2.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object2 = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object3).offer((AVIMOperationQueue$Operation)object2);
        object3 = this.session.getSelfPeerId();
        string2 = this.conversationId;
        string3 = object;
        object = UnreadMessagesClearPacket.getUnreadClearPacket((String)object3, string2, (String)object, l10, n10);
        this.session.sendPacket((CommandPacket)object);
        this.onUnreadMessagesEvent(null, 0, false);
    }

    private void refreshConversationThenNotify(AVIMConversation aVIMConversation, AVConversationHolder$SimpleCallback aVConversationHolder$SimpleCallback) {
        if (aVIMConversation == null) {
            return;
        }
        boolean bl2 = aVIMConversation.isShouldFetch();
        if (!bl2) {
            aVConversationHolder$SimpleCallback.done();
        } else {
            Object object = LOGGER;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("try to query conversation info for id=");
            Object object3 = aVIMConversation.getConversationId();
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).d((String)object2);
            object = aVIMConversation.getFetchRequestParams();
            object2 = InternalConfiguration.getOperationTube();
            object3 = this.session.getConnectionManager();
            String string2 = this.session.getSelfPeerId();
            object = JSON.toJSONString(object);
            AVConversationHolder$21 aVConversationHolder$21 = new AVConversationHolder$21(this, aVIMConversation, aVConversationHolder$SimpleCallback);
            object2.queryConversationsInternally((AVConnectionManager)object3, string2, (String)object, aVConversationHolder$21);
        }
    }

    private void refreshConversationThenNotify(AVIMMessage object, AVConversationHolder$SimpleCallback aVConversationHolder$SimpleCallback) {
        if (object != null && aVConversationHolder$SimpleCallback != null) {
            AVIMClient aVIMClient = AVIMClient.getInstance(this.session.getSelfPeerId());
            object = ((AVIMMessage)object).getConversationId();
            int n10 = this.convType;
            object = aVIMClient.getConversation((String)object, n10);
            this.refreshConversationThenNotify((AVIMConversation)object, aVConversationHolder$SimpleCallback);
        }
    }

    public void addMembers(List object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        object2 = new AVConversationHolder$1(this, n10, (List)object);
        String string2 = this.session.getSelfPeerId();
        object = new SignatureTask((SignatureCallback)object2, string2);
        ((SignatureTask)object).start();
    }

    public void blockMembers(List object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_BLOCK_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        object2 = new AVConversationHolder$3(this, n10, (List)object);
        String string2 = this.session.getSelfPeerId();
        object = new SignatureTask((SignatureCallback)object2, string2);
        ((SignatureTask)object).start();
    }

    public void getMemberCount(int n10) {
        Object object = Conversation$AVIMOperation.CONVERSATION_MEMBER_COUNT_QUERY;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n10);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n11 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object = this.session;
        object2 = ((AVSession)object).getSelfPeerId();
        string2 = this.conversationId;
        ConversationControlPacket conversationControlPacket = ConversationControlPacket.genConversationCommand((String)object2, string2, null, "count", null, null, n10);
        ((AVSession)object).sendPacket(conversationControlPacket);
    }

    public void getReceiptTime(int n10) {
        Object object = Conversation$AVIMOperation.CONVERSATION_FETCH_RECEIPT_TIME;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n10);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n11 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object = this.session;
        object2 = ((AVSession)object).getSelfPeerId();
        string2 = this.conversationId;
        ConversationControlPacket conversationControlPacket = ConversationControlPacket.genConversationCommand((String)object2, string2, null, "max_read", null, null, n10);
        ((AVSession)object).sendPacket(conversationControlPacket);
    }

    public void join(int n10) {
        AVConversationHolder$5 aVConversationHolder$5 = new AVConversationHolder$5(this, n10);
        String string2 = this.session.getSelfPeerId();
        SignatureTask signatureTask = new SignatureTask(aVConversationHolder$5, string2);
        signatureTask.start();
    }

    public void kickMembers(List object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_RM_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        object2 = new AVConversationHolder$2(this, n10, (List)object);
        String string2 = this.session.getSelfPeerId();
        object = new SignatureTask((SignatureCallback)object2, string2);
        ((SignatureTask)object).start();
    }

    public void mute(int n10) {
        Object object = Conversation$AVIMOperation.CONVERSATION_MUTE;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n10);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n11 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object = this.session;
        object2 = ((AVSession)object).getSelfPeerId();
        string2 = this.conversationId;
        ConversationControlPacket conversationControlPacket = ConversationControlPacket.genConversationCommand((String)object2, string2, null, "mute", null, null, n10);
        ((AVSession)object).sendPacket(conversationControlPacket);
    }

    public void muteMembers(List object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_MUTE_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        Object object3 = this.session.conversationOperationCache;
        int n11 = object2.getCode();
        String string2 = this.session.getSelfPeerId();
        Object object4 = this.conversationId;
        object2 = AVIMOperationQueue$Operation.getOperation(n11, string2, (String)object4, n10);
        ((AVIMOperationQueue)object3).offer((AVIMOperationQueue$Operation)object2);
        object2 = this.session;
        object3 = ((AVSession)object2).getSelfPeerId();
        string2 = this.conversationId;
        object4 = object;
        object = ConversationControlPacket.genConversationCommand((String)object3, string2, (List)object, "add_shutup", null, null, n10);
        ((AVSession)object2).sendPacket((CommandPacket)object);
    }

    /*
     * WARNING - void declaration
     */
    public void onConversationCreated(int n10, Messages$ConvCommand object) {
        void var5_8;
        Object object2 = ((Messages$ConvCommand)object).getCdate();
        String string2 = ((Messages$ConvCommand)object).getCid();
        boolean n11 = ((Messages$ConvCommand)object).hasTempConvTTL();
        if (n11) {
            int n12 = ((Messages$ConvCommand)object).getTempConvTTL();
        } else {
            boolean bl2 = false;
        }
        boolean bl3 = ((Messages$ConvCommand)object).hasUniqueId();
        object = bl3 ? ((Messages$ConvCommand)object).getUniqueId() : null;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object3 = "callbackCreatedAt";
        hashMap.put(object3, object2);
        hashMap.put("callbackconversation", string2);
        object2 = (int)var5_8;
        string2 = "callbackTemporaryTTL";
        hashMap.put(string2, object2);
        boolean bl4 = StringUtil.isEmpty((String)object);
        if (!bl4) {
            object2 = "callbackUniqueId";
            hashMap.put(object2, object);
        }
        object3 = InternalConfiguration.getOperationTube();
        String string3 = this.session.getSelfPeerId();
        String string4 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_CREATION;
        object3.onOperationCompletedEx(string3, string4, n10, conversation$AVIMOperation, hashMap);
    }

    public void onConversationDeliveredAtEvent(long l10) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            AVConversationHolder$20 aVConversationHolder$20;
            Object object = AVIMClient.getInstance(this.session.getSelfPeerId());
            Object object2 = this.conversationId;
            AVIMConversation aVIMConversation = ((AVIMClient)object).getConversation((String)object2);
            object = aVConversationHolder$20;
            object2 = this;
            aVConversationHolder$20 = new AVConversationHolder$20(this, aVIMConversationEventHandler, l10, aVIMConversation);
            this.refreshConversationThenNotify(aVIMConversation, (AVConversationHolder$SimpleCallback)aVConversationHolder$20);
        }
    }

    public void onConversationReadAtEvent(long l10) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            AVConversationHolder$19 aVConversationHolder$19;
            Object object = AVIMClient.getInstance(this.session.getSelfPeerId());
            Object object2 = this.conversationId;
            AVIMConversation aVIMConversation = ((AVIMClient)object).getConversation((String)object2);
            object = aVConversationHolder$19;
            object2 = this;
            aVConversationHolder$19 = new AVConversationHolder$19(this, aVIMConversationEventHandler, l10, aVIMConversation);
            this.refreshConversationThenNotify(aVIMConversation, (AVConversationHolder$SimpleCallback)aVConversationHolder$19);
        }
    }

    public void onHistoryMessageQuery(ArrayList arrayList, int n10, long l10, long l11) {
        HashMap<String, Serializable> hashMap = new HashMap<String, Serializable>();
        hashMap.put("callbackHistoryMessages", arrayList);
        Object object = l10;
        hashMap.put("callbackDeliveredAt", (Serializable)object);
        object = l11;
        hashMap.put("callbackReadAt", (Serializable)object);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
        operationTube.onOperationCompletedEx(string2, string3, n10, conversation$AVIMOperation, hashMap);
        AVSession aVSession = this.session;
        object = this.conversationId;
        aVSession.sendUnreadMessagesAck(arrayList, (String)object);
    }

    public void onInfoChangedNotify(Messages$ConvCommand object) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            String string2;
            boolean bl2;
            Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
            object2 = this.parseConversation((AVIMClient)object2, (Messages$ConvCommand)object);
            String string3 = ((Messages$ConvCommand)object).getInitBy();
            Messages$JsonObjectMessage messages$JsonObjectMessage = ((Messages$ConvCommand)object).getAttrModified();
            Serializable serializable = ((Messages$ConvCommand)object).getAttr();
            object = ((Messages$ConvCommand)object).getUdate();
            ConversationSynchronizer.changeUpdatedTime((AVIMConversation)object2, (String)object);
            object = null;
            serializable = serializable != null && !(bl2 = StringUtil.isEmpty(string2 = serializable.getData())) ? JSON.parseObject(serializable.getData()) : null;
            if (messages$JsonObjectMessage != null && !(bl2 = StringUtil.isEmpty(string2 = messages$JsonObjectMessage.getData()))) {
                object = JSON.parseObject(messages$JsonObjectMessage.getData());
            }
            if (object == null && serializable == null) {
                ((AVIMConversation)object2).setMustFetch();
            } else {
                ConversationSynchronizer.mergeConversationFromJsonObject((AVIMConversation)object2, (JSONObject)object, (JSONObject)serializable);
            }
            int n10 = 50026;
            aVIMConversationEventHandler.processEvent(n10, string3, object, object2);
        }
    }

    public void onInvited(int n10, Messages$ConvCommand object) {
        ProtocolStringList protocolStringList = ((Messages$ConvCommand)object).getAllowedPidsList();
        object = ((Messages$ConvCommand)object).getFailedPidsList();
        AVIMClient aVIMClient = AVIMClient.getInstance(this.session.getSelfPeerId());
        Object object2 = this.conversationId;
        ConversationSynchronizer.mergeMembers(aVIMClient.getConversation((String)object2), protocolStringList);
        HashMap hashMap = this.genPartiallyResult(protocolStringList, (List)object);
        object2 = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER;
        object2.onOperationCompletedEx(string2, string3, n10, conversation$AVIMOperation, hashMap);
    }

    public void onInvitedToConversation(String string2, Messages$ConvCommand object) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
            object = this.parseConversation((AVIMClient)object2, (Messages$ConvCommand)object);
            object2 = new AVConversationHolder$7(this, aVIMConversationEventHandler, string2, (AVIMConversation)object);
            this.refreshConversationThenNotify((AVIMConversation)object, (AVConversationHolder$SimpleCallback)object2);
        }
    }

    public void onJoined(int n10) {
        Object object = AVIMClient.getInstance(this.session.getSelfPeerId());
        Object object2 = this.conversationId;
        object = ((AVIMClient)object).getConversation((String)object2);
        object2 = new String[1];
        Object object3 = this.session.getSelfPeerId();
        object2[0] = object3;
        object2 = Arrays.asList(object2);
        ConversationSynchronizer.mergeMembers((AVIMConversation)object, (List)object2);
        object3 = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_JOIN;
        object3.onOperationCompleted(string2, string3, n10, conversation$AVIMOperation, null);
    }

    public void onKicked(int n10, Messages$ConvCommand object) {
        ProtocolStringList protocolStringList = ((Messages$ConvCommand)object).getAllowedPidsList();
        object = ((Messages$ConvCommand)object).getFailedPidsList();
        AVIMClient aVIMClient = AVIMClient.getInstance(this.session.getSelfPeerId());
        Object object2 = this.conversationId;
        ConversationSynchronizer.removeMembers(aVIMClient.getConversation((String)object2), protocolStringList);
        HashMap hashMap = this.genPartiallyResult(protocolStringList, (List)object);
        object2 = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_RM_MEMBER;
        object2.onOperationCompletedEx(string2, string3, n10, conversation$AVIMOperation, hashMap);
    }

    public void onKickedFromConversation(String object) {
        Object object2 = AVIMMessageManagerHelper.getConversationEventHandler();
        Object object3 = AVIMClient.getInstance(this.session.getSelfPeerId());
        Object object4 = this.conversationId;
        object3 = ((AVIMClient)object3).getConversation((String)object4);
        if (object2 != null) {
            object4 = new AVConversationHolder$8(this, (AVIMConversationEventHandler)object2, (String)object, (AVIMConversation)object3);
            this.refreshConversationThenNotify((AVIMConversation)object3, (AVConversationHolder$SimpleCallback)object4);
        }
        object = this.session;
        object2 = this.conversationId;
        ((AVSession)object).removeConversation((String)object2);
        AVIMMessageManagerHelper.removeConversationCache((AVIMConversation)object3);
    }

    public void onMemberBlockedNotify(boolean bl2, String string2, Messages$ConvCommand object) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        ProtocolStringList protocolStringList = ((Messages$ConvCommand)object).getMList();
        if (aVIMConversationEventHandler != null && protocolStringList != null) {
            AVConversationHolder$12 aVConversationHolder$12;
            Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
            object = this.parseConversation((AVIMClient)object2, (Messages$ConvCommand)object);
            object2 = aVConversationHolder$12;
            aVConversationHolder$12 = new AVConversationHolder$12(this, bl2, aVIMConversationEventHandler, string2, protocolStringList, (AVIMConversation)object);
            this.refreshConversationThenNotify((AVIMConversation)object, (AVConversationHolder$SimpleCallback)aVConversationHolder$12);
        }
    }

    public void onMemberCount(int n10, int n11) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Integer n12 = n10;
        hashMap.put("callbackMemberCount", n12);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MEMBER_COUNT_QUERY;
        operationTube.onOperationCompletedEx(string2, string3, n11, conversation$AVIMOperation, hashMap);
    }

    public void onMemberShutupedNotify(boolean bl2, String string2, Messages$ConvCommand object) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        Object object2 = ((Messages$ConvCommand)object).getMList();
        if (aVIMConversationEventHandler != null && object2 != null) {
            ArrayList arrayList = new ArrayList(object2);
            object2 = this.session.getSelfPeerId();
            arrayList.remove(object2);
            int n10 = arrayList.size();
            int n11 = 1;
            if (n10 < n11) {
                AVLogger aVLogger = LOGGER;
                string2 = "Notification --- ignore shutuped/unshutuped notify bcz duplicated.";
                aVLogger.d(string2);
            } else {
                AVConversationHolder$10 aVConversationHolder$10;
                object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
                object = this.parseConversation((AVIMClient)object2, (Messages$ConvCommand)object);
                object2 = aVConversationHolder$10;
                aVConversationHolder$10 = new AVConversationHolder$10(this, bl2, aVIMConversationEventHandler, string2, arrayList, (AVIMConversation)object);
                this.refreshConversationThenNotify((AVIMConversation)object, (AVConversationHolder$SimpleCallback)aVConversationHolder$10);
            }
        }
    }

    public void onMembersJoined(List list, String string2) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            AVConversationHolder$13 aVConversationHolder$13;
            Object object = AVIMClient.getInstance(this.session.getSelfPeerId());
            Object object2 = this.conversationId;
            AVIMConversation aVIMConversation = ((AVIMClient)object).getConversation((String)object2);
            ConversationSynchronizer.mergeMembers(aVIMConversation, list);
            object = aVConversationHolder$13;
            object2 = this;
            aVConversationHolder$13 = new AVConversationHolder$13(this, aVIMConversationEventHandler, string2, list, aVIMConversation);
            this.refreshConversationThenNotify(aVIMConversation, (AVConversationHolder$SimpleCallback)aVConversationHolder$13);
        }
    }

    public void onMembersLeft(List list, String string2) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            AVConversationHolder$14 aVConversationHolder$14;
            Object object = AVIMClient.getInstance(this.session.getSelfPeerId());
            Object object2 = this.conversationId;
            AVIMConversation aVIMConversation = ((AVIMClient)object).getConversation((String)object2);
            ConversationSynchronizer.removeMembers(aVIMConversation, list);
            object = aVConversationHolder$14;
            object2 = this;
            aVConversationHolder$14 = new AVConversationHolder$14(this, aVIMConversationEventHandler, string2, list, aVIMConversation);
            this.refreshConversationThenNotify(aVIMConversation, (AVConversationHolder$SimpleCallback)aVConversationHolder$14);
        }
    }

    public void onMessage(AVIMMessage aVIMMessage, boolean bl2, boolean bl3) {
        Object object = AVIMMessage$AVIMMessageIOType.AVIMMessageIOTypeIn;
        aVIMMessage.setMessageIOType((AVIMMessage$AVIMMessageIOType)((Object)object));
        object = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusSent;
        aVIMMessage.setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object));
        AVIMClient aVIMClient = AVIMClient.getInstance(this.session.getSelfPeerId());
        object = new AVConversationHolder$17(this, aVIMMessage, aVIMClient, bl2, bl3);
        this.refreshConversationThenNotify(aVIMMessage, (AVConversationHolder$SimpleCallback)object);
    }

    public void onMessageReceipt(AVIMMessage aVIMMessage, String string2) {
        AVConversationHolder$16 aVConversationHolder$16 = new AVConversationHolder$16(this, aVIMMessage, string2);
        this.refreshConversationThenNotify(aVIMMessage, (AVConversationHolder$SimpleCallback)aVConversationHolder$16);
    }

    public void onMessageSent(int n10, String string2, long l10) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put("callbackMessageTimeStamp", l11);
        hashMap.put("callbackMessageId", string2);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string3 = this.session.getSelfPeerId();
        String string4 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_SEND_MESSAGE;
        operationTube.onOperationCompletedEx(string3, string4, n10, conversation$AVIMOperation, hashMap);
    }

    public void onMessageUpdateEvent(AVIMMessage aVIMMessage, boolean bl2, long l10, String string2) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            Object object = AVIMClient.getInstance(this.session.getSelfPeerId());
            Object object2 = this.conversationId;
            object = ((AVIMClient)object).getConversation((String)object2);
            object2 = new AVConversationHolder$18(this, bl2, aVIMConversationEventHandler, aVIMMessage, (AVIMConversation)object);
            this.refreshConversationThenNotify((AVIMConversation)object, (AVConversationHolder$SimpleCallback)object2);
        }
    }

    public void onMuted(int n10) {
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTE;
        operationTube.onOperationCompleted(string2, string3, n10, conversation$AVIMOperation, null);
    }

    public void onQuit(int n10) {
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_QUIT;
        operationTube.onOperationCompleted(string2, string3, n10, conversation$AVIMOperation, null);
    }

    public void onResponse4MemberBlock(Conversation$AVIMOperation conversation$AVIMOperation, String object, int n10, Messages$BlacklistCommand messages$BlacklistCommand) {
        if (messages$BlacklistCommand == null) {
            return;
        }
        object = messages$BlacklistCommand.getAllowedPidsList();
        List list = messages$BlacklistCommand.getFailedPidsList();
        HashMap hashMap = this.genPartiallyResult((List)object, list);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = messages$BlacklistCommand.getSrcCid();
        operationTube.onOperationCompletedEx(string2, string3, n10, conversation$AVIMOperation, hashMap);
    }

    public void onResponse4MemberMute(Conversation$AVIMOperation conversation$AVIMOperation, String object, int n10, Messages$ConvCommand object2) {
        if (object2 == null) {
            return;
        }
        object = ((Messages$ConvCommand)object2).getAllowedPidsList();
        object2 = ((Messages$ConvCommand)object2).getFailedPidsList();
        HashMap hashMap = this.genPartiallyResult((List)object, (List)object2);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        operationTube.onOperationCompletedEx(string2, string3, n10, conversation$AVIMOperation, hashMap);
    }

    public void onSelfBlockedNotify(boolean bl2, String string2, Messages$ConvCommand object) {
        AVConversationHolder$11 aVConversationHolder$11;
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler == null) {
            return;
        }
        Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
        object = this.parseConversation((AVIMClient)object2, (Messages$ConvCommand)object);
        object2 = aVConversationHolder$11;
        aVConversationHolder$11 = new AVConversationHolder$11(this, bl2, aVIMConversationEventHandler, string2, (AVIMConversation)object);
        this.refreshConversationThenNotify((AVIMConversation)object, (AVConversationHolder$SimpleCallback)aVConversationHolder$11);
    }

    public void onSelfShutupedNotify(boolean bl2, String string2, Messages$ConvCommand object) {
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null) {
            AVConversationHolder$9 aVConversationHolder$9;
            Object object2 = AVIMClient.getInstance(this.session.getSelfPeerId());
            object = this.parseConversation((AVIMClient)object2, (Messages$ConvCommand)object);
            object2 = aVConversationHolder$9;
            aVConversationHolder$9 = new AVConversationHolder$9(this, bl2, aVIMConversationEventHandler, string2, (AVIMConversation)object);
            this.refreshConversationThenNotify((AVIMConversation)object, (AVConversationHolder$SimpleCallback)aVConversationHolder$9);
        }
    }

    public void onTimesReceipt(int n10, long l10, long l11) {
        HashMap<String, Long> hashMap = new HashMap<String, Long>();
        Long l12 = l11;
        hashMap.put("callbackReadAt", l12);
        Long l13 = l10;
        hashMap.put("callbackDeliveredAt", l13);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_FETCH_RECEIPT_TIME;
        operationTube.onOperationCompletedEx(string2, string3, n10, conversation$AVIMOperation, hashMap);
    }

    public void onUnmuted(int n10) {
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNMUTE;
        operationTube.onOperationCompleted(string2, string3, n10, conversation$AVIMOperation, null);
    }

    public void onUnreadMessagesEvent(AVIMMessage object, int n10, boolean bl2) {
        Object object2;
        Object object3;
        AVIMConversation aVIMConversation;
        int n11;
        AVIMConversationEventHandler aVIMConversationEventHandler = AVIMMessageManagerHelper.getConversationEventHandler();
        if (aVIMConversationEventHandler != null && (n11 = (aVIMConversation = ((AVIMClient)(object3 = AVIMClient.getInstance(this.session.getSelfPeerId()))).getConversation((String)(object2 = this.conversationId))).getUnreadMessagesCount()) != n10) {
            Object object4 = n10;
            Boolean bl3 = bl2;
            AbstractMap.SimpleEntry<Integer, Boolean> simpleEntry = new AbstractMap.SimpleEntry<Integer, Boolean>((Integer)object4, bl3);
            if (object != null) {
                object4 = AVIMMessage$AVIMMessageIOType.AVIMMessageIOTypeIn;
                ((AVIMMessage)object).setMessageIOType((AVIMMessage$AVIMMessageIOType)((Object)object4));
                object4 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusSent;
                ((AVIMMessage)object).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object4));
                object = AVIMMessageManagerHelper.parseTypedMessage((AVIMMessage)object);
            }
            AVIMMessage aVIMMessage = object;
            object3 = object;
            object2 = this;
            object = new AVConversationHolder$15(this, aVIMConversationEventHandler, aVIMMessage, simpleEntry, aVIMConversation);
            this.refreshConversationThenNotify(aVIMConversation, (AVConversationHolder$SimpleCallback)object);
        }
    }

    public void patchMessage(AVIMMessage object, AVIMMessage object2, AVIMMessage object3, Conversation$AVIMOperation conversation$AVIMOperation, int n10) {
        boolean bl2 = this.checkSessionStatus(conversation$AVIMOperation, n10);
        if (!bl2) {
            return;
        }
        Object object4 = this.session.conversationOperationCache;
        int n11 = conversation$AVIMOperation.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        Object object5 = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        object4.offer((AVIMOperationQueue$Operation)object5);
        object4 = Conversation$AVIMOperation.CONVERSATION_RECALL_MESSAGE;
        bl2 = conversation$AVIMOperation.equals(object4);
        if (bl2) {
            string3 = object3.getMessageId();
            long l10 = object3.getTimestamp();
            object = this.session;
            object5 = ((AVSession)object).getSelfPeerId();
            string2 = this.conversationId;
            object2 = MessagePatchModifyPacket.getMessagePatchPacketForRecall((String)object5, string2, string3, l10, n10);
            ((AVSession)object).sendPacket((CommandPacket)object2);
        } else {
            object3 = Conversation$AVIMOperation.CONVERSATION_UPDATE_MESSAGE;
            boolean bl3 = conversation$AVIMOperation.equals(object3);
            if (bl3) {
                string2 = ((AVIMMessage)object).getMessageId();
                long l11 = ((AVIMMessage)object).getTimestamp();
                string3 = ((AVIMMessage)object2).getContent();
                boolean bl4 = ((AVIMMessage)object2).isMentionAll();
                List list = ((AVIMMessage)object2).getMentionList();
                object = null;
                bl3 = object2 instanceof AVIMBinaryMessage;
                if (bl3) {
                    object2 = (AVIMBinaryMessage)object2;
                    object = ((AVIMBinaryMessage)object2).getBytes();
                }
                Object object6 = object;
                object = this.session;
                object4 = ((AVSession)object).getSelfPeerId();
                object5 = this.conversationId;
                object2 = MessagePatchModifyPacket.getMessagePatchPacketForUpdate((String)object4, (String)object5, string2, string3, (byte[])object6, bl4, list, l11, n10);
                ((AVSession)object).sendPacket((CommandPacket)object2);
            }
        }
    }

    public void processConversationCommandFromClient(Conversation$AVIMOperation conversation$AVIMOperation, Map map, int n10) {
        AVConversationHolder aVConversationHolder = this;
        Object object = map;
        int n11 = n10;
        int n12 = 0;
        Object object2 = null;
        Object object3 = map != null ? (List)map.get("conversation.member") : null;
        int[] nArray = AVConversationHolder$22.$SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
        int bl2 = conversation$AVIMOperation.ordinal();
        int n13 = nArray[bl2];
        Object object4 = "skip";
        String string2 = "ts";
        String string3 = "mid";
        String string4 = "limit";
        switch (n13) {
            default: {
                break;
            }
            case 18: {
                object2 = (String)object.get(string3);
                object3 = (Number)object.get(string2);
                long l10 = ((Number)object3).longValue();
                object4 = (Boolean)object.get("sinc");
                boolean bl3 = (Boolean)object4;
                string2 = (String)object.get("tmid");
                long l11 = ((Number)object.get("tt")).longValue();
                int n14 = ((Boolean)object.get("tinc")).booleanValue();
                int n15 = (Integer)object.get("direct");
                int n16 = (Integer)object.get(string4);
                string3 = "type";
                int n17 = (Integer)object.get(string3);
                object = this;
                boolean bl4 = n14;
                int n18 = n15;
                n14 = n16;
                n15 = n17;
                n11 = n10;
                this.queryHistoryMessages((String)object2, l10, bl3, string2, l11, bl4, n18, n16, n17, n10);
                break;
            }
            case 17: {
                object2 = (Integer)object.get(object4);
                n12 = (Integer)object2;
                object = (Integer)object.get(string4);
                int n19 = (Integer)object;
                aVConversationHolder.queryBlockedMembers(n12, n19, n11);
                break;
            }
            case 16: {
                object2 = (Integer)object.get(object4);
                n12 = (Integer)object2;
                object = (Integer)object.get(string4);
                int n20 = (Integer)object;
                aVConversationHolder.queryMutedMembers(n12, n20, n11);
                break;
            }
            case 15: {
                aVConversationHolder.unblockMembers((List)object3, n11);
                break;
            }
            case 14: {
                aVConversationHolder.blockMembers((List)object3, n11);
                break;
            }
            case 13: {
                aVConversationHolder.unmuteMembers((List)object3, n11);
                break;
            }
            case 12: {
                aVConversationHolder.muteMembers((List)object3, n11);
                break;
            }
            case 11: {
                if (object != null) {
                    object2 = object = object.get("conversation.memberDetails");
                    object2 = object;
                }
                if (object2 == null) break;
                aVConversationHolder.promoteMember((Map)object2, n11);
                break;
            }
            case 10: {
                boolean bl5;
                object2 = object != null && (n12 = object.containsKey(string3)) != 0 ? (String)object.get(string3) : "";
                long l12 = 0L;
                if (object != null && (bl5 = object.containsKey(string2))) {
                    object = (Number)object.get(string2);
                    l12 = ((Number)object).longValue();
                }
                aVConversationHolder.read((String)object2, l12, n11);
                break;
            }
            case 9: {
                aVConversationHolder.getReceiptTime(n11);
                break;
            }
            case 8: {
                aVConversationHolder.getMemberCount(n11);
                break;
            }
            case 7: {
                aVConversationHolder.unmute(n11);
                break;
            }
            case 6: {
                aVConversationHolder.mute(n11);
                break;
            }
            case 5: {
                object2 = "conversation.attributes";
                object = (Map)object.get(object2);
                aVConversationHolder.updateInfo((Map)object, n11);
                break;
            }
            case 4: {
                aVConversationHolder.quit(n11);
                break;
            }
            case 3: {
                aVConversationHolder.kickMembers((List)object3, n11);
                break;
            }
            case 2: {
                aVConversationHolder.addMembers((List)object3, n11);
                break;
            }
            case 1: {
                aVConversationHolder.join(n11);
            }
        }
    }

    public void processConversationCommandFromServer(Conversation$AVIMOperation object, String object2, int n10, Messages$ConvCommand object3) {
        Object object4 = "started";
        boolean n11 = ((String)object4).equals(object2);
        if (n11) {
            this.onConversationCreated(n10, (Messages$ConvCommand)object3);
        } else {
            object4 = "joined";
            boolean bl2 = ((String)object4).equals(object2);
            if (bl2) {
                object = ((Messages$ConvCommand)object3).getInitBy();
                this.onInvitedToConversation((String)object, (Messages$ConvCommand)object3);
            } else {
                object4 = "removed";
                boolean bl3 = ((String)object4).equals(object2);
                int n12 = -65537;
                if (bl3) {
                    if (n10 != n12) {
                        if (object == null) {
                            object = LOGGER;
                            StringBuilder stringBuilder = new StringBuilder();
                            object3 = "IllegalState. operation is null, excepted is QUIT / KICK, originalOp=";
                            stringBuilder.append((String)object3);
                            stringBuilder.append((String)object2);
                            object2 = stringBuilder.toString();
                            ((AVLogger)object).e((String)object2);
                        } else {
                            int n13;
                            int n14 = ((Conversation$AVIMOperation)((Object)object)).getCode();
                            if (n14 == (n13 = ((Conversation$AVIMOperation)((Object)(object4 = Conversation$AVIMOperation.CONVERSATION_QUIT))).getCode())) {
                                this.onQuit(n10);
                            } else {
                                int n15 = ((Conversation$AVIMOperation)((Object)object)).getCode();
                                if (n15 == (n14 = ((Conversation$AVIMOperation)((Object)(object2 = Conversation$AVIMOperation.CONVERSATION_RM_MEMBER))).getCode())) {
                                    this.onKicked(n10, (Messages$ConvCommand)object3);
                                }
                            }
                        }
                    }
                } else {
                    object4 = "added";
                    boolean bl4 = ((String)object4).equals(object2);
                    if (bl4) {
                        if (n10 != n12) {
                            if (object == null) {
                                object = LOGGER;
                                StringBuilder stringBuilder = new StringBuilder();
                                object3 = "IllegalState. operation is null, excepted is JOIN / INVITE, originalOp=";
                                stringBuilder.append((String)object3);
                                stringBuilder.append((String)object2);
                                object2 = stringBuilder.toString();
                                ((AVLogger)object).e((String)object2);
                            } else {
                                int n16;
                                int n17 = ((Conversation$AVIMOperation)((Object)object)).getCode();
                                if (n17 == (n16 = ((Conversation$AVIMOperation)((Object)(object4 = Conversation$AVIMOperation.CONVERSATION_JOIN))).getCode())) {
                                    this.onJoined(n10);
                                } else {
                                    int n18 = ((Conversation$AVIMOperation)((Object)object)).getCode();
                                    if (n18 == (n17 = ((Conversation$AVIMOperation)((Object)(object2 = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER))).getCode())) {
                                        this.onInvited(n10, (Messages$ConvCommand)object3);
                                    }
                                }
                            }
                        }
                    } else {
                        object4 = "left";
                        boolean bl5 = ((String)object4).equals(object2);
                        if (bl5) {
                            object = ((Messages$ConvCommand)object3).getInitBy();
                            if (object != null) {
                                this.onKickedFromConversation((String)object);
                            }
                        } else {
                            object4 = "updated";
                            boolean bl6 = ((String)object4).equals(object2);
                            if (bl6) {
                                if (object == null) {
                                    this.onInfoChangedNotify((Messages$ConvCommand)object3);
                                } else {
                                    this.mergeServerData((Messages$ConvCommand)object3);
                                    object2 = Conversation$AVIMOperation.CONVERSATION_MUTE;
                                    int n19 = ((Conversation$AVIMOperation)((Object)object2)).getCode();
                                    int n20 = ((Conversation$AVIMOperation)((Object)object)).getCode();
                                    if (n19 == n20) {
                                        this.onMuted(n10);
                                    } else {
                                        int n21;
                                        object2 = Conversation$AVIMOperation.CONVERSATION_UNMUTE;
                                        n19 = ((Conversation$AVIMOperation)((Object)object2)).getCode();
                                        if (n19 == (n21 = ((Conversation$AVIMOperation)((Object)object)).getCode())) {
                                            this.onUnmuted(n10);
                                        } else {
                                            int n22;
                                            object2 = Conversation$AVIMOperation.CONVERSATION_UPDATE;
                                            n19 = ((Conversation$AVIMOperation)((Object)object2)).getCode();
                                            if (n19 == (n22 = ((Conversation$AVIMOperation)((Object)object)).getCode())) {
                                                object = ((Messages$ConvCommand)object3).getUdate();
                                                this.onInfoUpdated(n10, (String)object);
                                            }
                                        }
                                    }
                                }
                            } else {
                                object4 = "result";
                                boolean bl7 = ((String)object4).equals(object2);
                                if (bl7) {
                                    int n23 = ((Messages$ConvCommand)object3).getCount();
                                    this.onMemberCount(n23, n10);
                                } else {
                                    object4 = "max_read";
                                    boolean bl8 = ((String)object4).equals(object2);
                                    if (bl8) {
                                        long l10 = ((Messages$ConvCommand)object3).getMaxAckTimestamp();
                                        long l11 = ((Messages$ConvCommand)object3).getMaxReadTimestamp();
                                        this.onTimesReceipt(n10, l10, l11);
                                    } else {
                                        object4 = "member_info_updated";
                                        boolean bl9 = ((String)object4).equals(object2);
                                        if (bl9) {
                                            this.onMemberUpdated(n10);
                                        } else {
                                            boolean bl10;
                                            object4 = "shutup_added";
                                            boolean bl11 = ((String)object4).equals(object2);
                                            if (!bl11 && !(bl10 = ((String)(object4 = "shutup_removed")).equals(object2))) {
                                                object = "members_joined";
                                                boolean bl12 = ((String)object).equals(object2);
                                                if (bl12) {
                                                    object = ((Messages$ConvCommand)object3).getInitBy();
                                                    object2 = ((Messages$ConvCommand)object3).getMList();
                                                    this.onMembersJoined((List)object2, (String)object);
                                                } else {
                                                    object = "members_left";
                                                    bl12 = ((String)object).equals(object2);
                                                    if (bl12) {
                                                        object = ((Messages$ConvCommand)object3).getInitBy();
                                                        object2 = ((Messages$ConvCommand)object3).getMList();
                                                        this.onMembersLeft((List)object2, (String)object);
                                                    } else {
                                                        object = "member_info_changed";
                                                        bl12 = ((String)object).equals(object2);
                                                        if (bl12) {
                                                            object = ((Messages$ConvCommand)object3).getInitBy();
                                                            object2 = ((Messages$ConvCommand)object3).getInfo();
                                                            this.onMemberChanged((String)object, (Messages$ConvMemberInfo)object2);
                                                        } else {
                                                            String string2;
                                                            object = "shutuped";
                                                            n10 = (int)(((String)object).equals(object2) ? 1 : 0);
                                                            if (n10 == 0 && (n10 = (int)((string2 = "unshutuped").equals(object2) ? 1 : 0)) == 0) {
                                                                object = "members_shutuped";
                                                                n10 = (int)(((String)object).equals(object2) ? 1 : 0);
                                                                if (n10 == 0 && (n10 = (int)((string2 = "members_unshutuped").equals(object2) ? 1 : 0)) == 0) {
                                                                    object = "blocked";
                                                                    n10 = (int)(((String)object).equals(object2) ? 1 : 0);
                                                                    if (n10 == 0 && (n10 = (int)((string2 = "unblocked").equals(object2) ? 1 : 0)) == 0) {
                                                                        object = "members_blocked";
                                                                        n10 = (int)(((String)object).equals(object2) ? 1 : 0);
                                                                        if (n10 != 0 || (n10 = (int)((string2 = "members_unblocked").equals(object2) ? 1 : 0)) != 0) {
                                                                            string2 = ((Messages$ConvCommand)object3).getInitBy();
                                                                            bl12 = ((String)object).equals(object2);
                                                                            this.onMemberBlockedNotify(bl12, string2, (Messages$ConvCommand)object3);
                                                                        }
                                                                    } else {
                                                                        string2 = ((Messages$ConvCommand)object3).getInitBy();
                                                                        bl12 = ((String)object).equals(object2);
                                                                        this.onSelfBlockedNotify(bl12, string2, (Messages$ConvCommand)object3);
                                                                    }
                                                                } else {
                                                                    string2 = ((Messages$ConvCommand)object3).getInitBy();
                                                                    bl12 = ((String)object).equals(object2);
                                                                    this.onMemberShutupedNotify(bl12, string2, (Messages$ConvCommand)object3);
                                                                }
                                                            } else {
                                                                string2 = ((Messages$ConvCommand)object3).getInitBy();
                                                                bl12 = ((String)object).equals(object2);
                                                                this.onSelfShutupedNotify(bl12, string2, (Messages$ConvCommand)object3);
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (object == null) {
                                                object = LOGGER;
                                                StringBuilder stringBuilder = new StringBuilder();
                                                object3 = "IllegalState. operation is null, excepted is member_shutupped / member_unshutuped, originalOp=";
                                                stringBuilder.append((String)object3);
                                                stringBuilder.append((String)object2);
                                                object2 = stringBuilder.toString();
                                                ((AVLogger)object).e((String)object2);
                                            } else {
                                                this.onResponse4MemberMute((Conversation$AVIMOperation)((Object)object), (String)object2, n10, (Messages$ConvCommand)object3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void processMessages(Integer n10, List list) {
        boolean bl2;
        AVConversationHolder aVConversationHolder = this;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = list.iterator();
        long l10 = -1;
        long l11 = -1;
        while (bl2 = object.hasNext()) {
            AVIMMessage aVIMMessage;
            String string2;
            long l12;
            Messages$LogItem messages$LogItem = (Messages$LogItem)object.next();
            Object object2 = messages$LogItem.hasAckAt();
            long l13 = object2 != 0 ? (long)-1 : (l12 = messages$LogItem.getAckAt());
            object2 = messages$LogItem.hasReadAt();
            long l14 = object2 != 0 ? (long)-1 : (l12 = messages$LogItem.getReadAt());
            object2 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            if (object2 < 0) {
                l10 = l13;
            }
            if ((object2 = (Object)(l11 == l14 ? 0 : (l11 < l14 ? -1 : 1))) < 0) {
                l11 = l14;
            }
            String string3 = messages$LogItem.getFrom();
            Object object3 = messages$LogItem.getData();
            long l15 = messages$LogItem.getTimestamp();
            String string4 = messages$LogItem.getMsgId();
            boolean bl3 = messages$LogItem.hasMentionAll();
            boolean bl4 = true;
            float f10 = Float.MIN_VALUE;
            bl3 = bl3 && (bl3 = messages$LogItem.getMentionAll()) ? bl4 : false;
            Object object4 = messages$LogItem.getMentionPidsList();
            boolean bl5 = messages$LogItem.hasBin();
            if (!bl5 || !(bl5 = messages$LogItem.getBin())) {
                bl4 = false;
                string2 = null;
                f10 = 0.0f;
            }
            if (bl4 && object3 != null) {
                string2 = aVConversationHolder.conversationId;
                bl2 = bl3;
                aVIMMessage = new AVIMBinaryMessage(string2, string3, l15, l13, l14);
                object3 = Base64Decoder.decodeToBytes((String)object3);
                ((AVIMBinaryMessage)aVIMMessage).setBytes((byte[])object3);
            } else {
                bl2 = bl3;
                string2 = aVConversationHolder.conversationId;
                aVIMMessage = new AVIMMessage(string2, string3, l15, l13, l14);
                aVIMMessage.setContent((String)object3);
            }
            aVIMMessage.setMessageId(string4);
            aVIMMessage.setMentionAll(bl2);
            aVIMMessage.setMentionList((List)object4);
            object4 = AVIMMessageManagerHelper.parseTypedMessage(aVIMMessage);
            arrayList.add(object4);
        }
        int n11 = n10;
        object = this;
        this.onHistoryMessageQuery(arrayList, n11, l10, l11);
    }

    public void promoteMember(Map object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_PROMOTE_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        Object object3 = this.session.conversationOperationCache;
        int n11 = object2.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object2 = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object3).offer((AVIMOperationQueue$Operation)object2);
        object3 = this.session.getSelfPeerId();
        string2 = this.conversationId;
        object = ConversationControlPacket.genConversationMemberCommand((String)object3, string2, "member_info_update", (Map)object, null, n10);
        this.session.sendPacket((CommandPacket)object);
    }

    public void queryBlockedMembers(int n10, int n11, int n12) {
        Object object = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n12);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n13 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n13, string2, string3, n12);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object2 = this.session.getSelfPeerId();
        string2 = this.conversationId;
        BlacklistCommandPacket blacklistCommandPacket = BlacklistCommandPacket.genBlacklistCommandPacket((String)object2, string2, "query", n10, n11, n12);
        this.session.sendPacket(blacklistCommandPacket);
    }

    public void queryHistoryMessages(String string2, long l10, int n10, String string3, long l11, int n11) {
        int n12 = AVIMMessageQueryDirection.AVIMMessageQueryDirectionFromNewToOld.getCode();
        this.queryHistoryMessages(string2, l10, false, string3, l11, false, n12, n10, 0, n11);
    }

    public void queryHistoryMessages(String string2, long l10, boolean bl2, String string3, long l11, boolean bl3, int n10, int n11, int n12, int n13) {
        Object object = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
        boolean bl4 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n13);
        if (!bl4) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n14 = object.getCode();
        String string4 = this.session.getSelfPeerId();
        String string5 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n14, string4, string5, n13);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        AVSession aVSession = this.session;
        object = aVSession.getSelfPeerId();
        object2 = this.conversationId;
        string4 = string2;
        object = ConversationMessageQueryPacket.getConversationMessageQueryPacket((String)object, (String)object2, string2, l10, bl2, string3, l11, bl3, n10, n11, n12, n13);
        aVSession.sendPacket((CommandPacket)object);
    }

    public void queryMutedMembers(int n10, int n11, int n12) {
        Object object = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n12);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n13 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n13, string2, string3, n12);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object2 = this.session.getSelfPeerId();
        string2 = this.conversationId;
        ConversationControlPacket conversationControlPacket = ConversationControlPacket.genConversationCommand((String)object2, string2, null, "query_shutup", null, null, n12);
        conversationControlPacket.setQueryOffset(n10);
        conversationControlPacket.setQueryLimit(n11);
        this.session.sendPacket(conversationControlPacket);
    }

    public void quit(int n10) {
        Object object = Conversation$AVIMOperation.CONVERSATION_QUIT;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n10);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n11 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        Object object3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n11, string2, (String)object3, n10);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object = this.session;
        object2 = ((AVSession)object).getSelfPeerId();
        string2 = this.conversationId;
        String string3 = this.session.getSelfPeerId();
        object3 = new String[]{string3};
        object3 = Arrays.asList(object3);
        ConversationControlPacket conversationControlPacket = ConversationControlPacket.genConversationCommand((String)object2, string2, (List)object3, "remove", null, null, n10);
        ((AVSession)object).sendPacket(conversationControlPacket);
    }

    public void sendMessage(AVIMMessage object, int n10, AVIMMessageOption aVIMMessageOption) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_SEND_MESSAGE;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        bl2 = false;
        object2 = null;
        boolean bl3 = object instanceof AVIMBinaryMessage;
        if (bl3) {
            object2 = object;
            object2 = ((AVIMBinaryMessage)object).getBytes();
        }
        Conversation$AVIMOperation conversation$AVIMOperation = object2;
        object2 = this.session;
        Object object3 = ((AVIMMessage)object).getContent();
        String string2 = String.valueOf(n10);
        boolean bl4 = aVIMMessageOption.isReceipt();
        String string3 = this.conversationId;
        object3 = PendingMessageCache$Message.getMessage((String)object3, string2, bl4, string3);
        ((AVSession)object2).storeMessage((PendingMessageCache$Message)object3, n10);
        object2 = this.session;
        object3 = ((AVSession)object2).getSelfPeerId();
        string2 = this.conversationId;
        String string4 = ((AVIMMessage)object).getContent();
        boolean bl5 = ((AVIMMessage)object).isMentionAll();
        List list = ((AVIMMessage)object).getMentionList();
        String string5 = AVIMMessageManagerHelper.getMessageToken((AVIMMessage)object);
        object = ConversationDirectMessagePacket.getConversationMessagePacket((String)object3, string2, string4, (byte[])conversation$AVIMOperation, bl5, list, string5, aVIMMessageOption, n10);
        ((AVSession)object2).sendPacket((CommandPacket)object);
    }

    public void unblockMembers(List object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_UNBLOCK_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        object2 = new AVConversationHolder$4(this, n10, (List)object);
        String string2 = this.session.getSelfPeerId();
        object = new SignatureTask((SignatureCallback)object2, string2);
        ((SignatureTask)object).start();
    }

    public void unmute(int n10) {
        Object object = Conversation$AVIMOperation.CONVERSATION_UNMUTE;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object), n10);
        if (!bl2) {
            return;
        }
        Object object2 = this.session.conversationOperationCache;
        int n11 = object.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
        object = this.session;
        object2 = ((AVSession)object).getSelfPeerId();
        string2 = this.conversationId;
        ConversationControlPacket conversationControlPacket = ConversationControlPacket.genConversationCommand((String)object2, string2, null, "unmute", null, null, n10);
        ((AVSession)object).sendPacket(conversationControlPacket);
    }

    public void unmuteMembers(List object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_UNMUTE_MEMBER;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        Object object3 = this.session.conversationOperationCache;
        int n11 = object2.getCode();
        String string2 = this.session.getSelfPeerId();
        Object object4 = this.conversationId;
        object2 = AVIMOperationQueue$Operation.getOperation(n11, string2, (String)object4, n10);
        ((AVIMOperationQueue)object3).offer((AVIMOperationQueue$Operation)object2);
        object2 = this.session;
        object3 = ((AVSession)object2).getSelfPeerId();
        string2 = this.conversationId;
        object4 = object;
        object = ConversationControlPacket.genConversationCommand((String)object3, string2, (List)object, "remove_shutup", null, null, n10);
        ((AVSession)object2).sendPacket((CommandPacket)object);
    }

    public void updateInfo(Map object, int n10) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_UPDATE;
        boolean bl2 = this.checkSessionStatus((Conversation$AVIMOperation)((Object)object2), n10);
        if (!bl2) {
            return;
        }
        Object object3 = this.session.conversationOperationCache;
        int n11 = object2.getCode();
        String string2 = this.session.getSelfPeerId();
        String string3 = this.conversationId;
        object2 = AVIMOperationQueue$Operation.getOperation(n11, string2, string3, n10);
        ((AVIMOperationQueue)object3).offer((AVIMOperationQueue$Operation)object2);
        object2 = this.session;
        object3 = ((AVSession)object2).getSelfPeerId();
        string2 = this.conversationId;
        object = ConversationControlPacket.genConversationCommand((String)object3, string2, null, "update", (Map)object, null, n10);
        ((AVSession)object2).sendPacket((CommandPacket)object);
    }
}

