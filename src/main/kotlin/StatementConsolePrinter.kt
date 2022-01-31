import com.google.common.collect.ImmutableList
import java.time.format.DateTimeFormatter

class StatementConsolePrinter: StatementPrinter {
    private val header = "Date | Debit | Credit | Balance"

    override fun print(transactions: ImmutableList<Transaction>) {
        println(header)
        transactions.forEach {
            val dataToPrint = formatDataToPrint(it)
            println(dataToPrint)
        }

    }

    private fun formatDataToPrint(transaction: Transaction): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        val formattedDate = formatter.format(transaction.date)
        val credit =
            if (transaction.transactionType == TransactionType.DEPOSIT) transaction.amount.toString() else ""
        val debit =
            if (transaction.transactionType == TransactionType.WITHDRAWAL) transaction.amount.toString() else ""
        return "$formattedDate | $debit | $credit | ${transaction.balance}"
    }
}