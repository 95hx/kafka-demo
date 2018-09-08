//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.kafka.clients.producer;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.ProducerFencedException;

public interface Producer<K, V> extends Closeable {
    void initTransactions();

    void beginTransaction() throws ProducerFencedException;

    void sendOffsetsToTransaction(Map<TopicPartition, OffsetAndMetadata> var1, String var2) throws ProducerFencedException;

    void commitTransaction() throws ProducerFencedException;

    void abortTransaction() throws ProducerFencedException;

    Future<RecordMetadata> send(ProducerRecord<K, V> var1);

    Future<RecordMetadata> send(ProducerRecord<K, V> var1, Callback var2);

    void flush();

    List<PartitionInfo> partitionsFor(String var1);

    Map<MetricName, ? extends Metric> metrics();

    void close();

    void close(long var1, TimeUnit var3);
}
