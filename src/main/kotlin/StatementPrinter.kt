import com.google.common.collect.ImmutableList

interface StatementPrinter {
    fun print(transactions: ImmutableList<Transaction>)
}
