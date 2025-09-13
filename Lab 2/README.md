# RFC 865 UDP Quote of the Day (QOTD) Server & Client

This project implements the **RFC 865 Quote of the Day Protocol** using UDP sockets in Java.

- **Server**: Listens for UDP requests on a fixed port and responds with a quote.
- **Client**: Sends a request to the server and prints the received quote.

---

## 📂 Project Files

- `RFC_865_Server.java` – UDP server implementation.
- `Rfc865UdpClient.java` – UDP client implementation.
- `README.md` – Documentation (this file).

---

## ⚙️ How It Works

- The **server** opens a UDP socket on a known port (default: `5000` for testing, or `17` for RFC compliance).
- The **client** opens its own UDP socket on a random free port, sends a request, and waits for the server's reply.
- The server replies with a predefined "Quote of the Day" string.

---

## 🚀 Running the Programs

### 1. Compile

Open a terminal in the project folder and run:

```bash
javac RFC_865_Server.java Rfc865UdpClient.java
```
