FROM mongo
WORKDIR /data/db

RUN apt-get update && apt-get install -y openssh-server
RUN mkdir /var/run/sshd
RUN echo 'root:fabricio123' | chpasswd
RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd


COPY ./alunos.json /data/db
COPY ./professores.json /data/db

VOLUME ["~/mongodb:/data/db"]

EXPOSE 27017:27017 22:22
CMD ["/usr/sbin/sshd", "-D"]





