package com.github.dockerjava.api.command;

import javax.annotation.CheckForNull;
import java.io.InputStream;

/**
 * Export a container.
 */
public interface ExportContainerCmd extends SyncDockerCmd<InputStream> {

    @CheckForNull
    public String getContainerId();

    public static interface Exec extends DockerCmdSyncExec<ExportContainerCmd, InputStream> {
    }

}
