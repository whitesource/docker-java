package com.github.dockerjava.jaxrs;

import com.github.dockerjava.api.command.ExportContainerCmd;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.util.WrappedResponseInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

public class ExportContainerCmdExec extends AbstrSyncDockerCmdExec<ExportContainerCmd, InputStream> implements
        ExportContainerCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExportContainerCmdExec.class);

    private static final String WEB_TARGET_FORMAT = "/containers/{id}/export";

    public ExportContainerCmdExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected InputStream execute(ExportContainerCmd command) {
        WebTarget webTarget = getBaseResource().path(WEB_TARGET_FORMAT).resolveTemplate("id", command.getContainerId());

        LOGGER.trace("EXPORT: {}", webTarget);
        Response response = webTarget.request().accept(MediaType.APPLICATION_OCTET_STREAM).get();
        return new WrappedResponseInputStream(response);
    }

}
