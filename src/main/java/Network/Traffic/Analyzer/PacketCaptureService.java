package Network.Traffic.Analyzer;

import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.TcpPacket;
import org.pcap4j.packet.UdpPacket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacketCaptureService {

    private PcapHandle handle;
    private boolean capturing = false;
    private final PacketWebSocketHandler webSocketHandler;

    public PacketCaptureService(PacketWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }
    private List<PacketInfo> packets = new ArrayList<>();

    public void startCapture() throws Exception {

        if (capturing) {
            System.out.println("Capture is already running.");
            return;
        }

        packets.clear();

        List<PcapNetworkInterface> devices = Pcaps.findAllDevs();

        PcapNetworkInterface device = devices.get(4);

        handle = device.openLive(
                65536,
                PcapNetworkInterface.PromiscuousMode.PROMISCUOUS,
                10
        );

        capturing = true;

        System.out.println("Packet capture started...");

        while (capturing) {

    Packet packet;

    try {
        packet = handle.getNextPacket();
    } catch (Exception e) {
        if (!capturing) {
            break;
        }
        throw e;
    }

    if (packet != null) {

                IpV4Packet ipPacket =
                        packet.get(IpV4Packet.class);

                if (ipPacket != null) {

                    String sourceIp =
                            ipPacket.getHeader()
                                    .getSrcAddr()
                                    .getHostAddress();

                    String destinationIp =
                            ipPacket.getHeader()
                                    .getDstAddr()
                                    .getHostAddress();

                    String protocol = "Other";
                    int sourcePort = 0;
                    int destinationPort = 0;

                    TcpPacket tcpPacket =
                            packet.get(TcpPacket.class);

                    UdpPacket udpPacket =
                            packet.get(UdpPacket.class);

                    if (tcpPacket != null) {

                        protocol = "TCP";

                        sourcePort =
                                tcpPacket.getHeader()
                                        .getSrcPort()
                                        .valueAsInt();

                        destinationPort =
                                tcpPacket.getHeader()
                                        .getDstPort()
                                        .valueAsInt();
                    }

                    else if (udpPacket != null) {

                        protocol = "UDP";

                        sourcePort =
                                udpPacket.getHeader()
                                        .getSrcPort()
                                        .valueAsInt();

                        destinationPort =
                                udpPacket.getHeader()
                                        .getDstPort()
                                        .valueAsInt();
                    }

                    String timestamp =
        java.time.LocalTime.now()
                .withNano(0)
                .toString();

PacketInfo packetInfo = new PacketInfo(
        timestamp,
        sourceIp,
        destinationIp,
        protocol,
        sourcePort,
        destinationPort,
        packet.length()
);

                    packets.add(packetInfo);

webSocketHandler.sendPacket(packetInfo);

System.out.println(
        "Captured packet: "
                + sourceIp
                + " -> "
                + destinationIp
                + " | "
                + protocol
);
                }
            }
        }
    }

    public void stopCapture() {

        capturing = false;

        if (handle != null) {
            handle.close();
            handle = null;
        }

        System.out.println("Packet capture stopped.");
    }

    public List<PacketInfo> getPackets() {
        return packets;
    }
}