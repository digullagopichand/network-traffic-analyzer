package Network.Traffic.Analyzer;

public class PacketStats {

    private int totalPackets;
    private int tcpPackets;
    private int udpPackets;
    private int totalBytes;

    public PacketStats(int totalPackets, int tcpPackets,
                       int udpPackets, int totalBytes) {

        this.totalPackets = totalPackets;
        this.tcpPackets = tcpPackets;
        this.udpPackets = udpPackets;
        this.totalBytes = totalBytes;
    }

    public int getTotalPackets() {
        return totalPackets;
    }

    public int getTcpPackets() {
        return tcpPackets;
    }

    public int getUdpPackets() {
        return udpPackets;
    }

    public int getTotalBytes() {
        return totalBytes;
    }
}