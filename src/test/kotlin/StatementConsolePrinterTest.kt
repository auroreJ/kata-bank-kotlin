import com.google.common.collect.ImmutableList
import org.junit.jupiter.api.Test
import java.time.LocalDate
class StatementConsolePrinterTest {

    @Test
    fun `should print all account's transactions in the console`() {
        val printer = StatementConsolePrinter()
        val transactions = listOf(
            Transaction(TransactionType.DEPOSIT, 40, LocalDate.of(2022, 1, 12), 40),
            Transaction(TransactionType.DEPOSIT, 100, LocalDate.of(2022, 1, 13), 140),
            Transaction(TransactionType.WITHDRAWAL, 120, LocalDate.of(2022, 1, 14), 20),
            Transaction(TransactionType.DEPOSIT, 10, LocalDate.of(2022, 1, 15), 30))
        val immutableTransactions = ImmutableList.copyOf(transactions)

        printer.print(immutableTransactions)
    }
}