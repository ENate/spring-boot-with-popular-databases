FROM gitpod/workspace-full
# Install Redis.

RUN sudo apt-get update \
 && sudo apt-get install -y \
  redis-server \
 && sudo rm -rf /var/lib/apt/lists/*


RUN apt-get update && apt-get install -y \
        postgresql \
        postgresql-contrib \
        && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh &&  sdk install java 17.0.3-zulu && sdk use java 17.0.3-zulu"



FROM gitpod/workspace-mysql