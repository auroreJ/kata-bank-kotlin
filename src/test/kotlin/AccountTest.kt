import com.google.common.collect.ImmutableList
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDate

class AccountTest {
    private val statement = mock(Statement::class.java)
    private val printer = mock(StatementConsolePrinter::class.java)
    private val account = Account(statement, printer)

    @Test
    fun `should do a deposit of 50 euros`() {
        account.deposit(50, LocalDate.now())

        assertThat(account.balance).isEqualTo(50)
    }

    @Test
    fun `should register a transaction when doing a deposit of 50 euros`() {
        val depositDate = LocalDate.of(2022, 1, 12)
        val expectedTransaction = Transaction(TransactionType.DEPOSIT, amount = 50, depositDate, balance = 50)

        account.deposit(50, depositDate)

        verify(statement, times(1)).registerTransaction(expectedTransaction)
    }

    @Test
    fun `should do a withdrawal of 60 euros`() {
        account.balance = 100

        account.withdraw(60, LocalDate.now())

        assertThat(account.balance).isEqualTo(40)
    }

    @Test
    fun `should register a transaction when doing a withdrawal of 60 euros`() {
        account.balance = 100
        val withdrawalDate = LocalDate.of(2022, 1, 12)
        val expectedTransaction = Transaction(TransactionType.WITHDRAWAL, amount = 60, withdrawalDate, balance = 40)

        account.withdraw(60, withdrawalDate)

        verify(statement, times(1)).registerTransaction(expectedTransaction)
    }

    @Test
    fun `should fail when balance become negative after the withdrawal`() {
        assertThatThrownBy { account.withdraw(60, LocalDate.of(2022, 1, 12)) }
            .hasMessage("Withdrawal not allowed")
    }

    @Test
    fun `print a statement`() {
        val transactions = listOf(
        Transaction(TransactionType.DEPOSIT, 40, LocalDate.of(2022, 1, 12), 40),
        Transaction(TransactionType.DEPOSIT, 100, LocalDate.of(2022, 1, 13), 140),
        Transaction(TransactionType.WITHDRAWAL, 120, LocalDate.of(2022, 1, 14), 20),
        Transaction(TransactionType.DEPOSIT, 10, LocalDate.of(2022, 1, 15), 30))
        val immutableTransactions = ImmutableList.copyOf(transactions)

        `when`(statement.getTansactions()).thenReturn(immutableTransactions)
        account.printStatement()

        verify(printer, times(1)).print(immutableTransactions)
    }
}