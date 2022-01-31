import java.time.LocalDate

data class Transaction(val transactionType: TransactionType, val amount: Int, val date: LocalDate, val balance: Int)