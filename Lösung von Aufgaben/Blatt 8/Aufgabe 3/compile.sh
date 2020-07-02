#!/bin/bash

javac caesar/Caesar.java

echo "CaesarTest..."
javac -cp ".:junit-4.12.jar" caesar/test/CaesarTest.java

