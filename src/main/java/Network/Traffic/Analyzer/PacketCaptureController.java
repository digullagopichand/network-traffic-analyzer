package Network.Traffic.Analyzer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacketCaptureController {

    private final PacketCaptureService packetCaptureService;

    public PacketCaptureController(PacketCaptureService packetCaptureService) {
        this.packetCaptureService = packetCaptureService;
    }

    @GetMapping("/api/capture/start")
    public String startCapture() {

        Thread thread = new Thread(() -> {
            try {
                packetCaptureService.startCapture();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();

        return "Packet capture started";
    }

    @GetMapping("/api/capture/stop")
    public String stopCapture() {

        packetCaptureService.stopCapture();

        return "Packet capture stopped";
    }

    @GetMapping("/api/packets")
public List<PacketInfo> getPackets() {

    return packetCaptureService.getPackets();
}

    @GetMapping("/api/stats")
public PacketStats getStats() {

    List<PacketInfo> packets =
            packetCaptureService.getPackets();

    int totalPackets = packets.size();
    int tcpPackets = 0;
    int udpPackets = 0;
    int totalBytes = 0;

    for (PacketInfo packet : packets) {

        if (packet.getProtocol().equals("TCP")) {
            tcpPackets++;
        }

        if (packet.getProtocol().equals("UDP")) {
            udpPackets++;
        }

        totalBytes += packet.getPacketSize();
    }

    return new PacketStats(
            totalPackets,
            tcpPackets,
            udpPackets,
            totalBytes
    );
}
}