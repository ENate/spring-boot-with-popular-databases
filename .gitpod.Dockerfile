FROM gitpod/workspace-full
# Install Redis.
RUN sudo apt-get update \
 && sudo apt-get install -y \
  redis-server \
 && sudo rm -rf /var/lib/apt/lists/*



RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh &&  sdk install java 17.0.3-zulu && sdk use java 17.0.3-zulu"
