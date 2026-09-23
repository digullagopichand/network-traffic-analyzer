package Network.Traffic.Analyzer;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacketWebSocketHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> sessions =
            new ArrayList<>();

    @Override
    public void afterConnectionEstablished(
            WebSocketSession session) {

        sessions.add(session);

        System.out.println(
                "WebSocket connected: "
                        + session.getId()
        );
    }

    public void sendPacket(PacketInfo packet) {

        try {

            String json = "{"
                    + "\"timestamp\":\"" + packet.getTimestamp() + "\","
                    + "\"sourceIp\":\"" + packet.getSourceIp() + "\","
                    + "\"destinationIp\":\"" + packet.getDestinationIp() + "\","
                    + "\"protocol\":\"" + packet.getProtocol() + "\","
                    + "\"sourcePort\":" + packet.getSourcePort() + ","
                    + "\"destinationPort\":" + packet.getDestinationPort() + ","
                    + "\"packetSize\":" + packet.getPacketSize()
                    + "}";

            for (WebSocketSession session : sessions) {

                if (session.isOpen()) {

                    session.sendMessage(
                            new TextMessage(json)
                    );
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session,
            org.springframework.web.socket.CloseStatus status) {

        sessions.remove(session);

        System.out.println(
                "WebSocket disconnected: "
                        + session.getId()
        );
    }
}