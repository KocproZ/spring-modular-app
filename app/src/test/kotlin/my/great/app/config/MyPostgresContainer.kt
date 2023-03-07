package my.great.app.config

import org.springframework.context.annotation.Configuration
import org.testcontainers.containers.PostgreSQLContainer

@Configuration
class MyPostgresContainer : PostgreSQLContainer<MyPostgresContainer>(IMAGE) {

    companion object {
        private const val IMAGE = "postgres:15"
        val instance by lazy { MyPostgresContainer() }
    }

    override fun start() {
        super.start()
        System.setProperty("DATASOURCE_URL", this.jdbcUrl)
        System.setProperty("DATASOURCE_USERNAME", this.username)
        System.setProperty("DATASOURCE_PASSWORD", this.password)
    }

}
