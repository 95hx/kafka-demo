//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.kafka.clients.admin;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.admin.KafkaAdminClient.TimeoutProcessorFactory;
import org.apache.kafka.common.TopicPartitionReplica;
import org.apache.kafka.common.acl.AclBinding;
import org.apache.kafka.common.acl.AclBindingFilter;
import org.apache.kafka.common.annotation.InterfaceStability.Evolving;
import org.apache.kafka.common.config.ConfigResource;

@Evolving
public abstract class AdminClient implements AutoCloseable {
    public AdminClient() {
    }

    public static AdminClient create(Properties props) {
        return KafkaAdminClient.createInternal(new AdminClientConfig(props), (TimeoutProcessorFactory)null);
    }

    public static AdminClient create(Map<String, Object> conf) {
        return KafkaAdminClient.createInternal(new AdminClientConfig(conf), (TimeoutProcessorFactory)null);
    }

    public void close() {
        this.close(9223372036854775807L, TimeUnit.MILLISECONDS);
    }

    public abstract void close(long var1, TimeUnit var3);

    public CreateTopicsResult createTopics(Collection<NewTopic> newTopics) {
        return this.createTopics(newTopics, new CreateTopicsOptions());
    }

    public abstract CreateTopicsResult createTopics(Collection<NewTopic> var1, CreateTopicsOptions var2);

    public DeleteTopicsResult deleteTopics(Collection<String> topics) {
        return this.deleteTopics(topics, new DeleteTopicsOptions());
    }

    public abstract DeleteTopicsResult deleteTopics(Collection<String> var1, DeleteTopicsOptions var2);

    public ListTopicsResult listTopics() {
        return this.listTopics(new ListTopicsOptions());
    }

    public abstract ListTopicsResult listTopics(ListTopicsOptions var1);

    public DescribeTopicsResult describeTopics(Collection<String> topicNames) {
        return this.describeTopics(topicNames, new DescribeTopicsOptions());
    }

    public abstract DescribeTopicsResult describeTopics(Collection<String> var1, DescribeTopicsOptions var2);

    public DescribeClusterResult describeCluster() {
        return this.describeCluster(new DescribeClusterOptions());
    }

    public abstract DescribeClusterResult describeCluster(DescribeClusterOptions var1);

    public DescribeAclsResult describeAcls(AclBindingFilter filter) {
        return this.describeAcls(filter, new DescribeAclsOptions());
    }

    public abstract DescribeAclsResult describeAcls(AclBindingFilter var1, DescribeAclsOptions var2);

    public CreateAclsResult createAcls(Collection<AclBinding> acls) {
        return this.createAcls(acls, new CreateAclsOptions());
    }

    public abstract CreateAclsResult createAcls(Collection<AclBinding> var1, CreateAclsOptions var2);

    public DeleteAclsResult deleteAcls(Collection<AclBindingFilter> filters) {
        return this.deleteAcls(filters, new DeleteAclsOptions());
    }

    public abstract DeleteAclsResult deleteAcls(Collection<AclBindingFilter> var1, DeleteAclsOptions var2);

    public DescribeConfigsResult describeConfigs(Collection<ConfigResource> resources) {
        return this.describeConfigs(resources, new DescribeConfigsOptions());
    }

    public abstract DescribeConfigsResult describeConfigs(Collection<ConfigResource> var1, DescribeConfigsOptions var2);

    public AlterConfigsResult alterConfigs(Map<ConfigResource, Config> configs) {
        return this.alterConfigs(configs, new AlterConfigsOptions());
    }

    public abstract AlterConfigsResult alterConfigs(Map<ConfigResource, Config> var1, AlterConfigsOptions var2);

    public AlterReplicaLogDirsResult alterReplicaLogDirs(Map<TopicPartitionReplica, String> replicaAssignment) {
        return this.alterReplicaLogDirs(replicaAssignment, new AlterReplicaLogDirsOptions());
    }

    public abstract AlterReplicaLogDirsResult alterReplicaLogDirs(Map<TopicPartitionReplica, String> var1, AlterReplicaLogDirsOptions var2);

    public DescribeLogDirsResult describeLogDirs(Collection<Integer> brokers) {
        return this.describeLogDirs(brokers, new DescribeLogDirsOptions());
    }

    public abstract DescribeLogDirsResult describeLogDirs(Collection<Integer> var1, DescribeLogDirsOptions var2);

    public DescribeReplicaLogDirsResult describeReplicaLogDirs(Collection<TopicPartitionReplica> replicas) {
        return this.describeReplicaLogDirs(replicas, new DescribeReplicaLogDirsOptions());
    }

    public abstract DescribeReplicaLogDirsResult describeReplicaLogDirs(Collection<TopicPartitionReplica> var1, DescribeReplicaLogDirsOptions var2);

    public CreatePartitionsResult createPartitions(Map<String, NewPartitions> newPartitions) {
        return this.createPartitions(newPartitions, new CreatePartitionsOptions());
    }

    public abstract CreatePartitionsResult createPartitions(Map<String, NewPartitions> var1, CreatePartitionsOptions var2);
}
