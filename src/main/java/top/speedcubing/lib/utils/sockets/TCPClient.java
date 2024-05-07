package top.speedcubing.lib.utils.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import top.speedcubing.lib.utils.bytes.IOUtils;

public class TCPClient {
    private final String host;
    private final int timeout;

    public TCPClient(String host, int timeout) {
        this.host = host;
        this.timeout = timeout;
    }

    public void send(int port, byte[] data) {
        try {
            sendUnsafe(port, data);
        } catch (IOException e) {
        }
    }

    public void sendUnsafe(int port, byte[] data) throws IOException {
        Socket client = new Socket();
        client.connect(new InetSocketAddress(host, port), timeout);
        client.getOutputStream().write(data);
        IOUtils.closeQuietly(client);
    }
}
