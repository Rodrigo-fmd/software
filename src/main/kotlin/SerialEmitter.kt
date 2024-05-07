object SerialEmitter { // Envia tramas para os diferentes módulos Serial Receiver.
    enum class Destination {LCD, SCORE}
    // Inicia a classe
    fun init(){
        TODO()
    }
    // Envia a trama para o módulo destino
    fun send(addr: Destination, data: Int, size : Int){
        when(addr) {
            Destination.LCD -> {
                val mask = 1 shl size
                mask.inv()
                HAL.writeBits(mask, data)

            }
            Destination.SCORE -> {
                // Handle the case when the destination is SCORE
            }
        }
    }
}