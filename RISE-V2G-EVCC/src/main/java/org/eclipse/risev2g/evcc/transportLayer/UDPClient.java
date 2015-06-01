/*******************************************************************************
 *  Copyright (c) 2015 Marc Mültin (Chargepartner GmbH).
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Dr.-Ing. Marc Mültin (Chargepartner GmbH) - initial API and implementation and initial documentation
 *******************************************************************************/
package org.eclipse.risev2g.evcc.transportLayer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet6Address;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.risev2g.shared.enumerations.GlobalValues;
import org.eclipse.risev2g.shared.misc.TimeRestrictions;
import org.eclipse.risev2g.shared.misc.V2GTPMessage;
import org.eclipse.risev2g.shared.utils.MiscUtils;

/**
 * The UDP client is handling the SECCDiscovery messages only. The standard does not
 * foresee any further communication to be done via UDP but TCP. 
 * Therefore, the size of the UPD packet to be received is restricted to 28 bytes 
 * (8 bytes header of V2GTP message + 20 byte SECCDiscoveryRes payload).
 */
public class UDPClient {
	
	/*
	 *  Eager instantiation of the singleton, since a UDP client is always needed upfront. 
	 *  The JVM creates the unique instance when the class is loaded and before any thread tries to 
	 *  access the instance variable -> thread safe.
	 */
	private Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
	private static final UDPClient uniqueUDPClientInstance = new UDPClient();
	private int multicastSocketPort;
	private Inet6Address multicastAddress;
	private MulticastSocket socketToUDPServer;
	private byte[] udpServerResponse;
	private DatagramPacket udpServerPacket;
	private Inet6Address udpClientAddress;
	
	private UDPClient() {
		setUdpServerResponse(new byte[28]);
	}
	
	/**
	 * Used to check the correct initialization of a UDP client which is a prerequisite for establishing
	 * a V2G communication session.
	 * @return True if the initialization of the UDP client was successful, false otherwise
	 */
	public boolean initialize() {
		setSocketToUDPServer(null);
		
		// Try to find a free port within the range of V2G_UDP_SDP_Client (see Table 15) 
		while (getSocketToUDPServer() == null) {
			try {
				setUdpClientAddress(MiscUtils.getLinkLocalAddress());
				
				if (getUdpClientAddress() == null) return false;
				
				setMulticastAddress((Inet6Address) Inet6Address.getByName(GlobalValues.SDP_MULTICAST_ADDRESS.toString()));
				setMulticastSocketPort(MiscUtils.getRandomPortNumber());
				setSocketToUDPServer(new MulticastSocket(getMulticastSocketPort()));
				
				// Without setting the interface, the UDP server will not receive the requests
				getSocketToUDPServer().setInterface(getUdpClientAddress());
				
				getSocketToUDPServer().joinGroup(getMulticastAddress());
				
				getLogger().info("UDP client initialized at address " + 
								 getUdpClientAddress().getHostAddress() + " and port " + getMulticastSocketPort());
				return true;
			} catch (UnknownHostException e) {
				getLogger().error("Initialization of UDPClient failed (Unknown host exception)!", e); 
				return false;
			} catch (IOException e) {
				getLogger().debug("MulticastSocket creation failed, UDPClient port " + multicastSocketPort + 
								  " may not be free, trying another port.", e);
				setSocketToUDPServer(null);
				return false;
			}
		}
		
		return false;
	}
	

	public static UDPClient getInstance() {
		return uniqueUDPClientInstance;
	}
	
	
	public byte[] send(V2GTPMessage v2gTPMessage) {
		// Set up the UDP packet containing the V2GTP message to be sent to the UDP server
		DatagramPacket udpClientPacket = new DatagramPacket(v2gTPMessage.getMessage(), 
															v2gTPMessage.getMessage().length, 
											 				getMulticastAddress(), 
											 				GlobalValues.V2G_UDP_SDP_SERVER_PORT.getShortValue());
		
		setUdpServerPacket(new DatagramPacket(getUdpServerResponse(), getUdpServerResponse().length));
		
		try {
			getSocketToUDPServer().setSoTimeout(TimeRestrictions.SDP_RESPONSE_TIMEOUT);
			getSocketToUDPServer().send(udpClientPacket);
			getLogger().debug("Message sent");
			
			// Wait for the UDP Response (receive() blocks until the data arrives)
			getSocketToUDPServer().receive(getUdpServerPacket());
			getLogger().debug("Message received");
			
			return getUdpServerPacket().getData();
		} catch (SocketTimeoutException e) {
			getLogger().error("A SocketTimeoutException was thrown while waiting for input stream from UDPServer");
		} catch (UnknownHostException e) {
			getLogger().error("UDP request failed (UnknownHostException)!", e);
		} catch (IOException e) {
			getLogger().error("UDP request failed (IOException)!", e);
		}
		
		return null;
	}
	

	public void stop() {
		// the UDPClient is not supposed to be stopped
	}
	
	
	public Logger getLogger() {
		return logger;
	}
	

	public int getMulticastSocketPort() {
		return multicastSocketPort;
	}


	private void setMulticastSocketPort(int multicastSocketPort) {
		this.multicastSocketPort = multicastSocketPort;
	}


	public Inet6Address getMulticastAddress() {
		return multicastAddress;
	}


	private void setMulticastAddress(Inet6Address multicastAddress) {
		this.multicastAddress = multicastAddress;
	}


	public MulticastSocket getSocketToUDPServer() {
		return socketToUDPServer;
	}


	private void setSocketToUDPServer(MulticastSocket socketToUDPServer) {
		this.socketToUDPServer = socketToUDPServer;
	}


	public byte[] getUdpServerResponse() {
		return udpServerResponse;
	}


	private void setUdpServerResponse(byte[] udpServerResponse) {
		this.udpServerResponse = udpServerResponse;
	}


	public DatagramPacket getUdpServerPacket() {
		return udpServerPacket;
	}


	private void setUdpServerPacket(DatagramPacket udpServerPacket) {
		this.udpServerPacket = udpServerPacket;
	}

	public Inet6Address getUdpClientAddress() {
		return udpClientAddress;
	}
	
	private void setUdpClientAddress(Inet6Address udpClientAddress) {
		this.udpClientAddress = udpClientAddress;
	}
}