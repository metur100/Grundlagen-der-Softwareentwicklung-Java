#!/bin/bash

echo "CaesarTest..."
java -cp ".:junit-4.12.jar:hamcrest-core-1.3.jar" org.junit.runner.JUnitCore caesar.test.CaesarTest
