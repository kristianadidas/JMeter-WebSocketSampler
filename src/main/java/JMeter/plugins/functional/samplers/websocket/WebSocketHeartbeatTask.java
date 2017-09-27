package JMeter.plugins.functional.samplers.websocket;

import org.apache.commons.lang3.StringUtils;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import java.util.TimerTask;

/**
 * Created by nejcl on 27/09/2017.
 */
public class WebSocketHeartbeatTask extends TimerTask {

    private ServiceSocket socket;
    private static final Logger log = LoggingManager.getLoggerForClass();

    public WebSocketHeartbeatTask(ServiceSocket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            log.info("Sending heartbeat");
            socket.sendMessage("heartbeat");
        }
        catch (Exception e) {
            log.info("Heartbeat missed");
        }

    }
}
