object LCD { // Escreve no LCD usando a interface a 8 bits.
    private const val LINES = 2
    private const val  COLS = 16 // Dimensão do display.
    private const val SERIAL_INTERFACE = false // Define se a interface é Série ou Paralela
    // Escreve um byte de comando/dados no LCD em paralelo
    private fun writeByteParallel(rs: Boolean, data: Int) {
        if(rs){
            HAL.setBits(data)
        }
    }
    // Escreve um byte de comando/dados no LCD em série
    private fun writeByteSerial(rs: Boolean, data: Int){
        if (!rs){
            HAL.setBits(data)
        }
    }
    // Escreve um byte de comando/dados no LCD
    private fun writeByte(rs: Boolean, data: Int){
        writeByteSerial(rs,data)
        writeByteParallel(rs,data)
    }
    // Escreve um comando no LCD
    private fun writeCMD(data: Int) {

    }
    // Escreve um dado no LCD
    private fun writeDATA(data: Int){

    }
    // Envia a sequência de iniciação para comunicação a 8 bits.
    fun init(){

    }
    // Escreve um caráter na posição corrente.
    fun write(c: Char){

    }
    // Escreve uma string na posição corrente.
    fun write(text: String){

    }
    // Envia comando para posicionar cursor (‘line’:0..LINES-1 , ‘column’:0..COLS-1)
    fun cursor(line: Int, column: Int){

    }
    // Envia comando para limpar o ecrã e posicionar o cursor em (0,0)
    fun clear(){

    }
}