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
                // Convert the data to a binary string
                val binaryString = data.toString(2).padStart(size, '0')
                // Send each bit to the LCD module
                LCD.write(binaryString)

            }
            Destination.SCORE -> {
                // Handle the case when the destination is SCORE
                // This will depend on how your SCORE module is set up
            }
        }
    }
}