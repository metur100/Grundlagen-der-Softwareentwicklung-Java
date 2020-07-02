#!/bin/bash

echo "PointTest..."
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore geometry.test.PointTest
echo "LineTest..."
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore geometry.test.LineTest
echo "TriangleTest..."
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore geometry.test.TriangleTest
