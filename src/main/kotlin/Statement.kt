class Statement {
    var transactions: MutableList<Transaction> = mutableListOf()

    fun registerTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

}