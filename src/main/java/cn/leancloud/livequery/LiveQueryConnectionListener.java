/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.AVLogger;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$DataCommand;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.livequery.AVLiveQuery;
import cn.leancloud.livequery.AVLiveQueryConnectionHandler;
import cn.leancloud.livequery.LiveQueryOperationDelegate;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.utils.LogUtil;
import com.google.protobuf.ProtocolStringList;
import java.util.ArrayList;

public class LiveQueryConnectionListener
implements AVConnectionListener {
    private static final AVLogger LOGGER = LogUtil.getLogger(LiveQueryConnectionListener.class);
    private AVLiveQueryConnectionHandler connectionHandler = null;
    private volatile boolean connectionIsOpen = false;

    private void processErrorCommand(String string2, Integer n10, Messages$ErrorCommand object) {
        int n11;
        int n12;
        if (n10 != null && (n12 = n10.intValue()) != (n11 = -65537)) {
            n12 = ((Messages$ErrorCommand)object).getCode();
            n11 = (int)(((Messages$ErrorCommand)object).hasAppCode() ? 1 : 0);
            n11 = n11 != 0 ? ((Messages$ErrorCommand)object).getAppCode() : 0;
            object = ((Messages$ErrorCommand)object).getReason();
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            int n13 = n10;
            AVIMException aVIMException = new AVIMException(n12, n11, (String)object);
            operationTube.onOperationCompleted(string2, null, n13, null, aVIMException);
        }
    }

    private void processLiveQueryData(Messages$DataCommand object) {
        int n10;
        ProtocolStringList protocolStringList = ((Messages$DataCommand)object).getIdsList();
        object = ((Messages$DataCommand)object).getMsgList();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = object.size()) && i10 < (n10 = protocolStringList.size()); ++i10) {
            Object object2 = (Messages$JsonObjectMessage)object.get(i10);
            if (object2 == null) continue;
            object2 = ((Messages$JsonObjectMessage)object2).getData();
            arrayList.add(object2);
        }
        AVLiveQuery.processData(arrayList);
    }

    private void processLoggedinCommand(Integer object) {
        if (object == null) {
            object = LOGGER;
            String string2 = "request key is null, ignore.";
            ((AVLogger)object).d(string2);
        } else {
            boolean bl2;
            this.connectionIsOpen = bl2 = true;
            Object object2 = LiveQueryOperationDelegate.getInstance();
            int n10 = (Integer)object;
            ((LiveQueryOperationDelegate)object2).ackOperationReplied(n10);
            object2 = InternalConfiguration.getOperationTube();
            int n11 = (Integer)object;
            n10 = 0;
            object2.onLiveQueryCompleted(n11, null);
        }
    }

    public boolean connectionIsOpen() {
        return this.connectionIsOpen;
    }

    public void onError(Integer object, Messages$ErrorCommand messages$ErrorCommand) {
        object = LOGGER;
        String string2 = "encounter error.";
        ((AVLogger)object).e(string2);
        boolean bl2 = false;
        this.connectionIsOpen = false;
        object = this.connectionHandler;
        if (object != null) {
            string2 = "";
            int n10 = -1;
            if (messages$ErrorCommand == null) {
                object.onConnectionError(n10, string2);
            } else {
                bl2 = messages$ErrorCommand.hasCode();
                if (bl2) {
                    n10 = messages$ErrorCommand.getCode();
                }
                if (bl2 = messages$ErrorCommand.hasReason()) {
                    string2 = messages$ErrorCommand.getReason();
                }
                object = this.connectionHandler;
                object.onConnectionError(n10, string2);
            }
        }
    }

    public void onMessageArriving(String object, Integer object2, Messages$GenericCommand generatedMessageV3) {
        int n10;
        if (generatedMessageV3 != null && (n10 = generatedMessageV3.hasService()) != 0) {
            int n11 = 1;
            n10 = generatedMessageV3.getService();
            if (n11 != n10) {
                object = LOGGER;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("service field is invalid. expected=1, result=");
                ((StringBuilder)object2).append(n10);
                object2 = ((StringBuilder)object2).toString();
                ((AVLogger)object).w((String)object2);
                return;
            }
            Messages$CommandType messages$CommandType = generatedMessageV3.getCmd();
            n10 = messages$CommandType.getNumber();
            AVLogger aVLogger = LOGGER;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("new message arriving. peerId=");
            charSequence.append((String)object);
            charSequence.append(", requestKey=");
            charSequence.append(object2);
            String string2 = ", commandCode=";
            charSequence.append(string2);
            charSequence.append(n10);
            charSequence = charSequence.toString();
            aVLogger.d((String)charSequence);
            int n12 = 15;
            if (n10 == n12) {
                this.processLoggedinCommand((Integer)object2);
            } else {
                n12 = 9;
                if (n10 == n12) {
                    object = generatedMessageV3.getDataMessage();
                    this.processLiveQueryData((Messages$DataCommand)object);
                } else {
                    n12 = 7;
                    if (n10 == n12) {
                        generatedMessageV3 = generatedMessageV3.getErrorMessage();
                        this.processErrorCommand((String)object, (Integer)object2, (Messages$ErrorCommand)generatedMessageV3);
                    } else {
                        object = "command isn't recognized.";
                        aVLogger.w((String)object);
                    }
                }
            }
            return;
        }
        LOGGER.w("GenericCommand is null or hasn't service field.");
    }

    public void onWebSocketClose() {
        Object object = LOGGER;
        String string2 = "livequery connection closed.";
        ((AVLogger)object).d(string2);
        this.connectionIsOpen = false;
        object = this.connectionHandler;
        if (object != null) {
            object.onConnectionClose();
        }
    }

    public void onWebSocketOpen() {
        Object object = LOGGER;
        String string2 = "livequery connection opened, ready to send packet";
        ((AVLogger)object).d(string2);
        object = this.connectionHandler;
        if (object != null) {
            object.onConnectionOpen();
        }
    }

    public void setConnectionHandler(AVLiveQueryConnectionHandler aVLiveQueryConnectionHandler) {
        this.connectionHandler = aVLiveQueryConnectionHandler;
    }
}

