all:
	javac $(shell find . -name \*.java)

run: all
	java pong.gui.Serveur &
	xterm -e "java pong.gui.Client; $SHELL" &
	java pong.Main	

clean:
	rm $(shell find . -name \*.class)
