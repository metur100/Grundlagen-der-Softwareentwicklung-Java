#!/bin/bash

echo "PointTest..."
javac -cp .:junit-4.12.jar geometry/test/PointTest.java
echo "LineTest..."
javac -cp .:junit-4.12.jar geometry/test/LineTest.java
echo "TriangleTest..."
javac -cp .:junit-4.12.jar geometry/test/TriangleTest.java
