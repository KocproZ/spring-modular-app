package my.great.app.config

import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfiguration(
    private val dataSource: DataSource,
    @Value("\${spring.jpa.show-sql}") private val showSql: Boolean
) {

    @Bean
    fun database(): Database = Database.connect(
        dataSource = dataSource,
        alwaysQuoteIdentifiers = true,
        logger = ConsoleLogger(
            threshold = if (showSql) LogLevel.DEBUG else LogLevel.INFO
        )
    )

}
