FROM ghcr.io/cyclonedx/bci-java:master

LABEL maintainer="CycloneDX" \
      org.opencontainers.image.authors="Team AppThreat <cloud@appthreat.com>" \
      org.opencontainers.image.source="https://github.com/CycloneDX/cdxgen" \
      org.opencontainers.image.url="https://github.com/CycloneDX/cdxgen" \
      org.opencontainers.image.version="rolling" \
      org.opencontainers.image.vendor="AppThreat" \
      org.opencontainers.image.licenses="Apache-2.0" \
      org.opencontainers.image.title="cdxgen" \
      org.opencontainers.image.description="Rolling image with cdxgen SBOM generator for Java 11 and android apps" \
      org.opencontainers.docker.cmd="docker run --rm -v /tmp:/tmp -p 9090:9090 -v $(pwd):/app:rw -t ghcr.io/cyclonedx/cdxgen-java:v11 -r /app --server"

ENV CDXGEN_IN_CONTAINER=true

RUN npm install -g @cyclonedx/cdxgen --omit=dev

ENTRYPOINT ["cdxgen"]
