package transport;

/**
 * @author sterling
 *
 */
public class NetInfo {

	private static String ip = "192.168.1.144";
	private static int port = 9002;
	
	/**
	 * @return the ip
	 */
	public static String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public static void setIp(String ip) {
		NetInfo.ip = ip;
	}
	/**
	 * @return the port
	 */
	public static int getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public static void setPort(int port) {
		NetInfo.port = port;
	}

}
