startTcpServer:
	java TcpServer.java

build:
	javac -d out a/*.java

start:
	if [ -e "./out" ]; then cd out && java a.A2; else make bstart; fi

bstart:
	make build
	make start
