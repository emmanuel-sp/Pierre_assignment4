#! /usr/bin/bash -ex

javac -d bin src/esp/controller/Sorting.java
javac -cp bin -d bin src/esp/SortDriver.java
java -cp bin esp.SortDriver
