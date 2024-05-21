object SerialEmitter { // Envia tramas para os diferentes módulos Serial Receiver.
    enum class Destination {LCD, SCORE}
    // Inicia a classe
    fun init(){
        SerialEmitter.send(SerialEmitter.Destination.SCORE, 0, 1)
        SerialEmitter.send(SerialEmitter.Destination.LCD, 0, 1)
    }
    // Envia a trama para o módulo destino
    fun send(addr: Destination, data: Int, size : Int){

        val mask = (1 shl size).inv()

        when(addr) {
            Destination.LCD -> {
                HAL.writeBits(mask, data)
            }
            Destination.SCORE -> {
                HAL.writeBits(mask, data)
            }
        }
    }
}