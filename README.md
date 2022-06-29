This app generates deadlock. And will be used by monitordeadlock to send slack notification when a deadlock happens

commands to use: 

jstack -l > ../detectdeadlockissue/thread-dump.txt 

jps

run docker:

docker build . -t deadlockapp

docker run -it --rm --name deadlockapp deadlockapp
