import com.google.common.collect.ImmutableList

class Statement {
    private var transactions: MutableList<Transaction> = mutableListOf()

    fun registerTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun getTansactions(): ImmutableList<Transaction> {
        return ImmutableList.copyOf(transactions)
    }
}