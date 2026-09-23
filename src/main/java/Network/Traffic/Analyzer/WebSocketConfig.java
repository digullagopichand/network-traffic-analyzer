package Network.Traffic.Analyzer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final PacketWebSocketHandler packetWebSocketHandler;

    public WebSocketConfig(PacketWebSocketHandler packetWebSocketHandler) {
        this.packetWebSocketHandler = packetWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(
            WebSocketHandlerRegistry registry) {

        registry.addHandler(
                packetWebSocketHandler,
                "/ws/packets"
        ).setAllowedOrigins("*");
    }
}