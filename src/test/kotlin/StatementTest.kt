import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class StatementTest {
    private val statement = Statement()

    @Test
    fun `should register a transaction`() {
        val amount = 50
        val transactionDate = LocalDate.of(2022, 1, 12)
        val transaction = Transaction(TransactionType.DEPOSIT, amount, transactionDate)

        statement.registerTransaction(transaction)

        assertThat(statement.transactions.size).isEqualTo(1)
        val actualTransaction = statement.transactions.first()
        assertThat(actualTransaction.amount).isEqualTo(amount)
        assertThat(actualTransaction.transactionType).isEqualTo(TransactionType.DEPOSIT)
        assertThat(actualTransaction.date).isEqualTo(transactionDate)
    }

}