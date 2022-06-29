FROM openjdk:17 as builder
COPY src/ /src/
RUN javac /src/com/deadlock/Util.java /src/com/deadlock/ThreadDeadLock.java /src/Main.java -d /app

FROM openjdk:17
COPY --from=builder /app /app
WORKDIR /app
CMD ["java", "Main"]