object SerialEmitter { // Envia tramas para os diferentes módulos Serial Receiver.
    const val SELECT_LCD = 0x01
    const val SELECT_SCORE = 0x02
    var PARITY_BIT = 0

    enum class Destination {LCD, SCORE}
    // Inicia a classe
    fun init(){
        HAL.setBits(SELECT_LCD)
        HAL.setBits(SELECT_SCORE)
    }
    // Envia a trama para o módulo destino
    fun send(addr: Destination, data: Int, size : Int){
        var activeBits = 0

        when(addr) {
            Destination.LCD -> {
                HAL.setBits(SELECT_LCD)
                PARITY_BIT = 0x200
            }
            Destination.SCORE -> {
                HAL.setBits(SELECT_SCORE)
                PARITY_BIT = 0x40
            }
        }

        for (i in 0 until size) {
            val bit = (data shr i) and 1
            if (bit == 1) {
                HAL.setBits((1 shl size).inv())
                activeBits++
            } else {
                HAL.clrBits((1 shl size).inv())
            }
        }

        if (activeBits % 2 == 0) {
            HAL.clrBits(PARITY_BIT)
        } else {
            HAL.setBits(PARITY_BIT)
        }

        HAL.clrBits(SELECT_LCD)
        HAL.clrBits(SELECT_SCORE)
    }
}