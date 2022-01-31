import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDate

class AccountTest {
    private val statement = mock(Statement::class.java)
    private val account = Account(statement)

    @Test
    fun `should do a deposit of 50 euros`() {
        account.deposit(50, LocalDate.now())

        assertThat(account.balance).isEqualTo(50)
    }

    @Test
    fun `should register a transaction when doing a deposit of 50 euros`() {
        val depositDate = LocalDate.of(2022, 1, 12)
        val expectedTransaction = Transaction(TransactionType.DEPOSIT, 50, depositDate)

        account.deposit(50, depositDate)

        verify(statement, times(1)).registerTransaction(expectedTransaction)
    }

    @Test
    fun `should do a withdrawal of 60 euros`() {
        account.balance = 100

        account.withdrawal(60, LocalDate.now())

        assertThat(account.balance).isEqualTo(40)
    }

    @Test
    fun `should register a transaction when doing a withdrawal of 60 euros`() {
        account.balance = 100
        val withdrawalDate = LocalDate.of(2022, 1, 12)
        val expectedTransaction = Transaction(TransactionType.WITHDRAWAL, 60, withdrawalDate)

        account.withdrawal(60, withdrawalDate)

        verify(statement, times(1)).registerTransaction(expectedTransaction)
    }
}