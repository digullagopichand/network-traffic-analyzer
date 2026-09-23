package Network.Traffic.Analyzer;

import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.IpV4Packet;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.TcpPacket;
import org.pcap4j.packet.UdpPacket;

import java.util.List;

public class PacketCapture {

    public static void main(String[] args) throws Exception {

        List<PcapNetworkInterface> devices = Pcaps.findAllDevs();

        System.out.println("Available Network Interfaces:");

        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + " : " + devices.get(i).getName());
            System.out.println("    " + devices.get(i).getDescription());
        }

        // Wi-Fi adapter
        PcapNetworkInterface device = devices.get(4);

        System.out.println();
        System.out.println("Capturing packets from: " + device.getName());

        PcapHandle handle = device.openLive(
                65536,
                PcapNetworkInterface.PromiscuousMode.PROMISCUOUS,
                10
        );

        System.out.println("Packet capture started...");
        System.out.println();

        int count = 0;

        while (count < 10) {

            Packet packet = handle.getNextPacket();

            if (packet != null) {

                count++;

                System.out.println("Packet " + count);
                System.out.println("Size: " + packet.length() + " bytes");

                IpV4Packet ipPacket = packet.get(IpV4Packet.class);

                if (ipPacket != null) {

                    String sourceIp =
                            ipPacket.getHeader().getSrcAddr().getHostAddress();

                    String destinationIp =
                            ipPacket.getHeader().getDstAddr().getHostAddress();

                    System.out.println("Source IP      : " + sourceIp);
                    System.out.println("Destination IP : " + destinationIp);

                    TcpPacket tcpPacket = packet.get(TcpPacket.class);

                    if (tcpPacket != null) {

                        System.out.println("Protocol       : TCP");
                        System.out.println("Source Port    : "
                                + tcpPacket.getHeader().getSrcPort().valueAsInt());
                        System.out.println("Destination Port: "
                                + tcpPacket.getHeader().getDstPort().valueAsInt());
                    }

                    UdpPacket udpPacket = packet.get(UdpPacket.class);

                    if (udpPacket != null) {

                        System.out.println("Protocol       : UDP");
                        System.out.println("Source Port    : "
                                + udpPacket.getHeader().getSrcPort().valueAsInt());
                        System.out.println("Destination Port: "
                                + udpPacket.getHeader().getDstPort().valueAsInt());
                    }
                }

                System.out.println("-------------------------");
            }
        }

        handle.close();

        System.out.println("Packet capture stopped.");
    }
}