# 🌐  Network Traffic Analyzer

<p align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot" />
  <img src="https://img.shields.io/badge/Pcap4J-Packet%20Capture-blue" />
  <img src="https://img.shields.io/badge/HTML5-E34F26?logo=html5&logoColor=white" />
  <img src="https://img.shields.io/badge/CSS3-1572B6?logo=css3&logoColor=white" />
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?logo=javascript&logoColor=black" />
  <img src="https://img.shields.io/badge/WebSocket-Real--Time-purple" />
  <img src="https://img.shields.io/badge/Chart.js-Visualization-FF6384?logo=chartdotjs" />
  <img src="https://img.shields.io/badge/GitHub-Version%20Control-black?logo=github" />
</p>

<p align="center">
A Java-based web application for real-time network packet capture, analysis, and visualization.
</p>

---

## 📌 Project Overview

The **Web-Based Network Traffic Analyzer** is a Java-based web application designed to capture, analyze, and visualize network traffic in real time.

The system captures network packets and extracts information such as source IP address, destination IP address, protocol, port numbers, packet size, and timestamp. This information is displayed through a web-based dashboard using tables, charts, and real-time updates.

The main purpose of this project is to make Computer Network concepts easier to understand by providing a practical and visual representation of network communication.

---

## 🎯 Objectives

- Capture network packets in real time
- Analyze basic packet information
- Identify protocols such as TCP, UDP, and ICMP
- Display source and destination IP addresses
- Display source and destination port numbers
- Monitor packet sizes and traffic statistics
- Visualize network traffic using charts
- Provide a real-time web dashboard
- Help students understand practical Computer Network concepts

---

## 🚀 Features

### Real-Time Packet Capture

Captures live network packets from the system's network interface.

### Packet Analysis

Extracts:

- Source IP
- Destination IP
- Source Port
- Destination Port
- Protocol
- Packet Size
- Timestamp

### Protocol Analysis

Supports analysis of common protocols such as:

- TCP
- UDP
- ICMP
- DNS
- HTTP/HTTPS where identifiable

### Real-Time Dashboard

Displays:

- Total packets
- TCP packets
- UDP packets
- ICMP packets
- Incoming traffic
- Outgoing traffic
- Packet size statistics
- Protocol distribution

### Live Packet Table

Displays captured packets with continuously updated information.

### Data Visualization

Provides charts for:

- Protocol distribution
- Packet count
- Traffic volume
- Incoming vs outgoing traffic

### Packet Details

Allows users to select a packet and view its detailed information.

---

## 🏗️ System Architecture

```text
                Network Traffic
                       │
                       ▼
              Network Interface
                       │
                       ▼
                Pcap4J Capture
                       │
                       ▼
             Java Packet Analyzer
                       │
             ┌─────────┴─────────┐
             │                   │
             ▼                   ▼
        REST APIs            WebSocket
             │                   │
             └─────────┬─────────┘
                       ▼
                Web Dashboard
                       │
             ┌─────────┼─────────┐
             ▼         ▼         ▼
          Tables     Charts    Statistics

🛠️ Technologies Used
Backend
Java
Spring Boot
Pcap4J
REST API
WebSocket
Frontend
HTML
CSS
JavaScript
Chart.js
Database

SQLite or MongoDB may be used for storing packet history and analysis data.

Development Tools
VS Code / IntelliJ IDEA
Git
GitHub
Maven
📂 Planned Project Structure
network-traffic-analyzer/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── analyzer/
│   ├── model/
│   └── config/
│
├── frontend/
│   ├── index.html
│   ├── css/
│   └── js/
│
├── README.md
└── pom.xml

🔄 How the System Works
The application starts network packet capture.
Pcap4J captures packets from the selected network interface.
Java analyzes each packet.
Important packet information is extracted.
The backend sends the analyzed data to the web dashboard.
The dashboard updates packet information and statistics in real time.
Charts visualize the network traffic.
Users can inspect individual packet details.
📊 Example Packet Information
Source IP	Destination IP	Protocol	Source Port	Destination Port	Size
192.168.1.10	142.250.x.x	TCP	52341	443	1280
192.168.1.10	8.8.8.8	UDP	52120	53	74
192.168.1.10	192.168.1.1	ICMP	-	-	98

Actual values depend on the network traffic being captured.
