import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class StatementTest {
    private val statement = Statement()

    @Test
    fun `should register a transaction`() {
        val amount = 50
        val transactionDate = LocalDate.of(2022, 1, 12)
        val transaction = Transaction(TransactionType.DEPOSIT, amount, transactionDate, balance = 50)

        statement.registerTransaction(transaction)

        assertThat(statement.getTansactions().size).isEqualTo(1)
        val actualTransaction = statement.getTansactions().first()
        assertThat(actualTransaction.amount).isEqualTo(amount)
        assertThat(actualTransaction.transactionType).isEqualTo(TransactionType.DEPOSIT)
        assertThat(actualTransaction.date).isEqualTo(transactionDate)
    }

}