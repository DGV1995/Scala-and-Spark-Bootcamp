#!/bin/bash
JAVA_HOME="$(/usr/libexec/java_home --version 1.8)" exec "/usr/local/Cellar/apache-spark/2.4.3/libexec/bin/load-spark-env.sh" "$@"
