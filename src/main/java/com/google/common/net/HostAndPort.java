/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;

public final class HostAndPort
implements Serializable {
    private static final int NO_PORT = 255;
    private static final long serialVersionUID;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String string2, int n10, boolean bl2) {
        this.host = string2;
        this.port = n10;
        this.hasBracketlessColons = bl2;
    }

    public static HostAndPort fromHost(String string2) {
        HostAndPort hostAndPort = HostAndPort.fromString(string2);
        Preconditions.checkArgument(hostAndPort.hasPort() ^ true, "Host has a port: %s", (Object)string2);
        return hostAndPort;
    }

    public static HostAndPort fromParts(String object, int n10) {
        Preconditions.checkArgument(HostAndPort.isValidPort(n10), "Port out of range: %s", n10);
        HostAndPort hostAndPort = HostAndPort.fromString((String)object);
        Preconditions.checkArgument(hostAndPort.hasPort() ^ true, "Host has a port: %s", object);
        String string2 = hostAndPort.host;
        boolean bl2 = hostAndPort.hasBracketlessColons;
        object = new HostAndPort(string2, n10, bl2);
        return object;
    }

    public static HostAndPort fromString(String object) {
        int n10;
        Object object2;
        Preconditions.checkNotNull(object);
        Object object22 = "[";
        boolean n11 = ((String)object).startsWith((String)object22);
        int n12 = -1;
        int n13 = 1;
        int n14 = 0;
        if (n11) {
            object22 = HostAndPort.getHostAndPortFromBracketedHost((String)object);
            object2 = object22[0];
            object22 = object22[n13];
        } else {
            int n15;
            int n16 = 58;
            int n17 = ((String)object).indexOf(n16);
            if (n17 >= 0 && (n15 = ((String)object).indexOf(n16, n10 = n17 + 1)) == n12) {
                object2 = ((String)object).substring(0, n17);
                object22 = ((String)object).substring(n10);
            } else {
                if (n17 >= 0) {
                    n14 = n13;
                }
                boolean bl2 = false;
                object22 = null;
                object2 = object;
            }
        }
        n10 = (int)(Strings.isNullOrEmpty((String)object22) ? 1 : 0);
        if (n10 == 0) {
            CharSequence charSequence = "+";
            n12 = ((String)object22).startsWith((String)charSequence) ^ n13;
            String string2 = "Unparseable port number: %s";
            Preconditions.checkArgument(n12 != 0, string2, object);
            try {
                n12 = Integer.parseInt((String)object22);
            }
            catch (NumberFormatException numberFormatException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Unparseable port number: ");
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                object22 = new IllegalArgumentException((String)object);
                throw object22;
            }
            boolean bl3 = HostAndPort.isValidPort(n12);
            string2 = "Port number out of range: %s";
            Preconditions.checkArgument(bl3, string2, object);
        }
        object = new HostAndPort((String)object2, n12, n14 != 0);
        return object;
    }

    private static String[] getHostAndPortFromBracketedHost(String object) {
        String[] stringArray;
        int n10 = object.charAt(0);
        int n11 = 1;
        int n12 = 91;
        if (n10 == n12) {
            n10 = n11;
        } else {
            n10 = 0;
            stringArray = null;
        }
        String string2 = "Bracketed host-port string must start with a bracket: %s";
        Preconditions.checkArgument(n10 != 0, string2, object);
        n10 = 58;
        n12 = object.indexOf(n10);
        int n13 = object.lastIndexOf(93);
        int n14 = -1;
        if (n12 > n14 && n13 > n12) {
            n12 = n11;
        } else {
            n12 = 0;
            string2 = null;
        }
        String string3 = "Invalid bracketed host/port: %s";
        Preconditions.checkArgument(n12 != 0, string3, object);
        string2 = object.substring(n11, n13);
        n14 = n13 + 1;
        int n15 = object.length();
        int n16 = 2;
        if (n14 == n15) {
            object = new String[n16];
            object[0] = string2;
            object[n11] = "";
            return object;
        }
        if ((n14 = (int)object.charAt(n14)) == n10) {
            n10 = n11;
        } else {
            n10 = 0;
            stringArray = null;
        }
        string3 = "Only a colon may follow a close bracket: %s";
        Preconditions.checkArgument(n10 != 0, string3, object);
        for (n10 = n13 += n16; n10 < (n14 = object.length()); ++n10) {
            n14 = (int)(Character.isDigit(object.charAt(n10)) ? 1 : 0);
            String string4 = "Port must be numeric: %s";
            Preconditions.checkArgument(n14 != 0, string4, object);
        }
        stringArray = new String[n16];
        stringArray[0] = string2;
        stringArray[n11] = object = object.substring(n13);
        return stringArray;
    }

    private static boolean isValidPort(int n10) {
        char c10;
        n10 = n10 >= 0 && n10 <= (c10 = (char)-1) ? 1 : 0;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof HostAndPort;
        if (n10 != 0) {
            int n11;
            object = (HostAndPort)object;
            String string2 = this.host;
            String string3 = ((HostAndPort)object).host;
            n10 = Objects.equal(string2, string3);
            if (n10 == 0 || (n10 = this.port) != (n11 = ((HostAndPort)object).port)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Preconditions.checkState(this.hasPort());
        return this.port;
    }

    public int getPortOrDefault(int n10) {
        boolean bl2 = this.hasPort();
        if (bl2) {
            n10 = this.port;
        }
        return n10;
    }

    public boolean hasPort() {
        int n10 = this.port;
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public int hashCode() {
        Object object = this.host;
        object = this.port;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hashCode(objectArray);
    }

    public HostAndPort requireBracketsForIPv6() {
        boolean bl2 = this.hasBracketlessColons ^ true;
        String string2 = this.host;
        Preconditions.checkArgument(bl2, "Possible bracketless IPv6 literal: %s", (Object)string2);
        return this;
    }

    public String toString() {
        int n10 = this.host.length() + 8;
        StringBuilder stringBuilder = new StringBuilder(n10);
        String string2 = this.host;
        char c10 = ':';
        n10 = string2.indexOf(c10);
        if (n10 >= 0) {
            stringBuilder.append('[');
            string2 = this.host;
            stringBuilder.append(string2);
            n10 = 93;
            stringBuilder.append((char)n10);
        } else {
            string2 = this.host;
            stringBuilder.append(string2);
        }
        n10 = (int)(this.hasPort() ? 1 : 0);
        if (n10 != 0) {
            stringBuilder.append(c10);
            n10 = this.port;
            stringBuilder.append(n10);
        }
        return stringBuilder.toString();
    }

    public HostAndPort withDefaultPort(int n10) {
        Preconditions.checkArgument(HostAndPort.isValidPort(n10));
        boolean bl2 = this.hasPort();
        if (bl2) {
            return this;
        }
        String string2 = this.host;
        boolean bl3 = this.hasBracketlessColons;
        HostAndPort hostAndPort = new HostAndPort(string2, n10, bl3);
        return hostAndPort;
    }
}

