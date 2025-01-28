fun main(){

}

fun calculateCommission(cardType: String, account: String, amountTransferPerMonth: Int, amountTransfer: Int): Int {

    when(cardType){
        "VK Pay" -> when{
            amountTransfer > 15000 -> return -1
            amountTransferPerMonth + amountTransfer > 40000 -> return -2
            else -> return cardToCommisions(cardType, account, amountTransferPerMonth, amountTransfer)
        }
        else -> when{
            amountTransfer > 150000 -> return -1
            amountTransferPerMonth + amountTransfer > 600_000 -> return -2
            else ->  return cardToCommisions(cardType, account, amountTransferPerMonth, amountTransfer)
        }
    }
}

fun cardToCommisions(cardType: String, account: String, amountTransferPerMonth: Int, amountTransfer: Int): Int{
    when(account) {
        "VK Pay" -> return 0
        else -> when (cardType) {
                    "Mastercard", "Maestro" -> when {
                        amountTransfer < 300 -> return (amountTransfer * 0.006 + 20).toInt()
                        amountTransferPerMonth > 75000 -> return (amountTransfer * 0.006 + 20).toInt()
                        amountTransferPerMonth + amountTransfer > 75000 -> return ((amountTransferPerMonth + amountTransfer - 75000) * 0.006 + 20).toInt()
                        else -> return 0
                    }
                    "Visa", "Мир" -> if (amountTransfer * 0.0075 > 35) return (amountTransfer * 0.0075).toInt() else return 35
                    else -> return 0
                    }
    }
}