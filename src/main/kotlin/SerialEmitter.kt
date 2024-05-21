object SerialEmitter { // Envia tramas para os diferentes módulos Serial Receiver.
    enum class Destination {LCD, SCORE}
    // Inicia a classe
    fun init(){
        TODO()
    }
    // Envia a trama para o módulo destino
    fun send(addr: Destination, data: Int, size : Int){

        val mask = (1 shl size).inv()

        when(addr) {
            Destination.LCD -> {
                HAL.writeBits(data, mask)
            }
            Destination.SCORE -> {
                HAL.writeBits(mask, data)
            }
        }
    }
}