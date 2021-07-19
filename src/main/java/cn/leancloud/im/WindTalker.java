/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVLogger;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.LiveQueryLoginPacket;
import cn.leancloud.command.PushAckPacket;
import cn.leancloud.command.SessionControlPacket;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.im.Signature;
import cn.leancloud.utils.LogUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class WindTalker {
    private static final AVLogger LOGGER;
    public static AtomicInteger acu;
    private static WindTalker instance;

    static {
        AtomicInteger atomicInteger;
        LOGGER = LogUtil.getLogger(WindTalker.class);
        instance = null;
        acu = atomicInteger = new AtomicInteger(-65536);
    }

    private WindTalker() {
    }

    public static WindTalker getInstance() {
        WindTalker windTalker = instance;
        if (windTalker == null) {
            instance = windTalker = new WindTalker();
        }
        return instance;
    }

    public static int getNextIMRequestId() {
        char c10;
        AtomicInteger atomicInteger = acu;
        int n10 = atomicInteger.incrementAndGet();
        if (n10 > (c10 = (char)-1)) {
            int n11;
            AtomicInteger atomicInteger2;
            boolean bl2;
            while (n10 > c10 && !(bl2 = (atomicInteger2 = acu).compareAndSet(n10, n11 = -65536))) {
                atomicInteger = acu;
                n10 = atomicInteger.get();
            }
        }
        return n10;
    }

    public CommandPacket assembleLiveQueryLoginPacket(String string2, int n10) {
        LiveQueryLoginPacket liveQueryLoginPacket = new LiveQueryLoginPacket();
        liveQueryLoginPacket.setSubscribeId(string2);
        long l10 = System.currentTimeMillis();
        liveQueryLoginPacket.setClientTs(l10);
        if (n10 != 0) {
            liveQueryLoginPacket.setRequestId(n10);
        }
        return liveQueryLoginPacket;
    }

    public CommandPacket assemblePushAckPacket(String string2, List list) {
        PushAckPacket pushAckPacket = new PushAckPacket();
        pushAckPacket.setInstallationId(string2);
        pushAckPacket.setMessageIds(list);
        return pushAckPacket;
    }

    public CommandPacket assembleSessionOpenPacket(String string2, String string3, String string4, Signature signature, long l10, long l11, boolean bl2, int n10) {
        Integer n11 = n10;
        Object object = string2;
        String string5 = string3;
        object = SessionControlPacket.genSessionCommand(string2, string3, null, "open", signature, l10, l11, n11);
        string5 = string4;
        ((SessionControlPacket)object).setTag(string4);
        string5 = AVOSCloud.getApplicationId();
        ((CommandPacket)object).setAppId(string5);
        ((SessionControlPacket)object).setReconnectionRequest(bl2);
        return object;
    }

    public CommandPacket assembleSessionOpenPacket(String string2, String string3, String string4, String string5, long l10, long l11, boolean bl2, Integer n10) {
        Object object = string2;
        String string6 = string3;
        object = SessionControlPacket.genSessionCommand(string2, string3, null, "open", null, l10, l11, n10);
        string6 = string5;
        ((SessionControlPacket)object).setSessionToken(string5);
        ((SessionControlPacket)object).setReconnectionRequest(bl2);
        string6 = AVOSCloud.getApplicationId();
        ((CommandPacket)object).setAppId(string6);
        return object;
    }

    public CommandPacket assembleSessionPacket(String string2, String string3, List list, String string4, Signature signature, Integer n10) {
        return SessionControlPacket.genSessionCommand(string2, string3, list, string4, signature, n10);
    }

    public Messages$GenericCommand disassemblePacket(ByteBuffer byteBuffer) {
        try {
            return Messages$GenericCommand.parseFrom(byteBuffer);
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            LOGGER.e("failed to disassemble packet.", invalidProtocolBufferException);
            return null;
        }
    }
}

