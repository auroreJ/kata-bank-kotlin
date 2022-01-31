import java.time.LocalDate

class Account(private val statement: Statement, var balance: Int = 0) {

    fun deposit(amount: Int, date: LocalDate) {
        balance += amount
        val transaction = Transaction(TransactionType.DEPOSIT, amount, date)
        statement.registerTransaction(transaction)
    }
}
