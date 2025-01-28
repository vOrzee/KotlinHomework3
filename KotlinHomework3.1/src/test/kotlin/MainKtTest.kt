import org.junit.Test

import org.junit.Assert.*
 class MainKtTest {

    @Test
    fun calculateCommission_ToCardTypeVkpayMoreThanOnce() {
        val cardType = "VK Pay"
        val account = "Visa"
        val amountTransferPerMonth = 0
        val amountTransfer = 15001

        val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
        assertEquals(-1, result)
    }
     @Test
     fun calculateCommission_ToCardTypeVkpayMoreThanMonth() {
         val cardType = "VK Pay"
         val account = "Visa"
         val amountTransferPerMonth = 35000
         val amountTransfer = 10000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(-2, result)
     }

     @Test
     fun calculateCommission_ToCardTypeVkpay() {
         val cardType = "VK Pay"
         val account = "Visa"
         val amountTransferPerMonth = 10000
         val amountTransfer = 5000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(0, result)
     }

     @Test
     fun calculateCommission_ToAccountVkpay() {
         val cardType = "Mastercard"
         val account = "VK Pay"
         val amountTransferPerMonth = 10000
         val amountTransfer = 80000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(0, result)
     }

     @Test
     fun calculateCommission_MoreThanOnce() {
         val cardType = "Visa"
         val account = "Visa"
         val amountTransferPerMonth = 0
         val amountTransfer = 150001

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(-1, result)
     }

     @Test
     fun calculateCommission_MoreThanMonth() {
         val cardType = "Mir"
         val account = "Visa"
         val amountTransferPerMonth = 6923623
         val amountTransfer = 15

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(-2, result)
     }

     @Test
     fun calculateCommission_CardTypeMastercardAndMaestroLess300() {
         val cardType = "Mastercard"
         val account = "Мир"
         val amountTransferPerMonth = 10000
         val amountTransfer = 299

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(21, result)
     }

     @Test
     fun calculateCommission_CardTypeMastercardAndMaestroMonthMore75000() {
         val cardType = "Maestro"
         val account = "Мир"
         val amountTransferPerMonth = 75001
         val amountTransfer = 150000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(920, result)
     }

     @Test
     fun calculateCommission_CardTypeMastercardAndMaestroTransferMore75000() {
         val cardType = "Mastercard"
         val account = "Мир"
         val amountTransferPerMonth = 0
         val amountTransfer = 150000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(470, result)
     }

     @Test
     fun calculateCommission_CardTypeMastercardAndMaestroMonthAndTransferMore75000() {
         val cardType = "Maestro"
         val account = "Мир"
         val amountTransferPerMonth = 20000
         val amountTransfer = 150000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(590, result)
     }

     @Test
     fun CalculateCommission_CardTypeMastercardAndMaestro() {
         val cardType = "Mastercard"
         val account = "Мир"
         val amountTransferPerMonth = 10000
         val amountTransfer = 10000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(0, result)
     }

     @Test
     fun CalculateCommission_CardTypeVisaAndMir() {
         val cardType = "Visa"
         val account = "Мир"
         val amountTransferPerMonth = 100
         val amountTransfer = 100000

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(750, result)
     }

     @Test
     fun CalculateCommission_CardTypeVisaAndMirLess35() {
         val cardType = "Visa"
         val account = "Мир"
         val amountTransferPerMonth = 100
         val amountTransfer = 100

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(35, result)
     }

     @Test
     fun CalculateCommission_CardType() {
         val cardType = "QIWI"
         val account = "Мир"
         val amountTransferPerMonth = 100
         val amountTransfer = 100

         val result = calculateCommission(cardType, account, amountTransferPerMonth, amountTransfer)
         assertEquals(0, result)
     }
}