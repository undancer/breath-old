package com.undancer.breath.samples.user.selectors;

import org.axonframework.eventhandling.SimpleCluster;

/**
 * Created by undancer on 14-1-6.
 */
public class UserCluster extends SimpleCluster {
    /**
     * Initializes the cluster with given <code>name</code>.
     *
     * @param name The name of this cluster
     */
    public UserCluster(String name) {
        super(name);
    }
}
