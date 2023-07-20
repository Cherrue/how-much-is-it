#!/bin/bash

APP_NAME="app"
APP_PORT=10080
JAVA_OPTS="-Dserver.port=${APP_PORT} \
        -Xmx256g -Xms256m \
        -XX:+HeapDumpOnOutOfMemoryError \
        -XX:HeapDumpPath=/tmp/heapdump.hprof \
        -Dspring.profiles.active=alpha"

# kill existing process if exists
PID=$(ps -ef | grep ${APP_NAME} | grep -v grep | awk '{print $2}')
if [[ ! -z ${PID} ]]; then
  kill -15 ${PID}
fi

# start new process
nohup java ${JAVA_OPTS} -jar /home/ec2-user/deploy/${APP_NAME}.jar > /home/ec2-user/logs 2>&1 &
echo "${APP_NAME} started on port ${APP_PORT}"