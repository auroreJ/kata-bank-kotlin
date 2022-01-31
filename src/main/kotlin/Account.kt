import java.time.LocalDate

class Account(private val statement: Statement, private val statementPrinter: StatementPrinter, var balance: Int = 0) {

    fun deposit(amount: Int, date: LocalDate) {
        balance += amount
        val transaction = Transaction(TransactionType.DEPOSIT, amount, date, balance)
        statement.registerTransaction(transaction)
    }

    fun withdraw(amount: Int, date: LocalDate) {
        balance -= amount
        val transaction = Transaction(TransactionType.WITHDRAWAL, amount, date, balance)
        statement.registerTransaction(transaction)
    }

    fun printStatement() {
        statementPrinter.print(statement.getTansactions())
    }
}
