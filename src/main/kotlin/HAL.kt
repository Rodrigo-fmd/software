
import isel.leic.UsbPort

object HAL { // Virtualiza o acesso ao sistema UsbPort

    private var output = 0

    // Inicia a classe
    fun init() = UsbPort.write(output)

    // Retorna true se o bit tiver o valor lógico ‘1’
    fun isBit(mask: Int): Boolean = mask.and(UsbPort.read()) == mask

    // Retorna os valores dos bits representados por mask presentes no UsbPort
    fun readBits(mask: Int): Int = mask.and(UsbPort.read())

    // Escreve nos bits representados por mask os valores dos bits correspondentes em value
    fun writeBits(mask: Int, value: Int) {
        output = value
        setBits(mask)
        clrBits(mask)
    }

    // Coloca os bits representados por mask no valor lógico ‘1’
    fun setBits(mask: Int) {
        output = mask.and(output)
        UsbPort.write(output)
    }

    // Coloca os bits representados por mask no valor lógico ‘0’
    fun clrBits(mask: Int) {
        output = (mask.inv()).and(output)
        UsbPort.write(output)
    }
}