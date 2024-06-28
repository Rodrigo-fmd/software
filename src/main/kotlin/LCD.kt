import isel.leic.UsbPort
import isel.leic.utils.*

object LCD { // Escreve no LCD usando a interface a 4 bits.
    private const val RS = 0x01
    private const val LINES = 2
    private const val COLS = 16; // Dimensão do display.
    private const val SERIAL_INTERFACE = false // Define se a interface é Série ou Paralela

    // Escreve um byte de comando/dados no LCD em paralelo
    private fun writeByteParallel(rs: Boolean, data: Int) {
        if (!rs) {
            HAL.clrBits(RS)
        } else HAL.setBits(RS)
        HAL.writeBits(0xFF,data)

    }

    // Escreve um byte de comando/dados no LCD em série
    private fun writeByteSerial(rs: Boolean, data: Int) {
        if (!rs) {
            HAL.clrBits(RS)
        } else HAL.setBits(RS)

        SerialEmitter.send(SerialEmitter.Destination.LCD, data, 8)
    }

    // Escreve um byte de comando/dados no LCD
    private fun writeByte(rs: Boolean, data: Int) {
        if (!rs) writeByteParallel(false, data)
        else writeByteSerial(true, data)
    }

    // Escreve um comando no LCD
    private fun writeCMD(data: Int) {
        writeByteParallel(false, data)
    }

    // Escreve um dado no LCD
    private fun writeDATA(data: Int) {
        if (SERIAL_INTERFACE) {
            writeByteParallel(true, data)
        } else writeByteSerial(true, data)
    }

    // Envia a sequência de iniciação para comunicação a 4 bits.
    fun init() {
        // Inicialização do LCD

        // Sequência de inicialização para comunicação a 4 bits
        writeCMD(0x33)
        writeCMD(0x32)
        clear() // Limpa o display e posiciona o cursor no início
    }

    // Escreve um caráter na posição corrente.
    fun write(c: Char) = writeDATA(c.code)

    // Escreve uma string na posição corrente.
    fun write(text: String) {
        for (c in text) {
            write(c)
        }
    }

    // Envia comando para posicionar cursor (‘line’:0..LINES-1 , ‘column’:0..COLS-1)
    fun cursor(line: Int, column: Int) {
        val pos = if (line == 0) column else column + 0x40
        writeCMD(pos)
    }

    // Envia comando para limpar o ecrã e posicionar o cursor em (0,0)
    fun clear() = writeCMD(0x01)


}