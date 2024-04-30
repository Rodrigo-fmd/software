import isel.leic.UsbPort

object KBD { // Ler teclas. Métodos retornam ‘0’..’9’,’#’,’*’ ou NONE.
    const val NONE = 0;
    const val DVAL_MASK = 0x10
    const val KEY_CODE_MASK = 0x0F


    // Inicia a classe
    fun init() = waitKey(10000)

    // Retorna de imediato a tecla premida ou NONE se não há tecla premida.
    fun getKey(): Char {
        return if (HAL.isBit(DVAL_MASK)) HAL.readBits(KEY_CODE_MASK).toChar()
        else NONE.toChar()
    }

    // Retorna a tecla premida, caso ocorra antes do ‘timeout’ (representado em milissegundos), ou
// NONE caso contrário.
    fun waitKey(timeout: Long): Char {
        val startTime = System.currentTimeMillis()
        var key: Char = NONE.toChar() // Inicialmente, nenhum botão foi pressionado

        while (System.currentTimeMillis() - startTime < timeout) {
            key = getKey() // Tenta obter a tecla pressionada
            if (key != NONE.toChar()) {
                // Se uma tecla foi pressionada, retorna imediatamente
                return key
            }
        }

        // Se nenhum botão foi pressionado dentro do tempo limite, retorna NONE
        return key
    }
}