/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.Messages$LogItem;
import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchItem;
import cn.leancloud.Messages$RcpCommand;
import cn.leancloud.Messages$SessionCommand;
import cn.leancloud.Messages$UnreadCommand;
import cn.leancloud.Messages$UnreadTuple;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.ConversationAckPacket;
import cn.leancloud.command.SessionAckPacket;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMBinaryMessage;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVDefaultConnectionListener$1;
import cn.leancloud.session.AVDefaultConnectionListener$2;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.AVSessionCacheHelper;
import cn.leancloud.session.AVSessionCacheHelper$SessionTagCache;
import cn.leancloud.session.AVSessionListener;
import cn.leancloud.session.MessageReceiptCache;
import cn.leancloud.session.PendingMessageCache;
import cn.leancloud.session.PendingMessageCache$Message;
import cn.leancloud.session.RequestStormSuppression;
import cn.leancloud.session.RequestStormSuppression$RequestCallback;
import cn.leancloud.session.StaleMessageDepot;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AVDefaultConnectionListener
implements AVConnectionListener {
    private static final int CODE_SESSION_SIGNATURE_FAILURE = 4102;
    private static final int CODE_SESSION_TOKEN_FAILURE = 4112;
    private static final AVLogger LOGGER = LogUtil.getLogger(AVDefaultConnectionListener.class);
    private static final String SESSION_MESSASGE_DEPOT = "com.avos.push.session.message.";
    private final StaleMessageDepot depot;
    public AVSession session;

    public AVDefaultConnectionListener(AVSession object) {
        StaleMessageDepot staleMessageDepot;
        this.session = object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SESSION_MESSASGE_DEPOT);
        object = ((AVSession)object).getSelfPeerId();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        this.depot = staleMessageDepot = new StaleMessageDepot((String)object);
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    private SessionAckPacket genSessionAckPacket(String string2) {
        SessionAckPacket sessionAckPacket = new SessionAckPacket();
        String string3 = this.session.getSelfPeerId();
        sessionAckPacket.setPeerId(string3);
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            sessionAckPacket.setMessageId(string2);
        }
        return sessionAckPacket;
    }

    private void onAckError(Integer n10, Messages$AckCommand object, PendingMessageCache$Message object2) {
        object2 = this.session.conversationOperationCache;
        int n11 = n10;
        object2 = ((AVIMOperationQueue)object2).poll(n11);
        n11 = ((AVIMOperationQueue$Operation)object2).operation;
        Object object3 = Conversation$AVIMOperation.CLIENT_OPEN;
        int n12 = ((Conversation$AVIMOperation)((Object)object3)).getCode();
        if (n11 == n12) {
            AVSession aVSession = this.session;
            object3 = AVSession$Status.Closed;
            aVSession.setSessionStatus((AVSession$Status)((Object)object3));
        }
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.getAVIMOperation(((AVIMOperationQueue$Operation)object2).operation);
        n11 = ((Messages$AckCommand)object).getCode();
        n12 = (int)(((Messages$AckCommand)object).hasAppCode() ? 1 : 0);
        if (n12 != 0) {
            n12 = ((Messages$AckCommand)object).getAppCode();
        } else {
            n12 = 0;
            object3 = null;
        }
        object = ((Messages$AckCommand)object).getReason();
        AVIMException aVIMException = new AVIMException(n11, n12, (String)object);
        object3 = InternalConfiguration.getOperationTube();
        String string2 = this.session.getSelfPeerId();
        String string3 = ((AVIMOperationQueue$Operation)object2).conversationId;
        int n13 = n10;
        object3.onOperationCompleted(string2, string3, n13, conversation$AVIMOperation, aVIMException);
    }

    private void processAckCommand(String object, Integer object2, Messages$AckCommand object3) {
        object = this.session;
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        ((AVSession)object).setServerAckReceived(l10 /= l11);
        l10 = ((Messages$AckCommand)object3).getT();
        object = this.session.pendingMessages;
        Object object4 = String.valueOf(object2);
        object = (PendingMessageCache$Message)((PendingMessageCache)object).poll((String)object4);
        boolean bl2 = ((Messages$AckCommand)object3).hasCode();
        if (bl2) {
            this.onAckError((Integer)object2, (Messages$AckCommand)object3, (PendingMessageCache$Message)object);
        } else if (object != null && !(bl2 = StringUtil.isEmpty((String)(object4 = ((PendingMessageCache$Message)object).cid)))) {
            object4 = this.session;
            Object object5 = ((PendingMessageCache$Message)object).cid;
            object4 = ((AVSession)object4).getConversationHolder((String)object5, 1);
            object5 = this.session.conversationOperationCache;
            int n10 = (Integer)object2;
            ((AVIMOperationQueue)object5).poll(n10);
            object3 = ((Messages$AckCommand)object3).getUid();
            int n11 = (Integer)object2;
            ((AVConversationHolder)object4).onMessageSent(n11, (String)object3, l10);
            n11 = (int)(((PendingMessageCache$Message)object).requestReceipt ? 1 : 0);
            if (n11 != 0) {
                ((PendingMessageCache$Message)object).timestamp = l10;
                ((PendingMessageCache$Message)object).id = object3;
                object2 = this.session.getSelfPeerId();
                MessageReceiptCache.add((String)object2, (String)object3, object);
            }
        }
    }

    private void processBlacklistCommand(String object, String charSequence, Integer n10, Messages$BlacklistCommand object2) {
        object = "query_result";
        boolean n11 = ((String)object).equals(charSequence);
        if (n11) {
            Conversation$AVIMOperation conversation$AVIMOperation;
            int n12;
            object = this.session.conversationOperationCache;
            int n13 = n10;
            if ((object = ((AVIMOperationQueue)object).poll(n13)) != null && (n12 = ((AVIMOperationQueue$Operation)object).operation) == (n13 = (conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY).getCode())) {
                Object object3;
                int n14;
                object = ((Messages$BlacklistCommand)object2).getBlockedPidsList();
                n13 = (int)(((Messages$BlacklistCommand)object2).hasNext() ? 1 : 0);
                if (n13 != 0) {
                    charSequence = ((Messages$BlacklistCommand)object2).getNext();
                } else {
                    n13 = 0;
                    charSequence = null;
                }
                if (object == null) {
                    n14 = 0;
                    object3 = null;
                } else {
                    n14 = object.size();
                }
                object3 = new String[n14];
                if (object != null) {
                    object.toArray((T[])object3);
                }
                String string2 = ((Messages$BlacklistCommand)object2).getSrcCid();
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                object = "callbackData";
                hashMap.put(object, object3);
                boolean bl2 = StringUtil.isEmpty((String)charSequence);
                if (!bl2) {
                    object = "callbackNext";
                    hashMap.put(object, charSequence);
                }
                object3 = InternalConfiguration.getOperationTube();
                object = this.session;
                String string3 = ((AVSession)object).getSelfPeerId();
                int n15 = n10;
                object3.onOperationCompletedEx(string3, string2, n15, conversation$AVIMOperation, hashMap);
            } else {
                object = LOGGER;
                charSequence = new StringBuilder();
                object2 = "not found requestKey: ";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(n10);
                charSequence = ((StringBuilder)charSequence).toString();
                ((AVLogger)object).w((String)charSequence);
            }
        } else {
            boolean bl3;
            object = "blocked";
            boolean bl4 = ((String)object).equals(charSequence);
            if (bl4 || (bl3 = ((String)(object = "unblocked")).equals(charSequence))) {
                object = ((Messages$BlacklistCommand)object2).getSrcCid();
                object = this.session.getConversationHolder((String)object, 1);
                Object object4 = this.session.conversationOperationCache;
                int n16 = n10;
                if ((object4 = ((AVIMOperationQueue)object4).poll(n16)) != null && object != null) {
                    int n17 = ((AVIMOperationQueue$Operation)object4).operation;
                    object4 = Conversation$AVIMOperation.getAVIMOperation(n17);
                    int n18 = n10;
                    ((AVConversationHolder)object).onResponse4MemberBlock((Conversation$AVIMOperation)((Object)object4), (String)charSequence, n18, (Messages$BlacklistCommand)object2);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void processConvCommand(String object, String object2, Integer hashMap, Messages$ConvCommand object3) {
        object = "results";
        boolean n10 = ((String)object).equals(object2);
        String string2 = "callbackData";
        Object object4 = "not found requestKey: ";
        if (n10) {
            int n11;
            int n12;
            object = this.session.conversationOperationCache;
            int n13 = (Integer)((Object)hashMap);
            object = ((AVIMOperationQueue)object).poll(n13);
            object2 = LOGGER;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("poll operation with requestId=");
            charSequence.append(hashMap);
            Object object5 = ", result=";
            charSequence.append((String)object5);
            charSequence.append(object);
            charSequence = charSequence.toString();
            ((AVLogger)object2).d((String)charSequence);
            if (object != null && (n12 = ((AVIMOperationQueue$Operation)object).operation) == (n11 = ((Conversation$AVIMOperation)((Object)(object5 = Conversation$AVIMOperation.CONVERSATION_QUERY))).getCode())) {
                object2 = ((Messages$ConvCommand)object3).getResults().getData();
                hashMap = new HashMap<String, Object>();
                hashMap.put(string2, object2);
                object2 = RequestStormSuppression.getInstance();
                object3 = new AVDefaultConnectionListener$1(this, hashMap);
                ((RequestStormSuppression)object2).release((AVIMOperationQueue$Operation)object, (RequestStormSuppression$RequestCallback)object3);
            } else {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(hashMap);
                hashMap = ", op=";
                ((StringBuilder)object3).append((String)((Object)hashMap));
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                ((AVLogger)object2).w((String)object);
            }
        } else {
            object = "shutup_result";
            boolean bl2 = ((String)object).equals(object2);
            boolean bl3 = false;
            Object object6 = null;
            if (bl2) {
                Conversation$AVIMOperation conversation$AVIMOperation;
                int n14;
                object = this.session.conversationOperationCache;
                int n15 = (Integer)((Object)hashMap);
                if ((object = ((AVIMOperationQueue)object).poll(n15)) != null && (n14 = ((AVIMOperationQueue$Operation)object).operation) == (n15 = (conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY).getCode())) {
                    object = ((Messages$ConvCommand)object3).getMList();
                    n15 = (int)(((Messages$ConvCommand)object3).hasNext() ? 1 : 0);
                    if (n15 != 0) {
                        object6 = ((Messages$ConvCommand)object3).getNext();
                    }
                    if (object == null) {
                        n15 = 0;
                        object2 = null;
                    } else {
                        n15 = object.size();
                    }
                    object2 = new String[n15];
                    if (object != null) {
                        object.toArray((T[])object2);
                    }
                    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
                    hashMap2.put(string2, object2);
                    boolean bl4 = StringUtil.isEmpty((String)object6);
                    if (!bl4) {
                        object = "callbackNext";
                        hashMap2.put(object, object6);
                    }
                    OperationTube operationTube = InternalConfiguration.getOperationTube();
                    object = this.session;
                    String string3 = ((AVSession)object).getSelfPeerId();
                    int n16 = (Integer)((Object)hashMap);
                    operationTube.onOperationCompletedEx(string3, null, n16, conversation$AVIMOperation, hashMap2);
                } else {
                    object = LOGGER;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object4);
                    ((StringBuilder)object2).append(hashMap);
                    object2 = ((StringBuilder)object2).toString();
                    ((AVLogger)object).w((String)object2);
                }
            } else {
                boolean bl5;
                boolean bl6;
                boolean bl7;
                boolean bl8;
                boolean bl9;
                boolean bl10;
                boolean bl11;
                int n17 = -65537;
                int n18 = hashMap != null ? (Integer)((Object)hashMap) : n17;
                string2 = "added";
                boolean bl12 = ((String)object2).equals(string2);
                if ((bl12 || (bl11 = ((String)object2).equals(string2 = "removed")) || (bl10 = ((String)object2).equals(string2 = "updated")) || (bl9 = ((String)object2).equals(string2 = "result")) || (bl8 = ((String)object2).equals(string2 = "shutup_added")) || (bl7 = ((String)object2).equals(string2 = "max_read")) || (bl6 = ((String)object2).equals(string2 = "shutup_removed")) || (bl5 = ((String)object2).equals(string2 = "member_info_updated"))) && n18 != n17) {
                    object = this.session.conversationOperationCache.poll(n18);
                    if (object != null) {
                        int n19 = ((AVIMOperationQueue$Operation)object).operation;
                        object6 = Conversation$AVIMOperation.getAVIMOperation(n19);
                        object = ((AVIMOperationQueue$Operation)object).conversationId;
                    } else {
                        object = ((Messages$ConvCommand)object3).getCid();
                    }
                } else {
                    object = "started";
                    boolean bl13 = ((String)object2).equals(object);
                    if (bl13) {
                        object = this.session.conversationOperationCache;
                        ((AVIMOperationQueue)object).poll(n18);
                    }
                    object = ((Messages$ConvCommand)object3).getCid();
                }
                boolean bl14 = true;
                boolean bl15 = ((Messages$ConvCommand)object3).hasTempConv();
                if (bl15 && (bl15 = ((Messages$ConvCommand)object3).getTempConv())) {
                    int n20 = 4;
                } else {
                    bl15 = ((Messages$ConvCommand)object3).hasTransient();
                    if (bl15 && (bl15 = ((Messages$ConvCommand)object3).getTransient())) {
                        int n21 = 2;
                    }
                }
                bl15 = StringUtil.isEmpty((String)object);
                if (!bl15) {
                    void var18_39;
                    object4 = this.session;
                    object = ((AVSession)object4).getConversationHolder((String)object, (int)var18_39);
                    ((AVConversationHolder)object).processConversationCommandFromServer((Conversation$AVIMOperation)((Object)object6), (String)object2, n18, (Messages$ConvCommand)object3);
                }
            }
        }
    }

    private void processConversationDeliveredAt(String string2, int n10, long l10) {
        this.session.getConversationHolder(string2, n10).onConversationDeliveredAtEvent(l10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processDirectCommand(String string2, Messages$DirectCommand messages$DirectCommand) {
        void var4_7;
        Object object;
        Object object2;
        Object object3;
        block13: {
            Object object4;
            Object object5;
            float f10;
            int n10;
            object3 = this;
            Object object6 = messages$DirectCommand.getMsg();
            object2 = messages$DirectCommand.getBinaryMsg();
            String string3 = messages$DirectCommand.getFromPeerId();
            String string4 = messages$DirectCommand.getCid();
            long l10 = messages$DirectCommand.getTimestamp();
            object = l10;
            String string5 = messages$DirectCommand.getId();
            int n11 = messages$DirectCommand.hasConvType();
            int n12 = 1;
            float f11 = Float.MIN_VALUE;
            n11 = n11 != 0 ? messages$DirectCommand.getConvType() : n12;
            boolean bl2 = messages$DirectCommand.hasTransient();
            Object object7 = null;
            if (bl2 && (bl2 = messages$DirectCommand.getTransient())) {
                n10 = n12;
                f10 = f11;
            } else {
                n10 = 0;
                object5 = null;
                f10 = 0.0f;
            }
            bl2 = messages$DirectCommand.hasHasMore();
            int n13 = bl2 && (bl2 = messages$DirectCommand.getHasMore()) ? n12 : 0;
            long l11 = messages$DirectCommand.getPatchTimestamp();
            bl2 = messages$DirectCommand.hasMentionAll();
            int n14 = bl2 && (bl2 = messages$DirectCommand.getMentionAll()) ? n12 : 0;
            ProtocolStringList protocolStringList = messages$DirectCommand.getMentionPidsList();
            if (n10 == 0) {
                try {
                    n12 = (int)(StringUtil.isEmpty(string4) ? 1 : 0);
                    if (n12 == 0) {
                        object4 = ((AVDefaultConnectionListener)object3).session;
                        object7 = ((AVSession)object4).getSelfPeerId();
                        object7 = ConversationAckPacket.getConversationAckPacket((String)object7, string4, string5);
                        ((AVSession)object4).sendPacket((CommandPacket)object7);
                    } else {
                        object4 = ((AVDefaultConnectionListener)object3).session;
                        object7 = ((AVDefaultConnectionListener)object3).genSessionAckPacket(string5);
                        ((AVSession)object4).sendPacket((CommandPacket)object7);
                    }
                }
                catch (Exception exception) {
                    break block13;
                }
            }
            try {
                object4 = ((AVDefaultConnectionListener)object3).depot;
                n12 = (int)(((StaleMessageDepot)object4).putStableMessage(string5) ? 1 : 0);
                if (n12 != 0 && (n12 = (int)(StringUtil.isEmpty(string4) ? 1 : 0)) == 0) {
                    float f12;
                    int n15;
                    object4 = ((AVDefaultConnectionListener)object3).session;
                    object7 = ((AVSession)object4).getConversationHolder(string4, n11);
                    n11 = (int)(StringUtil.isEmpty((String)object6) ? 1 : 0);
                    if (n11 != 0 && object2 != null) {
                        l10 = (Long)object;
                        long l12 = -1;
                        object = object6;
                        object3 = protocolStringList;
                        n15 = n10;
                        f12 = f10;
                        object5 = object7;
                        long l13 = l12;
                        object6 = new AVIMBinaryMessage(string4, string3, l10, l12);
                        object2 = ((ByteString)object2).toByteArray();
                        ((AVIMBinaryMessage)object6).setBytes((byte[])object2);
                    } else {
                        object3 = protocolStringList;
                        n15 = n10;
                        f12 = f10;
                        object5 = object7;
                        l10 = (Long)object;
                        long l14 = -1;
                        object = object2;
                        object2 = new AVIMMessage(string4, string3, l10, l14);
                        ((AVIMMessage)object2).setContent((String)object6);
                        object6 = object2;
                    }
                    ((AVIMMessage)object6).setMessageId(string5);
                    ((AVIMMessage)object6).setUpdateAt(l11);
                    ((AVIMMessage)object6).setMentionAll(n14 != 0);
                    ((AVIMMessage)object6).setMentionList((List)object3);
                    n12 = n15;
                    f11 = f12;
                    ((AVConversationHolder)object5).onMessage((AVIMMessage)object6, n13 != 0, n15 != 0);
                }
                object3 = this;
                return;
            }
            catch (Exception exception) {
                object3 = this;
            }
        }
        object2 = ((AVDefaultConnectionListener)object3).session;
        object = ((AVSession)object2).sessionListener;
        ((AVSessionListener)object).onError((AVSession)object2, (Throwable)var4_7);
    }

    private void processErrorCommand(String object, Integer object2, Messages$ErrorCommand messages$ErrorCommand) {
        int n10;
        int n11;
        if (object2 != null && (n11 = ((Integer)object2).intValue()) != (n10 = -65537)) {
            Enum enum_;
            int n12;
            Object object3 = this.session.conversationOperationCache;
            n10 = (Integer)object2;
            if ((object3 = ((AVIMOperationQueue)object3).poll(n10)) != null && (n10 = ((AVIMOperationQueue$Operation)object3).operation) == (n12 = ((Conversation$AVIMOperation)(enum_ = Conversation$AVIMOperation.CLIENT_OPEN)).getCode())) {
                AVSession aVSession = this.session;
                enum_ = AVSession$Status.Closed;
                aVSession.setSessionStatus((AVSession$Status)enum_);
            }
            n10 = messages$ErrorCommand.getCode();
            n12 = messages$ErrorCommand.hasAppCode();
            if (n12 != 0) {
                n12 = messages$ErrorCommand.getAppCode();
            } else {
                n12 = 0;
                enum_ = null;
            }
            String string2 = messages$ErrorCommand.getReason();
            if (object3 != null) {
                n11 = ((AVIMOperationQueue$Operation)object3).operation;
                object3 = Conversation$AVIMOperation.getAVIMOperation(n11);
            } else {
                n11 = 0;
                object3 = null;
            }
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            int n13 = (Integer)object2;
            AVIMException aVIMException = new AVIMException(n10, n12, string2);
            operationTube.onOperationCompleted((String)object, null, n13, (Conversation$AVIMOperation)((Object)object3), aVIMException);
        }
        if (object2 == null) {
            int n14 = 4102;
            int n15 = messages$ErrorCommand.getCode();
            if (n14 == n15) {
                object = AVSessionCacheHelper.getTagCacheInstance();
                object2 = this.session.getSelfPeerId();
                ((AVSessionCacheHelper$SessionTagCache)object).removeSession((String)object2);
            } else {
                n14 = 4112;
                if (n14 == n15) {
                    object = this.session;
                    object2 = "";
                    ((AVSession)object).updateRealtimeSessionToken((String)object2, 0);
                    this.onWebSocketOpen();
                }
            }
        }
    }

    private void processGoawayCommand(String object) {
        this.session.getConnectionManager().resetConnection();
        object = this.session.getConnectionManager();
        AVDefaultConnectionListener$2 aVDefaultConnectionListener$2 = new AVDefaultConnectionListener$2(this);
        ((AVConnectionManager)object).startConnection(aVDefaultConnectionListener$2);
    }

    private void processLogsCommand(String object, Integer n10, Messages$LogsCommand object2) {
        int n11;
        int n12;
        if (n10 != null && (n12 = n10.intValue()) != (n11 = -65537)) {
            Object object3;
            object = this.session.conversationOperationCache;
            n11 = n10;
            object = ((AVIMOperationQueue)object).poll(n11);
            n11 = 1;
            int n13 = ((Messages$LogsCommand)object2).getLogsCount();
            if (n13 > 0) {
                boolean bl2;
                n13 = 0;
                object3 = ((Messages$LogsCommand)object2).getLogs(0);
                if (object3 != null && (bl2 = ((Messages$LogItem)object3).hasConvType())) {
                    n11 = ((Messages$LogItem)object3).getConvType();
                }
            }
            object3 = this.session;
            object = ((AVIMOperationQueue$Operation)object).conversationId;
            object = ((AVSession)object3).getConversationHolder((String)object, n11);
            object2 = ((Messages$LogsCommand)object2).getLogsList();
            ((AVConversationHolder)object).processMessages(n10, (List)object2);
        }
    }

    private void processMessageReceipt(String object, String string2, int n10, long l10, String string3) {
        AVIMMessage aVIMMessage;
        Object object2 = this.session.getSelfPeerId();
        object = MessageReceiptCache.get((String)object2, (String)object);
        if (object == null) {
            return;
        }
        object = (PendingMessageCache$Message)object;
        String string4 = this.session.getSelfPeerId();
        long l11 = ((PendingMessageCache$Message)object).timestamp;
        object2 = aVIMMessage;
        aVIMMessage = new AVIMMessage(string2, string4, l11, l10);
        String string5 = ((PendingMessageCache$Message)object).id;
        aVIMMessage.setMessageId(string5);
        object = ((PendingMessageCache$Message)object).msg;
        aVIMMessage.setContent((String)object);
        object = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusReceipt;
        aVIMMessage.setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object));
        this.session.getConversationHolder(string2, n10).onMessageReceipt(aVIMMessage, string3);
    }

    private void processPatchCommand(String string2, boolean n10, Integer n11, Messages$PatchCommand messages$PatchCommand) {
        AVDefaultConnectionListener aVDefaultConnectionListener = this;
        int n12 = n10;
        Object object = messages$PatchCommand;
        this.updateLocalPatchTime(n10 != 0, messages$PatchCommand);
        if (n10 != 0) {
            n12 = messages$PatchCommand.getPatchesCount();
            if (n12 > 0) {
                boolean bl2;
                Iterator iterator2 = messages$PatchCommand.getPatchesList().iterator();
                while (bl2 = iterator2.hasNext()) {
                    object = (Messages$PatchItem)iterator2.next();
                    Object object2 = ((Messages$PatchItem)object).getCid();
                    String string3 = ((Messages$PatchItem)object).getMid();
                    String string4 = ((Messages$PatchItem)object).getData();
                    String string5 = ((Messages$PatchItem)object).getFrom();
                    long l10 = ((Messages$PatchItem)object).getTimestamp();
                    long l11 = 0L;
                    long l12 = 0L;
                    AVIMMessage aVIMMessage = AVIMTypedMessage.getMessage((String)object2, string3, string4, string5, l10, l11, l12);
                    long l13 = ((Messages$PatchItem)object).getPatchTimestamp();
                    aVIMMessage.setUpdateAt(l13);
                    boolean bl3 = ((Messages$PatchItem)object).hasPatchCode();
                    l13 = bl3 ? ((Messages$PatchItem)object).getPatchCode() : 0L;
                    long l14 = l13;
                    bl3 = ((Messages$PatchItem)object).hasPatchReason();
                    if (bl3) {
                        object2 = ((Messages$PatchItem)object).getPatchReason();
                    } else {
                        bl3 = false;
                        object2 = null;
                    }
                    String string6 = object2;
                    object2 = aVDefaultConnectionListener.session;
                    string3 = ((Messages$PatchItem)object).getCid();
                    int n13 = 1;
                    AVConversationHolder aVConversationHolder = ((AVSession)object2).getConversationHolder(string3, n13);
                    boolean bl4 = ((Messages$PatchItem)object).getRecall();
                    aVConversationHolder.onMessageUpdateEvent(aVIMMessage, bl4, l14, string6);
                }
            }
        } else {
            Object object3 = this.session.conversationOperationCache;
            int n14 = n11;
            n12 = object3.poll((int)n14).operation;
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.getAVIMOperation(n12);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            long l15 = messages$PatchCommand.getLastPatchTime();
            object3 = l15;
            hashMap.put("message_patch_time", object3);
            object = InternalConfiguration.getOperationTube();
            object3 = this.session;
            String string7 = ((AVSession)object3).getSelfPeerId();
            Object var11_14 = null;
            int n15 = n11;
            object.onOperationCompletedEx(string7, null, n15, conversation$AVIMOperation, hashMap);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void processRcpCommand(String object, Messages$RcpCommand object2) {
        try {
            Object object3;
            boolean bl2 = ((Messages$RcpCommand)object2).hasRead();
            int n10 = 1;
            if (bl2 && (bl2 = ((Messages$RcpCommand)object2).hasCid())) {
                long l10 = ((Messages$RcpCommand)object2).getT();
                object = l10;
                object2 = ((Messages$RcpCommand)object2).getCid();
                AVSession aVSession = this.session;
                object2 = aVSession.getConversationHolder((String)object2, n10);
                long l11 = (Long)object;
                ((AVConversationHolder)object2).onConversationReadAtEvent(l11);
                return;
            }
            bl2 = ((Messages$RcpCommand)object2).hasT();
            if (!bl2) return;
            long l12 = ((Messages$RcpCommand)object2).getT();
            object = l12;
            String string2 = ((Messages$RcpCommand)object2).getCid();
            boolean bl3 = ((Messages$RcpCommand)object2).hasFrom();
            if (bl3) {
                object3 = ((Messages$RcpCommand)object2).getFrom();
            } else {
                bl3 = false;
                object3 = null;
            }
            String string3 = object3;
            bl3 = StringUtil.isEmpty(string2);
            if (bl3) return;
            l12 = (Long)object;
            this.processConversationDeliveredAt(string2, n10, l12);
            String string4 = ((Messages$RcpCommand)object2).getId();
            long l13 = (Long)object;
            int n11 = 1;
            object3 = this;
            this.processMessageReceipt(string4, string2, n11, l13, string3);
            return;
        }
        catch (Exception exception) {
            object2 = this.session;
            AVSessionListener aVSessionListener = ((AVSession)object2).sessionListener;
            aVSessionListener.onError((AVSession)object2, exception);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void processSessionCommand(String var1_1, String var2_3, Integer var3_4, Messages$SessionCommand var4_5) {
        block38: {
            block39: {
                block37: {
                    var1_1 = AVDefaultConnectionListener.LOGGER;
                    var5_6 /* !! */  = new StringBuilder();
                    var5_6 /* !! */ .append("processSessionCommand. op=");
                    var5_6 /* !! */ .append((String)var2_3 /* !! */ );
                    var6_7 /* !! */  = ",requestKey=";
                    var5_6 /* !! */ .append((String)var6_7 /* !! */ );
                    var5_6 /* !! */ .append(var3_4);
                    var5_6 /* !! */  = var5_6 /* !! */ .toString();
                    var1_1.d((String)var5_6 /* !! */ );
                    var7_8 = -65537;
                    var8_9 = var3_4 != null ? var3_4.intValue() : var7_8;
                    var6_7 /* !! */  = "opened";
                    var9_10 = var2_3 /* !! */ .equals(var6_7 /* !! */ );
                    if (!var9_10) break block39;
                    var2_3 /* !! */  = this.session;
                    var2_3 /* !! */  = var2_3 /* !! */ .getCurrentStatus();
                    var6_7 /* !! */  = this.session;
                    var10_11 = AVSession$Status.Opened;
                    var6_7 /* !! */ .setSessionStatus(var10_11);
                    var6_7 /* !! */  = AVSession$Status.Closed;
                    if (var6_7 /* !! */  == var2_3 /* !! */ ) break block37;
                    var2_3 /* !! */  = this.session;
                    var2_3 /* !! */  = var2_3 /* !! */ .conversationOperationCache;
                    var11_12 = var2_3 /* !! */ .containRequest(var8_9);
                    if (var11_12) break block37;
                    var2_3 /* !! */  = "session resumed";
                    var1_1.d((String)var2_3 /* !! */ );
                    var1_1 = this.session;
                    var2_3 /* !! */  = var1_1.sessionListener;
                    var2_3 /* !! */ .onSessionResumed((AVSession)var1_1);
                    ** GOTO lbl61
                }
                if (var8_9 == var7_8) ** GOTO lbl56
                var1_1 = this.session;
                var1_1 = var1_1.conversationOperationCache;
                var1_1.poll(var8_9);
lbl56:
                // 2 sources

                var1_1 = this.session;
                var2_3 /* !! */  = var1_1.sessionListener;
                var2_3 /* !! */ .onSessionOpen((AVSession)var1_1, var8_9);
lbl61:
                // 2 sources

                var12_13 = var4_5.hasSt();
                if (!var12_13) ** GOTO lbl78
                var12_13 = var4_5.hasStTtl();
                if (!var12_13) ** GOTO lbl78
                var1_1 = this.session;
                var2_3 /* !! */  = var4_5.getSt();
                var8_9 = var4_5.getStTtl();
                var3_4 = var8_9;
                var8_9 = var3_4.intValue();
                var1_1.updateRealtimeSessionToken((String)var2_3 /* !! */ , var8_9);
lbl78:
                // 3 sources

                if (!(var12_13 = var4_5.hasLastPatchTime())) break block38;
                var1_1 = this.session;
                var13_16 = var4_5.getLastPatchTime();
                var15_17 = true;
                try {
                    var1_1.updateLastPatchTime(var13_16, var15_17);
                }
                catch (Exception var1_2) {
                    var2_3 /* !! */  = this.session;
                    var3_4 = var2_3 /* !! */ .sessionListener;
                    var3_4.onError((AVSession)var2_3 /* !! */ , var1_2);
                }
                break block38;
            }
            var6_7 /* !! */  = "refreshed";
            var9_10 = var2_3 /* !! */ .equals(var6_7 /* !! */ );
            if (var9_10) {
                var12_14 = var4_5.hasSt();
                if (var12_14 && (var12_14 = var4_5.hasStTtl())) {
                    var1_1 = this.session;
                    var2_3 /* !! */  = var4_5.getSt();
                    var4_5 = var4_5.getStTtl();
                    var15_18 = var4_5.intValue();
                    var1_1.updateRealtimeSessionToken((String)var2_3 /* !! */ , var15_18);
                }
                var1_1 = this.session;
                var2_3 /* !! */  = var1_1.sessionListener;
                var2_3 /* !! */ .onSessionTokenRenewed((AVSession)var1_1, var8_9);
            } else {
                var6_7 /* !! */  = "query_result";
                var9_10 = var2_3 /* !! */ .equals(var6_7 /* !! */ );
                if (var9_10) {
                    var1_1 = var4_5.getOnlineSessionPeerIdsList();
                    var2_3 /* !! */  = this.session;
                    var4_5 = var2_3 /* !! */ .sessionListener;
                    var4_5.onOnlineQuery((AVSession)var2_3 /* !! */ , (List)var1_1, var8_9);
                } else {
                    var6_7 /* !! */  = "closed";
                    var9_10 = var2_3 /* !! */ .equals(var6_7 /* !! */ );
                    if (var9_10) {
                        var12_15 = var4_5.hasCode();
                        if (var12_15) {
                            var1_1 = this.session;
                            var2_3 /* !! */  = var1_1.sessionListener;
                            var8_9 = var4_5.getCode();
                            var2_3 /* !! */ .onSessionClosedFromServer((AVSession)var1_1, var8_9);
                        } else {
                            if (var8_9 != var7_8) {
                                var1_1 = this.session.conversationOperationCache;
                                var1_1.poll(var8_9);
                            }
                            var1_1 = this.session;
                            var2_3 /* !! */  = var1_1.sessionListener;
                            var2_3 /* !! */ .onSessionClose((AVSession)var1_1, var8_9);
                        }
                        var1_1 = this.session;
                        var2_3 /* !! */  = AVSession$Status.Closed;
                        var1_1.setSessionStatus((AVSession$Status)var2_3 /* !! */ );
                    } else {
                        var3_4 = new StringBuilder();
                        var4_5 = "unknown operation: ";
                        var3_4.append((String)var4_5);
                        var3_4.append((String)var2_3 /* !! */ );
                        var2_3 /* !! */  = var3_4.toString();
                        var1_1.w((String)var2_3 /* !! */ );
                    }
                }
            }
        }
    }

    private void processUnreadCommand(String iterator2, Messages$UnreadCommand messages$UnreadCommand) {
        AVDefaultConnectionListener aVDefaultConnectionListener = this;
        Iterator iterator3 = this.session;
        long l10 = messages$UnreadCommand.getNotifTime();
        ((AVSession)((Object)iterator3)).updateLastNotifyTime(l10);
        int n10 = messages$UnreadCommand.getConvsCount();
        if (n10 > 0 && (iterator3 = messages$UnreadCommand.getConvsList()) != null) {
            int n11;
            iterator3 = iterator3.iterator();
            while ((n11 = iterator3.hasNext()) != 0) {
                boolean bl2;
                Object object;
                Messages$UnreadTuple messages$UnreadTuple = (Messages$UnreadTuple)iterator3.next();
                Object object2 = messages$UnreadTuple.getMid();
                Object object3 = messages$UnreadTuple.getData();
                long l11 = messages$UnreadTuple.getTimestamp();
                long l12 = messages$UnreadTuple.getPatchTimestamp();
                String string2 = messages$UnreadTuple.getCid();
                boolean bl3 = messages$UnreadTuple.getMentioned();
                ByteString byteString = messages$UnreadTuple.getBinaryMsg();
                String string3 = messages$UnreadTuple.getFrom();
                int n12 = messages$UnreadTuple.hasConvType();
                n12 = n12 != 0 ? messages$UnreadTuple.getConvType() : 1;
                int n13 = n12;
                n12 = (int)(StringUtil.isEmpty((String)object3) ? 1 : 0);
                if (n12 != 0 && byteString != null) {
                    long l13 = -1;
                    object = object3;
                    iterator2 = iterator3;
                    n10 = n13;
                    object3 = new AVIMBinaryMessage(string2, string3, l11, l13);
                    object = byteString.toByteArray();
                    ((AVIMBinaryMessage)object3).setBytes((byte[])object);
                    bl2 = bl3;
                } else {
                    AVIMMessage aVIMMessage;
                    iterator2 = iterator3;
                    n10 = n13;
                    long l14 = -1;
                    object = aVIMMessage;
                    bl2 = bl3;
                    aVIMMessage = new AVIMMessage(string2, string3, l11, l14);
                    aVIMMessage.setContent((String)object3);
                    object3 = aVIMMessage;
                }
                ((AVIMMessage)object3).setMessageId((String)object2);
                ((AVIMMessage)object3).setUpdateAt(l12);
                object2 = aVDefaultConnectionListener.session;
                iterator3 = ((AVSession)object2).getConversationHolder(string2, n10);
                n11 = messages$UnreadTuple.getUnread();
                ((AVConversationHolder)((Object)iterator3)).onUnreadMessagesEvent((AVIMMessage)object3, n11, bl2);
                iterator3 = iterator2;
            }
        }
    }

    private void updateLocalPatchTime(boolean bl2, Messages$PatchCommand generatedMessageV3) {
        if (bl2) {
            boolean bl3;
            long l10 = 0L;
            Object object = ((Messages$PatchCommand)generatedMessageV3).getPatchesList().iterator();
            while (bl3 = object.hasNext()) {
                generatedMessageV3 = (Messages$PatchItem)object.next();
                long l11 = ((Messages$PatchItem)generatedMessageV3).getPatchTimestamp();
                long l12 = l11 - l10;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 <= 0) continue;
                l10 = ((Messages$PatchItem)generatedMessageV3).getPatchTimestamp();
            }
            object = this.session;
            ((AVSession)object).updateLastPatchTime(l10);
        } else {
            AVSession aVSession = this.session;
            long l13 = ((Messages$PatchCommand)generatedMessageV3).getLastPatchTime();
            aVSession.updateLastPatchTime(l13);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void onError(Integer object, Messages$ErrorCommand object2) {
        int n10;
        int n11;
        if (object2 == null) {
            return;
        }
        if (object != null && (n11 = ((Integer)object).intValue()) != (n10 = -65537)) {
            void var7_11;
            Enum enum_;
            int n12;
            Object object3 = this.session.conversationOperationCache;
            n10 = (Integer)object;
            if ((object3 = ((AVIMOperationQueue)object3).poll(n10)) != null && (n10 = ((AVIMOperationQueue$Operation)object3).operation) == (n12 = ((Conversation$AVIMOperation)(enum_ = Conversation$AVIMOperation.CLIENT_OPEN)).getCode())) {
                AVSession aVSession = this.session;
                enum_ = AVSession$Status.Closed;
                aVSession.setSessionStatus((AVSession$Status)enum_);
            }
            n10 = ((Messages$ErrorCommand)object2).getCode();
            boolean bl2 = ((Messages$ErrorCommand)object2).hasAppCode();
            if (bl2) {
                int n13 = ((Messages$ErrorCommand)object2).getAppCode();
            } else {
                boolean bl3 = false;
                enum_ = null;
            }
            String string2 = ((Messages$ErrorCommand)object2).getReason();
            if (object3 != null) {
                n11 = ((AVIMOperationQueue$Operation)object3).operation;
                object3 = Conversation$AVIMOperation.getAVIMOperation(n11);
            } else {
                n11 = 0;
                object3 = null;
            }
            Object object4 = object3;
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            object3 = this.session;
            String string3 = ((AVSession)object3).getSelfPeerId();
            int n14 = (Integer)object;
            AVIMException aVIMException = new AVIMException(n10, (int)var7_11, string2);
            operationTube.onOperationCompleted(string3, null, n14, (Conversation$AVIMOperation)((Object)object4), aVIMException);
        }
        if (object == null) {
            int n15 = 4102;
            int n16 = ((Messages$ErrorCommand)object2).getCode();
            if (n15 == n16) {
                object = AVSessionCacheHelper.getTagCacheInstance();
                object2 = this.session.getSelfPeerId();
                ((AVSessionCacheHelper$SessionTagCache)object).removeSession((String)object2);
            } else {
                n15 = 4112;
                if (n15 == n16) {
                    object = this.session;
                    object2 = "";
                    ((AVSession)object).updateRealtimeSessionToken((String)object2, 0);
                    this.onWebSocketOpen();
                }
            }
        }
    }

    public void onMessageArriving(String charSequence, Integer object, Messages$GenericCommand generatedMessageV3) {
        if (generatedMessageV3 == null) {
            return;
        }
        Object object2 = LOGGER;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("new message arriving. peerId=");
        ((StringBuilder)object3).append((String)charSequence);
        ((StringBuilder)object3).append(", requestId=");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(", command=");
        Messages$CommandType messages$CommandType = ((Messages$GenericCommand)generatedMessageV3).getCmd();
        int n10 = messages$CommandType.getNumber();
        ((StringBuilder)object3).append(n10);
        object3 = ((StringBuilder)object3).toString();
        ((AVLogger)object2).d((String)object3);
        object3 = ((Messages$GenericCommand)generatedMessageV3).getCmd();
        int n11 = ((Messages$CommandType)object3).getNumber();
        n10 = 15;
        if (n11 == n10) {
            charSequence = "ignore loggedin command bcz invalid service.";
            ((AVLogger)object2).w((String)charSequence);
        } else {
            object3 = ((Messages$GenericCommand)generatedMessageV3).getCmd();
            n11 = ((Messages$CommandType)object3).getNumber();
            if (n11 != (n10 = 18)) {
                n10 = 20;
                if (n11 != n10) {
                    n10 = 21;
                    if (n11 != n10) {
                        switch (n11) {
                            default: {
                                charSequence = new StringBuilder();
                                ((StringBuilder)charSequence).append("unknown command. Cmd:");
                                object = ((Messages$GenericCommand)generatedMessageV3).getCmd();
                                int n12 = ((Messages$CommandType)object).getNumber();
                                ((StringBuilder)charSequence).append(n12);
                                charSequence = ((StringBuilder)charSequence).toString();
                                ((AVLogger)object2).w((String)charSequence);
                                break;
                            }
                            case 7: {
                                generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getErrorMessage();
                                this.processErrorCommand((String)charSequence, (Integer)object, (Messages$ErrorCommand)generatedMessageV3);
                                break;
                            }
                            case 6: {
                                generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getLogsMessage();
                                this.processLogsCommand((String)charSequence, (Integer)object, (Messages$LogsCommand)generatedMessageV3);
                                break;
                            }
                            case 5: {
                                object = ((Messages$GenericCommand)generatedMessageV3).getUnreadMessage();
                                this.processUnreadCommand((String)charSequence, (Messages$UnreadCommand)object);
                                break;
                            }
                            case 4: {
                                object = ((Messages$GenericCommand)generatedMessageV3).getRcpMessage();
                                this.processRcpCommand((String)charSequence, (Messages$RcpCommand)object);
                                break;
                            }
                            case 3: {
                                generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getAckMessage();
                                this.processAckCommand((String)charSequence, (Integer)object, (Messages$AckCommand)generatedMessageV3);
                                break;
                            }
                            case 2: {
                                object = ((Messages$GenericCommand)generatedMessageV3).getDirectMessage();
                                this.processDirectCommand((String)charSequence, (Messages$DirectCommand)object);
                                break;
                            }
                            case 1: {
                                object2 = ((Messages$GenericCommand)generatedMessageV3).getOp().name();
                                generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getConvMessage();
                                this.processConvCommand((String)charSequence, (String)object2, (Integer)object, (Messages$ConvCommand)generatedMessageV3);
                                break;
                            }
                            case 0: {
                                object2 = ((Messages$GenericCommand)generatedMessageV3).getOp().name();
                                generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getSessionMessage();
                                this.processSessionCommand((String)charSequence, (String)object2, (Integer)object, (Messages$SessionCommand)generatedMessageV3);
                                break;
                            }
                        }
                    } else {
                        this.processGoawayCommand((String)charSequence);
                    }
                } else {
                    object2 = ((Messages$GenericCommand)generatedMessageV3).getOp().name();
                    generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getBlacklistMessage();
                    this.processBlacklistCommand((String)charSequence, (String)object2, (Integer)object, (Messages$BlacklistCommand)generatedMessageV3);
                }
            } else {
                object2 = ((Messages$GenericCommand)generatedMessageV3).getOp();
                boolean bl2 = ((Enum)object2).equals(object3 = Messages$OpType.modify);
                if (bl2) {
                    bl2 = true;
                    generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getPatchMessage();
                    this.processPatchCommand((String)charSequence, bl2, (Integer)object, (Messages$PatchCommand)generatedMessageV3);
                } else {
                    object2 = ((Messages$GenericCommand)generatedMessageV3).getOp();
                    bl2 = ((Enum)object2).equals(object3 = Messages$OpType.modified);
                    if (bl2) {
                        bl2 = false;
                        object2 = null;
                        generatedMessageV3 = ((Messages$GenericCommand)generatedMessageV3).getPatchMessage();
                        this.processPatchCommand((String)charSequence, false, (Integer)object, (Messages$PatchCommand)generatedMessageV3);
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onWebSocketClose() {
        Object object = AVSession$Status.Closed;
        Object object2 = this.session.getCurrentStatus();
        if (object == object2) return;
        try {
            RuntimeException runtimeException;
            Conversation$AVIMOperation conversation$AVIMOperation;
            int n10;
            String string2;
            Object object3;
            Object object4;
            int n11;
            Object object5;
            boolean bl2;
            object = this.session;
            object2 = ((AVSession)object).sessionListener;
            ((AVSessionListener)object2).onSessionPaused((AVSession)object);
            object = this.session;
            object = ((AVSession)object).pendingMessages;
            object2 = "Connection Lost";
            if (object != null && !(bl2 = ((PendingMessageCache)object).isEmpty())) {
                while (true) {
                    object = this.session;
                    object = ((AVSession)object).pendingMessages;
                    bl2 = ((PendingMessageCache)object).isEmpty();
                    if (bl2) break;
                    object = this.session;
                    object = ((AVSession)object).pendingMessages;
                    object = ((PendingMessageCache)object).poll();
                    object = (PendingMessageCache$Message)object;
                    object5 = ((PendingMessageCache$Message)object).cid;
                    n11 = StringUtil.isEmpty((String)object5);
                    if (n11 != 0) continue;
                    object5 = this.session;
                    object4 = ((PendingMessageCache$Message)object).cid;
                    int n12 = 1;
                    object5 = ((AVSession)object5).getConversationHolder((String)object4, n12);
                    object4 = InternalConfiguration.getOperationTube();
                    object3 = this.session;
                    object3 = ((AVSession)object3).getSelfPeerId();
                    string2 = ((AVConversationHolder)object5).conversationId;
                    object = ((PendingMessageCache$Message)object).id;
                    n10 = Integer.parseInt((String)object);
                    conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_SEND_MESSAGE;
                    runtimeException = new RuntimeException((String)object2);
                    object4.onOperationCompleted((String)object3, string2, n10, conversation$AVIMOperation, runtimeException);
                }
            }
            object = this.session;
            object = ((AVSession)object).conversationOperationCache;
            if (object == null || (bl2 = ((AVIMOperationQueue)object).isEmpty())) return;
            object = this.session;
            object = ((AVSession)object).conversationOperationCache;
            object = ((AVIMOperationQueue)object).cache;
            object = object.entrySet();
            object = object.iterator();
            while ((n11 = object.hasNext()) != 0) {
                object5 = object.next();
                object5 = (Map.Entry)object5;
                object5 = object5.getKey();
                object5 = (Integer)object5;
                n10 = (Integer)object5;
                object5 = this.session;
                object5 = ((AVSession)object5).conversationOperationCache;
                object5 = ((AVIMOperationQueue)object5).poll(n10);
                object4 = InternalConfiguration.getOperationTube();
                object3 = ((AVIMOperationQueue$Operation)object5).sessionId;
                string2 = ((AVIMOperationQueue$Operation)object5).conversationId;
                n11 = ((AVIMOperationQueue$Operation)object5).operation;
                conversation$AVIMOperation = Conversation$AVIMOperation.getAVIMOperation(n11);
                runtimeException = new IllegalStateException((String)object2);
                object4.onOperationCompleted((String)object3, string2, n10, conversation$AVIMOperation, runtimeException);
            }
            return;
        }
        catch (Exception exception) {
            object2 = this.session;
            AVSessionListener aVSessionListener = ((AVSession)object2).sessionListener;
            aVSessionListener.onError((AVSession)object2, exception);
        }
    }

    public void onWebSocketOpen() {
        LOGGER.d("web socket opened, send session open.");
        this.session.reopen();
    }
}

