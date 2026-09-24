# 🌐 Network Traffic Analyzer

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/Pcap4J-2.0.0--alpha.6-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/Npcap-1.89-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/WebSocket-Live%20Data-purple?style=for-the-badge">
  <img src="https://img.shields.io/badge/Chart.js-Visualization-red?style=for-the-badge&logo=chartdotjs&logoColor=white">
</p>

<p align="center">
  <b>Real-Time Network Traffic Monitoring and Packet Analysis</b>
</p>

<p align="center">
  A Java and Spring Boot based network monitoring application that captures,
  analyzes, visualizes, and exports live network traffic.
</p>

---

## 📌 About the Project

**Network Traffic Analyzer** is a real-time web-based network monitoring application developed using Java, Spring Boot, Pcap4J, Npcap, WebSocket, HTML, CSS, JavaScript, and Chart.js.

The application captures live IPv4 network packets from a network interface and extracts useful information such as source IP, destination IP, protocol, ports, packet size, and timestamp.

The analyzed packets are sent from the Spring Boot backend to a web dashboard using WebSocket communication, allowing users to monitor network traffic in real time.

---

## 🎯 Objectives

- 📡 Capture live network packets
- 🔍 Analyze captured packets
- 🌐 Extract source and destination IP addresses
- 🔌 Extract source and destination ports
- 🔵 Identify TCP packets
- 🟢 Identify UDP packets
- 📦 Calculate packet sizes
- 🕒 Record packet timestamps
- 📊 Display real-time statistics
- 📈 Visualize traffic over time
- 🥧 Display protocol distribution
- 🔎 Search and filter packets
- 🔬 View packet details
- 📥 Export packet information as CSV

---

## 🏗️ System Architecture


                    🌐 Network
                        │
                        ▼
               📡 Network Interface
                        │
                        ▼
                     Npcap
                        │
                        ▼
                     Pcap4J
                        │
                        ▼
                📦 Packet Capture
                        │
                        ▼
              ☕ Java Packet Analyzer
                        │
                        ▼
                  Spring Boot
                  │         │
                  │         │
               REST API   WebSocket
                  │         │
                  └────┬────┘
                       ▼
                🖥️ Web Dashboard
                       │
          ┌────────────┼────────────┐
          ▼            ▼            ▼
       📊 Charts    📋 Packets    🔍 Search



---
##✨ Features
📡 Real-Time Packet Capture

Captures live network packets from the network interface using Pcap4J and Npcap.
---

##🔍 Packet Analysis

The application extracts:

Timestamp
Source IP
Destination IP
Protocol
Source Port
Destination Port
Packet Size
📊 Network Statistics

The dashboard displays:

Total Packets
TCP Packets
UDP Packets
Total Bytes
📈 Traffic Over Time

A line chart displays the number of captured packets over time.

🥧 Protocol Distribution

A pie chart displays the distribution of:

TCP
UDP
Other
📋 Live Packet Table

New packets are displayed in the dashboard as they are captured.

🔎 Packet Search

Users can search captured packets using:

IP address
Protocol
Port number
🔬 Packet Details

Clicking a packet displays detailed information about that packet.

📥 CSV Export

Captured packet information can be exported as a CSV file.

🛠️ Technologies Used
<p align="center"> <img src="https://skillicons.dev/icons?i=java,spring,maven,html,css,js" /> </p>
Backend
☕ Java
🍃 Spring Boot
🌐 Spring Web
🔄 Spring WebSocket
📦 Pcap4J
Network Capture
🛡️ Npcap
WinPcap-compatible API
Frontend
🌐 HTML
🎨 CSS
⚡ JavaScript
📊 Chart.js
Tools
Visual Studio Code
Git
GitHub
Maven Wrapper
📂 Project Structure
network-traffic-analyzer/
│
├── .mvn/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── Network/
│       │       └── Traffic/
│       │           └── Analyzer/
│       │               ├── NetworkTrafficAnalyzerApplication.java
│       │               ├── PacketInfo.java
│       │               ├── PacketStats.java
│       │               ├── PacketCaptureService.java
│       │               ├── PacketCaptureController.java
│       │               ├── PacketWebSocketHandler.java
│       │               └── WebSocketConfig.java
│       │
│       └── resources/
│           ├── static/
│           │   └── index.html
│           └── application.properties
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── README.md
└── .gitignore
⚙️ How It Works
1. Network Packet Capture

