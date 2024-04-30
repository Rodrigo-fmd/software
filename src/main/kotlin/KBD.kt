object KBD {    // Ler teclas. Métodos retornam ‘0’..’9’,’#’,’*’ ou NONE.
    const val NONE = 0;
    const val D_VAL_MASK = 0x10
    const val KEY_CODE_MASK = 0xF

    // Inicia a classe
    fun init(){
            getKey()
    }

    // Retorna de imediato a tecla premida ou NONE se não há tecla premida.
    fun getKey(): Char {
        if(HAL.isBit(D_VAL_MASK)){
            return HAL.readBits(KEY_CODE_MASK).toChar()
        } else
            return NONE.toChar()
    }

    // Retorna a tecla premida, caso ocorra antes do ‘timeout’ (representado em milissegundos), ou NONE caso contrário.
    fun waitKey(timeout: Long): Char {
        
    }
}