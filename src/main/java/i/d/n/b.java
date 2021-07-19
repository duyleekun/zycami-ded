/*
 * Decompiled with CFR 0.151.
 */
package i.d.n;

import i.d.f;
import i.d.i;
import i.d.j;
import i.d.n.a;
import i.d.n.b$a;
import i.d.p.g;
import i.d.q.h;
import i.h.c;
import i.h.d;
import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;

public class b
extends a {
    private static final String m = "Sec-WebSocket-Key";
    private static final String n = "Sec-WebSocket-Protocol";
    private static final String o = "Sec-WebSocket-Extensions";
    private static final String p = "Sec-WebSocket-Accept";
    private static final String q = "Upgrade";
    private static final String r = "Connection";
    public static final /* synthetic */ boolean s;
    private final c c;
    private i.d.o.c d;
    private List e;
    private i.d.s.a f;
    private List g;
    private i.d.p.f h;
    private final List i;
    private ByteBuffer j;
    private final Random k;
    private int l;

    public b() {
        List list = Collections.emptyList();
        this(list);
    }

    public b(i.d.o.c object) {
        object = Collections.singletonList(object);
        this((List)object);
    }

    public b(List list) {
        Object object = new i.d.s.b("");
        object = Collections.singletonList(object);
        this(list, (List)object);
    }

    public b(List list, int n10) {
        Object object = new i.d.s.b("");
        object = Collections.singletonList(object);
        this(list, (List)object, n10);
    }

    public b(List list, List list2) {
        this(list, list2, -1 >>> 1);
    }

    public b(List object, List list, int n10) {
        int n11;
        Object object2 = i.h.d.i(b.class);
        this.c = object2;
        this.d = object2 = new i.d.o.b();
        this.k = object2 = new Random();
        if (object != null && list != null && n10 >= (n11 = 1)) {
            boolean bl2;
            int n12 = object.size();
            Object object3 = new ArrayList(n12);
            this.e = object3;
            n12 = list.size();
            object3 = new ArrayList(n12);
            this.g = object3;
            int n13 = 0;
            object3 = null;
            Object object4 = new ArrayList();
            this.i = object4;
            object4 = object.iterator();
            while (bl2 = object4.hasNext()) {
                Class<i.d.o.b> clazz;
                Class<?> clazz2 = ((i.d.o.c)object4.next()).getClass();
                bl2 = clazz2.equals(clazz = i.d.o.b.class);
                if (!bl2) continue;
                n13 = n11;
            }
            object2 = this.e;
            object2.addAll(object);
            if (n13 == 0) {
                object = this.e;
                n11 = object.size();
                object3 = this.d;
                object.add(n11, object3);
            }
            this.g.addAll(list);
            this.l = n10;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void C(ByteBuffer byteBuffer) {
        List list = this.i;
        synchronized (list) {
            List list2 = this.i;
            list2.add(byteBuffer);
            return;
        }
    }

    private void D() {
        long l10;
        long l11 = this.J();
        long l12 = l11 - (l10 = (long)this.l);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return;
        }
        this.E();
        c c10 = this.c;
        Integer n10 = this.l;
        Serializable serializable = l11;
        c10.trace("Payload limit reached. Allowed: {} Current: {}", (Object)n10, (Object)serializable);
        int n11 = this.l;
        serializable = new LimitExceededException(n11);
        throw serializable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void E() {
        List list = this.i;
        synchronized (list) {
            List list2 = this.i;
            list2.clear();
            return;
        }
    }

    private HandshakeState F(String string2) {
        boolean bl2;
        Iterator iterator2 = this.g.iterator();
        while (bl2 = iterator2.hasNext()) {
            i.d.s.a a10 = (i.d.s.a)iterator2.next();
            boolean bl3 = a10.b(string2);
            if (!bl3) continue;
            this.f = a10;
            this.c.trace("acceptHandshake - Matching protocol found: {}", (Object)a10);
            return HandshakeState.MATCHED;
        }
        return HandshakeState.NOT_MATCHED;
    }

    /*
     * WARNING - void declaration
     */
    private ByteBuffer G(i.d.p.f object) {
        block15: {
            ByteBuffer byteBuffer;
            void var7_9;
            int n10;
            int by5;
            int n102;
            Object object2;
            ByteBuffer byteBuffer2;
            block13: {
                int n11;
                int n12;
                block14: {
                    block12: {
                        void var14_26;
                        Opcode opcode;
                        byteBuffer2 = object.g();
                        object2 = this.a;
                        Role role = Role.CLIENT;
                        n102 = 0;
                        by5 = 1;
                        if (object2 == role) {
                            int by4 = by5;
                        } else {
                            boolean bl2 = false;
                            object2 = null;
                        }
                        n12 = this.S(byteBuffer2);
                        int n13 = n12 > by5 ? n12 + 1 : n12;
                        n13 += by5;
                        n10 = 4;
                        if (var7_9 != false) {
                            n11 = n10;
                        } else {
                            n11 = 0;
                            opcode = null;
                        }
                        n13 += n11;
                        n11 = byteBuffer2.remaining();
                        byteBuffer = ByteBuffer.allocate(n13 += n11);
                        opcode = object.d();
                        n11 = this.H(opcode);
                        boolean bl3 = object.f();
                        if (bl3) {
                            int n14 = -128;
                        } else {
                            boolean bl4 = false;
                            object = null;
                        }
                        byte by2 = (byte)((byte)var14_26 | n11);
                        byteBuffer.put(by2);
                        int n15 = byteBuffer2.remaining();
                        long l10 = n15;
                        object = this.a0(l10, n12);
                        if (n12 != by5) break block12;
                        Object object3 = object[0];
                        byte by3 = this.N((boolean)var7_9);
                        byte by4 = (byte)(object3 | by3);
                        byteBuffer.put(by4);
                        break block13;
                    }
                    n11 = 2;
                    if (n12 != n11) break block14;
                    byte by6 = (byte)(this.N((boolean)var7_9) | 0x7E);
                    byteBuffer.put(by6);
                    byteBuffer.put((byte[])object);
                    break block13;
                }
                n11 = 8;
                if (n12 != n11) break block15;
                byte by7 = (byte)(this.N((boolean)var7_9) | 0x7F);
                byteBuffer.put(by7);
                byteBuffer.put((byte[])object);
            }
            if (var7_9 != false) {
                byte by8;
                object = ByteBuffer.allocate(n10);
                int n16 = this.k.nextInt();
                ((ByteBuffer)object).putInt(n16);
                object2 = ((ByteBuffer)object).array();
                byteBuffer.put((byte[])object2);
                while ((by8 = byteBuffer2.hasRemaining()) != 0) {
                    by8 = byteBuffer2.get();
                    int n17 = n102 % 4;
                    n17 = ((ByteBuffer)object).get(n17);
                    by8 = (byte)(by8 ^ n17);
                    byteBuffer.put(by8);
                    n102 += by5;
                }
            } else {
                byteBuffer.put(byteBuffer2);
                byteBuffer2.flip();
            }
            byteBuffer.flip();
            return byteBuffer;
        }
        object = new IllegalStateException("Size representation not supported/specified");
        throw object;
    }

    private byte H(Opcode object) {
        Object object2 = Opcode.CONTINUOUS;
        if (object == object2) {
            return 0;
        }
        object2 = Opcode.TEXT;
        if (object == object2) {
            return 1;
        }
        object2 = Opcode.BINARY;
        if (object == object2) {
            return 2;
        }
        object2 = Opcode.CLOSING;
        if (object == object2) {
            return 8;
        }
        object2 = Opcode.PING;
        if (object == object2) {
            return 9;
        }
        object2 = Opcode.PONG;
        if (object == object2) {
            return 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Don't know how to handle ");
        object = object.toString();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private String I(String object) {
        object = ((String)object).trim();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        object = ((StringBuilder)object2).toString();
        object2 = "SHA1";
        try {
            object2 = MessageDigest.getInstance((String)object2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object2 = new IllegalStateException(noSuchAlgorithmException);
            throw object2;
        }
        object = ((String)object).getBytes();
        return i.d.u.a.g(((MessageDigest)object2).digest((byte[])object));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long J() {
        List list = this.i;
        synchronized (list) {
            Object object = this.i;
            object = object.iterator();
            long l10 = 0L;
            int n10;
            while ((n10 = object.hasNext()) != 0) {
                Object object2 = object.next();
                object2 = (ByteBuffer)object2;
                n10 = ((Buffer)object2).limit();
                long l11 = n10;
                l10 += l11;
            }
            return l10;
        }
    }

    /*
     * WARNING - void declaration
     */
    private byte N(boolean bl2) {
        void var1_4;
        if (bl2) {
            int n10 = -128;
        } else {
            boolean bl3 = false;
        }
        return (byte)var1_4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ByteBuffer P() {
        List list = this.i;
        synchronized (list) {
            int n10;
            Object object = this.i;
            object = object.iterator();
            long l10 = 0L;
            while ((n10 = object.hasNext()) != 0) {
                Object object2 = object.next();
                object2 = (ByteBuffer)object2;
                n10 = ((Buffer)object2).limit();
                long l11 = n10;
                l10 += l11;
            }
            this.D();
            int n11 = (int)l10;
            object = ByteBuffer.allocate(n11);
            Object object3 = this.i;
            object3 = object3.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object3.hasNext())) {
                    // MONITOREXIT @DISABLED, blocks:[2, 4, 5] lbl20 : MonitorExitStatement: MONITOREXIT : var1_1
                    ((ByteBuffer)object).flip();
                    return object;
                }
                Object object4 = object3.next();
                object4 = (ByteBuffer)object4;
                ((ByteBuffer)object).put((ByteBuffer)object4);
            }
        }
    }

    private String R() {
        Comparable<Calendar> comparable = Calendar.getInstance();
        Cloneable cloneable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", (Locale)cloneable);
        cloneable = DesugarTimeZone.getTimeZone("GMT");
        simpleDateFormat.setTimeZone((TimeZone)cloneable);
        comparable = comparable.getTime();
        return simpleDateFormat.format((Date)comparable);
    }

    private int S(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.remaining();
        if (n11 <= (n10 = 125)) {
            return 1;
        }
        int n12 = byteBuffer.remaining();
        if (n12 <= (n11 = (int)((char)-1))) {
            return 2;
        }
        return 8;
    }

    private void T(i i10, RuntimeException runtimeException) {
        this.c.error("Runtime exception during onWebsocketMessage", runtimeException);
        i10.q().onWebsocketError(i10, runtimeException);
    }

    private void U(i i10, i.d.p.f object) {
        j j10 = i10.q();
        object = object.g();
        try {
            j10.onWebsocketMessage((f)i10, (ByteBuffer)object);
        }
        catch (RuntimeException runtimeException) {
            this.T(i10, runtimeException);
        }
    }

    private void V(i i10, i.d.p.f object) {
        int n10 = object instanceof i.d.p.b;
        if (n10 != 0) {
            object = (i.d.p.b)object;
            n10 = ((i.d.p.b)object).q();
            object = ((i.d.p.b)object).r();
        } else {
            n10 = 1005;
            object = "";
        }
        Enum enum_ = i10.getReadyState();
        Enum enum_2 = ReadyState.CLOSING;
        boolean bl2 = true;
        if (enum_ == enum_2) {
            i10.d(n10, (String)object, bl2);
        } else {
            enum_ = this.n();
            if (enum_ == (enum_2 = CloseHandshakeType.TWOWAY)) {
                i10.a(n10, (String)object, bl2);
            } else {
                enum_ = null;
                i10.l(n10, (String)object, false);
            }
        }
    }

    private void W(i object, i.d.p.f f10, Opcode opcode) {
        block8: {
            boolean bl2;
            Opcode opcode2;
            block6: {
                block7: {
                    block5: {
                        opcode2 = Opcode.CONTINUOUS;
                        if (opcode == opcode2) break block5;
                        this.Y(f10);
                        break block6;
                    }
                    boolean bl3 = f10.f();
                    if (!bl3) break block7;
                    this.X((i)object, f10);
                    break block6;
                }
                object = this.h;
                if (object == null) break block8;
            }
            object = Opcode.TEXT;
            if (opcode == object && !(bl2 = i.d.u.c.b((ByteBuffer)(object = f10.g())))) {
                this.c.error("Protocol error: Payload is not UTF8");
                object = new InvalidDataException(1007);
                throw object;
            }
            if (opcode == opcode2 && (object = this.h) != null) {
                object = f10.g();
                this.C((ByteBuffer)object);
            }
            return;
        }
        this.c.error("Protocol error: Continuous frame sequence was not started.");
        object = new InvalidDataException(1002, "Continuous frame sequence was not started.");
        throw object;
    }

    private void X(i object, i.d.p.f object2) {
        Object object3 = this.h;
        if (object3 != null) {
            object2 = object2.g();
            this.C((ByteBuffer)object2);
            this.D();
            object2 = this.h.d();
            object3 = Opcode.TEXT;
            if (object2 == object3) {
                object2 = (g)this.h;
                object3 = this.P();
                ((g)object2).l((ByteBuffer)object3);
                object2 = (g)this.h;
                ((g)object2).j();
                object2 = ((i)object).q();
                object3 = this.h;
                object3 = object3.g();
                object3 = i.d.u.c.f((ByteBuffer)object3);
                try {
                    object2.onWebsocketMessage((f)object, (String)object3);
                }
                catch (RuntimeException runtimeException) {
                    this.T((i)object, runtimeException);
                }
            } else {
                object2 = this.h.d();
                if (object2 == (object3 = Opcode.BINARY)) {
                    object2 = (g)this.h;
                    object3 = this.P();
                    ((g)object2).l((ByteBuffer)object3);
                    object2 = (g)this.h;
                    ((g)object2).j();
                    object2 = ((i)object).q();
                    object3 = this.h;
                    object3 = object3.g();
                    try {
                        object2.onWebsocketMessage((f)object, (ByteBuffer)object3);
                    }
                    catch (RuntimeException runtimeException) {
                        this.T((i)object, runtimeException);
                    }
                }
            }
            this.h = null;
            this.E();
            return;
        }
        this.c.trace("Protocol error: Previous continuous frame sequence not completed.");
        object = new InvalidDataException(1002, "Continuous frame sequence was not started.");
        throw object;
    }

    private void Y(i.d.p.f object) {
        i.d.p.f f10 = this.h;
        if (f10 == null) {
            this.h = object;
            object = object.g();
            this.C((ByteBuffer)object);
            this.D();
            return;
        }
        this.c.trace("Protocol error: Previous continuous frame sequence not completed.");
        object = new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
        throw object;
    }

    private void Z(i i10, i.d.p.f object) {
        j j10 = i10.q();
        object = object.g();
        object = i.d.u.c.f((ByteBuffer)object);
        try {
            j10.onWebsocketMessage((f)i10, (String)object);
        }
        catch (RuntimeException runtimeException) {
            this.T(i10, runtimeException);
        }
    }

    private byte[] a0(long l10, int n10) {
        byte[] byArray = new byte[n10];
        int n11 = n10 * 8 + -8;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = i10 * 8;
            n12 = n11 - n12;
            long l11 = l10 >>> n12;
            byArray[i10] = n12 = (int)((byte)l11);
        }
        return byArray;
    }

    private Opcode b0(byte n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    switch (n10) {
                        default: {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown opcode ");
                            n10 = (short)n10;
                            stringBuilder.append(n10);
                            String string2 = stringBuilder.toString();
                            InvalidFrameException invalidFrameException = new InvalidFrameException(string2);
                            throw invalidFrameException;
                        }
                        case 10: {
                            return Opcode.PONG;
                        }
                        case 9: {
                            return Opcode.PING;
                        }
                        case 8: 
                    }
                    return Opcode.CLOSING;
                }
                return Opcode.BINARY;
            }
            return Opcode.TEXT;
        }
        return Opcode.CONTINUOUS;
    }

    private i.d.p.f c0(ByteBuffer object) {
        if (object != null) {
            Object object2;
            Object object3;
            Object object4;
            int n10 = ((Buffer)object).remaining();
            int n11 = 2;
            this.e0(n10, n11);
            int n12 = ((ByteBuffer)object).get();
            int n13 = n12 >> 8;
            int n14 = 1;
            int n15 = 0;
            int n16 = n13 != 0 ? n14 : 0;
            n13 = n12 & 0x40;
            int n17 = n13 != 0 ? n14 : 0;
            n13 = n12 & 0x20;
            int n18 = n13 != 0 ? n14 : 0;
            n13 = n12 & 0x10;
            int n19 = n13 != 0 ? n14 : 0;
            n13 = ((ByteBuffer)object).get();
            Object object5 = n13 & 0xFFFFFF80;
            int n20 = object5 != 0 ? n14 : 0;
            n14 = n13 &= 0x7F;
            n12 = (byte)(n12 & 0xF);
            Opcode opcode = this.b0((byte)n12);
            if (n14 < 0 || n14 > (n12 = 125)) {
                int n21 = 2;
                object4 = this;
                object3 = object;
                object2 = opcode;
                object5 = n10;
                object4 = this.f0((ByteBuffer)object, opcode, n14, n10, n21);
                n14 = b$a.a((b$a)object4);
                n11 = b$a.b((b$a)object4);
            }
            long l10 = n14;
            this.d0(l10);
            n12 = 4;
            if (n20 != 0) {
                n13 = n12;
            } else {
                n13 = 0;
                object2 = null;
            }
            n11 = n11 + n13 + n14;
            this.e0(n10, n11);
            n11 = this.d(n14);
            object4 = ByteBuffer.allocate(n11);
            if (n20 != 0) {
                object3 = new byte[n12];
                ((ByteBuffer)object).get((byte[])object3);
                while (n15 < n14) {
                    n13 = ((ByteBuffer)object).get();
                    object5 = n15 % 4;
                    object5 = object3[object5];
                    n13 = (byte)(n13 ^ object5);
                    ((ByteBuffer)object4).put((byte)n13);
                    ++n15;
                }
            } else {
                object3 = ((ByteBuffer)object).array();
                n13 = ((Buffer)object).position();
                n14 = ((Buffer)object4).limit();
                ((ByteBuffer)object4).put((byte[])object3, n13, n14);
                n12 = ((Buffer)object).position();
                n13 = ((Buffer)object4).limit();
                ((ByteBuffer)object).position(n12 += n13);
            }
            object = i.d.p.g.i(opcode);
            ((g)object).k(n16 != 0);
            ((g)object).m(n17 != 0);
            ((g)object).n(n18 != 0);
            ((g)object).o(n19 != 0);
            ((ByteBuffer)object4).flip();
            ((g)object).l((ByteBuffer)object4);
            this.K().g((i.d.p.f)object);
            this.K().c((i.d.p.f)object);
            object4 = this.c;
            n11 = (int)(object4.isTraceEnabled() ? 1 : 0);
            if (n11 != 0) {
                Object object6;
                object4 = this.c;
                n12 = ((g)object).g().remaining();
                object3 = n12;
                object2 = ((g)object).g();
                n13 = ((Buffer)object2).remaining();
                if (n13 > (n14 = 1000)) {
                    object2 = "too big to display";
                } else {
                    object6 = ((g)object).g().array();
                    object2 = new String((byte[])object6);
                }
                object6 = "afterDecoding({}): {}";
                object4.trace((String)object6, object3, object2);
            }
            ((g)object).j();
            return object;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    private void d0(long l10) {
        long l11 = Integer.MAX_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            object = this.l;
            long l13 = object;
            long l14 = l10 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 <= 0) {
                l11 = 0L;
                long l15 = l10 - l11;
                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object3 >= 0) {
                    return;
                }
                this.c.trace("Limit underflow: Payloadsize is to little...");
                LimitExceededException limitExceededException = new LimitExceededException("Payloadsize is to little...");
                throw limitExceededException;
            }
            c c10 = this.c;
            Integer n10 = (int)object;
            Serializable serializable = l10;
            c10.trace("Payload limit reached. Allowed: {} Current: {}", (Object)n10, (Object)serializable);
            int n11 = this.l;
            serializable = new LimitExceededException("Payload limit reached.", n11);
            throw serializable;
        }
        this.c.trace("Limit exedeed: Payloadsize is to big...");
        LimitExceededException limitExceededException = new LimitExceededException("Payloadsize is to big...");
        throw limitExceededException;
    }

    private void e0(int n10, int n11) {
        if (n10 >= n11) {
            return;
        }
        this.c.trace("Incomplete frame: maxpacketsize < realpacketsize");
        IncompleteException incompleteException = new IncompleteException(n11);
        throw incompleteException;
    }

    private b$a f0(ByteBuffer object, Opcode object2, int n10, int n11, int n12) {
        Opcode opcode = Opcode.PING;
        if (object2 != opcode && object2 != (opcode = Opcode.PONG) && object2 != (opcode = Opcode.CLOSING)) {
            int n13;
            int n14 = 126;
            if (n10 == n14) {
                n14 = 2;
                this.e0(n11, n12 += n14);
                n10 = 3;
                byte[] byArray = new byte[n10];
                n11 = ((ByteBuffer)object).get();
                int n15 = 1;
                byArray[n15] = n11;
                byArray[n14] = n13 = ((ByteBuffer)object).get();
                object = new BigInteger(byArray);
                n13 = ((BigInteger)object).intValue();
            } else {
                n14 = 8;
                this.e0(n11, n12 += n14);
                byte[] byArray = new byte[n14];
                for (n11 = 0; n11 < n14; ++n11) {
                    byte by2;
                    byArray[n11] = by2 = ((ByteBuffer)object).get();
                }
                object = new BigInteger(byArray);
                long l10 = ((BigInteger)object).longValue();
                this.d0(l10);
                n13 = (int)l10;
            }
            object2 = new b$a(this, n13, n12);
            return object2;
        }
        this.c.trace("Invalid frame: more than 125 octets");
        object = new InvalidFrameException("more than 125 octets");
        throw object;
    }

    public i.d.o.c K() {
        return this.d;
    }

    public List L() {
        return this.e;
    }

    public List M() {
        return this.g;
    }

    public int O() {
        return this.l;
    }

    public i.d.s.a Q() {
        return this.f;
    }

    public HandshakeState a(i.d.q.a object, h object2) {
        Object object3;
        boolean bl2;
        boolean bl3 = this.c((i.d.q.f)object2);
        if (!bl3) {
            this.c.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        }
        Object object4 = m;
        boolean bl4 = object.d((String)object4);
        if (bl4 && (bl2 = object2.d((String)(object3 = p)))) {
            object3 = object2.j((String)object3);
            object = object.j((String)object4);
            boolean bl5 = ((String)(object = this.I((String)object))).equals(object3);
            if (!bl5) {
                this.c.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return HandshakeState.NOT_MATCHED;
            }
            object = HandshakeState.NOT_MATCHED;
            object4 = object2.j(o);
            object3 = this.e.iterator();
            while (bl2 = object3.hasNext()) {
                i.d.o.c c10 = (i.d.o.c)object3.next();
                boolean bl6 = c10.e((String)object4);
                if (!bl6) continue;
                this.d = c10;
                object = HandshakeState.MATCHED;
                object4 = this.c;
                object3 = "acceptHandshakeAsClient - Matching extension found: {}";
                object4.trace((String)object3, (Object)c10);
                break;
            }
            object2 = object2.j(n);
            if ((object2 = this.F((String)object2)) == (object4 = HandshakeState.MATCHED) && object == object4) {
                return object4;
            }
            this.c.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
            return HandshakeState.NOT_MATCHED;
        }
        this.c.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
        return HandshakeState.NOT_MATCHED;
    }

    public HandshakeState b(i.d.q.a object) {
        boolean bl2;
        int n10;
        int n11 = this.u((i.d.q.f)object);
        if (n11 != (n10 = 13)) {
            this.c.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        Object object2 = object.j(o);
        Object object3 = this.e.iterator();
        while (bl2 = object3.hasNext()) {
            i.d.o.c c10 = (i.d.o.c)object3.next();
            boolean bl3 = c10.b((String)object2);
            if (!bl3) continue;
            this.d = c10;
            handshakeState = HandshakeState.MATCHED;
            object2 = this.c;
            object3 = "acceptHandshakeAsServer - Matching extension found: {}";
            object2.trace((String)object3, (Object)c10);
            break;
        }
        object = object.j(n);
        if ((object = this.F((String)object)) == (object2 = HandshakeState.MATCHED) && handshakeState == object2) {
            return object2;
        }
        this.c.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            int n10 = this.l;
            int n11 = ((b)(object = (b)object)).O();
            if (n10 != n11) {
                return false;
            }
            object3 = this.d;
            if (object3 != null ? (n10 = (int)(object3.equals(object2 = ((b)object).K()) ? 1 : 0)) == 0 : (object3 = ((b)object).K()) != null) {
                return false;
            }
            object3 = this.f;
            object = ((b)object).Q();
            if (object3 != null) {
                bl2 = object3.equals(object);
            } else if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public a f() {
        int n10;
        Object object;
        boolean bl2;
        ArrayList<i.d.o.c> arrayList = new ArrayList<i.d.o.c>();
        ArrayList<i.d.s.a> arrayList2 = this.L().iterator();
        while (bl2 = arrayList2.hasNext()) {
            object = ((i.d.o.c)arrayList2.next()).a();
            arrayList.add((i.d.o.c)object);
        }
        arrayList2 = new ArrayList<i.d.s.a>();
        object = this.M().iterator();
        while ((n10 = object.hasNext()) != 0) {
            i.d.s.a a10 = ((i.d.s.a)object.next()).a();
            arrayList2.add(a10);
        }
        n10 = this.l;
        object = new b(arrayList, arrayList2, n10);
        return object;
    }

    public ByteBuffer g(i.d.p.f f10) {
        this.K().f(f10);
        c c10 = this.c;
        boolean bl2 = c10.isTraceEnabled();
        if (bl2) {
            Object object;
            int n10;
            c10 = this.c;
            int n11 = f10.g().remaining();
            Integer n12 = n11;
            Object object2 = f10.g();
            int n13 = ((Buffer)object2).remaining();
            if (n13 > (n10 = 1000)) {
                object2 = "too big to display";
            } else {
                object = f10.g().array();
                object2 = new String((byte[])object);
            }
            object = "afterEnconding({}): {}";
            c10.trace((String)object, (Object)n12, object2);
        }
        return this.G(f10);
    }

    public List h(String object, boolean bl2) {
        i.d.p.j j10 = new i.d.p.j();
        object = ByteBuffer.wrap(i.d.u.c.h((String)object));
        j10.l((ByteBuffer)object);
        j10.p(bl2);
        try {
            j10.j();
        }
        catch (InvalidDataException invalidDataException) {
            NotSendableException notSendableException = new NotSendableException(invalidDataException);
            throw notSendableException;
        }
        return Collections.singletonList(j10);
    }

    public int hashCode() {
        int n10;
        i.d.o.c c10 = this.d;
        int n11 = 0;
        if (c10 != null) {
            n10 = c10.hashCode();
        } else {
            n10 = 0;
            c10 = null;
        }
        n10 *= 31;
        i.d.s.a a10 = this.f;
        if (a10 != null) {
            n11 = a10.hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = this.l;
        int n12 = n11 >>> 32;
        return n10 + (n11 ^= n12);
    }

    public List i(ByteBuffer byteBuffer, boolean bl2) {
        i.d.p.a a10 = new i.d.p.a();
        a10.l(byteBuffer);
        a10.p(bl2);
        try {
            a10.j();
        }
        catch (InvalidDataException invalidDataException) {
            NotSendableException notSendableException = new NotSendableException(invalidDataException);
            throw notSendableException;
        }
        return Collections.singletonList(a10);
    }

    public CloseHandshakeType n() {
        return CloseHandshakeType.TWOWAY;
    }

    public i.d.q.b p(i.d.q.b b10) {
        int n10;
        String string2;
        Object object;
        String string3;
        boolean bl2;
        Object object2 = q;
        b10.a((String)object2, "websocket");
        b10.a(r, (String)object2);
        int n11 = 16;
        object2 = new byte[n11];
        this.k.nextBytes((byte[])object2);
        object2 = i.d.u.a.g((byte[])object2);
        b10.a(m, (String)object2);
        b10.a("Sec-WebSocket-Version", "13");
        object2 = new StringBuilder();
        Object object3 = this.e.iterator();
        while (true) {
            bl2 = object3.hasNext();
            string3 = ", ";
            if (!bl2) break;
            object = (i.d.o.c)object3.next();
            string2 = object.d();
            if (string2 == null || (n10 = (string2 = object.d()).length()) == 0) continue;
            n10 = ((StringBuilder)object2).length();
            if (n10 > 0) {
                ((StringBuilder)object2).append(string3);
            }
            object = object.d();
            ((StringBuilder)object2).append((String)object);
        }
        int n12 = ((StringBuilder)object2).length();
        if (n12 != 0) {
            object2 = ((StringBuilder)object2).toString();
            object3 = o;
            b10.a((String)object3, (String)object2);
        }
        object2 = new StringBuilder();
        object3 = this.g.iterator();
        while (bl2 = object3.hasNext()) {
            object = (i.d.s.a)object3.next();
            string2 = object.c();
            n10 = string2.length();
            if (n10 == 0) continue;
            n10 = ((StringBuilder)object2).length();
            if (n10 > 0) {
                ((StringBuilder)object2).append(string3);
            }
            object = object.c();
            ((StringBuilder)object2).append((String)object);
        }
        n12 = ((StringBuilder)object2).length();
        if (n12 != 0) {
            object2 = ((StringBuilder)object2).toString();
            object3 = n;
            b10.a((String)object3, (String)object2);
        }
        return b10;
    }

    public i.d.q.c q(i.d.q.a object, i.d.q.i i10) {
        i10.a(q, "websocket");
        String string2 = r;
        String string3 = object.j(string2);
        i10.a(string2, string3);
        string2 = m;
        object = object.j(string2);
        if (object != null) {
            object = this.I((String)object);
            string2 = p;
            i10.a(string2, (String)object);
            object = this.K().h();
            int n10 = ((String)object).length();
            if (n10 != 0) {
                object = this.K().h();
                string2 = o;
                i10.a(string2, (String)object);
            }
            if ((object = this.Q()) != null && (n10 = ((String)(object = this.Q().c())).length()) != 0) {
                object = this.Q().c();
                string2 = n;
                i10.a(string2, (String)object);
            }
            i10.h("Web Socket Protocol Handshake");
            i10.a("Server", "TooTallNate Java-WebSocket");
            object = this.R();
            i10.a("Date", (String)object);
            return i10;
        }
        object = new InvalidHandshakeException("missing Sec-WebSocket-Key");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void r(i object, i.d.p.f object2) {
        Opcode opcode;
        Opcode opcode2;
        Opcode opcode3 = object2.d();
        if (opcode3 == (opcode2 = Opcode.CLOSING)) {
            this.V((i)object, (i.d.p.f)object2);
            return;
        }
        Opcode opcode4 = Opcode.PING;
        if (opcode3 == opcode4) {
            j j10 = ((i)object).q();
            j10.onWebsocketPing((f)object, (i.d.p.f)object2);
            return;
        }
        Opcode opcode5 = Opcode.PONG;
        if (opcode3 == opcode5) {
            ((i)object).y();
            j j11 = ((i)object).q();
            j11.onWebsocketPong((f)object, (i.d.p.f)object2);
            return;
        }
        boolean bl2 = object2.f();
        if (bl2 && opcode3 != (opcode = Opcode.CONTINUOUS)) {
            i.d.p.f f10 = this.h;
            int n10 = 1002;
            if (f10 != null) {
                this.c.error("Protocol error: Continuous frame sequence not completed.");
                object = new InvalidDataException(n10, "Continuous frame sequence not completed.");
                throw object;
            }
            Opcode opcode6 = Opcode.TEXT;
            if (opcode3 == opcode6) {
                this.Z((i)object, (i.d.p.f)object2);
                return;
            }
            Opcode opcode7 = Opcode.BINARY;
            if (opcode3 == opcode7) {
                this.U((i)object, (i.d.p.f)object2);
                return;
            }
            object = this.c;
            object2 = "non control or continious frame expected";
            object.error((String)object2);
            object = new InvalidDataException(n10, (String)object2);
            throw object;
        }
        this.W((i)object, (i.d.p.f)object2, opcode3);
    }

    public String toString() {
        String string2 = super.toString();
        Object object = this.K();
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" extension: ");
            string2 = this.K().toString();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.Q()) != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" protocol: ");
            string2 = this.Q().toString();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" max frame size: ");
        int n10 = this.l;
        ((StringBuilder)object).append(n10);
        return ((StringBuilder)object).toString();
    }

    public void v() {
        this.j = null;
        i.d.o.c c10 = this.d;
        if (c10 != null) {
            c10.reset();
        }
        this.d = c10 = new i.d.o.b();
        this.f = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List x(ByteBuffer byteBuffer) {
        int n10;
        Object object;
        Object object2;
        while (true) {
            int n11;
            object2 = new LinkedList();
            object = this.j;
            if (object == null) break;
            try {
                byteBuffer.mark();
                n10 = byteBuffer.remaining();
                Object object3 = this.j;
                int n12 = ((Buffer)object3).remaining();
                if (n12 > n10) {
                    object2 = this.j;
                    object3 = byteBuffer.array();
                    int n13 = byteBuffer.position();
                    ((ByteBuffer)object2).put((byte[])object3, n13, n10);
                    n11 = byteBuffer.position() + n10;
                    byteBuffer.position(n11);
                    return Collections.emptyList();
                }
                object = this.j;
                byte[] byArray = byteBuffer.array();
                int n14 = byteBuffer.position();
                ((ByteBuffer)object).put(byArray, n14, n12);
                n10 = byteBuffer.position() + n12;
                byteBuffer.position(n10);
                object = this.j;
                object = ((ByteBuffer)object).duplicate();
                n12 = 0;
                object3 = null;
                object = ((ByteBuffer)object).position(0);
                object = (ByteBuffer)object;
                object = this.c0((ByteBuffer)object);
                object2.add(object);
                n10 = 0;
                object = null;
                this.j = null;
            }
            catch (IncompleteException incompleteException) {
                n11 = incompleteException.getPreferredSize();
                n11 = this.d(n11);
                object2 = ByteBuffer.allocate(n11);
                this.j.rewind();
                object = this.j;
                ((ByteBuffer)object2).put((ByteBuffer)object);
                this.j = object2;
                continue;
            }
            break;
        }
        while ((n10 = byteBuffer.hasRemaining()) != 0) {
            byteBuffer.mark();
            try {
                object = this.c0(byteBuffer);
                object2.add(object);
            }
            catch (IncompleteException incompleteException) {
                ByteBuffer byteBuffer2;
                byteBuffer.reset();
                n10 = incompleteException.getPreferredSize();
                n10 = this.d(n10);
                this.j = byteBuffer2 = ByteBuffer.allocate(n10);
                byteBuffer2.put(byteBuffer);
                return object2;
            }
        }
        return object2;
    }
}

