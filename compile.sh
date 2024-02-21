#!bin/bash

echo "Compiling guis.."
javac Window/gui/gui.java
javac Window/gui/start_gui/start_gui.java
echo "Compiling input layer.."
javac Window/input/inputBufferInterface.java
javac Window/input/input.java
echo "Compiling entity"

javac classes/entityGroup/entityGroup.java
javac classes/entity/entityIdInterface.java
javac classes/entity/entity.java

javac classes/entity/player/player.java
javac classes/entity/npc/npc.java


echo "Compiling window system.."
javac Window/Window.java
echo "Compiling debugger.."
javac Debug/debug.java
echo "Compiling main.."
javac Game.java