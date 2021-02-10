package ps.exalt.training.serverpool.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAerospikeRepositories(basePackages = "ps.exalt.training.serverpool.repositories")
@ConfigurationProperties(prefix = "db")
public class AerospikeConfig {

    private String host;
    private int port;

    // region Getters and setters

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    // endregion

    @Bean
    public AerospikeTemplate aerospikeTemplate() {
        return new AerospikeTemplate(getClient(), "test");
    }

    @Bean
    public AerospikeClient getClient() {
        ClientPolicy cPolicy = new ClientPolicy();
        cPolicy.failIfNotConnected = true;

        return new AerospikeClient(cPolicy, host, port);
    }
}
