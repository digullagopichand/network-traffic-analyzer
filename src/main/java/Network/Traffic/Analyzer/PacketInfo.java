package Network.Traffic.Analyzer;

public class PacketInfo {

    private String timestamp;
    private String sourceIp;
    private String destinationIp;
    private String protocol;
    private int sourcePort;
    private int destinationPort;
    private int packetSize;

    public PacketInfo() {
    }

    public PacketInfo(String timestamp,
                      String sourceIp,
                      String destinationIp,
                      String protocol,
                      int sourcePort,
                      int destinationPort,
                      int packetSize) {

        this.timestamp = timestamp;
        this.sourceIp = sourceIp;
        this.destinationIp = destinationIp;
        this.protocol = protocol;
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
        this.packetSize = packetSize;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public int getPacketSize() {
        return packetSize;
    }
}