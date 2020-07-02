#!/bin/bash

javac caesar/Caesar.java

echo "CaesarTest..."
javac -cp ".:junit-4.12.jar:hamcrest-core-1.3.jar" caesar/test/CaesarTest.java

