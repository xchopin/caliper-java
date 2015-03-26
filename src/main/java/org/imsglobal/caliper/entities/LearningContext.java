package org.imsglobal.caliper.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.imsglobal.caliper.entities.agent.SoftwareApplication;
import org.imsglobal.caliper.entities.foaf.Agent;
import org.imsglobal.caliper.entities.w3c.Organization;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonPropertyOrder({ "edApp", "group", "agent"})
public class LearningContext {

    @JsonProperty("edApp")
    private SoftwareApplication edApp;

    @JsonProperty("group")
    private Organization group;

    @JsonProperty("agent")
    private Agent agent;

    /**
     * @param builder apply builder object properties to the LearningContext object.
     */
    protected LearningContext(Builder<?> builder) {
        this.edApp = builder.edApp;
        this.group = builder.group;
        this.agent = builder.agent;
    }

    /**
     * @return the educational app.
     */
    @Nullable
    public SoftwareApplication getEdApp() {
        return edApp;
    }

    /**
     * @return organizational group.
     */
    @Nullable
    public Organization getGroup() {
        return group;
    }

    /**
     * @return the agent.
     */
    @Nonnull
    public Agent getAgent() {
        return agent;
    }

    /**
     * Builder class provides a fluid interface for setting object properties.
     * @param <T> builder
     */
    public static abstract class Builder<T extends Builder<T>> {
        private SoftwareApplication edApp;
        private Organization group;
        private Agent agent;

        protected abstract T self();

        /**
         * @param edApp
         * @return builder.
         */
        public T edApp(SoftwareApplication edApp) {
            this.edApp = edApp;
            return self();
        }

        /**
         * @param group
         * @return builder.
         */
        public T group(Organization group) {
            this.group = group;
            return self();
        }

        /**
         * @param agent
         * @return builder.
         */
        public T agent(Agent agent) {
            this.agent = agent;
            return self();
        }

        /**
         * Client invokes the build method in order to create an immutable LearningContext object.
         * @return the LearningContext.
         */
        public LearningContext build() {
            return new LearningContext(this);
        }
    }

    /**
     *
     */
    private static class Builder2 extends Builder<Builder2> {
        @Override
        protected Builder2 self() {
            return this;
        }
    }

    /**
     * Static factory method.
     * @return a new instance of the builder.
     */
    public static Builder<?> builder() {
        return new Builder2();
    }
}