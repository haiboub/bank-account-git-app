package net.youssfi.customer_service.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig {

    private int p1;
    private int p2;
}
