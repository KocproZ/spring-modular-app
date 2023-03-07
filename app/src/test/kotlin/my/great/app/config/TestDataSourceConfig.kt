package my.great.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class TestDataSourceConfig {

    @Bean
    fun dataSource(): DataSource  {
        val ds = DriverManagerDataSource()
        MyPostgresContainer.instance.start()
        ds.setDriverClassName(MyPostgresContainer.instance.driverClassName)
        ds.url = MyPostgresContainer.instance.jdbcUrl
        ds.username = MyPostgresContainer.instance.username
        ds.password = MyPostgresContainer.instance.password
        return ds
    }
}
