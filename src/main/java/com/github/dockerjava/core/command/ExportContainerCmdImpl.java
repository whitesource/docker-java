package com.github.dockerjava.core.command;

import com.github.dockerjava.api.command.ExportContainerCmd;

import java.io.InputStream;

/**
 * Export a container.
 */
public class ExportContainerCmdImpl extends AbstrDockerCmd<ExportContainerCmd, InputStream> implements
        ExportContainerCmd {

    private String containerId;

    public ExportContainerCmdImpl(Exec exec, String containerId) {
        super(exec);
        this.containerId = containerId;
    }

    @Override
    public String getContainerId() {
        return containerId;
    }
}