Npcap provides access to the Windows network interface.

Pcap4J uses the Npcap interface to capture live network packets.

2. Packet Processing

The Java application analyzes each captured IPv4 packet and extracts:

Timestamp
Source IP
Destination IP
Protocol
Source Port
Destination Port
Packet Size
3. Spring Boot Backend

Spring Boot provides REST APIs for controlling packet capture and retrieving statistics.

/api/capture/start
/api/capture/stop
/api/packets
/api/stats
/api/traffic-over-time
4. WebSocket Communication

Captured packets are sent to the frontend in real time through:

/ws/packets
5. Web Dashboard

The frontend displays:

Live packets
Statistics
Traffic charts
Protocol distribution
Packet details
Search results
🚀 Getting Started
Prerequisites

Install the following:

Java 17 or higher
Npcap
Git
Visual Studio Code or another Java IDE

Maven does not need to be installed globally because the project uses the Maven Wrapper.

🛡️ Npcap Setup

This project requires Npcap for packet capture on Windows.

During Npcap installation, enable:

WinPcap API-compatible Mode

After installing Npcap, restart Visual Studio Code or your development environment.

📥 Clone the Repository
git clone https://github.com/digullagopichand/network-traffic-analyzer.git
cd network-traffic-analyzer
▶️ Run the Application

On Windows, run:

.\mvnw.cmd spring-boot:run

The Spring Boot server runs on:

http://localhost:8081

Open the above address in your browser to access the dashboard.

🖥️ Dashboard

The dashboard provides:

▶️ Start Capture
⏹️ Stop Capture
📥 Export CSV
📊 Total Packet Statistics
🔵 TCP Statistics
🟢 UDP Statistics
📦 Total Bytes
📈 Traffic Over Time
🥧 Protocol Distribution
🔎 Packet Search
📋 Live Packet Table
🔬 Packet Details
📡 Packet Information
Field	Description
🕒 Timestamp	Time when the packet was captured
🌐 Source IP	Source IPv4 address
🌐 Destination IP	Destination IPv4 address
🔌 Protocol	TCP / UDP / Other
📤 Source Port	Source network port
📥 Destination Port	Destination network port
📦 Packet Size	Packet size in bytes
🔌 API Endpoints
Method	Endpoint	Description
GET	/api/capture/start	Start packet capture
GET	/api/capture/stop	Stop packet capture
GET	/api/packets	Get captured packets
GET	/api/stats	Get packet statistics
GET	/api/traffic-over-time	Get traffic statistics over time
WebSocket	/ws/packets	Receive live packets
📊 Statistics

The application calculates:

Total Packets
      │
      ├── TCP Packets
      │
      ├── UDP Packets
      │
      └── Other Packets

Total Bytes
📈 Traffic Monitoring

The traffic-over-time chart displays packet activity based on packet timestamps.

This allows users to observe changes in network traffic while packet capture is running.

📥 CSV Export

The dashboard provides an Export CSV button.

Captured packet information can be downloaded as:

network-traffic.csv

The exported file contains:

Time
Source IP
Destination IP
Protocol
Source Port
Destination Port
Packet Size
🔄 Real-Time WebSocket Flow
Network Packet
      │
      ▼
Pcap4J
      │
      ▼
Java Packet Analyzer
      │
      ▼
Spring Boot
      │
      ▼
WebSocket
      │
      ▼
Browser
      │
      ▼
Live Packet Table

The WebSocket connection allows newly captured packets to appear on the dashboard without refreshing the webpage.

🔐 Notes
Packet capture requires Npcap.
The application currently analyzes IPv4 traffic.
TCP and UDP packets are identified separately.
Other IPv4 protocols are classified as Other.
The current implementation uses a network interface available on the host system.
This project is intended primarily for academic and educational purposes.
---
